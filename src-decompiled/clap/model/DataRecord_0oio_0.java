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
package clap.model;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.security.Key;
import java.security.MessageDigest;
import java.util.concurrent.CompletableFuture;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.config.ConfigSupport_O0I;
import clap.core.module.Module;
import skidonion.loader.0ooo;

/*
 * Renamed from clap.model.EnumType_0OIo
 */
public final class DataRecord_0oio_0
extends Record
implements ArgumentType {
    private final boolean DataRecord_OOI0;
    static Object OOIo;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{DataRecord_0oio_0.class, "fullName", "DataRecord_OOI0"}, this);
    }

    public static DataRecord_0oio_0 ScaledDrawContext() {
        return DataRecord_0oio_0.IrcManager(false);
    }

    public DataRecord_0oio_0(boolean param1) {
        this.DataRecord_OOI0 = param1;
    }

    public CompletableFuture listSuggestions(CommandContext param1, SuggestionsBuilder param2) {
        String v3 = param2.getRemainingLowerCase();
        for (Module v5 : 0ooo.0i0i().oo0o()) {
            String v6 = v5.iooi().toLowerCase();
            String v7 = v5.IoOO().toLowerCase();
            if (!v6.startsWith(v3) && !v7.startsWith(v3)) continue;
            param2.suggest(v6);
        }
        return param2.buildFuture();
    }

    public static Module Oo0i(CommandContext param0, String param1) {
        return (Module)param0.getArgument(param1, Module.class);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{DataRecord_0oio_0.class, "fullName", "DataRecord_OOI0"}, this);
    }

    static {
        __k__gH4it = DataRecord_0oio_0.__k__gH4it((long)1213484528153128465L);
        __rP__gH4it0 = new String[]{"\ucdbc\ue6a5\u3ffe\u6a94\uede3\u8397\u5e0b\u3c6b\uca3e\ue173\u3e90\u6b28\uecfb\u82f2\u5ffc\u3dd9\ucb16\ue03d\u3ed5\u68bb\uefe4\u81c8\u5c61\u3e0f\uc8e2\ue3cc\u3df4\u6991\uee22\u80b3\u5d6f\u3f17\uc9fc\ue2bf\u3c3b\u16d6\u911a\uff62\u2200\u40af\ub61b\u9d86\u430d\u171f\u9085\ufe60\u23fa\u4117\ub725\u9c5e\u42bc\u1749\u9327\ufdbb\u2068\u4288", "\ucd39\ue1bb\u3faf\u6a00\ued15\u8373\u5e33\u3c83\uca27\ue0d1", "\ucddb\ue135\u3f33\u6a56\uedbb\u8307\u5e34\u3cb1", "\ucd3b\ue1b9\u3fa9\u6a06\ued17\u8371\u5e3d\u3c8d\uca25\ue0d3", "\ucd39\ue1a2\u3fbe", "\ucd29\ue1aa\u3faf\u6a7c\ued15\u8374\u5e26"};
        __rP__gH4it1 = new String[]{"\ucd2f\ue1b0\u3fac\u6a6d\ued75\u83ec\u5e62\u3cf0\uca03\ue146\u3e84\u6b69\uec3b\u82f6\u5f48\u3db3\ucb3f\ue06c\u3da1\u6855"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\ucd2c\ue1b7\u3faf\u6a7d\ued1c"};
        byte[] v0 = "\u00ff\u00b8)\u00be\u00fd!2\u00acufO\n\u00ed|=&%\u0010\u00f2\u00a1\u008aN\u00a8\u00f8\u00d9\u00e9\u00db\u0083D-\u00be\u00f8\u00df\u0082\f\u00dcd\u00f4\u00d9H0\u00b32\u001d\u00f3\u008e\u001b\b6\u0013\u00bb\u00b3i]\u0081\u009f".getBytes("ISO_8859_1");
        Object[] v1 = "\u00aa\u00de\u00d2\u000e\u0097O3\u0004".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1532043179;
                case 1 -> -1086798804;
                case 2 -> 541948452;
                case 3 -> -1180793453;
                case 4 -> -115456722;
                case 5 -> 1687641687;
                case 6 -> -1042253467;
                case 7 -> -922798870;
                case 8 -> 1215734754;
                case 9 -> 656455831;
                case 10 -> 1399652211;
                case 11 -> 1618149270;
                case 12 -> -1901072247;
                case 13 -> 672313501;
                case 14 -> 419232396;
                case 15 -> 1039528960;
                case 16 -> 1726340801;
                case 17 -> 777910414;
                case 18 -> -961975230;
                case 19 -> -1078009750;
                case 20 -> 1930462404;
                case 21 -> 669697321;
                case 22 -> -1722590892;
                case 23 -> -641987174;
                case 24 -> -1671900792;
                case 25 -> -1768201849;
                case 26 -> 1430804535;
                case 27 -> -1092805185;
                case 28 -> -1913626326;
                case 29 -> 396273379;
                case 30 -> -560559280;
                case 31 -> -1942641141;
                case 32 -> 1253671694;
                case 33 -> -62871801;
                case 34 -> -354749413;
                case 35 -> -1499827347;
                case 36 -> -1249537175;
                case 37 -> 965215954;
                case 38 -> -1987032740;
                case 39 -> -921332417;
                case 40 -> 1367139366;
                case 41 -> 466796429;
                case 42 -> 1301534114;
                case 43 -> 162241339;
                case 44 -> -173742959;
                case 45 -> -2054328812;
                case 46 -> -738655467;
                case 47 -> 212771147;
                case 48 -> 279856380;
                case 49 -> -1471394060;
                case 50 -> 1083937281;
                case 51 -> -746450144;
                case 52 -> -495044670;
                case 53 -> 1044216480;
                case 54 -> 1265345989;
                case 55 -> -998486396;
                case 56 -> -1937564549;
                case 57 -> 861941870;
                case 58 -> 1366173691;
                case 59 -> -725518049;
                case 60 -> 1779840509;
                case 61 -> 1382360014;
                case 62 -> -316725309;
                case 63 -> -456833634;
                case 64 -> -63888661;
                case 65 -> 349703514;
                case 66 -> 982201908;
                case 67 -> 181891557;
                case 68 -> 550982451;
                case 69 -> -646766411;
                case 70 -> -1487933922;
                case 71 -> 2130263128;
                case 72 -> -335499262;
                case 73 -> -226427401;
                case 74 -> 84087112;
                case 75 -> 1316495190;
                case 76 -> 1993611139;
                case 77 -> -1321578946;
                case 78 -> 948110814;
                case 79 -> -1095991768;
                case 80 -> 1607826202;
                case 81 -> -2041038283;
                case 82 -> -106262113;
                case 83 -> 184626786;
                case 84 -> -1667973378;
                case 85 -> -1008389871;
                case 86 -> -2146625322;
                case 87 -> -850201287;
                case 88 -> 279419316;
                case 89 -> -2065045184;
                case 90 -> 33538930;
                case 91 -> 520448719;
                case 92 -> 529147491;
                case 93 -> -986940849;
                case 94 -> -1769518091;
                case 95 -> 1058853385;
                case 96 -> -190391771;
                case 97 -> 303295584;
                case 98 -> 1342792137;
                case 99 -> 209905873;
                case 100 -> 1870663606;
                case 101 -> 1176677865;
                case 102 -> 1880873911;
                case 103 -> -711543947;
                case 104 -> -1090360985;
                case 105 -> 111068838;
                case 106 -> 62595106;
                case 107 -> 763739958;
                case 108 -> -1884772279;
                case 109 -> -685325586;
                case 110 -> 1574211551;
                case 111 -> -1762692872;
                case 112 -> -376518643;
                case 113 -> 1700696420;
                case 114 -> 195609964;
                case 115 -> -1204204255;
                case 116 -> 790327118;
                case 117 -> -1882198584;
                case 118 -> 2119499664;
                case 119 -> 1929732209;
                case 120 -> 667161784;
                case 121 -> -1026686403;
                case 122 -> -1374546938;
                case 123 -> -72739233;
                case 124 -> 1172397771;
                case 125 -> -1125883588;
                case 126 -> 296395649;
                case 127 -> -241351860;
                case 128 -> -674325377;
                case 129 -> 240483556;
                case 130 -> -24016575;
                case 131 -> 1689921410;
                case 132 -> 484993212;
                case 133 -> -1532152876;
                case 134 -> -1357073385;
                case 135 -> -1352357366;
                case 136 -> 598460150;
                case 137 -> 548419285;
                case 138 -> 66577088;
                case 139 -> -1995828615;
                case 140 -> 1484279504;
                case 141 -> 1245266556;
                case 142 -> -1893342196;
                case 143 -> -1046348221;
                case 144 -> 160254010;
                case 145 -> -1356762732;
                case 146 -> 2032040522;
                case 147 -> -1411878634;
                case 148 -> 906147218;
                case 149 -> -664717396;
                case 150 -> 1996610269;
                case 151 -> 1924403120;
                case 152 -> 1878830553;
                case 153 -> -949241786;
                case 154 -> -491097007;
                case 155 -> -283506775;
                case 156 -> -1352099054;
                case 157 -> -442593275;
                case 158 -> 1450740698;
                case 159 -> 734212705;
                case 160 -> -1082577459;
                case 161 -> -994296935;
                case 162 -> 729461991;
                case 163 -> -1454612106;
                case 164 -> -1626402084;
                case 165 -> 302496655;
                case 166 -> 1406227955;
                case 167 -> -901385302;
                case 168 -> 948555887;
                case 169 -> -1040438400;
                case 170 -> 385526578;
                case 171 -> 650449838;
                case 172 -> 1365069843;
                case 173 -> -1727838303;
                case 174 -> -719848597;
                case 175 -> 305878705;
                case 176 -> 1652418841;
                case 177 -> -365283507;
                case 178 -> -1554779406;
                case 179 -> 1937735407;
                case 180 -> 696126723;
                case 181 -> 1350834877;
                case 182 -> 0x111D5D1D;
                case 183 -> 1748805843;
                case 184 -> 2086001060;
                case 185 -> -1407316737;
                case 186 -> -531058196;
                case 187 -> -1465177496;
                case 188 -> 545141104;
                case 189 -> 937477037;
                case 190 -> -706866428;
                case 191 -> -2134319733;
                case 192 -> -829544366;
                case 193 -> -1047008752;
                case 194 -> -624894342;
                case 195 -> -1619219441;
                case 196 -> -282929733;
                case 197 -> 681039078;
                case 198 -> 2100874405;
                case 199 -> 1013679584;
                case 200 -> 432466161;
                case 201 -> 826165016;
                case 202 -> -120306254;
                case 203 -> -654105693;
                case 204 -> -1542419322;
                case 205 -> 1939034147;
                case 206 -> 2082373626;
                case 207 -> 2057389670;
                case 208 -> 595685495;
                case 209 -> -351565781;
                case 210 -> -1923390821;
                case 211 -> -519815746;
                case 212 -> 1092487599;
                case 213 -> 901588659;
                case 214 -> -1817808849;
                case 215 -> 1201402823;
                case 216 -> -1888591376;
                case 217 -> 1718469214;
                case 218 -> 1960906535;
                case 219 -> 1881198717;
                case 220 -> -1142159379;
                case 221 -> -151602024;
                case 222 -> 1857028823;
                case 223 -> 1799890771;
                case 224 -> -922355667;
                case 225 -> -1277522299;
                case 226 -> 1217329338;
                case 227 -> 398721544;
                case 228 -> 1729923868;
                case 229 -> -1228566312;
                case 230 -> 1643928296;
                case 231 -> 171342968;
                case 232 -> -1100693968;
                case 233 -> -933695269;
                case 234 -> 288287813;
                case 235 -> 1352598900;
                case 236 -> 1522758329;
                case 237 -> -498671013;
                case 238 -> 401199052;
                case 239 -> -1152760890;
                case 240 -> -1834585273;
                case 241 -> 1706248793;
                case 242 -> 1813706289;
                case 243 -> 1521703736;
                case 244 -> -336965739;
                case 245 -> -818123171;
                case 246 -> 742076316;
                case 247 -> 793763297;
                case 248 -> 993615784;
                case 249 -> -431791746;
                case 250 -> -1020902588;
                case 251 -> 2083368842;
                case 252 -> -1539205205;
                case 253 -> 1078214602;
                case 254 -> 529846777;
                case 255 -> 1239192999;
                default -> 820240803;
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
            OOIo = objectArray;
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

    public boolean OooO() {
        return this.DataRecord_OOI0;
    }

    public Module PacketSendEvent(StringReader param1) throws CommandSyntaxException {
        String v2 = param1.readString().toLowerCase();
        for (Module v4 : 0ooo.0ioO().oo0o()) {
            if (!v2.equalsIgnoreCase(v4.iooi()) && !v4.iooi().startsWith(v2)) continue;
            return v4;
        }
        throw ConfigSupport_O0I.PacketEvent("Invalid module", new Object[0]).createWithContext((ImmutableStringReader)param1);
    }

    public static DataRecord_0oio_0 IrcManager(boolean param0) {
        return new DataRecord_0oio_0(param0);
    }

    @Override
    public final boolean equals(Object param1) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{DataRecord_0oio_0.class, "fullName", "DataRecord_OOI0"}, this, param1);
    }
}

