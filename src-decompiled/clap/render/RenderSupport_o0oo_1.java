/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11C
 *  org.lwjgl.opengl.GL30C
 */
package clap.render;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL30C;
import clap.render.RenderSupport_00io_1;
import clap.module.client.streamproof.StreamproofLogger;

/*
 * Renamed from clap.render.RenderSupport_o0oo_1
 */
public class RenderSupport_o0oo_1 {
    public int HelpCommand = -1;
    public int PacketEvent = -1;
    private final boolean O0o;
    public boolean EventBusApi;
    public int GuiSupport_OOI = -1;
    public int OOi = -1;
    public int OOo = -1;
    public boolean HudElement;
    static Object ConfigSupport_O0I;
    private static volatile /* synthetic */ long __k__gH4it;

    public void PacketEvent() {
        if (StreamproofLogger.HudElement == null) {
            return;
        }
        int v1 = StreamproofLogger.HudElement.getFramebuffer().textureWidth;
        int v2 = StreamproofLogger.HudElement.getFramebuffer().textureHeight;
        if (v1 != this.GuiSupport_OOI || v2 != this.OOi || this.PacketEvent == -1) {
            this.HelpCommand(v1, v2);
        }
    }

    public void OOo() {
        this.PacketEvent();
        RenderSupport_00io_1.PacketEvent();
        RenderSupport_00io_1.Ooo(36160, this.PacketEvent);
        this.HudElement = true;
    }

    public void OOi() {
        this.OOo();
        RenderSupport_00io_1.ConfigSupport_OII();
        this.GuiSupport_OOI();
        this.EventBusApi = false;
    }

    private void HelpCommand(int param1, int param2) {
        this.GuiSupport_OOI = param1;
        this.OOi = param2;
        RenderSupport_00io_1.PacketEvent();
        if (this.PacketEvent != -1) {
            GL30C.glDeleteFramebuffers((int)this.PacketEvent);
        }
        if (this.HelpCommand != -1) {
            GL11C.glDeleteTextures((int)this.HelpCommand);
        }
        if (this.OOo != -1) {
            GL11C.glDeleteTextures((int)this.OOo);
        }
        this.PacketEvent = RenderSupport_00io_1.EventBusApi();
        this.HelpCommand = RenderSupport_00io_1.HudElement();
        RenderSupport_00io_1.O0i(this.HelpCommand);
        RenderSupport_00io_1.KeystrokesHudElement();
        RenderSupport_00io_1.OIo(3553, 0, 32856, param1, param2, 0, 6408, 5121, null);
        if (this.O0o) {
            this.OOo = RenderSupport_00io_1.HudElement();
            RenderSupport_00io_1.O0i(this.OOo);
            RenderSupport_00io_1.ConfigSupport_OI0();
            RenderSupport_00io_1.OIo(3553, 0, 33191, param1, param2, 0, 6402, 5125, null);
        }
        RenderSupport_00io_1.Ooo(36160, this.PacketEvent);
        RenderSupport_00io_1.OoI(36160, 36064, 3553, this.HelpCommand, 0);
        if (this.O0o) {
            RenderSupport_00io_1.OoI(36160, 36096, 3553, this.OOo, 0);
        }
        if (!RenderSupport_00io_1.Ooi(36160)) {
            throw new IllegalStateException("Streamproof framebuffer incomplete");
        }
        RenderSupport_00io_1.ConfigSupport_OII();
        RenderSupport_00io_1.HelpCommand();
        this.EventBusApi = false;
    }

    public void GuiSupport_OOI() {
        this.HudElement = false;
        RenderSupport_00io_1.HelpCommand();
        this.EventBusApi = true;
    }

    public RenderSupport_o0oo_1(boolean param1) {
        this.O0o = param1;
    }

