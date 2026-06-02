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
 * Renamed from clap.gui.GuiSupport_OOIo
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class EnumType_ooio_0
extends Enum {
    public static final /* enum */ EnumType_ooio_0 0iI;
    public static final /* enum */ EnumType_ooio_0 oOO;
    public static final /* enum */ EnumType_ooio_0 0ii;
    private static final /* synthetic */ EnumType_ooio_0[] oOo;
    public static final /* enum */ EnumType_ooio_0 FastWebModule;
    static Object RenderSupport_ooi_1;

    public static EnumType_ooio_0[] values() {
        return (EnumType_ooio_0[])oOo.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_ooio_0() {
        void param2;
        void param1;
    }

    public static EnumType_ooio_0 valueOf(String param0) {
        return Enum.valueOf(EnumType_ooio_0.class, param0);
    }

    static {
        byte[] v0 = "\u00baVw\u009b\u00a6\u00dc\u001e\\\u008c\u00d8\u00fa\u00e8~\u00e8\u00fdD\u00fd\u00d3)\u00eb\u008c]\u00b0\u0019\u00192\bHw'\u00f3\u00e3hUql\u000e\u0095r\u00eb\u00a9\u001d|\u0016\u00c5\u00a2\u0001\u00a3\u0096\u0096\u00f4>8\u00f6\u0088A\u0004\u00fd\u00d5\u00ff\u0019\u00f82$\u00ccE\u00c3\u00f3\u00fc_7\u00fd/:p\u00a9\u00c6\u00907\u00e5\u00a1\u00d3\r\u00f2\u00af\u0094\u00a4\u00b9".getBytes("ISO_8859_1");
        Object[] v1 = "D\u0080\u009aG?/}\u0007".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1334972840;
                case 1 -> 1443971853;
                case 2 -> -443461289;
                case 3 -> 2107816102;
                case 4 -> -878097584;
                case 5 -> -1380253906;
                case 6 -> 386951207;
                case 7 -> -669936596;
                case 8 -> -206458574;
                case 9 -> 1519239293;
                case 10 -> -959832189;
                case 11 -> 551939239;
                case 12 -> 1221490329;
                case 13 -> -220605676;
                case 14 -> 233317179;
                case 15 -> -1022592683;
                case 16 -> 176377352;
                case 17 -> 398195016;
                case 18 -> 1486608033;
                case 19 -> -7824140;
                case 20 -> 14526367;
                case 21 -> 2059587559;
                case 22 -> 2113982233;
                case 23 -> -1209495062;
                case 24 -> -1627660653;
                case 25 -> -521856360;
                case 26 -> -1425936450;
                case 27 -> -6444168;
                case 28 -> 590301338;
                case 29 -> 430939629;
                case 30 -> 1983095467;
                case 31 -> 1004567936;
                case 32 -> -274311891;
                case 33 -> -590839685;
                case 34 -> 211565347;
                case 35 -> -873335853;
                case 36 -> -1046717477;
                case 37 -> -1353618073;
                case 38 -> -208827975;
                case 39 -> -687356898;
                case 40 -> -1864318881;
                case 41 -> -443490775;
                case 42 -> -666827762;
                case 43 -> 860075971;
                case 44 -> 106924571;
                case 45 -> -824292326;
                case 46 -> 1964656644;
                case 47 -> 1996139512;
                case 48 -> 712090040;
                case 49 -> 1364474299;
                case 50 -> -1131827914;
                case 51 -> 1418288834;
                case 52 -> 995835502;
                case 53 -> 461783905;
                case 54 -> 1690512128;
                case 55 -> -566077610;
                case 56 -> 1573080658;
                case 57 -> -72829959;
                case 58 -> 740028268;
                case 59 -> 1289847218;
                case 60 -> -464073122;
                case 61 -> 1887062356;
                case 62 -> -299678910;
                case 63 -> 1151813295;
                case 64 -> 1568106057;
                case 65 -> -1340595226;
                case 66 -> -72244004;
                case 67 -> 1426476468;
                case 68 -> 235191370;
                case 69 -> -420541823;
                case 70 -> 1450392678;
                case 71 -> -638838635;
                case 72 -> 1665423422;
                case 73 -> -2072214428;
                case 74 -> 287381673;
                case 75 -> 1566453668;
                case 76 -> -1679555835;
                case 77 -> -272271992;
                case 78 -> 1794030306;
                case 79 -> -777347488;
                case 80 -> 491714624;
                case 81 -> -913363950;
                case 82 -> 1827141900;
                case 83 -> 1090770175;
                case 84 -> -816943712;
                case 85 -> 29565558;
                case 86 -> 626346305;
                case 87 -> -62043485;
                case 88 -> 1618091931;
                case 89 -> -147532138;
                case 90 -> -973419407;
                case 91 -> -1721797490;
                case 92 -> 2051409956;
                case 93 -> -796622649;
                case 94 -> 946396930;
                case 95 -> -1235296562;
                case 96 -> -383359755;
                case 97 -> 1632666063;
                case 98 -> 1708848168;
                case 99 -> 355170127;
                case 100 -> 1356045847;
                case 101 -> -1684874022;
                case 102 -> -796136290;
                case 103 -> 615151165;
                case 104 -> -1191453431;
                case 105 -> -1859709444;
                case 106 -> -248165050;
                case 107 -> -151102546;
                case 108 -> -1811398446;
                case 109 -> -397921546;
                case 110 -> 1994456247;
                case 111 -> 1223024668;
                case 112 -> -1428686767;
                case 113 -> -694296438;
                case 114 -> 1334532090;
                case 115 -> 146012961;
                case 116 -> -504109616;
                case 117 -> -462762221;
                case 118 -> -1349655204;
                case 119 -> 2011184262;
                case 120 -> 745101831;
                case 121 -> 64872940;
                case 122 -> -223811782;
                case 123 -> -498067572;
                case 124 -> 1310923152;
                case 125 -> -1028996376;
                case 126 -> -1643870159;
                case 127 -> 527366662;
                case 128 -> -1484531926;
                case 129 -> 1294329034;
                case 130 -> 1424521051;
                case 131 -> -600557636;
                case 132 -> 108376835;
                case 133 -> -1653923468;
                case 134 -> -1267522492;
                case 135 -> -1751966231;
                case 136 -> 173439051;
                case 137 -> -170563931;
                case 138 -> -1551369917;
                case 139 -> 1707267601;
                case 140 -> -1335843280;
                case 141 -> -813621803;
                case 142 -> 901657584;
                case 143 -> -275721761;
                case 144 -> 162368143;
                case 145 -> -889562991;
                case 146 -> 814761153;
                case 147 -> -1026956674;
                case 148 -> 1525472629;
                case 149 -> 1037230132;
                case 150 -> 463854949;
                case 151 -> 1156797299;
                case 152 -> 749914097;
                case 153 -> 1793828049;
                case 154 -> 1980828102;
                case 155 -> 1666092386;
                case 156 -> 1510287506;
                case 157 -> -1073725113;
                case 158 -> -990316522;
                case 159 -> 934749743;
                case 160 -> 1843235622;
                case 161 -> 12224783;
                case 162 -> 716398261;
                case 163 -> 580151149;
                case 164 -> -1612368818;
                case 165 -> -1317058053;
                case 166 -> -1443391865;
                case 167 -> 2081725626;
                case 168 -> 1090851944;
                case 169 -> 1770308619;
                case 170 -> 635753855;
                case 171 -> -1149645222;
                case 172 -> 834379688;
                case 173 -> -1210678313;
                case 174 -> 927410836;
                case 175 -> 1604626554;
                case 176 -> 449239940;
                case 177 -> -1326346527;
                case 178 -> -1742920928;
                case 179 -> -1450987810;
                case 180 -> 617680656;
                case 181 -> -169926807;
                case 182 -> -635816276;
                case 183 -> 1423575865;
                case 184 -> 699594454;
                case 185 -> 1902339082;
                case 186 -> 1778408997;
                case 187 -> 2134020151;
                case 188 -> 700866189;
                case 189 -> 926476023;
                case 190 -> 980257252;
                case 191 -> 1023984622;
                case 192 -> -839873173;
                case 193 -> -341269820;
                case 194 -> 1801436748;
                case 195 -> 1937438005;
                case 196 -> 196861240;
                case 197 -> 442104005;
                case 198 -> -1703078307;
                case 199 -> 913692669;
                case 200 -> -2142477904;
                case 201 -> -1724584768;
                case 202 -> 1499135365;
                case 203 -> -1988425730;
                case 204 -> -1317824638;
                case 205 -> -488348234;
                case 206 -> 1423069157;
                case 207 -> 690581192;
                case 208 -> 1172528240;
                case 209 -> -1825739670;
                case 210 -> -1457243424;
                case 211 -> 1053267924;
                case 212 -> 515946274;
                case 213 -> 1764461489;
                case 214 -> 2089686315;
                case 215 -> 712847481;
                case 216 -> -2116339508;
                case 217 -> 1741805853;
                case 218 -> 1932031059;
                case 219 -> 501902691;
                case 220 -> -1395266559;
                case 221 -> -1894561229;
                case 222 -> -1244643972;
                case 223 -> 346096349;
                case 224 -> -220515473;
                case 225 -> -552840003;
                case 226 -> -794914702;
                case 227 -> -336862395;
                case 228 -> 809823645;
                case 229 -> -1112340765;
                case 230 -> 1985912779;
                case 231 -> 1552943309;
                case 232 -> -298396265;
                case 233 -> -1104014861;
                case 234 -> 2076112319;
                case 235 -> 1761728429;
                case 236 -> 197197784;
                case 237 -> 845576354;
                case 238 -> 15578035;
                case 239 -> 1177551181;
                case 240 -> 1996276599;
                case 241 -> -767635061;
                case 242 -> -1994017301;
                case 243 -> -977409831;
                case 244 -> 1056348402;
                case 245 -> 1295406652;
                case 246 -> -1750284644;
                case 247 -> 328525589;
                case 248 -> -1554275345;
                case 249 -> 1729441881;
                case 250 -> -1625211073;
                case 251 -> -11205608;
                case 252 -> 1493828809;
                case 253 -> -1513963862;
                case 254 -> -1795704951;
                case 255 -> -1314723041;
                default -> -552660295;
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
            Object[] objectArray = new Object[4];
            v1 = objectArray;
            RenderSupport_ooi_1 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0iI = new EnumType_ooio_0("PLACE_WATER", 0);
        0ii = new EnumType_ooio_0("RETRIEVE_WATER", 1);
        oOO = new EnumType_ooio_0("BLOCK_LAVA", 2);
        FastWebModule = new EnumType_ooio_0("BREAK_FIRE", 3);
        oOo = EnumType_ooio_0.Oo0();
    }

    private static /* synthetic */ EnumType_ooio_0[] Oo0() {
        return new EnumType_ooio_0[]{0iI, 0ii, oOO, FastWebModule};
    }
}

