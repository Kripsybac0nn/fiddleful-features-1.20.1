package kripsy.fiddlefulfeatures;

import kripsy.fiddlefulfeatures.block.ModBlocks;
import kripsy.fiddlefulfeatures.item.ModItemGroups;
import kripsy.fiddlefulfeatures.item.ModItems;
import kripsy.fiddlefulfeatures.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FiddlefulFeatures implements ModInitializer {
	public static final String MOD_ID = "fiddlefulfeatures";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		SoundEventRegistry.registerSoundEvents();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModLootTableModifiers.registerLootTables();



	}
}