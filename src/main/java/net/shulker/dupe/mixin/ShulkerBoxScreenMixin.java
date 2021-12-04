package net.shulker.dupe.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.shulker.dupe.ShulkerDupe;

@Mixin(ShulkerBoxScreen.class)
public class ShulkerBoxScreenMixin extends Screen {
    protected ShulkerBoxScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("TAIL"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;IIF)V")
    public void renderScreen(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        int totalButtons = 2;
        double width = 50;
        double height = 20;

        double x = ShulkerDupe.CLIENT.getWindow().getScaledWidth() / 2 - (totalButtons - 1)*width;
        double y = 32/ShulkerDupe.CLIENT.getWindow().getScaleFactor();

        this.addDrawableChild(new ButtonWidget((int)x, (int)y, (int)width, (int)height, Text.of("Dupe"), (button) -> {
            ShulkerDupe.mode = ShulkerDupe.DupeMode.DUPE_SLOT0;
            ShulkerDupe.performDupe = true;
        }));

        x += width;

        this.addDrawableChild(new ButtonWidget((int)x, (int)y, (int)width, (int)height, Text.of("Dupe All"), (button) -> {
            ShulkerDupe.mode = ShulkerDupe.DupeMode.DUPE_ALL;
            ShulkerDupe.performDupe = true;
        }));

    }
}
