/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.hud.ChatHud
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package clap.mixin;

import java.util.List;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={ChatHud.class})
public interface ChatHudAccessor {
    @Accessor(value="allMessages")
    public List clap$getAllMessages();

    @Accessor(value="trimmedMessages")
    public List clap$getTrimmedMessages();

    @Accessor(value="chatScrollbarPos")
    public int clap$getChatScrollbarPos();

    @Invoker(value="refreshTrimmedMessages")
    public void clap$refreshTrimmedMessages();

    @Invoker(value="getScale")
    public double clap$getScale();

    @Invoker(value="getLineHeight")
    public int clap$getLineHeight();
}