    static {
        __k__gH4it = RenderSupport_o0oo_1.__k__gH4it((long)-5652769393201910255L);
        __rP__gH4it0 = new String[]{"\u961d\ufe69\u213e\u7490\uf385\ubce3\uba83\u23e8\u9703\uff03", "\u967b\ufe92\u2186\u74e9\uf3fb\ubcfb\uba17\u2353", "\u961d\ufe70\u212f", "\u9608\ufe65\u213e\u74ed\uf38c"};
        __rP__gH4it1 = new String[]{"\u961f\ufe6b\u2138\u7496\uf387\ubce1\uba8d\u23e6\u9701\uff01", "\u960d\ufe78\u213e\u74ec\uf385\ubce4\ubab6"};
        __rP__gH4it2 = new String[]{"\u969f\ufe6e\u21ab\u745f\uf387\ubdb2\ubb90\u235d\u97b9\uffd1\u20b6\u7548\uf257\ubc53\uba50\u2334\u90c5\uf84a\u27b6\u72fc\uf52b\ubbd9\ubd3a\u242c\u9107\uf9ff\u267b\u7397\uf445\ubaf5\ubc41\u25d6\u9257\ufa4a\u25f7\u70d6\uf7ce\ub9c4\ubfd2\u268d\u938c\ufbfd\u24c8\u71de\uf67b\ub825\ubeec\u2748\u938c\uf45e\u2bfc\u7e72\uf9b5\ub745\ub11a\u28c0\u9cdb\uf5f5\u2a8b\u7f00\uf881\ub697\ub0ec\u29a0\u9dac\uf636\u29aa\u7ca6\ufb3c\ub545\ub34e\u2a5b"};
        __rP__gH4it3 = new String[]{"\u960b\ufe62\u213d\u74fd\uf3e5\ubc9c\ubaf2\u23fb\u9707\uff74\u2035\u7599\uf28b\ubb86\ubdd8\u24b8\u903b\uf85e\u2710\u72a5"};
        byte[] v0 = "\u0088\u0091\u001d\u00d5y\u00a4\u00e9\u00c1\u00a6&\b\u00ca\u00a1=\u0011P\u00e2\u00c50\u0086\u00e5\u00bfs@(x\u00f5\u00e5\u0083\u008b\u0010\u00a2`\u00d5a\u00bc\u0010\u00b2\u008b\u00f1\u00b3jV\u00bc\u00adk\u00cd\fK\u00f1\u001a(\u009b\u00033\u008c\u0014ReR\u00a7\u00c9\u00dd\u00f4{\u0089\\\u00ec\u0002\u0013w\u0007".getBytes("ISO_8859_1");
        Object[] v1 = ".\u00ab\u00f6!G#\u00a0\u008d".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 89714770;
                case 1 -> 32840083;
                case 2 -> -534219153;
                case 3 -> -1466898452;
                case 4 -> 1255069643;
                case 5 -> 755315314;
                case 6 -> 532335187;
                case 7 -> 392753909;
                case 8 -> 12648129;
                case 9 -> 1781383017;
                case 10 -> -1075212722;
                case 11 -> 17478169;
                case 12 -> 1440710953;
                case 13 -> -1036732539;
                case 14 -> 1199044400;
                case 15 -> -1868958372;
                case 16 -> 1988396210;
                case 17 -> 269385013;
                case 18 -> 886178511;
                case 19 -> -1584549600;
                case 20 -> 610795391;
                case 21 -> -584950372;
                case 22 -> 1274916576;
                case 23 -> 1579604045;
                case 24 -> 1983512627;
                case 25 -> -103576562;
                case 26 -> -1155286851;
                case 27 -> -615150194;
                case 28 -> -1098758202;
                case 29 -> 807862864;
                case 30 -> 131911138;
                case 31 -> 577282138;
                case 32 -> 800935754;
                case 33 -> 1025414328;
                case 34 -> 2026594897;
                case 35 -> 1748858839;
                case 36 -> -1298396587;
                case 37 -> 1340485151;
                case 38 -> 1658435857;
                case 39 -> -194722524;
                case 40 -> 1003289667;
                case 41 -> -1669849161;
                case 42 -> -1695110803;
                case 43 -> -1022186748;
                case 44 -> 1175088347;
                case 45 -> 1445578232;
                case 46 -> 1940076813;
                case 47 -> 1895252107;
                case 48 -> -2070749905;
                case 49 -> 1709315323;
                case 50 -> 2085499430;
                case 51 -> -628720000;
                case 52 -> 1458440471;
                case 53 -> -338703882;
                case 54 -> 2124029886;
                case 55 -> -955964553;
                case 56 -> -2110651327;
                case 57 -> -1651686977;
                case 58 -> 1987932740;
                case 59 -> 1562509551;
                case 60 -> -1960751212;
                case 61 -> 603731459;
                case 62 -> -185351684;
                case 63 -> 1094303929;
                case 64 -> 682883848;
                case 65 -> 268696422;
                case 66 -> 754076983;
                case 67 -> -2032325575;
                case 68 -> 1697325524;
                case 69 -> -419373502;
                case 70 -> -155104902;
                case 71 -> -569350988;
                case 72 -> 1978618940;
                case 73 -> 1062979943;
                case 74 -> 838766489;
                case 75 -> 0xB3BAA3B;
                case 76 -> 1030738074;
                case 77 -> 1202545172;
                case 78 -> -509229017;
                case 79 -> 489463221;
                case 80 -> 121735190;
                case 81 -> 1061167381;
                case 82 -> 583345415;
                case 83 -> 1896946568;
                case 84 -> -350593207;
                case 85 -> 33109625;
                case 86 -> 625289547;
                case 87 -> 1195577985;
                case 88 -> -2143935681;
                case 89 -> 2078814528;
                case 90 -> -1180878417;
                case 91 -> -145817664;
                case 92 -> 494410550;
                case 93 -> -1908820180;
                case 94 -> -306846851;
                case 95 -> 471134170;
                case 96 -> -730512190;
                case 97 -> 407487528;
                case 98 -> -506131077;
                case 99 -> -461494839;
                case 100 -> 62947956;
                case 101 -> -1470739850;
                case 102 -> 863996162;
                case 103 -> 4184421;
                case 104 -> -1198297768;
                case 105 -> 135996310;
                case 106 -> -1963019361;
                case 107 -> -188373997;
                case 108 -> -427591280;
                case 109 -> -424896092;
                case 110 -> 1743790881;
                case 111 -> 2061794746;
                case 112 -> -1768120106;
                case 113 -> 1249254567;
                case 114 -> -718238511;
                case 115 -> 1956739013;
                case 116 -> -1019751909;
                case 117 -> 9883629;
                case 118 -> 1137858639;
                case 119 -> 291872855;
                case 120 -> 1685376138;
                case 121 -> -1305606294;
                case 122 -> 853777417;
                case 123 -> 2024445315;
                case 124 -> -811326982;
                case 125 -> -1329204958;
                case 126 -> 902720187;
                case 127 -> 1438764476;
                case 128 -> -1553494311;
                case 129 -> 2032855077;
                case 130 -> 1213836318;
                case 131 -> -1928158327;
                case 132 -> 136046815;
                case 133 -> -1277017318;
                case 134 -> -1929380109;
                case 135 -> 1246334942;
                case 136 -> -1585365242;
                case 137 -> 1952159943;
                case 138 -> -1548403343;
                case 139 -> 699742348;
                case 140 -> -1865742521;
                case 141 -> 1076083683;
                case 142 -> -1014318593;
                case 143 -> 330577075;
                case 144 -> -829730093;
                case 145 -> 504430958;
                case 146 -> -466793926;
                case 147 -> 836807024;
                case 148 -> -1081506242;
                case 149 -> 1993639154;
                case 150 -> 1010281126;
                case 151 -> 1356146944;
                case 152 -> -1748631016;
                case 153 -> -724275651;
                case 154 -> -1979261995;
                case 155 -> -919048605;
                case 156 -> 418491186;
                case 157 -> -1125148950;
                case 158 -> 1566933352;
                case 159 -> 1433658113;
                case 160 -> -960933392;
                case 161 -> -1660230012;
                case 162 -> 1950246661;
                case 163 -> -783085726;
                case 164 -> 1756520648;
                case 165 -> -1672652127;
                case 166 -> 852861428;
                case 167 -> -200780472;
                case 168 -> -793290723;
                case 169 -> 1811388153;
                case 170 -> 67831724;
                case 171 -> 1979032780;
                case 172 -> 1649929448;
                case 173 -> -888121039;
                case 174 -> -1491078504;
                case 175 -> 2019425184;
                case 176 -> -571874948;
                case 177 -> -2098245401;
                case 178 -> -106596511;
                case 179 -> 1208936804;
                case 180 -> -452660239;
                case 181 -> 994314666;
                case 182 -> -187199027;
                case 183 -> -211849070;
                case 184 -> -1878696871;
                case 185 -> -1446045545;
                case 186 -> 1627188332;
                case 187 -> -1982603748;
                case 188 -> 299226615;
                case 189 -> -1595958039;
                case 190 -> 648694184;
                case 191 -> -24339851;
                case 192 -> -1174726245;
                case 193 -> 671596383;
                case 194 -> 1346613573;
                case 195 -> 2023748478;
                case 196 -> -504869146;
                case 197 -> -1331764172;
                case 198 -> 1560600080;
                case 199 -> -1411555587;
                case 200 -> 1262802833;
                case 201 -> 869306533;
                case 202 -> -847404680;
                case 203 -> -1820668883;
                case 204 -> -834572212;
                case 205 -> 1986219228;
                case 206 -> 386279137;
                case 207 -> 1829957080;
                case 208 -> -1432116645;
                case 209 -> 793972003;
                case 210 -> -344301557;
                case 211 -> 392533450;
                case 212 -> 1762387894;
                case 213 -> -2045847381;
                case 214 -> -339020375;
                case 215 -> 1538890398;
                case 216 -> -1653864845;
                case 217 -> 1944172976;
                case 218 -> 300250898;
                case 219 -> 751950509;
                case 220 -> 2095616494;
                case 221 -> 1980447618;
                case 222 -> -128133498;
                case 223 -> 1901936980;
                case 224 -> -1581676879;
                case 225 -> -1685325419;
                case 226 -> 1867919631;
                case 227 -> -1947992469;
                case 228 -> 1682663264;
                case 229 -> 116326116;
                case 230 -> -976382013;
                case 231 -> -307084323;
                case 232 -> 1394832126;
                case 233 -> 832634511;
                case 234 -> -947302939;
                case 235 -> -1352451490;
                case 236 -> -803295509;
                case 237 -> -1745703075;
                case 238 -> -1840667605;
                case 239 -> 1588923789;
                case 240 -> 181207246;
                case 241 -> 1928576942;
                case 242 -> 724469034;
                case 243 -> 142159116;
                case 244 -> 572948643;
                case 245 -> 203959306;
                case 246 -> -1221906386;
                case 247 -> 2097295522;
                case 248 -> 1827323192;
                case 249 -> 1324485255;
                case 250 -> -1443636270;
                case 251 -> 128122064;
                case 252 -> -723606202;
                case 253 -> 279310749;
                case 254 -> 1566060118;
                case 255 -> 1424558788;
                default -> -15250476;
            });
        } while (v2 != 72);
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
            ConfigSupport_O0I = objectArray;
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

