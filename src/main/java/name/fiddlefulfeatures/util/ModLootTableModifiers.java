package name.fiddlefulfeatures.util;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier MINESHAFT_ID =
            new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier SHIPWRECK_ID =
            new Identifier("minecraft", "chests/shipwreck_map");
    private static final Identifier DUNGEON_ID =
            new Identifier("minecraft", "chests/simple_dungeon");
    private static final Identifier BASTION_ID =
            new Identifier("minecraft", "chests/bastion_other");
    private static final Identifier WATERRUIN_ID =
            new Identifier("minecraft", "chests/underwater_ruin_small");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, builder, lootTableSource) -> {

            if(MINESHAFT_ID.equals(identifier)) {LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.COIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());
            builder.pool(poolBuilder.build());}

            if(DUNGEON_ID.equals(identifier)) {LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.COIN))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());
                builder.pool(poolBuilder.build());}

            if(SHIPWRECK_ID.equals(identifier)) {LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.COIN))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,5.0f)).build());
                builder.pool(poolBuilder.build());}

            if(BASTION_ID.equals(identifier)) {LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.COIN))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,3.0f)).build());
                builder.pool(poolBuilder.build());}

            if(WATERRUIN_ID.equals(identifier)) {LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.COIN))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());
                builder.pool(poolBuilder.build());}
        });


    }
    public static void registerLootTables() {
        FiddlefulFeatures.LOGGER.info("Registering Loot Tables for " + FiddlefulFeatures.MOD_ID);
    }
}
