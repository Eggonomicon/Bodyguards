package dev.eggonomicon.bodyguards.item;

import dev.eggonomicon.bodyguards.BodyguardsMod;
//import dev.eggonomicon.bodyguards.config.BodyguardsConfig;
import dev.eggonomicon.bodyguards.enums.SummoningItemID;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

import static dev.eggonomicon.bodyguards.BodyguardsMod.BODYGUARDS;

public class ItemSummoningItem extends Item {

    public final SummoningItemID id;

    public ItemSummoningItem(SummoningItemID id) {
        super(new Settings().maxCount(1).group(BodyguardsMod.BODYGUARDS).maxDamage(30));
                //Bodyguards.config.getSummoningArtefactDurability()));
        this.id = id;
    }

    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }
}
