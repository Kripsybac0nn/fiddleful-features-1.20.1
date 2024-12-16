package name.fiddlefulfeatures;

import name.fiddlefulfeatures.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FiddlefulFeatures implements ModInitializer {
	public static final String MOD_ID = "fiddlefulfeatures";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		LOGGER.info("Hello Fabric world!");
	}
}