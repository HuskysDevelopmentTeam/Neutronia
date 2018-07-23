package net.hdt.neutronia.items;

import net.hdt.huskylib2.interf.IVariantHolder;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public abstract class ItemModTest extends ItemElytra implements IVariantHolder {

    public static final ArrayList<IVariantHolder> variantHolders = new ArrayList<>();

    private final String[] variants;
    private final String bareName, modid;

    public ItemModTest(String name, String modid, String... variants) {
        if (variants.length > 1)
            setHasSubtypes(true);

        if (variants.length == 0)
            variants = new String[]{name};

        bareName = name;
        this.variants = variants;
        this.modid = modid;
        setTranslationKey(name);
        variantHolders.add(this);
    }

    public Item setTranslationKey(String name) {
        super.setTranslationKey(name);
        this.setRegistryName(new ResourceLocation(getPrefix(), name));
        ProxyRegistry.register(this);
        return this;
    }

    @Override
    public String getTranslationKey(ItemStack par1ItemStack) {
        int dmg = par1ItemStack.getItemDamage();
        String[] variants = getVariants();

        String name;
        if (dmg >= variants.length)
            name = bareName;
        else name = variants[dmg];

        return "item." + name;
    }

    @Override
    public String getPrefix() {
        return this.modid;
    }

    @Override
    public String getModNamespace() {
        return this.modid;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (isInCreativeTab(tab))
            for (int i = 0; i < getVariants().length; i++)
                subItems.add(new ItemStack(this, 1, i));
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

}