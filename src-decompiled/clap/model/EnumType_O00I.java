/*
 * Decompiled with CFR 0.152.
 */
package clap.model;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

final class EnumType_O00I
extends Enum {
    public static final /* enum */ EnumType_O00I SettingContainer;
    public static final /* enum */ EnumType_O00I RenderSupport_ooo_0;
    public static final /* enum */ EnumType_O00I NetworkSupport_o0o_0;
    public static final /* enum */ EnumType_O00I o00;
    private static final /* synthetic */ EnumType_O00I[] oo0;
    public static final /* enum */ EnumType_O00I o0I;
    static Object ooo;

    public static EnumType_O00I[] values() {
        return (EnumType_O00I[])oo0.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_O00I() {
        void param2;
        void param1;
    }

    public static EnumType_O00I valueOf(String param0) {
        return Enum.valueOf(EnumType_O00I.class, param0);
    }

    static {
        byte[] v0 = "sf\u00cc \u000e\u00a2\u00c8Gu\u001d\u00bbA\u00d1o\u00f2$%\u00cb\u0086bYba\u00ec\u00bc\u00b4R/\t\u00a6\u008e\u00df\re)\u00d01~\u001e\u00f4\u009d\u00a8L\u00cfNr\u00ea\u00d9|\u00ee\u00d2\u00b7\n\u00c4\u001dLV1Yfz\"\u00b3\u00d4\u0087\u001a(\u0092\u00fb\f7\u0098%:\u00ce_\u00c6\r\u00ee\u00eb\u00ac\u00cdAM\u00ad\u00f6\u007f\u0086\u0094\u00d8\u00e4h/v%P".getBytes("ISO_8859_1");
        Object[] v1 = "\u00dap\u00a7_&U\u00f42".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -646114537;
                case 1 -> 1979007682;
                case 2 -> -898202564;
                case 3 -> 1803617048;
                case 4 -> 848012049;
                case 5 -> 542501819;
                case 6 -> 1934928587;
                case 7 -> -661280332;
                case 8 -> 1098538367;
                case 9 -> -1276638506;
                case 10 -> 1591618312;
                case 11 -> -572150983;
                case 12 -> 46906217;
                case 13 -> -41353243;
                case 14 -> 1824161491;
                case 15 -> 1218154511;
                case 16 -> -308057914;
                case 17 -> 1767394015;
                case 18 -> 234671254;
                case 19 -> 128608407;
                case 20 -> 143558116;
                case 21 -> -1085583755;
                case 22 -> -612648054;
                case 23 -> 2042511133;
                case 24 -> 984129706;
                case 25 -> -87764238;
                case 26 -> -453302037;
                case 27 -> 1822212808;
                case 28 -> -1231948234;
                case 29 -> -2093876120;
                case 30 -> -1670964029;
                case 31 -> 385748249;
                case 32 -> -1395527455;
                case 33 -> -1988630387;
                case 34 -> -1634759543;
                case 35 -> -906964134;
                case 36 -> -141886595;
                case 37 -> 1461333510;
                case 38 -> -1010267123;
                case 39 -> -128166423;
                case 40 -> -938272505;
                case 41 -> -776737498;
                case 42 -> 1053498871;
                case 43 -> 1701173760;
                case 44 -> -900277348;
                case 45 -> 216146137;
                case 46 -> -881936263;
                case 47 -> -1532581465;
                case 48 -> -668820360;
                case 49 -> 1196910443;
                case 50 -> 966013630;
                case 51 -> -1535468238;
                case 52 -> -2117589423;
                case 53 -> 985565456;
                case 54 -> -283200327;
                case 55 -> 981394977;
                case 56 -> 274017832;
                case 57 -> -359512631;
                case 58 -> 1180681397;
                case 59 -> -807691696;
                case 60 -> -1980680813;
                case 61 -> -1587129862;
                case 62 -> 824685326;
                case 63 -> 2104101108;
                case 64 -> -515913315;
                case 65 -> 663127343;
                case 66 -> 66840312;
                case 67 -> -2106257766;
                case 68 -> 789462149;
                case 69 -> 1586404842;
                case 70 -> 1158202646;
                case 71 -> -756033624;
                case 72 -> 1617050482;
                case 73 -> -722592672;
                case 74 -> 1467831701;
                case 75 -> 114475585;
                case 76 -> -2072975351;
                case 77 -> -412016840;
                case 78 -> -1436896229;
                case 79 -> -1290445036;
                case 80 -> 610031178;
                case 81 -> 253771097;
                case 82 -> 27399221;
                case 83 -> -793267381;
                case 84 -> 873436001;
                case 85 -> -1000947181;
                case 86 -> -1771053080;
                case 87 -> 1857831090;
                case 88 -> 107979305;
                case 89 -> 1041227635;
                case 90 -> 1044060212;
                case 91 -> 1410826414;
                case 92 -> -1315307010;
                case 93 -> 1801493150;
                case 94 -> -413386792;
                case 95 -> 900776924;
                case 96 -> -800084873;
                case 97 -> 236822284;
                case 98 -> 1634665767;
                case 99 -> -1243894270;
                case 100 -> 104183006;
                case 101 -> 1711879040;
                case 102 -> 1062682033;
                case 103 -> -177158661;
                case 104 -> -75310458;
                case 105 -> -2066288239;
                case 106 -> 1323825254;
                case 107 -> 907983651;
                case 108 -> 742639732;
                case 109 -> 572006074;
                case 110 -> -1817568049;
                case 111 -> 16086700;
                case 112 -> 1305859429;
                case 113 -> -1543726335;
                case 114 -> 1463707402;
                case 115 -> -1094254167;
                case 116 -> -1127060897;
                case 117 -> 1812062373;
                case 118 -> -291780753;
                case 119 -> 1896472207;
                case 120 -> 1285783851;
                case 121 -> 1047167748;
                case 122 -> -2144138146;
                case 123 -> -1263835209;
                case 124 -> -2103717749;
                case 125 -> -1779555325;
                case 126 -> -536005327;
                case 127 -> -738706464;
                case 128 -> 921929765;
                case 129 -> -1145384437;
                case 130 -> 2089410952;
                case 131 -> 78374011;
                case 132 -> 1622462981;
                case 133 -> -1143062355;
                case 134 -> 481796122;
                case 135 -> 311962444;
                case 136 -> 1957784924;
                case 137 -> -2000790459;
                case 138 -> -1600639333;
                case 139 -> 1768411725;
                case 140 -> -582154771;
                case 141 -> 1789792853;
                case 142 -> 406772782;
                case 143 -> 1745331501;
                case 144 -> 796801843;
                case 145 -> -601594445;
                case 146 -> -254303139;
                case 147 -> 293343659;
                case 148 -> -1960677867;
                case 149 -> 753475293;
                case 150 -> -91637432;
                case 151 -> -392641343;
                case 152 -> 400472194;
                case 153 -> 1206627392;
                case 154 -> 1083736;
                case 155 -> 561182576;
                case 156 -> 2123022295;
                case 157 -> 632163419;
                case 158 -> 756186143;
                case 159 -> 1539203919;
                case 160 -> 801649334;
                case 161 -> 1232521604;
                case 162 -> -1293093053;
                case 163 -> 131077581;
                case 164 -> -181129916;
                case 165 -> -283481441;
                case 166 -> -517906626;
                case 167 -> 469862243;
                case 168 -> -775039982;
                case 169 -> -1419911449;
                case 170 -> 654780007;
                case 171 -> 1021430246;
                case 172 -> 1509936801;
                case 173 -> 1727579278;
                case 174 -> 1545807559;
                case 175 -> 0x47499799;
                case 176 -> 309366720;
                case 177 -> 358061004;
                case 178 -> -339424650;
                case 179 -> -750607976;
                case 180 -> -661158368;
                case 181 -> -240448898;
                case 182 -> -1953642127;
                case 183 -> -922653776;
                case 184 -> 122918852;
                case 185 -> -1747753297;
                case 186 -> 1938915130;
                case 187 -> 825527036;
                case 188 -> -962491063;
                case 189 -> 9127824;
                case 190 -> 1577394007;
                case 191 -> -1360846782;
                case 192 -> 1985438604;
                case 193 -> 1511999963;
                case 194 -> 608847190;
                case 195 -> 1715460138;
                case 196 -> 1119059511;
                case 197 -> 1446815982;
                case 198 -> -1548636894;
                case 199 -> -931869483;
                case 200 -> -321040432;
                case 201 -> -751661028;
                case 202 -> -1242820735;
                case 203 -> -742386222;
                case 204 -> -1956187137;
                case 205 -> -1733897646;
                case 206 -> -1006931727;
                case 207 -> -931140107;
                case 208 -> 1169538274;
                case 209 -> 511193452;
                case 210 -> -1630053840;
                case 211 -> 1246274084;
                case 212 -> -1154368195;
                case 213 -> 1033209468;
                case 214 -> 1796918218;
                case 215 -> -15876112;
                case 216 -> 846909624;
                case 217 -> 254956132;
                case 218 -> 624615555;
                case 219 -> 1359687871;
                case 220 -> -941383727;
                case 221 -> -1003054010;
                case 222 -> 1848735420;
                case 223 -> 1236421703;
                case 224 -> 1935259455;
                case 225 -> -1638849132;
                case 226 -> 1299665370;
                case 227 -> 128580202;
                case 228 -> -554983258;
                case 229 -> 2062567277;
                case 230 -> -1998749021;
                case 231 -> 120611065;
                case 232 -> 109871982;
                case 233 -> 802626468;
                case 234 -> 1166941885;
                case 235 -> -165683590;
                case 236 -> 2043079892;
                case 237 -> -968249885;
                case 238 -> 1131967219;
                case 239 -> -1296024596;
                case 240 -> -1090088798;
                case 241 -> -165388347;
                case 242 -> 502094434;
                case 243 -> 698891410;
                case 244 -> -801422548;
                case 245 -> -85997490;
                case 246 -> 1165253460;
                case 247 -> 1250107731;
                case 248 -> 1612020510;
                case 249 -> 1791206653;
                case 250 -> -1742036064;
                case 251 -> 818982094;
                case 252 -> -1606484490;
                case 253 -> 1637918447;
                case 254 -> -1819731065;
                case 255 -> -873614021;
                default -> -1845973080;
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
            Object[] objectArray = new Object[5];
            v1 = objectArray;
            ooo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        o00 = new EnumType_O00I("SIGN", 0);
        NetworkSupport_o0o_0 = new EnumType_O00I("PISTON", 1);
        o0I = new EnumType_O00I("STICKY_PISTON", 2);
        SettingContainer = new EnumType_O00I("PISTON_PART", 3);
        RenderSupport_ooo_0 = new EnumType_O00I("STICKY_PISTON_PART", 4);
        oo0 = EnumType_O00I.OoI();
    }

    private static /* synthetic */ EnumType_O00I[] OoI() {
        return new EnumType_O00I[]{o00, NetworkSupport_o0o_0, o0I, SettingContainer, RenderSupport_ooo_0};
    }
}

