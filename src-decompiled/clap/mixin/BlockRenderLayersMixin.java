/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.render.BlockRenderLayer
 *  net.minecraft.client.render.BlockRenderLayers
 *  net.minecraft.fluid.FluidState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.BlockRenderLayers;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.XrayModule;

@Mixin(value={BlockRenderLayers.class})
public class BlockRenderLayersMixin {
    @Inject(method={"getChunkRenderType"}, at={@At(value="HEAD")}, cancellable=true)
    private static void clap$xrayBlockLayer(BlockState param0, CallbackInfoReturnable param1) {
        XrayModule v2 = XrayModule.io0O();
        if (v2 != null && v2.ioOo()) {
            param1.setReturnValue((Object)BlockRenderLayer.TRANSLUCENT);
        }
    }

    @Inject(method={"getRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    private static void clap$xrayFluidLayer(FluidState param0, CallbackInfoReturnable param1) {
        XrayModule v2 = XrayModule.io0O();
        if (v2 != null && v2.ioOo()) {
            param1.setReturnValue((Object)BlockRenderLayer.TRANSLUCENT);
        }
    }
}

