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
 * Renamed from psx.Hyk.oOO
 */
final class EnumType_ooo_3
extends Enum {
    public static final /* enum */ EnumType_ooo_3 OOi;
    public static final /* enum */ EnumType_ooo_3 EventBusApi;
    public static final /* enum */ EnumType_ooo_3 ConfigSupport_O0I;
    public static final /* enum */ EnumType_ooo_3 HudElement;
    public static final /* enum */ EnumType_ooo_3 O0o;
    public static final /* enum */ EnumType_ooo_3 GuiSupport_OOI;
    private static final /* synthetic */ EnumType_ooo_3[] O0i;
    static Object OoO;

    public static EnumType_ooo_3[] values() {
        return (EnumType_ooo_3[])O0i.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_ooo_3() {
        void param2;
        void param1;
    }

    public static EnumType_ooo_3 valueOf(String param0) {
        return Enum.valueOf(EnumType_ooo_3.class, param0);
    }

    static {
        byte[] v0 = "\u0004\u00df\u00d4\u00cd\u001aR;\u0093\u0004\t\u00869\u008bH5\u0006\u0019Y,\u00cc\u00b6<\u00e7\u0018\u00f7;\u00c7\u0090\u00d20\u0088\u009b\u00d9S.\u0002\ny]5h\u00ee\u0095\u00ef\u0014+$\u0084\u00d4\u0083h+\u00c2\u00d3\u00a7\u00ef1\u008d\u009cp^\u0003tpyM\u00ea\u000f\u00ff\u009d\u0003\u00e3\u00cc\u00ec\u00ad9k\u00a2\u0088[\u00d3\n\u00bd{\u00dd 5x".getBytes("ISO_8859_1");
        Object[] v1 = "K\u00e1\u0006\u008cg\u00ee%E".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -204704933;
                case 1 -> 1722699588;
                case 2 -> -649683048;
                case 3 -> 112289299;
                case 4 -> 966815872;
                case 5 -> 1431218476;
                case 6 -> 0x57855758;
                case 7 -> -1983311662;
                case 8 -> 1739535296;
                case 9 -> 1606262249;
                case 10 -> 1162848862;
                case 11 -> -1528682324;
                case 12 -> 2050406195;
                case 13 -> 1204264244;
                case 14 -> -1843462221;
                case 15 -> -2004884580;
                case 16 -> 344312396;
                case 17 -> 2028063370;
                case 18 -> -555296293;
                case 19 -> 1547207574;
                case 20 -> 106088616;
                case 21 -> 1202647184;
                case 22 -> 1371316273;
                case 23 -> 129675806;
                case 24 -> 886844780;
                case 25 -> 4110081;
                case 26 -> -1323339012;
                case 27 -> 605235365;
                case 28 -> 1562261629;
                case 29 -> -778974263;
                case 30 -> 1410169331;
                case 31 -> -138084973;
                case 32 -> -582335095;
                case 33 -> -1135218083;
                case 34 -> 351759655;
                case 35 -> 210325514;
                case 36 -> -1855868650;
                case 37 -> -394696840;
                case 38 -> 2038055477;
                case 39 -> -206495302;
                case 40 -> -895529804;
                case 41 -> -916131067;
                case 42 -> 1657942736;
                case 43 -> 1752075103;
                case 44 -> -797457718;
                case 45 -> -1482651614;
                case 46 -> 175739581;
                case 47 -> -872893596;
                case 48 -> 229277192;
                case 49 -> -392271699;
                case 50 -> -1365692588;
                case 51 -> 953164658;
                case 52 -> -1050547461;
                case 53 -> 1856312836;
                case 54 -> -99148256;
                case 55 -> 1184851290;
                case 56 -> -1929702513;
                case 57 -> -611281618;
                case 58 -> -278120154;
                case 59 -> 1502481176;
                case 60 -> -1611003559;
                case 61 -> 1437057395;
                case 62 -> 1798815431;
                case 63 -> -1399160139;
                case 64 -> 1177654541;
                case 65 -> -1639269135;
                case 66 -> 1728822703;
                case 67 -> -2131664945;
                case 68 -> -1116074124;
                case 69 -> 319534953;
                case 70 -> 627330929;
                case 71 -> 847181186;
                case 72 -> 297563809;
                case 73 -> 1393794159;
                case 74 -> -1201223601;
                case 75 -> -1100843891;
                case 76 -> 1020528485;
                case 77 -> 1086874572;
                case 78 -> -1255843598;
                case 79 -> 1220009852;
                case 80 -> 1830421987;
                case 81 -> 2059599387;
                case 82 -> -537472628;
                case 83 -> -962560257;
                case 84 -> 1989438097;
                case 85 -> -75544412;
                case 86 -> -1422293933;
                case 87 -> 1707590782;
                case 88 -> 2029627897;
                case 89 -> -1525657787;
                case 90 -> 735274228;
                case 91 -> 102544953;
                case 92 -> 1833486672;
                case 93 -> 700965799;
                case 94 -> -852430143;
                case 95 -> -346668291;
                case 96 -> -371822080;
                case 97 -> 476598126;
                case 98 -> 1688703094;
                case 99 -> 609953434;
                case 100 -> 547668241;
                case 101 -> 1449369299;
                case 102 -> 288835737;
                case 103 -> 1561089926;
                case 104 -> 585430108;
                case 105 -> 823905601;
                case 106 -> -1812781157;
                case 107 -> 1568338518;
                case 108 -> 1524581337;
                case 109 -> -330574494;
                case 110 -> -300505650;
                case 111 -> 1048657127;
                case 112 -> 342784301;
                case 113 -> -1342606889;
                case 114 -> 927062251;
                case 115 -> -649578052;
                case 116 -> -922605334;
                case 117 -> -808718376;
                case 118 -> -541239376;
                case 119 -> -1816539683;
                case 120 -> -1074561318;
                case 121 -> -1062953802;
                case 122 -> 994183952;
                case 123 -> -243693008;
                case 124 -> -869917282;
                case 125 -> -1004963130;
                case 126 -> -3120081;
                case 127 -> 771523343;
                case 128 -> 1974436584;
                case 129 -> -532982966;
                case 130 -> -857369081;
                case 131 -> 721084345;
                case 132 -> 1993659075;
                case 133 -> -920885045;
                case 134 -> 957671947;
                case 135 -> -1526990594;
                case 136 -> -128441979;
                case 137 -> -316851104;
                case 138 -> -369737657;
                case 139 -> -2140654552;
                case 140 -> -1760852351;
                case 141 -> -1587983062;
                case 142 -> -340113761;
                case 143 -> 446301410;
                case 144 -> -1255044542;
                case 145 -> 1088792978;
                case 146 -> -1647832796;
                case 147 -> 2115608363;
                case 148 -> -2103977207;
                case 149 -> -63981510;
                case 150 -> -808514290;
                case 151 -> -1379572718;
                case 152 -> 668088163;
                case 153 -> -1511344667;
                case 154 -> 32732953;
                case 155 -> -1704785891;
                case 156 -> -1731657514;
                case 157 -> 1423873623;
                case 158 -> -2106926422;
                case 159 -> -818679511;
                case 160 -> 1378876700;
                case 161 -> -1915522283;
                case 162 -> 1849768401;
                case 163 -> 652830421;
                case 164 -> 296690116;
                case 165 -> 1929422044;
                case 166 -> 1901520757;
                case 167 -> -2131005971;
                case 168 -> -355439474;
                case 169 -> 1326917243;
                case 170 -> -1104005626;
                case 171 -> 841977876;
                case 172 -> -1067240258;
                case 173 -> -1653409286;
                case 174 -> -935364803;
                case 175 -> -397749146;
                case 176 -> -2076804277;
                case 177 -> 1467454340;
                case 178 -> 902626307;
                case 179 -> -1296261791;
                case 180 -> -485421918;
                case 181 -> -52980303;
                case 182 -> -1715989845;
                case 183 -> 2126925187;
                case 184 -> 2045218037;
                case 185 -> 835213394;
                case 186 -> 1520117470;
                case 187 -> 1602082990;
                case 188 -> -121782042;
                case 189 -> 1596328042;
                case 190 -> -1113813877;
                case 191 -> -1622696713;
                case 192 -> -526274065;
                case 193 -> -174760791;
                case 194 -> 151032799;
                case 195 -> -1421461217;
                case 196 -> -637246520;
                case 197 -> -1979963646;
                case 198 -> -979835598;
                case 199 -> 537210453;
                case 200 -> 278746471;
                case 201 -> 930761270;
                case 202 -> 693527542;
                case 203 -> 1938652884;
                case 204 -> -12384264;
                case 205 -> -1918840910;
                case 206 -> -136188344;
                case 207 -> 711045047;
                case 208 -> -1577835571;
                case 209 -> -650305379;
                case 210 -> -1418473232;
                case 211 -> 349226560;
                case 212 -> -202237569;
                case 213 -> 384482196;
                case 214 -> 2003355148;
                case 215 -> -2031733423;
                case 216 -> -595114121;
                case 217 -> 687720009;
                case 218 -> -628175968;
                case 219 -> -1053375384;
                case 220 -> 1948254542;
                case 221 -> -1837275156;
                case 222 -> -1609357191;
                case 223 -> 573110254;
                case 224 -> -1375797397;
                case 225 -> -1760771507;
                case 226 -> -1365347561;
                case 227 -> 676953568;
                case 228 -> -1773461946;
                case 229 -> 269354559;
                case 230 -> 616725896;
                case 231 -> -1516070886;
                case 232 -> 834499479;
                case 233 -> -365236883;
                case 234 -> 2074694310;
                case 235 -> -1185440453;
                case 236 -> -1324086559;
                case 237 -> 950175170;
                case 238 -> -1405890881;
                case 239 -> -1649149509;
                case 240 -> -1210127132;
                case 241 -> 1119110549;
                case 242 -> 1118401914;
                case 243 -> 177164355;
                case 244 -> 1635922238;
                case 245 -> 1459397255;
                case 246 -> -2130543300;
                case 247 -> -866211400;
                case 248 -> 27347493;
                case 249 -> 1807206256;
                case 250 -> -219132895;
                case 251 -> 1017429445;
                case 252 -> 869578531;
                case 253 -> 1705184675;
                case 254 -> 1750584632;
                case 255 -> -160310729;
                default -> 449633004;
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
            Object[] objectArray = new Object[6];
            v1 = objectArray;
            OoO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        GuiSupport_OOI = new EnumType_ooo_3("BOOLEAN", 0);
        OOi = new EnumType_ooo_3("NUMBER", 1);
        HudElement = new EnumType_ooo_3("ENUM", 2);
        EventBusApi = new EnumType_ooo_3("ENUM_VALUE", 3);
        O0o = new EnumType_ooo_3("COLOR", 4);
        ConfigSupport_O0I = new EnumType_ooo_3("STRING", 5);
        O0i = EnumType_ooo_3.HelpCommand();
    }

    private static /* synthetic */ EnumType_ooo_3[] HelpCommand() {
        return new EnumType_ooo_3[]{GuiSupport_OOI, OOi, HudElement, EventBusApi, O0o, ConfigSupport_O0I};
    }
}

