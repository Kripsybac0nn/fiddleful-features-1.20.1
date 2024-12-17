package name.fiddlefulfeatures.item;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FIDDLEGROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FiddlefulFeatures.MOD_ID, "fiddlegroup"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fiddlegroup"))
                    .icon(() -> new ItemStack(ModItems.MATTOCK)).entries((displayContext, entries) -> {

                        entries.add(ModItems.ORB);
                        entries.add(ModItems.MATTOCK);
                        entries.add(ModBlocks.ORB_BLOCK);
                        entries.add(ModBlocks.SLOTMACHINE);
                        entries.add(ModItems.COIN);

                    }).build());


    public static void registerItemGroups() {
        FiddlefulFeatures.LOGGER.info("Registering Item Groups for " + FiddlefulFeatures.MOD_ID);
    }
}
