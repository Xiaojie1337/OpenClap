/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  net.minecraft.text.Text
 */
package clap.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.text.Text;
import clap.network.NetworkSupport_io0_0;
import clap.event.Listener;
import clap.render.RenderSupport_ooi_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.render.RenderSupport_ooo_0
 */
public abstract class Command
extends Listener {
    public static final int O0oo;
    private String O0oi = "No description was provided for this command.";
    public static final int EnumType_o0o0_0;
    private final String[] NetworkSupport_o0oi_2;
    static Object ConfigSupport_O0IO;
    private static volatile /* synthetic */ long __k__gH4it;

    protected int OiII() {
        return 0;
    }

    public static RequiredArgumentBuilder RenderSupport_0OO0(String param0, ArgumentType param1) {
        return RequiredArgumentBuilder.argument((String)param0, (ArgumentType)param1);
    }

    public String[] RenderSupport_oiii_5() {
        return this.NetworkSupport_o0oi_2;
    }

    public static void OiiI(String param0, String param1) {
        if (param0 == null) {
            return;
        }
        RenderSupport_ooi_0.PacketEvent((Text)NetworkSupport_io0_0.HelpCommand(param0, new Object[0]), param1);
    }

    public boolean Oiio() {
        return true;
    }

    public Command(String ... param1) {
        super(param1[0]);
        this.NetworkSupport_o0oi_2 = param1;
    }

    public abstract void PacketEvent(LiteralArgumentBuilder var1);

    static {
        __k__gH4it = Command.__k__gH4it(1260399727237656081L);
        __rP__gH4it0 = new String[]{"\u57b8\u7fc5\ua1ac\uf5da\u7227\udc88\u3fd0\ua387\u5671\u7edd\ua0ec\uf2fc\u7598\udbf1\u3846\ua4b6\u51ce\u79df\ua7cb\uf3fd\u7425\udacc\u39ae\ua555\u5092\u78e4\ua6bd\uf348\u77ce\ud989\u3ad7\ua610\u5309\u7b39\ua5a5\uf0b6\u7636\ud8bf\u3ba9\ua736\u5258\u7a4c\ua45a\uf195\u79ae\ud782\u343c\ua8ba\u5dd9\u758f\uab2c\ufe63\u7859\ud6ee\u357d\ua9d5\u5c3b\u74cc\uaab9\uffd4\u78c1\ud527\u3649\uaa5f\u5f4e\u7716\ua981\ufc6c\u7b62\ud4fc\u3703\uab0f\u5e7c\u7601\ua8e6\ufd9a\u7aa9\ud3e3\u3056\uaceb\u596f\u719e\uafe7\ufa77\u7dac\ud3a5\u319a\uadd1\u58c4\u70a7\uaeb7\ufb05\u7cad\ud2ea\u32e2\uae29", "\u574c\u7f41\ua09e"};
        __rP__gH4it1 = new String[]{"\u574c\u7f58\ua08f\uf560\u7235\udc93\u3fd3\ua31d\u5652\u7e32", "\u575a\u7f53\ua08c\uf50d\u7255\udccc\u3f42\ua32e\u5636\u7e65\ua064\uf249\u755b\udbd6\u3868\ua46d\u510a\u794f\ua741\uf375", "\u575c\u7f49\ua08f\uf51c\u7235\udc94\u3fc6", "\u5759\u7f54\ua08f\uf51d\u723c"};
        __rP__gH4it2 = new String[]{"\u574e\u7f5a\ua089\uf566\u7237\udc91\u3fdd\ua313\u5650\u7e30"};
        __rP__gH4it3 = new String[]{"\u5754\u7f6d\ua045\uf520\u7225\udc18\u3fc2\ua31a"};
        byte[] v0 = "\u00d6\u00e3\u0083\u00c8A\u0016\u00c1\u0096\u0007\u00e3\u00db\u00f6\u00e6g_\u00af\u00b0\u00e9\u00f4\u00ffS\"\u008f\u00b4\u00d4\u00aa\u00ba\u00b2\u0080o\u00fe\u00f9G\u007f\u00aaDpA\u0098\u00c7\u000e\u0012M\u007f\u00f0t\u0005C\u0087\u00d93\u0081\u000f <\u0014\u009d\u00a2\u00de\u000eo\u00e1\u0000\u0096\u00e0p\u00ee\u00be\u00c4\"R\u00de\u00ca\u007f\u0091P\u00175\u000f2\u00d1\u00e8\u0098\u00b5\u001a\u008b\u00fbpB)\u00f0\u00bf#\u00cc\u008b\u0080".getBytes("ISO_8859_1");
        Object[] v1 = "Pe\u0084\u0018)\u00b0%1".getBytes("ISO_8859_1");
        int v2 = 0;
        int v3 = 96;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 416765661;
                case 1 -> 1537699820;
                case 2 -> 837267769;
                case 3 -> -593346182;
                case 4 -> -1330803748;
                case 5 -> -445312030;
                case 6 -> 1775255770;
                case 7 -> -1292155880;
                case 8 -> -539032617;
                case 9 -> -2029265720;
                case 10 -> 892149330;
                case 11 -> -1540431123;
                case 12 -> 1447826710;
                case 13 -> 1803442582;
                case 14 -> 862670203;
                case 15 -> 869418984;
                case 16 -> -494236291;
                case 17 -> 1609625995;
                case 18 -> -174322911;
                case 19 -> 778976812;
                case 20 -> -849582473;
                case 21 -> -2137511582;
                case 22 -> -726655756;
                case 23 -> 1170539840;
                case 24 -> 65859839;
                case 25 -> 552900275;
                case 26 -> -813436007;
                case 27 -> 2056989382;
                case 28 -> -666749350;
                case 29 -> -175647819;
                case 30 -> 118542288;
                case 31 -> -1292212335;
                case 32 -> -942028626;
                case 33 -> -1758594869;
                case 34 -> -337514587;
                case 35 -> -1712353061;
                case 36 -> -666556206;
                case 37 -> -788836208;
                case 38 -> -433302393;
                case 39 -> 1379076239;
                case 40 -> 1376485219;
                case 41 -> -248096407;
                case 42 -> -723859067;
                case 43 -> -1573040237;
                case 44 -> 1750819331;
                case 45 -> -117287413;
                case 46 -> -960028434;
                case 47 -> -197157198;
                case 48 -> 963692063;
                case 49 -> -187766394;
                case 50 -> -1753948534;
                case 51 -> -644699557;
                case 52 -> 1698721889;
                case 53 -> -1243249900;
                case 54 -> -584008402;
                case 55 -> 632025905;
                case 56 -> -1355059905;
                case 57 -> 1270199357;
                case 58 -> -860106687;
                case 59 -> 986466999;
                case 60 -> 34766827;
                case 61 -> -166884857;
                case 62 -> 1172316262;
                case 63 -> -1063228686;
                case 64 -> 311064375;
                case 65 -> 1484496798;
                case 66 -> 1069026509;
                case 67 -> -852046236;
                case 68 -> 1978655223;
                case 69 -> -1091797250;
                case 70 -> -766454088;
                case 71 -> 154935202;
                case 72 -> -1966501603;
                case 73 -> -1938983207;
                case 74 -> 1759778433;
                case 75 -> -1415451362;
                case 76 -> 609149947;
                case 77 -> 52109110;
                case 78 -> 1936392118;
                case 79 -> 1424590592;
                case 80 -> -1407202700;
                case 81 -> -2015231019;
                case 82 -> -1559645519;
                case 83 -> 25633358;
                case 84 -> -552995507;
                case 85 -> 706496207;
                case 86 -> 973084101;
                case 87 -> 191868655;
                case 88 -> 2055710804;
                case 89 -> 1719615249;
                case 90 -> -793717933;
                case 91 -> -1222249313;
                case 92 -> 106569627;
                case 93 -> -226994838;
                case 94 -> -1389982711;
                case 95 -> 650247532;
                case 96 -> 1500152357;
                case 97 -> 2034798796;
                case 98 -> 613047369;
                case 99 -> -4735129;
                case 100 -> -667301130;
                case 101 -> -81609437;
                case 102 -> -1518455216;
                case 103 -> 886085272;
                case 104 -> -1764151952;
                case 105 -> 1485312047;
                case 106 -> -494880758;
                case 107 -> 2132613343;
                case 108 -> 904516461;
                case 109 -> 760976405;
                case 110 -> -207125293;
                case 111 -> 1155217032;
                case 112 -> 1253834995;
                case 113 -> -1478169035;
                case 114 -> 978860188;
                case 115 -> 1185333188;
                case 116 -> -2087521039;
                case 117 -> 1954493577;
                case 118 -> -680030785;
                case 119 -> 403223893;
                case 120 -> 865345359;
                case 121 -> 523819040;
                case 122 -> -804698375;
                case 123 -> 2061245058;
                case 124 -> 188578418;
                case 125 -> -1384778228;
                case 126 -> -1263343718;
                case 127 -> 1665468452;
                case 128 -> 329783723;
                case 129 -> 1794538148;
                case 130 -> 557738132;
                case 131 -> 241257976;
                case 132 -> 2040089369;
                case 133 -> 2075521916;
                case 134 -> -2124851908;
                case 135 -> -290988157;
                case 136 -> -759833878;
                case 137 -> 1060309054;
                case 138 -> -1163914060;
                case 139 -> -1604397820;
                case 140 -> -1605353915;
                case 141 -> -1106716072;
                case 142 -> 550256659;
                case 143 -> -454703037;
                case 144 -> 1367597939;
                case 145 -> -2002461607;
                case 146 -> 450384186;
                case 147 -> 923580886;
                case 148 -> -1495482384;
                case 149 -> -1316498500;
                case 150 -> 1046085922;
                case 151 -> -1282544297;
                case 152 -> 1844175354;
                case 153 -> -14081922;
                case 154 -> 880289851;
                case 155 -> 1094930247;
                case 156 -> 941540971;
                case 157 -> 1837069679;
                case 158 -> 1089993800;
                case 159 -> 1930844255;
                case 160 -> 792233036;
                case 161 -> 2107806141;
                case 162 -> -1154946262;
                case 163 -> 70485443;
                case 164 -> 136913660;
                case 165 -> 1194182492;
                case 166 -> -1590326657;
                case 167 -> -336015573;
                case 168 -> 1945154233;
                case 169 -> 1799569971;
                case 170 -> -875347296;
                case 171 -> 1554565128;
                case 172 -> 1124140840;
                case 173 -> -661889885;
                case 174 -> 1102165653;
                case 175 -> -194888971;
                case 176 -> -1016462320;
                case 177 -> 848528038;
                case 178 -> 178655794;
                case 179 -> -2055835016;
                case 180 -> 306838757;
                case 181 -> -644321337;
                case 182 -> 1771946502;
                case 183 -> 272014506;
                case 184 -> 381457617;
                case 185 -> 986169209;
                case 186 -> 86453672;
                case 187 -> 1727187808;
                case 188 -> 1830293729;
                case 189 -> -1211425565;
                case 190 -> -1474918306;
                case 191 -> -211051146;
                case 192 -> -2047730686;
                case 193 -> 406293812;
                case 194 -> -2118658512;
                case 195 -> -845048046;
                case 196 -> -765305367;
                case 197 -> -608983412;
                case 198 -> 912171239;
                case 199 -> -990142303;
                case 200 -> -947231131;
                case 201 -> -1324898238;
                case 202 -> 1765216324;
                case 203 -> -932168932;
                case 204 -> 1674568082;
                case 205 -> -656030016;
                case 206 -> 1715690894;
                case 207 -> -957125075;
                case 208 -> 1504642926;
                case 209 -> -480699800;
                case 210 -> 581682970;
                case 211 -> 1495624642;
                case 212 -> 332965725;
                case 213 -> 1487803854;
                case 214 -> 1228314025;
                case 215 -> 1448898123;
                case 216 -> -38768227;
                case 217 -> -762355836;
                case 218 -> -1944011267;
                case 219 -> -1813616298;
                case 220 -> 1064646423;
                case 221 -> 1816034601;
                case 222 -> 65486136;
                case 223 -> 201681792;
                case 224 -> -408530984;
                case 225 -> 1635756429;
                case 226 -> 924601572;
                case 227 -> 1156831710;
                case 228 -> 416703162;
                case 229 -> 390381429;
                case 230 -> 828560910;
                case 231 -> 627830541;
                case 232 -> -1521666277;
                case 233 -> -2019875254;
                case 234 -> 845021130;
                case 235 -> 905977511;
                case 236 -> -1109436204;
                case 237 -> 1344080329;
                case 238 -> 1342808591;
                case 239 -> 1128803774;
                case 240 -> 1216062432;
                case 241 -> 526803649;
                case 242 -> 1976299159;
                case 243 -> 918637743;
                case 244 -> -1302589978;
                case 245 -> 1729271557;
                case 246 -> 1910485543;
                case 247 -> -109219071;
                case 248 -> -758627247;
                case 249 -> -2066763589;
                case 250 -> -122031802;
                case 251 -> 513846444;
                case 252 -> -1154617999;
                case 253 -> -1033868880;
                case 254 -> 1359266221;
                case 255 -> -1569637338;
                default -> 960208778;
            });
        } while (v2 != 96);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((byte[])v1)), new IvParameterSpec(new byte[8]));
        v0 = cipher.doFinal(v0);
        v3 = v0.length;
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
            ConfigSupport_O0IO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        O0oo = 0;
        EnumType_o0o0_0 = -1;
    }

    protected int OiIo(String param1, Object ... param2) {
        Command.Oiii("{red} " + param1, "fail", param2);
        return -1;
    }

    public static LiteralArgumentBuilder ConfigSupport_0OOO(String param0) {
        return LiteralArgumentBuilder.literal((String)param0);
    }

    public static void Oiii(String param0, String param1, Object ... param2) {
        if (param0 == null) {
            return;
        }
        RenderSupport_ooi_0.PacketEvent((Text)NetworkSupport_io0_0.HelpCommand(param0, param2), param1);
    }

    protected void OiiO(String param1) {
        this.O0oi = param1;
    }

    protected int ConfigSupport_oii0_1() {
        return 1;
    }

    protected int OiIO(String param1, Object ... param2) {
        return -1;
    }

    public String Oii0() {
        return this.O0oi;
    }
}

