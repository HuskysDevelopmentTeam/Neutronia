package team.abnormal.neutronia.base.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import team.abnormal.abnormalib.item.ItemModBlock;
import team.abnormal.abnormalib.util.ProxyRegistry;
import team.abnormal.neutronia.base.Reference;
import team.abnormal.neutronia.blocks.INeutroniaBlock;

public class BlockNeutroniaButton extends BlockButton implements INeutroniaBlock {

    private final String[] variants;
    private final String bareName;

    boolean wooden;

    public BlockNeutroniaButton(String name, boolean wooden) {
        super(wooden);

        this.wooden = wooden;
        bareName = name;
        variants = new String[]{bareName};

        setTranslationKey(bareName);

        setHardness(0.5F);
        setSoundType(wooden ? SoundType.WOOD : SoundType.STONE);
    }

    @Override
    public Block setTranslationKey(String name) {
        super.setTranslationKey(name);
        setRegistryName(Reference.PREFIX_MOD + name);
        ProxyRegistry.register(this);
        ProxyRegistry.register(new ItemModBlock(this, new ResourceLocation(Reference.PREFIX_MOD + name)));
        return this;
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    @Override
    public EnumRarity getBlockRarity(ItemStack stack) {
        return EnumRarity.COMMON;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    @Override
    public IProperty getVariantProp() {
        return null;
    }

    @Override
    public Class getVariantEnum() {
        return null;
    }

    @Override
    protected void playClickSound(EntityPlayer player, World worldIn, BlockPos pos) {
        if (wooden)
            worldIn.playSound(player, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
        else worldIn.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
    }

    @Override
    protected void playReleaseSound(World worldIn, BlockPos pos) {
        if (wooden)
            worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
        else worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
    }

}
