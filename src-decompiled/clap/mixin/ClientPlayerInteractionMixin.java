/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.config.ConfigSupport_IO0;
import clap.event.EventBusApi;

@Mixin(value={ClientPlayerInteractionManager.class})
public class ClientPlayerInteractionMixin {
    @Inject(method={"attack"}, at={@At(value="HEAD")}, cancellable=true)
    private void clap$onAttack(PlayerEntity param1, Entity param2, CallbackInfo param3) {
        if (param1 == null || param2 == null) {
            return;
        }
        if (EventBusApi.OIo.OOo(new ConfigSupport_IO0(param1, param2))) {
            param3.cancel();
        }
    }
}

