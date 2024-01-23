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

import java.lang.reflect.Array;

/**
 * TODO-Kenown ArrayAide
 *
 * @author Kenown
 * @since 1.0.0
 */
public class ArrayAide {

    public static int length(final Object array) {
        return array != null ? Array.getLength(array) : 0;
    }

    public static boolean isEmpty(final boolean[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final char[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final byte[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final short[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final int[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final long[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final float[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final double[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(final Object[] array) {
        return length(array) == 0;
    }

    public static boolean isNotEmpty(final boolean[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final char[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final byte[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final short[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final int[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final long[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final float[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final double[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(final Object[] array) {
        return !isEmpty(array);
    }

}
