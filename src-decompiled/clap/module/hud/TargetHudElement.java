/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.MathHelper
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import clap.gui.screen.HudEditorScreen;
import clap.network.NetworkSupport_00OI;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.model.DataRecord_000i_0;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.model.EnumType_0ooi_2;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.render.ScaledDrawContext;
import clap.gui.screen.HudEditorScreenV2;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.iOo
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class TargetHudElement
extends HudElement {
    private static final int 00Oi;
    public Setting BindCommand = this.OOi0i("Mode", EnumType_0ooi_2.SprintResetModule);
    private float ConfigSupport_00I0;
    private static final int RenderSupport_000I;
    private static final int NetworkSupport_00OI;
    private static final int 000o;
    private static final int 000i;
    public Setting 00oo;
    private static final int NetworkSupport_000O;
    private float 00Io;
    private static final int EnumType_0000;
    private float HudEditorScreen;
    public Setting 00o0 = this.OOi00("KeepTarget", true);
    private static final float 00i;
    private long 00oi;
    private LivingEntity IrcModule;
    static Object TranslateCommand;
    private static volatile /* synthetic */ long __k__gH4it;

    private int o0Ii(FontRenderer param1, FontRenderer param2, boolean param3, String param4) {
        return (param3 ? param1 : param2).GuiSupport_OOI(param4);
    }

    private void oIIi(ScaledDrawContext param1, FontRenderer param2, FontRenderer param3, boolean param4, String param5, float param6, float param7, int param8) {
        FontRenderer v9 = param4 ? param2 : param3;
        v9.PacketEvent(param1.ConfigSupport_O0I(), param5, param6, param7, param8);
    }

    private int oI0i(LivingEntity param1) {
        PlayerEntity v2;
        block3: {
            block2: {
                if (!(param1 instanceof PlayerEntity)) break block2;
                v2 = (PlayerEntity)param1;
                if (ConfigSupport_OI0.getNetworkHandler() != null) break block3;
            }
            return 0;
        }
        PlayerListEntry v3 = ConfigSupport_OI0.getNetworkHandler().getPlayerListEntry(v2.method_5667());
        return v3 == null ? 0 : v3.getLatency();
    }

    private void oIOI(ScaledDrawContext param1, LivingEntity param2, DataRecord_000i_0 param3, boolean param4) {
        float v5 = this.GuiSupport_OOI();
        float v6 = this.OOi();
        float v7 = this.OIo();
        float v8 = this.RenderSupport_oii_4(140);
        float v9 = this.RenderSupport_oii_4(36);
        int v10 = this.oIIO(this.oIoI(this.ConfigSupport_00I0), this.HudEditorScreen);
        if (this.oIIo()) {
            GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v5 + (float)this.RenderSupport_oii_4(1), v6 + (float)this.RenderSupport_oii_4(1), v5 + v8 + (float)this.RenderSupport_oii_4(1), v6 + v9 + (float)this.RenderSupport_oii_4(1), this.oII0(this.oIIO(0x55000000, this.HudEditorScreen)));
            GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v5, v6, v5 + v8, v6 + v9, this.oII0(this.oIIO(-603190259, this.HudEditorScreen)));
        }
        GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v5, v6, v5 + (float)this.RenderSupport_oii_4(3), v6 + v9, v10);
        int v11 = this.RenderSupport_oii_4(24);
        int v12 = Math.round(v5 + (float)this.RenderSupport_oii_4(7));
        int v13 = Math.round(v6 + (float)this.RenderSupport_oii_4(6));
        this.oIoO(param1, param2, param4, v12, v13, v11);
        float v14 = 0.5f * v7;
        FontRenderer v15 = clap.network.NetworkSupport_00OI.HudElement(18);
        FontRenderer v16 = clap.network.NetworkSupport_00OI.EventBusApi(18);
        float v17 = v5 + (float)this.RenderSupport_oii_4(38);
        float v18 = v6 + (float)this.RenderSupport_oii_4(5);
        float v19 = v6 + (float)this.RenderSupport_oii_4(15);
        String v20 = String.format("%.1f", Float.valueOf(param3.OI0i()));
        String v21 = String.format("%.0fm | %dms", Float.valueOf(param3.OIo0()), param3.OIoo());
        int v22 = Math.round((float)v15.GuiSupport_OOI(v20) * v14);
        int v23 = Math.round((float)v15.GuiSupport_OOI("HP") * v14);
        float v24 = v5 + v8 - (float)this.RenderSupport_oii_4(6) - (float)v22 - (float)v23 - (float)this.RenderSupport_oii_4(3);
        RenderSupport_00oi_0.HudElement(() -> {
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(v14, v14);
            this.oIII(param1, v15, v16, param3.HelpCommand(), v17 / v14, v18 / v14, this.oIIO(-1, this.HudEditorScreen));
            this.oIII(param1, v15, v16, "HP", v24 / v14, v18 / v14, this.oIIO(-42149, this.HudEditorScreen));
            this.oIII(param1, v15, v16, v20, (v24 + (float)v23 + (float)this.RenderSupport_oii_4(3)) / v14, v18 / v14, this.oIIO(-1, this.HudEditorScreen));
            this.oIII(param1, v15, v16, v21, v17 / v14, v19 / v14, this.oIIO(-3618616, this.HudEditorScreen));
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
        });
        float v26 = v6 + v9 - (float)this.RenderSupport_oii_4(10);
        float v27 = v5 + v8 - (float)this.RenderSupport_oii_4(7) - v17;
        float v28 = this.RenderSupport_oii_4(6);
        GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v17, v26, v17 + v27, v26 + v28, this.oIIO(-601348053, this.HudEditorScreen));
        GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v17, v26, v17 + v27 * this.00Io, v26 + v28, this.oIIO(-2099495876, this.HudEditorScreen));
        GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v17, v26, v17 + v27 * this.ConfigSupport_00I0, v26 + v28, v10);
        int v29 = this.oIIO(0x46000000, this.HudEditorScreen);
        for (int v30 = 1; v30 < 10; ++v30) {
            float v31 = v17 + v27 / 10.0f * (float)v30;
            GuiSupport_oi0o_0.OOoiO(param1.ConfigSupport_O0I(), v31, v26, v31 + (float)this.RenderSupport_oii_4(1), v26 + v28, v29);
        }
        this.Oii(v5, v6, v8, v9);
    }

    private boolean oIo0() {
        return TargetHudElement.ConfigSupport_OI0.currentScreen instanceof HudEditorScreen || TargetHudElement.ConfigSupport_OI0.currentScreen instanceof HudEditorScreenV2;
    }

    private boolean oIIo() {
        return (Integer)this.00oo.HelpCommand() > 0;
    }

    private int oIoI(float param1) {
        float v2 = MathHelper.clamp((float)param1, (float)0.0f, (float)1.0f) * 0.33f;
        return 0xFF000000 | Color.HSBtoRGB(v2, 0.85f, 1.0f) & 0xFFFFFF;
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

    private void oIOi(ScaledDrawContext param1, LivingEntity param2, DataRecord_000i_0 param3, boolean param4) {
        float v5 = this.GuiSupport_OOI();
        float v6 = this.OOi();
        float v7 = this.OIo();
        float v8 = this.RenderSupport_oii_4(150);
        float v9 = this.RenderSupport_oii_4(42);
        int v10 = this.RenderSupport_oii_4(8);
        int v11 = this.oIIO(this.oIoI(this.ConfigSupport_00I0), this.HudEditorScreen);
        if (this.oIIo()) {
            PostProcessingModule.IoiO(v5, v6, v8, v9, v10, this.oII0(this.oIIO(-1272962264, this.HudEditorScreen)));
            float v12 = this.RenderSupport_oii_4(1);
            RenderSupport_00oi_0.O0o(v5 + v12, v6 + v12, v8 - v12 * 2.0f, v9 - v12 * 2.0f, Math.max(1.0f, (float)v10 - v12), this.oII0(this.oIIO(437656095, this.HudEditorScreen)));
        }
        int v12 = this.RenderSupport_oii_4(28);
        int v13 = Math.round(v5 + (float)this.RenderSupport_oii_4(8));
        int v14 = Math.round(v6 + (float)this.RenderSupport_oii_4(7));
        this.oIoO(param1, param2, param4, v13, v14, v12);
        float v15 = 0.5f * v7;
        FontRenderer v16 = clap.network.NetworkSupport_00OI.HudElement(20);
        FontRenderer v17 = clap.network.NetworkSupport_00OI.HudElement(16);
        FontRenderer v18 = clap.network.NetworkSupport_00OI.EventBusApi(20);
        FontRenderer v19 = clap.network.NetworkSupport_00OI.EventBusApi(16);
        float v20 = v5 + (float)this.RenderSupport_oii_4(43);
        float v21 = v6 + (float)this.RenderSupport_oii_4(6);
        float v22 = v6 + (float)this.RenderSupport_oii_4(18);
        String v23 = Integer.toString(this.oIoi(param3.OI0i()));
        String v24 = "\u2764";
        String v25 = String.format("   %.0fm", Float.valueOf(param3.OIo0()));
        RenderSupport_00oi_0.HudElement(() -> {
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(v15, v15);
            this.oIII(param1, v16, v18, param3.HelpCommand(), v20 / v15, v21 / v15, this.oIIO(-1, this.HudEditorScreen));
            float v14 = v20 / v15;
            float v15 = v22 / v15;
            this.oIII(param1, v17, v19, v23, v14, v15, this.oIIO(-1, this.HudEditorScreen));
            this.oIII(param1, v17, v19, " " + v24, v14 += (float)this.o0iO(v17, v19, v23), v15, this.oIIO(-42149, this.HudEditorScreen));
            this.oIII(param1, v17, v19, v25, v14 += (float)this.o0iO(v17, v19, " " + v24), v15, this.oIIO(-1076370448, this.HudEditorScreen));
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
        });
        float v27 = v6 + v9 - (float)this.RenderSupport_oii_4(10);
        float v28 = v5 + v8 - (float)this.RenderSupport_oii_4(10) - v20;
        float v29 = this.RenderSupport_oii_4(5);
        RenderSupport_00oi_0.O0o(v20, v27, v28, v29, v29 * 0.5f, this.oIIO(1715554384, this.HudEditorScreen));
        RenderSupport_00oi_0.O0o(v20, v27, v28 * this.00Io, v29, v29 * 0.5f, this.oIIO(1894822979, this.HudEditorScreen));
        RenderSupport_00oi_0.O0o(v20, v27, v28 * this.ConfigSupport_00I0, v29, v29 * 0.5f, v11);
        this.Oii(v5, v6, v8, v9);
    }

    private int oIIO(int param1, float param2) {
        int v3 = param1 >>> 24 & 0xFF;
        int v4 = MathHelper.clamp((int)Math.round((float)v3 * MathHelper.clamp((float)param2, (float)0.0f, (float)1.0f)), (int)0, (int)255);
        return v4 << 24 | param1 & 0xFFFFFF;
    }

    private boolean o0Io(FontRenderer param1, char param2) {
        return param2 == ' ' || param1.HudElement(param2);
    }

    private LivingEntity oI00() {
        if (this.IrcModule == null || !this.oI0o(this.IrcModule)) {
            this.IrcModule = null;
            return null;
        }
        return this.IrcModule;
    }

    private void oIoO(ScaledDrawContext param1, LivingEntity param2, boolean param3, int param4, int param5, int param6) {
        if (!param3 && param2 instanceof AbstractClientPlayerEntity) {
            AbstractClientPlayerEntity v7 = (AbstractClientPlayerEntity)param2;
            Identifier v8 = v7.method_52814().body().texturePath();
            param1.ConfigSupport_O0I().drawTexture(RenderPipelines.GUI_TEXTURED, v8, param4, param5, 8.0f, 8.0f, param6, param6, 8, 8, 64, 64);
            param1.ConfigSupport_O0I().drawTexture(RenderPipelines.GUI_TEXTURED, v8, param4, param5, 40.0f, 8.0f, param6, param6, 8, 8, 64, 64);
            return;
        }
        int v7 = Math.max(2, param6 / 6);
        GuiSupport_oi0o_0.OOoiI(param1.ConfigSupport_O0I(), param4, param5, param6, param6, Math.max(1, param6 / 5), this.oIIO(1076243249, this.HudEditorScreen));
        GuiSupport_oi0o_0.OOoiI(param1.ConfigSupport_O0I(), param4 + v7, param5 + v7, param6 - v7 * 2, param6 - v7 * 2, Math.max(1, param6 / 6), this.oIIO(1656275660, this.HudEditorScreen));
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        LivingEntity v5;
        super.O0i(param1);
        if (TargetHudElement.iooI()) {
            return;
        }
        boolean v2 = this.oIo0();
        LivingEntity v3 = this.oI0O();
        boolean v4 = v3 != null;
        this.HudEditorScreen = this.oIoo(this.HudEditorScreen, v2 || v4 ? 1.0f : 0.0f, 0.22f);
        if (this.HudEditorScreen < 0.03f) {
            this.Oii(this.GuiSupport_OOI(), this.OOi(), 0.0f, 0.0f);
            return;
        }
        Object object = v4 ? v3 : (v5 = v2 ? TargetHudElement.ConfigSupport_OI0.player : this.oI00());
        if (v5 == null) {
            return;
        }
        DataRecord_000i_0 v6 = this.oI0I(v5, v2);
        this.ConfigSupport_00I0 = this.oIoo(this.ConfigSupport_00I0, v6.OIoO(), 0.18f);
        this.00Io = this.00Io < this.ConfigSupport_00I0 ? this.ConfigSupport_00I0 : this.oIoo(this.00Io, this.ConfigSupport_00I0, 0.06f);
        if (this.BindCommand.HelpCommand() == EnumType_0ooi_2.SprintResetModule) {
            this.oIOI(param1, v5, v6, v2);
        } else {
            this.oIOi(param1, v5, v6, v2);
        }
    }

    private LivingEntity oI0O() {
        LivingEntity v3;
        EntityHitResult v2;
        if (TargetHudElement.ConfigSupport_OI0.world == null || TargetHudElement.ConfigSupport_OI0.player == null) {
            return null;
        }
        HitResult v1 = TargetHudElement.ConfigSupport_OI0.crosshairTarget;
        if (v1 instanceof EntityHitResult && (v1 = (v2 = (EntityHitResult)v1).getEntity()) instanceof LivingEntity && (v3 = (LivingEntity)v1) != TargetHudElement.ConfigSupport_OI0.player && v3.method_5805() && !v3.method_31481()) {
            this.IrcModule = v3;
            this.00oi = System.currentTimeMillis();
            return v3;
        }
        if (!((Boolean)this.00o0.HelpCommand()).booleanValue() || this.IrcModule == null) {
            return null;
        }
        if (!this.oI0o(this.IrcModule)) {
            this.IrcModule = null;
            return null;
        }
        return this.IrcModule;
    }

    private int oIoi(float param1) {
        if (param1 <= 0.0f) {
            return 0;
        }
        return Math.max(1, (int)Math.ceil(param1));
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        if (TargetHudElement.iooI()) {
            return;
        }
        boolean v2 = this.oIo0();
        LivingEntity v3 = this.oI0O();
        if (!v2 && v3 == null && this.HudEditorScreen < 0.03f) {
            return;
        }
        float v4 = this.GuiSupport_OOI();
        float v5 = this.OOi();
        if (this.BindCommand.HelpCommand() == EnumType_0ooi_2.SprintResetModule) {
            PostProcessingModule.Ioio(v4, v5, this.RenderSupport_oii_4(140), this.RenderSupport_oii_4(36), this.ConfigSupport_OII(2.0f));
        } else {
            PostProcessingModule.Ioio(v4, v5, this.RenderSupport_oii_4(150), this.RenderSupport_oii_4(42), this.ConfigSupport_OII(8.0f));
        }
    }

    private boolean oI0o(LivingEntity param1) {
        if (TargetHudElement.ConfigSupport_OI0.player == null || param1 == null) {
            return false;
        }
        boolean v2 = System.currentTimeMillis() - this.00oi <= 1000L;
        boolean v3 = param1.method_5805() && !param1.method_31481();
        boolean v4 = TargetHudElement.ConfigSupport_OI0.player.method_5739((Entity)param1) <= 20.0f;
        return v2 && v3 && v4;
    }

    public TargetHudElement() {
        super("TargetHUD", "Display current target health", 140.0f, 36.0f);
        this.00oo = this.OOi0o("BackgroundDepth", 100, 0, 100).ConfigSupport_00o_0("%");
    }

    private DataRecord_000i_0 oI0I(LivingEntity param1, boolean param2) {
        String v3 = param2 ? "Target" : param1.method_5477().getString();
        float v4 = param2 ? 17.0f : 0ooo.i0i().iOOO(param1);
        float v5 = param2 ? 20.0f : Math.max(param1.getMaxHealth() + param1.getAbsorptionAmount(), v4);
        float v6 = v5 <= 0.001f ? 0.0f : MathHelper.clamp((float)(v4 / v5), (float)0.0f, (float)1.0f);
        float v7 = param2 || TargetHudElement.ConfigSupport_OI0.player == null ? 6.2f : TargetHudElement.ConfigSupport_OI0.player.method_5739((Entity)param1);
        int v8 = param2 ? 42 : this.oI0i(param1);
        return new DataRecord_000i_0(v3, v4, v6, v7, v8);
    }

    private void oIII(ScaledDrawContext param1, FontRenderer param2, FontRenderer param3, String param4, float param5, float param6, int param7) {
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
                this.oIIi(param1, param2, param3, v10, v14, v8, param6, param7);
                v8 += (float)this.o0Ii(param2, param3, v10, v14);
                v9.setLength(0);
                v10 = v13;
            }
            v9.append(v12);
        }
        if (!v9.isEmpty()) {
            this.oIIi(param1, param2, param3, v10, v9.toString(), v8, param6, param7);
        }
    }

    private int oII0(int param1) {
        float v2 = (float)((Integer)this.00oo.HelpCommand()).intValue() / 100.0f;
        int v3 = param1 >>> 24 & 0xFF;
        int v4 = MathHelper.clamp((int)Math.round((float)v3 * v2), (int)0, (int)255);
        return v4 << 24 | param1 & 0xFFFFFF;
    }

    static {
        __k__gH4it = TargetHudElement.__k__gH4it(-3354432655381762543L);
        __rP__gH4it0 = new String[]{"\u9bf2\u32a1\ued3f\ub8e3\u3ffb\ua49e\u8c24\uef07\u9afe\u33b7\uec37\ub997\u3e85\ubb84\u930e\uf044\u85c2\u2c9d\uf312\ua6db", "\u9bf4\u32bf\ued3c\ub8ee\u3fbb\ua51a\u8c60", "\u9bf1\u325e\ued04\ub893\u3fb2"};
        __rP__gH4it1 = new String[]{"\u9be4\u32b3\ued2d"};
        __rP__gH4it2 = new String[]{"\u9b10\u3205\uece4\ub9e1\u3ed9\ua439\u8c65\uefcf\u9a68\u3313\uec6d\ua6a2\u219e\ubb1d\u93f7\uf0cc\u8500\u2c21\uf3fa\ua72e\u2058\ubade\u92d2\uf1c8\u8420\u2ddf\uf259\ua453\u2317\ub994\u91a9\uf29e\u8730\u2e1d\uf1a8\ua49f\u22de\ub8b6\u9006\uf305\u86ad\u2f03\uf031\ua56e\u252c\ubfa4\u97ae\uf444\u8185\u2833\uf790\ua2e3\u248d\ube6b\u96fc\uf5de\u8014\u295f\uf62e\ua35f\u2752\ubd1d\u95fb\uf60e\u83a1\u2a6d\uf571\ua02f\u27e4\ubc11\u9447\uf7da\u8275\u2b13\uf479\ua1df\u26a9\ub30a\u9bb7\uf8cb\u8dcc\u241f\ufbfd\uaed6\u2977\ub2cd\u9a7f\uf9e0\u8cae\u2535\ufa8c\uaff3\u2858\ub108\u9920\ufa52\u8f10\u2612\uf924\uacc2\u2bee\ub167\u98c8\ufbba\u8e09\u277a\uf801\uad93\u2a60\ub023\u9ff0\ufc2f\u899d\u200e\uff57\uaa19\u2d09\ub742\u9eda\ufd11\u8810\u21c7\ufe7f\uab1f\u2c1e\ub60c\u9d07\ufeda\u8b2a\u2260\ufdec\ua83e\u2fe7\ub537\u9d71\uffdb\u8ab7\u23d1\ufc02\ua91c\u2ee4\ub47f\u9cba\u00e0\u754f\udc01\u0371\u5625\ud196\u4b5e\u6399\u012d\u74a1\uddb5\u02fd\u575e\ud039\u4ae0\u6244\u028f", "\u9be4\u32ae\ued34\ub89a\u3f8b\ua4ed\u8c5d\uef18\u9afa\u33c4", "\u9b9d\u32e1\ued0c\ub8b6\u3f79\ua4f8\u8ce0\uef26"};
        __rP__gH4it3 = new String[]{"\u9be6\u32ac\ued3a\ub894\u3f89\ua4ef\u8c5b\uef1e\u9af8\u33c6"};
        byte[] v0 = "\u0016\u00918\u00fd\u00b1\u00b5R7\u0016\u00bfI\u00b6\u00fe\u0099\u00c8<v\u0085\u00d6\" B\u00f5 NcmWg\u0000\u0086~V\u00a9\u0094c\u0096Z\u0011\u001d\u00f3\u00cf5\u009al@\u00b1T\u00d3\u00f7\u009c\u000f\u00d5\u0097\u00fb\u00d6Z\u0083:\u00bb\u0002\u00e9\u00f4\u000e\u00e7\u00b9m\u00f3L\u00dd0\u00e2\u00cb\u00ff\u001d\u000b\t\u00ce\u00c8\u00fbz\u00fb\u0091\u001a\u00cf\u0011\u0018\u00c8\u0000\u00c9\u00f87\u00e8\u00dcOr\u00b6\u00e6X~fK\u009f\u00e2\u0097vE'\u00e0\u0007\u00af\u007f\u000b\n\u001b\u00b5\u0091~\u009dY\u009e\u00db+\u00bb\u008e8H\u009a\u00act\u00b0\u00a2\u000f;\u00c6\u00a3I\u00fd\u00a6\u0088\u0004{\u0005\u0090\u00b9%\u00dd\u00a9nB>EO\u0089I\u00da\u00c9\u00f4\u00eb\u00ef".getBytes("ISO_8859_1");
        Object[] v1 = "1\u0013vp\u00cb*\u0089\u0004".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1202998341;
                case 1 -> -1102832787;
                case 2 -> 84967235;
                case 3 -> -25263893;
                case 4 -> -2039577344;
                case 5 -> 1583961873;
                case 6 -> -799106683;
                case 7 -> 1280388225;
                case 8 -> 2094612521;
                case 9 -> 272208665;
                case 10 -> -909823625;
                case 11 -> -732684361;
                case 12 -> -2001197182;
                case 13 -> -2092841768;
                case 14 -> -314719786;
                case 15 -> -533386920;
                case 16 -> 1058921530;
                case 17 -> 2143653400;
                case 18 -> 1501568407;
                case 19 -> 918772237;
                case 20 -> -2060951118;
                case 21 -> -1876946860;
                case 22 -> -184231372;
                case 23 -> 2047298493;
                case 24 -> -442787185;
                case 25 -> -1520129351;
                case 26 -> 1857322416;
                case 27 -> 1787379708;
                case 28 -> -1209825932;
                case 29 -> -1650890926;
                case 30 -> 1741043250;
                case 31 -> -1963899940;
                case 32 -> -9489233;
                case 33 -> 1801122702;
                case 34 -> 1764380256;
                case 35 -> 1865278981;
                case 36 -> -1276072029;
                case 37 -> -246140852;
                case 38 -> 134842778;
                case 39 -> -367902391;
                case 40 -> 589115284;
                case 41 -> 1576133717;
                case 42 -> 1000612085;
                case 43 -> -2077992027;
                case 44 -> -968066582;
                case 45 -> -2023943544;
                case 46 -> 678436350;
                case 47 -> -1436473974;
                case 48 -> -1592970200;
                case 49 -> -347280298;
                case 50 -> 1644179906;
                case 51 -> -733243047;
                case 52 -> -1532002446;
                case 53 -> 602636362;
                case 54 -> 205084989;
                case 55 -> 1106297068;
                case 56 -> -1222231231;
                case 57 -> -652835688;
                case 58 -> 367976432;
                case 59 -> -1394435733;
                case 60 -> -1666011145;
                case 61 -> 368565817;
                case 62 -> -1738434523;
                case 63 -> 1724396196;
                case 64 -> -623540189;
                case 65 -> -58205314;
                case 66 -> -510106380;
                case 67 -> 1967222504;
                case 68 -> -1556387318;
                case 69 -> -1119540062;
                case 70 -> -799715200;
                case 71 -> -1715387377;
                case 72 -> 1309307445;
                case 73 -> -1886581077;
                case 74 -> -2134120905;
                case 75 -> 887713765;
                case 76 -> -145130513;
                case 77 -> -658486022;
                case 78 -> 1047692816;
                case 79 -> 874439610;
                case 80 -> 2062614295;
                case 81 -> 1409806399;
                case 82 -> -1164847791;
                case 83 -> -708937413;
                case 84 -> -2029988013;
                case 85 -> -1672031981;
                case 86 -> 1976736267;
                case 87 -> -254958411;
                case 88 -> -2123018503;
                case 89 -> 343105994;
                case 90 -> 2117835711;
                case 91 -> 2021339934;
                case 92 -> -414634228;
                case 93 -> -1884857317;
                case 94 -> 1343641037;
                case 95 -> 1451251015;
                case 96 -> -119942051;
                case 97 -> -144098655;
                case 98 -> 407541511;
                case 99 -> 565343489;
                case 100 -> 2099074154;
                case 101 -> 1093505044;
                case 102 -> 1731090780;
                case 103 -> 471508704;
                case 104 -> 652894676;
                case 105 -> -1983070050;
                case 106 -> -993497426;
                case 107 -> -1108366408;
                case 108 -> 1719953576;
                case 109 -> -338979874;
                case 110 -> -1873162047;
                case 111 -> -1659119237;
                case 112 -> -711589111;
                case 113 -> 1503376402;
                case 114 -> 1038789174;
                case 115 -> -70756324;
                case 116 -> -806428203;
                case 117 -> 1188240621;
                case 118 -> -891980426;
                case 119 -> -1208251704;
                case 120 -> 2130289980;
                case 121 -> 2041046020;
                case 122 -> 656124142;
                case 123 -> -1024418393;
                case 124 -> -1540268738;
                case 125 -> -621800402;
                case 126 -> 703917458;
                case 127 -> -55933997;
                case 128 -> -1088055718;
                case 129 -> 1287346733;
                case 130 -> 1573049386;
                case 131 -> 530898263;
                case 132 -> -250134241;
                case 133 -> 1620494742;
                case 134 -> -1080006261;
                case 135 -> -441868774;
                case 136 -> -634926554;
                case 137 -> -2065101279;
                case 138 -> 1248213653;
                case 139 -> 1375363525;
                case 140 -> -306761584;
                case 141 -> -556291097;
                case 142 -> 1903206773;
                case 143 -> -228016741;
                case 144 -> -1406862994;
                case 145 -> 1510749437;
                case 146 -> 1174365955;
                case 147 -> 1357454079;
                case 148 -> 1257458346;
                case 149 -> 2075827922;
                case 150 -> -270330013;
                case 151 -> -572535907;
                case 152 -> -2004186921;
                case 153 -> -1732767183;
                case 154 -> 144543942;
                case 155 -> 2032168135;
                case 156 -> 1506754768;
                case 157 -> 830725382;
                case 158 -> -1134514362;
                case 159 -> -661400512;
                case 160 -> 1688421624;
                case 161 -> 1360685391;
                case 162 -> -542172421;
                case 163 -> 1341721636;
                case 164 -> -1635371486;
                case 165 -> -427530813;
                case 166 -> 1209046407;
                case 167 -> -1585830398;
                case 168 -> 689499598;
                case 169 -> -1684902349;
                case 170 -> 462184304;
                case 171 -> 991291289;
                case 172 -> -1702201932;
                case 173 -> -1218970724;
                case 174 -> -1162775224;
                case 175 -> -1788114295;
                case 176 -> 757895273;
                case 177 -> 519983199;
                case 178 -> -1122118559;
                case 179 -> -846845848;
                case 180 -> -220663393;
                case 181 -> -1649231759;
                case 182 -> -571277146;
                case 183 -> 1360626577;
                case 184 -> -1380994831;
                case 185 -> -1023323080;
                case 186 -> -306744384;
                case 187 -> -746964532;
                case 188 -> -1689610831;
                case 189 -> 2109259;
                case 190 -> -16137963;
                case 191 -> 1303881156;
                case 192 -> -1995946905;
                case 193 -> 1053064047;
                case 194 -> 881032665;
                case 195 -> -1780618419;
                case 196 -> 1523412062;
                case 197 -> 559290212;
                case 198 -> 1433880678;
                case 199 -> -188023351;
                case 200 -> -1463189895;
                case 201 -> 49528179;
                case 202 -> -1374255824;
                case 203 -> -412509517;
                case 204 -> -810577738;
                case 205 -> -671314110;
                case 206 -> -1556046676;
                case 207 -> 64061659;
                case 208 -> 1219192910;
                case 209 -> 1408880114;
                case 210 -> -1006186369;
                case 211 -> 1828482271;
                case 212 -> 375778291;
                case 213 -> 1913516265;
                case 214 -> 1343030370;
                case 215 -> -1129082159;
                case 216 -> -1175761596;
                case 217 -> 1203533915;
                case 218 -> 60884155;
                case 219 -> 995205500;
                case 220 -> 1484312328;
                case 221 -> 691022268;
                case 222 -> 904338819;
                case 223 -> 1278318862;
                case 224 -> 1499394781;
                case 225 -> -1067743554;
                case 226 -> -1139530093;
                case 227 -> 1415768460;
                case 228 -> -729787540;
                case 229 -> 396998266;
                case 230 -> -1281736682;
                case 231 -> 62891467;
                case 232 -> 767862701;
                case 233 -> 1806973472;
                case 234 -> -38868693;
                case 235 -> -955656479;
                case 236 -> 1666878159;
                case 237 -> 802429053;
                case 238 -> 1575369061;
                case 239 -> -2139020771;
                case 240 -> 186259625;
                case 241 -> 1168856205;
                case 242 -> 1829260583;
                case 243 -> 867326198;
                case 244 -> 436568224;
                case 245 -> 1378741624;
                case 246 -> -704426961;
                case 247 -> -1655268308;
                case 248 -> 654573796;
                case 249 -> 427798490;
                case 250 -> 506300804;
                case 251 -> 1093682147;
                case 252 -> 1791430992;
                case 253 -> 1080987270;
                case 254 -> -516910878;
                case 255 -> 439325670;
                default -> -1047486724;
            });
        } while (v2 != 160);
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
            Object[] objectArray = new Object[12];
            v1 = objectArray;
            TranslateCommand = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        000i = 437656095;
        RenderSupport_000I = -1272962264;
        000o = -603190259;
        EnumType_0000 = 42;
        NetworkSupport_000O = 150;
        00Oi = 36;
        NetworkSupport_00OI = 140;
        00i = 0.5f;
    }

    private float oIoo(float param1, float param2, float param3) {
        return param1 + (param2 - param1) * param3;
    }
}

