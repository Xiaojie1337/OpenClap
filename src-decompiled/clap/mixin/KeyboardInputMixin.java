/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.client.input.Input
 *  net.minecraft.client.input.KeyboardInput
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.util.PlayerInput
 *  net.minecraft.util.math.Vec2f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.Vec2f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.event.EventBusApi;
import clap.config.ConfigSupport_oio_5;
import clap.module.movement.InventoryMoveModule;
import skidonion.loader.0ooo;

@Mixin(value={KeyboardInput.class})
public abstract class KeyboardInputMixin
extends Input {
    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void clap$applyInvMoveSprintState(CallbackInfo param1) {
        InventoryMoveModule v2;
        InventoryMoveModule ooii_42 = v2 = 0ooo.OIoo() != null ? (InventoryMoveModule)0ooo.OIoI().oo0i(InventoryMoveModule.class) : null;
        if (v2 != null) {
            v2.OOOoi();
        }
    }

    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/KeyMapping;isDown()Z")})
    private boolean clap$hookInvMove(KeyBinding param1, Operation param2) {
        boolean v3 = (Boolean)param2.call(new Object[]{param1});
        if (v3 || 0ooo.OIoi() == null) {
            return v3;
        }
        InventoryMoveModule v4 = (InventoryMoveModule)0ooo.RenderSupport_OIIO().oo0i(InventoryMoveModule.class);
        return v4 != null && v4.OOOoI(param1) && v4.OOOIO(param1);
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void clap$callMoveInputEvent(CallbackInfo param1) {
        Vec2f v3;
        if (EventBusApi.ConfigSupport_OI0.player == null) {
            return;
        }
        ConfigSupport_oio_5 v2 = new ConfigSupport_oio_5(KeyboardInputMixin.getMovementMultiplier(this.field_54155.forward(), this.field_54155.backward()), KeyboardInputMixin.getMovementMultiplier(this.field_54155.left(), this.field_54155.right()), this.field_54155.jump(), this.field_54155.sneak());
        EventBusApi.OIo.OOo(v2);
        this.field_54155 = new PlayerInput(KeyboardInputMixin.getKeyStateFromValue(v2.OoO()), KeyboardInputMixin.getKeyStateFromValue(-v2.OoO()), KeyboardInputMixin.getKeyStateFromValue(v2.Ooo()), KeyboardInputMixin.getKeyStateFromValue(-v2.Ooo()), v2.Ooi(), v2.ConfigSupport_OI0(), KeyboardInputMixin.getSprint(this.field_54155.sprint(), v2.OoO(), v2.ConfigSupport_OI0()));
        this.field_55868 = v3 = new Vec2f(v2.Ooo(), v2.OoO()).normalize();
    }

    @Unique
    private static float getMovementMultiplier(boolean param0, boolean param1) {
        if (param0 == param1) {
            return 0.0f;
        }
        return param0 ? 1.0f : -1.0f;
    }

    @Unique
    private static boolean getKeyStateFromValue(float param0) {
        return param0 > 0.0f;
    }

    @Unique
    private static boolean getSprint(boolean param0, float param1, boolean param2) {
        return param0 && param1 > 0.0f && !param2;
    }
}

