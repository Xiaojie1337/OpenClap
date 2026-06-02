/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ingame.AnvilScreen
 *  net.minecraft.text.Text
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package clap.mixin;

import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={AnvilScreen.class})
public class AnvilScreenTextMixin {
    @Redirect(method={"slotChanged"}, at=@At(value="INVOKE", target="Lnet/minecraft/network/chat/Component;getString()Ljava/lang/String;"))
    public String slotChanged$getString(Text param1) {
        return this.sanitizedString(param1);
    }

    @Redirect(method={"onNameChanged"}, at=@At(value="INVOKE", target="Lnet/minecraft/network/chat/Component;getString()Ljava/lang/String;"))
    public String onNameChanged$getString(Text param1) {
        return this.sanitizedString(param1);
    }

    private String sanitizedString(Text param1) {
        return param1.getString();
    }
}

