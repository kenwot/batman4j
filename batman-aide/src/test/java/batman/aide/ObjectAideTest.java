/*
 * Copyright the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package batman.aide;

import batman.aide.consts.ArrayConst;
import batman.aide.exception.CloneFailedException;
import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link ObjectAide} 单元测试
 *
 * @author Kenown
 * @since 1.0.0
 */
public class ObjectAideTest {

    private static final String FOO = "foo";
    private static final String BAR = "bar";
    private static final String[] NON_EMPTY_ARRAY = { FOO, BAR, };

    /**
     * String that is cloneable.
     */
    static final class CloneableString implements Cloneable, Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private final String value;

        CloneableString(final String s) {
            this.value = s;
        }

        @Override
        public CloneableString clone() throws CloneNotSupportedException {
            return (CloneableString) super.clone();
        }

        public String getValue() {
            return this.value;
        }
    }

    static final class UncloneableString implements Cloneable, Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private final String value;

        UncloneableString(final String s) {
            this.value = s;
        }
    }

    /**
     * Tests for {@link ObjectAide#isAllNonnull(Object...)}.
     */
    @Test
    public void testAllNonnull() {
        assertFalse(ObjectAide.isAllNonnull((Object) null));
        assertFalse(ObjectAide.isAllNonnull((Object[]) null));
        assertFalse(ObjectAide.isAllNonnull(null, null, null));
        assertFalse(ObjectAide.isAllNonnull(null, FOO, BAR));
        assertFalse(ObjectAide.isAllNonnull(FOO, BAR, null));
        assertFalse(ObjectAide.isAllNonnull(FOO, BAR, null, FOO, BAR));

        assertTrue(ObjectAide.isAllNonnull());
        assertTrue(ObjectAide.isAllNonnull(FOO));
        assertTrue(ObjectAide.isAllNonnull(FOO, BAR, 1, Boolean.TRUE, new Object(), new Object[]{}));
    }

    /**
     * Tests for {@link ObjectAide#isAllNull(Object...)}.
     */
    @Test
    public void testAllNull() {
        assertTrue(ObjectAide.isAllNull());
        assertTrue(ObjectAide.isAllNull((Object) null));
        assertTrue(ObjectAide.isAllNull((Object[]) null));
        assertTrue(ObjectAide.isAllNull(null, null, null));

        assertFalse(ObjectAide.isAllNull(FOO));
        assertFalse(ObjectAide.isAllNull(null, FOO, null));
        assertFalse(ObjectAide.isAllNull(null, null, null, null, FOO, BAR));
    }

    /**
     * Tests for {@link ObjectAide#isAnyNonnull(Object...)}.
     */
    @Test
    public void testAnyNonnull() {
        assertFalse(ObjectAide.isAnyNonnull());
        assertFalse(ObjectAide.isAnyNonnull((Object) null));
        assertFalse(ObjectAide.isAnyNonnull((Object[]) null));
        assertFalse(ObjectAide.isAnyNonnull(null, null, null));

        assertTrue(ObjectAide.isAnyNonnull(FOO));
        assertTrue(ObjectAide.isAnyNonnull(null, FOO, null));
        assertTrue(ObjectAide.isAnyNonnull(null, null, null, null, FOO, BAR));
    }

    /**
     * Tests for {@link ObjectAide#isAnyNull(Object...)}.
     */
    @Test
    public void testAnyNull() {
        assertTrue(ObjectAide.isAnyNull((Object) null));
        assertTrue(ObjectAide.isAnyNull(null, null, null));
        assertTrue(ObjectAide.isAnyNull(null, FOO, BAR));
        assertTrue(ObjectAide.isAnyNull(FOO, BAR, null));
        assertTrue(ObjectAide.isAnyNull(FOO, BAR, null, FOO, BAR));

        assertFalse(ObjectAide.isAnyNull());
        assertFalse(ObjectAide.isAnyNull(FOO));
        assertFalse(ObjectAide.isAnyNull(FOO, BAR, 1, Boolean.TRUE, new Object(), new Object[]{}));
    }

    /**
     * Test for {@link ObjectAide#isArray(Object)}.
     */
    @Test
    public void testArray() {
        assertFalse(ObjectAide.isArray(null));
        assertFalse(ObjectAide.isArray(""));
        assertFalse(ObjectAide.isArray("abg"));
        assertFalse(ObjectAide.isArray(123));
        assertTrue(ObjectAide.isArray(NON_EMPTY_ARRAY));
        assertTrue(ObjectAide.isArray(new int[]{1, 2, 3}));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_BOOLEAN_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_BOOLEAN_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_BOOLEAN_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_BYTE_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_BYTE_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_CHAR_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_CHARACTER_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_CLASS_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_DOUBLE_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_DOUBLE_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_FIELD_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_FLOAT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_FLOAT_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_INT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_INTEGER_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_LONG_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_LONG_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_METHOD_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_SHORT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_SHORT_OBJECT_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_STRING_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_THROWABLE_ARRAY));
        assertTrue(ObjectAide.isArray(ArrayConst.EMPTY_TYPE_ARRAY));
    }

    /**
     * Tests {@link ObjectAide#clone(Object)} with a cloneable object.
     */
    @Test
    public void testCloneOfCloneable() {
        final CloneableString string = new CloneableString("batman");
        final CloneableString stringClone = ObjectAide.clone(string);
        assertEquals("batman", stringClone.getValue());
    }

    /**
     * Tests {@link ObjectAide#clone(Object)} with a not cloneable object.
     */
    @Test
    public void testCloneOfNotCloneable() {
        final String string = "batman";
        assertNull(ObjectAide.clone(string));
    }

    /**
     * Tests {@link ObjectAide#clone(Object)} with an array of primitives.
     */
    @Test
    public void testCloneOfPrimitiveArray() {
        assertArrayEquals(new int[]{1}, ObjectAide.clone(new int[]{1}));
    }

    /**
     * Tests {@link ObjectAide#clone(Object)} with an object array.
     */
    @Test
    public void testCloneOfStringArray() {
        assertTrue(Arrays.deepEquals(
                new String[]{"string"}, ObjectAide.clone(new String[]{"string"})));
    }

    /**
     * Tests {@link ObjectAide#clone(Object)} with an uncloneable object.
     */
    @Test
    public void testCloneOfUncloneable() {
        final UncloneableString string = new UncloneableString("batman");
        final CloneFailedException e = assertThrows(CloneFailedException.class, () -> ObjectAide.clone(string));
        assertEquals(NoSuchMethodException.class, e.getCause().getClass());
    }


}
