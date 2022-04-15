package dev.eggonomicon.bodyguards.init;

//import dev.eggonomicon.bodyguards.config.McdarConfig;
import dev.eggonomicon.bodyguards.enums.*;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class LootRegistry {

    public static final Collection<Identifier> ILLAGER_Item_LOOT_TABLES =
            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                    LootTables.WOODLAND_MANSION_CHEST, LootTables.PILLAGER_OUTPOST_CHEST
            )));

    public static final Collection<Identifier> VILLAGER_Item_LOOT_TABLES =
            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                    LootTables.VILLAGE_ARMORER_CHEST, LootTables.VILLAGE_BUTCHER_CHEST,
                    LootTables.VILLAGE_CARTOGRAPHER_CHEST, LootTables.VILLAGE_FISHER_CHEST,
                    LootTables.VILLAGE_FLETCHER_CHEST, LootTables.VILLAGE_DESERT_HOUSE_CHEST,
                    LootTables.VILLAGE_MASON_CHEST, LootTables.VILLAGE_PLAINS_CHEST,
                    LootTables.VILLAGE_SAVANNA_HOUSE_CHEST, LootTables.VILLAGE_SHEPARD_CHEST,
                    LootTables.VILLAGE_SNOWY_HOUSE_CHEST, LootTables.VILLAGE_TAIGA_HOUSE_CHEST,
                    LootTables.VILLAGE_TANNERY_CHEST, LootTables.VILLAGE_TEMPLE_CHEST,
                    LootTables.VILLAGE_TOOLSMITH_CHEST
            )));
    public static final Collection<Identifier> WORLD_CHESTS =
            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
                    LootTables.ABANDONED_MINESHAFT_CHEST, LootTables.SIMPLE_DUNGEON_CHEST,
                    LootTables.SHIPWRECK_TREASURE_CHEST
            )));

    public static void init(){
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if (!id.getNamespace().equals("minecraft"))
                return;

            FabricLootPoolBuilder poolBuilder;

            if (ILLAGER_Item_LOOT_TABLES.contains(id)){
                poolBuilder = FabricLootPoolBuilder.builder();
                addItem(poolBuilder, ItemInit.summoningItem.get(SummoningItemID.GOLEM_KIT), 0);
                /*
                if (McdarConfig.config.enableSummoningItem.get(SummoningItemID.GOLEM_KIT)) {
                    addItem(poolBuilder, ItemInit.summoningItem.get(SummoningItemID.GOLEM_KIT),
                 */
                            supplier.pool(poolBuilder);
            } else if (VILLAGER_Item_LOOT_TABLES.contains(id)){
                poolBuilder = FabricLootPoolBuilder.builder();

                addItem(poolBuilder, ItemInit.summoningItem.get(SummoningItemID.GOLEM_KIT), 0);
                /*
                if (McdarConfig.config.enableSummoningItem.get(SummoningItemID.GOLEM_KIT)) {
                    addItem(poolBuilder, ItemInit.summoningItem.get(SummoningItemID.GOLEM_KIT),
                 */
                supplier.pool(poolBuilder);
            } else if (WORLD_CHESTS.contains(id)){
                poolBuilder = FabricLootPoolBuilder.builder();

                addItem(poolBuilder, ItemInit.summoningItem.get(SummoningItemID.GOLEM_KIT), 0);
                /*
                if (McdarConfig.config.enableSummoningItem.get(SummoningItemID.GOLEM_KIT)) {
                    addItem(poolBuilder, ItemInit.summoningItem.get(SummoningItemID.GOLEM_KIT),
                 */
                supplier.pool(poolBuilder);
            }
        }));
    }

    public static void addItem(FabricLootPoolBuilder poolBuilder, Item Item, float p){
        poolBuilder.rolls(BinomialLootNumberProvider.create(1, p));
        poolBuilder.withEntry(ItemEntry.builder(Item).build());
    }
}
