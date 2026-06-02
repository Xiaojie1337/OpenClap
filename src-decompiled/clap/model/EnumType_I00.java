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

final class EnumType_I00
extends Enum {
    public static final /* enum */ EnumType_I00 OoO;
    public static final /* enum */ EnumType_I00 Ooo;
    public static final /* enum */ EnumType_I00 Oo0;
    private static final /* synthetic */ EnumType_I00[] Ooi;
    public static final /* enum */ EnumType_I00 OoI;
    static Object KeystrokesHudElement;

    public static EnumType_I00[] values() {
        return (EnumType_I00[])Ooi.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_I00() {
        void param2;
        void param1;
    }

    public static EnumType_I00 valueOf(String param0) {
        return Enum.valueOf(EnumType_I00.class, param0);
    }

    static {
        byte[] v0 = "\u009f\u00f1s\u0095AO\u0094\u00eb6\u0001\u00c1\u0005J\u00b7\u00e2\u00af \u00e0\u0019\u001b\u0084\u0000\u001e\u0098\u00e3\u00b0\u008btTA5\u0083t\u00f4z<\u00ee9_\u00ffB\u008e&\u00fb[\u0016\u00f2e%\u00b2`\u00d9Dd&4\u00ca\u00c4\u0089\u00f6\u0087:4\u00c6".getBytes("ISO_8859_1");
        Object[] v1 = "vY\u00ef.\u00ccv\u0095\u00e4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1912887544;
                case 1 -> -1962933648;
                case 2 -> 273759647;
                case 3 -> 479364427;
                case 4 -> 313115825;
                case 5 -> 1379498456;
                case 6 -> -1729332130;
                case 7 -> 558719131;
                case 8 -> 1600870308;
                case 9 -> -1388889566;
                case 10 -> -235475635;
                case 11 -> 292908613;
                case 12 -> -1250777499;
                case 13 -> 6943221;
                case 14 -> -84352395;
                case 15 -> -1204289791;
                case 16 -> -1999003806;
                case 17 -> 2105981264;
                case 18 -> 2059461881;
                case 19 -> 1924261819;
                case 20 -> -1897703918;
                case 21 -> 1105729694;
                case 22 -> 106070270;
                case 23 -> 1054750381;
                case 24 -> 590296160;
                case 25 -> -449408578;
                case 26 -> 942944288;
                case 27 -> 473078728;
                case 28 -> 1938171072;
                case 29 -> -2002142889;
                case 30 -> 956217877;
                case 31 -> 391663670;
                case 32 -> 632794899;
                case 33 -> -353646566;
                case 34 -> 1332771684;
                case 35 -> 233561985;
                case 36 -> 1375149564;
                case 37 -> 1924599561;
                case 38 -> -244619526;
                case 39 -> -551739232;
                case 40 -> 545718214;
                case 41 -> 1541791566;
                case 42 -> 946650162;
                case 43 -> -1381226942;
                case 44 -> 226743859;
                case 45 -> -584927992;
                case 46 -> -2022064038;
                case 47 -> 1448550074;
                case 48 -> -1618695774;
                case 49 -> -252724570;
                case 50 -> -26415415;
                case 51 -> -963101146;
                case 52 -> 936556397;
                case 53 -> 2023356182;
                case 54 -> 725839928;
                case 55 -> 1641172522;
                case 56 -> -345528427;
                case 57 -> 1411237646;
                case 58 -> 1841488250;
                case 59 -> -1040357191;
                case 60 -> 217308175;
                case 61 -> 1011310401;
                case 62 -> 550214357;
                case 63 -> 1942813464;
                case 64 -> 539282479;
                case 65 -> 900955968;
                case 66 -> -953412994;
                case 67 -> -1604111060;
                case 68 -> 1602062071;
                case 69 -> 822190220;
                case 70 -> -468841776;
                case 71 -> 657802909;
                case 72 -> 1049739359;
                case 73 -> 1338651677;
                case 74 -> -1990287884;
                case 75 -> 1829191830;
                case 76 -> 1955995056;
                case 77 -> -1811886652;
                case 78 -> -48340319;
                case 79 -> 1931673;
                case 80 -> 356419217;
                case 81 -> -778882041;
                case 82 -> -1583926256;
                case 83 -> 1093445638;
                case 84 -> 705543556;
                case 85 -> 1033100732;
                case 86 -> -800497438;
                case 87 -> 326186930;
                case 88 -> -1698196248;
                case 89 -> 743386672;
                case 90 -> -600166303;
                case 91 -> 1877568311;
                case 92 -> 585718857;
                case 93 -> -1919908685;
                case 94 -> -2106968805;
                case 95 -> -818579989;
                case 96 -> -1709014772;
                case 97 -> -1521157437;
                case 98 -> -1093031089;
                case 99 -> 509313148;
                case 100 -> 553743298;
                case 101 -> -596158521;
                case 102 -> 501605934;
                case 103 -> 1004357334;
                case 104 -> 1604793723;
                case 105 -> 1640080353;
                case 106 -> 221424500;
                case 107 -> 1601163625;
                case 108 -> 613827902;
                case 109 -> -1786362156;
                case 110 -> -2130786853;
                case 111 -> -696422365;
                case 112 -> 1809299558;
                case 113 -> -643054423;
                case 114 -> 452158382;
                case 115 -> -442173148;
                case 116 -> 1694215732;
                case 117 -> -1422696869;
                case 118 -> 1114763427;
                case 119 -> -1830232221;
                case 120 -> 254314969;
                case 121 -> -1040958808;
                case 122 -> -1269007355;
                case 123 -> -2139892139;
                case 124 -> -1212251774;
                case 125 -> 214557418;
                case 126 -> -1517229498;
                case 127 -> -1409295921;
                case 128 -> 944473293;
                case 129 -> -2062670915;
                case 130 -> -670075949;
                case 131 -> -431493356;
                case 132 -> -2048558549;
                case 133 -> 555988081;
                case 134 -> -347521653;
                case 135 -> -1480849304;
                case 136 -> -1396744563;
                case 137 -> 1415063411;
                case 138 -> -1264843439;
                case 139 -> -1087265039;
                case 140 -> 19906643;
                case 141 -> 263783904;
                case 142 -> -909365747;
                case 143 -> 1539529586;
                case 144 -> 1504029435;
                case 145 -> -1260315577;
                case 146 -> 1553902148;
                case 147 -> 2143041310;
                case 148 -> -445451376;
                case 149 -> -830446969;
                case 150 -> -1731688902;
                case 151 -> -829707489;
                case 152 -> 1763800601;
                case 153 -> 733082514;
                case 154 -> 1820468483;
                case 155 -> 1720814968;
                case 156 -> -1267020058;
                case 157 -> -2141648897;
                case 158 -> -865574646;
                case 159 -> -2007419455;
                case 160 -> 1321234516;
                case 161 -> 1459024924;
                case 162 -> 1832263306;
                case 163 -> -623516340;
                case 164 -> 84694825;
                case 165 -> -1392933002;
                case 166 -> -1383787305;
                case 167 -> 1185016337;
                case 168 -> 196123953;
                case 169 -> 1386369672;
                case 170 -> 393006625;
                case 171 -> 2087009832;
                case 172 -> 804168055;
                case 173 -> 1084014645;
                case 174 -> -641522628;
                case 175 -> 195003224;
                case 176 -> -2117818258;
                case 177 -> -1067318642;
                case 178 -> -1154368189;
                case 179 -> 1918673047;
                case 180 -> 1612388532;
                case 181 -> 250029591;
                case 182 -> -91731537;
                case 183 -> 857370590;
                case 184 -> -897011118;
                case 185 -> 738390675;
                case 186 -> -135557138;
                case 187 -> -409392595;
                case 188 -> -847812487;
                case 189 -> -910273428;
                case 190 -> 1308459497;
                case 191 -> -1934127123;
                case 192 -> 770294528;
                case 193 -> -828670221;
                case 194 -> -1592074385;
                case 195 -> 806811333;
                case 196 -> -1279596145;
                case 197 -> -99813194;
                case 198 -> 294598309;
                case 199 -> 2069019819;
                case 200 -> -2110669618;
                case 201 -> -468235878;
                case 202 -> 610806858;
                case 203 -> -983970595;
                case 204 -> 1768005878;
                case 205 -> -1918040870;
                case 206 -> -1717734740;
                case 207 -> -1070586396;
                case 208 -> 1968824613;
                case 209 -> -536981038;
                case 210 -> 97703116;
                case 211 -> 592028895;
                case 212 -> -724643869;
                case 213 -> -84788697;
                case 214 -> -431085988;
                case 215 -> -401704857;
                case 216 -> 2113271430;
                case 217 -> -812554695;
                case 218 -> 252912699;
                case 219 -> -1842546104;
                case 220 -> 1610685321;
                case 221 -> -812712059;
                case 222 -> -776767425;
                case 223 -> 1197727104;
                case 224 -> -130424596;
                case 225 -> 546694642;
                case 226 -> -1618906613;
                case 227 -> 363523330;
                case 228 -> 1970942903;
                case 229 -> -1110605348;
                case 230 -> -2017971737;
                case 231 -> 307217304;
                case 232 -> 1104930032;
                case 233 -> -714423094;
                case 234 -> 571755189;
                case 235 -> 201274986;
                case 236 -> -2093213571;
                case 237 -> -531156931;
                case 238 -> -729536405;
                case 239 -> 1678472022;
                case 240 -> 2111138708;
                case 241 -> -398396029;
                case 242 -> 256355045;
                case 243 -> -2083920039;
                case 244 -> 2063461835;
                case 245 -> -100367377;
                case 246 -> -95761252;
                case 247 -> -119307427;
                case 248 -> 121921489;
                case 249 -> 1083249917;
                case 250 -> 150950058;
                case 251 -> -232456769;
                case 252 -> -923118977;
                case 253 -> -328265544;
                case 254 -> 733329668;
                case 255 -> -184283993;
                default -> -2131816931;
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
            Object[] objectArray = new Object[4];
            v1 = objectArray;
            KeystrokesHudElement = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OoO = new EnumType_I00("NONE", 0);
        Oo0 = new EnumType_I00("SQUARE", 1);
        Ooo = new EnumType_I00("HUE", 2);
        OoI = new EnumType_I00("ALPHA", 3);
        Ooi = EnumType_I00.OOo();
    }

    private static /* synthetic */ EnumType_I00[] OOo() {
        return new EnumType_I00[]{OoO, Oo0, Ooo, OoI};
    }
}

