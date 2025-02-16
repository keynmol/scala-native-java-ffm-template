// Generated by jextract

package myscalalib_bindings;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct {
 *     myscalalib_operation op;
 *     char *label;
 * }
 * }
 */
public class myscalalib_config {

    myscalalib_config() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        interface_h.C_INT.withName("op"),
        MemoryLayout.paddingLayout(4),
        interface_h.C_POINTER.withName("label")
    ).withName("$anon$3:9");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt op$LAYOUT = (OfInt)$LAYOUT.select(groupElement("op"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * myscalalib_operation op
     * }
     */
    public static final OfInt op$layout() {
        return op$LAYOUT;
    }

    private static final long op$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * myscalalib_operation op
     * }
     */
    public static final long op$offset() {
        return op$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * myscalalib_operation op
     * }
     */
    public static int op(MemorySegment struct) {
        return struct.get(op$LAYOUT, op$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * myscalalib_operation op
     * }
     */
    public static void op(MemorySegment struct, int fieldValue) {
        struct.set(op$LAYOUT, op$OFFSET, fieldValue);
    }

    private static final AddressLayout label$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("label"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char *label
     * }
     */
    public static final AddressLayout label$layout() {
        return label$LAYOUT;
    }

    private static final long label$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char *label
     * }
     */
    public static final long label$offset() {
        return label$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char *label
     * }
     */
    public static MemorySegment label(MemorySegment struct) {
        return struct.get(label$LAYOUT, label$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char *label
     * }
     */
    public static void label(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(label$LAYOUT, label$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}

