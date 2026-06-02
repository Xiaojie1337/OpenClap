/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.text.Text
 */
package clap.gui.screen;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import clap.network.NetworkSupport_00OI;
import clap.render.FontRenderer;
import clap.gui.GuiSupport_oi0o_0;

/*
 * Renamed from clap.module.combat.KillAuraModule
 */
public class AuthWelcomeScreen
extends Screen {
    private static final long oii;
    private static final int IOi;
    private static final int SprintModule;
    private static final String IOo;
    private static final long WatermarkHudElement;
    private boolean EnumType_I00;
    private static final int ConfigSupport_IO0;
    private static final long oiI;
    private static final float HelpCommand;
    private final long DataRecord_I0O = System.currentTimeMillis();
    static Object I0o;
    private static volatile /* synthetic */ long __k__gH4it;

    public boolean method_25422() {
        return false;
    }

    private float Module(float param1) {
        return Math.max(0.0f, Math.min(1.0f, param1));
    }

    private float iii(float param1) {
        float v2 = this.Module(param1);
        return 1.0f - (1.0f - v2) * (1.0f - v2) * (1.0f - v2);
    }

    private float iiI(float param1) {
        float v2 = this.Module((1.0f - param1) / 0.16f);
        return this.iii(v2);
    }

    private void iio(DrawContext param1, float param2, float param3, int param4, float param5) {
        FontRenderer v6 = NetworkSupport_00OI.GuiSupport_OOI(136);
        float v7 = (float)v6.GuiSupport_OOI("LOGIN SUCCESSFUL") * 0.5f;
        float v8 = (float)v6.OOi() * 0.5f;
        float v9 = param2 - v7 * 0.5f;
        float v10 = param3 - v8 * 0.5f;
        float v11 = this.iii(this.Module((param5 - 0.06f) / 0.74f));
        if (v11 <= 0.0f) {
            return;
        }
        int v12 = Math.round(v9);
        int v13 = Math.round(v10 - 10.0f);
        int v14 = Math.round(v9 + v7 * v11);
        int v15 = Math.round(v10 + v8 + 12.0f);
        param1.enableScissor(v12, v13, v14, v15);
        this.oIO(param1, v6, "LOGIN SUCCESSFUL", v9, v10, param4);
        param1.disableScissor();
    }

    static {
        __k__gH4it = AuthWelcomeScreen.__k__gH4it((long)-8136258507545514479L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[]{"\u15ce3\udf5b\u8abb\u0c68\ue0cc\u8b4c\udd0c\u14d0\u0159", "\u15d8<\udf40\u8ac2\u0c18\ue0bf\u8b35\udd13\u14d4\u012a\ude58\u8bb6\u0f66\ue3a5\u881f\ude50\u17e8\u0200\udd0d\u88ba", "\u15ce*\udf4a", "\u15db?\udf5b\u8ace\u0d91"};
        __rP__gH4it2 = new String[]{"\u1596>\ude50\u8b25\u0c5c\ue011\u8ba6\udd4f\u1476\u013d\ude31\u88f2\u0f0c\ue31a\u882d\ude6d\u1769\u02f0\uddb9\u8988\u0eec\ue22e\u89f6\udf55\u1690\u0386\udcce\ub6da\u31c0\udd16\ub6b8\ue0fa\u2987\u3ccc\ue3ca\ub74f\u3042\udc92\ub7cd\ue15e\u281d\u3d1a\ue24a\ub77b\u3368\udfae\ub406\ue231\u2b6e\u3e4c\ue179\ub4eb\u3205\ude1e\ub58b\ue3cf\u2a0a\u3f44\ue01f\ub5dd\u35a2\ud9d0\ub2c4\ue4c2\u2d0a\u38cc\ue778\ub207\u3400\ud805\ub341\ue5db", "\u15cc=\udf55\u8ab9\u0c6a\ue0ca\u8b4a\udd0e\u14d2\u0167"};
        __rP__gH4it3 = new String[]{"\u1500,\udf8b\u8a2b\u0c69\ue02c\u8b95\udde9", "\u15de\u001e\udf23\u8af3\u0d98\ue0ff\u8b31"};
        byte[] v0 = "R\u001f\u008b\u0000O\u00a4\u0018\u00bb\u00ba\u0014\u0012\u00efg\u0097k\u00a1\u00dd\u00e1\u0092\u009d\u008f\u00ab\u00b8\u0091,\u009f\u00fd\u00d7\u00bb\u008b\u00ee&#\u00cd\u00f1J1\u0007\u0093\u008a\u00b1\u0013I\u0086#C`\u001d\u00fa=r\u001eF\u00fb\u00e5\u00eb\u0096=\f0\u00f9-\u00b2\u00fe\u008e\u00adc\u00e2S\u00f0?\u00ef".getBytes("ISO_8859_1");
        Object[] v1 = "\u0086O\u009e\u00c08\u00db\u00ed\u00db".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -800355863;
                case 1 -> 758222030;
                case 2 -> -879124726;
                case 3 -> -166300125;
                case 4 -> 89166338;
                case 5 -> -771608430;
                case 6 -> 778190851;
                case 7 -> 2093480796;
                case 8 -> 226972386;
                case 9 -> 927886005;
                case 10 -> 1013398065;
                case 11 -> 1661433913;
                case 12 -> -1970704959;
                case 13 -> -1088754307;
                case 14 -> -1056330500;
                case 15 -> -118767103;
                case 16 -> 699796237;
                case 17 -> -947803956;
                case 18 -> -655095393;
                case 19 -> -1343651648;
                case 20 -> -55991914;
                case 21 -> 1999999763;
                case 22 -> 848842556;
                case 23 -> 1849984077;
                case 24 -> 9604787;
                case 25 -> 1545905374;
                case 26 -> 1063396383;
                case 27 -> 1989241638;
                case 28 -> 1048003372;
                case 29 -> 1596416512;
                case 30 -> 667502175;
                case 31 -> 1912997111;
                case 32 -> -192213006;
                case 33 -> -1968123963;
                case 34 -> 542304047;
                case 35 -> 1093427883;
                case 36 -> -1359299193;
                case 37 -> 40408219;
                case 38 -> 1029105658;
                case 39 -> -1149916806;
                case 40 -> 1567266765;
                case 41 -> 700755619;
                case 42 -> -246939541;
                case 43 -> -395910970;
                case 44 -> 1307807551;
                case 45 -> -1487469546;
                case 46 -> 999053121;
                case 47 -> 2112581287;
                case 48 -> -1895461458;
                case 49 -> -1261000017;
                case 50 -> 384175205;
                case 51 -> 1677591842;
                case 52 -> -613340442;
                case 53 -> -130830605;
                case 54 -> -1270762731;
                case 55 -> -1886249527;
                case 56 -> -1355065068;
                case 57 -> 595573414;
                case 58 -> 1807405385;
                case 59 -> -223001794;
                case 60 -> 218221944;
                case 61 -> 1868886945;
                case 62 -> 1476709770;
                case 63 -> 1468064345;
                case 64 -> 1793002488;
                case 65 -> 25676908;
                case 66 -> 979956592;
                case 67 -> 1676299862;
                case 68 -> 254378417;
                case 69 -> -1127761381;
                case 70 -> 1701866886;
                case 71 -> 1997022688;
                case 72 -> 962140844;
                case 73 -> 1344146984;
                case 74 -> -61124806;
                case 75 -> -1706990057;
                case 76 -> -300738802;
                case 77 -> -1994828100;
                case 78 -> 871641012;
                case 79 -> 55295026;
                case 80 -> 1192505420;
                case 81 -> -1679359503;
                case 82 -> 1885459391;
                case 83 -> 337898863;
                case 84 -> 749551918;
                case 85 -> -742112572;
                case 86 -> 26143301;
                case 87 -> -310089802;
                case 88 -> 1325860370;
                case 89 -> -1094035724;
                case 90 -> -421923859;
                case 91 -> 1678462788;
                case 92 -> -978996482;
                case 93 -> -1499878329;
                case 94 -> -650270386;
                case 95 -> -377315119;
                case 96 -> -1544727736;
                case 97 -> -139811787;
                case 98 -> -213603384;
                case 99 -> 131216226;
                case 100 -> 234117760;
                case 101 -> 37867487;
                case 102 -> -1641991529;
                case 103 -> -1152599598;
                case 104 -> 1778500439;
                case 105 -> 1567681936;
                case 106 -> 225184011;
                case 107 -> -75101570;
                case 108 -> 1961402706;
                case 109 -> -1251140534;
                case 110 -> 94117590;
                case 111 -> 1441942612;
                case 112 -> -1974793316;
                case 113 -> 907405978;
                case 114 -> 242898639;
                case 115 -> -1183654829;
                case 116 -> -370490519;
                case 117 -> 1209022492;
                case 118 -> -1863612440;
                case 119 -> -1628506663;
                case 120 -> 953024424;
                case 121 -> 1704145676;
                case 122 -> -526074045;
                case 123 -> 375617646;
                case 124 -> -1000132298;
                case 125 -> 1127531489;
                case 126 -> 1694250970;
                case 127 -> -88709164;
                case 128 -> -13188771;
                case 129 -> -68800124;
                case 130 -> 709597593;
                case 131 -> -1907367398;
                case 132 -> 1719273196;
                case 133 -> -450300477;
                case 134 -> 897481710;
                case 135 -> 4441323;
                case 136 -> 499842922;
                case 137 -> -460399304;
                case 138 -> 934425702;
                case 139 -> 586424371;
                case 140 -> 2007010569;
                case 141 -> -1055389953;
                case 142 -> 1450865544;
                case 143 -> -758755186;
                case 144 -> -1128842012;
                case 145 -> -583772675;
                case 146 -> -391105519;
                case 147 -> -485929865;
                case 148 -> -2145988071;
                case 149 -> -531272744;
                case 150 -> 1843855108;
                case 151 -> -1446678288;
                case 152 -> -670486149;
                case 153 -> 609828954;
                case 154 -> -234976720;
                case 155 -> -1910833479;
                case 156 -> -488682558;
                case 157 -> -1159405378;
                case 158 -> 755316283;
                case 159 -> 22409837;
                case 160 -> 149501370;
                case 161 -> -1001784034;
                case 162 -> 1409413263;
                case 163 -> -1909260566;
                case 164 -> -1345156547;
                case 165 -> -1006026379;
                case 166 -> -276663940;
                case 167 -> -986008313;
                case 168 -> 1323613403;
                case 169 -> -105994276;
                case 170 -> -2093680799;
                case 171 -> -1378528867;
                case 172 -> -1950023787;
                case 173 -> 1457796748;
                case 174 -> 480435544;
                case 175 -> -1962241833;
                case 176 -> -1000611033;
                case 177 -> -127211143;
                case 178 -> 1620291746;
                case 179 -> -2046391708;
                case 180 -> -118434605;
                case 181 -> -2039436085;
                case 182 -> -1393119886;
                case 183 -> -1732930870;
                case 184 -> -1184624969;
                case 185 -> 1018535869;
                case 186 -> -894774892;
                case 187 -> -1655278989;
                case 188 -> -1642739596;
                case 189 -> -1285414632;
                case 190 -> 1163643496;
                case 191 -> 100898226;
                case 192 -> 145854965;
                case 193 -> -1450031319;
                case 194 -> 1110213223;
                case 195 -> -1775698082;
                case 196 -> -956224476;
                case 197 -> -776815075;
                case 198 -> -296869960;
                case 199 -> -1058663004;
                case 200 -> -1705349474;
                case 201 -> -250198143;
                case 202 -> -684940971;
                case 203 -> -1749574919;
                case 204 -> 1030742411;
                case 205 -> -152419722;
                case 206 -> -1933020079;
                case 207 -> -1648925147;
                case 208 -> -259774912;
                case 209 -> 639893125;
                case 210 -> 1449569937;
                case 211 -> 1384429576;
                case 212 -> -981700153;
                case 213 -> 560446591;
                case 214 -> -398995158;
                case 215 -> -440324733;
                case 216 -> 1246661731;
                case 217 -> -494558156;
                case 218 -> 2016358991;
                case 219 -> -1640252443;
                case 220 -> -49597969;
                case 221 -> 674763923;
                case 222 -> 927169232;
                case 223 -> 128201261;
                case 224 -> 1636678671;
                case 225 -> 529662634;
                case 226 -> -1527593211;
                case 227 -> -1271451683;
                case 228 -> 434534357;
                case 229 -> 1782802584;
                case 230 -> -479495941;
                case 231 -> 645626976;
                case 232 -> 136646257;
                case 233 -> -1161499232;
                case 234 -> -1117478169;
                case 235 -> 1999063949;
                case 236 -> 108846582;
                case 237 -> 584791584;
                case 238 -> 1908387915;
                case 239 -> 1171571171;
                case 240 -> -233493335;
                case 241 -> -1560960702;
                case 242 -> 918469163;
                case 243 -> 227723831;
                case 244 -> -1452042323;
                case 245 -> 1089688923;
                case 246 -> 1160874928;
                case 247 -> -1177017311;
                case 248 -> -913365680;
                case 249 -> -703275902;
                case 250 -> -977964794;
                case 251 -> 1378620603;
                case 252 -> -1199647351;
                case 253 -> 1032831141;
                case 254 -> 1027748166;
                case 255 -> 1413039120;
                default -> 1117692082;
            });
        } while (v2 != 72);
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
            Object[] objectArray = new Object[2];
            v1 = objectArray;
            I0o = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        IOi = -250209240;
        SprintModule = -250538464;
        IOo = "LOGIN SUCCESSFUL";
        ConfigSupport_IO0 = -854017;
        WatermarkHudElement = 3750L;
        oii = 3200L;
        oiI = 550L;
        HelpCommand = 0.5f;
    }

    private void oIO(DrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6) {
        param1.getMatrices().pushMatrix();
        param1.getMatrices().scale(0.5f, 0.5f);
        param2.PacketEvent(param1, param3, param4 / 0.5f, param5 / 0.5f, param6);
        param1.getMatrices().popMatrix();
    }

    public void method_25394(DrawContext param1, int param2, int param3, float param4) {
        long v5 = System.currentTimeMillis() - this.DataRecord_I0O;
        float v7 = this.Module((float)(v5 - 550L) / 3200.0f);
        float v8 = this.iiI(this.Module((float)v5 / 3750.0f));
        int v9 = param1.getScaledWindowWidth();
        int v10 = param1.getScaledWindowHeight();
        int v11 = this.EnumType_OOO0(-250538464, Math.round(241.0f * v8));
        int v12 = this.EnumType_OOO0(-250209240, Math.round(241.0f * v8));
        GuiSupport_oi0o_0.OOI0O(param1, 0, 0, v9, v10, v11, v12, v12, v11);
        float v13 = (float)v9 * 0.5f;
        float v14 = (float)v10 * 0.5f;
        float v15 = 1.0f + this.iii(v7) * 0.08f;
        param1.getMatrices().pushMatrix();
        param1.getMatrices().translate(v13, v14);
        param1.getMatrices().scale(v15, v15);
        param1.getMatrices().translate(-v13, -v14);
        this.iio(param1, v13, v14, this.EnumType_OOO0(-854017, Math.round(255.0f * v8)), v7);
        param1.getMatrices().popMatrix();
        if (!this.EnumType_I00 && v5 >= 3750L) {
            this.EnumType_I00 = true;
            this.field_22787.setScreen(null);
        }
    }

    public AuthWelcomeScreen(String param1) {
        super((Text)Text.literal((String)"clap-auth-welcome"));
    }

    private int EnumType_OOO0(int param1, int param2) {
        int v3 = Math.max(0, Math.min(255, param2));
        return v3 << 24 | param1 & 0xFFFFFF;
    }
}

