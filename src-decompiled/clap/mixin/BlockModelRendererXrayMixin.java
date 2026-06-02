/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.render.block.BlockModelRenderer
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
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import clap.module.render.XrayModule;

@Mixin(value={BlockModelRenderer.class})
public class BlockModelRendererXrayMixin {
    @Unique
    private static final ThreadLocal clap$currentOpacity = ThreadLocal.withInitial(() -> Float.valueOf(1.0f));

    @WrapOperation(method={"shouldRenderFace"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/block/Block;shouldRenderFace(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z")})
    private static boolean clap$xrayShouldRenderFace(BlockState param0, BlockState param1, Direction param2, Operation param3, BlockRenderView param4, BlockState param5, boolean param6, Direction param7, BlockPos param8) {
        XrayModule v9 = XrayModule.io0O();
        if (v9 == null) {
            return (Boolean)param3.call(new Object[]{param0, param1, param2});
        }
        BlockPos v10 = param8.offset(param2.getOpposite());
        Boolean v11 = v9.i0ii(param0, v10);
        clap$currentOpacity.set(Float.valueOf(v9.ioOo() && !v9.ioO0(param0.method_26204(), v10) ? v9.ioOI() : 1.0f));
        if (v11 != null) {
            return v11;
        }
        return (Boolean)param3.call(new Object[]{param0, param1, param2});
    }

    @ModifyExpressionValue(method={"putQuadData"}, at={@At(value="CONSTANT", args={"floatValue=1.0"})})
    private float clap$xrayOpacity(float param1) {
        return ((Float)clap$currentOpacity.get()).floatValue();
    }

    @WrapOperation(method={"tesselateWithoutAO", "tesselateWithAO"}, at={@At(value="INVOKE", target="Ljava/util/List;isEmpty()Z", ordinal=1)})
    private boolean clap$xrayHideUnculledFaces(List param1, Operation param2, BlockRenderView param3, List param4, BlockState param5, BlockPos param6) {
        XrayModule v7 = XrayModule.io0O();
        if (v7 != null && Boolean.FALSE.equals(v7.i0ii(param5, param6))) {
            return true;
        }
        return (Boolean)param2.call(new Object[]{param1});
    }
}

