/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.sound.SoundEvents
 */
package clap.gui;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import clap.gui.GuiSupport_III;
import clap.gui.GuiSupport_O000;
import clap.gui.component.GuiComponent;
import clap.gui.GuiSupport_OOII;
import clap.core.module.Module;
import clap.module.client.HudEditorModule;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.gui.GuiSupport_oi0o_2;
import clap.module.client.ClickGuiModule;
import clap.gui.GuiSupport_ooi0_2;
import clap.gui.GuiSupport_ooi_4;
import clap.gui.screen.HudEditorScreenV2;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.config.ConfigSupport_OI0i
 */
public class GuiSupport_oi0i_0
extends GuiComponent {
    private final Map RenderSupport_oii_4 = new IdentityHashMap();
    private boolean Ooo;
    private final Module ConfigSupport_OII;
    private final MinecraftClient HelpCommand = MinecraftClient.getInstance();
    static Object OiO;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public void OOo(double param1, double param3, int param5) {
        if (this.Ooo((int)param1, (int)param3)) {
            if (!this.ConfigSupport_OII.I0i0()) {
                return;
            }
            if (param5 == 0) {
                if (this.ConfigSupport_OII instanceof HudEditorModule) {
                    this.HelpCommand.setScreen((Screen)HudEditorScreenV2.iI0());
                } else {
                    this.ConfigSupport_OII.Oo00O();
                }
                this.OoO();
            } else if (param5 == 1 && !this.EnumType_0OI().isEmpty()) {
                this.Ooo = !this.Ooo;
                this.OoO();
            }
        }
        if (this.Ooo && this.ConfigSupport_OII.I0i0()) {
            for (GuiComponent v7 : this.EnumType_0OI()) {
                v7.OOo(param1, param3, param5);
            }
        }
    }

    private void OoO() {
        this.HelpCommand.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((RegistryEntry)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
    }

    @Override
    public void GuiSupport_OOI(double param1, double param3, int param5) {
        if (this.Ooo && this.ConfigSupport_OII.I0i0()) {
            for (GuiComponent v7 : this.EnumType_0OI()) {
                v7.GuiSupport_OOI(param1, param3, param5);
            }
        }
    }

    public boolean StorageEspModule() {
        if (!this.Ooo || !this.ConfigSupport_OII.I0i0()) {
            return false;
        }
        for (GuiComponent v2 : this.EnumType_0OI()) {
            GuiSupport_OOII v3;
            if (!(v2 instanceof GuiSupport_OOII) || !(v3 = (GuiSupport_OOII)v2).ConfigSupport_O0I()) continue;
            return true;
        }
        return false;
    }

    public boolean Kernel32SnapshotApi() {
        return this.Ooo;
    }

    public GuiSupport_oi0i_0(Module param1, float param2, float param3, float param4, float param5) {
        super(param2, param3, param4, param5);
        this.ConfigSupport_OII = param1;
        this.0Oo(param2, param3 + param5);
    }

    private void 0Oo(float param1, float param2) {
        float v3 = param2;
        for (Setting v5 : this.ConfigSupport_OII.ioIO()) {
            if ("Enabled".equals(v5.PacketEvent())) continue;
            GuiComponent v6 = null;
            if (v5.HelpCommand() instanceof GuiSupport_O000) {
                v6 = new GuiSupport_OOII(v5, param1, v3, this.EventBusApi, 16.0f);
            } else if (v5.HelpCommand() instanceof Boolean) {
                v6 = new GuiSupport_oi0o_2(v5, param1, v3, this.EventBusApi, 16.0f);
            } else if (v5.Oio()) {
                v6 = new GuiSupport_ooi_4(v5, param1, v3, this.EventBusApi, 16.0f);
            } else if (v5.OiI()) {
                v6 = new GuiSupport_III(v5, param1, v3, this.EventBusApi, 16.0f);
            } else if (v5.DataRecord_0O0()) {
                v6 = new GuiSupport_ooi0_2(v5, param1, v3, this.EventBusApi, 16.0f);
            }
            if (v6 == null) continue;
            this.RenderSupport_oii_4.put(v5, v6);
            v3 += 16.0f;
        }
    }

    static {
        __k__gH4it = GuiSupport_oi0i_0.__k__gH4it(8778012815152639505L);
        __rP__gH4it0 = new String[]{"\uf599\u0c2f\ud256\u87bb\u034f\u59e4\u6b7b\ud28b"};
        __rP__gH4it1 = new String[]{"\uf552\u0cce\ud25d\u87ce\u009b\u59fa\u6b80"};
        __rP__gH4it2 = new String[]{"\uf570\u0c74\ud196\u8452\u036e\u599d\u6b36\ud212\uf602\u0f0e\ud05e\u85fe\u023a\u58bc\u6ab8\ud399\uf749\u0ef3\ud74e\u824b\u05ec\u5fd5\u6d9b\ud49f\uf027\u0967\ud795\u8315\u0482\u5e29\u6c6c\ud50d\uf124\u081e\ud6c1\u804c\u0773\u5d26\u6ff2\ud65e\uf2eb\u0bb3\ud571\u8122\u061a\u5c99\u6e34\ud7c8\uf3da\u0a06\ud44b\u81bf\u09f5\u533e\u61ed\ud866\ufc1c\u05e9\udb50\u8e89\u0831\u522e\u6066\ud949\ufdb9\u0430\udaa6\u8fdb\u0b0b\u516f\u63ad\udae0\ufe89\u0797\ud9ea\u8c6d\u0a48\u5020\u6217\udb29", "\uf540\u0cdd\ud25b\u87b4\u0369\u59cf\u6bfb\ud2e4\uf65e\u0fb7"};
        __rP__gH4it3 = new String[]{"\uf542\u0cdf\ud255\u87ba\u036b\u59cd\u6bfd\ud2e2\uf65c\u0fb5", "\uf554\u0cd0\ud25e\u87c3\u031b\u59be\u6b84\ud2fd\uf658\u0fc6\ud156\u84b7\u0265\u58a4\u6aae\ud3be\uf764\u0eec\ud073\u85bb", "\uf542\u0cc2\ud24c", "\uf557\u0cef\ud225\u87f3\u0092"};
        byte[] v0 = " \u00a1[~v!1\u0000J\u00c3\u008b\u00da*\b\u00b7\u0083\t6\u0093W\u0084Yl\u00bd\u001f\u009a\u00b0\u0001\u00e2\u00ad\u0093'\u0014\u00eb\u00ec@\u000b\u00ba\u0015l\u00c3^D&j\r\u00db\u00f2\u00fa\u00e3vC\u00bd\u00d2:\u00a4\u0004tU}q\u00ca\u00b9\u0083\u00a9\u00a5\u00ab7S\u0093j2\u0081\u001a\u00ff\u0089\u0018\u00d4\u00d8\u00f3".getBytes("ISO_8859_1");
        Object[] v1 = "\u0093\u00acM]\u001d\u0016\u00b2S".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1077562399;
                case 1 -> -18265010;
                case 2 -> 1077800910;
                case 3 -> 1373613138;
                case 4 -> -1613082879;
                case 5 -> -1673082332;
                case 6 -> 1855565263;
                case 7 -> 1463472509;
                case 8 -> -1029822487;
                case 9 -> -553548729;
                case 10 -> -714345155;
                case 11 -> 1770599748;
                case 12 -> -342802881;
                case 13 -> -888112362;
                case 14 -> -110403092;
                case 15 -> 1510265665;
                case 16 -> 5710754;
                case 17 -> 1681389203;
                case 18 -> 1484521931;
                case 19 -> -1028115605;
                case 20 -> 1153496749;
                case 21 -> -1849834573;
                case 22 -> -1985232386;
                case 23 -> 727442229;
                case 24 -> -1662379480;
                case 25 -> 1438151817;
                case 26 -> -852210959;
                case 27 -> 1591632921;
                case 28 -> -265915652;
                case 29 -> 981436907;
                case 30 -> -94608326;
                case 31 -> -1788277829;
                case 32 -> 1073510244;
                case 33 -> -524509108;
                case 34 -> -199212441;
                case 35 -> 584615558;
                case 36 -> -1017871598;
                case 37 -> -33810700;
                case 38 -> -1540804504;
                case 39 -> -1681378912;
                case 40 -> -1431694414;
                case 41 -> -794970657;
                case 42 -> -1827499414;
                case 43 -> -1212461477;
                case 44 -> 1705177119;
                case 45 -> -387162377;
                case 46 -> 1183004857;
                case 47 -> -35663209;
                case 48 -> -801410182;
                case 49 -> 573427052;
                case 50 -> -1501602051;
                case 51 -> -1483052228;
                case 52 -> -2064229871;
                case 53 -> 535418522;
                case 54 -> 1825107664;
                case 55 -> 1086574254;
                case 56 -> 1433525887;
                case 57 -> -1648702807;
                case 58 -> -2140611631;
                case 59 -> -713319480;
                case 60 -> 850066804;
                case 61 -> 1089396247;
                case 62 -> -1512726851;
                case 63 -> -520796988;
                case 64 -> 1699953852;
                case 65 -> 1834795298;
                case 66 -> -153602015;
                case 67 -> 1676136823;
                case 68 -> 472659668;
                case 69 -> 1347140407;
                case 70 -> -1785577765;
                case 71 -> 1150385913;
                case 72 -> -39858595;
                case 73 -> -143523998;
                case 74 -> 1226625337;
                case 75 -> 1506568640;
                case 76 -> 2047008740;
                case 77 -> -720233662;
                case 78 -> -2124314045;
                case 79 -> -960368613;
                case 80 -> 811313941;
                case 81 -> -1620404949;
                case 82 -> 1347139715;
                case 83 -> -643929651;
                case 84 -> 1600420241;
                case 85 -> -2026294453;
                case 86 -> 2038528050;
                case 87 -> -1115733219;
                case 88 -> 1528173831;
                case 89 -> 1900379266;
                case 90 -> -457601986;
                case 91 -> -1963861453;
                case 92 -> -1953683344;
                case 93 -> 939287590;
                case 94 -> -1430523446;
                case 95 -> -1426493088;
                case 96 -> -2581348;
                case 97 -> 643908278;
                case 98 -> 526949425;
                case 99 -> -352900161;
                case 100 -> -43090827;
                case 101 -> 1798730789;
                case 102 -> -1258233689;
                case 103 -> -466160966;
                case 104 -> -1092087888;
                case 105 -> 1686261805;
                case 106 -> 1134911888;
                case 107 -> -1802460008;
                case 108 -> 1367150045;
                case 109 -> 1857771396;
                case 110 -> 482580311;
                case 111 -> -692258676;
                case 112 -> -339657126;
                case 113 -> -1842301441;
                case 114 -> -1437907541;
                case 115 -> 888270529;
                case 116 -> 1621549393;
                case 117 -> -1695381314;
                case 118 -> 238384014;
                case 119 -> -1085096289;
                case 120 -> 1526436155;
                case 121 -> 500140058;
                case 122 -> -43272960;
                case 123 -> -839146895;
                case 124 -> -1363366279;
                case 125 -> -835456992;
                case 126 -> -1296571592;
                case 127 -> 338813158;
                case 128 -> 1375429893;
                case 129 -> -1626351056;
                case 130 -> 1884392307;
                case 131 -> 465892399;
                case 132 -> -170402037;
                case 133 -> 581525971;
                case 134 -> 1243591704;
                case 135 -> 490065138;
                case 136 -> -190955474;
                case 137 -> -861849428;
                case 138 -> 1696253623;
                case 139 -> 1862624009;
                case 140 -> -2088276267;
                case 141 -> 1421253128;
                case 142 -> 312716949;
                case 143 -> 886848466;
                case 144 -> 675993002;
                case 145 -> -633228286;
                case 146 -> 509774933;
                case 147 -> 307265044;
                case 148 -> 734893526;
                case 149 -> 1311368781;
                case 150 -> -879721306;
                case 151 -> -181878765;
                case 152 -> -1492199512;
                case 153 -> 1972342651;
                case 154 -> -1330281485;
                case 155 -> 1549122122;
                case 156 -> 1295531599;
                case 157 -> -793297284;
                case 158 -> 1209799067;
                case 159 -> 599614516;
                case 160 -> -390817416;
                case 161 -> 1111385104;
                case 162 -> 1690991025;
                case 163 -> -443132440;
                case 164 -> -1063364238;
                case 165 -> 1216349535;
                case 166 -> 418507336;
                case 167 -> -2001055761;
                case 168 -> -1694858938;
                case 169 -> 1754392975;
                case 170 -> 549017592;
                case 171 -> -196915879;
                case 172 -> -1773408531;
                case 173 -> 1705595228;
                case 174 -> -866961554;
                case 175 -> -63533945;
                case 176 -> -1655288826;
                case 177 -> -2092941229;
                case 178 -> 1001024153;
                case 179 -> 355820227;
                case 180 -> 833030956;
                case 181 -> 977453581;
                case 182 -> -1511790651;
                case 183 -> -563884343;
                case 184 -> -672259958;
                case 185 -> -65152587;
                case 186 -> 1421343236;
                case 187 -> 87107882;
                case 188 -> -1416135207;
                case 189 -> 1073736460;
                case 190 -> -125883377;
                case 191 -> -558935643;
                case 192 -> -793678116;
                case 193 -> -1321934958;
                case 194 -> 1660693720;
                case 195 -> -2115422270;
                case 196 -> 1664834925;
                case 197 -> -679065527;
                case 198 -> 2108507934;
                case 199 -> 1852949328;
                case 200 -> -1799641751;
                case 201 -> -1909834408;
                case 202 -> 973422627;
                case 203 -> 1450200675;
                case 204 -> 1269983845;
                case 205 -> -1991127697;
                case 206 -> 529837302;
                case 207 -> 2080392430;
                case 208 -> 1735046139;
                case 209 -> -1609422200;
                case 210 -> 724176993;
                case 211 -> -82991711;
                case 212 -> -720753024;
                case 213 -> -1905133814;
                case 214 -> -1417646947;
                case 215 -> 456159668;
                case 216 -> -1412212362;
                case 217 -> 202788493;
                case 218 -> 1098444282;
                case 219 -> 1822768880;
                case 220 -> 1167393443;
                case 221 -> -308184392;
                case 222 -> -866781472;
                case 223 -> -1868463808;
                case 224 -> -1468182539;
                case 225 -> 999255786;
                case 226 -> -751124817;
                case 227 -> 1948666054;
                case 228 -> -130690986;
                case 229 -> -948275497;
                case 230 -> 2106860438;
                case 231 -> -849579828;
                case 232 -> 412169191;
                case 233 -> -2106282226;
                case 234 -> -918257791;
                case 235 -> 1924240542;
                case 236 -> 996848355;
                case 237 -> 1120485796;
                case 238 -> -524969510;
                case 239 -> -929219106;
                case 240 -> -119386826;
                case 241 -> 2135058534;
                case 242 -> 160498179;
                case 243 -> -345368194;
                case 244 -> 2082495838;
                case 245 -> -398474869;
                case 246 -> 1078501;
                case 247 -> 1305949639;
                case 248 -> -1568791660;
                case 249 -> 1975155996;
                case 250 -> -404945275;
                case 251 -> 1881246277;
                case 252 -> -23570206;
                case 253 -> 587944233;
                case 254 -> -1819457708;
                case 255 -> -985246937;
                default -> 262920774;
            });
        } while (v2 != 80);
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
            Object[] objectArray = new Object[5];
            v1 = objectArray;
            OiO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
    }

    @Override
    public void Oo0(float param1, float param2) {
        super.Oo0(param1, param2);
        if (this.Ooo) {
            float v3 = param2 + this.O0o;
            for (GuiComponent v5 : this.EnumType_0OI()) {
                v5.Oo0(param1, v3);
                v3 += v5.OIo();
            }
        }
    }

    @Override
    public String HelpCommand(int param1, int param2) {
        if (this.Ooo(param1, param2)) {
            if (!this.ConfigSupport_OII.I0i0()) {
                return "Requires Beta access.";
            }
            String v3 = this.ConfigSupport_OII.Oii0();
            return v3 == null || v3.isEmpty() ? null : v3;
        }
        if (this.Ooo) {
            for (GuiComponent v4 : this.EnumType_0OI()) {
                String v5 = v4.HelpCommand(param1, param2);
                if (v5 == null || v5.isEmpty()) continue;
                return v5;
            }
        }
        return null;
    }

    public boolean OiO(double param1, double param3, int param5) {
        if (!this.Ooo || !this.ConfigSupport_OII.I0i0()) {
            return false;
        }
        for (GuiComponent v7 : this.EnumType_0OI()) {
            GuiSupport_OOII v8;
            if (!(v7 instanceof GuiSupport_OOII) || !(v8 = (GuiSupport_OOII)v7).ConfigSupport_O0I()) continue;
            return v8.O0o(param5);
        }
        return false;
    }

    @Override
    public void EventBusApi(int param1, int param2, int param3) {
        if (this.Ooo && this.ConfigSupport_OII.I0i0()) {
            for (GuiComponent v5 : this.EnumType_0OI()) {
                v5.EventBusApi(param1, param2, param3);
            }
        }
    }

    @Override
    public void PacketEvent(DrawContext param1, int param2, int param3, float param4) {
        boolean v5 = this.ConfigSupport_OII.I0i0();
        Color v6 = !v5 ? new Color(28, 28, 28, 180) : (this.Ooo(param2, param3) ? new Color(50, 50, 50, 210) : new Color(35, 35, 35, 200));
        GuiSupport_oi0o_0.OOoiO(param1, this.OOi, this.HudElement, this.OOi + this.EventBusApi, this.HudElement + this.O0o, v6.getRGB());
        int v7 = !v5 ? -8947849 : (this.ConfigSupport_OII.IoOo() ? ((Color)ClickGuiModule.OOi0O().IoO0.HelpCommand()).getRGB() : -1);
        param1.drawText(this.HelpCommand.textRenderer, this.ConfigSupport_OII.iooi(), (int)(this.OOi + 5.0f), (int)(this.HudElement + this.O0o / 2.0f - 4.0f), v7, true);
        if (!v5) {
            param1.drawText(this.HelpCommand.textRenderer, "Beta", (int)(this.OOi + this.EventBusApi - 28.0f), (int)(this.HudElement + this.O0o / 2.0f - 4.0f), -8947849, true);
        } else if (!this.EnumType_0OI().isEmpty()) {
            param1.drawText(this.HelpCommand.textRenderer, this.Ooo ? "-" : "+", (int)(this.OOi + this.EventBusApi - 10.0f), (int)(this.HudElement + this.O0o / 2.0f - 4.0f), -1, true);
        }
        if (this.Ooo && v5) {
            for (GuiComponent v9 : this.EnumType_0OI()) {
                v9.PacketEvent(param1, param2, param3, param4);
            }
        }
    }

    private List EnumType_0OI() {
        ArrayList<GuiComponent> v1 = new ArrayList<GuiComponent>();
        float v2 = this.HudElement + this.O0o;
        for (Setting v4 : this.ConfigSupport_OII.ioIO()) {
            GuiComponent v5;
            if (!v4.0oO() || "Enabled".equals(v4.PacketEvent()) || (v5 = (GuiComponent)this.RenderSupport_oii_4.get(v4)) == null) continue;
            v5.Oo0(this.OOi, v2);
            v1.add(v5);
            v2 += v5.OIo();
        }
        return v1;
    }

    public float 0Oi() {
        if (!this.Ooo || !this.ConfigSupport_OII.I0i0()) {
            return 0.0f;
        }
        float v1 = 0.0f;
        for (GuiComponent v3 : this.EnumType_0OI()) {
            v1 += v3.OIo();
        }
        return v1;
    }
}

