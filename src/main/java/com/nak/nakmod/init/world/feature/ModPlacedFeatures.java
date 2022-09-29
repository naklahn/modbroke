package com.nak.nakmod.init.world.feature;

import java.util.List;

import com.nak.nakmod.Nakmod;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {

	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
			DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Nakmod.MOD_ID);
//commonOrePlacement(veins per chunk, creates a triangle between 80 and -80 with the heighest dist in the middle, other options available
	public static final RegistryObject<PlacedFeature> CRYSTAL_ORE = PLACED_FEATURES.register("crystal_ore",
			() -> new PlacedFeature(ModConfiguredFeatures.CRYSTAL_ORE.getHolder().get(),
					commonOrePlacement(100, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))));
		
	//public static final RegistryObject<PlacedFeature> CRYSTAL_ORE_PLACED = PLACED_FEATURES.register("crystal_ore_placed", () -> new PlacedFeature(ModConfiguredFeatures.CRYSTAL_ORE.getHolder().get(), commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top()))));

	
	   private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		      return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }

		   private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		      return orePlacement(CountPlacement.of(p_195344_), p_195345_);
		   }

		   private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		      return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
		   }
	
	public static void register(IEventBus bus) {
		// TODO Auto-generated method stub
		PLACED_FEATURES.register(bus);
	}
}
