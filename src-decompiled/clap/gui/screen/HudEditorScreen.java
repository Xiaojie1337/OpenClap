/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Click
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.text.Text
 *  org.joml.Vector2f
 */
package clap.gui.screen;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.joml.Vector2f;
import clap.network.NetworkSupport_00OI;
import clap.model.EnumType_I00;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.core.module.Module;
import clap.render.RenderSupport_00oi_0;
import clap.model.DataRecord_00oo_2;
import clap.gui.component.ModuleButton;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.gui.screen.ClickGuiScreen;
import clap.module.client.ClickGuiModule;
import clap.gui.GuiSupport_oiio_6;
import clap.model.EnumType_ooo_3;
import clap.model.DataRecord_ooo_6;
import clap.render.RenderSupport_oooo_2;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class HudEditorScreen
extends Screen {
    private static final int IrcCommand;
    private ModuleButton ioi;
    private float iii;
    private float OOOi;
    private static HudEditorScreen i0i;
    private static final int IoO;
    private static final float Setting;
    private static final int RenderSupport_iio_5;
    private ModuleButton iio;
    private static final int ItemTagsModule;
    private Setting 0o0;
    private float OO0o;
    private ModuleButton iIO;
    private static final float HelpCommand;
    private static final int IoI;
    private final IdentityHashMap ConfigSupport_0II;
    private static final int GuiSupport_III;
    private boolean iiI;
    private ModuleButton iI0;
    private float OOOo = 28.0f;
    private static final int Ii0;
    private static final FontRenderer i0I;
    private static final float iOi;
    private ModuleButton ioo;
    private Setting DataRecord_00I;
    private EnumType_I00 iIi;
    private static final int Ioo;
    private Setting RenderSupport_0I0;
    private static final FontRenderer WorldTimeModule;
    private static final float iOo;
    private float Module;
    private boolean PostProcessingModule;
    private float EnumType_OOO0 = 22.0f;
    private ModuleButton PotionEffectsHudElement;
    private static final float RenderSupport_io0_2;
    private static final int NetworkSupport_i0i_2;
    private static final int IIi;
    private float NetworkSupport_OO00;
    private ModuleButton iiO;
    private float DataRecord_OO0O;
    private static final int ConfigSupport_II0;
    private static final float IiI;
    private ModuleButton EnumType_ii0_2;
    private ModuleButton NoHurtCamModule;
    private static final int Iio;
    private static final int Ioi;
    private final List RenderSupport_oii_4;
    private Setting AutoMlgModule;
    private static final float Iii;
    private String 00i = "";
    public boolean oio;
    private final List io0;
    private static final float OOo;
    public HudElement oi0;
    private static final FontRenderer i00;
    private final List ioO = new ArrayList();
    private static final int Io0;
    private static final float iOI;
    private HudElement iIo;
    private static final int IiO;
    private static final FontRenderer i0o;
    static Object FontRenderer;
    private static volatile /* synthetic */ long __k__gH4it;

    private void GuiComponent(DrawContext param1, ModuleButton param2, float[] param3) {
        ModuleButton v4 = this.NetworkSupport_o0oi_2(param2);
        float v5 = this.oOO(v4.0ii() + v4.FastWebModule() * param3[1], v4.0ii(), v4.0ii() + v4.FastWebModule());
        float v6 = this.oOO(v4.oOO() + v4.oOo() * (1.0f - param3[2]), v4.oOO(), v4.oOO() + v4.oOo());
        this.GuiSupport_O000(param1, v5, v6, 4.5f, -251658241, -1340070608);
        this.GuiSupport_O000(param1, v5, v6, 1.8f, 1612719408, 0);
    }

    private void GuiSupport_O000(DrawContext param1, float param2, float param3, float param4, int param5, int param6) {
        GuiSupport_oi0o_0.OOoiI(param1, param2 - param4, param3 - param4, param4 * 2.0f, param4 * 2.0f, param4, param5);
        if (param6 >>> 24 != 0) {
            GuiSupport_oi0o_0.OOoii(param1, param2 - param4, param3 - param4, param4 * 2.0f, param4 * 2.0f, param4, 1.0f, param6);
        }
    }

    private float ConfigSupport_oi0_2(FontRenderer param1, String param2) {
        return (float)param1.GuiSupport_OOI(param2) * 0.42f;
    }

    private void O0Oi(DrawContext param1, ModuleButton param2, float param3) {
        ModuleButton v4 = this.NetworkSupport_o0oi_2(param2);
        float v5 = param3 >= 0.999f ? 1.0f : param3;
        float v6 = this.oOO(v4.0ii() + v4.FastWebModule() * v5, v4.0ii(), v4.0ii() + v4.FastWebModule());
        this.O00o(param1, v6 - 1.5f, v4.oOO() - 3.0f, 3.0f, v4.oOo() + 6.0f);
    }

    private float[] ConfigSupport_OI0(Setting param1) {
        Color v2 = (Color)param1.HelpCommand();
        float[] v3 = Color.RGBtoHSB(v2.getRed(), v2.getGreen(), v2.getBlue(), null);
        float[] v4 = (float[])this.ConfigSupport_0II.get(param1);
        if (v4 == null) {
            this.ConfigSupport_0II.put(param1, (float[])v3.clone());
            return v3;
        }
        return (float[])v4.clone();
    }

    private float oOO(float param1, float param2, float param3) {
        return Math.max(param2, Math.min(param3, param1));
    }

    private int 0io(float param1) {
        Color v2 = ClickGuiModule.OOi0O() == null ? new Color(114, 164, 255, 255) : (Color)ClickGuiModule.OOi0O().I0ii.HelpCommand();
        int v3 = Math.round((float)v2.getAlpha() * param1);
        return v3 << 24 | v2.getRGB() & 0xFFFFFF;
    }

    private void EnumType_o0o0_0(DrawContext param1, String param2, ModuleButton param3, FontRenderer param4, int param5) {
        float v6 = param3.0ii() + (param3.FastWebModule() - this.ConfigSupport_oi0_2(param4, param2)) * 0.5f;
        float v7 = param3.oOO() + (param3.oOo() - this.oIo(param4)) * 0.5f - 0.5f;
        this.oIO(param1, param4, param2, v6, v7, param5);
    }

    private ModuleButton NetworkSupport_o0oi_2(ModuleButton param1) {
        float v2 = Math.round(param1.0ii());
        float v3 = Math.round(param1.oOO());
        float v4 = (float)Math.round(param1.0ii() + param1.FastWebModule()) - v2;
        float v5 = (float)Math.round(param1.oOO() + param1.oOo()) - v3;
        return new ModuleButton(v2, v3, Math.max(1.0f, v4), Math.max(1.0f, v5));
    }

    private boolean MoveFixModule(ModuleButton param1, ModuleButton param2) {
        return param1.oOO() + param1.oOo() >= param2.oOO() && param1.oOO() <= param2.oOO() + param2.oOo();
    }

    public boolean method_25400(CharInput param1) {
        String v2 = param1.asString();
        if (this.DataRecord_00I != null && v2 != null && !v2.isEmpty() && v2.charAt(0) >= ' ') {
            this.00i = this.00i + v2;
            return true;
        }
        return super.method_25400(param1);
    }

    private void oIO(DrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6) {
        float v7 = (float)Math.round(param4 / 0.42f) * 0.42f;
        float v8 = (float)Math.round(param5 / 0.42f) * 0.42f;
        param1.getMatrices().pushMatrix();
        param1.getMatrices().scale(0.42f, 0.42f);
        param2.PacketEvent(param1, param3, v7 / 0.42f, v8 / 0.42f, param6);
        param1.getMatrices().popMatrix();
    }

    private void O00i(float param1, float param2, float param3, float param4, float param5, int param6, int param7) {
        RenderSupport_00oi_0.O0o(param1, param2, param3, param4, param5, param6);
        if (param7 >>> 24 != 0) {
            RenderSupport_00oi_0.ConfigSupport_O0I(param1, param2, param3, param4, param5, 0.75f, param7);
        }
    }

    private double KeepSprintModule() {
        return this.field_22787 == null ? 0.0 : this.field_22787.mouse.getY() / (double)this.field_22787.getWindow().getScaleFactor();
    }

    private /* synthetic */ void O0iO(DrawContext param1, Setting param2, ModuleButton param3, float param4, float param5, Color param6) {
        this.oIO(param1, i0I, param2.PacketEvent(), param3.0ii() + param4, param5, -722947);
        this.oIO(param1, i0I, this.oIi(param6), param3.0ii() + param4, param5 + 13.0f, -1631335721);
    }

    private float DataRecord_OO0O() {
        float v1 = Math.max(this.ConfigSupport_oi0_2(i0I, "Visible"), this.ConfigSupport_oi0_2(i00, this.iIo == null ? "" : this.iIo.IoOO()));
        for (HudElement v3 : this.ioO) {
            for (Setting v5 : v3.ioIO()) {
                if (!v5.0oO() || "Enabled".equalsIgnoreCase(v5.PacketEvent()) || "Position".equalsIgnoreCase(v5.PacketEvent()) || !this.EventHandler(v5)) continue;
                v1 = Math.max(v1, this.ConfigSupport_oi0_2(i0I, v5.PacketEvent()));
            }
        }
        return this.oOO(v1 + 72.0f, 150.0f, 176.0f);
    }

    public void method_25393() {
        if (this.iIi != EnumType_I00.OoO && this.RenderSupport_0I0 != null) {
            this.O0Oo(this.DataRecord_0io_2(), this.KeepSprintModule());
        }
    }

    private void OOoI(DrawContext param1, String param2, boolean param3, ModuleButton param4, ModuleButton param5) {
        if (!this.MoveFixModule(param4, param5)) {
            return;
        }
        ModuleButton v6 = new ModuleButton(param4.0ii() + param4.FastWebModule() - 32.0f, param4.oOO() + 8.5f, 26.0f, 13.0f);
        this.EnumType_O00I(v6, param3);
        this.RenderSupport_o0oo_1(param1, param5, () -> this.oIO(param1, i0I, param2, param4.0ii(), param4.oOO() + 9.0f, -723456517));
        this.RenderSupport_oii_4.add(new DataRecord_00oo_2(this.iIo.0io0.PacketEvent().equals(param2) ? this.iIo.0io0 : this.OOio(param2), EnumType_ooo_3.GuiSupport_OOI, param4, null));
    }

    private HudEditorScreen() {
        super((Text)Text.literal((String)"clap-hudeditor"));
        this.io0 = new ArrayList();
        this.RenderSupport_oii_4 = new ArrayList();
        this.ioo = ModuleButton.0io();
        this.NoHurtCamModule = ModuleButton.0io();
        this.ioi = ModuleButton.0io();
        this.iIO = ModuleButton.0io();
        this.iI0 = ModuleButton.0io();
        this.iIi = EnumType_I00.OoO;
        this.iiO = ModuleButton.0io();
        this.EnumType_ii0_2 = ModuleButton.0io();
        this.iio = ModuleButton.0io();
        this.ConfigSupport_0II = new IdentityHashMap();
        this.PostProcessingModule();
    }

    private float OOoO() {
        if (this.iIo == null) {
            return 0.0f;
        }
        float v1 = 0.0f;
        for (Setting v3 : this.iIo.ioIO()) {
            if (!v3.0oO() || this.OOoo(v3) || !this.EventHandler(v3)) continue;
            v1 += 34.0f;
            if (v3 == this.AutoMlgModule) {
                v1 += this.DataRecord_OOI0(this.i0o(v3)) + 4.0f;
            }
            if (v3 != this.RenderSupport_0I0) continue;
            v1 += 128.0f;
        }
        return Math.max(0.0f, v1 - 4.0f);
    }

    private void OOi(DrawContext param1, int param2, int param3) {
        int v4 = param1.getScaledWindowWidth();
        int v5 = param1.getScaledWindowHeight();
        param1.fill(0, 0, v4, v5, 0x6000000);
        float v6 = this.OOOi();
        float v7 = this.DataRecord_OO0O();
        float v8 = Math.min(352.0f, Math.max(300.0f, v6 + v7 + 36.0f));
        float v9 = Math.min(292.0f, Math.max(224.0f, (float)v5 - 128.0f));
        if (!this.PostProcessingModule) {
            this.EnumType_OOO0 = ((float)v4 - v8) * 0.5f;
            this.OOOo = ((float)v5 - v9) * 0.5f;
            this.PostProcessingModule = true;
        }
        this.EnumType_OOO0 = this.oOO(this.EnumType_OOO0, 4.0f, Math.max(4.0f, (float)v4 - v8 - 4.0f));
        this.OOOo = this.oOO(this.OOOo, 4.0f, Math.max(4.0f, (float)v5 - v9 - 4.0f));
        this.ioi = new ModuleButton(this.EnumType_OOO0, this.OOOo, v8, v9);
        this.iIO = new ModuleButton(this.EnumType_OOO0 + 8.0f, this.OOOo + 8.0f, v8 - 64.0f, 32.0f);
        this.iI0 = new ModuleButton(this.EnumType_OOO0 + v8 - 62.0f, this.OOOo + 14.0f, 46.0f, 16.0f);
        float v10 = this.field_22787.getWindow().getScaleFactor();
        boolean v11 = RenderSupport_00oi_0.OOo(v4, v5, v10);
        try {
            this.O00i(this.EnumType_OOO0, this.OOOo, v8, v9, 12.0f, 1244016956, 0x18FFFFFF);
            this.NetworkSupport_OO00(param1, this.EnumType_OOO0, this.OOOo, v8);
            this.OO0o(param1, param2, param3, this.EnumType_OOO0 + 10.0f, this.OOOo + 46.0f, v6, v9 - 56.0f);
            this.OO0i(param1, param2, param3, this.EnumType_OOO0 + 22.0f + v6, this.OOOo + 46.0f, v8 - v6 - 32.0f, v9 - 56.0f);
            this.EnumType_O0OO(v4, v5);
        }
        finally {
            if (v11) {
                RenderSupport_00oi_0.GuiSupport_OOI();
                param1.createNewRootLayer();
                RenderSupport_00oi_0.EventBusApi();
            }
        }
        RenderSupport_00oi_0.EventBusApi();
    }

    private void O00o(DrawContext param1, float param2, float param3, float param4, float param5) {
        GuiSupport_oi0o_0.OOoiI(param1, param2, param3, param4, param5, Math.min(param4, param5) * 0.5f, -525313);
        GuiSupport_oi0o_0.OOoii(param1, param2, param3, param4, param5, Math.min(param4, param5) * 0.5f, 0.75f, -1071635152);
    }

    private void OOi0(DrawContext param1, ModuleButton param2, Setting param3, ModuleButton param4) {
        if (!this.MoveFixModule(param2, param4)) {
            return;
        }
        ModuleButton v5 = new ModuleButton(param2.0ii() + param2.FastWebModule() * 0.42f, param2.oOO() + 4.0f, param2.FastWebModule() * 0.58f, 18.0f);
        this.O00i(v5.0ii(), v5.oOO(), v5.FastWebModule(), v5.oOo(), 7.0f, 1545611314, 0x18FFFFFF);
        this.RenderSupport_o0oo_1(param1, param4, () -> {
            this.oIO(param1, i0I, param3.PacketEvent(), param2.0ii(), param2.oOO() + 9.0f, -723456517);
            this.oIO(param1, i0I, this.oII(i0I, param3.0Oi(), v5.FastWebModule() - 12.0f), v5.0ii() + 7.0f, v5.oOO() + 4.0f, -722947);
        });
    }

    private String oi0(Setting param1) {
        return this.RenderSupport_oio_2((Number)param1.HelpCommand()) + param1.StorageEspModule();
    }

    private Setting i0i(Setting param1) {
        return param1;
    }

    static {
        __k__gH4it = HudEditorScreen.__k__gH4it((long)5874705645650832913L);
        __rP__gH4it0 = new String[]{"\ue36d\u4a8b\u9443\uc17e\u4690\u06f7\ue266\u98e5", "\ue326\u4a45\u9404\uc199\u46b2\u0611\ue2b3"};
        __rP__gH4it1 = new String[]{"\ue336\u4a48\u941c\uc1f1\u46a2\u0602\ue2ae\u986a\uec38\u4522", "\ue323\u4a58\u940c\uc198\u46bb"};
        __rP__gH4it2 = new String[]{"\ue334\u4a56\u9402\uc1f3\u46a0\u0604\ue2a8\u9868\uec3a\u452c"};
        __rP__gH4it3 = new String[]{"\ue3a6\u4af8\u9424\uc1f5\u49dd\u09ff\ue2d5\u982f\uec21\u4544\u9b87\ucebb\u48a0\u0849\ue3f4\u9900\ued2a\u4453\u9afd\ucfc3\u4b3c\u0b1a\ue031\u9a42\ueede\u4773\u99eb\ucce8\u4b09\u0a12\ue15f\u9bc4\uef3d\u4632\u98cb\ucd57\u4a65\u0d25\ue6f9\u9cb2\ue880\u4167\u9ff8\uca31\u4d0e\u0c40\ue7aa\u9d2d\ue944\u40a0\u9e6e\ucb4e\u4c49\u0f54\ue4ba\u9e42\uea17\u4348\u9d7b\uc881\u4fec\u0ffe\ue52c\u9fe6\uebd7\u429d\u9c11\uc94e\u4e55\u0ef1\udacf\ua0f0\ud468\u7d75\ua32c\uf60d\u71ab\u3110\udbfa\ua1b0\ud5ab\u7c8c\ua2cc\uf7d8\u70bf\u30c3\ud86c\ua2bd\ud68b\u7fcf\ua108\uf424\u73d2\u33aa\ud882\ua3d9\ud729\u7ef6\ua023\uf544\u7231\u3218\ud9b9\ua48d\ud049\u79be\ua7ba\uf272\u759d\u35fc\ude0d\ua535\ud1ef\u7887\ua645\uf366\u7465\u3450\udf6e\ua697\ud218\u7bfa\ua527\uf05e\u7766\u37bc\udcf1\ua68b\ud35d\u7a5a\ua421\uf1af\u7699\u3610\udd2d\ua752\udc6d\u75ef\uab7c\ufe02\u7943\u39f9\ud2f4\ua834\uddca\u74a1\uaa5d\uff0c\u7800\u3818\ud332\ua992\ude55\u7705\ua90c\ufc5c\u7b75\u3ba8\ud0aa\uaacd\ude2b\u76d5\ua8da\ufd63\u7a0a\u3a0c\ud124\uab8f\udf00\u7155\uafd0\ufae4\u7d75\u3d06\ud6dd\uac05\ud8b0\u70b4\uaeb0\ufbe9\u7ca3\u3c0c\ud770\uad86\ud9f7\u7360\uadbb\uf8eb\u7f46\u3f9e\ud4c0\uaed1", "\ue320\u4a5b\u9407\uc184\u46d2\u0675\ue2d7\u9871\uec3c\u455d\u9b1f\ucef0\u49dc\u095f\ue20d\u9902\ued70\u4447\u9aca\ucffc", "\ue336\u4a4d\u9415"};
        byte[] v0 = "\u00126 \u000e\u009c\u0018\u0011!\u009d\u0082\u008bH\u00f9\u00b6(\u0016\u008e\u008d\u00e9(m\u00ed\u00e5\\r\u00a5\u00f7\u000b\u00a0\u00dd\u00f3\u00e2i\u00dc\u00af\u008c\u00c4\u00e2]\u009c\u00dc\u0081\u0094\u00e2\u00b7\u009f\u0016\u001b\u0000^\u001a\u0085\u00f8\u0083\u000e|[\u00be\u0007Be\u00d1\u00a0\u00a0\u00a3\u0093U\u00f5\u00d4\u00d6K\u00be\u0014s`\u00be2/f\u00e6\u00cf\u0092\u0098s.\u00f4\u00f8\u00e3\u00e7\u00d9T\u0087;\u00a5\u00ee\u00bf=\u00d8\u0087\u00df\u00d0\u001f\u00dd\u00e3U\u0098\u0016\u00e1d\u00e3qC\u00eb\u00b9\u00f1\u00ed\u0094G\u001a\u00e9\u0014\u00cc\u009b\u00dd\u00af\u00d3\u00bd\ri\u0014\u00a5\u00d4Xwi\u00dcQ\u00a9\u00f0q\u009a\u0086\u00a8\u00a2\u00ee\u00ff\u00c9g\u00d1of\fyS\u0090?\\\u00e7\u0086k\u00ff\u00bb>8+K\u0000!\u00dc3<\u00b7LY\u00e1\u00b3t\u00caD\u00a2\u0092[D8;\u0016G\u00a8O1\u00cc\u0017".getBytes("ISO_8859_1");
        Object[] v1 = "\u0013\u008f\u0011\u00d3\u000b\u00ca\u00fc\u00b5".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1319586881;
                case 1 -> -477546725;
                case 2 -> -758841228;
                case 3 -> 2015056372;
                case 4 -> -694089016;
                case 5 -> -1565977156;
                case 6 -> -742794633;
                case 7 -> -202471205;
                case 8 -> -987736385;
                case 9 -> -485465536;
                case 10 -> -454110825;
                case 11 -> 1527237351;
                case 12 -> -1427432788;
                case 13 -> -1068665132;
                case 14 -> -2082824150;
                case 15 -> -1737709482;
                case 16 -> 1484606936;
                case 17 -> -337195819;
                case 18 -> 532321061;
                case 19 -> 91118666;
                case 20 -> -693942940;
                case 21 -> 215018386;
                case 22 -> -683862094;
                case 23 -> -1248966446;
                case 24 -> 1720598881;
                case 25 -> 851771542;
                case 26 -> -2043620474;
                case 27 -> -932362204;
                case 28 -> -1187602630;
                case 29 -> 132834034;
                case 30 -> -2110929651;
                case 31 -> -1501550072;
                case 32 -> 1732262952;
                case 33 -> 1496424906;
                case 34 -> 1519456532;
                case 35 -> -1274675538;
                case 36 -> 952818271;
                case 37 -> -1981957240;
                case 38 -> 276525579;
                case 39 -> 778246359;
                case 40 -> 2028053123;
                case 41 -> -1316707198;
                case 42 -> -1039299275;
                case 43 -> 1288564297;
                case 44 -> 802820345;
                case 45 -> 1629571656;
                case 46 -> 1612484286;
                case 47 -> 2087270412;
                case 48 -> 337896029;
                case 49 -> 1147510752;
                case 50 -> 441241421;
                case 51 -> 1807280523;
                case 52 -> 2131810995;
                case 53 -> 875131893;
                case 54 -> 304573762;
                case 55 -> 940964195;
                case 56 -> 70544944;
                case 57 -> -2045304336;
                case 58 -> 630919470;
                case 59 -> 1000280341;
                case 60 -> 191411099;
                case 61 -> -390412503;
                case 62 -> 1000821243;
                case 63 -> -513636026;
                case 64 -> 814158374;
                case 65 -> 1646338509;
                case 66 -> 636841068;
                case 67 -> 1516263704;
                case 68 -> 901297019;
                case 69 -> -830522723;
                case 70 -> -2028452099;
                case 71 -> -959914689;
                case 72 -> 522947675;
                case 73 -> -1003717168;
                case 74 -> 442032549;
                case 75 -> 1036490273;
                case 76 -> 104239774;
                case 77 -> 248311099;
                case 78 -> -2037134460;
                case 79 -> 1366772584;
                case 80 -> 1472756499;
                case 81 -> 220299845;
                case 82 -> -1795218125;
                case 83 -> 512697018;
                case 84 -> 1537343726;
                case 85 -> 1875966313;
                case 86 -> 771247192;
                case 87 -> 1848553772;
                case 88 -> -124411392;
                case 89 -> -203715879;
                case 90 -> 208881287;
                case 91 -> -701954178;
                case 92 -> -350991076;
                case 93 -> 1301306734;
                case 94 -> 1268084738;
                case 95 -> 1737306446;
                case 96 -> -537955993;
                case 97 -> 688106311;
                case 98 -> 480780355;
                case 99 -> 1311556971;
                case 100 -> -1028760655;
                case 101 -> -948900665;
                case 102 -> 1562848950;
                case 103 -> -1664650416;
                case 104 -> -966923920;
                case 105 -> -1243319829;
                case 106 -> -394618286;
                case 107 -> 1519165376;
                case 108 -> 1319037494;
                case 109 -> -2059643661;
                case 110 -> 1311358381;
                case 111 -> 504530201;
                case 112 -> -2044148619;
                case 113 -> 1984473512;
                case 114 -> -1354121269;
                case 115 -> 435453018;
                case 116 -> -1791284510;
                case 117 -> 584004911;
                case 118 -> -2083501671;
                case 119 -> 1581268674;
                case 120 -> -1764557851;
                case 121 -> 1035420345;
                case 122 -> -1248945401;
                case 123 -> 1106532988;
                case 124 -> 2082710381;
                case 125 -> 1172717283;
                case 126 -> 438863094;
                case 127 -> -682608474;
                case 128 -> 1947700675;
                case 129 -> 815674878;
                case 130 -> -761401114;
                case 131 -> 249056083;
                case 132 -> 1840213919;
                case 133 -> -1648661910;
                case 134 -> 1563752945;
                case 135 -> -1242080462;
                case 136 -> 1094820805;
                case 137 -> -1707178015;
                case 138 -> 1358805117;
                case 139 -> -380630749;
                case 140 -> -1558726248;
                case 141 -> -1872412772;
                case 142 -> 1476935679;
                case 143 -> 1583346129;
                case 144 -> 2063203455;
                case 145 -> 275467581;
                case 146 -> 1375238893;
                case 147 -> 910692751;
                case 148 -> -1390568242;
                case 149 -> 640296186;
                case 150 -> -886379600;
                case 151 -> -492547361;
                case 152 -> -219959970;
                case 153 -> 107860442;
                case 154 -> -1873254577;
                case 155 -> 798383237;
                case 156 -> -1843117814;
                case 157 -> -684078845;
                case 158 -> -86613867;
                case 159 -> 1371937907;
                case 160 -> -1583206873;
                case 161 -> 144751332;
                case 162 -> 829706836;
                case 163 -> 375166724;
                case 164 -> -33989102;
                case 165 -> 1014928401;
                case 166 -> -1932629914;
                case 167 -> 472119713;
                case 168 -> 354596984;
                case 169 -> -1164686577;
                case 170 -> 1324904376;
                case 171 -> -1975387693;
                case 172 -> -1933183626;
                case 173 -> 1215900652;
                case 174 -> 484679446;
                case 175 -> -1464861475;
                case 176 -> 1648555742;
                case 177 -> 1506650764;
                case 178 -> 118810602;
                case 179 -> 1390846012;
                case 180 -> 803303505;
                case 181 -> -1722283663;
                case 182 -> 1181265148;
                case 183 -> -1670871910;
                case 184 -> -1976630880;
                case 185 -> -143440222;
                case 186 -> 737950239;
                case 187 -> 1932690817;
                case 188 -> 142673017;
                case 189 -> -1447223100;
                case 190 -> -1608233696;
                case 191 -> 1138080640;
                case 192 -> 890286790;
                case 193 -> -747095627;
                case 194 -> 517698361;
                case 195 -> -262014658;
                case 196 -> -646092068;
                case 197 -> 568561065;
                case 198 -> -1886768707;
                case 199 -> 76388020;
                case 200 -> 2095725223;
                case 201 -> 1142476038;
                case 202 -> -38394069;
                case 203 -> 1358018774;
                case 204 -> 1588126895;
                case 205 -> 1326931570;
                case 206 -> -414932573;
                case 207 -> -1157597233;
                case 208 -> 1152784585;
                case 209 -> 1555694385;
                case 210 -> 248531895;
                case 211 -> 2043447831;
                case 212 -> 1836028747;
                case 213 -> -743347823;
                case 214 -> -61276479;
                case 215 -> 1863339877;
                case 216 -> 1093030665;
                case 217 -> 394146491;
                case 218 -> 1066391151;
                case 219 -> 979136001;
                case 220 -> -1078190165;
                case 221 -> -167171554;
                case 222 -> 1014040861;
                case 223 -> -667658226;
                case 224 -> 1771899152;
                case 225 -> 488682638;
                case 226 -> -1610599945;
                case 227 -> -1973328749;
                case 228 -> -1353011876;
                case 229 -> -1861305001;
                case 230 -> 1460862213;
                case 231 -> -1070899334;
                case 232 -> 20467501;
                case 233 -> 1726652768;
                case 234 -> -10388446;
                case 235 -> 917484600;
                case 236 -> -179035038;
                case 237 -> -1921064566;
                case 238 -> -1160611004;
                case 239 -> 1904122201;
                case 240 -> -922001750;
                case 241 -> -556623305;
                case 242 -> 829268020;
                case 243 -> 2084033818;
                case 244 -> -1241790216;
                case 245 -> -152892212;
                case 246 -> 2126791824;
                case 247 -> 89592205;
                case 248 -> 903811721;
                case 249 -> -770069340;
                case 250 -> 255668719;
                case 251 -> -621160107;
                case 252 -> -1079436980;
                case 253 -> 869241065;
                case 254 -> -809581336;
                case 255 -> -1838703468;
                default -> -1256998515;
            });
        } while (v2 != 192);
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
            Object[] objectArray = new Object[17];
            v1 = objectArray;
            FontRenderer = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OOo = 0.999f;
        iOi = 124.0f;
        iOI = 18.0f;
        iOo = 4.0f;
        RenderSupport_io0_2 = 30.0f;
        Setting = 8.0f;
        Iii = 4.0f;
        IiI = 24.0f;
        HelpCommand = 0.42f;
        Iio = -394241;
        Ii0 = -1193940481;
        IiO = 1512452154;
        IIi = 1545611314;
        GuiSupport_III = 1720689080;
        RenderSupport_iio_5 = -1631335721;
        ConfigSupport_II0 = -723456517;
        ItemTagsModule = -722947;
        Ioi = 575570687;
        IoI = 406804336;
        Ioo = 0;
        Io0 = 0x18FFFFFF;
        IoO = 808532805;
        NetworkSupport_i0i_2 = 1244016956;
        IrcCommand = 0x6000000;
        WorldTimeModule = NetworkSupport_00OI.OOi(34);
        i00 = NetworkSupport_00OI.OOo(30);
        i0o = NetworkSupport_00OI.OOo(27);
        i0I = NetworkSupport_00OI.OOo(24);
    }

    public boolean method_25404(KeyInput param1) {
        if (this.DataRecord_00I != null) {
            int v2 = param1.method_74228();
            if (v2 == 257) {
                this.DataRecord_00I.OOo(this.00i.isEmpty() ? (String)this.DataRecord_00I.EnumType_0OI() : this.00i);
                this.DataRecord_00I = null;
                this.oio();
                return true;
            }
            if (v2 == 259 && !this.00i.isEmpty()) {
                this.00i = this.00i.substring(0, this.00i.length() - 1);
                return true;
            }
            if (v2 == 256) {
                this.DataRecord_00I = null;
                return true;
            }
        }
        if (param1.method_74228() == 256 && this.field_22787 != null) {
            this.field_22787.setScreen((Screen)ClickGuiScreen.PacketEvent());
            return true;
        }
        return super.method_25404(param1);
    }

    private void OO0o(DrawContext param1, int param2, int param3, float param4, float param5, float param6, float param7) {
        block5: {
            this.O00i(param4, param5, param6, param7, 10.0f, 808532805, 0x18FFFFFF);
            this.ioo = new ModuleButton(param4 + 6.0f, param5 + 7.0f, param6 - 12.0f, param7 - 14.0f);
            float v8 = Math.max(0.0f, (float)this.ioO.size() * 28.0f - 4.0f + 8.0f);
            this.DataRecord_OO0O = Math.max(0.0f, v8 - this.ioo.oOo());
            this.OOOi = this.oOO(this.OOOi, 0.0f, this.DataRecord_OO0O);
            GuiSupport_oiio_6.PacketEvent(param1, Math.round(this.ioo.0ii()), Math.round(this.ioo.oOO()), Math.round(this.ioo.0ii() + this.ioo.FastWebModule()), Math.round(this.ioo.oOO() + this.ioo.oOo()));
            RenderSupport_00oi_0.ConfigSupport_OI0(this.ioo.0ii(), this.ioo.oOO(), this.ioo.FastWebModule(), this.ioo.oOo());
            float v9 = this.ioo.oOO() - this.OOOi;
            for (HudElement v11 : this.ioO) {
                ModuleButton v12 = new ModuleButton(this.ioo.0ii(), v9, this.ioo.FastWebModule(), 24.0f);
                if (this.MoveFixModule(v12, this.ioo)) {
                    this.FontRenderer(param1, param2, param3, v11, v12, this.ioo);
                }
                v9 += 28.0f;
            }
            if (!(this.DataRecord_OO0O > 0.0f)) break block5;
            this.O00i(param4 + param6 - 5.0f, param5 + 10.0f, 2.0f, param7 - 20.0f, 1.0f, 675566439, 0);
            v9 = Math.max(18.0f, (param7 - 20.0f) * ((param7 - 20.0f) / (param7 - 20.0f + this.DataRecord_OO0O)));
            float v10 = param5 + 10.0f + (param7 - 20.0f - v9) * (this.OOOi / this.DataRecord_OO0O);
            this.O00i(param4 + param6 - 5.0f, v10, 2.0f, v9, 1.0f, this.0io(0.7f), 0);
        }
        return;
        finally {
            RenderSupport_00oi_0.OIo();
            GuiSupport_oiio_6.HelpCommand(param1);
        }
    }

    private void AntiBotModule(DrawContext param1, ModuleButton param2, float param3) {
        ModuleButton v4 = this.NetworkSupport_o0oi_2(param2);
        float v5 = this.oOO(v4.oOO() + v4.oOo() * (1.0f - param3), v4.oOO(), v4.oOO() + v4.oOo());
        this.O00o(param1, v4.0ii() - 4.0f, v5 - 1.5f, v4.FastWebModule() + 8.0f, 3.0f);
    }

    private boolean OOoo(Setting param1) {
        String v2 = param1.PacketEvent();
        return "Enabled".equalsIgnoreCase(v2) || "Drawn".equalsIgnoreCase(v2) || "Keybind".equalsIgnoreCase(v2) || "DisplayName".equalsIgnoreCase(v2) || "Position".equalsIgnoreCase(v2);
    }

    private double DataRecord_0io_2() {
        return this.field_22787 == null ? 0.0 : this.field_22787.mouse.getX() / (double)this.field_22787.getWindow().getScaleFactor();
    }

    private Setting i0I(Setting param1) {
        return param1;
    }

    private boolean EventHandler(Setting param1) {
        if (param1 == null || !param1.0oO()) {
            return false;
        }
        return !this.OOoo(param1);
    }

    private void ConfigSupport_OII(Setting param1) {
        Color v2 = (Color)param1.HelpCommand();
        float[] v3 = Color.RGBtoHSB(v2.getRed(), v2.getGreen(), v2.getBlue(), null);
        float[] v4 = (float[])this.ConfigSupport_0II.get(param1);
        if (v4 == null) {
            this.ConfigSupport_0II.put(param1, (float[])v3.clone());
            return;
        }
        if (v3[2] > 0.0f) {
            v4[2] = v3[2];
            if (v3[1] > 0.0f) {
                v4[0] = v3[0];
                v4[1] = v3[1];
            }
        }
    }

    private void GuiSupport_OOII(DrawContext param1, ModuleButton param2, Setting param3, ModuleButton param4) {
        if (!this.MoveFixModule(param2, param4)) {
            return;
        }
        Color v5 = (Color)param3.HelpCommand();
        boolean v6 = this.RenderSupport_0I0 == param3;
        ModuleButton v7 = new ModuleButton(param2.0ii() + param2.FastWebModule() - 32.0f, param2.oOO() + 2.0f, 26.0f, 22.0f);
        ModuleButton v8 = new ModuleButton(v7.0ii() + 5.0f, v7.oOO() + 3.0f, 16.0f, 16.0f);
        this.O00i(v7.0ii(), v7.oOO(), v7.FastWebModule(), v7.oOo(), 7.0f, v6 ? 1917080423 : 1545611314, v6 ? -1999246849 : 0x18FFFFFF);
        this.O00i(v8.0ii(), v8.oOO(), v8.FastWebModule(), v8.oOo(), 5.0f, v5.getRGB(), -1459617793);
        this.RenderSupport_o0oo_1(param1, param4, () -> this.oIO(param1, i0I, param3.PacketEvent(), param2.0ii(), param2.oOO() + 9.0f, -723456517));
        this.RenderSupport_oii_4.add(new DataRecord_00oo_2(param3, EnumType_ooo_3.O0o, v7, null));
    }

    public boolean method_25421() {
        return false;
    }

    private float oIo(FontRenderer param1) {
        return (float)param1.OOi() * 0.42f;
    }

    private void RenderSupport_o0oo_1(DrawContext param1, ModuleButton param2, Runnable param3) {
        this.O0o(() -> {
            param1.enableScissor(Math.round(param2.0ii()), Math.round(param2.oOO()), Math.round(param2.0ii() + param2.FastWebModule()), Math.round(param2.oOO() + param2.oOo()));
            try {
                param3.run();
                return;
            }
            finally {
                param1.disableScissor();
            }
        });
    }

    public boolean method_25403(Click param1, double param2, double param4) {
        if (this.iiI) {
            float v6 = this.ioi.FastWebModule();
            float v7 = this.ioi.oOo();
            int v8 = this.field_22787.getWindow().getScaledWidth();
            int v9 = this.field_22787.getWindow().getScaledHeight();
            this.EnumType_OOO0 = this.oOO((float)param1.x() - this.iii, 4.0f, Math.max(4.0f, (float)v8 - v6 - 4.0f));
            this.OOOo = this.oOO((float)param1.y() - this.Module, 4.0f, Math.max(4.0f, (float)v9 - v7 - 4.0f));
            return true;
        }
        if (this.0o0 != null) {
            this.OoI((int)param1.x());
            return true;
        }
        if (this.iIi != EnumType_I00.OoO && this.RenderSupport_0I0 != null) {
            this.O0Oo(this.DataRecord_0io_2(), this.KeepSprintModule());
            return true;
        }
        return super.method_25403(param1, param2, param4);
    }

    private void NetworkSupport_OO00(DrawContext param1, float param2, float param3, float param4) {
        this.O0o(() -> this.oIO(param1, WorldTimeModule, "HudEditor", param2 + 12.0f, param3 + 11.0f, -722947));
        this.O00i(this.iI0.0ii(), this.iI0.oOO(), this.iI0.FastWebModule(), this.iI0.oOo(), 8.0f, this.0io(0.38f), 0x38FFFFFF);
        this.O0o(() -> this.EnumType_o0o0_0(param1, "Reset", this.iI0, i0I, -723456517));
    }

    private void OOIo(DrawContext param1, int param2, int param3, ModuleButton param4, Setting param5, ModuleButton param6) {
        ModuleButton v7 = this.O0oo(param4, param6);
        if (v7.oOo() <= 0.0f) {
            return;
        }
        this.O00i(v7.0ii(), v7.oOO(), v7.FastWebModule(), v7.oOo(), 8.0f, -668981198, 1758849535);
        float v8 = param4.oOO() + 3.0f;
        for (Enum v12 : (Enum[])((Enum)param5.HelpCommand()).getClass().getEnumConstants()) {
            ModuleButton v13 = new ModuleButton(param4.0ii() + 4.0f, v8, param4.FastWebModule() - 8.0f, 16.0f);
            ModuleButton v14 = this.O0oo(v13, param6);
            if (v14.oOo() > 0.0f) {
                int v17;
                boolean v15 = v12.name().equals(((Enum)param5.HelpCommand()).name());
                boolean v16 = v13.0iI(param2, param3);
                int n = v15 ? 575570687 : (v17 = v16 ? 406804336 : 0);
                if (v17 != 0) {
                    this.O00i(v14.0ii(), v14.oOO(), v14.FastWebModule(), v14.oOo(), 5.0f, v17, 0);
                }
                String v18 = v12.name();
                this.RenderSupport_o0oo_1(param1, param6, () -> {
                    if (v13.oOO() >= param6.oOO() && v13.oOO() + v13.oOo() <= param6.oOO() + param6.oOo()) {
                        this.oIO(param1, i0I, this.oII(i0I, v18, v13.FastWebModule() - 16.0f), v13.0ii() + 6.0f, v13.oOO() + 3.0f, v15 ? -722947 : -723456517);
                    }
                });
                this.RenderSupport_oii_4.add(new DataRecord_00oo_2(param5, EnumType_ooo_3.EventBusApi, v14, v12));
            }
            v8 += 18.0f;
        }
    }

    private void oio() {
        if (this.field_22787 != null) {
            this.field_22787.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((RegistryEntry)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
        }
    }

    public boolean method_25401(double param1, double param3, double param5, double param7) {
        if (this.ioo.0iI(param1, param3)) {
            this.OOOi = this.oOO(this.OOOi + (float)(-param7 * 24.0), 0.0f, this.DataRecord_OO0O);
            return true;
        }
        if (this.NoHurtCamModule.0iI(param1, param3)) {
            this.NetworkSupport_OO00 = this.oOO(this.NetworkSupport_OO00 + (float)(-param7 * 24.0), 0.0f, this.OO0o);
            return true;
        }
        return super.method_25401(param1, param3, param5, param7);
    }

    public void method_25394(DrawContext param1, int param2, int param3, float param4) {
        RenderSupport_oooo_2.begin("CLAP_HUD_EDITOR");
        RenderSupport_oooo_2.beginImmediate("CLAP_HUD_EDITOR");
        try {
            this.io0.clear();
            this.RenderSupport_oii_4.clear();
            this.oio = false;
            this.PostProcessingModule();
            this.OOi(param1, param2, param3);
            return;
        }
        finally {
            RenderSupport_oooo_2.endImmediate("CLAP_HUD_EDITOR");
            RenderSupport_oooo_2.end("CLAP_HUD_EDITOR");
        }
    }

    private Setting OOio(String param1) {
        if (this.iIo == null) {
            return null;
        }
        if ("Visible".equals(param1)) {
            return this.iIo.0io0;
        }
        for (Setting v3 : this.iIo.ioIO()) {
            if (!v3.PacketEvent().equals(param1)) continue;
            return v3;
        }
        return null;
    }

    private float OIo(float param1) {
        return this.oOO(param1, 0.0f, 0.999f);
    }

    public boolean method_25406(Click param1) {
        this.0o0 = null;
        this.PotionEffectsHudElement = null;
        this.iiI = false;
        this.iIi = EnumType_I00.OoO;
        return super.method_25406(param1);
    }

    private void Manager(DrawContext param1, ModuleButton param2, Setting param3, ModuleButton param4) {
        if (!this.MoveFixModule(param2, param4)) {
            return;
        }
        ModuleButton v5 = new ModuleButton(param2.0ii() + param2.FastWebModule() - 82.0f, param2.oOO() + 4.0f, 82.0f, 18.0f);
        boolean v6 = this.AutoMlgModule == param3;
        this.O00i(v5.0ii(), v5.oOO(), v5.FastWebModule(), v5.oOo(), 9.0f, v6 ? 1917080423 : 1545611314, v6 ? -1999246849 : 886434303);
        this.RenderSupport_o0oo_1(param1, param4, () -> {
            this.oIO(param1, i0I, param3.PacketEvent(), param2.0ii(), param2.oOO() + 9.0f, -723456517);
            this.oIO(param1, i0I, this.oII(i0I, param3.KeystrokesHudElement(), v5.FastWebModule() - 22.0f), v5.0ii() + 8.0f, v5.oOO() + 4.0f, -722947);
            this.oIO(param1, i0I, v6 ? "v" : ">", v5.0ii() + v5.FastWebModule() - 14.0f, v5.oOO() + 4.0f, -1631335721);
        });
        this.RenderSupport_oii_4.add(new DataRecord_00oo_2(param3, EnumType_ooo_3.HudElement, v5, null));
    }

    private void O0Oo(double param1, double param3) {
        if (this.RenderSupport_0I0 == null) {
            return;
        }
        Color v5 = (Color)this.RenderSupport_0I0.HelpCommand();
        float[] v6 = this.ConfigSupport_OI0(this.RenderSupport_0I0);
        int v7 = v5.getAlpha();
        if (this.iIi == EnumType_I00.Oo0) {
            v6[1] = this.oOO((float)((param1 - (double)this.iiO.0ii()) / (double)this.iiO.FastWebModule()), 0.0f, 1.0f);
            v6[2] = 1.0f - this.oOO((float)((param3 - (double)this.iiO.oOO()) / (double)this.iiO.oOo()), 0.0f, 1.0f);
        } else if (this.iIi == EnumType_I00.Ooo) {
            v6[0] = this.OIo((float)((param1 - (double)this.EnumType_ii0_2.0ii()) / (double)this.EnumType_ii0_2.FastWebModule()));
        } else if (this.iIi == EnumType_I00.OoI) {
            v7 = Math.round(255.0f * (1.0f - this.oOO((float)((param3 - (double)this.iio.oOO()) / (double)this.iio.oOo()), 0.0f, 1.0f)));
        }
        Color v8 = new Color(Color.HSBtoRGB(v6[0], v6[1], v6[2]));
        this.ConfigSupport_0II.put(this.RenderSupport_0I0, (float[])v6.clone());
        this.RenderSupport_0I0.OOo(new Color(v8.getRed(), v8.getGreen(), v8.getBlue(), v7));
    }

    private ModuleButton O0oo(ModuleButton param1, ModuleButton param2) {
        float v3 = Math.max(param1.0ii(), param2.0ii());
        float v4 = Math.max(param1.oOO(), param2.oOO());
        float v5 = Math.min(param1.0ii() + param1.FastWebModule(), param2.0ii() + param2.FastWebModule());
        float v6 = Math.min(param1.oOO() + param1.oOo(), param2.oOO() + param2.oOo());
        return new ModuleButton(v3, v4, Math.max(0.0f, v5 - v3), Math.max(0.0f, v6 - v4));
    }

    private String RenderSupport_oio_2(Number param1) {
        if (param1 instanceof Integer) {
            return Integer.toString(param1.intValue());
        }
        return String.format(Locale.ROOT, "%.2f", param1.doubleValue());
    }

    private boolean 0ii() {
        return System.currentTimeMillis() / 450L % 2L == 0L;
    }

    private float OOOi() {
        float v1 = 0.0f;
        for (HudElement v3 : this.ioO) {
            v1 = Math.max(v1, this.ConfigSupport_oi0_2(i0o, v3.IoOO()));
        }
        return this.oOO(v1 + 58.0f, 128.0f, 154.0f);
    }

    public boolean method_25402(Click param1, boolean param2) {
        int v3 = (int)param1.x();
        int v4 = (int)param1.y();
        int v5 = param1.button();
        this.0o0 = null;
        this.PotionEffectsHudElement = null;
        this.iiI = false;
        this.iIi = EnumType_I00.OoO;
        if (v5 == 0 && this.iI0.0iI(v3, v4) && this.iIo != null) {
            this.iIo.OOo.OOo(new Vector2f(0.5f, 0.5f));
            this.iIo.GuiSupport_OOI.GuiSupport_OOI();
            this.oio();
            return true;
        }
        if (v5 == 0 && this.iIO.0iI(v3, v4)) {
            this.iiI = true;
            this.iii = (float)v3 - this.EnumType_OOO0;
            this.Module = (float)v4 - this.OOOo;
            return true;
        }
        if (v5 == 0 && this.RenderSupport_0I0 != null) {
            if (this.iiO.0iI(v3, v4)) {
                this.iIi = EnumType_I00.Oo0;
                this.O0Oo(v3, v4);
                return true;
            }
            if (this.EnumType_ii0_2.0iI(v3, v4)) {
                this.iIi = EnumType_I00.Ooo;
                this.O0Oo(v3, v4);
                return true;
            }
            if (this.iio.0iI(v3, v4)) {
                this.iIi = EnumType_I00.OoI;
                this.O0Oo(v3, v4);
                return true;
            }
        }
        for (Record v7 : this.io0) {
            if (!((DataRecord_ooo_6)v7).ConfigSupport_IO0().0iI(v3, v4)) continue;
            if (this.iIo != ((DataRecord_ooo_6)v7).WatermarkHudElement()) {
                this.NetworkSupport_OO00 = 0.0f;
                this.DataRecord_00I = null;
            }
            this.iIo = ((DataRecord_ooo_6)v7).WatermarkHudElement();
            if (v5 == 0 && ((DataRecord_ooo_6)v7).IOo().0iI(v3, v4)) {
                ((DataRecord_ooo_6)v7).WatermarkHudElement().Oo00O();
            }
            this.oio();
            return true;
        }
        for (Record v7 : this.RenderSupport_oii_4) {
            if (!((DataRecord_00oo_2)v7).RenderSupport_OIIO().0iI(v3, v4)) continue;
            if (((DataRecord_00oo_2)v7).OIoi() == EnumType_ooo_3.GuiSupport_OOI) {
                if (((DataRecord_00oo_2)v7).EnumType_OOO0() == null) {
                    return true;
                }
                this.i00(((DataRecord_00oo_2)v7).EnumType_OOO0()).OOo((Boolean)this.i00(((DataRecord_00oo_2)v7).EnumType_OOO0()).HelpCommand() == false);
                this.oio();
                return true;
            }
            if (((DataRecord_00oo_2)v7).OIoi() == EnumType_ooo_3.OOi) {
                this.0o0 = this.i0I(((DataRecord_00oo_2)v7).EnumType_OOO0());
                this.PotionEffectsHudElement = ((DataRecord_00oo_2)v7).RenderSupport_OIIO();
                this.OoI(v3);
                this.oio();
                return true;
            }
            if (((DataRecord_00oo_2)v7).OIoi() == EnumType_ooo_3.HudElement) {
                Setting v8 = this.i0o(((DataRecord_00oo_2)v7).EnumType_OOO0());
                this.AutoMlgModule = this.AutoMlgModule == v8 ? null : v8;
                this.RenderSupport_0I0 = null;
                this.oio();
                return true;
            }
            if (((DataRecord_00oo_2)v7).OIoi() == EnumType_ooo_3.EventBusApi) {
                this.i0o(((DataRecord_00oo_2)v7).EnumType_OOO0()).OOo((Enum)((DataRecord_00oo_2)v7).DataRecord_OII0());
                this.AutoMlgModule = null;
                this.oio();
                return true;
            }
            if (((DataRecord_00oo_2)v7).OIoi() == EnumType_ooo_3.O0o) {
                Setting v8 = this.ioo(((DataRecord_00oo_2)v7).EnumType_OOO0());
                this.RenderSupport_0I0 = this.RenderSupport_0I0 == v8 ? null : v8;
                this.AutoMlgModule = null;
                if (this.RenderSupport_0I0 == v8) {
                    this.ConfigSupport_OII(v8);
                }
                this.oio();
                return true;
            }
            if (((DataRecord_00oo_2)v7).OIoi() != EnumType_ooo_3.ConfigSupport_O0I) continue;
            this.DataRecord_00I = this.i0i(((DataRecord_00oo_2)v7).EnumType_OOO0());
            this.00i = (String)this.DataRecord_00I.HelpCommand();
            this.oio();
            return true;
        }
        return super.method_25402(param1, param2);
    }

    private Setting i00(Setting param1) {
        return param1;
    }

    private String oIi(Color param1) {
        return String.format(Locale.ROOT, "#%02X%02X%02X", param1.getRed(), param1.getGreen(), param1.getBlue());
    }

    private void OoI(int param1) {
        if (this.0o0 == null || this.PotionEffectsHudElement == null) {
            return;
        }
        float v2 = this.oOO(((float)param1 - this.PotionEffectsHudElement.0ii()) / this.PotionEffectsHudElement.FastWebModule(), 0.0f, 1.0f);
        Number v3 = (Number)this.0o0.EventBusApi();
        Number v4 = (Number)this.0o0.ConfigSupport_O0I();
        if (this.0o0.HelpCommand() instanceof Integer) {
            this.0o0.OOo(v3.intValue() + Math.round((float)(v4.intValue() - v3.intValue()) * v2));
        } else if (this.0o0.HelpCommand() instanceof Float) {
            float v5 = v3.floatValue() + (v4.floatValue() - v3.floatValue()) * v2;
            this.0o0.OOo(Float.valueOf((float)Math.round(v5 * 100.0f) / 100.0f));
        } else if (this.0o0.HelpCommand() instanceof Double) {
            double v6 = v3.doubleValue() + (v4.doubleValue() - v3.doubleValue()) * (double)v2;
            this.0o0.OOo((double)Math.round(v6 * 100.0) / 100.0);
        }
    }

    private void OOIi(DrawContext param1, ModuleButton param2, Setting param3, ModuleButton param4) {
        ModuleButton v5 = this.O0oo(param2, param4);
        if (v5.oOo() <= 0.0f) {
            return;
        }
        Color v6 = (Color)param3.HelpCommand();
        float[] v7 = this.ConfigSupport_OI0(param3);
        this.O00i(v5.0ii(), v5.oOO(), v5.FastWebModule(), v5.oOo(), 8.0f, 1545611314, 0x18FFFFFF);
        ModuleButton v10 = new ModuleButton(param2.0ii() + 8.0f, param2.oOO() + 28.0f + 6.0f, param2.FastWebModule() - 16.0f - 18.0f, 56.0f);
        ModuleButton v11 = new ModuleButton(v10.0ii(), v10.oOO() + v10.oOo() + 10.0f, v10.FastWebModule(), 7.0f);
        ModuleButton v12 = new ModuleButton(v10.0ii() + v10.FastWebModule() + 8.0f, v10.oOO(), 8.0f, v10.oOo());
        this.iiO = v10;
        this.EnumType_ii0_2 = v11;
        this.iio = v12;
        RenderSupport_00oi_0.ConfigSupport_OI0(v5.0ii(), v5.oOO(), v5.FastWebModule(), v5.oOo());
        param1.enableScissor(Math.round(v5.0ii()), Math.round(v5.oOO()), Math.round(v5.0ii() + v5.FastWebModule()), Math.round(v5.oOO() + v5.oOo()));
        try {
            float v13 = param2.oOO() + 8.0f;
            if (v13 >= v5.oOO() && v13 <= v5.oOO() + v5.oOo()) {
                this.RenderSupport_o0oo_1(param1, param4, () -> this.O0iO(param1, param3, param2, 8.0f, v13, v6));
            }
            ModuleButton v14 = this.NetworkSupport_o0oi_2(v10);
            Color v15 = Color.getHSBColor(v7[0], 1.0f, 1.0f);
            GuiSupport_oi0o_0.OOIOI(param1, v14.0ii(), v14.oOO(), v14.0ii() + v14.FastWebModule(), v14.oOO() + v14.oOo(), new Color(-1, true), v15);
            GuiSupport_oi0o_0.OOIOi(param1, v14.0ii(), v14.oOO(), v14.0ii() + v14.FastWebModule(), v14.oOO() + v14.oOo(), new Color(0xFFFFFF, true), new Color(-16777216, true));
            GuiSupport_oi0o_0.OOoii(param1, v14.0ii(), v14.oOO(), v14.FastWebModule(), v14.oOo(), 4.0f, 1.0f, 1440607999);
            ModuleButton v16 = this.NetworkSupport_o0oi_2(v11);
            int v17 = Math.max(1, Math.round(v16.FastWebModule()));
            for (int v18 = 0; v18 < v17; ++v18) {
                float v19 = (float)v18 / (float)Math.max(1, v17 - 1);
                GuiSupport_oi0o_0.OOoiO(param1, v16.0ii() + (float)v18, v16.oOO(), v16.0ii() + (float)v18 + 1.0f, v16.oOO() + v16.oOo(), Color.HSBtoRGB(v19, 1.0f, 1.0f) | 0xFF000000);
            }
            GuiSupport_oi0o_0.OOoii(param1, v16.0ii(), v16.oOO(), v16.FastWebModule(), v16.oOo(), 2.0f, 1.0f, 1440607999);
            ModuleButton v18 = this.NetworkSupport_o0oi_2(v12);
            this.O0oi(param1, v18.0ii(), v18.oOO(), v18.FastWebModule(), v18.oOo(), 2.0f);
            GuiSupport_oi0o_0.OOIOi(param1, v18.0ii(), v18.oOO(), v18.0ii() + v18.FastWebModule(), v18.oOO() + v18.oOo(), new Color(v6.getRed(), v6.getGreen(), v6.getBlue(), 255), new Color(v6.getRed(), v6.getGreen(), v6.getBlue(), 24));
            GuiSupport_oi0o_0.OOoii(param1, v18.0ii(), v18.oOO(), v18.FastWebModule(), v18.oOo(), 2.0f, 1.0f, 1440607999);
            this.GuiComponent(param1, v10, v7);
            this.O0Oi(param1, v11, v7[0]);
            this.AntiBotModule(param1, v12, (float)v6.getAlpha() / 255.0f);
            return;
        }
        finally {
            param1.disableScissor();
            RenderSupport_00oi_0.OIo();
        }
    }

    private float ooi(Setting param1) {
        Number v2 = (Number)param1.EventBusApi();
        Number v3 = (Number)param1.ConfigSupport_O0I();
        float v4 = v3.floatValue() - v2.floatValue();
        if (v4 <= 0.0f) {
            return 0.0f;
        }
        return this.oOO((((Number)param1.HelpCommand()).floatValue() - v2.floatValue()) / v4, 0.0f, 1.0f);
    }

    private String oII(FontRenderer param1, String param2, float param3) {
        if (param2 == null) {
            return "";
        }
        if (this.ConfigSupport_oi0_2(param1, param2) <= param3) {
            return param2;
        }
        String v4 = param2;
        while (!v4.isEmpty() && this.ConfigSupport_oi0_2(param1, v4 + "...") > param3) {
            v4 = v4.substring(0, v4.length() - 1);
        }
        return v4 + "...";
    }

    private void OOii(DrawContext param1, ModuleButton param2, String param3) {
        this.O00i(param2.0ii(), param2.oOO(), param2.FastWebModule(), param2.oOo(), 7.0f, 1545611314, 0x18FFFFFF);
        this.O0o(() -> this.EnumType_o0o0_0(param1, param3, param2, i0I, -723456517));
    }

    private void OOoi(DrawContext param1, int param2, ModuleButton param3, Setting param4, ModuleButton param5) {
        if (!this.MoveFixModule(param3, param5)) {
            return;
        }
        ModuleButton v6 = new ModuleButton(param3.0ii() + param3.FastWebModule() - 34.0f, param3.oOO(), 34.0f, 16.0f);
        ModuleButton v7 = new ModuleButton(param3.0ii(), param3.oOO() + 18.0f, param3.FastWebModule(), 12.0f);
        float v8 = this.ooi(param4);
        float v9 = v7.0ii() + v7.FastWebModule() * v8;
        int v10 = v7.0iI(param2, param3.oOO() + 12.0f) ? -2110702518 : 1545611314;
        this.O00i(v7.0ii(), v7.oOO() + 5.0f, v7.FastWebModule(), 2.0f, 1.0f, v10, 0);
        this.O00i(v7.0ii(), v7.oOO() + 5.0f, Math.max(1.0f, v9 - v7.0ii()), 2.0f, 1.0f, this.0io(0.78f), 0);
        RenderSupport_00oi_0.O0o(v9 - 3.0f, v7.oOO() + 2.0f, 6.0f, 8.0f, 3.0f, -394241);
        this.RenderSupport_o0oo_1(param1, param5, () -> {
            this.oIO(param1, i0I, param4.PacketEvent(), param3.0ii(), param3.oOO() + 1.0f, -723456517);
            this.EnumType_o0o0_0(param1, this.oi0(param4), v6, i0I, -722947);
        });
        this.RenderSupport_oii_4.add(new DataRecord_00oo_2(param4, EnumType_ooo_3.OOi, v7, null));
    }

    private void OO0i(DrawContext param1, int param2, int param3, float param4, float param5, float param6, float param7) {
        block10: {
            this.O00i(param4, param5, param6, param7, 10.0f, 808532805, 0x18FFFFFF);
            if (this.iIo == null) {
                this.O0o(() -> this.oIO(param1, i0o, "No HUD modules", param4 + 12.0f, param5 + 14.0f, -1631335721));
                return;
            }
            this.O0o(() -> this.oIO(param1, i00, this.iIo.IoOO(), param4 + 10.0f, param5 + 10.0f, -722947));
            float v8 = param5 + 10.0f + this.oIo(i00) + 8.0f;
            float v9 = param5 + param7 - 8.0f;
            this.NoHurtCamModule = new ModuleButton(param4 + 10.0f, v8, param6 - 20.0f, Math.max(30.0f, v9 - v8));
            float v10 = this.OOoO();
            this.OO0o = Math.max(0.0f, v10 - this.NoHurtCamModule.oOo());
            this.NetworkSupport_OO00 = this.oOO(this.NetworkSupport_OO00, 0.0f, this.OO0o);
            GuiSupport_oiio_6.PacketEvent(param1, Math.round(this.NoHurtCamModule.0ii()), Math.round(this.NoHurtCamModule.oOO()), Math.round(this.NoHurtCamModule.0ii() + this.NoHurtCamModule.FastWebModule()), Math.round(this.NoHurtCamModule.oOO() + this.NoHurtCamModule.oOo()));
            RenderSupport_00oi_0.ConfigSupport_OI0(this.NoHurtCamModule.0ii(), this.NoHurtCamModule.oOO(), this.NoHurtCamModule.FastWebModule(), this.NoHurtCamModule.oOo());
            float v11 = this.NoHurtCamModule.oOO() - this.NetworkSupport_OO00;
            for (Setting v13 : this.iIo.ioIO()) {
                if (!v13.0oO() || this.OOoo(v13)) continue;
                ModuleButton v14 = new ModuleButton(this.NoHurtCamModule.0ii(), v11, this.NoHurtCamModule.FastWebModule(), 30.0f);
                if (v13.Oio()) {
                    this.OOoi(param1, param2, v14, this.i0I(v13), this.NoHurtCamModule);
                    v11 += 34.0f;
                    continue;
                }
                Object v152 = v13.HelpCommand();
                if (v152 instanceof Boolean) {
                    Boolean v16 = (Boolean)v152;
                    this.OOoI(param1, v13.PacketEvent(), v16, v14, this.NoHurtCamModule);
                    v11 += 34.0f;
                    continue;
                }
                if (v13.OiI()) {
                    this.Manager(param1, v14, this.i0o(v13), this.NoHurtCamModule);
                    v11 += 34.0f;
                    if (v13 != this.AutoMlgModule) continue;
                    float v152 = this.DataRecord_OOI0(this.i0o(v13));
                    ModuleButton v17 = new ModuleButton(v14.0ii() + v14.FastWebModule() - 82.0f, v14.oOO() + 24.0f, 82.0f, v152);
                    this.OOIo(param1, param2, param3, v17, this.i0o(v13), this.NoHurtCamModule);
                    v11 += v152 - 8.0f + 4.0f;
                    continue;
                }
                if (v13.DataRecord_0O0()) {
                    this.GuiSupport_OOII(param1, v14, this.ioo(v13), this.NoHurtCamModule);
                    v11 += 34.0f;
                    if (v13 != this.RenderSupport_0I0) continue;
                    v152 = new ModuleButton(v14.0ii(), v11 - 1.0f, v14.FastWebModule(), 124.0f);
                    this.OOIi(param1, (ModuleButton)v152, this.ioo(v13), this.NoHurtCamModule);
                    v11 += 128.0f;
                    continue;
                }
                if (v13.Oii()) {
                    this.OOiO(param1, v14, this.i0i(v13), this.NoHurtCamModule);
                    v11 += 34.0f;
                    continue;
                }
                this.OOi0(param1, v14, v13, this.NoHurtCamModule);
                v11 += 34.0f;
            }
            if (!(this.OO0o > 0.0f)) break block10;
            this.O00i(param4 + param6 - 7.0f, this.NoHurtCamModule.oOO(), 2.0f, this.NoHurtCamModule.oOo(), 1.0f, 675566439, 0);
            v11 = Math.max(16.0f, this.NoHurtCamModule.oOo() * (this.NoHurtCamModule.oOo() / (this.NoHurtCamModule.oOo() + this.OO0o)));
            float v12 = this.NoHurtCamModule.oOO() + (this.NoHurtCamModule.oOo() - v11) * (this.NetworkSupport_OO00 / this.OO0o);
            this.O00i(param4 + param6 - 7.0f, v12, 2.0f, v11, 1.0f, this.0io(0.7f), 0);
        }
        return;
        finally {
            RenderSupport_00oi_0.OIo();
            GuiSupport_oiio_6.HelpCommand(param1);
        }
    }

    private void EnumType_O0OO(int param1, int param2) {
        RenderSupport_00oi_0.Ooi((float)param1 / 2.0f - 0.5f, 0.0f, 1.0f, param2, 0x16FFFFFF);
        RenderSupport_00oi_0.Ooi(0.0f, (float)param2 / 2.0f - 0.5f, param1, 1.0f, 0x16FFFFFF);
    }

    private Setting ioo(Setting param1) {
        return param1;
    }

    public static HudEditorScreen ConfigSupport_O0IO() {
        if (i0i == null) {
            i0i = new HudEditorScreen();
        }
        return i0i;
    }

    private void O0oi(DrawContext param1, float param2, float param3, float param4, float param5, float param6) {
        int v7 = Math.max(1, (int)Math.ceil(param4 / param6));
        int v8 = Math.max(1, (int)Math.ceil(param5 / param6));
        for (int v9 = 0; v9 < v8; ++v9) {
            for (int v10 = 0; v10 < v7; ++v10) {
                int v11 = (v9 + v10 & 1) == 0 ? -4603704 : -1643794;
                float v12 = param2 + (float)v10 * param6;
                float v13 = param3 + (float)v9 * param6;
                GuiSupport_oi0o_0.OOoiO(param1, v12, v13, Math.min(param2 + param4, v12 + param6), Math.min(param3 + param5, v13 + param6), v11);
            }
        }
    }

    private void PostProcessingModule() {
        this.ioO.clear();
        0ooo.0iIi().oo0I().filter(param0 -> param0 instanceof HudElement && !param0.0iI0).map(param0 -> (HudElement)param0).sorted(Comparator.comparing(Module::IoOO, String.CASE_INSENSITIVE_ORDER)).forEach(this.ioO::add);
        if (this.iIo == null || !this.ioO.contains(this.iIo)) {
            this.iIo = this.ioO.isEmpty() ? null : (HudElement)this.ioO.get(0);
        }
    }

    private Setting i0o(Setting param1) {
        return param1;
    }

    private void SprintResetModule(Setting param1) {
        Color v2 = (Color)param1.HelpCommand();
        float[] v3 = Color.RGBtoHSB(v2.getRed(), v2.getGreen(), v2.getBlue(), null);
        float v4 = (v3[0] + 0.08f) % 1.0f;
        Color v5 = new Color(Color.HSBtoRGB(v4, Math.max(0.25f, v3[1]), Math.max(0.35f, v3[2])));
        param1.OOo(new Color(v5.getRed(), v5.getGreen(), v5.getBlue(), v2.getAlpha()));
    }

    private void FontRenderer(DrawContext param1, int param2, int param3, HudElement param4, ModuleButton param5, ModuleButton param6) {
        int v9;
        boolean v8;
        boolean v7 = param5.0iI(param2, param3);
        boolean bl = v8 = this.iIo == param4;
        int n = v8 ? 575570687 : (v9 = v7 ? 406804336 : 0);
        if (v9 != 0) {
            this.O00i(param5.0ii(), param5.oOO(), param5.FastWebModule(), param5.oOo(), 7.0f, v9, 0);
        }
        ModuleButton v10 = new ModuleButton(param5.0ii() + param5.FastWebModule() - 32.0f, param5.oOO() + 5.0f, 24.0f, 13.0f);
        this.EnumType_O00I(v10, param4.IoOo());
        this.RenderSupport_o0oo_1(param1, param6, () -> this.oIO(param1, i0o, param4.IoOO(), param5.0ii() + 8.0f, param5.oOO() + 5.0f, v8 ? -722947 : -723456517));
        this.io0.add(new DataRecord_ooo_6(param4, param5, v10));
    }

    private void EnumType_O00I(ModuleButton param1, boolean param2) {
        this.O00i(param1.0ii(), param1.oOO(), param1.FastWebModule(), param1.oOo(), param1.oOo() * 0.5f, param2 ? this.0io(0.78f) : 1512452154, param2 ? -1193940481 : 0x18FFFFFF);
        float v3 = param1.oOo() - 4.0f;
        float v4 = param2 ? param1.0ii() + param1.FastWebModule() - v3 - 2.0f : param1.0ii() + 2.0f;
        RenderSupport_00oi_0.O0o(v4, param1.oOO() + 2.0f, v3, v3, v3 * 0.5f, -394241);
    }

    private float DataRecord_OOI0(Setting param1) {
        return 6.0f + (float)((Enum[])((Enum)param1.HelpCommand()).getClass().getEnumConstants()).length * 18.0f;
    }

    public void method_25420(DrawContext param1, int param2, int param3, float param4) {
    }

    private void O0o(Runnable param1) {
        RenderSupport_00oi_0.HudElement(param1);
    }

    private void OOiO(DrawContext param1, ModuleButton param2, Setting param3, ModuleButton param4) {
        if (!this.MoveFixModule(param2, param4)) {
            return;
        }
        ModuleButton v5 = new ModuleButton(param2.0ii() + param2.FastWebModule() * 0.42f, param2.oOO() + 4.0f, param2.FastWebModule() * 0.58f, 18.0f);
        boolean v6 = this.DataRecord_00I == param3;
        this.O00i(v5.0ii(), v5.oOO(), v5.FastWebModule(), v5.oOo(), 7.0f, v6 ? 1915829322 : 1545611314, v6 ? -1999246849 : 0x18FFFFFF);
        String v7 = v6 ? this.00i + (this.0ii() ? "_" : "") : (String)param3.HelpCommand();
        this.RenderSupport_o0oo_1(param1, param4, () -> {
            this.oIO(param1, i0I, param3.PacketEvent(), param2.0ii(), param2.oOO() + 9.0f, -723456517);
            this.oIO(param1, i0I, this.oII(i0I, v7, v5.FastWebModule() - 12.0f), v5.0ii() + 7.0f, v5.oOO() + 4.0f, -722947);
        });
        this.RenderSupport_oii_4.add(new DataRecord_00oo_2(param3, EnumType_ooo_3.ConfigSupport_O0I, v5, null));
    }
}

