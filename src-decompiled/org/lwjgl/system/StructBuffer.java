/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;

public abstract class StructBuffer<T extends Struct<T>, SELF extends StructBuffer<T, SELF>>
extends CustomBuffer<SELF>
implements Iterable<T> {
    protected StructBuffer(ByteBuffer param1, int param2) {
        super(MemoryUtil.memAddress(param1), param1, -1, 0, param2, param2);
    }

    protected StructBuffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
        super(param1, param3, param4, param5, param6, param7);
    }

    @Override
    public int sizeof() {
        return ((Struct)this.getElementFactory()).sizeof();
    }

    public T get() {
        T v1 = this.getElementFactory();
        return (T)((Struct)v1).create(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)((Struct)v1).sizeof(), this.container);
    }

    public SELF get(T param1) {
        int v2 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)v2, ((Pointer.Default)param1).address(), v2);
        return (SELF)((StructBuffer)this.self());
    }

    @Override
    public SELF put(T param1) {
        int v2 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(((Pointer.Default)param1).address(), this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)v2, v2);
        return (SELF)((StructBuffer)this.self());
    }

    public T get(int param1) {
        T v2 = this.getElementFactory();
        return (T)((Struct)v2).create(this.address + Integer.toUnsignedLong(StructBuffer.check(param1, this.limit)) * (long)((Struct)v2).sizeof(), this.container);
    }

    public SELF get(int param1, T param2) {
        int v3 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(this.address + Checks.check(param1, this.limit) * (long)v3, ((Pointer.Default)param2).address(), v3);
        return (SELF)((StructBuffer)this.self());
    }

    public SELF put(int param1, T param2) {
        int v3 = ((Struct)this.getElementFactory()).sizeof();
        MemoryUtil.memCopy(((Pointer.Default)param2).address(), this.address + Checks.check(param1, this.limit) * (long)v3, v3);
        return (SELF)((StructBuffer)this.self());
    }

    public SELF apply(Consumer<T> param1) {
        param1.accept(this.get());
        return (SELF)((StructBuffer)this.self());
    }

    public SELF apply(int param1, Consumer<T> param2) {
        param2.accept(this.get(param1));
        return (SELF)((StructBuffer)this.self());
    }

    @Override
    public Iterator<T> iterator() {
        return new StructIterator<T>(this.address, this.container, this.getElementFactory(), this.position, this.limit);
    }

    @Override
    public void forEach(Consumer<? super T> param1) {
        Objects.requireNonNull(param1);
        T v2 = this.getElementFactory();
        int v4 = this.limit;
        ((Struct)v2).sizeof();
        for (int v3 = this.position; v3 < v4; ++v3) {
            param1.accept(((Struct)v2).create(this.address + Integer.toUnsignedLong(v3) * (long)this.sizeof(), this.container));
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return new StructSpliterator<T>(this.address, this.container, this.getElementFactory(), this.position, this.limit);
    }

    public Stream<T> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public Stream<T> parallelStream() {
        return StreamSupport.stream(this.spliterator(), true);
    }

    protected abstract T getElementFactory();

    private static int check(int param0, int param1) {
        if (Checks.CHECKS && (param0 < 0 || param1 <= param0)) {
            throw new IndexOutOfBoundsException();
        }
        return param0;
    }

    private static class StructSpliterator<T extends Struct<T>>
    implements Spliterator<T> {
        private long address;
        @Nullable
        private ByteBuffer container;
        private T factory;
        private int index;
        private int fence;

        StructSpliterator(long param1, @Nullable ByteBuffer param3, T param4, int param5, int param6) {
            this.address = param1;
            this.container = param3;
            this.factory = param4;
            this.index = param5;
            this.fence = param6;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> param1) {
            Objects.requireNonNull(param1);
            if (this.index < this.fence) {
                param1.accept(((Struct)this.factory).create(this.address + Integer.toUnsignedLong(this.index++) * (long)((Struct)this.factory).sizeof(), this.container));
                return true;
            }
            return false;
        }

        @Override
        @Nullable
        public Spliterator<T> trySplit() {
            StructSpliterator<T> structSpliterator;
            int v1 = this.index;
            int v2 = v1 + this.fence >>> 1;
            if (v1 < v2) {
                this.index = v2;
                structSpliterator = new StructSpliterator<T>(this.address, this.container, this.factory, v1, v2);
            } else {
                structSpliterator = null;
            }
            return structSpliterator;
        }

        @Override
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override
        public int characteristics() {
            return 17744;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> param1) {
            int v2;
            Objects.requireNonNull(param1);
            try {
                int v3 = ((Struct)this.factory).sizeof();
                for (v2 = this.index; v2 < this.fence; ++v2) {
                    param1.accept(((Struct)this.factory).create(this.address + Integer.toUnsignedLong(v2) * (long)v3, this.container));
                }
                return;
            }
            finally {
                this.index = v2;
            }
        }

        @Override
        public Comparator<? super T> getComparator() {
            throw new IllegalStateException();
        }
    }

    private static class StructIterator<T extends Struct<T>>
    implements Iterator<T> {
        private long address;
        @Nullable
        private ByteBuffer container;
        private T factory;
        private int index;
        private int fence;

        StructIterator(long param1, @Nullable ByteBuffer param3, T param4, int param5, int param6) {
            this.address = param1;
            this.container = param3;
            this.factory = param4;
            this.index = param5;
            this.fence = param6;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.fence;
        }

        @Override
        public T next() {
            if (Checks.CHECKS && this.fence <= this.index) {
                throw new NoSuchElementException();
            }
            return (T)((Struct)this.factory).create(this.address + Integer.toUnsignedLong(this.index++) * (long)((Struct)this.factory).sizeof(), this.container);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> param1) {
            int v2;
            Objects.requireNonNull(param1);
            try {
                int v3 = ((Struct)this.factory).sizeof();
                for (v2 = this.index; v2 < this.fence; ++v2) {
                    param1.accept(((Struct)this.factory).create(this.address + Integer.toUnsignedLong(v2) * (long)v3, this.container));
                }
                return;
            }
            finally {
                this.index = v2;
            }
        }
    }
}

