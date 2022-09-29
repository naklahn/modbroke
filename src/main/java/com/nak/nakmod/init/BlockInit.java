package com.nak.nakmod.init;

import java.util.function.Function;

//import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.nak.nakmod.Nakmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nakmod.MOD_ID);

	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	// creates block with "name", material, and map color (purple), strength (how hard it is to mine), sounds
	// item is the block item that appears in the creative tab
	// then go to blockstates
	// then make a file under block models named after the block
	// add the block to the lang file
	// drag in the block texture to the textures folder
	// in the data package loot tables package add a new json file with the block name and enter the code so that it drops the block when mined
	// in the minecraft tags open the appropriate tool .json and add the item to the list
	// create an item model in the item model folder with the block name so that it can be shown in the inventory
	// if you want to have the block require a specific tool, create a file named after the tool in the data folder and copy the info from the tool.json
	
	//To create an ore, follow the above steps
	//create an entry in the 2 ModConfiguredFeatues and 1 ModPlacedFeatures
	//add a file called add_orename_ore.json in the forge.biome_modifier folder under data
		//in .json
		//type: stays same
		//biome: select specific biome, create biome list, or add all biomes (#minecraft:is_overworld)
		//features: underground ores (look at generation step class to see all options, (decoration, structures, lakes, etc)
	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block", () 
			-> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(2.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()), object -> ()
			-> new BlockItem(object.get(), new Item.Properties().tab(Nakmod.NAKMOD_TAB)));
	
	public static final RegistryObject<Block> CRYSTAL_ORE = register("crystal_ore", () 
			-> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).strength(2.0f).sound(SoundType.STONE).lightLevel(state -> 15).requiresCorrectToolForDrops()), object -> ()
			-> new BlockItem(object.get(), new Item.Properties().tab(Nakmod.NAKMOD_TAB)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block){
		return BLOCKS.register(name, block);
	}
		
		private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, 
					Function<RegistryObject<T>, Supplier<? extends Item>> item){
			//return BLOCKS.register(name, block);
			RegistryObject<T> obj = registerBlock(name, block);
			ITEMS.register(name, item.apply(obj));
			return obj;
	}
}
