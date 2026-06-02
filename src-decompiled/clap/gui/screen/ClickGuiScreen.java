/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
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
 */
package clap.gui.screen;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Path;
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
import net.minecraft.client.MinecraftClient;
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
import clap.gui.screen.HudEditorScreen;
import clap.model.EnumType_0OI;
import clap.gui.GuiSupport_O000;
import clap.render.RenderSupport_OIIO;
import clap.model.EnumType_OIO0;
import clap.render.FontRenderer;
import clap.model.DataRecord_OO0O;
import clap.core.module.Module;
import clap.render.RenderSupport_00ii_0;
import clap.model.DataRecord_00o0_0;
import clap.render.RenderSupport_00oi_0;
import clap.model.DataRecord_i0o_0;
import clap.model.DataRecord_ii0_1;
import clap.gui.GuiSupport_iio_1;
import clap.setting.Setting;
import clap.config.ConfigSupport_oii0_1;
import clap.gui.GuiSupport_oii0_2;
import clap.render.RenderSupport_oii_3;
import clap.gui.GuiSupport_oii_5;
import clap.module.client.ClickGuiModule;
import clap.model.EnumType_oio0_0;
import clap.model.DataRecord_oioi_0;
import clap.core.module.ModuleCategory;
import clap.model.DataRecord_oioo_1;
import clap.command.Command;
import clap.gui.GuiSupport_oooi_1;
import clap.render.RenderSupport_oooo_2;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.OiI
 */
