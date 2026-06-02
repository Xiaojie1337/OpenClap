/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package clap.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import clap.event.EventBusApi;
import clap.module.movement.KeepSprintModule;
import clap.config.ConfigSupport_ooo_2;

@Mixin(value={PlayerEntity.class})
public class PlayerKnockbackMixin {
    @Unique
    private ConfigSupport_ooo_2 clap$attackVelocityEvent;

    @Redirect(method={"causeExtraKnockback"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Player;setSprinting(Z)V"))
    private void clap$redirectAttackSprint(PlayerEntity param1, boolean param2) {
        if (this != MinecraftClient.getInstance().player) {
            param1.method_5728(param2);
            return;
        }
        KeepSprintModule v3 = KeepSprintModule.OIIo();
        if (v3 == null || !v3.IoOo() || this.clap$attackVelocityEvent == null) {
            param1.method_5728(param2);
            return;
        }
        param1.method_5728(this.clap$attackVelocityEvent.HelpCommand());
        this.clap$attackVelocityEvent = null;
    }

    @Redirect(method={"causeExtraKnockback"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Player;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
    private void clap$redirectAttackVelocity(PlayerEntity param1, Vec3d param2) {
        if (this != MinecraftClient.getInstance().player) {
            param1.method_18799(param2);
            return;
        }
        KeepSprintModule v3 = KeepSprintModule.OIIo();
        if (v3 == null || !v3.IoOo()) {
            param1.method_18799(param2);
            return;
        }
        this.clap$attackVelocityEvent = new ConfigSupport_ooo_2();
        EventBusApi.OIo.OOo(this.clap$attackVelocityEvent);
        Vec3d v4 = param1.method_18798().multiply(this.clap$attackVelocityEvent.GuiSupport_OOI(), 1.0, this.clap$attackVelocityEvent.GuiSupport_OOI());
        param1.method_18799(v4);
    }
}

