package name.fiddlefulfeatures.item;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.items.Mattock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ORB = registerItem("orb", new Item(new FabricItemSettings()));
    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings()));
    public static final Item MATTOCK = registerItem("mattock", new Mattock(new FabricItemSettings().maxCount(1).fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FiddlefulFeatures.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FiddlefulFeatures.LOGGER.info("Registering Mod Items for " + FiddlefulFeatures.MOD_ID);

    }
}
