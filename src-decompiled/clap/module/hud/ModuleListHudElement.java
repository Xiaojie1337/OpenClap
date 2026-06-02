/*
 * Decompiled with CFR 0.152.
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.network.NetworkSupport_00OI;
import clap.model.DataRecord_00OO;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.core.module.Module;
import clap.render.RenderSupport_00oi_0;
import clap.model.DataRecord_0ii_1;
import clap.gui.GuiSupport_0oo_2;
import clap.model.EnumType_io0_1;
import clap.setting.Setting;
import clap.model.EnumType_oiio_5;
import clap.core.module.ModuleCategory;
import clap.model.DataRecord_oioo_4;
import clap.render.ScaledDrawContext;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.oio
 */
public class ModuleListHudElement
extends HudElement {
    private float OoII;
    private int EnumType_OIO0;
    public Setting 0oI;
    private double OoIO;
    public Setting EnumType_OI0O;
    public Setting ConfigSupport_OIOI;
    private float Ooi0;
    public Setting CameraClipModule;
    private float Ooii;
    public Setting 0oi;
    public Setting RotationModule;
    private final List OooO;
    private final List Ooo0;
    public Setting OIoi;
    public Setting 0Io;
    private static final int[] PacketSendEvent;
    private float Ooio;
    private long Oooi;
    private static final float Oo0O;
    public Setting OIOi;
    private float OoiO;
    public Setting OI0i;
    private float PacketReceiveEvent;
    private final List Oooo;
    private static final float 00i;
    private boolean KillAuraModule;
    public Setting RenderSupport_OIIO;
    private float OoIi;
    private final Map IrcManager = new HashMap();
    public Setting OIoO;
    public Setting DataRecord_OII0;
    private long OooI;
    private final Map Oo0i = new HashMap();
    public Setting OI0o;
    public Setting OIoo;
    private static final int ScaledDrawContext;
    public Setting OIo0;
    public Setting OIoI;
    private EnumType_io0_1 AutoCollectWaterModule;
    public Setting OIOo;
    private static final float OoOi;
    private float OoiI;
    static Object OIIo;
    private static volatile /* synthetic */ long __k__gH4it;

    private int 0IIO(FontRenderer param1, String param2) {
        if (param2 == null || param2.isEmpty()) {
            return 0;
        }
        return this.0Ioo() ? ModuleListHudElement.ConfigSupport_OI0.textRenderer.getWidth(param2) : param1.GuiSupport_OOI(param2);
    }

    private int 0oii(int param1) {
        int v2 = param1 >>> 24 & 0xFF;
        int v3 = param1 >>> 16 & 0xFF;
        int v4 = param1 >>> 8 & 0xFF;
        int v5 = param1 & 0xFF;
        float[] v6 = Color.RGBtoHSB(v3, v4, v5, null);
        float v7 = Math.max(0.35f, v6[1]);
        float v8 = Math.max(0.78f, v6[2]) * ((float)this.EnumType_OIO0 / 100.0f);
        int v9 = Color.HSBtoRGB(v6[0], Math.min(1.0f, v7), Math.min(1.0f, v8));
        return v2 << 24 | v9 & 0xFFFFFF;
    }

    private float 0oiI(float param1) {
        float v2 = Math.max(0.0f, Math.min(1.0f, param1));
        float v3 = 1.0f - v2;
        return 1.0f - v3 * v3 * v3;
    }

    private void 0oIo() {
        double v1 = (double)System.nanoTime() / 1.0E9;
        this.OoIO = v1 * (double)((Integer)this.RotationModule.HelpCommand()).intValue() * 7.2;
    }

    private int 0ooo(int param1) {
        int v2 = this.ConfigSupport_0oo0_1(param1);
        return this.AutoCollectWaterModule == EnumType_io0_1.DataRecord_0O0 ? v2 : this.0oii(v2);
    }

    private float 0oIO(int param1) {
        float v2 = this.0oI0(param1);
        return v2 < 0.5f ? v2 * 2.0f : (1.0f - v2) * 2.0f;
    }

    private float 0Ioi() {
        return this.0IoI() * this.OIo();
    }

    private void 0I0i() {
        this.Oooo.clear();
        if (0ooo.Ii0() == null) {
            return;
        }
        for (Module v2 : 0ooo.Iio().oo0o()) {
            if (v2 == this || v2.0iI0 || v2.Io00() == ModuleCategory.ioi) continue;
            this.Oooo.add(v2);
        }
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        super.O0i(param1);
        FontRenderer v2 = this.0Io0();
        this.0oi0();
        this.0IOi(v2);
        if (this.OooO.isEmpty()) {
            this.Oii(this.GuiSupport_OOI(), this.OOi(), 1.0f, 1.0f);
            return;
        }
        this.0IoO();
        this.PacketReceiveEvent = Math.max(1.0f, (float)this.0II0(v2) * this.0IoI() * this.OIo() + (float)this.RenderSupport_oii_4((Integer)this.OIo0.HelpCommand()) * 2.0f);
        float v3 = this.0I0O(this.OooO);
        float v4 = (float)this.OooO.size() * this.PacketReceiveEvent + (float)Math.max(0, this.OooO.size() - 1) * this.Ooi0;
        this.KillAuraModule = this.OiO();
        this.OoII = this.GuiSupport_OOI();
        float v5 = this.KillAuraModule ? this.OoII - v3 : this.OoII;
        this.OoIi = this.OOi();
        this.0oIo();
        this.Ooo0.clear();
        for (int v6 = 0; v6 < this.OooO.size(); ++v6) {
            DataRecord_0ii_1 v7 = (DataRecord_0ii_1)this.OooO.get(v6);
            float v8 = this.0I00(v7);
            float v9 = this.0oiI(v7.o00);
            float v10 = (1.0f - v9) * this.ConfigSupport_OII(10.0f);
            float v11 = this.KillAuraModule ? this.OoII - v8 + v10 : this.OoII - v10;
            float v12 = this.OoIi + (float)v6 * (this.PacketReceiveEvent + this.Ooi0);
            int v13 = this.0IOO(this.0ooo(v6), Math.round(255.0f * v9));
            this.0I0o(v11, v12, v8, this.PacketReceiveEvent, v9, this.KillAuraModule, v13);
            float v14 = this.KillAuraModule ? v11 + v8 - this.OoiI - this.Ooii - this.OoiO - v7.0oi : v11 + this.OoiI + this.Ooii + this.OoiO;
            float v15 = this.0IIo(v2, v12);
            this.Ooo0.add(new DataRecord_00OO(v7, v14, v15, v13, Math.round(255.0f * v9)));
        }
        if (!this.Ooo0.isEmpty()) {
            float v6 = this.0Ioi();
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(v6, v6);
            for (DataRecord_00OO v8 : this.Ooo0) {
                this.RenderSupport_0ooo_1(param1, v2, v8.EnumType_o0o0_0, v8.0oO / v6, v8.0o0 / v6, v8.GuiSupport_OOI, v8.O0oo, v6);
            }
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
        }
        this.Oii(v5, this.OoIi, v3, v4);
    }

    private boolean 0Ioo() {
        return this.OIOo.HelpCommand() == EnumType_oiio_5.DataRecord_OOI0;
    }

    private float 0IOI() {
        return this.RenderSupport_oii_4(Math.max(0, (Integer)this.0oI.HelpCommand()));
    }

    private float 0I00(DataRecord_0ii_1 param1) {
        return param1.0oi + this.OoiO * 2.0f + this.OoiI + this.Ooii;
    }

    private double 0oII(double param1, double param3) {
        double v5 = param1 % param3;
        return v5 < 0.0 ? v5 + param3 : v5;
    }

    private void 0I0I(float param1, float param2, float param3, float param4, boolean param5) {
        float v6 = this.Ooio;
        if (!((Boolean)this.OIoI.HelpCommand()).booleanValue()) {
            RenderSupport_00oi_0.O0o(param1, param2, param3, param4, v6, 0x55FFFFFF);
            return;
        }
        if (param5) {
            RenderSupport_00oi_0.OoO(param1, param2, param3, param4, v6, 0.0f, 0.0f, v6, 0x55FFFFFF);
        } else {
            RenderSupport_00oi_0.OoO(param1, param2, param3, param4, 0.0f, v6, v6, 0.0f, 0x55FFFFFF);
        }
    }

    private FontRenderer 0Io0() {
        return switch (((EnumType_oiio_5)((Object)this.OIOo.HelpCommand())).ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> NetworkSupport_00OI.OOo(20);
            case 1 -> NetworkSupport_00OI.GuiSupport_OOI(20);
            case 2 -> NetworkSupport_00OI.OOi(20);
            case 3 -> null;
        };
    }

    private void RenderSupport_0ooo_1(ScaledDrawContext param1, FontRenderer param2, DataRecord_0ii_1 param3, float param4, float param5, int param6, int param7, float param8) {
        if (this.0Ioo()) {
            param1.ConfigSupport_O0I().drawText(ModuleListHudElement.ConfigSupport_OI0.textRenderer, param3.HelpCommand, Math.round(param4), Math.round(param5), param6, ((Boolean)this.DataRecord_OII0.HelpCommand()).booleanValue());
        } else if (param2 != null) {
            if (((Boolean)this.DataRecord_OII0.HelpCommand()).booleanValue()) {
                param2.HelpCommand(param1.ConfigSupport_O0I(), param3.HelpCommand, param4 + 1.0f, param5 + 1.0f, this.0IO0(param6));
            }
            param2.HelpCommand(param1.ConfigSupport_O0I(), param3.HelpCommand, param4, param5, param6);
        }
        if (!param3.RenderSupport_ooi_1.isEmpty()) {
            float v9 = param4 + param3.oOi / param8;
            int v10 = this.0IOO(-4671304, param7);
            if (this.0Ioo()) {
                param1.ConfigSupport_O0I().drawText(ModuleListHudElement.ConfigSupport_OI0.textRenderer, param3.RenderSupport_ooi_1, Math.round(v9), Math.round(param5), v10, ((Boolean)this.DataRecord_OII0.HelpCommand()).booleanValue());
            } else if (param2 != null) {
                if (((Boolean)this.DataRecord_OII0.HelpCommand()).booleanValue()) {
                    param2.HelpCommand(param1.ConfigSupport_O0I(), param3.RenderSupport_ooi_1, v9 + 1.0f, param5 + 1.0f, this.0IO0(v10));
                }
                param2.HelpCommand(param1.ConfigSupport_O0I(), param3.RenderSupport_ooi_1, v9, param5, v10);
            }
        }
    }

    private int 0IOO(int param1, int param2) {
        return Math.max(0, Math.min(255, param2)) << 24 | param1 & 0xFFFFFF;
    }

    private int 0ooi(int param1) {
        Color v2 = (Color)this.OIOi.HelpCommand();
        Color v3 = (Color)this.EnumType_OI0O.HelpCommand();
        float v4 = this.0oIO(param1);
        int v5 = this.0oiO(v2.getRed(), v3.getRed(), v4);
        int v6 = this.0oiO(v2.getGreen(), v3.getGreen(), v4);
        int v7 = this.0oiO(v2.getBlue(), v3.getBlue(), v4);
        int v8 = this.0oiO(v2.getAlpha(), v3.getAlpha(), v4);
        return v8 << 24 | v5 << 16 | v6 << 8 | v7;
    }

    private int 0II0(FontRenderer param1) {
        int n;
        if (this.0Ioo()) {
            Objects.requireNonNull(ModuleListHudElement.ConfigSupport_OI0.textRenderer);
            n = 9;
        } else {
            n = param1.OOi();
        }
        return n;
    }

    private void 0IOi(FontRenderer param12) {
        this.OooO.clear();
        EnumType_oiio_5 v2 = (EnumType_oiio_5)((Object)this.OIOo.HelpCommand());
        float v3 = this.0Ioi();
        boolean v4 = false;
        for (Module v6 : this.Oooo) {
            float v7 = this.IrcManager.getOrDefault(v6, Float.valueOf(0.0f)).floatValue();
            if (v7 <= 0.01f) continue;
            String v8 = v6.IoOO();
            String v9 = (Boolean)this.RenderSupport_OIIO.HelpCommand() != false ? v6.OIIi() : null;
            String v10 = v9 == null || v9.isEmpty() ? "" : " " + v9;
            DataRecord_oioo_4 v11 = (DataRecord_oioo_4)this.Oo0i.get(v6);
            if (v11 == null || v11.OO0o != v2 || !v11.HelpCommand.equals(v8) || !v11.RenderSupport_ooi_1.equals(v10)) {
                v11 = new DataRecord_oioo_4(v8, v10, v2, this.0IIO(param12, v8), this.0IIO(param12, v10));
                this.Oo0i.put(v6, v11);
                v4 = true;
            }
            float v12 = (float)v11.FontRenderer * v3;
            float v13 = (float)v11.OO0i * v3;
            this.OooO.add(new DataRecord_0ii_1(v8, v10, v12, v13, v12 + v13, v7));
        }
        if (v4) {
            this.Oooo.sort((param1, param2) -> {
                DataRecord_oioo_4 v3 = (DataRecord_oioo_4)this.Oo0i.get(param1);
                DataRecord_oioo_4 v4 = (DataRecord_oioo_4)this.Oo0i.get(param2);
                int v5 = v3 == null ? 0 : v3.FontRenderer + v3.OO0i;
                int v6 = v4 == null ? 0 : v4.FontRenderer + v4.OO0i;
                return Integer.compare(v6, v5);
            });
        }
        this.OooO.sort(Comparator.comparingDouble(DataRecord_0ii_1::RenderSupport_ooi_1).reversed());
    }

    public ModuleListHudElement() {
        super("ModuleList", "Display enabled modules", 90.0f, 80.0f);
        this.OooO = new ArrayList();
        this.Ooo0 = new ArrayList();
        this.Oooo = new ArrayList();
        this.OIOo = this.OOi0i("Font", EnumType_oiio_5.OOoI);
        this.ConfigSupport_OIOI = this.OOi0i("Color", EnumType_io0_1.ConfigSupport_0OO);
        this.0Io = this.OOioo("TextColor", 210, 120, 255, 255);
        this.OIOi = this.OOioo("GradientStart", 255, 90, 190, 255);
        this.EnumType_OI0O = this.OOioo("GradientEnd", 90, 160, 255, 255);
        this.RotationModule = this.OOi0o("ColorSpeed", 90, 0, 100);
        this.OI0o = this.OOi0o("ColorOffset", 90, 0, 100);
        this.0oi = this.OOioo("BackgroundColor", 25, 18, 32, 120);
        this.CameraClipModule = this.OOi0o("Brightness", 115, 80, 150);
        this.OI0i = this.OOi0o("AnimationSpeed", 12, 1, 30);
        this.OIoO = this.OOi0o("PaddingX", 6, 0, 20);
        this.OIo0 = this.OOi0o("PaddingY", 3, 0, 12);
        this.OIoo = this.OOi0o("Spacing", 1, 0, 8);
        this.0oI = this.OOi0o("Radius", 4, 0, 12);
        this.OIoI = this.OOi00("ColorBar", false);
        this.OIoi = this.OOi0o("ColorBarWidth", 2, 1, 8);
        this.RenderSupport_OIIO = this.OOi00("Suffix", true);
        this.DataRecord_OII0 = this.OOi00("TextShadow", false);
        this.0Io.00i(param1 -> this.ConfigSupport_OIOI.HelpCommand() == EnumType_io0_1.OiI);
        this.OIOi.00i(param1 -> this.ConfigSupport_OIOI.HelpCommand() == EnumType_io0_1.DataRecord_0O0);
        this.EnumType_OI0O.00i(param1 -> this.ConfigSupport_OIOI.HelpCommand() == EnumType_io0_1.DataRecord_0O0);
        this.RotationModule.00i(param1 -> this.0oIi());
        this.OI0o.00i(param1 -> this.0oIi());
        this.OIoi.00i(param1 -> (Boolean)this.OIoI.HelpCommand());
        this.0I0i();
    }

    private float 0I0O(List param1) {
        float v2 = 1.0f;
        for (DataRecord_0ii_1 v4 : param1) {
            v2 = Math.max(v2, this.0I00(v4));
        }
        return v2;
    }

    private int 0oiO(int param1, int param2, float param3) {
        return Math.round((float)param1 + (float)(param2 - param1) * param3);
    }

    private int 0IO0(int param1) {
        int v2 = Math.round((float)(param1 >>> 24 & 0xFF) * 0.45f);
        return v2 << 24;
    }

    private int 0ooI(int param1) {
        float v2 = this.0oI0(param1);
        return Color.HSBtoRGB(v2, 0.82f, 1.0f) | 0xFF000000;
    }

    private void 0oi0() {
        long v1 = System.currentTimeMillis();
        if (this.OooI == 0L) {
            this.OooI = v1;
        }
        float v3 = Math.min(0.05f, (float)(v1 - this.OooI) / 1000.0f);
        this.OooI = v1;
        float v4 = v3 * (float)((Integer)this.OI0i.HelpCommand()).intValue();
        long v5 = 1L;
        List v7 = 0ooo.IiI().oo0o();
        for (Module v9 : v7) {
            float v11;
            if (v9 == this || v9.Io00() == ModuleCategory.ioi || v9.0iI0 || !v9.IoOi()) {
                this.IrcManager.remove(v9);
                this.Oo0i.remove(v9);
                continue;
            }
            float v10 = this.IrcManager.getOrDefault(v9, Float.valueOf(0.0f)).floatValue();
            float v12 = this.0oio(v10, v11 = v9.IoOo() ? 1.0f : 0.0f, v4);
            if (v12 <= 0.01f && v11 == 0.0f) {
                this.IrcManager.remove(v9);
            } else {
                this.IrcManager.put(v9, Float.valueOf(v12));
            }
            v5 = 31L * v5 + (long)System.identityHashCode(v9);
            v5 = 31L * v5 + (long)(v9.IoOo() ? 1 : 0);
        }
        if (v5 != this.Oooi || this.Oooo.size() != v7.size()) {
            this.0I0i();
            this.Oooi = v5;
        }
    }

    private float 0oio(float param1, float param2, float param3) {
        if (param1 < param2) {
            return Math.min(param2, param1 + param3);
        }
        if (param1 > param2) {
            return Math.max(param2, param1 - param3);
        }
        return param1;
    }

    private float 0IoI() {
        return this.0Ioo() ? 1.0f : 0.5f;
    }

    private float 0oI0(int param1) {
        double v2 = this.OoIO + (double)(param1 * (Integer)this.OI0o.HelpCommand());
        return (float)(this.0oII(v2, 360.0) / 360.0);
    }

    private void 0I0o(float param1, float param2, float param3, float param4, float param5, boolean param6, int param7) {
        int v8 = this.0IOO(((Color)this.0oi.HelpCommand()).getRGB(), Math.round((float)((Color)this.0oi.HelpCommand()).getAlpha() * param5));
        float v9 = this.Ooio;
        float v10 = this.OoiI;
        if (v10 <= 0.0f) {
            PostProcessingModule.IoiO(param1, param2, param3, param4, v9, v8);
            return;
        }
        if (param6) {
            PostProcessingModule.Ioi0(param1, param2, param3, param4, v9, 0.0f, 0.0f, v9, v8);
            RenderSupport_00oi_0.Ooi(param1 + param3 - v10, param2, v10, param4, param7);
        } else {
            PostProcessingModule.Ioi0(param1, param2, param3, param4, 0.0f, v9, v9, 0.0f, v8);
            RenderSupport_00oi_0.Ooi(param1, param2, v10, param4, param7);
        }
    }

    private int 0IOo(int param1) {
        return PacketSendEvent[param1 % PacketSendEvent.length];
    }

    static {
        __k__gH4it = ModuleListHudElement.__k__gH4it(1692545910493408785L);
        __rP__gH4it0 = new String[]{"\u4217\u660e\ub851\uedbe\u6d6f\u6fc9\uced9\ubc15\u45f9\u6154", "\u42dc\u669d\ub8ff\ued14\u6d0a\u6f2e\uce1a\ubce8"};
        __rP__gH4it1 = new String[]{"\u4215\u660c\ub857\uedb8\u6d6d\u6fcb\ucea7\ubc2b\u45fb\u6156", "\u4217\u661b\ub848"};
        __rP__gH4it2 = new String[]{"\u4365\u679a\ub9a3\uec6d\u6a4c\u683c\uc912\ubbf4\u42f7\u6628\ub809\ued19\u6d58\u6f5f\uce3e\ubc17\u4547\u6100\ubfa2\uea43\u6cc3\u6ea5\ucff4\ubdf4\u44da\u6062\ubee4\uebae\u6c12\u6d24\uccfe\ubeee\u4724\u6310\ubdb8\ue878\u6f8a\u6c9d\ucd03\ubf6d\u468a\u62e2\ubc70\ue9cb\u6eb4\u1374\ub284\uc088\u398c\u1dea\uc3d3\u96eb\u117f\u126f\ub318\uc116\u3886\u1cac\uc21a\u9758\u10fc\u1273\ub0e9\uc2eb\u3b5d\u1f35\uc142\u9482\u13c9\u1172\ub14a\uc341\u3aab\u1e27\uc081\u95c7\u122c\u1069\ub67f\uc408\u3d49\u19b6\uc739\u926f\u15c1\u1787\ub74d\uc590\u3c44\u1888\uc610\u932b\u1429\u16d2\ub7f0\uc634\u3f42\u1bd0\uc57d\u9036\u1706\u158a\ub402\uc718\u3e41\u1aef\uc4d7\u9173\u1659\u14ae\ub572\uc8bd\u3133\u1516\ucb0c\u9e65\u19d5\u1bf1\ubac1\uc801\u30ac\u14af\uca6a\u9fc4\u1833\u1ac6\ubb6d\uc92c\u33b5\u1755\uc927\u9cf6\u1b7b\u1960\ub815\uca3e\u32b1\u16f3\uc830\u9d87\u1a8a\u1818\ub99f\ucbc6\u35c5\u1128\ucf3f\u9ada\u1de7\u1fcb\ube27\ucc8a\u350f\u109d\ucedd\u9b0a\u1cff\u1e4a\ubf9c\ucd59\u3474\u1300\ucd48\u9857\u1f25\u1d9b\ubc35\uce53\u37a8\u125f\ucc6f\u995a\u1e19\u1c52\ubdf5\ucf56\u36e2\u0da5\ud36c\u86dc\u01c9\u03eb\ua2ef\ud052\u29ff\u0d0e\ud249\u873b\u00b8\u02d0\ua39f\ud14c\u2888\u0ca4\ud19d\u844b\u031a\u012c\ua0dc\ud291\u2b04\u0fcc\ud023\u85e3\u0257\u00d5\ua154\ud31f\u2afd\u0e8b\ud7c7\u829a\u050c\u07f6\ua6b4\ud4e9\u2d25\u0931\ud78b\u83a6\u04ed\u067d\ua71b\ud5b6\u2cd8\u08dd\ud640\u805d\u075f\u058f\ua4c7\ud63f\u2f43\u0b4f\ud5e5\u8115\u0630\u04e9\ua545\ud720\u2e6e\u0a39\ud4c8\u8e07\u091f\u0b6b\uaa40\ud80f\u21be\u0529\udb94\u8e9a\u0892\u0a8b\uab75\ud922\u20d8\u0438\udacd\u8f79\u0b79\u09d3\ua828\udaaf\u234f\u07df\ud9bc\u8c18\u0ab8\u08b4\ua900\udbf8\u22ac\u06b7\ud8dc\u8dc3\u0d4c\u0f3f\uaec3\udc47", "\u4207\u661f\ub851\uedc2\u6d6f\u6fce\uceac"};
        __rP__gH4it3 = new String[]{"\u4201\u6601\ub852\uedd7\u6d0f\u6faa\ucec8\ubc2a\u451d\u6107\ubf4a\ueaa3\u6c71\u6eb0\ucfe2\ubd79\u4431\u603d\ube7f\ueb8f", "\u4202\u6606\ub851\uedc7\u6d66"};
        byte[] v0 = "(\u00d6\u00aa\u009d\b\u00dc\u0091\u00e9\u00a2|\u0018\u00f1\u0004\u00a7\u00a5\u0002\u001a\\\u00bb\u00a3\u0097Ug\u00d9\u007f\u0006\u0085v\u00be\u00ec\u0015\u00cb\u0089|\u00d1\u00a8.]\u00e0P?\u0096\u0001\u0003\b\u00ac\u007f\u00bd1\u0096\u00aa+\u00cb\u00bf\u00eb[\u0003([\u00e0p[\"\u00ae\u00d0\u00b9\u000b2MR\u0089\u001c>\u00b3\u00d0o\u00b0Q\u00a4]\u00d4*`\u00cfU\u00b7\u009e\u00fd\u00a1,\u00b1\u00b3\u00c5\u00da\u00dbQ\u00af|\u00d4\u00a6\u00e2\u008a!e\u00b4[f\u00fb\u00a5\u00b6I\u00c8\u00ce\u00aa\u00b5\u00e5!\u00e1\u00f2\u008cik\u00eb\u00bc\u00ff\u00aef\u00a9x\u0099\u00ae\u0086\u00bf\u0000\u0016\u00a3d'\u00a1\u00efV`\u0084S\u0018\u00f4\u00a6\u00ba3\u00bb4'*y<R\u00d3\u0002\u00f7\u00fcY\u00ec\u00a1\u0007\u0001\u00dbV\u00ee\u009d\u00ab\u009e\u0012%\n\u008e\u00e3\u00dfY\u0095\u009c\u00fd\u00bb\u009c\u009f\u00fa\n\u0088\u0003\u00b4x\u00d4\u0089\u0085\u00a8T{\u001e\u008c\u009fL\u0011\u00d8\u00f2\u00cbKm\u000f\u00ca\u00e0\u0097\u001e\u00ba\u0018F\u00e7\u0004@\u0015\u00aa\u00be\u0081\u00f5\u00b0S\u00b5\u00f1iM;\u000fd\u00c26{\u00d4\u001dLq\u00fe\u00d5\u0013\u0005\u00f1\u0007k\u00fb\u00f3\u0002\u00fbm\u0095b\u00dec\u00fe'\u0095t\u00c4\u0089=3\u00ab\u00b2\u001a\u008b\u00ad\u00f0\u00e4L\u009b\u00ed\u00f1\u00eb\u00c5#\u0018\u00cfPj".getBytes("ISO_8859_1");
        Object[] v1 = "\u0083\u00c7\u00e0\u00f6\\\u00e0\u00f7\u00c7".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1575661602;
                case 1 -> 597101024;
                case 2 -> -1427391741;
                case 3 -> -1804952196;
                case 4 -> 808010393;
                case 5 -> 900053962;
                case 6 -> 897500101;
                case 7 -> -473251113;
                case 8 -> -238361335;
                case 9 -> 1916860818;
                case 10 -> 29852823;
                case 11 -> 1487573597;
                case 12 -> 1555544443;
                case 13 -> -183944594;
                case 14 -> 1707968461;
                case 15 -> -1140148216;
                case 16 -> 832983210;
                case 17 -> 444500125;
                case 18 -> -10363880;
                case 19 -> 1138041387;
                case 20 -> 1141464633;
                case 21 -> -759355462;
                case 22 -> 425086737;
                case 23 -> -1570236844;
                case 24 -> -1993778443;
                case 25 -> -839130047;
                case 26 -> -1397159484;
                case 27 -> -1896337555;
                case 28 -> 157826827;
                case 29 -> -170259452;
                case 30 -> 1118065682;
                case 31 -> 61918955;
                case 32 -> -274186520;
                case 33 -> -1159245811;
                case 34 -> -2013693844;
                case 35 -> 1657863824;
                case 36 -> 2030535443;
                case 37 -> 1404049318;
                case 38 -> -1369907021;
                case 39 -> -277029663;
                case 40 -> -1347400576;
                case 41 -> 909969257;
                case 42 -> -602340005;
                case 43 -> 1473899610;
                case 44 -> -140641573;
                case 45 -> -291715410;
                case 46 -> -1021262867;
                case 47 -> -426834076;
                case 48 -> -1456676559;
                case 49 -> 1492857858;
                case 50 -> -1012851993;
                case 51 -> -1473857954;
                case 52 -> 2085877895;
                case 53 -> 339323128;
                case 54 -> -1091202995;
                case 55 -> -547540224;
                case 56 -> -305877457;
                case 57 -> 1596978359;
                case 58 -> 1605473308;
                case 59 -> 1750161380;
                case 60 -> 773752779;
                case 61 -> 653666341;
                case 62 -> 1096070166;
                case 63 -> -1474150207;
                case 64 -> -2010559158;
                case 65 -> -1005360351;
                case 66 -> 596017164;
                case 67 -> -1023841656;
                case 68 -> -2032016287;
                case 69 -> 795763884;
                case 70 -> 2102811093;
                case 71 -> -1743028513;
                case 72 -> -598529847;
                case 73 -> -1969230945;
                case 74 -> 336242296;
                case 75 -> 1620584660;
                case 76 -> 267734683;
                case 77 -> -367975880;
                case 78 -> 567153659;
                case 79 -> 1406379696;
                case 80 -> 333689398;
                case 81 -> -564517973;
                case 82 -> -2109676862;
                case 83 -> -609555826;
                case 84 -> -454942289;
                case 85 -> 1172752553;
                case 86 -> -522229115;
                case 87 -> 1117614858;
                case 88 -> 1999104503;
                case 89 -> 1010526228;
                case 90 -> 378426008;
                case 91 -> 1601587824;
                case 92 -> 712527043;
                case 93 -> 1368090782;
                case 94 -> -2085607641;
                case 95 -> 899661305;
                case 96 -> 1752510358;
                case 97 -> -1611658949;
                case 98 -> -97563407;
                case 99 -> 1440990206;
                case 100 -> -1852700350;
                case 101 -> 1672339126;
                case 102 -> -1574799410;
                case 103 -> -1424676008;
                case 104 -> -187010253;
                case 105 -> -975457414;
                case 106 -> -1956566749;
                case 107 -> 1463546328;
                case 108 -> -836702795;
                case 109 -> -458884382;
                case 110 -> 1774248055;
                case 111 -> 178352999;
                case 112 -> -1839226588;
                case 113 -> 1855317047;
                case 114 -> 1342891339;
                case 115 -> 1690260079;
                case 116 -> -1537325114;
                case 117 -> 2129904424;
                case 118 -> 1514537927;
                case 119 -> 836644375;
                case 120 -> -1320325290;
                case 121 -> -1261407993;
                case 122 -> -907116000;
                case 123 -> -715152027;
                case 124 -> -818360011;
                case 125 -> -1531331792;
                case 126 -> -2123748118;
                case 127 -> -1434373530;
                case 128 -> 993488959;
                case 129 -> -220587054;
                case 130 -> 1722632007;
                case 131 -> 1109119001;
                case 132 -> -1940281050;
                case 133 -> 1216627122;
                case 134 -> -1964984067;
                case 135 -> -306280085;
                case 136 -> -138249252;
                case 137 -> 1764700798;
                case 138 -> 86559119;
                case 139 -> 767579812;
                case 140 -> 190489890;
                case 141 -> 1609563252;
                case 142 -> -324058201;
                case 143 -> 717745491;
                case 144 -> 341926686;
                case 145 -> -741717044;
                case 146 -> 1896532211;
                case 147 -> 437151278;
                case 148 -> 1460137018;
                case 149 -> 1191270607;
                case 150 -> -1823952513;
                case 151 -> 546036641;
                case 152 -> -1182664003;
                case 153 -> 1613169598;
                case 154 -> -998385924;
                case 155 -> 982215183;
                case 156 -> -1866011527;
                case 157 -> 1665077518;
                case 158 -> -1273627973;
                case 159 -> -1122618750;
                case 160 -> -1394316159;
                case 161 -> 36230580;
                case 162 -> -681520798;
                case 163 -> -75810179;
                case 164 -> 2138870176;
                case 165 -> 1977733516;
                case 166 -> -665399616;
                case 167 -> 1597269088;
                case 168 -> 2115429200;
                case 169 -> -94896398;
                case 170 -> -1031851116;
                case 171 -> 566676501;
                case 172 -> -2071144881;
                case 173 -> -458564803;
                case 174 -> -981201648;
                case 175 -> -918603695;
                case 176 -> -1622180563;
                case 177 -> 2082893599;
                case 178 -> 77080229;
                case 179 -> 1590788697;
                case 180 -> 47031860;
                case 181 -> -516699293;
                case 182 -> -1549925726;
                case 183 -> 237770858;
                case 184 -> 438212003;
                case 185 -> -953231543;
                case 186 -> 104756251;
                case 187 -> -780206198;
                case 188 -> 612829532;
                case 189 -> -1094099288;
                case 190 -> -1525647256;
                case 191 -> 71824188;
                case 192 -> 1152603506;
                case 193 -> -1298157027;
                case 194 -> -1864679892;
                case 195 -> 334205226;
                case 196 -> -1227186347;
                case 197 -> -148680260;
                case 198 -> 2132189686;
                case 199 -> 322809040;
                case 200 -> -106127054;
                case 201 -> -1639681831;
                case 202 -> 1281197380;
                case 203 -> 597240476;
                case 204 -> -2111015495;
                case 205 -> 1451970163;
                case 206 -> 885571662;
                case 207 -> -2058740339;
                case 208 -> 1504726342;
                case 209 -> -119624811;
                case 210 -> 2120256657;
                case 211 -> -1475155896;
                case 212 -> 543629292;
                case 213 -> -2008750874;
                case 214 -> 306033982;
                case 215 -> -574642557;
                case 216 -> 188916081;
                case 217 -> 264333503;
                case 218 -> 349370545;
                case 219 -> -632738491;
                case 220 -> -751491363;
                case 221 -> -1001874368;
                case 222 -> 946488908;
                case 223 -> 423317059;
                case 224 -> 1117269761;
                case 225 -> -1478463861;
                case 226 -> 2104022278;
                case 227 -> -1792522362;
                case 228 -> 1166658036;
                case 229 -> -1348202835;
                case 230 -> -978826854;
                case 231 -> 640512630;
                case 232 -> -1738800952;
                case 233 -> -188372951;
                case 234 -> -362653805;
                case 235 -> -433345578;
                case 236 -> 1964182665;
                case 237 -> -1726935297;
                case 238 -> 2047841306;
                case 239 -> 1452804079;
                case 240 -> -610008599;
                case 241 -> -568418443;
                case 242 -> 1819376624;
                case 243 -> -890258427;
                case 244 -> 963581137;
                case 245 -> 462811064;
                case 246 -> -1307918637;
                case 247 -> 103049946;
                case 248 -> -1735536033;
                case 249 -> 684980055;
                case 250 -> -1194823174;
                case 251 -> -1492901394;
                case 252 -> 4118148;
                case 253 -> -650065693;
                case 254 -> -1261325339;
                case 255 -> 837993042;
                default -> 37606938;
            });
        } while (v2 != 280);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((byte[])v1)), new IvParameterSpec(new byte[8]));
        v0 = cipher.doFinal(v0);
        int v3 = v0.length;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        v2 = v3 - 32;
        messageDigest.update(v0, 0, v2);
        v1 = messageDigest.digest();
        int v4 = 0;
        int v52 = 0;
        int v6 = 0;
        do {
            v52 |= v0[v2 + v4] ^ v1[v4];
        } while (++v4 != 32);
        if (v52 == 0) {
            Object[] objectArray = new Object[21];
            v1 = objectArray;
            OIIo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        ScaledDrawContext = -4671304;
        Oo0O = 1.0f;
        OoOi = 1.0f;
        00i = 0.5f;
        PacketSendEvent = new int[]{-37186, -8546561, -10494786, -12956};
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        if (this.OooO.isEmpty()) {
            FontRenderer v2 = this.0Io0();
            this.0IOi(v2);
            if (this.OooO.isEmpty()) {
                return;
            }
            this.0IoO();
            this.PacketReceiveEvent = Math.max(1.0f, (float)this.0II0(v2) * this.0IoI() * this.OIo() + (float)this.RenderSupport_oii_4((Integer)this.OIo0.HelpCommand()) * 2.0f);
            this.KillAuraModule = this.OiO();
            this.OoII = this.GuiSupport_OOI();
            this.OoIi = this.OOi();
        }
        for (int v2 = 0; v2 < this.OooO.size(); ++v2) {
            DataRecord_0ii_1 v3 = (DataRecord_0ii_1)this.OooO.get(v2);
            float v4 = this.0I00(v3);
            float v5 = this.0oiI(v3.o00);
            float v6 = (1.0f - v5) * this.ConfigSupport_OII(10.0f);
            float v7 = this.KillAuraModule ? this.OoII - v4 + v6 : this.OoII - v6;
            float v8 = this.OoIi + (float)v2 * (this.PacketReceiveEvent + this.Ooi0);
            this.0I0I(v7, v8, v4, this.PacketReceiveEvent, this.KillAuraModule);
        }
    }

    private int ConfigSupport_0oo0_1(int param1) {
        return switch (this.AutoCollectWaterModule.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> ((Color)this.0Io.HelpCommand()).getRGB();
            case 1 -> 0ooo.Iii().OOi();
            case 2 -> this.0ooI(param1);
            case 3 -> this.0ooi(param1);
            case 4 -> this.0IOo(param1);
        };
    }

    private float 0IIo(FontRenderer param1, float param2) {
        float v3 = (float)this.0II0(param1) * this.0Ioi();
        float v4 = param2 + (this.PacketReceiveEvent - v3) / 2.0f;
        return this.0Ioo() ? v4 + 1.0f * this.OIo() : v4;
    }

    private void 0IoO() {
        this.OoiO = this.RenderSupport_oii_4((Integer)this.OIoO.HelpCommand());
        this.Ooi0 = this.RenderSupport_oii_4((Integer)this.OIoo.HelpCommand());
        this.Ooio = this.0IOI();
        this.OoiI = (Boolean)this.OIoI.HelpCommand() != false ? (float)this.RenderSupport_oii_4((Integer)this.OIoi.HelpCommand()) : 0.0f;
        this.Ooii = (Boolean)this.OIoI.HelpCommand() != false ? this.ConfigSupport_OII(1.0f) : 0.0f;
        this.AutoCollectWaterModule = (EnumType_io0_1)((Object)this.ConfigSupport_OIOI.HelpCommand());
        this.EnumType_OIO0 = (Integer)this.CameraClipModule.HelpCommand();
    }

    private boolean 0oIi() {
        EnumType_io0_1 v1 = (EnumType_io0_1)((Object)this.ConfigSupport_OIOI.HelpCommand());
        return v1 == EnumType_io0_1.ConfigSupport_0OO || v1 == EnumType_io0_1.DataRecord_0O0;
    }
}

