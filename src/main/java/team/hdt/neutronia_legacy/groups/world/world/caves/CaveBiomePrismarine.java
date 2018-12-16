package team.hdt.neutronia_legacy.groups.world.world.caves;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.hdt.neutronia_legacy.base.groups.GroupLoader;

public class CaveBiomePrismarine extends BasicCaveBiome {

    int seaLanternChance, waterChance;

    public CaveBiomePrismarine() {
        super(Blocks.PRISMARINE.getDefaultState(), Blocks.PRISMARINE.getDefaultState(), Blocks.PRISMARINE.getDefaultState());
    }

    @Override
    public void fillWall(World world, BlockPos pos, IBlockState state) {
        super.fillWall(world, pos, state);

        if (seaLanternChance > 0 && world.rand.nextInt(seaLanternChance) == 0)
            world.setBlockState(pos, Blocks.SEA_LANTERN.getDefaultState(), 2);
    }

    @Override
    public void fillFloor(World world, BlockPos pos, IBlockState state) {
        if (waterChance > 0 && !isBorder(world, pos, state) && world.rand.nextInt(waterChance) == 0)
            world.setBlockState(pos, Blocks.WATER.getDefaultState());
        else super.fillFloor(world, pos, state);
    }

    @Override
    public void setupConfig(String category) {
        seaLanternChance = GroupLoader.config.getInt("Sea Lantern Chance", category, 120, 0, Integer.MAX_VALUE, "The higher, the less sea lanterns will spawn");
        waterChance = GroupLoader.config.getInt("Water Chance", category, 4, 0, Integer.MAX_VALUE, "The higher, the less water will spawn");
    }


}