public class ClickGuiScreen
extends Screen {
    private String ConfigSupport_0OO = "";
    private String 0Oo;
    private boolean oIO;
    private EnumType_OIO0 Oio;
    private Setting 0oO;
    private final IdentityHashMap 0io;
    private final List ConfigSupport_OII;
    private final GuiSupport_oii0_2 Ooi;
    private final IdentityHashMap ChestStealerModule;
    private static final long OOi;
    private static final long HudElement;
    private final GuiSupport_oii_5 KeystrokesHudElement;
    private final List Oi0;
    private final IdentityHashMap oOO;
    private static final float Oo0;
    private String 0oi = "";
    private boolean StorageEspModule;
    private EnumType_oio0_0 0Io;
    private static final long EventBusApi;
    private Setting 0o0;
    private static final float OoO;
    private DataRecord_OO0O ConfigSupport_00o_0;
    private DataRecord_OO0O SettingContainer;
    private boolean EnumType_0OI;
    private static final long O0i;
    private final IdentityHashMap DataRecord_0io_2;
    private boolean 0Oi;
    private final IdentityHashMap FastWebModule;
    private Setting 0oI;
    private final IdentityHashMap 0ii;
    private static final float OOo;
    private String DataRecord_0O0 = "";
    private Setting DataRecord_00I;
    private static final float HelpCommand;
    private DataRecord_OO0O oOi;
    private final GuiSupport_oooi_1 ConfigSupport_OI0;
    private long ooi;
    private DataRecord_OO0O o00;
    private String 00i = "";
    private Setting RenderSupport_0I0;
    private long ooI;
    private float o0I;
    private DataRecord_OO0O o0O;
    private final IdentityHashMap ConfigSupport_0II;
    private final List RenderSupport_oii_4;
    private DataRecord_OO0O ooo;
    private static final long GuiSupport_OOI;
    private static ClickGuiScreen PacketEvent;
    private long Kernel32SnapshotApi;
    private boolean NetworkSupport_o0o_0;
    private DataRecord_OO0O oo0;
    private Setting AutoMlgModule;
    private static final long O0o;
    private final RenderSupport_oii_3 Ooo = new RenderSupport_oii_3();
    private final List OIo;
    private DataRecord_OO0O RenderSupport_ooo_0;
    private final GuiSupport_iio_1 OoI = new GuiSupport_iio_1();
    private Module OiI;
    private float RenderSupport_ooi_1;
    private final List OiO;
    private Module Oii;
    private final IdentityHashMap KeepSprintModule;
    private boolean oIo;
    private boolean ConfigSupport_oi0_2;
    private final IdentityHashMap 0iI;
    private float oOo;
    private DataRecord_OO0O SpawnerFinderModule;
    private static final long ConfigSupport_O0I;
    static Object oII;
    private static volatile /* synthetic */ long __k__gH4it;

    int ConfigSupport_0II() {
        return this.field_22787 == null ? 0 : (int)(this.field_22787.mouse.getX() / (double)this.field_22787.getWindow().getScaleFactor());
    }

    private int ooI(int param1, float param2) {
        int v3 = Math.round((float)(param1 >>> 24 & 0xFF) * this.oOO(param2, 0.0f, 1.0f));
        return v3 << 24 | param1 & 0xFFFFFF;
    }

    void Ooi() {
        if (this.0oI == null || this.0oi.isBlank() || "-".equals(this.0oi) || ".".equals(this.0oi)) {
            return;
        }
        try {
            Number v1 = (Number)this.0oI.HelpCommand();
            if (v1 instanceof Integer) {
                this.0oI.OOo(Math.round(Float.parseFloat(this.0oi)));
            } else if (v1 instanceof Float) {
                float v2 = Float.parseFloat(this.0oi);
                this.0oI.OOo(Float.valueOf((float)Math.round(v2 * 100.0f) / 100.0f));
            } else if (v1 instanceof Double) {
                double v3 = Double.parseDouble(this.0oi);
                this.0oI.OOo((double)Math.round(v3 * 100.0) / 100.0);
            }
        }
        catch (NumberFormatException numberFormatException) {}
    }

    boolean OiI(Module param1) {
        return this.Oio(param1) || this.Oii(param1) > 0.0f;
    }

    private Setting i0o(Setting param1) {
        return param1;
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

    public boolean method_25403(Click param1, double param2, double param4) {
        if (this.NetworkSupport_o0o_0()) {
            return true;
        }
        if (this.0Io != EnumType_oio0_0.iOI) {
            this.KeystrokesHudElement(this.DataRecord_0io_2(), this.KeepSprintModule());
            return true;
        }
        if (this.0o0 != null) {
            this.OoI(this.ConfigSupport_0II());
            return true;
        }
        if (this.NetworkSupport_o0o_0) {
            this.Oo0(this.KeepSprintModule());
            return true;
        }
        return super.method_25403(param1, param2, param4);
    }

    RenderSupport_oii_3 oii() {
        return this.Ooo;
    }

    private void AutoMlgModule(Setting param1) {
        this.oOO.put(param1, System.currentTimeMillis());
        this.FastWebModule.put(param1, (Boolean)param1.HelpCommand());
    }

    float EnumType_0OI() {
        if (this.Kernel32SnapshotApi == Long.MIN_VALUE) {
            return this.0Oi ? 1.0f : 0.0f;
        }
        float v1 = this.oOO((float)(System.currentTimeMillis() - this.Kernel32SnapshotApi) / 145.0f, 0.0f, 1.0f);
        float v2 = this.RenderSupport_ooo_0(v1);
        if (v1 >= 1.0f) {
            this.Kernel32SnapshotApi = Long.MIN_VALUE;
            return this.StorageEspModule ? 1.0f : 0.0f;
        }
        return this.StorageEspModule ? v2 : 1.0f - v2;
    }

    private float oo0(float param1) {
        float v4 = param1 - 1.0f;
        return this.oOO(1.0f + 2.35f * v4 * v4 * v4 + 1.35f * v4 * v4, 0.0f, 1.025f);
    }

    List DataRecord_I0O() {
        return this.OiO;
    }

    private String ConfigSupport_II0(int param1, int param2) {
        if (this.Oio != EnumType_OIO0.Ii0 || !this.oOi.0iI(param1, param2)) {
            return null;
        }
        List v3 = 0ooo.Oo0().O0o();
        for (DataRecord_oioo_1 v5 : this.Oi0) {
            int v6;
            if (v5.O00o() < 2000 || !v5.GuiSupport_O000().0iI(param1, param2) || (v6 = v5.O00o() - 2000) < 0 || v6 >= v3.size()) continue;
            return (String)v3.get(v6);
        }
        return null;
    }

    void RenderSupport_oii_4() {
        if (this.Oio == EnumType_OIO0.Ii0 || this.Oio == EnumType_OIO0.Iio) {
            this.OiI = null;
            this.Oii = null;
            this.ChestStealerModule.clear();
            this.DataRecord_0io_2.clear();
            this.KeepSprintModule.clear();
            this.0io.clear();
            this.AutoMlgModule = null;
            return;
        }
        List v1 = this.RenderSupport_0I0();
        if (this.OiI == null || !v1.contains(this.OiI)) {
            Module oOOO = this.OiI = v1.isEmpty() ? null : (Module)v1.get(0);
        }
        if (this.Oii != null && !v1.contains(this.Oii)) {
            this.Oii = null;
            this.ChestStealerModule.clear();
            this.DataRecord_0io_2.clear();
            this.RenderSupport_0I0 = null;
            this.AutoMlgModule = null;
            this.KeepSprintModule.clear();
            this.0io.clear();
        }
    }

    float ooi(Setting param1) {
        Number v2 = (Number)param1.EventBusApi();
        Number v3 = (Number)param1.ConfigSupport_O0I();
        float v4 = v3.floatValue() - v2.floatValue();
        if (v4 <= 0.0f) {
            return 0.0f;
        }
        return this.oOO((((Number)param1.HelpCommand()).floatValue() - v2.floatValue()) / v4, 0.0f, 1.0f);
    }

    Setting IiI() {
        return this.RenderSupport_0I0;
    }

    public void method_25393() {
        if (this.0o0 != null) {
            this.OoI(this.ConfigSupport_0II());
        }
        if (this.0Io != EnumType_oio0_0.iOI) {
            this.KeystrokesHudElement(this.DataRecord_0io_2(), this.KeepSprintModule());
        }
    }

    boolean IoI() {
        return this.0Oi;
    }

    protected void method_25426() {
        super.init();
        this.FastWebModule();
    }

    float RenderSupport_io0_2() {
        return this.oOo;
    }

    private boolean NetworkSupport_o0o_0() {
        return this.ConfigSupport_oi0_2 || !this.ConfigSupport_oi0_2 && this.o00() < 170L || this.0Oo();
    }

    public boolean method_25402(Click param1, boolean param2) {
        Object v62;
        if (this.NetworkSupport_o0o_0()) {
            return true;
        }
        int v3 = (int)param1.x();
        int v4 = (int)param1.y();
        int v5 = param1.button();
        if (this.0oO != null) {
            if (v5 == 0 || v5 == 1) {
                return true;
            }
            GuiSupport_O000 v62 = GuiSupport_O000.iOI0(v5);
            v62.iOiO(((GuiSupport_O000)this.0oO.HelpCommand()).iOIi());
            this.0oO.OOo(v62);
            this.0oO = null;
            this.oio();
            return true;
        }
        if (v5 == 0 && this.RenderSupport_0I0 != null) {
            if (this.RenderSupport_ooo_0.0iI(v3, v4)) {
                this.0Io = EnumType_oio0_0.iOi;
                this.KeystrokesHudElement(v3, v4);
                return true;
            }
            if (this.oo0.0iI(v3, v4)) {
                this.0Io = EnumType_oio0_0.WorldTimeModule;
                this.KeystrokesHudElement(v3, v4);
                return true;
            }
            if (this.ooo.0iI(v3, v4)) {
                this.0Io = EnumType_oio0_0.i00;
                this.KeystrokesHudElement(v3, v4);
                return true;
            }
            if (!this.SettingContainer.0iI(v3, v4)) {
                this.0o0();
            }
        }
        this.EnumType_0OI = false;
        this.0o0 = null;
        this.SpawnerFinderModule = null;
        this.0oI = null;
        if (this.0Oo != null && this.ConfigSupport_II0(v3, v4) == null) {
            this.0Oo = null;
        }
        if (v5 == 0 && this.RenderSupport_ooi_1 > 0.0f && ((DataRecord_OO0O)(v62 = this.Ooo(this.o0O, 4.0f, 2.0f))).0iI(v3, v4)) {
            this.NetworkSupport_o0o_0 = true;
            if (this.o00.0iI(v3, v4)) {
                this.o0I = (float)v4 - this.o00.oOO();
            } else {
                this.o0I = this.o00.oOo() * 0.5f;
                this.Oo0(v4);
            }
            return true;
        }
        if (this.ConfigSupport_00o_0.0iI(v3, v4)) {
            this.EnumType_0OI = true;
            this.DataRecord_00I = null;
            this.0oO = null;
            return true;
        }
        for (Object v7 : this.OIo) {
            if (!((DataRecord_00o0_0)v7).GuiSupport_O000().0iI(v3, v4)) continue;
            if (((DataRecord_00o0_0)v7).OIoI() == EnumType_OIO0.Iio) {
                this.field_22787.setScreen((Screen)HudEditorScreen.ConfigSupport_O0IO());
                this.oio();
                return true;
            }
            this.Oio = ((DataRecord_00o0_0)v7).OIoI();
            if (this.Oio == EnumType_OIO0.Ii0) {
                this.0Oi = false;
            }
            this.oOo = 0.0f;
            this.Oii = null;
            this.ChestStealerModule.clear();
            this.DataRecord_0io_2.clear();
            this.RenderSupport_0I0 = null;
            this.AutoMlgModule = null;
            this.KeepSprintModule.clear();
            this.0io.clear();
            this.DataRecord_0O0();
            this.oio();
            this.RenderSupport_oii_4();
            return true;
        }
        boolean v62 = this.oOi.0iI(v3, v4);
        if (v62 && this.Oio == EnumType_OIO0.Ii0) {
            for (Record v8 : this.Oi0) {
                if (!((DataRecord_oioo_1)v8).GuiSupport_O000().0iI(v3, v4)) continue;
                if (((DataRecord_oioo_1)v8).O00o() == 1) {
                    this.Ioi(!this.0Oi);
                    this.EnumType_0OI = this.0Oi;
                    this.DataRecord_00I = null;
                    this.0oO = null;
                } else if (((DataRecord_oioo_1)v8).O00o() == 2) {
                    try {
                        0ooo.Ooo().GuiSupport_OOI();
                        Command.Oiii("Updated config {green} %s", "general", 0ooo.OoI().OoO());
                    }
                    catch (IllegalArgumentException v9) {
                        Command.Oiii("{red} %s", "general", v9.getMessage());
                    }
                } else if (((DataRecord_oioo_1)v8).O00o() == 3) {
                    this.0Oi();
                } else if (((DataRecord_oioo_1)v8).O00o() == 0) {
                    String v9 = this.DataRecord_0O0.trim();
                    if (!v9.isEmpty()) {
                        try {
                            0ooo.Ooi().OOi(v9);
                            this.DataRecord_0O0 = "";
                            Command.Oiii("Saved config {green} %s", "general", 0ooo.KeystrokesHudElement().OoO());
                        }
                        catch (IllegalArgumentException v10) {
                            Command.Oiii("{red} %s", "general", v10.getMessage());
                        }
                    }
                } else if (((DataRecord_oioo_1)v8).O00o() >= 1000 && ((DataRecord_oioo_1)v8).O00o() < 2000) {
                    List v9 = 0ooo.ConfigSupport_OI0().O0o();
                    int v10 = ((DataRecord_oioo_1)v8).O00o() - 1000;
                    if (v10 >= 0 && v10 < v9.size()) {
                        String v11 = (String)v9.get(v10);
                        if (0ooo.OIo().OOo(v11)) {
                            Command.Oiii("Loaded config {green} %s", "general", v11);
                        }
                    }
                } else if (((DataRecord_oioo_1)v8).O00o() >= 2000) {
                    List v9 = 0ooo.ConfigSupport_OII().O0o();
                    int v10 = ((DataRecord_oioo_1)v8).O00o() - 2000;
                    if (v10 >= 0 && v10 < v9.size()) {
                        String v11 = (String)v9.get(v10);
                        if (!v11.equals(this.0Oo)) {
                            this.0Oo = v11;
                        } else {
                            this.0Oo = null;
                            if (0ooo.RenderSupport_oii_4().O0i(v11)) {
                                Command.Oiii("Deleted config {green} %s", "general", v11);
                            } else {
                                Command.Oiii("{red} Could not delete config %s", "general", v11);
                            }
                        }
                    }
                }
                this.oio();
                return true;
            }
        }
        if (v62) {
            for (Record v8 : this.ConfigSupport_OII) {
                if (!((DataRecord_i0o_0)v8).ItemTagsModule().I0i0() && (((DataRecord_i0o_0)v8).ConfigSupport_II0().0iI(v3, v4) || ((DataRecord_i0o_0)v8).RenderSupport_iio_5().0iI(v3, v4) || ((DataRecord_i0o_0)v8).GuiSupport_III().0iI(v3, v4))) {
                    return true;
                }
                if (v5 == 0 && ((DataRecord_i0o_0)v8).RenderSupport_iio_5().0iI(v3, v4)) {
                    ((DataRecord_i0o_0)v8).ItemTagsModule().Oo00O();
                    this.0oi(((DataRecord_i0o_0)v8).ItemTagsModule());
                    this.oio();
                    return true;
                }
                if (((DataRecord_i0o_0)v8).GuiSupport_III().0iI(v3, v4) || v5 == 1 && ((DataRecord_i0o_0)v8).ConfigSupport_II0().0iI(v3, v4)) {
                    this.OiI = ((DataRecord_i0o_0)v8).ItemTagsModule();
                    this.Oi0(((DataRecord_i0o_0)v8).ItemTagsModule());
                    this.oio();
                    return true;
                }
                if (v5 != 0 || !((DataRecord_i0o_0)v8).ConfigSupport_II0().0iI(v3, v4)) continue;
                this.OiI = ((DataRecord_i0o_0)v8).ItemTagsModule();
                this.oio();
                return true;
            }
            for (Record v8 : this.OiO) {
                if (!((DataRecord_oioi_0)v8).GuiSupport_O000().0iI(v3, v4)) continue;
                this.i0o(((DataRecord_oioi_0)v8).EnumType_OOO0()).OOo(((DataRecord_oioi_0)v8).AntiBotModule());
                this.0oO();
                this.oio();
                return true;
            }
            for (Record v8 : this.RenderSupport_oii_4) {
                boolean v9;
                boolean bl = v9 = ((DataRecord_ii0_1)v8).PostProcessingModule().0iI(v3, v4) || ((DataRecord_ii0_1)v8).OOOi() != null && ((DataRecord_ii0_1)v8).OOOi().0iI(v3, v4) || ((DataRecord_ii0_1)v8).DataRecord_OO0O() != null && ((DataRecord_ii0_1)v8).DataRecord_OO0O().0iI(v3, v4);
                if (!v9) continue;
                switch (((DataRecord_ii0_1)v8).OOOo()) {
                    case EnumType_o0o0_0: {
                        Setting v10 = this.i00(((DataRecord_ii0_1)v8).EnumType_OOO0());
                        v10.OOo((Boolean)v10.HelpCommand() == false);
                        this.AutoMlgModule(v10);
                        this.oio();
                        return true;
                    }
                    case O0oo: {
                        Setting v10 = this.i0o(((DataRecord_ii0_1)v8).EnumType_OOO0());
                        if (v5 == 1) {
                            if (this.AutoMlgModule == v10) {
                                this.0oO();
                            } else {
                                this.0o0();
                                if (this.AutoMlgModule != null) {
                                    this.0oO();
                                }
                                this.AutoMlgModule = v10;
                                this.00i(v10, true);
                            }
                        } else {
                            v10.OIo();
                            this.0oO();
                        }
                        this.oio();
                        return true;
                    }
                    case NetworkSupport_o0oi_2: {
                        Setting v10 = this.i0I(((DataRecord_ii0_1)v8).EnumType_OOO0());
                        if (((DataRecord_ii0_1)v8).OOOi() != null && ((DataRecord_ii0_1)v8).OOOi().0iI(v3, v4)) {
                            this.0oI = v10;
                            this.0oi = this.RenderSupport_oio_2((Number)v10.HelpCommand());
                            this.DataRecord_00I = null;
                            this.0oO = null;
                            this.oio();
                        } else {
                            this.0o0 = v10;
                            this.SpawnerFinderModule = ((DataRecord_ii0_1)v8).PostProcessingModule();
                            this.OoI(v3);
                        }
                        return true;
                    }
                    case O0oi: {
                        this.DataRecord_00I = this.i0i(((DataRecord_ii0_1)v8).EnumType_OOO0());
                        this.00i = (String)this.DataRecord_00I.HelpCommand();
                        this.0oO = null;
                        this.oio();
                        return true;
                    }
                    case ConfigSupport_O0IO: {
                        Setting v10;
                        if (((DataRecord_ii0_1)v8).OOOi() != null && ((DataRecord_ii0_1)v8).OOOi().0iI(v3, v4) && (v10 = this.io0(((DataRecord_ii0_1)v8).EnumType_OOO0())) != null) {
                            v10.OOo((Object)(v10.HelpCommand() == clap.model.EnumType_0OI.HelpCommand ? clap.model.EnumType_0OI.PacketEvent : clap.model.EnumType_0OI.HelpCommand));
                            this.oio();
                            return true;
                        }
                        this.0oO = this.ioO(((DataRecord_ii0_1)v8).EnumType_OOO0());
                        this.DataRecord_00I = null;
                        this.oio();
                        return true;
                    }
                    case RenderSupport_O0I0: {
                        boolean v11;
                        Setting v10 = this.ioo(((DataRecord_ii0_1)v8).EnumType_OOO0());
                        boolean bl2 = v11 = this.RenderSupport_0I0 != v10;
                        if (v11) {
                            this.0oO();
                            if (this.RenderSupport_0I0 != null) {
                                this.0o0();
                            }
                            this.RenderSupport_0I0 = v10;
                            this.00i(v10, true);
                        } else {
                            this.0o0();
                        }
                        this.ConfigSupport_OII(v10);
                        if (v11) {
                            this.OiO(((DataRecord_ii0_1)v8).PostProcessingModule());
                        }
                        this.oio();
                        return true;
                    }
                }
            }
        }
        return super.method_25402(param1, param2);
    }

    boolean DataRecord_00I(Setting param1) {
        return param1 == this.RenderSupport_0I0 || this.StorageEspModule(param1) > 0.0f;
    }

    double DataRecord_0io_2() {
        return this.field_22787 == null ? 0.0 : this.field_22787.mouse.getX() / (double)this.field_22787.getWindow().getScaleFactor();
    }

    public boolean HudElement(float param1, float param2, float param3, float param4) {
        return ClickGuiScreen.EventBusApi(param1, param2, param3, param4);
    }

    private void 0o0() {
        if (this.RenderSupport_0I0 == null) {
            return;
        }
        this.00i(this.RenderSupport_0I0, false);
        this.RenderSupport_0I0 = null;
        this.0Io = EnumType_oio0_0.iOI;
    }

    private void o0O() {
        this.EnumType_0OI = false;
        this.0Oi = false;
        this.0Oo = null;
        this.Kernel32SnapshotApi = Long.MIN_VALUE;
        this.StorageEspModule = false;
        this.DataRecord_00I = null;
        this.0oO = null;
        this.0o0 = null;
        this.SpawnerFinderModule = null;
        this.NetworkSupport_o0o_0 = false;
        this.0oI = null;
        this.AutoMlgModule = null;
        this.RenderSupport_0I0 = null;
        this.KeepSprintModule.clear();
        this.0io.clear();
        this.0Io = EnumType_oio0_0.iOI;
    }

    private void Io0() {
        if (this.Oio == EnumType_OIO0.Ii0) {
            return;
        }
        this.oOo = 0.0f;
        this.Oii = null;
        this.ChestStealerModule.clear();
        this.DataRecord_0io_2.clear();
        this.RenderSupport_0I0 = null;
        this.AutoMlgModule = null;
        this.KeepSprintModule.clear();
        this.0io.clear();
        this.RenderSupport_oii_4();
    }

    public void method_25420(DrawContext param1, int param2, int param3, float param4) {
    }

    void RenderSupport_iio_5(DataRecord_OO0O param1) {
        this.ConfigSupport_00o_0 = param1;
    }

    Setting Iii() {
        return this.AutoMlgModule;
    }

    boolean 0ii() {
        return System.currentTimeMillis() / 450L % 2L == 0L;
    }

    float 0oI(Setting param1) {
        Boolean v2 = (Boolean)this.FastWebModule.get(param1);
        Long v3 = (Long)this.oOO.get(param1);
        if (v2 == null || v3 == null) {
            return (Boolean)param1.HelpCommand() != false ? 1.0f : 0.0f;
        }
        float v4 = this.oOO((float)(System.currentTimeMillis() - v3) / 135.0f, 0.0f, 1.0f);
        if (v4 >= 1.0f) {
            this.oOO.remove(param1);
            this.FastWebModule.remove(param1);
            return v2 != false ? 1.0f : 0.0f;
        }
        float v5 = this.RenderSupport_ooo_0(v4);
        return v2 != false ? v5 : 1.0f - v5;
    }

    public boolean method_25421() {
        return false;
    }

    private void Oo0(double param1) {
        float v3 = this.o0O.oOo() - this.o00.oOo();
        if (v3 <= 0.0f || this.RenderSupport_ooi_1 <= 0.0f) {
            this.oOo = 0.0f;
            return;
        }
        float v4 = (float)param1 - this.o0I;
        float v5 = this.oOO((v4 - this.o0O.oOO()) / v3, 0.0f, 1.0f);
        this.oOo = v5 * this.RenderSupport_ooi_1;
    }

    String IIi() {
        return this.00i;
    }

    String oIi(Color param1) {
        return String.format("#%02X%02X%02X", param1.getRed(), param1.getGreen(), param1.getBlue());
    }

    private boolean oOo(ClickGuiModule param1) {
        if (!((Boolean)param1.0iIo.HelpCommand()).booleanValue()) {
            return true;
        }
        if (!this.oIO) {
            this.oIO = true;
            RenderSupport_00ii_0.OOo();
        }
        return true;
    }

    float RenderSupport_ooo_0(float param1) {
        float v2 = 1.0f - param1;
        return 1.0f - v2 * v2 * v2;
    }

    void OoO() {
        this.o0O = DataRecord_OO0O.OOoO();
        this.o00 = DataRecord_OO0O.OOoO();
        this.NetworkSupport_o0o_0 = false;
    }

    private Setting i00(Setting param1) {
        return param1;
    }

    public static boolean EventBusApi(float param0, float param1, float param2, float param3) {
        MinecraftClient v4 = MinecraftClient.getInstance();
        if (!(v4.currentScreen instanceof ClickGuiScreen)) {
            return false;
        }
        float v5 = v4.getWindow().getScaledWidth();
        float v6 = v4.getWindow().getScaledHeight();
        float v7 = Math.min(Math.max(640.0f, v5 - 360.0f), 760.0f);
        float v8 = Math.min(Math.max(385.0f, v6 - 230.0f), 470.0f);
        float v9 = (v5 - v7) * 0.5f;
        float v10 = (v6 - v8) * 0.5f;
        return param0 < v9 + v7 && param0 + param2 > v9 && param1 < v10 + v8 && param1 + param3 > v10;
    }

    private void OOo(Module param1) {
        this.GuiSupport_OOI(RenderSupport_OIIO.DataRecord_0io_2, param1.IoOO());
        this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, param1.Oii0());
        for (Setting v3 : this.0Io(param1)) {
            this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, v3.PacketEvent());
            this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, v3.0Oi());
            if (!(v3.HelpCommand() instanceof Enum)) continue;
            this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, v3.KeystrokesHudElement());
            for (Enum v7 : (Enum[])((Enum)v3.HelpCommand()).getClass().getEnumConstants()) {
                this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, v7.name());
            }
        }
    }

    private float o0I() {
        long v1 = this.ConfigSupport_oi0_2 ? 135L : 170L;
        float v3 = this.oOO((float)this.o00() / (float)v1, 0.0f, 1.0f);
        if (this.ConfigSupport_oi0_2) {
            return 1.0f - this.SettingContainer(v3);
        }
        return this.oo0(v3);
    }

    void WorldTimeModule(DataRecord_OO0O param1, DataRecord_OO0O param2, DataRecord_OO0O param3, DataRecord_OO0O param4) {
        this.SettingContainer = param1;
        this.RenderSupport_ooo_0 = param2;
        this.oo0 = param3;
        this.ooo = param4;
    }

    GuiSupport_oooi_1 ConfigSupport_IO0() {
        return this.ConfigSupport_OI0;
    }

    private void Kernel32SnapshotApi(Module param1, boolean param2) {
        this.ChestStealerModule.put(param1, System.currentTimeMillis());
        this.DataRecord_0io_2.put(param1, param2);
    }

    void Ioi(boolean param1) {
        if (this.0Oi == param1 && this.Kernel32SnapshotApi == Long.MIN_VALUE) {
            return;
        }
        this.0Oi = param1;
        this.StorageEspModule = param1;
        this.Kernel32SnapshotApi = System.currentTimeMillis();
    }

    private void OiO(DataRecord_OO0O param1) {
        float v2 = param1.oOO() + 31.0f;
        float v3 = v2 + 158.0f;
        float v4 = this.oOi.oOO();
        float v5 = this.oOi.oOO() + this.oOi.oOo();
        if (v3 > v5) {
            this.oOo = Math.max(0.0f, this.oOo + v3 - v5 + 8.0f);
        } else if (v2 < v4) {
            this.oOo = Math.max(0.0f, this.oOo - (v4 - v2) - 8.0f);
        }
    }

    private void IoO(String param1) {
        if (this.Oio == EnumType_OIO0.Ii0) {
            this.DataRecord_0O0 = param1;
        } else {
            this.ConfigSupport_0OO = param1;
        }
    }

    boolean ItemTagsModule(String param1) {
        return param1 != null && param1.equals(this.0Oo);
    }

    void KeystrokesHudElement(double param1, double param3) {
        if (this.RenderSupport_0I0 == null) {
            return;
        }
        Color v5 = (Color)this.RenderSupport_0I0.HelpCommand();
        float[] v6 = this.ConfigSupport_OI0(this.RenderSupport_0I0);
        int v7 = v5.getAlpha();
        switch (this.0Io) {
            case iOi: {
                v6[1] = this.oOO((float)((param1 - (double)this.RenderSupport_ooo_0.0ii()) / (double)this.RenderSupport_ooo_0.FastWebModule()), 0.0f, 1.0f);
                v6[2] = 1.0f - this.oOO((float)((param3 - (double)this.RenderSupport_ooo_0.oOO()) / (double)this.RenderSupport_ooo_0.oOo()), 0.0f, 1.0f);
                break;
            }
            case WorldTimeModule: {
                v6[0] = this.OIo((float)((param1 - (double)this.oo0.0ii()) / (double)this.oo0.FastWebModule()));
                break;
            }
            case i00: {
                v7 = Math.round(255.0f * (1.0f - this.oOO((float)((param3 - (double)this.ooo.oOO()) / (double)this.ooo.oOo()), 0.0f, 1.0f)));
                break;
            }
            default: {
                return;
            }
        }
        Color v8 = new Color(Color.HSBtoRGB(v6[0], v6[1], v6[2]));
        this.ConfigSupport_0II.put(this.RenderSupport_0I0, (float[])v6.clone());
        this.RenderSupport_0I0.OOo(new Color(v8.getRed(), v8.getGreen(), v8.getBlue(), v7));
    }

    void O0i(float param1, float param2, float param3, float param4, float param5, float param6) {
        this.o0O = new DataRecord_OO0O(param1, param2, param3, param4);
        this.Ooo.OOo(param1, param2, param3, param4, 2.0f, RenderSupport_OIIO.00i);
        float v7 = Math.max(20.0f, param4 * (param4 / (param4 + param6)));
        float v8 = param6 <= 0.0f ? param2 + 2.0f : param2 + (param4 - v7) * (param5 / param6);
        this.o00 = new DataRecord_OO0O(param1, v8, param3, Math.min(v7, param4));
        this.Ooo.OOo(this.o00.0ii(), this.o00.oOO(), this.o00.FastWebModule(), this.o00.oOo(), 2.0f, RenderSupport_OIIO.0oO);
    }

    int 0iI(int param1, int param2, float param3) {
        float v4 = this.oOO(param3, 0.0f, 1.0f);
        int v5 = Math.round((float)(param1 >>> 24 & 0xFF) + (float)((param2 >>> 24 & 0xFF) - (param1 >>> 24 & 0xFF)) * v4);
        int v6 = Math.round((float)(param1 >>> 16 & 0xFF) + (float)((param2 >>> 16 & 0xFF) - (param1 >>> 16 & 0xFF)) * v4);
        int v7 = Math.round((float)(param1 >>> 8 & 0xFF) + (float)((param2 >>> 8 & 0xFF) - (param1 >>> 8 & 0xFF)) * v4);
        int v8 = Math.round((float)(param1 & 0xFF) + (float)((param2 & 0xFF) - (param1 & 0xFF)) * v4);
        return v5 << 24 | v6 << 16 | v7 << 8 | v8;
    }

    private void 0Oi() {
        Path v1 = 0ooo.OiO().Oo0();
        try {
            if (System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win")) {
                new ProcessBuilder("explorer.exe", v1.toString()).start();
                return;
            }
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(v1.toFile());
                return;
            }
        }
        catch (IOException iOException) {}
        Command.OiiI("{red} Could not open config folder", "general");
    }

    void iOI(float param1) {
        this.RenderSupport_ooi_1 = param1;
    }

    private void 00i(Setting param1, boolean param2) {
        this.KeepSprintModule.put(param1, System.currentTimeMillis());
        this.0io.put(param1, param2);
    }

    private void 0oO() {
        if (this.AutoMlgModule == null) {
            return;
        }
        this.00i(this.AutoMlgModule, false);
        this.AutoMlgModule = null;
    }

    float SpawnerFinderModule(Module param1) {
        Boolean v2 = (Boolean)this.0ii.get(param1);
        Long v3 = (Long)this.0iI.get(param1);
        if (v2 == null || v3 == null) {
            return param1.IoOo() ? 1.0f : 0.0f;
        }
        float v4 = this.oOO((float)(System.currentTimeMillis() - v3) / 135.0f, 0.0f, 1.0f);
        if (v4 >= 1.0f) {
            this.0iI.remove(param1);
            this.0ii.remove(param1);
            return v2 != false ? 1.0f : 0.0f;
        }
        float v5 = this.RenderSupport_ooo_0(v4);
        return v2 != false ? v5 : 1.0f - v5;
    }

    public boolean method_25406(Click param1) {
        if (this.NetworkSupport_o0o_0()) {
            return true;
        }
        this.0o0 = null;
        this.SpawnerFinderModule = null;
        this.NetworkSupport_o0o_0 = false;
        this.0Io = EnumType_oio0_0.iOI;
        return super.method_25406(param1);
    }

    private float SettingContainer(float param1) {
        return param1 * param1 * param1;
    }

    List RenderSupport_0I0() {
        ArrayList<Module> v1 = new ArrayList<Module>();
        String v2 = this.ConfigSupport_0OO.toLowerCase(Locale.ROOT).trim();
        List v3 = v2.isEmpty() ? 0ooo.Oi0().oooo(this.Oio.IiI) : 0ooo.Oio().oo0o();
        for (Module v5 : v3) {
            String v6;
            if (v5.0iI0 || v5.Io00() == ModuleCategory.ioi || !v2.isEmpty() && !(v6 = v5.IoOO().toLowerCase(Locale.ROOT)).startsWith(v2)) continue;
            v1.add(v5);
        }
        v1.sort(Comparator.comparing(Module::IoOO, String.CASE_INSENSITIVE_ORDER));
        return v1;
    }

    public void method_25419() {
        if (this.oIo) {
            super.close();
            return;
        }
        this.RenderSupport_ooi_1();
    }

    int 0io(float param1) {
        Color v2 = ClickGuiModule.OOi0O() == null ? new Color(114, 164, 255, 255) : (Color)ClickGuiModule.OOi0O().I0ii.HelpCommand();
        int v3 = Math.round((float)v2.getAlpha() * param1);
        return v3 << 24 | v2.getRGB() & 0xFFFFFF;
    }

    private void ooo(DrawContext param1, float param2, float param3, float param4) {
        param1.getMatrices().translate(param2, param3);
        param1.getMatrices().scale(param4, param4);
        param1.getMatrices().translate(-param2, -param3);
    }

    public boolean method_25404(KeyInput param1) {
        int v2 = param1.method_74228();
        if (this.ConfigSupport_oi0_2) {
            return true;
        }
        if (this.0oO != null) {
            GuiSupport_O000 v3 = new GuiSupport_O000(v2);
            if (v2 == 261 || v2 == 259 || v2 == 256) {
                v3 = GuiSupport_O000.iOIO();
            }
            v3.iOiO(((GuiSupport_O000)this.0oO.HelpCommand()).iOIi());
            this.0oO.OOo(v3);
            this.0oO = null;
            this.oio();
            return true;
        }
        if (this.DataRecord_00I != null) {
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
        if (this.0oI != null) {
            if (v2 == 257) {
                this.Ooi();
                this.0oI = null;
                this.oio();
                return true;
            }
            if (v2 == 259 && !this.0oi.isEmpty()) {
                this.0oi = this.0oi.substring(0, this.0oi.length() - 1);
                return true;
            }
            if (v2 == 256) {
                this.0oI = null;
                return true;
            }
        }
        if (this.EnumType_0OI) {
            if (v2 == 259 && !this.NetworkSupport_i0i_2().isEmpty()) {
                this.IoO(this.NetworkSupport_i0i_2().substring(0, this.NetworkSupport_i0i_2().length() - 1));
                this.Io0();
                return true;
            }
            if (v2 == 256) {
                this.EnumType_0OI = false;
                return true;
            }
        }
        if (this.RenderSupport_0I0 != null && v2 == 256) {
            this.0o0();
            return true;
        }
        if (this.AutoMlgModule != null && v2 == 256) {
            this.0oO();
            return true;
        }
        if (v2 == 256) {
            this.RenderSupport_ooi_1();
            return true;
        }
        return super.method_25404(param1);
    }

    private long o00() {
        return Math.max(0L, System.currentTimeMillis() - this.ooI);
    }

    private void OOi(DrawContext param1, int param2, int param3) {
        RenderSupport_OIIO.PacketEvent();
        this.OIo.clear();
        this.ConfigSupport_OII.clear();
        this.RenderSupport_oii_4.clear();
        this.OiO.clear();
        this.Oi0.clear();
        this.RenderSupport_oii_4();
        int v4 = param1.getScaledWindowWidth();
        int v5 = param1.getScaledWindowHeight();
        float v6 = Math.min(Math.max(640.0f, (float)v4 - 360.0f), 760.0f);
        float v7 = Math.min(Math.max(385.0f, (float)v5 - 230.0f), 470.0f);
        float v8 = ((float)v4 - v6) * 0.5f;
        float v9 = ((float)v5 - v7) * 0.5f;
        float v11 = v9 + 12.0f;
        float v12 = v7 - 24.0f;
        float v13 = v8 + 12.0f;
        float v15 = v8 + 152.0f + 8.0f;
        float v16 = v6 - 152.0f - 20.0f;
        float v18 = v13 + 10.0f;
        float v19 = v9 + 56.0f;
        float v20 = v7 - 70.0f;
        float v21 = v15 + 10.0f;
        float v22 = v16 - 20.0f;
        boolean v23 = this.Oio == EnumType_OIO0.Ii0;
        float v24 = v9 + 14.0f;
        float v25 = v23 ? v24 : v9 + 46.0f;
        float v26 = v23 ? v7 - 26.0f : v7 - 58.0f;
        float v27 = this.o0I();
        float v28 = 0.86f + 0.13999999f * v27;
        float v29 = v8 + v6 * 0.5f;
        float v30 = v9 + v7 * 0.5f;
        ClickGuiModule v31 = ClickGuiModule.OOi0O();
        if (v31 != null && this.oOo(v31)) {
            RenderSupport_00ii_0.HelpCommand((Boolean)v31.0iIo.HelpCommand(), (Integer)v31.0iIi.HelpCommand());
        }
        param1.fill(0, 0, v4, v5, this.ooI(RenderSupport_OIIO.PacketEvent, 0.55f + 0.45f * v27));
        param1.getMatrices().pushMatrix();
        this.ooo(param1, v29, v30, v28);
        float v32 = this.field_22787.getWindow().getScaleFactor();
        RenderSupport_oooo_2.beginImmediate("CLAP_CLICKGUI");
        boolean v33 = RenderSupport_00oi_0.OOo(v4, v5, v32);
        if (v33) {
            RenderSupport_00oi_0.ConfigSupport_OII(v29, v30, v28);
        }
        this.Ooo.PacketEvent(v8 + 6.0f, v9 + 6.0f, v6 - 12.0f, v7 - 12.0f, 18.0f);
        this.Ooo.EventBusApi(v13, v11, 140.0f, v12, 14.0f);
        this.Ooo.EventBusApi(v15, v11, v16, v12, 14.0f);
        this.Ooo.OoI(v15 - 5.0f, v11 + 4.0f, 1.0f, v12 - 8.0f);
        this.OoI.PacketEvent(param1, this, param2, param3, v18, v19, 120.0f, v20);
        if (v23) {
            this.RenderSupport_iio_5(DataRecord_OO0O.OOoO());
        } else {
            this.Ooi.PacketEvent(param1, this, v21, v24, v22);
        }
        this.WorldTimeModule(DataRecord_OO0O.OOoO(), DataRecord_OO0O.OOoO(), DataRecord_OO0O.OOoO(), DataRecord_OO0O.OOoO());
        this.Ooi.HelpCommand(param1, this, param2, param3, v21, v25, v22, v26);
        this.O0o(() -> {
            this.oIO(param1, RenderSupport_OIIO.ConfigSupport_0II, "Clap Client", v8 + 16.0f, v9 + 16.0f, -722947);
            this.oIO(param1, RenderSupport_OIIO.KeepSprintModule, this.Oio == EnumType_OIO0.Ii0 ? "Configuration" : this.Oio.WatermarkHudElement, v8 + 16.0f, v9 + 38.0f, -1429284376);
        });
        RenderSupport_00oi_0.EventBusApi();
        param1.getMatrices().popMatrix();
        return;
        finally {
            if (v33) {
                RenderSupport_00oi_0.RenderSupport_oii_4();
                RenderSupport_00oi_0.GuiSupport_OOI();
                param1.createNewRootLayer();
                RenderSupport_00oi_0.EventBusApi();
            }
            RenderSupport_oooo_2.endImmediate("CLAP_CLICKGUI");
        }
    }

    private float OIo(float param1) {
        return this.oOO(param1, 0.0f, 0.999f);
    }

    private Setting i0i(Setting param1) {
        return param1;
    }

    String NetworkSupport_i0i_2() {
        return this.Oio == EnumType_OIO0.Ii0 ? this.DataRecord_0O0 : this.ConfigSupport_0OO;
    }

    int ChestStealerModule() {
        return this.field_22787 == null ? 0 : (int)(this.field_22787.mouse.getY() / (double)this.field_22787.getWindow().getScaleFactor());
    }

    void oIO(DrawContext param1, FontRenderer param2, String param3, float param4, float param5, int param6) {
        float v7 = (float)Math.round(param4 / 0.5f) * 0.5f;
        float v8 = (float)Math.round(param5 / 0.5f) * 0.5f;
        param1.getMatrices().pushMatrix();
        param1.getMatrices().scale(0.5f, 0.5f);
        param2.PacketEvent(param1, param3, v7 / 0.5f, v8 / 0.5f, param6);
        param1.getMatrices().popMatrix();
    }

    float[] ConfigSupport_OI0(Setting param1) {
        Color v2 = (Color)param1.HelpCommand();
        float[] v3 = Color.RGBtoHSB(v2.getRed(), v2.getGreen(), v2.getBlue(), null);
        float[] v4 = (float[])this.ConfigSupport_0II.get(param1);
        if (v4 == null) {
            this.ConfigSupport_0II.put(param1, (float[])v3.clone());
            return v3;
        }
        return (float[])v4.clone();
    }

    public boolean method_25400(CharInput param1) {
        if (this.NetworkSupport_o0o_0()) {
            return true;
        }
        String v2 = param1.asString();
        if (v2 == null || v2.isEmpty() || v2.charAt(0) < ' ') {
            return super.method_25400(param1);
        }
        if (this.DataRecord_00I != null) {
            this.00i = this.00i + v2;
            return true;
        }
        if (this.0oI != null) {
            char v3 = v2.charAt(0);
            if (v3 >= '0' && v3 <= '9' || v3 == '.' || v3 == '-') {
                if (v3 == '.' && this.0oi.contains(".")) {
                    return true;
                }
                if (v3 == '-' && !this.0oi.isEmpty()) {
                    return true;
                }
                this.0oi = this.0oi + v2;
            }
            return true;
        }
        if (this.EnumType_0OI) {
            this.IoO(this.NetworkSupport_i0i_2() + v2);
            this.Io0();
            return true;
        }
        return super.method_25400(param1);
    }

    public static ClickGuiScreen PacketEvent() {
        if (PacketEvent == null) {
            PacketEvent = new ClickGuiScreen();
        }
        return PacketEvent;
    }

    String oII(FontRenderer param1, String param2, float param3) {
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

    boolean Ioo() {
        return this.EnumType_0OI;
    }

    float oIo(FontRenderer param1) {
        return (float)param1.OOi() * 0.5f;
    }

    List SprintModule() {
        return this.ConfigSupport_OII;
    }

    static {
        __k__gH4it = ClickGuiScreen.__k__gH4it((long)1661105126389050897L);
        __rP__gH4it0 = new String[]{"\ud188\uf5fc\u2a77\u7f92\uf896\u76bd\uc4b6\u29df\ud098\uf475\u2943\u7c97\ufb2f\u756b\uc7e1\u2adb\ud337\uf730\u28e3\u7db6\ufab6\u7463\uc6c2\u2be6\ud2fd\uf6f3\u2811\u7a77\ufdb9\u731b\uc189\u2c4e\ud534\uf12f\u2f2c\u7bd2\ufc62\u72ab\uc09a\u2d30\ud466\uf04c\u2e55\u78e2\uff47\u7113\uc301\u2e8d\ud749\uf3ee\u2d24\u7933\ufeec\u7009\uc29e\u2fa3\ud6db\uf22b\u2c85\u7934\ue19a\u6f53\uddc6\u3020\uc9a9\uedde\u330d\u66e0\ue0c5\u6e48\udc11\u318a\uc8a4\uec81\u3291\u67e7\ue30d\u6d01\udf0d\u32ff\ucb75\uefeb\u31e7\u64fd\ue221\u6c2b\ude1e\u3331\uca56\ueec4\u30d5\u6518\ue282\u6b13\ud915\u34a1\ucd7e\ue910\u3749\u62f9\ue53c\u6ada\ud871\u3574\uccb7\ue8c8\u361b\u63db\ue4b6\u6919\udb13\u36e4\ucfc8\uebd0\u35b9\u60c4\ue708\u6996\uda77\u379d\uceca\uea46\u342d\u61cb\ue6f7\u6816\ud597\u387f\uc198\ue52c\u3b5b\u6e2e\ue915\u671c\ud410\u3909\uc0a8\ue49e\u3aff\u6f01\ue850\u669e\ud729\u3afa\uc3be\ue7af\u39e8\u6c5c\ueb49\u654a\ud713\u3bee\uc2fe\ue68a\u38cc\u6deb\uead1\u64dd\ud641\u3c79\uc521\ue1b3\u3f88\u6afd\uedaa\u6385\ud1c7\u3db9\uc451\ue0ee\u3e32\u6ba2\uec23\u628e\ud004\u3e7e\uc721\ue303\u3d58\u683a\uefcf\u61b1\ud36d\u3edf\uc69a\ue2f7\u3c3f\u69ae\uee65\u6079\ud21a\u3f0b\ub9f7\u9d6d\u4330\u16c7\u910f\u1f23\uad68\u40b0\ub8e7\u9ca3\u42b2\u1705\u904c\u1eed\uacd8\u41cc\ubb68\u9fb5\u41c3\u141f\u93c8\u1dbb\uaf6e\u4206\ubb8d\u9efb\u40a0\u1531\u928a\u1cb0\uae82\u4377\uba96\u9941\u4719\u12e9\u95fd\u1b0f\ua93d\u44ae\ubde2\u988d\u469c\u1385\u9475\u1a47\ua887\u45d7\ubc96\u9b99\u45a0\u10db\u97b0\u1915\uabe9\u4669\ubf06\u9be4\u44db\u115c\u9651\u1804\uaa64\u475c\ube68\u9afa\u4b98\u1e26\u99b9\u17cd\ua567\u4811\ub1a6\u9551\u4a1b\u1ff1\u9834\u16d0\ua4af\u49cf\ub063\u942d\u4929\u1c8c\u9b35\u15ad\ua7bd\u4a3d\ub3f7\u97ba\u4979\u1dda\u9a4d\u14d1\ua644\u4bbd\ub288\u964d\u485a\u1a12\u9d7b\u13e7\ua190\u4c0c\ub597\u91e6\u4fe0\u1bb9\u9c83\u12df\ua03d\u4d1f\ub48a\u901f\u4e9d\u1819\u9f0f\u1108\ua320\u4e7c\ub74d\u9397\u4dac\u180e\u9ed3\u10db\ua220\u4fd6\ub666\u9293\u4c4c\u19ba\u811d\u0f20\ubdc6\u5077\ua9f3\u8d28\u53f0\u0694\u80eb\u0e86\ubc47\u51d2\ua84a\u8c05\u5266\u07c6\u83f3\u0def\ubf82\u5207\uab6e\u8f4e\u5148\u04c4\u8368\u0ca7\ube87\u53e0\uaa9d\u8ea7\u5039\u055b\u822a\u0bc8\ub914\u54c7\uad57\u89d1\u5771\u02a7\u85f0\u0ace\ub84b\u558b\uaced\u8867\u56ae\u0363\u84dc\u0a80\ubba7\u5620\uaf37\u8bb5\u5589\u00e3\u874e\u0927\ubaa6\u5764\uae6c\u8aca\u54cc\u0170\u866f\u08f2\ub5b4\u5866\ua1a5\u8528\u5bd2\u0ea6\u8945\u078e\ub40c\u59b4", "\ud03f\uf4c6\u2a19\u7ff6\uf8a7\u7601\uc76d\u2af2\ud321\uf7ac", "\ud03d\uf4dd\u2a0e", "\ud028\uf4c8\u2a1f\u7f8d\uf8ac"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\ud03d\uf4c4\u2a1f\u7ff0\uf8a5\u7603\uc763\u2afc\ud323\uf7ae", "\ud02b\uf4cf\u2a1c\u7f9d\uf8c5\u767c\uc712\u2aef\ud327\uf7d9\u2914\u7cf9\ufbab\u7566\uc638\u2bac\ud21b\uf6f3\u2831\u7dc5", "\ud02d\uf4d5\u2a1f\u7f8c\uf8a5\u7604\uc496"};
        __rP__gH4it3 = new String[]{"\ud0af\uf4ce\u2ae6\u7f56\uf8de\u7619\uc75f\u2a9e"};
        byte[] v0 = "g\u00f6\u00b8\u00a0\u0090\u0003g\u009fog\u0094\u00bd1\u00dd8\u0093\u00c8*<\u0094\u00a0\u00ed\u00e3\u0096z\u00d16m\u00d7\u009d\u00a06\u00bb\u0005\u0003\u00c0\u00045\u00abP\u00f1~b\u00e89\u00858\u00e5\u00d6\u00d4\u001b1\u009a\u00e7\u009f3|i\u0082\u00ce\u00d4\u00b5\u00cf\u00b8\u0006\u0094\u0002\u0012\u0083\u00b6\u0000\n\u0013\u00d3\u0086\rS\u00f7\u0014w\u00ca\u00b1\u00f8\u001fw\u00e5\u007f\u0081\u0011\u00a6\u00b2\u00c2,\u00d5|\u00191z&+\u009a\u0004\u0000\u00d4\u00e0\u00bal\u0011\b\u00cfjL\u0097\u00aa\u00c6\u0006\u00be\u00b86M\u00ad\u00c4jqy0\u00de\u00a7\u00f7\u00a6\u0014\u009c\u0093\"A\u00c9\u00df\f\u00a8\u00ab\u00ce\u00a8p2\u00c15\u00b7\u00fe\u00dfD\u00b2\u001e\u00f9(kq?\u00db\u00e8\u0081.\u0019'oL\u009bvYF\\\u0085(\u00dd\u0098\u00bd\u0096>\u00b9\u00e7\u00b89\u00df\u00ec\u00cf\u00bd5\u00b8\u00d4\u00ab\u001f\u0093\u0013\u00d8\u00a7\u00bf\u00b5\u00c9]\u00f9\u00b0\u00d0q%o\u0092\u009bA\u00c4Wo\\}\u001e\u00f5\u008f6J\u0019Gk\u00a4\u00f6kOY\u00ab\u00f6\u00bb\u00dbQ\u00cc\u008e5\u007fk\u00cfK\u0011~\u00ffIc_\u0099\u0086\u00bb(9\u00e1\u00e6\u001cf_\u00a2\u00ad\u0004\u0087\u00f0W\u0014\u00bfs\u00b6QQC\u00cc\u00db*fv\u0087\u009c7\u00f6\u00ae##\u009cMp\u0098^\u00c0#Wm\u00c5\u0007gu\u0000\u001dy\u00a1l\u0000\u00d4\u00d7\u00b3\u00fdI\u0004w\u0015%\u00a2\u001by\u00e6!\u00ec\u00ea\u00d5\u00ab\u00f4\u009d=)N\u00c9\u00d9CH[\u00de\u00d7\u00f7Dz\u00e7~\u00b5p^Z\u00f5_y$\u00a5!\u00e3\u00b7),/\u001e\u00c6a\u00eeX\u00d2\u00cdV\u0089\u008c\u0016eg\u0000\u00a3\u0006mN\u00182#\u00b2\u001d\u00d1\u00a1j\u00ae\u00e6\u00f0P7\u00ceY\u00c0\u0001\u00ef\u00bc\u0003@\u0083\u00c2\u00e9\u00cc\u00e5\u00a6\u00d2\u00ba\u0085\f\u00db\u00b8U|".getBytes("ISO_8859_1");
        Object[] v1 = "\u00daZ\u00b7\u00feB!\bT".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1596307844;
                case 1 -> -364007049;
                case 2 -> 948399003;
                case 3 -> 1512417977;
                case 4 -> -1166904256;
                case 5 -> -291401834;
                case 6 -> -2081452805;
                case 7 -> -1066382216;
                case 8 -> 1250513379;
                case 9 -> 1117014785;
                case 10 -> -104154615;
                case 11 -> -1979829055;
                case 12 -> -1998659873;
                case 13 -> -1845902080;
                case 14 -> 2013105286;
                case 15 -> -1264600244;
                case 16 -> 1392111704;
                case 17 -> 691235181;
                case 18 -> -668862482;
                case 19 -> -408463084;
                case 20 -> 463551079;
                case 21 -> 1915064327;
                case 22 -> 46667039;
                case 23 -> -1275432357;
                case 24 -> 1137133220;
                case 25 -> 677929861;
                case 26 -> 927337271;
                case 27 -> 1720464800;
                case 28 -> -784787875;
                case 29 -> -1744566123;
                case 30 -> 1529183299;
                case 31 -> 916585014;
                case 32 -> 612697044;
                case 33 -> -1195372352;
                case 34 -> -1573895857;
                case 35 -> -984429904;
                case 36 -> 2027206581;
                case 37 -> -1039501619;
                case 38 -> -2113579871;
                case 39 -> -1767251183;
                case 40 -> 1758351205;
                case 41 -> -654661203;
                case 42 -> 1966746116;
                case 43 -> 1894674130;
                case 44 -> 1212020483;
                case 45 -> 1866036391;
                case 46 -> -778310316;
                case 47 -> -770653764;
                case 48 -> 1284152448;
                case 49 -> -2032225563;
                case 50 -> -697874392;
                case 51 -> 6279057;
                case 52 -> -2096267221;
                case 53 -> 1356998619;
                case 54 -> 25474828;
                case 55 -> -1733314872;
                case 56 -> -846346616;
                case 57 -> 30209562;
                case 58 -> -918382523;
                case 59 -> -79396845;
                case 60 -> 933122534;
                case 61 -> -2027061699;
                case 62 -> -1713018726;
                case 63 -> 409110410;
                case 64 -> 883785129;
                case 65 -> 1210554861;
                case 66 -> -1359355342;
                case 67 -> -6809015;
                case 68 -> -881093585;
                case 69 -> -661156567;
                case 70 -> 1188821454;
                case 71 -> 1072317861;
                case 72 -> -1985607473;
                case 73 -> -1864487784;
                case 74 -> 782294005;
                case 75 -> -985076545;
                case 76 -> -834484022;
                case 77 -> 684780178;
                case 78 -> -1665044267;
                case 79 -> -11761618;
                case 80 -> -1637330916;
                case 81 -> -1699683601;
                case 82 -> 1422267678;
                case 83 -> -259899094;
                case 84 -> -1355533591;
                case 85 -> -810015181;
                case 86 -> -1525975085;
                case 87 -> 1655781086;
                case 88 -> -1750384299;
                case 89 -> -1963145816;
                case 90 -> -1262237442;
                case 91 -> 500049675;
                case 92 -> 2129373363;
                case 93 -> 358438018;
                case 94 -> -86586229;
                case 95 -> 1124128999;
                case 96 -> -103122629;
                case 97 -> -1105000245;
                case 98 -> 2037800647;
                case 99 -> 359717089;
                case 100 -> -604265470;
                case 101 -> 71407120;
                case 102 -> 1432647715;
                case 103 -> -1379562543;
                case 104 -> 1253851976;
                case 105 -> 1541235277;
                case 106 -> -1639785575;
                case 107 -> -1650481447;
                case 108 -> -2040221786;
                case 109 -> -146487080;
                case 110 -> 504618384;
                case 111 -> 336621651;
                case 112 -> 1231611895;
                case 113 -> -1173259924;
                case 114 -> -57210449;
                case 115 -> -176849547;
                case 116 -> -618458336;
                case 117 -> -990694485;
                case 118 -> 379816410;
                case 119 -> -966411817;
                case 120 -> -1754444803;
                case 121 -> -1728749719;
                case 122 -> 1968014013;
                case 123 -> -1664683512;
                case 124 -> -1504910303;
                case 125 -> 774196916;
                case 126 -> 599976393;
                case 127 -> 1106329578;
                case 128 -> 1865605105;
                case 129 -> 194453391;
                case 130 -> 1084193730;
                case 131 -> -1355291058;
                case 132 -> 1333417196;
                case 133 -> 1109628695;
                case 134 -> 121553278;
                case 135 -> 1501933213;
                case 136 -> -1392059293;
                case 137 -> 1880710535;
                case 138 -> 1519283481;
                case 139 -> -1019955588;
                case 140 -> 1634885571;
                case 141 -> -1094682708;
                case 142 -> 877818268;
                case 143 -> 1395145532;
                case 144 -> 22729570;
                case 145 -> 859240752;
                case 146 -> 351241312;
                case 147 -> -273614852;
                case 148 -> -749356048;
                case 149 -> 253375010;
                case 150 -> -270001956;
                case 151 -> -1456804802;
                case 152 -> -1676113533;
                case 153 -> 987748125;
                case 154 -> 327344861;
                case 155 -> 1439551353;
                case 156 -> 1187127667;
                case 157 -> 1878455244;
                case 158 -> -1647216588;
                case 159 -> 1008169260;
                case 160 -> 35859058;
                case 161 -> -1140808895;
                case 162 -> 1505800618;
                case 163 -> 1305070513;
                case 164 -> -1549277205;
                case 165 -> -320022448;
                case 166 -> 1933817314;
                case 167 -> 1760333520;
                case 168 -> 123716623;
                case 169 -> -272125683;
                case 170 -> -1656355051;
                case 171 -> 551312326;
                case 172 -> 399237023;
                case 173 -> 1573396164;
                case 174 -> -970990265;
                case 175 -> -1519381894;
                case 176 -> 417273912;
                case 177 -> -1795626401;
                case 178 -> -1022650305;
                case 179 -> 199149829;
                case 180 -> -2060479125;
                case 181 -> 1205948799;
                case 182 -> -674086808;
                case 183 -> -90742703;
                case 184 -> 469939297;
                case 185 -> 1780663991;
                case 186 -> 1221605539;
                case 187 -> 551865931;
                case 188 -> -673590854;
                case 189 -> -1957326505;
                case 190 -> 1238540824;
                case 191 -> -213350543;
                case 192 -> 683108607;
                case 193 -> -708420713;
                case 194 -> 1600204214;
                case 195 -> -2144947862;
                case 196 -> -1866895315;
                case 197 -> 273868886;
                case 198 -> 1628385113;
                case 199 -> 1542843539;
                case 200 -> 1310654100;
                case 201 -> -1044088510;
                case 202 -> -1515564146;
                case 203 -> 1256126944;
                case 204 -> 278694011;
                case 205 -> 1022013172;
                case 206 -> -590592676;
                case 207 -> 2111209521;
                case 208 -> 1648578429;
                case 209 -> 1201788260;
                case 210 -> -944239202;
                case 211 -> -1526878533;
                case 212 -> -747249650;
                case 213 -> -669253898;
                case 214 -> 1824724298;
                case 215 -> 1455196812;
                case 216 -> -1767072987;
                case 217 -> 729040802;
                case 218 -> -1072363032;
                case 219 -> 349381650;
                case 220 -> -647317692;
                case 221 -> 587741010;
                case 222 -> -1047984206;
                case 223 -> -1395851080;
                case 224 -> 754269278;
                case 225 -> 1267406533;
                case 226 -> 489542017;
                case 227 -> -1844157190;
                case 228 -> -261956878;
                case 229 -> 1568905208;
                case 230 -> -913704890;
                case 231 -> -1013354439;
                case 232 -> 800367413;
                case 233 -> 455365668;
                case 234 -> 2007248698;
                case 235 -> -1613031466;
                case 236 -> 1846872548;
                case 237 -> -1619797898;
                case 238 -> -333495303;
                case 239 -> -430017446;
                case 240 -> -2057591257;
                case 241 -> -155104338;
                case 242 -> 968646154;
                case 243 -> -545061605;
                case 244 -> 801747055;
                case 245 -> -324080530;
                case 246 -> -74605802;
                case 247 -> -244792589;
                case 248 -> 198975526;
                case 249 -> -1595147330;
                case 250 -> -212988535;
                case 251 -> -1534645363;
                case 252 -> 1649273862;
                case 253 -> -1387545754;
                case 254 -> 636729716;
                case 255 -> -2099069584;
                default -> -1388978624;
            });
        } while (v2 != 400);
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
            Object[] objectArray = new Object[25];
            v1 = objectArray;
            oII = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        Oo0 = 34.0f;
        OoO = 0.86f;
        O0i = 145L;
        ConfigSupport_O0I = 135L;
        O0o = 145L;
        EventBusApi = 165L;
        HudElement = 175L;
        OOi = 135L;
        GuiSupport_OOI = 170L;
        OOo = 0.999f;
        HelpCommand = 0.5f;
    }

    void O0o(Runnable param1) {
        RenderSupport_00oi_0.HudElement(param1);
    }

    GuiSupport_oii_5 WatermarkHudElement() {
        return this.KeystrokesHudElement;
    }

    float oOO(float param1, float param2, float param3) {
        return Math.max(param2, Math.min(param3, param1));
    }

    float ConfigSupport_oi0_2(FontRenderer param1, String param2) {
        return (float)param1.GuiSupport_OOI(param2) * 0.5f;
    }

    private Setting i0I(Setting param1) {
        return param1;
    }

    boolean Oio(Module param1) {
        return this.Oii == param1;
    }

    float Oii(Module param1) {
        Boolean v2 = (Boolean)this.DataRecord_0io_2.get(param1);
        Long v3 = (Long)this.ChestStealerModule.get(param1);
        if (v2 == null || v3 == null) {
            return this.Oio(param1) ? 1.0f : 0.0f;
        }
        float v4 = this.oOO((float)(System.currentTimeMillis() - v3) / 165.0f, 0.0f, 1.0f);
        if (v4 >= 1.0f) {
            this.ChestStealerModule.remove(param1);
            this.DataRecord_0io_2.remove(param1);
            return v2 != false ? 1.0f : 0.0f;
        }
        float v5 = this.RenderSupport_ooo_0(v4);
        return v2 != false ? v5 : 1.0f - v5;
    }

    String oi0(Setting param1) {
        return this.RenderSupport_oio_2((Number)param1.HelpCommand()) + param1.StorageEspModule();
    }

    boolean ConfigSupport_00o_0(Setting param1) {
        return param1 == this.AutoMlgModule || this.StorageEspModule(param1) > 0.0f;
    }

    public void HelpCommand() {
        RenderSupport_OIIO.PacketEvent();
        this.GuiSupport_OOI(RenderSupport_OIIO.ConfigSupport_0II, "Clap Client");
        this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, "Configuration");
        this.GuiSupport_OOI(RenderSupport_OIIO.DataRecord_0io_2, "Search modules");
        this.GuiSupport_OOI(RenderSupport_OIIO.DataRecord_0io_2, "Config name");
        for (EnumType_OIO0 v4 : EnumType_OIO0.values()) {
            this.GuiSupport_OOI(RenderSupport_OIIO.DataRecord_0io_2, v4.WatermarkHudElement);
            if (v4.IiI == null) continue;
            ArrayList<Module> v5 = new ArrayList<Module>(0ooo.OiI().oooo(v4.IiI));
            v5.removeIf(param0 -> param0.0iI0 || param0.Io00() == ModuleCategory.ioi);
            v5.sort(Comparator.comparing(Module::IoOO, String.CASE_INSENSITIVE_ORDER));
            for (Module v7 : v5) {
                this.OOo(v7);
            }
        }
        for (String v2 : 0ooo.Oii().O0o()) {
            this.GuiSupport_OOI(RenderSupport_OIIO.KeepSprintModule, v2);
        }
    }

    String RenderSupport_oio_2(Number param1) {
        if (param1 instanceof Integer) {
            return Integer.toString(param1.intValue());
        }
        return String.format(Locale.ROOT, "%.2f", param1.doubleValue());
    }

    private void DataRecord_0O0() {
        this.ooi = System.currentTimeMillis();
    }

    private Setting ioo(Setting param1) {
        return param1;
    }

    public boolean method_25401(double param1, double param3, double param5, double param7) {
        if (this.NetworkSupport_o0o_0()) {
            return true;
        }
        if (this.oOi.0iI(param1, param3)) {
            this.oOo = this.oOO(this.oOo + (float)(-param7 * 28.0), 0.0f, this.RenderSupport_ooi_1);
            return true;
        }
        return super.method_25401(param1, param3, param5, param7);
    }

    List IOi() {
        return this.RenderSupport_oii_4;
    }

    double KeepSprintModule() {
        return this.field_22787 == null ? 0.0 : this.field_22787.mouse.getY() / (double)this.field_22787.getWindow().getScaleFactor();
    }

    List 0Io(Module param1) {
        ArrayList<Setting> v2 = new ArrayList<Setting>();
        for (Setting v4 : param1.ioIO()) {
            if (!v4.0oO() || "Enabled".equalsIgnoreCase(v4.PacketEvent()) || v4.HelpCommand() instanceof EnumType_0OI) continue;
            v2.add(v4);
        }
        return v2;
    }

    List IOo() {
        return this.OIo;
    }

    Setting Ii0() {
        return this.0oI;
    }

    private void oOi() {
        if (this.field_22787 == null) {
            return;
        }
        this.oIo = true;
        this.field_22787.setScreen(null);
    }

    private boolean 0Oo() {
        return this.ooi != Long.MIN_VALUE && System.currentTimeMillis() - this.ooi < 175L;
    }

    private void FastWebModule() {
        this.ooI = System.currentTimeMillis();
        this.oIO = false;
        this.ConfigSupport_oi0_2 = false;
        this.oIo = false;
    }

    void oio() {
        if (this.field_22787 != null) {
            this.field_22787.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((RegistryEntry)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
        }
    }

    EnumType_OIO0 I0o() {
        return this.Oio;
    }

    private ClickGuiScreen() {
        super((Text)Text.literal((String)"clap-clickgui"));
        this.Ooi = new GuiSupport_oii0_2();
        this.KeystrokesHudElement = new GuiSupport_oii_5();
        this.ConfigSupport_OI0 = new GuiSupport_oooi_1();
        this.OIo = new ArrayList();
        this.ConfigSupport_OII = new ArrayList();
        this.RenderSupport_oii_4 = new ArrayList();
        this.OiO = new ArrayList();
        this.Oi0 = new ArrayList();
        this.Oio = EnumType_OIO0.ItemTagsModule;
        this.Kernel32SnapshotApi = Long.MIN_VALUE;
        this.ConfigSupport_00o_0 = DataRecord_OO0O.OOoO();
        this.0Io = EnumType_oio0_0.iOI;
        this.ConfigSupport_0II = new IdentityHashMap();
        this.ChestStealerModule = new IdentityHashMap();
        this.DataRecord_0io_2 = new IdentityHashMap();
        this.KeepSprintModule = new IdentityHashMap();
        this.0io = new IdentityHashMap();
        this.0iI = new IdentityHashMap();
        this.0ii = new IdentityHashMap();
        this.oOO = new IdentityHashMap();
        this.FastWebModule = new IdentityHashMap();
        this.oOi = DataRecord_OO0O.OOoO();
        this.o0O = DataRecord_OO0O.OOoO();
        this.o00 = DataRecord_OO0O.OOoO();
        this.SettingContainer = DataRecord_OO0O.OOoO();
        this.RenderSupport_ooo_0 = DataRecord_OO0O.OOoO();
        this.oo0 = DataRecord_OO0O.OOoO();
        this.ooo = DataRecord_OO0O.OOoO();
        this.ooi = Long.MIN_VALUE;
    }

    private void RenderSupport_ooi_1() {
        if (this.ConfigSupport_oi0_2) {
            return;
        }
        this.o0O();
        this.ooI = System.currentTimeMillis();
        this.ConfigSupport_oi0_2 = true;
    }

    String oiI() {
        String v1 = ConfigSupport_oii0_1.HudElement();
        if (v1 != null && !v1.isBlank()) {
            return v1;
        }
        return "UserName";
    }

    Setting GuiSupport_III() {
        return this.DataRecord_00I;
    }

    private DataRecord_OO0O Ooo(DataRecord_OO0O param1, float param2, float param3) {
        return new DataRecord_OO0O(param1.0ii() - param2, param1.oOO() - param3, param1.FastWebModule() + param2 * 2.0f, param1.oOo() + param3 * 2.0f);
    }

    void iOo(float param1) {
        this.oOo = param1;
    }

    String Iio() {
        return this.0oi;
    }

    private void 0oi(Module param1) {
        this.0iI.put(param1, System.currentTimeMillis());
        this.0ii.put(param1, param1.IoOo());
    }

    private void GuiSupport_OOI(FontRenderer param1, String param2) {
        if (param2 == null || param2.isEmpty()) {
            return;
        }
        param1.OOi();
        param1.GuiSupport_OOI(param2);
    }

    public void method_25394(DrawContext param1, int param2, int param3, float param4) {
        if (this.ConfigSupport_oi0_2 && this.o00() >= 135L) {
            this.oOi();
            return;
        }
        RenderSupport_oooo_2.begin("CLAP_CLICKGUI");
        try {
            this.OOi(param1, param2, param3);
            return;
        }
        finally {
            RenderSupport_oooo_2.end("CLAP_CLICKGUI");
        }
    }

    void Oi0(Module param1) {
        if (this.Oii == param1) {
            this.Kernel32SnapshotApi(param1, false);
            this.Oii = null;
            this.0o0();
            this.0oO();
        } else {
            if (this.Oii != null) {
                this.Kernel32SnapshotApi(this.Oii, false);
            }
            this.Oii = param1;
            this.Kernel32SnapshotApi(param1, true);
            this.0oO();
        }
    }

    private Setting io0(Setting param1) {
        if (param1.Oo0() == null) {
            return null;
        }
        for (Setting v3 : param1.Oo0().ioIO()) {
            if (!(v3.HelpCommand() instanceof EnumType_0OI) || !"BindMode".equalsIgnoreCase(v3.PacketEvent())) continue;
            return v3;
        }
        return null;
    }

    List EnumType_I00() {
        return this.Oi0;
    }

    void OoI(int param1) {
        if (this.0o0 == null || this.SpawnerFinderModule == null) {
            return;
        }
        float v2 = this.oOO(((float)param1 - this.SpawnerFinderModule.0ii()) / this.SpawnerFinderModule.FastWebModule(), 0.0f, 1.0f);
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

    void iOi(DataRecord_OO0O param1) {
        this.oOi = param1;
    }

    Setting IiO() {
        return this.0oO;
    }

    boolean Setting() {
        return this.0Io != EnumType_oio0_0.iOI;
    }

    Module IrcCommand() {
        return this.OiI;
    }

    float StorageEspModule(Setting param1) {
        Boolean v2 = (Boolean)this.0io.get(param1);
        Long v3 = (Long)this.KeepSprintModule.get(param1);
        if (v2 == null || v3 == null) {
            return param1 == this.AutoMlgModule || param1 == this.RenderSupport_0I0 ? 1.0f : 0.0f;
        }
        float v4 = this.oOO((float)(System.currentTimeMillis() - v3) / 145.0f, 0.0f, 1.0f);
        if (v4 >= 1.0f) {
            this.KeepSprintModule.remove(param1);
            this.0io.remove(param1);
            return v2 != false ? 1.0f : 0.0f;
        }
        float v5 = this.RenderSupport_ooo_0(v4);
        return v2 != false ? v5 : 1.0f - v5;
    }

    void ConfigSupport_O0I(DrawContext param1, DataRecord_OO0O param2, Runnable param3) {
        if (param2 == null) {
            this.O0o(param3);
            return;
        }
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

    private Setting ioO(Setting param1) {
        return param1;
    }

    float ConfigSupport_0OO() {
        if (this.ooi == Long.MIN_VALUE) {
            return 0.0f;
        }
        float v1 = this.oOO((float)(System.currentTimeMillis() - this.ooi) / 175.0f, 0.0f, 1.0f);
        if (v1 >= 1.0f) {
            this.ooi = Long.MIN_VALUE;
            return 0.0f;
        }
        return -34.0f * (1.0f - this.RenderSupport_ooo_0(v1));
    }
}

