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
class _CharSequenceAide {

    static final int NOT_FOUND = -1;

    static final int TO_STRING_LIMIT = 16;


    /**
     * Returns the index within a CharSequence of the first occurrence of the specified subsequence,
     * starting at the specified index.
     *
     * <p>This is an internal utility method and does not handle {@code null}.
     *
     * @param sequence   the CharSequence to be processed.
     * @param search     the subsequence to search for.
     * @param beginIndex the index from which to start the search.
     * @return the index where the search sequence was found.
     */
    static int indexOf(CharSequence sequence, CharSequence search, int beginIndex) {
        if (sequence instanceof String string) {
            return string.indexOf(search.toString(), beginIndex);
        }
        if (sequence instanceof StringBuilder builder) {
            return builder.indexOf(search.toString(), beginIndex);
        }
        if (sequence instanceof StringBuffer buffer) {
            return buffer.indexOf(search.toString(), beginIndex);
        }
        return sequence.toString().indexOf(search.toString(), beginIndex);
    }

    /**
     * Returns the index of the first occurrence of the specified subsequence
     * within the specified index range of a CharSequence.
     *
     * <p>This is an internal utility method and does not handle {@code null}.
     *
     * @param sequence   the CharSequence to be processed.
     * @param search     the subsequence to search for.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex   the index to stop the search at (excluded).
     * @return the index of the first occurrence of the specified subsequence within the specified index range,
     *         or -1 if there is no such occurrence.
     */
    static int indexOf(CharSequence sequence, CharSequence search, int beginIndex, int endIndex) {
        int sequenceLength = sequence.length();
        if (beginIndex > sequenceLength) {
            return NOT_FOUND;
        }
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > sequenceLength) {
            endIndex = sequenceLength;
        }
        if (endIndex <= beginIndex) {
            return NOT_FOUND;
        }
        if (sequence instanceof String string) {
            return string.indexOf(search.toString(), beginIndex, endIndex);
        }
        return sequence.toString().indexOf(search.toString(), beginIndex, endIndex);
    }

    static int lastIndexOf(CharSequence sequence, CharSequence search, int start) {
        if (search == null || sequence == null) {
            return NOT_FOUND;
        }
        if (search instanceof String searchStr) {
            if (sequence instanceof String string) {
                return string.lastIndexOf(searchStr, start);
            }
            if (sequence instanceof StringBuilder builder) {
                return builder.lastIndexOf(searchStr, start);
            }
            if (sequence instanceof StringBuffer buffer) {
                return buffer.lastIndexOf(searchStr, start);
            }
        }

        int sequenceLength = sequence.length();
        int searchLength = search.length();
        if (start > sequenceLength) {
            start = sequenceLength;
        }
        if (start < 0 || searchLength > sequenceLength) {
            return NOT_FOUND;
        }
        if (searchLength == 0) {
            return start;
        }

        if (searchLength <= TO_STRING_LIMIT) {
            if (sequence instanceof String string) {
                return string.lastIndexOf(search.toString(), start);
            }
            if (sequence instanceof StringBuilder builder) {
                return builder.lastIndexOf(search.toString(), start);
            }
            if (sequence instanceof StringBuffer buffer) {
                return buffer.lastIndexOf(search.toString(), start);
            }
        }

        if (start + searchLength > sequenceLength) {
            start = sequenceLength - searchLength;
        }

        char char0 = search.charAt(0);

        int i = start;
        while (true) {
            while (sequence.charAt(i) != char0) {
                i--;
                if (i < 0) {
                    return NOT_FOUND;
                }
            }
            if (checkLaterThan1(sequence, search, searchLength, i)) {
                return i;
            }
            i--;
            if (i < 0) {
                return NOT_FOUND;
            }
        }
    }

    private static boolean checkLaterThan1(CharSequence sequence, CharSequence search, int searchLength, int start1) {
        for (int i = 1, j = searchLength - 1; i <= j; i++, j--) {
            if (sequence.charAt(start1 + i) != search.charAt(i) || sequence.charAt(start1 + j) != search.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character,
     * starting the search at the specified index.
     *
     * <p>This method uses {@link String#indexOf(String, int)} if possible.
     *
     * <p>If a character with value {@code search} occurs in the character sequence
     * represented by the CharSequence object at an index no smaller than {@code beginIndex},
     * then the index (in Unicode code units) of the first such occurrence is returned.
     *
     * <p>For values of {@code search} in the range from 0 to 0xFFFF (inclusive),
     * the result is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == search) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote>
     *
     * <p>For other values of {@code search}, the result is the smallest value {@code k} such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == search) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote>
     *
     * <p>In either case, if no such character occurs in the CharSequence at or after position {@code beginIndex},
     * then -1 is returned.
     *
     * <p>There is no restriction on the value of {@code beginIndex}.
     * If it is negative, it has the same effect as if it were zero: the entire CharSequence may be searched.
     * If it is greater than the length of the CharSequence,
     * it has the same effect as if it were equal to the length of the CharSequence: {@code -1} is returned.
     *
     * <p>All indices are specified in {@code char} values (Unicode code units).
     *
     * @param sequence   the CharSequence to be processed, not null.
     * @param search     the char to be searched for (Unicode code point).
     * @param beginIndex the index to start the search from.
     * @return the index where the search char was found, or -1 if not found.
     */
    static int indexOf(CharSequence sequence, int search, int beginIndex) {
        return indexOf(sequence, search, beginIndex, sequence.length());
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>This method uses {@link String#indexOf(String, int)} if possible.
     *
     * <p>If a character with value {@code search} occurs in the character sequence
     * represented by the CharSequence object at an index no smaller than {@code beginIndex},
     * then the index (in Unicode code units) of the first such occurrence is returned.
     *
     * <p>For values of {@code search} in the range from 0 to 0xFFFF (inclusive),
     * the result is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == search) &amp;&amp; (beginIndex &lt;= <i>k</i> &lt; endIndex)
     * </pre></blockquote>
     *
     * <p>For other values of {@code search}, the result is the smallest value {@code k} such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == search) &amp;&amp; (beginIndex &lt;= <i>k</i> &lt; endIndex)
     * </pre></blockquote>
     *
     * <p>In either case, if no such character occurs in the CharSequence
     * at or after position {@code beginIndex} and before position {@code endIndex}, then -1 is returned.
     *
     * <p>If {@code beginIndex} is negative, it has the same effect as if it were zero.
     * If {@code beginIndex} is greater than the length of the CharSequence, {@code -1} is returned.
     * If {@code endIndex} is greater than the length of the CharSequence,
     * it has the same effect as if it were equal to the length of the CharSequence.
     * If {@code endIndex <= beginIndex}, {@code -1} is returned.
     *
     * <p>All indices are specified in {@code char} values (Unicode code units).
     *
     * @param sequence   the CharSequence to be processed, not null.
     * @param search     the char to be searched for (Unicode code point).
     * @param beginIndex the index to start the search from, inclusive.
     * @param endIndex   the index to start the search from, exclusive.
     * @return the index of the first occurrence of the character in the CharSequence
     *         that is greater than or equal to {@code beginIndex} and less than {@code endIndex},
     *         or {@code -1} if the character does not occur.
     */
    static int indexOf(CharSequence sequence, int search, int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        int sequenceLength = sequence.length();
        if (beginIndex > sequenceLength) {
            return NOT_FOUND;
        }
        if (endIndex > sequenceLength) {
            endIndex = sequenceLength;
        }
        if (endIndex <= beginIndex) {
            return NOT_FOUND;
        }
        if (sequence instanceof String string) {
            return string.indexOf(search, beginIndex, endIndex);
        }
        // Basic Multilingual Plane
        if (search < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
            for (int i = beginIndex; i < endIndex; i++) {
                if (sequence.charAt(i) == search) {
                    return i;
                }
            }
            return NOT_FOUND;
        }
        // supplementary characters
        if (search <= Character.MAX_CODE_POINT) {
            char[] chars = Character.toChars(search);
            for (int i = beginIndex; i < endIndex - 1; i++) {
                char high = sequence.charAt(i);
                char low = sequence.charAt(i + 1);
                if (high == chars[0] && low == chars[1]) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }

    /**
     * Tests if two CharSequence regions are equal.
     *
     * <p>This method uses {@link String#regionMatches(boolean, int, String, int, int)} if possible.
     *
     * @param ignoreCase   whether to be case-insensitive
     * @param thisSequence the CharSequence to be compared.
     * @param thisOffset   the starting offset of the subregion in the CharSequence.
     * @param thatSequence another CharSequence to be compared.
     * @param thatOffset   the starting offset of the subregion in another CharSequence.
     * @param length       character length of the region
     * @return whether the region matched
     */
    static boolean regionMatches(boolean ignoreCase,
                                 CharSequence thisSequence, int thisOffset,
                                 CharSequence thatSequence, int thatOffset,
                                 int length) {
        if (thisSequence instanceof String string && thatSequence instanceof String substring) {
            return string.regionMatches(ignoreCase, thisOffset, substring, thatOffset, length);
        }

        if (thisOffset < 0 || thatOffset < 0 || length < 0) {
            return false;
        }

        int thisLength = thisSequence.length() - thisOffset;
        int thatLength = thatSequence.length() - thatOffset;

        if (thisLength < length || thatLength < length) {
            return false;
        }

        int thisIndex = thisOffset;
        int thatIndex = thatOffset;

        while (length-- > 0) {
            char thisChar = thisSequence.charAt(thisIndex++);
            char thatChar = thatSequence.charAt(thatIndex++);

            if (thisChar == thatChar) {
                continue;
            }

            if (!ignoreCase) {
                return false;
            }

            char thisCharUpper = Character.toUpperCase(thisChar);
            char thatCharUpper = Character.toUpperCase(thatChar);
            if (thisCharUpper != thatCharUpper
                    && Character.toLowerCase(thisCharUpper) != Character.toLowerCase(thatCharUpper)) {
                return false;
            }
        }

        return true;
    }

}
