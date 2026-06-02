/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.text.MutableText
 *  net.minecraft.text.StringVisitable
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 *  net.minecraft.util.math.Vec3d
 *  org.joml.Vector3f
 */
package clap.module.render;

import java.awt.Color;
import java.lang.invoke.CallSite;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;
import clap.network.NetworkSupport_00OI;
import clap.module.combat.AntiBotModule;
import clap.render.FontRenderer;
import clap.core.module.Module;
import clap.model.DataRecord_00ii_2;
import clap.render.RenderSupport_00oi_0;
import clap.config.ConfigSupport_0oii_0;
import clap.model.EnumType_0ooi_3;
import clap.setting.Setting;
import clap.model.DataRecord_o0oo_2;
import clap.gui.GuiSupport_oi0o_0;
import clap.gui.screen.ClickGuiScreen;
import clap.render.RenderSupport_oiio_4;
import clap.model.DataRecord_oioi_1;
import clap.core.module.ModuleCategory;
import clap.config.ConfigSupport_oioo_0;
import clap.render.ScaledDrawContext;
import clap.config.ConfigSupport_ooii_2;
import clap.model.DataRecord_ooio_1;
import clap.event.EventHandler;
import clap.model.EnumType_oooi_6;
import clap.render.RenderSupport_oooo_2;
import skidonion.loader.0ooo;

