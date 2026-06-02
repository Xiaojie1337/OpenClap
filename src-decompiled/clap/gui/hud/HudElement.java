/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.ChatScreen
 *  net.minecraft.client.gui.screen.Screen
 *  org.joml.Vector2f
 */
package clap.gui.hud;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import org.joml.Vector2f;
import clap.gui.screen.HudEditorScreen;
import clap.core.module.Module;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.config.ConfigSupport_iio_2;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.core.module.ModuleCategory;
import clap.render.ScaledDrawContext;
import clap.gui.screen.HudEditorScreenV2;
import clap.event.EventHandler;
import clap.config.ConfigSupport_oooo_0;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class HudElement
extends Module {
    public final Setting OOo = this.OOioi("Position", 0.5f, 0.5f);
    private float ConfigSupport_O0I;
    private boolean Ooi;
    private float EventBusApi;
    private static final float HelpCommand;
    private float HudElement;
    private float O0o;
    private float OoO;
    public final Setting GuiSupport_OOI = this.OOi0o("Scale", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(2.0f));
    private boolean KeystrokesHudElement;
    private float OOi;
    private float OoI;
    private float O0i;
    private static final int PacketEvent;
    private float Ooo;
    private float Oo0;
    static Object ConfigSupport_OI0;
    private static volatile /* synthetic */ long __k__gH4it;

    private HudElement StorageEspModule() {
        if (((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof HudEditorScreenV2) {
            return HudEditorScreenV2.iI0().oi0;
        }
        return HudEditorScreen.ConfigSupport_O0IO().oi0;
    }

    private void 00i(boolean param1) {
        if (((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof HudEditorScreenV2) {
            HudEditorScreenV2.iI0().oio = param1;
        } else {
            HudEditorScreen.ConfigSupport_O0IO().oio = param1;
        }
    }

    public void Oii(float param1, float param2, float param3, float param4) {
        this.OoO = param1;
        this.Oo0 = param2;
        this.Ooo = param3;
        this.OoI = param4;
        this.ConfigSupport_O0I = param1 - this.GuiSupport_OOI();
        this.O0i = param2 - this.OOi();
        this.EventBusApi = param3;
        this.O0o = param4;
    }

    private float EnumType_0OI(float param1, float param2, float param3) {
        if (param3 < param2) {
            return param2;
        }
        return Math.max(param2, Math.min(param3, param1));
    }

    private boolean Kernel32SnapshotApi() {
        HudEditorScreenV2 v2;
        Screen v1 = ((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen;
        return v1 instanceof HudEditorScreenV2 && (v2 = (HudEditorScreenV2)v1).iiO(this.Oo0(), this.Ooo());
    }

    public int Oo0() {
        return (int)(((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).mouse.getX() / (double)ConfigSupport_OI0.getWindow().getScaleFactor());
    }

    public float GuiSupport_OOI() {
        return (float)ConfigSupport_OI0.getWindow().getScaledWidth() * ((Vector2f)this.OOo.HelpCommand()).x();
    }

    public float OIo() {
        return ((Float)this.GuiSupport_OOI.HelpCommand()).floatValue();
    }

    @EventHandler
    public void ConfigSupport_O0I(ConfigSupport_oooo_0 param1) {
        if (!this.0Oi() || this.Kernel32SnapshotApi() || clap.gui.hud.HudElement.iooI() || !this.Ooi()) {
            return;
        }
        if (param1.EnumType_0OI() == 0.0) {
            return;
        }
        float v2 = this.OIo();
        float v3 = v2 + (param1.EnumType_0OI() > 0.0 ? 0.05f : -0.05f);
        this.GuiSupport_OOI.OOo(Float.valueOf(v3));
        float v4 = this.OIo();
        if (v4 == v2) {
            param1.DataRecord_0O0();
            return;
        }
        this.0Oo(v2, v4);
        param1.DataRecord_0O0();
    }

    private void 0Oo(float param1, float param2) {
        if (param1 <= 0.0f || this.Ooo <= 0.0f || this.OoI <= 0.0f) {
            return;
        }
        float v3 = param2 / param1;
        float v4 = this.Oo0();
        float v5 = this.Ooo();
        float v6 = (v4 - this.OoO) / this.Ooo;
        float v7 = (v5 - this.Oo0) / this.OoI;
        float v8 = this.Ooo * v3;
        float v9 = this.OoI * v3;
        float v10 = v4 - v6 * v8;
        float v11 = v5 - v7 * v9;
        float v12 = this.ConfigSupport_O0I * v3;
        float v13 = this.O0i * v3;
        float v14 = v10 - v12;
        float v15 = v11 - v13;
        float v16 = (float)ConfigSupport_OI0.getWindow().getScaledWidth() - v8 - v12;
        float v17 = (float)ConfigSupport_OI0.getWindow().getScaledHeight() - v9 - v13;
        ((Vector2f)this.OOo.HelpCommand()).x = this.EnumType_0OI(v14, -v12, v16) / (float)ConfigSupport_OI0.getWindow().getScaledWidth();
        ((Vector2f)this.OOo.HelpCommand()).y = this.EnumType_0OI(v15, -v13, v17) / (float)ConfigSupport_OI0.getWindow().getScaledHeight();
    }

    protected int RenderSupport_oii_4(int param1) {
        return Math.round((float)param1 * this.OIo());
    }

    private boolean DataRecord_00I() {
        if (((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof HudEditorScreenV2) {
            return HudEditorScreenV2.iI0().oio;
        }
        return HudEditorScreen.ConfigSupport_O0IO().oio;
    }

    private boolean 0Oi() {
        return ((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof HudEditorScreen || ((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof HudEditorScreenV2;
    }

    public void Oi0(float param1) {
        this.EventBusApi = param1;
    }

    static {
        __k__gH4it = clap.gui.hud.HudElement.__k__gH4it(5634717347190140433L);
        __rP__gH4it0 = new String[]{"\uf47b\u6294\ubc37", "\uf46e\u6281\ubc26\ue9f2\u6e95"};
        __rP__gH4it1 = new String[]{"\uf47b\u628d\ubc26\ue98f\u6e9c\u25f8\ue2e0\uc054\u8b75\u1df7", "\uf479\u628b\ubc20\ue98d\u6e9e\u25e6\ue2fe\uc056\u8b77\u1df1", "\uf46b\u6298\ubc26\ue9f7\u6e9c\u25f3\ue2e5"};
        __rP__gH4it2 = new String[]{"\uf4a7\u6232\ubc81\ue9a0\u6ee1\u5a68\u9d33\uc021\u8bc3\u1df4\uc3bc\u96e8\u11d4\u254a\ue2f3\uc14f\u8a26\u1cea\uc2b0\u972f\u1027\u242d\ue3cc\uc291\u89ae\u1fb9\uc197\u94e1\u13d5\u2755\ue079\uc38c\u8863\u1e6a\uc09c\u9545\u1288\u2682\ue12f\uc3ee\u8f79\u1907\uc7f9\u9291\u15ad\u21a5\ue6f4\uc4c2\u8ef2\u188c\uc653\u9389\u1432\u205b\ue723\uc523", "\uf454\u62ab\ubc0f\ue9bd\u6ed0\u2550\ue2e9\uc057"};
        __rP__gH4it3 = new String[]{"\uf46d\u6282\ubc25\ue9e6\u6efc\u259b\ue281\uc04b\u8b71\u1d84\uc33d\u9692\u1182\u2481\ue39b\uc178\u8a7d\u1c5e\uc228\u97de"};
        byte[] v0 = "\u00a6\u001d\u00df\u0001vY)\u001d\u00ba\u00e3\u001aq;C\u00e1{W\u00f5\u001e\u00be\u00c0,\u00c6\u00bd\u00c7\u00be!h*L{\u00a8\u0002e\"\u00c4\u007f\u0093\u00152 p\u007f\u00e8b\u00cc\u00c6\u0016\u00a3\u00f3\u00dd\u00f8\u00f5:\t\u00ef".getBytes("ISO_8859_1");
        Object[] v1 = "gvgju\u0093=%".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1911292296;
                case 1 -> 1923477312;
                case 2 -> 1461540034;
                case 3 -> 250903097;
                case 4 -> 803271015;
                case 5 -> -1603852779;
                case 6 -> -1113966926;
                case 7 -> -2026090832;
                case 8 -> -579190842;
                case 9 -> -777795696;
                case 10 -> 647917129;
                case 11 -> -1006359732;
                case 12 -> -442207502;
                case 13 -> -736453422;
                case 14 -> 1736006442;
                case 15 -> -1574921059;
                case 16 -> 1600998239;
                case 17 -> -955971463;
                case 18 -> -606888319;
                case 19 -> 1457915115;
                case 20 -> 2052337661;
                case 21 -> 1768250464;
                case 22 -> -2042128117;
                case 23 -> -1225823275;
                case 24 -> -1389932568;
                case 25 -> 1524822391;
                case 26 -> -197023837;
                case 27 -> -1696669183;
                case 28 -> 49310260;
                case 29 -> 1080051985;
                case 30 -> 169417638;
                case 31 -> -2014873010;
                case 32 -> -1773324394;
                case 33 -> -310916449;
                case 34 -> -2047994354;
                case 35 -> 1955257172;
                case 36 -> -323172180;
                case 37 -> -70270367;
                case 38 -> -404237227;
                case 39 -> -1678576969;
                case 40 -> 1647084657;
                case 41 -> -788607674;
                case 42 -> -130943315;
                case 43 -> 1710376766;
                case 44 -> -156990918;
                case 45 -> 2009453735;
                case 46 -> -1110515489;
                case 47 -> -314838405;
                case 48 -> 1838965704;
                case 49 -> -504026932;
                case 50 -> 4214986;
                case 51 -> 990791889;
                case 52 -> -176230235;
                case 53 -> -374962790;
                case 54 -> 1885775355;
                case 55 -> -442915748;
                case 56 -> 1064575519;
                case 57 -> -2100428286;
                case 58 -> 369788152;
                case 59 -> -14749162;
                case 60 -> -1594991549;
                case 61 -> 230695305;
                case 62 -> 1452005405;
                case 63 -> -1252530649;
                case 64 -> 854649949;
                case 65 -> 812359285;
                case 66 -> -1049861584;
                case 67 -> 1299510902;
                case 68 -> -472699748;
                case 69 -> 1525261299;
                case 70 -> 672874268;
                case 71 -> 1595639629;
                case 72 -> -1465592079;
                case 73 -> 2096071815;
                case 74 -> 1925850674;
                case 75 -> 43050927;
                case 76 -> -796043497;
                case 77 -> 282667098;
                case 78 -> 728518889;
                case 79 -> -1444608151;
                case 80 -> 1741242904;
                case 81 -> -1632387168;
                case 82 -> 361379081;
                case 83 -> 1287259583;
                case 84 -> 1720068643;
                case 85 -> 438596770;
                case 86 -> 211066030;
                case 87 -> -2005665779;
                case 88 -> 2064549857;
                case 89 -> -377542002;
                case 90 -> 773107481;
                case 91 -> 493789834;
                case 92 -> -876846832;
                case 93 -> 656246337;
                case 94 -> 1623066008;
                case 95 -> 1804395083;
                case 96 -> 1564669443;
                case 97 -> 2017905066;
                case 98 -> 541250905;
                case 99 -> 122688382;
                case 100 -> 2051837180;
                case 101 -> 452804058;
                case 102 -> 387567344;
                case 103 -> 1659091928;
                case 104 -> -1150606464;
                case 105 -> 101595875;
                case 106 -> 778582611;
                case 107 -> -1502860476;
                case 108 -> 657441923;
                case 109 -> -519173343;
                case 110 -> 3830352;
                case 111 -> -424873008;
                case 112 -> 1797622500;
                case 113 -> 1958293460;
                case 114 -> -597703778;
                case 115 -> -888777745;
                case 116 -> -727009372;
                case 117 -> 63487603;
                case 118 -> 601771558;
                case 119 -> -1575548199;
                case 120 -> 1970500657;
                case 121 -> -924845523;
                case 122 -> -1522106510;
                case 123 -> -1052629970;
                case 124 -> -1742276554;
                case 125 -> -334148173;
                case 126 -> -730521159;
                case 127 -> -1657883027;
                case 128 -> 1061241162;
                case 129 -> 1912155541;
                case 130 -> 1573798596;
                case 131 -> 978426679;
                case 132 -> 410036679;
                case 133 -> -2094938902;
                case 134 -> 1323978421;
                case 135 -> -1292918012;
                case 136 -> -364385169;
                case 137 -> -1905638663;
                case 138 -> 810688583;
                case 139 -> -1912022803;
                case 140 -> -1366134449;
                case 141 -> 226571384;
                case 142 -> 1014889758;
                case 143 -> 1451471906;
                case 144 -> 35778987;
                case 145 -> 2068928812;
                case 146 -> -619272155;
                case 147 -> 1173975314;
                case 148 -> 1623835492;
                case 149 -> 2055518546;
                case 150 -> -1682504473;
                case 151 -> 1223876165;
                case 152 -> 1789752985;
                case 153 -> 1746536504;
                case 154 -> -1134560101;
                case 155 -> 628575805;
                case 156 -> -1538428282;
                case 157 -> 251694888;
                case 158 -> 1823973386;
                case 159 -> 113611707;
                case 160 -> 1310051846;
                case 161 -> -701550368;
                case 162 -> 1128771430;
                case 163 -> 740892248;
                case 164 -> -270492837;
                case 165 -> 1190081595;
                case 166 -> -58785631;
                case 167 -> 1666954752;
                case 168 -> 2048804499;
                case 169 -> -446958702;
                case 170 -> -1887666993;
                case 171 -> 1661359688;
                case 172 -> -1368663445;
                case 173 -> 94674907;
                case 174 -> -773742276;
                case 175 -> -33937089;
                case 176 -> 898122090;
                case 177 -> 229484387;
                case 178 -> 1700119782;
                case 179 -> -1645953088;
                case 180 -> 236375646;
                case 181 -> -1333558061;
                case 182 -> 239237335;
                case 183 -> -86974688;
                case 184 -> 397322853;
                case 185 -> 1877535529;
                case 186 -> 518317183;
                case 187 -> -1107846548;
                case 188 -> 2107372728;
                case 189 -> -1670993179;
                case 190 -> -1957238017;
                case 191 -> -1334081111;
                case 192 -> -709840554;
                case 193 -> 904117437;
                case 194 -> -303147398;
                case 195 -> 1809993826;
                case 196 -> 1724959970;
                case 197 -> 1244678780;
                case 198 -> 511678965;
                case 199 -> -927018811;
                case 200 -> 1237703156;
                case 201 -> -1806260465;
                case 202 -> -1779128963;
                case 203 -> -1304383372;
                case 204 -> -627290946;
                case 205 -> 1261538030;
                case 206 -> 830472068;
                case 207 -> -1450960947;
                case 208 -> 848648325;
                case 209 -> -537459608;
                case 210 -> -1061213689;
                case 211 -> 1539752634;
                case 212 -> 1876274263;
                case 213 -> 1247542932;
                case 214 -> 1335810284;
                case 215 -> -648685171;
                case 216 -> 1235927889;
                case 217 -> -806600524;
                case 218 -> 856074417;
                case 219 -> 2052728542;
                case 220 -> -1949992454;
                case 221 -> -1552990708;
                case 222 -> 1568233896;
                case 223 -> 2027852175;
                case 224 -> 1499599310;
                case 225 -> 2012364296;
                case 226 -> 1915856566;
                case 227 -> 113706973;
                case 228 -> -1472005412;
                case 229 -> 630491411;
                case 230 -> -250396380;
                case 231 -> -651415306;
                case 232 -> -337321446;
                case 233 -> -1128612098;
                case 234 -> -548756181;
                case 235 -> 452106172;
                case 236 -> -257430245;
                case 237 -> 454719797;
                case 238 -> -1494373100;
                case 239 -> -1397086580;
                case 240 -> 101918609;
                case 241 -> 90169283;
                case 242 -> -426106046;
                case 243 -> -491969653;
                case 244 -> -1139505298;
                case 245 -> 1950534857;
                case 246 -> 1613678387;
                case 247 -> 1334050672;
                case 248 -> 577833263;
                case 249 -> -1258706474;
                case 250 -> -1500615273;
                case 251 -> 25539714;
                case 252 -> 12438533;
                case 253 -> -11259189;
                case 254 -> 220479479;
                case 255 -> 681739457;
                default -> 1232349729;
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
            ConfigSupport_OI0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        HelpCommand = 0.05f;
        PacketEvent = 3;
    }

    @EventHandler
    public void HudElement(ScaledDrawContext param1) {
        this.O0i(param1);
    }

    public float ConfigSupport_OI0() {
        return this.O0o;
    }

    public void OiI(float param1, float param2) {
        this.ConfigSupport_O0I = param1;
        this.O0i = param2;
        this.OoO = this.GuiSupport_OOI() + param1;
        this.Oo0 = this.OOi() + param2;
        this.Ooo = this.EventBusApi;
        this.OoI = this.O0o;
    }

    private float ConfigSupport_0OO() {
        return this.OoO;
    }

    @EventHandler
    public void EventBusApi(GuiSupport_0oo_2 param1) {
        this.OoO(param1);
    }

    @EventHandler
    public void O0o(ConfigSupport_iio_2 param1) {
        if (!this.0Oi() || this.Kernel32SnapshotApi() || clap.gui.hud.HudElement.iooI()) {
            return;
        }
        if (param1.OiI() == 0) {
            this.KeystrokesHudElement = false;
            this.Ooi = false;
            this.ConfigSupport_00o_0(null);
        }
        if (param1.OiI() == 1 && this.Ooi()) {
            this.KeystrokesHudElement = true;
        }
    }

    private float DataRecord_0O0() {
        return this.Oo0;
    }

    protected float ConfigSupport_OII(float param1) {
        return param1 * this.OIo();
    }

    public void OoI(float param1, float param2, float param3, float param4) {
        this.EventBusApi = param3;
        this.O0o = param4;
        ((Vector2f)this.OOo.HelpCommand()).x = param1 / (float)ConfigSupport_OI0.getWindow().getScaledWidth();
        ((Vector2f)this.OOo.HelpCommand()).y = param2 / (float)ConfigSupport_OI0.getWindow().getScaledHeight();
    }

    public HudElement(String param1, String param2, float param3, float param4) {
        super(param1, param2, ModuleCategory.ioi);
        this.GuiSupport_OOI.00i(param0 -> false);
        this.EventBusApi = param3;
        this.O0o = param4;
        this.Ooo = param3;
        this.OoI = param4;
    }

    private void ConfigSupport_00o_0(HudElement param1) {
        if (((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof HudEditorScreenV2) {
            HudEditorScreenV2.iI0().oi0 = param1;
        } else {
            HudEditorScreen.ConfigSupport_O0IO().oi0 = param1;
        }
    }

    public float KeystrokesHudElement() {
        return this.EventBusApi;
    }

    public int Ooo() {
        return (int)(((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).mouse.getY() / (double)ConfigSupport_OI0.getWindow().getScaleFactor());
    }

    protected void OoO(GuiSupport_0oo_2 param1) {
    }

    protected boolean OiO() {
        return this.GuiSupport_OOI() + this.KeystrokesHudElement() / 2.0f > (float)ConfigSupport_OI0.getWindow().getScaledWidth() / 2.0f;
    }

    protected void O0i(ScaledDrawContext param1) {
        boolean v42;
        if (!this.0Oi() || clap.gui.hud.HudElement.iooI()) {
            return;
        }
        float v2 = this.ConfigSupport_0OO();
        float v3 = this.DataRecord_0O0();
        if (this.KeystrokesHudElement) {
            if (!this.Ooi && !this.Kernel32SnapshotApi() && this.Ooi() && this.StorageEspModule() == null) {
                this.OOi = (float)this.Oo0() - v2;
                this.HudElement = (float)this.Ooo() - v3;
                this.Ooi = true;
                this.ConfigSupport_00o_0(this);
            }
            if (this.Ooi) {
                float v42 = Math.min(Math.max((float)this.Oo0() - this.OOi, 0.0f), (float)ConfigSupport_OI0.getWindow().getScaledWidth() - this.Ooo);
                float v5 = Math.min(Math.max((float)this.Ooo() - this.HudElement, 0.0f), (float)ConfigSupport_OI0.getWindow().getScaledHeight() - this.OoI);
                ((Vector2f)this.OOo.HelpCommand()).x = (v42 - this.ConfigSupport_O0I) / (float)ConfigSupport_OI0.getWindow().getScaledWidth();
                ((Vector2f)this.OOo.HelpCommand()).y = (v5 - this.O0i) / (float)ConfigSupport_OI0.getWindow().getScaledHeight();
            }
        } else {
            this.Ooi = false;
        }
        boolean bl = v42 = !this.Kernel32SnapshotApi() && this.Ooi() && !this.DataRecord_00I();
        if (this.StorageEspModule() != null) {
            boolean bl2 = v42 = this.StorageEspModule() == this;
        }
        if (v42) {
            int v5 = ((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).textRenderer.getWidth(this.iooi());
            Objects.requireNonNull(((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).textRenderer);
            float v7 = v2 + this.Ooo + 3.0f + 4.0f;
            if (v7 + (float)v5 > (float)ConfigSupport_OI0.getWindow().getScaledWidth()) {
                v7 = v2 - 3.0f - 4.0f - (float)v5;
            }
            param1.ConfigSupport_O0I().drawTextWithShadow(((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).textRenderer, this.iooi(), (int)v7, (int)(v3 + this.OoI / 2.0f - 4.5f), -1);
            this.00i(true);
        }
        RenderSupport_00oi_0.HudElement(() -> {
            int v2 = (int)Math.floor(this.ConfigSupport_0OO()) - 3;
            int v3 = (int)Math.floor(this.DataRecord_0O0()) - 3;
            int v4 = (int)Math.ceil(this.ConfigSupport_0OO() + this.Ooo) + 3;
            int v5 = (int)Math.ceil(this.DataRecord_0O0() + this.OoI) + 3;
            int v6 = 0ooo.HelpCommand().HelpCommand().getRGB();
            GuiSupport_oi0o_0.OOoi0(param1.ConfigSupport_O0I(), v2, v3, v4, v5, v6, 1.0f);
        });
    }

    public boolean Ooi() {
        int v1 = this.Oo0();
        int v2 = this.Ooo();
        float v3 = this.ConfigSupport_0OO();
        float v4 = this.DataRecord_0O0();
        return (float)v1 >= v3 - 3.0f && (float)v1 <= v3 + this.Ooo + 3.0f && (float)v2 >= v4 - 3.0f && (float)v2 <= v4 + this.OoI + 3.0f;
    }

    public float OOi() {
        float v1 = ConfigSupport_OI0.getWindow().getScaledHeight() - 14;
        float v2 = (float)ConfigSupport_OI0.getWindow().getScaledHeight() * ((Vector2f)this.OOo.HelpCommand()).y();
        float v3 = v2 + this.ConfigSupport_OI0();
        if (((MinecraftClient)clap.gui.hud.HudElement.ConfigSupport_OI0).currentScreen instanceof ChatScreen) {
            v2 = Math.min(v3, v1) - this.ConfigSupport_OI0();
        }
        return v2;
    }

    public void Oio(float param1) {
        this.O0o = param1;
    }
}

