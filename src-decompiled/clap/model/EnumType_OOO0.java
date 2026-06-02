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

public final class EnumType_OOO0
extends Enum {
    public static final /* enum */ EnumType_OOO0 World;
    public static final /* enum */ EnumType_OOO0 Other;
    public static final /* enum */ EnumType_OOO0 Gui;
    private static final /* synthetic */ EnumType_OOO0[] $VALUES;
    public static final /* enum */ EnumType_OOO0 Hidden;
    static Object PacketEvent;

    public static EnumType_OOO0[] values() {
        return (EnumType_OOO0[])$VALUES.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_OOO0() {
        void param2;
        void param1;
    }

    public static EnumType_OOO0 valueOf(String param0) {
        return Enum.valueOf(EnumType_OOO0.class, param0);
    }

    static {
        byte[] v0 = "\u000b\u001aw[\u009f\u0095\u0007\u001b\b\u00b98zBu\u0012\u00f6}\u00b4\u00a9\u00a5x\u00af=\u00c4\u008b\"\u0087\u00d5\u00d9\u00c9\u008e=(\u00b20v\u008cw~X'\u00aen\u00fc\u00e0\u00f2T`\n\u00b9\u00c3\u00da\u00e2\u00c2\u00aa\u00b1\u00f9\u008a\u00ca\u00de\u00b1\u00e2\u00fa\u00f5".getBytes("ISO_8859_1");
        Object[] v1 = "\u00bet@\u0094\u00c0\u00d0N\u00de".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1820493299;
                case 1 -> -1893670104;
                case 2 -> 219753621;
                case 3 -> 1248225471;
                case 4 -> 1412856499;
                case 5 -> 783449659;
                case 6 -> 680368711;
                case 7 -> -2041011987;
                case 8 -> 1285536492;
                case 9 -> 1028254418;
                case 10 -> -2137733777;
                case 11 -> 988531462;
                case 12 -> -1027312402;
                case 13 -> -835622692;
                case 14 -> -84229558;
                case 15 -> -916483687;
                case 16 -> 1005311717;
                case 17 -> -172997230;
                case 18 -> -1528174285;
                case 19 -> 1925257461;
                case 20 -> -2047553239;
                case 21 -> -1736880041;
                case 22 -> -849799413;
                case 23 -> -1672923467;
                case 24 -> 103352588;
                case 25 -> -808760275;
                case 26 -> -1674544953;
                case 27 -> 2088133475;
                case 28 -> 1765404897;
                case 29 -> -807295972;
                case 30 -> 33999928;
                case 31 -> 1444597374;
                case 32 -> 900305897;
                case 33 -> 1231360023;
                case 34 -> 305202859;
                case 35 -> -1658164792;
                case 36 -> 1242731814;
                case 37 -> 1634787213;
                case 38 -> -1409640333;
                case 39 -> -1516521435;
                case 40 -> 31023436;
                case 41 -> -1078257760;
                case 42 -> -662898400;
                case 43 -> 980006936;
                case 44 -> -1089823823;
                case 45 -> 1421519979;
                case 46 -> 1156649931;
                case 47 -> -1863040912;
                case 48 -> 2110342537;
                case 49 -> 1804102075;
                case 50 -> -1648511713;
                case 51 -> 249534730;
                case 52 -> 250689163;
                case 53 -> 1106010366;
                case 54 -> 1630680227;
                case 55 -> -848611026;
                case 56 -> -1162297221;
                case 57 -> -1244466794;
                case 58 -> -1441998360;
                case 59 -> 1749211861;
                case 60 -> -1821982626;
                case 61 -> -410927068;
                case 62 -> -706687625;
                case 63 -> -1504942271;
                case 64 -> 1239439637;
                case 65 -> -594138115;
                case 66 -> 845646819;
                case 67 -> -869769505;
                case 68 -> 606347155;
                case 69 -> -295954749;
                case 70 -> -1291442631;
                case 71 -> -1052657132;
                case 72 -> -285309750;
                case 73 -> -408608297;
                case 74 -> 1166988310;
                case 75 -> -1398440883;
                case 76 -> -1298288888;
                case 77 -> 1211472176;
                case 78 -> -1496605594;
                case 79 -> -844539304;
                case 80 -> 1130962847;
                case 81 -> -547504974;
                case 82 -> -1931014869;
                case 83 -> 1223440644;
                case 84 -> -807156205;
                case 85 -> 1504387756;
                case 86 -> -611034329;
                case 87 -> -1817019102;
                case 88 -> 2141550236;
                case 89 -> 268918914;
                case 90 -> 472406857;
                case 91 -> 1900758065;
                case 92 -> 1893910210;
                case 93 -> 1314272445;
                case 94 -> 652812125;
                case 95 -> -414508838;
                case 96 -> -1614225766;
                case 97 -> -436806761;
                case 98 -> 1391607385;
                case 99 -> -1455699353;
                case 100 -> -412828819;
                case 101 -> -1968090866;
                case 102 -> 1801980088;
                case 103 -> -1171762174;
                case 104 -> -1658593742;
                case 105 -> -1747868016;
                case 106 -> 1670654271;
                case 107 -> 224860707;
                case 108 -> -1334408456;
                case 109 -> 750822149;
                case 110 -> 1680507250;
                case 111 -> -411837731;
                case 112 -> -2047220401;
                case 113 -> 1703571646;
                case 114 -> 1788687590;
                case 115 -> 1993217893;
                case 116 -> 1796388782;
                case 117 -> -239538380;
                case 118 -> -1403833425;
                case 119 -> 1525149415;
                case 120 -> -767060481;
                case 121 -> -1410269474;
                case 122 -> 587518313;
                case 123 -> -1887667335;
                case 124 -> 70496067;
                case 125 -> -1541481019;
                case 126 -> -1179252160;
                case 127 -> -463185039;
                case 128 -> 1926863092;
                case 129 -> 1844403068;
                case 130 -> 721330892;
                case 131 -> -260970886;
                case 132 -> -407916732;
                case 133 -> 1796772522;
                case 134 -> -1379120836;
                case 135 -> 1615211106;
                case 136 -> -1103753543;
                case 137 -> 1036932278;
                case 138 -> 2110475943;
                case 139 -> -341129347;
                case 140 -> -813683325;
                case 141 -> -252997459;
                case 142 -> 1416015586;
                case 143 -> -603180800;
                case 144 -> -1927642718;
                case 145 -> -1575270212;
                case 146 -> 1058566324;
                case 147 -> 1483933312;
                case 148 -> -1655250702;
                case 149 -> 1541468612;
                case 150 -> 1674553435;
                case 151 -> 101869598;
                case 152 -> -1903137251;
                case 153 -> 722027793;
                case 154 -> 885101404;
                case 155 -> -1821601777;
                case 156 -> -2069738364;
                case 157 -> -2113278934;
                case 158 -> 374316166;
                case 159 -> -2039605131;
                case 160 -> 433741988;
                case 161 -> 1852275295;
                case 162 -> 1409565403;
                case 163 -> -420240924;
                case 164 -> -1385962378;
                case 165 -> -1784762884;
                case 166 -> -2126170770;
                case 167 -> -701180530;
                case 168 -> -1967417510;
                case 169 -> 159838360;
                case 170 -> -1753670194;
                case 171 -> -1144328803;
                case 172 -> 1652144445;
                case 173 -> -990807446;
                case 174 -> -1572614126;
                case 175 -> -910670708;
                case 176 -> -2099495532;
                case 177 -> -1716937209;
                case 178 -> -345764575;
                case 179 -> 1161400054;
                case 180 -> -801259960;
                case 181 -> -298833752;
                case 182 -> -152442798;
                case 183 -> 1233173974;
                case 184 -> 1095514064;
                case 185 -> 1423230030;
                case 186 -> 1580039600;
                case 187 -> -687552743;
                case 188 -> 1385992943;
                case 189 -> -1804737197;
                case 190 -> -1738431539;
                case 191 -> -1525633210;
                case 192 -> -1620675575;
                case 193 -> -1910465606;
                case 194 -> -350836570;
                case 195 -> -1225810752;
                case 196 -> 1409673848;
                case 197 -> -1196470985;
                case 198 -> 1069375134;
                case 199 -> -2118459664;
                case 200 -> 680975678;
                case 201 -> -102804923;
                case 202 -> 628814548;
                case 203 -> 111815658;
                case 204 -> -925337711;
                case 205 -> 385011459;
                case 206 -> 1285708107;
                case 207 -> -1491768212;
                case 208 -> 818203063;
                case 209 -> -147497100;
                case 210 -> -1020241509;
                case 211 -> 1448798377;
                case 212 -> 1697345760;
                case 213 -> -1938856145;
                case 214 -> -470587257;
                case 215 -> -774654991;
                case 216 -> -1016854583;
                case 217 -> 2113739860;
                case 218 -> -2066157797;
                case 219 -> -1960076929;
                case 220 -> -988308895;
                case 221 -> 428056657;
                case 222 -> -2140293834;
                case 223 -> 1158738689;
                case 224 -> -1016171057;
                case 225 -> -1861241723;
                case 226 -> 1127704336;
                case 227 -> 142879370;
                case 228 -> -505286165;
                case 229 -> 118419155;
                case 230 -> -613836415;
                case 231 -> 156616501;
                case 232 -> -1698157147;
                case 233 -> 1045260027;
                case 234 -> -120016614;
                case 235 -> 1977439056;
                case 236 -> 1487524239;
                case 237 -> 875516776;
                case 238 -> -399408800;
                case 239 -> -1478330938;
                case 240 -> 1708144954;
                case 241 -> 1191120121;
                case 242 -> 2007279426;
                case 243 -> 240453080;
                case 244 -> 964475609;
                case 245 -> 1990022741;
                case 246 -> -1197416973;
                case 247 -> -1207434079;
                case 248 -> -1642079608;
                case 249 -> -2073361471;
                case 250 -> 438815830;
                case 251 -> 577679866;
                case 252 -> 1341235665;
                case 253 -> 1159743788;
                case 254 -> -2047006217;
                case 255 -> -1013306780;
                default -> -440768112;
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
            PacketEvent = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        World = new EnumType_OOO0("World", 0);
        Gui = new EnumType_OOO0("Gui", 1);
        Other = new EnumType_OOO0("Other", 2);
        Hidden = new EnumType_OOO0("Hidden", 3);
        $VALUES = EnumType_OOO0.$values();
    }

    private static /* synthetic */ EnumType_OOO0[] $values() {
        return new EnumType_OOO0[]{World, Gui, Other, Hidden};
    }
}

