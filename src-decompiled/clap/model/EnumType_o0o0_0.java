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
 * Renamed from clap.model.EnumType_o0o0_0
 */
public final class EnumType_o0o0_0
extends Enum {
    public static final /* enum */ EnumType_o0o0_0 oIO;
    private static final /* synthetic */ EnumType_o0o0_0[] RenderSupport_oio_2;
    public static final /* enum */ EnumType_o0o0_0 oIo;
    private final String oII;
    public static final /* enum */ EnumType_o0o0_0 ConfigSupport_oi0_2;
    public static final /* enum */ EnumType_o0o0_0 ooI;
    public static final /* enum */ EnumType_o0o0_0 ooo;
    private final String oIi;
    public static final /* enum */ EnumType_o0o0_0 ooi;
    static Object oi0;

    public static EnumType_o0o0_0 valueOf(String param0) {
        return Enum.valueOf(EnumType_o0o0_0.class, param0);
    }

    public static EnumType_o0o0_0[] values() {
        return (EnumType_o0o0_0[])RenderSupport_oio_2.clone();
    }

    static {
        byte[] v0 = "\u0019\u00b3\u00fb\u008d\u00fe\u00ac\u001a\u0093\u00bf\u00b0wx[|\u00fc\u0018RnY\u00dd{\u0087*\u0003#\u00dd\u00e0\u00dc\u00b3s\u00a6Ix\u00af1W\u00aa\u0088\u00b6\u0089\r\u0084\u009f\u00ee\u00ea\u00b8\u00dfD\u00b0\u00db\u00c7\u0010\u00ba\u00bfs\u00c1\u00e4\u0086\u00c2\u00e5\u0084\u00fa\u000bZ\u00fd\u00a9\u00f6\u0086\u0000\u001e\u0011\f\u0080\u0099\u00ec\u00f1\u00cc\b\u00b6hf(\u0015\u0098\u00fa\u00bcc4\u008a\u00ed\u00bdl\u00d1#\u00b5\u00b6\u00d4\u00fe^\u0010\u0001\u009c\u001as\u00a0\u00f0=]\u00cc\u0002X\u009d\u0002{\u00ecP\u00e0\u00033\u00d7\u00b5\u0019\u00a7\u00bfu\u008d\u0083&\u00caF\u00c9i#\u008em(Xj\u0005\u00a2YP\u00dc7".getBytes("ISO_8859_1");
        Object[] v1 = "g\u0003R\u0096[\u0004\u0018\u00d7".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -624979158;
                case 1 -> -1487575623;
                case 2 -> -45050076;
                case 3 -> -1842132200;
                case 4 -> 1556280583;
                case 5 -> 1109689927;
                case 6 -> 947248206;
                case 7 -> -1248378990;
                case 8 -> 1542177687;
                case 9 -> -1778156399;
                case 10 -> 571723201;
                case 11 -> -512668283;
                case 12 -> 1487129091;
                case 13 -> -1999737889;
                case 14 -> -1694592124;
                case 15 -> -1658333239;
                case 16 -> 309657007;
                case 17 -> 902818320;
                case 18 -> -2095412779;
                case 19 -> 1161888985;
                case 20 -> 497815079;
                case 21 -> 1797838137;
                case 22 -> -1335961976;
                case 23 -> -1192378452;
                case 24 -> -2035503981;
                case 25 -> -1049830320;
                case 26 -> -863571848;
                case 27 -> -836900027;
                case 28 -> 12328283;
                case 29 -> -1249538121;
                case 30 -> -578655197;
                case 31 -> 1840629145;
                case 32 -> 590153776;
                case 33 -> -1145633710;
                case 34 -> -673021598;
                case 35 -> -1501062872;
                case 36 -> -1054762063;
                case 37 -> 1824420342;
                case 38 -> -797369957;
                case 39 -> 1882475305;
                case 40 -> 331837863;
                case 41 -> -1800126320;
                case 42 -> -1688902874;
                case 43 -> 575168719;
                case 44 -> 2135086667;
                case 45 -> -1008698556;
                case 46 -> -1903806947;
                case 47 -> -1491959561;
                case 48 -> 1437947647;
                case 49 -> -716594763;
                case 50 -> -422920109;
                case 51 -> 940287339;
                case 52 -> 1814410146;
                case 53 -> -894224098;
                case 54 -> -404860467;
                case 55 -> 2054710942;
                case 56 -> 1221438953;
                case 57 -> 323138634;
                case 58 -> 966013869;
                case 59 -> 1366169348;
                case 60 -> 2075407356;
                case 61 -> 1448507648;
                case 62 -> 1925507020;
                case 63 -> -706891200;
                case 64 -> -2017395915;
                case 65 -> -930864369;
                case 66 -> -77708915;
                case 67 -> -118377402;
                case 68 -> -35619039;
                case 69 -> -764390405;
                case 70 -> -201579500;
                case 71 -> 808154362;
                case 72 -> -878842256;
                case 73 -> -377249784;
                case 74 -> 730327813;
                case 75 -> -1333815632;
                case 76 -> -1526035274;
                case 77 -> 1051032924;
                case 78 -> 649640577;
                case 79 -> -1518824329;
                case 80 -> 622888529;
                case 81 -> -1067505247;
                case 82 -> 707740939;
                case 83 -> 643930571;
                case 84 -> 709445900;
                case 85 -> -1722418952;
                case 86 -> 713803216;
                case 87 -> -1930750250;
                case 88 -> -460469449;
                case 89 -> 590189446;
                case 90 -> -1769658349;
                case 91 -> 299748489;
                case 92 -> 1920558062;
                case 93 -> 1574436067;
                case 94 -> 2046082954;
                case 95 -> -58180275;
                case 96 -> 522066157;
                case 97 -> -1788713199;
                case 98 -> 1580853526;
                case 99 -> 1004386142;
                case 100 -> -785150183;
                case 101 -> -1985263442;
                case 102 -> 814581035;
                case 103 -> 1543336076;
                case 104 -> -549982044;
                case 105 -> 1163859519;
                case 106 -> 34941250;
                case 107 -> -1689557126;
                case 108 -> -921930768;
                case 109 -> -782322539;
                case 110 -> -1811781270;
                case 111 -> 2125198892;
                case 112 -> -1292014400;
                case 113 -> 546009460;
                case 114 -> -1005932594;
                case 115 -> -133278150;
                case 116 -> 1925189621;
                case 117 -> 1260525617;
                case 118 -> 1195924990;
                case 119 -> -1132363551;
                case 120 -> 2062430118;
                case 121 -> 1771011329;
                case 122 -> -346138519;
                case 123 -> 986848562;
                case 124 -> -2027240539;
                case 125 -> -633437414;
                case 126 -> 1271079263;
                case 127 -> 677873005;
                case 128 -> 278917320;
                case 129 -> 0x55888CC5;
                case 130 -> -1951853977;
                case 131 -> 1795224152;
                case 132 -> -500049107;
                case 133 -> 334414164;
                case 134 -> -129136446;
                case 135 -> 1381198475;
                case 136 -> -1680895522;
                case 137 -> 911454877;
                case 138 -> 1137763913;
                case 139 -> 1604059496;
                case 140 -> 922596466;
                case 141 -> 726807480;
                case 142 -> 1515573743;
                case 143 -> -96370923;
                case 144 -> 843893619;
                case 145 -> -1589150119;
                case 146 -> 977671698;
                case 147 -> 1390118999;
                case 148 -> -1742247949;
                case 149 -> -1351355555;
                case 150 -> 159385381;
                case 151 -> -1197160116;
                case 152 -> -1383963642;
                case 153 -> -755561718;
                case 154 -> 873942645;
                case 155 -> -608120730;
                case 156 -> 1757155548;
                case 157 -> -1952428676;
                case 158 -> 1384151683;
                case 159 -> -401237350;
                case 160 -> 1989998383;
                case 161 -> 1238916654;
                case 162 -> 78567327;
                case 163 -> 1275324941;
                case 164 -> 1161271788;
                case 165 -> -947747995;
                case 166 -> -1038074371;
                case 167 -> 189333391;
                case 168 -> 1754418922;
                case 169 -> 854070919;
                case 170 -> -1135940073;
                case 171 -> 336020593;
                case 172 -> 1977163203;
                case 173 -> -104536652;
                case 174 -> -2053258923;
                case 175 -> -2120549874;
                case 176 -> -846509469;
                case 177 -> -861640732;
                case 178 -> -343729752;
                case 179 -> -1715794781;
                case 180 -> -2047682179;
                case 181 -> 1026374078;
                case 182 -> -908364223;
                case 183 -> -1682601842;
                case 184 -> -344827143;
                case 185 -> 1442409270;
                case 186 -> 174888627;
                case 187 -> -493198977;
                case 188 -> -1374180862;
                case 189 -> -1116770598;
                case 190 -> 1057914822;
                case 191 -> 152994495;
                case 192 -> -1985444024;
                case 193 -> 2012791096;
                case 194 -> -1842357864;
                case 195 -> -1943251090;
                case 196 -> -649584256;
                case 197 -> -1640979031;
                case 198 -> 719288988;
                case 199 -> 649479230;
                case 200 -> 1478691104;
                case 201 -> 1517713794;
                case 202 -> -1608444831;
                case 203 -> -776812679;
                case 204 -> 796991943;
                case 205 -> 334792500;
                case 206 -> -13676355;
                case 207 -> -311351620;
                case 208 -> 645100234;
                case 209 -> -1125820638;
                case 210 -> 162388531;
                case 211 -> -923732613;
                case 212 -> 978194363;
                case 213 -> 65989547;
                case 214 -> 1072832160;
                case 215 -> 534105002;
                case 216 -> 1736205298;
                case 217 -> 2114739421;
                case 218 -> -1598962026;
                case 219 -> -1825308718;
                case 220 -> -364866093;
                case 221 -> 1693699569;
                case 222 -> -1630394636;
                case 223 -> -603309962;
                case 224 -> -1797989416;
                case 225 -> -160454427;
                case 226 -> 134494820;
                case 227 -> -83418033;
                case 228 -> -26218154;
                case 229 -> -385903407;
                case 230 -> -1752377900;
                case 231 -> -411451669;
                case 232 -> -1558444180;
                case 233 -> 1787209499;
                case 234 -> -531551460;
                case 235 -> -633482912;
                case 236 -> -1855859447;
                case 237 -> 739355367;
                case 238 -> -2076452901;
                case 239 -> -530728730;
                case 240 -> -557862340;
                case 241 -> -1558605646;
                case 242 -> 1166999166;
                case 243 -> -1354922025;
                case 244 -> -654387052;
                case 245 -> -1034723132;
                case 246 -> 352074978;
                case 247 -> 0xB3133B;
                case 248 -> 922171482;
                case 249 -> 1801467247;
                case 250 -> -1918667800;
                case 251 -> -72249789;
                case 252 -> 2037676512;
                case 253 -> 80029370;
                case 254 -> 1386589215;
                case 255 -> 1164355645;
                default -> 854922290;
            });
        } while (v2 != 144);
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
            Object[] objectArray = new Object[12];
            v1 = objectArray;
            oi0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        ooo = new EnumType_o0o0_0("SimplifiedChinese", 0, "SimplifiedChinese", "zh");
        ooI = new EnumType_o0o0_0("TraditionalChinese", 1, "TraditionalChinese", "cht");
        ooi = new EnumType_o0o0_0("English", 2, "English", "en");
        oIO = new EnumType_o0o0_0("Japanese", 3, "Japanese", "jp");
        ConfigSupport_oi0_2 = new EnumType_o0o0_0("Korean", 4, "Korean", "kor");
        oIo = new EnumType_o0o0_0("Vietnamese", 5, "Vietnamese", "vie");
        RenderSupport_oio_2 = EnumType_o0o0_0.ConfigSupport_OI0();
    }

    private static /* synthetic */ EnumType_o0o0_0[] ConfigSupport_OI0() {
        return new EnumType_o0o0_0[]{ooo, ooI, ooi, oIO, ConfigSupport_oi0_2, oIo};
    }

    public String Ooi() {
        return this.oII;
    }

    public String KeystrokesHudElement() {
        return this.oIi;
    }

    /*
     * WARNING - void declaration
     */
    private EnumType_o0o0_0() {
        void param4;
        void param3;
        this.oII = param3;
        this.oIi = param4;
    }

    public String toString() {
        return this.oII;
    }
}

