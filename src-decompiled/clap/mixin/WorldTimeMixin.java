/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.module.render.WorldTimeModule;

@Mixin(value={World.class})
public class WorldTimeMixin {
    @Inject(method={"getDayTime"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$overrideDayTime(CallbackInfoReturnable param1) {
        WorldTimeModule v2 = WorldTimeModule.oi00();
        World v3 = (World)this;
        if (v2 != null && v2.oiOi(v3)) {
            param1.setReturnValue((Object)v2.oi0O());
        }
    }
}

