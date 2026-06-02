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
import clap.gui.GuiSupport_oiio_3;
import clap.command.Command;

public class TranslateCommand
extends Command {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public void PacketEvent(LiteralArgumentBuilder param12) {
        param12.then(TranslateCommand.RenderSupport_0OO0("text", (ArgumentType)StringArgumentType.greedyString()).executes(param1 -> {
            String v2 = StringArgumentType.getString((CommandContext)param1, (String)"text");
            if (v2 == null || v2.isBlank()) {
                return this.OiIo("Text must not be blank", new Object[0]);
            }
            GuiSupport_oiio_3.OOiII(v2);
            return this.OiIO("Translating and sending...", new Object[0]);
        }));
    }

    static {
        __k__gH4it = TranslateCommand.__k__gH4it(5874705671420636689L);
        __rP__gH4it0 = new String[]{"\u2d8d\u84f6\u5a16\u0f94\u8893\uc4d2\u23df\u5a6d\u2ef2\u87f0\u5963\u0c4c\u8bcb\uc783\u20a9\u5b0f\u2f53\u8602\u58a2\u0d90\u8afd\uc68b\u2113\u5c71\u2853\u81a8\u5ffe\u0ace\u8d67\uc15f\u26fe\u5dab\u29d1\u8001\u5ed2\u0b9b\u8c64\uc039\u2719\u5d42\u2aeb\u83dc\u5db2\u083b\u8fee\uc3fe\u2413\u5e25\u2bd0\u82dc\u5ca9\u0940\u8eeb\uc24b\u25bf\u5fb2\u1448\ubd91\u6395\u3686\ub1af\ufd8b\u1a4c\u60c9\u15b5\ubc3e\u62a1\u37a5\ub003\ufc89\u1b65\u6101\u1557\ubfb4\u619e\u34c2\ub3d3\uff23\u1878\u62e3\u1604\ube31\u6044\u35b8\ub25e\ufe38\u1920\u6393\u1720\ub971\u6778\u3243\ub5dd\uf9d9\u1e33\u64f2\u1039\ub8d4\u6699\u33d5\ub4a3\uf884\u1ff6\u6598\u1135\ub84c\u6500\u306d\ub7a4\ufbdf\u1cb6\u6657\u1264\ubbfc\u6458\u31cd\ub6ae\ufa75\u1d16\u670d\u130a\uba37\u6bd5\u3ec4\ub9dc\uf55b\u1297\u68a2\u1cc8\ub532\u6b61\u3f7e\ub80a\uf448\u13fb\u6906\u1d6e\ub416\u6a9e\u3c37\ubb45\uf775\u109c\u6a37\u1ec4\ub73d\u6904\u3db6\ubab7\uf62e\u11b7\u6b84\u1fca\ub69b\u685c\u3a3f\ubd06\uf1f8\u16e5\u6c19\u18e1\ub1ae\u6f69\u3acc\ubc26\uf0d6\u1799\u6d92\u19ad\ub04a\u6e1c\u3b08\ubf0d\uf301\u1496\u6e49", "\u2d9c\u873e\u59aa\u0c0b\u8b18\uc77c\u201c\u5a90\u2e82\u8654", "\u2d46\u871c\u59e6\u0c15\u8b59\uc7d5\u20b8\u5afb", "\u2d9e\u8730\u59a4\u0c09\u8b1a\uc77a\u201a\u5a92\u2e80\u864a", "\u2d9c\u8727\u59bb", "\u2d89\u8732\u59aa\u0c7e\u8b01"};
        __rP__gH4it1 = new String[]{"\u2d8a\u8731\u5991\u0c12\u8b48\uc7ef\u2045\u5aef\u2ea6\u87c7\u5889\u0d66\u8a36\uc6f5\u216f\u5bac\u2f9a\u86ed\u5fbc\u0a4a", "\u2d8c\u8733\u59b2\u0c63\u8b08\uc76f\u2001"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[0];
        byte[] v0 = "\u00e3\u00e2\u00b4\tx\u00df\u00b9\r\u00e4\u00dc\u00c9\u00d9(\u0086\u00c7gM&\u0010\u001d\u0006\u0096e\u0001U\u0094DK\u0094J\u0080\u00d3\u00df5P\u00e6\u00afT_\u00c2\u00dd\u00908N-\u009b]\u00ad\u00ee\u0098;-06\u00e9\"n\u00cd\u000f\u00e3|\u00fe\u0012Q\u009bjC\u00f8(\u00c4C\u00a1\u0081\u00d8t\u0097\u00f0fVK\u00daU\u00b6\u00f5ee\u0016#\u00e6\r\u0082\u0006\u00ee\u008c\rJ\u00f7\u00a0[\u00e8\u00a8)\u00f0X\u00c3\u00c0\u00caX\u00a7z\u00b8\u009f\u009ax\u008a\u00e0\u00b5\u00c8\u0000\u00dd\u00ec\u00ab\u000f\u00e1\u00cf\u00ee\u0089z&\u00a6Cca\u00c5\u001d\u00e6\u00f8\u00ba\u00b4\"&\u00f0r\u00dfZ\u00996\u00bb\u00cc\u00b3AtL'f:um\u001b\u00e1o\u001ak1m;_\u0092\u001b\u0086\u0016\u00fdN\u00e4XA".getBytes("ISO_8859_1");
        Object[] v1 = "\u0092r\u0002Nx\u0092\u0090U".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1564355108;
                case 1 -> 450303623;
                case 2 -> -835934538;
                case 3 -> -980408056;
                case 4 -> -1609914042;
                case 5 -> 1545507906;
                case 6 -> -1390319288;
                case 7 -> 1131121848;
                case 8 -> -1795512536;
                case 9 -> -1473856008;
                case 10 -> 263228199;
                case 11 -> 235475788;
                case 12 -> 1631292002;
                case 13 -> -1431382494;
                case 14 -> -1737551807;
                case 15 -> -1796036310;
                case 16 -> -1228818282;
                case 17 -> -2023191197;
                case 18 -> -48695905;
                case 19 -> -341972783;
                case 20 -> -493437868;
                case 21 -> -2019836380;
                case 22 -> 228226314;
                case 23 -> -1530175852;
                case 24 -> 1006318388;
                case 25 -> 106884323;
                case 26 -> 401933010;
                case 27 -> 2142226157;
                case 28 -> -1232014277;
                case 29 -> 1683553792;
                case 30 -> 880920789;
                case 31 -> 1638302945;
                case 32 -> 1645567036;
                case 33 -> 1411859074;
                case 34 -> 1541194057;
                case 35 -> 1834801017;
                case 36 -> -1371605044;
                case 37 -> 0xCCCC066;
                case 38 -> -1998537527;
                case 39 -> -1453744153;
                case 40 -> 1120991147;
                case 41 -> 2118012314;
                case 42 -> 1993204225;
                case 43 -> -71460308;
                case 44 -> 103428214;
                case 45 -> -948894459;
                case 46 -> 2067371750;
                case 47 -> -195790261;
                case 48 -> 1589413851;
                case 49 -> 193398717;
                case 50 -> 1442821263;
                case 51 -> 550454328;
                case 52 -> -516615879;
                case 53 -> -1492083995;
                case 54 -> -1269130957;
                case 55 -> 1837418098;
                case 56 -> -185839348;
                case 57 -> 1561732472;
                case 58 -> 1086878830;
                case 59 -> 1469917276;
                case 60 -> -1246149331;
                case 61 -> -1342073788;
                case 62 -> -189153857;
                case 63 -> -1336291205;
                case 64 -> -1531363345;
                case 65 -> 1925454368;
                case 66 -> -1804735757;
                case 67 -> 612054450;
                case 68 -> -330714054;
                case 69 -> 218063743;
                case 70 -> -1239371809;
                case 71 -> 718948092;
                case 72 -> -443513901;
                case 73 -> -1345867420;
                case 74 -> -184853663;
                case 75 -> -228358579;
                case 76 -> -1295887238;
                case 77 -> 839282846;
                case 78 -> 1264791390;
                case 79 -> 771624018;
                case 80 -> -1742858080;
                case 81 -> -1042598329;
                case 82 -> 1886831090;
                case 83 -> -2067203693;
                case 84 -> -242233922;
                case 85 -> 1976782951;
                case 86 -> 924431145;
                case 87 -> 180232062;
                case 88 -> 1398540371;
                case 89 -> -609341134;
                case 90 -> -1559272947;
                case 91 -> -1854873741;
                case 92 -> 1683549168;
                case 93 -> 1558676505;
                case 94 -> -677749611;
                case 95 -> 915179920;
                case 96 -> 391153805;
                case 97 -> 161851637;
                case 98 -> 1679796171;
                case 99 -> 908441598;
                case 100 -> 309583168;
                case 101 -> -1959408965;
                case 102 -> 1403666613;
                case 103 -> 1445358259;
                case 104 -> -1098587559;
                case 105 -> -2043871530;
                case 106 -> -451129204;
                case 107 -> -430638223;
                case 108 -> -959361005;
                case 109 -> 332921620;
                case 110 -> -392101972;
                case 111 -> 972163013;
                case 112 -> -562089760;
                case 113 -> -1726392213;
                case 114 -> 1959456105;
                case 115 -> 485096706;
                case 116 -> -1303951209;
                case 117 -> -1469022923;
                case 118 -> 1475913674;
                case 119 -> 1264251197;
                case 120 -> -959911631;
                case 121 -> -1142843478;
                case 122 -> 1247392360;
                case 123 -> -1762143327;
                case 124 -> 375773410;
                case 125 -> -65452389;
                case 126 -> 931393908;
                case 127 -> -1495385364;
                case 128 -> -179554963;
                case 129 -> 1923931670;
                case 130 -> -718106089;
                case 131 -> 470045872;
                case 132 -> -1304452156;
                case 133 -> -2013108413;
                case 134 -> 1422180197;
                case 135 -> 582531189;
                case 136 -> -1508762057;
                case 137 -> -2005291261;
                case 138 -> 262385800;
                case 139 -> -519691770;
                case 140 -> -1378865057;
                case 141 -> -1037946439;
                case 142 -> 823982557;
                case 143 -> -831956646;
                case 144 -> 464226156;
                case 145 -> 585076750;
                case 146 -> 1001855620;
                case 147 -> 1667746550;
                case 148 -> -336983490;
                case 149 -> -1063721424;
                case 150 -> -640437938;
                case 151 -> 192515337;
                case 152 -> -590415625;
                case 153 -> 1882014449;
                case 154 -> 1121180437;
                case 155 -> 832696297;
                case 156 -> -36261039;
                case 157 -> 917108137;
                case 158 -> 69770239;
                case 159 -> 1010676404;
                case 160 -> 1794455546;
                case 161 -> -1998220862;
                case 162 -> -1442686777;
                case 163 -> 2000586782;
                case 164 -> 1863477666;
                case 165 -> -1301492248;
                case 166 -> 1659883293;
                case 167 -> 696229423;
                case 168 -> -453069472;
                case 169 -> 2078056715;
                case 170 -> -1376911743;
                case 171 -> 1247225834;
                case 172 -> -1026706003;
                case 173 -> 77021466;
                case 174 -> -1603278899;
                case 175 -> -1404750936;
                case 176 -> -1607743528;
                case 177 -> 1652024210;
                case 178 -> -1560395434;
                case 179 -> -1461691043;
                case 180 -> 1209979179;
                case 181 -> -972852867;
                case 182 -> 1149001552;
                case 183 -> -584776849;
                case 184 -> 15838603;
                case 185 -> -925727814;
                case 186 -> 656469157;
                case 187 -> -866901292;
                case 188 -> -586360679;
                case 189 -> 13849025;
                case 190 -> 335957455;
                case 191 -> 115016465;
                case 192 -> -998869697;
                case 193 -> -1412925481;
                case 194 -> 203406587;
                case 195 -> -91401697;
                case 196 -> -740374607;
                case 197 -> 492025817;
                case 198 -> 614296555;
                case 199 -> -569421227;
                case 200 -> 2059246683;
                case 201 -> -852879739;
                case 202 -> 580604326;
                case 203 -> 1122385070;
                case 204 -> 1901614711;
                case 205 -> 1426128055;
                case 206 -> -207919067;
                case 207 -> 209783640;
                case 208 -> 684691587;
                case 209 -> 614088048;
                case 210 -> 923102872;
                case 211 -> -1494468103;
                case 212 -> -439447250;
                case 213 -> 407841212;
                case 214 -> 1307808765;
                case 215 -> -234411158;
                case 216 -> -379193664;
                case 217 -> -1042739740;
                case 218 -> -1556839186;
                case 219 -> 104488656;
                case 220 -> 910054851;
                case 221 -> 102219904;
                case 222 -> -1159671721;
                case 223 -> -1709602909;
                case 224 -> -370751690;
                case 225 -> -1954729762;
                case 226 -> -798322152;
                case 227 -> -984794998;
                case 228 -> 1171163846;
                case 229 -> 1305412123;
                case 230 -> 1760288157;
                case 231 -> 1221839900;
                case 232 -> 1354250273;
                case 233 -> -480398648;
                case 234 -> -420916087;
                case 235 -> -1889430127;
                case 236 -> 325597519;
                case 237 -> -1746741430;
                case 238 -> 1375988647;
                case 239 -> -1364944625;
                case 240 -> 1899460558;
                case 241 -> 1613654819;
                case 242 -> -1318207057;
                case 243 -> -1011850588;
                case 244 -> 1246654502;
                case 245 -> -639287792;
                case 246 -> 1755546492;
                case 247 -> -971334137;
                case 248 -> 819737844;
                case 249 -> 2047932122;
                case 250 -> 1814878724;
                case 251 -> 379165326;
                case 252 -> 2011164572;
                case 253 -> -832288634;
                case 254 -> 624672325;
                case 255 -> -1685989614;
                default -> -1470956443;
            });
        } while (v2 != 176);
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

    public TranslateCommand() {
        super("fy", "translate");
        this.OiiO("Translate text with Baidu and send the translated result to chat.");
    }
}

