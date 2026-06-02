/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 */
package clap.command.argument;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.security.Key;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.config.ConfigSupport_O0I;

/*
 * Renamed from clap.config.ConfigSupport_0oo0_1
 */
public class ArgumentType_0oo0_2
implements ArgumentType {
    private final Map OooO = new HashMap();
    private final Enum Ooo0;
    static Object Oooo;
    private static volatile /* synthetic */ long __k__gH4it;

    /*
     * Enabled aggressive block sorting
     */
    public Enum Oi00(StringReader param1) throws CommandSyntaxException {
        String v2 = param1.readString();
        for (String v4 : this.OooO.keySet()) {
            if (!v2.equalsIgnoreCase(v4)) continue;
            return (Enum)this.OooO.get(v4);
        }
        if (this.Ooo0 == null) {
            throw ConfigSupport_O0I.PacketEvent("Invalid enum type", new Object[0]).createWithContext((ImmutableStringReader)param1);
        }
        return this.Ooo0;
    }

    public ArgumentType_0oo0_2(Class param1, Enum param2) {
        this.Ooo0 = param2;
        for (Enum v6 : (Enum[])param1.getEnumConstants()) {
            this.OooO.put(v6.toString(), v6);
        }
    }

    static {
        __k__gH4it = ArgumentType_0oo0_2.__k__gH4it((long)8531141054211026449L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[]{"\u63f3\u8519\u5b02\u0ef3\u89a0\ub504\u0fd4\u5944\u62fd\u8463", "\u63e5\u8516\u5b09\u0e8a\u89d0\ub577\u0fad\u595b\u62f9\u8410\u5ae1\u0fce\u88de\ub45d\u0f77\u5a28\u61b5\u870a\u59c4\u0cf2", "\u63f3\u8500\u5b13"};
        __rP__gH4it2 = new String[]{"\u6395\u8516\u5b1a\u0ea2\u89c5\ub563\u0f84\u5984\u6227\u84bb\u5ae0\u0f61\u8814\ub4b8\u0cc9\u5a46\u618c\u8725\u59f5\u0c70\u8b1b\ub7f1\u0d06\u5b25\u60cb\u8666\u58fa\u0d76\u8a69\ub674\u0a8b\u5c05\u674a\u8128\u5f92\u0a0c\u8d36\ub129\u0a21\u5dbc\u668c\u8001\u5ede\u0b85\u8cd6\ub031\u0bc7\u5e46\u6533\u838f\u5d58\u0871\u8fe8\ub381\u0818\u5fa9", "\u63f1\u8507\u5b1c\u0ef1\u89a2\ub502\u0fd2\u5946\u62ff\u846d", "\u63e3\u8504\u5b0a\u0e9b\u89b0\ub517\u0fc9", "\u63e6\u8515\u5b02\u0e96\u89b9"};
        __rP__gH4it3 = new String[]{"\u6374\u85e2\u5b71\u0e68\u89cf\ub52a\u0fa5\u5989"};
        byte[] v0 = "\u001c\u00adX\u001fNNr\u00e8\u0096\u00f8\u00aa\u00d4\u0097\u009d7\"5n\u00a7\u00dd\u0080\u00cc\u00e0Yj5\u00a0\u00d3\u00faAeq\u00e3s0\u0091\u00dd$7\u00f0]bt\u001054\u00d9\u0002\u00ea\u00e4\u00ea\u00fc\u0013\u009c\u001e\u00f5".getBytes("ISO_8859_1");
        Object[] v1 = "\u00cf\u00ab=\u00dbV\u0015E\u00f3".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 23817518;
                case 1 -> -1621611232;
                case 2 -> 1692541774;
                case 3 -> 37601538;
                case 4 -> 152283683;
                case 5 -> -930993413;
                case 6 -> 2081932356;
                case 7 -> -471683302;
                case 8 -> -1647634935;
                case 9 -> -1227641424;
                case 10 -> -87584739;
                case 11 -> -2079771303;
                case 12 -> -101211311;
                case 13 -> -1784326379;
                case 14 -> 701390530;
                case 15 -> 1654215707;
                case 16 -> -492186760;
                case 17 -> -1842473969;
                case 18 -> -153077561;
                case 19 -> 653535638;
                case 20 -> -935263088;
                case 21 -> 2057931833;
                case 22 -> 546218910;
                case 23 -> 920922155;
                case 24 -> 1833051053;
                case 25 -> 614351490;
                case 26 -> -1129969915;
                case 27 -> -1378683444;
                case 28 -> 444618611;
                case 29 -> 1075060667;
                case 30 -> -1052470198;
                case 31 -> 1597235316;
                case 32 -> -947020480;
                case 33 -> -1991931799;
                case 34 -> -429062932;
                case 35 -> -628286584;
                case 36 -> 2103666609;
                case 37 -> 274879564;
                case 38 -> 1895572308;
                case 39 -> 662257177;
                case 40 -> -443438461;
                case 41 -> 1620915223;
                case 42 -> -653262677;
                case 43 -> 2006824748;
                case 44 -> 1682244376;
                case 45 -> 1378965439;
                case 46 -> -1587795767;
                case 47 -> -1557519579;
                case 48 -> 492489761;
                case 49 -> -6851236;
                case 50 -> 2060866738;
                case 51 -> 1698677771;
                case 52 -> -691777535;
                case 53 -> -1174504217;
                case 54 -> 484140687;
                case 55 -> -404782635;
                case 56 -> 719878572;
                case 57 -> -1785887474;
                case 58 -> 899983837;
                case 59 -> -437243916;
                case 60 -> -289036752;
                case 61 -> -1338385671;
                case 62 -> -303980769;
                case 63 -> 349573013;
                case 64 -> -141852563;
                case 65 -> 928328156;
                case 66 -> -1664426819;
                case 67 -> 1898952329;
                case 68 -> -1803615520;
                case 69 -> 1168454070;
                case 70 -> 742832865;
                case 71 -> -1294215168;
                case 72 -> -1971780219;
                case 73 -> 1863811544;
                case 74 -> 117498437;
                case 75 -> -2035376216;
                case 76 -> 946997261;
                case 77 -> 1966677946;
                case 78 -> 954332104;
                case 79 -> 527733592;
                case 80 -> -1097595240;
                case 81 -> -1983699851;
                case 82 -> 761580082;
                case 83 -> 1464612558;
                case 84 -> -1519021980;
                case 85 -> 1611311341;
                case 86 -> 1931159719;
                case 87 -> -2059480578;
                case 88 -> 397375669;
                case 89 -> 1546882961;
                case 90 -> 1753991632;
                case 91 -> -1668012896;
                case 92 -> 1731250952;
                case 93 -> -2064970854;
                case 94 -> 1085285207;
                case 95 -> 1524887827;
                case 96 -> 1472916061;
                case 97 -> -1553471955;
                case 98 -> 1962431554;
                case 99 -> -1566339746;
                case 100 -> -1414926539;
                case 101 -> -1296307469;
                case 102 -> 1411384836;
                case 103 -> -2128809238;
                case 104 -> 1124844242;
                case 105 -> 1952644681;
                case 106 -> -1064874337;
                case 107 -> 1537214149;
                case 108 -> -120947459;
                case 109 -> -1716404085;
                case 110 -> 2054078255;
                case 111 -> -543815701;
                case 112 -> 1467286780;
                case 113 -> 1770963199;
                case 114 -> 581322554;
                case 115 -> 1328174364;
                case 116 -> -1996814273;
                case 117 -> 1828628070;
                case 118 -> -583890906;
                case 119 -> -809826428;
                case 120 -> 463448883;
                case 121 -> 1555879253;
                case 122 -> -1989885321;
                case 123 -> 1534527330;
                case 124 -> -1539792116;
                case 125 -> -73438154;
                case 126 -> -1843560644;
                case 127 -> -1145658269;
                case 128 -> 234196943;
                case 129 -> -2044811946;
                case 130 -> -1783457340;
                case 131 -> -1997091276;
                case 132 -> -716847813;
                case 133 -> 71630545;
                case 134 -> -2055910423;
                case 135 -> 388920583;
                case 136 -> 741400848;
                case 137 -> -909203834;
                case 138 -> 1499292890;
                case 139 -> -1531398650;
                case 140 -> 1826148557;
                case 141 -> 1301552169;
                case 142 -> 1227542124;
                case 143 -> 1048958115;
                case 144 -> -2128465816;
                case 145 -> -691733920;
                case 146 -> 1772026179;
                case 147 -> -252696505;
                case 148 -> 1592402511;
                case 149 -> 959798334;
                case 150 -> 377744290;
                case 151 -> -659454374;
                case 152 -> 620693234;
                case 153 -> 2068929826;
                case 154 -> 1095694070;
                case 155 -> -28787632;
                case 156 -> 679719058;
                case 157 -> 493848956;
                case 158 -> 1552505622;
                case 159 -> 249967882;
                case 160 -> -1564800253;
                case 161 -> 1014260636;
                case 162 -> 2114543327;
                case 163 -> -1410213210;
                case 164 -> 380911222;
                case 165 -> -1371127853;
                case 166 -> -1985310811;
                case 167 -> 1286323670;
                case 168 -> -1020410752;
                case 169 -> -827192169;
                case 170 -> -606320722;
                case 171 -> 1603022632;
                case 172 -> -108521055;
                case 173 -> 609675886;
                case 174 -> 1531553822;
                case 175 -> 1109345042;
                case 176 -> 1426511274;
                case 177 -> -2009622456;
                case 178 -> -212953374;
                case 179 -> -1050481535;
                case 180 -> 136931975;
                case 181 -> -1662121587;
                case 182 -> -501122380;
                case 183 -> -1855052562;
                case 184 -> -1496130446;
                case 185 -> 1164886517;
                case 186 -> -1512977673;
                case 187 -> -1399136620;
                case 188 -> 2106202694;
                case 189 -> 1678689391;
                case 190 -> -1766351119;
                case 191 -> -405558629;
                case 192 -> 244505931;
                case 193 -> -2108149596;
                case 194 -> -722413191;
                case 195 -> -1908323912;
                case 196 -> 1060715028;
                case 197 -> 1986450277;
                case 198 -> 1296866496;
                case 199 -> 1101241291;
                case 200 -> 145241230;
                case 201 -> -1673047046;
                case 202 -> 2026774129;
                case 203 -> 560243809;
                case 204 -> -1304031918;
                case 205 -> -1905739802;
                case 206 -> -1795417733;
                case 207 -> -1070885991;
                case 208 -> 773268516;
                case 209 -> 1222211001;
                case 210 -> 1791120701;
                case 211 -> 1369510366;
                case 212 -> -1135438925;
                case 213 -> 2097560764;
                case 214 -> 301932627;
                case 215 -> -948622224;
                case 216 -> -2141066839;
                case 217 -> 1346515239;
                case 218 -> 1093576382;
                case 219 -> 281720959;
                case 220 -> -784881587;
                case 221 -> 1673876464;
                case 222 -> -1354598428;
                case 223 -> 288553409;
                case 224 -> 1333684163;
                case 225 -> -2109263747;
                case 226 -> 1775485562;
                case 227 -> 396354789;
                case 228 -> -673399702;
                case 229 -> -1557580181;
                case 230 -> 398655447;
                case 231 -> 23221339;
                case 232 -> 1286102289;
                case 233 -> -1367002063;
                case 234 -> 1212158846;
                case 235 -> -592643273;
                case 236 -> -1557853457;
                case 237 -> -173415734;
                case 238 -> -1000198458;
                case 239 -> -798231139;
                case 240 -> 856830676;
                case 241 -> 567836042;
                case 242 -> 2116481455;
                case 243 -> -2016658902;
                case 244 -> -1240174452;
                case 245 -> 1018419895;
                case 246 -> 254054115;
                case 247 -> 231562335;
                case 248 -> -843691673;
                case 249 -> -872255688;
                case 250 -> -1414334472;
                case 251 -> 1273711579;
                case 252 -> 210619283;
                case 253 -> -93700543;
                case 254 -> 688674521;
                case 255 -> -1785393176;
                default -> 130740021;
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
            Oooo = objectArray;
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

    public static Enum GuiSupport_oi0o_2(CommandContext param0, String param1) {
        return (Enum)param0.getArgument(param1, Object.class);
    }

    public static ArgumentType_0oo0_2 EnumType_oi0i_1(Class param0) {
        return ArgumentType_0oo0_2.Oi0i(param0, null);
    }

    public CompletableFuture listSuggestions(CommandContext param1, SuggestionsBuilder param2) {
        String v3 = param2.getRemainingLowerCase();
        Iterator v4 = this.OooO.keySet().iterator();
        while (v4.hasNext()) {
            String v5 = (String)v4.next();
            String v6 = v5.toLowerCase();
            if (!v6.startsWith(v3)) continue;
            param2.suggest(v6);
        }
        return param2.buildFuture();
    }

    public static ArgumentType_0oo0_2 Oi0i(Class param0, Enum param1) {
        return new ArgumentType_0oo0_2(param0, param1);
    }
}

