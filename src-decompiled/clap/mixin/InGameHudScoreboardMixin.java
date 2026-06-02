/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.render.RenderTickCounter
 *  org.spongepowered.asm.mixin.Mixin
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={InGameHud.class})
public class InGameHudScoreboardMixin {
    @WrapMethod(method={"renderScoreboardSidebar"})
    private void clap$streamproofScoreboard(DrawContext param1, RenderTickCounter param2, Operation param3) {
        RenderSupport_oooo_2.begin("SCOREBOARD");
        param3.call(new Object[]{param1, param2});
        RenderSupport_oooo_2.end("SCOREBOARD");
    }
}

