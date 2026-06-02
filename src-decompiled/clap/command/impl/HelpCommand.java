/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Iterables
 *  com.mojang.brigadier.ParseResults
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.context.ParsedCommandNode
 *  net.minecraft.text.Text
 */
package clap.command.impl;

import com.google.common.collect.Iterables;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedCommandNode;
import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.text.Text;
import clap.command.argument.ArgumentType_0OIO;
import clap.network.NetworkSupport_io0_0;
import clap.render.RenderSupport_ooi_0;
import clap.command.impl.CommandsCommand;
import clap.command.Command;

public class HelpCommand
extends Command {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    public HelpCommand() {
        super("help", "commands", "h", "cmds");
        this.OiiO("Displays all executable commands and additional information");
    }

    private int HelpCommand(CommandContext param1) {
        Command v2 = ArgumentType_0OIO.OoOi(param1, "command_name");
        HelpCommand.Oiii("Usages for %s:", "general", v2.iooi());
        ParseResults v3 = ((CommandsCommand)param1.getSource()).Iiio().parse(v2.iooi(), (Object)((CommandsCommand)param1.getSource()));
        if (v3.getContext().getNodes().isEmpty()) {
            return this.OiIO("No usages available", new Object[0]);
        }
        Map v4 = ((CommandsCommand)param1.getSource()).Iiio().getSmartUsage(((ParsedCommandNode)Iterables.getLast((Iterable)v3.getContext().getNodes())).getNode(), (Object)((CommandsCommand)param1.getSource()));
        for (String v6 : v4.values()) {
            HelpCommand.Oiii(".%s %s", "general", v3.getReader().getString(), v6);
        }
        return this.ConfigSupport_oii0_1();
    }

    @Override
    public void PacketEvent(LiteralArgumentBuilder param1) {
        ((LiteralArgumentBuilder)param1.executes(this::OOo)).then(HelpCommand.RenderSupport_0OO0("command_name", ArgumentType_0OIO.Oo0O()).executes(this::HelpCommand));
    }

    static {
        __k__gH4it = HelpCommand.__k__gH4it(3534536673691954705L);
        __rP__gH4it0 = new String[]{"\ud75a\ubfac\u61ec\u34a1\ub3ca\u6329\u37db"};
        __rP__gH4it1 = new String[]{"\ud6d3\ube02\u6026\u35d0\ub258\u629e\u36b0\u638b\ud169\ub931\u67bb\u32e2\ub59c\u65e7\u312c\u64fd\ud027\ub8d1\u6642\u3381\ub45b\u641f\u3045\u6548\ud3f2\ubbc7\u6553\u302d\ub7da\u6737\u33f9\u66b7\ud343\ubaa5\u6427\u31a2\ub69a\u66f8\u3263\u67bb\ud210\ub54c\u6bf1\u3e12\ub9a8\u69f1\u3d24\u68de\udd28\ub433\u6a52\u3fd6\ub836\u6800\u3c7c\u69a9\udcc3\ub79a\u69c6\u3cda\ubb75\u6b3a\u3f3a\u6a86\udfd5\ub7a6\u6822\u3d27\ubadf\u6a97\u3e36\u6b02\ude76\ub695\u6f9c\u3aef\ubd25\u6d46\u39dd\u6cd6\ud958\ub15c\u6eaf\u3b13\ubc49\u6c2b\u38fb\u6dbb\ud8e6\ub02d\u6dd3\u3858\ubf4b\u6f44\u3b9e\u6e47\udb4f\ub399\u6dbd\u3995\ube62\u6ec5\u3ae3\u6f6d\uda7d\ub2be\u6cf7\u263a\ua1f7\u7118\u252e\u701c\uc546\uad4d\u73a8\u2752\ua0ba\u70f3\u2436\u71f5\uc4c2\uaca9\u724d\u24cd\ua33f\u7306\u27c7\u72e4\uc77f\uaf4b\u71b1\u24c5\ua21c\u724f\u2618\u7361\uc6dc\uae6c\u70d0\u2565\ua5c3\u7500\u21df\u74dd\uc134\ua95d\u77a1\u225b\ua4f1\u744d\u205e\u75b3\uc07b\ua8e8\u76b8\u23ec\ua4bf\u777c\u23b2\u769c\uc38e\uab03\u758a\u204a\ua7ed\u76e7\u22fa\u7733\uc27c\uaac7\u7449\u218d\ua6f7\u794f\u2d0f\u7818\ucdce\ua592\u7bf6\u2e32\ua9af\u78b1\u2c65\u7946\uccfd\ua48c\u7a40\u2faa\ua890\u78f8\u2fc2\u7a7a\ucf12\ua7ed\u79c3\u2c14\uab24\u7bbd\u2e29\u7b6d\uce6e\ua627\u7809\u2dfe\uaae7\u7ab4\u2917\u7c26\uc965\ua1f6\u7f58\u2a41\uad8f\u7d7a\u283d\u7d4b\uc866\ua028\u7e1b\u2b4d\uacaa\u7c05\u2899\u7e54\ucb68\ua309\u7d11\u28b5\uafcd\u7faa\u2b46\u7f13\ucae7\ua2db\u7c0e\u2955\uae81\u7e80\u2a51\u8036\u35a5\u5d4d\u83ae\ud65c\u5164\u8141\ud5cd\u81d2\u348c\u5cec\u8252\ud7c1\u50db\u80fa\ud4c6\u810b\u3760\u5fc9\u8177\ud443\u53eb\u8362\ud7aa\u8268\u3655\u5e12\u8004\ud516\u5279\u822c\ud6f7\u83a2\u3162\u59b7\u87e9\ud271\u55a7\u851a\ud12f\u84f9\u30ea\u5856\u86be\ud316\u54e2\u843e\ud07f\u85fb\u30b3\u5be4\u8557\ud0ac\u577f\u87fb\ud36b\u86b7", "\ud777\ubff3\u61b8\u3457\ub3ef\u63a3\u37f3\u6396"};
        __rP__gH4it2 = new String[]{"\ud74a\ubfb1\u61e4\u34c9\ub3da\u633a\u37c6\u637d\ud654\ubecb", "\ud75c\ubfb2\u61ef\u34ac\ub38a\u632d\u379f\u6286\ud670\ubec4\u60c7\u3528\ub2f4\u6237\u36b5\u63c5\ud14c\ub9ee\u67e2\u3214", "\ud74a\ubfa4\u61fd"};
        __rP__gH4it3 = new String[]{"\ud748\ubfbf\u61ea\u34cb\ub3d8\u633c\u37c0\u637f\ud656\ubed5", "\ud75f\ubfb1\u61f4\u34a0\ub3c3"};
        byte[] v0 = "\u00f3\u008d\u00a2\u00ab\u0099\u00f9d*A\u00b67\u0091E\u0098\u00e0D\u0017N\u00d6\u00ea\u008ah\u0081\u00f9\u00caP\u00cfN\u00f3xE>\u0083\n\u00c3\u00f9\u00bb\u00bf\u00d7:\u00d8\u00eb\u001dA\u0091\u00ae\u0088G\u00f8\u008c\u00a6\u009d\u0007W\u00d88\u001b-:\u0099|\u0095\u00a6o5\u00e9\u00e6\u001c\u00de0\u00a2\u00e3\u009e\u00d2P\u00dc<\u00f9Q/\u00a8\u0003{8X\u009c\u007fJ\u001ez\u000f{\"\u00cb\u00e2\u008e\u00cf\u00f6\u0099\u008e\u0003B\u0097\u00ac\u00f5\u00d9\u00db)\u008e\u0087B\u00c5\u00d62\u009cY\u00cbdR$Z\u00deq\u00cev\u00e9\u009b\u00cd\u00dfD\u00b5>]\u00a8L@tk\u00dc\u0096\u009a\u00ff\u0093\u00e4\u0084B\u00b5\u00b0\u00a0\u00ba\u001a\u0082\u00c3\u00ff\u00a4\u000f\u0016\u00b3\u008e\u0095\u00ce,\u00ee\u0091L \u00ce24\u00e0%^N\u0090#\u0001\u009e\u00ad\u0082\u00f9\u001efAW\u00a5\u00bb<i\u0019\u00d7\u00de\u0013r\"\u0087\u00af\u00a5\u009a=\f\u0006\u00e0EM~\u008b\u001b_\u0015)\f\u00ea\u001eM9:\u001e\u00ffG\u00eeC\ne\u001dh\u00e6\u00b5.,\u00ad\u00b2R\u00ef<\u00a2\u00c6x\u009f\u00bdo\u00b5\u00b2\u001a\u00d7\u0095V)\u0083\u0094\u001b\u00eeB\u0012\u0095\u001a\u00a2@F\u00f38*\u0005~\u00c9}\u0095\u0088e\u00a0S;\u001bR(}\u001avm\u00ebH\u00d2\u00c1\"u\u00cbq\u00c3rsK\u00b3\u00f7^\u00bc\u00df6".getBytes("ISO_8859_1");
        Object[] v1 = "u\u001e\u0012\u00c2\f\u00a6\u0001\u00d1".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 2073297335;
                case 1 -> -883150144;
                case 2 -> 130927921;
                case 3 -> 1511052310;
                case 4 -> -2094689765;
                case 5 -> -391692893;
                case 6 -> 1626550267;
                case 7 -> 1156536047;
                case 8 -> -1267919339;
                case 9 -> 1892574098;
                case 10 -> -1292215936;
                case 11 -> 455595244;
                case 12 -> -838876313;
                case 13 -> 1879476354;
                case 14 -> 1430526291;
                case 15 -> -1907905156;
                case 16 -> 2066361549;
                case 17 -> -2052789557;
                case 18 -> 437205218;
                case 19 -> 1783769614;
                case 20 -> -285755660;
                case 21 -> -1564116541;
                case 22 -> -696918244;
                case 23 -> -1732175416;
                case 24 -> 1145506381;
                case 25 -> -1187781671;
                case 26 -> 922130656;
                case 27 -> -499179285;
                case 28 -> 1873718443;
                case 29 -> 1033824422;
                case 30 -> -78368899;
                case 31 -> 1482223428;
                case 32 -> 814870771;
                case 33 -> 177319448;
                case 34 -> -1181293818;
                case 35 -> -997152374;
                case 36 -> 1945632656;
                case 37 -> -1490609111;
                case 38 -> 1437373572;
                case 39 -> 1527854630;
                case 40 -> 985377147;
                case 41 -> 1629980658;
                case 42 -> -926092115;
                case 43 -> -487238582;
                case 44 -> -1765531587;
                case 45 -> -1098832065;
                case 46 -> 748803613;
                case 47 -> 1458608243;
                case 48 -> 1432614637;
                case 49 -> -99604224;
                case 50 -> 1099114460;
                case 51 -> -580469716;
                case 52 -> -1594038827;
                case 53 -> 62084214;
                case 54 -> -2011614937;
                case 55 -> -1327506173;
                case 56 -> 1323058000;
                case 57 -> -1879669211;
                case 58 -> 749678437;
                case 59 -> -544304062;
                case 60 -> -919786777;
                case 61 -> 1751949623;
                case 62 -> 1219187843;
                case 63 -> -2071526418;
                case 64 -> -48583153;
                case 65 -> 1734772357;
                case 66 -> -1270823622;
                case 67 -> -2053881054;
                case 68 -> 1812839166;
                case 69 -> 1615679134;
                case 70 -> -893176111;
                case 71 -> -678701151;
                case 72 -> 1234655841;
                case 73 -> -171843741;
                case 74 -> 374021887;
                case 75 -> -1764424687;
                case 76 -> 1464964287;
                case 77 -> -670795017;
                case 78 -> -19614270;
                case 79 -> -858509906;
                case 80 -> 839785273;
                case 81 -> -1387595361;
                case 82 -> -185387180;
                case 83 -> -750213353;
                case 84 -> -783583615;
                case 85 -> -1831548055;
                case 86 -> 1943342604;
                case 87 -> -559048398;
                case 88 -> -1201772180;
                case 89 -> -1795694045;
                case 90 -> -387124778;
                case 91 -> 647288037;
                case 92 -> -2126070818;
                case 93 -> 240267093;
                case 94 -> -1939924903;
                case 95 -> 1627178336;
                case 96 -> 151234380;
                case 97 -> -1224780748;
                case 98 -> 1804663582;
                case 99 -> 839968067;
                case 100 -> 1034783746;
                case 101 -> 1953147064;
                case 102 -> -97690047;
                case 103 -> -824815624;
                case 104 -> -723535241;
                case 105 -> 491898158;
                case 106 -> 81103656;
                case 107 -> 1161581103;
                case 108 -> -1906942578;
                case 109 -> 1410082447;
                case 110 -> -1496056504;
                case 111 -> -1323091195;
                case 112 -> -128847779;
                case 113 -> 124818249;
                case 114 -> 682879239;
                case 115 -> -1972788327;
                case 116 -> 1653783300;
                case 117 -> -788957745;
                case 118 -> 1675909606;
                case 119 -> 1043526491;
                case 120 -> 248788659;
                case 121 -> 1096102556;
                case 122 -> 1455737912;
                case 123 -> 1671429792;
                case 124 -> 333015661;
                case 125 -> -1147126844;
                case 126 -> 400857888;
                case 127 -> 744281355;
                case 128 -> 2140707732;
                case 129 -> 123368062;
                case 130 -> -568491822;
                case 131 -> -1309328400;
                case 132 -> 1327879907;
                case 133 -> -1979579765;
                case 134 -> -1597699781;
                case 135 -> -1810671703;
                case 136 -> -455004271;
                case 137 -> -1353066585;
                case 138 -> 515367888;
                case 139 -> 132288879;
                case 140 -> -395914901;
                case 141 -> 2063750616;
                case 142 -> 1337796836;
                case 143 -> 671790968;
                case 144 -> 1829511437;
                case 145 -> 1668216727;
                case 146 -> 1089418101;
                case 147 -> -1789538918;
                case 148 -> -325673378;
                case 149 -> 1168895318;
                case 150 -> -1246058170;
                case 151 -> 2085959886;
                case 152 -> -108119800;
                case 153 -> -1760365079;
                case 154 -> 584819155;
                case 155 -> -226420746;
                case 156 -> -2141825966;
                case 157 -> -1774260173;
                case 158 -> 1925984593;
                case 159 -> -1885931244;
                case 160 -> 1297457371;
                case 161 -> -2088631516;
                case 162 -> -1432960655;
                case 163 -> -861187654;
                case 164 -> 975604351;
                case 165 -> 1125791866;
                case 166 -> -567154211;
                case 167 -> 1270042284;
                case 168 -> -1857096935;
                case 169 -> -459475914;
                case 170 -> -1011694691;
                case 171 -> -561842066;
                case 172 -> -1332259264;
                case 173 -> -1814973238;
                case 174 -> -1476533357;
                case 175 -> 1033221722;
                case 176 -> -754537238;
                case 177 -> 1673062002;
                case 178 -> 225344855;
                case 179 -> -1951030379;
                case 180 -> -435577669;
                case 181 -> 755225494;
                case 182 -> 141445429;
                case 183 -> 1442339253;
                case 184 -> -425666518;
                case 185 -> -1710297313;
                case 186 -> -1502591326;
                case 187 -> -305264292;
                case 188 -> 349940705;
                case 189 -> 868220743;
                case 190 -> -1402248625;
                case 191 -> 524949835;
                case 192 -> 1117855002;
                case 193 -> 1488841332;
                case 194 -> -1844337926;
                case 195 -> 513447998;
                case 196 -> 538652553;
                case 197 -> 59780464;
                case 198 -> 1372807946;
                case 199 -> 1997944073;
                case 200 -> 20779765;
                case 201 -> -258980766;
                case 202 -> -360335327;
                case 203 -> 312385552;
                case 204 -> -1776916035;
                case 205 -> 1651996591;
                case 206 -> -243395864;
                case 207 -> -2087750660;
                case 208 -> 808641401;
                case 209 -> -2013796762;
                case 210 -> 1919197911;
                case 211 -> 1682966832;
                case 212 -> -1016674628;
                case 213 -> 1987561662;
                case 214 -> 1747073581;
                case 215 -> 1344334023;
                case 216 -> -44152656;
                case 217 -> 703735545;
                case 218 -> 526746899;
                case 219 -> 119775140;
                case 220 -> -833702265;
                case 221 -> -529491048;
                case 222 -> -897127483;
                case 223 -> 908477663;
                case 224 -> 461754282;
                case 225 -> 482725454;
                case 226 -> -414090867;
                case 227 -> -139860164;
                case 228 -> 864346057;
                case 229 -> 1214825490;
                case 230 -> -190148760;
                case 231 -> -114445403;
                case 232 -> -266703175;
                case 233 -> 1003302641;
                case 234 -> 1870219108;
                case 235 -> -1539405462;
                case 236 -> 1187420850;
                case 237 -> 1469403828;
                case 238 -> 1858718170;
                case 239 -> 1214599105;
                case 240 -> -1209832360;
                case 241 -> -2084683060;
                case 242 -> 1043854635;
                case 243 -> -133412943;
                case 244 -> -1966358117;
                case 245 -> -1800440664;
                case 246 -> 1987063293;
                case 247 -> 689315653;
                case 248 -> -707750266;
                case 249 -> -1121785976;
                case 250 -> -1253303551;
                case 251 -> -1469609076;
                case 252 -> -847917370;
                case 253 -> -680821834;
                case 254 -> -721634348;
                case 255 -> -1471239841;
                default -> -328415518;
            });
        } while (v2 != 296);
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
            Object[] objectArray = new Object[15];
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

    private int OOo(CommandContext param1) {
        List<Command> v2 = ((CommandsCommand)param1.getSource()).Iii0().stream().filter(Command::Oiio).toList();
        StringBuilder v3 = new StringBuilder();
        v3.append("{gray}===== {aqua}Clap Commands {gray}=====\n");
        for (Command v5 : v2) {
            v3.append("{aqua}.").append(v5.iooi()).append(" {gray}- ").append(v5.Oii0()).append("\n");
        }
        v3.append("{gray}===============================");
        RenderSupport_ooi_0.HelpCommand((Text)NetworkSupport_io0_0.HelpCommand(v3.toString(), new Object[0]), "help");
        return this.ConfigSupport_oii0_1();
    }
}

