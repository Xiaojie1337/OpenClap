/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.PlayerListHud
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.ScoreboardObjective
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.render.RenderSupport_oooo_2;
import skidonion.loader.0ooo;

@Mixin(value={PlayerListHud.class})
public class PlayerListHudMixin {
    @WrapMethod(method={"render"})
    private void clap$streamproofPlayerList(DrawContext param1, int param2, Scoreboard param3, ScoreboardObjective param4, Operation param5) {
        RenderSupport_oooo_2.begin("PLAYERLIST");
        param5.call(new Object[]{param1, param2, param3, param4});
        RenderSupport_oooo_2.end("PLAYERLIST");
    }

    @Inject(method={"getNameForDisplay"}, at={@At(value="RETURN")}, cancellable=true)
    private void clap$appendIrcName(PlayerListEntry param1, CallbackInfoReturnable param2) {
        if (0ooo.0Ooo() == null || param1 == null || param1.getProfile() == null) {
            return;
        }
        String v3 = param1.getProfile().name();
        String v4 = 0ooo.0OoI().iI0i(v3);
        if (v4.isBlank() || v4.equalsIgnoreCase(v3)) {
            return;
        }
        param2.setReturnValue((Object)Text.empty().append((Text)param2.getReturnValue()).append((Text)Text.literal((String)" (").formatted(Formatting.GRAY)).append((Text)Text.literal((String)v4).formatted(Formatting.AQUA)).append((Text)Text.literal((String)")").formatted(Formatting.GRAY)));
    }
}

