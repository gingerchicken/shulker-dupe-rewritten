package net.shulker.dupe;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;

public class ShulkerDupe implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("shulker-dupe");
	public static final MinecraftClient CLIENT = MinecraftClient.getInstance();

	public static enum DupeMode {
		DUPE_ALL,
		DUPE_SLOT0
	}

	public static Boolean performDupe = false;
	public static DupeMode mode = DupeMode.DUPE_SLOT0;

	// Perform the trolling
	public static void takeItems() {
		switch (mode) {
			case DUPE_SLOT0: {
				takeItem(0);
				
				break;
			}

			case DUPE_ALL: {
				for (int i = 0; i < 27; i++) {
					takeItem(i);
				}

				break;
			}
		}
	}

	public static void handlePacket(Packet<?> packet, CallbackInfo ci) {
		if (!ShulkerDupe.performDupe) return;
		
		if (!(packet instanceof PlayerActionC2SPacket)) return;
		PlayerActionC2SPacket actionC2SPacket = (PlayerActionC2SPacket)packet;

		if (actionC2SPacket.getAction() != PlayerActionC2SPacket.Action.STOP_DESTROY_BLOCK) return;
		
		takeItems();
	}

	public static Boolean doTick() {
		if (!ShulkerDupe.performDupe) return false;

		// Make sure we're looking at a block
		HitResult hitResult = CLIENT.crosshairTarget;
		if (!(hitResult instanceof BlockHitResult)) return false;

		BlockHitResult blockHitResult = (BlockHitResult)hitResult;
		BlockPos blockPos = blockHitResult.getBlockPos();

		// Shulkers only
		if (!(CLIENT.world.getBlockState(blockPos).getBlock() instanceof ShulkerBoxBlock)) return false;
		if (!(CLIENT.player.currentScreenHandler instanceof ShulkerBoxScreenHandler)) return false;

		// Perform action
		CLIENT.interactionManager.updateBlockBreakingProgress(blockHitResult.getBlockPos(), Direction.DOWN);

		return true;
	}

	public static void handleTick() {
		ShulkerDupe.performDupe = doTick();
	}

	// Takes an item from a given slot
	public static void takeItem(int slot) {
		if (!(CLIENT.player.currentScreenHandler instanceof ShulkerBoxScreenHandler)) return;
		ShulkerBoxScreenHandler handler = (ShulkerBoxScreenHandler)CLIENT.player.currentScreenHandler;
		ItemStack itemStack = handler.getSlot(slot).getStack();

		Int2ObjectArrayMap<ItemStack> stack = new Int2ObjectArrayMap<>();
		stack.put(slot, itemStack);

		CLIENT.getNetworkHandler().sendPacket(
			new ClickSlotC2SPacket(handler.syncId, 0, slot, 0, SlotActionType.QUICK_MOVE, itemStack, stack)
		);
	}
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}
