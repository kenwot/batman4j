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

    public static int length(Object array) {
        return array != null ? Array.getLength(array) : 0;
    }

    public static boolean isEmpty(boolean[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(char[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(byte[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(short[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(int[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(long[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(float[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(double[] array) {
        return length(array) == 0;
    }

    public static boolean isEmpty(Object[] array) {
        return length(array) == 0;
    }

    public static boolean isNotEmpty(boolean[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(char[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(byte[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(short[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(int[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(long[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(float[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(double[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

}
