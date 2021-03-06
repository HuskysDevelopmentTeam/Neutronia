package team.abnormal.neutronia.world.gen.features;/*
package neutronia_legacy.groups.world.world.gen;

import BlockCattail;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import vibrantjourneys.init.PVJBlocks;

import java.util.Arrays;
import java.util.Random;

public class WorldGenCattail implements IWorldGenerator
{
	private int frequency;
	private Biome[] biomes;
	
	public WorldGenCattail(int frequency, Biome... biomes)
	{
		this.frequency = frequency;
		this.biomes = biomes;
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		if(Arrays.asList(biomes).contains(biome))
		{	
			int yPos = 60;
			for(int i = 0; i < frequency; i++)
			{
				int xPos = x + random.nextInt(3) - random.nextInt(3);
				int zPos = z + random.nextInt(3) - random.nextInt(3);
				
				yPos = 60;
				for(int j = 0; j < 20; j++)
				{
					yPos += 1;
					BlockPos pos = new BlockPos(xPos, yPos, zPos);
					if(world.getBlockState(pos).getBlock() == Blocks.GRASS)
					{
						for(EnumFacing facing : EnumFacing.HORIZONTALS)
						{
							if(world.getBlockState(pos.offset(facing)).getMaterial() == Material.WATER)
							{
								if(world.isAirBlock(pos.up()) && world.isAirBlock(pos.up(2)))
								{
									((BlockCattail) PVJBlocks.cattail).placeAt(world, pos.up(), 2);
									
									for(BlockPos position : BlockPos.getAllInBoxMutable(pos.addWalls(-5, yPos, -5), (pos.addWalls(5, yPos, 5))))
									{
										if(world.getBlockState(position).getBlock() == Blocks.GRASS)
										{
											for(EnumFacing facing2 : EnumFacing.HORIZONTALS)
											{
												if(world.getBlockState(position.offset(facing2)).getMaterial() == Material.WATER)
												{
													if(world.isAirBlock(position.up()) && world.isAirBlock(position.up(2)))
													{
														if(random.nextInt(5) < 3)
														{
															((BlockCattail) PVJBlocks.cattail).placeAt(world, position.up(), 2);
															break;
														}
													}
												}
											}
										}
									}
								}
								break;
							}
						}
					}
				}
				
			}
		}
	}
}
*/
