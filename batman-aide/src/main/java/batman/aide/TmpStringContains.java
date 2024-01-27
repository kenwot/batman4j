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

/**
 * @author Kenown
 * @since 1.0.0
 */
public class TmpStringContains {

    public static boolean isEmpty(CharSequence sequence) {
        return StringAide.isEmpty(sequence);
    }

    public static int length(CharSequence sequence) {
        return StringAide.length(sequence);
    }

    public static final int INDEX_NOT_FOUND = -1;


    public static boolean contains(CharSequence sequence, CharSequence search) {
        if (sequence == null || search == null) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, search, 0) >= 0;
    }

    public static boolean contains(CharSequence sequence, CharSequence search, int beginIndex) {
        if (sequence == null || search == null) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, search, beginIndex) >= 0;
    }

    public static boolean contains(CharSequence sequence, CharSequence search, int beginIndex, int endIndex) {
        if (sequence == null || search == null) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, search, beginIndex, endIndex) >= 0;
    }

    public static boolean containsIgnoreCase(CharSequence sequence, CharSequence search) {
        return containsIgnoreCase(sequence, search, 0);
    }

    public static boolean containsIgnoreCase(CharSequence sequence, CharSequence search, int beginIndex) {
        if (sequence == null || search == null) {
            return false;
        }
        int searchLength = search.length();
        int endLimit = sequence.length() - searchLength;
        for (int i = beginIndex; i <= endLimit; i++) {
            if (_CharSequenceAide.regionMatches(true, sequence, i, search, 0, searchLength)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence sequence, CharSequence search, int beginIndex, int endIndex) {
        if (sequence == null || search == null) {
            return false;
        }
        int sequenceLength = sequence.length();
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > sequenceLength) {
            endIndex = sequenceLength;
        }
        if (endIndex < beginIndex) {
            return false;
        }

        int searchLength = search.length();
        int endLimit = Math.min(sequenceLength - searchLength, endIndex);
        if (endIndex < sequenceLength) {
            sequence = sequence.subSequence(0, endIndex);
        }
        for (int i = beginIndex; i <= endLimit; i++) {
            if (_CharSequenceAide.regionMatches(true, sequence, i, search, 0, searchLength)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAny(CharSequence sequence, CharSequence... searches) {
        return true;
    }

    public static boolean containsAny(CharSequence sequence, CharSequence[] searches, int beginIndex) {
        return true;
    }

    public static boolean containsAny(CharSequence sequence, CharSequence[] searches, int beginIndex, int endIndex) {
        return true;
    }

    public static boolean containsAnyIgnoreCase(CharSequence sequence, CharSequence... searches) {
        return true;
    }

    public static boolean containsAnyIgnoreCase(CharSequence sequence, CharSequence[] searches, int beginIndex) {
        return true;
    }

    public static boolean containsAnyIgnoreCase(CharSequence sequence, CharSequence[] searches, int beginIndex, int endIndex) {
        return true;
    }

    public static boolean containsNone(CharSequence sequence, CharSequence... searches) {
        return true;
    }

    public static boolean containsNone(CharSequence sequence, CharSequence[] searches, int beginIndex) {
        return true;
    }

    public static boolean containsNone(CharSequence sequence, CharSequence[] searches, int beginIndex, int endIndex) {
        return true;
    }

    public static boolean containsNoneIgnoreCase(CharSequence sequence, CharSequence... searches) {
        return true;
    }

    public static boolean containsNoneIgnoreCase(CharSequence sequence, CharSequence[] searches, int beginIndex) {
        return true;
    }

    public static boolean containsNoneIgnoreCase(CharSequence sequence, CharSequence[] searches, int beginIndex, int endIndex) {
        return true;
    }

}
