/*
package team.hdt.neutronia.groups.world.features.overworld;

import BlockNeutroniaButton;
import Reference;
import team.hdt.neutronia.groups.decoration.blocks.*;
import team.hdt.neutronia.groups.world.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.ResourceLocation;

public class Temporary {

    public static Block coconut;

    public static Block fallenleaves_oak, fallenleaves_birch, fallenleaves_spruce, fallenleaves_jungle, fallenleaves_darkoak,
            fallenleaves_acacia, fallenleaves_dead;

    //1.13: allow waterlogged
    public static Block stone_rocks, cobblestone_rocks, mossy_cobblestone_rocks, andesite_rocks, granite_rocks, diorite_rocks, sandstone_rocks,
            red_sandstone_rocks;

    public static Block oak_twigs, birch_twigs, spruce_twigs, jungle_twigs, acacia_twigs, dark_oak_twigs;
    public static Block bones;
    public static Block seashells;
    public static Block pinecones;

    public static Block cracked_sand, red_cracked_sand;
    public static Block wet_adobe;
    public static Block mud;

    public static Block short_grass;
    public static Block wild_wheat, wild_potato, wild_carrot, wild_beetroot;
    public static Block frost_lotus;
    public static Block silverleaf;
    public static Block frogbit, duckweed;
    public static Block chickweed, clovers, crabgrass;
    public static Block small_cactus;
    public static Block bracket_fungus;
    public static Block waxcap, orange_mushroom, deathcap;
    public static Block cattail;

    public static Block bloodnettle;
    public static Block glowcap;

    public static Block rock_formation, ice_formation;

    public static Block aquamarine_ore;
    public static Block aquamarine_block;

    public static Block mystical_grill;

    public static Block cobblestone_chimney, stone_chimney, brick_chimney, stonebrick_chimney, cobblestone_brick_chimney,
            sandstone_chimney, netherbrick_chimney;

    public static Block cobblestone_chimney_top, stone_chimney_top, brick_chimney_top, stonebrick_chimney_top, cobblestone_brick_chimney_top,
            sandstone_chimney_top, netherbrick_chimney_top;

    public static Block cobblestone_brick_wall;

    public static Block campfire;
    public static Block candle;
    public static Block glowstone_lamp_wood, glowstone_lamp_stone, glowstone_lamp_iron;
    public static Block lantern;
    public static Block lantern_candle;
    public static Block lava_lamp;
    public static Block paper_lantern;
    public static Block lightbulb;
    public static Block ceiling_lamp;
    public static Block circuit_breaker;

    public static Block redwood_bark;

    public static void initBlocks()
    {
        short_grass = registerBlock(new BlockShortGrass(), "short_grass");
        frost_lotus = registerBlock(new BlockPVJPlant("frost_lotus"), "frost_lotus");
        silverleaf = registerBlock(new BlockPVJPlant("silver_leaf"), "silver_leaf");
        chickweed = registerBlock(new BlockWeed(), "chickweed");
        clovers = registerBlock(new BlockWeed(), "clovers");
        crabgrass = registerBlock(new BlockWeed(), "crabgrass");
        bracket_fungus = new BlockBracketFungus();
        registerBlockWithItem(bracket_fungus, "bracket_fungus", new ItemBracketFungus(bracket_fungus));
        frogbit = new BlockFloatingPlant();
        registerBlockWithItem(frogbit, "frogbit", new ItemFloatingPlant(frogbit));
        duckweed = new BlockFloatingPlant();
        registerBlockWithItem(duckweed, "duckweed", new ItemFloatingPlant(duckweed));
        waxcap = registerBlock(new BlockPVJMushroom(), "waxcap");
        orange_mushroom = registerBlock(new BlockPVJMushroom(), "orange_mushroom");
        deathcap = registerBlock(new BlockPVJMushroom(), "deathcap");
        cattail = registerBlock(new BlockCattail(), "cattail");
        small_cactus = registerBlock(new BlockPVJCactus(), "small_cactus");

        wild_wheat = registerBlock(new BlockWildCrop(Items.WHEAT), "wild_wheat");
        wild_potato = registerBlock(new BlockWildCrop(Items.POTATO), "wild_potato");
        wild_carrot = registerBlock(new BlockWildCrop(Items.CARROT), "wild_carrot");
        wild_beetroot = registerBlock(new BlockWildCrop(Items.BEETROOT), "wild_beetroot");

        bloodnettle = registerBlock(new BlockNetherPlant(), "bloodnettle");
        glowcap = registerBlock(new BlockGlowcap(), "glowcap");

        //separate loops to keep the creative inventory neat
        for(EnumWoodType woodType : EnumWoodType.values())
            LOGS.add(registerBlock(new BlockPVJLog(), "log_" + woodType.getName()));

        for(EnumLeafType leafType : EnumLeafType.values())
            LEAVES.add(registerBlock(new BlockPVJLeaves(leafType), "leaves_" + leafType.getName()));

        for(EnumLeafType leafType : EnumLeafType.values())
            SAPLINGS.add(registerBlock(new BlockPVJSapling(leafType), "sapling_" + leafType.getName()));

        for(EnumWoodType woodType : EnumWoodType.values())
            PLANKS.add(registerBlock(new BlockPVJPlanks(), "planks_" + woodType.getName()));

        for(EnumWoodType woodType : EnumWoodType.values())
            STAIRS.add(registerBlock(new BlockPVJStairs(PLANKS.get(woodType.getID()).getDefaultState()), woodType.getName() + "_stairs"));

        for(EnumWoodType woodType : EnumWoodType.values())
        {
            BlockPVJHalfSlab slab1 = new BlockPVJHalfSlab(PLANKS.get(woodType.getID()).getDefaultState());
            BlockPVJDoubleSlab slab2 = new BlockPVJDoubleSlab(PLANKS.get(woodType.getID()).getDefaultState(), slab1);

            registerSlab(slab1, slab2, woodType.getName()+ "_slab", woodType.getName() + "_double_slab");

            SLABS.add(slab1);
        }

        for(EnumWoodType woodType : EnumWoodType.values())
            FENCES.add(registerBlock(new BlockPVJFence(), woodType.getName() + "_fence"));

        for(EnumWoodType woodType : EnumWoodType.values())
            FENCE_GATES.add(registerBlock(new BlockPVJFenceGate(), woodType.getName() + "_fence_gate"));

        for(EnumWoodType woodType : EnumWoodType.values())
            DOORS.add(registerDoor(new BlockPVJDoor(), woodType.getName() + "_door"));

        for(EnumWoodType woodType : EnumWoodType.values())
            TRAPDOORS.add(registerBlock(new BlockPVJTrapdoor(), woodType.getName() + "_trapdoor"));

        for(EnumWoodType woodType : EnumWoodType.values())
            BUTTONS.add(registerBlock(new BlockNeutroniaButton(woodType.getName() + "_button"), woodType.getName() + "_button"));

        for(EnumWoodType woodType : EnumWoodType.values())
            PRESSURE_PLATES.add(registerBlock(new BlockPVJPressurePlate(), woodType.getName() + "_pressure_plate"));

        fallenleaves_oak = registerBlock(new BlockFallenLeaves(), "fallen_leaves_oak");
        fallenleaves_birch = registerBlock(new BlockFallenLeaves(), "fallen_leaves_birch");
        fallenleaves_spruce = registerBlock(new BlockFallenLeaves(), "fallen_leaves_spruce");
        fallenleaves_jungle = registerBlock(new BlockFallenLeaves(), "fallen_leaves_jungle");
        fallenleaves_darkoak = registerBlock(new BlockFallenLeaves(), "fallen_leaves_dark_oak");
        fallenleaves_acacia = registerBlock(new BlockFallenLeaves(), "fallen_leaves_acacia");
        fallenleaves_dead = registerBlock(new BlockFallenLeaves(), "fallen_leaves_dead");

        for(EnumLeafType leafType : EnumLeafType.values())
            FALLEN_LEAVES.add(registerBlock(new BlockFallenLeaves(), "fallen_leaves_" + leafType.getName()));

        oak_twigs = registerBlock(new BlockGroundCover("oak_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), "oak_twigs");
        birch_twigs = registerBlock(new BlockGroundCover("birch_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), "birch_twigs");
        spruce_twigs = registerBlock(new BlockGroundCover("spruce_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), "spruce_twigs");
        jungle_twigs = registerBlock(new BlockGroundCover("jungle_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), "jungle_twigs");
        acacia_twigs = registerBlock(new BlockGroundCover("acacia_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), "acacia_twigs");
        dark_oak_twigs = registerBlock(new BlockGroundCover("dark_oak_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), "dark_oak_twigs");

        for(EnumLeafType leafType : EnumLeafType.values())
            TWIGS.add(registerBlock(new BlockGroundCover(leafType.getName() + "_twigs", Material.PLANTS, BlockGroundCover.GroundCoverType.TWIGS), leafType.getName() + "_twigs"));

        coconut = new BlockCoconut();
        registerBlockWithItem(coconut, "coconut", new ItemCoconut(coconut));

        stone_rocks = registerBlock(new BlockGroundCover("stone_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "stone_rocks");
        cobblestone_rocks = registerBlock(new BlockGroundCover("cobblestone_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "cobblestone_rocks");
        mossy_cobblestone_rocks = registerBlock(new BlockGroundCover("mossy_cobblestone_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "mossy_cobblestone_rocks");
        andesite_rocks = registerBlock(new BlockGroundCover("andesite_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "andesite_rocks");
        granite_rocks = registerBlock(new BlockGroundCover("granite_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "granite_rocks");
        diorite_rocks = registerBlock(new BlockGroundCover("diorite_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "diorite_rocks");
        sandstone_rocks = registerBlock(new BlockGroundCover("sandstone_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "sandstone_rocks");
        red_sandstone_rocks = registerBlock(new BlockGroundCover("red_sandstone_rocks", Material.ROCK, BlockGroundCover.GroundCoverType.ROCKS), "red_sandstone_rocks");

        bones = registerBlock(new BlockGroundCover("bones", Material.ROCK, BlockGroundCover.GroundCoverType.BONES), "bones");
        seashells = registerBlock(new BlockGroundCover("sea_shells", Material.ROCK, BlockGroundCover.GroundCoverType.SEASHELLS), "sea_shells");
        pinecones = registerBlock(new BlockGroundCover("pine_cones", Material.PLANTS, BlockGroundCover.GroundCoverType.PINE_CONES), "pine_cones");

        cracked_sand = registerBlock(new BlockCrackedSand(), "cracked_sand");
        red_cracked_sand = registerBlock(new BlockCrackedSand(), "red_cracked_sand");

        mud = registerBlock(new BlockMud(), "mud");

        if(PVJConfig.master.enableStoneTypeBlocks)
        {
            wet_adobe = registerBlock(new BlockWetAdobe(), "wet_adobe");

            for(EnumStoneType stone : EnumStoneType.values())
                STONES.add(registerBlock(new BlockStoneBlock(stone.getHardness(), stone.getResistance(), stone.getMapColor()), stone.getName()));

            for(EnumStoneType stone : EnumStoneType.values())
                STAIRS.add(registerBlock(new BlockPVJStairs(STONES.get(stone.getID()).getDefaultState()), stone.getName() + "_stairs"));

            for(EnumStoneType stone : EnumStoneType.values())
            {
                BlockPVJHalfSlab slab1 = new BlockPVJHalfSlab(STONES.get(stone.getID()).getDefaultState());
                BlockPVJDoubleSlab slab2 = new BlockPVJDoubleSlab(STONES.get(stone.getID()).getDefaultState(), slab1);

                registerSlab(slab1, slab2, stone.getName()+ "_slab", stone.getName() + "_double_slab");

                SLABS.add(slab1);
            }

            cobblestone_brick_wall = registerBlock(new BlockCobblestoneBrickWall(), "cobblestone_brick_wall");
        }

		*/
