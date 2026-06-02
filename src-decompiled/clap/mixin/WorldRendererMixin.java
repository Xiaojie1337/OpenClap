/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.VertexConsumerProvider$Immediate
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.client.util.ObjectAllocator
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.util.profiler.Profiler
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 *  org.joml.Vector4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.profiler.Profiler;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.event.EventBusApi;
import clap.module.render.CameraClipModule;
import clap.render.RenderSupport_0ooi_1;
import clap.config.ConfigSupport_oi0_1;
import clap.render.RenderSupport_oiio_4;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={WorldRenderer.class})
public class WorldRendererMixin {
    @Redirect(method={"renderLevel"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;isSpectator()Z"))
    private boolean clap$useCameraClipClearView(ClientPlayerEntity param1) {
        CameraClipModule v2 = CameraClipModule.OOiOo();
        return param1.method_7325() || v2 != null && v2.OOiO0();
    }

    @Inject(method={"renderBlockOutline"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderBlockOutline(VertexConsumerProvider.Immediate param1, MatrixStack param2, boolean param3, WorldRenderState param4, CallbackInfo param5) {
        if (EventBusApi.OIo.OOo(new ConfigSupport_oi0_1())) {
            param5.cancel();
        }
    }

    @Inject(method={"renderLevel"}, at={@At(value="RETURN")})
    private void render(ObjectAllocator param1, RenderTickCounter param2, boolean param3, Camera param4, Matrix4f param5, Matrix4f param6, Matrix4f param7, GpuBufferSlice param8, Vector4f param9, boolean param10, CallbackInfo param11, @Local Profiler param12) {
        MatrixStack v13 = new MatrixStack();
        v13.push();
        v13.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(EventBusApi.ConfigSupport_OI0.gameRenderer.getCamera().getPitch()));
        v13.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(EventBusApi.ConfigSupport_OI0.gameRenderer.getCamera().getYaw() + 180.0f));
        param12.push("clap-render-3d");
        RenderSupport_oiio_4.O0OIo(param7, param5);
        RenderSupport_oooo_2.beginImmediate("CLAP_RENDER_3D");
        RenderSupport_0ooi_1 v14 = new RenderSupport_0ooi_1(v13, param2.getTickProgress(true));
        try {
            EventBusApi.OIo.OOo(v14);
            return;
        }
        finally {
            RenderSupport_oooo_2.endImmediate("CLAP_RENDER_3D");
            v13.pop();
            param12.pop();
        }
    }
}

