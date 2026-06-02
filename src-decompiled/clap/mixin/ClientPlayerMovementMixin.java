/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.util.math.Vec3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.event.EventBusApi;
import clap.config.ConfigSupport_O0IO;
import clap.model.EnumType_iii_0;
import clap.config.ConfigSupport_o0o_2;
import clap.config.ConfigSupport_oiio_2;
import clap.module.movement.MoveFixModule;
import skidonion.loader.0ooo;

@Mixin(value={ClientPlayerEntity.class})
public class ClientPlayerMovementMixin {
    @Unique
    private ConfigSupport_oiio_2 clap$preMovementPacketEvent;

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void tickHook(CallbackInfo param1) {
        EventBusApi.OIo.OOo(new ConfigSupport_o0o_2());
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/AbstractClientPlayer;tick()V", shift=At.Shift.BEFORE)})
    private void tickHook2(CallbackInfo param1) {
        EventBusApi.OIo.OOo(new ConfigSupport_O0IO(EnumType_iii_0.OiO));
        if (0ooo.00Io() != null) {
            0ooo.TranslateCommand().KeystrokesHudElement();
        }
    }

    @Inject(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;sendPosition()V", shift=At.Shift.AFTER)})
    private void tickHook3(CallbackInfo param1) {
        EventBusApi.OIo.OOo(new ConfigSupport_O0IO(EnumType_iii_0.Oi0));
        this.clap$preMovementPacketEvent = null;
    }

    @Inject(method={"sendPosition"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$sendPositionHead(CallbackInfo param1) {
        ClientPlayerEntity v2 = (ClientPlayerEntity)this;
        this.clap$preMovementPacketEvent = new ConfigSupport_oiio_2(v2.method_23317(), v2.method_23318(), v2.method_23321(), v2.method_36454(), v2.method_36455(), v2.method_24828(), v2.method_5624(), v2.field_5976);
        if (EventBusApi.OIo.OOo(this.clap$preMovementPacketEvent)) {
            param1.cancel();
        }
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getYRot()F"))
    private float clap$spoofYaw(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.AutoMlgModule() : param1.method_36454();
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getXRot()F"))
    private float clap$spoofPitch(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.0Io() : param1.method_36455();
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getX()D"))
    private double clap$spoofX(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.00i() : param1.method_23317();
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getY()D"))
    private double clap$spoofY(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.0o0() : param1.method_23318();
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getZ()D"))
    private double clap$spoofZ(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.0oI() : param1.method_23321();
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;position()Lnet/minecraft/world/phys/Vec3;"))
    private Vec3d clap$spoofPosition(ClientPlayerEntity param1) {
        if (this.clap$preMovementPacketEvent == null) {
            return param1.method_73189();
        }
        return new Vec3d(this.clap$preMovementPacketEvent.00i(), this.clap$preMovementPacketEvent.0o0(), this.clap$preMovementPacketEvent.0oI());
    }

    @Redirect(method={"sendPosition"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;onGround()Z"))
    private boolean clap$spoofGround(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.ChestStealerModule() : param1.method_24828();
    }

    @Redirect(method={"sendPosition"}, at=@At(value="FIELD", target="Lnet/minecraft/client/player/LocalPlayer;horizontalCollision:Z"))
    private boolean clap$spoofHorizontalCollision(ClientPlayerEntity param1) {
        return this.clap$preMovementPacketEvent != null ? this.clap$preMovementPacketEvent.KeepSprintModule() : param1.field_5976;
    }

    @Inject(method={"canStartSprinting"}, at={@At(value="RETURN")}, cancellable=true)
    private void clap$moveFixCanStartSprint(CallbackInfoReturnable param1) {
        if (0ooo.00Ii() == null) {
            return;
        }
        MoveFixModule v2 = (MoveFixModule)0ooo.00iO().oo0i(MoveFixModule.class);
        if (v2 != null && v2.OOO00() && !v2.OOO0o() && v2.OOO0I()) {
            param1.setReturnValue((Object)false);
        }
    }

    @Redirect(method={"sendIsSprintingIfNeeded"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;isSprinting()Z"))
    private boolean clap$moveFixSprintPacket(ClientPlayerEntity param1) {
        MoveFixModule v2;
        if (this.clap$preMovementPacketEvent != null) {
            return this.clap$preMovementPacketEvent.HelpCommand();
        }
        if (0ooo.StructureFinderModule() != null && (v2 = (MoveFixModule)0ooo.RenderSupport_00io_1().oo0i(MoveFixModule.class)) != null && v2.OOO00() && v2.OOO0I()) {
            return false;
        }
        return param1.method_5624();
    }
}

