/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.entity.EntityRenderer
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.render.NameTagsModule;
import skidonion.loader.0ooo;

@Mixin(value={EntityRenderer.class})
public class EntityRendererStateMixin {
    @Inject(method={"finalizeRenderState"}, at={@At(value="RETURN")})
    private void hideVanillaNametags(Entity param1, EntityRenderState param2, CallbackInfo param3) {
        NameTagsModule v4;
        NameTagsModule o00_02 = v4 = 0ooo.OoOo() == null ? null : (NameTagsModule)0ooo.ConfigSupport_oooi_3().oo0i(NameTagsModule.class);
        if (v4 != null && v4.IoOo() && v4.Oo0oO(param1)) {
            param2.displayName = null;
            param2.nameLabelPos = null;
        }
    }
}

