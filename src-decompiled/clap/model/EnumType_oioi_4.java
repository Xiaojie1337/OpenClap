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
 * Renamed from psx.Hyk.OiOi
 */
public final class EnumType_oioi_4
extends Enum {
    public static final /* enum */ EnumType_oioi_4 iIi;
    public static final /* enum */ EnumType_oioi_4 iiO;
    private static final /* synthetic */ EnumType_oioi_4[] EnumType_ii0_2;
    static Object iio;

    public static EnumType_oioi_4[] values() {
        return (EnumType_oioi_4[])EnumType_ii0_2.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oioi_4() {
        void param2;
        void param1;
    }

    public static EnumType_oioi_4 valueOf(String param0) {
        return Enum.valueOf(EnumType_oioi_4.class, param0);
    }

    static {
        byte[] v0 = "\u00c7\u00bb\u008d\u0091O!\u0011%j\u00b5\u00af\u00f7\u00b3}\u0092\u0012d\u00d2\u00ef\u00dfC\b\u00dc~5\u0004\fd\u00aa\u00fdn\u0088\u00fe8o\u00f3(V\u00ff\u00d6\u00eeN\u00e6\u00cek\u00c3N\u0083".getBytes("ISO_8859_1");
        Object[] v1 = "(\u00cb\u00b9\u00f2\u00de2\u0096\u00b4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -70801663;
                case 1 -> -392648770;
                case 2 -> -542774197;
                case 3 -> -285761699;
                case 4 -> 1757813332;
                case 5 -> -1888729521;
                case 6 -> -1297333486;
                case 7 -> -1964005653;
                case 8 -> 113731765;
                case 9 -> -605004267;
                case 10 -> -922525173;
                case 11 -> -1665390977;
                case 12 -> 948868280;
                case 13 -> 18397466;
                case 14 -> -336589451;
                case 15 -> -1392051243;
                case 16 -> -1192435081;
                case 17 -> 1208343579;
                case 18 -> -16855901;
                case 19 -> -249555953;
                case 20 -> 1432326557;
                case 21 -> 1348470958;
                case 22 -> -1183313880;
                case 23 -> -1782812293;
                case 24 -> -910895985;
                case 25 -> 303792156;
                case 26 -> 202490518;
                case 27 -> 1927958002;
                case 28 -> 1053383715;
                case 29 -> -773473382;
                case 30 -> -1175965694;
                case 31 -> 1477849936;
                case 32 -> -1281215084;
                case 33 -> 1432372105;
                case 34 -> -2082164327;
                case 35 -> -2071731140;
                case 36 -> 1446821074;
                case 37 -> -1857593180;
                case 38 -> 458780967;
                case 39 -> -816232184;
                case 40 -> -1297554086;
                case 41 -> 1190126201;
                case 42 -> -1208600115;
                case 43 -> 1502144970;
                case 44 -> 832581152;
                case 45 -> -1586980393;
                case 46 -> 2126390794;
                case 47 -> -154367198;
                case 48 -> -703731767;
                case 49 -> -1035905808;
                case 50 -> -15030679;
                case 51 -> 1354237330;
                case 52 -> -1725715202;
                case 53 -> 1271036432;
                case 54 -> -1986122298;
                case 55 -> -621321532;
                case 56 -> 1759460164;
                case 57 -> -1619161631;
                case 58 -> 1824879133;
                case 59 -> 826990553;
                case 60 -> 1133840443;
                case 61 -> -1647299151;
                case 62 -> -1608894329;
                case 63 -> 1241931335;
                case 64 -> 1986344484;
                case 65 -> -361195265;
                case 66 -> -1051796941;
                case 67 -> -503227024;
                case 68 -> -893988107;
                case 69 -> -588046409;
                case 70 -> -1314180926;
                case 71 -> -1270901892;
                case 72 -> -1171293885;
                case 73 -> 1850145681;
                case 74 -> -1868069741;
                case 75 -> -278287431;
                case 76 -> 1062981975;
                case 77 -> 1516762976;
                case 78 -> 991599994;
                case 79 -> 548459108;
                case 80 -> -576754669;
                case 81 -> -827756130;
                case 82 -> 422326319;
                case 83 -> -1641081806;
                case 84 -> 994642999;
                case 85 -> -98071723;
                case 86 -> -1601362963;
                case 87 -> -1249794336;
                case 88 -> 2131907459;
                case 89 -> -1781994024;
                case 90 -> 143360364;
                case 91 -> 1434038030;
                case 92 -> 1293968364;
                case 93 -> -2134072390;
                case 94 -> -894431321;
                case 95 -> 378743064;
                case 96 -> 554495078;
                case 97 -> 838660768;
                case 98 -> 2028981986;
                case 99 -> -458695472;
                case 100 -> 550876778;
                case 101 -> 1708735751;
                case 102 -> -2107903135;
                case 103 -> -933779629;
                case 104 -> -905273031;
                case 105 -> -594134459;
                case 106 -> -992016084;
                case 107 -> -2030926004;
                case 108 -> -714039114;
                case 109 -> 2029331212;
                case 110 -> 1581143284;
                case 111 -> -670298240;
                case 112 -> -808303290;
                case 113 -> -941118923;
                case 114 -> 1820504202;
                case 115 -> -1900983379;
                case 116 -> -2028159954;
                case 117 -> 570409958;
                case 118 -> 912025425;
                case 119 -> 1170028502;
                case 120 -> 57829897;
                case 121 -> -1073242817;
                case 122 -> 726259304;
                case 123 -> 1365988462;
                case 124 -> 852132216;
                case 125 -> 1695506331;
                case 126 -> -108996559;
                case 127 -> 264433071;
                case 128 -> 893861597;
                case 129 -> -1627163279;
                case 130 -> -1994967679;
                case 131 -> 1155277797;
                case 132 -> -1092442168;
                case 133 -> 481791021;
                case 134 -> 1894166046;
                case 135 -> 1251662539;
                case 136 -> -760481053;
                case 137 -> -1837136336;
                case 138 -> -1502784982;
                case 139 -> 1015746470;
                case 140 -> 583935182;
                case 141 -> 238093288;
                case 142 -> -156028354;
                case 143 -> 1666004605;
                case 144 -> 825879025;
                case 145 -> 905792395;
                case 146 -> -1085623791;
                case 147 -> 1589159746;
                case 148 -> 1565830890;
                case 149 -> -1807959301;
                case 150 -> 1678831742;
                case 151 -> -2050668726;
                case 152 -> -172560233;
                case 153 -> -230560731;
                case 154 -> -458744042;
                case 155 -> -1230186237;
                case 156 -> 672390609;
                case 157 -> -1629726474;
                case 158 -> -2080522907;
                case 159 -> 600291532;
                case 160 -> -418008012;
                case 161 -> -409529340;
                case 162 -> -1194656512;
                case 163 -> 1102047782;
                case 164 -> 479250531;
                case 165 -> -1355157646;
                case 166 -> 673045620;
                case 167 -> -999245629;
                case 168 -> 1747536473;
                case 169 -> -438298048;
                case 170 -> -1898074559;
                case 171 -> -214415107;
                case 172 -> 1302742971;
                case 173 -> 1213796016;
                case 174 -> -1792663035;
                case 175 -> -1755058694;
                case 176 -> -991005270;
                case 177 -> -1698859880;
                case 178 -> 713032745;
                case 179 -> 1947671721;
                case 180 -> 777107419;
                case 181 -> 107683773;
                case 182 -> 1554987669;
                case 183 -> -1038599708;
                case 184 -> 2056026647;
                case 185 -> 725123144;
                case 186 -> -2143171681;
                case 187 -> 1336785677;
                case 188 -> -48213205;
                case 189 -> 803279296;
                case 190 -> -494670905;
                case 191 -> 15288993;
                case 192 -> -1552974514;
                case 193 -> -474899859;
                case 194 -> 1144608627;
                case 195 -> -646586957;
                case 196 -> -776004065;
                case 197 -> 479485551;
                case 198 -> -1145275681;
                case 199 -> 14220636;
                case 200 -> -1155631704;
                case 201 -> -2046131358;
                case 202 -> -936890413;
                case 203 -> 1416014105;
                case 204 -> -663791340;
                case 205 -> 1084314548;
                case 206 -> -835120164;
                case 207 -> -903180206;
                case 208 -> -5330811;
                case 209 -> 54990508;
                case 210 -> -1495286967;
                case 211 -> -855601862;
                case 212 -> 1029803652;
                case 213 -> 30192633;
                case 214 -> -1756543566;
                case 215 -> -1354651908;
                case 216 -> -789135016;
                case 217 -> 454971580;
                case 218 -> -19394860;
                case 219 -> -1509298611;
                case 220 -> -935778725;
                case 221 -> -1081171521;
                case 222 -> 1219400481;
                case 223 -> 1986992540;
                case 224 -> -1880920926;
                case 225 -> 1899340993;
                case 226 -> -1976911786;
                case 227 -> 256285637;
                case 228 -> 775591222;
                case 229 -> -1625496202;
                case 230 -> 2063076226;
                case 231 -> -527065905;
                case 232 -> -1433434056;
                case 233 -> 620799454;
                case 234 -> -1234982010;
                case 235 -> 2092179294;
                case 236 -> -1343877414;
                case 237 -> -1106349427;
                case 238 -> 223672056;
                case 239 -> 1104162213;
                case 240 -> -1274943255;
                case 241 -> -562103381;
                case 242 -> -86364867;
                case 243 -> -1139485077;
                case 244 -> -1392455544;
                case 245 -> 1735543814;
                case 246 -> 1780782476;
                case 247 -> -1669047833;
                case 248 -> -1598905361;
                case 249 -> -1890407954;
                case 250 -> 277078631;
                case 251 -> 1976817759;
                case 252 -> 2018442227;
                case 253 -> -931941490;
                case 254 -> -794236681;
                case 255 -> -1836429936;
                default -> -2093353451;
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
            iio = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iIi = new EnumType_oioi_4("Mode1", 0);
        iiO = new EnumType_oioi_4("Mode2", 1);
        EnumType_ii0_2 = EnumType_oioi_4.ConfigSupport_0OO();
    }

    private static /* synthetic */ EnumType_oioi_4[] ConfigSupport_0OO() {
        return new EnumType_oioi_4[]{iIi, iiO};
    }
}

