package net.thegaminghuskymc.mcaddon.blocks.end;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.mcaddon.Main;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BlockEndBase extends BlockMod {

    public BlockEndBase(Material material, String name) {
        super(material, MOD_ID, name);
        setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
    }

}
