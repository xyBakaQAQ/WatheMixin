package com.xybaka.wathemixin.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "dev.doctor4t.wathe.Wathe")
public abstract class WatheSupporterMixin {
	@Inject(method = "isSupporter", at = @At("HEAD"), cancellable = true)
	private static void watheMixin$allowLevelFourOp(Player player, CallbackInfoReturnable<Boolean> cir) {
		MinecraftServer server = player.getServer();
		if (server == null) {
			return;
		}

		if (server.getProfilePermissions(player.getGameProfile()) >= 4) {
			cir.setReturnValue(true);
		}
	}
}