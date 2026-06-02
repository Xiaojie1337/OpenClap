/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.entity.LivingEntityRenderer
 *  net.minecraft.client.render.entity.state.LivingEntityRenderState
 *  net.minecraft.entity.LivingEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.render.RotationModule;

@Mixin(value={LivingEntityRenderer.class})
public abstract class LivingEntityRendererRotationMixin {
    @Inject(method={"extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V"}, at={@At(value="HEAD")})
    private void clap$beginLocalRotationRenderPass(LivingEntity param1, LivingEntityRenderState param2, float param3, CallbackInfo param4) {
        RotationModule v5 = RotationModule.OOoIo();
        if (param1 == MinecraftClient.getInstance().player && v5 != null) {
            v5.OOoo0();
        }
    }

    @Redirect(method={"extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/LivingEntity;getXRot(F)F"))
    private float clap$smoothLocalPlayerHeadPitch(LivingEntity param1, float param2) {
        RotationModule v3 = RotationModule.OOoIo();
        if (param1 == MinecraftClient.getInstance().player && v3 != null && v3.OOo0i()) {
            return v3.OOooI(param2);
        }
        return param1.method_61414(param2);
    }

    @ModifyExpressionValue(method={"extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/util/Mth;rotLerp(FFF)F", ordinal=0)})
    private float clap$smoothLocalPlayerHeadYaw(float param1, LivingEntity param2, LivingEntityRenderState param3, float param4) {
        RotationModule v5 = RotationModule.OOoIo();
        if (param2 == MinecraftClient.getInstance().player && v5 != null && v5.OOo0i()) {
            return v5.OOooo(param4);
        }
        return param1;
    }

    @Inject(method={"extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V"}, at={@At(value="TAIL")})
    private void clap$applyLocalPlayerBodyRotation(LivingEntity param1, LivingEntityRenderState param2, float param3, CallbackInfo param4) {
        float v6;
        RotationModule v5 = RotationModule.OOoIo();
        if (param1 != MinecraftClient.getInstance().player || v5 == null || !v5.OOooO()) {
            return;
        }
        param2.bodyYaw = v6 = v5.OOoIO(param3);
        param2.relativeHeadYaw = v5.OOoI0(v6, param3);
    }
}

