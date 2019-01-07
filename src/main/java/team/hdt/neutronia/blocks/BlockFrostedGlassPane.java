package team.hdt.neutronia.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import team.hdt.neutronia.base.blocks.BlockNeutroniaPane;

public class BlockFrostedGlassPane extends BlockNeutroniaPane {

    public BlockFrostedGlassPane() {
        super("frosted_glass_pane", Material.GLASS);
        setHardness(3.0F);
        setResistance(10.0F);
        setSoundType(SoundType.GLASS);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return super.canPaneConnectTo(world, pos, dir) || world.getBlockState(pos.offset(dir)).getBlock() instanceof BlockFrostedGlass;
    }

}