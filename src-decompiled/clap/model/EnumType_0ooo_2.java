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
 * Renamed from psx.Hyk.0Ooo
 */
public final class EnumType_0ooo_2
extends Enum {
    public static final /* enum */ EnumType_0ooo_2 OOIi;
    public static final /* enum */ EnumType_0ooo_2 GuiSupport_OOII;
    private static final /* synthetic */ EnumType_0ooo_2[] EnumType_O0OO;
    public static final /* enum */ EnumType_0ooo_2 OOii;
    public static final /* enum */ EnumType_0ooo_2 OOi0;
    public static final /* enum */ EnumType_0ooo_2 OOio;
    public static final /* enum */ EnumType_0ooo_2 OOiO;
    public static final /* enum */ EnumType_0ooo_2 MoveFixModule;
    static Object SprintResetModule;

    public static EnumType_0ooo_2[] values() {
        return (EnumType_0ooo_2[])EnumType_O0OO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0ooo_2() {
        void param2;
        void param1;
    }

    public static EnumType_0ooo_2 valueOf(String param0) {
        return Enum.valueOf(EnumType_0ooo_2.class, param0);
    }

    static {
        byte[] v0 = "Zz\u007f\u009fM\u00dd\u00c7\r1}\u0093\u00d7\u00a54\u00ab\u00f3\u00a9~cf\u0099z:\u00edH\u00c0\u001b\u0000\u00c9\u0089\u00c2zh\u000fn\u00b7#{m\u00d9\u0083\u00f6\u0003\\\u0019\u0001\u00ec|\u00d6m\u009b\u00d1H\u00b3\u008c\u00be0\u00ff\u0087\u0018\u00ab\u00fe/ u\u00e2G<\u00b5<\u0094\u00a2\u00dd\u00f3>\u00d9\u0098\u00fb\u00cat\u00a24\u009e\u001dL\u00a9y\u0089".getBytes("ISO_8859_1");
        Object[] v1 = "\u0097\u00e5\u0016J\r$\u00e5 ".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1761043079;
                case 1 -> 1182859836;
                case 2 -> -115932214;
                case 3 -> -819782269;
                case 4 -> -243085319;
                case 5 -> 1778865627;
                case 6 -> 2085145600;
                case 7 -> 1936166458;
                case 8 -> -888430846;
                case 9 -> 1156384573;
                case 10 -> -323614183;
                case 11 -> -51284259;
                case 12 -> 725893759;
                case 13 -> -1903184943;
                case 14 -> 95408980;
                case 15 -> -1500474220;
                case 16 -> 1811438208;
                case 17 -> 1732181122;
                case 18 -> 784311879;
                case 19 -> 188065735;
                case 20 -> -1129899144;
                case 21 -> 39828449;
                case 22 -> 1005492880;
                case 23 -> -1577969840;
                case 24 -> 1422483440;
                case 25 -> -1103016259;
                case 26 -> -758913537;
                case 27 -> -454319149;
                case 28 -> -1219548274;
                case 29 -> 1516711425;
                case 30 -> 560135931;
                case 31 -> -1192006627;
                case 32 -> -1200396350;
                case 33 -> 175655112;
                case 34 -> 1091542325;
                case 35 -> -2037320207;
                case 36 -> 598526322;
                case 37 -> 1361626034;
                case 38 -> -2132780699;
                case 39 -> 1497817937;
                case 40 -> 1181698761;
                case 41 -> -1568000787;
                case 42 -> 1187952355;
                case 43 -> 2145426771;
                case 44 -> 635537670;
                case 45 -> -1015453995;
                case 46 -> -1361194820;
                case 47 -> 502599689;
                case 48 -> 1709048679;
                case 49 -> 597703788;
                case 50 -> 1878983647;
                case 51 -> 79446128;
                case 52 -> -1898968787;
                case 53 -> 737496024;
                case 54 -> 1458452147;
                case 55 -> -182820444;
                case 56 -> 1517863988;
                case 57 -> -1005965320;
                case 58 -> 1052092970;
                case 59 -> 664577790;
                case 60 -> 1839779599;
                case 61 -> 1880412463;
                case 62 -> 1596160440;
                case 63 -> -28244651;
                case 64 -> -1698751666;
                case 65 -> 531563670;
                case 66 -> 24714213;
                case 67 -> 153324485;
                case 68 -> -1366936228;
                case 69 -> -2062862211;
                case 70 -> -1119902035;
                case 71 -> -855564450;
                case 72 -> 1528112594;
                case 73 -> -49006628;
                case 74 -> -1062101966;
                case 75 -> -509036911;
                case 76 -> 317286232;
                case 77 -> 1306074326;
                case 78 -> -204113610;
                case 79 -> 655447006;
                case 80 -> 1438897412;
                case 81 -> -653920898;
                case 82 -> -109945118;
                case 83 -> -891522609;
                case 84 -> -651530832;
                case 85 -> 389861047;
                case 86 -> -809862210;
                case 87 -> 766613255;
                case 88 -> 604850207;
                case 89 -> -30797066;
                case 90 -> -1575147967;
                case 91 -> 416891273;
                case 92 -> 942491639;
                case 93 -> 1097495434;
                case 94 -> -395528921;
                case 95 -> 456809653;
                case 96 -> 281487594;
                case 97 -> -1928865300;
                case 98 -> 1134725443;
                case 99 -> -482412411;
                case 100 -> 1827544390;
                case 101 -> -88737246;
                case 102 -> 1481502670;
                case 103 -> 1717174861;
                case 104 -> 690823055;
                case 105 -> 542024714;
                case 106 -> -933187510;
                case 107 -> 405868714;
                case 108 -> 2008447298;
                case 109 -> 1771624737;
                case 110 -> 467042840;
                case 111 -> 671785630;
                case 112 -> 1960665562;
                case 113 -> -1469758389;
                case 114 -> -1920180;
                case 115 -> 340942586;
                case 116 -> -821193533;
                case 117 -> 1203611227;
                case 118 -> -1994278884;
                case 119 -> 386540453;
                case 120 -> -1439613547;
                case 121 -> -1332985538;
                case 122 -> -1123909259;
                case 123 -> 1142426457;
                case 124 -> 1052095115;
                case 125 -> -1157926076;
                case 126 -> 1534442094;
                case 127 -> 1221501026;
                case 128 -> 1751367908;
                case 129 -> 2132598975;
                case 130 -> -500213959;
                case 131 -> -1005721293;
                case 132 -> -515338066;
                case 133 -> 745211171;
                case 134 -> -525789955;
                case 135 -> 758193768;
                case 136 -> -46634222;
                case 137 -> 1773076287;
                case 138 -> -1512387391;
                case 139 -> 1323699525;
                case 140 -> -1555767565;
                case 141 -> -117450986;
                case 142 -> -259537429;
                case 143 -> -414673912;
                case 144 -> 1309563;
                case 145 -> 1160756739;
                case 146 -> -682727825;
                case 147 -> 158186614;
                case 148 -> 111071003;
                case 149 -> 441379014;
                case 150 -> 2023349781;
                case 151 -> 992953001;
                case 152 -> -1732692068;
                case 153 -> 288554657;
                case 154 -> -227818476;
                case 155 -> -440291292;
                case 156 -> -299519383;
                case 157 -> 1366122887;
                case 158 -> -1863470470;
                case 159 -> -978562035;
                case 160 -> 471587128;
                case 161 -> -586570147;
                case 162 -> 1595496288;
                case 163 -> 1750835366;
                case 164 -> 273719337;
                case 165 -> -250541973;
                case 166 -> 1086822843;
                case 167 -> 402382036;
                case 168 -> -973372864;
                case 169 -> 1818673463;
                case 170 -> 1331538538;
                case 171 -> -1831656948;
                case 172 -> 1363425808;
                case 173 -> 526155866;
                case 174 -> 1415135108;
                case 175 -> -1624303813;
                case 176 -> -1170687061;
                case 177 -> 1352493259;
                case 178 -> 1298872948;
                case 179 -> -1720985527;
                case 180 -> -1406963066;
                case 181 -> 1258380796;
                case 182 -> -421362616;
                case 183 -> -203487921;
                case 184 -> 622203048;
                case 185 -> 46234509;
                case 186 -> -1323376992;
                case 187 -> -775229232;
                case 188 -> -2080543629;
                case 189 -> -1700657801;
                case 190 -> -1898058321;
                case 191 -> 1277906278;
                case 192 -> 1171730322;
                case 193 -> 171256593;
                case 194 -> -491601231;
                case 195 -> -93458036;
                case 196 -> 753558964;
                case 197 -> 1352492582;
                case 198 -> 1813685917;
                case 199 -> 1329559187;
                case 200 -> 1802509730;
                case 201 -> 1651333646;
                case 202 -> -2035814923;
                case 203 -> -1816339735;
                case 204 -> 1042920679;
                case 205 -> 2024699168;
                case 206 -> -1310322503;
                case 207 -> 1993894592;
                case 208 -> 1865842408;
                case 209 -> 569818806;
                case 210 -> 1831361183;
                case 211 -> -2066640691;
                case 212 -> -967649506;
                case 213 -> -1207336276;
                case 214 -> -1448680658;
                case 215 -> -2138811741;
                case 216 -> 96920968;
                case 217 -> -603594770;
                case 218 -> 1701028619;
                case 219 -> -1353801958;
                case 220 -> -890533550;
                case 221 -> -1008641588;
                case 222 -> -1802773200;
                case 223 -> 764852119;
                case 224 -> 1385184791;
                case 225 -> 1427891609;
                case 226 -> -475515964;
                case 227 -> 1725908310;
                case 228 -> -1795884957;
                case 229 -> -713148667;
                case 230 -> 1160775521;
                case 231 -> -1240793926;
                case 232 -> -2034811680;
                case 233 -> -360043989;
                case 234 -> -1086646253;
                case 235 -> -96808319;
                case 236 -> 742521128;
                case 237 -> 1850772348;
                case 238 -> -1000964378;
                case 239 -> -540073179;
                case 240 -> -129768655;
                case 241 -> 2078191015;
                case 242 -> 724587762;
                case 243 -> -1664788582;
                case 244 -> 195582447;
                case 245 -> -508983081;
                case 246 -> -702555687;
                case 247 -> -1590631525;
                case 248 -> 181082264;
                case 249 -> -1132246931;
                case 250 -> 1942341420;
                case 251 -> 153593188;
                case 252 -> -2007025321;
                case 253 -> 1694730847;
                case 254 -> -1084548239;
                case 255 -> -1838739212;
                default -> 1996901015;
            });
        } while (v2 != 88);
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
            Object[] objectArray = new Object[7];
            v1 = objectArray;
            SprintResetModule = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        GuiSupport_OOII = new EnumType_0ooo_2("SUNRISE", 0);
        OOIi = new EnumType_0ooo_2("DAY", 1);
        OOiO = new EnumType_0ooo_2("NOON", 2);
        OOi0 = new EnumType_0ooo_2("SUNSET", 3);
        OOio = new EnumType_0ooo_2("NIGHT", 4);
        MoveFixModule = new EnumType_0ooo_2("MIDNIGHT", 5);
        OOii = new EnumType_0ooo_2("CUSTOM", 6);
        EnumType_O0OO = EnumType_0ooo_2.StorageEspModule();
    }

    private static /* synthetic */ EnumType_0ooo_2[] StorageEspModule() {
        return new EnumType_0ooo_2[]{GuiSupport_OOII, OOIi, OOiO, OOi0, OOio, MoveFixModule, OOii};
    }
}

