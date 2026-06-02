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
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.OiII
 */
public final class EnumType_oiii_3
extends Enum {
    public static final /* enum */ EnumType_oiii_3 OOoO;
    private static final /* synthetic */ EnumType_oiii_3[] OOoo;
    public static final /* enum */ EnumType_oiii_3 OO0i;
    public static final /* enum */ EnumType_oiii_3 EventHandler;
    static Object OOoI;

    public static EnumType_oiii_3[] values() {
        return (EnumType_oiii_3[])OOoo.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oiii_3() {
        void param2;
        void param1;
    }

    public static EnumType_oiii_3 valueOf(String param0) {
        return Enum.valueOf(EnumType_oiii_3.class, param0);
    }

    static {
        byte[] v0 = "x\u00e0\u007f\u00ec\u0014\u00c43\u0084\u0010n\u00ac\u0098\u008c\u0010\u00c9\u0007\u00dd\u000f\u00f3F\u0010\u00ea\u00de\u00c6\u00cfw\u00c6jc\u00a7\u00f9\u00f3b\u001c\u00a6\u0011\u0098\u00d7F\u00dd\u008c\u00c0\u00d4\u008d\u000f\u00ed\u0084f\u0088V\u00a1\u00c9\u000f\u00c6\u00c7\u001e\u001c\u00cdx\u00be[\u00e1/\\".getBytes("ISO_8859_1");
        Object[] v1 = "\u00d9\u001f\u0087Y\u00c5%\u00ba\u00f4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 2122196608;
                case 1 -> -1275778139;
                case 2 -> 414301532;
                case 3 -> -1328763581;
                case 4 -> -1486422348;
                case 5 -> -1496915256;
                case 6 -> -970619247;
                case 7 -> 812462283;
                case 8 -> -1199868173;
                case 9 -> -1051223039;
                case 10 -> -1533311508;
                case 11 -> 1115315204;
                case 12 -> 460216507;
                case 13 -> 2113915415;
                case 14 -> 174070644;
                case 15 -> -473067190;
                case 16 -> 287584335;
                case 17 -> -1797434396;
                case 18 -> 2124374125;
                case 19 -> 1757385788;
                case 20 -> 1595295246;
                case 21 -> 183994046;
                case 22 -> -1709092262;
                case 23 -> -770724191;
                case 24 -> -139224313;
                case 25 -> 1338176977;
                case 26 -> -1633766899;
                case 27 -> -1111421960;
                case 28 -> 376331312;
                case 29 -> -1457671122;
                case 30 -> -1809998105;
                case 31 -> -1278538905;
                case 32 -> -1171889825;
                case 33 -> -1101927824;
                case 34 -> -1791940946;
                case 35 -> 1662024472;
                case 36 -> -796416073;
                case 37 -> 758493546;
                case 38 -> -1897440071;
                case 39 -> -1579357213;
                case 40 -> -1124212429;
                case 41 -> -967006258;
                case 42 -> 1004909452;
                case 43 -> -1654223528;
                case 44 -> -1941141269;
                case 45 -> -138361333;
                case 46 -> -1276405303;
                case 47 -> 952525004;
                case 48 -> 485298154;
                case 49 -> -2054339796;
                case 50 -> -168841869;
                case 51 -> -994078978;
                case 52 -> -1303700912;
                case 53 -> -2146457831;
                case 54 -> 1267463039;
                case 55 -> -1043713691;
                case 56 -> -669982013;
                case 57 -> 1233148688;
                case 58 -> -55448185;
                case 59 -> -2073755622;
                case 60 -> -1724634614;
                case 61 -> -409648063;
                case 62 -> 988251059;
                case 63 -> 1274317249;
                case 64 -> -292136448;
                case 65 -> 283528666;
                case 66 -> 1876559491;
                case 67 -> -1917979819;
                case 68 -> -518995450;
                case 69 -> -1101733385;
                case 70 -> -1272652906;
                case 71 -> -92897835;
                case 72 -> 1156582058;
                case 73 -> 841267980;
                case 74 -> 1694336166;
                case 75 -> -1350554596;
                case 76 -> -1351597414;
                case 77 -> -1568305988;
                case 78 -> -498134019;
                case 79 -> 1358912379;
                case 80 -> 1945976186;
                case 81 -> 422732837;
                case 82 -> -18135221;
                case 83 -> -1143200798;
                case 84 -> 487654766;
                case 85 -> -825960493;
                case 86 -> -1441275290;
                case 87 -> -235024463;
                case 88 -> 499426629;
                case 89 -> -878229036;
                case 90 -> -1457330883;
                case 91 -> -1006776849;
                case 92 -> -205153376;
                case 93 -> -76356069;
                case 94 -> -1324298114;
                case 95 -> 368235810;
                case 96 -> -811295560;
                case 97 -> 121316101;
                case 98 -> -266068834;
                case 99 -> -86231751;
                case 100 -> 832082735;
                case 101 -> 823251498;
                case 102 -> -1121096016;
                case 103 -> -29328403;
                case 104 -> -182782943;
                case 105 -> 1546398706;
                case 106 -> 327703181;
                case 107 -> -49157912;
                case 108 -> -1536109675;
                case 109 -> 1254249179;
                case 110 -> 648061912;
                case 111 -> -920751522;
                case 112 -> -528066335;
                case 113 -> -1706545045;
                case 114 -> 1528320508;
                case 115 -> 1417162941;
                case 116 -> 1471708841;
                case 117 -> -248005242;
                case 118 -> -2040066910;
                case 119 -> 1470002843;
                case 120 -> 2038643319;
                case 121 -> 1150418226;
                case 122 -> 1817156282;
                case 123 -> -855696851;
                case 124 -> 2076733270;
                case 125 -> -943892380;
                case 126 -> 68183541;
                case 127 -> 1776974518;
                case 128 -> -1295624162;
                case 129 -> -2067984134;
                case 130 -> 1509976646;
                case 131 -> -1752409999;
                case 132 -> -451263662;
                case 133 -> 1579611283;
                case 134 -> -1516633016;
                case 135 -> -1322865443;
                case 136 -> -2087269835;
                case 137 -> 1157210279;
                case 138 -> -334931879;
                case 139 -> 1189799209;
                case 140 -> 1065544743;
                case 141 -> 1002888285;
                case 142 -> -865309687;
                case 143 -> 1503743042;
                case 144 -> -1018584640;
                case 145 -> -1412762430;
                case 146 -> -1454428253;
                case 147 -> 1779794921;
                case 148 -> -1745362977;
                case 149 -> 12784899;
                case 150 -> -1697782776;
                case 151 -> 2067417482;
                case 152 -> -278848380;
                case 153 -> 853674742;
                case 154 -> -2106797169;
                case 155 -> -429521803;
                case 156 -> -308229559;
                case 157 -> 744745576;
                case 158 -> 1432101670;
                case 159 -> -248727603;
                case 160 -> -1758371182;
                case 161 -> -147420104;
                case 162 -> -1748289124;
                case 163 -> 997418470;
                case 164 -> 288873750;
                case 165 -> -1875522013;
                case 166 -> -195095896;
                case 167 -> 1436814907;
                case 168 -> -500377492;
                case 169 -> -1378347235;
                case 170 -> 2048092009;
                case 171 -> -1985431350;
                case 172 -> 939172666;
                case 173 -> -652703836;
                case 174 -> 17208151;
                case 175 -> 1086800285;
                case 176 -> 1748631666;
                case 177 -> -567160300;
                case 178 -> 1881967275;
                case 179 -> -1948327648;
                case 180 -> 1303209880;
                case 181 -> -527061123;
                case 182 -> -1964679609;
                case 183 -> 1982045838;
                case 184 -> 1572137490;
                case 185 -> -1615178178;
                case 186 -> -1036510401;
                case 187 -> -1283253473;
                case 188 -> 1064514512;
                case 189 -> -1441234413;
                case 190 -> 2050683801;
                case 191 -> 1587642361;
                case 192 -> -419548888;
                case 193 -> 508158305;
                case 194 -> -985787338;
                case 195 -> 1041521243;
                case 196 -> 796677137;
                case 197 -> 148961943;
                case 198 -> -1008824209;
                case 199 -> 141348997;
                case 200 -> 1102679884;
                case 201 -> -1785667825;
                case 202 -> 1736127431;
                case 203 -> 1778478532;
                case 204 -> -1077054991;
                case 205 -> -322157936;
                case 206 -> 199049167;
                case 207 -> -377790921;
                case 208 -> 1411252086;
                case 209 -> 1231601507;
                case 210 -> 1233342600;
                case 211 -> -399375947;
                case 212 -> 1755396436;
                case 213 -> 1028419661;
                case 214 -> 337442050;
                case 215 -> -862257440;
                case 216 -> 486107058;
                case 217 -> 1039735711;
                case 218 -> 78233599;
                case 219 -> 1187276162;
                case 220 -> 489068254;
                case 221 -> -81160276;
                case 222 -> -325664809;
                case 223 -> -1540261549;
                case 224 -> 1900667309;
                case 225 -> 401289158;
                case 226 -> 459393404;
                case 227 -> 1489643649;
                case 228 -> 1469938414;
                case 229 -> 451290585;
                case 230 -> 989460694;
                case 231 -> 2031638080;
                case 232 -> 1854833812;
                case 233 -> -1708810768;
                case 234 -> 881405065;
                case 235 -> -1911717308;
                case 236 -> 68433147;
                case 237 -> 719359717;
                case 238 -> 399154552;
                case 239 -> 1329489188;
                case 240 -> 187812572;
                case 241 -> -1412791105;
                case 242 -> -1362185630;
                case 243 -> -987132079;
                case 244 -> -1488496076;
                case 245 -> 1636584981;
                case 246 -> -280189088;
                case 247 -> -1527174993;
                case 248 -> 951024433;
                case 249 -> -1368266418;
                case 250 -> 1302778821;
                case 251 -> 1635735929;
                case 252 -> -1922678062;
                case 253 -> 559691819;
                case 254 -> -1932626444;
                case 255 -> 623903371;
                default -> 492319743;
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
            OOoI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OO0i = new EnumType_oiii_3("Health", 0);
        OOoO = new EnumType_oiii_3("Distance", 1);
        EventHandler = new EnumType_oiii_3("Angle", 2);
        OOoo = EnumType_oiii_3.0Oi();
    }

    private static /* synthetic */ EnumType_oiii_3[] 0Oi() {
        return new EnumType_oiii_3[]{OO0i, OOoO, EventHandler};
    }
}

