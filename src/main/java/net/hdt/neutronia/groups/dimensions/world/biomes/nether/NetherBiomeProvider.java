package net.hdt.neutronia.groups.dimensions.world.biomes.nether;

import net.hdt.neutronia.groups.dimensions.world.gen.nether.layer.NetherGenLayer;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class NetherBiomeProvider extends BiomeProvider {
    public NetherBiomeProvider(World world) {
        super();
        GenLayer[] genLayers = NetherGenLayer.initializeAllBiomeGenerators(world.getSeed(), world.getWorldType());
        ObfuscationReflectionHelper.setPrivateValue(BiomeProvider.class, this, genLayers[0], "field_76944_d", "genBiomes");
        ObfuscationReflectionHelper.setPrivateValue(BiomeProvider.class, this, genLayers[1], "field_76945_e", "biomeIndexLayer");
    }
}