package com.sammymc.datagen;

import com.sammymc.SuperWeapons;
import com.sammymc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, SuperWeapons.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		singleTexture(
				Registration.SUPERAXE.get().getRegistryName().getPath(), 
				new ResourceLocation("item/handheld"),
				"layer0",
				new ResourceLocation(SuperWeapons.MODID, "item/superaxe"));

	}

}
