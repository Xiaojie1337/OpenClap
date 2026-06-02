/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.text.OrderedText
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.Text
 *  org.lwjgl.glfw.GLFW
 */
package clap.gui.screen;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.OrderedText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import clap.gui.screen.ConfigPanel;
import clap.gui.GuiSupport_o0ii_1;
import clap.config.ConfigSupport_oii0_1;
import clap.core.module.ModuleCategory;
import clap.render.RenderSupport_oooo_2;

/*
 * Renamed from clap.gui.screen.ClickGuiScreenV2
 */
public class ClickGuiScreenV2
extends Screen {
    private final List RenderSupport_oio_2 = new ArrayList();
    private final ConfigPanel I0o;
    static Object IrcCommand;
    private static volatile /* synthetic */ long __k__gH4it;

    private void EnumType_ii0_2(DrawContext param1, String param2, int param3, int param4) {
        if (this.field_22787 == null || this.field_22787.textRenderer == null || param2 == null || param2.isEmpty()) {
            return;
        }
        List v6 = this.field_22787.textRenderer.wrapLines((StringVisitable)Text.literal((String)param2), 220);
        if (v6.isEmpty()) {
            return;
        }
        int v10 = 0;
        for (OrderedText v12 : v6) {
            v10 = Math.max(v10, this.field_22787.textRenderer.getWidth(v12));
        }
        Objects.requireNonNull(this.field_22787.textRenderer);
        int v12 = v6.size() * 9 + (v6.size() - 1) * 1;
        int v13 = v10 + 6;
        int v14 = v12 + 4;
        int v15 = param3 + 10;
        int v16 = param4 + 8;
        if (v15 + v13 > param1.getScaledWindowWidth() - 2) {
            v15 = param3 - v13 - 10;
        }
        if (v16 + v14 > param1.getScaledWindowHeight() - 2) {
            v16 = param4 - v14 - 6;
        }
        if (v15 < 2) {
            v15 = 2;
        }
        if (v16 < 2) {
            v16 = 2;
        }
        param1.fill(v15, v16, v15 + v13, v16 + v14, new Color(10, 10, 14, 160).getRGB());
        int v17 = v16 + 2;
        for (OrderedText v19 : v6) {
            param1.drawText(this.field_22787.textRenderer, v19, v15 + 3, v17, -921089, true);
            v17 += 10;
        }
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25420(DrawContext param1, int param2, int param3, float param4) {
    }

    public boolean method_25401(double param1, double param3, double param5, double param7) {
        this.I0o.0o0(param1, param3, param7);
        boolean v9 = false;
        if (this.I0o.Oi0() > 18.0f) {
            float v10 = this.I0o.Ooi() + 18.0f + 16.0f + 16.0f + 18.0f;
            float v11 = this.I0o.Oi0() - 68.0f;
            boolean bl = v9 = param1 >= (double)this.I0o.OoI() && param1 <= (double)(this.I0o.OoI() + this.I0o.ConfigSupport_OI0()) && param3 >= (double)v10 && param3 <= (double)(v10 + v11);
        }
        if (!v9) {
            double v12 = param7 * 25.0;
            for (GuiSupport_o0ii_1 v15 : this.RenderSupport_oio_2) {
                v15.KeystrokesHudElement((float)((double)v15.Ooi() + v12));
            }
            this.I0o.KeystrokesHudElement((float)((double)this.I0o.Ooi() + v12));
        }
        return super.method_25401(param1, param3, param5, param7);
    }

    public boolean method_25403(Click param1, double param2, double param4) {
        this.I0o.0oO(param1.x(), param1.y());
        return super.method_25403(param1, param2, param4);
    }

    public ClickGuiScreenV2() {
        super((Text)Text.literal((String)"clap-clickgui2"));
        float v1 = 10.0f;
        for (ModuleCategory v5 : ModuleCategory.values()) {
            if (v5 == ModuleCategory.ioi) continue;
            this.RenderSupport_oio_2.add(new GuiSupport_o0ii_1(v5, v1, 10.0f, 110.0f, 18.0f));
            v1 += 120.0f;
        }
        this.I0o = new ConfigPanel(v1, 10.0f, 120.0f);
    }

    public void method_25394(DrawContext param1, int param2, int param3, float param4) {
        RenderSupport_oooo_2.begin("CLAP_CLICKGUI");
        try {
            param1.fill(0, 0, param1.getScaledWindowWidth(), param1.getScaledWindowHeight(), new Color(0, 0, 0, 100).getRGB());
            this.I0o.0oO(param2, param3);
            for (GuiSupport_o0ii_1 v6 : this.RenderSupport_oio_2) {
                v6.PacketEvent(param1, param2, param3, param4);
            }
            this.I0o.PacketEvent(param1, param2, param3, param4);
            this.PotionEffectsHudElement(param1, param2, param3);
            this.OOOo(param1);
            return;
        }
        finally {
            RenderSupport_oooo_2.end("CLAP_CLICKGUI");
        }
    }

    static {
        __k__gH4it = ClickGuiScreenV2.__k__gH4it((long)8130996242781040145L);
        __rP__gH4it0 = new String[0];
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\u6948\u82d1\u5c4f\u09cc\u8eea\ua18d\u65bf\u6076\u56a4\ubde7\u6327\u3688\ub194\ua097\u6495\u6135\u5798\ubccd\u6202\u37b4", "\u694e\u82cf\u5c4c\u09c1\ub16a\ua1c9\u65bb", "\u694b\u82d2\u5c54\u09c0\ub163"};
        __rP__gH4it3 = new String[]{"\u69f0\u82b3\u5c29\u0929\u8e1a\ua11a\u65a1\u60c3\u562d\ubd58\u630e\u3657\ub116\ua0a3\u64f5\u6133\u57d2\ubce6\u62db\u3772\ub095\ua0f7\u6712\u6295\u5424\ubf0b\u6162\u3428\ub39c\ua364\u6648\u63fb\u552c\ubeb3\u607a\u357c\ub2f3\ua275\u6129\u64ce\u5235\ub9e4\u6751\u325e\ub56d\ua5b8\u6053\u6535\u534e\ub8f6\u6668\u33a0\ub4b7\ua4ab\u603d\u6650\u50d9\ubbef\u656a\u3097\ub770\ua78e\u6343\u6705\u513f\uba00\u6408\u31d2\ub617\ua64a\u6236\u689b\u5e57\ub56d\u6b7a\u3efa\ub9ad\ua909\u6d6f\u694a\u5f0d\ub40d\u6a77\u3fc5\ub8f0\ua837\u6cb6\u69e0\u5cfa\ub72b\u6901\u3c7f\ubb80\uabc5\u6fa0\u6a55\u5d20\ub602\u680a\u3dc7\uba83\uaab4\u6e5d\u6b01\u5afd\ub144\u6fcd\u3a0a\ubd8b\uad18\u692d\u6c8f\u5b6c\ub089\u6e2a\u3b0e\ubc54\uacb7\u68fe\u6d8d\u5b30\ub38c\u6d99\u38b0\ubf79\uaf0e\u6b4c\u6e92\u583b\ub2f3\u6ce8\u39b6\ubec4\uae56\u6aff\u6f6c\u5923\uadc6\u73b5\u26f7\ua177\ub175\u750b\u7019\u4617\uac4b\u7287\u2709\ua044\ub0ca\u740f\u71bf\u47da\uaca7\u7162\u2400\ua34f\ub3a0\u77b0\u729c\u4442\uafb4\u704b\u251e\ua269\ub20c\u76b5\u73b1\u456c\uae96\u77ed\u2261\ua545\ub525\u714b\u74ff\u42e2\ua942\u7686\u237c\ua4b3\ub47d\u7061\u7525\u43c8\ua834\u76bb\u2016\ua73f\ub718\u737a\u7654\u4029\uaba1\u7517\u214c\ua65b\ub6ad\u72bc\u77ae\u412a\uaab1\u7451\u2e6f\ua9ac\ub913\u7dcb\u786c\u4e17\ua5a4\u7b0e\u2f4a\ua85f\ub8d1\u7c3c\u792e\u4f13\ua41e\u7a9e\u2f89\uabd3\ubbf5\u7f58\u7aa9", "\u695e\u82d2\u5c44\u09a9\ub17a\ua1da\u65a6\u604d\u5640\ubda8", "\u6919\u8272\u5c34\u093e\ub182\ua163\u65ac\u6088", "\u695c\u82dc\u5c4a\u09ab\ub178\ua1dc\u65a0\u604f\u5642\ubdb6", "\u695e\u82c7\u5c5d"};
        byte[] v0 = "\f\u0017E\u00fa\u00a3\u00c5M\u008a\u00c9\u00e4z\u009c\u00a7t\u0011r>R\u00a7\u00b1\u001c\u00d8\u00ce\u00ac\u00f0G&\u0093\u001dC\u009c\u00ca\u00f0\u00f76\u00cfjJ\u00e5\u00e7\u00f1\u00b8\u0005\u00f5\u00fc\u008f\u0097\u0014\u0082\u00a24\u0003^\u00a4\u0001Im\u0083\u00ce\f\u0091\u0089w\u0014\u0083d\u00a4A\u00eeU\u001a\u0092\u00f3\u0011\u00ceq\\\u001eKK\u00a1y\u00cbF9X\u00aa\u0019n'\u0085\u0004A\u00a2\u00b4\u00a4\u00bc\u0006\u0086\u00b4Z\u00cbQ\u00e8yXYaZo)n\u00e0\u009d\u00b6m}\u00f8\u0082TD\u00a0}\u00ebXI8CG\u00d7\u0004\u00e5\u00fd\t\u0093\u00a5G\u00faA\u00bcF\"o\u00d8{\u007f{JMeS\u0006\u008ek\u00a6;N\u0007\u00e4-\u001ep\u0087-p\u00b3\u00f9\u0018(J9JT\u0092\u000f^\u00ae\u0096Z_\u00da\u00f2\u00dd\u00bc\u00fc\u00d8\u009f\r^\u009f\u00ce\u00c5\u0015E;_\"2\u0010'\u000eMed\u00dd\u0084o\u00ed;P2I\u0016>\u00a0W\u0007\u0092\u009ar\u0092\u0012\u00cc\u00d8".getBytes("ISO_8859_1");
        Object[] v1 = "\u000f\u00fc>\u00cb\u00c1\u0086>\u00ff".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 609899095;
                case 1 -> -584708920;
                case 2 -> -2064428143;
                case 3 -> 94062224;
                case 4 -> 161024451;
                case 5 -> -373469374;
                case 6 -> 959356689;
                case 7 -> 1527784747;
                case 8 -> -1252599134;
                case 9 -> 1129688966;
                case 10 -> -1843883983;
                case 11 -> -841230758;
                case 12 -> -1831534472;
                case 13 -> 496209207;
                case 14 -> -1149755282;
                case 15 -> -473089964;
                case 16 -> 786642756;
                case 17 -> 1768578749;
                case 18 -> 1645305142;
                case 19 -> -1645247978;
                case 20 -> -834107151;
                case 21 -> 1339601985;
                case 22 -> -871228493;
                case 23 -> 26629781;
                case 24 -> 1285355104;
                case 25 -> 370389315;
                case 26 -> -2003335287;
                case 27 -> 1378751794;
                case 28 -> 624484127;
                case 29 -> 80225484;
                case 30 -> 858753389;
                case 31 -> -5612564;
                case 32 -> 1020799181;
                case 33 -> -373825739;
                case 34 -> -1091289867;
                case 35 -> -1767456060;
                case 36 -> -2049145387;
                case 37 -> 442364749;
                case 38 -> -1676747029;
                case 39 -> 2045532003;
                case 40 -> -67406917;
                case 41 -> 1470951656;
                case 42 -> 1699936058;
                case 43 -> 189817160;
                case 44 -> -1680231065;
                case 45 -> -1297719470;
                case 46 -> 561620351;
                case 47 -> 1107777998;
                case 48 -> -522228122;
                case 49 -> 934999525;
                case 50 -> 1066419615;
                case 51 -> -1194244841;
                case 52 -> 1152198434;
                case 53 -> 399988287;
                case 54 -> 2142038746;
                case 55 -> -1659713701;
                case 56 -> 424366836;
                case 57 -> -1443277074;
                case 58 -> -751937156;
                case 59 -> -616523640;
                case 60 -> -1766643453;
                case 61 -> -1553593743;
                case 62 -> -1040943084;
                case 63 -> -1824963552;
                case 64 -> -555158342;
                case 65 -> 2002333331;
                case 66 -> 391736946;
                case 67 -> -1836888313;
                case 68 -> 785189063;
                case 69 -> -443902555;
                case 70 -> 25353682;
                case 71 -> -115069770;
                case 72 -> 508173206;
                case 73 -> 1366210928;
                case 74 -> -1692010774;
                case 75 -> -1708743170;
                case 76 -> 1037877681;
                case 77 -> -958158298;
                case 78 -> 844122626;
                case 79 -> 1361942819;
                case 80 -> 584652677;
                case 81 -> 1414254639;
                case 82 -> -512581360;
                case 83 -> -992333035;
                case 84 -> -57603377;
                case 85 -> 573333787;
                case 86 -> 168442556;
                case 87 -> -1600454202;
                case 88 -> -1680952385;
                case 89 -> -176327713;
                case 90 -> 1964519106;
                case 91 -> -1712616452;
                case 92 -> -1053053721;
                case 93 -> 1614153187;
                case 94 -> -1000477144;
                case 95 -> -614312231;
                case 96 -> -142117935;
                case 97 -> 461269583;
                case 98 -> 592513959;
                case 99 -> 493185316;
                case 100 -> -257154210;
                case 101 -> -191366630;
                case 102 -> -416826625;
                case 103 -> -1757689863;
                case 104 -> -1546509283;
                case 105 -> 1899031870;
                case 106 -> -578630341;
                case 107 -> 2108979190;
                case 108 -> 1749588777;
                case 109 -> 902280792;
                case 110 -> 810621273;
                case 111 -> 1291978060;
                case 112 -> 991016997;
                case 113 -> 691102549;
                case 114 -> -19698376;
                case 115 -> 468949719;
                case 116 -> -857788668;
                case 117 -> -276120537;
                case 118 -> -2040029256;
                case 119 -> -1918691158;
                case 120 -> 122451044;
                case 121 -> 1293168329;
                case 122 -> 355753222;
                case 123 -> 641847903;
                case 124 -> 1592363056;
                case 125 -> 989117596;
                case 126 -> 473345968;
                case 127 -> 908316666;
                case 128 -> -1920830464;
                case 129 -> 1692436854;
                case 130 -> -657626387;
                case 131 -> -977031126;
                case 132 -> -1841512805;
                case 133 -> -1687965922;
                case 134 -> -152173544;
                case 135 -> -596135461;
                case 136 -> 82145885;
                case 137 -> -1151700528;
                case 138 -> -1343131537;
                case 139 -> -1271771379;
                case 140 -> -1403023860;
                case 141 -> 472649176;
                case 142 -> -1382084247;
                case 143 -> 1697614684;
                case 144 -> -1228150142;
                case 145 -> -1007836080;
                case 146 -> -116991596;
                case 147 -> -417732180;
                case 148 -> 436266542;
                case 149 -> 786896137;
                case 150 -> -2011486381;
                case 151 -> -264206380;
                case 152 -> 1165592011;
                case 153 -> 793489316;
                case 154 -> 1460532727;
                case 155 -> -517342895;
                case 156 -> 21542057;
                case 157 -> 1452613474;
                case 158 -> 444363033;
                case 159 -> 291885478;
                case 160 -> -1055466674;
                case 161 -> 202311028;
                case 162 -> 1756304854;
                case 163 -> 607708892;
                case 164 -> -738389433;
                case 165 -> 1074134938;
                case 166 -> 434356384;
                case 167 -> -1763781440;
                case 168 -> 1131576933;
                case 169 -> -386584182;
                case 170 -> -1527085663;
                case 171 -> 819808419;
                case 172 -> 1236646726;
                case 173 -> -1002864715;
                case 174 -> 1848975751;
                case 175 -> -141819263;
                case 176 -> -2073732283;
                case 177 -> 1317146891;
                case 178 -> -1807463813;
                case 179 -> 2059319100;
                case 180 -> 932696766;
                case 181 -> 1974066041;
                case 182 -> 1943883316;
                case 183 -> -542365109;
                case 184 -> 2046060661;
                case 185 -> 236855836;
                case 186 -> 1053144815;
                case 187 -> -1157616277;
                case 188 -> 810809281;
                case 189 -> -978166420;
                case 190 -> -135667315;
                case 191 -> 968647241;
                case 192 -> -1601593283;
                case 193 -> -721298557;
                case 194 -> 1978583694;
                case 195 -> 342225427;
                case 196 -> -1268732411;
                case 197 -> -2088501453;
                case 198 -> -1208064212;
                case 199 -> 2134671482;
                case 200 -> -119646723;
                case 201 -> 696261805;
                case 202 -> -1869518762;
                case 203 -> -1894178003;
                case 204 -> -5565058;
                case 205 -> 1918508818;
                case 206 -> 384840107;
                case 207 -> 324674152;
                case 208 -> 577818169;
                case 209 -> 2038540672;
                case 210 -> 1297110881;
                case 211 -> -1943356263;
                case 212 -> 792194784;
                case 213 -> -119455002;
                case 214 -> 1175652535;
                case 215 -> -406567922;
                case 216 -> 983511927;
                case 217 -> 692304356;
                case 218 -> -772008206;
                case 219 -> -214417276;
                case 220 -> -1905332050;
                case 221 -> 2013392253;
                case 222 -> 1518378909;
                case 223 -> -1305907276;
                case 224 -> 1371655877;
                case 225 -> -1582592517;
                case 226 -> 700938760;
                case 227 -> 114548638;
                case 228 -> 1493857523;
                case 229 -> -1417575278;
                case 230 -> -1528503007;
                case 231 -> -2027787625;
                case 232 -> 1490982927;
                case 233 -> 901850031;
                case 234 -> 931014552;
                case 235 -> -23968881;
                case 236 -> 602235531;
                case 237 -> -1825880862;
                case 238 -> 697899521;
                case 239 -> -980711459;
                case 240 -> 1674582520;
                case 241 -> 1461907368;
                case 242 -> -869872162;
                case 243 -> -1075849718;
                case 244 -> 1814136019;
                case 245 -> -948747456;
                case 246 -> 1175960498;
                case 247 -> -611419415;
                case 248 -> -50752662;
                case 249 -> -108746893;
                case 250 -> 1975205450;
                case 251 -> 1358932193;
                case 252 -> -2124410384;
                case 253 -> -926578742;
                case 254 -> 1746091705;
                case 255 -> -1797340020;
                default -> 283281243;
            });
        } while (v2 != 224);
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
            Object[] objectArray = new Object[6];
            v1 = objectArray;
            IrcCommand = objectArray;
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

    private void PotionEffectsHudElement(DrawContext param1, int param2, int param3) {
        if (!this.iIo()) {
            return;
        }
        for (GuiSupport_o0ii_1 v5 : this.RenderSupport_oio_2) {
            String v6 = v5.HelpCommand(param2, param3);
            if (v6 == null || v6.isEmpty()) continue;
            this.EnumType_ii0_2(param1, v6, param2, param3);
            return;
        }
    }

    public boolean method_25400(CharInput param1) {
        this.I0o.SpawnerFinderModule((char)param1.codepoint());
        return super.method_25400(param1);
    }

    public boolean method_25404(KeyInput param1) {
        int v2 = param1.key();
        int v3 = param1.scancode();
        int v4 = param1.comp_4797();
        this.I0o.EventBusApi(v2, v3, v4);
        boolean v5 = false;
        for (GuiSupport_o0ii_1 v7 : this.RenderSupport_oio_2) {
            if (!v7.RenderSupport_oii_4()) continue;
            v5 = true;
            break;
        }
        for (GuiSupport_o0ii_1 v7 : this.RenderSupport_oio_2) {
            v7.EventBusApi(v2, v3, v4);
        }
        if (v5 || this.I0o.0oi()) {
            return true;
        }
        return super.method_25404(param1);
    }

    public boolean method_25402(Click param1, boolean param2) {
        double v3 = param1.x();
        double v5 = param1.y();
        int v7 = param1.button();
        for (GuiSupport_o0ii_1 v9 : this.RenderSupport_oio_2) {
            if (!v9.OiO(v3, v5, v7)) continue;
            return true;
        }
        this.I0o.OOo(v3, v5, v7);
        for (GuiSupport_o0ii_1 v9 : this.RenderSupport_oio_2) {
            v9.OOo(v3, v5, v7);
        }
        return super.method_25402(param1, param2);
    }

    private boolean iIo() {
        if (this.field_22787 == null) {
            return false;
        }
        long v1 = this.field_22787.getWindow().getHandle();
        return GLFW.glfwGetKey((long)v1, (int)342) == 1;
    }

    private void OOOo(DrawContext param1) {
        if (this.field_22787 == null || this.field_22787.textRenderer == null) {
            return;
        }
        int v3 = param1.getScaledWindowHeight();
        Objects.requireNonNull(this.field_22787.textRenderer);
        int v5 = v3 - 18 - 6;
        int v6 = v3 - 9 - 4;
        String v7 = ConfigSupport_oii0_1.O0i() ? "\u00a7fRole: \u00a7l\u00a7cAdmin" : (ConfigSupport_oii0_1.OoO() ? "\u00a7fRole: \u00a7l\u00a76Beta" : "\u00a7fRole: \u00a7l\u00a7aUser");
        String v8 = "\u00a7fHold \u00a7bLeft Alt \u00a7ffor setting help. Hold \u00a7l\u00a7bLeft Shift \u00a7r\u00a7ffor precise sliders.";
        param1.drawText(this.field_22787.textRenderer, v7, 4, v5, -1, true);
        param1.drawText(this.field_22787.textRenderer, v8, 4, v6, -1, true);
    }

    public boolean method_25406(Click param1) {
        double v2 = param1.x();
        double v4 = param1.y();
        int v6 = param1.button();
        this.I0o.GuiSupport_OOI(v2, v4, v6);
        for (GuiSupport_o0ii_1 v8 : this.RenderSupport_oio_2) {
            v8.GuiSupport_OOI(v2, v4, v6);
        }
        return super.method_25406(param1);
    }
}

