/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.entity.player.PlayerEntity
 */
package clap.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.entity.player.PlayerEntity;
import clap.setting.SettingContainer;
import skidonion.loader.0ooo;

public class ConfigSupport_0II
implements SettingContainer {
    private final List OOIo = new ArrayList();
    static Object GuiSupport_OOII;
    private static volatile /* synthetic */ long __k__gH4it;

    public void OI0i(String param1) {
        this.OOIo.add(param1);
    }

    @Override
    public String OIoi() {
        return "friends.json";
    }

    public boolean OI0o(String param12) {
        return this.OOIo.stream().anyMatch(param1 -> param1.equalsIgnoreCase(param12));
    }

    public void RotationModule() {
        0ooo.oOo().PacketEvent(this);
    }

    @Override
    public JsonElement OIoo() {
        JsonObject v1 = new JsonObject();
        JsonArray v2 = new JsonArray();
        for (String v4 : this.OOIo) {
            v2.add(v4);
        }
        v1.add("friends", (JsonElement)v2);
        return v1;
    }

    public void OIoO(String param12) {
        this.OOIo.removeIf(param1 -> param1.equalsIgnoreCase(param12));
    }

    public List OIo0() {
        return this.OOIo;
    }

    public boolean CameraClipModule(PlayerEntity param1) {
        return this.OI0o(param1.getGameProfile().name());
    }

    @Override
    public void OIoI(JsonElement param1) {
        this.OOIo.clear();
        if (param1 == null || !param1.isJsonObject()) {
            return;
        }
        JsonElement v2 = param1.getAsJsonObject().get("friends");
        if (v2 == null || !v2.isJsonArray()) {
            return;
        }
        for (JsonElement v4 : v2.getAsJsonArray()) {
            this.OOIo.add(v4.getAsString());
        }
    }

    static {
        __k__gH4it = ConfigSupport_0II.__k__gH4it((long)8057843981838446097L);
        __rP__gH4it0 = new String[]{"\u9f5e\u4af4\u945c\uc1b1\u4962\u89c2\uc56e\u980d\u9050\u459e"};
        __rP__gH4it1 = new String[]{"\u9f48\u4ae7\u9447\uc1c4\u4912\u89b5\uc517\u9816\u9054\u45e1\u9b5f\uceb0\u499c\u889f\uc44d\u9965\u9198\u44fb\u9a0a\ucfbc", "\u9f4e\u4af9\u9444\uc1d9\u4972\u89d1\uc573"};
        __rP__gH4it2 = new String[]{"\u9f72\u4a98\u943d\uc182\u491a\u89dc\uc5cd\u98fb", "\u9f4b\u4ae4\u944c\uc1d8\u497b"};
        __rP__gH4it3 = new String[]{"\u9f3c\u4a85\u9479\uce2a\u491d\u894e\uc5e9\u9826\u9046\u45d4\u9b26\uceda\u4806\u88b4\uc46c\u9972\u91e7\u44f2\u9a6e\ucf29\u4bce\u8bb8\uc747\u9a07\u9251\u4729\u9978\uccd1\u4a1e\u8a57\uc621\u9b3a\u93c3\u468b\u98d2\ucd61\u4a8e\u8ddc\uc1ef\u9cd5\u94f9\u415a\u9f2a\ucaf6\u4d45\u8cf7\uc06a\u9d8b\u957b\u4071\u9e02\ucbee\u4c26\u8f32\uc365\u9eb4", "\u9f5c\u4aea\u9442\uc1b3\u4960\u89c4\uc568\u980f\u9052\u4590", "\u9f5e\u4af1\u9455"};
        byte[] v0 = "\u0018OE)T\u00a1\u00a5\u0007Zf\"!GS([\u00f3Hb\u00da\u0097G\u001b6]\u008bl:O\u00a0u\u0003\u00c7!\u00ce\u0082'\u0013\u00c3\u00d4\u0005\u00c8N-\u00e40N\u0082\u008f\u00ebn=\u009f\u00edY\u00a5".getBytes("ISO_8859_1");
        Object[] v1 = "d /oA!\u0097\u00cc".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1296117684;
                case 1 -> -1866839161;
                case 2 -> 861675094;
                case 3 -> -540570237;
                case 4 -> 1474152970;
                case 5 -> 997683340;
                case 6 -> -1327900919;
                case 7 -> 993360512;
                case 8 -> 1857514591;
                case 9 -> 2122585798;
                case 10 -> -1655873800;
                case 11 -> -1210689790;
                case 12 -> 2067139653;
                case 13 -> 909948165;
                case 14 -> -809159782;
                case 15 -> -1230827573;
                case 16 -> 1489098664;
                case 17 -> -64282702;
                case 18 -> -1838234050;
                case 19 -> -1568645069;
                case 20 -> -982184932;
                case 21 -> 1403575120;
                case 22 -> 1246246319;
                case 23 -> 1848501181;
                case 24 -> -590702578;
                case 25 -> 175970406;
                case 26 -> -120281095;
                case 27 -> 803633486;
                case 28 -> -1345542721;
                case 29 -> 1838792296;
                case 30 -> 770790373;
                case 31 -> 1829888713;
                case 32 -> 960143228;
                case 33 -> -1740606859;
                case 34 -> 893744929;
                case 35 -> 1110337832;
                case 36 -> 1769251700;
                case 37 -> -15620857;
                case 38 -> 296204040;
                case 39 -> -1173038752;
                case 40 -> 1517582955;
                case 41 -> 638911309;
                case 42 -> 1165473736;
                case 43 -> 2066233338;
                case 44 -> -1241875194;
                case 45 -> -2115252783;
                case 46 -> -1852642190;
                case 47 -> 1143334946;
                case 48 -> 1771508110;
                case 49 -> -28115201;
                case 50 -> 427288222;
                case 51 -> 1281509028;
                case 52 -> 1134532749;
                case 53 -> -1071363589;
                case 54 -> -1701077023;
                case 55 -> 2005453043;
                case 56 -> 2074605804;
                case 57 -> 73546928;
                case 58 -> 1126729615;
                case 59 -> -625590728;
                case 60 -> 1460152214;
                case 61 -> -1714605435;
                case 62 -> -644389790;
                case 63 -> 1932973794;
                case 64 -> -1870179977;
                case 65 -> 1413729604;
                case 66 -> 1057894766;
                case 67 -> 1033423058;
                case 68 -> 1337757223;
                case 69 -> 168501990;
                case 70 -> 1383176237;
                case 71 -> 1633681345;
                case 72 -> -615564894;
                case 73 -> -2008555103;
                case 74 -> 232372892;
                case 75 -> -1581902456;
                case 76 -> -1220583765;
                case 77 -> 1723009070;
                case 78 -> -1679601956;
                case 79 -> 691366436;
                case 80 -> 536923712;
                case 81 -> -2144730583;
                case 82 -> -1839044991;
                case 83 -> 2107981138;
                case 84 -> 1119476076;
                case 85 -> -278708266;
                case 86 -> 2089568132;
                case 87 -> -1956118084;
                case 88 -> -861882215;
                case 89 -> -233990953;
                case 90 -> 738341081;
                case 91 -> 1455187579;
                case 92 -> 1837175523;
                case 93 -> -1036909787;
                case 94 -> -1367408049;
                case 95 -> -1106985203;
                case 96 -> 1445285914;
                case 97 -> -485183066;
                case 98 -> 1367742987;
                case 99 -> -1957707134;
                case 100 -> 418745435;
                case 101 -> 894119018;
                case 102 -> 1586616156;
                case 103 -> -946285223;
                case 104 -> 1272467010;
                case 105 -> 1653296170;
                case 106 -> -2061200103;
                case 107 -> 920999663;
                case 108 -> -327189978;
                case 109 -> 1712799832;
                case 110 -> -1794694123;
                case 111 -> 751279053;
                case 112 -> -2045900143;
                case 113 -> -2015319781;
                case 114 -> -701762139;
                case 115 -> -1943562874;
                case 116 -> 111773001;
                case 117 -> -2017080556;
                case 118 -> 358517601;
                case 119 -> -21212386;
                case 120 -> -816559279;
                case 121 -> -1058462338;
                case 122 -> 1230697099;
                case 123 -> -274673958;
                case 124 -> -291757283;
                case 125 -> 475338229;
                case 126 -> 1801534382;
                case 127 -> -64897290;
                case 128 -> 1769646567;
                case 129 -> -215856806;
                case 130 -> -317373569;
                case 131 -> -1249287372;
                case 132 -> -1686404320;
                case 133 -> -865002517;
                case 134 -> -876916788;
                case 135 -> 1099528890;
                case 136 -> -636059789;
                case 137 -> -806145573;
                case 138 -> 317078435;
                case 139 -> -1540173153;
                case 140 -> -714473039;
                case 141 -> 63169266;
                case 142 -> 649346159;
                case 143 -> -110283139;
                case 144 -> 2086954400;
                case 145 -> 19089607;
                case 146 -> 604210648;
                case 147 -> 1138333242;
                case 148 -> 707867501;
                case 149 -> -795799346;
                case 150 -> 1272465708;
                case 151 -> -1758218424;
                case 152 -> 1890143213;
                case 153 -> -2147399581;
                case 154 -> -893263336;
                case 155 -> -1813525929;
                case 156 -> 768834921;
                case 157 -> -961093736;
                case 158 -> 1168449374;
                case 159 -> 1810082107;
                case 160 -> -1552609177;
                case 161 -> 2129957348;
                case 162 -> -1221722065;
                case 163 -> -185423307;
                case 164 -> -980926583;
                case 165 -> -814851306;
                case 166 -> 613115061;
                case 167 -> -831635561;
                case 168 -> -781666644;
                case 169 -> -898444081;
                case 170 -> 423322183;
                case 171 -> -167979032;
                case 172 -> -907769990;
                case 173 -> -530256143;
                case 174 -> 1222076841;
                case 175 -> -1531205097;
                case 176 -> -1637735152;
                case 177 -> 1804863076;
                case 178 -> 121327261;
                case 179 -> 986151150;
                case 180 -> 1664245642;
                case 181 -> -1911995861;
                case 182 -> -615324304;
                case 183 -> -706520880;
                case 184 -> 288323072;
                case 185 -> -1547786237;
                case 186 -> 1804457778;
                case 187 -> -532930497;
                case 188 -> 557360396;
                case 189 -> 1311075132;
                case 190 -> -1934507419;
                case 191 -> 289015990;
                case 192 -> 120314160;
                case 193 -> 237394737;
                case 194 -> -1061229401;
                case 195 -> -1690727739;
                case 196 -> -168464958;
                case 197 -> 153119661;
                case 198 -> -467928322;
                case 199 -> 1629465852;
                case 200 -> 2103968851;
                case 201 -> -787035591;
                case 202 -> -679377431;
                case 203 -> 1296901572;
                case 204 -> -385023111;
                case 205 -> 1233189699;
                case 206 -> 1566999261;
                case 207 -> 867638211;
                case 208 -> -549441579;
                case 209 -> 1313136318;
                case 210 -> 507169947;
                case 211 -> -232560150;
                case 212 -> -1880134572;
                case 213 -> -225727048;
                case 214 -> 1473071222;
                case 215 -> -554592300;
                case 216 -> -461263857;
                case 217 -> -1365228015;
                case 218 -> 1712287297;
                case 219 -> -1749480700;
                case 220 -> 351699767;
                case 221 -> -401188205;
                case 222 -> 1581268811;
                case 223 -> 681056682;
                case 224 -> -343801612;
                case 225 -> -77640673;
                case 226 -> -307960608;
                case 227 -> -1969820236;
                case 228 -> -570515216;
                case 229 -> 2062213117;
                case 230 -> -1567261513;
                case 231 -> 104626832;
                case 232 -> 633969587;
                case 233 -> 859766101;
                case 234 -> -1912020805;
                case 235 -> -22876142;
                case 236 -> -1321480000;
                case 237 -> -1101844514;
                case 238 -> -1657642567;
                case 239 -> -1673764718;
                case 240 -> 1614024961;
                case 241 -> -265183453;
                case 242 -> 1114685041;
                case 243 -> 1146063764;
                case 244 -> -1924293430;
                case 245 -> 615034359;
                case 246 -> -1560421315;
                case 247 -> 2118125405;
                case 248 -> -1448611530;
                case 249 -> -1091209654;
                case 250 -> -406648865;
                case 251 -> 154417557;
                case 252 -> 1205037011;
                case 253 -> -503260090;
                case 254 -> -340938376;
                case 255 -> 1457442067;
                default -> -1647828461;
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
            Object[] objectArray = new Object[2];
            v1 = objectArray;
            GuiSupport_OOII = objectArray;
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

