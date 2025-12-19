package com.lejastrinkets;

import com.lejastrinkets.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LejasTrinketsMod implements ModInitializer {
	public static final String MOD_ID = "lejas-trinkets-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}