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
 * Renamed from clap.model.EnumType_oi0i_1
 */
public final class EnumType_oi0i_1
extends Enum {
    public static final /* enum */ EnumType_oi0i_1 iio;
    public static final /* enum */ EnumType_oi0i_1 iii;
    public static final /* enum */ EnumType_oi0i_1 iiI;
    private static final /* synthetic */ EnumType_oi0i_1[] EnumType_OOO0;
    public static final /* enum */ EnumType_oi0i_1 Module;
    static Object OOOo;

    public static EnumType_oi0i_1[] values() {
        return (EnumType_oi0i_1[])EnumType_OOO0.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oi0i_1() {
        void param2;
        void param1;
    }

    public static EnumType_oi0i_1 valueOf(String param0) {
        return Enum.valueOf(EnumType_oi0i_1.class, param0);
    }

    static {
        byte[] v0 = "\u00ac\u0098\u008b\u00c9\u00ed\u00f5\"\u008eR_\u00f5.\r\u00f1)\u0092*(\u0000\u000fH\u000bFV\b@p\u00a8\u00e5?\u00db\u0000n\u00ba/\u00ae\u00f5i\u00f1\u008a\u00b5\u00c0\u00ee\u00c2\u0090\u00025\u001c\u00d2\u00a8o\u001b4TP\u00f4\u0090\u0004`H\td\u0018\u00cf\f`\u0006\u00c9>}\u0018\u00dd".getBytes("ISO_8859_1");
        Object[] v1 = "c\u00a1\u00828\u0080\u0087\u001fY".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1079282187;
                case 1 -> 358762122;
                case 2 -> -199382694;
                case 3 -> -621577886;
                case 4 -> 471933401;
                case 5 -> -2066687656;
                case 6 -> 1556088582;
                case 7 -> -856156056;
                case 8 -> -337284578;
                case 9 -> -561894142;
                case 10 -> 853927317;
                case 11 -> -1962762814;
                case 12 -> -670660560;
                case 13 -> -1387085524;
                case 14 -> 979849141;
                case 15 -> -998280853;
                case 16 -> -1845776268;
                case 17 -> -880380854;
                case 18 -> -640421508;
                case 19 -> 348463144;
                case 20 -> -1789358442;
                case 21 -> -97963315;
                case 22 -> -732444962;
                case 23 -> 1371472191;
                case 24 -> -1456846757;
                case 25 -> 1562674458;
                case 26 -> 1005184516;
                case 27 -> 1376209650;
                case 28 -> 346076140;
                case 29 -> -1509647375;
                case 30 -> 1577557088;
                case 31 -> 1264099987;
                case 32 -> 1244847307;
                case 33 -> -32802541;
                case 34 -> 313343309;
                case 35 -> 1310567836;
                case 36 -> -7369613;
                case 37 -> 1691971144;
                case 38 -> 442593915;
                case 39 -> 2120689417;
                case 40 -> 1688176607;
                case 41 -> -1747058398;
                case 42 -> -465639340;
                case 43 -> -738758792;
                case 44 -> -1444370555;
                case 45 -> -1875584420;
                case 46 -> 590585797;
                case 47 -> -593709862;
                case 48 -> -738317748;
                case 49 -> -590973586;
                case 50 -> 2037137935;
                case 51 -> 335617588;
                case 52 -> 396080422;
                case 53 -> 1035770135;
                case 54 -> 1431651835;
                case 55 -> 1688901355;
                case 56 -> -1647444452;
                case 57 -> -657005999;
                case 58 -> -66928020;
                case 59 -> -1252385903;
                case 60 -> -1570436356;
                case 61 -> -1809067811;
                case 62 -> -194301850;
                case 63 -> -1902855882;
                case 64 -> -1105625855;
                case 65 -> -760794175;
                case 66 -> 1425050776;
                case 67 -> -736193457;
                case 68 -> -896570263;
                case 69 -> 727642670;
                case 70 -> 1282836858;
                case 71 -> -674061092;
                case 72 -> -302605915;
                case 73 -> 1055089252;
                case 74 -> 150718805;
                case 75 -> 617089344;
                case 76 -> -676253664;
                case 77 -> -2076129037;
                case 78 -> 1922521403;
                case 79 -> -446689011;
                case 80 -> 1013399992;
                case 81 -> -1900298865;
                case 82 -> 572183009;
                case 83 -> -1293522812;
                case 84 -> -276911148;
                case 85 -> -1381337787;
                case 86 -> 1236065812;
                case 87 -> -1809906697;
                case 88 -> 659830193;
                case 89 -> -311870281;
                case 90 -> -1430837789;
                case 91 -> 2008265224;
                case 92 -> 839642897;
                case 93 -> -74934367;
                case 94 -> 448637388;
                case 95 -> 976060195;
                case 96 -> 530330430;
                case 97 -> -1791498889;
                case 98 -> -547013724;
                case 99 -> 1396979736;
                case 100 -> 1008195595;
                case 101 -> 1305964816;
                case 102 -> 1683067837;
                case 103 -> 1309723603;
                case 104 -> 141650152;
                case 105 -> 1086930949;
                case 106 -> -2099570338;
                case 107 -> -917151933;
                case 108 -> 691695489;
                case 109 -> -985126672;
                case 110 -> -14188157;
                case 111 -> -1562887406;
                case 112 -> 1333737788;
                case 113 -> 1635835374;
                case 114 -> -1355825814;
                case 115 -> 1090321124;
                case 116 -> -787443114;
                case 117 -> -341765625;
                case 118 -> 1508962756;
                case 119 -> 1788449955;
                case 120 -> -1332586348;
                case 121 -> 810345618;
                case 122 -> 380459889;
                case 123 -> 1824208171;
                case 124 -> -2084636299;
                case 125 -> 1177227037;
                case 126 -> 1493001612;
                case 127 -> 988347878;
                case 128 -> -1799541592;
                case 129 -> 1648148681;
                case 130 -> -440376750;
                case 131 -> -290387210;
                case 132 -> -77168465;
                case 133 -> 12449895;
                case 134 -> 1509920179;
                case 135 -> 1630436427;
                case 136 -> 1110607686;
                case 137 -> 1184354182;
                case 138 -> 1590517004;
                case 139 -> 1123895917;
                case 140 -> -1855731814;
                case 141 -> -532801106;
                case 142 -> -145338745;
                case 143 -> -285536647;
                case 144 -> -1085232242;
                case 145 -> 1483090098;
                case 146 -> -671638953;
                case 147 -> 2021799981;
                case 148 -> 125051640;
                case 149 -> -207830811;
                case 150 -> 1770231294;
                case 151 -> 146750788;
                case 152 -> 1620485308;
                case 153 -> -643993744;
                case 154 -> -98393130;
                case 155 -> 1184214912;
                case 156 -> 1578751041;
                case 157 -> -1968317872;
                case 158 -> -793053289;
                case 159 -> 730160096;
                case 160 -> 1987963789;
                case 161 -> -496780338;
                case 162 -> -4682325;
                case 163 -> -1671569957;
                case 164 -> 1121559067;
                case 165 -> -765158606;
                case 166 -> 1135748288;
                case 167 -> 1351695157;
                case 168 -> 1970429283;
                case 169 -> 1796900383;
                case 170 -> 956239742;
                case 171 -> -589527427;
                case 172 -> -1708413494;
                case 173 -> 373899223;
                case 174 -> 1008545183;
                case 175 -> 268928357;
                case 176 -> 1063421097;
                case 177 -> 1008973921;
                case 178 -> 1258646835;
                case 179 -> -1729436087;
                case 180 -> -1975933894;
                case 181 -> 255448345;
                case 182 -> -595553839;
                case 183 -> 637441107;
                case 184 -> -341693536;
                case 185 -> 1519564841;
                case 186 -> 1970614957;
                case 187 -> -1096282506;
                case 188 -> 885276885;
                case 189 -> -674750999;
                case 190 -> -1773984780;
                case 191 -> 127593273;
                case 192 -> -2028386902;
                case 193 -> 2101055389;
                case 194 -> -1429225857;
                case 195 -> -467933089;
                case 196 -> -3533710;
                case 197 -> 382103645;
                case 198 -> -366363262;
                case 199 -> -2011615171;
                case 200 -> -872864470;
                case 201 -> 1372725136;
                case 202 -> 1843568062;
                case 203 -> -1995393605;
                case 204 -> -439768054;
                case 205 -> -1328168657;
                case 206 -> 1487322660;
                case 207 -> -404242004;
                case 208 -> -1116601567;
                case 209 -> -569677642;
                case 210 -> 914141625;
                case 211 -> -362467843;
                case 212 -> -944178710;
                case 213 -> -637097529;
                case 214 -> 447177817;
                case 215 -> 171037433;
                case 216 -> 1763889563;
                case 217 -> 351459895;
                case 218 -> -1766969597;
                case 219 -> 1197024623;
                case 220 -> 604770697;
                case 221 -> -1327529310;
                case 222 -> -423041356;
                case 223 -> -142729542;
                case 224 -> -851614001;
                case 225 -> -857359616;
                case 226 -> 2031970810;
                case 227 -> 1201063856;
                case 228 -> -412794680;
                case 229 -> -1537633653;
                case 230 -> -635474418;
                case 231 -> 1178806038;
                case 232 -> 127463679;
                case 233 -> -1629054042;
                case 234 -> -1741002713;
                case 235 -> -2030413102;
                case 236 -> 1153982776;
                case 237 -> -962114329;
                case 238 -> -1762077113;
                case 239 -> 2090010819;
                case 240 -> 2133638449;
                case 241 -> -600122897;
                case 242 -> -1118087915;
                case 243 -> 710581406;
                case 244 -> -1536454107;
                case 245 -> -690644289;
                case 246 -> -817545520;
                case 247 -> 4249154;
                case 248 -> -1364373170;
                case 249 -> -1283180346;
                case 250 -> 1846261401;
                case 251 -> -959206520;
                case 252 -> -1048629288;
                case 253 -> 999962594;
                case 254 -> -1148228371;
                case 255 -> -1256092761;
                default -> -1807365101;
            });
        } while (v2 != 72);
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
            OOOo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iio = new EnumType_oi0i_1("HOTBAR", 0);
        iiI = new EnumType_oi0i_1("INVENTORY", 1);
        iii = new EnumType_oi0i_1("OFFHAND", 2);
        Module = new EnumType_oi0i_1("NONE", 3);
        EnumType_OOO0 = EnumType_oi0i_1.DataRecord_0O0();
    }

    private static /* synthetic */ EnumType_oi0i_1[] DataRecord_0O0() {
        return new EnumType_oi0i_1[]{iio, iiI, iii, Module};
    }
}

