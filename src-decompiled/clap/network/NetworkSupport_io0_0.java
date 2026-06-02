/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.cattyn.catformat.CatFormat
 *  dev.cattyn.catformat.fabric.FabricCatFormat
 *  net.minecraft.text.MutableText
 */
package clap.network;

import dev.cattyn.catformat.CatFormat;
import dev.cattyn.catformat.fabric.FabricCatFormat;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.text.MutableText;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.Io0
 */
public final class NetworkSupport_io0_0 {
    private static CatFormat PacketEvent;
    static Object HelpCommand;
    private static volatile /* synthetic */ long __k__gH4it;

    public static void PacketEvent() {
        if (PacketEvent != null) {
            throw new IllegalStateException("Formatter is already initialized");
        }
        PacketEvent = new FabricCatFormat(true);
        NetworkSupport_io0_0.GuiSupport_OOI();
    }

    public static CatFormat OOo() {
        return PacketEvent;
    }

    public static MutableText HelpCommand(String param0, Object ... param1) {
        if (param1 == null || param1.length == 0) {
            return (MutableText)PacketEvent.format(param0);
        }
        return (MutableText)PacketEvent.format(param0, param1);
    }

    private static void GuiSupport_OOI() {
        PacketEvent.add("global", () -> 0ooo.i00().GuiSupport_OOI());
    }

    private NetworkSupport_io0_0() {
        throw new AssertionError((Object)"Can't create an instance of utility class");
    }

