/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractBlock$AbstractBlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.BlockView
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.XrayModule;

@Mixin(value={AbstractBlock.AbstractBlockState.class})
public class AbstractBlockStateBrightnessMixin {
    @Inject(method={"getShadeBrightness"}, at={@At(value="RETURN")}, cancellable=true, order=980)
    private void clap$xrayShadeBrightness(BlockView param1, BlockPos param2, CallbackInfoReturnable param3) {
        XrayModule v4 = XrayModule.io0O();
        if (v4 != null && v4.IoOo()) {
            param3.setReturnValue((Object)Float.valueOf(1.0f));
        }
    }
}

