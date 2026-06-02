/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandExceptionType
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 */
package clap.command.argument;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.config.ConfigSupport_O0I;
import clap.command.Command;
import skidonion.loader.0ooo;

public class ArgumentType_0OIO
implements ArgumentType,
CommandExceptionType {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    public Command ConfigSupport_oooi_3(StringReader param1) throws CommandSyntaxException {
        String v2 = param1.readString().toLowerCase();
        for (String v4 : 0ooo.0IIi().IiiO()) {
            if (!v2.equalsIgnoreCase(v4)) continue;
            return 0ooo.0IiO().IiIi(v4);
        }
        throw ConfigSupport_O0I.PacketEvent("Invalid command", new Object[0]).createWithContext((ImmutableStringReader)param1);
    }

    public static Command OoOi(CommandContext param0, String param1) {
        return (Command)param0.getArgument(param1, Command.class);
    }

    public CompletableFuture listSuggestions(CommandContext param1, SuggestionsBuilder param2) {
        String v3 = param2.getRemainingLowerCase();
        Iterator v4 = 0ooo.0Ii0().IiiO().iterator();
        while (v4.hasNext()) {
            String v5 = (String)v4.next();
            String v6 = v5.toLowerCase();
            if (!v6.startsWith(v3)) continue;
            param2.suggest(v6);
        }
        return param2.buildFuture();
    }

    public static ArgumentType_0OIO Oo0O() {
        return new ArgumentType_0OIO();
    }

    static {
        __k__gH4it = ArgumentType_0OIO.__k__gH4it((long)1213484390714174993L);
        __rP__gH4it0 = new String[]{"\ua0d9\u8b9b\u55cf \u87f5\ua953\u3413\u56a3\ua1c7\u8af1", "\ua0db\u8b99\u55c9&\u87f7\ua951\u341d\u56ad\ua1c5\u8af3", "\ua0c9\u8b8a\u55cf\\\u87f5\ua954\u3406", "\ua0cc\u8b97\u55cf]\u87fc"};
        __rP__gH4it1 = new String[]{"\ua0d9\u8b82\u55de"};
        __rP__gH4it2 = new String[]{"\ua0cf\u8b90\u55ccM\u8795\ua90c\u3402\u5690\ua023\u8aa6\u54a4\u0109\u861b\ua816\u3528\u57d3\ua11f\u858c\u5b81\u0e35"};
        __rP__gH4it3 = new String[]{"\ua0ef\u8b9f\u55d7~\u871f\ua9cc\u344f\u57f9\ua1fc\u8a73\u5485\u0197\u86ea\ua848\u35ae\u5705\uae2d\u855b\u5b8c\u0eb8\u8986\ua700\u3a94\u5809\uaf22\u8426\u5af1\u0fd3\u8812\ua68d\u3b12\u59a7\uac28\u87cf\u59c1\u0c2b\u8b16\ua5fc\u3845\u5a69\uad61\u8683\u584c\u0d42\u8a2a\ua4c3\u3963\u5ba7\uadc8\u813e\u5f5c\u0a9c\u8d6a\ua3e9\u3e2a\u5ca5", "\ua0a0\u8b21\u55ba\u0091\u8719\ua986\u3451\u560b"};
        byte[] v0 = "L\"`\u00f4\u00e1\u00daV\u009eW\u00c6:\u0015\u001c&\u008f\u009a\u00be\u0096\u000b\u00c2Hf\u00bd\u009e\u00b9\u00e3~\u00a1\u00d4\u00f3#(\u00ab\u0012VA\u00c8\u008a|\u00ee\u00eaV\u00d3 \u00fc\u008d\"\u0018\u00bb\u00d3\u00bb\u00c6D\u00afc\u0012".getBytes("ISO_8859_1");
        Object[] v1 = "1\u00ea;\u00e9\u00d5\u00eev\u009e".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 516792731;
                case 1 -> 946940602;
                case 2 -> -896612649;
                case 3 -> 669156621;
                case 4 -> 1197342264;
                case 5 -> 1565950140;
                case 6 -> 848045998;
                case 7 -> -948618515;
                case 8 -> 207922171;
                case 9 -> -8563559;
                case 10 -> 948423704;
                case 11 -> -640729004;
                case 12 -> -1928144120;
                case 13 -> 626113307;
                case 14 -> -2023805040;
                case 15 -> -1571532369;
                case 16 -> 678233473;
                case 17 -> -397233713;
                case 18 -> -1139575113;
                case 19 -> 19298067;
                case 20 -> 1216155296;
                case 21 -> 484214853;
                case 22 -> 1005191700;
                case 23 -> 86219685;
                case 24 -> 1016360088;
                case 25 -> 2120216181;
                case 26 -> -1431528770;
                case 27 -> 65899736;
                case 28 -> -1796016397;
                case 29 -> -164034798;
                case 30 -> -1141423792;
                case 31 -> 1458314505;
                case 32 -> 2006595842;
                case 33 -> -1971353446;
                case 34 -> -857866247;
                case 35 -> -1358928288;
                case 36 -> 678115538;
                case 37 -> -1100885082;
                case 38 -> -954921047;
                case 39 -> -526693378;
                case 40 -> -400116062;
                case 41 -> 1814721389;
                case 42 -> 1483360961;
                case 43 -> 911785503;
                case 44 -> 751202292;
                case 45 -> -1288663760;
                case 46 -> -1593392113;
                case 47 -> -1805353130;
                case 48 -> 2082986923;
                case 49 -> -1628893318;
                case 50 -> 2094787672;
                case 51 -> -905693329;
                case 52 -> 912750842;
                case 53 -> -380125568;
                case 54 -> 1494197674;
                case 55 -> 1408120836;
                case 56 -> -640312477;
                case 57 -> 930902120;
                case 58 -> -1049679495;
                case 59 -> -120370842;
                case 60 -> -1654895187;
                case 61 -> -1958083786;
                case 62 -> 606646659;
                case 63 -> 888483879;
                case 64 -> 700433521;
                case 65 -> 1501164274;
                case 66 -> -1618465611;
                case 67 -> 1896545407;
                case 68 -> 614033225;
                case 69 -> -1016558698;
                case 70 -> 1987281526;
                case 71 -> -816891659;
                case 72 -> -1282968107;
                case 73 -> 1129522416;
                case 74 -> 958869004;
                case 75 -> -1365019220;
                case 76 -> 151633887;
                case 77 -> -1793923102;
                case 78 -> 8139420;
                case 79 -> 1383592635;
                case 80 -> 19273380;
                case 81 -> -1811678423;
                case 82 -> -955472718;
                case 83 -> -841135692;
                case 84 -> 1215647021;
                case 85 -> 24259041;
                case 86 -> -182690072;
                case 87 -> -65974240;
                case 88 -> 384037513;
                case 89 -> -622766276;
                case 90 -> 1585417232;
                case 91 -> 137867804;
                case 92 -> 780151515;
                case 93 -> -702983732;
                case 94 -> 85012370;
                case 95 -> -1946032634;
                case 96 -> 811617892;
                case 97 -> 1463934877;
                case 98 -> -85476314;
                case 99 -> 1494319144;
                case 100 -> -62640138;
                case 101 -> 1825901617;
                case 102 -> 1301706893;
                case 103 -> 2115701810;
                case 104 -> 1565336081;
                case 105 -> 184230638;
                case 106 -> 1269712151;
                case 107 -> 1719593019;
                case 108 -> -850970560;
                case 109 -> 1967440494;
                case 110 -> 261677669;
                case 111 -> 611374106;
                case 112 -> 1254117967;
                case 113 -> -403893662;
                case 114 -> -1558843593;
                case 115 -> 303964555;
                case 116 -> -1294998945;
                case 117 -> -1709770933;
                case 118 -> 1699817780;
                case 119 -> 953010282;
                case 120 -> -2143517107;
                case 121 -> -300562521;
                case 122 -> -2030193458;
                case 123 -> 83150521;
                case 124 -> 1557850658;
                case 125 -> 1963128265;
                case 126 -> 1415210638;
                case 127 -> 518816191;
                case 128 -> 1507034174;
                case 129 -> -2065197474;
                case 130 -> -792764860;
                case 131 -> 547363898;
                case 132 -> -1909254526;
                case 133 -> -841363911;
                case 134 -> -1969917700;
                case 135 -> -597621462;
                case 136 -> 319038251;
                case 137 -> 937130717;
                case 138 -> -40099100;
                case 139 -> -10350033;
                case 140 -> 124627307;
                case 141 -> -1840730924;
                case 142 -> -865385458;
                case 143 -> -1101267600;
                case 144 -> 1211485907;
                case 145 -> 1132054814;
                case 146 -> 1298751173;
                case 147 -> -1814748450;
                case 148 -> -1966248314;
                case 149 -> 1294362969;
                case 150 -> -1690270072;
                case 151 -> -1062095028;
                case 152 -> 1861456086;
                case 153 -> 223557775;
                case 154 -> -1854974569;
                case 155 -> -2007959405;
                case 156 -> 424563052;
                case 157 -> 627475624;
                case 158 -> -483653859;
                case 159 -> 214889952;
                case 160 -> -414664512;
                case 161 -> -1230752077;
                case 162 -> 430704870;
                case 163 -> 894038489;
                case 164 -> -1889827000;
                case 165 -> -1777640076;
                case 166 -> -1891472505;
                case 167 -> 1384486364;
                case 168 -> 1927349825;
                case 169 -> 1989971989;
                case 170 -> 49028097;
                case 171 -> -449487125;
                case 172 -> 1441940992;
                case 173 -> 565298254;
                case 174 -> -1140274644;
                case 175 -> 1339752386;
                case 176 -> 281964676;
                case 177 -> 1317365619;
                case 178 -> 1147914951;
                case 179 -> -1547917522;
                case 180 -> -214757837;
                case 181 -> 1032836586;
                case 182 -> -538937148;
                case 183 -> -1740477972;
                case 184 -> 1997958794;
                case 185 -> -146835375;
                case 186 -> 1072817761;
                case 187 -> 88682388;
                case 188 -> -475823387;
                case 189 -> -1862194529;
                case 190 -> -1451374353;
                case 191 -> -1897075457;
                case 192 -> -1519853370;
                case 193 -> -1663848131;
                case 194 -> 1133966426;
                case 195 -> 724767242;
                case 196 -> 1268961046;
                case 197 -> 1878677853;
                case 198 -> -2068058244;
                case 199 -> -1827052989;
                case 200 -> 1453487957;
                case 201 -> 437262885;
                case 202 -> 1621773378;
                case 203 -> -937644623;
                case 204 -> -1093491118;
                case 205 -> 670941219;
                case 206 -> -1369445128;
                case 207 -> -1869735049;
                case 208 -> 1761394083;
                case 209 -> -345307174;
                case 210 -> 929516940;
                case 211 -> 256179467;
                case 212 -> -1854487694;
                case 213 -> 1349231942;
                case 214 -> 2140964900;
                case 215 -> -2119802806;
                case 216 -> -1358061337;
                case 217 -> -39409968;
                case 218 -> -613636706;
                case 219 -> 1222296709;
                case 220 -> -435353398;
                case 221 -> -800610696;
                case 222 -> 577331579;
                case 223 -> -207764227;
                case 224 -> -34040175;
                case 225 -> -772879455;
                case 226 -> -1054367818;
                case 227 -> 1016760041;
                case 228 -> -274718032;
                case 229 -> -1261603202;
                case 230 -> 805242595;
                case 231 -> 1224951559;
                case 232 -> -1217180841;
                case 233 -> 778772861;
                case 234 -> -1197108900;
                case 235 -> -1019128749;
                case 236 -> -1349073423;
                case 237 -> 1164896615;
                case 238 -> -754310329;
                case 239 -> 1233012997;
                case 240 -> -2139102013;
                case 241 -> -1216374219;
                case 242 -> 1451051011;
                case 243 -> -1768003637;
                case 244 -> -872320568;
                case 245 -> -82487147;
                case 246 -> -412630721;
                case 247 -> -1991291359;
                case 248 -> 1342098537;
                case 249 -> 1530213913;
                case 250 -> -809332275;
                case 251 -> -414349379;
                case 252 -> -106377263;
                case 253 -> 566250424;
                case 254 -> 964464375;
                case 255 -> 1446415451;
                default -> -2105927292;
            });
        } while (v2 != 56);
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
            Object[] objectArray = new Object[1];
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

