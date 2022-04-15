package dev.eggonomicon.bodyguards.item;

//import chronosacaria.mcdar.api.CleanlinessHelper;

import dev.eggonomicon.bodyguards.api.CleanlinessHelper;
import dev.eggonomicon.bodyguards.enums.SummoningItemID;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;


import static dev.eggonomicon.bodyguards.api.SummoningHelper.summonGolemKitGolem;

public class GolemKitItem extends ItemSummoningItem{
    public GolemKitItem(SummoningItemID ItemID) {
        super(ItemID);
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        World world = itemUsageContext.getWorld();

        if (world.isClient){
            return ActionResult.SUCCESS;
        } else {
            PlayerEntity itemUsageContextPlayer = itemUsageContext.getPlayer();

            if (itemUsageContextPlayer != null){

                summonGolemKitGolem(itemUsageContextPlayer, itemUsageContext.getBlockPos());

                if (!itemUsageContextPlayer.isCreative()){
                    itemUsageContext.getStack().damage(1, itemUsageContextPlayer,
                            (entity) -> entity.sendToolBreakStatus(itemUsageContext.getHand()));
                }
                CleanlinessHelper.cooldownHelper(itemUsageContextPlayer, this, 600);
            }
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext){
        tooltip.add(new TranslatableText("tooltip_info_item.mcdar.golem_kit_1").formatted(Formatting.ITALIC));
        tooltip.add(new TranslatableText("tooltip_info_item.mcdar.golem_kit_2").formatted(Formatting.ITALIC));
        tooltip.add(new TranslatableText("tooltip_info_item.mcdar.golem_kit_3").formatted(Formatting.ITALIC));
        tooltip.add(new TranslatableText("tooltip_info_item.mcdar.golem_kit_4").formatted(Formatting.ITALIC));
    }
}
