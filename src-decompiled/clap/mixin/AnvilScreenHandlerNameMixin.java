/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.AnvilScreenHandler
 *  net.minecraft.text.Text
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package clap.mixin;

import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={AnvilScreenHandler.class})
public class AnvilScreenHandlerNameMixin {
    @Redirect(method={"createResult"}, at=@At(value="INVOKE", target="Lnet/minecraft/network/chat/Component;getString()Ljava/lang/String;"))
    public String getString(Text param1) {
        return param1.getString();
    }
}

