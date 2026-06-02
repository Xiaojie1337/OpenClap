/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.render.item.HeldItemRenderer
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.consume.UseAction
 *  net.minecraft.util.Arm
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RotationAxis
 *  org.joml.Quaternionfc
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.Slice
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.UseAction;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.combat.KillAuraModule;
import skidonion.loader.0ooo;

@Mixin(value={HeldItemRenderer.class})
public class HeldItemRendererMixin {
    @Redirect(method={"renderHandsWithItems"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getXRot(F)F"))
    private float clap$redirectHandPitch(ClientPlayerEntity param1, float param2) {
        if (0ooo.iio() != null) {
            return 0ooo.iiI().Oi0(param1.method_61414(param2));
        }
        return param1.method_61414(param2);
    }

    @Redirect(method={"renderHandsWithItems"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getViewXRot(F)F"))
    private float clap$redirectHandViewPitch(ClientPlayerEntity param1, float param2) {
        if (0ooo.iii() != null) {
            return 0ooo.Module().Oi0(param1.method_5695(param2));
        }
        return param1.method_5695(param2);
    }

    @Redirect(method={"renderHandsWithItems"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/LocalPlayer;getViewYRot(F)F"))
    private float clap$redirectHandViewYaw(ClientPlayerEntity param1, float param2) {
        if (0ooo.EnumType_OOO0() != null) {
            return 0ooo.OOOo().OiO(param1.method_5705(param2));
        }
        return param1.method_5705(param2);
    }

    @Redirect(method={"renderHandsWithItems"}, at=@At(value="FIELD", target="Lnet/minecraft/client/player/LocalPlayer;xBobO:F"))
    private float clap$redirectPreviousHandPitchBob(ClientPlayerEntity param1) {
        if (0ooo.PostProcessingModule() != null) {
            return 0ooo.OOOi().Oi0(param1.lastRenderPitch);
        }
        return param1.lastRenderPitch;
    }

    @Redirect(method={"renderHandsWithItems"}, at=@At(value="FIELD", target="Lnet/minecraft/client/player/LocalPlayer;xBob:F"))
    private float clap$redirectHandPitchBob(ClientPlayerEntity param1) {
        if (0ooo.DataRecord_OO0O() != null) {
            return 0ooo.NetworkSupport_OO00().Oi0(param1.renderPitch);
        }
        return param1.renderPitch;
    }

    @Redirect(method={"renderHandsWithItems"}, at=@At(value="FIELD", target="Lnet/minecraft/client/player/LocalPlayer;yBobO:F"))
    private float clap$redirectPreviousHandYawBob(ClientPlayerEntity param1) {
        if (0ooo.OO0o() != null) {
            return 0ooo.FontRenderer().OiO(param1.lastRenderYaw);
        }
        return param1.lastRenderYaw;
    }

    @Redirect(method={"renderHandsWithItems"}, at=@At(value="FIELD", target="Lnet/minecraft/client/player/LocalPlayer;yBob:F"))
    private float clap$redirectHandYawBob(ClientPlayerEntity param1) {
        if (0ooo.OO0i() != null) {
            return 0ooo.OOoO().OiO(param1.renderYaw);
        }
        return param1.renderYaw;
    }

    @ModifyExpressionValue(method={"renderArmWithItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/AbstractClientPlayer;isUsingItem()Z", ordinal=1)})
    private boolean clap$fakeBlockUsingItem(boolean param1) {
        return param1 || KillAuraModule.II0I();
    }

    @ModifyExpressionValue(method={"renderArmWithItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/AbstractClientPlayer;getUsedItemHand()Lnet/minecraft/world/InteractionHand;", ordinal=1)})
    private Hand clap$fakeBlockUsedHand(Hand param1) {
        return KillAuraModule.II0I() ? Hand.MAIN_HAND : param1;
    }

    @ModifyExpressionValue(method={"renderArmWithItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/player/AbstractClientPlayer;getUseItemRemainingTicks()I", ordinal=2)})
    private int clap$fakeBlockUseTicks(int param1) {
        return KillAuraModule.II0I() ? 7200 : param1;
    }

    @ModifyExpressionValue(method={"renderArmWithItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/item/ItemStack;getUseAnimation()Lnet/minecraft/world/item/ItemUseAnimation;", ordinal=0)})
    private UseAction clap$fakeBlockUseAnimation(UseAction param1) {
        return KillAuraModule.II0I() ? UseAction.BLOCK : param1;
    }

    @ModifyArg(method={"renderArmWithItem"}, slice=@Slice(from=@At(value="INVOKE", target="Lnet/minecraft/world/item/ItemStack;getUseAnimation()Lnet/minecraft/world/item/ItemUseAnimation;")), at=@At(value="INVOKE", target="Lnet/minecraft/client/renderer/ItemInHandRenderer;applyItemArmTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V", ordinal=0), index=2)
    private float clap$fakeBlockIgnoreBlockingEquipOffset(float param1) {
        return KillAuraModule.II0I() ? 0.0f : param1;
    }

    @Inject(method={"renderArmWithItem"}, slice={@Slice(from=@At(value="INVOKE", target="Lnet/minecraft/world/item/ItemStack;getUseAnimation()Lnet/minecraft/world/item/ItemUseAnimation;"))}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/ItemInHandRenderer;applyItemArmTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V", ordinal=0, shift=At.Shift.AFTER)})
    private void clap$fakeBlockOneSeven(AbstractClientPlayerEntity param1, float param2, float param3, Hand param4, float param5, ItemStack param6, float param7, MatrixStack param8, OrderedRenderCommandQueue param9, int param10, CallbackInfo param11) {
        if (param4 == Hand.MAIN_HAND && KillAuraModule.II0I()) {
            Arm v12 = param4 == Hand.MAIN_HAND ? param1.method_6068() : param1.method_6068().getOpposite();
            HeldItemRendererMixin.applyOneSevenBlockTransform(param8, v12, param5);
        }
    }

    private static void applyOneSevenBlockTransform(MatrixStack param0, Arm param1, float param2) {
        param0.translate(param1 == Arm.RIGHT ? -0.1f : 0.1f, 0.1f, 0.0f);
        HeldItemRendererMixin.applySwingOffset(param0, param1, param2 * 0.9f);
    }

    private static void applySwingOffset(MatrixStack param0, Arm param1, float param2) {
        int v3 = param1 == Arm.RIGHT ? 1 : -1;
        float v4 = MathHelper.sin((double)(param2 * param2 * (float)Math.PI));
        param0.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees((float)v3 * (45.0f + v4 * -20.0f)));
        float v5 = MathHelper.sin((double)(MathHelper.sqrt((float)param2) * (float)Math.PI));
        param0.multiply((Quaternionfc)RotationAxis.POSITIVE_Z.rotationDegrees((float)v3 * v5 * -20.0f));
        param0.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(v5 * -80.0f));
        param0.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees((float)v3 * -45.0f));
    }
}

