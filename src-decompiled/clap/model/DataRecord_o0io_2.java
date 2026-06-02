/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.ImmutableMultimap$Builder
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  com.mojang.authlib.properties.PropertyMap
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.CustomModelDataComponent
 *  net.minecraft.component.type.ProfileComponent
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 */
package clap.model;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

/*
 * Renamed from clap.module.combat.CriticalsModule
 */
public final class DataRecord_o0io_2
extends Record {
    private final String iIo;
    private final Item PotionEffectsHudElement;
    private final String i0I;
    private static final String iiO;
    private final float iIi;
    static Object EnumType_ii0_2;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{DataRecord_o0io_2.class, "displayName;craftId;baseItem;modelData", "iIo", "i0I", "PotionEffectsHudElement", "iIi"}, this);
    }

    public Item O0Oo() {
        return this.PotionEffectsHudElement;
    }

    private ItemStack OOii() {
        ItemStack v1 = new ItemStack((ItemConvertible)Items.PLAYER_HEAD);
        ImmutableMultimap.Builder v2 = ImmutableMultimap.builder();
        v2.put((Object)"textures", (Object)new Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2JiNjEyZWI0OTVlZGUyYzVjYTUxNzhkMmQxZWNmMWNhNWEyNTVkMjVkZmMzYzI1NGJjNDdmNjg0ODc5MWQ4In19fQ=="));
        PropertyMap v3 = new PropertyMap((Multimap)v2.build());
        UUID v4 = UUID.nameUUIDFromBytes(this.i0I.getBytes(StandardCharsets.UTF_8));
        GameProfile v5 = new GameProfile(v4, this.i0I, v3);
        v1.set(DataComponentTypes.PROFILE, (Object)ProfileComponent.ofStatic((GameProfile)v5));
        v1.set(DataComponentTypes.CUSTOM_NAME, (Object)this.EnumType_O0OO());
        return v1;
    }

    public ItemStack MoveFixModule() {
        if (this.PotionEffectsHudElement == Items.PLAYER_HEAD && "golden_head".equals(this.i0I)) {
            return this.OOii();
        }
        ItemStack v1 = new ItemStack((ItemConvertible)this.PotionEffectsHudElement);
        v1.set(DataComponentTypes.CUSTOM_MODEL_DATA, (Object)new CustomModelDataComponent(List.of(Float.valueOf(this.iIi)), List.of(), List.of(), List.of()));
        v1.set(DataComponentTypes.CUSTOM_NAME, (Object)this.EnumType_O0OO());
        return v1;
    }

    public float GuiComponent() {
        return this.iIi;
    }

    public String SprintResetModule() {
        return this.iIo;
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{DataRecord_o0io_2.class, "displayName;craftId;baseItem;modelData", "iIo", "i0I", "PotionEffectsHudElement", "iIi"}, this);
    }

    @Override
    public final boolean equals(Object param1) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{DataRecord_o0io_2.class, "displayName;craftId;baseItem;modelData", "iIo", "i0I", "PotionEffectsHudElement", "iIi"}, this, param1);
    }

    private Text EnumType_O0OO() {
        return Text.literal((String)this.iIo).styled(param0 -> param0.withItalic(Boolean.valueOf(false)).withColor(Formatting.GOLD));
    }

    public String OOoi() {
        return this.i0I;
    }

    public DataRecord_o0io_2(String param1, String param2, Item param3, float param4) {
        this.iIo = param1;
        this.i0I = param2;
        this.PotionEffectsHudElement = param3;
        this.iIi = param4;
    }

    static {
        __k__gH4it = DataRecord_o0io_2.__k__gH4it((long)-5220411279079903727L);
        __rP__gH4it0 = new String[]{"\udce7\ub84a\u6759", "\udcf7\ub84e\u6740\u32d2\ub47f\u96de\ueb9c"};
        __rP__gH4it1 = new String[]{"\udc92\ub8bf\u6726\u32ba\ub4ef\u96b7\uebf6\u65fe", "\udcf1\ub850\u6743\u32c7\ub41f\u96ba\uebf8\u65c6\udded\ub956\u665b\u33b3\ub761\u95a0\ue8d2\u66b5\ude21\uba4c\u650e\u30bf"};
        __rP__gH4it2 = new String[]{"\udce7\ub85f\u6740\u32ae\ub47f\u96d9\ueb89\u65d9\udde9\ub925", "\udce5\ub85d\u6746\u32a8\ub47d\u96db\ueb97\u65c7\uddeb\ub927"};
        __rP__gH4it3 = new String[]{"\udcd3\ub825\u676f\u32d9\ub595\u96d4\ueb8e\u6530\udd92\ub980\u6658\u33f2\ub4b5\u95e1\ue80b\u66a1\ude2a\ubaf3\u651a\u30fc\ub783\u958c\ue9a3\u6745\udf1e\ubbe1\u64d3\u3150\ub6d5\u94e2\ue692\u68a0\ud07d\ub4ae\u6b93\u3ec9\ub97f\u9b3f\ue7af\u699d\ud150\ub528\u6a16\u3f3a\ub89e\u9a99\ue419\u6a27\ud2b7\ub618\u6981\u3cac\ubb9e\u996c\ue46e\u6b69\ud352\ub77a\u685f\u3d11\ubac3\u983f\ue56d\u6c2e\ud43a\ub03b\u6f52\u3a3a\ubd7f\u9f36\ue2d0\u6deb\ud59e\ub1fc\u6e82\u3b11\ubc73\u9e44\ue3c9\u6d9c\ud60b\ub265\u6dc7\u3849\ubf00\u9db6\ue0a2\u6ed9\ud79c\ub32f\u6c64\u3972\ube4f\u9c92\ue1d2\u6f67\uc863\uac94\u73ad\u2619\ua148\u837d\ufe1c\u703d\uc909\uad2e\u725c\u27d8\ua0ab\u828e\uff98\u71e6\uc9f6\uae0f\u7146\u2456\ua3af\u81ba\ufcb2\u72b9\ucaed\uaf3b\u70aa\u25e2\ua264\u80fd\ufd91\u733e\ucbba\ua828\u777f\u22d9\ua5f5\u8737\ufaf2\u7495\uccc0\ua92f\u7617\u2372\ua487\u86a7\ufb30\u75b1\ucd09\ua953\u7502\u20bf\ua771\u8511\uf8bc\u76e3\uce61\uaa77\u7485\u21a5\ua6f4\u8433\uf9a0\u773a\ucf59\uab31\u7b3f\u2ef2\ua961\u8b32\uf672\u7861\uc024\ua441\u7a6f\u2f3f\ua83e\u8a30\uf799\u797b\uc1be\ua5eb\u7a2c\u2c76\uabc8\u894b\uf400\u7ae0\uc2a3\ua6db\u79fe\u2d97\uaaab\u8889\uf58a\u7b43\uc33b\ua709\u78ea\u2a4d\uad46\u8f02\uf283\u7c44\uc4c8\ua0c0\u7fdc\u2b40\uacaa\u8e5f\uf36a\u7daa\uc570\ua1e0\u7e6a\u2b40\uafb7\u8dd6\uf077\u7e39\uc608\ua2f9\u7dd7\u2834\uaec1\u8c2d\uf1eb\u7fd5\uc7e9\ua349\u7ced\u293d\u5124\u733d\u0e02\u800c\u3829\u5c35\u83d1\ud6bf\u507e\u7261\u0f01\u8198", "\udcf2\ub857\u6740\u32d7\ub476"};
        byte[] v0 = "\u0086\u0010\u001f\u0011)\fU\u00f9\u00cf\u00bd 2\u00011\u00d8\u0010O6ZD\u000f\u00a4H\u00fcs,\u009b\u00e0Q\u00c2q\u0001\b{\u00c3a\u00e3\u0007T4-\u00f5N\u009a\n\u00a9\u00ea\u00b6\u00b2\u00fd!4rde\u00f0_\u0097\u00f7\u0081'?n\u00af/\u00ce\u00e2\u00b2\u0083.\u00cbb\u0083\u0001:\u0091\u0087T\u00da\u00ed.\u00e0G1\u00cc\u00de\u0089\u00a0\u00b1\u00a2\u00ec\u0002\u008b\u00f2\u00f1\u0006V\u0001=q\u0094\u0005'T4\u00b3\u00c4\u00b8\u007f\u00fe\u00ab\u00b73\u00aa\u00a6\u000e\u0083\u00f2\u00f9\u00e0 \u0096B\u00b2@\u00bd\u00d2\u007fo\u009d\u008f\u0091\u00c9o\u00a9\u00dc\u001d\u0092\u00ef2\u00b3\u00f7c\u0080\u00ec\u0016\u00c2\u0087}\u00b9\u00d7\u00da\u008c:M\u0095\u00f0\u0093\u00c3\u001b\u00acd\u00ef\u00da}\u008a\tH\u00d9\u001c\u00b7\u001f*\u0080\u00eaj;\u008e\fn\u00a4\u00c3\u008b\u00f9.\u00b6\u00d6\u0087\u00cf\t\tB\u00ae|\u00daE:\u009a\u0018MU\u00bd\u00e4@\u00de\u00cf\u00f9[\u00d5\u00e5j\u00b8\u00fb>\u00dc\u00c0\u00a5\u00f4\u00df\u00c4\u0085\u00cdH4\\\\\u00fd\u00d5x\u00c5\u00b9\u00e5\u0094(\u00c9_*\u0091\u00b2I".getBytes("ISO_8859_1");
        Object[] v1 = "=\u00b4(H\u00a9IK\u001d".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 811300997;
                case 1 -> 931182735;
                case 2 -> -1757490881;
                case 3 -> -1025143992;
                case 4 -> 1681562719;
                case 5 -> -619169763;
                case 6 -> -1876860154;
                case 7 -> -1614937293;
                case 8 -> 1010185070;
                case 9 -> 548296458;
                case 10 -> 210989207;
                case 11 -> 647649048;
                case 12 -> 395125721;
                case 13 -> -1776976904;
                case 14 -> 1255069903;
                case 15 -> 149360711;
                case 16 -> -384584755;
                case 17 -> 366756253;
                case 18 -> 1255273756;
                case 19 -> -1865469569;
                case 20 -> -529365098;
                case 21 -> -225704404;
                case 22 -> 848919750;
                case 23 -> -861336317;
                case 24 -> -1204043816;
                case 25 -> 2505978;
                case 26 -> 1667609443;
                case 27 -> -1372309784;
                case 28 -> -1966021850;
                case 29 -> -514379191;
                case 30 -> 988203685;
                case 31 -> -575028043;
                case 32 -> 680238763;
                case 33 -> -1944375055;
                case 34 -> 747990013;
                case 35 -> 443581305;
                case 36 -> -901354010;
                case 37 -> 2113737419;
                case 38 -> -1237722800;
                case 39 -> 2006630000;
                case 40 -> 1937883835;
                case 41 -> 1357101940;
                case 42 -> 804599193;
                case 43 -> 552319796;
                case 44 -> -365606366;
                case 45 -> -1328148205;
                case 46 -> -247091456;
                case 47 -> 1562319457;
                case 48 -> 1327777141;
                case 49 -> 1601395608;
                case 50 -> 582469561;
                case 51 -> -1819498104;
                case 52 -> -1014549980;
                case 53 -> 1700276489;
                case 54 -> -1803294609;
                case 55 -> 1025994401;
                case 56 -> 1196175393;
                case 57 -> -1702483157;
                case 58 -> 1719204368;
                case 59 -> -83957783;
                case 60 -> -380445320;
                case 61 -> -1083728403;
                case 62 -> 1518972471;
                case 63 -> -398081045;
                case 64 -> 1210029487;
                case 65 -> -831707865;
                case 66 -> -1973702494;
                case 67 -> -2075025304;
                case 68 -> 952979182;
                case 69 -> 1959742941;
                case 70 -> 1989475708;
                case 71 -> -432303908;
                case 72 -> -1564180310;
                case 73 -> -1645543735;
                case 74 -> 630521369;
                case 75 -> -134129091;
                case 76 -> 1546706169;
                case 77 -> 843224787;
                case 78 -> 1007434510;
                case 79 -> 646174596;
                case 80 -> 748071437;
                case 81 -> -6058422;
                case 82 -> -1380012318;
                case 83 -> -1229008515;
                case 84 -> 1535385077;
                case 85 -> -1114979918;
                case 86 -> 887758750;
                case 87 -> -77904898;
                case 88 -> 409601526;
                case 89 -> 903858625;
                case 90 -> 478873944;
                case 91 -> 814016053;
                case 92 -> 157979254;
                case 93 -> 1489110886;
                case 94 -> -632297663;
                case 95 -> 1257792064;
                case 96 -> -794551206;
                case 97 -> -525842795;
                case 98 -> 1370749451;
                case 99 -> -1966105650;
                case 100 -> -177656151;
                case 101 -> -994174071;
                case 102 -> -1883775644;
                case 103 -> -421141426;
                case 104 -> 1748383680;
                case 105 -> 142105317;
                case 106 -> 524253777;
                case 107 -> 856038733;
                case 108 -> -1874286876;
                case 109 -> 588010743;
                case 110 -> 1451373034;
                case 111 -> 1169224914;
                case 112 -> 801265773;
                case 113 -> -972309332;
                case 114 -> -680309081;
                case 115 -> -362159082;
                case 116 -> 1518310560;
                case 117 -> -501132347;
                case 118 -> -321512638;
                case 119 -> 1868405609;
                case 120 -> -1686829730;
                case 121 -> 2047394498;
                case 122 -> 85072498;
                case 123 -> 1897717700;
                case 124 -> 1204709723;
                case 125 -> -794931980;
                case 126 -> -1341041597;
                case 127 -> -917294572;
                case 128 -> -312613848;
                case 129 -> 1569270394;
                case 130 -> -1346652176;
                case 131 -> 1443933630;
                case 132 -> -25742821;
                case 133 -> 1858982267;
                case 134 -> -1472208933;
                case 135 -> -1833768089;
                case 136 -> 122758446;
                case 137 -> -1832686458;
                case 138 -> 797633427;
                case 139 -> -1712263199;
                case 140 -> 1002121695;
                case 141 -> -1749403444;
                case 142 -> -1755964603;
                case 143 -> 1313498022;
                case 144 -> 1587264312;
                case 145 -> -1017730086;
                case 146 -> 474636556;
                case 147 -> -1017471084;
                case 148 -> 1921520661;
                case 149 -> -1518369762;
                case 150 -> -1004066259;
                case 151 -> 194266639;
                case 152 -> 1259628356;
                case 153 -> -939841961;
                case 154 -> 1440414097;
                case 155 -> -1158512854;
                case 156 -> -1400931071;
                case 157 -> 1186655378;
                case 158 -> 2119281328;
                case 159 -> 2088306102;
                case 160 -> -766274762;
                case 161 -> -879147123;
                case 162 -> 2091215153;
                case 163 -> 1177327879;
                case 164 -> -792611841;
                case 165 -> 1429858444;
                case 166 -> 94158066;
                case 167 -> 163682698;
                case 168 -> -1625555377;
                case 169 -> -636930477;
                case 170 -> 1915824454;
                case 171 -> 1071039175;
                case 172 -> -1222206763;
                case 173 -> 541775122;
                case 174 -> -1803594193;
                case 175 -> -1536272015;
                case 176 -> 205402885;
                case 177 -> -788724045;
                case 178 -> -1556434815;
                case 179 -> -1111997636;
                case 180 -> -640790758;
                case 181 -> -950984620;
                case 182 -> -892604926;
                case 183 -> -429662768;
                case 184 -> 159438633;
                case 185 -> 936863874;
                case 186 -> -303888352;
                case 187 -> 718830373;
                case 188 -> 171154851;
                case 189 -> 1937705859;
                case 190 -> -1699057756;
                case 191 -> 824177431;
                case 192 -> 676839998;
                case 193 -> -1720648524;
                case 194 -> -271407531;
                case 195 -> -29450063;
                case 196 -> 1244281696;
                case 197 -> 2044132727;
                case 198 -> 667582422;
                case 199 -> -580344212;
                case 200 -> 1299441515;
                case 201 -> -1727127876;
                case 202 -> 1768529547;
                case 203 -> 507284648;
                case 204 -> -864886179;
                case 205 -> -1328127805;
                case 206 -> -1137175548;
                case 207 -> 992431987;
                case 208 -> 1534465255;
                case 209 -> 570907643;
                case 210 -> 743906775;
                case 211 -> 815175513;
                case 212 -> 734997946;
                case 213 -> -1888742113;
                case 214 -> 385638299;
                case 215 -> 350337260;
                case 216 -> -1437697865;
                case 217 -> -1075421109;
                case 218 -> -1120781467;
                case 219 -> 270174367;
                case 220 -> 448744877;
                case 221 -> -48467512;
                case 222 -> -644546757;
                case 223 -> -1501341598;
                case 224 -> 1175650270;
                case 225 -> 1660520444;
                case 226 -> 1760434388;
                case 227 -> 1618447162;
                case 228 -> 693341328;
                case 229 -> 359977052;
                case 230 -> -905213761;
                case 231 -> 2070450311;
                case 232 -> -1084850973;
                case 233 -> -1818235506;
                case 234 -> 272845299;
                case 235 -> -1050066094;
                case 236 -> -1044668488;
                case 237 -> -2093959928;
                case 238 -> -218670535;
                case 239 -> 1943929470;
                case 240 -> -833968672;
                case 241 -> 1557143214;
                case 242 -> 1416141724;
                case 243 -> 1921508714;
                case 244 -> 662554314;
                case 245 -> -2119010176;
                case 246 -> 1752418096;
                case 247 -> 1183184849;
                case 248 -> 691461462;
                case 249 -> 77285923;
                case 250 -> 565517132;
                case 251 -> 1364156689;
                case 252 -> 411026330;
                case 253 -> 95521725;
                case 254 -> -1639675342;
                case 255 -> 777376495;
                default -> -1240609889;
            });
        } while (v2 != 240);
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
            EnumType_ii0_2 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iiO = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2JiNjEyZWI0OTVlZGUyYzVjYTUxNzhkMmQxZWNmMWNhNWEyNTVkMjVkZmMzYzI1NGJjNDdmNjg0ODc5MWQ4In19fQ==";
    }
}

