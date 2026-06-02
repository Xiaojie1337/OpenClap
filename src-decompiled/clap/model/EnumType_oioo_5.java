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
 * Renamed from psx.Hyk.OioO
 */
public final class EnumType_oioo_5
extends Enum {
    public static final /* enum */ EnumType_oioo_5 PostProcessingModule;
    private static final /* synthetic */ EnumType_oioo_5[] DataRecord_OO0O;
    public static final /* enum */ EnumType_oioo_5 OOOo;
    public static final /* enum */ EnumType_oioo_5 OOOi;
    static Object NetworkSupport_OO00;

    public static EnumType_oioo_5[] values() {
        return (EnumType_oioo_5[])DataRecord_OO0O.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oioo_5() {
        void param2;
        void param1;
    }

    public static EnumType_oioo_5 valueOf(String param0) {
        return Enum.valueOf(EnumType_oioo_5.class, param0);
    }

    static {
        byte[] v0 = "|WFV\u00d8c\u0017\u00da\u0010\u00b8He\u009c}4\u00ec=\u0014r\u008c\u00ad\u000fh\u0091\u00e4\u0092\u00d2{\u00b3Wr\u00b8\u00eb\u008e\u000b$\u00fe\u0099\u00d6\u00f2;*\u0015\u0001\u009b\u00fa\u00bc\u0081@\u009c>\u00db\u0018w\u0002\u00f0\u00f3q\u00e0\u00f3\u0007\u0012\u008f\f".getBytes("ISO_8859_1");
        Object[] v1 = "\u00ec\u0002\u009d\u0095\u00c9\u0002yS".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 873080306;
                case 1 -> -1789100380;
                case 2 -> 107196818;
                case 3 -> 0x54442555;
                case 4 -> 1981684990;
                case 5 -> 854936953;
                case 6 -> -216318248;
                case 7 -> -785620282;
                case 8 -> -1564199956;
                case 9 -> -1513042551;
                case 10 -> 1683595243;
                case 11 -> -1912818605;
                case 12 -> 1582621766;
                case 13 -> -689850189;
                case 14 -> 1926386110;
                case 15 -> 243949494;
                case 16 -> -108207836;
                case 17 -> -1417377543;
                case 18 -> 900973938;
                case 19 -> 1516212695;
                case 20 -> 826179836;
                case 21 -> 1376030579;
                case 22 -> 206769525;
                case 23 -> 1741730350;
                case 24 -> 29706134;
                case 25 -> -1810971231;
                case 26 -> -818813214;
                case 27 -> 377902642;
                case 28 -> -561942639;
                case 29 -> 638789808;
                case 30 -> 278413715;
                case 31 -> -1849603657;
                case 32 -> -2020823126;
                case 33 -> -549463864;
                case 34 -> -1225288482;
                case 35 -> -218987577;
                case 36 -> -1925665270;
                case 37 -> 852448325;
                case 38 -> 2011139572;
                case 39 -> 1184432630;
                case 40 -> 351986207;
                case 41 -> -887786475;
                case 42 -> -1498348923;
                case 43 -> -1275867236;
                case 44 -> 1567667982;
                case 45 -> 1330449189;
                case 46 -> 263527808;
                case 47 -> 204914543;
                case 48 -> -1167961608;
                case 49 -> -790472609;
                case 50 -> 873214130;
                case 51 -> -1009479111;
                case 52 -> -1386658407;
                case 53 -> 705994758;
                case 54 -> -1102530801;
                case 55 -> -1470521477;
                case 56 -> 1858340150;
                case 57 -> 1888196477;
                case 58 -> -675258857;
                case 59 -> 595473272;
                case 60 -> -1242172017;
                case 61 -> 421760099;
                case 62 -> -1662640302;
                case 63 -> -1463275323;
                case 64 -> 249519863;
                case 65 -> 1090347356;
                case 66 -> 412996251;
                case 67 -> -360205336;
                case 68 -> 1113042116;
                case 69 -> -519189844;
                case 70 -> 1286258013;
                case 71 -> -1921859791;
                case 72 -> -1534612004;
                case 73 -> 1060727166;
                case 74 -> 358609706;
                case 75 -> 1944075238;
                case 76 -> -609692961;
                case 77 -> 1623308261;
                case 78 -> 1909629965;
                case 79 -> 316847466;
                case 80 -> 1797885452;
                case 81 -> 1604374562;
                case 82 -> -2059687648;
                case 83 -> 143116019;
                case 84 -> 60186817;
                case 85 -> 2108723889;
                case 86 -> -1288250386;
                case 87 -> -745995316;
                case 88 -> -106290377;
                case 89 -> 2002496315;
                case 90 -> -1939597149;
                case 91 -> -704130155;
                case 92 -> -35670696;
                case 93 -> -1570930072;
                case 94 -> -187237329;
                case 95 -> -155344971;
                case 96 -> 352980310;
                case 97 -> -1375726916;
                case 98 -> 1862248164;
                case 99 -> 1117661449;
                case 100 -> 957826761;
                case 101 -> -1617613118;
                case 102 -> -980933126;
                case 103 -> -327021008;
                case 104 -> -227128991;
                case 105 -> -908411646;
                case 106 -> 1111969809;
                case 107 -> 1028369435;
                case 108 -> -1646389963;
                case 109 -> -959453763;
                case 110 -> 555955373;
                case 111 -> 1163461723;
                case 112 -> 447793727;
                case 113 -> -746898986;
                case 114 -> 952783621;
                case 115 -> -63355861;
                case 116 -> -349963177;
                case 117 -> -1568646882;
                case 118 -> -1177790039;
                case 119 -> -1916464774;
                case 120 -> -1275400157;
                case 121 -> -1083857331;
                case 122 -> 202382657;
                case 123 -> -1205547673;
                case 124 -> -852047834;
                case 125 -> -950999767;
                case 126 -> -198316181;
                case 127 -> -1254074228;
                case 128 -> -1293170813;
                case 129 -> 118229233;
                case 130 -> 1393728331;
                case 131 -> 1472732619;
                case 132 -> -1935006581;
                case 133 -> -678336813;
                case 134 -> -1547653139;
                case 135 -> -255892993;
                case 136 -> 1440489596;
                case 137 -> 1550919576;
                case 138 -> 1246416002;
                case 139 -> -1435755097;
                case 140 -> 157439147;
                case 141 -> -128473635;
                case 142 -> 1568353617;
                case 143 -> 957411904;
                case 144 -> 1506962260;
                case 145 -> -300481683;
                case 146 -> -1354128362;
                case 147 -> -988158392;
                case 148 -> 894155737;
                case 149 -> -1508618801;
                case 150 -> -394090499;
                case 151 -> 2108489855;
                case 152 -> -1961332931;
                case 153 -> 52088439;
                case 154 -> -686339883;
                case 155 -> 1377565484;
                case 156 -> 1770601551;
                case 157 -> 211711950;
                case 158 -> -306765210;
                case 159 -> 1690608832;
                case 160 -> -1360736924;
                case 161 -> 295732207;
                case 162 -> 332567470;
                case 163 -> 650218541;
                case 164 -> -1071423174;
                case 165 -> -990396951;
                case 166 -> -2009802174;
                case 167 -> -106614517;
                case 168 -> 1187139139;
                case 169 -> -739245692;
                case 170 -> -750065044;
                case 171 -> 1066781435;
                case 172 -> 327308728;
                case 173 -> 558557480;
                case 174 -> -1037762139;
                case 175 -> -88061712;
                case 176 -> 1503595027;
                case 177 -> 1256571271;
                case 178 -> -1651612136;
                case 179 -> 1467829172;
                case 180 -> 1681699184;
                case 181 -> -35181964;
                case 182 -> 1517800448;
                case 183 -> -1863644910;
                case 184 -> 1101879297;
                case 185 -> 244912460;
                case 186 -> 1067862076;
                case 187 -> -1435795705;
                case 188 -> 755307418;
                case 189 -> 1681513312;
                case 190 -> 1768018505;
                case 191 -> 430329760;
                case 192 -> 2038469262;
                case 193 -> -933631585;
                case 194 -> -67387167;
                case 195 -> 413284190;
                case 196 -> -1681880169;
                case 197 -> 722001826;
                case 198 -> -1699300630;
                case 199 -> 1451359370;
                case 200 -> -2045794881;
                case 201 -> 862472481;
                case 202 -> -1893792326;
                case 203 -> -877840925;
                case 204 -> -1106258230;
                case 205 -> 628066470;
                case 206 -> -1099220451;
                case 207 -> -1007856435;
                case 208 -> 1720153748;
                case 209 -> -1945687357;
                case 210 -> 887797849;
                case 211 -> -1299459118;
                case 212 -> 1859479406;
                case 213 -> 0x60600EE0;
                case 214 -> 1632135070;
                case 215 -> 302411183;
                case 216 -> 1712789160;
                case 217 -> -422773150;
                case 218 -> -1623350906;
                case 219 -> -1497712057;
                case 220 -> 964837956;
                case 221 -> 1688968144;
                case 222 -> -145075467;
                case 223 -> -1170560583;
                case 224 -> -954220912;
                case 225 -> -2074885247;
                case 226 -> -54219748;
                case 227 -> -804282149;
                case 228 -> 1999873492;
                case 229 -> 1909644918;
                case 230 -> -429657062;
                case 231 -> 1959412227;
                case 232 -> -2106414796;
                case 233 -> -676683671;
                case 234 -> -1014019820;
                case 235 -> -375840069;
                case 236 -> -1595177447;
                case 237 -> 740375770;
                case 238 -> 1669493640;
                case 239 -> -511645487;
                case 240 -> 1082569306;
                case 241 -> -1607788226;
                case 242 -> -261616153;
                case 243 -> 1576314640;
                case 244 -> 829282824;
                case 245 -> 1188331088;
                case 246 -> -1410750130;
                case 247 -> 255159949;
                case 248 -> -976238792;
                case 249 -> 697551411;
                case 250 -> -785667471;
                case 251 -> -842247164;
                case 252 -> 2022486567;
                case 253 -> 1230185117;
                case 254 -> -1742469275;
                case 255 -> -1377663670;
                default -> 1185033942;
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
            NetworkSupport_OO00 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OOOo = new EnumType_oioo_5("Vanilla", 0);
        PostProcessingModule = new EnumType_oioo_5("Modded", 1);
        OOOi = new EnumType_oioo_5("Custom", 2);
        DataRecord_OO0O = EnumType_oioo_5.0Oo();
    }

    private static /* synthetic */ EnumType_oioo_5[] 0Oo() {
        return new EnumType_oioo_5[]{OOOo, PostProcessingModule, OOOi};
    }
}

