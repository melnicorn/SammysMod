package com.sammymc.setup;


import com.sammymc.SuperWeapons;
import com.sammymc.items.SuperAxe;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperWeapons.MODID);
	public static final RegistryObject<SuperAxe> SUPERAXE = ITEMS.register("superaxe", ()-> new SuperAxe(
			new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
