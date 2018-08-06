package net.hdt.neutronia.groups.dimensions.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.groups.dimensions.world.biomes.moon.BiomeMoonMain;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

public class MoonBiomes extends Component {

    public static final Biome MOON_MAIN = new BiomeMoonMain();

    private static void addBiome(Biome biome, String name) {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Moon Biome: %s is now registered", name));
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addBiome(MOON_MAIN, "moon_main");
    }

}
