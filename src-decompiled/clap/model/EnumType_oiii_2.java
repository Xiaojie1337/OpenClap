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
 * Renamed from clap.render.RenderSupport_oii_4i
 */
final class EnumType_oiii_2
extends Enum {
    public static final /* enum */ EnumType_oiii_2 iI0;
    public static final /* enum */ EnumType_oiii_2 iIo;
    private static final /* synthetic */ EnumType_oiii_2[] PotionEffectsHudElement;
    static Object iIi;

    public static EnumType_oiii_2[] values() {
        return (EnumType_oiii_2[])PotionEffectsHudElement.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oiii_2() {
        void param2;
        void param1;
    }

    public static EnumType_oiii_2 valueOf(String param0) {
        return Enum.valueOf(EnumType_oiii_2.class, param0);
    }

    static {
        byte[] v0 = "?\u00c9u\u0092n\u0082\t\u001fM\u0011ED\u00c9\u00fa\u00d3Wb\u008b\u00ba\u0005\u00ce\u00be\u00f4\u0088\u009e\u00e0A\f\u0099\u0090`\u0015\u0011c\u00ce\u0088\u0096\u00ad\u0001W\u00f2\u00bf\u00fb\u00ae\u0084v\u00159`l\u00e8x\u00d4_\u00825".getBytes("ISO_8859_1");
        Object[] v1 = "D\u00e4\u0090\u00cfT \u0093\u0099".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 757272841;
                case 1 -> 1389294661;
                case 2 -> 343755915;
                case 3 -> 1108043374;
                case 4 -> 1917554497;
                case 5 -> 2099194291;
                case 6 -> -229924564;
                case 7 -> 671977488;
                case 8 -> 1813857239;
                case 9 -> -955051706;
                case 10 -> 154887715;
                case 11 -> -950878301;
                case 12 -> 136268043;
                case 13 -> -1237357014;
                case 14 -> -1482096227;
                case 15 -> 1148033859;
                case 16 -> 1538780528;
                case 17 -> 752305667;
                case 18 -> -1963526528;
                case 19 -> -330761432;
                case 20 -> 759821169;
                case 21 -> -496134933;
                case 22 -> 1928003854;
                case 23 -> 1609273826;
                case 24 -> 1441722615;
                case 25 -> -74011239;
                case 26 -> 1206892024;
                case 27 -> -551140151;
                case 28 -> -1473566305;
                case 29 -> -228224901;
                case 30 -> -1554724149;
                case 31 -> -1935243217;
                case 32 -> -759441607;
                case 33 -> -1462724294;
                case 34 -> 1571190410;
                case 35 -> -1549319349;
                case 36 -> 23637304;
                case 37 -> 1053574055;
                case 38 -> 1171682800;
                case 39 -> 1209015707;
                case 40 -> 1154355155;
                case 41 -> -2019429514;
                case 42 -> -1032343343;
                case 43 -> -1233370242;
                case 44 -> 228941384;
                case 45 -> 1475608604;
                case 46 -> 1995937254;
                case 47 -> 1335819357;
                case 48 -> 207956648;
                case 49 -> 1866425563;
                case 50 -> 399414930;
                case 51 -> 185441639;
                case 52 -> 1399540932;
                case 53 -> 935254801;
                case 54 -> 72573188;
                case 55 -> -572804350;
                case 56 -> -1132514624;
                case 57 -> -1248178662;
                case 58 -> -1988967447;
                case 59 -> 988772303;
                case 60 -> -627388538;
                case 61 -> -1383542567;
                case 62 -> -2008524275;
                case 63 -> 46259300;
                case 64 -> -2100490307;
                case 65 -> -1430611889;
                case 66 -> -1397593161;
                case 67 -> -1885416722;
                case 68 -> -1963936681;
                case 69 -> 792965066;
                case 70 -> 482186050;
                case 71 -> 1873776488;
                case 72 -> 1595866175;
                case 73 -> 144131837;
                case 74 -> 678112210;
                case 75 -> 1214376736;
                case 76 -> -1619690247;
                case 77 -> -1238440612;
                case 78 -> -1138785797;
                case 79 -> 475869128;
                case 80 -> -80016730;
                case 81 -> -1166546245;
                case 82 -> 1295211981;
                case 83 -> 526771618;
                case 84 -> -588798349;
                case 85 -> -254473390;
                case 86 -> 1777751841;
                case 87 -> -1617462633;
                case 88 -> 1615836466;
                case 89 -> -165096192;
                case 90 -> -1423572236;
                case 91 -> -1703687304;
                case 92 -> 695405825;
                case 93 -> -549893878;
                case 94 -> 1186462083;
                case 95 -> -206179430;
                case 96 -> 2071235380;
                case 97 -> -527685131;
                case 98 -> 554908506;
                case 99 -> 618061925;
                case 100 -> -599305186;
                case 101 -> -513898314;
                case 102 -> -994607838;
                case 103 -> -1543005916;
                case 104 -> 1592450169;
                case 105 -> -565071784;
                case 106 -> -686338023;
                case 107 -> 1229862685;
                case 108 -> -1679859173;
                case 109 -> 1536325517;
                case 110 -> 1314143888;
                case 111 -> 229632775;
                case 112 -> 1913684322;
                case 113 -> 1088391853;
                case 114 -> 349850436;
                case 115 -> -1541166788;
                case 116 -> -368316182;
                case 117 -> 1462131208;
                case 118 -> -808815246;
                case 119 -> 1940799850;
                case 120 -> 1312207090;
                case 121 -> 917872645;
                case 122 -> -369484340;
                case 123 -> 1321340236;
                case 124 -> -1928125387;
                case 125 -> -243290436;
                case 126 -> -1052282208;
                case 127 -> 587821262;
                case 128 -> -623975430;
                case 129 -> -975832746;
                case 130 -> 761354539;
                case 131 -> -1755001471;
                case 132 -> -579387706;
                case 133 -> -22372858;
                case 134 -> -2145167818;
                case 135 -> -916864197;
                case 136 -> 1470089009;
                case 137 -> 503040924;
                case 138 -> 1854700567;
                case 139 -> -793068010;
                case 140 -> -1607052151;
                case 141 -> -2604755;
                case 142 -> 6449243;
                case 143 -> 1831550932;
                case 144 -> 1744062315;
                case 145 -> -1079285053;
                case 146 -> 301975482;
                case 147 -> -426355540;
                case 148 -> 2106925205;
                case 149 -> 1903341462;
                case 150 -> 568324919;
                case 151 -> 754072653;
                case 152 -> -571040876;
                case 153 -> -865794577;
                case 154 -> -126901546;
                case 155 -> 772086889;
                case 156 -> 1422318445;
                case 157 -> 2142299532;
                case 158 -> 1053079272;
                case 159 -> 109857245;
                case 160 -> -106336423;
                case 161 -> 1401170366;
                case 162 -> -1101161047;
                case 163 -> -1737978039;
                case 164 -> -1526453635;
                case 165 -> 1674867495;
                case 166 -> -617945280;
                case 167 -> 1854367640;
                case 168 -> 187767283;
                case 169 -> -1768545365;
                case 170 -> -668209068;
                case 171 -> 174729892;
                case 172 -> 81992316;
                case 173 -> 125502228;
                case 174 -> -1206795735;
                case 175 -> 1806272799;
                case 176 -> -329328336;
                case 177 -> 254879631;
                case 178 -> -1930847754;
                case 179 -> 417654284;
                case 180 -> 688009041;
                case 181 -> 246262191;
                case 182 -> -301815501;
                case 183 -> 1081241210;
                case 184 -> -1850723414;
                case 185 -> 2006338014;
                case 186 -> 408487205;
                case 187 -> -685904432;
                case 188 -> 1264090041;
                case 189 -> 345508033;
                case 190 -> 503961313;
                case 191 -> 1771161877;
                case 192 -> 120868738;
                case 193 -> 916999439;
                case 194 -> 183714420;
                case 195 -> -1293505161;
                case 196 -> -591605168;
                case 197 -> -1173274797;
                case 198 -> 971283052;
                case 199 -> -578046288;
                case 200 -> -1979092755;
                case 201 -> 1459698613;
                case 202 -> 1424609278;
                case 203 -> -1803404924;
                case 204 -> 1249247256;
                case 205 -> 543207954;
                case 206 -> -561565721;
                case 207 -> 117800700;
                case 208 -> 325351333;
                case 209 -> -1607414417;
                case 210 -> 1198059960;
                case 211 -> -1721241283;
                case 212 -> 1239816412;
                case 213 -> -1914136187;
                case 214 -> -1101261138;
                case 215 -> -395005185;
                case 216 -> -1772848716;
                case 217 -> -2140296543;
                case 218 -> 1033673607;
                case 219 -> -901937486;
                case 220 -> -1935486267;
                case 221 -> 1168139363;
                case 222 -> 585042773;
                case 223 -> 891981511;
                case 224 -> 1706321120;
                case 225 -> 876834399;
                case 226 -> -1925584779;
                case 227 -> 497174229;
                case 228 -> -141757110;
                case 229 -> 227077347;
                case 230 -> 527794510;
                case 231 -> -252333410;
                case 232 -> -1275285531;
                case 233 -> 17271020;
                case 234 -> -728817081;
                case 235 -> -224019410;
                case 236 -> 2008602033;
                case 237 -> 2072278399;
                case 238 -> -1448691228;
                case 239 -> 1423189856;
                case 240 -> -488167951;
                case 241 -> 1713299558;
                case 242 -> -1168351725;
                case 243 -> -284976066;
                case 244 -> 1480187537;
                case 245 -> -482573089;
                case 246 -> 1830116449;
                case 247 -> 1282389442;
                case 248 -> 1695986879;
                case 249 -> -530688296;
                case 250 -> -1175019634;
                case 251 -> -696318682;
                case 252 -> -1943850093;
                case 253 -> -1426096678;
                case 254 -> -606294392;
                case 255 -> -581006754;
                default -> 1211454880;
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
            Object[] objectArray = new Object[2];
            v1 = objectArray;
            iIi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iI0 = new EnumType_oiii_2("BEDROCK", 0);
        iIo = new EnumType_oiii_2("UNSAFE", 1);
        PotionEffectsHudElement = EnumType_oiii_2.Oii();
    }

    private static /* synthetic */ EnumType_oiii_2[] Oii() {
        return new EnumType_oiii_2[]{iI0, iIo};
    }
}

