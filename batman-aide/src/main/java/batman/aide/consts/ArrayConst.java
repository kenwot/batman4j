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

package batman.aide.consts;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Defines some array constants.
 *
 * @author Kenown
 * @since 1.0.0
 */
public interface ArrayConst {

    /**
     * An empty immutable {@code boolean} array.
     */
    boolean[] EMPTY_BOOLEAN_ARRAY = {};

    /**
     * An empty immutable {@link Boolean} array.
     */
    Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code char} array.
     */
    char[] EMPTY_CHAR_ARRAY = {};

    /**
     * An empty immutable {@link Character} array.
     */
    Character[] EMPTY_CHARACTER_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code byte} array.
     */
    byte[] EMPTY_BYTE_ARRAY = {};

    /**
     * An empty immutable {@link Byte} array.
     */
    Byte[] EMPTY_BYTE_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code short} array.
     */
    short[] EMPTY_SHORT_ARRAY = {};

    /**
     * An empty immutable {@link Short} array.
     */
    Short[] EMPTY_SHORT_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code int} array.
     */
    int[] EMPTY_INT_ARRAY = {};

    /**
     * An empty immutable {@link Integer} array.
     */
    Integer[] EMPTY_INTEGER_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code long} array.
     */
    long[] EMPTY_LONG_ARRAY = {};

    /**
     * An empty immutable {@link Long} array.
     */
    Long[] EMPTY_LONG_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code float} array.
     */
    float[] EMPTY_FLOAT_ARRAY = {};

    /**
     * An empty immutable {@link Float} array.
     */
    Float[] EMPTY_FLOAT_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@code double} array.
     */
    double[] EMPTY_DOUBLE_ARRAY = {};

    /**
     * An empty immutable {@link Double} array.
     */
    Double[] EMPTY_DOUBLE_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@link String} array.
     */
    String[] EMPTY_STRING_ARRAY = {};

    /**
     * An empty immutable {@link Object} array.
     */
    Object[] EMPTY_OBJECT_ARRAY = {};

    /**
     * An empty immutable {@link Throwable} array.
     */
    Throwable[] EMPTY_THROWABLE_ARRAY = {};

    /**
     * An empty immutable {@link Type} array.
     */
    Type[] EMPTY_TYPE_ARRAY = {};

    /**
     * An empty immutable {@link Class} array.
     */
    Class<?>[] EMPTY_CLASS_ARRAY = {};

    /**
     * An empty immutable {@link Field} array.
     */
    Field[] EMPTY_FIELD_ARRAY = {};

    /**
     * An empty immutable {@link Method} array.
     */
    Method[] EMPTY_METHOD_ARRAY = {};

}
