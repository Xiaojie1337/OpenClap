/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.screen.slot.SlotActionType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.movement.InventoryMoveModule;
import skidonion.loader.0ooo;

@Mixin(value={HandledScreen.class})
public class HandledScreenSlotClickMixin {
    @Inject(method={"slotClicked(Lnet/minecraft/world/inventory/Slot;IILnet/minecraft/world/inventory/ClickType;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$blockClickWhileInvMove(Slot param1, int param2, int param3, SlotActionType param4, CallbackInfo param5) {
        if (!(this instanceof InventoryScreen) || 0ooo.OoOi() == null) {
            return;
        }
        InventoryMoveModule v6 = (InventoryMoveModule)0ooo.Oo0O().oo0i(InventoryMoveModule.class);
        if (v6 != null && v6.OOOI0()) {
            param5.cancel();
        }
    }
}

