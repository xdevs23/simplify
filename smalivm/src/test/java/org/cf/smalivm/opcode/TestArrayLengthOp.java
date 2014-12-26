package org.cf.smalivm.opcode;

import gnu.trove.map.TIntObjectMap;

import org.cf.smalivm.VMTester;
import org.cf.smalivm.context.HeapItem;
import org.cf.smalivm.type.UnknownValue;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class TestArrayLengthOp {

    private static final String CLASS_NAME = "Larray_length_test;";

    public static class TestObjectArrays {
        @Test
        public void testArrayLengthForEmptyIntegerArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new Integer[] {}, "[I");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 0, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForIntegerArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new Integer[] { 1, 2, 3 }, "[I");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 3, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForStringArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new String[] { "isn't", "this", "where" },
                            "[I");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 3, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForUnknownValueOfIntegerType() {
            TIntObjectMap<HeapItem> initial = VMTester
                            .buildRegisterState(0, new UnknownValue(), "[Ljava/lang/Integer;");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, new UnknownValue(), "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForUnknownValueOfPrimitiveType() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new UnknownValue(), "[I");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, new UnknownValue(), "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }
    }

    public static class TestPrimitiveArrays {
        @Test
        public void testArrayLengthForEmptyIntArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new int[] {}, "[I");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 0, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForIntArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new int[] { 1, 2, 3 }, "[I");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 3, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForLongArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new long[] { 1, 2, 3, 4 }, "[J");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 4, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

        @Test
        public void testArrayLengthForShortArray() {
            TIntObjectMap<HeapItem> initial = VMTester.buildRegisterState(0, new short[] { 1, 2 }, "[S");
            TIntObjectMap<HeapItem> expected = VMTester.buildRegisterState(0, 2, "I");

            VMTester.testMethodState(CLASS_NAME, "ArrayLength()V", initial, expected);
        }

    }

}
