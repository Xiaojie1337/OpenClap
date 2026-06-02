/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.render.NoHurtCamModule;

@Mixin(value={GameRenderer.class})
public class GameRendererHurtBobMixin {
    @Inject(method={"bobHurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$noHurtCam(MatrixStack param1, float param2, CallbackInfo param3) {
        NoHurtCamModule v4 = NoHurtCamModule.oIio();
        if (v4 != null && v4.IoOo()) {
            param3.cancel();
        }
    }
}