    static {
        __k__gH4it = NetworkSupport_io0_0.__k__gH4it((long)3531430802451590673L);
        __rP__gH4it0 = new String[]{"\uc508\uad2f\u72f0\u273f\ua085\u84d6\u13cb\u71d0\uc411\uac4f\u7177\u244c\ua302\u87c4\u109d\u72ca\uc7f6\uaf26\u70df\u255c\ua24b\u861f\u1134\u7301\uc63c\uae53\u779b\u224b\ua542\u8112\u162e\u746a\uc1fb\ua94c\u772b\u2347\ua4c5\u80c4\u17b7\u75b9\uc09e\ua8f2\u7657\u2013\ua74f\u8381\u1461\u76ce\uc334\uab0e\u7512\u2190\ua636\u82bb\u1567\u77dc\uc219\uaa35\u743e\u2e09\ua970\u8d3d\u1a5e\u78c1\ucd84\ua5a4\u7baa\u2e09\ua820\u8ca0\u1b7b\u7945\ucc91\ua406\u7a62\u2f06\uab7f\u8f91\u18a1\u7aaa\ucf7e\ua7ed\u7964\u2cc0\uaa55\u8e93\u199c\u7bc5\uced0\ua632\u78f3\u2d5e\uad40\u8942\u1ef7\u7ce7\uc9aa\ua1f8\u7f16\u2a3b\uad51\u889d\u1f77\u7d11\uc8da\ua0f0\u7efd\u2b4c\uac8a\u8b89\u1cd0\u7eb5\ucbf0\ua3f7\u7dd6\u2860\uafb3\u8a76\u1d2e\u7fcd", "\uc5d4\uad24\u737d\u273e\ua024\u84c3\u13d9\u71c3\uc4d8\uac32\u7275\u245a\ua34a\u87c9\u10f3\u7280\uc7e4\uaf18\u7150\u2566", "\uc5d2\uad3e\u737e\u272f\ua044\u84db\u139d"};
        __rP__gH4it1 = new String[]{"\uc532\uad54\u73cd\u27f3\ua016\u841c\u1334\u71fb", "\uc5c0\uad2d\u7378\u2755\ua046\u84ae\u13a6\u71de\uc4de\uac47", "\uc5c2\uad32\u736f", "\uc5d7\uad27\u737e\u272a\ua04d"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\uc5c2\uad2b\u737e\u2757\ua044\u84a0\u13a8\u71dc\uc4dc\uac41"};
        byte[] v0 = "\u00f0f6\u0006\u008a\u007f\u00a9\u0004\u00e1\u000e\u00b9}\u0005e\u00e7\u0006\u001e\u007f\tuT\u00a6F\u00c5\u00dc\u0002EjU\u00a3\u00a4\u0096c%\r^\u00aaM5M\u000e\u0093y\u0002(\u0000\u00fb\"\u00bcw$\u0099I\"\u00f58\u0099D\u0000\b\u0007\u00ac\u00f4\u00dd<\u00ad\u00ac\u00f0oI\u00d9Q!\u0007l\u00f78p\u001b\u00a6\u00d6\u00f4r)\nj.\u00c1p#\u00ed\u00bf\u0017\u00b3=\u00db\u00f2\u00d1p\u00e2\u00feT\u00b5%\u008a\u00d1\u0093\u009d-H\n\u0099\u00b8\u00ce\u00a0\u00a9\f\u00af\u00fc\u00e9".getBytes("ISO_8859_1");
        Object[] v1 = "\u00b8/\u00fd\u00fck\u0087\u00a8\u0011".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1760099722;
                case 1 -> -2142196199;
                case 2 -> -1412301469;
                case 3 -> 166701831;
                case 4 -> 1141088269;
                case 5 -> -210458262;
                case 6 -> 1921839363;
                case 7 -> 1934413021;
                case 8 -> 1064062765;
                case 9 -> -1050932931;
                case 10 -> 409162917;
                case 11 -> 2033622663;
                case 12 -> 458198527;
                case 13 -> -565633800;
                case 14 -> 2111536017;
                case 15 -> 1393186813;
                case 16 -> -660583701;
                case 17 -> 798943047;
                case 18 -> 332309829;
                case 19 -> 1778630175;
                case 20 -> -789099640;
                case 21 -> -118956829;
                case 22 -> -1817420070;
                case 23 -> 1277738148;
                case 24 -> 194182332;
                case 25 -> 460460215;
                case 26 -> -971981564;
                case 27 -> -290789544;
                case 28 -> 651091160;
                case 29 -> -1589313591;
                case 30 -> 309971720;
                case 31 -> -868823281;
                case 32 -> -282527694;
                case 33 -> 1583044737;
                case 34 -> -2099663238;
                case 35 -> 1424040165;
                case 36 -> -1822480116;
                case 37 -> 1297573669;
                case 38 -> 1535667027;
                case 39 -> -2116174830;
                case 40 -> 1737821864;
                case 41 -> 378996332;
                case 42 -> 1827753375;
                case 43 -> -1624409649;
                case 44 -> -1559304317;
                case 45 -> 1930049193;
                case 46 -> 897927964;
                case 47 -> -1254938755;
                case 48 -> 874306517;
                case 49 -> -969552870;
                case 50 -> -1187184197;
                case 51 -> -1545013775;
                case 52 -> 529877284;
                case 53 -> -294860231;
                case 54 -> 1703545878;
                case 55 -> 1971022380;
                case 56 -> 1274290609;
                case 57 -> 1573998645;
                case 58 -> 1178657043;
                case 59 -> -1365276517;
                case 60 -> -1356824418;
                case 61 -> -1403499131;
                case 62 -> 1728146946;
                case 63 -> 877514609;
                case 64 -> -1472663219;
                case 65 -> -115784609;
                case 66 -> 1043735147;
                case 67 -> -1998314672;
                case 68 -> -1613097894;
                case 69 -> 1105583197;
                case 70 -> 2499590;
                case 71 -> -1303581880;
                case 72 -> -1873107538;
                case 73 -> -642052050;
                case 74 -> 1662048192;
                case 75 -> -1612066643;
                case 76 -> -1078788294;
                case 77 -> 56110922;
                case 78 -> -1374291171;
                case 79 -> -1243283153;
                case 80 -> 494251051;
                case 81 -> 2070284221;
                case 82 -> 1963916941;
                case 83 -> -1804345105;
                case 84 -> 1939972720;
                case 85 -> 526049290;
                case 86 -> -2001513730;
                case 87 -> -524126253;
                case 88 -> -261216939;
                case 89 -> 1911436532;
                case 90 -> -576004200;
                case 91 -> -487643537;
                case 92 -> -1128559646;
                case 93 -> 1035548949;
                case 94 -> 1271848744;
                case 95 -> 485644487;
                case 96 -> 97732755;
                case 97 -> 550482142;
                case 98 -> 1779088555;
                case 99 -> 2043036225;
                case 100 -> 2094334962;
                case 101 -> 586060860;
                case 102 -> -1470904960;
                case 103 -> -2032211170;
                case 104 -> 701865838;
                case 105 -> 1100254411;
                case 106 -> 1766312802;
                case 107 -> 71500781;
                case 108 -> 395342576;
                case 109 -> -466465753;
                case 110 -> -579863604;
                case 111 -> 1838831442;
                case 112 -> -841345366;
                case 113 -> -1663089287;
                case 114 -> -198800834;
                case 115 -> 1754189731;
                case 116 -> -2146987054;
                case 117 -> 1239498559;
                case 118 -> -554498764;
                case 119 -> -14067736;
                case 120 -> -395063744;
                case 121 -> 1344000809;
                case 122 -> 2098879252;
                case 123 -> 2007244734;
                case 124 -> -562531167;
                case 125 -> 409394156;
                case 126 -> -77793741;
                case 127 -> 2059403193;
                case 128 -> 399429626;
                case 129 -> 2014920179;
                case 130 -> 145650252;
                case 131 -> 373493174;
                case 132 -> 1017137810;
                case 133 -> 436716147;
                case 134 -> 156748676;
                case 135 -> 1327665525;
                case 136 -> 1976925668;
                case 137 -> 520996107;
                case 138 -> -1750199072;
                case 139 -> 909833127;
                case 140 -> 313398058;
                case 141 -> -298845877;
                case 142 -> -1584067232;
                case 143 -> 1604083431;
                case 144 -> 1822090523;
                case 145 -> -624452981;
                case 146 -> 1571169919;
                case 147 -> -811920266;
                case 148 -> 569838080;
                case 149 -> -718886205;
                case 150 -> -817247339;
                case 151 -> -968965762;
                case 152 -> 1624495836;
                case 153 -> -1643369828;
                case 154 -> 1469712919;
                case 155 -> -1449371834;
                case 156 -> -975771704;
                case 157 -> -381063177;
                case 158 -> -289218151;
                case 159 -> -832954789;
                case 160 -> 929615479;
                case 161 -> -563613346;
                case 162 -> -1207578334;
                case 163 -> 727062857;
                case 164 -> -966397331;
                case 165 -> 2033269861;
                case 166 -> 650872980;
                case 167 -> -1906117064;
                case 168 -> -1838501310;
                case 169 -> 1441852034;
                case 170 -> 1720169410;
                case 171 -> -1668282812;
                case 172 -> -1007753040;
                case 173 -> -2141010220;
                case 174 -> 115361729;
                case 175 -> 2092241570;
                case 176 -> 552884753;
                case 177 -> 1455259424;
                case 178 -> -2100631834;
                case 179 -> 927139088;
                case 180 -> -2058441788;
                case 181 -> -1905489412;
                case 182 -> 1499996618;
                case 183 -> -1763266212;
                case 184 -> -2067600794;
                case 185 -> -602793605;
                case 186 -> 1938667183;
                case 187 -> 714815014;
                case 188 -> -827865789;
                case 189 -> -963356667;
                case 190 -> 644750857;
                case 191 -> 933089203;
                case 192 -> 529464891;
                case 193 -> 1132934704;
                case 194 -> -1948453381;
                case 195 -> 948764540;
                case 196 -> -384583119;
                case 197 -> 74874081;
                case 198 -> 949297855;
                case 199 -> -2095482802;
                case 200 -> -1854888490;
                case 201 -> -559280793;
                case 202 -> -1176584971;
                case 203 -> -414243295;
                case 204 -> -1355010932;
                case 205 -> -1674025818;
                case 206 -> 859837945;
                case 207 -> 1726034318;
                case 208 -> -791140042;
                case 209 -> 1541000942;
                case 210 -> 63337551;
                case 211 -> 1481375316;
                case 212 -> -972698188;
                case 213 -> -1624184422;
                case 214 -> 1848137060;
                case 215 -> -2058590487;
                case 216 -> -1947882632;
                case 217 -> 1533240918;
                case 218 -> -791921327;
                case 219 -> -1235506746;
                case 220 -> -1548279465;
                case 221 -> 136846032;
                case 222 -> 1474069385;
                case 223 -> 164885454;
                case 224 -> -232157385;
                case 225 -> 1679677663;
                case 226 -> 490837170;
                case 227 -> -715564264;
                case 228 -> 725946758;
                case 229 -> -1265590156;
                case 230 -> 367104526;
                case 231 -> 1331673260;
                case 232 -> 488092341;
                case 233 -> -787929651;
                case 234 -> -1038264891;
                case 235 -> 224771984;
                case 236 -> -324056319;
                case 237 -> -1705202454;
                case 238 -> 1987064726;
                case 239 -> 1979858080;
                case 240 -> 213351387;
                case 241 -> 1068615459;
                case 242 -> -375845481;
                case 243 -> -1805099311;
                case 244 -> -1902740521;
                case 245 -> 1011907161;
                case 246 -> 218663784;
                case 247 -> -2116787598;
                case 248 -> -1789218719;
                case 249 -> 2103097530;
                case 250 -> -1548119665;
                case 251 -> -1734205768;
                case 252 -> -2139732775;
                case 253 -> -118202467;
                case 254 -> -2141833226;
                case 255 -> 1625501545;
                default -> -1436212499;
            });
        } while (v2 != 120);
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
            HelpCommand = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
    }
}

