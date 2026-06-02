/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.gui.screen.ingame.RecipeBookScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.mixin.HandledScreenAccessor;
import clap.module.player.FastCraftModule;
import skidonion.loader.0ooo;

@Mixin(value={RecipeBookScreen.class})
public abstract class RecipeBookScreenMixin {
    @Unique
    private boolean clap$isInventoryScreen() {
        return this instanceof InventoryScreen;
    }

    @Unique
    private FastCraftModule clap$getFastCraft() {
        return 0ooo.iIo() == null ? null : (FastCraftModule)0ooo.PotionEffectsHudElement().oo0i(FastCraftModule.class);
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void clap$renderFastCraftPanel(DrawContext param1, int param2, int param3, float param4, CallbackInfo param5) {
        if (!this.clap$isInventoryScreen()) {
            return;
        }
        FastCraftModule v6 = this.clap$getFastCraft();
        if (v6 != null && v6.IoOo()) {
            HandledScreenAccessor v7 = (HandledScreenAccessor)((Object)this);
            v6.IOoI(param1, v7.clap$getLeftPos(), v7.clap$getTopPos(), param2, param3);
        }
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$clickFastCraftPanel(Click param1, boolean param2, CallbackInfoReturnable param3) {
        if (!this.clap$isInventoryScreen()) {
            return;
        }
        FastCraftModule v4 = this.clap$getFastCraft();
        HandledScreenAccessor v5 = (HandledScreenAccessor)((Object)this);
        if (v4 != null && v4.IoOo() && v4.IOoi(param1, v5.clap$getLeftPos(), v5.clap$getTopPos())) {
            param3.setReturnValue((Object)true);
        }
    }
}

