/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 */
package clap.command.impl;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.command.Command;
import skidonion.loader.0ooo;

public class IrcCommand
extends Command {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public void PacketEvent(LiteralArgumentBuilder param12) {
        ((LiteralArgumentBuilder)((LiteralArgumentBuilder)param12.executes(param1 -> this.OiIo("Usage: .i <message>", new Object[0]))).then(IrcCommand.ConfigSupport_0OOO("reconnect").executes(param1 -> this.o0Oo()))).then(IrcCommand.RenderSupport_0OO0("message", (ArgumentType)StringArgumentType.greedyString()).executes(param1 -> this.o0OI(StringArgumentType.getString((CommandContext)param1, (String)"message"))));
    }

    public IrcCommand() {
        super("i", "irc");
        this.OiiO("Sends and manages IRC chat");
    }

    static {
        __k__gH4it = IrcCommand.__k__gH4it(5333307193875754513L);
        __rP__gH4it0 = new String[]{"\uca1a\u54f8\u8af3\udf92\u5853\u0c2a\ud61f\u8a21"};
        __rP__gH4it1 = new String[]{"\uca29\u5475\u8a16\udfff\u58ac\u0c08\ud6b0\u8a7a\uc947\u572f", "\uca3c\u5479\u8a16\udf82\u58a5"};
        __rP__gH4it2 = new String[]{"\uca2b\u5473\u8a10\udffd\u58ae\u0c36\ud54e\u8a78\uc945\u5729", "\uca29\u546c\u8a07", "\uca39\u5460\u8a16\udf87\u58ac\u0c03\ud6b5"};
        __rP__gH4it3 = new String[]{"\ucac3\u57ea\u896a\udc88\u5bf7\u0f60\ud678\u8a80\uc94e\u56fa\u88c1\uddac\u5a80\u0ead\ud783\u8b38\uc85b\u56de\u8f18\udaf9\u5d3b\u096d\ud0b4\u8cf4\ucf6f\u51aa\u8ec4\udbca\u5c13\u084e\ud1bf\u8d8c\ucefb\u5079\u8dc5\ud8d2\u5fbf\u0bc4\ud22c\u8ee7\ucdc5\u53d7\u8c84\ud9e5\u5ed6\u0a38\ud3b3\u8f15\ucc8d\u52d5\u8c24\uc646\u413d\u15b9\ucc98\u90aa\ud3f2\u4d38\u933e\uc742\u409f\u1485\ucd3b\u91c1\ud27c\u4c4c\u92d1\uc43d\u43ac\u1741\ucee8\u92a3\ud173\u4ffb\u911d\uc5b2\u42fe\u163e\ucf54\u93da\ud08a\u4e35\u904c\uc53a\u4508\u119f\uc8f7\u940c\ud7b3\u496b\u973b\uc2df\u44ca\u1017\uc976\u9596\ud61d\u4855\u96bd\uc3f8\u4792\u13d2\uca2a\u9646\ud51b\u4bc5\u95c1\uc0be\u4607\u12d2\ucb51\u9765\ud401\u4a60\u946e\uc1db\u466f\u1dce\uc493\u9893\udbb3\u453f\u9b99\ucea9\u492a\u1c7d\uc581\u9947\udab6\u4433\u9abd\ucfcd\u483e\u1f3c\uc691\u9a66\ud936\u47c3\u99c8\ucc24\u4bfb\u1e01\uc7e2\u9bc1\ud855\u46f7\u98ed\ucdfc\u4a78\u1e6a\uc0d3\u9c8b\udf38\u4133\u9f61\ucab9\u4d21\u190e\uc1f1\u9de7", "\uca3f\u547a\u8a15\udf96\u58cc\u0c6b\ud6d1\u8a45\uc923\u577c\u890d\udce2\u5bb2\u0f71\ud7eb\u8b16\uc80f\u5646\u8838\uddce"};
        byte[] v0 = "\b\u00a5\u009c\u00c1\u00c89Z\u001a\u008d\u00bd?\u00ed\u00b7\u00fc\u0099\u00da\u00a0a\u00de\u00c04\u00c4\u00a6\u001e\u009c\u001d\n\u00fb\u0014\u00ef\u00b5~\u0010\u00d6\u0013\u00fb\u00a0}.\u001d&pZ\u00c4\u00c1\u0089I\u00d7\u0016J\u0002_R0j`a\u00af\u0010S\u00f8\u0004\u00d1\u0013\u00f7\u00c3\u00e74\u00d3\u00d8\ny\u00f0|#\u00b3\u0089\u00af\u008e\u00f81\u00caJ\u00c3Gv%&\u0000\u009c5.\u008d\u00f6\u00bc\u00a4\u00b6\u00ba\u00ab\u0011\u00cd+\u00e8|\u00b8\"\u00df_P#\u00ebgZ\u00bf\b\u0002\u00c0\u0007!\u0099\u00e0\u00e8\u00f7x\u008d\u00bc+U\u00fd\u00fc\u00cb\u0004\u0081\u00e53|u\u0004\u00b6\u00e5L\u00d0x\u00a3.\u00c8\u00abE\u00f7CA\u00e1K\u0004/\b\u00a6/{\u0095".getBytes("ISO_8859_1");
        Object[] v1 = "{\u00dd\u00ab5\u00c6\u0019\u009b]".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 194474753;
                case 1 -> -818952404;
                case 2 -> 1465033464;
                case 3 -> 1333248965;
                case 4 -> 566810080;
                case 5 -> 1788960099;
                case 6 -> 2114119833;
                case 7 -> 1034704759;
                case 8 -> -813901461;
                case 9 -> 598881517;
                case 10 -> -1769732636;
                case 11 -> 755846446;
                case 12 -> 854219263;
                case 13 -> 57324803;
                case 14 -> 1728328761;
                case 15 -> 1186411588;
                case 16 -> 756247417;
                case 17 -> -1846846777;
                case 18 -> -2103975376;
                case 19 -> 1477610155;
                case 20 -> 1031460024;
                case 21 -> 1547663355;
                case 22 -> -1196228507;
                case 23 -> 1204804290;
                case 24 -> 1599590719;
                case 25 -> -624624052;
                case 26 -> 1219686820;
                case 27 -> -781072626;
                case 28 -> -267246102;
                case 29 -> 1784550313;
                case 30 -> 1859531761;
                case 31 -> 805201268;
                case 32 -> 83600883;
                case 33 -> -24405350;
                case 34 -> 809245120;
                case 35 -> -1845114486;
                case 36 -> -472141945;
                case 37 -> 1390291431;
                case 38 -> 1515725849;
                case 39 -> 2143531260;
                case 40 -> -1842066852;
                case 41 -> -1860372325;
                case 42 -> 1290390996;
                case 43 -> 335454737;
                case 44 -> -1720724114;
                case 45 -> 1700312052;
                case 46 -> 1162010529;
                case 47 -> -643369687;
                case 48 -> 1570868017;
                case 49 -> 1008363006;
                case 50 -> -1145853150;
                case 51 -> -547580373;
                case 52 -> 1483882450;
                case 53 -> 926727254;
                case 54 -> -912937604;
                case 55 -> -1221953531;
                case 56 -> -2055860234;
                case 57 -> 905999186;
                case 58 -> 618821845;
                case 59 -> -2144137297;
                case 60 -> -1749091101;
                case 61 -> -221075607;
                case 62 -> -1093797938;
                case 63 -> 569983372;
                case 64 -> -1521771494;
                case 65 -> -1354348138;
                case 66 -> -1967627739;
                case 67 -> -1314544903;
                case 68 -> -1020238641;
                case 69 -> -1959784978;
                case 70 -> 54357819;
                case 71 -> -1184895112;
                case 72 -> 944580556;
                case 73 -> 2028372133;
                case 74 -> 560699998;
                case 75 -> 886121338;
                case 76 -> 189258425;
                case 77 -> -1398923776;
                case 78 -> 797414965;
                case 79 -> 2086833843;
                case 80 -> -1902069469;
                case 81 -> 1911789323;
                case 82 -> 174930771;
                case 83 -> -1089287671;
                case 84 -> 1782797183;
                case 85 -> -281763759;
                case 86 -> 1944094285;
                case 87 -> -922646851;
                case 88 -> 1882923560;
                case 89 -> -1676020285;
                case 90 -> 1379302577;
                case 91 -> -1486919609;
                case 92 -> 829010354;
                case 93 -> 128677190;
                case 94 -> 2011631123;
                case 95 -> -1048602211;
                case 96 -> -494438238;
                case 97 -> 288453727;
                case 98 -> 2098609277;
                case 99 -> 2124196360;
                case 100 -> 1083698194;
                case 101 -> 1889841423;
                case 102 -> -1758189685;
                case 103 -> -793056156;
                case 104 -> 160197986;
                case 105 -> 1983940276;
                case 106 -> 1152963265;
                case 107 -> -1959891561;
                case 108 -> -2124869412;
                case 109 -> 1290881018;
                case 110 -> 1039773060;
                case 111 -> 1458251589;
                case 112 -> -931565512;
                case 113 -> -225253891;
                case 114 -> -446415868;
                case 115 -> 875177500;
                case 116 -> 1578304657;
                case 117 -> 294797334;
                case 118 -> 2051699330;
                case 119 -> -1604935182;
                case 120 -> -1731878769;
                case 121 -> 600166605;
                case 122 -> 2132971243;
                case 123 -> -991800529;
                case 124 -> -1257101377;
                case 125 -> -596082609;
                case 126 -> 266704880;
                case 127 -> 667981855;
                case 128 -> 172658267;
                case 129 -> 32235796;
                case 130 -> -1672168232;
                case 131 -> -1782840683;
                case 132 -> 914208797;
                case 133 -> 994386858;
                case 134 -> 2107588454;
                case 135 -> -820869914;
                case 136 -> -2113614192;
                case 137 -> 690645436;
                case 138 -> -462966892;
                case 139 -> -1820302763;
                case 140 -> 863966163;
                case 141 -> -1953733087;
                case 142 -> 1824558125;
                case 143 -> 658665672;
                case 144 -> 409231080;
                case 145 -> -2005769110;
                case 146 -> 1587916074;
                case 147 -> 1385982833;
                case 148 -> -1541031141;
                case 149 -> 207428314;
                case 150 -> -201789573;
                case 151 -> 473458284;
                case 152 -> -346630891;
                case 153 -> 121041985;
                case 154 -> 1851658250;
                case 155 -> 1476432678;
                case 156 -> -1865272674;
                case 157 -> 789492020;
                case 158 -> -256195766;
                case 159 -> 1431629399;
                case 160 -> -747281319;
                case 161 -> 1313044808;
                case 162 -> -555922854;
                case 163 -> 93490856;
                case 164 -> 456239390;
                case 165 -> -1281894850;
                case 166 -> 2065514051;
                case 167 -> 1727699169;
                case 168 -> 788573842;
                case 169 -> -2112672822;
                case 170 -> -353419849;
                case 171 -> -1537005844;
                case 172 -> 437547667;
                case 173 -> -1561357186;
                case 174 -> 563982092;
                case 175 -> 2147260831;
                case 176 -> 1620338016;
                case 177 -> 1733054341;
                case 178 -> 686153880;
                case 179 -> 1528438896;
                case 180 -> -1700178912;
                case 181 -> 1211830898;
                case 182 -> 727322176;
                case 183 -> -1768654504;
                case 184 -> -1296253069;
                case 185 -> 474019213;
                case 186 -> -1453442404;
                case 187 -> 2068459059;
                case 188 -> -1595433285;
                case 189 -> -540420946;
                case 190 -> -1734420464;
                case 191 -> 951111508;
                case 192 -> -1932019258;
                case 193 -> 1284982915;
                case 194 -> 1681761153;
                case 195 -> 1956574781;
                case 196 -> 808588917;
                case 197 -> -786260678;
                case 198 -> -85836177;
                case 199 -> 196021444;
                case 200 -> 1223436271;
                case 201 -> -2038730392;
                case 202 -> 1151426126;
                case 203 -> -384359607;
                case 204 -> -58937082;
                case 205 -> -274542160;
                case 206 -> -2037996128;
                case 207 -> -1210951508;
                case 208 -> -2057266187;
                case 209 -> 587007597;
                case 210 -> -1044743144;
                case 211 -> -776171557;
                case 212 -> 595534027;
                case 213 -> 1802661853;
                case 214 -> -234982237;
                case 215 -> 1946780041;
                case 216 -> -2135158071;
                case 217 -> 91884338;
                case 218 -> -137357095;
                case 219 -> 1603039543;
                case 220 -> -188865017;
                case 221 -> -758211747;
                case 222 -> -819253114;
                case 223 -> -1495927928;
                case 224 -> -388334601;
                case 225 -> 1345945654;
                case 226 -> -1579034622;
                case 227 -> 1216456514;
                case 228 -> 511036032;
                case 229 -> -1041451993;
                case 230 -> 219279201;
                case 231 -> 426101434;
                case 232 -> -1975581124;
                case 233 -> 244811431;
                case 234 -> 698664930;
                case 235 -> 2096302046;
                case 236 -> -1934735137;
                case 237 -> -1510473770;
                case 238 -> 960435047;
                case 239 -> 171108388;
                case 240 -> 2003716631;
                case 241 -> -1083896757;
                case 242 -> 1087666806;
                case 243 -> -709376303;
                case 244 -> -419044442;
                case 245 -> 1173085878;
                case 246 -> -378316311;
                case 247 -> 79243406;
                case 248 -> -1820707369;
                case 249 -> -1671621954;
                case 250 -> 470976693;
                case 251 -> 667151077;
                case 252 -> -520520179;
                case 253 -> -1706255920;
                case 254 -> 1869887917;
                case 255 -> -1005218224;
                default -> -433467668;
            });
        } while (v2 != 160);
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
            Object[] objectArray = new Object[8];
            v1 = objectArray;
            PacketEvent = objectArray;
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

    private int o0OI(String param1) {
        if (0ooo.iOo() == null) {
            return this.OiIo("IRC manager is not initialized", new Object[0]);
        }
        0ooo.iOI().ioii(param1);
        return this.ConfigSupport_oii0_1();
    }

    private int o0Oo() {
        if (0ooo.iOi() == null) {
            return this.OiIo("IRC manager is not initialized", new Object[0]);
        }
        0ooo.WorldTimeModule().ioiI();
        return this.OiIO("IRC reconnecting", new Object[0]);
    }
}

