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
 * Renamed from clap.render.RenderSupport_ooi_1
 */
public class FriendCommand
extends Command {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public void PacketEvent(LiteralArgumentBuilder param12) {
        ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)param12.then(FriendCommand.ConfigSupport_0OOO("list").executes(param1 -> {
            List v2 = 0ooo.SettingContainer().OIo0();
            if (v2.isEmpty()) {
                return this.OiIO("You have no friends :(", new Object[0]);
            }
            StringJoiner v3 = new StringJoiner(",");
            Objects.requireNonNull(v3);
            v2.forEach(v3::add);
            return this.OiIO("Friends (%s): %s", v2.size(), v3);
        }))).then(FriendCommand.ConfigSupport_0OOO("clear").executes(param1 -> {
            0ooo.ooo().OIo0().clear();
            return this.OiIO("Cleared friends list", new Object[0]);
        }))).then(FriendCommand.ConfigSupport_0OOO("add").then(FriendCommand.RenderSupport_0OO0("username", (ArgumentType)StringArgumentType.word()).executes(param1 -> {
            String v2 = StringArgumentType.getString((CommandContext)param1, (String)"username");
            if (0ooo.NetworkSupport_o0o_0().OI0o(v2)) {
                return this.OiIO("{green} %s {reset} is already on your friends list.", v2);
            }
            0ooo.o0I().OI0i(v2);
            return this.OiIO("Added {green} %s {reset} to your friends list", v2);
        })))).then(FriendCommand.ConfigSupport_0OOO("remove").then(FriendCommand.RenderSupport_0OO0("username", (ArgumentType)StringArgumentType.word()).executes(param1 -> {
            String v2 = StringArgumentType.getString((CommandContext)param1, (String)"username");
            if (!0ooo.RenderSupport_ooo_0().OI0o(v2)) {
                return this.OiIO("{green} %s {reset} is not on your friends list.", v2);
            }
            0ooo.oo0().OIoO(v2);
            return this.OiIO("Removed {green} %s {reset} from your friends list", v2);
        })));
    }

    public FriendCommand() {
        super("friend", "friends", "f");
        this.OiiO("Manages your friends list");
    }

    static {
        __k__gH4it = FriendCommand.__k__gH4it(8177702092274658833L);
        __rP__gH4it0 = new String[]{"\u4af1\ua2fd\u7c22\u29e7\uaeff\u339a\ua0d8\u8048\ub5ed\u5dfb\u833a\ud693\u5181\u3280\ua1f2\u817b\ub4e1\u5c21\u822f\ud7df", "\u4af2\ua2fa\u7c21\u29f7\uae96"};
        __rP__gH4it1 = new String[]{"\u4af7\ua2e3\u7c21\u29f2\uae9f\u33fe\ua0bc"};
        __rP__gH4it2 = new String[]{"\u4ae5\ua2f0\u7c27\u2988\uae9d\u33fb\ua0b7\u8049\ub5eb\u5d8a", "\u4ae7\ua2e7\u7c38"};
        __rP__gH4it3 = new String[]{"\u4b0d\ua2a6\u7cb6\u29a5\uaef6\ucc30\u5fcd\u7fef\u4a5a\u5db0\u8363\ud634\u5150\u3381\ua0dc\u80ed\ub53c\u5c5c\u8214\ud722\u5055\u328b\ua1b9\u81d7\ub496\u5fe8\u8179\ud4e9\u538d\u31f1\ua24f\u82dc\ub715\u5fdc\u80ec\ud506\u529c\u3004\ua3fa\u83b9\ub647\u5e1e\u8741\ud2f2\u553f\u37bf\ua40d\u8499\ub14f\u5917\u8640\ud38c\u5423\u361a\ua505\u8524\ub024\u58c0\u851c\ud062\u5747\u35a8\ua66d\u8638\ub36d\u5be3\u857f\ud16b\u56ce\u3421\ua77d\u8783\ub2c4\u5afd\u8459\ude24\u59f2\u3bf3\ua807\u8827\ubd1c\u551e\u8b49\udf8a\u58e0\u3ae5\ua948\u89aa\ubcc9\u546b\u8a96\udc8a\u5b10\u399e\uaa58\u8aa9\ubf5a\u57f5\u89d5\udc46\u5a92\u38fc\uab5d\u8b4c\ube66\u56df\u8894\uddde\u5d72\u3f90\uac28\u8ca5\ub9aa\u5116\u8ff6\udafc\u5c54\u3ead\uad45\u8d24\ub8d6\u50cf\u8e0c\udbf5\u5f4d\u3d6e\uae3c\u8e77\ubbe4\u53f3\u8dd6\ud851\u5f66\u3cf8\uaf82\u8fe8\uba56\u520b\u8c83\ud951\u5ef7\u2337\ub01c\u9034\ua529\u4dd7\u93cc\uc62c\u4198\u222e\ub1c4\u91f0\ua417\u4c02\u92fe\uc704\u40f9\u2118\ub2cf\u92bf\ua7af\u4f04\u91d4\uc490\u43df\u21ad\ub3e8\u93fe\ua6fb\u4e81\u9075\uc5e2\u42f2\u2008\ub424\u947d\ua116\u49c8\u9716\uc203\u45e1\u27bf\ub593\u95f7\ua019\u4885\u96fa\uc39d\u449f\u26e1\ub69f\u963b\ua3a5\u4b71\u95f5\uc0e2\u4735\u25a3\ub61e\u9731\ua255\u4a2f\u943b\uc13c\u4654\u24fa\ub7da\u985a\uad6c\u45fd\u9b1d\uce75\u4911\u2bf6\ub8ab\u99db\uac50\u441b\u9a44\ucf34\u4894\u2a62\ub9c9\u994d\uaf79\u4765\u99bd\uccb2\u4bd5\u29fd\uba71\u9a5e\uae90\u46bd\u98ef\ucde7\u4a07\u28f2\ubbc5\u9bd3\ua96c\u4158\u9fea\uca57\u4df9\u2fbe\ubc8e\u9c18\ua8c0\u405e\u9e19\ucbda\u4c4c\u2ea5\ubdf3\u9d48\ua8c8\u4331\u9dbc\uc8d7\u4fd8\u2d49\ube7e\u9e34\uab11\u423d\u9c13\uc927\u4e8a\u2c28\ubf2b\u9f88\uaa3c\u7d54\ua344\uf666\u71e6\u1387\u809f\ua0bd\u9583\u7c9e\ua2cf\uf7b3\u70dd\u121d\u814b\ua180\u9418\u7c88\ua1bf\uf4fc\u7365\u1103\u8271\ua239\u9731\u7fda\ua09b\uf5ef\u72c4\u10ac\u8305\ua327\u9664\u7e94\ua7ae\uf24f\u75c0\u1732\u841e\ua42e\u9118\u7929\ua63c\uf38c\u74df\u16b9\u85de\ua538\u9082\u7884\ua6ab\uf02c\u7752\u15fd\u8623\ua694\u9355\u7b62\ua5be\uf1bc\u76be\u14d5\u870f\ua71a\u92c9\u7a81\ua46d\ufe69\u79ab\u1b18\u8862\ua8f3\u9dc1\u75d1\uabe3\uff0c\u78a8\u1ad2\u89fe\ua9ac\u9c9c\u749a\uaa21\uff0d\u7bf2\u19a0\u8ac3\uaa7f\u9f97\u7796\ua97a\ufc22\u7a0c\u1858\u8bcc\uabf0\u9e41\u76b3\ua8a1\ufd36\u7d94\u1f08\u8c03\uac90\u9932\u71c6\uaf07\ufa37\u7c77\u1e4d\u8d8b\uadb0", "\u4ae7\ua2f2\u7c21\u298e\uae9f\u33f9\ua0a9\u8057\ub5e9\u5d88", "\u4aa1\ua2ac\u7c8e\u296b\uaef5\u3353\ua0ee\u800e"};
        byte[] v0 = "(\u008eW\u00fd\u00dax\u00c6\u0018w\u0090\u008adt\u00c1\u00df\u0002\td\u00e5ji\u00d3\u00a20\u00ab\u00d8\u0080\u00a9\u00b9\u00a1\\C\u0010\u0014->\u0090\u00ac\u00d1.J\u00de\u0088\u00c2;\u001f.\u0016Z\u00cf\u0091\u00a4?\u00a2>\u00a39\u0010\u00c5BS\u0018^\u0087\b\u000b^s\u00a2\u00a9\u00b64\u00a9\u001dp4\u0096s\u00c4\u0088i\u00e6x\u0082\u009c}\u0093\r\u00b4\u009b\u00af\u008ad\u000e\u008b\u00f6\u001f}\u00d4\u00be\u00de\u0014\u00b6\u001b+_\u009d.6p\u00cb\u00ea\u00ff\u008e\u00e7\u0014\bU\u00bec\u008b_\u0015\u0015\u0019\u009e\u00cf\bA[\u00b7\u0089\u00ca0\t\u009f\u00fb\u00ab\u00ea\u0081S\u00f7\u009f[\u009co\u00bd\u00e4$\u00f6_\u0097\u00aa\u00b2\u0087\u00c4M\u00c8\\\u00a0*L\u0095(S\u0085C\u00e9v\u00c1<Rv(\u0087r\u0083\u0090G\u00ab}\u0087(\u00f0\u0084\u00d5\u00a3=\u000b\u00d1,\u0004@\u0019Tz\u00d9\u00abU\u0006\u00b8O\u0092\u00ac\u00b0\u00fa\u0099u\u0099\u0085\u00ac\u00fd\u00ed\u00ee\u00f0\u00fc\u00adk\u00fd\u00b4`r\u009a\u0092\u00bcm<\u00ca\u0019\u0095\u001a\u0089]\u00bdf\u0097\u00c3\u0092\u00a6\u001c\u00b9@{?%\u00c6\u00f5\u00df\u001dN\u0080\u00ba\u0098\u00d5\u0080\u00b7\u00ed\u0019]\u008f\u00f4\u0001u\u00c3<\u001d\u00faw\u00aeh(g\tl\u00b5.\u00da\u00df\u0084Z\u00be\u00ae6\u00f3\u00e9MX\u001f\u001d@~\u00c4i\u00abZ\u00ae<\u001aR\u00df\u00c0\f&\u00a8qL\u007fg\u00dc\u008a%\u00a9\u0005\u00f9\u00e5\u00ac\u00cb\t\u00ed\u0087\u00e7l\u008a4>u\u00e8#8\u0082\u0097\u00ac\u00daU\u00cc\u00b5\u00bcy\\a\u00d7\u0080\u00b9T\u00bc!\u00da\f\u00dcB-\u00f3\u00d9\u0012 \u00f5\u00beH((\u00da\u0016s\u00d2H\u00b8/\u00bf\u0014+\u00b0\u00de\u00c8\u00f0\u00f8\u00d7oV\u001e\u00d7#\u00bdx\u00cf".getBytes("ISO_8859_1");
        Object[] v1 = "\u000e\n\u00e1\u00b9S\u008dsc".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1084241347;
                case 1 -> 1043654795;
                case 2 -> 1199082908;
                case 3 -> 56658393;
                case 4 -> 874884330;
                case 5 -> -315539934;
                case 6 -> -624652739;
                case 7 -> 270780261;
                case 8 -> -692586269;
                case 9 -> -1269183742;
                case 10 -> 2059130786;
                case 11 -> 1735662922;
                case 12 -> 890760591;
                case 13 -> -1152800397;
                case 14 -> -1903965781;
                case 15 -> -382974126;
                case 16 -> 1688953393;
                case 17 -> -1665041961;
                case 18 -> -824170673;
                case 19 -> -1221103112;
                case 20 -> 1163377024;
                case 21 -> -284433887;
                case 22 -> -1711396004;
                case 23 -> -2053979262;
                case 24 -> 572288863;
                case 25 -> -1317730185;
                case 26 -> 462401848;
                case 27 -> 877415862;
                case 28 -> 1064280741;
                case 29 -> 1353674306;
                case 30 -> 98086321;
                case 31 -> -1354267769;
                case 32 -> -1947466932;
                case 33 -> -660270570;
                case 34 -> -2084542681;
                case 35 -> 1097703953;
                case 36 -> -1862225230;
                case 37 -> 215725807;
                case 38 -> -149217935;
                case 39 -> 1383247080;
                case 40 -> -1823940923;
                case 41 -> -578833639;
                case 42 -> -931653134;
                case 43 -> 1035851021;
                case 44 -> -969259155;
                case 45 -> -426196507;
                case 46 -> 34299009;
                case 47 -> 277777927;
                case 48 -> 439804661;
                case 49 -> -48199235;
                case 50 -> 352934641;
                case 51 -> 1667600976;
                case 52 -> -1610660207;
                case 53 -> -353697764;
                case 54 -> 591296467;
                case 55 -> -1320450124;
                case 56 -> -1236751151;
                case 57 -> 1254934998;
                case 58 -> -1928118496;
                case 59 -> -318424522;
                case 60 -> 1058182798;
                case 61 -> 1785474340;
                case 62 -> -1580628631;
                case 63 -> 719286727;
                case 64 -> 1334147479;
                case 65 -> 1659724641;
                case 66 -> -473045760;
                case 67 -> -205858554;
                case 68 -> 535097768;
                case 69 -> 1970484584;
                case 70 -> -792962620;
                case 71 -> -844979264;
                case 72 -> 917856237;
                case 73 -> -1602668098;
                case 74 -> -345124365;
                case 75 -> 767471657;
                case 76 -> -1143079138;
                case 77 -> 1469920670;
                case 78 -> -2125460876;
                case 79 -> -115571792;
                case 80 -> -1148334980;
                case 81 -> 213999836;
                case 82 -> 1520964919;
                case 83 -> -203928916;
                case 84 -> -1506097320;
                case 85 -> -1748399552;
                case 86 -> -93110563;
                case 87 -> -1562269747;
                case 88 -> 544761877;
                case 89 -> -1915652177;
                case 90 -> -39760381;
                case 91 -> -1171380153;
                case 92 -> -472158891;
                case 93 -> -774183254;
                case 94 -> 1973310143;
                case 95 -> -505052923;
                case 96 -> 116273770;
                case 97 -> 1809189709;
                case 98 -> 651259162;
                case 99 -> 1999764010;
                case 100 -> 244990809;
                case 101 -> 1473217867;
                case 102 -> 1947814805;
                case 103 -> -1558075481;
                case 104 -> 346093915;
                case 105 -> 574294943;
                case 106 -> 2074497788;
                case 107 -> 1235968779;
                case 108 -> -1912200240;
                case 109 -> -402496630;
                case 110 -> -1155688582;
                case 111 -> -1498113384;
                case 112 -> -1628625272;
                case 113 -> -1787539850;
                case 114 -> 669988815;
                case 115 -> 220419771;
                case 116 -> -795206013;
                case 117 -> -291009382;
                case 118 -> 1753064140;
                case 119 -> -421908629;
                case 120 -> -1622290866;
                case 121 -> 849486739;
                case 122 -> 442165551;
                case 123 -> 1915878932;
                case 124 -> -104038584;
                case 125 -> -1193969821;
                case 126 -> 1555838209;
                case 127 -> -1805681458;
                case 128 -> 281877307;
                case 129 -> 847510571;
                case 130 -> 731043220;
                case 131 -> -1636748536;
                case 132 -> -359721218;
                case 133 -> -1213368838;
                case 134 -> 717073785;
                case 135 -> -428582883;
                case 136 -> 464191763;
                case 137 -> 896212653;
                case 138 -> -121839506;
                case 139 -> 1310033636;
                case 140 -> -484780777;
                case 141 -> 1920281025;
                case 142 -> -662897532;
                case 143 -> 368864244;
                case 144 -> 565462868;
                case 145 -> -1306564801;
                case 146 -> -915533124;
                case 147 -> -277882484;
                case 148 -> 1042334482;
                case 149 -> 246618091;
                case 150 -> -9538039;
                case 151 -> -20852026;
                case 152 -> -754722158;
                case 153 -> 1038623418;
                case 154 -> 274207200;
                case 155 -> 920225433;
                case 156 -> -289785949;
                case 157 -> 1705001768;
                case 158 -> 1182432923;
                case 159 -> 187387061;
                case 160 -> -265783458;
                case 161 -> -2010453047;
                case 162 -> -180654833;
                case 163 -> 936188123;
                case 164 -> 2075290086;
                case 165 -> 1988155610;
                case 166 -> -1028001898;
                case 167 -> 1096284996;
                case 168 -> 1139318358;
                case 169 -> 5416764;
                case 170 -> -571951422;
                case 171 -> 640521953;
                case 172 -> 738413410;
                case 173 -> -1514804267;
                case 174 -> -2023857355;
                case 175 -> -2101168641;
                case 176 -> -1407263642;
                case 177 -> -2131721358;
                case 178 -> 458911079;
                case 179 -> -2130814999;
                case 180 -> -106970753;
                case 181 -> -1600503718;
                case 182 -> -1871690000;
                case 183 -> 1372514248;
                case 184 -> -1100456202;
                case 185 -> 122228101;
                case 186 -> -1221477913;
                case 187 -> -1911722159;
                case 188 -> -1461381549;
                case 189 -> -293851634;
                case 190 -> 1061991896;
                case 191 -> -1159659282;
                case 192 -> -1298146057;
                case 193 -> 1925141516;
                case 194 -> -585108709;
                case 195 -> -1135435028;
                case 196 -> 340644147;
                case 197 -> 793151076;
                case 198 -> -754109416;
                case 199 -> 1357150113;
                case 200 -> -1033974838;
                case 201 -> -2083511340;
                case 202 -> -2096692896;
                case 203 -> -1190857718;
                case 204 -> 1430245426;
                case 205 -> -928345736;
                case 206 -> -1572655235;
                case 207 -> -2023663546;
                case 208 -> 436134964;
                case 209 -> -695254899;
                case 210 -> -1042643975;
                case 211 -> -1045906653;
                case 212 -> -200296893;
                case 213 -> 1256005801;
                case 214 -> 1588678048;
                case 215 -> 377710264;
                case 216 -> -858390394;
                case 217 -> 1624818429;
                case 218 -> -930363330;
                case 219 -> 60312393;
                case 220 -> -1298943777;
                case 221 -> 641246118;
                case 222 -> 1458344674;
                case 223 -> 2142554967;
                case 224 -> -72993479;
                case 225 -> 279475579;
                case 226 -> 1904909424;
                case 227 -> -1479988363;
                case 228 -> -706774883;
                case 229 -> 1666603054;
                case 230 -> 2098156143;
                case 231 -> 1001281900;
                case 232 -> -2122557638;
                case 233 -> -2092347067;
                case 234 -> 1252320293;
                case 235 -> 2144330783;
                case 236 -> 218349751;
                case 237 -> -277837687;
                case 238 -> -186125820;
                case 239 -> -1793107668;
                case 240 -> 141997613;
                case 241 -> 1917779265;
                case 242 -> 1313801124;
                case 243 -> 660886142;
                case 244 -> 871028403;
                case 245 -> -1222650706;
                case 246 -> 256736550;
                case 247 -> -1253118448;
                case 248 -> 1563310283;
                case 249 -> 1602969949;
                case 250 -> -1533076770;
                case 251 -> -739733200;
                case 252 -> 984394681;
                case 253 -> 969248656;
                case 254 -> -477887022;
                case 255 -> -229047045;
                default -> 884719912;
            });
        } while (v2 != 384);
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
            Object[] objectArray = new Object[17];
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

