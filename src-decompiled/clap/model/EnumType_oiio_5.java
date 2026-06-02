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
 * Renamed from psx.Hyk.OiiO
 */
public final class EnumType_oiio_5
extends Enum {
    public static final /* enum */ EnumType_oiio_5 OOoI;
    public static final /* enum */ EnumType_oiio_5 Manager;
    public static final /* enum */ EnumType_oiio_5 OOoi;
    private static final /* synthetic */ EnumType_oiio_5[] OOIo;
    public static final /* enum */ EnumType_oiio_5 DataRecord_OOI0;
    static Object GuiSupport_OOII;

    public static EnumType_oiio_5[] values() {
        return (EnumType_oiio_5[])OOIo.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oiio_5() {
        void param2;
        void param1;
    }

    public static EnumType_oiio_5 valueOf(String param0) {
        return Enum.valueOf(EnumType_oiio_5.class, param0);
    }

    static {
        byte[] v0 = "\u00bfB\u0016L\u00b8Y\u00b9\u0095d\u00d9^\u009e\u0099A6\u00c2Wn]4\u0098\fA\u00f2\u00d57\u00fe@\u00ec\u00d13\u0011\u00a1\u0014\u00c1\u00cc0\u0095\u00c6\u00d9\u0002\u00ea\r\u0005\u00b0wv\u0014[\u000f\u00ben\t\u00ad\u00b3g\u0088\u0003\u0094\u00daX\u00aa\u00a9\u00b35\u00e0,\u00ec\u00a3P\u0011\u0084".getBytes("ISO_8859_1");
        Object[] v1 = ")\u00cc\u00b0({\n\n\u00a2".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -686617545;
                case 1 -> 94416192;
                case 2 -> -1648152091;
                case 3 -> -1427599422;
                case 4 -> 549912622;
                case 5 -> 1395899011;
                case 6 -> 1249788456;
                case 7 -> -332265544;
                case 8 -> -487803189;
                case 9 -> 825173192;
                case 10 -> -1043197028;
                case 11 -> 1625419227;
                case 12 -> 1371609293;
                case 13 -> 1285911584;
                case 14 -> 830407189;
                case 15 -> 697525632;
                case 16 -> -825878014;
                case 17 -> 431031658;
                case 18 -> 646364431;
                case 19 -> -645646497;
                case 20 -> 1320747674;
                case 21 -> -1216594796;
                case 22 -> 1030304667;
                case 23 -> 1500677539;
                case 24 -> 256292850;
                case 25 -> -1954337856;
                case 26 -> 1806681642;
                case 27 -> 1198259086;
                case 28 -> 1959620101;
                case 29 -> 1666016856;
                case 30 -> 882394846;
                case 31 -> -940245151;
                case 32 -> 1302087378;
                case 33 -> -628681441;
                case 34 -> -506177528;
                case 35 -> 846226497;
                case 36 -> -971592841;
                case 37 -> 206340647;
                case 38 -> 661211289;
                case 39 -> 639016267;
                case 40 -> 1227527084;
                case 41 -> 434872708;
                case 42 -> 1778873826;
                case 43 -> -531265605;
                case 44 -> -404362981;
                case 45 -> 1939039251;
                case 46 -> -1594897458;
                case 47 -> -10472726;
                case 48 -> -756502000;
                case 49 -> -1197419279;
                case 50 -> -1561262604;
                case 51 -> -1236776474;
                case 52 -> -432614607;
                case 53 -> 1639331824;
                case 54 -> -1334992634;
                case 55 -> 1097926064;
                case 56 -> 1288009523;
                case 57 -> -1496793060;
                case 58 -> -2047426816;
                case 59 -> -1396324240;
                case 60 -> 843936793;
                case 61 -> 1796579674;
                case 62 -> -216570153;
                case 63 -> -1491285768;
                case 64 -> 1219315747;
                case 65 -> -1598593228;
                case 66 -> 1252971591;
                case 67 -> -1043307476;
                case 68 -> 1471836100;
                case 69 -> 161544848;
                case 70 -> 1827659005;
                case 71 -> -1893720034;
                case 72 -> -66371974;
                case 73 -> 2085862726;
                case 74 -> 1107720274;
                case 75 -> 798247307;
                case 76 -> 1346339652;
                case 77 -> -1543860508;
                case 78 -> 1321472902;
                case 79 -> 78496127;
                case 80 -> 1038061049;
                case 81 -> 1575728055;
                case 82 -> 1573269540;
                case 83 -> 266178637;
                case 84 -> 877552524;
                case 85 -> 1714417924;
                case 86 -> -1097701394;
                case 87 -> -2041179796;
                case 88 -> -1362802497;
                case 89 -> -1983032520;
                case 90 -> 1147008545;
                case 91 -> -16649123;
                case 92 -> 1125899314;
                case 93 -> 1685612177;
                case 94 -> 1457931933;
                case 95 -> 1712022964;
                case 96 -> 2072079677;
                case 97 -> 540470880;
                case 98 -> 606285179;
                case 99 -> 1126174444;
                case 100 -> -494842612;
                case 101 -> 1554731885;
                case 102 -> 1492307957;
                case 103 -> 1933887375;
                case 104 -> -470465350;
                case 105 -> 1903187687;
                case 106 -> -194354674;
                case 107 -> -153737418;
                case 108 -> 1143368507;
                case 109 -> -1889484287;
                case 110 -> 2088122814;
                case 111 -> -25079597;
                case 112 -> 1368264275;
                case 113 -> -1071698563;
                case 114 -> 1982258501;
                case 115 -> -1194157240;
                case 116 -> -760390833;
                case 117 -> -1779565534;
                case 118 -> -542109595;
                case 119 -> 732827677;
                case 120 -> 1368130456;
                case 121 -> 942162340;
                case 122 -> 284821716;
                case 123 -> 1809826879;
                case 124 -> 1725633325;
                case 125 -> -827316366;
                case 126 -> -655081630;
                case 127 -> -147814795;
                case 128 -> 951754809;
                case 129 -> -1733298429;
                case 130 -> -1663263327;
                case 131 -> -1521647629;
                case 132 -> -1980361125;
                case 133 -> -178848157;
                case 134 -> 1386538961;
                case 135 -> 1201121545;
                case 136 -> -1888205013;
                case 137 -> -1878275422;
                case 138 -> 1137420790;
                case 139 -> -2116403985;
                case 140 -> -1210746348;
                case 141 -> -1054763610;
                case 142 -> -375582604;
                case 143 -> -466255798;
                case 144 -> -1509217359;
                case 145 -> 280417159;
                case 146 -> -366779424;
                case 147 -> -1149395731;
                case 148 -> -1470482415;
                case 149 -> -281072176;
                case 150 -> 1029053801;
                case 151 -> 790842452;
                case 152 -> -621702382;
                case 153 -> -157586340;
                case 154 -> -141440822;
                case 155 -> 79078486;
                case 156 -> 625794281;
                case 157 -> -205121115;
                case 158 -> -1068360235;
                case 159 -> 259145726;
                case 160 -> 758866835;
                case 161 -> 742643577;
                case 162 -> -305458317;
                case 163 -> -532710068;
                case 164 -> -690391885;
                case 165 -> -1477266630;
                case 166 -> -560669160;
                case 167 -> -1903508551;
                case 168 -> -1353515710;
                case 169 -> 532937995;
                case 170 -> -177603590;
                case 171 -> 1716044973;
                case 172 -> -1104946299;
                case 173 -> -1331667326;
                case 174 -> 2134236429;
                case 175 -> 1241274307;
                case 176 -> 1325101450;
                case 177 -> -1083295011;
                case 178 -> 1822804903;
                case 179 -> -1432458859;
                case 180 -> -894546689;
                case 181 -> 70163848;
                case 182 -> -1118502562;
                case 183 -> 20968551;
                case 184 -> 821688696;
                case 185 -> 1722104494;
                case 186 -> -1899480011;
                case 187 -> -1051188006;
                case 188 -> 344739254;
                case 189 -> -347850559;
                case 190 -> 872161450;
                case 191 -> 892274326;
                case 192 -> -1878996273;
                case 193 -> 459072534;
                case 194 -> 2123183037;
                case 195 -> -1309183773;
                case 196 -> -895753866;
                case 197 -> 337800879;
                case 198 -> 1605853225;
                case 199 -> 87094732;
                case 200 -> -1481297853;
                case 201 -> 1025267853;
                case 202 -> 1490434086;
                case 203 -> 51716295;
                case 204 -> -784396471;
                case 205 -> -730187216;
                case 206 -> 1743674430;
                case 207 -> 878788247;
                case 208 -> -1242890827;
                case 209 -> 1318255548;
                case 210 -> 2019283310;
                case 211 -> -352289714;
                case 212 -> 1666170172;
                case 213 -> -2114606479;
                case 214 -> 424158168;
                case 215 -> -2026890517;
                case 216 -> -2056304347;
                case 217 -> -753757013;
                case 218 -> -1102667800;
                case 219 -> -1678641840;
                case 220 -> -1001926183;
                case 221 -> -572046634;
                case 222 -> -106692775;
                case 223 -> 2017442039;
                case 224 -> 1190952873;
                case 225 -> 1367373905;
                case 226 -> -2032511893;
                case 227 -> -1800182903;
                case 228 -> 936881256;
                case 229 -> -321819224;
                case 230 -> 628167163;
                case 231 -> -1719663337;
                case 232 -> -1238254177;
                case 233 -> 1854915940;
                case 234 -> -325290862;
                case 235 -> 1491064316;
                case 236 -> 6613807;
                case 237 -> 918030790;
                case 238 -> 359578750;
                case 239 -> -724892817;
                case 240 -> -1448639777;
                case 241 -> -1202277764;
                case 242 -> 530638817;
                case 243 -> 1981608711;
                case 244 -> 455836869;
                case 245 -> 1500378526;
                case 246 -> -2095062820;
                case 247 -> 629388629;
                case 248 -> 914073985;
                case 249 -> 764471562;
                case 250 -> -504996448;
                case 251 -> 1173352474;
                case 252 -> -839178295;
                case 253 -> 173062231;
                case 254 -> 1635442790;
                case 255 -> 1392088498;
                default -> -2131837203;
            });
        } while (v2 != 72);
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
            GuiSupport_OOII = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OOoI = new EnumType_oiio_5("FONT1", 0);
        OOoi = new EnumType_oiio_5("FONT1_BOLD", 1);
        Manager = new EnumType_oiio_5("FONT2", 2);
        DataRecord_OOI0 = new EnumType_oiio_5("VANILLA", 3);
        OOIo = EnumType_oiio_5.Kernel32SnapshotApi();
    }

    private static /* synthetic */ EnumType_oiio_5[] Kernel32SnapshotApi() {
        return new EnumType_oiio_5[]{OOoI, OOoi, Manager, DataRecord_OOI0};
    }
}

