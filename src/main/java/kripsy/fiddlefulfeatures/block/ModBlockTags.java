package kripsy.fiddlefulfeatures.block;

import kripsy.fiddlefulfeatures.FiddlefulFeatures;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModBlockTags {
    public static final TagKey<Block> MATTOCK_BREAKABLE = TagKey.of(RegistryKeys.BLOCK, Identifier.of(FiddlefulFeatures.MOD_ID, "mattock_breakable"));
}