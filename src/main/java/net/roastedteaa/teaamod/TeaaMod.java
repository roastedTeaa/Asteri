package net.roastedteaa.teaamod;

import net.fabricmc.api.ModInitializer;

import net.roastedteaa.teaamod.block.ModBlocks;
import net.roastedteaa.teaamod.item.ModItemGroups;
import net.roastedteaa.teaamod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaaMod implements ModInitializer {
	public static final String MOD_ID = "teaamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}