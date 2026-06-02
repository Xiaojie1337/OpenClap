/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package clap.gui;

import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.DrawContext;
import clap.render.RenderSupport_OIIO;
import clap.model.EnumType_OIO0;
import clap.render.FontRenderer;
import clap.model.DataRecord_OO0O;
import clap.core.module.Module;
import clap.render.RenderSupport_00oi_0;
import clap.model.DataRecord_i0o_0;
import clap.gui.screen.ClickGuiScreen;
import clap.gui.GuiSupport_oiio_6;
import clap.model.DataRecord_oioo_1;
import clap.model.DataRecord_oo0_0;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.Oii0
 */
final class GuiSupport_oii0_2 {
    private static final float ConfigSupport_O0I;
    private static final float GuiSupport_OOI;
    private static final float HelpCommand;
    private static final float HudElement;
    private static final float O0o;
    private static final float Oo0;
    private static final float EventBusApi;
    private static final float OoO;
    private static final float O0i;
    private static final float ConfigSupport_OI0;
    private static final float Ooi;
    private static final float OOi;
    private static final float KeystrokesHudElement;
    private static final float Ooo;
    private static final float OoI;
    private static final String OIo;
    private static final float PacketEvent;
    private static final float OOo;
    static Object ConfigSupport_OII;
    private static volatile /* synthetic */ long __k__gH4it;

    private boolean O0o(DataRecord_OO0O param1, DataRecord_OO0O param2) {
        return param1.oOO() + param1.oOo() >= param2.oOO() && param1.oOO() <= param2.oOO() + param2.oOo();
    }

    private float OOo(ClickGuiScreen param1) {
        float v2 = 0.0f;
        for (Module v4 : param1.RenderSupport_0I0()) {
            v2 += 43.0f;
            float v5 = param1.Oii(v4);
            if (!(v5 > 0.0f)) continue;
            v2 += (param1.WatermarkHudElement().PacketEvent(param1, param1.0Io(v4)) + 5.0f) * v5;
        }
        return Math.max(0.0f, v2 - 7.0f);
    }

    void PacketEvent(DrawContext param1, ClickGuiScreen param2, float param3, float param4, float param5) {
        String v9;
        float v6 = Math.max(120.0f, param5 - 30.0f);
        DataRecord_OO0O v7 = new DataRecord_OO0O(param3 + 15.0f, param4, v6, 26.0f);
        boolean v8 = param2.Ioo();
        param2.oii().O0o(v7.0ii(), v7.oOO(), v7.FastWebModule(), v7.oOo(), 10.0f, v8 ? RenderSupport_OIIO.0Oi : RenderSupport_OIIO.EnumType_0OI, v8 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement);
        String string = v9 = param2.I0o() == EnumType_OIO0.Ii0 ? "Config name" : "Search modules";
        String v10 = param2.NetworkSupport_i0i_2().isEmpty() && !v8 ? v9 : param2.NetworkSupport_i0i_2() + (param2.0ii() && v8 ? "_" : "");
        int v11 = param2.NetworkSupport_i0i_2().isEmpty() && !v8 ? 1922937807 : -722947;
        param2.O0o(() -> {
            float v5 = v7.oOO() + (v7.oOo() - param2.oIo(RenderSupport_OIIO.0ii)) * 0.5f + 1.0f + 2.0f;
            float v6 = v7.oOO() + (v7.oOo() - param2.oIo(RenderSupport_OIIO.DataRecord_0io_2)) * 0.5f - 0.5f + 1.0f;
            param2.oIO(param1, RenderSupport_OIIO.0ii, "G", v7.0ii() + 13.0f, v5, v11);
            param2.oIO(param1, RenderSupport_OIIO.DataRecord_0io_2, param2.oII(RenderSupport_OIIO.DataRecord_0io_2, v10, v7.FastWebModule() - 48.0f), v7.0ii() + 38.0f, v6, v11);
        });
        param2.RenderSupport_iio_5(v7);
    }

