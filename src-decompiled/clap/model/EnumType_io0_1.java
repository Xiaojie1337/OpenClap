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
 * Renamed from clap.render.RenderSupport_io0_2
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class EnumType_io0_1
extends Enum {
    public static final /* enum */ EnumType_io0_1 DataRecord_0O0;
    public static final /* enum */ EnumType_io0_1 0Oo;
    public static final /* enum */ EnumType_io0_1 Oii;
    public static final /* enum */ EnumType_io0_1 OiI;
    private static final /* synthetic */ EnumType_io0_1[] EnumType_0OI;
    public static final /* enum */ EnumType_io0_1 ConfigSupport_0OO;
    static Object 0Oi;

    public static EnumType_io0_1[] values() {
        return (EnumType_io0_1[])EnumType_0OI.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_io0_1() {
        void param2;
        void param1;
    }

    public static EnumType_io0_1 valueOf(String param0) {
        return Enum.valueOf(EnumType_io0_1.class, param0);
    }

    static {
        byte[] v0 = "\u00ec*4$\u00e2\u00a9\u0001\u00e8\u0088|\u0095\u009c\u00ea\u000f\u00a6w\u0005\u00f9\u00ea<\u009c\t\u00ff(\t\u00fe\u00c3\u0016\u001d\u00db\u0007\u00f1\u0089\u00ee\u009d\u00c6\u00a5}\u00985|\u0004\u00fa\u00ea\u007f\u00c2\u00b6\u001e\u000e\u00fe\u00cbnR=\r\u00d6\u00c0+\u0014zr\u00ce\u00dc\u00b5\u00e7\u000e\u00fc2{F\u00beV\u009a\u0011\u0004\u00e5Y`){".getBytes("ISO_8859_1");
        Object[] v1 = "\u00ee\u00ees\u0001\u00feB\u0090\u00ce".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 517471355;
                case 1 -> 350554170;
                case 2 -> -785371720;
                case 3 -> -1396381611;
                case 4 -> 1537851245;
                case 5 -> 1178098159;
                case 6 -> -1901612026;
                case 7 -> 996112371;
                case 8 -> -1423065762;
                case 9 -> 1627071578;
                case 10 -> -2004621011;
                case 11 -> 1850905348;
                case 12 -> 312746468;
                case 13 -> 625369247;
                case 14 -> 150629284;
                case 15 -> -1097662995;
                case 16 -> -1204142243;
                case 17 -> 1591715782;
                case 18 -> -1012016649;
                case 19 -> 72644532;
                case 20 -> 1730983657;
                case 21 -> -1990851258;
                case 22 -> 744880230;
                case 23 -> 1080966281;
                case 24 -> 1847308815;
                case 25 -> 206990810;
                case 26 -> 967047242;
                case 27 -> 421919058;
                case 28 -> -1945493918;
                case 29 -> -433971312;
                case 30 -> -789983815;
                case 31 -> 1847536635;
                case 32 -> 783934359;
                case 33 -> -1745782692;
                case 34 -> -1400449160;
                case 35 -> 1252461263;
                case 36 -> -173765840;
                case 37 -> 1001520693;
                case 38 -> 2032880171;
                case 39 -> -160212124;
                case 40 -> -1863268992;
                case 41 -> -331965231;
                case 42 -> 128386715;
                case 43 -> 1701635178;
                case 44 -> -793067753;
                case 45 -> 1960665366;
                case 46 -> -2075141226;
                case 47 -> 629423910;
                case 48 -> 1208897662;
                case 49 -> 1948138266;
                case 50 -> -1395237118;
                case 51 -> -1608884173;
                case 52 -> -716222523;
                case 53 -> 1638561800;
                case 54 -> 1712317103;
                case 55 -> -244054879;
                case 56 -> -792874251;
                case 57 -> -453176863;
                case 58 -> 11473667;
                case 59 -> 1044501071;
                case 60 -> -2037892382;
                case 61 -> -2001207893;
                case 62 -> 88895629;
                case 63 -> -1279460618;
                case 64 -> 96062949;
                case 65 -> -1976887869;
                case 66 -> -793080104;
                case 67 -> -864911925;
                case 68 -> -1921331756;
                case 69 -> 2133152513;
                case 70 -> 1622266169;
                case 71 -> -120222608;
                case 72 -> -270466648;
                case 73 -> 117006321;
                case 74 -> -509466031;
                case 75 -> -111964354;
                case 76 -> -501358819;
                case 77 -> 850051068;
                case 78 -> 1076946512;
                case 79 -> -2044015942;
                case 80 -> 1048859157;
                case 81 -> -1010227236;
                case 82 -> -824986900;
                case 83 -> -370231331;
                case 84 -> -488877436;
                case 85 -> -1781290389;
                case 86 -> 156848216;
                case 87 -> -189562820;
                case 88 -> -703868661;
                case 89 -> 1129698713;
                case 90 -> 1749267171;
                case 91 -> -913555436;
                case 92 -> 1350692145;
                case 93 -> 1787623292;
                case 94 -> -1008834457;
                case 95 -> 77455113;
                case 96 -> -867542230;
                case 97 -> 1837373619;
                case 98 -> -432563183;
                case 99 -> 1069729068;
                case 100 -> 1635549358;
                case 101 -> 2071553705;
                case 102 -> -86962604;
                case 103 -> 484029464;
                case 104 -> -82138196;
                case 105 -> 1967658573;
                case 106 -> -1639859132;
                case 107 -> 1771860711;
                case 108 -> -995401974;
                case 109 -> 1891502370;
                case 110 -> 1851276943;
                case 111 -> 1065431985;
                case 112 -> 186627186;
                case 113 -> 1601480793;
                case 114 -> 1608053790;
                case 115 -> -319565239;
                case 116 -> 2033656392;
                case 117 -> -1858548825;
                case 118 -> 2029158886;
                case 119 -> 442650587;
                case 120 -> 2042778019;
                case 121 -> 1485153789;
                case 122 -> 1110857122;
                case 123 -> -1083559875;
                case 124 -> -701775962;
                case 125 -> 760413748;
                case 126 -> -1568005597;
                case 127 -> -1054170765;
                case 128 -> -1496954769;
                case 129 -> -138985672;
                case 130 -> 2019721364;
                case 131 -> 1150912973;
                case 132 -> -103877769;
                case 133 -> 618793386;
                case 134 -> 451295635;
                case 135 -> 217571994;
                case 136 -> 1729138460;
                case 137 -> 1174172302;
                case 138 -> -1281566905;
                case 139 -> 2036600000;
                case 140 -> 502068034;
                case 141 -> -171437098;
                case 142 -> -1136490228;
                case 143 -> -1823542529;
                case 144 -> -210176449;
                case 145 -> -542737016;
                case 146 -> -1215922675;
                case 147 -> -58512751;
                case 148 -> -74090529;
                case 149 -> 88526440;
                case 150 -> -971495011;
                case 151 -> -1531219265;
                case 152 -> 1270942224;
                case 153 -> -808488663;
                case 154 -> 112931671;
                case 155 -> -424135202;
                case 156 -> 2114129898;
                case 157 -> 1647724846;
                case 158 -> -1218380773;
                case 159 -> -912659359;
                case 160 -> 1326079438;
                case 161 -> -723923803;
                case 162 -> -104731518;
                case 163 -> -1891593087;
                case 164 -> -2119776363;
                case 165 -> 311546655;
                case 166 -> -1897922677;
                case 167 -> -1043428601;
                case 168 -> -597291130;
                case 169 -> -1785256462;
                case 170 -> 629099008;
                case 171 -> -1955626644;
                case 172 -> 1100096480;
                case 173 -> 453833916;
                case 174 -> 1060659219;
                case 175 -> 577398009;
                case 176 -> 1196928822;
                case 177 -> -286790725;
                case 178 -> -1315709741;
                case 179 -> 1921997803;
                case 180 -> 1656315951;
                case 181 -> -744329866;
                case 182 -> 1407020675;
                case 183 -> 1249988298;
                case 184 -> 1298491070;
                case 185 -> -370790254;
                case 186 -> 575681663;
                case 187 -> 829195289;
                case 188 -> 1103629689;
                case 189 -> -934326406;
                case 190 -> -1692054611;
                case 191 -> -1900917426;
                case 192 -> -2096137179;
                case 193 -> 451773480;
                case 194 -> 623429040;
                case 195 -> 53204423;
                case 196 -> 1166144579;
                case 197 -> 1500258112;
                case 198 -> 688423346;
                case 199 -> 690259325;
                case 200 -> -540466960;
                case 201 -> 571598215;
                case 202 -> 567515269;
                case 203 -> 2001640117;
                case 204 -> 2095729265;
                case 205 -> -1957295874;
                case 206 -> 760762930;
                case 207 -> -1308964470;
                case 208 -> -1446213556;
                case 209 -> -975718368;
                case 210 -> -1384526025;
                case 211 -> 1191585893;
                case 212 -> -1112851572;
                case 213 -> -111532991;
                case 214 -> -411702580;
                case 215 -> -1568690495;
                case 216 -> -2082183688;
                case 217 -> -1455499205;
                case 218 -> -2136541483;
                case 219 -> 507050335;
                case 220 -> -864567197;
                case 221 -> -1407922363;
                case 222 -> 2027181860;
                case 223 -> -1416874057;
                case 224 -> -930834231;
                case 225 -> -294473433;
                case 226 -> 1004545541;
                case 227 -> -421831058;
                case 228 -> -698235928;
                case 229 -> -1481176624;
                case 230 -> 1993298884;
                case 231 -> 1978338777;
                case 232 -> -1362343666;
                case 233 -> 800157373;
                case 234 -> 437057986;
                case 235 -> -1753365900;
                case 236 -> -1486973032;
                case 237 -> 1659104274;
                case 238 -> -475996428;
                case 239 -> -1178974687;
                case 240 -> -280280582;
                case 241 -> 406598098;
                case 242 -> -1424209248;
                case 243 -> 3306734;
                case 244 -> -1754022244;
                case 245 -> -82299978;
                case 246 -> -1518359469;
                case 247 -> 2014166633;
                case 248 -> -1079731810;
                case 249 -> -1889376056;
                case 250 -> -728839850;
                case 251 -> -1825763113;
                case 252 -> 491126875;
                case 253 -> -405943691;
                case 254 -> -1439671712;
                case 255 -> -2007760565;
                default -> 90749375;
            });
        } while (v2 != 80);
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
            Object[] objectArray = new Object[5];
            v1 = objectArray;
            0Oi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OiI = new EnumType_io0_1("STATIC", 0);
        Oii = new EnumType_io0_1("GLOBAL", 1);
        ConfigSupport_0OO = new EnumType_io0_1("RAINBOW", 2);
        DataRecord_0O0 = new EnumType_io0_1("GRADIENT", 3);
        0Oo = new EnumType_io0_1("CATEGORY", 4);
        EnumType_0OI = EnumType_io0_1.HudElement();
    }

    private static /* synthetic */ EnumType_io0_1[] HudElement() {
        return new EnumType_io0_1[]{OiI, Oii, ConfigSupport_0OO, DataRecord_0O0, 0Oo};
    }
}

