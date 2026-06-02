/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Keyboard
 *  net.minecraft.client.input.KeyInput
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.Keyboard;
import net.minecraft.client.input.KeyInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.event.EventBusApi;
import clap.config.ConfigSupport_iio_0;
import clap.config.ConfigSupport_oioi_5;

@Mixin(value={Keyboard.class})
public class KeyboardMixin {
    @Inject(method={"keyPress"}, at={@At(value="TAIL")}, cancellable=true)
    private void keyPress(long param1, int param3, KeyInput param4, CallbackInfo param5) {
        EventBusApi.OIo.OOo(new ConfigSupport_iio_0(param4.key(), param4.scancode(), param4.comp_4797(), param3));
        if (param3 != 1) {
            if (param3 == 0) {
                EventBusApi.OIo.OOo(new ConfigSupport_oioi_5(param4.key(), param3));
            }
            return;
        }
        if (EventBusApi.OIo.OOo(new ConfigSupport_oioi_5(param4.key(), param3))) {
            param5.cancel();
        }
    }
}

