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
 * Renamed from psx.Hyk.iii
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class EnumType_iii_6
extends Enum {
    public static final /* enum */ EnumType_iii_6 0o0;
    public static final /* enum */ EnumType_iii_6 0oI;
    public static final /* enum */ EnumType_iii_6 SpawnerFinderModule;
    private static final /* synthetic */ EnumType_iii_6[] AutoMlgModule;
    public static final /* enum */ EnumType_iii_6 0oi;
    static Object RenderSupport_0I0;

    public static EnumType_iii_6[] values() {
        return (EnumType_iii_6[])AutoMlgModule.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_iii_6() {
        void param2;
        void param1;
    }

    public static EnumType_iii_6 valueOf(String param0) {
        return Enum.valueOf(EnumType_iii_6.class, param0);
    }

    static {
        byte[] v0 = "\u00af\u009a!Q\u00c2pD$N\u001f\u00e3\u0017\u00f5\u00fa\u00aa3\u0092\u00f8\u0015\u00d4 \b\u0089/K\u00c7k\u00c2\b\u0000\u00ae\u00da\u00ae%\u00bfI\u00d1\u00ee*o\u00dfN\u00f9\u0090\u00c5<\u00ec\u008c\u00c8\u00eb\u00ff*\u00c8\f}\u00e5k\u0019_\u00d6\u0018\u00c0\u00da\u00e3\u00e4\u0015\u008a\u00bdZ\u00f3\u00ae\u00da\u00b4\u00aa\u00e67\u001f<\u0011 \u0084.T\u00e1\u009c\u00d7\u00b14\u00c0\u00f1\u0000\u0001\u00f0\u00af9]".getBytes("ISO_8859_1");
        Object[] v1 = "\r\u00bb\u008b\u0003\u0019\u0004b\u0003".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -228719355;
                case 1 -> -836035106;
                case 2 -> -750832743;
                case 3 -> -497224437;
                case 4 -> 1114712546;
                case 5 -> -392780953;
                case 6 -> -117406521;
                case 7 -> -33395197;
                case 8 -> 1681489194;
                case 9 -> -1833957256;
                case 10 -> 1200812172;
                case 11 -> 368526548;
                case 12 -> -1758578389;
                case 13 -> -1512216118;
                case 14 -> 425870524;
                case 15 -> -1438579467;
                case 16 -> 734404654;
                case 17 -> 512361645;
                case 18 -> -1973815590;
                case 19 -> -1370224199;
                case 20 -> -615739158;
                case 21 -> 126129844;
                case 22 -> -1978467068;
                case 23 -> -1102313599;
                case 24 -> 479771294;
                case 25 -> -1422312587;
                case 26 -> -1795343761;
                case 27 -> -978886972;
                case 28 -> -1582668750;
                case 29 -> 1732422994;
                case 30 -> -1031579209;
                case 31 -> 1575241912;
                case 32 -> -794843970;
                case 33 -> 907681607;
                case 34 -> 2092059869;
                case 35 -> 1237069991;
                case 36 -> -1079288013;
                case 37 -> 460073546;
                case 38 -> -1831092376;
                case 39 -> 279629083;
                case 40 -> -1477668075;
                case 41 -> 1024227735;
                case 42 -> -297977984;
                case 43 -> -751577963;
                case 44 -> -763187164;
                case 45 -> -1410780014;
                case 46 -> 1680585794;
                case 47 -> 70471472;
                case 48 -> 641431126;
                case 49 -> 16403686;
                case 50 -> 2128475991;
                case 51 -> 598864697;
                case 52 -> -419744314;
                case 53 -> -1187499899;
                case 54 -> -1964122155;
                case 55 -> -713553812;
                case 56 -> 583556344;
                case 57 -> 476613729;
                case 58 -> 1447785024;
                case 59 -> 2116991016;
                case 60 -> 795847088;
                case 61 -> -599320621;
                case 62 -> 1273136402;
                case 63 -> -829894114;
                case 64 -> 2135324667;
                case 65 -> 393976071;
                case 66 -> -1881272514;
                case 67 -> 2045337381;
                case 68 -> -1209733254;
                case 69 -> 355312118;
                case 70 -> 1904388858;
                case 71 -> -2037410032;
                case 72 -> 587867529;
                case 73 -> -1508271533;
                case 74 -> -1823748042;
                case 75 -> -977991842;
                case 76 -> 1417175092;
                case 77 -> 1444036847;
                case 78 -> 378386510;
                case 79 -> -1148973849;
                case 80 -> -944238860;
                case 81 -> 1746180108;
                case 82 -> -1885861487;
                case 83 -> -1902519925;
                case 84 -> -1701563325;
                case 85 -> 1455680694;
                case 86 -> -1737247719;
                case 87 -> 237552390;
                case 88 -> -1123331855;
                case 89 -> 1451652681;
                case 90 -> 890805961;
                case 91 -> -503021982;
                case 92 -> -1852049583;
                case 93 -> 617789822;
                case 94 -> 2057177635;
                case 95 -> 36407265;
                case 96 -> 696564610;
                case 97 -> -2067222755;
                case 98 -> -978136661;
                case 99 -> 1895688233;
                case 100 -> -335345092;
                case 101 -> -751744969;
                case 102 -> 1641604244;
                case 103 -> 1166216800;
                case 104 -> 1981095807;
                case 105 -> 2125589518;
                case 106 -> -1800296469;
                case 107 -> -1893374286;
                case 108 -> 100612601;
                case 109 -> 1135147762;
                case 110 -> 895423909;
                case 111 -> -882642223;
                case 112 -> -2095798641;
                case 113 -> 1493395197;
                case 114 -> 433574792;
                case 115 -> 627510213;
                case 116 -> -1689690043;
                case 117 -> 1135280703;
                case 118 -> -515208234;
                case 119 -> -1201208319;
                case 120 -> -48675597;
                case 121 -> 2083526035;
                case 122 -> -846250528;
                case 123 -> -1784126056;
                case 124 -> 564011500;
                case 125 -> 491272732;
                case 126 -> 745234860;
                case 127 -> 1991960995;
                case 128 -> -1468125327;
                case 129 -> 1290254637;
                case 130 -> 509087142;
                case 131 -> 971342871;
                case 132 -> -101669798;
                case 133 -> 1280954689;
                case 134 -> -1849200897;
                case 135 -> -1971648125;
                case 136 -> -1028755039;
                case 137 -> 420455772;
                case 138 -> -237416842;
                case 139 -> 1048071890;
                case 140 -> 914452749;
                case 141 -> 1059373344;
                case 142 -> 340030811;
                case 143 -> -410661417;
                case 144 -> -1467711314;
                case 145 -> 454256479;
                case 146 -> 1312104348;
                case 147 -> 344206152;
                case 148 -> -2008330387;
                case 149 -> -385736941;
                case 150 -> -1858152159;
                case 151 -> -1687409374;
                case 152 -> -917443995;
                case 153 -> -122209825;
                case 154 -> -92114077;
                case 155 -> -1631587416;
                case 156 -> 41434456;
                case 157 -> 1960195130;
                case 158 -> 755951386;
                case 159 -> -1756066273;
                case 160 -> -1906698008;
                case 161 -> -573160496;
                case 162 -> 529424004;
                case 163 -> -2011677372;
                case 164 -> -959416707;
                case 165 -> -1805622609;
                case 166 -> 314486333;
                case 167 -> 1189803101;
                case 168 -> 1189548623;
                case 169 -> 917941390;
                case 170 -> 877067323;
                case 171 -> -387714589;
                case 172 -> 1515553041;
                case 173 -> -1062344648;
                case 174 -> -428709585;
                case 175 -> 1790475968;
                case 176 -> 1495752982;
                case 177 -> 417169940;
                case 178 -> -881729842;
                case 179 -> 2091200266;
                case 180 -> 1434147381;
                case 181 -> 1060725874;
                case 182 -> -129665633;
                case 183 -> 1568420555;
                case 184 -> -259392845;
                case 185 -> -1668520883;
                case 186 -> 714082445;
                case 187 -> 798000251;
                case 188 -> 1605478594;
                case 189 -> -427740281;
                case 190 -> 2073943197;
                case 191 -> -2057363269;
                case 192 -> 576011376;
                case 193 -> -1001189963;
                case 194 -> -334395819;
                case 195 -> -1202424113;
                case 196 -> -366019696;
                case 197 -> 1813944079;
                case 198 -> -986157910;
                case 199 -> 857591345;
                case 200 -> 160561241;
                case 201 -> 324968828;
                case 202 -> 1362791408;
                case 203 -> 1205556324;
                case 204 -> -365943103;
                case 205 -> 2108143660;
                case 206 -> -663789093;
                case 207 -> -1702823817;
                case 208 -> -1415867564;
                case 209 -> -1636773693;
                case 210 -> 1381769709;
                case 211 -> 369189374;
                case 212 -> -417488420;
                case 213 -> 82208233;
                case 214 -> 1518181018;
                case 215 -> -524313524;
                case 216 -> -1897451585;
                case 217 -> 917032676;
                case 218 -> -297637719;
                case 219 -> -1216788536;
                case 220 -> 222888122;
                case 221 -> -1087522199;
                case 222 -> 1489003815;
                case 223 -> 1990483148;
                case 224 -> -841750323;
                case 225 -> 1216875595;
                case 226 -> -1275434334;
                case 227 -> -1235688805;
                case 228 -> -1707838248;
                case 229 -> -1093107808;
                case 230 -> 758765592;
                case 231 -> 361769098;
                case 232 -> 395715222;
                case 233 -> 752669401;
                case 234 -> 72448371;
                case 235 -> -603434636;
                case 236 -> -476683774;
                case 237 -> -2059768859;
                case 238 -> 852866312;
                case 239 -> -1078705219;
                case 240 -> -2121276160;
                case 241 -> -193158791;
                case 242 -> 313532454;
                case 243 -> -124952399;
                case 244 -> 1854604964;
                case 245 -> 579742854;
                case 246 -> -382539930;
                case 247 -> 354257222;
                case 248 -> 1135101934;
                case 249 -> 720920841;
                case 250 -> 1060283639;
                case 251 -> -1200799634;
                case 252 -> 145107452;
                case 253 -> 816463440;
                case 254 -> -1644983702;
                case 255 -> 678106219;
                default -> 2054417469;
            });
        } while (v2 != 96);
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
            RenderSupport_0I0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0o0 = new EnumType_iii_6("IDLE", 0);
        SpawnerFinderModule = new EnumType_iii_6("PREPARE_BUCKET", 1);
        0oI = new EnumType_iii_6("WAITING_FOR_LAND", 2);
        0oi = new EnumType_iii_6("WAITING_FOR_RECYCLE", 3);
        AutoMlgModule = EnumType_iii_6.ConfigSupport_O0I();
    }

    private static /* synthetic */ EnumType_iii_6[] ConfigSupport_O0I() {
        return new EnumType_iii_6[]{0o0, SpawnerFinderModule, 0oI, 0oi};
    }
}