/*if(PVJConfig.master.enableAquamarine)
		{
			aquamarine_ore = registerBlock(new BlockPVJOre(PVJItems.aquamarine), "aquamarine_ore");
			aquamarine_block = registerBlock(new BlockStoneBlock(5.0F, 10.0F, MapColor.DIAMOND), "aquamarine_block");
		}*//*


        if(PVJConfig.master.enableMysticalGrill)
        {
            mystical_grill = registerBlock(new BlockMysticalGrill(), "mystical_grill");
        }

        if(PVJConfig.master.enableChimneys)
        {
            cobblestone_chimney = registerBlock(new BlockChimney(), "cobblestone_chimney");
            stone_chimney = registerBlock(new BlockChimney(), "stone_chimney");
            brick_chimney = registerBlock(new BlockChimney(), "brick_chimney");
            stonebrick_chimney = registerBlock(new BlockChimney(), "stonebrick_chimney");
            cobblestone_brick_chimney = registerBlock(new BlockChimney(), "cobblestone_brick_chimney");
            sandstone_chimney = registerBlock(new BlockChimney(), "sandstone_chimney");
            netherbrick_chimney = registerBlock(new BlockChimney(), "netherbrick_chimney");

            cobblestone_chimney_top = registerBlock(new BlockChimneyTop(), "cobblestone_chimney_top");
            stone_chimney_top = registerBlock(new BlockChimneyTop(), "stone_chimney_top");
            brick_chimney_top = registerBlock(new BlockChimneyTop(), "brick_chimney_top");
            stonebrick_chimney_top = registerBlock(new BlockChimneyTop(), "stonebrick_chimney_top");
            cobblestone_brick_chimney_top = registerBlock(new BlockChimneyTop(), "cobblestone_brick_chimney_top");
            sandstone_chimney_top = registerBlock(new BlockChimneyTop(), "sandstone_chimney_top");
            netherbrick_chimney_top = registerBlock(new BlockChimneyTop(), "netherbrick_chimney_top");
        }

        if(PVJConfig.master.enableLighting)
        {
            campfire = registerBlock(new BlockCampfire(), "campfire");
            candle = registerBlock(new BlockCandle(), "candle");
            glowstone_lamp_wood = registerBlock(new BlockGlowstoneLamp(Material.WOOD), "glowstone_lamp_wood");
            glowstone_lamp_stone = registerBlock(new BlockGlowstoneLamp(Material.ROCK), "glowstone_lamp_stone");
            glowstone_lamp_iron = registerBlock(new BlockGlowstoneLamp(Material.IRON), "glowstone_lamp_iron");
            lantern = registerBlock(new BlockLantern(BlockLantern.Type.NORMAL), "lantern");
            lantern_candle = registerBlock(new BlockLantern(BlockLantern.Type.CANDLE), "lantern_candle");
            lava_lamp = registerBlock(new BlockLantern(BlockLantern.Type.LAVA), "lava_lamp");
            paper_lantern = registerBlock(new BlockLantern(BlockLantern.Type.PAPER), "paper_lantern");
            lightbulb = registerBlock(new BlockLightbulb("lightbulb"), "lightbulb");
            ceiling_lamp = registerBlock(new BlockCeilingLamp(), "ceiling_lamp");
            circuit_breaker = registerBlock(new BlockCircuitBreaker(), "circuit_breaker");
        }

        redwood_bark = registerBlock(new BlockBark(LOGS.get(EnumWoodType.REDWOOD.getID())), "redwood_bark");

        rock_formation = registerBlock(new BlockRockFormation("rock_formation"), "rock_formation");
        ice_formation = registerBlock(new BlockRockFormation("ice_formation"), "ice_formation");
    }

    public static Block registerBlock(Block block, String name)
    {
        block.setUnlocalizedName(name);
        block.setCreativeTab(CreativeTabPVJ.instance);

        block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));

        Item itemBlock = new ItemPVJBlock(block);
        itemBlock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));

        BLOCKS.add(block);
        PVJItems.ITEMS.add(itemBlock);

        return block;
    }

    public static Block registerBlockWithItem(Block block, String name, ItemBlock itemblock)
    {
        block.setUnlocalizedName(name);
        block.setCreativeTab(CreativeTabPVJ.instance);

        block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        BLOCKS.add(block);

        itemblock.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        PVJItems.ITEMS.add(itemblock);

        return block;
    }

    //Doors must be registered alongside its item
    public static Block registerDoor(BlockPVJDoor door, String name)
    {
        door = (BlockPVJDoor) registerBlock(door, name);
        door.setCreativeTab(null);

        Item item = PVJItems.registerItem(new ItemDoor(door), name + "_item");
        door.setDoorItem(item);

        return door;
    }

    public static void registerSlab(BlockPVJHalfSlab halfSlab, BlockPVJDoubleSlab doubleSlab, String name1, String name2)
    {
        ItemPVJSlab itemSlab = new ItemPVJSlab(halfSlab, halfSlab, doubleSlab);
        registerBlockWithItem(halfSlab, name1, itemSlab);

        doubleSlab.setRegistryName(new ResourceLocation(Reference.MOD_ID, name2));
        BLOCKS.add(doubleSlab);
    }

}
*/
