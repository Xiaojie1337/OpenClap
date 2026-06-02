/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.item.ItemStack;
import clap.network.NetworkSupport_00OI;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.model.DataRecord_ii0_0;
import clap.setting.Setting;
import clap.render.ScaledDrawContext;

/*
 * Renamed from clap.event.network.PacketEventi
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class InventoryHudElement
extends HudElement {
    private static final String oOOI;
    public Setting 0IiI;
    private static final float oOO0;
    private static final int 0iii;
    public Setting SpawnerFinderModule;
    private static final int oOOO;
    public Setting oO00;
    private static final float 00i;
    public Setting oO0O;
    public Setting 0oi;
    public Setting 0oI;
    private static final float oOOo;
    public Setting 0Ii0;
    public Setting oOOi = this.OOi00("Title", true);
    static Object oO0o;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    protected void O0i(ScaledDrawContext param1) {
        float v8;
        super.O0i(param1);
        if (InventoryHudElement.iooI()) {
            return;
        }
        FontRenderer v2 = NetworkSupport_00OI.OOo(20);
        DataRecord_ii0_0 v3 = this.IoiI(v2);
        float v4 = this.GuiSupport_OOI();
        float v5 = this.OOi();
        PostProcessingModule.IoiO(v4, v5, v3.RenderSupport_ooi_1(), v3.oOi(), this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()), ((Color)this.0oi.HelpCommand()).getRGB());
        for (int v6 = 0; v6 < 3; ++v6) {
            for (int v7 = 0; v7 < 9; ++v7) {
                v8 = v4 + v3.o0O() + (float)v7 * (v3.iOi() + v3.iOI());
                float v9 = v5 + v3.o0O() + v3.i00() + (float)v6 * (v3.iOi() + v3.iOI());
                RenderSupport_00oi_0.O0o(v8, v9, v3.iOi(), v3.iOi(), this.RenderSupport_oii_4((Integer)this.oO0O.HelpCommand()), ((Color)this.0Ii0.HelpCommand()).getRGB());
                ItemStack v10 = InventoryHudElement.ConfigSupport_OI0.player.method_31548().method_5438(9 + v6 * 9 + v7);
                if (v10.isEmpty()) continue;
                this.Ioii(param1, v10, v8, v9, v3.iOi(), v3.WorldTimeModule());
            }
        }
        if (((Boolean)this.oOOi.HelpCommand()).booleanValue()) {
            float v6 = 0.5f * this.OIo();
            float v7 = v4 + v3.o0O();
            v8 = v5 + v3.o0O() - (float)this.RenderSupport_oii_4(1);
            RenderSupport_00oi_0.HudElement(() -> {
                param1.ConfigSupport_O0I().getMatrices().pushMatrix();
                param1.ConfigSupport_O0I().getMatrices().scale(v6, v6);
                v2.PacketEvent(param1.ConfigSupport_O0I(), "Inventory", v7 / v6, v8 / v6, ((Color)this.0IiI.HelpCommand()).getRGB());
                param1.ConfigSupport_O0I().getMatrices().popMatrix();
            });
        }
        this.Oii(v4, v5, v3.RenderSupport_ooi_1(), v3.oOi());
    }

    private DataRecord_ii0_0 IoiI(FontRenderer param1) {
        float v2 = this.RenderSupport_oii_4(18);
        float v3 = this.RenderSupport_oii_4((Integer)this.oO00.HelpCommand());
        float v4 = this.RenderSupport_oii_4((Integer)this.SpawnerFinderModule.HelpCommand());
        float v5 = 0.0f;
        if (((Boolean)this.oOOi.HelpCommand()).booleanValue()) {
            v5 = (float)Math.round((float)param1.OOi() * 0.5f * this.OIo()) + this.ConfigSupport_OII(2.0f);
        }
        float v6 = 9.0f * v2 + 8.0f * v3;
        float v7 = 3.0f * v2 + 2.0f * v3;
        float v8 = v6 + v4 * 2.0f;
        float v9 = v7 + v4 * 2.0f + v5;
        float v10 = Math.max(0.5f, (v2 - this.ConfigSupport_OII(1.0f) * 2.0f) / 16.0f);
        return new DataRecord_ii0_0(v8, v9, v4, v3, v2, v10, v5);
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        if (InventoryHudElement.iooI()) {
            return;
        }
        DataRecord_ii0_0 v2 = this.IoiI(NetworkSupport_00OI.OOo(20));
        PostProcessingModule.Ioio(this.GuiSupport_OOI(), this.OOi(), v2.RenderSupport_ooi_1(), v2.oOi(), this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()));
    }

    private void Ioii(ScaledDrawContext param1, ItemStack param2, float param3, float param4, float param5, float param6) {
        float v7 = 16.0f * param6;
        float v8 = param3 + (param5 - v7) * 0.5f;
        float v9 = param4 + (param5 - v7) * 0.5f;
        param1.ConfigSupport_O0I().getMatrices().pushMatrix();
        param1.ConfigSupport_O0I().getMatrices().translate(v8, v9);
        param1.ConfigSupport_O0I().getMatrices().scale(param6, param6);
        param1.ConfigSupport_O0I().drawItem(param2, 0, 0);
        param1.ConfigSupport_O0I().drawStackOverlay(InventoryHudElement.ConfigSupport_OI0.textRenderer, param2, 0, 0);
        param1.ConfigSupport_O0I().getMatrices().popMatrix();
    }

    public InventoryHudElement() {
        super("InventoryHUD", "Display main inventory", 180.0f, 74.0f);
        this.0oI = this.OOi0o("Radius", 8, 0, 18);
        this.oO0O = this.OOi0o("SlotRadius", 4, 0, 12);
        this.oO00 = this.OOi0o("SlotGap", 3, 0, 8);
        this.SpawnerFinderModule = this.OOi0o("Padding", 6, 2, 14);
        this.0oi = this.OOioo("BackgroundColor", 18, 18, 24, 128);
        this.0Ii0 = this.OOioo("SlotColor", 255, 255, 255, 24);
        this.0IiI = this.OOioo("TitleColor", 215, 227, 240, 255);
    }

    static {
        __k__gH4it = InventoryHudElement.__k__gH4it(5667461765537984017L);
        __rP__gH4it0 = new String[]{"\uc623\u5139\u8fc6\uda57\u5dfc\ua953\u01c5"};
        __rP__gH4it1 = new String[]{"\uc633\u512c\u8fc6\uda2f\u5dfc\ua958\u01c0\u8c5b\uc73d\u5056", "\uc667\u5101\u8f1f\uda23\u5d23\ua952\u01af\u8c58", "\uc631\u512a\u8fc0\uda2d\u5dfe\ua946\u01de\u8c59\uc73f\u5050", "\uc625\u5123\u8fc5\uda46\u5d9c\ua93b\u01a1\u8c44\uc739\u5025\u8edd\udb32\u5ce2\ua821\u00fb\u8d37\uc7f5\u533f\u8d88\ud83e", "\uc626\u5120\u8fc6\uda52\u5df5"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\uc679\u512b\u8f4f\udbd8\u5c3f\ua82f\u00ef\u8d61\uc76e\u50c3\u8e10\ud8f6\u5f5e\uab70\u03cc\u8e04\uc476\u53d1\u8d6c\ud960\u5ea7\uaa9c\u0280\u8f6e\uc50b\u5295\u8c8e\ud9ad\u4185\ub51d\u1dfe\u906c\udaab\u4db6\u932e\uc6f0\u403d\ub41b\u1cc8\u9193\udb75\u4c0d\u923b\uc7e8\u436f\ub78a\u1fbe\u92c8\ud8a5\u4f7f\u9156\uc43f\u423b\ub6e3\u1e9a\u933e\ud9eb\u4e80\u907e\uc510\u4291\ub1db\u193e\u94c0\udec7\u4917\u9750\uc244\u45eb\ub0d4\u185d\u9532\udf71\u48bd\u96ba\uc34a\u44f3\ub371\u1b4e\u96f5\udc8c\u4b2d\u956d\uc01f\u47b8\ub239\u1a09\u97dc\udd4b\u4a95\u94c9\uc1fb\u46c3\ub21c\u15da\u98c7\ud23c\u45a0\u9bb5\uceec\u49f1\ubd77\u140c\u995f\ud36c\u446e\u9adb\ucfea\u480c\ubc67\u1780\u9a97\ud08f\u4707\u9953\ucc84\u4be4\ubf17\u179d\u9b2b\ud1ee\u4625\u98f0\ucdab\u4a0c\ube96\u1654\u9caa\ud660\u4111\u9f34\uca12\u4da1\ub92d\u114c\u9dec\ud784\u4045\u9e6d\ucb5f\u4c33\ub8d8\u1055\u9e8f\ud428\u4323\u9da4\uc884\u4fc6\ubb78\u13e0\u9e36\ud571\u420f\u9c16\uc985\u4e85\ubada\u12c0\u9fbb\ueada\u7dbb\ua34c\uf617\u7108\u85a0\u2d00\ua0e2", "\uc633\u5135\u8fd7"};
        byte[] v0 = "\u00a0\u00b5a\u00c9X\u00ae\u00a5b\u00afE&\u00ff!\u00e9\u008e\u000f\u00bf_Ra\u00d0\r\u00fa\u009d\u00fac\u0088T\u00ca\u00f4\u008c\u0097RH \u0001z\u00fa\u00a2p\u0094\u00eb-\u00010s\u00dc#L\u0091H\u00del\u0012\u0080\u00ed\u00faV\u0018\u00c9>\u0012,\u001b\u00de\u00c9>\u0095L\u0015W\u00f1p{\u00cc\u0083L\u00a8L>\u0085\u00e3\u0013\u00de\u000f\u00e83oz\u00a3\u008fBL5\u00e8|\u0005\u009e\u00fb]vV&\u00fcMH\u008dC\u0093^\u00a2<\u00a6)\r%s&G\u00b8\u00bf3V2\u00e3\u009f\u008619\u000f\u009a\u0083F,\u0086o\u00c5C\u00db\u00d6\u00cc\u00c1\u0097\u0004a-\u001a\u00051i\u001aE\u0000y\u0090\u00fcJ\u00b32\u00c0\u00a3\u00c5\u00c2f\u00cf\u00c1\u00ea\u0081".getBytes("ISO_8859_1");
        Object[] v1 = "\u001c}\u0097T\u00e61[%".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 2039420452;
                case 1 -> 870626206;
                case 2 -> -980691758;
                case 3 -> 58564210;
                case 4 -> -1048818720;
                case 5 -> 1519077405;
                case 6 -> -1795354782;
                case 7 -> 256962536;
                case 8 -> 668162745;
                case 9 -> -2092798481;
                case 10 -> 1812547886;
                case 11 -> 1011794917;
                case 12 -> -872288933;
                case 13 -> 935274204;
                case 14 -> -624074854;
                case 15 -> 1748070020;
                case 16 -> 589987622;
                case 17 -> -436246943;
                case 18 -> -30285050;
                case 19 -> -307478662;
                case 20 -> 1647763461;
                case 21 -> -598629694;
                case 22 -> 2087652641;
                case 23 -> -1296270590;
                case 24 -> -1792382520;
                case 25 -> 570871833;
                case 26 -> -1525312471;
                case 27 -> 423265108;
                case 28 -> -794701236;
                case 29 -> 364810032;
                case 30 -> 778307603;
                case 31 -> 956556604;
                case 32 -> -1127550364;
                case 33 -> 755261919;
                case 34 -> -335114386;
                case 35 -> -1487897749;
                case 36 -> -318834557;
                case 37 -> -1057999880;
                case 38 -> -455529212;
                case 39 -> -313397838;
                case 40 -> 550358447;
                case 41 -> -1611947252;
                case 42 -> 740491128;
                case 43 -> 39721334;
                case 44 -> -1024345785;
                case 45 -> -119490313;
                case 46 -> 1229128257;
                case 47 -> -925219152;
                case 48 -> 479099983;
                case 49 -> -416413679;
                case 50 -> 489509776;
                case 51 -> -366595313;
                case 52 -> -1617990786;
                case 53 -> 1812426011;
                case 54 -> -1851651400;
                case 55 -> 170086811;
                case 56 -> 103568083;
                case 57 -> 1755961815;
                case 58 -> -789245284;
                case 59 -> 1206237253;
                case 60 -> 2010455118;
                case 61 -> 1480317762;
                case 62 -> -791632766;
                case 63 -> 1407302884;
                case 64 -> 1497402354;
                case 65 -> 798748122;
                case 66 -> 80890048;
                case 67 -> 365045312;
                case 68 -> 1448769445;
                case 69 -> 939041557;
                case 70 -> -1585676738;
                case 71 -> 1245734559;
                case 72 -> -980259258;
                case 73 -> -1373750968;
                case 74 -> -487228656;
                case 75 -> -1659281654;
                case 76 -> -187456040;
                case 77 -> -551012051;
                case 78 -> -542272903;
                case 79 -> 1372492422;
                case 80 -> -1115978860;
                case 81 -> -889379668;
                case 82 -> 59651815;
                case 83 -> 1754055875;
                case 84 -> -432778473;
                case 85 -> -1595581358;
                case 86 -> -16992361;
                case 87 -> -2138147926;
                case 88 -> 602789579;
                case 89 -> -1041385930;
                case 90 -> -1140187253;
                case 91 -> 1205970488;
                case 92 -> -1098531827;
                case 93 -> 450458228;
                case 94 -> 1843119939;
                case 95 -> -1495400730;
                case 96 -> 105794984;
                case 97 -> 1399754737;
                case 98 -> -1863408926;
                case 99 -> -1391394534;
                case 100 -> 1975632381;
                case 101 -> 1847763598;
                case 102 -> 1620133566;
                case 103 -> -1825303644;
                case 104 -> -493548858;
                case 105 -> 1625142647;
                case 106 -> -317773695;
                case 107 -> 2065731173;
                case 108 -> -616228046;
                case 109 -> 15454057;
                case 110 -> 1355393539;
                case 111 -> 1491858412;
                case 112 -> -697965540;
                case 113 -> 1485647232;
                case 114 -> 388096044;
                case 115 -> 413081802;
                case 116 -> 1336579870;
                case 117 -> 1595953967;
                case 118 -> 2027956958;
                case 119 -> 1872299626;
                case 120 -> 940763033;
                case 121 -> -991926637;
                case 122 -> -1124788440;
                case 123 -> 954094317;
                case 124 -> 589389179;
                case 125 -> 1944425843;
                case 126 -> -1807671831;
                case 127 -> -174263346;
                case 128 -> -2034570658;
                case 129 -> -390303429;
                case 130 -> 1372004871;
                case 131 -> 1480820326;
                case 132 -> -426748641;
                case 133 -> 549744139;
                case 134 -> 948431559;
                case 135 -> 1039794953;
                case 136 -> 1391867282;
                case 137 -> -1831530845;
                case 138 -> -343747403;
                case 139 -> 1498035367;
                case 140 -> -1239905459;
                case 141 -> 715937279;
                case 142 -> 758811450;
                case 143 -> 379313076;
                case 144 -> -1111280784;
                case 145 -> 950044789;
                case 146 -> 1088588240;
                case 147 -> 152143911;
                case 148 -> 63484897;
                case 149 -> -1875220397;
                case 150 -> 1111792591;
                case 151 -> -510622757;
                case 152 -> 1873099022;
                case 153 -> -117678877;
                case 154 -> -390349441;
                case 155 -> -1819323809;
                case 156 -> -1315720936;
                case 157 -> -1611777176;
                case 158 -> 1200880128;
                case 159 -> -1326729163;
                case 160 -> 1982290121;
                case 161 -> 1573696491;
                case 162 -> 16069707;
                case 163 -> 415383439;
                case 164 -> 1507603491;
                case 165 -> -1875478169;
                case 166 -> -226953339;
                case 167 -> 307140669;
                case 168 -> 1245004993;
                case 169 -> -1826573750;
                case 170 -> -236341965;
                case 171 -> -1518505554;
                case 172 -> 2116511833;
                case 173 -> -293643155;
                case 174 -> -1347675882;
                case 175 -> 474845704;
                case 176 -> 1576814081;
                case 177 -> 1369804631;
                case 178 -> 423186388;
                case 179 -> -878226646;
                case 180 -> -204951819;
                case 181 -> -173217123;
                case 182 -> -1692702621;
                case 183 -> -1657883051;
                case 184 -> -179944593;
                case 185 -> -378372571;
                case 186 -> -984926537;
                case 187 -> -150613948;
                case 188 -> 1318611769;
                case 189 -> -1079309386;
                case 190 -> 417419936;
                case 191 -> -4570902;
                case 192 -> -1216295006;
                case 193 -> -1317574007;
                case 194 -> 285353689;
                case 195 -> 1693568499;
                case 196 -> 973595700;
                case 197 -> 1358784972;
                case 198 -> -720954561;
                case 199 -> -1743288277;
                case 200 -> 1591890284;
                case 201 -> -1625783928;
                case 202 -> -580558677;
                case 203 -> 1452013959;
                case 204 -> -1457248321;
                case 205 -> -1334237807;
                case 206 -> 1106566029;
                case 207 -> -1880083436;
                case 208 -> 610220081;
                case 209 -> -255815594;
                case 210 -> 1564488265;
                case 211 -> -1370690991;
                case 212 -> -2040918448;
                case 213 -> -1735239723;
                case 214 -> 129044731;
                case 215 -> -1772896363;
                case 216 -> 207700915;
                case 217 -> -1519114323;
                case 218 -> 1694108540;
                case 219 -> -1425371752;
                case 220 -> 336414374;
                case 221 -> -756587651;
                case 222 -> 944882169;
                case 223 -> -854241350;
                case 224 -> 74632503;
                case 225 -> -223372148;
                case 226 -> -148297182;
                case 227 -> -607329030;
                case 228 -> 2136240061;
                case 229 -> -101443330;
                case 230 -> -2008995082;
                case 231 -> 714989400;
                case 232 -> -699384938;
                case 233 -> 152686830;
                case 234 -> 1419891700;
                case 235 -> -1190390084;
                case 236 -> 1047282940;
                case 237 -> 806791337;
                case 238 -> 993525280;
                case 239 -> -1402163110;
                case 240 -> 1360095984;
                case 241 -> 1070975940;
                case 242 -> 755242592;
                case 243 -> -1993225590;
                case 244 -> -1263280271;
                case 245 -> 1448109149;
                case 246 -> -250659935;
                case 247 -> 1136661425;
                case 248 -> -1386399535;
                case 249 -> 763176669;
                case 250 -> 1795828438;
                case 251 -> 1467472476;
                case 252 -> 1044643525;
                case 253 -> 1886147602;
                case 254 -> -3439411;
                case 255 -> 1528856763;
                default -> 500765566;
            });
        } while (v2 != 168);
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
            Object[] objectArray = new Object[11];
            v1 = objectArray;
            oO0o = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        oOOI = "Inventory";
        oOOo = 2.0f;
        oOO0 = 1.0f;
        oOOO = 3;
        0iii = 9;
        00i = 0.5f;
    }
}

