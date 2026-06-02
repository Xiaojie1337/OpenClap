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
 */
final class EnumType_0000
extends Enum {
    public static final /* enum */ EnumType_0000 O0oo;
    public static final /* enum */ EnumType_0000 O0oi;
    public static final /* enum */ EnumType_0000 RenderSupport_O0I0;
    public static final /* enum */ EnumType_0000 NetworkSupport_o0oi_2;
    public static final /* enum */ EnumType_0000 ConfigSupport_O0IO;
    public static final /* enum */ EnumType_0000 EnumType_o0o0_0;
    private static final /* synthetic */ EnumType_0000[] O0Io;
    static Object EnumType_O0II;

    public static EnumType_0000[] values() {
        return (EnumType_0000[])O0Io.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0000() {
        void param2;
        void param1;
    }

    public static EnumType_0000 valueOf(String param0) {
        return Enum.valueOf(EnumType_0000.class, param0);
    }

    static {
        byte[] v0 = "\\\u00cd\u00c4\u008b5%\u00f2c\u0095$^\u0010\u00d2\u00b6\u0007S\u00ba\u00aa\" ]\u009b8g\u009a\u0093\u001dJ\u001b\u00bd%f\u0094$\u00edO\r\u00a9\u0098\u0096\u0002\u00a3a(\u00a2\u000bmP\u009f\u00a6g\u00e2M*\u009e\u00bd\u0002\u008d\u00cf;gF\u008aHC_l\u0089\u0019\u00ec\u00f3a\u009a^?(Q>\u00a6T".getBytes("ISO_8859_1");
        Object[] v1 = ")-wF|\\\u001d\u00b3".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 71269731;
                case 1 -> -1780689817;
                case 2 -> 1544122720;
                case 3 -> 1413323524;
                case 4 -> -1782161186;
                case 5 -> 740283673;
                case 6 -> -501069783;
                case 7 -> 1649130470;
                case 8 -> 465689845;
                case 9 -> 1200326951;
                case 10 -> -2101312293;
                case 11 -> -413441715;
                case 12 -> -1169672740;
                case 13 -> -584196858;
                case 14 -> -833809913;
                case 15 -> -52607025;
                case 16 -> 74975446;
                case 17 -> 579554812;
                case 18 -> -402607139;
                case 19 -> -562357593;
                case 20 -> 2141595444;
                case 21 -> -859971301;
                case 22 -> -1817859329;
                case 23 -> 185993757;
                case 24 -> 166072370;
                case 25 -> -1645167374;
                case 26 -> -438539429;
                case 27 -> 529731546;
                case 28 -> -1630736336;
                case 29 -> -379300903;
                case 30 -> 1000335388;
                case 31 -> -1638852328;
                case 32 -> -387362693;
                case 33 -> 72656159;
                case 34 -> 243933952;
                case 35 -> -1422613695;
                case 36 -> 2036844894;
                case 37 -> -1780743345;
                case 38 -> 0xC222722;
                case 39 -> -1829284777;
                case 40 -> -201362260;
                case 41 -> 646069288;
                case 42 -> 59281978;
                case 43 -> 606186956;
                case 44 -> 1908861452;
                case 45 -> 181486422;
                case 46 -> -966245011;
                case 47 -> 201321528;
                case 48 -> 1815937856;
                case 49 -> -129654011;
                case 50 -> -1000016443;
                case 51 -> -1589467728;
                case 52 -> -1461801841;
                case 53 -> 42095441;
                case 54 -> -1147557139;
                case 55 -> -1945192894;
                case 56 -> 2136311054;
                case 57 -> -48971804;
                case 58 -> 0x61556115;
                case 59 -> 1195875561;
                case 60 -> -153015933;
                case 61 -> -175169754;
                case 62 -> -194746246;
                case 63 -> 1947880020;
                case 64 -> 1163342295;
                case 65 -> -1483971968;
                case 66 -> -1843844759;
                case 67 -> -964818697;
                case 68 -> 1093958217;
                case 69 -> 26366349;
                case 70 -> 1093626555;
                case 71 -> 46397960;
                case 72 -> 184298540;
                case 73 -> 1945877054;
                case 74 -> -1915661424;
                case 75 -> 547708232;
                case 76 -> 650608547;
                case 77 -> 1264429953;
                case 78 -> 1756736168;
                case 79 -> 1791726034;
                case 80 -> 800283798;
                case 81 -> -1820843449;
                case 82 -> -1530717304;
                case 83 -> 164395705;
                case 84 -> 1510421762;
                case 85 -> 1341372790;
                case 86 -> -753106130;
                case 87 -> 977856254;
                case 88 -> -524105772;
                case 89 -> 1915956947;
                case 90 -> -1992914593;
                case 91 -> -830349030;
                case 92 -> -436822015;
                case 93 -> 546885110;
                case 94 -> -2684361;
                case 95 -> 395657672;
                case 96 -> 86345725;
                case 97 -> 1091377562;
                case 98 -> -387771099;
                case 99 -> -387922949;
                case 100 -> 170607371;
                case 101 -> -141209864;
                case 102 -> -857178432;
                case 103 -> -871462609;
                case 104 -> -1073265482;
                case 105 -> -274892320;
                case 106 -> -191080157;
                case 107 -> 1430575155;
                case 108 -> 1336945567;
                case 109 -> -326936277;
                case 110 -> 374849905;
                case 111 -> -1340191248;
                case 112 -> 167725795;
                case 113 -> -1322499274;
                case 114 -> -1204757904;
                case 115 -> 1185877753;
                case 116 -> -149847073;
                case 117 -> -801002418;
                case 118 -> 2095441778;
                case 119 -> -819031859;
                case 120 -> 57485482;
                case 121 -> 1012213491;
                case 122 -> -1330849197;
                case 123 -> 304414708;
                case 124 -> -434978613;
                case 125 -> 1642456970;
                case 126 -> 861524151;
                case 127 -> -2055836052;
                case 128 -> -862396854;
                case 129 -> 1917791879;
                case 130 -> -478987140;
                case 131 -> 127221779;
                case 132 -> -909027311;
                case 133 -> 524818786;
                case 134 -> -1980573937;
                case 135 -> -322400066;
                case 136 -> -495410665;
                case 137 -> 1228526;
                case 138 -> -723616979;
                case 139 -> 1980397235;
                case 140 -> 945163390;
                case 141 -> -318660483;
                case 142 -> -1881895305;
                case 143 -> 684551524;
                case 144 -> 960375968;
                case 145 -> -656944794;
                case 146 -> 559655256;
                case 147 -> 1211581844;
                case 148 -> 987151684;
                case 149 -> -1292282517;
                case 150 -> -1971484063;
                case 151 -> -2041357253;
                case 152 -> -1878156155;
                case 153 -> 514234213;
                case 154 -> 674335915;
                case 155 -> 2107967829;
                case 156 -> -802498142;
                case 157 -> -740880804;
                case 158 -> 865812203;
                case 159 -> 1822324882;
                case 160 -> -1015028572;
                case 161 -> 720656305;
                case 162 -> 728087400;
                case 163 -> 1141858529;
                case 164 -> -1523297914;
                case 165 -> 385378419;
                case 166 -> -1513297319;
                case 167 -> 1390563872;
                case 168 -> 919784684;
                case 169 -> -293165511;
                case 170 -> -2072914652;
                case 171 -> -1682536721;
                case 172 -> 2000626136;
                case 173 -> 901835954;
                case 174 -> -1591240518;
                case 175 -> 1196388725;
                case 176 -> -974617780;
                case 177 -> -854134790;
                case 178 -> 297453188;
                case 179 -> 1085439092;
                case 180 -> 1385786305;
                case 181 -> -1101040314;
                case 182 -> 1485645209;
                case 183 -> 408856848;
                case 184 -> 343457546;
                case 185 -> 1852852688;
                case 186 -> -855892305;
                case 187 -> 177276692;
                case 188 -> 635837601;
                case 189 -> 1734538862;
                case 190 -> 1227382717;
                case 191 -> -599508419;
                case 192 -> 2031447192;
                case 193 -> -1140744546;
                case 194 -> -1894158795;
                case 195 -> 315128277;
                case 196 -> -252958529;
                case 197 -> 1085834626;
                case 198 -> -1247791979;
                case 199 -> 1706345770;
                case 200 -> 887418489;
                case 201 -> 1730027415;
                case 202 -> 1644676432;
                case 203 -> -1177990773;
                case 204 -> 736382979;
                case 205 -> 1743567285;
                case 206 -> 1054075971;
                case 207 -> 811994187;
                case 208 -> 590607277;
                case 209 -> -513405422;
                case 210 -> 1707159672;
                case 211 -> 297304244;
                case 212 -> -494437448;
                case 213 -> 113925389;
                case 214 -> -1137543996;
                case 215 -> 1928693375;
                case 216 -> -1908355437;
                case 217 -> -1508781303;
                case 218 -> 963923877;
                case 219 -> 1293743548;
                case 220 -> 1683988711;
                case 221 -> 1823499869;
                case 222 -> -436289473;
                case 223 -> 1327415974;
                case 224 -> 1625452065;
                case 225 -> 270098737;
                case 226 -> 241301705;
                case 227 -> -1895214486;
                case 228 -> 1511865755;
                case 229 -> 70863505;
                case 230 -> -1676463375;
                case 231 -> -1939106105;
                case 232 -> 2129451718;
                case 233 -> -1099829649;
                case 234 -> 102428958;
                case 235 -> -510855983;
                case 236 -> -2047647512;
                case 237 -> -1072850002;
                case 238 -> -1812588349;
                case 239 -> -456644471;
                case 240 -> -1468709426;
                case 241 -> -1260652228;
                case 242 -> 1108323350;
                case 243 -> 645240233;
                case 244 -> 1933328106;
                case 245 -> 1526461582;
                case 246 -> 22100636;
                case 247 -> -1381713214;
                case 248 -> -296244251;
                case 249 -> -50617254;
                case 250 -> 379856466;
                case 251 -> -1918123574;
                case 252 -> -538419043;
                case 253 -> 1890597858;
                case 254 -> 1545499973;
                case 255 -> -1819324020;
                default -> 1755317272;
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
            Object[] objectArray = new Object[6];
            v1 = objectArray;
            EnumType_O0II = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        EnumType_o0o0_0 = new EnumType_0000("BOOLEAN", 0);
        O0oo = new EnumType_0000("ENUM", 1);
        NetworkSupport_o0oi_2 = new EnumType_0000("NUMBER", 2);
        O0oi = new EnumType_0000("STRING", 3);
        ConfigSupport_O0IO = new EnumType_0000("BIND", 4);
        RenderSupport_O0I0 = new EnumType_0000("COLOR", 5);
        O0Io = EnumType_0000.0oO();
    }

    private static /* synthetic */ EnumType_0000[] 0oO() {
        return new EnumType_0000[]{EnumType_o0o0_0, O0oo, NetworkSupport_o0oi_2, O0oi, ConfigSupport_O0IO, RenderSupport_O0I0};
    }
}

