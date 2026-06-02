/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.XrayModule;

@Pseudo
@Mixin(targets={"net.caffeinemc.mods.sodium.client.render.model.AbstractBlockRenderContext"}, remap=false)
public class SodiumBlockRenderContextMixin {
    @Shadow
    protected BlockState state;
    @Shadow
    protected BlockPos pos;

    @Inject(method={"isFaceCulled(Lnet/minecraft/class_2350;)Z"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void clap$xrayIsFaceCulled(Direction param1, CallbackInfoReturnable param2) {
        XrayModule v3 = XrayModule.io0O();
        if (v3 == null) {
            return;
        }
        Boolean v4 = v3.i0ii(this.state, this.pos);
        if (v4 != null) {
            param2.setReturnValue((Object)(v4 == false ? 1 : 0));
        }
    }
}

