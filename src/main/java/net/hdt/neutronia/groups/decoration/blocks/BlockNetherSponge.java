package net.hdt.neutronia.groups.decoration.blocks;

import com.google.common.collect.Lists;
import net.hdt.neutronia.base.blocks.BlockNeutroniaBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;

public class BlockNetherSponge extends BlockNeutroniaBase {

    private static final PropertyBool WET = PropertyBool.create("wet");

    public BlockNetherSponge() {
        super(Material.SPONGE, "nether_sponge");
        this.setDefaultState(this.blockState.getBaseState().withProperty(WET, Boolean.FALSE));
        setCreativeTab(WET.equals(false) ? CreativeTabs.BUILDING_BLOCKS : CreativeTabs.SEARCH);
    }

    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(this.getTranslationKey() + "_dry.name");
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state) {
        return state.getValue(WET) ? 1 : 0;
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        this.tryAbsorb(worldIn, pos, state);
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        this.tryAbsorb(worldIn, pos, state);
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
    }

    private void tryAbsorb(World worldIn, BlockPos pos, IBlockState state) {
        if (!state.getValue(WET) && this.absorb(worldIn, pos)) {
            worldIn.setBlockState(pos, state.withProperty(WET, Boolean.TRUE), 2);
            worldIn.playEvent(2001, pos, Block.getIdFromBlock(Blocks.LAVA));
        }
    }

    private boolean absorb(World worldIn, BlockPos pos) {
        Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
        List<BlockPos> list = Lists.newArrayList();
        queue.add(new Tuple<>(pos, 0));
        int i = 0;

        while (!queue.isEmpty()) {
            Tuple<BlockPos, Integer> tuple = queue.poll();
            BlockPos blockpos = Objects.requireNonNull(tuple).getFirst();
            int j = tuple.getSecond();

            for (EnumFacing enumfacing : EnumFacing.values()) {
                BlockPos blockpos1 = blockpos.offset(enumfacing);

                if (worldIn.getBlockState(blockpos1).getMaterial() == Material.LAVA) {
                    worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 2);
                    list.add(blockpos1);
                    ++i;

                    if (j < 6) {
                        queue.add(new Tuple<>(blockpos1, j + 1));
                    }
                }
            }

            if (i > 64) {
                break;
            }
        }

        for (BlockPos blockpos2 : list) {
            worldIn.notifyNeighborsOfStateChange(blockpos2, Blocks.AIR, false);
        }

        return i > 0;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, 0));
        items.add(new ItemStack(this, 1, 1));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(WET, (meta & 1) == 1);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        return state.getValue(WET) ? 1 : 0;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, WET);
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
     * this method is unrelated to {{@link #needsRandomTick}, and will always be called regardless
     * of whether the block can receive random update ticks
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.getValue(WET)) {
            EnumFacing enumfacing = EnumFacing.random(rand);

            if (enumfacing != EnumFacing.UP && !worldIn.getBlockState(pos.offset(enumfacing)).isTopSolid()) {
                double d0 = (double) pos.getX();
                double d1 = (double) pos.getY();
                double d2 = (double) pos.getZ();

                if (enumfacing == EnumFacing.DOWN) {
                    d1 = d1 - 0.05D;
                    d0 += rand.nextDouble();
                    d2 += rand.nextDouble();
                } else {
                    d1 = d1 + rand.nextDouble() * 0.8D;

                    if (enumfacing.getAxis() == EnumFacing.Axis.X) {
                        d2 += rand.nextDouble();

                        if (enumfacing == EnumFacing.EAST) {
                            ++d0;
                        } else {
                            d0 += 0.05D;
                        }
                    } else {
                        d0 += rand.nextDouble();

                        if (enumfacing == EnumFacing.SOUTH) {
                            ++d2;
                        } else {
                            d2 += 0.05D;
                        }
                    }
                }

                worldIn.spawnParticle(EnumParticleTypes.DRIP_LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}