/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.ChatHud
 *  org.spongepowered.asm.mixin.Mixin
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={ChatHud.class})
public class ChatHudRenderMixin {
    @WrapMethod(method={"render"})
    private void clap$streamproofChat(DrawContext param1, TextRenderer param2, int param3, int param4, int param5, boolean param6, boolean param7, Operation param8) {
        RenderSupport_oooo_2.begin("CHAT_MESSAGES_OVERLAY");
        param8.call(new Object[]{param1, param2, param3, param4, param5, param6, param7});
        RenderSupport_oooo_2.end("CHAT_MESSAGES_OVERLAY");
    }
}

