/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.DebugHud
 *  org.spongepowered.asm.mixin.Mixin
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={DebugHud.class})
public class DebugHudRenderMixin {
    @WrapMethod(method={"render"})
    private void clap$streamproofF3(DrawContext param1, Operation param2) {
        RenderSupport_oooo_2.begin("F3_OVERLAY");
        param2.call(new Object[]{param1});
        RenderSupport_oooo_2.end("F3_OVERLAY");
    }
}

