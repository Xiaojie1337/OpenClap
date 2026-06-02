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
 * Renamed from psx.Hyk.iIO
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class EnumType_iio_3
extends Enum {
    public static final /* enum */ EnumType_iio_3 Kernel32SnapshotApi;
    private static final /* synthetic */ EnumType_iio_3[] ConfigSupport_00o_0;
    public static final /* enum */ EnumType_iio_3 0Oi;
    public static final /* enum */ EnumType_iio_3 StorageEspModule;
    static Object DataRecord_00I;

    public static EnumType_iio_3[] values() {
        return (EnumType_iio_3[])ConfigSupport_00o_0.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_iio_3() {
        void param2;
        void param1;
    }

    public static EnumType_iio_3 valueOf(String param0) {
        return Enum.valueOf(EnumType_iio_3.class, param0);
    }

    static {
        byte[] v0 = "1K\u0004\u0000\u00e0\u00f6\u00a1\u0019\u0085~\u00e9b[\u0088yK\u0013)\u00aa\u00d7\u009d\u0089d\u00d7\u00c4\u00bbJ\u001d\u00daq\u008e\u00d1\u00a8\u00c1\u00ee\u00e8\u00c8\rS\u00f9\u0090K\u008ev\u008dj\u00f7\nS\u001fk\u00d0\\\u00a7/~".getBytes("ISO_8859_1");
        Object[] v1 = "\u0096\u009de\u00cb_H7\u0012".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1188175769;
                case 1 -> -1063824824;
                case 2 -> 931675578;
                case 3 -> 556122260;
                case 4 -> -750564759;
                case 5 -> 1793685625;
                case 6 -> 793064474;
                case 7 -> -877266410;
                case 8 -> 1006615643;
                case 9 -> 1927152476;
                case 10 -> -655254230;
                case 11 -> -1907212800;
                case 12 -> 1319605413;
                case 13 -> 1261380758;
                case 14 -> 397933602;
                case 15 -> 236366960;
                case 16 -> -1240053025;
                case 17 -> 96527152;
                case 18 -> -1828566749;
                case 19 -> -400036311;
                case 20 -> -1577162498;
                case 21 -> -74782384;
                case 22 -> 987952177;
                case 23 -> 300866712;
                case 24 -> -650194713;
                case 25 -> -988446699;
                case 26 -> -1482901812;
                case 27 -> 2113086063;
                case 28 -> -123433453;
                case 29 -> -973331119;
                case 30 -> -965797699;
                case 31 -> 1031884760;
                case 32 -> -1455523468;
                case 33 -> -1841744189;
                case 34 -> 468029964;
                case 35 -> 1226574621;
                case 36 -> 1541036564;
                case 37 -> -467429621;
                case 38 -> 457418443;
                case 39 -> -1921031672;
                case 40 -> 1721336299;
                case 41 -> 524314157;
                case 42 -> -74948733;
                case 43 -> 2079874087;
                case 44 -> -1476077266;
                case 45 -> 865599754;
                case 46 -> 556272155;
                case 47 -> 1245860403;
                case 48 -> -555290581;
                case 49 -> 1885277146;
                case 50 -> -1069341678;
                case 51 -> 457095520;
                case 52 -> 699700384;
                case 53 -> -1732696613;
                case 54 -> 571329183;
                case 55 -> 1039357323;
                case 56 -> -239935942;
                case 57 -> -1822124571;
                case 58 -> -645192817;
                case 59 -> -2038038384;
                case 60 -> 1603527061;
                case 61 -> -478476336;
                case 62 -> -738946643;
                case 63 -> -324236615;
                case 64 -> 925978164;
                case 65 -> -563799268;
                case 66 -> 945597537;
                case 67 -> 930764101;
                case 68 -> 547275253;
                case 69 -> 1055098098;
                case 70 -> 1687831218;
                case 71 -> -1495487305;
                case 72 -> 1547932743;
                case 73 -> 1340723981;
                case 74 -> 1938289746;
                case 75 -> -1968044155;
                case 76 -> 809915721;
                case 77 -> -785105992;
                case 78 -> -831972617;
                case 79 -> 1299686557;
                case 80 -> -174959698;
                case 81 -> -599594747;
                case 82 -> -1861417101;
                case 83 -> 407651580;
                case 84 -> 476174491;
                case 85 -> 939180290;
                case 86 -> 2052450261;
                case 87 -> 1186848273;
                case 88 -> 1102970447;
                case 89 -> -1932225174;
                case 90 -> -1051148357;
                case 91 -> -37512532;
                case 92 -> 453982200;
                case 93 -> -125753300;
                case 94 -> 916474950;
                case 95 -> 1906603440;
                case 96 -> -1863845803;
                case 97 -> 1467585008;
                case 98 -> 1635046641;
                case 99 -> 2107525648;
                case 100 -> -2132465128;
                case 101 -> -765929750;
                case 102 -> -693693050;
                case 103 -> -584568719;
                case 104 -> -837404835;
                case 105 -> 2102710584;
                case 106 -> 1769797121;
                case 107 -> -2065274424;
                case 108 -> 1377364644;
                case 109 -> 519679127;
                case 110 -> 1682087121;
                case 111 -> -1475000256;
                case 112 -> -181174933;
                case 113 -> 296523687;
                case 114 -> 82509765;
                case 115 -> -107752340;
                case 116 -> 1668903362;
                case 117 -> 246381362;
                case 118 -> -1487455148;
                case 119 -> -1257371668;
                case 120 -> 380511511;
                case 121 -> 44617219;
                case 122 -> 1921787528;
                case 123 -> 810677459;
                case 124 -> 2053260756;
                case 125 -> -1605383079;
                case 126 -> -325985946;
                case 127 -> -841338688;
                case 128 -> -403212602;
                case 129 -> -1626424602;
                case 130 -> 1915835911;
                case 131 -> -1957999365;
                case 132 -> -586685898;
                case 133 -> -1502481093;
                case 134 -> 1619030505;
                case 135 -> 1749629375;
                case 136 -> -966422545;
                case 137 -> 492041519;
                case 138 -> 1986822942;
                case 139 -> 249880777;
                case 140 -> -826302431;
                case 141 -> 170099382;
                case 142 -> 142131670;
                case 143 -> 2117162502;
                case 144 -> -2143690941;
                case 145 -> 430096762;
                case 146 -> -1997727283;
                case 147 -> -1399626460;
                case 148 -> -2044379866;
                case 149 -> -1068308617;
                case 150 -> 1593768841;
                case 151 -> -782936255;
                case 152 -> 768485998;
                case 153 -> 1504289241;
                case 154 -> 1347254703;
                case 155 -> 523519458;
                case 156 -> 1161815357;
                case 157 -> -1804956511;
                case 158 -> -576811945;
                case 159 -> -2093265476;
                case 160 -> -483776006;
                case 161 -> 1716538765;
                case 162 -> -295467631;
                case 163 -> 2006216452;
                case 164 -> 1577638776;
                case 165 -> -2744500;
                case 166 -> 1248258510;
                case 167 -> 540935748;
                case 168 -> 142846388;
                case 169 -> -1263800839;
                case 170 -> 2120629473;
                case 171 -> -485556679;
                case 172 -> 401973984;
                case 173 -> -1016316051;
                case 174 -> 1937669913;
                case 175 -> 476273635;
                case 176 -> -1234482395;
                case 177 -> 684501070;
                case 178 -> -763729465;
                case 179 -> -915560860;
                case 180 -> -1654144599;
                case 181 -> -587830217;
                case 182 -> 528325715;
                case 183 -> 1203849182;
                case 184 -> -2002269293;
                case 185 -> -1237416574;
                case 186 -> -1334289739;
                case 187 -> 443873882;
                case 188 -> 1378096263;
                case 189 -> -1068411800;
                case 190 -> 1568898122;
                case 191 -> -277097830;
                case 192 -> -117320330;
                case 193 -> -1017670368;
                case 194 -> 905753614;
                case 195 -> -2033811841;
                case 196 -> 909356118;
                case 197 -> 1893689085;
                case 198 -> 204953896;
                case 199 -> 933612607;
                case 200 -> 2038591940;
                case 201 -> -1112705140;
                case 202 -> 1008093313;
                case 203 -> 1795328665;
                case 204 -> 1120943682;
                case 205 -> 893893195;
                case 206 -> 1663537502;
                case 207 -> -1181853762;
                case 208 -> 870710114;
                case 209 -> -11788023;
                case 210 -> -1960639172;
                case 211 -> 1733556853;
                case 212 -> 20850091;
                case 213 -> 616252804;
                case 214 -> -2043094282;
                case 215 -> -1723513733;
                case 216 -> -1975146408;
                case 217 -> -1115159593;
                case 218 -> 1873670819;
                case 219 -> -120605750;
                case 220 -> -172625176;
                case 221 -> -1170578114;
                case 222 -> -1357412398;
                case 223 -> 341850801;
                case 224 -> 859416202;
                case 225 -> 998601317;
                case 226 -> -916439922;
                case 227 -> -313395840;
                case 228 -> -624980355;
                case 229 -> -275468289;
                case 230 -> 1155325412;
                case 231 -> 55226867;
                case 232 -> 301317358;
                case 233 -> -472946468;
                case 234 -> -44609366;
                case 235 -> 902004338;
                case 236 -> 329312207;
                case 237 -> 522001763;
                case 238 -> 1314551219;
                case 239 -> -441794392;
                case 240 -> -1188919243;
                case 241 -> 1033344543;
                case 242 -> 1299319021;
                case 243 -> 1844476125;
                case 244 -> 784479614;
                case 245 -> 273449823;
                case 246 -> 129873054;
                case 247 -> -643518046;
                case 248 -> -579516913;
                case 249 -> -344344174;
                case 250 -> -161026739;
                case 251 -> 1817920934;
                case 252 -> -886454916;
                case 253 -> 550261492;
                case 254 -> 142429596;
                case 255 -> 1292334273;
                default -> -616028146;
            });
        } while (v2 != 56);
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
            DataRecord_00I = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0Oi = new EnumType_iio_3("WTap", 0);
        Kernel32SnapshotApi = new EnumType_iio_3("STap", 1);
        StorageEspModule = new EnumType_iio_3("NoStop", 2);
        ConfigSupport_00o_0 = EnumType_iio_3.EventBusApi();
    }

    private static /* synthetic */ EnumType_iio_3[] EventBusApi() {
        return new EnumType_iio_3[]{0Oi, Kernel32SnapshotApi, StorageEspModule};
    }
}

