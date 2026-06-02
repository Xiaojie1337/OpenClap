/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.player.AutoMlgModule;
import clap.module.combat.KbDelayModule;
import clap.event.EventBusApi;
import clap.module.player.AutoCollectWaterModule;
import clap.module.combat.TriggerbotModule;
import clap.config.ConfigSupport_oiii_4;
import clap.module.player.WaterBucketModule;
import clap.module.player.ExtinguisherModule;
import clap.config.ConfigSupport_oooo_3;
import skidonion.loader.0ooo;

@Mixin(value={MinecraftClient.class})
public class MinecraftClientInputMixin {
    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void clap$lagManagerTick(CallbackInfo param1) {
        ConfigSupport_oiii_4.SpawnerFinderModule();
    }

    @Inject(method={"startAttack"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$cancelGodProtectedAttack(CallbackInfoReturnable param1) {
        MinecraftClient v2 = (MinecraftClient)this;
        if (0ooo.ClickGuiScreenV2() == null || v2.crosshairTarget == null || v2.crosshairTarget.getType() != HitResult.Type.ENTITY) {
            return;
        }
        EntityHitResult v3 = (EntityHitResult)v2.crosshairTarget;
        Entity v4 = v3.getEntity();
        if (v4 instanceof PlayerEntity) {
            PlayerEntity v5 = (PlayerEntity)v4;
            if (0ooo.NetworkSupport_0oio_1().iIoO(v5)) {
                param1.setReturnValue((Object)false);
            }
        }
    }

    @Inject(method={"startAttack"}, at={@At(value="RETURN")})
    private void clap$trackAttack(CallbackInfoReturnable param1) {
        if (0ooo.0OiI() == null) {
            return;
        }
        MinecraftClient v2 = (MinecraftClient)this;
        if (v2.crosshairTarget == null || v2.crosshairTarget.getType() != HitResult.Type.ENTITY) {
            return;
        }
        EntityHitResult v3 = (EntityHitResult)v2.crosshairTarget;
        if (!(v3.getEntity() instanceof PlayerEntity)) {
            return;
        }
        KbDelayModule v4 = (KbDelayModule)0ooo.0Oii().oo0i(KbDelayModule.class);
        if (v4 != null) {
            v4.O0o00();
        }
    }

    @Inject(method={"handleKeybinds"}, at={@At(value="TAIL")})
    private void clap$moduleHandleKeybinds(CallbackInfo param1) {
        TriggerbotModule v5;
        ExtinguisherModule v4;
        AutoMlgModule v3;
        if (0ooo.DataRecord_00OO() == null) {
            return;
        }
        AutoCollectWaterModule v2 = (AutoCollectWaterModule)0ooo.ConfigSupport_00O0().oo0i(AutoCollectWaterModule.class);
        if (v2 != null && v2.IoOo()) {
            v2.OOii();
        }
        if ((v3 = (AutoMlgModule)0ooo.00Oo().oo0i(AutoMlgModule.class)) != null && v3.IoOo()) {
            v3.OOii();
        }
        if ((v4 = (ExtinguisherModule)0ooo.NetworkSupport_00OI().oo0i(ExtinguisherModule.class)) != null && v4.IoOo()) {
            v4.OOii();
        }
        if ((v5 = (TriggerbotModule)0ooo.00Oi().oo0i(TriggerbotModule.class)) != null && v5.IoOo()) {
            v5.MoveFixModule();
        }
    }

    @Inject(method={"handleKeybinds"}, at={@At(value="HEAD")})
    private void clap$autoCollectWaterHandleKeybinds(CallbackInfo param1) {
        ExtinguisherModule v4;
        AutoMlgModule v3;
        if (0ooo.NetworkSupport_000O() == null) {
            return;
        }
        AutoCollectWaterModule v2 = (AutoCollectWaterModule)0ooo.EnumType_0000().oo0i(AutoCollectWaterModule.class);
        if (v2 != null && v2.IoOo()) {
            v2.MoveFixModule();
        }
        if ((v3 = (AutoMlgModule)0ooo.000o().oo0i(AutoMlgModule.class)) != null && v3.IoOo()) {
            v3.MoveFixModule();
        }
        if ((v4 = (ExtinguisherModule)0ooo.RenderSupport_000I().oo0i(ExtinguisherModule.class)) != null && v4.IoOo()) {
            v4.MoveFixModule();
        }
    }

    @Inject(method={"continueAttack"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$cancelBlockBreakingDuringTriggerbot(boolean param1, CallbackInfo param2) {
        if (!param1 || 0ooo.000i() == null) {
            return;
        }
        TriggerbotModule v3 = (TriggerbotModule)0ooo.BindCommand().oo0i(TriggerbotModule.class);
        if (v3 != null && v3.oOIi()) {
            param2.cancel();
        }
    }

    @Inject(method={"startUseItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$startUseItemEvent(CallbackInfo param1) {
        if (EventBusApi.OIo.OOo(new ConfigSupport_oooo_3())) {
            param1.cancel();
        }
    }

    @WrapOperation(method={"startUseItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;useItemOn(Lnet/minecraft/client/player/LocalPlayer;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;")})
    private ActionResult clap$passOffhandBlockUseDuringWaterBucketRecycle(ClientPlayerInteractionManager param1, ClientPlayerEntity param2, Hand param3, BlockHitResult param4, Operation param5) {
        WaterBucketModule v6 = WaterBucketModule.IOo();
        if (param3 == Hand.OFF_HAND && v6 != null && v6.SprintModule()) {
            return ActionResult.PASS;
        }
        return (ActionResult)param5.call(new Object[]{param1, param2, param3, param4});
    }
}

