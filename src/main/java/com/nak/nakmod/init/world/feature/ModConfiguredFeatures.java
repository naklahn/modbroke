package com.nak.nakmod.init.world.feature;

import java.util.List;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.nak.nakmod.Nakmod;
import com.nak.nakmod.init.BlockInit;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = 
			DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Nakmod.MOD_ID);
	//creates the list of what the ore will replace in the world
	public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CRYSTAL_ORES = Suppliers.memoize(() -> List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.CRYSTAL_ORE.get().defaultBlockState()),
					OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.CRYSTAL_ORE.get().defaultBlockState())));
	//replacing endstone requires a different set up https://www.youtube.com/watch?v=b_dHhi7SfM8&ab_channel=ModdingbyKaupenjoe
	// instead of OreFeatures.Replacables, use new BlockMatchTest(Blocks.TheBlockYouWantToReplace)
	
	// last number is vein size \/, stay above 3
	public static final RegistryObject<ConfiguredFeature<?, ?>> CRYSTAL_ORE = CONFIGURED_FEATURES.register("crystal_ore",  
			() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CRYSTAL_ORES.get(), 10)));
	
	public static void register(IEventBus bus) {
		CONFIGURED_FEATURES.register(bus);
	}
}
