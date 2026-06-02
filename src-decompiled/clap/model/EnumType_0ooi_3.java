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
 * Renamed from psx.Hyk.0oOI
 */
public final class EnumType_0ooi_3
extends Enum {
    public static final /* enum */ EnumType_0ooi_3 CriticalsModule;
    public static final /* enum */ EnumType_0ooi_3 XrayModule;
    private static final /* synthetic */ EnumType_0ooi_3[] O0ii;
    static Object RenderSupport_oooo_2;

    public static EnumType_0ooi_3[] values() {
        return (EnumType_0ooi_3[])O0ii.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0ooi_3() {
        void param2;
        void param1;
    }

    public static EnumType_0ooi_3 valueOf(String param0) {
        return Enum.valueOf(EnumType_0ooi_3.class, param0);
    }

    static {
        byte[] v0 = "P\u00a4\u0084B\u00ea\u0081\u00f6\u009a\u0006\u001ap\u00066\u00d7u\u0013Y>\u00dd`\u00fd\u009a\u001e\u0095\u00db\u000b\u00cfOF\u00b5\u00dd\u00a6\\\u00cc\u00a0v\u00b9\u00dd9\u00c9\u00de2Lu\u00d1=/I".getBytes("ISO_8859_1");
        Object[] v1 = "Ex\u0099\u00c0\u00ce\n\u00ec\u00b7".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -923918252;
                case 1 -> -192349452;
                case 2 -> -1705355404;
                case 3 -> 1227100872;
                case 4 -> -1733830263;
                case 5 -> 1804106781;
                case 6 -> -671179234;
                case 7 -> -1225307293;
                case 8 -> 1318496399;
                case 9 -> 698913005;
                case 10 -> -91516747;
                case 11 -> 473425840;
                case 12 -> -1589553503;
                case 13 -> 496772356;
                case 14 -> 865971911;
                case 15 -> -257668924;
                case 16 -> 1579756083;
                case 17 -> 1834403876;
                case 18 -> -1941979697;
                case 19 -> -726315596;
                case 20 -> -819634706;
                case 21 -> 166039166;
                case 22 -> 1335743504;
                case 23 -> 1174185320;
                case 24 -> -31216085;
                case 25 -> 2095685486;
                case 26 -> 2016852827;
                case 27 -> 1066906791;
                case 28 -> -2057472770;
                case 29 -> 270142167;
                case 30 -> -1648130236;
                case 31 -> -2010596558;
                case 32 -> 1629671168;
                case 33 -> -1753763448;
                case 34 -> 1057606124;
                case 35 -> -1481690308;
                case 36 -> 911466327;
                case 37 -> -2043193928;
                case 38 -> 0xB4CCBCB;
                case 39 -> 397646230;
                case 40 -> -1078317734;
                case 41 -> 1779640311;
                case 42 -> -1219058030;
                case 43 -> 1992955031;
                case 44 -> 49452281;
                case 45 -> -503945706;
                case 46 -> -1436933280;
                case 47 -> 1353888620;
                case 48 -> -1648726393;
                case 49 -> -385161913;
                case 50 -> 1668992185;
                case 51 -> 1301622189;
                case 52 -> -461847098;
                case 53 -> 928614815;
                case 54 -> 1641580902;
                case 55 -> 1883333653;
                case 56 -> -989409785;
                case 57 -> 850138584;
                case 58 -> -623857323;
                case 59 -> 71110066;
                case 60 -> -347539301;
                case 61 -> -1234185199;
                case 62 -> -318866564;
                case 63 -> 1006257382;
                case 64 -> -1571012175;
                case 65 -> -314704164;
                case 66 -> -828302261;
                case 67 -> 2098852839;
                case 68 -> 1664201298;
                case 69 -> -1146625551;
                case 70 -> -1012000051;
                case 71 -> 1599620787;
                case 72 -> 447488466;
                case 73 -> 1328687650;
                case 74 -> 1195019073;
                case 75 -> 1374723472;
                case 76 -> 2079500844;
                case 77 -> 1464589743;
                case 78 -> -1655810791;
                case 79 -> 1177137131;
                case 80 -> 1642884899;
                case 81 -> 633526460;
                case 82 -> 299934728;
                case 83 -> 730979581;
                case 84 -> 1795200773;
                case 85 -> 1778444365;
                case 86 -> 535635365;
                case 87 -> 914281308;
                case 88 -> -696277612;
                case 89 -> -1149645696;
                case 90 -> -58343887;
                case 91 -> 48432996;
                case 92 -> -641104075;
                case 93 -> -1788624695;
                case 94 -> -172172669;
                case 95 -> -1883328791;
                case 96 -> 1721111821;
                case 97 -> 1968790018;
                case 98 -> 1753248332;
                case 99 -> -1583796246;
                case 100 -> -637811117;
                case 101 -> 1226622889;
                case 102 -> -214010014;
                case 103 -> 1607156041;
                case 104 -> -1893016770;
                case 105 -> 1520555684;
                case 106 -> -240172414;
                case 107 -> 2016487759;
                case 108 -> -2020518258;
                case 109 -> 637880378;
                case 110 -> 816521923;
                case 111 -> -228603742;
                case 112 -> -1770103447;
                case 113 -> -2140322042;
                case 114 -> 1673284205;
                case 115 -> 1173254201;
                case 116 -> -157156133;
                case 117 -> -902292310;
                case 118 -> -110192361;
                case 119 -> -1710048646;
                case 120 -> 1043356187;
                case 121 -> 2140891918;
                case 122 -> -76347243;
                case 123 -> 518702634;
                case 124 -> 155046553;
                case 125 -> -634939864;
                case 126 -> 1019528657;
                case 127 -> -1247437174;
                case 128 -> -883193085;
                case 129 -> -1329065280;
                case 130 -> -27643488;
                case 131 -> 327202074;
                case 132 -> 1339192841;
                case 133 -> -1005403344;
                case 134 -> -1161013518;
                case 135 -> -544429223;
                case 136 -> -313206988;
                case 137 -> -414859249;
                case 138 -> 117674354;
                case 139 -> 463132511;
                case 140 -> 618446219;
                case 141 -> 1282668312;
                case 142 -> -2120192648;
                case 143 -> 1222130964;
                case 144 -> -1108341338;
                case 145 -> -917067635;
                case 146 -> 12846328;
                case 147 -> -273550807;
                case 148 -> -890699670;
                case 149 -> 1799531766;
                case 150 -> 1850431600;
                case 151 -> 2078938399;
                case 152 -> -798212896;
                case 153 -> -1323438033;
                case 154 -> -1312459007;
                case 155 -> 679730977;
                case 156 -> 1914957796;
                case 157 -> 1663217779;
                case 158 -> 1302618735;
                case 159 -> 648048069;
                case 160 -> 107580171;
                case 161 -> 922961809;
                case 162 -> -559611431;
                case 163 -> 1439517035;
                case 164 -> -1325530640;
                case 165 -> 1155180042;
                case 166 -> -378884948;
                case 167 -> 383834936;
                case 168 -> -1400196205;
                case 169 -> 595774557;
                case 170 -> -2029059256;
                case 171 -> -1148176822;
                case 172 -> 698574831;
                case 173 -> 1118556281;
                case 174 -> -969990875;
                case 175 -> 1202520460;
                case 176 -> 849606467;
                case 177 -> -1952233476;
                case 178 -> 1997233621;
                case 179 -> 212950903;
                case 180 -> -867527898;
                case 181 -> 1348809280;
                case 182 -> -1763747018;
                case 183 -> -1205136287;
                case 184 -> -1382434133;
                case 185 -> 1217178462;
                case 186 -> 1827387344;
                case 187 -> -923378218;
                case 188 -> 1687902371;
                case 189 -> -1907622531;
                case 190 -> 1929631873;
                case 191 -> -917755480;
                case 192 -> 860921424;
                case 193 -> -805769355;
                case 194 -> 1611518040;
                case 195 -> -609311538;
                case 196 -> -424637866;
                case 197 -> -432844131;
                case 198 -> -1392315525;
                case 199 -> 167402053;
                case 200 -> 189870610;
                case 201 -> -1334233414;
                case 202 -> 149153176;
                case 203 -> -1215214564;
                case 204 -> 1047936374;
                case 205 -> 324881070;
                case 206 -> -1107616385;
                case 207 -> -1392984934;
                case 208 -> -1593755977;
                case 209 -> -1714863149;
                case 210 -> -1493883141;
                case 211 -> 1939450618;
                case 212 -> 979798975;
                case 213 -> 117398459;
                case 214 -> 486939726;
                case 215 -> 1591679810;
                case 216 -> 513043303;
                case 217 -> -424984603;
                case 218 -> 633878574;
                case 219 -> 1542242363;
                case 220 -> -1998132860;
                case 221 -> 1015284023;
                case 222 -> -567846;
                case 223 -> -707030306;
                case 224 -> -1709772061;
                case 225 -> 319149190;
                case 226 -> 770297793;
                case 227 -> 0x11171DD;
                case 228 -> -1513613529;
                case 229 -> 434356357;
                case 230 -> -202954740;
                case 231 -> 1076095208;
                case 232 -> -936166454;
                case 233 -> 1715375149;
                case 234 -> 1669417533;
                case 235 -> 252023029;
                case 236 -> 61510326;
                case 237 -> -374377283;
                case 238 -> -199402540;
                case 239 -> -1455371876;
                case 240 -> 982879219;
                case 241 -> 1594527814;
                case 242 -> 270889073;
                case 243 -> 486127648;
                case 244 -> -1287020545;
                case 245 -> 1436936467;
                case 246 -> 640458209;
                case 247 -> -1986214964;
                case 248 -> 1242499266;
                case 249 -> 456107877;
                case 250 -> -1176293551;
                case 251 -> 901642559;
                case 252 -> 1223615934;
                case 253 -> -1980837409;
                case 254 -> -1437529374;
                case 255 -> -150921826;
                default -> -287680191;
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
            RenderSupport_oooo_2 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        CriticalsModule = new EnumType_0ooi_3("New", 0);
        XrayModule = new EnumType_0ooi_3("Old", 1);
        O0ii = EnumType_0ooi_3.SpawnerFinderModule();
    }

    private static /* synthetic */ EnumType_0ooi_3[] SpawnerFinderModule() {
        return new EnumType_0ooi_3[]{CriticalsModule, XrayModule};
    }
}

