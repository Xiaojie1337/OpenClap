/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package clap.gui;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.DrawContext;
import clap.model.EnumType_0OI;
import clap.gui.GuiSupport_O000;
import clap.render.RenderSupport_OIIO;
import clap.model.DataRecord_OO0O;
import clap.model.DataRecord_ii0_1;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.gui.screen.ClickGuiScreen;
import clap.model.DataRecord_oioi_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.oiI
 */
final class GuiSupport_oii_5 {
    private static final float HelpCommand;
    private static final float GuiSupport_OOI;
    private static final float PacketEvent;
    private static final float OOo;
    static Object OOi;
    private static volatile /* synthetic */ long __k__gH4it;

    private void ConfigSupport_OII(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, Runnable param4) {
        param2.ConfigSupport_O0I(param1, param3, param4);
    }

    private Setting Oii(Setting param1) {
        return param1;
    }

    private void O0i(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, Setting param4, int param5, DataRecord_OO0O param6) {
        boolean v7 = param2.Iii() == param4;
        int v8 = v7 ? RenderSupport_OIIO.0Oi : RenderSupport_OIIO.EnumType_0OI;
        int v9 = v7 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement;
        param2.oii().OoO(param3.0ii(), param3.oOO() + 3.0f, param3.FastWebModule(), param3.oOo() - 6.0f, v8, v9);
        param2.oii().OOo(param3.0ii() + 4.0f, param3.oOO() + 7.0f, 3.0f, param3.oOo() - 14.0f, 1.5f, RenderSupport_OIIO.0o0);
        String v10 = param2.oII(RenderSupport_OIIO.KeepSprintModule, param4.KeystrokesHudElement(), param3.FastWebModule() - 26.0f);
        this.ConfigSupport_OII(param1, param2, param6, () -> {
            float v5 = param3.oOO() + (param3.oOo() - param2.oIo(RenderSupport_OIIO.KeepSprintModule)) * 0.5f - 0.5f;
            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v10, param3.0ii() + 14.0f, v5, -722947);
            String v6 = v7 ? "v" : ">";
            float v7 = param3.0ii() + param3.FastWebModule() - param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, v6) - 12.0f;
            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v6, v7, v5, -1429284376);
        });
        param2.IOi().add(DataRecord_ii0_1.iiO(param4, param3));
    }

    private Setting Oio(Setting param1) {
        return param1;
    }

    void HelpCommand(DrawContext param1, ClickGuiScreen param2, int param3, int param4, float param5, float param6, float param7, List param8) {
        this.OOo(param1, param2, param3, param4, param5, param6, param7, param8, null);
    }

    private Setting ConfigSupport_0OO(Setting param1) {
        return param1;
    }

    private void O0o(DrawContext param1, ClickGuiScreen param2, int param3, int param4, DataRecord_OO0O param5, Setting param6, DataRecord_OO0O param7) {
        int v10;
        DataRecord_OO0O v8 = new DataRecord_OO0O(param5.0ii() + param5.FastWebModule() * 0.48f, param5.oOO() + 1.0f, param5.FastWebModule() * 0.52f, 28.0f);
        String v9 = param2.oII(RenderSupport_OIIO.KeepSprintModule, param6.PacketEvent(), v8.0ii() - param5.0ii() - 12.0f);
        if (param6 != param2.IiI()) {
            this.ConfigSupport_OII(param1, param2, param7, () -> param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v9, param5.0ii(), param5.oOO() + 6.0f, -588647425));
        }
        int n = v10 = v8.0iI(param3, param4) ? RenderSupport_OIIO.0Oi : RenderSupport_OIIO.EnumType_0OI;
        if (param6.DataRecord_0O0()) {
            this.OIo(param1, param2, v8, this.ConfigSupport_0OO(param6), param7);
            return;
        }
        if (param6.OiI()) {
            this.O0i(param1, param2, v8, this.OiO(param6), v10, param7);
            return;
        }
        if (param6.Oio() && param6.DataRecord_00I()) {
            this.Oo0(param1, param2, param5, v8, this.Oi0(param6), param7);
            return;
        }
        if (param6.HelpCommand() instanceof Boolean) {
            this.ConfigSupport_O0I(param1, param2, param5, v8, this.RenderSupport_oii_4(param6));
            return;
        }
        if (param6.HelpCommand() instanceof GuiSupport_O000) {
            this.OoI(param1, param2, param5, v8, this.OiI(param6), v10, param7);
            return;
        }
        if (param6.HelpCommand() instanceof String) {
            this.Ooo(param1, param2, v8, this.Oio(param6), v10, param7);
            return;
        }
        param2.oii().O0o(v8.0ii(), v8.oOO(), v8.FastWebModule(), v8.oOo(), 8.0f, v10, RenderSupport_OIIO.KeystrokesHudElement);
        this.ConfigSupport_OII(param1, param2, param7, () -> param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, param6.0Oi(), v8.0ii() + 10.0f, v8.oOO() + 7.0f, -722947));
    }

    private Setting Oi0(Setting param1) {
        return param1;
    }

    private float EventBusApi(Setting param1) {
        if (param1 == null) {
            return 0.0f;
        }
        return 8.0f + (float)((Enum[])((Enum)param1.HelpCommand()).getClass().getEnumConstants()).length * 22.0f;
    }

    private void Ooo(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, Setting param4, int param5, DataRecord_OO0O param6) {
        boolean v7 = param2.GuiSupport_III() == param4;
        param2.oii().O0o(param3.0ii(), param3.oOO(), param3.FastWebModule(), param3.oOo(), 8.0f, param5, v7 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement);
        String v8 = v7 ? param2.IIi() + (param2.0ii() ? "_" : "") : (String)param4.HelpCommand();
        String v9 = param2.oII(RenderSupport_OIIO.KeepSprintModule, v8, param3.FastWebModule() - 16.0f);
        this.ConfigSupport_OII(param1, param2, param6, () -> param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v9, param3.0ii() + 10.0f, param3.oOO() + 7.0f, -722947));
        param2.IOi().add(DataRecord_ii0_1.iio(param4, param3));
    }

    private boolean HudElement(DataRecord_OO0O param1, DataRecord_OO0O param2) {
        if (param2 == null) {
            return true;
        }
        return param1.oOO() + param1.oOo() >= param2.oOO() && param1.oOO() <= param2.oOO() + param2.oOo();
    }

    void OOo(DrawContext param1, ClickGuiScreen param2, int param3, int param4, float param5, float param6, float param7, List param8, DataRecord_OO0O param9) {
        float v12;
        float v10 = this.PacketEvent(param2, param8);
        DataRecord_OO0O v11 = this.GuiSupport_OOI(new DataRecord_OO0O(param5, param6, param7, v10), param9);
        if (v11.oOo() > 0.0f) {
            v12 = v11.oOO() <= param6 ? 11.0f : 0.0f;
            float v13 = v11.oOO() + v11.oOo() >= param6 + v10 ? 11.0f : 0.0f;
            param2.oii().ConfigSupport_O0I(v11.0ii(), v11.oOO(), v11.FastWebModule(), v11.oOo(), v12, v12, v13, v13, RenderSupport_OIIO.OoI, RenderSupport_OIIO.KeystrokesHudElement);
        }
        v12 = param6 + 7.0f;
        for (Setting v14 : param8) {
            DataRecord_OO0O v19;
            float v17;
            float v16;
            DataRecord_OO0O v15 = new DataRecord_OO0O(param5 + 9.0f, v12, param7 - 18.0f, 26.0f);
            if (this.HudElement(v15, param9)) {
                this.O0o(param1, param2, param3, param4, v15, v14, param9);
            }
            v12 += 31.0f;
            if (v14.OiI() && param2.ConfigSupport_00o_0(v14)) {
                v16 = param2.StorageEspModule(v14);
                v17 = this.EventBusApi(this.OiO(v14));
                float v18 = v17 * v16;
                v19 = new DataRecord_OO0O(v15.0ii() + v15.FastWebModule() * 0.48f, v12 - 1.0f, v15.FastWebModule() * 0.52f, v17);
                DataRecord_OO0O v20 = this.OOi(param9, new DataRecord_OO0O(v19.0ii(), v19.oOO(), v19.FastWebModule(), v18));
                if (v18 > 0.0f && this.HudElement(v19, v20)) {
                    this.OoO(param1, param2, param3, param4, v19, this.OiO(v14), v20);
                }
                v12 += (v17 + 4.0f) * v16;
            }
            if (!v14.DataRecord_0O0() || !param2.DataRecord_00I(v14)) continue;
            v16 = param2.StorageEspModule(v14);
            v17 = 158.0f * v16;
            DataRecord_OO0O v18 = new DataRecord_OO0O(param5 + 16.0f, v12 + 1.0f, param7 - 32.0f, 158.0f);
            v19 = this.OOi(param9, new DataRecord_OO0O(v18.0ii(), v18.oOO(), v18.FastWebModule(), v17));
            if (v17 > 0.0f && this.HudElement(v18, v19)) {
                param2.ConfigSupport_IO0().GuiSupport_OOI(param1, param2, this.ConfigSupport_0OO(v14), v18.0ii(), v18.oOO(), v18.FastWebModule(), v19);
            }
            v12 += 165.0f * v16;
        }
    }

    static {
        __k__gH4it = GuiSupport_oii_5.__k__gH4it((long)1692546073702166033L);
        __rP__gH4it0 = new String[]{"\u7a6b\u59af\u87bc\ud27d\u5565\u1b1c\uf672\u8490\u7d67\u58b9\u86b4\ud319\u540b\u1a06\uf758\u85d3\u7c5b\u5b93\u8591\ud025", "\u7a68\u59a8\u87bf\ud26d\u550c"};
        __rP__gH4it1 = new String[]{"\u7a09\u59a7\u8742\ud2fe\u55d8\u1b09\uf67c\u8463"};
        __rP__gH4it2 = new String[]{"\u7a7d\u59a4\u87bf\ud210\u5505\u1b63\uf603\u8483\u7d63\u58ce", "\u7a7f\u59a6\u87b9\ud216\u5507\u1b61\uf60d\u848d\u7d61\u58cc"};
        __rP__gH4it3 = new String[]{"\u7ae4\u5e6c\u80ab\ud239\u55ff\u1b83\uf663\u84cd\u7d3e\u5968\u8733\ud3f8\u546a\u1af3\uf7f7\u8526\u7cff\u5807\u8667\ud016\u5794\u19c7\uf43c\u8637\u7fe3\u5b0a\u85b3\ud1f7\u5665\u1847\uf51c\u87d5\u7ead\u5a69\u84aa\ud1e8\u5917\u176e\ufa71\u883e\u71d8\u5570\u8b0c\udec7\u5802\u16cc\ufbfc\u89f2\u7046\u549f\u8aed\udf29\u5b7f\u15aa\uf895\u8a0b\u73f8\u57e1\u898f\udc40\u5ad0\u1484\uf98e\u8bd3\u72a6\u561a\u88c4\udd7a\u5aca\u1324\ufe23\u8ca1\u7577\u5123\u8f9b\uda10\u5d58\u126f\uff8d\u8d89\u74c8\u502c\u8e49\udbe2\u5cf3\u11cb\ufcba\u8e6b", "\u7a7d\u59bd\u87ae", "\u7a6d\u59b5\u87bf\ud26c\u5505\u1b64\uf636"};
        byte[] v0 = "\u0083N\u008c#\u0091\u0005\u008a*QB\u001c\u00ea\fm\u0006\u00d9\u00885P\u001c\u00eaQ\u00c5\u00c0\u009c0\u008c\u00f5\u0013\u00a9\u00dd\u00da\u00ea+\u00ad\u0012Y\u0088\u00b89\u0097:\u00035D2-\u00ed\u0011\u00cd\u00fa\u00c3!\\L\u001c\u00a7\u00bb\u0090\u00a2\u0086J/\u00fc\u0001x\u00a3\u00a0d\u00e2\u008a\u0086\u00d8I\u00f4\u00c2\u00fe\u00b1<\u00b6\u007f^>(M\u001d\u0003\\".getBytes("ISO_8859_1");
        Object[] v1 = "<S\u00b3\u00b6\u00e4QK\u00d6".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 15710827;
                case 1 -> 1126636461;
                case 2 -> 543302567;
                case 3 -> -1546049535;
                case 4 -> -2032743885;
                case 5 -> 1521152540;
                case 6 -> 413688830;
                case 7 -> 1630482714;
                case 8 -> -281579596;
                case 9 -> 2099751052;
                case 10 -> 363211803;
                case 11 -> -903953097;
                case 12 -> -1646966568;
                case 13 -> -1936516122;
                case 14 -> -622278755;
                case 15 -> -1516260522;
                case 16 -> -397490041;
                case 17 -> -889690205;
                case 18 -> -577656073;
                case 19 -> 81384378;
                case 20 -> -415418398;
                case 21 -> 389664382;
                case 22 -> -103789887;
                case 23 -> 2067446633;
                case 24 -> -1570268182;
                case 25 -> -593308753;
                case 26 -> -1198700013;
                case 27 -> -400225324;
                case 28 -> -2017563405;
                case 29 -> -1842487485;
                case 30 -> 287515889;
                case 31 -> -870831246;
                case 32 -> 31400692;
                case 33 -> 2060506583;
                case 34 -> -531931298;
                case 35 -> -1481005807;
                case 36 -> -1489244588;
                case 37 -> 458782740;
                case 38 -> 1546051780;
                case 39 -> -32014475;
                case 40 -> -708590;
                case 41 -> 882020751;
                case 42 -> -1061489325;
                case 43 -> -955436025;
                case 44 -> 993496624;
                case 45 -> -301783237;
                case 46 -> 1604590707;
                case 47 -> -785697099;
                case 48 -> 1724557468;
                case 49 -> -1369357335;
                case 50 -> 1952101386;
                case 51 -> 1310398809;
                case 52 -> 833212349;
                case 53 -> 400296383;
                case 54 -> 1534398105;
                case 55 -> 2004405067;
                case 56 -> -431927599;
                case 57 -> -151966814;
                case 58 -> -2112515623;
                case 59 -> 1992000287;
                case 60 -> -545253194;
                case 61 -> 665450747;
                case 62 -> -93658503;
                case 63 -> -145801765;
                case 64 -> 513206770;
                case 65 -> -2036037547;
                case 66 -> -1240248304;
                case 67 -> -1599472147;
                case 68 -> 54214692;
                case 69 -> -1247620020;
                case 70 -> 110355535;
                case 71 -> 624305501;
                case 72 -> 1054191022;
                case 73 -> -1766741695;
                case 74 -> -232334548;
                case 75 -> 1016959910;
                case 76 -> -2123865975;
                case 77 -> -241838241;
                case 78 -> -550733526;
                case 79 -> 1251435727;
                case 80 -> -1099695489;
                case 81 -> 1296958778;
                case 82 -> -37462357;
                case 83 -> 1226080279;
                case 84 -> 1039007101;
                case 85 -> -144966960;
                case 86 -> 214231633;
                case 87 -> -607824292;
                case 88 -> -1967297138;
                case 89 -> -730830864;
                case 90 -> -1331085457;
                case 91 -> -306877246;
                case 92 -> 442989143;
                case 93 -> -2042600443;
                case 94 -> -1754922780;
                case 95 -> 1985978436;
                case 96 -> -1176551978;
                case 97 -> -788779229;
                case 98 -> 1319099197;
                case 99 -> -1134017499;
                case 100 -> 789112188;
                case 101 -> -598542638;
                case 102 -> -1312920102;
                case 103 -> -1084718784;
                case 104 -> 1991371020;
                case 105 -> -664298041;
                case 106 -> -1912004506;
                case 107 -> 562598047;
                case 108 -> -926611201;
                case 109 -> -489235035;
                case 110 -> -475854771;
                case 111 -> -1642282347;
                case 112 -> 1637496658;
                case 113 -> 1932470723;
                case 114 -> -1911166806;
                case 115 -> -1764528885;
                case 116 -> -1800417208;
                case 117 -> -1925238117;
                case 118 -> 493606206;
                case 119 -> -1063245006;
                case 120 -> 337347614;
                case 121 -> -223873338;
                case 122 -> -187027616;
                case 123 -> 1056115054;
                case 124 -> -1512634826;
                case 125 -> 1215018818;
                case 126 -> 83353962;
                case 127 -> 1246792764;
                case 128 -> -839557362;
                case 129 -> -519877944;
                case 130 -> -2002511622;
                case 131 -> -1446399116;
                case 132 -> -1341434256;
                case 133 -> -1676176492;
                case 134 -> 1549921891;
                case 135 -> 238113838;
                case 136 -> -1813611624;
                case 137 -> 445980089;
                case 138 -> -616515559;
                case 139 -> -1545699924;
                case 140 -> -413949202;
                case 141 -> -1398002643;
                case 142 -> -1716524376;
                case 143 -> -1163805467;
                case 144 -> 829353166;
                case 145 -> -1347439825;
                case 146 -> 152617641;
                case 147 -> 495807875;
                case 148 -> 1896131192;
                case 149 -> 535431448;
                case 150 -> -1509475174;
                case 151 -> -342917542;
                case 152 -> -1607748405;
                case 153 -> -2035921811;
                case 154 -> 558821730;
                case 155 -> 1759329319;
                case 156 -> 951517995;
                case 157 -> 52021642;
                case 158 -> 1110433893;
                case 159 -> 773332972;
                case 160 -> 1353033399;
                case 161 -> 1439227144;
                case 162 -> -2025172488;
                case 163 -> 1193060491;
                case 164 -> 1217748883;
                case 165 -> -1246289048;
                case 166 -> -1116713654;
                case 167 -> -1629830044;
                case 168 -> -1314025943;
                case 169 -> -177545336;
                case 170 -> -2125050413;
                case 171 -> -2119609860;
                case 172 -> 2042437638;
                case 173 -> -2016935965;
                case 174 -> -2096352699;
                case 175 -> -226713450;
                case 176 -> 480229253;
                case 177 -> 977742114;
                case 178 -> 860001526;
                case 179 -> 327298907;
                case 180 -> 1856717561;
                case 181 -> -1353606724;
                case 182 -> -2114977301;
                case 183 -> 1713497730;
                case 184 -> -30887260;
                case 185 -> -2133663866;
                case 186 -> 1999423797;
                case 187 -> 998739681;
                case 188 -> 1324322119;
                case 189 -> 1956492317;
                case 190 -> -1722594520;
                case 191 -> 1272797404;
                case 192 -> -1402635586;
                case 193 -> -766415041;
                case 194 -> 1641941250;
                case 195 -> 696951765;
                case 196 -> -1465900649;
                case 197 -> -113122746;
                case 198 -> 73131448;
                case 199 -> -1520936177;
                case 200 -> -596057737;
                case 201 -> 347838985;
                case 202 -> -1016710041;
                case 203 -> 1519297681;
                case 204 -> 826755093;
                case 205 -> -904211674;
                case 206 -> 906749919;
                case 207 -> -2060082968;
                case 208 -> 317738106;
                case 209 -> 114004814;
                case 210 -> -1612761472;
                case 211 -> 584943069;
                case 212 -> -582639237;
                case 213 -> -2136096848;
                case 214 -> -1241220915;
                case 215 -> -1108320368;
                case 216 -> -1148074299;
                case 217 -> -507499855;
                case 218 -> 1870769354;
                case 219 -> 1456614383;
                case 220 -> -371027399;
                case 221 -> 346151372;
                case 222 -> 1441227267;
                case 223 -> -1153819260;
                case 224 -> -831693951;
                case 225 -> 1521028257;
                case 226 -> -260705305;
                case 227 -> 2105166226;
                case 228 -> 59052021;
                case 229 -> 574869612;
                case 230 -> -2040429408;
                case 231 -> 1092159089;
                case 232 -> 155960990;
                case 233 -> 1699613837;
                case 234 -> 2013959858;
                case 235 -> 2054272534;
                case 236 -> -1496402976;
                case 237 -> 1464166835;
                case 238 -> -1440217548;
                case 239 -> 843633752;
                case 240 -> -841714335;
                case 241 -> -1962704899;
                case 242 -> -63260229;
                case 243 -> 647587328;
                case 244 -> 949168201;
                case 245 -> 1797988318;
                case 246 -> 74607040;
                case 247 -> 1839220749;
                case 248 -> -1509634255;
                case 249 -> -537023287;
                case 250 -> -2119285130;
                case 251 -> -510926000;
                case 252 -> 367384120;
                case 253 -> -2061903327;
                case 254 -> 1203461380;
                case 255 -> 1216165408;
                default -> 1238555161;
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
            OOi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        GuiSupport_OOI = 0.0f;
        OOo = 72.0f;
        HelpCommand = 7.0f;
        PacketEvent = 31.0f;
    }

    private DataRecord_OO0O GuiSupport_OOI(DataRecord_OO0O param1, DataRecord_OO0O param2) {
        if (param2 == null) {
            return param1;
        }
        float v3 = Math.max(param1.oOO(), param2.oOO());
        float v4 = Math.min(param1.oOO() + param1.oOo(), param2.oOO() + param2.oOo());
        return new DataRecord_OO0O(param1.0ii(), v3, param1.FastWebModule(), Math.max(0.0f, v4 - v3));
    }

    private void Oo0(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, DataRecord_OO0O param4, Setting param5, DataRecord_OO0O param6) {
        boolean v7;
        boolean bl = v7 = param2.Ii0() == param5;
        String v8 = v7 ? param2.Iio() + (param2.0ii() ? "_" : "") : param2.oi0(param5);
        DataRecord_OO0O v9 = new DataRecord_OO0O(param4.0ii() + param4.FastWebModule() - 72.0f - 0.0f, param4.oOO() + 3.0f, 72.0f, 22.0f);
        int v10 = v7 ? RenderSupport_OIIO.0Oi : RenderSupport_OIIO.EnumType_0OI;
        param2.oii().O0o(v9.0ii(), v9.oOO(), v9.FastWebModule(), v9.oOo(), 7.0f, v10, v7 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement);
        float v11 = param4.0ii() + 14.0f;
        float v12 = param4.oOO() + param4.oOo() * 0.5f - 1.0f;
        float v13 = Math.max(28.0f, v9.0ii() - v11 - 16.0f);
        float v14 = v11 + v13 * param2.ooi(param5);
        float v17 = v12 + 1.0f;
        if (v14 - 5.5f > v11) {
            GuiSupport_oi0o_0.OOoiO(param1, v11, v12, v14 - 5.5f, v12 + 2.0f, RenderSupport_OIIO.0oI);
        }
        if (v14 + 5.5f < v11 + v13) {
            GuiSupport_oi0o_0.OOoiO(param1, v14 + 5.5f, v12, v11 + v13, v12 + 2.0f, RenderSupport_OIIO.0oi);
        }
        param2.oii().Ooo(v14, v17, 4.5f, -394241, 0);
        this.ConfigSupport_OII(param1, param2, param6, () -> {
            String v5 = param2.oII(RenderSupport_OIIO.KeepSprintModule, v8, v9.FastWebModule() - 12.0f);
            float v6 = v9.0ii() + (v9.FastWebModule() - param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, v5)) * 0.5f;
            float v7 = param4.oOO() + (param4.oOo() - param2.oIo(RenderSupport_OIIO.KeepSprintModule)) * 0.5f - 0.5f;
            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v5, v6, v7, -722947);
        });
        param2.IOi().add(DataRecord_ii0_1.EnumType_ii0_2(param5, new DataRecord_OO0O(v11, v12 - 9.0f, v13, 18.0f), v9));
    }

    private DataRecord_OO0O OOi(DataRecord_OO0O param1, DataRecord_OO0O param2) {
        if (param1 == null) {
            return param2;
        }
        if (param2 == null) {
            return param1;
        }
        float v3 = Math.max(param1.0ii(), param2.0ii());
        float v4 = Math.max(param1.oOO(), param2.oOO());
        float v5 = Math.min(param1.0ii() + param1.FastWebModule(), param2.0ii() + param2.FastWebModule());
        float v6 = Math.min(param1.oOO() + param1.oOo(), param2.oOO() + param2.oOo());
        return new DataRecord_OO0O(v3, v4, Math.max(0.0f, v5 - v3), Math.max(0.0f, v6 - v4));
    }

    private Setting RenderSupport_oii_4(Setting param1) {
        return param1;
    }

    private Setting KeystrokesHudElement(Setting param1) {
        if (param1.Oo0() == null) {
            return null;
        }
        for (Setting v3 : param1.Oo0().ioIO()) {
            if (!(v3.HelpCommand() instanceof EnumType_0OI) || !"BindMode".equalsIgnoreCase(v3.PacketEvent())) continue;
            return this.Oii(v3);
        }
        return null;
    }

    private Setting OiO(Setting param1) {
        return param1;
    }

    private void ConfigSupport_OI0(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, Setting param4, DataRecord_OO0O param5) {
        if (param4 == null) {
            return;
        }
        boolean v6 = param4.HelpCommand() == EnumType_0OI.HelpCommand;
        int v8 = RenderSupport_OIIO.KeystrokesHudElement;
        param2.oii().OoO(param3.0ii(), param3.oOO(), param3.FastWebModule(), param3.oOo(), 1244476480, v8);
        DataRecord_OO0O v11 = new DataRecord_OO0O(param3.0ii() + 2.0f, param3.oOO() + 2.0f, param3.FastWebModule() * 0.5f - 3.0f, param3.oOo() - 4.0f);
        DataRecord_OO0O v12 = new DataRecord_OO0O(param3.0ii() + param3.FastWebModule() * 0.5f + 1.0f, param3.oOO() + 2.0f, param3.FastWebModule() * 0.5f - 3.0f, param3.oOo() - 4.0f);
        param2.oii().OoO(v11.0ii(), v11.oOO(), v11.FastWebModule(), v11.oOo(), v6 ? -11559425 : 623917896, RenderSupport_OIIO.KeystrokesHudElement);
        param2.oii().OoO(v12.0ii(), v12.oOO(), v12.FastWebModule(), v12.oOo(), v6 ? 623917896 : -11559425, RenderSupport_OIIO.KeystrokesHudElement);
        this.ConfigSupport_OII(param1, param2, param5, () -> {
            float v6 = param3.oOO() + (param3.oOo() - param2.oIo(RenderSupport_OIIO.KeepSprintModule)) * 0.5f - 0.5f;
            float v7 = v11.0ii() + (v11.FastWebModule() - param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, "Hold")) * 0.5f;
            float v8 = v12.0ii() + (v12.FastWebModule() - param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, "Toggle")) * 0.5f;
            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, "Hold", v7, v6, v6 ? -1 : -1429284376);
            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, "Toggle", v8, v6, v6 ? -1429284376 : -1);
        });
    }

    private void ConfigSupport_O0I(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, DataRecord_OO0O param4, Setting param5) {
        DataRecord_OO0O v6 = new DataRecord_OO0O(param4.0ii() + param4.FastWebModule() - 38.0f, param3.oOO() + 5.0f, 38.0f, 18.0f);
        ((Boolean)param5.HelpCommand()).booleanValue();
        float v8 = param2.0oI(param5);
        param2.oii().OoO(v6.0ii(), v6.oOO(), v6.FastWebModule(), v6.oOo(), param2.0iI(RenderSupport_OIIO.ConfigSupport_00o_0, -11559425, v8), param2.0iI(RenderSupport_OIIO.KeystrokesHudElement, -1510145, v8));
        float v10 = v6.0ii() + 3.0f + (v6.FastWebModule() - 14.0f - 6.0f) * v8;
        param2.oii().Oo0(v10, v6.oOO() + 2.0f, 14.0f, 7.0f, -394241, 0x18FFFFFF);
        param2.IOi().add(DataRecord_ii0_1.iIi(param5, v6));
    }

    private Setting OiI(Setting param1) {
        return param1;
    }

    private String Ooi(GuiSupport_O000 param1) {
        return param1.IoOO();
    }

    float PacketEvent(ClickGuiScreen param1, List param2) {
        if (param2.isEmpty()) {
            return 0.0f;
        }
        float v3 = 12.0f + (float)param2.size() * 31.0f;
        for (Setting v5 : param2) {
            float v6;
            if (v5.DataRecord_0O0() && param1.DataRecord_00I(v5)) {
                v6 = param1.StorageEspModule(v5);
                v3 += 165.0f * v6;
            }
            if (!v5.OiI() || !param1.ConfigSupport_00o_0(v5)) continue;
            v6 = param1.StorageEspModule(v5);
            v3 += (this.EventBusApi(this.OiO(v5)) + 4.0f) * v6;
        }
        return v3;
    }

    private void OIo(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, Setting param4, DataRecord_OO0O param5) {
        boolean v6 = param2.IiI() == param4;
        param2.oii().O0o(param3.0ii(), param3.oOO(), param3.FastWebModule(), param3.oOo(), 8.0f, RenderSupport_OIIO.EnumType_0OI, v6 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement);
        Color v7 = (Color)param4.HelpCommand();
        DataRecord_OO0O v8 = new DataRecord_OO0O(param3.0ii() + param3.FastWebModule() - 30.0f, param3.oOO() + 4.0f, 20.0f, 20.0f);
        param2.oii().Oo0(v8.0ii(), v8.oOO(), v8.FastWebModule(), 5.0f, v7.getRGB(), -1325400065);
        this.ConfigSupport_OII(param1, param2, param5, () -> param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, param2.oIi(v7), param3.0ii() + 10.0f, param3.oOO() + 7.0f, -722947));
        param2.IOi().add(DataRecord_ii0_1.Module(param4, param3, null, null));
    }

    private void OoO(DrawContext param1, ClickGuiScreen param2, int param3, int param4, DataRecord_OO0O param5, Setting param6, DataRecord_OO0O param7) {
        DataRecord_OO0O v8 = this.GuiSupport_OOI(param5, param7);
        if (v8.oOo() <= 0.0f) {
            return;
        }
        param2.oii().ConfigSupport_O0I(v8.0ii(), v8.oOO(), v8.FastWebModule(), v8.oOo(), v8.oOO() <= param5.oOO() ? 10.0f : 0.0f, v8.oOO() <= param5.oOO() ? 10.0f : 0.0f, v8.oOO() + v8.oOo() >= param5.oOO() + param5.oOo() ? 10.0f : 0.0f, v8.oOO() + v8.oOo() >= param5.oOO() + param5.oOo() ? 10.0f : 0.0f, RenderSupport_OIIO.DataRecord_00I, RenderSupport_OIIO.AutoMlgModule);
        Enum[] v9 = (Enum[])((Enum)param6.HelpCommand()).getClass().getEnumConstants();
        float v10 = param5.oOO() + 4.0f;
        for (Enum v14 : v9) {
            DataRecord_OO0O v15 = new DataRecord_OO0O(param5.0ii() + 5.0f, v10, param5.FastWebModule() - 10.0f, 18.0f);
            if (this.HudElement(v15, param7)) {
                int v19;
                DataRecord_OO0O v16 = this.GuiSupport_OOI(v15, param7);
                boolean v17 = v15.0iI(param3, param4);
                boolean v18 = v14.name().equals(((Enum)param6.HelpCommand()).name());
                int n = v18 ? RenderSupport_OIIO.Oii : (v19 = v17 ? RenderSupport_OIIO.OiI : RenderSupport_OIIO.Oio);
                if (v19 != 0 && v16.oOo() > 0.0f) {
                    param2.oii().OOo(v16.0ii(), v16.oOO(), v16.FastWebModule(), v16.oOo(), 6.0f, v19);
                }
                String v20 = param2.oII(RenderSupport_OIIO.KeepSprintModule, v14.name(), v15.FastWebModule() - 20.0f);
                this.ConfigSupport_OII(param1, param2, param7, () -> {
                    if (v15.oOO() >= v8.oOO() && v15.oOO() + v15.oOo() <= v8.oOO() + v8.oOo()) {
                        float v6 = v15.oOO() + (v15.oOo() - param2.oIo(RenderSupport_OIIO.KeepSprintModule)) * 0.5f - 0.5f;
                        param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v20, v15.0ii() + 8.0f, v6, v18 ? -722947 : -588647425);
                        if (v18) {
                            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, "*", v15.0ii() + v15.FastWebModule() - 12.0f, v6, -1429284376);
                        }
                    }
                });
                param2.DataRecord_I0O().add(new DataRecord_oioi_0(param6, v14, v16));
            }
            v10 += 22.0f;
        }
    }

    private void OoI(DrawContext param1, ClickGuiScreen param2, DataRecord_OO0O param3, DataRecord_OO0O param4, Setting param5, int param6, DataRecord_OO0O param7) {
        boolean v8 = param2.IiO() == param5;
        String v9 = v8 ? "Press key" : this.Ooi((GuiSupport_O000)param5.HelpCommand());
        float v10 = param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, v9);
        float v11 = Math.min(param4.FastWebModule(), Math.max(72.0f, v10 + 34.0f));
        DataRecord_OO0O v12 = new DataRecord_OO0O(param4.0ii() + param4.FastWebModule() - v11, param4.oOO() + 3.0f, v11, 22.0f);
        DataRecord_OO0O v15 = new DataRecord_OO0O(v12.0ii() - 8.0f - 118.0f, param4.oOO() + 3.0f, 118.0f, 22.0f);
        int v16 = v8 ? RenderSupport_OIIO.0Oi : 1513768530;
        int v17 = v8 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement;
        this.ConfigSupport_OI0(param1, param2, v15, this.KeystrokesHudElement(param5), param7);
        param2.oii().OoO(v12.0ii(), v12.oOO(), v12.FastWebModule(), v12.oOo(), v16, v17);
        this.ConfigSupport_OII(param1, param2, param7, () -> {
            String v5 = param2.oII(RenderSupport_OIIO.KeepSprintModule, v9, v12.FastWebModule() - 24.0f);
            float v6 = v12.0ii() + (v12.FastWebModule() - param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, v5)) * 0.5f;
            float v7 = v12.oOO() + (v12.oOo() - param2.oIo(RenderSupport_OIIO.KeepSprintModule)) * 0.5f - 0.5f;
            param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v5, v6, v7, v8 ? -722947 : -588647425);
        });
        param2.IOi().add(DataRecord_ii0_1.iii(param5, v12, v15));
    }

    GuiSupport_oii_5() {
    }
}

