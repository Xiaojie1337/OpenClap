/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.util.InputUtil
 *  org.lwjgl.glfw.GLFW
 */
package clap.gui;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import clap.model.EnumType_0OI;
import clap.event.EventBusApi;

public class GuiSupport_O000
implements EventBusApi {
    private static final int oooi;
    private int ooIO;
    private EnumType_0OI ooI0 = EnumType_0OI.PacketEvent;
    static Object ooIo;
    private static volatile /* synthetic */ long __k__gH4it;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean iOio() {
        if (this.ooI0 != EnumType_0OI.PacketEvent) return false;
        return true;
    }

    public int iOIo() {
        return this.ooIO;
    }

    public static GuiSupport_O000 iOIO() {
        return new GuiSupport_O000(-1);
    }

    public EnumType_0OI iOIi() {
        return this.ooI0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean iOi0() {
        if (this.ooI0 != EnumType_0OI.HelpCommand) return false;
        return true;
    }

    public int i0OO() {
        return -this.ooIO - 2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void iOiO(EnumType_0OI param1) {
        this.ooI0 = param1 == null ? EnumType_0OI.PacketEvent : param1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean iOii() {
        if (this.ooIO >= -1) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean iOiI() {
        if (this.ooIO != -1) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private String i0OI(String param1) {
        block88: {
            block89: {
                if (param1 == null) return "Unknown";
                if (param1.isEmpty()) {
                    return "Unknown";
                }
                v2 = param1.toLowerCase().replace("key.keyboard.", "").replace("key.mouse.", "mouse ");
                v4 = -1;
                switch (v2.hashCode()) {
                    case 1980578003: {
                        if (v2.equals("grave.accent")) {
                            v4 = 10;
                        }
                        break block88;
                    }
                    case -1934256493: {
                        if (v2.equals("num.lock")) {
                            v4 = 29;
                        }
                        break block88;
                    }
                    case 838155425: {
                        if (v2.equals("page.down")) {
                            v4 = 28;
                        }
                        break block88;
                    }
                    case 103901296: {
                        if (v2.equals("minus")) {
                            v4 = 20;
                        }
                        break block88;
                    }
                    case 109519229: {
                        if (v2.equals("slash")) {
                            v4 = 18;
                        }
                        break block88;
                    }
                    case 1688149622: {
                        if (v2.equals("left.control")) {
                            v4 = 0;
                        }
                        break block88;
                    }
                    case 109637894: {
                        if (v2.equals("space")) {
                            v4 = 23;
                        }
                        break block88;
                    }
                    case 874014145: {
                        if (v2.equals("left.bracket")) {
                            v4 = 11;
                        }
                        break block88;
                    }
                    case 1717303669: {
                        if (v2.equals("left.win")) {
                            v4 = 6;
                        }
                        break block88;
                    }
                    case -803595686: {
                        if (v2.equals("page.up")) {
                            v4 = 27;
                        }
                        break block88;
                    }
                    case -1470686935: {
                        if (!v2.equals("right.super")) break;
                        v4 = 9;
                        break;
                    }
                    case 138429999: {
                        if (!v2.equals("apostrophe")) break;
                        v4 = 15;
                        break;
                    }
                    case 1057658843: {
                        if (!v2.equals("left.shift")) break;
                        v4 = 2;
                        break;
                    }
                    case 2019970988: {
                        if (!v2.equals("scroll.lock")) break;
                        v4 = 30;
                        break;
                    }
                    case 1353389302: {
                        if (!v2.equals("backslash")) break;
                        v4 = 13;
                        break;
                    }
                    case -284840886: {
                        if (!v2.equals("unknown")) break;
                        v4 = 36;
                        break;
                    }
                    case 114581: {
                        if (!v2.equals("tab")) break;
                        v4 = 24;
                        break;
                    }
                    case -1294172031: {
                        if (!v2.equals("escape")) break;
                        v4 = 21;
                        break;
                    }
                    case 1353507967: {
                        if (!v2.equals("backspace")) break;
                        v4 = 25;
                        break;
                    }
                    case -1570261289: {
                        if (!v2.equals("right.alt")) break;
                        v4 = 5;
                        break;
                    }
                    case -1774232693: {
                        if (!v2.equals("right.control")) break;
                        v4 = 1;
                        break;
                    }
                    case 1058052820: {
                        if (!v2.equals("left.super")) break;
                        v4 = 7;
                        break;
                    }
                    case -261896499: {
                        if (!v2.equals("print.screen")) break;
                        v4 = 31;
                        break;
                    }
                    case 3739: {
                        if (!v2.equals("up")) break;
                        v4 = 34;
                        break;
                    }
                    case -714091343: {
                        if (!v2.equals("semicolon")) break;
                        v4 = 14;
                        break;
                    }
                    case -1570240246: {
                        if (!v2.equals("right.win")) break;
                        v4 = 8;
                        break;
                    }
                    case 1717282626: {
                        if (!v2.equals("left.alt")) break;
                        v4 = 4;
                        break;
                    }
                    case 94843605: {
                        if (!v2.equals("comma")) break;
                        v4 = 16;
                        break;
                    }
                    case -1636095976: {
                        if (!v2.equals("caps.lock")) break;
                        v4 = 26;
                        break;
                    }
                    case 3089570: {
                        if (!v2.equals("down")) break;
                        v4 = 35;
                        break;
                    }
                    case 1706599126: {
                        if (!v2.equals("right.bracket")) break;
                        v4 = 12;
                        break;
                    }
                    case 3317767: {
                        if (!v2.equals("left")) break;
                        v4 = 32;
                        break;
                    }
                    case 96757556: {
                        if (!v2.equals("equal")) break;
                        v4 = 19;
                        break;
                    }
                    case 96667352: {
                        if (!v2.equals("enter")) break;
                        v4 = 22;
                        break;
                    }
                    case 108511772: {
                        if (!v2.equals("right")) break;
                        v4 = 33;
                        break;
                    }
                    case -991726143: {
                        if (!v2.equals("period")) break;
                        v4 = 17;
                        break;
                    }
                    case -1471080912: {
                        if (v2.equals("right.shift")) break block89;
                    }
                }
                break block88;
            }
            v4 = 3;
        }
        switch (v4) {
            case 29: {
                return "NumLock";
            }
            case 1: {
                return "RCtrl";
            }
            case 14: {
                return ";";
            }
            case 36: {
                return "Unknown";
            }
            case 11: {
                return "[";
            }
            case 5: {
                return "RAlt";
            }
            case 23: {
                return "Space";
            }
            case 22: {
                return "Enter";
            }
            case 17: {
                return ".";
            }
            case 2: {
                return "LShift";
            }
            case 10: {
                return "Grave";
            }
            case 18: {
                return "/";
            }
            case 28: {
                return "PageDown";
            }
            case 13: {
                return "\\";
            }
            case 33: {
                return "Right";
            }
            case 8: 
            case 9: {
                return "RWin";
            }
            case 16: {
                return ",";
            }
            case 20: {
                return "-";
            }
            case 21: {
                return "Esc";
            }
            case 25: {
                return "Backspace";
            }
            case 0: {
                return "LCtrl";
            }
            case 6: 
            case 7: {
                return "LWin";
            }
            default: {
                if (v2.startsWith("kp.")) {
                    v0 = "Num" + this.i0Oo(v2.substring(3));
                    return v0;
                }
                ** GOTO lbl225
            }
            case 24: {
                return "Tab";
            }
            case 19: {
                return "=";
            }
            case 4: {
                return "LAlt";
            }
            case 34: {
                return "Up";
            }
            case 3: {
                return "RShift";
            }
            case 15: {
                return "'";
            }
            case 35: {
                return "Down";
            }
            case 30: {
                return "ScrollLock";
            }
            case 27: {
                return "PageUp";
            }
lbl225:
            // 1 sources

            v0 = this.i0Oo(v2);
            return v0;
            case 26: {
                return "CapsLock";
            }
            case 32: {
                return "Left";
            }
            case 31: {
                return "PrintScreen";
            }
            case 12: 
        }
        return "]";
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean i0O0() {
        if (this.iOiI()) {
            return false;
        }
        if (this.iOii()) {
            if (GLFW.glfwGetMouseButton((long)ConfigSupport_OI0.getWindow().getHandle(), (int)this.i0OO()) == 1) return true;
            return false;
        }
        if (GLFW.glfwGetKey((long)ConfigSupport_OI0.getWindow().getHandle(), (int)this.iOIo()) != 1) return false;
        return true;
    }

    public void iOII(int param1) {
        this.ooIO = param1;
    }

    /*
     * Enabled aggressive block sorting
     */
    private String i0Oo(String param1) {
        String string;
        if (param1.isEmpty()) {
            return "";
        }
        char c = Character.toUpperCase(param1.charAt(0));
        if (param1.length() == 1) {
            string = "";
            return c + string;
        }
        string = param1.substring(1).toLowerCase();
        return c + string;
    }

    public String toString() {
        if (this.iOiI()) {
            return "None";
        }
        return this.IoOO();
    }

    public String IoOO() {
        if (this.iOiI()) {
            return "None";
        }
        if (this.iOii()) {
            return "Mouse " + this.i0OO();
        }
        return this.i0OI(InputUtil.fromKeyCode((KeyInput)new KeyInput(this.ooIO, 0, 0)).getTranslationKey());
    }

    static {
        __k__gH4it = GuiSupport_O000.__k__gH4it((long)-3552728924616135151L);
        __rP__gH4it0 = new String[]{"\ued17\u7b96\uab0e\ufe23\u7931\ud3e7\uce22\ua85e\ue28c\u74af\uaabb\uff54\u7883\ud2c6\ucf7b\ua901\ue39a\u7531\ua948\ufc6a\u7b05\ud1ca\ucc11\uaa00\ue0f9\u766e\ua958\ufde3\u7a74\ud029\ucd19\uab83\ue15f\u7749\ua8da\ufa55\u7d6d\ud793\uca5e\uac67\ue6db\u705c\uafa9\ufbdd\u7c9a\ud60f\ucb76\uad85\ue7b6\u71a6\uae64\ufb45\u7f0f\ud5c4\uc812\uaea9\ue42c\u72be\uad54\uf808\u7e83\ud45a\uc967\uaf5e\ue5de\u73ce\uac16\uf9cd\u613a\ucb4c\ud669\ub048\ufae8\u6cb5\ub3e5\ue61b\u6015\ucacc\ud7fa\ub1a5\ufb65\u6ddc\ub222\ue7e1\u60b8\uc909\ud408\ub239\uf810\u6efb\ub13b\ue471\u632d\uc8a6\ud527\ub3f4\uf9e6\u6f62\ub063\ue551\u6299\ucf74\ud20b\ub4a0\ufe1e\u6841\ub728\ue2a2\u6549\uceed\ud376\ub50f\uff7b\u6955\ub63a\ue318\u6447\ucebe\ud028\ub6aa\ufcf5\u6a5d\ub565\ue0f1\u6767\ucddd\ud1fd\ub7b7\ufd44\u6bc4\ub48f\ue195\u6689\uccaf\udee2\ub872\uf2f7\u646f\ubb73\uee92\u69e6\uc364\udfb2\ub932\uf347\u6576\uba43\uef75\u68f3\uc24e\udf06\uba28\uf060\u6686\ub9d7\uec50\u6bd8\uc1bd\udc90\ubb3c\uf131\u671c\ub81b\ued5f\u6ae2\uc0d4\udd35\ubcb4\uf647\u609c\ubf7c\uea33\u6d9c\uc760\udabc\ubdfa\uf75d\u610f\ubeb2\ueb6a\u6ca3\uc698\udbdd\ubdb1\uf4e8\u6276\ubd1b\ue845\u6f99\uc511\ud8c5\ubedd\uf52d\u63dc\ubc14\ue968\u6e33\uc456\ud9dd\ubfe8\u8a07\u1c7f\uc35e\u96b0\u112e\ubbbd\ua646\uc0c3\u8b3c\u1d42\uc2a4\u97b1\u10e4\uba9b\ua769\uc148\u8b91\u1e3b\uc19a\u9489\u1367\ub970\ua4d4\uc2f2\u880d\u1fb8\uc028\u95f4\u12a2\ub8ca\ua5cf\uc396\u893d\u1827\uc72c\u9275\u15c5\ubf13\ua28c\uc4bd\u8e1e\u195d\uc6eb\u9310\u1431\ube25\ua335\uc5ba\u8f99\u19fd\uc596\u90f0\u17d5\ubd39\ua006\uc661\u8cb3\u1a51\uc4dc\u91bd\u16b0\ubc0b\ua146\uc77f\u8d4a\u1b80\ucb76\u9e7e\u19e7\ub3ab\uaeb9\uc874\u82e3\u14b3\uca77\u9f52\u186f\ub27a\uaf19\uc99f\u838d\u15aa\uca0e\u9c7a\u1b96\ub1eb\uac23\uca02\u8002\u1613\uc9c4\u9d93\u1abd\ub099\uad9d\ucb5d\u81b6\u17eb\uc876\u9ab7\u1dde\ub7d8\uaa73\ucc4d\u867f\u10e5\ucf49\u9adf\u1c9b\ub6a0\uab37\ucdff\u8703\u1125\ucee9\u9ba9\u1f54\ub5b4\ua81e\uceb1\u8483\u12b7\ucd3f\u980b\u1ea0\ub431\ua987\ucf44\u85c5\u13c0\ucc33\u9957\u018b\uab01\ub6f5\ud041\u9afb\u0c3b\ud3f5\u8624\u0106\uaa40\ub799\ud1bd\u9be8\u0dfc\ud2c5\u87e9\u00a3\ua9ea\ub44d\ud2cb\u98eb\u0eec\ud10d\u8402\u038b\ua8cb\ub590\ud39c\u999a\u0fa0\ud042\u85d9\u020a\uafe8\ub216\ud4f6\u9ed9\u085d\ud7c2\u820a\u054b\uafb2\ub30f\ud526\u9f50\u0917\ud696\u8381\u0413\uaea2\ub0a6\ud60e\u9c5d\u0a01\ud5e8\u8068\u0778\uada1\ub168\ud7c2\u9dc8\u0bb5\ud4f8\u8166\u0608\uac9a\ube32\ud870\u92be\u04cc\udb75\u8e69\u0987\ua38c\ube7f\ud910\u93a4\u0560\udaf1\u8f02\u08cc\ua25e\ubfaf\uda23\u9083\u06fc\ud9b6\u8cdc\u0b0f\ua16d\ubca2\udba3\u912c\u075d\ud8f5\u8da2\u0a11\ua042\ubd27\udc27\u9681\u0011\udfdf\u8a1d\u0d3b\ua76b\uba24\udcf8\u9763\u0158\ude65\u8bbc\u0c08\ua6ea\ubbec\udd1b\u9466\u02d1\udde2\u88ab\u0f26\ua54c\ub8e7\ude39\u9565\u03fb\udcf4\u8943\u0e9d\ua4ee\ub948\udfd1\uaa6f\u3ce6\ue35e\ub6c8\u31db\u9b17\u86d4\ue07a\uaa33\u3de9\ue2c8\ub7ba\u306f\u9a61\u877e\ue162\uab91\u3eaf\ue148\ub480\u336a\u9934\u84da\ue22f\ua8b6\u3f34\ue0f5\ub50b\u327c\u981a\u85ba\ue3c3\ua98a\u38c4\ue72c\ub272\u35d5\u9fba\u8275\ue481\uae30\u38a9\ue6c2\ub3fc\u34ed\u9e1e\u8338\ue5d2\uaf64\u394c\ue53d\ub048\u37b8\u9db3\u8054\ue619\uac16\u3af4\ue49c\ub1bc\u3691\u9ce5\u81fa\ue734\uadfb\u3b29\uebeb\ube2e\u39c0\u9302\u8e60\ue83d\ua2a3\u34d3\ueb88\ubf65\u3846\u92e0\u8fd5\ue9c4\ua33a\u355f\uea74\ubc5c\u3bc7\u910b\u8c5f\uea75\ua008\u36bc\ue912\ubd88\u3ab0\u906a\u8d9a\uebcd\ua1dc\u37c7\ue8ff\ubd7b\u3de1\u974e\u8a96\uecd3\ua6ac\u30d5\uefd7\uba62\u3cff\u96c0\u8b70\uede5\ua73d\u317c\uee62\ubbbf\u3f4d\u95ef\u88f1\uee11\ua4ab\u325d\ued9f\ub882\u3e91\u946b\u8945\uefc3\ua528\u337e\uece6\ub97d\u3e4f\u8bed\u9671\uf067\uba43\u2c57\uf38b\ua60b\u21d0\u8a53\u97c1\uf124\ubb83\u2d6a\uf23a\ua7be\u20a4\u89aa\u9407\uf242\ub81c\u2eb7\uf13e\ua46b\u239c\u8872\u95ad\uf357\ub993\u2fdd\uf032\ua554\u22e7\u88ad\u9260\uf488\ube8f\u2833\uf74f\ua2e6\u2594\u8f73\u93a3\uf5f7\ubf15\u290e\uf6a9\ua3be\u242b\u8e87\u90c4\uf671\ubca0\u2a42\uf5d6\ua034\u271b\u8d9d\u9167\uf7c8\ubd0d\u2bf4\uf4b5\ua173\u2648\u8cdf\u91de\uf86c\ub254\u2403\ufb69\uae0b\u29d7\u83c4\u9ecb\uf91c\ub320\u251d\ufa7a\uafdc\u28d8\u82c4\u9f58\ufa94", "\uef7d\u7989\ua63c\uf392\u7483\udde5\uc065\ua615\uec73\u7af3", "\uef68\u7989\ua62c\uf3fb\u749a"};
        __rP__gH4it1 = new String[]{"\uefc7\u79e6\ua699\uf384\u74c0\udd5f\uc024\ua641", "\uef7d\u7994\ua635"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\uef7f\u798b\ua622\uf38c\u7481\udde7\uc063\ua613\uec71\u7af1", "\uef6b\u7986\ua627\uf3eb\u74f3\udd96\uc01c\ua60a\uec77\u7a80\ua53f\uf0ef\u77bd\udd7c\uc106\ua739\ued7b\u7b5a\ua42a\uf1d3", "\uef6d\u7998\ua624\uf3f6\u7493\uddf2\uc078"};
        byte[] v0 = "\u0080-\u00c2\u000f)[\u00d5\u0093\u0003\fop\u0093r\u0084\u00c4\u001d\u009a\u0094vmF\u0016\u00fd\u0006\u00fd|\u00f7\u0014\u00ad\u0016v\u00a8\u00d2\u00f6Y\u0015\u000fI\u008a4\u00df\u009d\u00d9\u00ea\u009bi`Q-X\u00b9G(5\u00b4\u00f3MP\u00fc\u00c3\u00beHK\t5\u001a!b\u00b0^E'V\u00f1\u00ffE8\u00c5\u00a0\u00a27>=\u0010\u00c5O\u0004/(_\u00a5\u008dbh\u00c1\u00d1\u00b9\u000f\u009d!\u00a8\\\u008d1\u0082\\f\u00f99)*\\\u009eF\u00a4\u00cf\u0092O\u00f7\u00ean!E\u00e7\u00f9\u0092\u00e2S\u00ff\u00c39\u0011\u0093\u0095?\u00f8L'6vP\u00cdw@]\u001f\u00e9\u001bB\u0081U\u001f\u0095s\u00c48\u00b9\u001fIF\u0007\u00b7\u00d3\u001a\u00c8\u00a2\u00d9(\u009f\u00c8\u00b7lt#\u009f:\u0004\u000e\u0016k\u00f4z,\u00b7\u0005\u009f1YujHz\u00a7\u0098\u0004\u00eb*jeH\u001c\u00ca\u00d4\u00fe\u00c9\u00f9F{)8\u00ed\u00cc\u00d7\u00ae\u00f5.h~\u00ddG4\u001bG\u00ba\u00e3\u00c4\u00b8\u009a\u0096\u0018;\u0092d\u00d81\u00f5GS\u0018\u00b9\u0016\u0017,9\u0089\u00d2g\u0006NR\u00c4\u00d5\u009d\u00e9\u00b4$\u00ea\u0010\u0091\u00a8\u00b7\u00b1\u00b2\u00c5#\u00a2Z\u00f7\u001fF\u00b1d\u0018\u00abN\u0007\u00f6\u001ebr9*n\u00f6o,\u00f7\u00f5\u0088\u00e8\u009f\u00c5\u0005\u008a\u00b0YhB\u00b3\u00aeLl\u00a8\u0098nu#\u00d3L\u0010\u00e2\u00dc\u00d6\u00ed]\u0014P1\u00a4TL3\u00e7\u00f8\u00cd\u00b0I\n#'\u00b3\u00db\u00f5\u00caD<\u00d0\u00e9\u00f8\u00ae\u008c\u00de\u0080\u00d7/\u00a1=\u0003.\u0002\u00fe\u00dc7a\u00ce3\u0017\u00c7\u00b1\u00b5c6\u001d\u00ba<I\u00d3\u00fe\u0096\u00be\u00b6\u00c3\u009eh{O$\u00d25\u0093\u0086\u00c9[J:\u00a4\u00c4\u00e0\u009d\u001f\u008f\u00c7\u0096\u00ac\u00c2\u0098\u00aeM5\u00b9\u00e7)\u00f5o\u0080\u00f8m\u00dbsU\u0096,Z V\u00f4\u00e7\u001aP\u00f7q5\u00ceC^A&\u00e1V\u00b8B\u00e6\u001aca\u00f3\u0007\u0083e<+\u00e1\u00c8\u00c8\u008eC\u008e1\u00aan\u00c7\u00fe0P\u00b4*\u0098`'M\u009a\u00f7T(\u008d\u00c2\u0094\u00f3[\u0013\u00c7\u008c\u00ba,\u00eeO%\u00b1\u00d7&\u00f4\u00a4\u00ccRh\r\u0082\u0019w\u0001OLNef-\u008f\u00d0N\u00dd\u0016\u0092\\\u00af\u001a\u0006\u00c8\u00ed\u00ba\u00d7\u0007\u00f3\u00f7\u00f1d\u00a0\u000f\u00a3\u00d4\u0099WH\u0098\u0081Q\u0005\u00f1|\u008272\u00a8\u008eg\u00c0\\@\u00acq&d\u00da1\u00cd\u00c4XP\u00bf\u0097H\u0098\u00e7?&\u008c\u00c0\u00fe\u0085(;L\u00c3\u0087\u00a9\u00a2\u00b1\u00ces&\u00d3\u0096\u00bf$_\u00f0\u00ea\u0087nS\u0015\u0013\u00c6\u001cd\u00be\u008bf\u00c1\u009fz\u00c6\u00ef\u0095\u00fa\u00a1\u00e7!6Z|\u0084\u00ef\u00dfp\u0097\u008e\u0011\u00b4\u00b1Vr\u001cvPo3tJ\u00af,\u00a6\u00f2r\u00b4\u0016N\u00e8o\u0081\u0007\u00d5\u0090\u0000\u000bR\u0014W\u00cc\u00a2\u00025\u00e5\u0012\u00b3\u00bb\u00b3<\u00afa\u0082\u0090\u008b\u00a9\u0018\u008d\n\u00df\u00e9\u00ef\u00a0\u00d3Y\u0011+\u0010\u00cd\u009f7\u00c0DiW\u0006\u00d6P \u00d8\u00cf\u00f9".getBytes("ISO_8859_1");
        Object[] v1 = "\u00f2#\u00ebJz\u0085un".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -331286632;
                case 1 -> -346524524;
                case 2 -> -1192968826;
                case 3 -> 563985862;
                case 4 -> 1426531935;
                case 5 -> -1981335764;
                case 6 -> 94423805;
                case 7 -> -1390816909;
                case 8 -> 1352988634;
                case 9 -> 1547940697;
                case 10 -> -1978165986;
                case 11 -> -258842661;
                case 12 -> -511091504;
                case 13 -> -333420324;
                case 14 -> -381009626;
                case 15 -> -292007864;
                case 16 -> -1811551226;
                case 17 -> -1913275671;
                case 18 -> -428365195;
                case 19 -> -1267578015;
                case 20 -> -1144703544;
                case 21 -> 111003486;
                case 22 -> -1048070931;
                case 23 -> 249118164;
                case 24 -> 540502395;
                case 25 -> -680916396;
                case 26 -> -1378612646;
                case 27 -> -526112277;
                case 28 -> -671255733;
                case 29 -> -1508161375;
                case 30 -> -144274367;
                case 31 -> -664184457;
                case 32 -> -2092447184;
                case 33 -> 94936285;
                case 34 -> -1751852231;
                case 35 -> -1982240586;
                case 36 -> -1902144229;
                case 37 -> -1068855329;
                case 38 -> -597444073;
                case 39 -> 1291500499;
                case 40 -> 803598724;
                case 41 -> -418670705;
                case 42 -> -2053884774;
                case 43 -> -290305379;
                case 44 -> -4294992;
                case 45 -> 393178388;
                case 46 -> -1310212743;
                case 47 -> -1921979801;
                case 48 -> 1465337372;
                case 49 -> 550965280;
                case 50 -> -163068367;
                case 51 -> -1331006161;
                case 52 -> 1993489594;
                case 53 -> 23030707;
                case 54 -> -2108657358;
                case 55 -> 607023751;
                case 56 -> 1085805481;
                case 57 -> -514529822;
                case 58 -> -1048224908;
                case 59 -> -1479531648;
                case 60 -> 1947702939;
                case 61 -> -1791596209;
                case 62 -> 561165819;
                case 63 -> -2109333883;
                case 64 -> 2122328554;
                case 65 -> 1424399106;
                case 66 -> -1435755551;
                case 67 -> 1242027583;
                case 68 -> -1842853011;
                case 69 -> -615364376;
                case 70 -> -1111630999;
                case 71 -> 846312459;
                case 72 -> -930753449;
                case 73 -> 1623152035;
                case 74 -> 1480370563;
                case 75 -> 887006013;
                case 76 -> -140044519;
                case 77 -> -1150834814;
                case 78 -> -1502942639;
                case 79 -> -17808390;
                case 80 -> 234431559;
                case 81 -> 171432531;
                case 82 -> -148238441;
                case 83 -> -2027091541;
                case 84 -> 1712905107;
                case 85 -> 1287762465;
                case 86 -> 1315025671;
                case 87 -> 162401379;
                case 88 -> -2012118031;
                case 89 -> 502179879;
                case 90 -> 426603686;
                case 91 -> 1577867340;
                case 92 -> 1078270929;
                case 93 -> -587269254;
                case 94 -> 515748393;
                case 95 -> -1604851550;
                case 96 -> 862428076;
                case 97 -> 505813734;
                case 98 -> 1881583268;
                case 99 -> -153047192;
                case 100 -> 330812754;
                case 101 -> 2044553455;
                case 102 -> 1595720024;
                case 103 -> 1748783690;
                case 104 -> 456494349;
                case 105 -> 1007851572;
                case 106 -> -1697409880;
                case 107 -> -1367769686;
                case 108 -> 1245607992;
                case 109 -> 182923209;
                case 110 -> 1428265085;
                case 111 -> 1478225760;
                case 112 -> 1324840725;
                case 113 -> 604693333;
                case 114 -> -1687671407;
                case 115 -> 1401594015;
                case 116 -> -1451581680;
                case 117 -> 269674050;
                case 118 -> -1076615611;
                case 119 -> -666127087;
                case 120 -> 807816695;
                case 121 -> -1328782992;
                case 122 -> 1951509878;
                case 123 -> 150997967;
                case 124 -> 803440120;
                case 125 -> -358049734;
                case 126 -> -20337437;
                case 127 -> 1271568956;
                case 128 -> 50788748;
                case 129 -> 776308843;
                case 130 -> 351156350;
                case 131 -> 1122893216;
                case 132 -> -1345243851;
                case 133 -> 771619477;
                case 134 -> -2009157084;
                case 135 -> 925684304;
                case 136 -> 1388829248;
                case 137 -> -1332194986;
                case 138 -> 4425188;
                case 139 -> 1059048432;
                case 140 -> 1114302969;
                case 141 -> -707026444;
                case 142 -> -863187507;
                case 143 -> 880713959;
                case 144 -> -966360027;
                case 145 -> 675724110;
                case 146 -> 150880526;
                case 147 -> -1199097419;
                case 148 -> 1301458441;
                case 149 -> 1755140749;
                case 150 -> 1218849860;
                case 151 -> -444547952;
                case 152 -> 2031606478;
                case 153 -> 1220239250;
                case 154 -> 352604270;
                case 155 -> 2064540274;
                case 156 -> 1630039082;
                case 157 -> -77636187;
                case 158 -> 1417740333;
                case 159 -> 534788786;
                case 160 -> -970165570;
                case 161 -> 178264011;
                case 162 -> 438555584;
                case 163 -> -343002676;
                case 164 -> -1589759946;
                case 165 -> -959771459;
                case 166 -> 765241918;
                case 167 -> -1588849740;
                case 168 -> -1112846465;
                case 169 -> -1883983049;
                case 170 -> 1823015857;
                case 171 -> -1913952756;
                case 172 -> -870855970;
                case 173 -> 2069109746;
                case 174 -> -653607001;
                case 175 -> -1282788860;
                case 176 -> 605872850;
                case 177 -> 1914156877;
                case 178 -> 132439739;
                case 179 -> 295449948;
                case 180 -> 739228694;
                case 181 -> -872855526;
                case 182 -> -1146758622;
                case 183 -> 1257116253;
                case 184 -> -180328219;
                case 185 -> 355678601;
                case 186 -> -1343316074;
                case 187 -> 1930979457;
                case 188 -> -289702845;
                case 189 -> -1227231561;
                case 190 -> 845169153;
                case 191 -> 1406334003;
                case 192 -> -559576832;
                case 193 -> 1656733322;
                case 194 -> -1423308064;
                case 195 -> 1324752229;
                case 196 -> 1810431302;
                case 197 -> -348999029;
                case 198 -> 131356874;
                case 199 -> 368810969;
                case 200 -> 207901614;
                case 201 -> 2056205317;
                case 202 -> 1499235843;
                case 203 -> -1716188429;
                case 204 -> -531656419;
                case 205 -> 1284719279;
                case 206 -> 1602280060;
                case 207 -> -822501162;
                case 208 -> -278036578;
                case 209 -> 1074917135;
                case 210 -> 492505303;
                case 211 -> -1921361684;
                case 212 -> 17700543;
                case 213 -> -77652807;
                case 214 -> -1839531524;
                case 215 -> -419541701;
                case 216 -> 1512900966;
                case 217 -> 1556596779;
                case 218 -> -442840222;
                case 219 -> -985724024;
                case 220 -> -1773111595;
                case 221 -> 2062249572;
                case 222 -> -2086651886;
                case 223 -> 1840715420;
                case 224 -> 1836651560;
                case 225 -> 1125070785;
                case 226 -> 523165634;
                case 227 -> 724761276;
                case 228 -> -55151656;
                case 229 -> -2050227437;
                case 230 -> 672276344;
                case 231 -> -552103484;
                case 232 -> 1426530847;
                case 233 -> -117141249;
                case 234 -> 100433646;
                case 235 -> -1772725819;
                case 236 -> 106285347;
                case 237 -> -517914994;
                case 238 -> 1426440446;
                case 239 -> -1976366225;
                case 240 -> -1075733832;
                case 241 -> -144490383;
                case 242 -> 338705607;
                case 243 -> -1316237751;
                case 244 -> 896637464;
                case 245 -> 133769133;
                case 246 -> 1878066952;
                case 247 -> 1451730990;
                case 248 -> 1452777834;
                case 249 -> 882583899;
                case 250 -> -901906749;
                case 251 -> 212147820;
                case 252 -> -1270797159;
                case 253 -> -669677322;
                case 254 -> 1113578485;
                case 255 -> 240981002;
                default -> 773930267;
            });
        } while (v2 != 680);
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
            Object[] objectArray = new Object[78];
            v1 = objectArray;
            ooIo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        oooi = -1;
    }

    public GuiSupport_O000(int param1) {
        this.ooIO = param1;
    }

    public static GuiSupport_O000 iOI0(int param0) {
        return new GuiSupport_O000(-param0 - 2);
    }
}

