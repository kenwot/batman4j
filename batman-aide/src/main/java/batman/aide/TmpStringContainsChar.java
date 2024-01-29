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

/**
 * @author Kenown
 * @since 1.0.0
 */
public class TmpStringContainsChar {

    public static boolean isEmpty(CharSequence sequence) {
        return StringAide.isEmpty(sequence);
    }

    public static int length(CharSequence sequence) {
        return StringAide.length(sequence);
    }

    public static char[] toCharArray(CharSequence sequence) {
        int length = length(sequence);
        if (length == 0) {
            return ArrayConst.EMPTY_CHAR_ARRAY;
        }
        if (sequence instanceof String string) {
            return string.toCharArray();
        }
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = sequence.charAt(i);
        }
        return array;
    }

    public static final int INDEX_NOT_FOUND = -1;





    public static int indexOfNotAnyChar(CharSequence sequence, int... searches) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, int[] searches, int beginIndex) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, int[] searches, int beginIndex, int endIndex) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, char... searches) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, char[] searches, int beginIndex) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, char[] searches, int beginIndex, int endIndex) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, CharSequence searches) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, CharSequence searches, int beginIndex) {
        return 0;
    }

    public static int indexOfNotAnyChar(CharSequence sequence, CharSequence searches, int beginIndex, int endIndex) {
        return 0;
    }

}
