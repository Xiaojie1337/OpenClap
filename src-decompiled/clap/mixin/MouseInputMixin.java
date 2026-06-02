/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.util.GlfwUtil
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.GlfwUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.event.EventBusApi;
import clap.config.ConfigSupport_OIII;
import clap.config.ConfigSupport_iio_2;
import clap.config.ConfigSupport_oooo_0;

@Mixin(value={Mouse.class})
public class MouseInputMixin {
    @Unique
    private double clap$lastAimAssistFrameTime = GlfwUtil.getTime();

    @Inject(method={"onButton"}, at={@At(value="HEAD")}, cancellable=true)
    private void onButton(long param1, MouseInput param3, int param4, CallbackInfo param5) {
        if (param4 == 0) {
            EventBusApi.OIo.OOo(new ConfigSupport_iio_2(param3.button(), param4));
            return;
        }
        if (EventBusApi.OIo.OOo(new ConfigSupport_iio_2(param3.button(), param4))) {
            param5.cancel();
        }
    }

    @Inject(method={"onScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void onScroll(long param1, double param3, double param5, CallbackInfo param7) {
        if (EventBusApi.OIo.OOo(new ConfigSupport_oooo_0(param3, param5))) {
            param7.cancel();
        }
    }

    @Inject(method={"turnPlayer"}, at={@At(value="TAIL")})
    private void clap$aimAssistTurnPlayer(double param1, CallbackInfo param3) {
        double v4 = GlfwUtil.getTime();
        float v6 = (float)Math.min(v4 - this.clap$lastAimAssistFrameTime, 0.1);
        this.clap$lastAimAssistFrameTime = v4;
        MinecraftClient v7 = MinecraftClient.getInstance();
        float v8 = v7.getRenderTickCounter().getTickProgress(true);
        EventBusApi.OIo.OOo(new ConfigSupport_OIII(v6, v8));
    }
}

