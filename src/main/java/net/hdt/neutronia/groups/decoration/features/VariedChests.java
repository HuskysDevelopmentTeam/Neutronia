package net.hdt.neutronia.groups.decoration.features;

import net.hdt.huskylib2.recipe.BlacklistOreIngredient;
import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.handler.server.ModIntegrationHandler;
import net.hdt.neutronia.base.handler.server.RecipeProcessor;
import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.groups.decoration.blocks.BlockCustomChest;
import net.hdt.neutronia.groups.decoration.client.render.RenderTileCustomChest;
import net.hdt.neutronia.groups.decoration.tile_entity.TileCustomChest;
import net.minecraft.block.BlockChest.Type;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Map;

public class VariedChests extends Component {

	public static final Type CUSTOM_TYPE_NEUTRONIA = EnumHelper.addEnum(Type.class, "NEUTRONIA", new Class[0]);
	public static final Type CUSTOM_TYPE_NEUTRONIA_TRAP = EnumHelper.addEnum(Type.class, "NEUTRONIA_TRAP", new Class[0]);

	public static final ResourceLocation TRAP_RESOURCE = new ResourceLocation(LibMisc.PREFIX_MOD + "textures/blocks/chests/trap.png");
	public static final ResourceLocation TRAP_DOUBLE_RESOURCE = new ResourceLocation(LibMisc.PREFIX_MOD + "textures/blocks/chests/trap_double.png");

	public static BlockCustomChest custom_chest;
	public static BlockCustomChest custom_chest_trap;

	boolean renameVanillaChests;
	boolean addLogRecipe;
	boolean reversionRecipe;
	
	@Override
	public void setupConfig() {
		renameVanillaChests = loadPropBool("Rename vanilla chests to Oak (Trapped) Chest", "", true);
		addLogRecipe = loadPropBool("Add recipe to craft chests using Logs (makes 4 chests)", "", true);
		reversionRecipe = loadPropBool("Enable Conversion to Vanilla Chests", "Set this to true to add a recipe to convert any Quark chest to a vanilla one.\n"
				+ "Use this if some of your mods don't work with the ore dictionary key \"chestWood\".", false);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		custom_chest = new BlockCustomChest("custom_chest", CUSTOM_TYPE_NEUTRONIA);
		custom_chest_trap = new BlockCustomChest("custom_chest_trap", CUSTOM_TYPE_NEUTRONIA_TRAP);

		registerTile(TileCustomChest.class, "neutronia_chest");
		
		ModIntegrationHandler.addCharsetCarry(custom_chest);
		ModIntegrationHandler.addCharsetCarry(custom_chest_trap);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void preInitClient(FMLPreInitializationEvent event) {
		ClientRegistry.bindTileEntitySpecialRenderer(TileCustomChest.class, new RenderTileCustomChest());
	}

	@Override
	public void postPreInit(FMLPreInitializationEvent event) {		
		if(renameVanillaChests) {
			Blocks.CHEST.setTranslationKey("oak_chest");
			Blocks.TRAPPED_CHEST.setTranslationKey("oak_chest_trap");
		}

		RecipeProcessor.addWoodReplacements(1, Blocks.CHEST, Blocks.TRAPPED_CHEST);

		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(Blocks.CHEST),
				"WWW", "W W", "WWW",
				'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 0));
		if(addLogRecipe)
			RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(Blocks.CHEST, 4),
					"WWW", "W W", "WWW",
					'W', ProxyRegistry.newStack(Blocks.LOG, 1, 0));

		int i = 1;
		for(ChestType type : ChestType.VALID_TYPES) {
			ItemStack out = ProxyRegistry.newStack(custom_chest);
			custom_chest.setCustomType(out, type);

			RecipeHandler.addOreDictRecipe(out.copy(),
					"WWW", "W W", "WWW",
					'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, i));

			if(addLogRecipe) {
				ItemStack outFour = out.copy();
				outFour.setCount(4);
				RecipeHandler.addOreDictRecipe(outFour,
						"WWW", "W W", "WWW",
						'W', ProxyRegistry.newStack(i > 3 ? Blocks.LOG2 : Blocks.LOG, 1, i % 4));
			}

			ItemStack outTrap = ProxyRegistry.newStack(custom_chest_trap);
			custom_chest.setCustomType(outTrap, type);

			RecipeHandler.addShapelessOreDictRecipe(outTrap, out.copy(), ProxyRegistry.newStack(Blocks.TRIPWIRE_HOOK));
			i++;
		}

		// Low priority ore dictionary recipes
		Ingredient chest = new BlacklistOreIngredient("chestWood", (stack) -> stack.getItem() == Item.getItemFromBlock(custom_chest));

		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(Blocks.CHEST),
				"WWW", "W W", "WWW",
				'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 0));
		RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Blocks.TRAPPED_CHEST), chest, ProxyRegistry.newStack(Blocks.TRIPWIRE_HOOK));

		// Vanilla recipe replacement
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(Blocks.HOPPER),
				"I I", "ICI", " I ",
				'I', Items.IRON_INGOT,
				'C', "chestWood");
		
		RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(Blocks.PURPLE_SHULKER_BOX), 
				"S", "C", "S",
				'S', ProxyRegistry.newStack(Items.SHULKER_SHELL),
				'C', "chest");
		
		// Reversion Recipe
		if(reversionRecipe) {
			RecipeHandler.addShapelessOreDictRecipe(new ItemStack(Blocks.CHEST), "chestWood");
			RecipeHandler.addShapelessOreDictRecipe(new ItemStack(Blocks.TRAPPED_CHEST), "chestTrapped");
		}
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("chest", ProxyRegistry.newStack(custom_chest, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("chest", ProxyRegistry.newStack(custom_chest_trap, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("chest", Blocks.CHEST);
		OreDictionary.registerOre("chest", Blocks.TRAPPED_CHEST);
		
		OreDictionary.registerOre("chestWood", ProxyRegistry.newStack(custom_chest, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("chestWood", Blocks.CHEST);
		
		OreDictionary.registerOre("chestTrapped", ProxyRegistry.newStack(custom_chest_trap, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("chestTrapped", Blocks.TRAPPED_CHEST);
	}
	
	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}

	public enum ChestType {
		NONE(""),
		SPRUCE("spruce"),
		BIRCH("birch"),
		JUNGLE("jungle"),
		ACACIA("acacia"),
		DARK_OAK("dark_oak");

		public final String name;
		public final ResourceLocation nrmTex;
		public final ResourceLocation dblTex;
		public final ModelResourceLocation normalModel;
		public final ModelResourceLocation trapModel;

		public static final ChestType[] VALID_TYPES;
		public static final Map<String, ChestType> NAME_TO_TYPE;

		private ChestType(String name) {
			this.name = name;
			nrmTex = new ResourceLocation(LibMisc.PREFIX_MOD + "textures/blocks/chests/" + name + ".png");
			dblTex = new ResourceLocation(LibMisc.PREFIX_MOD + "textures/blocks/chests/" + name + "_double.png");

			normalModel = new ModelResourceLocation(new ResourceLocation("neutronia", "custom_chest_" + name), "inventory");
			trapModel = new ModelResourceLocation(new ResourceLocation("neutronia", "custom_chest_trap_" + name), "inventory");
		}

		public static ChestType getType(String type) {
			return NAME_TO_TYPE.getOrDefault(type, NONE);
		}

		static {
			VALID_TYPES = new ChestType[] { SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK };
			NAME_TO_TYPE = new HashMap<>();
			for( ChestType type : VALID_TYPES )
				NAME_TO_TYPE.put(type.name, type);
		}
	}
	
	
}