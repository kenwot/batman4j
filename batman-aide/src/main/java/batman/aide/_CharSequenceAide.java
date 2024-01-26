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
     * Used by the indexOf(CharSequence methods) as a green implementation of indexOf.
     *
     * @param cs     the {@link CharSequence} to be processed
     * @param search the {@link CharSequence} to be searched for
     * @param start  the start index
     * @return the index where the search sequence was found
     */
    static int indexOf(final CharSequence cs, final CharSequence search, final int start) {
        if (cs instanceof String string) {
            return string.indexOf(search.toString(), start);
        }
        if (cs instanceof StringBuilder builder) {
            return builder.indexOf(search.toString(), start);
        }
        if (cs instanceof StringBuffer buffer) {
            return buffer.indexOf(search.toString(), start);
        }
        return cs.toString().indexOf(search.toString(), start);
    }

    /**
     * Returns the index within {@code cs} of the first occurrence of the
     * specified character, starting the search at the specified index.
     *
     * <p>If a character with value {@code searchChar} occurs in the
     * character sequence represented by the {@code cs}
     * object at an index no smaller than {@code start}, then
     * the index of the first such occurrence is returned.</p>
     *
     * <p>For values of {@code searchChar} in the range from 0 to 0xFFFF (inclusive), this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote></p>
     *
     * <p>For other values of {@code searchChar}, it is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote></p>
     *
     * <p>In either case, if no such character occurs inm {@code cs}
     * at or after position {@code start}, then {@code -1} is returned.</p>
     *
     * <p>There is no restriction on the value of {@code start}.
     * If it is negative, it has the same effect as if it were zero: the entire {@link CharSequence} may be searched.
     * If it is greater than the length of {@code cs}, it has the same effect as if it were
     * equal to the length of {@code cs}: {@code -1} is returned.</p>
     *
     * <p>All indices are specified in {@code char} values (Unicode code units).</p>
     *
     * @param cs         the {@link CharSequence} to be processed, not null
     * @param searchChar the char to be searched for
     * @param start      the start index, negative starts at the string start
     * @return the index where the search char was found, -1 if not found
     */
    static int indexOf(final CharSequence cs, final int searchChar, int start) {
        if (cs instanceof String string) {
            return string.indexOf(searchChar, start);
        }
        final int length = cs.length();
        if (start < 0) {
            start = 0;
        }
        if (searchChar < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
            for (int i = start; i < length; i++) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }
            return NOT_FOUND;
        }
        // supplementary characters (LANG1300)
        if (searchChar <= Character.MAX_CODE_POINT) {
            final char[] chars = Character.toChars(searchChar);
            for (int i = start; i < length - 1; i++) {
                final char high = cs.charAt(i);
                final char low = cs.charAt(i + 1);
                if (high == chars[0] && low == chars[1]) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }

    /**
     * Green implementation of regionMatches.
     *
     * @param sequence    the {@link CharSequence} to be processed
     * @param ignoreCase  whether to be case-insensitive
     * @param thisStart   the index to start on the {@code cs} CharSequence
     * @param subsequence the {@link CharSequence} to be looked for
     * @param subStart    the index to start on the {@code substring} CharSequence
     * @param length      character length of the region
     * @return whether the region matched
     */
    static boolean regionMatches(final CharSequence sequence, final boolean ignoreCase, final int thisStart,
                                 final CharSequence subsequence, final int subStart, final int length) {
        if (sequence instanceof String string && subsequence instanceof String substring) {
            return string.regionMatches(ignoreCase, thisStart, substring, subStart, length);
        }

        if (thisStart < 0 || subStart < 0 || length < 0) {
            return false;
        }

        final int srcLength = sequence.length() - thisStart;
        final int subLength = subsequence.length() - subStart;

        if (srcLength < length || subLength < length) {
            return false;
        }

        int thisIndex = thisStart;
        int subIndex = subStart;
        int tmpLength = length;

        while (tmpLength-- > 0) {
            final char thisChar = sequence.charAt(thisIndex++);
            final char subChar = subsequence.charAt(subIndex++);

            if (thisChar == subChar) {
                continue;
            }

            if (!ignoreCase) {
                return false;
            }

            final char thisCharUpper = Character.toUpperCase(thisChar);
            final char subCharUpper = Character.toUpperCase(subChar);
            if (thisCharUpper != subCharUpper
                    && Character.toLowerCase(thisCharUpper) != Character.toLowerCase(subCharUpper)) {
                return false;
            }
        }

        return true;
    }

}
