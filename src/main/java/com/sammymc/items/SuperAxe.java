package com.sammymc.items;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class SuperAxe extends SwordItem {
	public static final String INTERNAL_NAME= "superaxe";
	
	public SuperAxe(Properties properties) {
		super(Tiers.NETHERITE, 3, -2.4F, properties);
		
	}

}
