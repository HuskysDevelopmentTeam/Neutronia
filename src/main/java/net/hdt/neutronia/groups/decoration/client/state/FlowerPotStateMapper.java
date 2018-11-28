package net.hdt.neutronia.groups.decoration.client.state;

import com.google.common.collect.Maps;
import net.hdt.neutronia.groups.decoration.blocks.BlockCustomFlowerPot;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;

import java.util.LinkedHashMap;

public class FlowerPotStateMapper extends StateMapperBase {
	
	public static final FlowerPotStateMapper INSTANCE = new FlowerPotStateMapper();
	public static final ModelResourceLocation LOCATION = new ModelResourceLocation(new ResourceLocation("neutronia", "custom_flower_pot"), "normal");

	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		if(state.getValue(BlockCustomFlowerPot.CUSTOM))
			return LOCATION;

		LinkedHashMap<IProperty<?>, Comparable<?>> map = Maps.newLinkedHashMap(state.getProperties());
		map.remove(BlockCustomFlowerPot.CUSTOM);
		map.remove(BlockCustomFlowerPot.LEGACY_DATA);

		return new ModelResourceLocation(state.getBlock().getRegistryName(), this.getPropertyString(map));
	}
}