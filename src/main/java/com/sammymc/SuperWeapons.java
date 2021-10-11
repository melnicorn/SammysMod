package com.sammymc;

import com.sammymc.setup.Registration;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SuperWeapons.MODID)
public class SuperWeapons {
	
	public static final String MODID = "superweapons";
	public SuperWeapons() {
		Registration.init();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		
	}
}
