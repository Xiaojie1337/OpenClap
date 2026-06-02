/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Downloader
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package clap.mixin;

import java.nio.file.Path;
import net.minecraft.util.Downloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={Downloader.class})
public class ResourceDownloaderPathMixin {
    @Redirect(method={"method_55485"}, at=@At(value="INVOKE", target="Ljava/nio/file/Path;resolve(Ljava/lang/String;)Ljava/nio/file/Path;"), remap=false)
    public Path resolve(Path param1, String param2) {
        return param1.resolve(param2);
    }
}

