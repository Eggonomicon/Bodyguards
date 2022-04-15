package dev.eggonomicon.bodyguards.mixin;

import dev.eggonomicon.bodyguards.BodyguardsMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class BodyguardsMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		BodyguardsMod.LOGGER.info("Bodyguard Mod: BodyguardsMixin");
	}
}
