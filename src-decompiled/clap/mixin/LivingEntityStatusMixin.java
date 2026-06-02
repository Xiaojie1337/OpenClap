/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.registry.entry.RegistryEntry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.NoDebuffModule;
import clap.module.movement.MoveFixModule;
import skidonion.loader.0ooo;

@Mixin(value={LivingEntity.class})
public class LivingEntityStatusMixin {
    @Unique
    private boolean clap$restoreJumpYaw;
    @Unique
    private float clap$preJumpYaw;

    @Inject(method={"hasEffect"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$noDebuffHasEffect(RegistryEntry param1, CallbackInfoReturnable param2) {
        if (this.clap$shouldHideEffect(param1)) {
            param2.setReturnValue((Object)false);
        }
    }

    @Inject(method={"getEffect"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$noDebuffGetEffect(RegistryEntry param1, CallbackInfoReturnable param2) {
        if (this.clap$shouldHideEffect(param1)) {
            param2.setReturnValue(null);
        }
    }

    private boolean clap$shouldHideEffect(RegistryEntry param1) {
        MinecraftClient v2 = MinecraftClient.getInstance();
        NoDebuffModule v3 = NoDebuffModule.i00i();
        return v2.player != null && this == v2.player && v3 != null && v3.i00I(param1);
    }

    @Inject(method={"jumpFromGround"}, at={@At(value="HEAD")})
    private void clap$moveFixJumpYawPre(CallbackInfo param1) {
        ClientPlayerEntity v4;
        MinecraftClient v2 = MinecraftClient.getInstance();
        Object v3 = v2.player;
        if (!(v3 instanceof ClientPlayerEntity) || this != (v4 = v3) || 0ooo.RenderSupport_0OO0() == null || !0ooo.0OOo().Oii() || 0ooo.DataRecord_0OOI() == null) {
            this.clap$restoreJumpYaw = false;
            return;
        }
        v3 = (MoveFixModule)0ooo.0OOi().oo0i(MoveFixModule.class);
        if (v3 == null || !((MoveFixModule)v3).OOO0O()) {
            this.clap$restoreJumpYaw = false;
            return;
        }
        this.clap$preJumpYaw = v4.method_36454();
        this.clap$restoreJumpYaw = true;
        v4.method_36456(0ooo.ConfigSupport_0O0O().ConfigSupport_OI0());
    }

    @Inject(method={"jumpFromGround"}, at={@At(value="TAIL")})
    private void clap$moveFixJumpYawPost(CallbackInfo param1) {
        if (!this.clap$restoreJumpYaw) {
            return;
        }
        MinecraftClient v2 = MinecraftClient.getInstance();
        if (this == v2.player) {
            v2.player.method_36456(this.clap$preJumpYaw);
        }
        this.clap$restoreJumpYaw = false;
    }
}