/*
 * Renamed from clap.module.render.NameTagsModule
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class NameTagsModule
extends Module {
    private static final float 00i;
    private static final int CoordinatesHudElement;
    private static final int iOiO;
    public Setting GuiSupport_OOI;
    public Setting oOio = this.OOi00("Players", true);
    private static final int i0Oo;
    private static final int i0O0;
    private final List i00i;
    private static final float iOiI;
    private static final float iOio;
    private final Map i0oO;
    private static final float i0OO;
    public Setting i00I;
    private static final float iOi0;
    public Setting 0Io;
    public Setting 0oi;
    public Setting I0II;
    private int i0oo;
    public Setting i00O;
    private static final EquipmentSlot[] iOIi;
    private final Map i0o0;
    public Setting BindCommand;
    private static final int iOii;
    public Setting i0OI = this.OOi00("Monsters", true);
    public Setting oOii = this.OOi00("Animals", false);
    public Setting i0Oi;
    public Setting i000;
    public Setting i00o;
    static Object i0oI;

    private boolean Ooooo(float param1, float param2, float param3, float param4) {
        return ClickGuiScreen.EventBusApi(param1, param2, param3, param4);
    }

    private void Oo0IO(ConfigSupport_0oii_0 param1) {
        param1.Ooo.clear();
        if (param1.OOo != null && !param1.OOo.getString().isEmpty()) {
            param1.Ooo.add(new DataRecord_o0oo_2(param1.OOo, param1.EventBusApi, -2628880));
        }
        if (param1.HelpCommand != null && !param1.HelpCommand.getString().isEmpty()) {
            param1.Ooo.add(new DataRecord_o0oo_2(param1.HelpCommand, param1.HudElement, ((Color)this.0Io.HelpCommand()).getRGB(), true));
        }
        if (param1.GuiSupport_OOI != null && !param1.GuiSupport_OOI.getString().isEmpty()) {
            param1.Ooo.add(new DataRecord_o0oo_2((Text)Text.literal((String)"\u2764 "), param1.O0o, -42149, param1.GuiSupport_OOI, param1.O0i, false, true));
        }
        if (param1.OOi != null && !param1.OOi.getString().isEmpty()) {
            param1.Ooo.add(new DataRecord_o0oo_2(param1.OOi, param1.ConfigSupport_O0I, param1.OoO));
        }
        param1.Oo0 = this.Oo0oi(param1.Ooo);
    }

    private void Oo0oI(float param1, float param2, float param3, List param4, float param5) {
        float v6 = Math.min(3.5f, param3 / 2.0f);
        float v7 = param1;
        for (DataRecord_o0oo_2 v9 : param4) {
            float v10 = ((float)v9.DataRecord_I0O() + 8.0f) * param5;
            RenderSupport_00oi_0.O0o(v7, param2, v10, param3, v6, ((Color)this.0oi.HelpCommand()).getRGB());
            v7 += v10 + 2.0f * param5;
        }
    }

    private int o0iO(FontRenderer param1, FontRenderer param2, String param3) {
        if (param3 == null || param3.isEmpty()) {
            return 0;
        }
        int v4 = 0;
        StringBuilder v5 = new StringBuilder();
        boolean v6 = this.o0Io(param1, param3.charAt(0));
        for (int v7 = 0; v7 < param3.length(); ++v7) {
            char v8 = param3.charAt(v7);
            boolean v9 = this.o0Io(param1, v8);
            if (v9 != v6 && !v5.isEmpty()) {
                v4 += this.o0Ii(param1, param2, v6, v5.toString());
                v5.setLength(0);
                v6 = v9;
            }
            v5.append(v8);
        }
        if (!v5.isEmpty()) {
            v4 += this.o0Ii(param1, param2, v6, v5.toString());
        }
        return v4;
    }

    private void Ooo0O(DrawContext param1, FontRenderer param2, FontRenderer param3, Text param4, float param5, float param6) {
        float v7 = param5;
        for (DataRecord_00ii_2 v9 : this.Ooo00(param4)) {
            this.o0I0(param1, param2, param3, v9.ConfigSupport_O0I(), v7, param6, v9.GuiSupport_OOI());
            v7 += (float)this.o0iO(param2, param3, v9.ConfigSupport_O0I());
        }
    }

    private ConfigSupport_0oii_0 Oo0I0(Entity param1) {
        int v2 = param1.method_5628();
        long v3 = NameTagsModule.ConfigSupport_OI0.world.method_75260();
        ConfigSupport_0oii_0 v5 = (ConfigSupport_0oii_0)this.i0oO.get(v2);
        if (v5 != null && v5.PacketEvent == v3) {
            return v5;
        }
        if (v5 == null) {
            v5 = new ConfigSupport_0oii_0();
        }
        v5.PacketEvent = v3;
        v5.HelpCommand = this.Oo0io(param1);
        v5.OOo = this.Oo0Io(param1);
        v5.GuiSupport_OOI = this.Oo0II(param1);
        v5.OOi = this.Oo0iO(param1);
        FontRenderer v6 = NetworkSupport_00OI.HudElement(18);
        FontRenderer v7 = NetworkSupport_00OI.EventBusApi(18);
        v5.HudElement = this.OooOi(v6, v7, v5.HelpCommand);
        v5.EventBusApi = this.OooOo(v5.OOo);
        v5.O0o = v5.GuiSupport_OOI.getString().isEmpty() ? 0 : this.OooOI(v6, v7, (Text)Text.literal((String)("\u2764 " + v5.GuiSupport_OOI.getString())));
        v5.ConfigSupport_O0I = this.OooOI(v6, v7, v5.OOi);
        v5.O0i = this.OooOO(param1);
        v5.OoO = this.OooO0(param1);
        this.Oo0IO(v5);
        this.i0oO.put(v2, v5);
        return v5;
    }

    private Formatting Ooooi(int param1) {
        if (param1 <= 50) {
            return Formatting.GREEN;
        }
        if (param1 <= 100) {
            return Formatting.YELLOW;
        }
        if (param1 <= 200) {
            return Formatting.GOLD;
        }
        if (param1 <= 300) {
            return Formatting.RED;
        }
        return Formatting.DARK_RED;
    }

    private void OoooO(List param1, ItemStack param2, EnumType_oooi_6 param3) {
        if (!param2.isEmpty()) {
            DataRecord_oioi_1 v4 = new DataRecord_oioi_1(param2.copy(), param3, List.of());
            param1.add(new DataRecord_oioi_1(v4.oII(), param3, this.Ooo0i(v4)));
        }
    }

    private Text Oo0ii(Entity param1) {
        MutableText v2 = Text.empty();
        if (param1 instanceof PlayerEntity) {
            PlayerEntity v3 = (PlayerEntity)param1;
            if (((Boolean)this.i000.HelpCommand()).booleanValue()) {
                int v4 = this.Ooo0o(v3);
                v2 = v2.copy().append((Text)Text.literal((String)(" [" + v4 + "ms]")).formatted(this.Ooooi(v4)));
            }
        }
        if (((Boolean)this.I0II.HelpCommand()).booleanValue()) {
            int v3 = (int)NameTagsModule.ConfigSupport_OI0.player.method_5739(param1);
            v2 = v2.copy().append((Text)Text.literal((String)(" " + v3 + "m")).formatted(Formatting.GRAY));
        }
        return v2;
    }

    private int o0Ii(FontRenderer param1, FontRenderer param2, boolean param3, String param4) {
        if (param3) {
            return param1.GuiSupport_OOI(param4);
        }
        return Math.round((float)NameTagsModule.ConfigSupport_OI0.textRenderer.getWidth(param4) * this.OooI0(param1));
    }

    private int OooOi(FontRenderer param1, FontRenderer param2, Text param3) {
        if (param3 == null || param3.getString().isEmpty()) {
            return 0;
        }
        int v4 = 0;
        for (DataRecord_00ii_2 v6 : this.Ooo00(param3)) {
            v4 += this.o0iO(param1, param2, v6.ConfigSupport_O0I());
        }
        return Math.round((float)v4 * 0.5f);
    }

    private void o0II(DrawContext param1, FontRenderer param2, FontRenderer param3, boolean param4, String param5, float param6, float param7, int param8) {
        if (param4) {
            param2.PacketEvent(param1, param5, param6, param7, param8);
            return;
        }
        float v9 = this.OooI0(param2);
        param1.getMatrices().pushMatrix();
        param1.getMatrices().scale(v9, v9);
        param1.drawText(NameTagsModule.ConfigSupport_OI0.textRenderer, param5, Math.round(param6 / v9), Math.round(param7 / v9), param8, true);
        param1.getMatrices().popMatrix();
    }

    private Text Oo0Io(Entity param1) {
        if (!((Boolean)this.I0II.HelpCommand()).booleanValue()) {
            return Text.empty();
        }
        int v2 = (int)NameTagsModule.ConfigSupport_OI0.player.method_5739(param1);
        return Text.literal((String)(v2 + "m"));
    }

    private Text Oo0io(Entity param1) {
        Text v2 = param1.method_5476();
        String v3 = this.Oo0iI(param1);
        if (v3.isBlank()) {
            return v2;
        }
        return Text.empty().append(v2).append((Text)Text.literal((String)" (").formatted(Formatting.GRAY)).append((Text)Text.literal((String)v3).formatted(Formatting.AQUA)).append((Text)Text.literal((String)")").formatted(Formatting.GRAY));
    }

    private void Oo0o0(ScaledDrawContext param1, Entity param2) {
        if (this.BindCommand.HelpCommand() == EnumType_0ooi_3.XrayModule) {
            this.Oo0oo(param1, param2);
            return;
        }
        double v3 = (double)param2.getHeight() + ((Boolean)this.i00I.HelpCommand() != false ? 0.6 : 0.4);
        Vec3d v5 = param2.getLerpedPos(param1.O0i()).add(0.0, v3, 0.0);
        Vector3f v6 = RenderSupport_oiio_4.O0OII(v5);
        if (v6 == null) {
            return;
        }
        ConfigSupport_0oii_0 v7 = this.Oo0I0(param2);
        if (v7.Ooo.isEmpty()) {
            return;
        }
        float v8 = ((Double)this.GuiSupport_OOI.HelpCommand()).floatValue();
        FontRenderer v9 = NetworkSupport_00OI.HudElement(18);
        FontRenderer v10 = NetworkSupport_00OI.EventBusApi(18);
        float v13 = v7.Oo0;
        float v15 = v6.x - v13 * v8 / 2.0f;
        int v12 = Math.round((float)v9.OOi() * 0.5f);
        float v14 = (float)v12 + 4.0f;
        float v16 = v6.y - v14 * v8 / 2.0f;
        if (this.Ooooo(v15, v16, v13 * v8, v14 * v8)) {
            return;
        }
        this.Oo0oI(v15, v16, v14 * v8, v7.Ooo, v8);
        DrawContext v17 = param1.ConfigSupport_O0I();
        v17.getMatrices().pushMatrix();
        v17.getMatrices().translate(v15, v16);
        v17.getMatrices().scale(v8, v8);
        float v18 = 0.0f;
        for (DataRecord_o0oo_2 v21 : v7.Ooo) {
            float v22 = v18 + 4.0f;
            if (v21.OOiO()) {
                v17.getMatrices().pushMatrix();
                v17.getMatrices().scale(0.5f, 0.5f);
                v23 = v22 / 0.5f;
                this.Ooo0O(v17, v9, v10, v21.OOIo(), v23, 4.0f);
                v17.getMatrices().popMatrix();
            } else {
                v17.getMatrices().pushMatrix();
                v17.getMatrices().scale(0.5f, 0.5f);
                v23 = v22 / 0.5f;
                if (v21.OOi0()) {
                    v10.PacketEvent(v17, v21.OOIo().getString(), v23, 4.0f, v21.GuiSupport_OOI());
                } else {
                    this.o0I0(v17, v9, v10, v21.OOIo().getString(), v23, 4.0f, v21.GuiSupport_OOI());
                }
                if (v21.GuiSupport_OOII() != null && !v21.GuiSupport_OOII().getString().isEmpty()) {
                    this.o0I0(v17, v9, v10, v21.GuiSupport_OOII().getString(), v23 += v21.OOi0() ? (float)v10.GuiSupport_OOI(v21.OOIo().getString()) : (float)this.o0iO(v9, v10, v21.OOIo().getString()), 4.0f, v21.OOIi());
                }
                v17.getMatrices().popMatrix();
            }
            v18 += (float)v21.DataRecord_I0O() + 8.0f + 2.0f;
        }
        if (((Boolean)this.i00I.HelpCommand()).booleanValue() && param2 instanceof PlayerEntity) {
            PlayerEntity v20 = (PlayerEntity)param2;
            this.Ooo0I(v17, v20, v13, false);
        }
        v17.getMatrices().popMatrix();
    }

    static {
        byte[] v0 = "\u00ce\u0005\u00b4\u0088\u00e0\u00c2\u009a3\u0017\u00c6\u0091}\u00c8\u00f7g\u008c\u009d<iiC\u00c1\u0096\u0094}5\u00be\u0006W;\u00b1\u00de\u0081\u00a9<\u00ac'\u00965\u00cfl\u009e*\u007fqka1\u00c4g#J\u0013\u0089\u00b7\u008bX\u008f\u0092\u00a4 \u00bb\u00f5\u00e3\u0098\u00f3\u0096\u00c7\u00c6:rA\u00be\n\u00b9W\u00be'\u0088\u00df\u00b9\u001b\u00a6\u00fd\u00ae\u00d0\u0004qlv`\u0012tZ\u00f0\u00bcO\u00021q[H\u00e0\u00c5IHBS\u009f\u0007|\u00dd\u00b1\u00e0=\u0084\u00c7\u0089\u00f2\u00ab\u00d3\u0018\u0001%t0\u00de|c9X\u008dd\u000ft\u0002\r\u008bK\u00eb\u00d5k\u00e2\u0010\u0082r[\u009fP\b\u00f2y\u008a\u0004\u0002\u008b\u00fa\u0007h\u00f8o\u0083\u0092\u00de\u0015\u00a2\u0084\u00ff\u00ac\u00112/V\u001ab&#:=m\u001a!\u008c6\u0003/\u0018\u00b2\u00e5\u0098?\u0084\\\u0082\u00f0~\u009eBW\u008c(7.\u0016u\u0099\u000b\u00d1\u008b}\u0088\u00ca\u00da\u00c1\u0087\u00fc\u0014\u0094\u00c1\u00e7'QJ\u0018".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c0\u00e5\u00deD\u00c2\u00a60l".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1281122978;
                case 1 -> -934608562;
                case 2 -> 1566460529;
                case 3 -> 1643309503;
                case 4 -> 1977991274;
                case 5 -> 105038863;
                case 6 -> 524144372;
                case 7 -> -330520434;
                case 8 -> -177329234;
                case 9 -> 1624516679;
                case 10 -> -1402911856;
                case 11 -> -92208934;
                case 12 -> 1705835103;
                case 13 -> 1734062247;
                case 14 -> 191880227;
                case 15 -> -272404808;
                case 16 -> 908651065;
                case 17 -> -2098582631;
                case 18 -> 366985395;
                case 19 -> -1446365277;
                case 20 -> -1174131909;
                case 21 -> 490018229;
                case 22 -> -1151067176;
                case 23 -> -1398879904;
                case 24 -> 1983126448;
                case 25 -> -664986237;
                case 26 -> -110700990;
                case 27 -> 193871545;
                case 28 -> -720142290;
                case 29 -> -767323172;
                case 30 -> -977782277;
                case 31 -> -1655636820;
                case 32 -> 1313677464;
                case 33 -> -1604260757;
                case 34 -> 2105475337;
                case 35 -> 1601935073;
                case 36 -> 1771500463;
                case 37 -> -979657216;
                case 38 -> 286761478;
                case 39 -> -541427155;
                case 40 -> 798241814;
                case 41 -> 733998440;
                case 42 -> 993644525;
                case 43 -> -478346222;
                case 44 -> 280431671;
                case 45 -> -886145987;
                case 46 -> -240685336;
                case 47 -> 533463689;
                case 48 -> 1549841433;
                case 49 -> 1583397845;
                case 50 -> -937911289;
                case 51 -> -1638739627;
                case 52 -> -1928778917;
                case 53 -> 1363116759;
                case 54 -> -682858285;
                case 55 -> -647919998;
                case 56 -> -819595593;
                case 57 -> 792290908;
                case 58 -> -1973526507;
                case 59 -> -903749500;
                case 60 -> -1038520286;
                case 61 -> -1681149847;
                case 62 -> 1744642847;
                case 63 -> 832564010;
                case 64 -> -353716800;
                case 65 -> 1762259236;
                case 66 -> -199325187;
                case 67 -> -1713204765;
                case 68 -> 840967908;
                case 69 -> 64854275;
                case 70 -> 1435638794;
                case 71 -> -1486909935;
                case 72 -> -15399372;
                case 73 -> 527966040;
                case 74 -> -1181029639;
                case 75 -> -942051384;
                case 76 -> -1513830756;
                case 77 -> 235377215;
                case 78 -> -87690678;
                case 79 -> -2123521385;
                case 80 -> 1586291582;
                case 81 -> 1701221889;
                case 82 -> -675105142;
                case 83 -> 914601877;
                case 84 -> 2081458195;
                case 85 -> -1736556058;
                case 86 -> -816338445;
                case 87 -> 816732789;
                case 88 -> 142033586;
                case 89 -> -761181987;
                case 90 -> 1206161064;
                case 91 -> -257841212;
                case 92 -> 49447606;
                case 93 -> 915238404;
                case 94 -> 260111697;
                case 95 -> -748035705;
                case 96 -> -1492402741;
                case 97 -> 1345926587;
                case 98 -> 233151529;
                case 99 -> 4760814;
                case 100 -> 586636031;
                case 101 -> 207695214;
                case 102 -> -2026714812;
                case 103 -> -1504827246;
                case 104 -> -146355144;
                case 105 -> 1948874825;
                case 106 -> -426786843;
                case 107 -> -400086428;
                case 108 -> -1693023200;
                case 109 -> 593318285;
                case 110 -> 1305049102;
                case 111 -> 1995407479;
                case 112 -> -2105897390;
                case 113 -> 1847568648;
                case 114 -> 1003014723;
                case 115 -> 90476115;
                case 116 -> 62330322;
                case 117 -> 1014838931;
                case 118 -> 1663798828;
                case 119 -> 449970511;
                case 120 -> -251650533;
                case 121 -> 679576604;
                case 122 -> 751095535;
                case 123 -> -1010396084;
                case 124 -> -766630667;
                case 125 -> -1686776580;
                case 126 -> -1954268564;
                case 127 -> -2059024064;
                case 128 -> 596344865;
                case 129 -> -905318408;
                case 130 -> 1753577565;
                case 131 -> 1493618213;
                case 132 -> -1590118527;
                case 133 -> 580135283;
                case 134 -> 2064382773;
                case 135 -> 1436549670;
                case 136 -> -1360783849;
                case 137 -> 899106274;
                case 138 -> 1362656655;
                case 139 -> -1350447165;
                case 140 -> 296961776;
                case 141 -> 1553067563;
                case 142 -> 1603359444;
                case 143 -> -1634024759;
                case 144 -> 1275308802;
                case 145 -> 2131031335;
                case 146 -> 1598494515;
                case 147 -> 1135226727;
                case 148 -> -1206858643;
                case 149 -> -1092969973;
                case 150 -> 431197042;
                case 151 -> 921022956;
                case 152 -> 1289620253;
                case 153 -> -1926598159;
                case 154 -> 52989722;
                case 155 -> -85369472;
                case 156 -> -1533843578;
                case 157 -> -2080718434;
                case 158 -> 67211148;
                case 159 -> 439452630;
                case 160 -> 743647041;
                case 161 -> 1247374150;
                case 162 -> 1430904769;
                case 163 -> 1708671056;
                case 164 -> 1166575459;
                case 165 -> -80498299;
                case 166 -> -93402638;
                case 167 -> 1094731942;
                case 168 -> -569518274;
                case 169 -> -705337668;
                case 170 -> -1147381992;
                case 171 -> 1928965396;
                case 172 -> -1853181936;
                case 173 -> 258830110;
                case 174 -> 1892686030;
                case 175 -> -557546843;
                case 176 -> -1722738213;
                case 177 -> 587109081;
                case 178 -> 1285382560;
                case 179 -> 1382065165;
                case 180 -> -1559573918;
                case 181 -> 352385759;
                case 182 -> -883762789;
                case 183 -> 504958511;
                case 184 -> 2012606042;
                case 185 -> 1353317256;
                case 186 -> 535382266;
                case 187 -> 770468108;
                case 188 -> 813892343;
                case 189 -> -1558911580;
                case 190 -> -668993961;
                case 191 -> 1478222826;
                case 192 -> 1763427184;
                case 193 -> -748614974;
                case 194 -> -324331871;
                case 195 -> 1694785852;
                case 196 -> -1762313349;
                case 197 -> 1518746054;
                case 198 -> 1033702801;
                case 199 -> 833985453;
                case 200 -> -1521653905;
                case 201 -> 901926984;
                case 202 -> 1316717738;
                case 203 -> 771606461;
                case 204 -> 2123827945;
                case 205 -> 26718335;
                case 206 -> -318921096;
                case 207 -> 1054330010;
                case 208 -> 136091261;
                case 209 -> -763516810;
                case 210 -> -914296673;
                case 211 -> -627757135;
                case 212 -> 2077053012;
                case 213 -> 1222719230;
                case 214 -> 756446006;
                case 215 -> -1812188214;
                case 216 -> 1903563217;
                case 217 -> 1764073593;
                case 218 -> 786591941;
                case 219 -> -2145003726;
                case 220 -> 1893289927;
                case 221 -> -482752966;
                case 222 -> -1650152891;
                case 223 -> 661565671;
                case 224 -> -1758444447;
                case 225 -> -649052292;
                case 226 -> 1390405734;
                case 227 -> 1871236047;
                case 228 -> -556178210;
                case 229 -> 1469418909;
                case 230 -> -1485085301;
                case 231 -> 49024816;
                case 232 -> 2107015499;
                case 233 -> -1600057943;
                case 234 -> 505495286;
                case 235 -> -1144662604;
                case 236 -> -956350122;
                case 237 -> 420634859;
                case 238 -> 709433805;
                case 239 -> 224371680;
                case 240 -> 603113932;
                case 241 -> -241797787;
                case 242 -> -468807472;
                case 243 -> 167789317;
                case 244 -> 924697278;
                case 245 -> -22248812;
                case 246 -> -588834182;
                case 247 -> -1547063134;
                case 248 -> -799530456;
                case 249 -> 1513386902;
                case 250 -> -1874623411;
                case 251 -> 139032625;
                case 252 -> 519064747;
                case 253 -> 693485242;
                case 254 -> -1050333580;
                case 255 -> 1335404121;
                default -> -869301711;
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
            Object[] objectArray = new Object[21];
            v1 = objectArray;
            i0oI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        i0Oo = 14;
        i0O0 = -1;
        i0OO = 0.65f;
        iOii = -42149;
        00i = 0.5f;
        CoordinatesHudElement = 18;
        iOiI = 2.0f;
        iOio = 4.0f;
        iOi0 = 2.0f;
        iOiO = 3;
        iOIi = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    }

    private void o0I0(DrawContext param1, FontRenderer param2, FontRenderer param3, String param4, float param5, float param6, int param7) {
        if (param4 == null || param4.isEmpty()) {
            return;
        }
        float v8 = param5;
        StringBuilder v9 = new StringBuilder();
        boolean v10 = this.o0Io(param2, param4.charAt(0));
        for (int v11 = 0; v11 < param4.length(); ++v11) {
            char v12 = param4.charAt(v11);
            boolean v13 = this.o0Io(param2, v12);
            if (v13 != v10 && !v9.isEmpty()) {
                String v14 = v9.toString();
                this.o0II(param1, param2, param3, v10, v14, v8, param6, param7);
                v8 += (float)this.o0Ii(param2, param3, v10, v14);
                v9.setLength(0);
                v10 = v13;
            }
            v9.append(v12);
        }
        if (!v9.isEmpty()) {
            this.o0II(param1, param2, param3, v10, v9.toString(), v8, param6, param7);
        }
    }

    private void Oo00I() {
        this.i00i.clear();
        Vec3d v1 = NameTagsModule.ConfigSupport_OI0.gameRenderer.getCamera().method_71156();
        for (Entity v3 : NameTagsModule.ConfigSupport_OI0.world.getEntities()) {
            if (!this.Oo00i(v3)) continue;
            this.i00i.add(v3);
        }
        this.i00i.sort(Comparator.comparingDouble(param1 -> -param1.squaredDistanceTo(v1)));
    }

    private List Ooo0i(DataRecord_oioi_1 param1) {
        int v32;
        ArrayList<CallSite> v2 = new ArrayList<CallSite>(2);
        if (param1.EnumType_O00I() == EnumType_oooi_6.IoO) {
            int v32 = ConfigSupport_oioo_0.OOoOI(Enchantments.SHARPNESS, param1.oII());
            int v4 = ConfigSupport_oioo_0.OOoOI(Enchantments.FIRE_ASPECT, param1.oII());
            if (v32 > 0) {
                v2.add((CallSite)((Object)("\u950b" + v32)));
            }
            if (v4 > 0) {
                v2.add((CallSite)((Object)("\u706b" + v4)));
            }
            return v2;
        }
        if (param1.EnumType_O00I() == EnumType_oooi_6.Io0 && (v32 = ConfigSupport_oioo_0.OOoOI(Enchantments.PROTECTION, param1.oII())) > 0) {
            v2.add((CallSite)((Object)("\u4fdd" + v32)));
        }
        return v2;
    }

    @Override
    @EventHandler
    public void DataRecord_OO0O(ScaledDrawContext param1) {
        if (NameTagsModule.iooI()) {
            return;
        }
        RenderSupport_oooo_2.begin("CLAP_RENDER_2D");
        try {
            if (++this.i0oo >= 3 || this.i00i.isEmpty()) {
                this.i0oo = 0;
                this.Oo00I();
            }
            long v2 = NameTagsModule.ConfigSupport_OI0.world.method_75260();
            this.i0oO.entrySet().removeIf(param2 -> v2 - ((ConfigSupport_0oii_0)param2.getValue()).PacketEvent > 20L);
            this.i0o0.entrySet().removeIf(param2 -> v2 - ((DataRecord_ooio_1)param2.getValue()).i0i > 20L);
            for (Entity v5 : this.i00i) {
                this.Oo0o0(param1, v5);
            }
            return;
        }
        finally {
            RenderSupport_oooo_2.end("CLAP_RENDER_2D");
        }
    }

    private int OooOo(Text param1) {
        return this.OooOI(NetworkSupport_00OI.HudElement(18), NetworkSupport_00OI.EventBusApi(18), param1);
    }

    private int OooOO(Entity param1) {
        if (param1 instanceof LivingEntity) {
            LivingEntity v2 = (LivingEntity)param1;
            float v3 = ConfigSupport_ooii_2.iOOO(v2);
            return this.OooIO(this.OoooI(v3, v2.getMaxHealth()));
        }
        return -1;
    }

    private String Oo0Ii(float param1) {
        if (param1 <= 0.0f) {
            return "0";
        }
        return Integer.toString(Math.max(1, (int)Math.ceil(param1)));
    }

    private int Ooo0o(PlayerEntity param1) {
        try {
            ClientPlayNetworkHandler v2 = ConfigSupport_OI0.getNetworkHandler();
            if (v2 == null) {
                return 0;
            }
            PlayerListEntry v3 = v2.getPlayerListEntry(param1.method_5667());
            return v3 == null ? 0 : v3.getLatency();
        }
        catch (Exception exception) {
            return 0;
        }
    }

    public boolean Oo0oO(Entity param1) {
        return this.Oo00i(param1);
    }

    private List Ooo00(Text param12) {
        ArrayList v2 = new ArrayList();
        param12.method_27658((param1, param2) -> {
            if (param2 != null && !param2.isEmpty()) {
                int v3 = -1;
                if (param1.getColor() != null) {
                    v3 = 0xFF000000 | param1.getColor().getRgb();
                }
                v2.add(new DataRecord_00ii_2(param2, v3));
            }
            return Optional.empty();
        }, Style.EMPTY);
        return v2;
    }

    private Text Oo0i0(Entity param1) {
        Text v2 = this.Oo0io(param1);
        if (((Boolean)this.i00O.HelpCommand()).booleanValue() && param1 instanceof LivingEntity) {
            LivingEntity v3 = (LivingEntity)param1;
            float v4 = ConfigSupport_ooii_2.iOOO(v3);
            Formatting v5 = this.OoooI(v4, v3.getMaxHealth());
            return Text.empty().append((Text)Text.literal((String)(this.Oo0Ii(v4) + " ")).formatted(v5)).append(v2);
        }
        return v2;
    }

    private int OooOI(FontRenderer param1, FontRenderer param2, Text param3) {
        return param3 == null || param3.getString().isEmpty() ? 0 : Math.round((float)this.o0iO(param1, param2, param3.getString()) * 0.5f);
    }

    private int OooIO(Formatting param1) {
        Integer v2 = param1.getColorValue();
        return v2 == null ? -1 : 0xFF000000 | v2;
    }

    private float OooI0(FontRenderer param1) {
        Objects.requireNonNull(NameTagsModule.ConfigSupport_OI0.textRenderer);
        Math.max(1.0f, 9.0f);
        float v3 = Math.max(1.0f, (float)param1.OOi());
        return v3 / 9.0f;
    }

    private boolean o0Io(FontRenderer param1, char param2) {
        return param2 == ' ' || param1.HudElement(param2);
    }

    private String Oo0iI(Entity param1) {
        String v4;
        if (((Boolean)this.i00o.HelpCommand()).booleanValue() && 0ooo.0iiO() != null && param1 instanceof PlayerEntity) {
            PlayerEntity v2 = (PlayerEntity)param1;
            String v3 = v2.getGameProfile().name();
            v4 = 0ooo.0ii0().iI0i(v3);
            if (v4.isBlank() || v4.equalsIgnoreCase(v3)) {
                return "";
            }
        } else {
            return "";
        }
        return v4;
    }

    private void Oo0oo(ScaledDrawContext param1, Entity param2) {
        double v3 = (double)param2.getHeight() + ((Boolean)this.i00I.HelpCommand() != false ? 0.6 : 0.4);
        Vec3d v5 = param2.getLerpedPos(param1.O0i()).add(0.0, v3, 0.0);
        Vector3f v6 = RenderSupport_oiio_4.O0OII(v5);
        if (v6 == null) {
            return;
        }
        Text v7 = this.Oo0i0(param2);
        Text v8 = this.Oo0ii(param2);
        int v9 = NameTagsModule.ConfigSupport_OI0.textRenderer.getWidth((StringVisitable)v7);
        int v10 = v8.getString().isEmpty() ? 0 : NameTagsModule.ConfigSupport_OI0.textRenderer.getWidth((StringVisitable)v8);
        int v11 = v9 + v10;
        Objects.requireNonNull(NameTagsModule.ConfigSupport_OI0.textRenderer);
        float v13 = ((Double)this.GuiSupport_OOI.HelpCommand()).floatValue();
        float v14 = (float)v11 / 2.0f;
        float v15 = v6.x + (-v14 - 2.0f) * v13;
        float v16 = v6.y + -6.5f * v13;
        float v17 = ((float)v11 + 4.0f) * v13;
        float v18 = 13.0f * v13;
        if (this.Ooooo(v15, v16, v17, v18)) {
            return;
        }
        DrawContext v19 = param1.ConfigSupport_O0I();
        GuiSupport_oi0o_0.OOoiO(v19, v15, v16, v15 + v17, v16 + v18, ((Color)this.0oi.HelpCommand()).getRGB());
        v19.getMatrices().pushMatrix();
        v19.getMatrices().translate(v6.x, v6.y);
        v19.getMatrices().scale(v13, v13);
        int v21 = Math.round(-v14);
        v19.drawText(NameTagsModule.ConfigSupport_OI0.textRenderer, v7, v21, -4, ((Color)this.0Io.HelpCommand()).getRGB(), true);
        if (v10 > 0) {
            v19.drawText(NameTagsModule.ConfigSupport_OI0.textRenderer, v8, v21 + v9, -4, -1, true);
        }
        if (((Boolean)this.i00I.HelpCommand()).booleanValue() && param2 instanceof PlayerEntity) {
            PlayerEntity v22 = (PlayerEntity)param2;
            this.Ooo0I(v19, v22, v11, true);
        }
        v19.getMatrices().popMatrix();
    }

    private List Oooo0(PlayerEntity param1) {
        int v2 = param1.method_5628();
        long v3 = NameTagsModule.ConfigSupport_OI0.world.method_75260();
        DataRecord_ooio_1 v5 = (DataRecord_ooio_1)this.i0o0.get(v2);
        if (v5 != null && v5.i0i == v3) {
            return v5.ioO;
        }
        ArrayList v6 = new ArrayList(6);
        this.OoooO(v6, param1.method_6047(), EnumType_oooi_6.IoO);
        for (EquipmentSlot v10 : iOIi) {
            this.OoooO(v6, param1.method_6118(v10), EnumType_oooi_6.Io0);
        }
        this.OoooO(v6, param1.method_6079(), EnumType_oooi_6.Ioo);
        this.i0o0.put(v2, new DataRecord_ooio_1(v3, v6));
        return v6;
    }

    private boolean Oo00i(Entity param1) {
        AntiBotModule v2;
        if (param1 == null || !param1.isAlive()) {
            return false;
        }
        if (((Boolean)this.i0Oi.HelpCommand()).booleanValue() && param1 == NameTagsModule.ConfigSupport_OI0.player) {
            return false;
        }
        if (param1 instanceof PlayerEntity && (v2 = AntiBotModule.iOoo()) != null && v2.iOoI(param1)) {
            return false;
        }
        if (param1 instanceof PlayerEntity) {
            return (Boolean)this.oOio.HelpCommand();
        }
        if (param1 instanceof HostileEntity || param1.getType().getSpawnGroup() == SpawnGroup.MONSTER) {
            return (Boolean)this.i0OI.HelpCommand();
        }
        if (param1 instanceof AnimalEntity || param1.getType().getSpawnGroup() == SpawnGroup.CREATURE) {
            return (Boolean)this.oOii.HelpCommand();
        }
        return false;
    }

    public NameTagsModule() {
        super("NameTags", "Displays entity nametags", ModuleCategory.ioO);
        this.BindCommand = this.OOi0i("Mode", EnumType_0ooi_3.CriticalsModule);
        this.GuiSupport_OOI = this.OOi0o("Scale", 1.0, 0.5, 3.0);
        this.i0Oi = this.OOi00("IgnoreSelf", true);
        this.i00O = this.OOi00("Health", true);
        this.i000 = this.OOi00("Ping", true);
        this.I0II = this.OOi00("Distance", false);
        this.i00o = this.OOi00("IRCName", true);
        this.i00I = this.OOi00("Armor/Hand", true);
        this.0oi = this.OOioo("Background", 75, 91, 111, 150);
        this.0Io = this.OOioo("TextColor", 255, 255, 255, 255);
        this.i00i = new ArrayList();
        this.i0oO = new HashMap();
        this.i0o0 = new HashMap();
    }

    private Formatting OoooI(float param1, float param2) {
        float v3;
        float f = v3 = param2 <= 0.0f ? 0.0f : param1 / param2;
        if (v3 >= 0.75f) {
            return Formatting.GREEN;
        }
        if (v3 >= 0.5f) {
            return Formatting.YELLOW;
        }
        if (v3 >= 0.25f) {
            return Formatting.GOLD;
        }
        return Formatting.RED;
    }

    private Text Oo0II(Entity param1) {
        if (((Boolean)this.i00O.HelpCommand()).booleanValue() && param1 instanceof LivingEntity) {
            LivingEntity v2 = (LivingEntity)param1;
            float v3 = ConfigSupport_ooii_2.iOOO(v2);
            return Text.literal((String)this.Oo0Ii(v3));
        }
        return Text.empty();
    }

    private Text Oo0iO(Entity param1) {
        if (param1 instanceof PlayerEntity) {
            PlayerEntity v2 = (PlayerEntity)param1;
            if (((Boolean)this.i000.HelpCommand()).booleanValue()) {
                return Text.literal((String)(this.Ooo0o(v2) + "ms"));
            }
        }
        return Text.empty();
    }

    private float Oo0oi(List param1) {
        float v2 = 0.0f;
        for (DataRecord_o0oo_2 v4 : param1) {
            v2 += (float)v4.DataRecord_I0O() + 8.0f;
        }
        return v2 += (float)Math.max(0, param1.size() - 1) * 2.0f;
    }

    private void Ooo0I(DrawContext param1, PlayerEntity param2, float param3, boolean param4) {
        List v8 = this.Oooo0(param2);
        if (v8.isEmpty()) {
            return;
        }
        float v9 = (float)v8.size() * 19.2f + (float)(v8.size() - 1) * 3.0f;
        float v10 = param4 ? -v9 / 2.0f : (param3 - v9) / 2.0f;
        for (int v12 = 0; v12 < v8.size(); ++v12) {
            DataRecord_oioi_1 v13 = (DataRecord_oioi_1)v8.get(v12);
            float v14 = v10 + (float)v12 * 22.2f;
            param1.getMatrices().pushMatrix();
            param1.getMatrices().translate(v14, -24.6f);
            param1.getMatrices().scale(1.2f, 1.2f);
            param1.drawItem(v13.oII(), 0, 0);
            param1.drawStackOverlay(NameTagsModule.ConfigSupport_OI0.textRenderer, v13.oII(), 0, 0);
            param1.getMatrices().popMatrix();
            List v15 = v13.O00i();
            if (v15.isEmpty()) continue;
            FontRenderer v16 = NetworkSupport_00OI.HudElement(14);
            float v17 = (float)v16.OOi() * 0.65f;
            float v18 = (float)v15.size() * v17;
            float v19 = -24.6f - v18 - 2.0f;
            float v20 = v14 + 9.6f;
            param1.getMatrices().pushMatrix();
            param1.getMatrices().scale(0.65f, 0.65f);
            for (int v21 = 0; v21 < v15.size(); ++v21) {
                String v22 = (String)v15.get(v21);
                float v23 = (float)v16.GuiSupport_OOI(v22) * 0.65f;
                float v24 = v20 - v23 * 0.5f;
                float v25 = v19 + (float)v21 * v17;
                float v26 = Math.round(v24 / 0.65f);
                float v27 = Math.round(v25 / 0.65f);
                v16.PacketEvent(param1, v22, v26, v27, -1);
            }
            param1.getMatrices().popMatrix();
        }
    }

    private int OooO0(Entity param1) {
        if (param1 instanceof PlayerEntity) {
            PlayerEntity v2 = (PlayerEntity)param1;
            return this.OooIO(this.Ooooi(this.Ooo0o(v2)));
        }
        return -1;
    }
}

