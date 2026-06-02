/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.network.packet.BrandCustomPayload
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.UnknownCustomPayload
 *  net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket
 */
package clap.module.client;

import clap.core.module.Module;
import clap.core.module.ModuleCategory;
import clap.event.EventHandler;
import clap.event.network.PacketReceiveEvent;
import clap.model.EnumType_oioo_5;
import clap.setting.Setting;
import net.minecraft.network.packet.BrandCustomPayload;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.UnknownCustomPayload;
import net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket;

/*
 * Renamed from psx.Hyk.iOi
 */
public class ClientSpoofModule extends Module {
    // EnumType_oioo_5 values are still obfuscated in their own class:
    // OOOo = Vanilla, PostProcessingModule = Modded, OOOi = Custom.
    public final Setting mode = this.OOi0i("Mode", EnumType_oioo_5.OOOo);
    public final Setting hideMods;
    public final Setting customClientName = this.OOi0I("Custom Client", "fabric");
    public final Setting preventFingerprinting;
    public final Setting disableCustomPayloads;

    public ClientSpoofModule() {
        super("ClientSpoof", "Spoofs client brand and hides mod fingerprints from servers", ModuleCategory.NoHurtCamModule);
        this.hideMods = this.OOi00("Hide Mods", true);
        this.disableCustomPayloads = this.OOi00("Disable Custom Payloads", true);
        this.preventFingerprinting = this.OOi00("Prevent Fingerprinting", true);
    }

    @EventHandler
    public void onPacket(PacketReceiveEvent event) {
        Packet packet = event.PacketEvent();
        if (!(packet instanceof CustomPayloadC2SPacket customPayloadPacket)) {
            return;
        }

        CustomPayload payload = customPayloadPacket.payload();
        if (payload instanceof UnknownCustomPayload || payload instanceof BrandCustomPayload) {
            return;
        }

        EnumType_oioo_5 activeMode = this.getActiveMode();
        if (activeMode == null || activeMode == EnumType_oioo_5.PostProcessingModule) {
            return;
        }
        if (activeMode == EnumType_oioo_5.OOOi && !((Boolean)this.disableCustomPayloads.HelpCommand()).booleanValue()) {
            return;
        }

        event.DataRecord_0O0();
    }

    public String getClientBrand() {
        EnumType_oioo_5 activeMode = this.getActiveMode();
        if (activeMode == null) {
            return null;
        }
        if (activeMode == EnumType_oioo_5.OOOo) {
            return "vanilla";
        }
        if (activeMode == EnumType_oioo_5.PostProcessingModule) {
            return "fabric";
        }
        if (activeMode == EnumType_oioo_5.OOOi) {
            return (String)this.customClientName.HelpCommand();
        }
        throw new MatchException(null, null);
    }

    public boolean shouldBlockFingerprinting() {
        EnumType_oioo_5 activeMode = this.getActiveMode();
        if (activeMode == null) {
            return false;
        }
        if (activeMode == EnumType_oioo_5.OOOo || activeMode == EnumType_oioo_5.PostProcessingModule) {
            return true;
        }
        if (activeMode == EnumType_oioo_5.OOOi) {
            return (Boolean)this.preventFingerprinting.HelpCommand();
        }
        throw new MatchException(null, null);
    }

    public EnumType_oioo_5 getActiveMode() {
        if (!this.IoOo()) {
            return null;
        }
        return (EnumType_oioo_5)this.mode.HelpCommand();
    }

    public boolean shouldHideMods() {
        EnumType_oioo_5 activeMode = this.getActiveMode();
        if (activeMode == null) {
            return false;
        }
        if (activeMode == EnumType_oioo_5.OOOo || activeMode == EnumType_oioo_5.PostProcessingModule) {
            return true;
        }
        if (activeMode == EnumType_oioo_5.OOOi) {
            return (Boolean)this.hideMods.HelpCommand();
        }
        throw new MatchException(null, null);
    }

    /** @deprecated Use {@link #onPacket(PacketReceiveEvent)}. */
    @Deprecated
    public void oIiI(PacketReceiveEvent event) {
        this.onPacket(event);
    }

    /** @deprecated Use {@link #getClientBrand()}. */
    @Deprecated
    public String oiOO() {
        return this.getClientBrand();
    }

    /** @deprecated Use {@link #shouldBlockFingerprinting()}. */
    @Deprecated
    public boolean oiOo() {
        return this.shouldBlockFingerprinting();
    }

    /** @deprecated Use {@link #getActiveMode()}. */
    @Deprecated
    public EnumType_oioo_5 oIii() {
        return this.getActiveMode();
    }

    /** @deprecated Use {@link #shouldHideMods()}. */
    @Deprecated
    public boolean oiO0() {
        return this.shouldHideMods();
    }
}
