/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.mixin.LivingEntityAccessor;
import clap.module.movement.NoJumpDelayModule;

@Mixin(value={ClientPlayerEntity.class})
public class ClientPlayerTickMixin {
    @Inject(method={"aiStep"}, at={@At(value="TAIL")})
    private void clap$removeJumpDelay(CallbackInfo param1) {
        NoJumpDelayModule v2 = NoJumpDelayModule.O0oOo();
        if (v2 != null && v2.IoOo()) {
            ((LivingEntityAccessor)((Object)this)).clap$setNoJumpDelay(0);
        }
    }
}

