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
 * TODO-Kenown _CharSequenceAide
 *
 * @author Kenown
 * @since 1.0.0
 */
class _CharSequenceAide {

    static final int NOT_FOUND = -1;

    static final int TO_STRING_LIMIT = 16;

    /**
     * Used by the indexOf(CharSequence methods) as a green implementation of indexOf.
     *
     * @param cs the {@link CharSequence} to be processed
     * @param search the {@link CharSequence} to be searched for
     * @param start the start index
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
     * 搜索字符序列 {@code cs} 中指定字符 {@code searchChar} 第一次出现的索引位置，从指定索引 {@code start} 处开始搜索。
     *
     * <p>
     * 对于 0 到 0xFFFF（含）范围内的 {@code searchChar}，结果为满足以下条件的最小 <i>k</i> 值：
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote>
     *
     * 对于其他值的 {@code searchChar}，结果为满足以下条件的最小 <i>k</i> 值：
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= start)
     * </pre></blockquote>
     *
     * 无论哪种情况，如果 {@code cs} 中在 {@code start} 处或之后没有出现 {@code searchChar} 字符，则返回 {@code -1}。
     * </p>
     *
     * <p>
     * {@code start} 的值没有限制。
     * 如果是负数，则等同于零（搜索整个字符序列）；
     * 如果大于字符序列的长度，则等同于字符序列的长度（返回 {@code -1}）。
     * </p>
     *
     * <p>
     * 所有索引都以 {@code char} 值（Unicode 代码单元）指定。
     * </p>
     *
     * @param cs 要处理的 {@link CharSequence}，不能为 {@code null}
     * @param searchChar 要搜索的字符
     * @param start 起始索引
     * @return 搜索字符的第一个索引位置，如果未找到则为 {@code -1}
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
        // 增补字符 LANG1300
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
     * @param sequence the {@link CharSequence} to be processed
     * @param ignoreCase whether or not to be case-insensitive
     * @param thisStart the index to start on the {@code cs} CharSequence
     * @param subsequence the {@link CharSequence} to be looked for
     * @param subStart the index to start on the {@code substring} CharSequence
     * @param length character length of the region
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
