/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.packet.s2c.play.GameMessageS2CPacket
 *  net.minecraft.text.ClickEvent
 *  net.minecraft.text.ClickEvent$RunCommand
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.Text
 */
package clap.module.player;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import clap.network.NetworkSupport_00OI;
import clap.render.FontRenderer;
import clap.core.module.Module;
import clap.render.RenderSupport_00oi_0;
import clap.setting.Setting;
import clap.model.DataRecord_o0io_2;
import clap.network.NetworkSupport_o0o_0;
import clap.model.DataRecord_oi0i_2;
import clap.gui.GuiSupport_oi0o_0;
import clap.model.DataRecord_oio_4;
import clap.core.module.ModuleCategory;
import clap.event.network.PacketSendEvent;
import clap.model.DataRecord_ooii_0;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.iio
 */
public class FastCraftModule
extends Module {
    private static final int 0I0i;
    private int 0i00;
    private final List 0i0O;
    private final Deque 0iO0;
    public final Setting SpawnerFinderModule;
    public final Setting 0Ii0;
    private final List 0iOi;
    private static final Pattern 0II0;
    public final Setting 0IIi;
    public final Setting 0IiI;
    private final Map 0iOo;
    private static final Pattern 0IIo;
    public final Setting 0oi;
    private final Set 0Iii;
    private static final int 0Io0;
    public final Setting 0III = this.OOi0o("Columns", 4, 2, 6);
    private final Set 0iOO;
    private static final int 0oi0;
    public final Setting 0Iio;
    private static final Pattern 0IIO;
    private static final float 0IoI;
    private static final int 0I0o;
    private static final int 0I00;
    private static final int 0IoO;
    private final List 0iOI;
    private static final String 0Ioi;
    private static final float 0Ioo;
    public final Setting 0IiO;
    private static final int 0I0I;
    static Object 0i0o;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    private String IOII(String param1) {
        String v3;
        if (param1 == null) {
            return null;
        }
        String v2 = param1.trim();
        if (v2.startsWith("/")) {
            v2 = v2.substring(1).trim();
        }
        if (!(v3 = v2.toLowerCase(Locale.ROOT)).startsWith("quickcraft ")) {
            return null;
        }
        String v4 = v2.substring("quickcraft ".length()).trim();
        if (v4.isEmpty()) {
            return null;
        }
        String[] v5 = v4.split("\\s+");
        return v5.length > 0 ? v5[0] : null;
    }

    @EventHandler
    public void RenderSupport_0I0(PacketSendEvent param1) {
        String v4;
        GameMessageS2CPacket v3;
        Object v2 = param1.PacketEvent();
        if (!(v2 instanceof GameMessageS2CPacket) || (v3 = (GameMessageS2CPacket)v2).overlay()) {
            return;
        }
        if (this.IOI0(v3.content())) {
            this.0iO0.clear();
            return;
        }
        v2 = this.I000(v3.content().getString());
        if (((String)v2).isEmpty()) {
            return;
        }
        if (0IIo.matcher((CharSequence)v2).find()) {
            this.I0OI();
            return;
        }
        if (this.IOIi((String)v2) || this.IOiO((String)v2)) {
            this.0iO0.clear();
            return;
        }
        this.0iO0.addLast(v2);
        if (this.0iO0.size() > 6) {
            this.0iO0.pollFirst();
        }
        if (!(v4 = this.I0Oi()).isEmpty() && this.IOiO(v4)) {
            this.0iO0.clear();
        }
    }

    public void IOoI(DrawContext param1, int param2, int param3, int param4, int param5) {
        int v28;
        int v27;
        Object v23;
        if (FastCraftModule.ConfigSupport_OI0.player == null) {
            return;
        }
        this.0iOi.clear();
        this.0i0O.clear();
        List v6 = this.IOiI();
        this.0i00 = Math.min(this.0i00, Math.max(0, this.I0OO()));
        int v7 = (Integer)this.0III.HelpCommand();
        int v8 = (Integer)this.0IIi.HelpCommand();
        int v9 = (Integer)this.SpawnerFinderModule.HelpCommand();
        int v10 = v7 * 18 + Math.max(0, v7 - 1) * 4;
        int v11 = v8 * 18 + Math.max(0, v8 - 1) * 4;
        int v12 = v10 + v9 * 2;
        int v13 = 19 + v11 + v9 * 2 + 17;
        int v14 = this.I0oI(param2, v12);
        int v16 = v14 + v9;
        int v17 = param3 + 19 + v9;
        int v18 = this.IOii();
        int v19 = this.0i00 * v18;
        int v20 = Math.min(v6.size(), v19 + v18);
        ArrayList<MutableText> v21 = null;
        for (int v22 = v19; v22 < v20; ++v22) {
            v23 = (DataRecord_o0io_2)v6.get(v22);
            int v24 = v22 - v19;
            int v25 = v24 % v7;
            int v26 = v24 / v7;
            v27 = v16 + v25 * 22;
            v28 = v17 + v26 * 22;
            boolean v29 = this.I0oi(param4, param5, v27, v28, 18, 18);
            boolean v30 = this.0iOO.contains(((DataRecord_o0io_2)v23).OOoi());
            this.0iOi.add(new DataRecord_oio_4(v27, v28, 18, 18, (DataRecord_o0io_2)v23));
            if (!v29 || v21 != null) continue;
            v21 = new ArrayList<MutableText>();
            v21.add(Text.literal((String)((DataRecord_o0io_2)v23).SprintResetModule()));
            if (!v30) continue;
            v21.add(Text.literal((String)"Craft limit reached"));
        }
        this.I00o(param1, v14, param3, v12, v13, param4, param5);
        String v22 = "FastCraft";
        param1.drawText(FastCraftModule.ConfigSupport_OI0.textRenderer, v22, v14 + v9, param3 + 6, ((Color)this.0IiI.HelpCommand()).getRGB(), false);
        v23 = String.valueOf(v6.size());
        param1.drawText(FastCraftModule.ConfigSupport_OI0.textRenderer, (String)v23, v14 + v12 - v9 - FastCraftModule.ConfigSupport_OI0.textRenderer.getWidth((String)v23), param3 + 6, -6642507, false);
        for (DataRecord_oio_4 v25 : this.0iOi) {
            ItemStack v26 = v25.ooi.MoveFixModule();
            param1.drawItem(v26, v25.RenderSupport_ooo_0 + 1, v25.oo0 + 1);
        }
        int v24 = param3 + v13 - 17;
        int v25 = this.I0OO();
        boolean v26 = this.0i00 > 0;
        v27 = this.0i00 < v25 ? 1 : 0;
        v28 = this.I0IO(210);
        int v31 = v14 + v9 - 2;
        int v32 = v14 + v12 - v9 - 12 + 2;
        int v33 = v24 + 2;
        FontRenderer v34 = NetworkSupport_00OI.O0i(10);
        this.I0oo(param1, v34, ",", v31, v33, 12, 12, v26 ? v28 : -9275518);
        this.I0oo(param1, v34, ";", v32, v33, 12, 12, v27 != 0 ? v28 : -9275518);
        this.0i0O.add(new DataRecord_oi0i_2(v31, v33 - 2, 12, 16, false));
        this.0i0O.add(new DataRecord_oi0i_2(v32, v33 - 2, 12, 16, true));
        String v35 = this.0i00 + 1 + "/" + (v25 + 1);
        int v36 = FastCraftModule.ConfigSupport_OI0.textRenderer.getWidth(v35);
        param1.drawText(FastCraftModule.ConfigSupport_OI0.textRenderer, v35, v14 + v12 / 2 - v36 / 2, v24 + 5, -3616289, false);
        if (v6.isEmpty()) {
            String v37 = (Boolean)this.0IiO.HelpCommand() != false ? "Waiting" : "Empty";
            int v38 = FastCraftModule.ConfigSupport_OI0.textRenderer.getWidth(v37);
            int v39 = v14 + v12 / 2 - v38 / 2;
            int n = v17 + v11 / 2;
            Objects.requireNonNull(FastCraftModule.ConfigSupport_OI0.textRenderer);
            int v40 = n - 4;
            param1.drawText(FastCraftModule.ConfigSupport_OI0.textRenderer, v37, v39, v40, -7498074, false);
        }
        if (v21 != null) {
            param1.drawTooltip(FastCraftModule.ConfigSupport_OI0.textRenderer, v21, param4, param5);
        }
    }

    private void I0Oo() {
        this.0i00 = Math.max(this.0i00 - 1, 0);
    }

    private int I0IO(int param1) {
        Color v2 = 0ooo.EventHandler() != null ? 0ooo.OOoo().HelpCommand() : Color.WHITE;
        return (param1 & 0xFF) << 24 | (v2.getRed() & 0xFF) << 16 | (v2.getGreen() & 0xFF) << 8 | v2.getBlue() & 0xFF;
    }

    @Override
    public void 0oI() {
        this.I0OI();
    }

    public void IOIO(DataRecord_o0io_2 param1) {
        if (param1 == null || ConfigSupport_OI0.getNetworkHandler() == null) {
            return;
        }
        ConfigSupport_OI0.getNetworkHandler().sendChatCommand("quickcraft " + param1.OOoi());
    }

    private void I00o(DrawContext param1, int param2, int param3, int param4, int param5, int param6, int param7) {
        boolean v8 = RenderSupport_00oi_0.OOo(ConfigSupport_OI0.getWindow().getScaledWidth(), ConfigSupport_OI0.getWindow().getScaledHeight(), ConfigSupport_OI0.getWindow().getScaleFactor());
        if (v8) {
            try {
                this.I00I(param2, param3, param4, param5);
                for (DataRecord_oio_4 v10 : this.0iOi) {
                    boolean v11 = this.I0oi(param6, param7, v10.RenderSupport_ooo_0, v10.oo0, v10.ooo, v10.ooI);
                    boolean v12 = this.0iOO.contains(v10.ooi.OOoi());
                    int v13 = v12 ? 1358909279 : (v11 ? ((Color)this.0Iio.HelpCommand()).getRGB() : ((Color)this.0Ii0.HelpCommand()).getRGB());
                    this.I0oO(v10.RenderSupport_ooo_0, v10.oo0, v10.ooo, v10.ooI, v13, v11);
                }
                return;
            }
            finally {
                RenderSupport_00oi_0.GuiSupport_OOI();
                param1.createNewRootLayer();
            }
        }
        this.I00i(param1, param2, param3, param4, param5);
        for (DataRecord_oio_4 v10 : this.0iOi) {
            boolean v11 = this.I0oi(param6, param7, v10.RenderSupport_ooo_0, v10.oo0, v10.ooo, v10.ooI);
            boolean v12 = this.0iOO.contains(v10.ooi.OOoi());
            int v13 = v12 ? 1358909279 : (v11 ? ((Color)this.0Iio.HelpCommand()).getRGB() : ((Color)this.0Ii0.HelpCommand()).getRGB());
            this.I0o0(param1, v10.RenderSupport_ooo_0, v10.oo0, v10.ooo, v10.ooI, v13, v11);
        }
    }

    private String I0Oi() {
        if (this.0iO0.isEmpty()) {
            return "";
        }
        StringBuilder v1 = new StringBuilder(160);
        for (String v3 : this.0iO0) {
            if (!v1.isEmpty()) {
                v1.append(' ');
            }
            v1.append(v3);
        }
        return v1.toString();
    }

    private boolean IOI0(Text param1) {
        ConcurrentHashMap.KeySetView v2 = ConcurrentHashMap.newKeySet();
        this.IOIo(param1, v2);
        if (v2.isEmpty()) {
            return false;
        }
        boolean v3 = false;
        for (String v5 : v2) {
            if (v5 == null || v5.isEmpty() || this.0iOO.contains(v5)) continue;
            this.0Iii.add(v5);
            v3 = true;
        }
        return v3;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        NetworkSupport_o0o_0.PacketEvent();
        this.IOio();
        this.I0OI();
    }

    public FastCraftModule() {
        super("FastCraft", "Shows quick craft artifacts beside the inventory.", ModuleCategory.ioo);
        this.0IIi = this.OOi0o("Rows", 3, 1, 6);
        this.SpawnerFinderModule = this.OOi0o("Padding", 6, 2, 10);
        this.0IiO = this.OOi00("SmartFilter", true);
        this.0oi = this.OOioo("BackgroundColor", 18, 18, 24, 176);
        this.0Ii0 = this.OOioo("SlotColor", 255, 255, 255, 20);
        this.0Iio = this.OOioo("HoverColor", 255, 255, 255, 46);
        this.0IiI = this.OOioo("TitleColor", 215, 227, 240, 255);
        this.0Iii = ConcurrentHashMap.newKeySet();
        this.0iOO = ConcurrentHashMap.newKeySet();
        this.0iO0 = new ArrayDeque();
        this.0iOo = new HashMap();
        this.0iOI = new ArrayList();
        this.0iOi = new ArrayList();
        this.0i0O = new ArrayList();
    }

    private boolean IOiO(String param1) {
        Matcher v2 = 0IIO.matcher(param1);
        if (!v2.find()) {
            return false;
        }
        String v3 = this.IOi0(v2.group(1).trim());
        if (v3 == null || this.0iOO.contains(v3)) {
            return false;
        }
        this.0Iii.add(v3);
        return true;
    }

    static {
        __k__gH4it = FastCraftModule.__k__gH4it(3707197807849893393L);
        __rP__gH4it0 = new String[]{"\u37ca\u5bef\u843a\ud1b9\u5627\uc0c6\u8f07\u874e"};
        __rP__gH4it1 = new String[]{"\u3744\u5b0a\u8495\ud17a\u562b\uc08d\u8ff1\u8793\u365a\u5a60", "\u3756\u5b19\u8563\ud130\u5659\uc0b8\u8f0a", "\u3753\u5b04\u849b\ud131\u5650"};
        __rP__gH4it2 = new String[]{"\u3746\u5b08\u849b\ud174\u5629\uc08f\u8ff7\u8795\u3658\u5a62", "\u3750\u5b1b\u8480\ud101\u5659\uc0f8\u8f8e\u878e\u365c\u5a1d\u8b98\ude75\u5927\ucfe2\u80a4\u88cd\u3960\u5507\u8b4d\udf79", "\u3746\u5b11\u848a"};
        __rP__gH4it3 = new String[]{"\u3631\u5a20\u84fe\ud13e\u565b\ucfbe\u80f8\u883b\u39db\u5523\u8b6d\udea6\u5973\uce32\u8143\u8925\u38ca\u5454\u8a2f\udf7d\u5802\uce6b\u827d\u8abb\u3b8c\u57ab\u8931\udc75\u5b38\ucdd7\u8324\u8b8c\u3a3e\u56d1\u887f\udd2e\u5a35\ucc37\u84a3\u8cef\u3d3a\u51d3\u8f48\udacf\u5d13\ucbda\u854b\u8d08\u3c5c\u5087\u8e28\udbf9\u5c5e\uca2a\u8565\u8e16\u3f3a\u535f\u8dd4\ud84a\u5fb8\uc9e0\u867b\u8f92\u3edd\u52dd\u8c8a\ud9a9\u5e2f\uc820\u87d1\u909a\u219e\u4df8\u9318\uc62d\u41c5\ud7b8\u9831\u9185\u2066\u4c10\u9237\uc7ac\u40c7\ud6dc\u99f4\u91f3\u2311\u4f27\u91d5\uc4cf\u43d8\ud583\u9a04\u92df\u22cd\u4e18\u90d1\uc535\u4289\ud46c\u9bcd\u93dd\u25c7\u49b3\u9777\uc223\u455b\ud386\u9cd7\u9427\u248d\u4812\u9622\uc3e2\u44a1\ud29d\u9dbb\u952b\u24e0\u4b56\u956a\uc051\u47bd\ud16a\u9e3f\u96b7\u277b\u4a9d\u9491\uc1b7\u46eb\ud048\u9f8f\u9703\u2601\u4589\u9b8e\ucedc\u49ea\udf73\u9044\u98e1\u2928\u45eb\u9af1\ucf3a\u4898\ude4e\u9175\u9901\u2879\u4409\u99c3\ucc40\u4bb4\uddad\u928d\u9ab6\u2b3d\u47a2\u987a\ucd18\u4a9a\udca3\u93d5\u9ba2\u2a24\u461b\u9fe6\ucab3\u4d9e\udb53\u94fd\u9cb4\u2d63\u413d\u9fd8\ucb87\u4cc6\uda9c\u9558\u9d75\u2cca\u40c2\u9e12\uc82a\u4fdf\ud92f\u9640\u9ef2\u2f78\u43d6\u9df4\uc9a5\u4e01\ud8ec\u974a\u9f62\u2eff\u428b\u9c9b\uf6e5\u7197\ue70b\ua851\ua044\u11cc\u7d64\ua3de\uf694\u7014\ue64b\ua931\ua165\u1054\u7c03\ua2ca\uf79e\u73cc\ue506\uaa40\ua22a\u1353\u7fa0\ua1c8\uf489\u727c\ue4ec\uabda\ua3bc\u12b1\u7ee8\ua0fb\uf574\u756d\ue399\uac49\ua43e\u1513\u793f\ua789\uf26c\u75a2\ue241\uad4e\ua5c0\u1459\u782d\ua6c2\uf39e\u7438\ue136\uae38\ua67f\u179a\u7b81\ua5cf\uf094\u7735\ue011\uaf13\ua722\u16e1\u7af8\ua498\uf1e4\u762e\uefe7\ua010\ua831\u19a2\u753b\uab22\ufedc\u7910\uefb1\ua103\ua94e\u186c\u74ba\uaa68\uff86\u7820\uee12\ua263\uaa5e\u1bfe\u77b4\ua918\ufc44\u7b58\ued87\ua312\uab05\u1a41\u76dd\ua846\ufd38\u7ad6\uecfc\ua42a\uac9e\u1dd3\u7158\uafda\uface\u7d9a\ueb99\ua428\uad6b\u1cfd\u70a0\uaeec\ufbb1\u7c66\uea8a\ua53c\uaea6\u1fed\u739d\uadf6\uf85b\u7ff9\ue972\ua6e3\uafe2\u1efa\u72b1\uacca\uf94e\u7e7c\ue8e6\ua717\ub091\u01e0\u6d21\ub302\ue6fb\u6160\uf751\ub829\ub023g\u6c58\ub2f9\ue7c4\u60c6\uf601\ub916\ub1bd\u031b\u6f7d\ub1bd\ue4b3\u63e6\uf554\ubaaf\ub26e\u02f2\u6e34\ub014\ue51d\u62f8\uf4b4\ubb9e\ub37d\u05fd\u69d1\ub760\ue25c\u65f3\uf360\ubcf8\ub485\u052b\u6803\ub6dc\ue355\u648b\uf278\ubdf7\ub5c9\u04a5\u6b3d\ub54b\ue0e0\u6717\uf1bc\ube3c\ub6f9\u0792\u6a1e\ub427\ue1f7\u666d\uf0dc\ubfd7\ub791\u06d7\u6a36\ubb66\uee31\u6989\uff61\ub0e3\ub8e3\u095c\u65b6\uba85\uef24\u6805\ufee3\ub1e3\ub926\u083d\u645d\ub929\uec2a\u6b14\ufdc4\ub24b\uba3c\u0bc7\u671a\ub8de\ued3e\u6a1d\ufc5c\ub32a\ubbd5"};
        __p__gH4it = new String[]{"\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79", "\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481", "\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6", "\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109", "\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d", "\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790", "\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788", "\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee", "\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f", "\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29", "\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e", "\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd", "\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f", "\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91", "\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f", "\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4", "\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d", "\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5", "\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529\ue54e", "\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525", "\uefa6\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d", "\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217", "\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453", "\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132", "\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c", "\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc", "\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96", "\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d", "\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf", "\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288", "\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e", "\uf12f\uf154\uf179\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310", "\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a", "\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc", "\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e", "\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9", "\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8\ueded\uee12\uee37\uee5c\uee81", "\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2", "\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1\ue206", "\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d", "\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575", "\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024", "\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124\uf149\uf16e", "\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1", "\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb", "\uee75\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7", "\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395", "\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db", "\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f", "\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443", "\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82", "\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed", "\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9", "\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259", "\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c", "\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599", "\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a", "\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543", "\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca", "\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1", "\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", "\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72", "\uf6f8\uf71d\uf742\uf767\uf78c\uf7b1\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4", "\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b", "\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8", "\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366", "\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e\uef83\uefa8\uefcd\ueff2", "\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35", "\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279", "\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4", "\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b", "\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d", "\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f", "\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2", "\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6", "\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51", "\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b", "\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5", "\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da", "\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb", "\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015", "\uf6c9\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e", "\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2", "\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d", "\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891", "\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af", "\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382", "\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861", "\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0", "\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1", "\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f", "\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c\ueec1", "\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f", "\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548", "\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d", "\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a"};
        __c__J7Um6 = new Object[][]{{"\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0\uf3c5\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3", 2029570316870857111L, "\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6", 1839186477, "\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7", false, "\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b", false, "\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087", false, "\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b", false}, {"\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9", 2029570316870922648L, "\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409", 603456650, "\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93", true, "\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c", true, "\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7", true, "\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0", true}, {"\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca", 2029570316870988185L, "\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b", -246395037, "\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f", false, "\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b", false, "\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f", false, "\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d", false}, {"\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed", 2029570316871053722L, "\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577", -2035772968, "\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70", true, "\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db", true, "\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4", true, "\ue8c7\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14", true}, {"\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f", 2029570316871119259L, "\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653", 1409341617, "\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f", false, "\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523", false, "\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441", false, "\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce", false}, {"\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b", 2029570316871184796L, "\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754", -442948754, "\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf", true, "\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8", true, "\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8", true, "\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b", true}, {"\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137", 2029570316871250333L, "\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933", -1141807673, "\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2\uf007", false, "\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725", false, "\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2", false, "\uebca\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f", false}, {"\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238", 2029570316871315870L, "\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3", 1229565116, "\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c", true, "\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc", true, "\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f", true, "\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65", true}, {"\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417", 2029570316871381407L, "\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb", 513931029, "\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209", false, "\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196", false, "\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923", false, "\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066", false}, {"\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587", 2029570316871446944L, "\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80", -1405470222, "\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0", true, "\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203", true, "\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49", true, "\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089", true}, {"\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf", 2029570316871512481L, "\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced", 2106720427, "\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a", false, "\ue192\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407", false, "\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a", false, "\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b", false}, {"\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764", 2029570316871578018L, "\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4", 870992640, "\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7", true, "\ue293\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d", true, "\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d", true, "\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7", true}, {"\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1", 2029570316871643555L, "\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e", -1052602887, "\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb", false, "\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e", false, "\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff", false, "\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3", false}, {"\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888", 2029570316871709092L, "\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb", -1764043690, "\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011", true, "\ue495\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651", true, "\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb", true, "\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4", true}, {"\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42", 2029570316871774629L, "\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc\uf0f1\uf116\uf13b\uf160\uf185\uf1aa\uf1cf", 607330063, "\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112", false, "\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3", false, "\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7", false, "\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3", false}, {"\ue93d\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf", 2029570316871840166L, "\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261\uf286\uf2ab\uf2d0\uf2f5", -175414812, "\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135", true, "\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf", true, "\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8", true, "\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723", true}, {"\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0\uebd5\uebfa\uec1f\uec44\uec69\uec8e\uecb3", 2029570316871905703L, "\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6", -1948014499, "\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7", false, "\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b", false, "\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097", false, "\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b", false}, {"\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45\ued6a\ued8f\uedb4\uedd9", 2029570316871971240L, "\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419", 1501295418, "\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3", true, "\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c", true, "\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207", true, "\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db\ue100", true}, {"\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda", 2029570316872036777L, "\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab", -288082541, "\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f", false, "\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b", false, "\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f", false, "\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d", false}, {"\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd", 2029570316872102314L, "\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587", -1137935288, "\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480", true, "\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb", true, "\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4", true, "\ue0d7\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224", true}, {"\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f", 2029570316872167851L, "\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663", 1300514593, "\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f", false, "\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33", false, "\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451", false, "\ue1d8\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de", false}, {"\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b", 2029570316872233388L, "\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764", 52201886, "\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf", true, "\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3\ueec8", true, "\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508", true, "\ue2d9\ue2fe\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b", true}, {"\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147", 2029570316872298925L, "\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143", -780873609, "\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817", false, "\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35", false, "\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2", false, "\ue3da\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f", false}, {"\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248", 2029570316872364462L, "\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3", 1724717868, "\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987\ue9ac", true, "\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec", true, "\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f", true, "\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775", true}, {"\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393\uf3b8\uf3dd\uf402\uf427", 2029570316872429999L, "\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb", 874864005, "\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19", false, "\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6", false, "\uf6be\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133", false, "\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876", false}, {"\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597", 2029570316872495536L, "\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b\ue490", -977427358, "\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0", true, "\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213", true, "\uf7bf\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259", true, "\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899", true}, {"\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df", 2029570316872561073L, "\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd", -1693061413, "\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a", false, "\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417", false, "\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a", false, "\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b", false}, {"\uf549\uf56e\uf593\uf5b8\uf5dd\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f\uf774", 2029570316872626610L, "\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4", 695087536, "\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7", true, "\uf2a3\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d", true, "\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d", true, "\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07", true}, {"\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1", 2029570316872692147L, "\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e", -20547479, "\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb", false, "\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e", false, "\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f", false, "\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3", false}, {"\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098", 2029570316872757684L, "\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db", -1939979578, "\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021", true, "\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661", true, "\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb", true, "\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4", true}, {"\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252", 2029570316872823221L, "\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df", 1572242879, "\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122", false, "\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3", false, "\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7", false, "\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3", false}, {"\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf", 2029570316872888758L, "\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05", 319736852, "\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145", true, "\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf", true, "\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8", true, "\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33", true}, {"\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a\ue42f\ue454\ue479\ue49e\ue4c3", 2029570316872954295L, "\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06", -1587079475, "\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7", false, "\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab", false, "\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7", false, "\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b", false}, {"\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9", 2029570316873019832L, "\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29", 1996446122, "\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3", true, "\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac", true, "\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17", true, "\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110", true}, {"\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea", 2029570316873085369L, "\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb", 72851459, "\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f", false, "\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b", false, "\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f", false, "\uefe6\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d", false}, {"\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d", 2029570316873150906L, "\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97", -709891336, "\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490", true, "\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb", true, "\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4", true, "\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234", true}, {"\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f", 2029570316873216443L, "\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73", 1795698001, "\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f", false, "\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543", false, "\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61", false, "\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee", false}, {"\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b", 2029570316873281980L, "\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74", 962622478, "\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df", true, "\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8", true, "\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18", true, "\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b", true}, {"\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957", 2029570316873347517L, "\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153", -822559001, "\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027", false, "\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745", false, "\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2", false, "\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f", false}, {"\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58", 2029570316873413054L, "\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3", -1672445604, "\uf791\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc", true, "\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc", true, "\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f", true, "\uf4eb\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785", true}, {"\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37", 2029570316873478591L, "\uf174\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b", 766036021, "\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229", false, "\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6", false, "\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143", false, "\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086", false}, {"\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7", 2029570316873544128L, "\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0", -486468974, "\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0", true, "\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23", true, "\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269", true, "\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9", true}, {"\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca\uedef", 2029570316873609665L, "\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d", -1332128437, "\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a", false, "\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27", false, "\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a", false, "\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b", false}, {"\ued59\ued7e\ueda3\uedc8\ueded\uee12\uee37\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f\uef84", 2029570316873675202L, "\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4", 1190239264, "\ue395\ue3ba\ue3df\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507", true, "\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d", true, "\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d", true, "\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217", true}, {"\uee5a\uee7f\ueea4\ueec9\ueeee\uef13\uef38\uef5d\uef82\uefa7\uefcc\ueff1", 2029570316873740739L, "\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e", 340387481, "\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b", false, "\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e", false, "\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f", false, "\ue1f0\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3", false}, {"\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8", 2029570316873806276L, "\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb", -1516099210, "\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831", true, "\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71", true, "\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb", true, "\ue2f1\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4", true}, {"\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262", 2029570316873871813L, "\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef", 2067427375, "\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932", false, "\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03", false, "\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7", false, "\ue3f2\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3", false}, {"\uf15d\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf", 2029570316873937350L, "\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315", 143833732, "\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955", true, "\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf", true, "\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8", true, "\ue4f3\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743", true}, {"\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3", 2029570316874002887L, "\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416", -555025027, "\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7", false, "\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb", false, "\uf6d6\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7", false, "\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b", false}, {"\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9", 2029570316874068424L, "\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439", 1816315866, "\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3", true, "\uf0b9\uf0de\uf103\uf128\uf14d\uf172\uf197\uf1bc", true, "\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227", true, "\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920", true}, {"\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa", 2029570316874133961L, "\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb", 1037766323, "\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f", false, "\uf1ba\uf1df\uf204\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b", false, "\ue0d8\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a\ue26f", false, "\ue7f6\ue81b\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d", false}, {"\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d", 2029570316874199498L, "\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7", -214740632, "\ueb9d\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0", true, "\uf2bb\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b", true, "\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404", true, "\ue8f7\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44", true}, {"\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af", 2029570316874265035L, "\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683", -2138334271, "\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f", false, "\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553", false, "\ue2da\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427\ue44c\ue471", false, "\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe", false}, {"\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b", 2029570316874330572L, "\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784", 1457775294, "\ued9f\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef", true, "\uf4bd\uf4e2\uf507\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8", true, "\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528", true, "\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b", true}, {"\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167", 2029570316874396109L, "\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963", -461626089, "\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037", false, "\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755", false, "\ue4dc\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2", false, "\uebfa\uec1f\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f", false}, {"\ue165\ue18a\ue1af\ue1d4\ue1f9\ue21e\ue243\ue268", 2029570316874461646L, "\ue883\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3", -1244368948, "\uefa1\uefc6\uefeb\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7\uf1cc", true, "\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c", true, "\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f", true, "\uecfb\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95", true}, {"\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447", 2029570316874527183L, "\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b", 1261221541, "\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239", false, "\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6", false, "\ue6de\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953", false, "\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096", false}, {"\ue367\ue38c\ue3b1\ue3d6\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7", 2029570316874592720L, "\uea85\ueaaa\ueacf\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b\uecb0", 411367682, "\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0", true, "\ue0c1\ue0e6\ue10b\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233", true, "\ue7df\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79", true, "\ueefd\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9", true}, {"\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b\ue590\ue5b5\ue5da\ue5ff", 2029570316874658257L, "\ueb86\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3\uecf8\ued1d", -1373846533, "\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa", false, "\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437", false, "\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a", false, "\ueffe\uf023\uf048\uf06d\uf092\uf0b7\uf0dc\uf101\uf126\uf14b", false}, {"\ue569\ue58e\ue5b3\ue5d8\ue5fd\ue622\ue647\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f\ue794", 2029570316874723794L, "\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4", 2088045136, "\uf3a5\uf3ca\uf3ef\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517", true, "\ue2c3\ue2e8\ue30d\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d", true, "\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d", true, "\uf0ff\uf124\uf149\uf16e\uf193\uf1b8\uf1dd\uf202\uf227", true}, {"\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801", 2029570316874789331L, "\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e", 231558409, "\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b", false, "\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e", false, "\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f", false, "\uf200\uf225\uf24a\uf26f\uf294\uf2b9\uf2de\uf303", false}, {"\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8", 2029570316874854868L, "\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb", -1020946458, "\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041", true, "\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681", true, "\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b", true, "\uf301\uf326\uf34b\uf370\uf395\uf3ba\uf3df\uf404", true}, {"\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72", 2029570316874920405L, "\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff", -1866604961, "\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142", false, "\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713", false, "\uece4\ued09\ued2e\ued53\ued78\ued9d\uedc2\uede7", false, "\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be\uf5e3", false}, {"\ue96d\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf", 2029570316874985942L, "\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325", 638984500, "\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165", true, "\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef", true, "\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8", true, "\uf503\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753", true}, {"\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3", 2029570316875051479L, "\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426", -194090003, "\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7", false, "\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb", false, "\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7", false, "\uf604\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707\uf72c\uf751\uf776\uf79b", false}, {"\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a\uedbf\uede4\uee09", 2029570316875117016L, "\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449", -2050575798, "\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3", true, "\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc", true, "\uefe7\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237", true, "\uf705\uf72a\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077\ue09c\ue0c1\ue0e6\ue10b\ue130", true}, {"\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a", 2029570316875182553L, "\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db", 1532949795, "\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af", false, "\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab", false, "\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f", false, "\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153\ue178\ue19d", false}, {"\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d", 2029570316875248090L, "\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7", -390643816, "\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0", true, "\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b", true, "\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef\uf414", true, "\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f\ue254", true}, {"\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf", 2029570316875313627L, "\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693", -1106311567, "\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f", false, "\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf\uecf4\ued19\ued3e\ued63", false, "\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481", false, "\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e", false}, {"\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b", 2029570316875379164L, "\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794", 1281837358, "\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff", true, "\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8", true, "\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538", true, "\ue309\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b", true}, {"\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177", 2029570316875444701L, "\uf792\uf7b7\uf7dc\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173", 503288711, "\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847", false, "\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65", false, "\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2", false, "\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f", false}, {"\uf175\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253\uf278", 2029570316875510238L, "\ue093\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3", -749217156, "\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc", true, "\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c", true, "\uf5ed\uf612\uf637\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f", true, "\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5", true}, {"\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457", 2029570316875575775L, "\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b", 1622154453, "\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49", false, "\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6", false, "\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163", false, "\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6", false}, {"\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7", 2029570316875641312L, "\ue295\ue2ba\ue2df\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0", 906520498, "\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00", true, "\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243", true, "\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289", true, "\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9", true}, {"\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f", 2029570316875706849L, "\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d", -1000296853, "\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba", false, "\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447", false, "\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a", false, "\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b", false}, {"\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4", 2029570316875772386L, "\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4", -1778847552, "\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27", true, "\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d", true, "\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad", true, "\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37", true}, {"\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011", 2029570316875837923L, "\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e", 726743993, "\uecb6\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b", false, "\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e", false, "\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f", false, "\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13", false}, {"\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8", 2029570316875903460L, "\ue699\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b", -123141610, "\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051", true, "\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691", true, "\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b", true, "\ueb11\ueb36\ueb5b\ueb80\ueba5\uebca\uebef\uec14", true}, {"\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282", 2029570316875968997L, "\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f", -1912519473, "\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152", false, "\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723", false, "\ue4f4\ue519\ue53e\ue563\ue588\ue5ad\ue5d2\ue5f7", false, "\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3", false}, {"\ue17d\ue1a2\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef", 2029570316876034534L, "\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35", 1603899300, "\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175", true, "\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff", true, "\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3\ue6f8", true, "\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63", true}, {"\ue27e\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3", 2029570316876100071L, "\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36", -302918115, "\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207", false, "\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db", false, "\ue6f6\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7", false, "\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab", false}, {"\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619", 2029570316876165608L, "\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59", -1555425030, "\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3", true, "\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc", true, "\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47", true, "\uef15\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140", true}, {"\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a", 2029570316876231145L, "\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb", 1889690451, "\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf", false, "\ue1da\ue1ff\ue224\ue249\ue26e\ue293\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb", false, "\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f", false, "\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad", false}, {"\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d", 2029570316876296682L, "\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7", 104507912, "\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0", true, "\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b", true, "\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24", true, "\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264", true}, {"\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf", 2029570316876362219L, "\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3", -678236959, "\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f", false, "\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529\ue54e\ue573", false, "\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91", false, "\uf218\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e", false}, {"\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab", 2029570316876427756L, "\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4", 1709913950, "\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f", true, "\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708", true, "\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48", true, "\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b", true}, {"\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987", 2029570316876493293L, "\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183", 994278967, "\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057", false, "\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775", false, "\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02", false, "\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f", false}, {"\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88", 2029570316876558830L, "\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3", -925155092, "\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec", true, "\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c", true, "\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00\uef25\uef4a\uef6f", true, "\uf51b\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5", true}, {"\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67", 2029570316876624367L, "\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b", -1640789179, "\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259", false, "\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6", false, "\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173", false, "\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6", false}, {"\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7", 2029570316876689904L, "\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0", 797692450, "\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310", true, "\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53", true, "\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299", true, "\uf71d\uf742\uf767\uf78c\uf7b1\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9", true}, {"\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f", 2029570316876755441L, "\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d", -35384165, "\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca", false, "\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57", false, "\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a", false, "\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7\ue0fc\ue121\ue146\ue16b", false}, {"\ued89\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4", 2029570316876820978L, "\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4", -1283694736, "\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537", true, "\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d", true, "\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd", true, "\ue11f\ue144\ue169\ue18e\ue1b3\ue1d8\ue1fd\ue222\ue247", true}, {"\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021", 2029570316876886515L, "\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae", 1087677993, "\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b", false, "\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e", false, "\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f", false, "\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323", false}, {"\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8", 2029570316876952052L, "\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b", 372041862, "\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861", true, "\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1", true, "\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b", true, "\ue321\ue346\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424", true}, {"\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292", 2029570316877017589L, "\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f", -1484442753, "\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962", false, "\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33", false, "\uf504\uf529\uf54e\uf573\uf598\uf5bd\uf5e2\uf607", false, "\ue422\ue447\ue46c\ue491\ue4b6\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603", false}, {"\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff", 2029570316877083126L, "\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345", 1964864980, "\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985", true, "\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f", true, "\uf605\uf62a\uf64f\uf674\uf699\uf6be\uf6e3\uf708", true, "\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773", true}};
        byte[] v0 = "\u0085\u001e\u008d\u00f0\u00e1d\u0095zw\u0015\u0016`\u00c1\u00e0&ln\u009al\u00c3\u0088A \u008a\u0010mz\u00c3\u00ba\u00f5q\u00b5\u00aa\u000f,\u0080\u00af\r\u00ee\u00ce\u00b6\u0005\u0013i\u0081\u00e8\u000e!\u00d8i\u008bg\u00b4 \u00d8\u0007\u00c6\u00b9\u007f\u00dcZ\u00e2\u00ce\u008b)#9'\u00d5:|\u009br\u000e\u00a3\u00ab7\u00aa\u0094\u008c\u0082\u009e\u00b4\u00d2\r\u00b6i\u0002\u00cd\u00a1^\u00b9\u001a\u00e1\u0091&\u0019\u0086B[S\u0016@<\u000b%\u00ecE\u0089\u00f4R\u00ceI\u00bc\u00c1\u00bc\u008b\u00d7F\u00fa\u00dc\u00f0\u0081\u0007\u009f(\u00canO#b\u00f9\u00d1\u0012b\u00c2-?u\u009a\u00d8!\u00a1(\f\u00a52\u0004\u0092\u00e4\u00a8\u00b0eO\bv\u00b6\u000fX\u000f)\u00fc\u00a96\u0080\u0019\u0018\u0003(M=\u0095\u008c\u00e18\u001dgS\u00fb\u0099\u00ac\u0016e\u00e4\u00b6\u00a49<\u00bd\u00aduk\f\u00a8\u00c7\u00ab{vg\u00e3\u0093\u00fd\u00a0\u00e3\u00e5\u0099t\u00cd\u00a8j\u00ddj^\u00a1,\u0014\b\u0005\u00c1h\u008e\u00e4US\u0007\u00be\u00dbg&\u0016\u00d7\u00dd\u00fd\u00fe\u00e0\u0092?kLWW\u0011\u00ea\u00b2\b\u008b3\u0091\u00e5\u000b\u00a9H\u009a\u00f4M&.\u00bf\u00bcZ\u008f\u00cb~cM\u00ce\u00e3\"\u009c5ux\u0006\u00f5ab\u009a\u009b^\u007f\u00f0|#0\u00a206gjjK\u00ea\u00c2\u00bd_$\u00cd\u000b\u001d\u009eD\u00ceo\u00b7W\u00b6yPp\u0093\u0095z\u0001FG'\u0084\u0088\u0089\u00bf\u0019cE\u00d5\u0003hN\u00e3\u0016Gq\u00c8\u008e\u00f4\u00b2\u0098\u0004\u00af\u0081\u0085\u00aa;\u00b4\u00d2\u00bb\u00der\u00b2\u0004c\u0083D\u00cf\u00e3.\u00dd<.\"\u008f>\u00a2\u008f{*\u00c6\u001b\u00949\u007f\u0083\u0002\u00d9*\u0005T\u0017\u00a57\u0003\u00a9:\u0002\u0010\u0091\u0083\u00b8\u00ae-\u00e6\u00d18\u00be\u00a8\u00dc\u00b1_\u008e2X\u00f3x\u00a5\u000f\u0083\u00cb>R@\u00f0N\u0012\u0007A6\u009f)\u0003\u00fa\u0004\u000e~\u0086\u009d\u00cbL\u0005\u0018\u000f\u00ee\u00ef|".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c4\u00b7\u00ef\u009d7r\u00c4\u00e5".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -676726026;
                case 1 -> -413589131;
                case 2 -> -1325281477;
                case 3 -> 1094704435;
                case 4 -> 667441719;
                case 5 -> -469367791;
                case 6 -> -765740490;
                case 7 -> 1199537415;
                case 8 -> -462875578;
                case 9 -> -1148043652;
                case 10 -> -542603166;
                case 11 -> -1561107740;
                case 12 -> -106754518;
                case 13 -> -1378598796;
                case 14 -> -1084010075;
                case 15 -> -972654022;
                case 16 -> -1081951947;
                case 17 -> 9465803;
                case 18 -> -1322120294;
                case 19 -> -1681382526;
                case 20 -> -2079954718;
                case 21 -> -39660498;
                case 22 -> 1762837936;
                case 23 -> -1181801856;
                case 24 -> 680894210;
                case 25 -> 440504595;
                case 26 -> -298676728;
                case 27 -> -82026177;
                case 28 -> 1486260665;
                case 29 -> 566201406;
                case 30 -> -333891548;
                case 31 -> -1462078118;
                case 32 -> 761385946;
                case 33 -> -22337422;
                case 34 -> -2016124285;
                case 35 -> -1039831293;
                case 36 -> -1492743631;
                case 37 -> -1466105846;
                case 38 -> 377458260;
                case 39 -> 1264092899;
                case 40 -> 1851052417;
                case 41 -> -3739017;
                case 42 -> -1641141852;
                case 43 -> 1016435651;
                case 44 -> 616528797;
                case 45 -> -1449920563;
                case 46 -> 1628947776;
                case 47 -> -1642829574;
                case 48 -> -1223563154;
                case 49 -> -944926679;
                case 50 -> -734664789;
                case 51 -> -909736693;
                case 52 -> -369577742;
                case 53 -> 482594548;
                case 54 -> 25571609;
                case 55 -> 1660793208;
                case 56 -> -1338969257;
                case 57 -> -1665060018;
                case 58 -> 437965836;
                case 59 -> 738882413;
                case 60 -> -484744186;
                case 61 -> -1058801824;
                case 62 -> -1068599230;
                case 63 -> 1118930655;
                case 64 -> 481124129;
                case 65 -> 1204447697;
                case 66 -> -1508896031;
                case 67 -> -1161454057;
                case 68 -> -1232362679;
                case 69 -> 1444447323;
                case 70 -> -2121373984;
                case 71 -> -349879741;
                case 72 -> 717192873;
                case 73 -> -2110199305;
                case 74 -> 181541564;
                case 75 -> -751665679;
                case 76 -> 674269508;
                case 77 -> 85706702;
                case 78 -> -632253661;
                case 79 -> -1345019033;
                case 80 -> -585485206;
                case 81 -> -1493532708;
                case 82 -> 980489452;
                case 83 -> 1970436911;
                case 84 -> 357946440;
                case 85 -> -1571882350;
                case 86 -> -1616850930;
                case 87 -> 1649772449;
                case 88 -> 1992746800;
                case 89 -> 2090466490;
                case 90 -> -886446614;
                case 91 -> 281885373;
                case 92 -> 482393815;
                case 93 -> 478412222;
                case 94 -> 399273423;
                case 95 -> 1416840524;
                case 96 -> 555338078;
                case 97 -> 1402485778;
                case 98 -> 56108242;
                case 99 -> 543191066;
                case 100 -> -401461269;
                case 101 -> -812505834;
                case 102 -> 1501056201;
                case 103 -> -1221360085;
                case 104 -> -1200066658;
                case 105 -> 1613839183;
                case 106 -> 147508781;
                case 107 -> 1606570216;
                case 108 -> -724551424;
                case 109 -> -1559750913;
                case 110 -> 1870053805;
                case 111 -> -731465698;
                case 112 -> -907234033;
                case 113 -> 721368790;
                case 114 -> 252039740;
                case 115 -> 223902800;
                case 116 -> 1823533130;
                case 117 -> -712200566;
                case 118 -> 193414427;
                case 119 -> -223997959;
                case 120 -> 1354626675;
                case 121 -> 808314542;
                case 122 -> -2026213666;
                case 123 -> -429550415;
                case 124 -> -1241489048;
                case 125 -> 364971888;
                case 126 -> -311821724;
                case 127 -> 232855024;
                case 128 -> -1333095533;
                case 129 -> 1227866087;
                case 130 -> 604001629;
                case 131 -> 1192185763;
                case 132 -> -432255557;
                case 133 -> 297106671;
                case 134 -> -1494156011;
                case 135 -> -253965311;
                case 136 -> -1113863939;
                case 137 -> 1227310535;
                case 138 -> -98980727;
                case 139 -> 517938258;
                case 140 -> 1782488797;
                case 141 -> -163328682;
                case 142 -> 284789173;
                case 143 -> -1505338372;
                case 144 -> 1651365242;
                case 145 -> 1215722700;
                case 146 -> 650893504;
                case 147 -> 947872516;
                case 148 -> -2003724771;
                case 149 -> 1876969012;
                case 150 -> -1737038139;
                case 151 -> -1438952810;
                case 152 -> -1767477412;
                case 153 -> 2015769002;
                case 154 -> 731320585;
                case 155 -> -1447606056;
                case 156 -> 466037361;
                case 157 -> -1632370856;
                case 158 -> -2047266317;
                case 159 -> -1083606388;
                case 160 -> -386691016;
                case 161 -> -99102264;
                case 162 -> -1638477442;
                case 163 -> 518457195;
                case 164 -> 65909423;
                case 165 -> 403842506;
                case 166 -> -2057704920;
                case 167 -> -853003531;
                case 168 -> -762543127;
                case 169 -> 657631781;
                case 170 -> -468381268;
                case 171 -> 461822258;
                case 172 -> -142876319;
                case 173 -> 2140822414;
                case 174 -> -25667166;
                case 175 -> -1238539368;
                case 176 -> 1750028692;
                case 177 -> -520111122;
                case 178 -> 1813663129;
                case 179 -> 929722547;
                case 180 -> 1296964232;
                case 181 -> 2056921483;
                case 182 -> 1127202681;
                case 183 -> -1447033921;
                case 184 -> -1028360252;
                case 185 -> 140861720;
                case 186 -> 1208247101;
                case 187 -> -691339609;
                case 188 -> 848235910;
                case 189 -> -1065396708;
                case 190 -> 837901141;
                case 191 -> 193600870;
                case 192 -> -1559041562;
                case 193 -> -143321465;
                case 194 -> 216939920;
                case 195 -> -648426539;
                case 196 -> -2136628570;
                case 197 -> -747781600;
                case 198 -> -1347667774;
                case 199 -> -1335068162;
                case 200 -> 1911451058;
                case 201 -> -394441401;
                case 202 -> -1594733576;
                case 203 -> 1121804883;
                case 204 -> 276970530;
                case 205 -> 2085204128;
                case 206 -> 1189926021;
                case 207 -> -654979945;
                case 208 -> -1354088805;
                case 209 -> -1999547962;
                case 210 -> -141439731;
                case 211 -> -300202084;
                case 212 -> -102414721;
                case 213 -> 2110365972;
                case 214 -> 1298043003;
                case 215 -> 73364664;
                case 216 -> 1396311115;
                case 217 -> -1845937267;
                case 218 -> -959779251;
                case 219 -> -250592879;
                case 220 -> -1502015995;
                case 221 -> 308347099;
                case 222 -> 739832981;
                case 223 -> 1899088852;
                case 224 -> 1781209921;
                case 225 -> 675018713;
                case 226 -> -303583377;
                case 227 -> 2008625104;
                case 228 -> 30997093;
                case 229 -> -1323960365;
                case 230 -> -899497825;
                case 231 -> -487454365;
                case 232 -> 1839212431;
                case 233 -> -373991111;
                case 234 -> -1638948891;
                case 235 -> -2131856204;
                case 236 -> 1491075397;
                case 237 -> 1167344721;
                case 238 -> -1512779864;
                case 239 -> 242988164;
                case 240 -> 2002321526;
                case 241 -> 225067113;
                case 242 -> 1441164013;
                case 243 -> 387182717;
                case 244 -> -1411875546;
                case 245 -> -2146488993;
                case 246 -> -704198100;
                case 247 -> -521691888;
                case 248 -> 1914757559;
                case 249 -> -1374892863;
                case 250 -> 1640050939;
                case 251 -> 1419740012;
                case 252 -> 1348945959;
                case 253 -> 566522969;
                case 254 -> 355445942;
                case 255 -> -1356696289;
                default -> -658705121;
            });
        } while (v2 != 432);
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
            Object[] objectArray = new Object[23];
            v1 = objectArray;
            0i0o = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0Ioi = "quickcraft ";
        0IoI = 4.0f;
        0Ioo = 8.0f;
        0Io0 = 7;
        0IoO = 17;
        0I0i = 19;
        0I0I = 4;
        0I0o = 18;
        0oi0 = 16;
        0I00 = 6;
        0IIO = Pattern.compile("you have all the items to craft (?:a |an |the )?(.+?)(?= click here| to craft it!?|!|$)", 2);
        0II0 = Pattern.compile("(?:! )?you crafted (.+?) \\((\\d+)/(\\d+)\\)", 2);
        0IIo = Pattern.compile("welcome to hoplite!|you have joined a server", 2);
    }

    private String I000(String param1) {
        int v4;
        if (param1 == null || param1.isEmpty()) {
            return "";
        }
        StringBuilder v2 = new StringBuilder(param1.length());
        boolean v3 = true;
        for (v4 = 0; v4 < param1.length(); ++v4) {
            char v5 = param1.charAt(v4);
            if (v5 == '\u00a7') {
                if (v4 + 1 >= param1.length()) continue;
                ++v4;
                continue;
            }
            if (Character.isWhitespace(v5)) {
                if (v3) continue;
                v2.append(' ');
                v3 = true;
                continue;
            }
            if (v5 == '\u2019' || v5 == '\u2018' || v5 == '`') {
                v5 = '\'';
            }
            v2.append(Character.toLowerCase(v5));
            v3 = false;
        }
        v4 = v2.length();
        if (v4 > 0 && v2.charAt(v4 - 1) == ' ') {
            v2.setLength(v4 - 1);
        }
        return v2.toString();
    }

    private void I00i(DrawContext param1, int param2, int param3, int param4, int param5) {
        int v6 = ((Color)this.0oi.HelpCommand()).getRGB();
        int v7 = this.0IOO(this.I0IO(255), 72);
        int v8 = this.0IOO(-1, 24);
        int v9 = this.0IOO(this.I0IO(255), 84);
        GuiSupport_oi0o_0.OOoiI(param1, param2, param3, param4, param5, 8.0f, v6);
        GuiSupport_oi0o_0.OOoii(param1, param2, param3, param4, param5, 8.0f, 1.0f, v9);
        float v10 = param3 + 19;
        float v11 = param3 + param5 - 17;
        GuiSupport_oi0o_0.OOoiO(param1, param2 + 1, v10, param2 + param4 - 1, v10 + 1.0f, v7);
        GuiSupport_oi0o_0.OOoiO(param1, param2 + 1, v11, param2 + param4 - 1, v11 + 1.0f, v8);
    }

    private int 0IOO(int param1, int param2) {
        return (Math.max(0, Math.min(255, param2)) & 0xFF) << 24 | param1 & 0xFFFFFF;
    }

    private List IOiI() {
        List v1 = NetworkSupport_o0o_0.HelpCommand();
        if (!((Boolean)this.0IiO.HelpCommand()).booleanValue()) {
            return v1;
        }
        ArrayList<DataRecord_o0io_2> v2 = new ArrayList<DataRecord_o0io_2>();
        for (DataRecord_o0io_2 v4 : v1) {
            if (this.0iOO.contains(v4.OOoi()) || !this.0Iii.contains(v4.OOoi())) continue;
            v2.add(v4);
        }
        return v2;
    }

    private void I0oo(DrawContext param1, FontRenderer param2, String param3, int param4, int param5, int param6, int param7, int param8) {
        int v9 = param2.GuiSupport_OOI(param3);
        int v10 = param2.OOi();
        float v11 = (float)param4 + (float)(param6 - v9) / 2.0f;
        float v12 = (float)param5 + (float)(param7 - v10) / 2.0f;
        param2.PacketEvent(param1, param3, v11, v12, param8);
    }

    private int I0OO() {
        int v1 = this.IOii();
        List v2 = this.IOiI();
        if (v1 <= 0 || v2.isEmpty()) {
            return 0;
        }
        return (v2.size() - 1) / v1;
    }

    private int IOii() {
        return (Integer)this.0III.HelpCommand() * (Integer)this.0IIi.HelpCommand();
    }

    private void I0oO(int param1, int param2, int param3, int param4, int param5, boolean param6) {
        int v7 = param6 ? this.0IOO(this.I0IO(255), 124) : 0x26FFFFFF;
        RenderSupport_00oi_0.O0o(param1, param2, param3, param4, 4.0f, param5);
        RenderSupport_00oi_0.ConfigSupport_O0I(param1, param2, param3, param4, 4.0f, 1.0f, v7);
    }

    private void IOio() {
        this.0iOo.clear();
        this.0iOI.clear();
        for (DataRecord_o0io_2 v2 : NetworkSupport_o0o_0.HelpCommand()) {
            String v3 = this.I00O(v2.SprintResetModule());
            this.0iOo.put(v3, v2.OOoi());
            this.0iOI.add(new DataRecord_ooii_0(v3, v2.OOoi()));
        }
    }

    private void I0O0() {
        this.0i00 = Math.min(this.0i00 + 1, this.I0OO());
    }

    private boolean IOIi(String param1) {
        Matcher v2 = 0II0.matcher(param1);
        if (!v2.find()) {
            return false;
        }
        String v3 = this.IOi0(v2.group(1).trim());
        int v4 = Integer.parseInt(v2.group(2));
        int v5 = Integer.parseInt(v2.group(3));
        if (v3 != null && v4 >= v5) {
            this.0iOO.add(v3);
            this.0Iii.remove(v3);
        }
        return true;
    }

    private int I0oI(int param1, int param2) {
        int v3 = param1 - param2 - 7;
        if (v3 >= 4) {
            return v3;
        }
        return param1 + 176 + 7;
    }

    private void I0o0(DrawContext param1, int param2, int param3, int param4, int param5, int param6, boolean param7) {
        int v8 = param7 ? this.0IOO(this.I0IO(255), 124) : 0x26FFFFFF;
        GuiSupport_oi0o_0.OOoiI(param1, param2, param3, param4, param5, 4.0f, param6);
        GuiSupport_oi0o_0.OOoii(param1, param2, param3, param4, param5, 4.0f, 1.0f, v8);
    }

    private boolean I0oi(double param1, double param3, int param5, int param6, int param7, int param8) {
        return param1 >= (double)param5 && param1 < (double)(param5 + param7) && param3 >= (double)param6 && param3 < (double)(param6 + param8);
    }

    private void I0OI() {
        this.0Iii.clear();
        this.0iOO.clear();
        this.0iO0.clear();
        this.0i00 = 0;
    }

    private void I00I(int param1, int param2, int param3, int param4) {
        int v5 = ((Color)this.0oi.HelpCommand()).getRGB();
        int v6 = this.0IOO(this.I0IO(255), 104);
        int v7 = this.0IOO(-1, 36);
        int v8 = this.0IOO(this.I0IO(255), 132);
        RenderSupport_00oi_0.O0o(param1, param2, param3, param4, 8.0f, v5);
        RenderSupport_00oi_0.ConfigSupport_O0I(param1, param2, param3, param4, 8.0f, 1.0f, v8);
        float v9 = param2 + 19;
        float v10 = param2 + param4 - 17;
        RenderSupport_00oi_0.Ooi(param1 + 1, v9, param3 - 2, 1.0f, v6);
        RenderSupport_00oi_0.Ooi(param1 + 1, v10, param3 - 2, 1.0f, v7);
    }

    private String IOi0(String param1) {
        String v2 = this.I00O(param1);
        if (v2.isEmpty()) {
            return null;
        }
        String v3 = (String)this.0iOo.get(v2);
        if (v3 != null) {
            return v3;
        }
        for (DataRecord_ooii_0 v5 : this.0iOI) {
            if (!v2.contains(v5.i0o) && !v5.i0o.contains(v2)) continue;
            return v5.i0I;
        }
        return null;
    }

    public boolean IOoi(Click param1, int param2, int param3) {
        int v10;
        if (FastCraftModule.ConfigSupport_OI0.player == null || param1.button() != 0) {
            return false;
        }
        int v4 = (int)param1.x();
        int v5 = (int)param1.y();
        int v6 = (Integer)this.0III.HelpCommand();
        int v7 = (Integer)this.0IIi.HelpCommand();
        int v8 = v6 * 18 + Math.max(0, v6 - 1) * 4 + (Integer)this.SpawnerFinderModule.HelpCommand() * 2;
        int v9 = this.I0oI(param2, v8);
        if (!this.I0oi(v4, v5, v9, param3, v8, v10 = 19 + v7 * 18 + Math.max(0, v7 - 1) * 4 + (Integer)this.SpawnerFinderModule.HelpCommand() * 2 + 17)) {
            return false;
        }
        for (Record v12 : this.0i0O) {
            if (!this.I0oi(v4, v5, v12.RenderSupport_ooo_0, v12.oo0, v12.ooo, v12.ooI)) continue;
            if (v12.OOoo) {
                this.I0O0();
            } else {
                this.I0Oo();
            }
            return true;
        }
        for (Record v12 : this.0iOi) {
            if (!this.I0oi(v4, v5, ((DataRecord_oio_4)v12).RenderSupport_ooo_0, ((DataRecord_oio_4)v12).oo0, ((DataRecord_oio_4)v12).ooo, ((DataRecord_oio_4)v12).ooI)) continue;
            this.IOIO(((DataRecord_oio_4)v12).ooi);
            return true;
        }
        return false;
    }

    private String I00O(String param1) {
        return this.I000(param1.replace("@", ""));
    }

    private void IOIo(Text param1, Set param2) {
        if (param1 == null) {
            return;
        }
        ArrayDeque<Text> v3 = new ArrayDeque<Text>();
        v3.push(param1);
        while (!v3.isEmpty()) {
            Object v6;
            String v72;
            ClickEvent v5;
            Text v4 = (Text)v3.pop();
            ClickEvent clickEvent = v5 = v4.getStyle() != null ? v4.getStyle().getClickEvent() : null;
            if (v5 instanceof ClickEvent.RunCommand && (v72 = this.IOII((v6 = (ClickEvent.RunCommand)v5).command())) != null) {
                param2.add(v72);
            }
            v6 = v4.getSiblings();
            for (int v72 = v6.size() - 1; v72 >= 0; --v72) {
                v3.push((Text)v6.get(v72));
            }
        }
    }
}

