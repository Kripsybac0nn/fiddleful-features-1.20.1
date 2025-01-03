package name.fiddlefulfeatures.block;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.block.custom.SlotMachine;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ORB_BLOCK = registerBlock("orb_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLOW_LICHEN)));
    public static final Block SLOTMACHINE = registerBlock("slotmachine",
            new SlotMachine(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque().hardness(0.5F).sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FiddlefulFeatures.MOD_ID, name), block);
    }

private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, new Identifier(FiddlefulFeatures.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
}


    public static void registerModBlocks() {
        FiddlefulFeatures.LOGGER.info("Registering Mod Blocks for " + FiddlefulFeatures.MOD_ID);
    }
}
