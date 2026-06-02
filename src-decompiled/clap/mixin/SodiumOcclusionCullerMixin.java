/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package clap.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import clap.module.render.XrayModule;

@Pseudo
@Mixin(targets={"net.caffeinemc.mods.sodium.client.render.chunk.occlusion.OcclusionCuller"}, remap=false)
public class SodiumOcclusionCullerMixin {
    @ModifyVariable(method={"findVisible(Lnet/caffeinemc/mods/sodium/client/render/chunk/lists/RenderSectionVisitor;Lnet/caffeinemc/mods/sodium/client/render/viewport/Viewport;FZI)V"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0, require=0)
    private boolean clap$xrayDisableOcclusionCulling(boolean param1) {
        XrayModule v2 = XrayModule.io0O();
        if (v2 != null && v2.IoOo()) {
            return false;
        }
        return param1;
    }
}

