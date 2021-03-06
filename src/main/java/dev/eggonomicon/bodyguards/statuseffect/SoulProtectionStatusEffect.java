package dev.eggonomicon.bodyguards.statuseffect;

import dev.eggonomicon.bodyguards.BodyguardsMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoulProtectionStatusEffect extends StatusEffect {

    public SoulProtectionStatusEffect(StatusEffectCategory type, int color, String id) {
        super(type, color);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(BodyguardsMod.MOD_ID, id), this);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }
}
