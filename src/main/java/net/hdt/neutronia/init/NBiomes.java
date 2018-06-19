package net.hdt.neutronia.init;

import net.hdt.neutronia.world.biome.overworld.BiomeBasaltOverworld;
import net.hdt.neutronia.world.biome.overworld.BiomeBlackDesert;
import net.hdt.neutronia.world.biome.overworld.BiomeRedDesert;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class NBiomes {

    public static final Biome BASALT = new BiomeBasaltOverworld();
    public static final Biome RED_DESERT = new BiomeRedDesert();
    public static final Biome BLACK_DESERT = new BiomeBlackDesert();

    public static final Biome COLD_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Cold Ocean")).setBaseHeight(-1.0F).setHeightVariation(0.1F).setBaseBiome("ocean").setWaterColor(0x3d57d6));
    public static final Biome LUKEWARM_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Lukewarm Ocean")).setBaseHeight(-1.0F).setHeightVariation(0.1F).setBaseBiome("ocean").setWaterColor(0x45adf2));
    public static final Biome WARM_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Warm Ocean")).setBaseHeight(-1.0F).setHeightVariation(0.1F).setBaseBiome("ocean").setWaterColor(0x43d5ee));
    public static final Biome DEEP_COLD_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Deep Cold Ocean")).setBaseHeight(-1.8F).setHeightVariation(0.1F).setBaseBiome("deep_ocean").setWaterColor(0x3d57d6));
    public static final Biome DEEP_LUKEWARM_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Deep Lukewarm Ocean")).setBaseHeight(-1.8F).setHeightVariation(0.1F).setBaseBiome("deep_ocean").setWaterColor(0x45adf2));
    public static final Biome DEEP_WARM_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Deep Warm Ocean")).setBaseHeight(-1.8F).setHeightVariation(0.1F).setBaseBiome("deep_ocean").setWaterColor(0x43d5ee));
    public static final Biome SUPER_DEEP_COLD_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Super Deep Cold Ocean")).setBaseHeight(-2.7F).setHeightVariation(0.1F).setBaseBiome("deep_ocean").setWaterColor(0x3d57d6));
    public static final Biome SUPER_DEEP_LUKEWARM_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Super Deep Lukewarm Ocean")).setBaseHeight(-2.7F).setHeightVariation(0.1F).setBaseBiome("deep_ocean").setWaterColor(0x45adf2));
    public static final Biome SUPER_DEEP_WARM_OCEAN = new BiomeOcean((new Biome.BiomeProperties("Super Deep Warm Ocean")).setBaseHeight(-2.7F).setHeightVariation(0.1F).setBaseBiome("deep_ocean").setWaterColor(0x3d57d6));
//    public static final Biome MESA = new BiomeFrozenMesa(false, false, (new Biome.BiomeProperties("Frozen Mesa")).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
//    public static final Biome MESA_ROCK = new BiomeFrozenMesa(false, true, (new Biome.BiomeProperties("Frozen Mesa Plateau F")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
//    public static final Biome MESA_CLEAR_ROCK = new BiomeFrozenMesa(false, false, (new Biome.BiomeProperties("Frozen Mesa Plateau")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
//    public static final Biome MUTATED_MESA = new BiomeFrozenMesa(false, true, (new Biome.BiomeProperties("Frozen Mesa (Bryce)")).setBaseBiome("frozen_mesa").setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
//    public static final Biome MUTATED_MESA_ROCK = new BiomeFrozenMesa(false, true, (new Biome.BiomeProperties("Frozen Mesa Plateau F M")).setBaseBiome("frozen_mesa_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());
//    public static final Biome MUTATED_MESA_CLEAR_ROCK = new BiomeFrozenMesa(false, false, (new Biome.BiomeProperties("Frozen Mesa Plateau F M")).setBaseBiome("frozen_mesa_clear_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.0F).setRainDisabled());

    public static void registerBiomes() {
        initBiome(BASALT, "basalt", 3, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DEAD);
        initBiome(RED_DESERT, "red_desert", 10, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY);
        initBiome(BLACK_DESERT, "black_desert", 20, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY);

        initBiome(COLD_OCEAN, "cold_ocean", 15, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);
        initBiome(LUKEWARM_OCEAN, "lukewarm_ocean", 10, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);
        initBiome(WARM_OCEAN, "warm_ocean", 19, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);

        initBiome(DEEP_COLD_OCEAN, "deep_cold_ocean", 20, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);
        initBiome(DEEP_LUKEWARM_OCEAN, "deep_lukewarm_ocean", 4, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);
        initBiome(DEEP_WARM_OCEAN, "deep_warm_ocean", 6, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);

//        initBiome(SUPER_DEEP_COLD_OCEAN, "super_deep_cold_ocean", 20, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);
//        initBiome(SUPER_DEEP_LUKEWARM_OCEAN, "super_deep_lukewarm_ocean", 4, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);
//        initBiome(SUPER_DEEP_WARM_OCEAN, "super_deep_warm_ocean", 6, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WET, BiomeDictionary.Type.WATER);

//        initBiome(MESA, "frozen_mesa", 1, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
//        initBiome(MESA_ROCK, "frozen_mesa_rock", 1, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
//        initBiome(MESA_CLEAR_ROCK, "frozen_mesa_clear_rock", 1, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
//        initBiome(MUTATED_MESA, "frozen_mutated_mesa", 60, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
//        initBiome(MUTATED_MESA_ROCK, "frozen_mutated_mesa_rock", 90, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
//        initBiome(MUTATED_MESA_CLEAR_ROCK, "frozen_mutated_mesa_clear_rock", 114, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.SANDY);
    }

    private static Biome initBiome(Biome biome, String name, int weight, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {
        biome.setRegistryName(MOD_ID, name);
        ForgeRegistries.BIOMES.register(biome);
        System.out.println(String.format("Biome: %s is now registered", name));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        System.out.println(String.format("Biome: %s is now added to the spawn biome's", name));
        return biome;
    }

}