/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gl.SimpleFramebuffer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.render.RenderTickCounter
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.network.NetworkSupport_00OI;
import clap.event.EventBusApi;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00ii_0;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.core.NativeEntrypointBridge;
import clap.gui.screen.ClickGuiScreen;
import clap.module.client.ClickGuiModule;
import clap.render.ScaledDrawContext;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={InGameHud.class})
public class InGameHudRenderMixin {
    private static boolean clickGuiMode1WarmupDone;

    @Inject(method={"render"}, at={@At(value="RETURN")})
    public void render(DrawContext param1, RenderTickCounter param2, CallbackInfo param3) {
        if (MinecraftClient.getInstance().inGameHud.getDebugHud().shouldShowDebugHud()) {
            return;
        }
        float v4 = MinecraftClient.getInstance().getWindow().getScaleFactor();
        float v5 = MinecraftClient.getInstance().getWindow().getScaledWidth();
        float v6 = MinecraftClient.getInstance().getWindow().getScaledHeight();
        float v7 = param2.getTickProgress(true);
        NetworkSupport_00OI.HelpCommand();
        this.warmupClickGuiMode1();
        PostProcessingModule v8 = PostProcessingModule.IoIo();
        if (v8 != null && v8.IooI()) {
            RenderSupport_00ii_0.PacketEvent();
        }
        PostProcessingModule.IoII(v8);
        if (v8 != null && v8.Iooi()) {
            this.renderBloom(v8, param1, v7, v5, v6, v4);
        }
        RenderSupport_oooo_2.begin("CLAP_HUD");
        RenderSupport_oooo_2.begin("CLAP_RENDER_2D");
        RenderSupport_oooo_2.beginImmediate("CLAP_HUD");
        boolean v9 = RenderSupport_00oi_0.OOo(v5, v6, v4);
        try {
            if (v8 != null && v8.Iooi() && RenderSupport_00oi_0.Oii()) {
                RenderSupport_00oi_0.OoI(0.0f, 0.0f, v5, v6, RenderSupport_00oi_0.GuiSupport_OOI);
            }
            ScaledDrawContext v10 = new ScaledDrawContext(param1, v7);
            EventBusApi.OIo.OOo(v10);
            RenderSupport_00ii_0.HudElement();
            return;
        }
        finally {
            if (v9) {
                RenderSupport_00oi_0.GuiSupport_OOI();
                param1.createNewRootLayer();
            }
            RenderSupport_00oi_0.EventBusApi();
            RenderSupport_oooo_2.endImmediate("CLAP_HUD");
            RenderSupport_oooo_2.end("CLAP_RENDER_2D");
            RenderSupport_oooo_2.end("CLAP_HUD");
        }
    }

    private void warmupClickGuiMode1() {
        if (clickGuiMode1WarmupDone) {
            return;
        }
        clickGuiMode1WarmupDone = true;
        ClickGuiScreen.PacketEvent().HelpCommand();
        ClickGuiModule v1 = ClickGuiModule.OOi0O();
        if (v1 == null || ((Boolean)v1.0iIo.HelpCommand()).booleanValue()) {
            RenderSupport_00ii_0.OOo();
        }
    }

    private void renderBloom(PostProcessingModule param1, DrawContext param2, float param3, float param4, float param5, float param6) {
        if (!param1.Iooi()) {
            return;
        }
        if (!RenderSupport_00ii_0.O0o()) {
            return;
        }
        RenderSupport_00ii_0.ConfigSupport_O0I();
        SimpleFramebuffer v7 = RenderSupport_00ii_0.O0i();
        if (v7 == null) {
            return;
        }
        try (RenderPass v82 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(() -> "clap/bloom", v7.method_71639(), OptionalInt.empty(), v7.field_1478 ? v7.method_71640() : null, OptionalDouble.empty());){
            v82.setPipeline(RenderPipelines.GUI);
            boolean v9 = RenderSupport_00oi_0.OOo(param4, param5, param6);
            try {
                EventBusApi.OIo.OOo(new GuiSupport_0oo_2(param2, param3));
            }
            finally {
                if (v9) {
                    RenderSupport_00oi_0.OOi(false);
                }
            }
        }
        catch (Throwable v82) {
            NativeEntrypointBridge.OOo.warn("Failed to render HUD bloom pass", v82);
        }
        RenderSupport_00ii_0.EventBusApi();
    }
}

