/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.option.SimpleOption
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package clap.mixin;

import java.util.function.Consumer;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SimpleOption.class})
public interface SimpleOptionAccessor {
    @Accessor(value="value")
    public void clap$setValue(Object var1);

    @Accessor(value="onValueUpdate")
    public Consumer clap$getOnValueUpdate();
}

