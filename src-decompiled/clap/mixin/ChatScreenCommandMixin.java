/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.text.ClickEvent
 *  net.minecraft.text.ClickEvent$Custom
 *  net.minecraft.text.Style
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.gui.GuiSupport_oiio_3;
import clap.render.RenderSupport_ooi_0;
import skidonion.loader.0ooo;

@Mixin(value={ChatScreen.class})
public abstract class ChatScreenCommandMixin {
    @Shadow
    public abstract String method_44054(String var1);

    @Inject(method={"handleChatInput"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$handleClientCommand(String param1, boolean param2, CallbackInfo param3) {
        String v4 = this.method_44054(param1);
        if (!0ooo.ConfigSupport_0OO().IiiI(v4)) {
            return;
        }
        if (param2) {
            RenderSupport_ooi_0.OOo(v4);
        }
        0ooo.DataRecord_0O0().IiIO(v4);
        param3.cancel();
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$handleTranslateAppend(Click param1, boolean param2, CallbackInfoReturnable param3) {
        if (param1.button() == 1 && GuiSupport_oiio_3.OOiI0(param1.x(), param1.y())) {
            param3.setReturnValue((Object)true);
        }
    }

    @Inject(method={"handleComponentClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$handleTranslateClick(Style param1, boolean param2, CallbackInfoReturnable param3) {
        ClickEvent.Custom v5;
        if (param1 == null) {
            return;
        }
        ClickEvent v4 = param1.getClickEvent();
        if (v4 instanceof ClickEvent.Custom && GuiSupport_oiio_3.OOiIo(v5 = (ClickEvent.Custom)v4)) {
            param3.setReturnValue((Object)true);
        }
    }

    @Inject(method={"removed"}, at={@At(value="HEAD")})
    private void clap$clearTranslateButtons(CallbackInfo param1) {
        GuiSupport_oiio_3.OOiIi(MinecraftClient.getInstance().inGameHud.getChatHud());
    }
}

