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
import clap.command.impl.CommandsCommand;
import clap.command.Command;

/*
 * Renamed from clap.command.impl.PrefixCommand
 */
public class PrefixCommand
extends Command {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    public PrefixCommand() {
        super("prefix", "setprefix");
        this.OiiO("Sets the command prefix");
    }

    @Override
    public void PacketEvent(LiteralArgumentBuilder param12) {
        ((LiteralArgumentBuilder)param12.executes(param1 -> this.OiIO("Current prefix: {green} %s", ((CommandsCommand)param1.getSource()).IiII()))).then(PrefixCommand.RenderSupport_0OO0("prefix", (ArgumentType)StringArgumentType.word()).executes(param1 -> {
            String v2 = StringArgumentType.getString((CommandContext)param1, (String)"prefix");
            if (v2 == null || v2.isBlank()) {
                return this.OiIo("Prefix must not be blank", new Object[0]);
            }
            ((CommandsCommand)param1.getSource()).IiIo(v2);
            Command.Oiii("Prefix changed to {green} %s", "general", ((CommandsCommand)param1.getSource()).IiII());
            return this.ConfigSupport_oii0_1();
        }));
    }

    static {
        __k__gH4it = PrefixCommand.__k__gH4it(-5692043115322413551L);
        __rP__gH4it0 = new String[]{"\udb36\ub29a\u6d08\u38e6\ubfb7\u4d11\uc701\u6fa7\uda28\ub3f0", "\udb34\ub298\u6d0e\u38e0\ubfb5\u4d13\uc70f\u6fa9\uda2a\ub3f2", "\udb26\ub28b\u6d08\u389a\ubfb7\u4d16\uc704", "\udb23\ub292\u6d08\u389f\ubfbe"};
        __rP__gH4it1 = new String[]{"\udbe9\ub3b7\u6c3b\u396a\ubefa\u4c6f\uc7c1\u6f31\uda47\ub321\u7389\u268b\ua1d3\u531a\ud8c5\u7052\uc582\uac4c\u7254\u2734\ua001\u5237\ud931\u71b3\uc483\uad7e\u71b3\u2448\ua366\u51c7\uda46\u72aa\uc7ef\uaecc\u7023\u25fd\ua2fc\u5042\udbf3\u7357\uc66b\uaff8\u70aa\u224b\ua566\u579c\udcda\u74e7\uc180\ua8de\u770a\u23a9\ua4bc\u5602\udd05\u75a4\uc085\ua960\u7635\u20bf\ua706\u55cc\ude2e\u76c2\uc35e\uaa3f\u7510\u2101\ua610\u544d\udf29\u7705\uc28d\uabf4\u74ec\u215e\ua9b9\u5bc1\ud058\u78ea\ucdfd\ua48e\u7b55\u2e2a\ua8f9\u5a95\ud111\u7967\ucc43\ua5c1\u7a63\u2fb4\uab16\u590b\ud274\u7a65\ucf69\ua6b0\u7934\u2cd1\uaafe\u5834\ud3a5\u7bd8\ucec4\ua733\u780d\u2da4\uaa5e\u5f22\ud4d3\u7c69\uc949\ua075\u7ff4\u2a20\uada9\u5e98\ud590\u7da3\uc8b7\ua177\u7e07\u2bbd\uac24\u5d3d\ud61d\u7e89\ucbe8\ua289\u7d93\u2864\uaf82\u5cc6\ud725\u7f2f\uca04\ua395\u7ca7\u2907\uae57\u5cd3\u281d\u800c\u35e0\u5c91\u8353\ud643\u5188\ua373\u29e6\u8148\u348e\u5d6f\u82d1\ud733\u501d\ua237\u2a51\u8244\u37c7\u5eef\u815f\ud4b4\u5343\ua174\u2ba9\u837c\u36dc\u5fd1\u80b1\ud5d6\u52e1\ua0db\u2bb7\u848a"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\udb3f\ub2c9\u6d51\u384a\ubfa4\u4de6\uc77d\u6f2e", "\udb20\ub295\u6d0b\u388f\ubfd7\u4d72\uc760\u6f98\uda4c\ub3a3\u6ce3\u39cb\ubed9\u4c58\uc7ba\u70db\uc570\uac89\u73c6\u26f7", "\udb36\ub29f\u6d01"};
        byte[] v0 = "-\u0007\u00c3*\u00ce?B&\u00bbiI\u00b3\u00df\u00b2~Mv\f\u009c\u0004\u0005\u0097\u0082\u00b4o&c`z\u007f\u00ed\u00a5\u000b\u009c\u00fb\u00dd\u00e8\u00f2P`\u00f7\u0090\u008aS\n\u0014\u0081\u00d8\u0014\u00be\"\u00b9\u00d8\u0082V\u0083\t\u0018\u0005\u00b7zTe\u00ed\u00daO(\u0001d\u00ddj\u00d21\u00fc\u00ec\u00a6\u00f5)#5I\u008e]\u00da\u00bdub\u00a0\u00ef\u00d9s\\J\u00f3\u001f\u00aa\u00cd\u00a0,1\u00aa\u00c4\u00c6/\u0098\u001bm|\u00f2\u00ea\u00c8\u0096\u001dU\u009c\u00f0\rX\u0083D\u00fbOwu\u0098\u00e5\u0016f\u00ac\u00b9\u00eb\u00a46\u0016&\u00b8x]\u00e7\u00bf\u00db\u00fb&\u0093\u0094Q\u001b\u00f3\fS\u00d5\u00cf\u00e2\u00b7\u0081\u009b\u0081\u000fz\u00cb\u00a3?\u0007\u0014\u00d7D\u008a\u00cb\u00c09\u0011N\r\u00d3l5".getBytes("ISO_8859_1");
        Object[] v1 = "A\u0007\u0017\u00f0*\u00c0H\u00b3".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 792398405;
                case 1 -> -1038589653;
                case 2 -> -2111535277;
                case 3 -> -688202727;
                case 4 -> -1890989818;
                case 5 -> 95928470;
                case 6 -> -1888191843;
                case 7 -> 2018132221;
                case 8 -> 1386268504;
                case 9 -> -1696486093;
                case 10 -> 234895484;
                case 11 -> 320785889;
                case 12 -> -1117662251;
                case 13 -> -581016608;
                case 14 -> -817520612;
                case 15 -> 1372534060;
                case 16 -> -375083869;
                case 17 -> 1394704300;
                case 18 -> 1690970114;
                case 19 -> 36692356;
                case 20 -> -82296070;
                case 21 -> 1014784460;
                case 22 -> -277464719;
                case 23 -> -1717465124;
                case 24 -> -827821114;
                case 25 -> -1009077331;
                case 26 -> -784732469;
                case 27 -> -2042775023;
                case 28 -> -271247380;
                case 29 -> 813576168;
                case 30 -> 969713864;
                case 31 -> 720238667;
                case 32 -> -1865317356;
                case 33 -> -1720980325;
                case 34 -> -2073209898;
                case 35 -> 1465570062;
                case 36 -> -632161190;
                case 37 -> -2045850030;
                case 38 -> -1365161670;
                case 39 -> -898517177;
                case 40 -> -2040623279;
                case 41 -> 104328699;
                case 42 -> -1555290585;
                case 43 -> 1309212821;
                case 44 -> -1529254450;
                case 45 -> 2086602310;
                case 46 -> -94696328;
                case 47 -> -417049654;
                case 48 -> 182501048;
                case 49 -> 1485980395;
                case 50 -> 937565517;
                case 51 -> -1882541546;
                case 52 -> 370306546;
                case 53 -> -1448740655;
                case 54 -> -1640815085;
                case 55 -> -930936674;
                case 56 -> -1942324316;
                case 57 -> -634769611;
                case 58 -> -1453273334;
                case 59 -> -811395274;
                case 60 -> -849685456;
                case 61 -> 1622473295;
                case 62 -> 672253945;
                case 63 -> 1860700406;
                case 64 -> -1014646670;
                case 65 -> 745406465;
                case 66 -> 1102820394;
                case 67 -> -2087779489;
                case 68 -> -671997265;
                case 69 -> 1220069384;
                case 70 -> 1033235881;
                case 71 -> -845705244;
                case 72 -> 960746639;
                case 73 -> -1969186686;
                case 74 -> 1947221418;
                case 75 -> 1195419715;
                case 76 -> 1383524905;
                case 77 -> 562167556;
                case 78 -> -291882139;
                case 79 -> -1855143575;
                case 80 -> -25620643;
                case 81 -> -140813278;
                case 82 -> 189527099;
                case 83 -> -1549262025;
                case 84 -> -1200042946;
                case 85 -> -537988737;
                case 86 -> 1003023335;
                case 87 -> 1515217413;
                case 88 -> 1452638707;
                case 89 -> 1651926693;
                case 90 -> 616740845;
                case 91 -> 437442533;
                case 92 -> 975239709;
                case 93 -> 1733344244;
                case 94 -> -32455673;
                case 95 -> 685987671;
                case 96 -> -397560453;
                case 97 -> 982584994;
                case 98 -> -559483610;
                case 99 -> -1595173171;
                case 100 -> -1372367660;
                case 101 -> 635813272;
                case 102 -> 1678585531;
                case 103 -> -989399654;
                case 104 -> -305872068;
                case 105 -> -1061895497;
                case 106 -> -292156720;
                case 107 -> -1218077577;
                case 108 -> 2095713903;
                case 109 -> -1010609247;
                case 110 -> 179521257;
                case 111 -> 221063617;
                case 112 -> -961937572;
                case 113 -> -1605621964;
                case 114 -> -391472360;
                case 115 -> -727951139;
                case 116 -> 778955019;
                case 117 -> -456596263;
                case 118 -> 1322652533;
                case 119 -> 1905943817;
                case 120 -> 1093419825;
                case 121 -> 15242711;
                case 122 -> -607709771;
                case 123 -> 1039272812;
                case 124 -> 502070684;
                case 125 -> -1216987106;
                case 126 -> -715932530;
                case 127 -> 1510172895;
                case 128 -> -387665063;
                case 129 -> 1301273400;
                case 130 -> 201992038;
                case 131 -> 1068969198;
                case 132 -> 814879098;
                case 133 -> -1413525047;
                case 134 -> 1878906954;
                case 135 -> -684667919;
                case 136 -> -1390729313;
                case 137 -> 1686918403;
                case 138 -> 10444319;
                case 139 -> 1516546144;
                case 140 -> 1440645116;
                case 141 -> 909580789;
                case 142 -> 1972292159;
                case 143 -> -846042777;
                case 144 -> 973477953;
                case 145 -> -1078373517;
                case 146 -> -832715520;
                case 147 -> 905112445;
                case 148 -> 86553968;
                case 149 -> -181666281;
                case 150 -> 1530801243;
                case 151 -> -1192456961;
                case 152 -> 1927815033;
                case 153 -> 1787155140;
                case 154 -> -2065261390;
                case 155 -> 337098962;
                case 156 -> -499042503;
                case 157 -> -426808672;
                case 158 -> -557429172;
                case 159 -> 1149826228;
                case 160 -> -1792210672;
                case 161 -> 1210547858;
                case 162 -> -399106426;
                case 163 -> 158652371;
                case 164 -> 830487032;
                case 165 -> -1631405286;
                case 166 -> 1475133054;
                case 167 -> 915777251;
                case 168 -> -1360497490;
                case 169 -> 1102581076;
                case 170 -> 752373342;
                case 171 -> 2097253592;
                case 172 -> -910309154;
                case 173 -> -1717338781;
                case 174 -> -656414181;
                case 175 -> -1734634533;
                case 176 -> 1029178184;
                case 177 -> 1899421985;
                case 178 -> 1093920697;
                case 179 -> 1278797686;
                case 180 -> -1057586250;
                case 181 -> -797900397;
                case 182 -> -1661219943;
                case 183 -> -1707669782;
                case 184 -> -95741214;
                case 185 -> 1135150063;
                case 186 -> 1251820951;
                case 187 -> 2044123172;
                case 188 -> 647947115;
                case 189 -> -1201327949;
                case 190 -> -439902784;
                case 191 -> 1719395976;
                case 192 -> 429012099;
                case 193 -> -640588415;
                case 194 -> 1629712708;
                case 195 -> 2083396882;
                case 196 -> -1125707227;
                case 197 -> -1357200278;
                case 198 -> -834751704;
                case 199 -> 128962645;
                case 200 -> 2044182369;
                case 201 -> -1539605018;
                case 202 -> 1095316800;
                case 203 -> 392232112;
                case 204 -> -932096115;
                case 205 -> -1558527900;
                case 206 -> -860468038;
                case 207 -> -2143031669;
                case 208 -> -1769697408;
                case 209 -> 1418864839;
                case 210 -> -1625539779;
                case 211 -> 788975125;
                case 212 -> -1136850192;
                case 213 -> 2016100399;
                case 214 -> -1812822900;
                case 215 -> 1933096480;
                case 216 -> 1519508670;
                case 217 -> -1015225455;
                case 218 -> 39602530;
                case 219 -> 570972553;
                case 220 -> -1110957379;
                case 221 -> 1077517303;
                case 222 -> -1002679385;
                case 223 -> 290807985;
                case 224 -> 1315624643;
                case 225 -> 1467830151;
                case 226 -> -1750827070;
                case 227 -> 314374566;
                case 228 -> -1146534256;
                case 229 -> -486945574;
                case 230 -> 1703579757;
                case 231 -> -2082650929;
                case 232 -> -46152882;
                case 233 -> -830010747;
                case 234 -> 784904133;
                case 235 -> -191717802;
                case 236 -> 388267886;
                case 237 -> 932525069;
                case 238 -> 1947211826;
                case 239 -> -1196624884;
                case 240 -> -663965442;
                case 241 -> 155964264;
                case 242 -> -1294417649;
                case 243 -> 1472894100;
                case 244 -> -1350801598;
                case 245 -> -452811148;
                case 246 -> -524225365;
                case 247 -> 1189688110;
                case 248 -> 1372959049;
                case 249 -> -1669987396;
                case 250 -> -998496211;
                case 251 -> -1290462040;
                case 252 -> 1946286160;
                case 253 -> -1763587549;
                case 254 -> 1201707402;
                case 255 -> 514438591;
                default -> 1616557235;
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
            Object[] objectArray = new Object[7];
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
}

