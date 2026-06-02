/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.block.BlockState
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.world.BlockView
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.XrayModule;

@Pseudo
@Mixin(targets={"net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.DefaultFluidRenderer"}, remap=false)
public class SodiumFluidRendererMixin {
    @Inject(method={"isFullBlockFluidSideVisible(Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_2350;Lnet/minecraft/class_3610;)Z"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void clap$xrayFullBlockFluidSideVisible(BlockView param1, BlockPos param2, Direction param3, FluidState param4, CallbackInfoReturnable param5) {
        XrayModule v6 = XrayModule.io0O();
        if (v6 == null) {
            return;
        }
        Boolean v7 = v6.i0ii(param4.getBlockState(), null);
        if (v7 == null) {
            return;
        }
        BlockState v8 = param1.getBlockState(param2.add(param3.getVector()));
        param5.setReturnValue((Object)(!v8.method_26227().getFluid().matchesType(param4.getFluid()) && v7 != false ? 1 : 0));
    }

    @Inject(method={"isFluidSideExposed(Lnet/minecraft/class_1920;Lnet/minecraft/class_2680;Lnet/minecraft/class_2338;Lnet/minecraft/class_2350;F)Z"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void clap$xrayFluidSideExposed(BlockRenderView param1, BlockState param2, BlockPos param3, Direction param4, float param5, CallbackInfoReturnable param6) {
        XrayModule v7 = XrayModule.io0O();
        if (v7 == null) {
            return;
        }
        Boolean v8 = v7.i0ii(param2, null);
        if (v8 == null) {
            return;
        }
        BlockState v9 = param1.method_8320(param3);
        param6.setReturnValue((Object)(!v9.method_26227().getFluid().matchesType(param2.method_26227().getFluid()) && v8 != false ? 1 : 0));
    }

    @Inject(method={"getUpFaceExposureByNeighbors(Lnet/minecraft/class_1920;Lnet/minecraft/class_2338;Lnet/minecraft/class_3610;)I"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void clap$xrayUpFaceExposure(BlockRenderView param1, BlockPos param2, FluidState param3, CallbackInfoReturnable param4) {
        XrayModule v5 = XrayModule.io0O();
        if (v5 == null) {
            return;
        }
        Boolean v6 = v5.i0ii(param3.getBlockState(), null);
        if (v6 != null) {
            param4.setReturnValue((Object)(v6 != false ? 3 : 0));
        }
    }

    @ModifyExpressionValue(method={"updateQuad"}, at={@At(value="INVOKE", target="Lnet/caffeinemc/mods/sodium/api/util/ColorARGB;toABGR(I)I")}, require=0)
    private int clap$xrayFluidOpacity(int param1, @Local(argsOnly=true) BlockPos param2, @Local(argsOnly=true) FluidState param3) {
        XrayModule v4 = XrayModule.io0O();
        if (v4 == null || !v4.ioOo() || v4.ioO0(param3.getBlockState().method_26204(), param2)) {
            return param1;
        }
        return param1 & v4.ioOi();
    }
}

