/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package clap.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import clap.module.movement.MoveFixModule;
import skidonion.loader.0ooo;

@Mixin(value={Entity.class})
public class EntityMovementYawMixin {
    @Redirect(method={"moveRelative"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getYRot()F"))
    private float clap$redirectMovementYaw(Entity param1) {
        if (0ooo.ooI() == null || !0ooo.ooi().Oii() || 0ooo.oIO() == null) {
            return param1.getYaw();
        }
        MoveFixModule v2 = (MoveFixModule)0ooo.ConfigSupport_oi0_2().oo0i(MoveFixModule.class);
        if (v2 != null && v2.OOO0O()) {
            return 0ooo.oIo().ConfigSupport_OI0();
        }
        return param1.getYaw();
    }
}

