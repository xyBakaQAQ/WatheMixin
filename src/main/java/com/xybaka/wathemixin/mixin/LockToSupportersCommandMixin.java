package com.xybaka.wathemixin.mixin;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "dev.doctor4t.wathe.command.LockToSupportersCommand")
public abstract class LockToSupportersCommandMixin {
	@Inject(method = "lambda$register$0", at = @At("HEAD"), cancellable = true)
	private static void watheMixin$allowLevelFourOp(CommandSourceStack source, CallbackInfoReturnable<Boolean> cir) {
		ServerPlayer player = source.getPlayer();
		if (player == null) {
			return;
		}

		MinecraftServer server = player.getServer();
		if (server == null) {
			return;
		}

		if (server.getProfilePermissions(player.getGameProfile()) >= 4) {
			cir.setReturnValue(true);
		}
	}
}