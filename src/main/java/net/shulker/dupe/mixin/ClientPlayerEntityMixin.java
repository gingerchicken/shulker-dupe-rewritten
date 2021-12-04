package net.shulker.dupe.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.shulker.dupe.ShulkerDupe;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void tick(CallbackInfo ci) {
        ShulkerDupe.handleTick();
    }
}
