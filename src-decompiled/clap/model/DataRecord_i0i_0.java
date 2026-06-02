/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 */
package clap.model;

import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.config.ConfigSupport_O0I;
import clap.config.ConfigSupport_oii_0;

/*
 * Renamed from clap.network.NetworkSupport_i0i_2
 */
public final class DataRecord_i0i_0
extends Record
implements ArgumentType {
    private final Class ConfigSupport_IO0;
    private final ConfigSupport_oii_0 IOo;
    static Object SprintModule;
    private static volatile /* synthetic */ long __k__gH4it;

    public static DataRecord_i0i_0 IiI(Class param0, ConfigSupport_oii_0 param1) {
        return new DataRecord_i0i_0(param0, param1);
    }

    static {
        __k__gH4it = DataRecord_i0i_0.__k__gH4it((long)5333307056436801041L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[]{"\u6309\ufd95\u2336\u769f\uf18c\ue4e8\u7dd0\u215a\u6227\ufc0f", "\u631f\ufd9a\u2335\u76f6\uf1ec\ue48b\u7db1\u2125\u6203\ufc9c\u222d\u7782\uf092\ue791\u7e8b\u2276\u612f\uffa6\u2118\u74ae", "\u6309\ufd8c\u2327"};
        __rP__gH4it2 = new String[]{"\u63a2\ufdd1\u2384\u76da\uf1c0\ue537\u7ce3\u20f1\u6238\ufc28\u2220\u774b\uf09c\ue404\u7d6b\u2162\u61e1\uff36\u2153\u74b9\uf39b\ue77d\u7ed1\u22f8\u618b\ufede\u2046\u7599\uf272\ue61b\u7f4f\u236e\u606f\uf96e\u279a\u729b\uf5e5\ue146\u7871\u24de\u675a\uf8eb\u2624\u7391\uf4fc\ue02a\u79bd\u253f\u66f6\ufbcf\u253f\u70a3\uf751\ue3d2\u7a5b\u2654\u6542\ufbbb\u2421\u71f8\uf64c\ue2b1\u7bb8\u27b5\u644d\ufa42\u2bbe\u7ee8\uf9f2\uede9\u74b3\u2881\u6b0a\uf5da\u2a91\u7f8e\uf8f0\uec3b\u75a1\u2950\u6a1c\uf43c\u29b8\u7c85\ufb55\ueffd\u76f6\u2a55\u6917\uf7e1\u29fe\u7dec\ufa69\uee48\u77c2\u2b79\u68de\uf6c5\u2843\u7a92\ufd9d\ue91d\u7043\u2c4a\u6f88\uf1db\u2f3d\u7b84\ufcbe\ue893\u71d6\u2d85\u6eae\uf0f3\u2e0b\u7884\uff40\ueb74\u729d\u2ec7", "\u630b\ufd93\u2330\u769d\uf18e\ue516\u7dee\u2158\u6225\ufc09", "\u6319\ufd80\u2336\u76e7\uf18c\ue4e3\u7dd5"};
        __rP__gH4it3 = new String[]{"\u6370\ufd52\u23f0\u76f1\uf1f3\ue4b1\u7d39\u2140", "\u631c\ufd99\u2336\u76e2\uf185"};
        byte[] v0 = "\u0091\u00a6\n\u00ab\u0007V\u00e9C\u0013G\u00b6\"C}i\u00d8\u00c2Q\u00cd\u00d8L\f\u00abzP\u0081\u00a0\u00c0]R=\u00e4\u00bc9t\u00ca\u00c2\u0007\u001bL\u0091\u00a4\u00d2\u00d8\u00c3s\u00df\u00a55\u0088\u00c1\u00e2f\u0083\u0001\u00b6\u00b9\u0004\u00e7\u00c1C\u0018\u00ea_\u00be\u00f5p\u00d9\u00f5H\u00f9s\u00e1uG\u00a7\u00ef\u0082\u00e3\u00aa\u00ff\u009bf\u00a4BLL\u0097\u008c~\u00d8\u00f5\u0006\u00c1p\u00b3MRm\u0083\u00fa\u009c\u00e9\u0098\u0003T\u000b\u008d\u00c1\nt_-t5\u00857\u00e5\u0007\u00e5".getBytes("ISO_8859_1");
        Object[] v1 = "1\u0097\u00886Fb\u00dd\\".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1107912714;
                case 1 -> -37409305;
                case 2 -> 1039057418;
                case 3 -> -1485546938;
                case 4 -> -2135081567;
                case 5 -> 301966568;
                case 6 -> -2080930593;
                case 7 -> 894944871;
                case 8 -> -928161529;
                case 9 -> 1560360226;
                case 10 -> -1478752909;
                case 11 -> 1515421402;
                case 12 -> -925603323;
                case 13 -> 724945131;
                case 14 -> -1580849412;
                case 15 -> 1460338534;
                case 16 -> -1511622550;
                case 17 -> 1275788030;
                case 18 -> 1299780955;
                case 19 -> -1937671886;
                case 20 -> 53047296;
                case 21 -> -865612653;
                case 22 -> -1666735937;
                case 23 -> 1166798647;
                case 24 -> -895671466;
                case 25 -> 1232161248;
                case 26 -> 1887438543;
                case 27 -> -1856106727;
                case 28 -> 1494035301;
                case 29 -> -1441848887;
                case 30 -> 117309117;
                case 31 -> -628731068;
                case 32 -> 1013859416;
                case 33 -> 1397718802;
                case 34 -> 1416290949;
                case 35 -> 869556758;
                case 36 -> 1454524931;
                case 37 -> 2012849586;
                case 38 -> -1417724979;
                case 39 -> -1225867222;
                case 40 -> -967108083;
                case 41 -> 1519584425;
                case 42 -> -300411787;
                case 43 -> 1695238467;
                case 44 -> 1371929460;
                case 45 -> -1559041759;
                case 46 -> 145086882;
                case 47 -> 59769782;
                case 48 -> -273786327;
                case 49 -> -222501460;
                case 50 -> -1969117915;
                case 51 -> -1835516691;
                case 52 -> 805301817;
                case 53 -> -648375265;
                case 54 -> -776912219;
                case 55 -> -2068573577;
                case 56 -> -654469080;
                case 57 -> 730952817;
                case 58 -> -219069545;
                case 59 -> 2079770769;
                case 60 -> -1220305585;
                case 61 -> 1922682493;
                case 62 -> -1990199120;
                case 63 -> 1389006466;
                case 64 -> -394201203;
                case 65 -> -26737419;
                case 66 -> -119857416;
                case 67 -> -716792363;
                case 68 -> 1781330084;
                case 69 -> -861292009;
                case 70 -> -439510978;
                case 71 -> 607048418;
                case 72 -> 1547384665;
                case 73 -> 2097980779;
                case 74 -> 1774817117;
                case 75 -> 59908605;
                case 76 -> -1256052080;
                case 77 -> 1985807216;
                case 78 -> 1881060052;
                case 79 -> -1234201891;
                case 80 -> 1839990067;
                case 81 -> -60424951;
                case 82 -> 440637593;
                case 83 -> -987784175;
                case 84 -> -649779897;
                case 85 -> -1805747147;
                case 86 -> -1109105754;
                case 87 -> -1883631743;
                case 88 -> -1341741637;
                case 89 -> -917426899;
                case 90 -> 483928531;
                case 91 -> -1500582220;
                case 92 -> -1814174121;
                case 93 -> 1133955013;
                case 94 -> -1251881684;
                case 95 -> 55235751;
                case 96 -> -1222186744;
                case 97 -> -1838824584;
                case 98 -> 1043873676;
                case 99 -> -1144661369;
                case 100 -> -99060466;
                case 101 -> -588572666;
                case 102 -> -1994564920;
                case 103 -> 503712299;
                case 104 -> -490834505;
                case 105 -> -1785479116;
                case 106 -> -1886794594;
                case 107 -> 837606676;
                case 108 -> 1647317106;
                case 109 -> -429458205;
                case 110 -> 2053622045;
                case 111 -> -493267727;
                case 112 -> 1584683089;
                case 113 -> -858935988;
                case 114 -> 524120099;
                case 115 -> -167864160;
                case 116 -> 2086774549;
                case 117 -> 774059849;
                case 118 -> -37545857;
                case 119 -> 113854144;
                case 120 -> 82899054;
                case 121 -> -919552318;
                case 122 -> -980934;
                case 123 -> -643053892;
                case 124 -> -281039718;
                case 125 -> 58438483;
                case 126 -> -1890373134;
                case 127 -> 902585833;
                case 128 -> -653253641;
                case 129 -> -1470298341;
                case 130 -> 1680409742;
                case 131 -> 1452656444;
                case 132 -> -465489091;
                case 133 -> -1016694772;
                case 134 -> 1623355014;
                case 135 -> -1244292890;
                case 136 -> 900981826;
                case 137 -> -1813003740;
                case 138 -> -454388358;
                case 139 -> 1310832218;
                case 140 -> -223978247;
                case 141 -> -184697686;
                case 142 -> 222555166;
                case 143 -> 825267099;
                case 144 -> -1443821037;
                case 145 -> -2024693285;
                case 146 -> 8431132;
                case 147 -> -362408862;
                case 148 -> -1072949728;
                case 149 -> 59703554;
                case 150 -> -1415729420;
                case 151 -> 1301363083;
                case 152 -> -1265601132;
                case 153 -> -1404357536;
                case 154 -> 2113250378;
                case 155 -> 318046030;
                case 156 -> 2135500999;
                case 157 -> 1002519539;
                case 158 -> -379286446;
                case 159 -> -1367800361;
                case 160 -> 924747576;
                case 161 -> 2064736202;
                case 162 -> -1458823463;
                case 163 -> -1098581409;
                case 164 -> 795777505;
                case 165 -> 295965505;
                case 166 -> 1439955910;
                case 167 -> -103558374;
                case 168 -> -2046629548;
                case 169 -> -289678730;
                case 170 -> 1237330793;
                case 171 -> -927315601;
                case 172 -> 503665624;
                case 173 -> -575000082;
                case 174 -> -1511285366;
                case 175 -> 2016296363;
                case 176 -> 1884988199;
                case 177 -> -1957180851;
                case 178 -> -778328732;
                case 179 -> -644688445;
                case 180 -> -1193072080;
                case 181 -> 793810840;
                case 182 -> -2034458449;
                case 183 -> -198733440;
                case 184 -> 2005827747;
                case 185 -> -1492622130;
                case 186 -> 2020030257;
                case 187 -> 1513530750;
                case 188 -> 758196006;
                case 189 -> -1967845312;
                case 190 -> -2045708395;
                case 191 -> -1895739924;
                case 192 -> -1277180165;
                case 193 -> 1676123928;
                case 194 -> -385732050;
                case 195 -> 1764682929;
                case 196 -> -1434638337;
                case 197 -> -367154431;
                case 198 -> -1261020964;
                case 199 -> 1517171408;
                case 200 -> -1872413624;
                case 201 -> 211353245;
                case 202 -> -1368703302;
                case 203 -> 1044748502;
                case 204 -> 1643170351;
                case 205 -> -1605154148;
                case 206 -> -369684661;
                case 207 -> -1442651170;
                case 208 -> -1640857073;
                case 209 -> 297819852;
                case 210 -> -935080476;
                case 211 -> 1955563242;
                case 212 -> -2096648263;
                case 213 -> 1282489041;
                case 214 -> -141909308;
                case 215 -> 954865531;
                case 216 -> 1000584885;
                case 217 -> -1160846996;
                case 218 -> -1386713981;
                case 219 -> 1063464622;
                case 220 -> -2007037692;
                case 221 -> 1716249441;
                case 222 -> -1215806491;
                case 223 -> 1925076886;
                case 224 -> -1308137205;
                case 225 -> -1193812356;
                case 226 -> -1980245111;
                case 227 -> -1522665326;
                case 228 -> 544764944;
                case 229 -> -1957657468;
                case 230 -> -1872424605;
                case 231 -> 1756058558;
                case 232 -> -1189025221;
                case 233 -> 778036673;
                case 234 -> -1222445409;
                case 235 -> 2044332380;
                case 236 -> -544592723;
                case 237 -> 468712758;
                case 238 -> -179819195;
                case 239 -> 1043905621;
                case 240 -> 87873786;
                case 241 -> 1800919024;
                case 242 -> 1054831272;
                case 243 -> -151603874;
                case 244 -> -1330215281;
                case 245 -> -370757240;
                case 246 -> 1891539695;
                case 247 -> 593542009;
                case 248 -> -1580070040;
                case 249 -> -1867118273;
                case 250 -> -1053333936;
                case 251 -> -2120912456;
                case 252 -> -1371225141;
                case 253 -> -1343001421;
                case 254 -> -65473838;
                case 255 -> 1137962349;
                default -> 1609091826;
            });
        } while (v2 != 120);
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
            Object[] objectArray = new Object[3];
            v1 = objectArray;
            SprintModule = objectArray;
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

    public static Number Ii0(Class param0, CommandContext param1, String param2) {
        return (Number)param1.getArgument(param2, param0);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public Number IIi(StringReader param1) throws CommandSyntaxException {
        void var3_5;
        String v2 = param1.readString();
        Object var3_3 = null;
        if (this.ConfigSupport_IO0.isAssignableFrom(Integer.class)) {
            Integer n = Integer.valueOf(v2);
        } else if (this.ConfigSupport_IO0.isAssignableFrom(Double.class)) {
            Double d = Double.valueOf(v2);
        } else if (this.ConfigSupport_IO0.isAssignableFrom(Float.class)) {
            Float f = Float.valueOf(v2);
        } else if (this.ConfigSupport_IO0.isAssignableFrom(Long.class)) {
            Long l = Long.valueOf(v2);
        }
        if (this.IOo != null) {
            this.IOo.PacketEvent(param1, (Number)var3_5);
        }
        if (var3_5 == null) {
            throw ConfigSupport_O0I.PacketEvent("Could not parse \"%s\"", v2).createWithContext((ImmutableStringReader)param1);
        }
        return var3_5;
    }

    public ConfigSupport_oii_0 Setting() {
        return this.IOo;
    }

    public static ConfigSupport_oii_0 IiO(Number param0, Number param1) {
        return (param2, param3) -> {
            double v4 = param3.doubleValue();
            if (param0.doubleValue() > v4) {
                throw ConfigSupport_O0I.PacketEvent("Value is less than minimum(%s)", param0.toString()).createWithContext((ImmutableStringReader)param2);
            }
            if (!(param1.doubleValue() < v4)) {
                return;
            }
            throw ConfigSupport_O0I.PacketEvent("Value is more than maximum(%s)", param1.toString()).createWithContext((ImmutableStringReader)param2);
        };
    }

    public Class Iii() {
        return this.ConfigSupport_IO0;
    }

    public DataRecord_i0i_0(Class param1, ConfigSupport_oii_0 param2) {
        this.ConfigSupport_IO0 = param1;
        this.IOo = param2;
    }

    @Override
    public final boolean equals(Object param1) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{DataRecord_i0i_0.class, "type;constraint", "ConfigSupport_IO0", "IOo"}, this, param1);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{DataRecord_i0i_0.class, "type;constraint", "ConfigSupport_IO0", "IOo"}, this);
    }

    public static DataRecord_i0i_0 Iio(Class param0) {
        return DataRecord_i0i_0.IiI(param0, null);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{DataRecord_i0i_0.class, "type;constraint", "ConfigSupport_IO0", "IOo"}, this);
    }
}

