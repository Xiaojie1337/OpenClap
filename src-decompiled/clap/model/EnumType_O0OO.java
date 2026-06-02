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

public final class EnumType_O0OO
extends Enum {
    public static final /* enum */ EnumType_O0OO RenderSupport_ooi_1;
    public static final /* enum */ EnumType_O0OO oOi;
    private static final /* synthetic */ EnumType_O0OO[] o0O;
    static Object o00;

    public static EnumType_O0OO[] values() {
        return (EnumType_O0OO[])o0O.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_O0OO() {
        void param2;
        void param1;
    }

    public static EnumType_O0OO valueOf(String param0) {
        return Enum.valueOf(EnumType_O0OO.class, param0);
    }

    static {
        byte[] v0 = "6q&\u00cd7L\u00f4\u008b\u001f\u00bb]\u009b\u00d7\u00ad\u00efc<`\u00f3\u0006\u00c7\u00ce\u007f\u007f\u0088\u0018\u00b9\u009elm\u00b0`z6\u0097\u00fa\u008e\u0001\u00a4\u00e3\u00c4\u00a5\u001b\u0095\u000b5a>\u008d|\u0012Z0\u001ba\u00bf".getBytes("ISO_8859_1");
        Object[] v1 = "\u00ef^\u0094\u00c1\u00a6 \u00ad\u00fe".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1132092312;
                case 1 -> 273668452;
                case 2 -> -1268368194;
                case 3 -> -1089611019;
                case 4 -> 818216727;
                case 5 -> 1396293772;
                case 6 -> 1986567473;
                case 7 -> 807110803;
                case 8 -> 175915340;
                case 9 -> 1032123186;
                case 10 -> 1533689680;
                case 11 -> -1382118376;
                case 12 -> -1086147668;
                case 13 -> 900325416;
                case 14 -> -1945387554;
                case 15 -> 93591315;
                case 16 -> 1148610229;
                case 17 -> -423029457;
                case 18 -> 50580224;
                case 19 -> 1829845599;
                case 20 -> 219601569;
                case 21 -> -718135967;
                case 22 -> -1139052074;
                case 23 -> -2014682019;
                case 24 -> -352178505;
                case 25 -> 1890448622;
                case 26 -> -682301567;
                case 27 -> -1592501990;
                case 28 -> 1478107613;
                case 29 -> 422614599;
                case 30 -> -1059380777;
                case 31 -> -828489331;
                case 32 -> -1538744790;
                case 33 -> -121993822;
                case 34 -> -877380143;
                case 35 -> 1575736914;
                case 36 -> 1790028183;
                case 37 -> -1200859398;
                case 38 -> 470903587;
                case 39 -> -1814962734;
                case 40 -> -321201989;
                case 41 -> -1403280670;
                case 42 -> 1387987565;
                case 43 -> -1482269741;
                case 44 -> 1416543430;
                case 45 -> 1792663206;
                case 46 -> 1035980968;
                case 47 -> -1149681801;
                case 48 -> -708519811;
                case 49 -> 97714960;
                case 50 -> 1065019495;
                case 51 -> 901869678;
                case 52 -> -1799547687;
                case 53 -> -2131556836;
                case 54 -> 74673912;
                case 55 -> 1159037044;
                case 56 -> 2097661189;
                case 57 -> 849249372;
                case 58 -> 651044528;
                case 59 -> -330932203;
                case 60 -> -723405044;
                case 61 -> -1581503846;
                case 62 -> 725668070;
                case 63 -> -542776233;
                case 64 -> -1344416234;
                case 65 -> 470923439;
                case 66 -> -1007449718;
                case 67 -> -760613042;
                case 68 -> -187932768;
                case 69 -> -1177507714;
                case 70 -> -373504502;
                case 71 -> -491209951;
                case 72 -> -261505811;
                case 73 -> 672912860;
                case 74 -> 1474861395;
                case 75 -> 1341721663;
                case 76 -> 1551724285;
                case 77 -> 1460712078;
                case 78 -> -2105256394;
                case 79 -> 583405963;
                case 80 -> -357324957;
                case 81 -> -848041876;
                case 82 -> -1221341342;
                case 83 -> 454810005;
                case 84 -> 973241653;
                case 85 -> -976590415;
                case 86 -> -1121602231;
                case 87 -> -230804958;
                case 88 -> 1058395793;
                case 89 -> -2086315648;
                case 90 -> -1106191969;
                case 91 -> -1657132153;
                case 92 -> -1840549588;
                case 93 -> 1165512013;
                case 94 -> 1350326270;
                case 95 -> -1544159272;
                case 96 -> 1786426434;
                case 97 -> 1823917803;
                case 98 -> 791736001;
                case 99 -> 2072663414;
                case 100 -> -782622327;
                case 101 -> -1804666581;
                case 102 -> 315754346;
                case 103 -> 249236406;
                case 104 -> 2131660548;
                case 105 -> 1399138243;
                case 106 -> -1786695005;
                case 107 -> -1659567636;
                case 108 -> -728852839;
                case 109 -> -485214805;
                case 110 -> 1565989140;
                case 111 -> -434531232;
                case 112 -> 1380372497;
                case 113 -> 1043153765;
                case 114 -> -1649856963;
                case 115 -> 1211614977;
                case 116 -> 1074907717;
                case 117 -> -126265878;
                case 118 -> 1891868896;
                case 119 -> 874397605;
                case 120 -> -1084173280;
                case 121 -> -459441651;
                case 122 -> -2144121212;
                case 123 -> -487548750;
                case 124 -> 1319176815;
                case 125 -> -210574468;
                case 126 -> -785136994;
                case 127 -> -367152869;
                case 128 -> -1615181876;
                case 129 -> -911615418;
                case 130 -> -2121171813;
                case 131 -> 2017197028;
                case 132 -> 826005278;
                case 133 -> -1668833206;
                case 134 -> 2140212542;
                case 135 -> 1091300416;
                case 136 -> 614799234;
                case 137 -> -1694727082;
                case 138 -> 1097843000;
                case 139 -> 1678775258;
                case 140 -> -2106170873;
                case 141 -> -1370434337;
                case 142 -> -1357190937;
                case 143 -> -1674738715;
                case 144 -> 1352200749;
                case 145 -> -1166252507;
                case 146 -> -1895368397;
                case 147 -> 1857977894;
                case 148 -> 1198691512;
                case 149 -> -752489554;
                case 150 -> 367005882;
                case 151 -> -1196646266;
                case 152 -> 1743018561;
                case 153 -> -2071708004;
                case 154 -> -1134453764;
                case 155 -> 801569603;
                case 156 -> 1992402782;
                case 157 -> 1479369336;
                case 158 -> 1060840038;
                case 159 -> 953930187;
                case 160 -> 1396654740;
                case 161 -> -92016625;
                case 162 -> -154891813;
                case 163 -> -949687733;
                case 164 -> 61885619;
                case 165 -> -1087567570;
                case 166 -> 1470380228;
                case 167 -> 84979464;
                case 168 -> 417415675;
                case 169 -> -150588999;
                case 170 -> -22152561;
                case 171 -> -580808515;
                case 172 -> -88119513;
                case 173 -> 1773375234;
                case 174 -> -1050044604;
                case 175 -> -1891611045;
                case 176 -> -1023585786;
                case 177 -> -179012806;
                case 178 -> -1239652529;
                case 179 -> 1526020153;
                case 180 -> 1380669268;
                case 181 -> -1854578252;
                case 182 -> 1646356849;
                case 183 -> -1043890045;
                case 184 -> 1153770269;
                case 185 -> -1003269696;
                case 186 -> 1611634539;
                case 187 -> -2067719447;
                case 188 -> -1331443003;
                case 189 -> -1560881164;
                case 190 -> 15109247;
                case 191 -> 1158211720;
                case 192 -> 827717902;
                case 193 -> 812702297;
                case 194 -> 410365777;
                case 195 -> -248769414;
                case 196 -> -1894372093;
                case 197 -> -656558360;
                case 198 -> 1035104202;
                case 199 -> -758457117;
                case 200 -> 1647385434;
                case 201 -> -784350183;
                case 202 -> -632699;
                case 203 -> 1454127163;
                case 204 -> -810771396;
                case 205 -> -1484522288;
                case 206 -> -1570374657;
                case 207 -> -2122377016;
                case 208 -> -48113797;
                case 209 -> -1516733325;
                case 210 -> -749865796;
                case 211 -> 1422337270;
                case 212 -> 295924592;
                case 213 -> 564527192;
                case 214 -> 240357650;
                case 215 -> 1289633942;
                case 216 -> -1548545289;
                case 217 -> 521844137;
                case 218 -> 707452793;
                case 219 -> 701706483;
                case 220 -> -824745936;
                case 221 -> 4579017;
                case 222 -> 1163664079;
                case 223 -> -1535036679;
                case 224 -> -124360808;
                case 225 -> -1943454294;
                case 226 -> 1707002633;
                case 227 -> -1094491576;
                case 228 -> -1834086974;
                case 229 -> 1629370423;
                case 230 -> -1141826403;
                case 231 -> 1952590765;
                case 232 -> 295622544;
                case 233 -> -1875237340;
                case 234 -> 1802902057;
                case 235 -> -1853341710;
                case 236 -> 1765498123;
                case 237 -> -1606532065;
                case 238 -> -779227084;
                case 239 -> -294668439;
                case 240 -> -550433075;
                case 241 -> 2123708656;
                case 242 -> -1534632334;
                case 243 -> -842046507;
                case 244 -> -73060908;
                case 245 -> -358012764;
                case 246 -> -1954941241;
                case 247 -> 1469805397;
                case 248 -> 206253039;
                case 249 -> -117785153;
                case 250 -> 1598870695;
                case 251 -> 1395387253;
                case 252 -> -1392003871;
                case 253 -> 1225960945;
                case 254 -> -1981421874;
                case 255 -> 1041146258;
                default -> 1552296582;
            });
        } while (v2 != 56);
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
            o00 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        RenderSupport_ooi_1 = new EnumType_O0OO("Single", 0);
        oOi = new EnumType_O0OO("Switch", 1);
        o0O = EnumType_O0OO.Ooo();
    }

    private static /* synthetic */ EnumType_O0OO[] Ooo() {
        return new EnumType_O0OO[]{RenderSupport_ooi_1, oOi};
    }
}