    private void OOi(DrawContext param1, ClickGuiScreen param2, int param3, int param4, DataRecord_OO0O param5, float param6, float param7) {
        List v8 = 0ooo.00oi().ConfigSupport_O0I();
        String v9 = 0ooo.HudEditorScreen().OoO();
        String v10 = param2.NetworkSupport_i0i_2().trim();
        DataRecord_OO0O v11 = new DataRecord_OO0O(param5.0ii() + param7, param6 + 8.0f, param5.FastWebModule(), 26.0f);
        if (this.O0o(v11, param5)) {
            this.HudElement(param1, param2, param3, param4, param5, v11, v10);
        }
        float v12 = param6 + 46.0f + 8.0f;
        for (int v13 = 0; v13 < v8.size(); ++v13) {
            int v25;
            int v24;
            DataRecord_oo0_0 v14 = (DataRecord_oo0_0)v8.get(v13);
            String v15 = v14.HelpCommand();
            DataRecord_OO0O v16 = new DataRecord_OO0O(param5.0ii() + param7 + 4.0f, v12 + (float)v13 * 46.0f, param5.FastWebModule() - 8.0f, 40.0f);
            if (!this.O0o(v16, param5)) continue;
            boolean v17 = v15.equals(v9);
            DataRecord_OO0O v18 = new DataRecord_OO0O(v16.0ii() + v16.FastWebModule() - 62.0f, v16.oOO() + 8.0f, 50.0f, 22.0f);
            DataRecord_OO0O v19 = new DataRecord_OO0O(v18.0ii() - (v17 ? 66.0f : 58.0f), v16.oOO() + 8.0f, v17 ? 58.0f : 50.0f, 22.0f);
            float v20 = Math.min(360.0f, Math.max(0.0f, v16.FastWebModule() * 0.34f));
            float v21 = v16.0ii() + 14.0f + v20 + 22.0f;
            float v22 = Math.max(0.0f, v19.0ii() - v21 - 16.0f);
            boolean v23 = v16.0iI(param3, param4);
            int n = v24 = v23 ? RenderSupport_OIIO.OiI : RenderSupport_OIIO.Oio;
            if (v24 != 0) {
                param2.oii().OOo(v16.0ii(), v16.oOO(), v16.FastWebModule(), v16.oOo(), 7.0f, v24);
            }
            param2.oii().OoO(v19.0ii(), v19.oOO(), v19.FastWebModule(), v19.oOo(), v17 ? -11559425 : RenderSupport_OIIO.ConfigSupport_00o_0, v17 ? -1510145 : RenderSupport_OIIO.KeystrokesHudElement);
            if (!"default".equals(v15)) {
                v25 = param2.ItemTagsModule(v15) ? 1 : 0;
                param2.oii().OoO(v18.0ii(), v18.oOO(), v18.FastWebModule(), v18.oOo(), v25 != 0 ? -1599846842 : RenderSupport_OIIO.EnumType_0OI, v25 != 0 ? -654345349 : RenderSupport_OIIO.KeystrokesHudElement);
            }
            v25 = v13;
            param2.ConfigSupport_O0I(param1, param5, () -> {
                DataRecord_oo0_0 v13 = (DataRecord_oo0_0)v8.get(v25);
                String v14 = v13.HelpCommand() + (v13.HelpCommand().equals(v9) ? " (active)" : "");
                param2.oIO(param1, RenderSupport_OIIO.DataRecord_0io_2, param2.oII(RenderSupport_OIIO.DataRecord_0io_2, v14, v20), v16.0ii() + 14.0f, v16.oOO() + 9.0f, -722947);
                if (v22 > 32.0f) {
                    param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, param2.oII(RenderSupport_OIIO.KeepSprintModule, v13.O0o(), v22), v21, v16.oOO() + 10.0f, -1429284376);
                }
                this.O0i(param1, param2, v17 ? "Active" : "Load", v19, -722947);
                if (!"default".equals(v13.HelpCommand())) {
                    int v15 = param2.ItemTagsModule(v13.HelpCommand()) ? -722947 : -1429284376;
                    this.O0i(param1, param2, "Delete", v18, v15);
                }
            });
            param2.EnumType_I00().add(new DataRecord_oioo_1(1000 + v13, v19));
            if ("default".equals(v15)) continue;
            param2.EnumType_I00().add(new DataRecord_oioo_1(2000 + v13, v18));
        }
    }

    private void EventBusApi(DrawContext param1, ClickGuiScreen param2, int param3, int param4, DataRecord_OO0O param5, Module param6, List param7, float param8, float param9, float param10) {
        String v29;
        String v28;
        boolean v11 = param6.I0i0();
        if (!v11) {
            param10 = 0.0f;
        }
        boolean v12 = v11 && param2.Oio(param6);
        float v13 = param2.WatermarkHudElement().PacketEvent(param2, param7);
        float v14 = v13 * param10 + (param10 > 0.0f ? 5.0f * param10 : 0.0f);
        float v15 = 36.0f + v14;
        DataRecord_OO0O v16 = new DataRecord_OO0O(param5.0ii() + param9, param8, param5.FastWebModule(), v15);
        DataRecord_OO0O v17 = new DataRecord_OO0O(v16.0ii() + 4.0f, v16.oOO() + 4.0f, v16.FastWebModule() - 8.0f, 28.0f);
        boolean v18 = v17.0iI(param3, param4);
        boolean v19 = this.O0o(v17, param5);
        DataRecord_OO0O v20 = new DataRecord_OO0O(v17.0ii() + v17.FastWebModule() - 66.0f, v17.oOO() + 5.0f, 38.0f, 18.0f);
        DataRecord_OO0O v21 = new DataRecord_OO0O(v17.0ii() + v17.FastWebModule() - 22.0f, v17.oOO() + 2.0f, 18.0f, 23.0f);
        float v22 = v17.0ii() + 11.0f;
        float v23 = Math.min(132.0f, v17.FastWebModule() * 0.34f);
        float v24 = v22 + v23 + 20.0f;
        float v25 = Math.max(0.0f, v20.0ii() - v24 - 14.0f);
        String v26 = param2.oII(RenderSupport_OIIO.DataRecord_0io_2, param6.IoOO(), v23);
        String v27 = param2.oII(RenderSupport_OIIO.KeepSprintModule, param6.Oii0(), v25);
        String string = v11 ? (param6.IoOo() ? "On" : "Off") : (v28 = "Beta");
        String string2 = v11 ? (v12 ? "v" : ">") : (v29 = "-");
        if (v19) {
            int v30;
            if (!v11) {
                v30 = v18 ? RenderSupport_OIIO.OiI : RenderSupport_OIIO.Oio;
            } else if (param6.IoOo()) {
                v30 = v18 ? RenderSupport_OIIO.DataRecord_0O0 : RenderSupport_OIIO.ConfigSupport_0OO;
            } else {
                int n = v30 = v18 ? RenderSupport_OIIO.OiI : RenderSupport_OIIO.Oio;
            }
            if (v30 != 0) {
                param2.oii().OOo(v17.0ii(), v17.oOO(), v17.FastWebModule(), v17.oOo(), 7.0f, v30);
            }
            float v31 = param2.SpawnerFinderModule(param6);
            param2.oii().OoO(v20.0ii(), v20.oOO(), v20.FastWebModule(), v20.oOo(), v11 ? param2.0iI(RenderSupport_OIIO.ConfigSupport_00o_0, -11559425, v31) : RenderSupport_OIIO.ConfigSupport_00o_0, v11 ? param2.0iI(RenderSupport_OIIO.KeystrokesHudElement, -1510145, v31) : RenderSupport_OIIO.KeystrokesHudElement);
            param2.ConfigSupport_O0I(param1, param5, () -> {
                int v14 = v11 ? -722947 : 1922937807;
                int v15 = v11 ? -1429284376 : 1922937807;
                param2.oIO(param1, RenderSupport_OIIO.DataRecord_0io_2, v26, v22, v17.oOO() + 5.0f, v14);
                if (v25 > 18.0f) {
                    param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, v27, v24, v17.oOO() + 6.0f, v15);
                }
                this.O0i(param1, param2, v28, v20, v14);
                this.O0i(param1, param2, v29, v21, v15);
            });
            param2.SprintModule().add(new DataRecord_i0o_0(param6, v17, v20, v21));
        }
        if (param10 > 0.0f) {
            DataRecord_OO0O v30 = this.ConfigSupport_O0I(param5, new DataRecord_OO0O(v16.0ii() + 4.0f, v17.oOO() + v17.oOo() + 4.0f, v16.FastWebModule() - 8.0f, Math.max(0.0f, v13 * param10)));
            param2.WatermarkHudElement().OOo(param1, param2, param3, param4, v16.0ii() + 4.0f, v17.oOO() + v17.oOo() + 4.0f, v16.FastWebModule() - 8.0f, param7, v30);
        }
    }

    private void OoO(DrawContext param1, ClickGuiScreen param2, String param3, DataRecord_OO0O param4, FontRenderer param5, int param6) {
        float v7 = param4.0ii() + (param4.FastWebModule() - param2.ConfigSupport_oi0_2(param5, param3)) * 0.5f;
        float v8 = param4.oOO() + (param4.oOo() - param2.oIo(param5)) * 0.5f - 0.5f;
        param2.oIO(param1, param5, param3, v7, v8, param6);
    }

    private void HudElement(DrawContext param1, ClickGuiScreen param2, int param3, int param4, DataRecord_OO0O param5, DataRecord_OO0O param6, String param7) {
        DataRecord_OO0O v8 = new DataRecord_OO0O(param6.0ii() + 4.0f, param6.oOO(), 26.0f, 26.0f);
        boolean v9 = param2.IoI();
        float v10 = param2.EnumType_0OI();
        float v11 = v8.0ii() + v8.FastWebModule() + 10.0f;
        DataRecord_OO0O v12 = new DataRecord_OO0O(v11, param6.oOO(), 168.0f, 26.0f);
        DataRecord_OO0O v13 = new DataRecord_OO0O(v12.0ii() + v12.FastWebModule() + 10.0f, param6.oOO(), 58.0f, 26.0f);
        float v14 = param6.0ii() + param6.FastWebModule() - 4.0f - 52.0f - 10.0f;
        DataRecord_OO0O v15 = new DataRecord_OO0O(v14, param6.oOO(), 26.0f, 26.0f);
        DataRecord_OO0O v16 = new DataRecord_OO0O(v15.0ii() + v15.FastWebModule() + 10.0f, param6.oOO(), 26.0f, 26.0f);
        boolean v17 = param2.Ioo();
        float v18 = Math.max(0.0f, Math.min(1.0f, v10 / 0.74f));
        float v19 = v10 <= 0.74f ? 0.0f : Math.max(0.0f, Math.min(1.0f, (v10 - 0.74f) / 0.26f));
        param2.oii().OoO(v8.0ii(), v8.oOO(), v8.FastWebModule(), v8.oOo(), v9 ? -11559425 : RenderSupport_OIIO.ConfigSupport_00o_0, v9 ? -1510145 : RenderSupport_OIIO.KeystrokesHudElement);
        param2.oii().OoO(v15.0ii(), v15.oOO(), v15.FastWebModule(), v15.oOo(), RenderSupport_OIIO.ConfigSupport_00o_0, RenderSupport_OIIO.KeystrokesHudElement);
        param2.oii().OoO(v16.0ii(), v16.oOO(), v16.FastWebModule(), v16.oOo(), RenderSupport_OIIO.ConfigSupport_00o_0, RenderSupport_OIIO.KeystrokesHudElement);
        if (v18 > 0.0f || v19 > 0.0f) {
            float v20 = v12.FastWebModule() * v18;
            float v21 = v13.FastWebModule() * v19;
            DataRecord_OO0O v22 = new DataRecord_OO0O(v12.0ii(), v12.oOO(), v20, v12.oOo());
            DataRecord_OO0O v23 = new DataRecord_OO0O(v13.0ii(), v13.oOO(), v21, v13.oOo());
            if (v22.FastWebModule() > 0.0f) {
                param2.oii().O0o(v22.0ii(), v22.oOO(), v22.FastWebModule(), v22.oOo(), 10.0f, v17 ? RenderSupport_OIIO.0Oi : RenderSupport_OIIO.EnumType_0OI, v17 ? RenderSupport_OIIO.AutoMlgModule : RenderSupport_OIIO.KeystrokesHudElement);
            }
            if (v23.FastWebModule() > 0.0f) {
                param2.oii().OoO(v23.0ii(), v23.oOO(), v23.FastWebModule(), v23.oOo(), param7.isEmpty() ? RenderSupport_OIIO.ConfigSupport_00o_0 : -11559425, param7.isEmpty() ? RenderSupport_OIIO.KeystrokesHudElement : -1510145);
            }
        }
        param2.ConfigSupport_O0I(param1, param5, () -> {
            this.O0i(param1, param2, "+", v8, -722947);
            this.OoO(param1, param2, "R", v15, RenderSupport_OIIO.oOO, -722947);
            this.OoO(param1, param2, "F", v16, RenderSupport_OIIO.oOO, -722947);
            if (v18 > 0.0f || v19 > 0.0f) {
                String v11 = param2.NetworkSupport_i0i_2().isEmpty() && !v17 ? "Config name" : param2.NetworkSupport_i0i_2() + (param2.0ii() && v17 ? "_" : "");
                int v12 = this.Oo0(param2.NetworkSupport_i0i_2().isEmpty() && !v17 ? 1922937807 : -722947, v18);
                int v13 = this.Oo0(-722947, v19);
                float v14 = v12.oOO() + (v12.oOo() - param2.oIo(RenderSupport_OIIO.DataRecord_0io_2)) * 0.5f - 0.5f;
                if (v18 > 0.0f) {
                    param2.oIO(param1, RenderSupport_OIIO.DataRecord_0io_2, param2.oII(RenderSupport_OIIO.DataRecord_0io_2, v11, v12.FastWebModule() - 22.0f), v12.0ii() + 12.0f, v14, v12);
                }
                if (v19 > 0.0f) {
                    this.O0i(param1, param2, "Save", v13, v13);
                }
            }
        });
        param2.RenderSupport_iio_5(v9 && v10 > 0.95f ? v12 : DataRecord_OO0O.OOoO());
        param2.EnumType_I00().add(new DataRecord_oioo_1(1, v8));
        param2.EnumType_I00().add(new DataRecord_oioo_1(2, v15));
        param2.EnumType_I00().add(new DataRecord_oioo_1(3, v16));
        if (v9 && v10 > 0.95f) {
            param2.EnumType_I00().add(new DataRecord_oioo_1(0, v13));
        }
    }

    private void O0i(DrawContext param1, ClickGuiScreen param2, String param3, DataRecord_OO0O param4, int param5) {
        float v6 = param4.0ii() + (param4.FastWebModule() - param2.ConfigSupport_oi0_2(RenderSupport_OIIO.KeepSprintModule, param3)) * 0.5f;
        float v7 = param4.oOO() + (param4.oOo() - param2.oIo(RenderSupport_OIIO.KeepSprintModule)) * 0.5f - 0.5f;
        param2.oIO(param1, RenderSupport_OIIO.KeepSprintModule, param3, v6, v7, param5);
    }

    private DataRecord_OO0O ConfigSupport_O0I(DataRecord_OO0O param1, DataRecord_OO0O param2) {
        float v3 = Math.max(param1.0ii(), param2.0ii());
        float v4 = Math.max(param1.oOO(), param2.oOO());
        float v5 = Math.min(param1.0ii() + param1.FastWebModule(), param2.0ii() + param2.FastWebModule());
        float v6 = Math.min(param1.oOO() + param1.oOo(), param2.oOO() + param2.oOo());
        return new DataRecord_OO0O(v3, v4, Math.max(0.0f, v5 - v3), Math.max(0.0f, v6 - v4));
    }

    private float GuiSupport_OOI() {
        return 46.0f + Math.max(0.0f, (float)0ooo.ConfigSupport_00I0().ConfigSupport_O0I().size() * 46.0f - 6.0f);
    }

    private int Oo0(int param1, float param2) {
        int v3 = Math.round((float)(param1 >>> 24 & 0xFF) * Math.max(0.0f, Math.min(1.0f, param2)));
        return v3 << 24 | param1 & 0xFFFFFF;
    }

    static {
        __k__gH4it = GuiSupport_oii0_2.__k__gH4it((long)-7853993544615203311L);
        __rP__gH4it0 = new String[]{"\u184b\u35f2\ue977\ubc2d\u3b62\uddbf\udf13\ueaa8", "\u18b9\u3549\ue993"};
        __rP__gH4it1 = new String[]{"\u18b9\u3550\ue982\ubc6c\u3b21\udd87\udf8f\ueaa0\u1bb7\u362a"};
        __rP__gH4it2 = new String[]{"\u18bb\u3552\ue99c\ubc72\u3b23\udd85\udf89\ueaa6\u1bb5\u3628", "\u18af\u3553\ue989\ubc09\u3b51\uddf0\udff6\ueabb\u1bb3\u3665\ue961\ubd4d\u3a5f\udcda\ude2c\uebc8\u1aff\u374f\ue844\uba71", "\u18ac\u355c\ue982\ubc19\u3b38"};
        __rP__gH4it3 = new String[]{"\u185e\u3584\ueacb\ubfd1\u38aa\udeb3\udcf4\uea14\u1b17\u36f7\ue9be\ubc08\u3b6d\uddc5\udf88\uebf8\u1a7d\u3767\ue8a9\ubd05\u3abc\udc85\ude8e\uec4f\u1de5\u3015\uefb7\uba57\u3ddd\udb1f\ud99a\uedaa\u1cc2\u31af\uee5f\ubba1\u3c29\uda96\ud850\ueda1\u1fae\u32aa\ued64\ub8c1\u3f93\ud94a\udb3b\ueee6\u1e85\u33f3\uec5b\ub9d2\u3e40\ud8f2\uda20\uefbb\u0189\u2cf6\uf3cb\ua653\u218b\uc7bb\uc5e4\uf0ae\u007f\u2dca\uf29c\ua7b5\u2040\uc64b\uc4cb\uf112_\u2e04\uf13f\ua4b9\u2300\uc568\uc7f2\uf275\u0313\u2fe1\uf011\ua5e0\u2224\uc43d\uc64f\uf321\u024f\u28bc\uf742\ua21c\u2583\uc3ea\uc153\uf44e\u057f\u28ca\uf600\ua3a6\u2402\uc2e0\uc074\uf5bf\u04ae\u29ab\uf502\ua035\u2792\uc1db\uc355\uf6e9\u073c\u2a56\uf40a\ua189\u266e\uc04e\uc237\uf7b4\u0654\u2b7a\ufb6f\uae06\u2908\ucf88\ucd70\uf804\u09a5\u24d0\ufbb7\uaf24\u283e\uce4e\ucc98\uf9f2\u08ab\u2567\ufa78\uac18\u2be7\ucde1\ucfca\ufafe\u0b84\u26c0\uf97f\uadd9\u2ac8\ucc32\uce3a\ufbc7", "\u18a9\u3541\ue98a\ubc18\u3b31\udd90\udf92"};
        byte[] v0 = "=*iO@\u00b998\fQ\u0014\u009e\u008f\u00c7M\u00dcn\u00d9\u001b\u008bF\u009fSs\u00ee\u00a3\r\u00d1/\rO\u009e\u00c1a\u00dd\u00df\u00e3\u00fc\u00bdm\u0095l\u00ee\u00b7Q(\u00de\"\u00b6-\u00c9\u00bc\u009a\u0088\u00ddg\u00a2 Q5Y\u00c9\u0011z\\$~\u00ebj\u0001F\u00fe\u0084\u00e2\u00d5\u00ef\"*w\u0091\u00c0\u001f\u00e3\u00ae\u001eg\u00d2\u00dd\u0084J\u00b8Z\u00b1\u00b8\u00c6\u00ba\u00bc\u00c4\u00c2\u0098\bJ\u00d93U\u00ad\u00c8\u0003\u0090y\u00f0m\u00cfH\u00d8\u00a7t\u00f4\u008a(\u00bfl\u00b5 \u001a:\u00c5\u0090F\u00fe\u0095:T\u00c4\u00d5^0AR\u000e\u0085c\u008fZ\u0017\u00feM\u00d7\u00b2\u00a8g{".getBytes("ISO_8859_1");
        Object[] v1 = "\u00ba\u00f2\u00bb\u0001z\u0003\u00a86".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1182959562;
                case 1 -> -1631927348;
                case 2 -> -1958377753;
                case 3 -> -1290095559;
                case 4 -> 529034424;
                case 5 -> -1962052271;
                case 6 -> 524623140;
                case 7 -> -514983735;
                case 8 -> 1881495334;
                case 9 -> 2083544680;
                case 10 -> -2033727152;
                case 11 -> 1925312965;
                case 12 -> -924383798;
                case 13 -> 988415958;
                case 14 -> -2015608096;
                case 15 -> 261721745;
                case 16 -> -1861246711;
                case 17 -> -1817074256;
                case 18 -> -2004554833;
                case 19 -> -700111545;
                case 20 -> 97433499;
                case 21 -> -998812016;
                case 22 -> -536757747;
                case 23 -> -563545248;
                case 24 -> -1609139799;
                case 25 -> -1270925477;
                case 26 -> -950198683;
                case 27 -> -670805760;
                case 28 -> -1564831773;
                case 29 -> 502605652;
                case 30 -> -1482142474;
                case 31 -> 993937261;
                case 32 -> -1478751924;
                case 33 -> -503895176;
                case 34 -> -1708738844;
                case 35 -> -1817164780;
                case 36 -> 952844065;
                case 37 -> 1563477228;
                case 38 -> -965765603;
                case 39 -> 1432078502;
                case 40 -> -993933318;
                case 41 -> 1099017986;
                case 42 -> -1886927241;
                case 43 -> -1007434636;
                case 44 -> 1717812238;
                case 45 -> 231661686;
                case 46 -> 1382373337;
                case 47 -> -1795170520;
                case 48 -> 655949632;
                case 49 -> 79999439;
                case 50 -> -1452173059;
                case 51 -> -1931324179;
                case 52 -> -146523951;
                case 53 -> -1136816639;
                case 54 -> -2135586535;
                case 55 -> -1137754612;
                case 56 -> -1670990720;
                case 57 -> -189751085;
                case 58 -> -1062737914;
                case 59 -> -1337031582;
                case 60 -> -274896310;
                case 61 -> -62897443;
                case 62 -> 1632848410;
                case 63 -> -1102069462;
                case 64 -> 282381575;
                case 65 -> 473445753;
                case 66 -> 0x77FDFDFF;
                case 67 -> 191483974;
                case 68 -> -1563024801;
                case 69 -> 1581770799;
                case 70 -> 1575262916;
                case 71 -> -2112497049;
                case 72 -> -1020619725;
                case 73 -> -926593228;
                case 74 -> -1305244964;
                case 75 -> 122688167;
                case 76 -> -1677905827;
                case 77 -> 990448026;
                case 78 -> 1937433195;
                case 79 -> -276397664;
                case 80 -> 384206006;
                case 81 -> -1933778153;
                case 82 -> 815488503;
                case 83 -> 2019590377;
                case 84 -> 589404769;
                case 85 -> -117310581;
                case 86 -> -975023970;
                case 87 -> 1645201309;
                case 88 -> 156461932;
                case 89 -> 820246193;
                case 90 -> -604641727;
                case 91 -> 1116094333;
                case 92 -> -1744099734;
                case 93 -> 1944267787;
                case 94 -> 2056389342;
                case 95 -> -721819825;
                case 96 -> 1337119419;
                case 97 -> -1984451925;
                case 98 -> 1009355058;
                case 99 -> -86866958;
                case 100 -> -1341314098;
                case 101 -> 2047570219;
                case 102 -> -1064894081;
                case 103 -> -424480729;
                case 104 -> 232177966;
                case 105 -> -167093674;
                case 106 -> -826098273;
                case 107 -> -1458946276;
                case 108 -> -504513693;
                case 109 -> -393580612;
                case 110 -> -1986787361;
                case 111 -> 498532632;
                case 112 -> -440088061;
                case 113 -> -461912554;
                case 114 -> 1063649534;
                case 115 -> -1106680572;
                case 116 -> -266658874;
                case 117 -> -900002801;
                case 118 -> -1058004526;
                case 119 -> -1340666793;
                case 120 -> -633574215;
                case 121 -> 495080893;
                case 122 -> 10329688;
                case 123 -> 1310570452;
                case 124 -> -1901492890;
                case 125 -> 63435902;
                case 126 -> -1173482647;
                case 127 -> 1826632804;
                case 128 -> 523942750;
                case 129 -> -1200924870;
                case 130 -> 1722628925;
                case 131 -> -1598346507;
                case 132 -> -1747762728;
                case 133 -> 2133602177;
                case 134 -> 705074522;
                case 135 -> 1290121813;
                case 136 -> 2094360095;
                case 137 -> -1860670419;
                case 138 -> 827670224;
                case 139 -> 824955272;
                case 140 -> 519376280;
                case 141 -> -2071869717;
                case 142 -> 1025466611;
                case 143 -> -1632678775;
                case 144 -> 1510407480;
                case 145 -> -845682388;
                case 146 -> 1689255643;
                case 147 -> 1310548805;
                case 148 -> -146747616;
                case 149 -> -512723775;
                case 150 -> 1094254916;
                case 151 -> -1215404617;
                case 152 -> -565798678;
                case 153 -> -2112464079;
                case 154 -> 1821558133;
                case 155 -> -1607579922;
                case 156 -> -257908063;
                case 157 -> -875663470;
                case 158 -> -315781453;
                case 159 -> -1843688632;
                case 160 -> -637222742;
                case 161 -> -900264524;
                case 162 -> -920868721;
                case 163 -> 31209583;
                case 164 -> 579085342;
                case 165 -> -188401423;
                case 166 -> -2073421584;
                case 167 -> -929126081;
                case 168 -> 1332195186;
                case 169 -> -1073633284;
                case 170 -> -295886989;
                case 171 -> 1031173268;
                case 172 -> 429008650;
                case 173 -> 386695944;
                case 174 -> -179504908;
                case 175 -> -400312180;
                case 176 -> -2048860260;
                case 177 -> -1923686635;
                case 178 -> -1807973328;
                case 179 -> 2012577086;
                case 180 -> -1569153481;
                case 181 -> 1726819579;
                case 182 -> -1743590493;
                case 183 -> 792596106;
                case 184 -> -1938430405;
                case 185 -> 2082352389;
                case 186 -> 1863338637;
                case 187 -> 1239050563;
                case 188 -> 961865532;
                case 189 -> -1359071851;
                case 190 -> 1667037993;
                case 191 -> 1773941399;
                case 192 -> -271143962;
                case 193 -> 1222549538;
                case 194 -> 746920066;
                case 195 -> -914898395;
                case 196 -> -630299309;
                case 197 -> -1865554791;
                case 198 -> 1117338501;
                case 199 -> -1060223850;
                case 200 -> 849009699;
                case 201 -> 850702865;
                case 202 -> -1681348717;
                case 203 -> 340129609;
                case 204 -> 238903371;
                case 205 -> 1424548405;
                case 206 -> -1177005908;
                case 207 -> 90241811;
                case 208 -> 1195426734;
                case 209 -> 945241839;
                case 210 -> 454915789;
                case 211 -> 925195688;
                case 212 -> -1879555637;
                case 213 -> -235835974;
                case 214 -> 702139214;
                case 215 -> 816785633;
                case 216 -> -456695674;
                case 217 -> -1289915524;
                case 218 -> -1069396880;
                case 219 -> -1347436345;
                case 220 -> -618588494;
                case 221 -> 1991812005;
                case 222 -> -698788751;
                case 223 -> -1790193176;
                case 224 -> 268295102;
                case 225 -> 152561947;
                case 226 -> 878152324;
                case 227 -> 586908178;
                case 228 -> 1103980610;
                case 229 -> -812920139;
                case 230 -> 1206298797;
                case 231 -> -2128161158;
                case 232 -> -1662893445;
                case 233 -> 2140059152;
                case 234 -> -416526172;
                case 235 -> 1349668066;
                case 236 -> -358456358;
                case 237 -> -215490621;
                case 238 -> -1043177755;
                case 239 -> -548523320;
                case 240 -> -1129737259;
                case 241 -> 1333174659;
                case 242 -> 287141006;
                case 243 -> -1180873124;
                case 244 -> 985615040;
                case 245 -> -536561838;
                case 246 -> 1274643415;
                case 247 -> -1100105618;
                case 248 -> -431283265;
                case 249 -> -38839902;
                case 250 -> -168812552;
                case 251 -> -234286599;
                case 252 -> -1123007667;
                case 253 -> 1995102297;
                case 254 -> 1064962498;
                case 255 -> 2135914119;
                default -> -2002172955;
            });
        } while (v2 != 152);
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
            Object[] objectArray = new Object[20];
            v1 = objectArray;
            ConfigSupport_OII = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OIo = "G";
        ConfigSupport_OI0 = 0.74f;
        KeystrokesHudElement = 4.0f;
        Ooi = 10.0f;
        OoI = 26.0f;
        Ooo = 8.0f;
        Oo0 = 4.0f;
        OoO = 10.0f;
        O0i = 58.0f;
        ConfigSupport_O0I = 168.0f;
        O0o = 26.0f;
        EventBusApi = -4.0f;
        HudElement = 3.0f;
        OOi = 2.0f;
        GuiSupport_OOI = 1.0f;
        OOo = 15.0f;
        HelpCommand = 30.0f;
        PacketEvent = 4.0f;
    }

    GuiSupport_oii0_2() {
    }

    void HelpCommand(DrawContext param1, ClickGuiScreen param2, int param3, int param4, float param5, float param6, float param7, float param8) {
        DataRecord_OO0O v9 = new DataRecord_OO0O(param5, param6, param7, param8);
        param2.iOi(v9);
        float v10 = param2.I0o() == EnumType_OIO0.Ii0 ? this.GuiSupport_OOI() : this.OOo(param2);
        float v11 = Math.max(0.0f, v10 - v9.oOo());
        param2.iOI(v11);
        param2.iOo(param2.oOO(param2.RenderSupport_io0_2(), 0.0f, v11));
        GuiSupport_oiio_6.PacketEvent(param1, Math.round(v9.0ii()), Math.round(v9.oOO()), Math.round(v9.0ii() + v9.FastWebModule()), Math.round(v9.oOO() + v9.oOo()));
        RenderSupport_00oi_0.ConfigSupport_OI0(v9.0ii(), v9.oOO(), v9.FastWebModule(), v9.oOo());
        float v12 = v9.oOO() - param2.RenderSupport_io0_2();
        float v13 = param2.ConfigSupport_0OO();
        if (param2.I0o() == EnumType_OIO0.Ii0) {
            this.OOi(param1, param2, param3, param4, v9, v12, v13);
        } else {
            for (Module v15 : param2.RenderSupport_0I0()) {
                float v19;
                List v16 = param2.0Io(v15);
                float v17 = param2.Oii(v15);
                float v18 = param2.WatermarkHudElement().PacketEvent(param2, v16) * v17;
                if (v17 > 0.0f) {
                    v18 += 5.0f * v17;
                }
                if (v12 + (v19 = 36.0f + v18) >= v9.oOO() - 8.0f && v12 <= v9.oOO() + v9.oOo() + 8.0f) {
                    this.EventBusApi(param1, param2, param3, param4, v9, v15, v16, v12, v13, v17);
                }
                v12 += v19 + 7.0f;
            }
        }
        RenderSupport_00oi_0.OIo();
        GuiSupport_oiio_6.HelpCommand(param1);
        if (v11 > 0.0f) {
            param2.O0i(param5 + param7 - 3.0f - -4.0f, param6 + 2.0f, 3.0f, param8 - 4.0f, param2.RenderSupport_io0_2(), v11);
        } else {
            param2.OoO();
        }
    }
}

