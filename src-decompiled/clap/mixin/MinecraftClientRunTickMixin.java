/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.client.streamproof.StreamproofLogger;

@Mixin(value={MinecraftClient.class})
public class MinecraftClientRunTickMixin {
    @Inject(method={"runTick"}, at={@At(value="HEAD")})
    private void clap$streamproofBeginFrame(boolean param1, CallbackInfo param2) {
        StreamproofLogger.GuiSupport_OOI();
    }

    @Inject(method={"resizeDisplay"}, at={@At(value="TAIL")})
    private void clap$streamproofResize(CallbackInfo param1) {
        StreamproofLogger.OOi();
    }
}

