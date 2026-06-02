/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.block.FluidRenderer
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.world.BlockRenderView
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import clap.module.render.XrayModule;

@Mixin(value={FluidRenderer.class})
public class FluidRendererMixin {
    @Unique
    private static final ThreadLocal clap$currentOpacity = ThreadLocal.withInitial(() -> Float.valueOf(1.0f));

    @WrapOperation(method={"tesselate"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/block/LiquidBlockRenderer;isFaceOccludedByNeighbor(Lnet/minecraft/core/Direction;FLnet/minecraft/world/level/block/state/BlockState;)Z")})
    private boolean clap$xrayShouldRenderFluidFace(Direction param1, float param2, BlockState param3, Operation param4, BlockRenderView param5, BlockPos param6, VertexConsumer param7, BlockState param8, FluidState param9) {
        XrayModule v10 = XrayModule.io0O();
        if (v10 == null) {
            return (Boolean)param4.call(new Object[]{param1, Float.valueOf(param2), param3});
        }
        Boolean v11 = v10.i0ii(param8, null);
        clap$currentOpacity.set(Float.valueOf(v10.ioOo() && !v10.ioO0(param8.method_26204(), param6) ? v10.ioOI() : 1.0f));
        if (v11 != null) {
            return v11 == false;
        }
        return (Boolean)param4.call(new Object[]{param1, Float.valueOf(param2), param3});
    }

    @ModifyExpressionValue(method={"vertex"}, at={@At(value="CONSTANT", args={"floatValue=1.0"}, ordinal=0)})
    private float clap$xrayFluidOpacity(float param1) {
        return ((Float)clap$currentOpacity.get()).floatValue();
    }
}

