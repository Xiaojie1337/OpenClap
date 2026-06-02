/*
 * Decompiled with CFR 0.152.
 */
package clap.api;

import clap.api.ApiSupport_0O0O_O0oO;
import clap.api.ApiSupport_0OoO_0o00;
import clap.api.ApiSupport_IIi_III;
import clap.api.ApiSupport_OI0i_OIIi;
import clap.network.NetworkSupport_OOI0_OOo;

public interface ApiSupport_ioi_oOo
extends ApiSupport_0O0O_O0oO,
ApiSupport_0OoO_0o00,
ApiSupport_IIi_III {
    public static final char OoIi = '\uffffb909';
    public static final short KillAuraModule = 18487;
    public static final float OoII = 0.2550056f;

    public void Oooi(String var1, boolean var2, char var3);

    public long OoIO(float var1);

    public void OooI(double var1, char var3, long var4);

    public static float PacketReceiveEvent() {
        ApiSupport_IIi_III.ConfigSupport_0II((short)-18966);
        int n = -14064;
        int n2 = 17764;
        NetworkSupport_OOI0_OOo.I0Ii(0.19911337f, "Then the LORD rained upon Sodom and upon Gomorrah brimstone and fire from the LORD out of heaven; And he overthrew those cities, and all the plain, and all the inhabitants of the cities, and that which grew upon the ground.", 4307924702852392067L);
        ApiSupport_OI0i_OIIi.PacketSendEvent(0.0926998476261306);
        return 0.8766094f;
    }
}

