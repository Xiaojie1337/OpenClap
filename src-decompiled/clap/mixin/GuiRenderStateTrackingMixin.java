/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.render.state.GuiRenderState
 *  net.minecraft.client.gui.render.state.ItemGuiElementRenderState
 *  net.minecraft.client.gui.render.state.SimpleGuiElementRenderState
 *  net.minecraft.client.gui.render.state.TextGuiElementRenderState
 *  net.minecraft.client.gui.render.state.TexturedQuadGuiElementRenderState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.ItemGuiElementRenderState;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.gui.render.state.TextGuiElementRenderState;
import net.minecraft.client.gui.render.state.TexturedQuadGuiElementRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.module.client.streamproof.StreamproofLogger;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={GuiRenderState.class})
public class GuiRenderStateTrackingMixin {
    @Inject(method={"submitGuiElement"}, at={@At(value="HEAD")})
    private void clap$streamproofGuiElement(SimpleGuiElementRenderState param1, CallbackInfo param2) {
        if (RenderSupport_oooo_2.isWriting()) {
            StreamproofLogger.OOi = true;
            StreamproofLogger.GuiSupport_OOI.add(param1);
        }
    }

    @Inject(method={"submitGlyphToCurrentLayer"}, at={@At(value="HEAD")})
    private void clap$streamproofGlyph(SimpleGuiElementRenderState param1, CallbackInfo param2) {
        if (RenderSupport_oooo_2.isWriting()) {
            StreamproofLogger.OOi = true;
            StreamproofLogger.GuiSupport_OOI.add(param1);
        }
    }

    @Inject(method={"submitBlitToCurrentLayer"}, at={@At(value="HEAD")})
    private void clap$streamproofBlit(TexturedQuadGuiElementRenderState param1, CallbackInfo param2) {
        if (RenderSupport_oooo_2.isWriting()) {
            StreamproofLogger.OOi = true;
            StreamproofLogger.GuiSupport_OOI.add(param1);
        }
    }

    @Inject(method={"submitText"}, at={@At(value="HEAD")})
    private void clap$streamproofText(TextGuiElementRenderState param1, CallbackInfo param2) {
        if (RenderSupport_oooo_2.isWriting()) {
            StreamproofLogger.OOi = true;
            StreamproofLogger.GuiSupport_OOI.add(param1);
        }
    }

    @Inject(method={"submitItem"}, at={@At(value="HEAD")})
    private void clap$streamproofItem(ItemGuiElementRenderState param1, CallbackInfo param2) {
        if (RenderSupport_oooo_2.isWriting()) {
            StreamproofLogger.OOi = true;
            StreamproofLogger.GuiSupport_OOI.add(param1);
        }
    }
}

