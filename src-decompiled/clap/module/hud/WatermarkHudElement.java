/*
 * Decompiled with CFR 0.152.
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.network.NetworkSupport_00OI;
import clap.model.DataRecord_I0O;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.setting.Setting;
import clap.render.ScaledDrawContext;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WatermarkHudElement
extends HudElement {
    private static final Color OIii;
    private static final int OIIi;
    private static final float OIIo;
    private static final int OIi0;
    private static final int OIiI;
    private static final int OiOo;
    private static final int OIio;
    private static final int PrefixCommand;
    private static final Color NotificationsModule;
    private DataRecord_I0O GuiSupport_oi0o_2;
    public Setting Oi0O = this.OOi0I("Text", "Clap");
    private static final int RenderSupport_oiio_4;
    public Setting Oi00 = this.OOi00("ShowVersion", true);
    private static final int OiOI;
    private static final int OiOi;
    private long EnumType_oi0i_1 = Long.MIN_VALUE;
    private static final float 00i;
    private static final int ConfigSupport_OIII;
    static Object Oi0i;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        FontRenderer v2 = NetworkSupport_00OI.GuiSupport_OOI(28);
        FontRenderer v3 = NetworkSupport_00OI.OOo(16);
        DataRecord_I0O v4 = this.0i00(v2, v3);
        PostProcessingModule.Ioio(v4.Ooo, v4.OoI, v4.Ooi, v4.KeystrokesHudElement, v4.oi0);
    }

    private void 0iO0(float param1, float param2, int param3, int param4, long param5, boolean param7) {
        int v8 = param7 ? 5 : 2;
        for (int v9 = 0; v9 < v8; ++v9) {
            long v10 = param5 / (param7 ? 32L : 80L) + (long)v9 * 31L;
            float v12 = param1 + (float)Math.floorMod(v10 * 7L, Math.max(6, param3));
            float v13 = param2 + (float)Math.floorMod(v10 * 11L, Math.max(4, param4));
            float v14 = 3.0f + (float)Math.floorMod(v10 * 5L, param7 ? 12 : 7);
            float v15 = 1.0f + (float)Math.floorMod(v10 * 3L, 3);
            RenderSupport_00oi_0.Ooi(v12, v13, v14, v15, this.0IOO(1526723012, param7 ? 110 : 58));
        }
    }

    private void 0Iii(ScaledDrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6, int param7) {
        float v8 = param4;
        for (int v9 = 0; v9 < param3.length(); ++v9) {
            String v10 = param3.substring(v9, v9 + 1);
            int v11 = Math.max(1, param2.GuiSupport_OOI(v10));
            float v12 = param6 <= 1 ? 0.0f : (v8 - param4) / Math.max(1.0f, (float)param6 - 1.0f);
            int v13 = param7 >>> 24 == 0 ? param7 : this.0IOO(this.0iOI(OIii, NotificationsModule, v12).getRGB(), param7 >>> 24 & 0xFF);
            param2.PacketEvent(param1.ConfigSupport_O0I(), v10, v8, param5, v13);
            v8 += (float)v11;
        }
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        super.O0i(param1);
        FontRenderer v2 = NetworkSupport_00OI.GuiSupport_OOI(28);
        FontRenderer v3 = NetworkSupport_00OI.OOo(16);
        DataRecord_I0O v4 = this.0i00(v2, v3);
        PostProcessingModule.IoiO(v4.Ooo, v4.OoI, v4.Ooi, v4.KeystrokesHudElement, v4.oi0, 0x60303030);
        RenderSupport_00oi_0.HudElement(() -> {
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(param2.oIo, param2.oIo);
            this.0Iio(param1, v2, param2.HelpCommand, (float)param2.OoO / param2.oIo, (float)param2.Oo0 / param2.oIo);
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
            if (param2.ConfigSupport_oi0_2) {
                param1.ConfigSupport_O0I().getMatrices().pushMatrix();
                param1.ConfigSupport_O0I().getMatrices().scale(param2.oII, param2.oII);
                v3.PacketEvent(param1.ConfigSupport_O0I(), param2.oIO, (float)param2.oIi / param2.oII, (float)param2.RenderSupport_oio_2 / param2.oII, -6645094);
                param1.ConfigSupport_O0I().getMatrices().popMatrix();
            }
        });
        this.Oii(v4.Ooo, v4.OoI, v4.Ooi, v4.KeystrokesHudElement);
    }

    private void 0IiI(ScaledDrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6, int param7, long param8, boolean param10, float param11, float param12) {
        int v16;
        float v13 = param10 ? 242.0f : 228.0f;
        float v14 = 0.78f + (float)((Math.sin((double)param8 / 48.0) + 1.0) * 0.11);
        this.0Iii(param1, param2, param3, param4 + param11 * 0.28f, param5 + param12 * 0.22f, param6, this.0IOO(16244083, Math.round(v13 * v14)));
        int v15 = param10 ? 4 : 3;
        for (v16 = 0; v16 < v15; ++v16) {
            float v17 = param5 - 1.0f + (float)((param8 / 11L + (long)v16 * 4L) % (long)Math.max(2, param7));
            float v18 = 2.0f + (float)((param8 / 17L + (long)v16 * 5L) % 2L);
            float v19 = (float)((param8 / 29L + (long)v16 * 9L) % 7L - 3L) * (param10 ? 0.75f : 0.35f);
            int v20 = Math.round((param10 ? 238.0f : 216.0f) * (0.82f + (float)((param8 / 23L + (long)v16 * 13L) % 4L) * 0.06f));
            int v21 = Math.round(param4 - 4.0f);
            int v22 = Math.round(v17);
            int v23 = Math.round(param4 + (float)param6 + 4.0f);
            int v24 = Math.round(v17 + v18);
            if (v24 <= v22) continue;
            param1.ConfigSupport_O0I().enableScissor(v21, v22, v23, v24);
            this.0Iii(param1, param2, param3, param4 + v19 + param11, param5 + param12 * 0.3f, param6, this.0IOO(16114290, v20));
            param1.ConfigSupport_O0I().disableScissor();
        }
        if (param10) {
            v16 = 120 + (int)(param8 / 19L % 80L);
            this.0Iii(param1, param2, param3, param4 - 1.6f, param5 + 0.15f, param6, this.0IOO(16773536, v16));
        }
    }

    private void 0iOO(ScaledDrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6, int param7, long param8, boolean param10, float param11, int param12) {
        int v13 = param10 ? 4 : 3;
        for (int v14 = 0; v14 < v13; ++v14) {
            float v15 = param5 - 1.0f + (float)((param8 / 13L + (long)v14 * 5L) % (long)Math.max(2, param7));
            float v16 = 2.0f + (float)((param8 / 7L + (long)v14 * 3L) % 3L);
            float v17 = param11 + (float)((param8 / 17L + (long)v14 * 11L) % 5L - 2L) * (param10 ? 0.9f : 0.45f);
            int v18 = Math.round(param4 - 6.0f);
            int v19 = Math.round(v15);
            int v20 = Math.round(param4 + (float)param6 + 6.0f);
            int v21 = Math.round(v15 + v16);
            if (v21 <= v19) continue;
            param1.ConfigSupport_O0I().enableScissor(v18, v19, v20, v21);
            param2.PacketEvent(param1.ConfigSupport_O0I(), param3, param4 + v17, param5, param12);
            param1.ConfigSupport_O0I().disableScissor();
        }
    }

    private Color 0iOI(Color param1, Color param2, float param3) {
        float v4 = Math.max(0.0f, Math.min(1.0f, param3));
        int v5 = Math.round((float)param1.getRed() + (float)(param2.getRed() - param1.getRed()) * v4);
        int v6 = Math.round((float)param1.getGreen() + (float)(param2.getGreen() - param1.getGreen()) * v4);
        int v7 = Math.round((float)param1.getBlue() + (float)(param2.getBlue() - param1.getBlue()) * v4);
        int v8 = Math.round((float)param1.getAlpha() + (float)(param2.getAlpha() - param1.getAlpha()) * v4);
        return new Color(v5, v6, v7, v8);
    }

    private int 0IOO(int param1, int param2) {
        return (param2 & 0xFF) << 24 | param1 & 0xFFFFFF;
    }

    static {
        __k__gH4it = WatermarkHudElement.__k__gH4it(1225570935491259921L);
        __rP__gH4it0 = new String[]{"\u9e05\ub633\u682c", "\u9e10\ub6de\u6805\u3d93\ubab2"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\u9e36\ub6d9\u680c\u3d93\uba2f\u2077\u6ec5\u6bbd\u9ea9\ub113\u6f6b\u3af3\ubdc2\u2757\u6904\u6ce8\u997c\ub0c0\u6eb6\u3b26\ubc3c\u260a\u68c8\u6dab\u98f0\ub3d3\u6de0\u3897\ubf50\u2592\u6bfe\u6e76\u9be1\ub268\u6cc3\u3956\ube07\u2467\u6a28\u6fca\u9aa4\ub2b1\u735f\u26b9\ua12c\u3bcf\u7518\u70e2\u856a\uad11\u724a\u277a\ua098\u3ad6\u74f2\u716d\u8497\uacce\u71de\u24fc\ua3db\u398b\u77f0\u72c4\u8734\uafbd\u7006\u2546\ua2bf\u383f\u76e4\u732f\u8602\uae7f\u7072\u229d\ua5d9\u3f20\u7142\u7412\u8171\ua95e\u770e\u23e2\ua4bc\u3e7f\u70d5\u7528\u809a\ua8b5\u76bf\u20fd\ua71f\u3dc4\u73c8\u7691", "\u9e05\ub62e\u6835\u3d9a\uba8b\u27ed\u695d\u6c7e\u991b\ub144", "\u9ecd\ub63b\u68aa\u3d6c\uba7a\u27b4\u697e\u6c75", "\u9e07\ub62c\u683b\u3d94\uba89\u27ef\u695b\u6c78\u9919\ub146", "\u9e13\ub621\u683e\u3de3\ubafb\u279e\u6924\u6c61\u991f\ub137\u6f36\u3a97\ubd85\u2684\u680e\u6d22\u9823\ub01d\u6e13\u3bdb", "\u9e15\ub63f\u683d\u3dee\ubabb\u201a\u6960"};
        __rP__gH4it3 = new String[0];
        byte[] v0 = "\u0011\r\u0091\u00cf\u0007;2cv\u00ff\u008e\u00a7\u00e2\u0013\u00fb>\u00ab$[j\u0004V/e?/\u0015\u00d3`\u00c6\u0011\u00b0&\u009c>j\u000f\u00cb\u00fft[\u00bd\u009a\u008d,k\u00c7T\u009d\u0015\u0087V\u0080j5\u00c3x\u00d2\u000b\u00d8\u00cb??b\u00d3\u00a9\u00dbZ\u00d7\u00b3\u00d3\u00b1\u009dSW\u0089\u00b9\u00a4}\u0084\u00e6z#\u00ee\u00c4\u00e3\u00f2\u00a6\u0015\u0089\u008a\u00f9oP\u00e7\u0017".getBytes("ISO_8859_1");
        Object[] v1 = "\u0080I\u00d1\u00aa\u00c8f\u00171".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1834717694;
                case 1 -> 1717460695;
                case 2 -> -2004679503;
                case 3 -> 1870748877;
                case 4 -> -1277618873;
                case 5 -> 121374211;
                case 6 -> 218361231;
                case 7 -> -1074952704;
                case 8 -> -1369463107;
                case 9 -> -200554794;
                case 10 -> 43877780;
                case 11 -> -1011144396;
                case 12 -> 287523243;
                case 13 -> 751985675;
                case 14 -> -1045062129;
                case 15 -> 349540865;
                case 16 -> 572228545;
                case 17 -> -757469047;
                case 18 -> -1112902831;
                case 19 -> -286333796;
                case 20 -> 1538704295;
                case 21 -> -647042139;
                case 22 -> 1664518662;
                case 23 -> 770211741;
                case 24 -> 438225676;
                case 25 -> -1941248781;
                case 26 -> -1272916450;
                case 27 -> 257079275;
                case 28 -> 1599131246;
                case 29 -> 459161210;
                case 30 -> -1204555836;
                case 31 -> -1220016094;
                case 32 -> -802056378;
                case 33 -> 1923151463;
                case 34 -> -539987342;
                case 35 -> -2107085437;
                case 36 -> 1373773406;
                case 37 -> -1934846055;
                case 38 -> -585375286;
                case 39 -> 1744665249;
                case 40 -> 1646789840;
                case 41 -> -1772110635;
                case 42 -> -1223781574;
                case 43 -> -795321255;
                case 44 -> 1526767378;
                case 45 -> -1293040539;
                case 46 -> 850953706;
                case 47 -> 1258744357;
                case 48 -> 799836845;
                case 49 -> -255616360;
                case 50 -> 2084449769;
                case 51 -> -208838056;
                case 52 -> -202573775;
                case 53 -> 584366705;
                case 54 -> -410283196;
                case 55 -> 1948679230;
                case 56 -> 873147191;
                case 57 -> 1433523579;
                case 58 -> -238203817;
                case 59 -> -2006715480;
                case 60 -> 282450457;
                case 61 -> -1677937644;
                case 62 -> 1973694517;
                case 63 -> 1889907299;
                case 64 -> 1833396264;
                case 65 -> 65225681;
                case 66 -> 1845612788;
                case 67 -> -822201208;
                case 68 -> -1354554320;
                case 69 -> -1148852723;
                case 70 -> 736695123;
                case 71 -> -662776175;
                case 72 -> -2130243211;
                case 73 -> 2135653440;
                case 74 -> -1691386477;
                case 75 -> 1880041579;
                case 76 -> 953341222;
                case 77 -> 1449638113;
                case 78 -> -15663827;
                case 79 -> -1063359227;
                case 80 -> -1759782015;
                case 81 -> -1442928401;
                case 82 -> 1781618976;
                case 83 -> -475075563;
                case 84 -> 615632119;
                case 85 -> 110796413;
                case 86 -> 1807973833;
                case 87 -> 1932441852;
                case 88 -> -793391295;
                case 89 -> -6826853;
                case 90 -> -566207759;
                case 91 -> -91617718;
                case 92 -> 1702518504;
                case 93 -> -126127389;
                case 94 -> 681314535;
                case 95 -> -1088467275;
                case 96 -> -628588695;
                case 97 -> 794942520;
                case 98 -> 1652647650;
                case 99 -> 2080226978;
                case 100 -> 2086844652;
                case 101 -> -1878365786;
                case 102 -> -1006018362;
                case 103 -> 1683668452;
                case 104 -> -680716923;
                case 105 -> 1187309171;
                case 106 -> 1256497306;
                case 107 -> 62098380;
                case 108 -> 2112163661;
                case 109 -> 266833967;
                case 110 -> 256068188;
                case 111 -> -1638122189;
                case 112 -> 1212886400;
                case 113 -> 297427881;
                case 114 -> -80738312;
                case 115 -> 1234014993;
                case 116 -> -280254556;
                case 117 -> 103735119;
                case 118 -> 1691390627;
                case 119 -> -1827177835;
                case 120 -> -1521321200;
                case 121 -> 1435087177;
                case 122 -> -263231928;
                case 123 -> -956943862;
                case 124 -> 667590637;
                case 125 -> -443164414;
                case 126 -> 1851221734;
                case 127 -> 2019844984;
                case 128 -> 332352865;
                case 129 -> 273628413;
                case 130 -> -1857843645;
                case 131 -> 1021615368;
                case 132 -> -888038852;
                case 133 -> -613630913;
                case 134 -> 179436543;
                case 135 -> -1772022981;
                case 136 -> 52678260;
                case 137 -> -166708007;
                case 138 -> 1045097667;
                case 139 -> -165115441;
                case 140 -> 108997974;
                case 141 -> -1520090958;
                case 142 -> 1518437003;
                case 143 -> -377765408;
                case 144 -> -2102384722;
                case 145 -> -94570617;
                case 146 -> -1910677858;
                case 147 -> -1043404294;
                case 148 -> 1969235419;
                case 149 -> -465507509;
                case 150 -> -960926425;
                case 151 -> 186042590;
                case 152 -> -776772333;
                case 153 -> -742153556;
                case 154 -> 173370236;
                case 155 -> -1984840654;
                case 156 -> -203123059;
                case 157 -> 717811797;
                case 158 -> 165481245;
                case 159 -> 871938582;
                case 160 -> 24065122;
                case 161 -> 211140996;
                case 162 -> 90225422;
                case 163 -> 428140728;
                case 164 -> 867483986;
                case 165 -> -760111686;
                case 166 -> -504796362;
                case 167 -> -1610971762;
                case 168 -> -2129105770;
                case 169 -> 1656890989;
                case 170 -> 1435625322;
                case 171 -> 586295506;
                case 172 -> -1739603227;
                case 173 -> 1934319471;
                case 174 -> 371560739;
                case 175 -> 1453696656;
                case 176 -> 308177218;
                case 177 -> -289049062;
                case 178 -> -634545878;
                case 179 -> -879360016;
                case 180 -> -1130489933;
                case 181 -> -1339862394;
                case 182 -> -380436692;
                case 183 -> 1622437912;
                case 184 -> -191678629;
                case 185 -> -940359248;
                case 186 -> -1332938285;
                case 187 -> 435153760;
                case 188 -> 107082030;
                case 189 -> -134914124;
                case 190 -> -436695882;
                case 191 -> -1096392512;
                case 192 -> 197037134;
                case 193 -> -1566986672;
                case 194 -> -391156078;
                case 195 -> 1721186525;
                case 196 -> -680569337;
                case 197 -> -1231949892;
                case 198 -> 801212884;
                case 199 -> 148537226;
                case 200 -> 1747292713;
                case 201 -> 851554776;
                case 202 -> 1507174816;
                case 203 -> -1891142753;
                case 204 -> 1070994532;
                case 205 -> 1855531888;
                case 206 -> 707475039;
                case 207 -> 2111953351;
                case 208 -> -636386357;
                case 209 -> -192032129;
                case 210 -> -251657188;
                case 211 -> 160794794;
                case 212 -> -1889042314;
                case 213 -> 707644104;
                case 214 -> 1375374837;
                case 215 -> 1744568770;
                case 216 -> 752816602;
                case 217 -> 1501137804;
                case 218 -> 1953117113;
                case 219 -> 459279915;
                case 220 -> -935194332;
                case 221 -> -1274972568;
                case 222 -> -1674292361;
                case 223 -> 787457787;
                case 224 -> 1000383003;
                case 225 -> 1073424815;
                case 226 -> 1079918879;
                case 227 -> 1867295301;
                case 228 -> -1085490754;
                case 229 -> 341621341;
                case 230 -> -1970174770;
                case 231 -> 531706903;
                case 232 -> 1356684041;
                case 233 -> 155864005;
                case 234 -> -218570947;
                case 235 -> -203130534;
                case 236 -> -1429463361;
                case 237 -> -536575358;
                case 238 -> 1789527329;
                case 239 -> -276197409;
                case 240 -> 708246748;
                case 241 -> -1756567988;
                case 242 -> 1438187884;
                case 243 -> 1948355710;
                case 244 -> -92562860;
                case 245 -> 18820023;
                case 246 -> -498094405;
                case 247 -> 1152307702;
                case 248 -> -2013232124;
                case 249 -> -85138695;
                case 250 -> 351588338;
                case 251 -> -1602259847;
                case 252 -> -1747711130;
                case 253 -> -998561897;
                case 254 -> 0xD39D39;
                case 255 -> 444670446;
                default -> 1745859719;
            });
        } while (v2 != 96);
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
            Object[] objectArray = new Object[6];
            v1 = objectArray;
            Oi0i = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OiOi = 822076026;
        OiOI = 1526723012;
        OiOo = -1459664014;
        PrefixCommand = -1472138497;
        OIiI = -6645094;
        OIio = -805308488;
        OIi0 = 0x30000000;
        RenderSupport_oiio_4 = 0x60303030;
        OIIi = 16;
        ConfigSupport_OIII = 28;
        OIIo = 0.5f;
        00i = 0.5f;
        OIii = new Color(255, 224, 116);
        NotificationsModule = new Color(255, 143, 92);
    }

    private void 0Iio(ScaledDrawContext param1, FontRenderer param2, String param3, float param4, float param5) {
        float v13;
        boolean v12;
        if (param3 == null || param3.isEmpty()) {
            return;
        }
        int v6 = param2.GuiSupport_OOI(param3);
        int v7 = Math.max(1, param2.OOi());
        long v8 = System.currentTimeMillis();
        long v10 = v8 / 70L;
        boolean bl = v12 = v10 % 9L == 0L || v10 % 13L == 5L;
        float f = v12 ? ((v10 & 1L) == 0L ? -1.4f : 1.4f) : (v13 = 0.0f);
        float v14 = v12 ? ((v10 & 2L) == 0L ? -0.55f : 0.55f) : 0.0f;
        param2.PacketEvent(param1.ConfigSupport_O0I(), param3, param4 + 2.0f + v13, param5 + 2.0f + v14, 0x30000000);
        this.0Iii(param1, param2, param3, param4 - 0.6f, param5, v6, 0x42FFFFFF);
        this.0Iii(param1, param2, param3, param4 + 0.6f, param5, v6, 922735468);
        this.0IiI(param1, param2, param3, param4, param5, v6, v7, v8, v12, v13, v14);
        this.0iOO(param1, param2, param3, param4, param5, v6, v7, v8, v12, -1.8f, -1472138497);
        this.0iOO(param1, param2, param3, param4, param5, v6, v7, v8 + 37L, v12, 1.45f, -1459664014);
        if (v12) {
            this.0iOO(param1, param2, param3, param4, param5, v6, v7, v8 + 91L, true, -3.0f, this.0IOO(-1472138497, 132));
            this.0iOO(param1, param2, param3, param4, param5, v6, v7, v8 + 143L, true, 2.6f, this.0IOO(-1459664014, 120));
        }
        this.0iO0(param4, param5, v6, v7, v8, v12);
        this.0iOo(param4, param5, v6, v7, v8, v12);
        param2.PacketEvent(param1.ConfigSupport_O0I(), param3, param4 + v13, param5 - 0.9f + v14, this.0IOO(-805308488, v12 ? 132 : 96));
    }

    private DataRecord_I0O 0i00(FontRenderer param1, FontRenderer param2) {
        long v3 = PostProcessingModule.IoIi();
        if (this.EnumType_oi0i_1 == v3 && this.GuiSupport_oi0o_2 != null) {
            return this.GuiSupport_oi0o_2;
        }
        String v5 = this.0iOi();
        String v6 = this.0i0O();
        boolean v7 = (Boolean)this.Oi00.HelpCommand();
        float v8 = 0.5f * this.OIo();
        float v9 = 0.5f * this.OIo();
        int v10 = (int)this.GuiSupport_OOI();
        int v11 = (int)this.OOi();
        int v12 = this.RenderSupport_oii_4(7);
        int v13 = this.RenderSupport_oii_4(5);
        int v14 = this.RenderSupport_oii_4(5);
        int v15 = Math.round((float)param1.GuiSupport_OOI(v5) * v8);
        int v16 = v7 ? Math.round((float)param2.GuiSupport_OOI(v6) * v9) : 0;
        int v17 = Math.round((float)param1.OOi() * v8);
        int v18 = v7 ? Math.round((float)param2.OOi() * v9) : 0;
        int v19 = v15 + (v7 ? v14 + v16 : 0);
        int v20 = Math.max(v17, v18);
        int v21 = v10 + v15 + v14;
        int v22 = v11 + v17 - v18;
        this.EnumType_oi0i_1 = v3;
        this.GuiSupport_oi0o_2 = new DataRecord_I0O(v5, v6, v7, v8, v9, v10, v11, v21, v22, v10 - v12, v11 - v13, v19 + v12 * 2, v20 + v13 * 2, this.RenderSupport_oii_4(8));
        return this.GuiSupport_oi0o_2;
    }

    private void 0iOo(float param1, float param2, int param3, int param4, long param5, boolean param7) {
        float v8 = Math.floorMod(param5 / (param7 ? 18L : 26L), Math.max(1, param4 + 8));
        float v9 = param2 - 3.0f + v8;
        RenderSupport_00oi_0.Ooi(param1 - 1.0f, v9, (float)param3 + 2.0f, param7 ? 2.2f : 1.2f, this.0IOO(822076026, param7 ? 86 : 42));
    }

    public WatermarkHudElement() {
        super("Watermark", "Display watermark", 100.0f, 10.0f);
    }

    private String 0i0O() {
        return "v1";
    }

    private String 0iOi() {
        return ((String)this.Oi0O.HelpCommand()).isBlank() ? "Clap" : (String)this.Oi0O.HelpCommand();
    }
}

