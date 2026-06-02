/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.ParseResults
 *  com.mojang.brigadier.StringReader
 *  net.minecraft.client.gui.screen.ChatInputSuggestor
 *  net.minecraft.client.gui.screen.ChatInputSuggestor$SuggestionWindow
 *  net.minecraft.client.gui.widget.TextFieldWidget
 *  org.jspecify.annotations.Nullable
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import skidonion.loader.0ooo;

@Mixin(value={ChatInputSuggestor.class})
public abstract class ChatInputSuggestorMixin {
    @Shadow
    private ChatInputSuggestor.SuggestionWindow field_21612;
    @Shadow
    private @Nullable CompletableFuture field_21611;
    @Shadow
    private @Nullable ParseResults field_21610;
    @Shadow
    boolean field_21614;
    @Shadow
    @Final
    TextFieldWidget field_21599;

    @Shadow
    protected abstract void method_23937();

    @Inject(method={"updateCommandInfo"}, at={@At(value="RETURN")})
    public void updateCommandInfo(CallbackInfo param1, @Local StringReader param2) {
        ParseResults v5;
        String v3 = 0ooo.iIi().IiII();
        if (!param2.canRead() || !param2.getString().startsWith(v3)) {
            return;
        }
        param2.setCursor(Math.min(v3.length(), param2.getTotalLength()));
        CommandDispatcher v4 = 0ooo.iiO().Iiio();
        this.field_21610 = v5 = v4.parse(param2, (Object)0ooo.EnumType_ii0_2());
        if (this.field_21612 == null || !this.field_21614) {
            this.field_21611 = v4.getCompletionSuggestions(v5, this.field_21599.getCursor());
            this.field_21611.thenRun(() -> {
                if (this.field_21611.isDone()) {
                    this.method_23937();
                }
            });
        }
    }
}

