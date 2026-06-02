/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import clap.mixin.SodiumBlockRenderContextMixin;
import clap.module.render.XrayModule;

@Pseudo
@Mixin(targets={"net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer"}, remap=false)
public class SodiumBlockRendererMixin
extends SodiumBlockRenderContextMixin {
    @ModifyExpressionValue(method={"bufferQuad(Lnet/caffeinemc/mods/sodium/client/render/model/MutableQuadViewImpl;[FLnet/caffeinemc/mods/sodium/client/render/chunk/terrain/material/Material;)V"}, at={@At(value="INVOKE", target="Lnet/caffeinemc/mods/sodium/client/render/model/MutableQuadViewImpl;baseColor(I)I")}, require=0)
    private int clap$xrayBlockOpacity(int param1) {
        XrayModule v2 = XrayModule.io0O();
        if (v2 == null || !v2.ioOo() || v2.ioO0(this.state.method_26204(), this.pos)) {
            return param1;
        }
        return param1 & v2.ioOi();
    }
}

