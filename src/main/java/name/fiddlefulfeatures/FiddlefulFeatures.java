package name.fiddlefulfeatures;

import name.fiddlefulfeatures.block.ModBlocks;
import name.fiddlefulfeatures.item.ModItemGroups;
import name.fiddlefulfeatures.item.ModItems;
import name.fiddlefulfeatures.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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