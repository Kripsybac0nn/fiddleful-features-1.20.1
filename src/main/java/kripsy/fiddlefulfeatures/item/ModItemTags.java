package kripsy.fiddlefulfeatures.item;

import kripsy.fiddlefulfeatures.FiddlefulFeatures;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> MATTOCKS = TagKey.of(RegistryKeys.ITEM, Identifier.of(FiddlefulFeatures.MOD_ID, "mattocks"));
}
