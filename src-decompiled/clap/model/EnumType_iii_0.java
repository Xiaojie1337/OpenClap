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
 * Renamed from psx.Hyk.IIi
 */
public final class EnumType_iii_0
extends Enum {
    public static final /* enum */ EnumType_iii_0 OiO;
    public static final /* enum */ EnumType_iii_0 Oi0;
    private static final /* synthetic */ EnumType_iii_0[] Oio;
    static Object OiI;

    public static EnumType_iii_0[] values() {
        return (EnumType_iii_0[])Oio.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_iii_0() {
        void param2;
        void param1;
    }

    public static EnumType_iii_0 valueOf(String param0) {
        return Enum.valueOf(EnumType_iii_0.class, param0);
    }

    static {
        byte[] v0 = "\u0090\u00cd\u00c7\u0099\u00d9\u00b6\u001b\u00a3U\u00ff\u00fdQ\u0002\n\u00f42{\u00e0\u0083@\u00a8\u00cf\u0004/v\u00cczq\u008f\u0003\u00f5\u0013|\u00c8W,\u001c[\u00a0(aR\u00982`o\u001c.".getBytes("ISO_8859_1");
        Object[] v1 = "e#\u0098\u00dc\u00f8YHI".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1710209969;
                case 1 -> 1857421341;
                case 2 -> 1467531897;
                case 3 -> 1929343512;
                case 4 -> -318884375;
                case 5 -> 1592211938;
                case 6 -> -2104848629;
                case 7 -> 971076678;
                case 8 -> 265800970;
                case 9 -> -1807784298;
                case 10 -> -1161242396;
                case 11 -> -381818885;
                case 12 -> 386532608;
                case 13 -> 593927372;
                case 14 -> 1564397920;
                case 15 -> 1300209336;
                case 16 -> -92209011;
                case 17 -> 1915303692;
                case 18 -> 831496881;
                case 19 -> 951108547;
                case 20 -> 2107874489;
                case 21 -> 633224791;
                case 22 -> -916287727;
                case 23 -> 884490233;
                case 24 -> 767217870;
                case 25 -> 1739087911;
                case 26 -> 535533000;
                case 27 -> -1121572102;
                case 28 -> 1619999132;
                case 29 -> 305539618;
                case 30 -> -981762771;
                case 31 -> 691528439;
                case 32 -> 80311436;
                case 33 -> -1998897775;
                case 34 -> -2010207376;
                case 35 -> -2079075374;
                case 36 -> -1891093680;
                case 37 -> 702912928;
                case 38 -> -293457893;
                case 39 -> 1556617540;
                case 40 -> 375992129;
                case 41 -> 867132321;
                case 42 -> -552935186;
                case 43 -> -929666219;
                case 44 -> -596619736;
                case 45 -> 144612301;
                case 46 -> 1644326322;
                case 47 -> -875883485;
                case 48 -> -418728296;
                case 49 -> 675919126;
                case 50 -> -1306865650;
                case 51 -> 1996740297;
                case 52 -> 1906418621;
                case 53 -> 1110513072;
                case 54 -> -2109176346;
                case 55 -> -878246696;
                case 56 -> -720690940;
                case 57 -> 350931267;
                case 58 -> -365406975;
                case 59 -> -375769629;
                case 60 -> 392502554;
                case 61 -> -1935731237;
                case 62 -> 1261289683;
                case 63 -> -716486124;
                case 64 -> -1932957995;
                case 65 -> -896949687;
                case 66 -> 1867725948;
                case 67 -> -149569236;
                case 68 -> 2068807191;
                case 69 -> -2044958044;
                case 70 -> 1716902419;
                case 71 -> 658078265;
                case 72 -> 1824223253;
                case 73 -> -56708612;
                case 74 -> 934939865;
                case 75 -> -80251086;
                case 76 -> -58263114;
                case 77 -> 1727240580;
                case 78 -> 1978635250;
                case 79 -> 498872837;
                case 80 -> 1675934810;
                case 81 -> -2082917418;
                case 82 -> 1493621470;
                case 83 -> -1199139475;
                case 84 -> -1926014598;
                case 85 -> 413799746;
                case 86 -> 491406772;
                case 87 -> -1959414188;
                case 88 -> -11498857;
                case 89 -> -1732718551;
                case 90 -> -2061358018;
                case 91 -> -774447973;
                case 92 -> -979715526;
                case 93 -> 1023267344;
                case 94 -> 651335399;
                case 95 -> -307206031;
                case 96 -> -1921933760;
                case 97 -> 1615173355;
                case 98 -> 2047733217;
                case 99 -> 559789149;
                case 100 -> 1542247375;
                case 101 -> -1466555723;
                case 102 -> -951569809;
                case 103 -> 437978696;
                case 104 -> 2022280922;
                case 105 -> 1918910094;
                case 106 -> 1332376963;
                case 107 -> 1650463314;
                case 108 -> -771830320;
                case 109 -> -1233001652;
                case 110 -> 1715377966;
                case 111 -> -656752323;
                case 112 -> 997828780;
                case 113 -> -1234910104;
                case 114 -> 954702229;
                case 115 -> 2042835318;
                case 116 -> 1350151271;
                case 117 -> -1562575066;
                case 118 -> -2076510797;
                case 119 -> -90366793;
                case 120 -> -1633722893;
                case 121 -> 270093147;
                case 122 -> 1226036568;
                case 123 -> 688529903;
                case 124 -> 1430079285;
                case 125 -> -868796290;
                case 126 -> 1325471453;
                case 127 -> -1617715356;
                case 128 -> 1017004843;
                case 129 -> -601664345;
                case 130 -> -63211049;
                case 131 -> 512367781;
                case 132 -> 284807572;
                case 133 -> 1419135635;
                case 134 -> 887185128;
                case 135 -> -964469661;
                case 136 -> -1455838961;
                case 137 -> 679299540;
                case 138 -> -683018934;
                case 139 -> 618641083;
                case 140 -> 239202825;
                case 141 -> 472733649;
                case 142 -> 1343869920;
                case 143 -> -1135460641;
                case 144 -> -157306063;
                case 145 -> -358200066;
                case 146 -> 853486249;
                case 147 -> -1427188577;
                case 148 -> 43478938;
                case 149 -> 2032379241;
                case 150 -> -744734475;
                case 151 -> -1342427333;
                case 152 -> -1077409170;
                case 153 -> 847668024;
                case 154 -> 1594543493;
                case 155 -> -50890893;
                case 156 -> 2016698567;
                case 157 -> 1627697026;
                case 158 -> -1161077567;
                case 159 -> -2112223354;
                case 160 -> 1355293534;
                case 161 -> 2118184200;
                case 162 -> -1470111982;
                case 163 -> 1317624178;
                case 164 -> 1435696783;
                case 165 -> -239894450;
                case 166 -> -570357128;
                case 167 -> -496742208;
                case 168 -> 4130973;
                case 169 -> -529569764;
                case 170 -> 1800548197;
                case 171 -> 610292278;
                case 172 -> 636876550;
                case 173 -> 1761306514;
                case 174 -> 904897107;
                case 175 -> -254026913;
                case 176 -> 1329249195;
                case 177 -> -1619097872;
                case 178 -> 1326444427;
                case 179 -> -999057395;
                case 180 -> 1819498634;
                case 181 -> -1558712265;
                case 182 -> -2010099014;
                case 183 -> -478011702;
                case 184 -> -281465876;
                case 185 -> 1378326891;
                case 186 -> -179742645;
                case 187 -> 297912796;
                case 188 -> 960759088;
                case 189 -> 701379359;
                case 190 -> -275740940;
                case 191 -> -1530172770;
                case 192 -> 1613147529;
                case 193 -> 1111507882;
                case 194 -> -392666120;
                case 195 -> -1599881087;
                case 196 -> -1353071984;
                case 197 -> -1225689219;
                case 198 -> -1292867742;
                case 199 -> -97195257;
                case 200 -> 1920733556;
                case 201 -> 207257973;
                case 202 -> 1467647487;
                case 203 -> -542095126;
                case 204 -> 645778740;
                case 205 -> -831710116;
                case 206 -> -1513855124;
                case 207 -> -2052555601;
                case 208 -> -1679932544;
                case 209 -> 133103496;
                case 210 -> 906923040;
                case 211 -> -394621438;
                case 212 -> 477758029;
                case 213 -> -1121067844;
                case 214 -> -578036071;
                case 215 -> -543667210;
                case 216 -> -1226737289;
                case 217 -> 17546914;
                case 218 -> -1257735071;
                case 219 -> -357207299;
                case 220 -> 906926417;
                case 221 -> -612083879;
                case 222 -> -540101060;
                case 223 -> 452740999;
                case 224 -> 2027025701;
                case 225 -> 834735995;
                case 226 -> -1735553985;
                case 227 -> 730176771;
                case 228 -> 649489023;
                case 229 -> 1792734277;
                case 230 -> -1938544705;
                case 231 -> 1067149398;
                case 232 -> -1566288866;
                case 233 -> 918999971;
                case 234 -> -571858641;
                case 235 -> 1108111175;
                case 236 -> 1954269476;
                case 237 -> -942075871;
                case 238 -> -259750453;
                case 239 -> -1437942842;
                case 240 -> -1267764826;
                case 241 -> -267118674;
                case 242 -> 1263791042;
                case 243 -> -1854555663;
                case 244 -> -1285559379;
                case 245 -> -213026710;
                case 246 -> -576185922;
                case 247 -> -838054887;
                case 248 -> -1257122714;
                case 249 -> -614270925;
                case 250 -> -114687190;
                case 251 -> 1196741;
                case 252 -> 35054532;
                case 253 -> -1518715163;
                case 254 -> -1695214424;
                case 255 -> -2076716051;
                default -> 1910813524;
            });
        } while (v2 != 48);
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
            OiI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OiO = new EnumType_iii_0("PRE", 0);
        Oi0 = new EnumType_iii_0("POST", 1);
        Oio = EnumType_iii_0.OOi();
    }

    private static /* synthetic */ EnumType_iii_0[] OOi() {
        return new EnumType_iii_0[]{OiO, Oi0};
    }
}

