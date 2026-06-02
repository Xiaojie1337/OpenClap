/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.SimpleFramebuffer
 */
package clap.render;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import clap.mixin.RenderSystemAccessor;
import clap.model.EnumType_0O00;
import clap.model.EnumType_OOO0;
import clap.render.RenderSupport_00io_1;
import clap.module.client.streamproof.StreamproofLogger;
import clap.render.RenderSupport_io0_2;
import clap.module.client.StreamproofModule;
import clap.render.RenderSupport_o0oo_1;
import clap.render.RenderSupport_ooo_0;

/*
 * Renamed from psx.Hyk.OoI
 */
public class RenderSupport_ooi_1
implements RenderSupport_ooo_0 {
    private RenderSupport_io0_2 GuiSupport_OOI;
    private GpuTextureView OOi;
    public RenderSupport_o0oo_1 HelpCommand;
    public SimpleFramebuffer PacketEvent;
    private GpuTextureView HudElement;
    private int OOo;
    static Object EventBusApi;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public void begin(String param1) {
        if (this.isStreamproof(param1)) {
            ++this.OOo;
        }
    }

    public void GuiSupport_OOI() {
        int v1;
        if (this.GuiSupport_OOI == null) {
            return;
        }
        RenderSupport_00io_1.OOo();
        if (this.PacketEvent != null && StreamproofLogger.HudElement != null && (v1 = this.HudElement(this.PacketEvent)) != -1) {
            RenderSupport_00io_1.RenderSupport_oii_4();
            GlStateManager._blendFuncSeparate((int)1, (int)771, (int)1, (int)771);
            RenderSupport_00io_1.Oi0();
            this.GuiSupport_OOI.PacketEvent();
            RenderSupport_00io_1.Oo0(0, 0);
            this.GuiSupport_OOI.HelpCommand("Sampler0", v1, 0);
            this.GuiSupport_OOI.GuiSupport_OOI();
        }
        if (this.HelpCommand != null && this.HelpCommand.HelpCommand != -1) {
            RenderSupport_00io_1.RenderSupport_oii_4();
            GlStateManager._blendFuncSeparate((int)1, (int)771, (int)1, (int)771);
            RenderSupport_00io_1.Oi0();
            this.GuiSupport_OOI.PacketEvent();
            RenderSupport_00io_1.Oo0(0, 0);
            this.GuiSupport_OOI.HelpCommand("Sampler0", this.HelpCommand.HelpCommand, 0);
            this.GuiSupport_OOI.GuiSupport_OOI();
        }
        RenderSupport_00io_1.OiI(0);
        RenderSupport_00io_1.GuiSupport_OOI();
    }

    @Override
    public void add(String param1, String param2, EnumType_OOO0 param3, boolean param4) {
        StreamproofLogger.OOo.PacketEvent(param1, param2, param4, param3);
    }

    @Override
    public void stopFbo(EnumType_0O00 param1) {
        if (param1 == EnumType_0O00.World && this.PacketEvent != null) {
            RenderSystemAccessor.clap$setOutputColorTextureOverride(this.OOi);
            RenderSystemAccessor.clap$setOutputDepthTextureOverride(this.HudElement);
            this.OOi = null;
            this.HudElement = null;
        }
        if (param1 == EnumType_0O00.Gui && this.HelpCommand != null) {
            this.HelpCommand.GuiSupport_OOI();
        }
    }

    @Override
    public void startFbo(EnumType_0O00 param1) {
        if (param1 == EnumType_0O00.World && this.PacketEvent != null) {
            Framebuffer v2;
            this.OOi();
            Framebuffer framebuffer = v2 = StreamproofLogger.HudElement == null ? null : StreamproofLogger.HudElement.getFramebuffer();
            if (v2 == null) {
                return;
            }
            this.OOi = RenderSystemAccessor.clap$getOutputColorTextureOverride();
            this.HudElement = RenderSystemAccessor.clap$getOutputDepthTextureOverride();
            RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.PacketEvent.method_30277(), 0, this.PacketEvent.method_30278(), 1.0);
            RenderSystem.getDevice().createCommandEncoder().copyTextureToTexture(v2.getDepthAttachment(), this.PacketEvent.method_30278(), 0, 0, 0, 0, 0, this.PacketEvent.field_1482, this.PacketEvent.field_1481);
            RenderSystemAccessor.clap$setOutputColorTextureOverride(this.PacketEvent.method_71639());
            RenderSystemAccessor.clap$setOutputDepthTextureOverride(this.PacketEvent.method_71640());
        }
        if (param1 == EnumType_0O00.Gui && this.HelpCommand != null) {
            this.HelpCommand.OOo();
        }
    }

    public void PacketEvent() {
        int v1 = StreamproofLogger.HudElement == null ? 1 : Math.max(1, StreamproofLogger.HudElement.getWindow().getFramebufferWidth());
        int v2 = StreamproofLogger.HudElement == null ? 1 : Math.max(1, StreamproofLogger.HudElement.getWindow().getFramebufferHeight());
        this.PacketEvent = new SimpleFramebuffer("clap/streamproof_world", v1, v2, true);
        this.HelpCommand = new RenderSupport_o0oo_1(false);
        this.GuiSupport_OOI = new RenderSupport_io0_2("overlay");
    }

    public void OOo() {
        if (this.OOo > 0) {
            --this.OOo;
        }
    }

    @Override
    public boolean isAvailable() {
        return StreamproofLogger.OoO;
    }

    public void OOi() {
        if (this.PacketEvent == null || StreamproofLogger.HudElement == null) {
            return;
        }
        int v1 = Math.max(1, StreamproofLogger.HudElement.getWindow().getFramebufferWidth());
        int v2 = Math.max(1, StreamproofLogger.HudElement.getWindow().getFramebufferHeight());
        if (this.PacketEvent.field_1482 != v1 || this.PacketEvent.field_1481 != v2) {
            this.PacketEvent.method_1234(v1, v2);
        }
    }

    @Override
    public boolean isWriting() {
        return this.OOo > 0;
    }

    @Override
    public EnumType_0O00 getRenderTarget(String param1) {
        return StreamproofLogger.OOo.OOo((String)param1).GuiSupport_OOI == EnumType_OOO0.World ? EnumType_0O00.World : EnumType_0O00.Gui;
    }

    static {
        __k__gH4it = RenderSupport_ooi_1.__k__gH4it((long)1228749297189645841L);
        __rP__gH4it0 = new String[]{"\u8345\uabf0\u75e7\u20c8\ua7dd\u453b\u8ef7\u77d1\u824b\uaa8a", "\u8347\uabe7\u75f8", "\u8352\uabfa\u75e1\u20b7\ua7d6"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\u83d2\uab47\u7583\u2061\ua7eb\u4432\u8fd4\u776e\u8282\uaa6a\u74dc\u212e\ua6f0\u4ba5\u80de\u78ac\u8d5b\ua590\u7b74\u2e4f\ua9c0\u4b63\u8130\u795e\u8cea\ua4ad\u7af3\u2f2f\ua8ec\u4a61\u82f8\u7a17\u8f00\ua74a\u7914\u2cbd\uabd7\u4965\u833b\u7bd8\u8ec3\ua6e4\u7819\u2d7d\uaab0\u487c\u84a5\u7c3a\u8992\ua186\u7f09\u2a2b\uad7a\u4fb8\u84da\u7dee\u8801\ua00b\u7e6f\u2b0c\uac3c\u4eee\u8559\u7e25\u8b8b\ua3b1\u7d47\u2860\uafd0\u4d7e\u86fc\u7f0b\u8a05\ua2d6\u7c45\u2929\uaecd\u4c46\u8746\u7fe2", "\u8347\uabf2\u75e1\u20ce\ua7df\u4539\u8ee9\u77cf\u8249\uaa88", "\u8351\uabfd\u75e2\u20a7\ua7bf\u455a\u8e98\u77d0\u824d\uaafb\u74fa\u21d3\ua6c1\u4440\u8fb2\u7763\u8d41\ua5a1\u7bef\u2e1f", "\u8357\uabe3\u75e1\u20b2\ua7df\u453e\u8efc"};
        __rP__gH4it3 = new String[]{"\u8363\uab00\u7515\u207b\ua752\u45a5\u8ead\u7789"};
        byte[] v0 = "\u0087?\u00f2\u00a9W\u00ea\u00cf\u00d1\u00df\u001a\u00a5\u00eeDu\u00cdk>\u00185\u00f7LK\u001b\u0091\u0087-\u00ba\u009fhA\u00db\u00c0u\u00d2E\u0015K]\u0000\u0007\u00bet@\u00dd$L\u0096\u00dd\u0097.\u00a8\u00b3\u0096\u00b0\u0011\u0001\f\u00ab\u00c6\u009c\u00d8\u00ee\u009a\u00d2\u009e\t\u00f6\u00e8,f'\u00f4\u0018f\u00fc\u00a99V\u0095\u00e5".getBytes("ISO_8859_1");
        Object[] v1 = "l\u00a6\u00ba\u00e9\u00b4\u00bbp|".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -912915511;
                case 1 -> -52283153;
                case 2 -> 1846594638;
                case 3 -> 335691334;
                case 4 -> 1756188724;
                case 5 -> -1449529527;
                case 6 -> 1777496256;
                case 7 -> 158233804;
                case 8 -> -135276770;
                case 9 -> -1851819463;
                case 10 -> -1086853740;
                case 11 -> -1195859800;
                case 12 -> -475726340;
                case 13 -> 1983894581;
                case 14 -> 1719010432;
                case 15 -> 1121565595;
                case 16 -> -1618563530;
                case 17 -> 1104986667;
                case 18 -> -1510607716;
                case 19 -> -1016703944;
                case 20 -> -1568700810;
                case 21 -> -279161347;
                case 22 -> -1344528020;
                case 23 -> -1850552410;
                case 24 -> 40947146;
                case 25 -> 32242921;
                case 26 -> -1448081606;
                case 27 -> 271815373;
                case 28 -> 1310989176;
                case 29 -> -2100266671;
                case 30 -> -532709889;
                case 31 -> -1883370801;
                case 32 -> -512381891;
                case 33 -> 1187787938;
                case 34 -> -872256104;
                case 35 -> -2026262413;
                case 36 -> -83767769;
                case 37 -> 221884815;
                case 38 -> -1966899089;
                case 39 -> -1214356941;
                case 40 -> 1416684882;
                case 41 -> -393204514;
                case 42 -> -1767544905;
                case 43 -> -1441806108;
                case 44 -> -1138562395;
                case 45 -> -1763399132;
                case 46 -> -1075592569;
                case 47 -> 280729604;
                case 48 -> 431256793;
                case 49 -> -782635014;
                case 50 -> -248918443;
                case 51 -> -585439200;
                case 52 -> -1679517673;
                case 53 -> -1214893191;
                case 54 -> -1387769102;
                case 55 -> -1516965981;
                case 56 -> 1594114986;
                case 57 -> -260209235;
                case 58 -> -742947363;
                case 59 -> 730059269;
                case 60 -> 1284297833;
                case 61 -> -1076088039;
                case 62 -> 1458098695;
                case 63 -> 1333949123;
                case 64 -> 331045;
                case 65 -> -1986220872;
                case 66 -> -1489518343;
                case 67 -> 2129939129;
                case 68 -> 809023554;
                case 69 -> 718842432;
                case 70 -> -1769446555;
                case 71 -> 19321091;
                case 72 -> 389580859;
                case 73 -> 1607312365;
                case 74 -> 110432784;
                case 75 -> -2038564269;
                case 76 -> 215814017;
                case 77 -> -2017933521;
                case 78 -> 1708415918;
                case 79 -> -552352788;
                case 80 -> -2015304954;
                case 81 -> 1830751224;
                case 82 -> -1610919405;
                case 83 -> -766713275;
                case 84 -> -564970543;
                case 85 -> -28700995;
                case 86 -> -156248665;
                case 87 -> 610469719;
                case 88 -> -664429612;
                case 89 -> -821374834;
                case 90 -> 675368135;
                case 91 -> -66628154;
                case 92 -> -1112773041;
                case 93 -> -832599283;
                case 94 -> 1148586130;
                case 95 -> 122021331;
                case 96 -> 1309905249;
                case 97 -> 1353328433;
                case 98 -> -1377417881;
                case 99 -> 234721099;
                case 100 -> -1035653350;
                case 101 -> -1376184603;
                case 102 -> -1740803504;
                case 103 -> -1882371482;
                case 104 -> -1135444347;
                case 105 -> -2084792182;
                case 106 -> 474827776;
                case 107 -> -1114975774;
                case 108 -> 374550847;
                case 109 -> -1235310303;
                case 110 -> -244984353;
                case 111 -> -1720946932;
                case 112 -> -492195108;
                case 113 -> -1445715772;
                case 114 -> 1797283059;
                case 115 -> 2001343580;
                case 116 -> 904362563;
                case 117 -> -1532902264;
                case 118 -> 1660616085;
                case 119 -> 100144468;
                case 120 -> -2043798086;
                case 121 -> -952608779;
                case 122 -> -922397514;
                case 123 -> -1375713465;
                case 124 -> 1956566961;
                case 125 -> -1909006157;
                case 126 -> 1035361807;
                case 127 -> 2133084400;
                case 128 -> -1405897574;
                case 129 -> 424849824;
                case 130 -> 202289187;
                case 131 -> 1465787532;
                case 132 -> 1937418238;
                case 133 -> -828836520;
                case 134 -> 1302953460;
                case 135 -> 29539262;
                case 136 -> 2103188488;
                case 137 -> -759838610;
                case 138 -> -711842770;
                case 139 -> 66816758;
                case 140 -> 630975300;
                case 141 -> -550956677;
                case 142 -> -1982124728;
                case 143 -> -733760979;
                case 144 -> 1633462036;
                case 145 -> 1863433107;
                case 146 -> 575601327;
                case 147 -> -1976666716;
                case 148 -> 1608168599;
                case 149 -> -21236133;
                case 150 -> 1398903995;
                case 151 -> 2017163112;
                case 152 -> -720001123;
                case 153 -> 698849488;
                case 154 -> 1930315489;
                case 155 -> -845186938;
                case 156 -> -1267477365;
                case 157 -> 176674138;
                case 158 -> -926741742;
                case 159 -> -1662098764;
                case 160 -> 1440025099;
                case 161 -> 554556095;
                case 162 -> 1428613414;
                case 163 -> -943861695;
                case 164 -> -1991841904;
                case 165 -> -1369174565;
                case 166 -> -1045968937;
                case 167 -> 388331239;
                case 168 -> 2111719402;
                case 169 -> 2069361614;
                case 170 -> -712023699;
                case 171 -> -1753937963;
                case 172 -> -329340595;
                case 173 -> 512558396;
                case 174 -> -1104784777;
                case 175 -> 1758299945;
                case 176 -> 395419423;
                case 177 -> 1844637675;
                case 178 -> 1416064472;
                case 179 -> 147202473;
                case 180 -> -1480746198;
                case 181 -> -513930213;
                case 182 -> 1949619834;
                case 183 -> 1898115116;
                case 184 -> 2110564963;
                case 185 -> 1690900451;
                case 186 -> 1109623733;
                case 187 -> -1222223094;
                case 188 -> 2057894903;
                case 189 -> -877440527;
                case 190 -> -1391904414;
                case 191 -> 1953226868;
                case 192 -> 425605245;
                case 193 -> -1535199839;
                case 194 -> -1966863122;
                case 195 -> -1480227920;
                case 196 -> 736890198;
                case 197 -> 921035994;
                case 198 -> -747502308;
                case 199 -> -930926568;
                case 200 -> 749173310;
                case 201 -> -1411784801;
                case 202 -> -691897428;
                case 203 -> -81932366;
                case 204 -> 1573760089;
                case 205 -> -1550594709;
                case 206 -> -344840303;
                case 207 -> 431344690;
                case 208 -> 1740933493;
                case 209 -> 1218924997;
                case 210 -> 1419652428;
                case 211 -> 527390308;
                case 212 -> -1447938931;
                case 213 -> 1889939666;
                case 214 -> -1431735415;
                case 215 -> 1773447445;
                case 216 -> -254399869;
                case 217 -> -860988677;
                case 218 -> 1899175638;
                case 219 -> -1073149466;
                case 220 -> -1901872746;
                case 221 -> 172458288;
                case 222 -> 273941521;
                case 223 -> -1600301927;
                case 224 -> -1522075895;
                case 225 -> 260431041;
                case 226 -> -1069258126;
                case 227 -> -2021569718;
                case 228 -> 725256898;
                case 229 -> -121911064;
                case 230 -> 720004228;
                case 231 -> -967113982;
                case 232 -> 1512425084;
                case 233 -> -228830005;
                case 234 -> 1508155176;
                case 235 -> -1388311620;
                case 236 -> -1868559416;
                case 237 -> -2092107649;
                case 238 -> -1330870910;
                case 239 -> -1058913365;
                case 240 -> -890279658;
                case 241 -> -351995337;
                case 242 -> 480633373;
                case 243 -> 821851997;
                case 244 -> -1180312450;
                case 245 -> 800936042;
                case 246 -> -1348365922;
                case 247 -> -1039586047;
                case 248 -> -1218330144;
                case 249 -> -1277432798;
                case 250 -> -1749295777;
                case 251 -> -1726988432;
                case 252 -> -701805730;
                case 253 -> 1123144561;
                case 254 -> -522813682;
                case 255 -> 1711157600;
                default -> 1781667529;
            });
        } while (v2 != 80);
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
            EventBusApi = objectArray;
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

    public void HelpCommand() {
        ++this.OOo;
    }

    @Override
    public boolean isStreamproof(String param1) {
        StreamproofModule v2 = StreamproofModule.i00o();
        return StreamproofLogger.OoO && StreamproofLogger.O0o != null && StreamproofLogger.O0o.GuiSupport_OOI && v2 != null && v2.IoOo() && StreamproofLogger.OOo.HelpCommand(param1);
    }

    private int HudElement(SimpleFramebuffer param1) {
        if (param1 == null || param1.method_30277() == null) {
            return -1;
        }
        try {
            return Integer.parseInt(param1.method_30277().getLabel());
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    @Override
    public void end(String param1) {
        if (this.isStreamproof(param1) && this.OOo > 0) {
            --this.OOo;
        }
    }
}

