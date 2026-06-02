/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resource.language.LanguageDefinition
 *  net.minecraft.client.resource.language.LanguageManager
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package clap.mixin;

import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.client.resource.language.LanguageDefinition;
import net.minecraft.client.resource.language.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={LanguageManager.class})
public interface LanguageManagerAccessor {
    @Accessor(value="DEFAULT_LANGUAGE")
    public static LanguageDefinition getDefaultLanguage() {
        throw new UnsupportedOperationException();
    }

    @Invoker
    public static Map invokeExtractLanguages(Stream param0) {
        throw new UnsupportedOperationException();
    }
}

