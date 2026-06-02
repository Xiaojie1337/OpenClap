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
 * Renamed from psx.Hyk.IoI
 */
final class EnumType_ioi_1
extends Enum {
    public static final /* enum */ EnumType_ioi_1 KeystrokesHudElement;
    public static final /* enum */ EnumType_ioi_1 OIo;
    public static final /* enum */ EnumType_ioi_1 ConfigSupport_OI0;
    private static final /* synthetic */ EnumType_ioi_1[] RenderSupport_oii_4;
    public static final /* enum */ EnumType_ioi_1 ConfigSupport_OII;
    static Object OiO;

    public static EnumType_ioi_1[] values() {
        return (EnumType_ioi_1[])RenderSupport_oii_4.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_ioi_1() {
        void param2;
        void param1;
    }

    public static EnumType_ioi_1 valueOf(String param0) {
        return Enum.valueOf(EnumType_ioi_1.class, param0);
    }

    static {
        byte[] v0 = "}\u00f8\u00e4\u00c9\u00f4\u0082`0$\n\u009d\u00fa\u00d0\u00b8\u00a2\u0088\u00c6\u00e3\u00ac)\u00f1\u00c1\u00aa\u0015\u00e3\u001418\u00ac\u0010K\n\u00e3?>\u00d9g\u00bf\u00d2\u000f\nO\\\u00c8\u00824\u00c8#r\u009dB\u00ae\u00fb,\u00e7i\u00ab\u0084h\u001f.\u00ca\u0012\u00d3\u00d5\u00e2X\u00d4X\u00a8\u00e0\u00cai>\u00e3\u00bb\u0005\u0016\u0011\u0086\u00ea\u0083\u00f2\u00f2/\u00b62\u009a".getBytes("ISO_8859_1");
        Object[] v1 = "fD\u00c8\u009a\u007f\u00b2\u00fa\n".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -204521153;
                case 1 -> 864883079;
                case 2 -> 897543480;
                case 3 -> -1226474563;
                case 4 -> 152496875;
                case 5 -> 222931269;
                case 6 -> 984892679;
                case 7 -> -1858207264;
                case 8 -> -813454137;
                case 9 -> -1928112021;
                case 10 -> -874505765;
                case 11 -> -837364947;
                case 12 -> -1833582625;
                case 13 -> -1513634673;
                case 14 -> 1352544989;
                case 15 -> 393394094;
                case 16 -> 971713796;
                case 17 -> 836304087;
                case 18 -> 402944577;
                case 19 -> -452986927;
                case 20 -> 657696524;
                case 21 -> -1567145228;
                case 22 -> -321104423;
                case 23 -> -424836130;
                case 24 -> -638916815;
                case 25 -> -1705862051;
                case 26 -> 452107081;
                case 27 -> -404973212;
                case 28 -> 787845146;
                case 29 -> -1816529346;
                case 30 -> -628922844;
                case 31 -> -1074938157;
                case 32 -> 1987633657;
                case 33 -> -1929072427;
                case 34 -> -1359047620;
                case 35 -> 1904289826;
                case 36 -> 595966458;
                case 37 -> 1422842638;
                case 38 -> -2084927976;
                case 39 -> -827335536;
                case 40 -> -1967937245;
                case 41 -> 274700787;
                case 42 -> -504776976;
                case 43 -> -2029772125;
                case 44 -> -248437608;
                case 45 -> 311707463;
                case 46 -> -779501792;
                case 47 -> -246603206;
                case 48 -> 1385826793;
                case 49 -> 1193441526;
                case 50 -> 155760942;
                case 51 -> -925716137;
                case 52 -> -2127163989;
                case 53 -> -1433540587;
                case 54 -> 1506284714;
                case 55 -> 1613476658;
                case 56 -> 508873765;
                case 57 -> 1397676591;
                case 58 -> 2104643314;
                case 59 -> -45442759;
                case 60 -> -409633686;
                case 61 -> -143089446;
                case 62 -> 160114396;
                case 63 -> 2138627370;
                case 64 -> -968584292;
                case 65 -> 318190100;
                case 66 -> 1836598970;
                case 67 -> -2110556094;
                case 68 -> 1071242024;
                case 69 -> -2005525134;
                case 70 -> 616193859;
                case 71 -> -1536702548;
                case 72 -> 1850062850;
                case 73 -> -378395744;
                case 74 -> 1290619912;
                case 75 -> -1011788923;
                case 76 -> -1671124585;
                case 77 -> 1411012106;
                case 78 -> 631747712;
                case 79 -> -64068160;
                case 80 -> 1658602630;
                case 81 -> -826500590;
                case 82 -> -226939594;
                case 83 -> 1351250940;
                case 84 -> -1944767860;
                case 85 -> 868533108;
                case 86 -> -1043335237;
                case 87 -> -1875198960;
                case 88 -> -1086721614;
                case 89 -> -1911243547;
                case 90 -> -1669484156;
                case 91 -> -2066048143;
                case 92 -> -1571136258;
                case 93 -> 1458534813;
                case 94 -> 455390773;
                case 95 -> -1738900154;
                case 96 -> -1219476902;
                case 97 -> 1947704406;
                case 98 -> -1219624767;
                case 99 -> 227375923;
                case 100 -> 503416723;
                case 101 -> 1767769345;
                case 102 -> -276713653;
                case 103 -> -389092628;
                case 104 -> -715086577;
                case 105 -> -1410611301;
                case 106 -> 1857725119;
                case 107 -> -1204123314;
                case 108 -> 1129608786;
                case 109 -> -631888535;
                case 110 -> 1781516616;
                case 111 -> 1334249886;
                case 112 -> 918333699;
                case 113 -> 843227484;
                case 114 -> -889979052;
                case 115 -> 473700494;
                case 116 -> 1045974021;
                case 117 -> -1907604532;
                case 118 -> 362261886;
                case 119 -> 553267169;
                case 120 -> -676839107;
                case 121 -> -1808102162;
                case 122 -> 1459977503;
                case 123 -> -1424241543;
                case 124 -> 1782553028;
                case 125 -> 1202573094;
                case 126 -> 1300619307;
                case 127 -> 173856397;
                case 128 -> 1250957590;
                case 129 -> -1486101421;
                case 130 -> 359344033;
                case 131 -> -1615964990;
                case 132 -> -1419675944;
                case 133 -> 1051942488;
                case 134 -> 2091022359;
                case 135 -> 2083110750;
                case 136 -> -888799921;
                case 137 -> 128633480;
                case 138 -> -712776272;
                case 139 -> 343440872;
                case 140 -> 558347631;
                case 141 -> -1285252519;
                case 142 -> 1644059227;
                case 143 -> -1522962612;
                case 144 -> 2033534859;
                case 145 -> 1850195303;
                case 146 -> -756923239;
                case 147 -> 1127714039;
                case 148 -> -693758088;
                case 149 -> -1070068873;
                case 150 -> -1781003468;
                case 151 -> 65139127;
                case 152 -> -1363055172;
                case 153 -> -438761376;
                case 154 -> -440544637;
                case 155 -> -1868107859;
                case 156 -> 1028431441;
                case 157 -> 1459135359;
                case 158 -> -2030431835;
                case 159 -> 131657516;
                case 160 -> -901739654;
                case 161 -> 1960244884;
                case 162 -> 1913061607;
                case 163 -> -1864549227;
                case 164 -> 879159139;
                case 165 -> 484124049;
                case 166 -> 877978367;
                case 167 -> 483529928;
                case 168 -> -2101079398;
                case 169 -> 412410908;
                case 170 -> -1327520816;
                case 171 -> -1579516254;
                case 172 -> 261789396;
                case 173 -> -840084802;
                case 174 -> -122263423;
                case 175 -> -1156330898;
                case 176 -> -786337263;
                case 177 -> -782166430;
                case 178 -> -428215091;
                case 179 -> 320983561;
                case 180 -> -1781082952;
                case 181 -> -347539985;
                case 182 -> -658437090;
                case 183 -> -931382725;
                case 184 -> -1058215427;
                case 185 -> 265642953;
                case 186 -> -1801441488;
                case 187 -> 309877760;
                case 188 -> 921100004;
                case 189 -> -1162564796;
                case 190 -> -444310405;
                case 191 -> -1448040814;
                case 192 -> 123227425;
                case 193 -> 178434896;
                case 194 -> -1067010458;
                case 195 -> -1088192915;
                case 196 -> -954623705;
                case 197 -> 161254645;
                case 198 -> 1884895356;
                case 199 -> -529462208;
                case 200 -> 308804426;
                case 201 -> 1667318422;
                case 202 -> -271920788;
                case 203 -> -700421437;
                case 204 -> -393196822;
                case 205 -> -1198744451;
                case 206 -> -18639605;
                case 207 -> -112582049;
                case 208 -> 1596965395;
                case 209 -> 137347881;
                case 210 -> -1707086793;
                case 211 -> 1678704757;
                case 212 -> -368687230;
                case 213 -> -812184408;
                case 214 -> 677104586;
                case 215 -> -669018193;
                case 216 -> 1242164649;
                case 217 -> 1865106445;
                case 218 -> 1701673686;
                case 219 -> -951451954;
                case 220 -> 1260637361;
                case 221 -> -1085255709;
                case 222 -> -947816842;
                case 223 -> 675851701;
                case 224 -> 939153435;
                case 225 -> 537521572;
                case 226 -> -1382066064;
                case 227 -> 484866901;
                case 228 -> 1185797542;
                case 229 -> 2102065846;
                case 230 -> 920250701;
                case 231 -> -768008734;
                case 232 -> -324037965;
                case 233 -> -10320443;
                case 234 -> -2018851447;
                case 235 -> -606816015;
                case 236 -> -1155200995;
                case 237 -> 1581087080;
                case 238 -> -1625543821;
                case 239 -> -571452748;
                case 240 -> 483659943;
                case 241 -> -160770874;
                case 242 -> -1605768091;
                case 243 -> 27017426;
                case 244 -> -1968851450;
                case 245 -> -348417863;
                case 246 -> -1175680275;
                case 247 -> 380168143;
                case 248 -> -794724705;
                case 249 -> 1630979814;
                case 250 -> 456130299;
                case 251 -> -1309846536;
                case 252 -> 320529099;
                case 253 -> 1923984409;
                case 254 -> -850805919;
                case 255 -> 427985290;
                default -> -152573345;
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
            Object[] objectArray = new Object[4];
            v1 = objectArray;
            OiO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        KeystrokesHudElement = new EnumType_ioi_1("IDLE", 0);
        ConfigSupport_OI0 = new EnumType_ioi_1("AIMING", 1);
        OIo = new EnumType_ioi_1("WAITING_RESULT", 2);
        ConfigSupport_OII = new EnumType_ioi_1("CONFIRMING_USE_ROTATION", 3);
        RenderSupport_oii_4 = EnumType_ioi_1.GuiSupport_OOI();
    }

    private static /* synthetic */ EnumType_ioi_1[] GuiSupport_OOI() {
        return new EnumType_ioi_1[]{KeystrokesHudElement, ConfigSupport_OI0, OIo, ConfigSupport_OII};
    }
}

