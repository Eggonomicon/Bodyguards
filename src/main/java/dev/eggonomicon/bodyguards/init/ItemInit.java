package dev.eggonomicon.bodyguards.init;

import dev.eggonomicon.bodyguards.BodyguardsMod;
import dev.eggonomicon.bodyguards.item.*;
import dev.eggonomicon.bodyguards.enums.*;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.EnumMap;

//import static dev.eggonomicon.bodyguards.config.BodyguardsConfig.config;

public class ItemInit {

    /*
    public static final EnumMap<DamagingItemID, Item> damagingItem = new EnumMap<>(DamagingItemID.class);
    public static final EnumMap<StatusInflictingItemID, Item> statusInflictingItem = new EnumMap<>(StatusInflictingItemID.class);
    public static final EnumMap<QuiverItemID, Item> quiverItem = new EnumMap<>(QuiverItemID.class);
    */
    public static final EnumMap<SummoningItemID, Item> summoningItem = new EnumMap<>(SummoningItemID.class);
    /*
    public static final EnumMap<AgilityItemID, Item> agilityItem = new EnumMap<>(AgilityItemID.class);
    public static final EnumMap<DefenciveItemID, Item> defenciveItem = new EnumMap<>(DefenciveItemID.class);
    */
    public static void init() {
        /*
        for (DamagingItemID ItemID : DamagingItemID.values()) {
            if (!config.enableDamagingItem.get(ItemID))
                continue;

            Item item;

            switch (ItemID) {
                case BLAST_FUNGUS:
                    item = new BlastFungusItem(ItemID);
                    break;
                case CORRUPTED_BEACON:
                    item = new CorruptedBeaconItem(ItemID);
                    break;
                case HARVESTER:
                    item = new HarvesterItem(ItemID);
                    break;
                case LIGHTNING_ROD:
                    item = new LightningRodItem(ItemID);
                    break;
                case UPDRAFT_TOME:
                    item = new UpdraftTomeItem(ItemID);
                    break;
                default:
                    item = new ItemDamagingItem(ItemID);
                    break;
            }
            damagingItem.put(ItemID, item);
            registerItems(ItemID.toString().toLowerCase(), item);
        }
        for (StatusInflictingItemID ItemID : StatusInflictingItemID.values()) {
            if (!config.enableStatusInflictingItem.get(ItemID))
                continue;

            Item item;

            switch (ItemID) {
                case CORRUPTED_SEEDS:
                    item = new CorruptedSeedsItem(ItemID);
                    break;
                case GONG_OF_WEAKENING:
                    item = new GongOfWeakeningItem(ItemID);
                    break;
                case SATCHEL_OF_ELEMENTS:
                    item = new SatchelOfElementsItem(ItemID);
                    break;
                case SHOCK_POWDER:
                    item = new ShockPowderItem(ItemID);
                    break;
                default:
                    item = new ItemStatusInflictingItem(ItemID);
                    break;
            }
            statusInflictingItem.put(ItemID, item);
            registerItems(ItemID.toString().toLowerCase(), item);
        }
        for (QuiverItemID ItemID : QuiverItemID.values()) {
            if (!config.enableQuiverItem.get(ItemID))
                continue;

            Item item;

            switch (ItemID) {
                case FLAMING_QUIVER:
                    item = new FlamingQuiverItem(ItemID);
                    break;
                case HARPOON_QUIVER:
                    item = new HarpoonQuiverItem(ItemID);
                    break;
                case THUNDERING_QUIVER:
                    item = new ThunderingQuiverItem(ItemID);
                    break;
                case TORMENT_QUIVER:
                    item = new TormentQuiverItem(ItemID);
                    break;
                default:
                    item = new ItemQuiverItem(ItemID);
                    break;
            }
            quiverItem.put(ItemID, item);
            registerItems(ItemID.toString().toLowerCase(), item);
        }
        */

        for (SummoningItemID ItemID : SummoningItemID.values()) {
            /*
            if (!config.enableSummoningItem.get(ItemID))
                continue;
            */
            Item item;

            switch (ItemID) {
                /*
                case BUZZY_NEST:
                    item = new BuzzyNestItem(ItemID);
                    break;
                case ENCHANTED_GRASS:
                    item = new EnchantedGrassItem(ItemID);
                    break;
                 */
                case GOLEM_KIT:
                    item = new GolemKitItem(ItemID);
                    break;
                    /*
                case TASTY_BONE:
                    item = new TastyBoneItem(ItemID);
                    break;
                case WONDERFUL_WHEAT:
                    item = new WonderfulWheatItem(ItemID);
                    break;

                     */
                default:
                    item = new ItemSummoningItem(ItemID);
                    break;
            }
            summoningItem.put(ItemID, item);
            registerItems(ItemID.toString().toLowerCase(), item);
        }
        /*
        for (AgilityItemID ItemID : AgilityItemID.values()) {
            if (!config.enableAgilityItem.get(ItemID))
                continue;

            Item item;

            switch (ItemID) {
                case BOOTS_OF_SWIFTNESS:
                    item = new BootsOfSwiftnessItem(ItemID);
                    break;
                case DEATH_CAP_MUSHROOM:
                    item = new DeathCapMushroomItem(ItemID);
                    break;
                case GHOST_CLOAK:
                    item = new GhostCloakItem(ItemID);
                    break;
                case LIGHT_FEATHER:
                    item = new LightFeatherItem(ItemID);
                    break;
                default:
                    item = new ItemAgilityItem(ItemID);
                    break;
            }
            agilityItem.put(ItemID, item);
            registerItems(ItemID.toString().toLowerCase(), item);
        }
        for (DefenciveItemID ItemID : DefenciveItemID.values()) {
            if (!config.enableDefenciveItem.get(ItemID))
                continue;

            Item item;

            switch (ItemID) {
                case ENCHANTERS_TOME:
                    item = new EnchantersTomeItem(ItemID);
                    break;
                case IRON_HIDE_AMULET:
                    item = new IronHideAmuletItem(ItemID);
                    break;
                case POWERSHAKER:
                    item = new PowershakerItem(ItemID);
                    break;
                //case SATCHEL_OF_ELIXIRS:
                //    item = new SatchelOfElixirsItem(ItemID);
                //    break;
                //case SATCHEL_OF_SNACKS:
                //    item = new SatchelOfSnacksItem(ItemID);
                //    break;
                case SOUL_HEALER:
                    item = new SoulHealerItem(ItemID);
                    break;
                case TOTEM_OF_REGENERATION:
                    item = new TotemOfRegenerationItem(ItemID);
                    break;
                case TOTEM_OF_SHIELDING:
                    item = new TotemOfShieldingItem(ItemID);
                    break;
                case TOTEM_OF_SOUL_PROTECTION:
                    item = new TotemOfSoulProtectionItem(ItemID);
                    break;
                case WIND_HORN:
                    item = new WindHornItem(ItemID);
                    break;
                default:
                    item = new ItemDefenciveItem(ItemID);
                    break;
            }
            defenciveItem.put(ItemID, item);
            registerItems(ItemID.toString().toLowerCase(), item);
        }

         */
    }

    protected static void registerItems(String id, Item item) {
        Registry.register(Registry.ITEM, BodyguardsMod.ID(id), item);
    }

}
