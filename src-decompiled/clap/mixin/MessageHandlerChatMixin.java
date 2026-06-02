/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.network.message.MessageHandler
 *  net.minecraft.network.message.MessageType$Parameters
 *  net.minecraft.network.message.SignedMessage
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.gui.GuiSupport_oiio_3;

@Mixin(value={MessageHandler.class})
public class MessageHandlerChatMixin {
    @Inject(method={"handlePlayerChatMessage"}, at={@At(value="HEAD")})
    private void clap$trackPlayerChat(SignedMessage param1, GameProfile param2, MessageType.Parameters param3, CallbackInfo param4) {
        GuiSupport_oiio_3.OOiIO(param1.signature(), param1.getSignedContent(), param2 != null ? param2.name() : "");
    }
}

