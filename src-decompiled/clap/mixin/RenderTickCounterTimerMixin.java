/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.RenderTickCounter$Dynamic
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.core.NativeEntrypointBridge;

@Mixin(value={RenderTickCounter.Dynamic.class})
public class RenderTickCounterTimerMixin {
    @Shadow
    private float field_51958;

    @Inject(method={"advanceGameTime(J)I"}, at={@At(value="FIELD", target="Lnet/minecraft/client/DeltaTracker$Timer;lastMs:J", opcode=181)})
    public void advanceGameTime(long param1, CallbackInfoReturnable param3) {
        this.field_51958 *= NativeEntrypointBridge.PacketEvent;
    }
}

