package net.hdt.neutronia.blocks.base;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.EnumDyeColor;
import net.hdt.huskylib2.blocks.BlockMod;
import net.hdt.huskylib2.interf.IBlockColorProvider;
import net.hdt.huskylib2.interf.IModBlock;

public class BlockColoredAlt extends BlockMod implements IBlockColorProvider, IModBlock {

    public final EnumDyeColor color;
    private String modid;

    public BlockColoredAlt(String modid, String name, EnumDyeColor color) {
        super(Material.ROCK, modid, color.getName() + "_" + name);
        this.color = color;
        this.modid = modid;
    }

    public BlockColoredAlt(Material material, String modid, String name, EnumDyeColor color) {
        super(material, modid, color.getName() + "_" + name);
        this.color = color;
        this.modid = modid;
    }

    /*private static TextFormatting getFromColor(EnumDyeColor color) {
        switch (color) {
            case ORANGE:
                return TextFormatting.GOLD;
            case MAGENTA:
                return TextFormatting.LIGHT_PURPLE;
            case LIGHT_BLUE:
                return TextFormatting.BLUE;
            case YELLOW:
                return TextFormatting.YELLOW;
            case LIME:
                return TextFormatting.GREEN;
            case PINK:
                return TextFormatting.LIGHT_PURPLE;
            case GRAY:
                return TextFormatting.DARK_GRAY;
            case SILVER:
                return TextFormatting.GRAY;
            case CYAN:
                return TextFormatting.DARK_AQUA;
            case PURPLE:
                return TextFormatting.DARK_PURPLE;
            case BLUE:
                return TextFormatting.DARK_BLUE;
            case BROWN:
                return TextFormatting.GOLD;
            case GREEN:
                return TextFormatting.DARK_GREEN;
            case RED:
                return TextFormatting.DARK_RED;
            case BLACK:
                return TextFormatting.BLACK;
            default:
                return TextFormatting.WHITE;
        }
    }

    @Override
    public String getModNamespace() {
        return modid;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!GuiScreen.isShiftKeyDown()) {
            tooltip.add("Hold " + TextFormatting.BOLD + getFromColor(color) + "SHIFT " + TextFormatting.GRAY + "for more information");
        } else {
            String colorName = color.getName().replace("_", " ");
            colorName = WordUtils.capitalize(colorName);
            tooltip.add("Color: " + TextFormatting.BOLD.toString() + getFromColor(color).toString() + colorName);
        }
    }*/

    @Override
    public IBlockColor getBlockColor() {
        return (state, worldIn, pos, tintIndex) -> EnumDyeColor.values()[tintIndex].getColorValue();
    }

    @Override
    public IItemColor getItemColor() {
        return (stack, tintIndex) -> EnumDyeColor.values()[tintIndex].getColorValue();
    }

}