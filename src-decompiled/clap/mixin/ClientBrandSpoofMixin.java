/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.ClientBrandRetriever
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package clap.mixin;

import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import clap.config.ClientSpoofState;

@Mixin(value={ClientBrandRetriever.class})
public class ClientBrandSpoofMixin {
    @Inject(method={"getClientModName"}, at={@At(value="HEAD")}, remap=false, cancellable=true)
    private static void getClientModName(CallbackInfoReturnable callback) {
        String brand = ClientSpoofState.getClientBrand();
        if (brand != null) {
            callback.setReturnValue((Object)brand);
        }
    }
}
