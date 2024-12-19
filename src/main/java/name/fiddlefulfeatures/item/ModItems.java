package name.fiddlefulfeatures.item;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.item.custom.WalletWhacker;
import name.fiddlefulfeatures.item.custom.Mattock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ORB = registerItem("orb", new Item(new FabricItemSettings()));
    public static final Item COIN = registerItem("coin", new Item(new FabricItemSettings()));
    public static final Item MATTOCK = registerItem("mattock", new Mattock(ToolMaterials.NETHERITE, 2, 2f, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item WALLETWHACKER = registerItem("walletwhacker", new WalletWhacker(new FabricItemSettings().maxDamage(2500), 1, 1f));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FiddlefulFeatures.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FiddlefulFeatures.LOGGER.info("Registering Mod Items for " + FiddlefulFeatures.MOD_ID);

    }
}
