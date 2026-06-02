/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resource.ClientDataPackManager
 *  net.minecraft.registry.VersionedIdentifier
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  psx.Hyk.OioO
 */
package clap.mixin;

import java.util.Map;
import net.minecraft.client.resource.ClientDataPackManager;
import net.minecraft.registry.VersionedIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import clap.model.EnumType_oioo_5;
import clap.config.ConfigSupport_ooo0_0;

@Mixin(value={ClientDataPackManager.class})
public class ClientDataPackManagerMixin {
    @Redirect(method={"trySelectingPacks"}, at=@At(value="INVOKE", target="Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;"))
    private Object redirectSelectPacks(Map param1, Object param2) {
        VersionedIdentifier v3 = (VersionedIdentifier)param2;
        EnumType_oioo_5 v5 = ConfigSupport_ooo0_0.HelpCommand();
        if (!v3.namespace().equalsIgnoreCase("fabric") || v5 == null) {
            return param1.get(v3);
        }
        if (v5 == EnumType_oioo_5.PostProcessingModule) {
            return param1.get(v3);
        }
        return null;
    }
}

