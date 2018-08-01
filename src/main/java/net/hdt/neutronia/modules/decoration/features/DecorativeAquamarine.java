package net.hdt.neutronia.modules.decoration.features;

import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.blocks.overworld.BlockOverworldBase;
import net.hdt.neutronia.modules.building.features.VanillaStairsAndSlabs;
import net.hdt.neutronia.properties.EnumAquamarineVariants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static net.hdt.neutronia.init.NCreativeTabs.OCEAN_EXPANSION_TAB;

public class DecorativeAquamarine extends Feature {

    private static final Block[] decorativeAquamarine = new Block[6];

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        for(EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
            decorativeAquamarine[aquamarineVariants.getID()] = new BlockOverworldBase(Material.ROCK, aquamarineVariants.getName(), false).setCreativeTab(OCEAN_EXPANSION_TAB);
            VanillaStairsAndSlabs.add(aquamarineVariants.getName(), decorativeAquamarine[aquamarineVariants.getID()], 0, true);
        }
    }

}