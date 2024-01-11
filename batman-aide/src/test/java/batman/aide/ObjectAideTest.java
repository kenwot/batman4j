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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link ObjectAide} 单元测试
 *
 * @author Kenown
 * @since 1.0.0
 */
public class ObjectAideTest {

    private static final String FOO = "foo";
    private static final String BAR = "bar";

    /**
     * Tests {@link ObjectAide#allNonnull(Object...)}.
     */
    @Test
    public void testAllNonnull() {
        assertFalse(ObjectAide.allNonnull((Object) null));
        assertFalse(ObjectAide.allNonnull((Object[]) null));
        assertFalse(ObjectAide.allNonnull(null, null, null));
        assertFalse(ObjectAide.allNonnull(null, FOO, BAR));
        assertFalse(ObjectAide.allNonnull(FOO, BAR, null));
        assertFalse(ObjectAide.allNonnull(FOO, BAR, null, FOO, BAR));

        assertTrue(ObjectAide.allNonnull());
        assertTrue(ObjectAide.allNonnull(FOO));
        assertTrue(ObjectAide.allNonnull(FOO, BAR, 1, Boolean.TRUE, new Object(), new Object[]{}));
    }

    /**
     * Tests {@link ObjectAide#allNull(Object...)}.
     */
    @Test
    public void testAllNull() {
        assertTrue(ObjectAide.allNull());
        assertTrue(ObjectAide.allNull((Object) null));
        assertTrue(ObjectAide.allNull((Object[]) null));
        assertTrue(ObjectAide.allNull(null, null, null));

        assertFalse(ObjectAide.allNull(FOO));
        assertFalse(ObjectAide.allNull(null, FOO, null));
        assertFalse(ObjectAide.allNull(null, null, null, null, FOO, BAR));
    }

    /**
     * Tests {@link ObjectAide#anyNonnull(Object...)}.
     */
    @Test
    public void testAnyNonnull() {
        assertFalse(ObjectAide.anyNonnull());
        assertFalse(ObjectAide.anyNonnull((Object) null));
        assertFalse(ObjectAide.anyNonnull((Object[]) null));
        assertFalse(ObjectAide.anyNonnull(null, null, null));

        assertTrue(ObjectAide.anyNonnull(FOO));
        assertTrue(ObjectAide.anyNonnull(null, FOO, null));
        assertTrue(ObjectAide.anyNonnull(null, null, null, null, FOO, BAR));
    }

    /**
     * Tests {@link ObjectAide#anyNull(Object...)}.
     */
    @Test
    public void testAnyNull() {
        assertTrue(ObjectAide.anyNull((Object) null));
        assertTrue(ObjectAide.anyNull(null, null, null));
        assertTrue(ObjectAide.anyNull(null, FOO, BAR));
        assertTrue(ObjectAide.anyNull(FOO, BAR, null));
        assertTrue(ObjectAide.anyNull(FOO, BAR, null, FOO, BAR));

        assertFalse(ObjectAide.anyNull());
        assertFalse(ObjectAide.anyNull(FOO));
        assertFalse(ObjectAide.anyNull(FOO, BAR, 1, Boolean.TRUE, new Object(), new Object[]{}));
    }

}
