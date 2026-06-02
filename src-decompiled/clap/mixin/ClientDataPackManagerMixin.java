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

import clap.model.ClientSpoofMode;
import clap.config.ClientSpoofState;

@Mixin(value={ClientDataPackManager.class})
public class ClientDataPackManagerMixin {
    @Redirect(method={"trySelectingPacks"}, at=@At(value="INVOKE", target="Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;"))
    private Object redirectSelectPacks(Map packsById, Object id) {
        VersionedIdentifier packId = (VersionedIdentifier)id;
        ClientSpoofMode activeMode = ClientSpoofState.getActiveMode();
        if (!packId.namespace().equalsIgnoreCase("fabric") || activeMode == null) {
            return packsById.get(packId);
        }
        if (activeMode == ClientSpoofMode.Modded) {
            return packsById.get(packId);
        }
        return null;
    }
}
