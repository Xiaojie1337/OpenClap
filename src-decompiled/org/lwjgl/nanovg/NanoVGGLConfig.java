/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.lang.reflect.Method;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryUtil;

final class NanoVGGLConfig {
    private NanoVGGLConfig() {
    }

    static void configGL(long param0) {
        NanoVGGLConfig.config(param0, NanoVGGLConfig.getFunctionProvider("org.lwjgl.opengl.GL"));
    }

    static void configGLES(long param0) {
        NanoVGGLConfig.config(param0, NanoVGGLConfig.getFunctionProvider("org.lwjgl.opengles.GLES"));
    }

    private static FunctionProvider getFunctionProvider(String param0) {
        try {
            Class<?> v1 = Class.forName(param0);
            Method v2 = v1.getMethod("getCapabilities", new Class[0]);
            v2.invoke(null, new Object[0]);
            Method v3 = v1.getMethod("getFunctionProvider", new Class[0]);
            return (FunctionProvider)v3.invoke(null, new Object[0]);
        }
        catch (Exception v1) {
            throw new RuntimeException(v1);
        }
    }

    private static void config(long param0, FunctionProvider param2) {
        String[] v3 = new String[]{"glActiveTexture", "glAttachShader", "glBindAttribLocation", "glBindBuffer", "glBindBufferRange", "glBindFramebuffer", "glBindRenderbuffer", "glBindTexture", "glBindVertexArray", "glBlendFunc", "glBlendFuncSeparate", "glBufferData", "glCheckFramebufferStatus", "glColorMask", "glCompileShader", "glCreateProgram", "glCreateShader", "glCullFace", "glDeleteBuffers", "glDeleteFramebuffers", "glDeleteProgram", "glDeleteRenderbuffers", "glDeleteShader", "glDeleteTextures", "glDeleteVertexArrays", "glDetachShader", "glDisable", "glDisableVertexAttribArray", "glDrawArrays", "glEnable", "glEnableVertexAttribArray", "glFinish", "glFlush", "glFramebufferRenderbuffer", "glFramebufferTexture2D", "glFrontFace", "glGenBuffers", "glGenFramebuffers", "glGenRenderbuffers", "glGenTextures", "glGenVertexArrays", "glGenerateMipmap", "glGetError", "glGetIntegerv", "glGetProgramiv", "glGetProgramInfoLog", "glGetShaderiv", "glGetShaderInfoLog", "glGetUniformBlockIndex", "glGetUniformLocation", "glLinkProgram", "glPixelStorei", "glRenderbufferStorage", "glShaderSource", "glStencilFunc", "glStencilMask", "glStencilOp", "glStencilOpSeparate", "glTexImage2D", "glTexParameteri", "glTexSubImage2D", "glUniform1i", "glUniform2fv", "glUniform4fv", "glUniformBlockBinding", "glUseProgram", "glVertexAttribPointer"};
        PointerBuffer v4 = MemoryUtil.memPointerBuffer(param0, 67);
        for (int v5 = 0; v5 < v3.length; ++v5) {
            v4.put(v5, param2.getFunctionAddress(v3[v5]));
        }
    }
}

