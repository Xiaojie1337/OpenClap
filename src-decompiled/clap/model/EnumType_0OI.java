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

public final class EnumType_0OI
extends Enum {
    public static final /* enum */ EnumType_0OI PacketEvent;
    public static final /* enum */ EnumType_0OI HelpCommand;
    private static final /* synthetic */ EnumType_0OI[] OOo;
    static Object GuiSupport_OOI;

    public static EnumType_0OI[] values() {
        return (EnumType_0OI[])OOo.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0OI() {
        void param2;
        void param1;
    }

    public static EnumType_0OI valueOf(String param0) {
        return Enum.valueOf(EnumType_0OI.class, param0);
    }

    static {
        byte[] v0 = "\u00d6!M\u000b\u0095d\u00d8\u001b\u00c39Fa\u00b4\u00dc\u0003o\u0010\u009aS\u00f6\u00e4N\u00ac\u0083ttRv`\u00b5U~C\u008b\u009d\u00b6Q\u0088\u00cb\u009aR&g\u00ffHJ_\u00f6".getBytes("ISO_8859_1");
        Object[] v1 = "LV\u00f9\u00045,0-".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1043744141;
                case 1 -> -1788766251;
                case 2 -> 1679506578;
                case 3 -> -1012515998;
                case 4 -> -1168345369;
                case 5 -> 359576875;
                case 6 -> -1024080178;
                case 7 -> 884300408;
                case 8 -> -145686026;
                case 9 -> -1491462074;
                case 10 -> 1122301939;
                case 11 -> -1547305945;
                case 12 -> -1283492192;
                case 13 -> 440123649;
                case 14 -> 1609187122;
                case 15 -> -468328953;
                case 16 -> 1380510746;
                case 17 -> 607452712;
                case 18 -> 1403234094;
                case 19 -> 588471384;
                case 20 -> 1135414326;
                case 21 -> 150113016;
                case 22 -> 462562056;
                case 23 -> 315268824;
                case 24 -> -1818025901;
                case 25 -> 1964550252;
                case 26 -> -124450650;
                case 27 -> -1702560318;
                case 28 -> -1676569476;
                case 29 -> -793646020;
                case 30 -> 1779915713;
                case 31 -> 1208248013;
                case 32 -> 1022047927;
                case 33 -> -1575963114;
                case 34 -> 1074911630;
                case 35 -> 403561939;
                case 36 -> 413776301;
                case 37 -> 1327397894;
                case 38 -> 869191620;
                case 39 -> 2090035430;
                case 40 -> -2133771763;
                case 41 -> 1465085880;
                case 42 -> -1500824696;
                case 43 -> 721355215;
                case 44 -> -425670132;
                case 45 -> 1698962427;
                case 46 -> 1893910620;
                case 47 -> 1797608516;
                case 48 -> -204453674;
                case 49 -> -1420164870;
                case 50 -> -1129671518;
                case 51 -> -1602194185;
                case 52 -> -1770254928;
                case 53 -> 1864850141;
                case 54 -> 2126044939;
                case 55 -> 952090546;
                case 56 -> -1100797859;
                case 57 -> 1897235379;
                case 58 -> 2102790451;
                case 59 -> 1035705064;
                case 60 -> -1062915239;
                case 61 -> -1238324111;
                case 62 -> -1258979253;
                case 63 -> -2102339639;
                case 64 -> 242813120;
                case 65 -> -959784139;
                case 66 -> 362514241;
                case 67 -> -560936705;
                case 68 -> 1663422495;
                case 69 -> -1847891729;
                case 70 -> -633407472;
                case 71 -> -1938789092;
                case 72 -> -904118761;
                case 73 -> 564093057;
                case 74 -> 1589927509;
                case 75 -> -1594739166;
                case 76 -> -408557084;
                case 77 -> 760388372;
                case 78 -> 992090141;
                case 79 -> 1563118034;
                case 80 -> 293412593;
                case 81 -> 1293965243;
                case 82 -> 1360224895;
                case 83 -> -297910432;
                case 84 -> -788557110;
                case 85 -> 1407561009;
                case 86 -> 1337615385;
                case 87 -> 435343969;
                case 88 -> -221061884;
                case 89 -> -1253098045;
                case 90 -> 1139781301;
                case 91 -> 1160965093;
                case 92 -> -403072901;
                case 93 -> 964612203;
                case 94 -> 251646445;
                case 95 -> -825556075;
                case 96 -> -825980948;
                case 97 -> -654515714;
                case 98 -> -427957741;
                case 99 -> -1605053934;
                case 100 -> 1593523656;
                case 101 -> -276478790;
                case 102 -> 1222384943;
                case 103 -> 638628968;
                case 104 -> 1347158819;
                case 105 -> -243444818;
                case 106 -> 2045379664;
                case 107 -> 904087723;
                case 108 -> -859109009;
                case 109 -> 433417041;
                case 110 -> -1570134649;
                case 111 -> 1123167401;
                case 112 -> -2025511190;
                case 113 -> -1275160368;
                case 114 -> -52174242;
                case 115 -> 397663249;
                case 116 -> 246063583;
                case 117 -> -2101826956;
                case 118 -> 436068708;
                case 119 -> 284429992;
                case 120 -> -1457858242;
                case 121 -> -1878247608;
                case 122 -> -1508896541;
                case 123 -> -359717383;
                case 124 -> 442611750;
                case 125 -> 1611078658;
                case 126 -> 1256282454;
                case 127 -> -541292562;
                case 128 -> 927223596;
                case 129 -> -167143837;
                case 130 -> 1097821140;
                case 131 -> -2048334169;
                case 132 -> -1995830800;
                case 133 -> 1994199516;
                case 134 -> 47660917;
                case 135 -> 262070172;
                case 136 -> -813414708;
                case 137 -> -5430678;
                case 138 -> -1023461204;
                case 139 -> -837978843;
                case 140 -> 732848784;
                case 141 -> -829527735;
                case 142 -> 500599299;
                case 143 -> -392084163;
                case 144 -> -1239654912;
                case 145 -> 1271286049;
                case 146 -> -1491876363;
                case 147 -> -2078376311;
                case 148 -> 1259259037;
                case 149 -> 1321315352;
                case 150 -> 0x696A9AA;
                case 151 -> 1928789191;
                case 152 -> 1046903958;
                case 153 -> -36157708;
                case 154 -> -2026919427;
                case 155 -> 410587504;
                case 156 -> 1276874757;
                case 157 -> 2010973710;
                case 158 -> -1395539324;
                case 159 -> 1294520971;
                case 160 -> -1836695737;
                case 161 -> -1722565729;
                case 162 -> -1604745603;
                case 163 -> -983629467;
                case 164 -> 1392099194;
                case 165 -> 1613693763;
                case 166 -> 1012826943;
                case 167 -> 157671913;
                case 168 -> -14382943;
                case 169 -> -545711276;
                case 170 -> -432904357;
                case 171 -> 1493012239;
                case 172 -> 648163518;
                case 173 -> 1132274913;
                case 174 -> 1652786402;
                case 175 -> -1867076723;
                case 176 -> -731445376;
                case 177 -> -298981492;
                case 178 -> -1538350172;
                case 179 -> 522939946;
                case 180 -> 124651797;
                case 181 -> 1038238150;
                case 182 -> 2032546894;
                case 183 -> 1745648941;
                case 184 -> 563471993;
                case 185 -> -1655786952;
                case 186 -> -1651287543;
                case 187 -> 1282935818;
                case 188 -> 1663180364;
                case 189 -> 1042725920;
                case 190 -> -2118689418;
                case 191 -> 2020026329;
                case 192 -> 220298208;
                case 193 -> 2135426458;
                case 194 -> 261782681;
                case 195 -> 627455259;
                case 196 -> 1363897959;
                case 197 -> -688094229;
                case 198 -> 1946104997;
                case 199 -> 680199255;
                case 200 -> 1325010075;
                case 201 -> -117439842;
                case 202 -> -27303347;
                case 203 -> -571736354;
                case 204 -> -1963018972;
                case 205 -> 1506337631;
                case 206 -> 120255870;
                case 207 -> 738282634;
                case 208 -> 1600890434;
                case 209 -> -1671765839;
                case 210 -> -1296697860;
                case 211 -> -695072872;
                case 212 -> 558694845;
                case 213 -> -1863964105;
                case 214 -> -977396548;
                case 215 -> 1750909248;
                case 216 -> 1089470313;
                case 217 -> 1340356921;
                case 218 -> 1682859711;
                case 219 -> 1842087503;
                case 220 -> -1912642734;
                case 221 -> -2105075015;
                case 222 -> -280420750;
                case 223 -> -1224958416;
                case 224 -> 1739090321;
                case 225 -> -714662070;
                case 226 -> -1639482761;
                case 227 -> 358917918;
                case 228 -> -630477714;
                case 229 -> -525980713;
                case 230 -> 1695005938;
                case 231 -> 382198746;
                case 232 -> 628219060;
                case 233 -> -260108923;
                case 234 -> 194076835;
                case 235 -> -1122583405;
                case 236 -> -2139867845;
                case 237 -> 766156470;
                case 238 -> -1597447034;
                case 239 -> 379251586;
                case 240 -> 767886979;
                case 241 -> -982803793;
                case 242 -> -22865299;
                case 243 -> -324158773;
                case 244 -> 1510261467;
                case 245 -> 682450575;
                case 246 -> 2143428916;
                case 247 -> -564047980;
                case 248 -> 953446609;
                case 249 -> 129043034;
                case 250 -> 910456005;
                case 251 -> 424117350;
                case 252 -> 1805543465;
                case 253 -> -947407558;
                case 254 -> 2100337989;
                case 255 -> 1108746647;
                default -> -1986349727;
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
            GuiSupport_OOI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        PacketEvent = new EnumType_0OI("TOGGLE", 0);
        HelpCommand = new EnumType_0OI("HOLD", 1);
        OOo = EnumType_0OI.PacketEvent();
    }

    private static /* synthetic */ EnumType_0OI[] PacketEvent() {
        return new EnumType_0OI[]{PacketEvent, HelpCommand};
    }
}

