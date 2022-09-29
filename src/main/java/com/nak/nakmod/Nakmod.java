package com.nak.nakmod;

import com.nak.nakmod.init.BlockInit;
import com.nak.nakmod.init.ItemInit;
import com.nak.nakmod.init.world.feature.ModConfiguredFeatures;
import com.nak.nakmod.init.world.feature.ModPlacedFeatures;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("nakmod")
public class Nakmod {

	public static final String MOD_ID = "nakmod";
// how to make a creative tab, MAKE SURE TI CHANGE CreativeModeTab(xxx) to make unique tabs
// Add creative tab name to the en_us file
	public static final CreativeModeTab NAKMOD_TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			//returns the item as the tab icon
			return new ItemStack(ItemInit.EXAMPLE_ITEM.get());
		}
	};
// To add new items
	// add new entry in the lang en-US.json with item name
	// create json file using the item name under the models folder
	// assign a texture to the item in the texture file
	// save the texture file (16x16) in under items in the textures folder 
	
	public Nakmod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		ModConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
		ModPlacedFeatures.PLACED_FEATURES.register(bus);
	MinecraftForge.EVENT_BUS.register(this);
	}
}
