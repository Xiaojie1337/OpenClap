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
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.command.Command;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.OoiI
 */
public class ConfigCommand
extends Command {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    private int OOOii(String param1) {
        try {
            if (!0ooo.OIii().OOo(param1)) {
                return this.OiIo("Config '%s' does not exist", param1);
            }
            return this.OiIO("Loaded config {green} %s", 0ooo.NotificationsModule().OoO());
        }
        catch (IllegalArgumentException v2) {
            return this.OiIo(v2.getMessage(), new Object[0]);
        }
    }

    private int OO0OO(String param1) {
        try {
            if (!0ooo.PrefixCommand().O0i(param1)) {
                return this.OiIo("Config '%s' could not be deleted", param1);
            }
            return this.OiIO("Deleted config {green} %s", param1);
        }
        catch (IllegalArgumentException v2) {
            return this.OiIo(v2.getMessage(), new Object[0]);
        }
    }

    public ConfigCommand() {
        super("config", "cfg");
        this.OiiO("Loads and saves named configs");
    }

    @Override
    public void PacketEvent(LiteralArgumentBuilder param12) {
        ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)param12.executes(param1 -> this.OOOi0())).then(ConfigCommand.ConfigSupport_0OOO("list").executes(param1 -> this.OOOio()))).then(((LiteralArgumentBuilder)ConfigCommand.ConfigSupport_0OOO("save").executes(param1 -> this.OOOiI(0ooo.Oi0O().OoO()))).then(ConfigCommand.RenderSupport_0OO0("name", (ArgumentType)StringArgumentType.word()).executes(param1 -> this.OOOiI(StringArgumentType.getString((CommandContext)param1, (String)"name")))))).then(((LiteralArgumentBuilder)ConfigCommand.ConfigSupport_0OOO("load").executes(param1 -> this.OOOii(0ooo.OiOo().OoO()))).then(ConfigCommand.RenderSupport_0OO0("name", (ArgumentType)StringArgumentType.word()).executes(param1 -> this.OOOii(StringArgumentType.getString((CommandContext)param1, (String)"name")))))).then(ConfigCommand.ConfigSupport_0OOO("delete").then(ConfigCommand.RenderSupport_0OO0("name", (ArgumentType)StringArgumentType.word()).executes(param1 -> this.OO0OO(StringArgumentType.getString((CommandContext)param1, (String)"name")))));
    }

    static {
        __k__gH4it = ConfigCommand.__k__gH4it(-5830259943206293999L);
        __rP__gH4it0 = new String[]{"\u8a1d\udf9c\u00c1\u55b1\ud2ee\u32d0\ub088\u03ed", "\u8a67\udf9b\u00f3\u5523\ud2f0\u3254\ub0d8\u0371\u8d49\ud881", "\u8a73\udf96\u00f6\u55b4\ud2a2\u3245\ub087\u0488\u8d6f\ud890\u07ee\u52c0\ud5cc\u354f\ub7bd\u05db\u8c43\ud9aa\u06db\u53ec"};
        __rP__gH4it1 = new String[]{"\u8b9f\udea9\u0164\u5402\ud3c1\u3212\ub085\u031c\u8a30\udff3\u0082\u556b\ud252\u35b3\ub782\u0437\u8d3f\ud886\u07ff\u5259\ud51c\u34d9\ub6f7\u05b8\u8c48\ud94c\u06c4\u53ce\ud405\u3490\ub5e7\u06e3\u8f64\udab4\u050c\u50bc\ud7ba\u3783\ub425\u07b8\u8eaa\udbe8\u04bc\u5144\ud648\u36fb\ubb7e\u08ec\u818b\ud4c3\u0bc6\u5e7b\ud985\u39a7\uba03\u0929\u8088\ud5ca\u0a3b\u5fea\ud83f\u388e\ubaae\u0a84\u83d5\ud633\u09de\u5c87\udbec\u3b72\ub9d5\u0bac\u821f\ud7ae\u0843\u5d99\uda30\u3ab8\ub863\u0c16\u8562\ud07b\u0f13\u5a95\udd55\u3d28\ubf24\u0d4b\u8470\ud12b\u0ec6\u5b47\udcc8\u3cd8\ube67\u0df3\u87fa\ud2d5\u0dda\u58df\udff0\u3f80\ubd5b\u0ec9\u8692\ud304\u0c2d\u591c\ude4a\u3e3a\ubc0c\u0fce\u993b\ucc4c\u130e\u466b\uc1b1\u21d3\ua3e1\u103a\u9832\ucdd8\u126f\u47e2\uc03e\u207e\ua2f1\u1114\u987a\uceac\u1188\u44f2\uc377\u2325\ua128\u124a\u9b59\ucf78\u10a8\u456e\uc26e\u2237\ua0f0\u13c8\u9a4b\uc870\u1754\u4201\uc56d\u256f\ua782\u1431\u9dc5\uc9b2\u16ab\u43ac\uc478\u24ef\ua64b\u15c3\u9ca0\uc95c\u15aa\u40bf\uc7e4\u27c9\ua58f\u1640\u9f3a\uca12\u1482\u41c4\uc62c\u2607\ua45b\u17d8\u9e19\ucbad\u1b17\u4e16\uc936\u29b1\uab6a\u1892\u919c\uc4ea\u1af9\u4fbe\uc817\u2814\uaa6f\u19d1\u9041\uc5c3\u1af7\u4c1f\ucbdf\u2b99\ua92b\u1a3c\u934f\uc663\u193e\u4dc7\uca51\u2ab9\ua8f7\u1b8b\u925c\uc797\u18a7\u4a4a\ucdcc\u2d24\uaffc\u1ccd\u9577\uc09a\u1f9e\u4b7a\ucc48\u2c95\uae08\u1ddf\u949f\uc1ac\u1e1e\u4b36\ucfb9\u2f20\uad48\u1eec\u9782\uc2a9\u1d35\u48db\uce14\u2e24\uac84\u1f40\u9649\uc34b\u1ca6\u4967\uf1ac\u1111\u935b\u2013\ua94e\ufcce\u23a8\u7610\uf16c\u102c\u9298\u21d1\ua8b5\ufdd7\u22d0\u77a7\uf085\u134d\u91fa\u22ba\uabb2\ufec1\u2148\u740c\uf320\u1242\u9088\u23b0\uaa9a\uff32\u2050\u7513\uf246\u157b\u9791\u2434\uadbe\uf868\u27ea\u72d3\uf5a2\u153b\u9606\u258c\uacb6\uf959\u262e\u7361\uf44e\u1446\u9572\u26dd\uafb0\ufa31\u259f\u7061\uf741\u1756\u946e\u27c3\uae71\ufb3a\u2455\u71b2\uf6ac\u160a\u9b5a\u2828\ua1e6\uf473\u2bb4\u7e9f\uf911\u19a8\u9b01\u291d\ua002\uf5db\u2a29\u7f5c\uf823\u1848\u9a7d\u2a90\ua395\uf6ae\u29c1\u7c1b\ufb16\u1b04\u9958\u2b37"};
        __rP__gH4it2 = new String[]{"\u8a65\udfe5\u00cd\u5521\ud2f2\u3252\ub0de\u0373\u8d4b\ud88f", "\u8a75\udf88\u00f5\u55a9\ud2c2\u3221\ub0e3"};
        __rP__gH4it3 = new String[]{"\u8a65\udf80\u00e4", "\u8a70\udf95\u00fd\u55a8\ud2cb"};
        byte[] v0 = "\u00e8\u00ba\u0001\u00d9`\u00d5\u0081\u00fbO\u00e8\u00ef\u00b8\u00ebl\u009e\u00c8X\u0085\u008a\u0092\u00ad\u000e\u00e3O'G\u00b9\r\u008c\u00bf\u00cbl3GI\u0007;\u00a4\u0001?\u00f5\u0013\u00f1\u00f7\u00d1\u00c4Bs\u00cc \u0093\u00d0\u0014\u00907\u00be\u00c7!fI\u00d6\u0081b+\u00e2\u00e0{\u001c\ru\u0011\u000b u\u00ee\n\u00c9\u00a7\u00bf\u00a9E\u00b8\u00a6\u001e\u00a4?\u00f0\u00fc_\u00e0{\u00c4\u0001\u00b7\u008b\u00bc\u00edf_\u00a41\u00e7\u00bf\u008e\u008d\u00bf\u00a0o\u0093E\u00f0\u0091<\u00ef\u009b\u0000`\u00a4\u0015m=s\u00f2\u0081\u00171}{\u008d?m\u00a9Vb\u00ac-\u00a6\u00e3E=Whl\u00b7\u00ac\u00f3\u00a1J\\8\u0016F*9V\u00efq@\u00e7\u00ccw/o\u0084\u00e5n+G\u00e5iO\u00f75\u00b8\u00e7\u00c7\u00de\u00ce\u00c2='\u0006\u00de\u0085S\u0081$\u009d~\u009b#\u00fe\u00f6\u0090\u00d2\u0004\u00be\u001eo\u001b\u00f08\u0013\u00d4(&\u00ab\u00b4\u00fb\u00d4\u0092A\u00bd\u00b3\u00a8\u00fa\u00d8\u00d1\u00a3y\u0001zd\u0010\b\u009f\u001b\u00cd\u00f8\u00c7,+\u001d\u00928(M\u00db\u00f8\u009f\u00ceh\u00b3\u008c\u00fd\u00e6/\u00c4\u00c1\u00e5\u00b5\u00f3\u00c5\u00e3\u0094>\u00c2\u00c4\u00b5|$\u008a\u00fe]\u00cd\u00da%\u00df\u0099\u009d\u0094O\u00fd1%\u00d8\u00f7\u00ac\u0085\u00c3\u00d1c\u0097\u0010+\u0014*\u0003\u00e1\u00aak\u00da\u00cfaVZ\u00ef\u00ca\u00d2\u00d2\u00d8iR\\6\u00d9\u0000\u0019==n\u00bf\u00a9\u0098\u00e9<\u00f8\u00a7\u00cd\u00b25\b\u008c\u00c7\u00c2O\u00b97\u00aaul\u0088\u00ef\u001b\u0084\u0088".getBytes("ISO_8859_1");
        Object[] v1 = "0UB\u00cc%\u00bdb\u00a4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 418919548;
                case 1 -> -1396361795;
                case 2 -> -1984977982;
                case 3 -> -1782411083;
                case 4 -> 2096688039;
                case 5 -> 1777820141;
                case 6 -> -1753845874;
                case 7 -> 713648233;
                case 8 -> 651231712;
                case 9 -> 412015680;
                case 10 -> -1614654137;
                case 11 -> -1630236007;
                case 12 -> 1250200310;
                case 13 -> 1263373110;
                case 14 -> -610710787;
                case 15 -> 1179713646;
                case 16 -> -1843141180;
                case 17 -> 1370639025;
                case 18 -> -1789513839;
                case 19 -> -1001013335;
                case 20 -> 1272866792;
                case 21 -> -768943560;
                case 22 -> 643903089;
                case 23 -> 221799924;
                case 24 -> 131390436;
                case 25 -> -1113261732;
                case 26 -> -1589066495;
                case 27 -> 1056089500;
                case 28 -> -937192545;
                case 29 -> -154706096;
                case 30 -> 2008396737;
                case 31 -> -1321206261;
                case 32 -> -1561210760;
                case 33 -> 575983895;
                case 34 -> 1922327089;
                case 35 -> 72724567;
                case 36 -> 1255063001;
                case 37 -> 600346602;
                case 38 -> -9274906;
                case 39 -> 147223072;
                case 40 -> 729962585;
                case 41 -> 442281845;
                case 42 -> 1085780613;
                case 43 -> -297361386;
                case 44 -> 452651817;
                case 45 -> 1822441558;
                case 46 -> -749920447;
                case 47 -> 18662660;
                case 48 -> 1566964727;
                case 49 -> -859027636;
                case 50 -> -1145667586;
                case 51 -> 1515572570;
                case 52 -> 1661850543;
                case 53 -> -1419515777;
                case 54 -> 181749835;
                case 55 -> -1265418854;
                case 56 -> 344132368;
                case 57 -> 1771917453;
                case 58 -> 801472819;
                case 59 -> 968701675;
                case 60 -> 942388584;
                case 61 -> -1093257373;
                case 62 -> -2067747953;
                case 63 -> -1404492648;
                case 64 -> -506983091;
                case 65 -> 892339938;
                case 66 -> -520932591;
                case 67 -> 341927651;
                case 68 -> 2065093014;
                case 69 -> -1097007102;
                case 70 -> 217398730;
                case 71 -> -716616846;
                case 72 -> -1161711756;
                case 73 -> 510195302;
                case 74 -> 459261827;
                case 75 -> 891037404;
                case 76 -> 1583112276;
                case 77 -> 14510360;
                case 78 -> 1459840070;
                case 79 -> 1472031317;
                case 80 -> 734484375;
                case 81 -> -196469395;
                case 82 -> -1261035740;
                case 83 -> 280690458;
                case 84 -> 938553261;
                case 85 -> 968391082;
                case 86 -> 1157773836;
                case 87 -> -834517108;
                case 88 -> -1291832104;
                case 89 -> 1361139040;
                case 90 -> -992486902;
                case 91 -> -61109349;
                case 92 -> 648000720;
                case 93 -> -765335177;
                case 94 -> 1056956887;
                case 95 -> 1386657061;
                case 96 -> -1329402783;
                case 97 -> 983963839;
                case 98 -> 678326285;
                case 99 -> 1930403257;
                case 100 -> -35010170;
                case 101 -> -758428473;
                case 102 -> -210244895;
                case 103 -> 1956599547;
                case 104 -> -1475227070;
                case 105 -> 1201703560;
                case 106 -> -11313109;
                case 107 -> 2113088271;
                case 108 -> -583015163;
                case 109 -> 1578993663;
                case 110 -> -1249785676;
                case 111 -> 1983463916;
                case 112 -> 1614130514;
                case 113 -> -722216503;
                case 114 -> -1337890136;
                case 115 -> 1293818573;
                case 116 -> -776999202;
                case 117 -> -814050296;
                case 118 -> -777431642;
                case 119 -> 420831744;
                case 120 -> -692513725;
                case 121 -> 1965419456;
                case 122 -> 713088649;
                case 123 -> -1290025003;
                case 124 -> -479355340;
                case 125 -> -104751522;
                case 126 -> -1633458455;
                case 127 -> -558449644;
                case 128 -> -683256174;
                case 129 -> 1321099014;
                case 130 -> 184613067;
                case 131 -> -2985379;
                case 132 -> -86610337;
                case 133 -> -363895986;
                case 134 -> -1018138173;
                case 135 -> -580031187;
                case 136 -> 2099900207;
                case 137 -> -1894328437;
                case 138 -> 59788061;
                case 139 -> -1425773721;
                case 140 -> 450042106;
                case 141 -> -738923746;
                case 142 -> 666844524;
                case 143 -> 849907953;
                case 144 -> -662989330;
                case 145 -> 1886821844;
                case 146 -> 1661353753;
                case 147 -> 1507137185;
                case 148 -> -2001163357;
                case 149 -> 1956548666;
                case 150 -> 1260498655;
                case 151 -> -1430724131;
                case 152 -> 1865403425;
                case 153 -> -1819047845;
                case 154 -> -445669940;
                case 155 -> 234602128;
                case 156 -> -1676991213;
                case 157 -> 1566921791;
                case 158 -> 1155895742;
                case 159 -> 1833843045;
                case 160 -> 1486099517;
                case 161 -> -1781381579;
                case 162 -> 59780305;
                case 163 -> -1198638875;
                case 164 -> 449030870;
                case 165 -> 33851178;
                case 166 -> -1956411001;
                case 167 -> 1564073345;
                case 168 -> 1073191724;
                case 169 -> -555753344;
                case 170 -> -783590568;
                case 171 -> -41069337;
                case 172 -> 956055607;
                case 173 -> 1508753135;
                case 174 -> -1227490061;
                case 175 -> 1631555970;
                case 176 -> -1316844421;
                case 177 -> -1719754802;
                case 178 -> 449184686;
                case 179 -> -1331879696;
                case 180 -> -1927077484;
                case 181 -> 712317602;
                case 182 -> -611705835;
                case 183 -> -83916471;
                case 184 -> -1300372892;
                case 185 -> -1398785789;
                case 186 -> -665637762;
                case 187 -> 1989343954;
                case 188 -> -1944608941;
                case 189 -> -959456249;
                case 190 -> -1031996822;
                case 191 -> 1749229936;
                case 192 -> -863120205;
                case 193 -> 1395084655;
                case 194 -> 1098772793;
                case 195 -> 46364174;
                case 196 -> 1792183238;
                case 197 -> 803163913;
                case 198 -> 1003924663;
                case 199 -> 171336988;
                case 200 -> 1637928313;
                case 201 -> -1578485878;
                case 202 -> -1077778642;
                case 203 -> -1707472208;
                case 204 -> -1787018693;
                case 205 -> 50461944;
                case 206 -> 49643435;
                case 207 -> -178753061;
                case 208 -> 1419047493;
                case 209 -> -456054406;
                case 210 -> -1043882948;
                case 211 -> -498821190;
                case 212 -> 1175597855;
                case 213 -> -1805307147;
                case 214 -> 804994248;
                case 215 -> 1546426186;
                case 216 -> -791265497;
                case 217 -> 1026136764;
                case 218 -> -131291911;
                case 219 -> -2097366922;
                case 220 -> 654181666;
                case 221 -> -426714203;
                case 222 -> -15827182;
                case 223 -> -34186725;
                case 224 -> 1098328763;
                case 225 -> 1418267132;
                case 226 -> -717573517;
                case 227 -> -776412098;
                case 228 -> 1480607272;
                case 229 -> -299391928;
                case 230 -> -910026339;
                case 231 -> -502645948;
                case 232 -> 1451614306;
                case 233 -> 1222183119;
                case 234 -> 1091455670;
                case 235 -> -1970314043;
                case 236 -> -1609519979;
                case 237 -> -1240108124;
                case 238 -> 1800701658;
                case 239 -> 1870484126;
                case 240 -> 1302334758;
                case 241 -> 795253042;
                case 242 -> 1409906866;
                case 243 -> -1688924000;
                case 244 -> 169207147;
                case 245 -> -2052707086;
                case 246 -> -323391533;
                case 247 -> 1614657361;
                case 248 -> -1861799811;
                case 249 -> -1374756424;
                case 250 -> -1851711184;
                case 251 -> 633464964;
                case 252 -> -1164511316;
                case 253 -> 524208719;
                case 254 -> 1100955939;
                case 255 -> 635289747;
                default -> 649563056;
            });
        } while (v2 != 336);
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
            Object[] objectArray = new Object[16];
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

    private int OOOiI(String param1) {
        try {
            0ooo.OiOI().OOi(param1);
            return this.OiIO("Saved config {green} %s", 0ooo.OiOi().OoO());
        }
        catch (IllegalArgumentException v2) {
            return this.OiIo(v2.getMessage(), new Object[0]);
        }
    }

    private int OOOio() {
        List v1 = 0ooo.Oi00().O0o();
        StringJoiner v2 = new StringJoiner(", ");
        Objects.requireNonNull(v2);
        v1.forEach(v2::add);
        return this.OiIO("Configs (%s): %s", v1.size(), v2);
    }

    private int OOOi0() {
        return this.OiIO("Active config: {green} %s {reset}. Use config list/save/load.", 0ooo.GuiSupport_oi0o_2().OoO());
    }
}

