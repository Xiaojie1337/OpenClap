/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.sound.SoundEvents
 */
package clap.gui.screen;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import clap.gui.component.GuiComponent;
import clap.gui.GuiSupport_oi0o_0;
import clap.module.client.ClickGuiModule;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ConfigPanel
extends GuiComponent {
    private float Oo0;
    private boolean Ooo = true;
    private static final float OiO;
    private final MinecraftClient HelpCommand = MinecraftClient.getInstance();
    private float OoO;
    private String Oio = "";
    private long DataRecord_0O0;
    private float Oii;
    private static final float Oi0;
    private boolean OOo;
    private String ConfigSupport_0OO;
    private boolean OiI;
    static Object 0Oo;
    private static volatile /* synthetic */ long __k__gH4it;

    public void 0oO(double param1, double param3) {
        if (this.OOo) {
            this.OOi = (float)param1 - this.OoO;
            this.HudElement = (float)param3 - this.Oo0;
        }
    }

    public boolean 0oi() {
        return this.OiI;
    }

    @Override
    public void GuiSupport_OOI(double param1, double param3, int param5) {
        this.OOo = false;
    }

    public void SpawnerFinderModule(char param1) {
        if (!this.OiI) {
            return;
        }
        if ((Character.isLetterOrDigit(param1) || param1 == '_' || param1 == '-' || param1 == '.') && this.Oio.length() < 32) {
            this.Oio = this.Oio + param1;
        }
    }

    @Override
    public void EventBusApi(int param1, int param2, int param3) {
        if (!this.OiI) {
            return;
        }
        if (param1 == 259) {
            if (!this.Oio.isEmpty()) {
                this.Oio = this.Oio.substring(0, this.Oio.length() - 1);
            }
        } else if (param1 == 257) {
            if (!this.Oio.isEmpty()) {
                0ooo.0Iio().OOo(this.Oio);
                this.Oio = "";
            }
            this.OiI = false;
        } else if (param1 == 256) {
            this.OiI = false;
        }
    }

    @Override
    public void PacketEvent(DrawContext param1, int param2, int param3, float param4) {
        Object v11;
        if (this.OOo) {
            this.OOi = (float)param2 - this.OoO;
            this.HudElement = (float)param3 - this.Oo0;
        }
        GuiSupport_oi0o_0.OOoiO(param1, this.OOi, this.HudElement, this.OOi + this.EventBusApi, this.HudElement + this.O0o, ((Color)ClickGuiModule.OOi0O().IoOO.HelpCommand()).getRGB());
        param1.drawText(this.HelpCommand.textRenderer, "Configs", (int)(this.OOi + 5.0f), (int)(this.HudElement + 5.0f), -1, true);
        param1.drawText(this.HelpCommand.textRenderer, this.Ooo ? "-" : "+", (int)(this.OOi + this.EventBusApi - 10.0f), (int)(this.HudElement + 5.0f), -1, true);
        if (!this.Ooo) {
            return;
        }
        float v5 = this.HudElement + 18.0f;
        List v6 = 0ooo.0IiI().O0o();
        float v7 = Math.min((float)v6.size(), 8.0f) * 16.0f;
        float v8 = 50.0f + v7;
        GuiSupport_oi0o_0.OOoiO(param1, this.OOi, v5, this.OOi + this.EventBusApi, v5 + v8, new Color(35, 35, 35, 200).getRGB());
        param1.drawText(this.HelpCommand.textRenderer, "\u00a77Current: \u00a7a" + 0ooo.0Iii().OoO(), (int)(this.OOi + 5.0f), (int)(v5 + 4.0f), -1, true);
        float v9 = v5 + 16.0f;
        Color v10 = this.OiI ? new Color(70, 70, 70, 220) : new Color(55, 55, 55, 220);
        GuiSupport_oi0o_0.OOoiO(param1, this.OOi + 4.0f, v9, this.OOi + this.EventBusApi - 4.0f, v9 + 14.0f, v10.getRGB());
        Object object = v11 = this.Oio.isEmpty() && !this.OiI ? "\u00a78Enter name..." : this.Oio;
        if (this.OiI && System.currentTimeMillis() % 1000L < 500L) {
            v11 = (String)v11 + "_";
        }
        param1.drawText(this.HelpCommand.textRenderer, (String)v11, (int)(this.OOi + 7.0f), (int)(v9 + 3.0f), -1, true);
        float v12 = v9 + 16.0f;
        float v13 = (this.EventBusApi - 12.0f) / 2.0f;
        this.ConfigSupport_00o_0(param1, param2, param3, this.OOi + 4.0f, v12, v13 - 1.0f, "Save", new Color(60, 140, 60, 200), new Color(80, 173, 80, 200));
        this.ConfigSupport_00o_0(param1, param2, param3, this.OOi + 4.0f + v13 + 1.0f, v12, v13 - 1.0f, "Load", new Color(70, 110, 170, 200), new Color(100, 140, 200, 200));
        this.DataRecord_00I(param1, param2, param3, v6, v12 + 18.0f, v7);
    }

    public ConfigPanel(float param1, float param2, float param3) {
        super(param1, param2, param3, 18.0f);
    }

    private void OoO() {
        this.HelpCommand.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((RegistryEntry)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
    }

    private void ConfigSupport_00o_0(DrawContext param1, int param2, int param3, float param4, float param5, float param6, String param7, Color param8, Color param9) {
        Color v10 = this.0oI(param2, param3, param4, param5, param6, 14.0f) ? param9 : param8;
        GuiSupport_oi0o_0.OOoiO(param1, param4, param5, param4 + param6, param5 + 14.0f, v10.getRGB());
        int v11 = this.HelpCommand.textRenderer.getWidth(param7);
        param1.drawText(this.HelpCommand.textRenderer, param7, (int)(param4 + (param6 - (float)v11) / 2.0f), (int)(param5 + 3.0f), -1, true);
    }

    @Override
    public float OIo() {
        if (!this.Ooo) {
            return 18.0f;
        }
        List v1 = 0ooo.0iOO().O0o();
        float v2 = Math.min((float)v1.size(), 8.0f) * 16.0f;
        return 68.0f + v2;
    }

    private void DataRecord_00I(DrawContext param1, int param2, int param3, List param4, float param5, float param6) {
        float v11;
        int v7 = (int)(this.Oii / 16.0f);
        int v8 = Math.min(param4.size(), v7 + 8 + 1);
        for (int v9 = v7; v9 < v8; ++v9) {
            boolean v16;
            String v10 = (String)param4.get(v9);
            v11 = param5 + (float)(v9 - v7) * 16.0f - this.Oii % 16.0f;
            if (v11 < param5 - 16.0f || v11 > param5 + param6) continue;
            boolean v12 = this.0oI(param2, param3, this.OOi + 4.0f, v11, this.EventBusApi - 24.0f, 14.0f);
            boolean v13 = this.0oI(param2, param3, this.OOi + this.EventBusApi - 18.0f, v11 + 1.0f, 14.0f, 12.0f);
            Color v14 = v10.equals(0ooo.0iO0().OoO()) ? new Color(173, 123, 255, 80) : (v12 ? new Color(50, 50, 50, 220) : new Color(40, 40, 40, 220));
            GuiSupport_oi0o_0.OOoiO(param1, this.OOi + 4.0f, v11, this.OOi + this.EventBusApi - 20.0f, v11 + 16.0f - 2.0f, v14.getRGB());
            int v15 = v10.equals(0ooo.0iOo().OoO()) ? new Color(173, 123, 255).getRGB() : -1;
            param1.drawText(this.HelpCommand.textRenderer, v10, (int)(this.OOi + 8.0f), (int)(v11 + 3.0f), v15, true);
            boolean bl = v16 = v10.equals(this.ConfigSupport_0OO) && System.currentTimeMillis() - this.DataRecord_0O0 < 3000L;
            Color v17 = v16 ? new Color(200, 60, 60, 220) : (v13 ? new Color(160, 50, 50, 220) : new Color(120, 40, 40, 220));
            GuiSupport_oi0o_0.OOoiO(param1, this.OOi + this.EventBusApi - 18.0f, v11 + 1.0f, this.OOi + this.EventBusApi - 4.0f, v11 + 16.0f - 3.0f, v17.getRGB());
            String v18 = v16 ? "?" : "X";
            param1.drawText(this.HelpCommand.textRenderer, v18, (int)(this.OOi + this.EventBusApi - 11.0f - (float)this.HelpCommand.textRenderer.getWidth(v18) / 2.0f), (int)(v11 + 3.0f), -1, true);
        }
        if ((float)param4.size() > 8.0f) {
            float v9 = param6 * (8.0f / (float)param4.size());
            float v10 = Math.max(1.0f, (float)param4.size() * 16.0f - param6);
            v11 = param5 + this.Oii / v10 * (param6 - v9);
            GuiSupport_oi0o_0.OOoiO(param1, this.OOi + this.EventBusApi - 2.0f, v11, this.OOi + this.EventBusApi, v11 + v9, new Color(173, 123, 255, 150).getRGB());
        }
    }

    private void 00i(double param1, double param3, float param5) {
        int v8;
        List v6 = 0ooo.0iOI().O0o();
        float v7 = Math.min((float)v6.size(), 8.0f) * 16.0f;
        if (!this.0oI(param1, param3, this.OOi + 4.0f, param5, this.EventBusApi - 8.0f, v7)) {
            return;
        }
        for (int v9 = v8 = (int)(this.Oii / 16.0f); v9 < Math.min(v6.size(), v8 + 8 + 1); ++v9) {
            String v10 = (String)v6.get(v9);
            float v11 = param5 + (float)(v9 - v8) * 16.0f - this.Oii % 16.0f;
            if (this.0oI(param1, param3, this.OOi + this.EventBusApi - 18.0f, v11 + 1.0f, 14.0f, 12.0f)) {
                if (v10.equals(this.ConfigSupport_0OO) && System.currentTimeMillis() - this.DataRecord_0O0 < 3000L) {
                    0ooo.0iOi().O0i(v10);
                    this.ConfigSupport_0OO = null;
                } else {
                    this.ConfigSupport_0OO = v10;
                    this.DataRecord_0O0 = System.currentTimeMillis();
                }
                this.OoO();
                return;
            }
            if (!this.0oI(param1, param3, this.OOi + 4.0f, v11, this.EventBusApi - 24.0f, 14.0f)) continue;
            this.Oio = v10;
            this.OoO();
            return;
        }
    }

    static {
        __k__gH4it = ConfigPanel.__k__gH4it(1213484669887049233L);
        __rP__gH4it0 = new String[]{"\u6f7c\u447c\u9a6a\ucc4b\u4b58\u9bbc\uf840\u9ac8\u6c62\u4716", "\u6f68\u4471\u9a6f\ucc2c\u4b0a\u9bad\uf81f\u9a31\u6c44\u4707\u9947\ucca8\u4a74\u9ab7\uf935\u9b72\u6d78\u462d\u9862\ucd94"};
        __rP__gH4it1 = new String[]{"\u6f7e\u4472\u9a64\ucc49\u4b5a\u9bba\uf846\u9aca\u6c60\u4708", "\u6f6b\u4472\u9a74\ucc20\u4b43"};
        __rP__gH4it2 = new String[]{"\u6f64\u47bc\u99e5\ucc32\u4b27\u9ba9\uf8ad\u9ac5\u6cd8\u468d\u98a1\ucd9f\u4a28\u9a32\uf950\u9b32\u6db0\u46d2\u9fdf\uca62\u4d96\u9db7\ufeb5\u9c22\u6a3f\u4168\u9e88\ucb52\u4c29\u9c34\uff58\u9dbf\u6ba4\u409c\u9d96\uc8a9\u4fb0\u9f5a\ufc6a\u9eb5\u68ef\u4325\u9c9d\uc99d\u4e91\u9ef5\ufd59\u9f0b\u69f4\u4222\u9c27\uf638\u71fa\ua1de\uc2ff\ua061\u56bb\u7d51\ua39b\uf7a2\u7046\ua0da\uc3a4\ua1c1\u577f\u7c27\ua24a\uf4dd\u7371\ua359\uc092\ua237\u547b\u7ff2\ua1f3\uf541\u723a\ua268\uc15c\ua310\u556c\u7ede\ua03f\uf51d\u7545\ua58a\uc6be\ua43f", "\u6f23\u447f\u9af5\uccf6\u4bd6\u9be1\uf8d4\u9a85"};
        __rP__gH4it3 = new String[]{"\u6f7e\u4467\u9a7d", "\u6f6e\u446f\u9a6c\ucc21\u4b4a\u9ba9\uf85b"};
        byte[] v0 = "\u0000@\u0011y\u0016\u00fe\tc\u00b4y]\u00dc!\u009d\u00cc\u00ec\u00e4\u00de\u001bY\u0097\u0010!\u00f4clDa0\u008b\u00d4q\u00e0\u0080B\u0082\u00a1\u00ed\u00ees\u00a31A\u00be\u00f8z%\u00f5\u00c0\u000e\u0003#\u009bY\u008b\u0097\u0087u\u00b7\u00b1?E\u00c8/[\u001b~\u00d6\u0000\u00ce\u00f6\u00d1W\u00c6\u00cfBs\u0087\u0000\u000ex\u0092;\u00e6\u0004m\u00ea)".getBytes("ISO_8859_1");
        Object[] v1 = "\u0015Q\u00df\u00e3\u00b5d\u00a6u".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 607277507;
                case 1 -> 2058192406;
                case 2 -> 1536118500;
                case 3 -> -552468337;
                case 4 -> 789592067;
                case 5 -> -1618099404;
                case 6 -> 735224285;
                case 7 -> 802937507;
                case 8 -> -440645311;
                case 9 -> -473968215;
                case 10 -> 1036092729;
                case 11 -> 1068613306;
                case 12 -> -1694042231;
                case 13 -> -569479844;
                case 14 -> -665964275;
                case 15 -> 363220209;
                case 16 -> 582595405;
                case 17 -> 2135627043;
                case 18 -> 1410565518;
                case 19 -> 156084970;
                case 20 -> 1605173078;
                case 21 -> -428551049;
                case 22 -> -562730777;
                case 23 -> 871910765;
                case 24 -> -80734506;
                case 25 -> -481506971;
                case 26 -> -684359605;
                case 27 -> -831250052;
                case 28 -> 968523977;
                case 29 -> -1819528078;
                case 30 -> 211729877;
                case 31 -> 1647800844;
                case 32 -> -1215223294;
                case 33 -> 803736623;
                case 34 -> 362634974;
                case 35 -> -1255462557;
                case 36 -> -527576392;
                case 37 -> 1984585113;
                case 38 -> -1136625794;
                case 39 -> -494902586;
                case 40 -> -103753322;
                case 41 -> 1449787257;
                case 42 -> -511894179;
                case 43 -> 1935106041;
                case 44 -> -1340942298;
                case 45 -> -1855105178;
                case 46 -> -69553496;
                case 47 -> 767315016;
                case 48 -> 46958109;
                case 49 -> -724748548;
                case 50 -> -2127362845;
                case 51 -> 165706556;
                case 52 -> -1732200192;
                case 53 -> -1200024131;
                case 54 -> 1462253905;
                case 55 -> -2101547407;
                case 56 -> -1495420411;
                case 57 -> -1332859260;
                case 58 -> 698198376;
                case 59 -> -1565171935;
                case 60 -> -2077760057;
                case 61 -> -133743584;
                case 62 -> 295712225;
                case 63 -> 2090937466;
                case 64 -> 1303505754;
                case 65 -> 1138941857;
                case 66 -> -855786004;
                case 67 -> -1743669131;
                case 68 -> -238392372;
                case 69 -> 2040198558;
                case 70 -> 1586668864;
                case 71 -> 2063876078;
                case 72 -> 46269567;
                case 73 -> 10967185;
                case 74 -> -196102673;
                case 75 -> 1437019610;
                case 76 -> -1925668702;
                case 77 -> -1452616167;
                case 78 -> -2123782372;
                case 79 -> -1262918135;
                case 80 -> 755149753;
                case 81 -> -1533974992;
                case 82 -> 1816606848;
                case 83 -> 1988895018;
                case 84 -> -475260813;
                case 85 -> 13815794;
                case 86 -> -942041957;
                case 87 -> 1679177130;
                case 88 -> -39304796;
                case 89 -> 2055034677;
                case 90 -> -900307573;
                case 91 -> 1024591296;
                case 92 -> 748349700;
                case 93 -> -1134545548;
                case 94 -> -16126765;
                case 95 -> -1710397396;
                case 96 -> 119017049;
                case 97 -> 753255883;
                case 98 -> 829088315;
                case 99 -> 1139094298;
                case 100 -> 1308443461;
                case 101 -> -257305419;
                case 102 -> 1543573221;
                case 103 -> -342078014;
                case 104 -> -1235174225;
                case 105 -> 1574465620;
                case 106 -> 1229636132;
                case 107 -> 303589119;
                case 108 -> -499165855;
                case 109 -> -446295013;
                case 110 -> -824393042;
                case 111 -> 1531757090;
                case 112 -> -1697371980;
                case 113 -> -1325781769;
                case 114 -> 247149490;
                case 115 -> 234730629;
                case 116 -> 186222779;
                case 117 -> 1517366590;
                case 118 -> 1604425835;
                case 119 -> -1764904048;
                case 120 -> -2137228043;
                case 121 -> 879484369;
                case 122 -> -35977563;
                case 123 -> 619652088;
                case 124 -> 1237909138;
                case 125 -> 1588948218;
                case 126 -> -2102719041;
                case 127 -> -555467225;
                case 128 -> 1684448172;
                case 129 -> 497190549;
                case 130 -> 458947978;
                case 131 -> 1617479158;
                case 132 -> 1784836383;
                case 133 -> -1389918384;
                case 134 -> 1241942395;
                case 135 -> -1237888686;
                case 136 -> 796657089;
                case 137 -> -1618714014;
                case 138 -> -1937903690;
                case 139 -> -1961464242;
                case 140 -> -851881242;
                case 141 -> 407437812;
                case 142 -> -129816476;
                case 143 -> -1044911521;
                case 144 -> -52062897;
                case 145 -> 928846653;
                case 146 -> -1056260788;
                case 147 -> -88674264;
                case 148 -> -23771627;
                case 149 -> 1759682779;
                case 150 -> -1065331331;
                case 151 -> 463985975;
                case 152 -> 1634873475;
                case 153 -> 779803527;
                case 154 -> -1382412197;
                case 155 -> -1913196896;
                case 156 -> -1708136654;
                case 157 -> 954790583;
                case 158 -> 1858418353;
                case 159 -> -1199494121;
                case 160 -> -776319833;
                case 161 -> 914812923;
                case 162 -> 938077458;
                case 163 -> -274383952;
                case 164 -> -315302585;
                case 165 -> -1078140968;
                case 166 -> 1256907367;
                case 167 -> 1665134589;
                case 168 -> -897911422;
                case 169 -> -152384406;
                case 170 -> -1038017786;
                case 171 -> 987941743;
                case 172 -> -1497479782;
                case 173 -> 960122241;
                case 174 -> -945590136;
                case 175 -> 1154535214;
                case 176 -> -790487240;
                case 177 -> 433367369;
                case 178 -> -1255386835;
                case 179 -> 774911320;
                case 180 -> 738682929;
                case 181 -> -1924736077;
                case 182 -> 1986515689;
                case 183 -> -525989090;
                case 184 -> -1180286960;
                case 185 -> -408096239;
                case 186 -> 94321270;
                case 187 -> 897236999;
                case 188 -> -758137513;
                case 189 -> 567450369;
                case 190 -> 1213626758;
                case 191 -> -290122562;
                case 192 -> -419217397;
                case 193 -> -938553069;
                case 194 -> -238860183;
                case 195 -> -1249179819;
                case 196 -> 1504199994;
                case 197 -> 1300033833;
                case 198 -> 1531762876;
                case 199 -> -2124500112;
                case 200 -> 1459010168;
                case 201 -> 261476422;
                case 202 -> -1564584098;
                case 203 -> 762784068;
                case 204 -> 1931817267;
                case 205 -> -1253084728;
                case 206 -> 1908779430;
                case 207 -> 1946403799;
                case 208 -> 1817544851;
                case 209 -> 1511162781;
                case 210 -> -302309927;
                case 211 -> -184908051;
                case 212 -> 506319631;
                case 213 -> -62860225;
                case 214 -> -1153038386;
                case 215 -> 893942059;
                case 216 -> 1452581144;
                case 217 -> 1358447828;
                case 218 -> 792555884;
                case 219 -> -1730865837;
                case 220 -> -756749102;
                case 221 -> -1888354412;
                case 222 -> -1033674912;
                case 223 -> -1639433232;
                case 224 -> -580957473;
                case 225 -> 638976159;
                case 226 -> 386684874;
                case 227 -> 412369122;
                case 228 -> 1088633740;
                case 229 -> 106371126;
                case 230 -> 749477925;
                case 231 -> -1371796595;
                case 232 -> 508859203;
                case 233 -> 988549998;
                case 234 -> 1415309642;
                case 235 -> -1821944077;
                case 236 -> 2025745387;
                case 237 -> -2109823593;
                case 238 -> 2013090512;
                case 239 -> -1336574198;
                case 240 -> 2089165997;
                case 241 -> 1697724158;
                case 242 -> 866190862;
                case 243 -> 1138855373;
                case 244 -> -535411516;
                case 245 -> -1259812913;
                case 246 -> 135193820;
                case 247 -> -2016393064;
                case 248 -> -1701683704;
                case 249 -> 22575636;
                case 250 -> -1464281700;
                case 251 -> 80449760;
                case 252 -> 1017263275;
                case 253 -> -1172276248;
                case 254 -> -1505697726;
                case 255 -> -1669575739;
                default -> -1183593923;
            });
        } while (v2 != 88);
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
            Object[] objectArray = new Object[9];
            v1 = objectArray;
            0Oo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        Oi0 = 8.0f;
        OiO = 16.0f;
    }

    private boolean 0oI(double param1, double param3, float param5, float param6, float param7, float param8) {
        return param1 >= (double)param5 && param1 <= (double)(param5 + param7) && param3 >= (double)param6 && param3 <= (double)(param6 + param8);
    }

    @Override
    public void OOo(double param1, double param3, int param5) {
        if (this.0oI(param1, param3, this.OOi, this.HudElement, this.EventBusApi, 18.0f)) {
            if (param5 == 0) {
                this.OOo = true;
                this.OoO = (float)param1 - this.OOi;
                this.Oo0 = (float)param3 - this.HudElement;
                this.OoO();
            } else if (param5 == 1) {
                this.Ooo = !this.Ooo;
                this.OoO();
            }
            return;
        }
        if (!this.Ooo) {
            return;
        }
        float v6 = this.HudElement + 18.0f;
        float v7 = v6 + 16.0f;
        if (this.0oI(param1, param3, this.OOi + 4.0f, v7, this.EventBusApi - 8.0f, 14.0f)) {
            this.OiI = true;
            this.OoO();
            return;
        }
        this.OiI = false;
        float v8 = v7 + 16.0f;
        float v9 = (this.EventBusApi - 12.0f) / 2.0f;
        if (this.0oI(param1, param3, this.OOi + 4.0f, v8, v9 - 1.0f, 14.0f)) {
            String v10 = this.Oio.isEmpty() ? 0ooo.0i0O().OoO() : this.Oio;
            0ooo.0i00().OOi(v10);
            this.Oio = "";
            this.OoO();
            return;
        }
        if (this.0oI(param1, param3, this.OOi + 4.0f + v9 + 1.0f, v8, v9 - 1.0f, 14.0f)) {
            if (!this.Oio.isEmpty() && 0ooo.0i0o().OOo(this.Oio)) {
                this.Oio = "";
            }
            this.OoO();
            return;
        }
        this.00i(param1, param3, v8 + 18.0f);
    }

    public float Oi0() {
        return this.OIo();
    }

    public void 0o0(double param1, double param3, double param5) {
        if (!this.Ooo) {
            return;
        }
        float v7 = this.HudElement + 18.0f + 16.0f + 16.0f + 18.0f;
        List v8 = 0ooo.0i0I().O0o();
        float v9 = Math.min((float)v8.size(), 8.0f) * 16.0f;
        if (this.0oI(param1, param3, this.OOi, v7, this.EventBusApi, v9)) {
            float v10 = Math.max(0.0f, (float)v8.size() * 16.0f - v9);
            this.Oii = (float)Math.max(0.0, Math.min((double)v10, (double)this.Oii - param5 * 16.0));
        }
    }
}

