/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.block.entity.BlockEntityRenderManager
 *  net.minecraft.client.render.block.entity.state.BlockEntityRenderState
 *  net.minecraft.client.render.command.OrderedRenderCommandQueue
 *  net.minecraft.client.render.state.CameraRenderState
 *  net.minecraft.client.util.math.MatrixStack
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.render.block.entity.BlockEntityRenderManager;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.render.XrayModule;

@Mixin(value={BlockEntityRenderManager.class})
public class BlockEntityRenderManagerMixin {
    @Inject(method={"submit"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$xrayHideBlockEntities(BlockEntityRenderState param1, MatrixStack param2, OrderedRenderCommandQueue param3, CameraRenderState param4, CallbackInfo param5) {
        XrayModule v6 = XrayModule.io0O();
        if (v6 != null && v6.ioOO(param1.blockState, param1.pos)) {
            param5.cancel();
        }
    }
}

