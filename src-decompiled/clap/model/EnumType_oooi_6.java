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

/*
 * Renamed from psx.Hyk.Oooi
 */
final class EnumType_oooi_6
extends Enum {
    public static final /* enum */ EnumType_oooi_6 Io0;
    private static final /* synthetic */ EnumType_oooi_6[] IoI;
    public static final /* enum */ EnumType_oooi_6 IoO;
    public static final /* enum */ EnumType_oooi_6 Ioo;
    static Object Ioi;

    public static EnumType_oooi_6[] values() {
        return (EnumType_oooi_6[])IoI.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oooi_6() {
        void param2;
        void param1;
    }

    public static EnumType_oooi_6 valueOf(String param0) {
        return Enum.valueOf(EnumType_oooi_6.class, param0);
    }

    static {
        byte[] v0 = "\u00b89\u0016QA\u00bf\u00c1\u0086\u00de\u00a2\u00b5\u00eb0\u00c4{\u00b1\u00e7En-0\u00ac1k2\u0004\u00a8\u0017\u00fa\u00c6\u00f4\u00f5\u0086\u00f4\u00ce\u008c+7\u0016\u0017\u00b3\u0098\u0005\u00f0\u00bc\u00a2\u0011\u0000\u00ad\u001e\u008eMT\u00fc/Ak\u00f2e\u00e4!\u00928\u00ef".getBytes("ISO_8859_1");
        Object[] v1 = "\u00db\u0092x\u009c\u00a4\u00fc-\u0018".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1925485255;
                case 1 -> 1356973053;
                case 2 -> -2118915477;
                case 3 -> -1820902785;
                case 4 -> 1478898369;
                case 5 -> -225258063;
                case 6 -> -1228875805;
                case 7 -> 1524804817;
                case 8 -> 534306157;
                case 9 -> 1412109114;
                case 10 -> 1895075883;
                case 11 -> 1720391741;
                case 12 -> 230365130;
                case 13 -> -741696719;
                case 14 -> 1031194326;
                case 15 -> -1403577829;
                case 16 -> -62133143;
                case 17 -> -1085212663;
                case 18 -> 1443956956;
                case 19 -> -632288688;
                case 20 -> -1305101236;
                case 21 -> 1336398339;
                case 22 -> -1068011234;
                case 23 -> 1658564582;
                case 24 -> -633554045;
                case 25 -> 1215506840;
                case 26 -> 1160305559;
                case 27 -> 1705271295;
                case 28 -> 979819332;
                case 29 -> 611705004;
                case 30 -> 1821304037;
                case 31 -> 1372367143;
                case 32 -> 208205586;
                case 33 -> -325930823;
                case 34 -> 734411265;
                case 35 -> 375824054;
                case 36 -> 331311239;
                case 37 -> 1161747668;
                case 38 -> -390330787;
                case 39 -> 284573184;
                case 40 -> -342462198;
                case 41 -> -1782762423;
                case 42 -> -673880892;
                case 43 -> -632702520;
                case 44 -> 1510543350;
                case 45 -> -221430495;
                case 46 -> -1029552558;
                case 47 -> -1083608186;
                case 48 -> 1971530856;
                case 49 -> 1155765556;
                case 50 -> -1200806876;
                case 51 -> 2047675620;
                case 52 -> 1853769432;
                case 53 -> -440540616;
                case 54 -> -2001902069;
                case 55 -> 1763821849;
                case 56 -> -1717701441;
                case 57 -> 729146069;
                case 58 -> -1149607899;
                case 59 -> -1581108451;
                case 60 -> 1185149146;
                case 61 -> 1566338716;
                case 62 -> -780579347;
                case 63 -> 717600856;
                case 64 -> 1309246918;
                case 65 -> -903966930;
                case 66 -> 1000386810;
                case 67 -> 1007332198;
                case 68 -> 1938197047;
                case 69 -> -465312085;
                case 70 -> -942674921;
                case 71 -> -1911818396;
                case 72 -> -1783872119;
                case 73 -> -1154020531;
                case 74 -> 1239552528;
                case 75 -> 2037859871;
                case 76 -> -1807947103;
                case 77 -> 16625462;
                case 78 -> 1842295273;
                case 79 -> -1601201955;
                case 80 -> 911116792;
                case 81 -> 1221564738;
                case 82 -> -1092640645;
                case 83 -> 410216973;
                case 84 -> -1596811516;
                case 85 -> -703017063;
                case 86 -> -1373040772;
                case 87 -> -165874487;
                case 88 -> -66488919;
                case 89 -> 1331986912;
                case 90 -> 1740988742;
                case 91 -> -446290306;
                case 92 -> 1023123701;
                case 93 -> -361527275;
                case 94 -> 2125434769;
                case 95 -> 515990042;
                case 96 -> 227040627;
                case 97 -> 932876210;
                case 98 -> 1395859516;
                case 99 -> -168618212;
                case 100 -> 204739888;
                case 101 -> -273597935;
                case 102 -> -878775174;
                case 103 -> 405259663;
                case 104 -> 48152611;
                case 105 -> 43835028;
                case 106 -> -1162583786;
                case 107 -> -712699039;
                case 108 -> -752025105;
                case 109 -> 1645649533;
                case 110 -> -1621625489;
                case 111 -> -385096414;
                case 112 -> 653579283;
                case 113 -> 2113273320;
                case 114 -> 1167676396;
                case 115 -> -1265846902;
                case 116 -> 212401874;
                case 117 -> 1246120333;
                case 118 -> -25429433;
                case 119 -> -456222554;
                case 120 -> -1983080629;
                case 121 -> -1258399914;
                case 122 -> 1782769738;
                case 123 -> -1357076572;
                case 124 -> 2049594688;
                case 125 -> 1050117086;
                case 126 -> 1016952645;
                case 127 -> 208977756;
                case 128 -> 1344372620;
                case 129 -> -1623592107;
                case 130 -> -2093750853;
                case 131 -> 1791871609;
                case 132 -> 588557743;
                case 133 -> -16682328;
                case 134 -> 569789806;
                case 135 -> -1583673360;
                case 136 -> -81481569;
                case 137 -> -599816359;
                case 138 -> -981918956;
                case 139 -> -1626003251;
                case 140 -> 656691198;
                case 141 -> -1412134502;
                case 142 -> 383139514;
                case 143 -> 1193848052;
                case 144 -> 962052245;
                case 145 -> 117624894;
                case 146 -> -1506109003;
                case 147 -> -1770671665;
                case 148 -> -1017319163;
                case 149 -> -1531161727;
                case 150 -> -1380223643;
                case 151 -> -87386736;
                case 152 -> 801642612;
                case 153 -> -878950927;
                case 154 -> 1703412199;
                case 155 -> 1513608749;
                case 156 -> -355328588;
                case 157 -> -1832678757;
                case 158 -> 1363613452;
                case 159 -> -914236890;
                case 160 -> 288150622;
                case 161 -> 1944589445;
                case 162 -> 1689378043;
                case 163 -> 93382005;
                case 164 -> -555017481;
                case 165 -> -44794533;
                case 166 -> -1887442849;
                case 167 -> 1624157208;
                case 168 -> 1185497776;
                case 169 -> 278294890;
                case 170 -> -1497231574;
                case 171 -> -1335607802;
                case 172 -> 1157920249;
                case 173 -> 258982875;
                case 174 -> 2014642778;
                case 175 -> -2059258646;
                case 176 -> 1681254159;
                case 177 -> -1115213104;
                case 178 -> 1508201078;
                case 179 -> 2097698499;
                case 180 -> 1368459826;
                case 181 -> -543996249;
                case 182 -> -946694459;
                case 183 -> 109133115;
                case 184 -> -1594746697;
                case 185 -> -1047870667;
                case 186 -> -1864909481;
                case 187 -> -1749448547;
                case 188 -> -1021531720;
                case 189 -> -1576298238;
                case 190 -> 632996972;
                case 191 -> 111624;
                case 192 -> -1847581490;
                case 193 -> 1927437974;
                case 194 -> 1671849918;
                case 195 -> 1638185027;
                case 196 -> -1848490633;
                case 197 -> -1431724960;
                case 198 -> -1854636637;
                case 199 -> 353167762;
                case 200 -> 1942883153;
                case 201 -> -619077970;
                case 202 -> -2024271451;
                case 203 -> -1800157308;
                case 204 -> 1785181774;
                case 205 -> 135689090;
                case 206 -> 822245192;
                case 207 -> -573524740;
                case 208 -> 1735181608;
                case 209 -> 236149587;
                case 210 -> 206496235;
                case 211 -> -393883348;
                case 212 -> 1167131762;
                case 213 -> -801124173;
                case 214 -> 561263929;
                case 215 -> -360097603;
                case 216 -> -1596448809;
                case 217 -> 157539522;
                case 218 -> 1534407054;
                case 219 -> -1539487797;
                case 220 -> -1352838861;
                case 221 -> -359234784;
                case 222 -> -1937565612;
                case 223 -> -1727119569;
                case 224 -> -1307500445;
                case 225 -> -1169010515;
                case 226 -> -1165529999;
                case 227 -> -1811035200;
                case 228 -> -1675673686;
                case 229 -> 1108961171;
                case 230 -> 1078822256;
                case 231 -> 2018216039;
                case 232 -> -970129054;
                case 233 -> 2048631534;
                case 234 -> -1743980896;
                case 235 -> 213115806;
                case 236 -> -87885176;
                case 237 -> -832137589;
                case 238 -> 1084365043;
                case 239 -> 477256767;
                case 240 -> -650462706;
                case 241 -> -380594996;
                case 242 -> -1613615393;
                case 243 -> 37782258;
                case 244 -> -1900821854;
                case 245 -> -800264407;
                case 246 -> 1305275874;
                case 247 -> 367664961;
                case 248 -> -1222568516;
                case 249 -> -1805046152;
                case 250 -> 552957651;
                case 251 -> -1159573497;
                case 252 -> -38597159;
                case 253 -> -208147633;
                case 254 -> 689500032;
                case 255 -> 877421793;
                default -> -772319095;
            });
        } while (v2 != 64);
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
            Object[] objectArray = new Object[3];
            v1 = objectArray;
            Ioi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        IoO = new EnumType_oooi_6("MAIN_HAND", 0);
        Io0 = new EnumType_oooi_6("ARMOR", 1);
        Ioo = new EnumType_oooi_6("OFF_HAND", 2);
        IoI = EnumType_oooi_6.RenderSupport_oii_4();
    }

    private static /* synthetic */ EnumType_oooi_6[] RenderSupport_oii_4() {
        return new EnumType_oooi_6[]{IoO, Io0, Ioo};
    }
}

