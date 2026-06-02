package clap.config;

import clap.model.ClientSpoofMode;
import clap.module.client.ClientSpoofModule;
import skidonion.loader.0ooo;

/*
 * Central accessors for ClientSpoof state used by mixins.
 */
public final class ClientSpoofState {
    private ClientSpoofState() {
    }

    public static ClientSpoofModule getModule() {
        if (0ooo.OOIi() == null) {
            return null;
        }
        return (ClientSpoofModule)0ooo.OOiO().oo0i(ClientSpoofModule.class);
    }

    public static String getClientBrand() {
        ClientSpoofModule module = ClientSpoofState.getModule();
        return module == null ? null : module.getClientBrand();
    }

    public static boolean shouldBlockFingerprinting() {
        ClientSpoofModule module = ClientSpoofState.getModule();
        return module != null && module.shouldBlockFingerprinting();
    }

    public static ClientSpoofMode getActiveMode() {
        ClientSpoofModule module = ClientSpoofState.getModule();
        return module == null ? null : module.getActiveMode();
    }

    public static boolean shouldHideMods() {
        ClientSpoofModule module = ClientSpoofState.getModule();
        return module != null && module.shouldHideMods();
    }
}
