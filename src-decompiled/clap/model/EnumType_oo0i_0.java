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
 * Renamed from clap.command.impl.HelpCommandi
 * Illegal identifiers - consider using --renameillegalidents true
 */
final class EnumType_oo0i_0
extends Enum {
    public static final /* enum */ EnumType_oo0i_0 0Io;
    public static final /* enum */ EnumType_oo0i_0 ChestStealerModule;
    public static final /* enum */ EnumType_oo0i_0 KeepSprintModule;
    public static final /* enum */ EnumType_oo0i_0 ConfigSupport_0II;
    public static final /* enum */ EnumType_oo0i_0 DataRecord_0io_2;
    public static final /* enum */ EnumType_oo0i_0 RenderSupport_0I0;
    private static final /* synthetic */ EnumType_oo0i_0[] 0io;
    static Object 0iI;

    public static EnumType_oo0i_0[] values() {
        return (EnumType_oo0i_0[])0io.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oo0i_0() {
        void param2;
        void param1;
    }

    public static EnumType_oo0i_0 valueOf(String param0) {
        return Enum.valueOf(EnumType_oo0i_0.class, param0);
    }

    static {
        byte[] v0 = "\"\u00f6L\u00e9\u001fQ\u00847\u00c8^\u008b\u0005\u00bc\u0081\u009a\u00e5P\u00fe\u00f2Kg\u00cb\rD\u00da\u009f\u0016\\\u00bb\u00a9\u0012\u00177\u00e5n\u00bb-\u008e\u00b9\u00f1\u00a8\u00df:\u00c1\u00c6\u00f3\u0080\u0092bgK\u009fV=a\u0016WND-I\u00b9\u00c7\u00c15F\u00a0\u0080G8v\u00cf\u00e2\u00c0L\u00a4\u00ed\u00f6\u00d4\u0012\u00c6_\u009cH\u00fcgX\u0089F\u0081\u00f1?!\u00ed45\u0093\u0086U:[4\u00aa\u00de{\u0018\u00a0\u00c6r(+\u000b\u008a\u00c4\n\u00c8k\u00ba\u00a3Y\u00dc\u00ac\u00d0\u00b3xj>\u00d4".getBytes("ISO_8859_1");
        Object[] v1 = "NA\"V\u00c2$9}".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1436325954;
                case 1 -> 203847880;
                case 2 -> -97984965;
                case 3 -> 1552443130;
                case 4 -> -848594253;
                case 5 -> -755697569;
                case 6 -> 455919317;
                case 7 -> -721914692;
                case 8 -> 27185826;
                case 9 -> 2091314052;
                case 10 -> -740581158;
                case 11 -> -1035946271;
                case 12 -> -1629321192;
                case 13 -> -867800457;
                case 14 -> -263282722;
                case 15 -> 1490516935;
                case 16 -> -582102627;
                case 17 -> 395478939;
                case 18 -> -878026305;
                case 19 -> -2118756488;
                case 20 -> 1405212600;
                case 21 -> 639649149;
                case 22 -> 676171425;
                case 23 -> -1747659837;
                case 24 -> 1862623234;
                case 25 -> -286796404;
                case 26 -> 1948097426;
                case 27 -> 322759547;
                case 28 -> -2044010725;
                case 29 -> 69862157;
                case 30 -> 1355997313;
                case 31 -> 532370517;
                case 32 -> 1682828343;
                case 33 -> 1879234592;
                case 34 -> -25848742;
                case 35 -> -1495744239;
                case 36 -> -1726013111;
                case 37 -> -340015359;
                case 38 -> 961637985;
                case 39 -> 99127888;
                case 40 -> 1602481150;
                case 41 -> 977338449;
                case 42 -> -994186723;
                case 43 -> 80521397;
                case 44 -> -838743580;
                case 45 -> 1480766291;
                case 46 -> 91585550;
                case 47 -> 534074853;
                case 48 -> -1778187741;
                case 49 -> -1815845851;
                case 50 -> 152449775;
                case 51 -> -2111861208;
                case 52 -> 1065147633;
                case 53 -> 778670562;
                case 54 -> 956994089;
                case 55 -> 1162012564;
                case 56 -> 1549648190;
                case 57 -> 1123046839;
                case 58 -> -708730262;
                case 59 -> -2109475146;
                case 60 -> 346815832;
                case 61 -> 1681901103;
                case 62 -> -1878427097;
                case 63 -> 1037511713;
                case 64 -> -6034900;
                case 65 -> 209270610;
                case 66 -> 164613741;
                case 67 -> 978008604;
                case 68 -> -105988904;
                case 69 -> 30972688;
                case 70 -> 1505771655;
                case 71 -> -1422815202;
                case 72 -> 1761167558;
                case 73 -> 1998697639;
                case 74 -> -2039449625;
                case 75 -> -850486588;
                case 76 -> -1392217411;
                case 77 -> -753085572;
                case 78 -> 977684036;
                case 79 -> -1748846073;
                case 80 -> -1359013417;
                case 81 -> -1082180750;
                case 82 -> 558129973;
                case 83 -> 1693984026;
                case 84 -> 995342489;
                case 85 -> -1060597361;
                case 86 -> -1448186849;
                case 87 -> 1374757480;
                case 88 -> -422442772;
                case 89 -> 392153744;
                case 90 -> 2017283735;
                case 91 -> -1672125660;
                case 92 -> 1434412150;
                case 93 -> -875589883;
                case 94 -> 1151943167;
                case 95 -> -497787371;
                case 96 -> 1017033559;
                case 97 -> 1705709408;
                case 98 -> 64939424;
                case 99 -> 1851646231;
                case 100 -> 120265420;
                case 101 -> 329360624;
                case 102 -> 109660081;
                case 103 -> -1156490962;
                case 104 -> -1710308475;
                case 105 -> -1126639560;
                case 106 -> -856502718;
                case 107 -> -589857805;
                case 108 -> -166630388;
                case 109 -> 621386855;
                case 110 -> -790934098;
                case 111 -> 899761390;
                case 112 -> -418342894;
                case 113 -> -1487482650;
                case 114 -> -83767566;
                case 115 -> -1350400757;
                case 116 -> 1020103951;
                case 117 -> 211836164;
                case 118 -> 956615985;
                case 119 -> 328034476;
                case 120 -> 1069252404;
                case 121 -> 980913652;
                case 122 -> 153349165;
                case 123 -> -21514230;
                case 124 -> -436564413;
                case 125 -> 1292786894;
                case 126 -> 1889166181;
                case 127 -> 2112469766;
                case 128 -> 1347582600;
                case 129 -> -1715147030;
                case 130 -> -822496451;
                case 131 -> -1209927040;
                case 132 -> 113914112;
                case 133 -> -426416167;
                case 134 -> 1096832364;
                case 135 -> -292009132;
                case 136 -> 1722260105;
                case 137 -> 902810995;
                case 138 -> -1277133393;
                case 139 -> -310514822;
                case 140 -> 2054506489;
                case 141 -> 312261313;
                case 142 -> -2111365078;
                case 143 -> 94338747;
                case 144 -> -1369315698;
                case 145 -> -1697187228;
                case 146 -> 1387515894;
                case 147 -> -1886827317;
                case 148 -> 1244111930;
                case 149 -> 859399576;
                case 150 -> 502670425;
                case 151 -> -1944251344;
                case 152 -> 2078791379;
                case 153 -> 350194214;
                case 154 -> -1934768018;
                case 155 -> 478949627;
                case 156 -> -548823695;
                case 157 -> -1142095266;
                case 158 -> -1019849380;
                case 159 -> -845149847;
                case 160 -> 2146457947;
                case 161 -> -937920718;
                case 162 -> -1976002485;
                case 163 -> -156893789;
                case 164 -> 944315006;
                case 165 -> -2045461177;
                case 166 -> -1798374314;
                case 167 -> -836715;
                case 168 -> 1006399152;
                case 169 -> 497257652;
                case 170 -> 1891832875;
                case 171 -> 1263025928;
                case 172 -> 2051289921;
                case 173 -> 415410713;
                case 174 -> -1016687189;
                case 175 -> -1465719069;
                case 176 -> 372985398;
                case 177 -> -1910659463;
                case 178 -> -1528149345;
                case 179 -> -410431844;
                case 180 -> 1681352612;
                case 181 -> -386176011;
                case 182 -> -918967805;
                case 183 -> -825822729;
                case 184 -> -107273747;
                case 185 -> -461355960;
                case 186 -> 1217017514;
                case 187 -> -432489589;
                case 188 -> 1519474058;
                case 189 -> 2089953397;
                case 190 -> 523881481;
                case 191 -> 1323041081;
                case 192 -> -2063053615;
                case 193 -> 221666947;
                case 194 -> 1149729234;
                case 195 -> -534800728;
                case 196 -> -61992225;
                case 197 -> -1491283546;
                case 198 -> -1503226061;
                case 199 -> -709530269;
                case 200 -> 1797080427;
                case 201 -> 1719574094;
                case 202 -> -1771821098;
                case 203 -> 706118140;
                case 204 -> 1962674253;
                case 205 -> -843400023;
                case 206 -> -1399667003;
                case 207 -> -556666120;
                case 208 -> -909837110;
                case 209 -> 1349833906;
                case 210 -> -906910519;
                case 211 -> -1210347523;
                case 212 -> 156001683;
                case 213 -> 1000834671;
                case 214 -> 1745311808;
                case 215 -> -1851965633;
                case 216 -> -275654691;
                case 217 -> 1818021562;
                case 218 -> 2142342891;
                case 219 -> 1842477989;
                case 220 -> -1374610042;
                case 221 -> 383011028;
                case 222 -> 28755345;
                case 223 -> -2140646892;
                case 224 -> 986395722;
                case 225 -> -1811386419;
                case 226 -> -1598570974;
                case 227 -> 118859376;
                case 228 -> -741704881;
                case 229 -> 1895900518;
                case 230 -> -906870564;
                case 231 -> 455253455;
                case 232 -> 2087946413;
                case 233 -> 326312602;
                case 234 -> 1763660217;
                case 235 -> 948727423;
                case 236 -> -215597093;
                case 237 -> 1192302412;
                case 238 -> -2945139;
                case 239 -> 522062048;
                case 240 -> -1882651067;
                case 241 -> 401381236;
                case 242 -> -1033582946;
                case 243 -> 1692355398;
                case 244 -> -787328574;
                case 245 -> -40755223;
                case 246 -> -1479938608;
                case 247 -> 1818736104;
                case 248 -> -1526541549;
                case 249 -> -1720921834;
                case 250 -> 2134321506;
                case 251 -> 142952541;
                case 252 -> -482016638;
                case 253 -> 246657984;
                case 254 -> 1241939862;
                case 255 -> 1887411260;
                default -> 340579504;
            });
        } while (v2 != 128);
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
            0iI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        RenderSupport_0I0 = new EnumType_oo0i_0("IDLE", 0);
        0Io = new EnumType_oo0i_0("AIMING_PLACE", 1);
        ConfigSupport_0II = new EnumType_oo0i_0("WAIT_PLACE_RESULT", 2);
        ChestStealerModule = new EnumType_oo0i_0("WAIT_RETRIEVE", 3);
        DataRecord_0io_2 = new EnumType_oo0i_0("AIMING_RETRIEVE", 4);
        KeepSprintModule = new EnumType_oo0i_0("WAIT_RETRIEVE_RESULT", 5);
        0io = EnumType_oo0i_0.O0i();
    }

    private static /* synthetic */ EnumType_oo0i_0[] O0i() {
        return new EnumType_oo0i_0[]{RenderSupport_0I0, 0Io, ConfigSupport_0II, ChestStealerModule, DataRecord_0io_2, KeepSprintModule};
    }
}

