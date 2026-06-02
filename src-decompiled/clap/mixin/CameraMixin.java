/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.Camera
 *  net.minecraft.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.CameraClipModule;
import skidonion.loader.0ooo;

@Mixin(value={Camera.class})
public class CameraMixin {
    @Redirect(method={"setup"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getViewYRot(F)F"))
    private float clap$redirectCameraYaw(Entity param1, float param2) {
        if (0ooo.Oiio() != null) {
            return 0ooo.OiiI().OiO(param1.getYaw(param2));
        }
        return param1.getYaw(param2);
    }

    @Redirect(method={"setup"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getViewXRot(F)F"))
    private float clap$redirectCameraPitch(Entity param1, float param2) {
        if (0ooo.Oiii() != null) {
            return 0ooo.ConfigSupport_0OOO().Oi0(param1.getPitch(param2));
        }
        return param1.getPitch(param2);
    }

    @ModifyArg(method={"setup"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/Camera;getMaxZoom(F)F"), index=0)
    private float clap$modifyCameraDistance(float param1) {
        CameraClipModule v2 = CameraClipModule.OOiOo();
        if (v2 != null && v2.IoOo()) {
            return v2.OOiOO();
        }
        return param1;
    }

    @Inject(method={"getMaxZoom"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$cameraClip(float param1, CallbackInfoReturnable param2) {
        CameraClipModule v3 = CameraClipModule.OOiOo();
        if (v3 != null && v3.IoOo()) {
            param2.setReturnValue((Object)Float.valueOf(param1));
        }
    }
}

