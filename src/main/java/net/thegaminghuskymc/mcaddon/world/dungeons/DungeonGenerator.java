package net.thegaminghuskymc.mcaddon.world.dungeons;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.thegaminghuskymc.mcaddon.world.dungeons.generator.HallwayStructure;
import net.thegaminghuskymc.mcaddon.world.dungeons.generator.RoomStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DungeonGenerator implements IWorldGenerator {

    private static final RoomStructure room1 = new RoomStructure("room_1");
    private static final RoomStructure room2 = new RoomStructure("room_2");
    private static final RoomStructure room3 = new RoomStructure("room_3");
    private static final RoomStructure room4 = new RoomStructure("room_4");
    private static final RoomStructure room5 = new RoomStructure("room_5");
    private static final RoomStructure room6 = new RoomStructure("room_6");
    private static final RoomStructure room7 = new RoomStructure("room_7");
    private static final RoomStructure room8 = new RoomStructure("room_8");
    private static final RoomStructure room9 = new RoomStructure("room_9");
    private static final RoomStructure room10 = new RoomStructure("room_10");

    private static final HallwayStructure hallway_s = new HallwayStructure("hallway_straight");
    private static final HallwayStructure hallway_cl = new HallwayStructure("hallway_straight");
    private static final HallwayStructure hallway_cr = new HallwayStructure("hallway_straight");
    private static final HallwayStructure hallway_u = new HallwayStructure("hallway_straight");
    private static final HallwayStructure hallway_d = new HallwayStructure("hallway_straight");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        for(int i = 0; i > random.nextInt(10); i++) {
            switch(world.provider.getDimension()) {
                case 1:
                    break;
                case 0:
                    if(i == 1) {
                        generateStructure(room1, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 2) {
                        generateStructure(room2, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 3) {
                        generateStructure(room3, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 4) {
                        generateStructure(room4, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 5) {
                        generateStructure(room5, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 6) {
                        generateStructure(room6, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 7) {
                        generateStructure(room7, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 8) {
                        generateStructure(room8, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 9) {
                        generateStructure(room9, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    } else if(i == 10) {
                        generateStructure(room10, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());

                        for(int j = 0; j > random.nextInt(5); j++) {
                            if(j == 1) {
                                generateStructure(hallway_s, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 2) {
                                generateStructure(hallway_cl, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 3) {
                                generateStructure(hallway_cr, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 4) {
                                generateStructure(hallway_u, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            } else if(j == 5) {
                                generateStructure(hallway_d, world, random, chunkX, chunkZ, 10, Blocks.STONE, Biomes.DESERT.getBiomeClass());
                            }
                        }

                    }
                    break;
                case -1:
            }

        }

    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
        ArrayList<Class<?>> classesList = new ArrayList<>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(classesList.contains(biome))
            {
                if(random.nextInt(chance) == 0)
                {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
    {
        int y = world.getHeight();
        boolean foundGround = false;

        while(!foundGround && y-- >= 0)
        {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }

    public static int getGroundFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 31)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER||blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS||blockAt == Blocks.MYCELIUM;
        }

        return y;
    }
    public static int getLakeFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 31)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER;
        }

        return y;
    }

    public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround)
    {
        int zwidth = template.getSize().getZ();
        int xwidth = template.getSize().getX();

        // check all the corners to see which ones are replaceable
        boolean corner1 = isCornerValid(world, posAboveGround);
        boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));

        // if Y > 20 and all corners pass the test, it's okay to spawn the structure
        return posAboveGround.getY() > 31 && corner1 && corner2;
    }

    public static boolean isCornerValid(World world, BlockPos pos)
    {
        int variation = 3;
        int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());

        return highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation;
    }

}
