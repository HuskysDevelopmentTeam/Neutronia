package net.hdt.neutronia.groups.decoration.features;

import net.hdt.huskylib2.recipe.BlacklistOreIngredient;
import net.hdt.huskylib2.recipe.RecipeHandler;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.blocks.BlockNeutroniaTrapdoor;
import net.hdt.neutronia.base.groups.Component;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class VariedTrapdoors extends Component {

    public static Block spruce_trapdoor;
    public static Block birch_trapdoor;
    public static Block jungle_trapdoor;
    public static Block acacia_trapdoor;
    public static Block dark_oak_trapdoor;

    boolean renameVanillaTrapdoor;
    int recipeOutput;

    @Override
    public void setupConfig() {
        renameVanillaTrapdoor = loadPropBool("Rename vanilla trapdoor to Oak Trapdoor", "", true);
        recipeOutput = loadPropInt("Amount of trapdoors crafted (vanilla is 2)", "", 6);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        spruce_trapdoor = new BlockNeutroniaTrapdoor("spruce_trapdoor");
        birch_trapdoor = new BlockNeutroniaTrapdoor("birch_trapdoor");
        jungle_trapdoor = new BlockNeutroniaTrapdoor("jungle_trapdoor");
        acacia_trapdoor = new BlockNeutroniaTrapdoor("acacia_trapdoor");
        dark_oak_trapdoor = new BlockNeutroniaTrapdoor("dark_oak_trapdoor");
    }

    @Override
    public void postPreInit(FMLPreInitializationEvent event) {
        List<ResourceLocation> recipeList = new ArrayList<>(CraftingManager.REGISTRY.getKeys());
        for (ResourceLocation res : recipeList) {
            IRecipe recipe = CraftingManager.REGISTRY.getObject(res);
            ItemStack out = recipe.getRecipeOutput();
            if (recipe instanceof ShapedRecipes && !out.isEmpty() && (out.getItem() == Item.getItemFromBlock(Blocks.TRAPDOOR))) {
                ShapedRecipes shaped = (ShapedRecipes) recipe;
                NonNullList<Ingredient> ingredients = shaped.recipeItems;
                for (int i = 0; i < ingredients.size(); i++) {
                    Ingredient ingr = ingredients.get(i);
                    if (ingr.apply(ProxyRegistry.newStack(Blocks.PLANKS))) {
                        ingredients.set(i, Ingredient.fromStacks(ProxyRegistry.newStack(Blocks.PLANKS, 1, 0)));
                        out.setCount(recipeOutput);
                    }
                }
            }
        }

        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(spruce_trapdoor, recipeOutput),
                "WWW", "WWW",
                'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 1));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(birch_trapdoor, recipeOutput),
                "WWW", "WWW",
                'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 2));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(jungle_trapdoor, recipeOutput),
                "WWW", "WWW",
                'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 3));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(acacia_trapdoor, recipeOutput),
                "WWW", "WWW",
                'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 4));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(dark_oak_trapdoor, recipeOutput),
                "WWW", "WWW",
                'W', ProxyRegistry.newStack(Blocks.PLANKS, 1, 5));

        if (renameVanillaTrapdoor)
            Blocks.TRAPDOOR.setTranslationKey("oak_trapdoor");

        // Low priority ore dictionary recipe
        Ingredient wood = new BlacklistOreIngredient("plankWood", (stack) -> stack.getItem() == Item.getItemFromBlock(Blocks.PLANKS));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(Blocks.TRAPDOOR, recipeOutput),
                "WWW", "WWW",
                'W', wood);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        OreDictionary.registerOre("trapdoorWood", Blocks.TRAPDOOR);
        OreDictionary.registerOre("trapdoorWood", spruce_trapdoor);
        OreDictionary.registerOre("trapdoorWood", birch_trapdoor);
        OreDictionary.registerOre("trapdoorWood", jungle_trapdoor);
        OreDictionary.registerOre("trapdoorWood", acacia_trapdoor);
        OreDictionary.registerOre("trapdoorWood", dark_oak_trapdoor);
    }

    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }
}