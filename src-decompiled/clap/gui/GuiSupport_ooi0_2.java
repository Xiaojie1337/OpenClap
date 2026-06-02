/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.sound.SoundEvents
 */
package clap.gui;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import clap.gui.component.GuiComponent;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.Ooi0
 */
public class GuiSupport_ooi0_2
extends GuiComponent {
    private final MinecraftClient HelpCommand = MinecraftClient.getInstance();
    private boolean Ooi;
    private boolean ConfigSupport_OI0;
    private boolean OoI;
    private boolean KeystrokesHudElement;
    private final Setting PacketEvent;
    private float[] OIo;
    static Object ConfigSupport_OII;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public float OIo() {
        return this.OoI ? this.O0o + 100.0f : this.O0o;
    }

    @Override
    public String HelpCommand(int param1, int param2) {
        if (!this.Ooo(param1, param2)) {
            return null;
        }
        String v3 = this.PacketEvent.Oi0();
        return v3 == null || v3.isEmpty() ? null : v3;
    }

    public GuiSupport_ooi0_2(Setting param1, float param2, float param3, float param4, float param5) {
        super(param2, param3, param4, param5);
        this.PacketEvent = param1;
        Color v6 = (Color)param1.HelpCommand();
        this.OIo = Color.RGBtoHSB(v6.getRed(), v6.getGreen(), v6.getBlue(), null);
    }

    private void OiI(DrawContext param1, int param2, int param3) {
        Color v20;
        float v4 = this.HudElement + this.O0o;
        float v7 = this.EventBusApi - 8.0f;
        float v9 = this.OOi + 4.0f;
        float v10 = v4 + 4.0f;
        GuiSupport_oi0o_0.OOoiO(param1, this.OOi, v4, this.OOi + this.EventBusApi, v4 + 100.0f, new Color(40, 40, 40, 240).getRGB());
        Color v11 = Color.getHSBColor(this.OIo[0], 1.0f, 1.0f);
        GuiSupport_oi0o_0.OOIOI(param1, v9, v10, v9 + v7, v10 + 60.0f, Color.WHITE, v11);
        GuiSupport_oi0o_0.OOIOi(param1, v9, v10, v9 + v7, v10 + 60.0f, new Color(0, 0, 0, 0), Color.BLACK);
        if (this.KeystrokesHudElement) {
            this.OIo[1] = this.DataRecord_0O0(((float)param2 - v9) / v7);
            this.OIo[2] = this.DataRecord_0O0(1.0f - ((float)param3 - v10) / 60.0f);
            this.Oii();
        }
        float v12 = v9 + this.OIo[1] * v7;
        float v13 = v10 + (1.0f - this.OIo[2]) * 60.0f;
        GuiSupport_oi0o_0.OOoiO(param1, v12 - 1.5f, v13 - 1.5f, v12 + 1.5f, v13 + 1.5f, -1);
        GuiSupport_oi0o_0.OOoiO(param1, v12 - 0.5f, v13 - 0.5f, v12 + 0.5f, v13 + 0.5f, Color.BLACK.getRGB());
        float v15 = v10 + 60.0f + 4.0f;
        int v222 = 0;
        while ((float)v222 < v7) {
            int v17 = Color.HSBtoRGB((float)v222 / v7, 1.0f, 1.0f);
            GuiSupport_oi0o_0.OOoiO(param1, v9 + (float)v222, v15, v9 + (float)v222 + 1.0f, v15 + 8.0f, v17);
            ++v222;
        }
        if (this.Ooi) {
            this.OIo[0] = this.DataRecord_0O0(((float)param2 - v9) / v7);
            this.Oii();
        }
        float v222 = v9 + this.OIo[0] * v7;
        GuiSupport_oi0o_0.OOoiO(param1, v222 - 1.0f, v15, v222 + 1.0f, v15 + 8.0f, -1);
        float v17 = v15 + 8.0f + 4.0f;
        this.ConfigSupport_0OO(param1, v9, v17, v9 + v7, v17 + 8.0f);
        Color v18 = new Color(Color.HSBtoRGB(this.OIo[0], this.OIo[1], this.OIo[2]));
        GuiSupport_oi0o_0.OOIOI(param1, v9, v17, v9 + v7, v17 + 8.0f, new Color(v18.getRed(), v18.getGreen(), v18.getBlue(), 0), v18);
        if (this.ConfigSupport_OI0) {
            int v19 = (int)(this.DataRecord_0O0(((float)param2 - v9) / v7) * 255.0f);
            v20 = (Color)this.PacketEvent.HelpCommand();
            this.PacketEvent.OOo(new Color(v20.getRed(), v20.getGreen(), v20.getBlue(), v19));
        }
        float v19 = v9 + (float)((Color)this.PacketEvent.HelpCommand()).getAlpha() / 255.0f * v7;
        GuiSupport_oi0o_0.OOoiO(param1, v19 - 1.0f, v17, v19 + 1.0f, v17 + 8.0f, -1);
        v20 = (Color)this.PacketEvent.HelpCommand();
        String v21 = String.format("R:%d G:%d B:%d A:%d", v20.getRed(), v20.getGreen(), v20.getBlue(), v20.getAlpha());
        param1.drawText(this.HelpCommand.textRenderer, v21, (int)v9, (int)(v17 + 8.0f + 2.0f), -5592406, true);
    }

    @Override
    public void GuiSupport_OOI(double param1, double param3, int param5) {
        this.Ooi = false;
        this.KeystrokesHudElement = false;
        this.ConfigSupport_OI0 = false;
    }

    private void Oii() {
        int v1 = Color.HSBtoRGB(this.OIo[0], this.OIo[1], this.OIo[2]);
        Color v2 = new Color(v1);
        this.PacketEvent.OOo(new Color(v2.getRed(), v2.getGreen(), v2.getBlue(), ((Color)this.PacketEvent.HelpCommand()).getAlpha()));
    }

    static {
        __k__gH4it = GuiSupport_ooi0_2.__k__gH4it(-5830260454307402223L);
        __rP__gH4it0 = new String[]{"\u27e8\u7216\uad78\uf956\u7e47\u6ca1\u1c91\uaf0c\u26f6\u737c", "\u27ea\u7214\uad7e\uf950\u7e45\u6ca3\u1c9f\uaf02\u26f4\u737e", "\u27f8\u7207\uad78\uf92a\u7e47\u6ca6\u1c94"};
        __rP__gH4it1 = new String[]{"\u27fd\u721e\uad78\uf92f\u7e4e"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\u272b\u7246\uadaa\uf889\u7ee6\u6c8e\u1c11\uaf5f\u2643\u7370\uac8c\uf959\u61d0\u73a3\u03e3\ub0db\u396e\u6c2b\ub3d5\ue606\u6046\u7243\u0288\ub1fb\u386e\u6d4b\ub20f\ue7f4\u63f2\u7117\u012e\ub2e2\u3bfa\u6ef1\ub10b\ue46f\u63e9\u7020\u00c6\ub30b\u3a7e\u6fd3\ub042\ue5bf\u62f3\u779c\u0758\ub40b\u3dbe\u68ee\ub781\ue26d\u6571\u76cc\u06ab\ub5b3", "\u27dc\u729b\uad4c\uf990\u7eb9\u6cb5\u1c02\uaf64", "\u27fe\u7219\uad7b\uf93f\u7e27\u6cc2\u1cf0\uaf13\u26f2\u730f\uac73\ue65b\u6149\u73c8\u03ca\ub050\u39ce\u6c25\ub356\ue767", "\u27e8\u7273\uad51"};
        byte[] v0 = "\u00b9r\u00aaq\u00aaf\u008a\u009b\u00d9L\u0084\u00a9\u0094Cp\u0007\u00ec\u000f\u00c5\u00ee\u001a\u00bb\u0003/\u00e4g\u0017\u0014\u00a6\u00e7\u00ad\u000e\u0088\u00e5k\u00b7E\u00e8=\u00ef\u0004\u00cf*oW\\\u00ab\u00f7\u00dc\u00ea\u00f1\u00a5\u00cd\u0014@G".getBytes("ISO_8859_1");
        Object[] v1 = "|\u00d9z\u009a\u00c7#\u00a7R".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1216242669;
                case 1 -> 1048258873;
                case 2 -> 1154401007;
                case 3 -> -1309964141;
                case 4 -> 1044537805;
                case 5 -> 940677021;
                case 6 -> -1387134367;
                case 7 -> 971427341;
                case 8 -> -1285307703;
                case 9 -> 1679404647;
                case 10 -> 269380750;
                case 11 -> 769283463;
                case 12 -> 1323166401;
                case 13 -> -1690975347;
                case 14 -> -1787628789;
                case 15 -> -420219750;
                case 16 -> -1951958954;
                case 17 -> -463134712;
                case 18 -> 907624781;
                case 19 -> 647708108;
                case 20 -> 1542610982;
                case 21 -> 136342464;
                case 22 -> 416181422;
                case 23 -> 448603681;
                case 24 -> 93712391;
                case 25 -> -180081126;
                case 26 -> -37798908;
                case 27 -> 347849517;
                case 28 -> 2102645795;
                case 29 -> 740752831;
                case 30 -> -1221514176;
                case 31 -> -1803209104;
                case 32 -> 136730866;
                case 33 -> 235733594;
                case 34 -> -1324314288;
                case 35 -> 1004749866;
                case 36 -> -36200486;
                case 37 -> -100471309;
                case 38 -> 1882173186;
                case 39 -> 591866609;
                case 40 -> 1141275164;
                case 41 -> 407279511;
                case 42 -> -140926531;
                case 43 -> -412379293;
                case 44 -> -1514725777;
                case 45 -> -1425813894;
                case 46 -> -1860743976;
                case 47 -> -933171094;
                case 48 -> 115008553;
                case 49 -> -2104484414;
                case 50 -> 1832112001;
                case 51 -> -449427658;
                case 52 -> -1373911964;
                case 53 -> -1531411241;
                case 54 -> -2114900983;
                case 55 -> 900963902;
                case 56 -> 1592613176;
                case 57 -> 1851814297;
                case 58 -> -2060119316;
                case 59 -> 1941987761;
                case 60 -> -1146194836;
                case 61 -> 350321688;
                case 62 -> -1811871683;
                case 63 -> -363118247;
                case 64 -> -1329356494;
                case 65 -> -712008278;
                case 66 -> 956850854;
                case 67 -> -1229535890;
                case 68 -> 1598304544;
                case 69 -> -1111623309;
                case 70 -> -144065003;
                case 71 -> -1285537411;
                case 72 -> -715615029;
                case 73 -> 1893494060;
                case 74 -> 410579969;
                case 75 -> 730665812;
                case 76 -> -1526587634;
                case 77 -> -586779768;
                case 78 -> 1222751664;
                case 79 -> -536589077;
                case 80 -> 888245226;
                case 81 -> 1558189992;
                case 82 -> 289031299;
                case 83 -> -2049367064;
                case 84 -> 731041316;
                case 85 -> 1344668559;
                case 86 -> -1683944260;
                case 87 -> 193781106;
                case 88 -> 399118123;
                case 89 -> -148771589;
                case 90 -> -1435046363;
                case 91 -> -780858145;
                case 92 -> 373742550;
                case 93 -> 411360030;
                case 94 -> 2129895141;
                case 95 -> -122861989;
                case 96 -> -1827674954;
                case 97 -> 826089181;
                case 98 -> -2140120576;
                case 99 -> -1230389993;
                case 100 -> -298131812;
                case 101 -> 720755663;
                case 102 -> 1108923982;
                case 103 -> -1661839922;
                case 104 -> 233397355;
                case 105 -> -1538616052;
                case 106 -> -2089208737;
                case 107 -> 1122248646;
                case 108 -> 802989851;
                case 109 -> 93922068;
                case 110 -> -1537519798;
                case 111 -> 617710820;
                case 112 -> 1468006780;
                case 113 -> 50385658;
                case 114 -> -590037994;
                case 115 -> -1497959357;
                case 116 -> -748040612;
                case 117 -> -540685987;
                case 118 -> 847923689;
                case 119 -> 1799206975;
                case 120 -> -1404466795;
                case 121 -> 624682170;
                case 122 -> 1665457108;
                case 123 -> -265629864;
                case 124 -> -1740533337;
                case 125 -> 1741459737;
                case 126 -> -834737666;
                case 127 -> 434344138;
                case 128 -> -704045509;
                case 129 -> -874549731;
                case 130 -> 944836321;
                case 131 -> -425770830;
                case 132 -> 1008992887;
                case 133 -> -358238025;
                case 134 -> 1050103312;
                case 135 -> 1768901878;
                case 136 -> -951913630;
                case 137 -> 1749334392;
                case 138 -> 2123375906;
                case 139 -> -742518878;
                case 140 -> 280529109;
                case 141 -> 1910232229;
                case 142 -> 894529832;
                case 143 -> 1132345031;
                case 144 -> -1340330925;
                case 145 -> -1499014533;
                case 146 -> 410961937;
                case 147 -> 860045388;
                case 148 -> -1829394082;
                case 149 -> -599408877;
                case 150 -> -428877690;
                case 151 -> 1511892613;
                case 152 -> -1881074799;
                case 153 -> 926869320;
                case 154 -> 111990189;
                case 155 -> -107242348;
                case 156 -> -1052496476;
                case 157 -> 912364405;
                case 158 -> 735190004;
                case 159 -> -1560702382;
                case 160 -> -1280597778;
                case 161 -> 1442986292;
                case 162 -> 1263241631;
                case 163 -> 1604045200;
                case 164 -> -294155447;
                case 165 -> -1620919883;
                case 166 -> 829109730;
                case 167 -> -2036551303;
                case 168 -> 1743015785;
                case 169 -> -583744191;
                case 170 -> 812023267;
                case 171 -> -405672367;
                case 172 -> -1191861209;
                case 173 -> -666566703;
                case 174 -> -771775360;
                case 175 -> -26991259;
                case 176 -> 1603749508;
                case 177 -> 1128365102;
                case 178 -> 1834052527;
                case 179 -> -1607207712;
                case 180 -> -1633167264;
                case 181 -> 846646802;
                case 182 -> 529882933;
                case 183 -> -838286276;
                case 184 -> -103297887;
                case 185 -> -1064647996;
                case 186 -> -283849131;
                case 187 -> 2032945383;
                case 188 -> 1603231870;
                case 189 -> -202612987;
                case 190 -> 234854469;
                case 191 -> -2105228;
                case 192 -> -1699999760;
                case 193 -> -31133525;
                case 194 -> -152876119;
                case 195 -> -381209470;
                case 196 -> 35060875;
                case 197 -> 1856899801;
                case 198 -> -651146383;
                case 199 -> -852119362;
                case 200 -> -1036305668;
                case 201 -> 447540333;
                case 202 -> -656283255;
                case 203 -> -83702621;
                case 204 -> -713296418;
                case 205 -> -97279164;
                case 206 -> -1942378522;
                case 207 -> 644036867;
                case 208 -> 1782046649;
                case 209 -> -2035495689;
                case 210 -> -456319181;
                case 211 -> 1350787087;
                case 212 -> 1072195990;
                case 213 -> -1256266056;
                case 214 -> 19479259;
                case 215 -> 545378715;
                case 216 -> 1992337554;
                case 217 -> 910199110;
                case 218 -> -381375166;
                case 219 -> -1624339828;
                case 220 -> 2132339387;
                case 221 -> 1982264375;
                case 222 -> -853084264;
                case 223 -> -1461832586;
                case 224 -> -1255055073;
                case 225 -> -370358626;
                case 226 -> 1372079555;
                case 227 -> -1553021780;
                case 228 -> -1012437967;
                case 229 -> -1689854500;
                case 230 -> -813561859;
                case 231 -> 9248006;
                case 232 -> -123842360;
                case 233 -> -589716782;
                case 234 -> 380570036;
                case 235 -> -1826516432;
                case 236 -> 945128762;
                case 237 -> 1988182480;
                case 238 -> -2053804753;
                case 239 -> -1396474957;
                case 240 -> 1626593095;
                case 241 -> -85745833;
                case 242 -> -1784425991;
                case 243 -> -1552796058;
                case 244 -> -1745880123;
                case 245 -> -271910445;
                case 246 -> -659654401;
                case 247 -> -1160498528;
                case 248 -> -1091277323;
                case 249 -> -583756725;
                case 250 -> -261076145;
                case 251 -> 1294139146;
                case 252 -> -307912321;
                case 253 -> -1813064344;
                case 254 -> -698415990;
                case 255 -> 1895131896;
                default -> 1418651063;
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
            ConfigSupport_OII = objectArray;
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

    private float DataRecord_0O0(float param1) {
        return Math.max(0.0f, Math.min(1.0f, param1));
    }

    @Override
    public void PacketEvent(DrawContext param1, int param2, int param3, float param4) {
        Color v5 = this.Ooo(param2, param3) ? new Color(70, 70, 70, 220) : new Color(55, 55, 55, 220);
        GuiSupport_oi0o_0.OOoiO(param1, this.OOi, this.HudElement, this.OOi + this.EventBusApi, this.HudElement + this.O0o, v5.getRGB());
        param1.drawText(this.HelpCommand.textRenderer, this.PacketEvent.PacketEvent(), (int)(this.OOi + 5.0f), (int)(this.HudElement + this.O0o / 2.0f - 4.0f), -1, true);
        float v6 = this.OOi + this.EventBusApi - 15.0f;
        float v7 = this.HudElement + 4.0f;
        this.ConfigSupport_0OO(param1, v6, v7, v6 + 10.0f, v7 + 10.0f);
        GuiSupport_oi0o_0.OOoiO(param1, v6, v7, v6 + 10.0f, v7 + 10.0f, ((Color)this.PacketEvent.HelpCommand()).getRGB());
        if (this.OoI) {
            this.OiI(param1, param2, param3);
        }
    }

    @Override
    public void OOo(double param1, double param3, int param5) {
        if ((param5 == 0 || param5 == 1) && this.Ooo((int)param1, (int)param3)) {
            this.OoI = !this.OoI;
            this.OoO();
            return;
        }
        if (param5 != 0 || !this.OoI) {
            return;
        }
        float v6 = this.HudElement + this.O0o;
        float v8 = this.EventBusApi - 8.0f;
        float v11 = this.OOi + 4.0f;
        float v12 = v6 + 4.0f;
        float v13 = v12 + 60.0f + 4.0f;
        float v14 = v13 + 8.0f + 4.0f;
        if (param1 >= (double)v11 && param1 <= (double)(v11 + v8)) {
            if (param3 >= (double)v12 && param3 <= (double)(v12 + 60.0f)) {
                this.KeystrokesHudElement = true;
            } else if (param3 >= (double)v13 && param3 <= (double)(v13 + 8.0f)) {
                this.Ooi = true;
            } else if (param3 >= (double)v14 && param3 <= (double)(v14 + 8.0f)) {
                this.ConfigSupport_OI0 = true;
            }
        }
    }

    private void OoO() {
        this.HelpCommand.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((RegistryEntry)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
    }

    private void ConfigSupport_0OO(DrawContext param1, float param2, float param3, float param4, float param5) {
        GuiSupport_oi0o_0.OOoiO(param1, param2, param3, param4, param5, -1);
        for (float v7 = param2; v7 < param4; v7 += 4.0f) {
            for (float v8 = param3; v8 < param5; v8 += 4.0f) {
                if (((int)((v7 - param2) / 4.0f) + (int)((v8 - param3) / 4.0f)) % 2 != 1) continue;
                GuiSupport_oi0o_0.OOoiO(param1, v7, v8, v7 + Math.min(4.0f, param4 - v7), v8 + Math.min(4.0f, param5 - v8), -3355444);
            }
        }
    }
}

