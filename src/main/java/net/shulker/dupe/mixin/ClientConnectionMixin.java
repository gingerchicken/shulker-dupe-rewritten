package net.shulker.dupe.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.shulker.dupe.ShulkerDupe;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
	@Inject(at = @At("TAIL"), method = "send(Lnet/minecraft/network/Packet;Lio/netty/util/concurrent/GenericFutureListener;)V", cancellable = true)
    public void send(Packet<?> packet, GenericFutureListener<? extends Future<? super Void>> callback, CallbackInfo ci) {
		ShulkerDupe.handlePacket(packet, ci);
	}
}
