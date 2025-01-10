package kripsy.fiddlefulfeatures.block;

import kripsy.fiddlefulfeatures.FiddlefulFeatures;
import kripsy.fiddlefulfeatures.block.custom.Kripsy_Plushie;
import kripsy.fiddlefulfeatures.block.custom.SlotMachine;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ORB_BLOCK = registerBlock("orb_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.GLOW_LICHEN)));
    public static final Block MEAT_BLOCK = registerBlock("meat_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK).sounds(BlockSoundGroup.SLIME)));
    public static final Block SLOTMACHINE = registerBlock("slotmachine",
            new SlotMachine(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque().hardness(0.5F).sounds(BlockSoundGroup.STONE)));
    public static final Block KRIPSY_PLUSHIE = registerBlock("kripsy_plushie",
            new Kripsy_Plushie(FabricBlockSettings.copyOf(Blocks.PLAYER_HEAD).sounds(BlockSoundGroup.WOOL).nonOpaque()));


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
