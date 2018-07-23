package net.hdt.neutronia.modules.building.features;

import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.blocks.overworld.BlockOverworldWoodBase;
import net.hdt.neutronia.init.NItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static net.hdt.neutronia.init.NCreativeTabs.WOOD_EXPANSION_TAB;

public class WoodBlocks extends Feature {

    private static final Block[] barkBlocks = new Block[6], chiseledBarkBlocks = new Block[6], strippedBarkBlocks = new Block[6], unnamedChiseledBarkBlock = new Block[6], barkButtons = new Block[6],
            barkPressurePlates = new Block[6];

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        for (BlockPlanks.EnumType enumType : BlockPlanks.EnumType.values()) {
//            potterySpinner[enumType.getMetadata()] = new BlockPotteryClayMachine(enumType.getMetadata(), String.format("%s_pottery_clay_machine", enumType.getName()), false).setCreativeTab(WOOD_EXPANSION_TAB);
//            potterySpinnerActive[enumType.getMetadata()] = new BlockPotteryClayMachine(enumType.getMetadata(), String.format("%s_pottery_clay_machine_active", enumType.getName()), true).setCreativeTab(null);
            barkBlocks[enumType.getMetadata()] = new BlockOverworldWoodBase(Material.WOOD, String.format("%s_wood", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            VanillaStairsAndSlabs.add(String.format("%s_wood", enumType.getName()), barkBlocks[enumType.getMetadata()], 0, true, true, true);
            VanillaWalls.add(String.format("%s_wood", enumType.getName()), barkBlocks[enumType.getMetadata()], 0, true);
//            addFenceAndFenceGate(enumType, String.format("%s_wood", enumType.getName()), barkBlocks[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//            addFenceAndFenceGate(enumType, String.format("stripped_%s_wood", enumType.getName()), strippedBarkBlocks[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//            addFenceAndFenceGate(enumType, String.format("stripped_%s_log", enumType.getName()), strippedLogs[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
            chiseledBarkBlocks[enumType.getMetadata()] = new BlockOverworldWoodBase(Material.WOOD, String.format("%s_wood_chiseled", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            unnamedChiseledBarkBlock[enumType.getMetadata()] = new BlockOverworldWoodBase(Material.WOOD, String.format("unnamed_%s_wood_chiseled", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            strippedBarkBlocks[enumType.getMetadata()] = new BlockOverworldWoodBase(Material.WOOD, String.format("stripped_%s_wood", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            VanillaStairsAndSlabs.add(String.format("stripped_%s_wood", enumType.getName()), strippedBarkBlocks[enumType.getMetadata()], 0, true, true, true);
            VanillaWalls.add(String.format("stripped_%s_wood", enumType.getName()), strippedBarkBlocks[enumType.getMetadata()], 0, true);
//            logDowels[enumType.getMetadata()] = new BlockRodBase(String.format("%s_log_dowel", enumType.getName()), WOOD_EXPANSION_TAB, false);
//            strippedLogDowels[enumType.getMetadata()] = new BlockRodBase(String.format("stripped_%s_log_dowel", enumType.getName()), WOOD_EXPANSION_TAB, false);
//            plankDowels[enumType.getMetadata()] = new BlockRodBase(String.format("%s_plank_dowel", enumType.getName()), WOOD_EXPANSION_TAB, false);
//            coffins[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, enumType.getName() + "_coffin", true).setCreativeTab(WOOD_EXPANSION_TAB);
            RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(strippedBarkBlocks[enumType.getMetadata()], 1), ProxyRegistry.newStack(barkBlocks[enumType.getMetadata()], 1), NItems.logStripper);
            RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(chiseledBarkBlocks[enumType.getMetadata()], 1), ProxyRegistry.newStack(barkBlocks[enumType.getMetadata()], 1), NItems.chisel);
        }
    }

}
