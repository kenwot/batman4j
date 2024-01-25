/*
 * Copyright the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package batman.aide;

import batman.aide.consts.ArrayConst;
import batman.aide.consts.CharConst;
import batman.aide.consts.StringConst;

/**
 * 操作字符串的工具方法。
 *
 * @author Kenown
 * @since 1.0.0
 */
public class StringAide implements StringConst {

    public static final int INDEX_NOT_FOUND = _CharSequenceAide.NOT_FOUND;

    /**
     * 获取字符序列 {@link CharSequence} 的长度，如果 CharSequence 为 {@code null} 则返回 {@code 0}。
     *
     * @param sequence CharSequence 或 {@code null}
     * @return CharSequence 的长度，如果 CharSequence 为 {@code null} 则为 {@code 0}
     */
    public static int length(final CharSequence sequence) {
        return sequence == null ? 0 : sequence.length();
    }

    /**
     * 获取字符序列 {@link CharSequence} 的代码点长度，如果 CharSequence 为 {@code null} 则返回 {@code 0}。
     *
     * @param sequence CharSequence 或 {@code null}
     * @return CharSequence 的代码点长度，如果 CharSequence 为 {@code null} 则为 {@code 0}
     */
    public static int codepointLength(final CharSequence sequence) {
        return sequence == null ? 0 : (int) sequence.codePoints().count();
    }

    /**
     * 检查字符序列是否为 {@code empty}（""）或者 {@code null}。
     *
     * <pre>
     * StringAide.isEmpty(null)      = true
     * StringAide.isEmpty("")        = true
     * StringAide.isEmpty(" ")       = false
     * StringAide.isEmpty("bob")     = false
     * StringAide.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param sequence 要检查的 CharSequence，可能为 {@code null}
     * @return 若 CharSequence 为 {@code empty} 或 {@code null} 则为 {@code true}，否则为 {@code false}
     */
    public static boolean isEmpty(final CharSequence sequence) {
        return sequence == null || sequence.isEmpty();
    }

    /**
     * 检查字符序列是否不为 {@code empty}（""）而且不为 {@code null}。
     *
     * <pre>
     * StringAide.isNotEmpty(null)      = false
     * StringAide.isNotEmpty("")        = false
     * StringAide.isNotEmpty(" ")       = true
     * StringAide.isNotEmpty("bob")     = true
     * StringAide.isNotEmpty("  bob  ") = true
     * </pre>
     *
     * @param sequence 要检查的 CharSequence，可能为 {@code null}
     * @return 若 CharSequence 不为 {@code empty} 且不为 {@code null} 则为 {@code true}，否则为 {@code false}
     */
    public static boolean isNotEmpty(final CharSequence sequence) {
        return !isEmpty(sequence);
    }

    /**
     * 检查所有字符序列是否都为 {@code empty}（""）或者 {@code null}。
     *
     * <pre>
     * StringAide.isAllEmpty(null)             = true
     * StringAide.isAllEmpty(null, "")         = true
     * StringAide.isAllEmpty(new String[] {})  = true
     * StringAide.isAllEmpty(null, "foo")      = false
     * StringAide.isAllEmpty("", "bar")        = false
     * StringAide.isAllEmpty("bob", "")        = false
     * StringAide.isAllEmpty("  bob  ", null)  = false
     * StringAide.isAllEmpty(" ", "bar")       = false
     * StringAide.isAllEmpty("foo", "bar")     = false
     * </pre>
     *
     * @param sequences 要检查的字符序列数组，可能为 {@code null} 或 {@code empty}
     * @return 若所有 CharSequence 都为 {@code empty} 或者 {@code null} 则为 {@code true}，否则为 {@code false}
     */
    public static boolean isAllEmpty(final CharSequence... sequences) {
        if (ArrayAide.isEmpty(sequences)) {
            return true;
        }
        for (CharSequence cs : sequences) {
            if (isNotEmpty(cs)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查字符序列数组中是否存在任何为 {@code empty} 或 {@code null} 的元素。
     *
     * <pre>
     * StringAide.isAnyEmpty((String) null)    = true
     * StringAide.isAnyEmpty((String[]) null)  = false
     * StringAide.isAnyEmpty(null, "foo")      = true
     * StringAide.isAnyEmpty("", "bar")        = true
     * StringAide.isAnyEmpty("bob", "")        = true
     * StringAide.isAnyEmpty("  bob  ", null)  = true
     * StringAide.isAnyEmpty(" ", "bar")       = false
     * StringAide.isAnyEmpty("foo", "bar")     = false
     * StringAide.isAnyEmpty(new String[]{})   = false
     * StringAide.isAnyEmpty(new String[]{""}) = true
     * </pre>
     *
     * @param sequences 要检查的字符序列数组，可能为 {@code null} 或 {@code empty}
     * @return 若存在任何 {@code empty} 或 {@code null} 的元素则为 {@code true}，否则为 {@code false}
     */
    public static boolean isAnyEmpty(final CharSequence... sequences) {
        if (ArrayAide.isEmpty(sequences)) {
            return false;
        }
        for (CharSequence cs : sequences) {
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查所有字符序列是否都不为 {@code empty} 且都不为 {@code null}。
     *
     * <pre>
     * StringAide.isNoneEmpty((String) null)    = false
     * StringAide.isNoneEmpty((String[]) null)  = true
     * StringAide.isNoneEmpty(null, "foo")      = false
     * StringAide.isNoneEmpty("", "bar")        = false
     * StringAide.isNoneEmpty("bob", "")        = false
     * StringAide.isNoneEmpty("  bob  ", null)  = false
     * StringAide.isNoneEmpty(new String[] {})  = true
     * StringAide.isNoneEmpty(new String[]{""}) = false
     * StringAide.isNoneEmpty(" ", "bar")       = true
     * StringAide.isNoneEmpty("foo", "bar")     = true
     * </pre>
     *
     * @param sequences 要检查的字符序列数组，可能为 {@code null} 或 {@code empty}
     * @return 若所有 CharSequence 都不为 {@code empty} 且都不为 {@code null} 则为 {@code true}，否则为 {@code false}
     */
    public static boolean isNoneEmpty(final CharSequence... sequences) {
        return !isAnyEmpty(sequences);
    }

    /**
     * 检查字符序列是否为 {@code empty}（""）或 {@code null} 或 {@code blank}（Whitespace，空白）。
     *
     * <p>{@code blank} 由 {@link Character#isWhitespace(char)} 定义。</p>
     *
     * <p>注意：此方法无法处理增补字符。
     * 要支持所有 Unicode 字符（包括增补字符）请使用 {@link #isBlankCoverSupplementary(CharSequence)} 方法。</p>
     *
     * <pre>
     * StringAide.isBlank(null)      = true
     * StringAide.isBlank("")        = true
     * StringAide.isBlank(" ")       = true
     * StringAide.isBlank("bob")     = false
     * StringAide.isBlank("  bob  ") = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 如果 CharSequence 为 {@code empty} 或 {@code null} 或 {@code blank} 则为 {@code true}，否额为 {@code false}
     * @see #isBlankCoverSupplementary(CharSequence)
     */
    public static boolean isBlank(final CharSequence sequence) {
        final int length = length(sequence);
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 包含 BMP 和 SMP 的空白检查。
     *
     * <p>空白符由 {@link Character#isWhitespace(int)} 定义。</p>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若字符序列全部为 BMP 或 SMP 的空白符则为 {@code true}
     * @see #isBlank(CharSequence)
     */
    public static boolean isBlankCoverSupplementary(final CharSequence sequence) {
        final int length = length(sequence);
        if (length == 0) {
            return true;
        }
        return sequence.codePoints().allMatch(Character::isWhitespace);
    }

    /**
     * 检查字符序列是否不为 {@code empty} 且不为 {@code null} 且不为 {@code blank}。
     *
     * <p>{@code blank} 由 {@link Character#isWhitespace(char)} 定义。</p>
     *
     * <p>注意：此方法无法处理增补字符。
     * 要支持所有 Unicode 字符（包括增补字符）请使用 {@link #isNotBlankCoverSupplementary(CharSequence)} 方法。</p>
     *
     * <pre>
     * StringAide.isNotBlank(null)      = false
     * StringAide.isNotBlank("")        = false
     * StringAide.isNotBlank(" ")       = false
     * StringAide.isNotBlank("bob")     = true
     * StringAide.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若 CharSequence 不为 {@code empty} 且不为 {@code null} 且不为 {@code blank} 则为 {@code true}，否则为 {@code false}
     * @see #isNotBlankCoverSupplementary(CharSequence)
     */
    public static boolean isNotBlank(final CharSequence sequence) {
        return !isBlank(sequence);
    }

    /**
     * 包含 BMP 和 SMP 的空白检查。
     *
     * <p>空白符由 {@link Character#isWhitespace(int)} 定义。</p>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若字符序列非空且包含除了 BMP 或 SMP 空白符以外的字符则为 {@code true}
     * @see #isNotBlank(CharSequence)
     */
    public static boolean isNotBlankCoverSupplementary(final CharSequence sequence) {
        return !isBlankCoverSupplementary(sequence);
    }

    /**
     * 检查所有字符序列是否都为 {@code empty} 或 {@code null} 或 {@code blank} 。
     *
     * <p>{@code blank} 由 {@link Character#isWhitespace(char)} 定义。</p>
     *
     * <p>注意：此方法无法处理增补字符。
     * 要支持所有 Unicode 字符（包括增补字符）请使用 {@link #isAllBlankCoverSupplementary(CharSequence...)} 方法。</p>
     *
     * <pre>
     * StringAide.isAllBlank(null)             = true
     * StringAide.isAllBlank(null, "foo")      = false
     * StringAide.isAllBlank(null, null)       = true
     * StringAide.isAllBlank("", "bar")        = false
     * StringAide.isAllBlank("bob", "")        = false
     * StringAide.isAllBlank("  bob  ", null)  = false
     * StringAide.isAllBlank(" ", "bar")       = false
     * StringAide.isAllBlank("foo", "bar")     = false
     * StringAide.isAllBlank(new String[] {})  = true
     * </pre>
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}
     * @return 若所有 CharSequence 都为 {@code empty} 或 {@code null} 或 {@code blank} 则为 {@code true}，否则为 {@code false}
     * @see #isAllBlankCoverSupplementary(CharSequence...)
     */
    public static boolean isAllBlank(final CharSequence... sequences) {
        if (ArrayAide.isEmpty(sequences)) {
            return true;
        }
        for (CharSequence sequence : sequences) {
            if (isNotBlank(sequence)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 包含 BMP 和 SMP 的空白检查。
     *
     * <p>空白符由 {@link Character#isWhitespace(int)} 定义。</p>
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}
     * @return 若所有字符序列都为空或只包含 BMP 或 SMP 空白符则为 {@code true}
     * @see #isAllBlank(CharSequence...)
     */
    public static boolean isAllBlankCoverSupplementary(final CharSequence... sequences) {
        if (ArrayAide.isEmpty(sequences)) {
            return true;
        }
        for (CharSequence sequence : sequences) {
            if (isNotBlankCoverSupplementary(sequence)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查字符序列数组中是否存在任何 {@code empty} 或 {@code null} 或 {@code blank} 的元素。
     *
     * <p>{@code blank} 由 {@link Character#isWhitespace(char)} 定义。</p>
     *
     * <p>注意：此方法无法处理增补字符。
     * 要支持所有 Unicode 字符（包括增补字符）请使用 {@link #isAnyBlankCoverSupplementary(CharSequence...)} 方法。</p>
     *
     * <pre>
     * StringAide.isAnyBlank((String) null)    = true
     * StringAide.isAnyBlank((String[]) null)  = false
     * StringAide.isAnyBlank(null, "foo")      = true
     * StringAide.isAnyBlank(null, null)       = true
     * StringAide.isAnyBlank("", "bar")        = true
     * StringAide.isAnyBlank("bob", "")        = true
     * StringAide.isAnyBlank("  bob  ", null)  = true
     * StringAide.isAnyBlank(" ", "bar")       = true
     * StringAide.isAnyBlank(new String[] {})  = false
     * StringAide.isAnyBlank(new String[]{""}) = true
     * StringAide.isAnyBlank("foo", "bar")     = false
     * </pre>
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}
     * @return 若存在任何 {@code empty} 或 {@code null} 或 {@code blank} 的元素则为 {@code true}，否则为 {@code false}
     * @see #isAnyBlankCoverSupplementary(CharSequence...)
     */
    public static boolean isAnyBlank(final CharSequence... sequences) {
        if (ArrayAide.isEmpty(sequences)) {
            return false;
        }
        for (CharSequence sequence : sequences) {
            if (isBlank(sequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 包含 BMP 和 SMP 的空白检查。
     *
     * <p>空白符由 {@link Character#isWhitespace(int)} 定义。</p>
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}
     * @return 若有任何字符序列为空或只包含 BMP 或 SMP 空白符则为 {@code true}
     * @see #isAnyBlank(CharSequence...)
     */
    public static boolean isAnyBlankCoverSupplementary(final CharSequence... sequences) {
        if (ArrayAide.isEmpty(sequences)) {
            return false;
        }
        for (CharSequence sequence : sequences) {
            if (isBlankCoverSupplementary(sequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查所有字符序列是否都不为 {@code empty} 且都不为 {@code null} 且都不为 {@code blank}。
     *
     * <p>{@code blank} 由 {@link Character#isWhitespace(char)} 定义。</p>
     *
     * <p>注意：此方法无法处理增补字符。
     * 要支持所有 Unicode 字符（包括增补字符）请使用 {@link #isNoneBlankCoverSupplementary(CharSequence...)} 方法。</p>
     *
     * <pre>
     * StringAide.isNoneBlank((String) null)    = false
     * StringAide.isNoneBlank((String[]) null)  = true
     * StringAide.isNoneBlank(null, "foo")      = false
     * StringAide.isNoneBlank(null, null)       = false
     * StringAide.isNoneBlank("", "bar")        = false
     * StringAide.isNoneBlank("bob", "")        = false
     * StringAide.isNoneBlank("  bob  ", null)  = false
     * StringAide.isNoneBlank(" ", "bar")       = false
     * StringAide.isNoneBlank(new String[] {})  = true
     * StringAide.isNoneBlank(new String[]{""}) = false
     * StringAide.isNoneBlank("foo", "bar")     = true
     * </pre>
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}
     * @return 若所有 CharSequence 都不为 {@code empty} 且都不为 {@code null} 且都不为 {@code blank} 则为 {@code true}，否则为 {@code false}
     * @see #isNoneBlankCoverSupplementary(CharSequence...)
     */
    public static boolean isNoneBlank(final CharSequence... sequences) {
        return !isAnyBlank(sequences);
    }

    /**
     * 包含 BMP 和 SMP 的空白检查。
     *
     * <p>空白符由 {@link Character#isWhitespace(int)} 定义。</p>
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}
     * @return 若所有字符序列都非空且包含除了 BMP 或 SMP 空白符以外的字符则为 {@code true}
     * @see #isNoneBlank(CharSequence...)
     */
    public static boolean isNoneBlankCoverSupplementary(final CharSequence... sequences) {
        return !isAnyBlankCoverSupplementary(sequences);
    }

    /**
     * 检查字符序列中是否仅包含小写字符。
     *
     * <p>小写字符由 {@link Character#isLowerCase(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 或 {@code empty} 贼返回 {@code false}。</p>
     *
     * <pre>
     * StringAide.isAllLowerCase(null)   = false
     * StringAide.isAllLowerCase("")     = false
     * StringAide.isAllLowerCase("  ")   = false
     * StringAide.isAllLowerCase("abc")  = true
     * StringAide.isAllLowerCase("abC")  = false
     * StringAide.isAllLowerCase("ab c") = false
     * StringAide.isAllLowerCase("ab1c") = false
     * StringAide.isAllLowerCase("ab/c") = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若非空且仅包含小写字符则为 {@code true}
     * @see Character#isLowerCase(char)
     */
    public static boolean isAllLowerCase(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isLowerCase(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 检查字符序列中是否包含任何小写字符。
     *
     * <p>小写字符由 {@link Character#isLowerCase(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 或 {@code empty} 贼返回 {@code false}。</p>
     *
     * <pre>
     * StringAide.isAnyLowerCase(null)   = false
     * StringAide.isAnyLowerCase("")     = false
     * StringAide.isAnyLowerCase("  ")   = false
     * StringAide.isAnyLowerCase("abc")  = true
     * StringAide.isAnyLowerCase("abC")  = true
     * StringAide.isAnyLowerCase("ab c") = true
     * StringAide.isAnyLowerCase("ab1c") = true
     * StringAide.isAnyLowerCase("ABC")  = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若非空且包含任何小写字符则为 {@code true}
     * @see Character#isLowerCase(char)
     */
    public static boolean isAnyLowerCase(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (Character.isLowerCase(sequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查字符序列中是否仅包含大写字符。
     *
     * <p>大写字符由 {@link Character#isUpperCase(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 或 {@code empty} 贼返回 {@code false}。</p>
     *
     * <pre>
     * StringAide.isAllUpperCase(null)   = false
     * StringAide.isAllUpperCase("")     = false
     * StringAide.isAllUpperCase("  ")   = false
     * StringAide.isAllUpperCase("ABC")  = true
     * StringAide.isAllUpperCase("aBC")  = false
     * StringAide.isAllUpperCase("A C")  = false
     * StringAide.isAllUpperCase("A1C")  = false
     * StringAide.isAllUpperCase("A/C")  = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若非空且仅包含大写字符则为 {@code true}
     * @see Character#isUpperCase(char)
     */
    public static boolean isAllUpperCase(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isUpperCase(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查字符序列中是否包含任何大写字符。
     *
     * <p>大写字符由 {@link Character#isUpperCase(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 或 {@code empty} 贼返回 {@code false}。</p>
     *
     * <pre>
     * StringAide.isAllUpperCase(null)   = false
     * StringAide.isAllUpperCase("")     = false
     * StringAide.isAllUpperCase("  ")   = false
     * StringAide.isAllUpperCase("ABC")  = true
     * StringAide.isAllUpperCase("aBC")  = true
     * StringAide.isAllUpperCase("A C")  = true
     * StringAide.isAllUpperCase("A1C")  = true
     * StringAide.isAllUpperCase("abc")  = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若非空且包含任何大写字符则为 {@code true}
     * @see Character#isUpperCase(char)
     */
    public static boolean isAnyUpperCase(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (Character.isUpperCase(sequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查字符序列是否同时包含大写和小写字符。
     *
     * <p>大写字符由 {@link Character#isUpperCase(char)} 定义；小写字符由 {@link Character#isLowerCase(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 或 {@code empty} 贼返回 {@code false}。</p>
     *
     * <pre>
     * StringAide.isMixedCase(null)    = false
     * StringAide.isMixedCase("")      = false
     * StringAide.isMixedCase(" ")     = false
     * StringAide.isMixedCase("ABC")   = false
     * StringAide.isMixedCase("abc")   = false
     * StringAide.isMixedCase("aBc")   = true
     * StringAide.isMixedCase("A c")   = true
     * StringAide.isMixedCase("A1c")   = true
     * StringAide.isMixedCase("a/C")   = true
     * StringAide.isMixedCase("aC\t")  = true
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若非空且同时包含大写和小写字符则为 {@code true}
     * @see Character#isUpperCase(char)
     * @see Character#isLowerCase(char)
     */
    public static boolean isMixedCase(final CharSequence sequence) {
        if (isEmpty(sequence) || sequence.length() == 1) {
            return false;
        }
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        final int length = sequence.length();
        for (int i = 0; i < length; i++) {
            final char ch = sequence.charAt(i);
            if (Character.isUpperCase(ch)) {
                containsUppercase = true;
            }
            if (Character.isLowerCase(ch)) {
                containsLowercase = true;
            }
            if (containsUppercase && containsLowercase) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查字符序列是否仅包含空白符。
     * 与 {@link #isBlank(CharSequence)} 不同的是 {@code null} 字符序列将返回 {@code false}。
     *
     * <p>空白符由 {@link Character#isWhitespace(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 则返回 {@code false}；若字符序列为 {@code empty} 则返回 {@code true}。</p>
     *
     * <p>注意：此方法无法处理增补字符。
     * 要支持所有 Unicode 字符（包括增补字符）请使用 {@link #isWhitespaceCoverSupplementary(CharSequence)} 方法。</p>
     *
     * <pre>
     * StringAide.isWhitespace(null)   = false
     * StringAide.isWhitespace("")     = true
     * StringAide.isWhitespace("  ")   = true
     * StringAide.isWhitespace("abc")  = false
     * StringAide.isWhitespace("ab2c") = false
     * StringAide.isWhitespace("ab-c") = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若字符序列为 {@code null} 则为 {@code false}；若字符序列为 {@code empty} 则为 {@code true}；若字符序列仅包含空白符则为 {@code true}
     * @see #isWhitespaceCoverSupplementary(CharSequence)
     */
    public static boolean isWhitespace(final CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return isBlank(sequence);
    }

    /**
     * 包含 BMP 和 SMP 的空白检查。
     * 与 {@link #isBlankCoverSupplementary(CharSequence)} 不同的是 {@code null} 字符序列将返回 {@code false}。
     *
     * <p>空白符由 {@link Character#isWhitespace(int)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 则返回 {@code false}；若字符序列为 {@code empty} 则返回 {@code true}。</p>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若字符序列为 {@code null} 则为 {@code false}；若字符序列为 {@code empty} 则为 {@code true}；若字符序列仅包含 BMP、SMP 空白符则为 {@code true}
     * @see #isWhitespace(CharSequence)
     */
    public static boolean isWhitespaceCoverSupplementary(final CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return isBlankCoverSupplementary(sequence);
    }

    /**
     * 检查字符序列是否仅包含 Unicode 字母。
     *
     * <p>字母由 {@link Character#isLetter(char)} 定义。</p>
     *
     * <p>若字符序列为 {@code null} 或 {@code empty} 将返回 {@code false}。</p>
     *
     * <pre>
     * StringAide.isAlpha(null)   = false
     * StringAide.isAlpha("")     = false
     * StringAide.isAlpha("  ")   = false
     * StringAide.isAlpha("abc")  = true
     * StringAide.isAlpha("ab2c") = false
     * StringAide.isAlpha("ab-c") = false
     * </pre>
     *
     * @param sequence 要检查的字符序列，可能为 {@code null}
     * @return 若非空且仅包含字母则为 {@code true}
     * @see Character#isLetter(char)
     */
    public static boolean isAlpha(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isLetter(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode letters or digits.
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code false}.</p>
     *
     * <pre>
     * StringAide.isAlphanumeric(null)   = false
     * StringAide.isAlphanumeric("")     = false
     * StringAide.isAlphanumeric("  ")   = false
     * StringAide.isAlphanumeric("abc")  = true
     * StringAide.isAlphanumeric("ab c") = false
     * StringAide.isAlphanumeric("ab2c") = true
     * StringAide.isAlphanumeric("ab-c") = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @return {@code true} if only contains letters or digits,
     *  and is non-null
     * @see Character#isLetterOrDigit(char)
     */
    public static boolean isAlphanumeric(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isLetterOrDigit(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode letters, digits
     * or space ({@code ' '}).
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code true}.</p>
     *
     * <pre>
     * StringAide.isAlphanumericSpace(null)   = false
     * StringAide.isAlphanumericSpace("")     = true
     * StringAide.isAlphanumericSpace("  ")   = true
     * StringAide.isAlphanumericSpace("abc")  = true
     * StringAide.isAlphanumericSpace("ab c") = true
     * StringAide.isAlphanumericSpace("ab2c") = true
     * StringAide.isAlphanumericSpace("ab-c") = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @return {@code true} if only contains letters, digits or space,
     *  and is non-null
     * @see CharConst#SPACE_CHAR
     * @see Character#isLetterOrDigit(char)
     */
    public static boolean isAlphanumericSpace(final CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            final char c = sequence.charAt(i);
            if (c != CharConst.SPACE_CHAR && !Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode letters and
     * space (' ').
     *
     * <p>{@code null} will return {@code false}
     * An empty CharSequence (length()=0) will return {@code true}.</p>
     *
     * <pre>
     * StringAide.isAlphaSpace(null)   = false
     * StringAide.isAlphaSpace("")     = true
     * StringAide.isAlphaSpace("  ")   = true
     * StringAide.isAlphaSpace("abc")  = true
     * StringAide.isAlphaSpace("ab c") = true
     * StringAide.isAlphaSpace("ab2c") = false
     * StringAide.isAlphaSpace("ab-c") = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @return {@code true} if only contains letters and space,
     *  and is non-null
     * @see CharConst#SPACE_CHAR
     * @see Character#isLetter(char)
     */
    public static boolean isAlphaSpace(final CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            final char c = sequence.charAt(i);
            if (c != CharConst.SPACE_CHAR && !Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode digits.
     * A decimal point is not a Unicode digit and returns false.
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code false}.</p>
     *
     * <p>Note that the method does not allow for a leading sign, either positive or negative.
     * Also, if a String passes the numeric test, it may still generate a NumberFormatException
     * when parsed by Integer.parseInt or Long.parseLong, e.g. if the value is outside the range
     * for int or long respectively.</p>
     *
     * <pre>
     * StringAide.isNumeric(null)   = false
     * StringAide.isNumeric("")     = false
     * StringAide.isNumeric("  ")   = false
     * StringAide.isNumeric("123")  = true
     * StringAide.isNumeric("&#92;u0967&#92;u0968&#92;u0969")  = true
     * StringAide.isNumeric("12 3") = false
     * StringAide.isNumeric("ab2c") = false
     * StringAide.isNumeric("12-3") = false
     * StringAide.isNumeric("12.3") = false
     * StringAide.isNumeric("-123") = false
     * StringAide.isNumeric("+123") = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @return {@code true} if only contains digits, and is non-null
     * @see Character#isDigit(char)
     */
    public static boolean isNumeric(final CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isDigit(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode digits or space
     * ({@code ' '}).
     * A decimal point is not a Unicode digit and returns false.
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code true}.</p>
     *
     * <pre>
     * StringAide.isNumericSpace(null)   = false
     * StringAide.isNumericSpace("")     = true
     * StringAide.isNumericSpace("  ")   = true
     * StringAide.isNumericSpace("123")  = true
     * StringAide.isNumericSpace("12 3") = true
     * StringAide.isNumericSpace("&#92;u0967&#92;u0968&#92;u0969")  = true
     * StringAide.isNumericSpace("&#92;u0967&#92;u0968 &#92;u0969")  = true
     * StringAide.isNumericSpace("ab2c") = false
     * StringAide.isNumericSpace("12-3") = false
     * StringAide.isNumericSpace("12.3") = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @return {@code true} if only contains digits or space,
     *  and is non-null
     * @see CharConst#SPACE_CHAR
     * @see Character#isDigit(char)
     */
    public static boolean isNumericSpace(final CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            final char c = sequence.charAt(i);
            if (c != CharConst.SPACE_CHAR && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only ASCII printable characters.
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code true}.</p>
     *
     * <pre>
     * StringAide.isAsciiPrintable(null)     = false
     * StringAide.isAsciiPrintable("")       = true
     * StringAide.isAsciiPrintable(" ")      = true
     * StringAide.isAsciiPrintable("Ceki")   = true
     * StringAide.isAsciiPrintable("ab2c")   = true
     * StringAide.isAsciiPrintable("!ab-c~") = true
     * StringAide.isAsciiPrintable("&#92;u0020") = true
     * StringAide.isAsciiPrintable("&#92;u0021") = true
     * StringAide.isAsciiPrintable("&#92;u007e") = true
     * StringAide.isAsciiPrintable("\u007f") = false
     * StringAide.isAsciiPrintable("Ceki G&#92;u00fclc&#92;u00fc") = false
     * </pre>
     *
     * @param sequence the CharSequence to check, may be null
     * @return {@code true} if every character is in the range
     *  32 through 126
     * @see CharAide#isAsciiPrintable(char)
     */
    public static boolean isAsciiPrintable(final CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!CharAide.isAsciiPrintable(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if CharSequence contains a search character, handling {@code null}.
     * This method uses {@link String#indexOf(int)} if possible.
     *
     * <p>A {@code null} or empty ("") CharSequence will return {@code false}.</p>
     *
     * <pre>
     * StringAide.contains(null, *)    = false
     * StringAide.contains("", *)      = false
     * StringAide.contains("abc", 'a') = true
     * StringAide.contains("abc", 'z') = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChar  the character to find
     * @return true if the CharSequence contains the search character,
     *  false if not or {@code null} string input
     */
    public static boolean containsChar(final CharSequence sequence, final int searchChar) {
        if (isEmpty(sequence)) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, searchChar, 0) >= 0;
    }

    /**
     * xxxxxxxxxx
     *
     * @param sequence
     * @param searchChar
     * @return
     */
    public static boolean containsChar(final CharSequence sequence, final char searchChar) {
        return containsChar(sequence, Character.digit(searchChar, 10));
    }

    /**
     * Checks if CharSequence contains a search CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String)} if possible.
     *
     * <p>A {@code null} CharSequence will return {@code false}.</p>
     *
     * <pre>
     * StringAide.contains(null, *)     = false
     * StringAide.contains(*, null)     = false
     * StringAide.contains("", "")      = true
     * StringAide.contains("abc", "")   = true
     * StringAide.contains("abc", "a")  = true
     * StringAide.contains("abc", "z")  = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param search  the CharSequence to find, may be null
     * @return true if the CharSequence contains the search CharSequence,
     *  false if not or {@code null} string input
     */
    public static boolean contains(final CharSequence sequence, final CharSequence search) {
        if (sequence == null || search == null) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, search, 0) >= 0;
    }

    /**
     * Checks if CharSequence contains a search CharSequence irrespective of case,
     * handling {@code null}. Case-insensitivity is defined as by
     * {@link String#equalsIgnoreCase(String)}.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     *
     * <pre>
     * StringAide.containsIgnoreCase(null, *) = false
     * StringAide.containsIgnoreCase(*, null) = false
     * StringAide.containsIgnoreCase("", "") = true
     * StringAide.containsIgnoreCase("abc", "") = true
     * StringAide.containsIgnoreCase("abc", "a") = true
     * StringAide.containsIgnoreCase("abc", "z") = false
     * StringAide.containsIgnoreCase("abc", "A") = true
     * StringAide.containsIgnoreCase("abc", "Z") = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param search  the CharSequence to find, may be null
     * @return true if the CharSequence contains the search CharSequence irrespective of
     * case or false if not or {@code null} string input
     */
    public static boolean containsIgnoreCase(final CharSequence sequence, final CharSequence search) {
        if (sequence == null || search == null) {
            return false;
        }
        final int searchLength = search.length();
        // sequence.length() - searchLength : 从头查找到剩余长度不足 searchLength 即可
        for (int i = 0; i <= (sequence.length() - searchLength); i++) {
            if (_CharSequenceAide.regionMatches(sequence, true, i, search, 0, searchLength)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the CharSequence contains any character in the given
     * set of characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} or zero length search array will return {@code false}.</p>
     *
     * <pre>
     * StringAide.containsAny(null, *)                  = false
     * StringAide.containsAny("", *)                    = false
     * StringAide.containsAny(*, null)                  = false
     * StringAide.containsAny(*, [])                    = false
     * StringAide.containsAny("zzabyycdxx", ['z', 'a']) = true
     * StringAide.containsAny("zzabyycdxx", ['b', 'y']) = true
     * StringAide.containsAny("zzabyycdxx", ['z', 'y']) = true
     * StringAide.containsAny("aba", ['z'])             = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChars  the chars to search for, may be null
     * @return the {@code true} if any of the chars are found,
     * {@code false} if no match or null input
     */
    public static boolean containsAnyChar(final CharSequence sequence, final char... searchChars) {
        if(isEmpty(sequence) || ArrayAide.isEmpty(searchChars)) {
            return false;
        }
        final int sequenceLength = sequence.length();
        final int searchLength = searchChars.length;
        final int sequenceLast = sequenceLength - 1;
        final int searchLast = searchLength - 1;
        for (int i = 0; i < sequenceLength; i++) {
            final char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (!Character.isHighSurrogate(ch)) {
                        // ch 属于基本多文种平面（Basic Multilingual Plane, BMP）
                        return true;
                    }
                    if (j == searchLast) {
                        // 缺少低代理项，就像 String.indexOf(String)
                        return true;
                    }
                    if (i < sequenceLast && searchChars[j + 1] == sequence.charAt(i + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the CharSequence contains any character in the given set of characters.
     *
     * <p>
     * A {@code null} CharSequence will return {@code false}. A {@code null} search CharSequence will return
     * {@code false}.
     * </p>
     *
     * <pre>
     * StringAide.containsAny(null, *)               = false
     * StringAide.containsAny("", *)                 = false
     * StringAide.containsAny(*, null)               = false
     * StringAide.containsAny(*, "")                 = false
     * StringAide.containsAny("zzabyycdxx", "za")    = true
     * StringAide.containsAny("zzabyycdxx", "by")    = true
     * StringAide.containsAny("zzabyycdxx", "zy")    = true
     * StringAide.containsAny("zzabyycdxx", "\tx")   = true
     * StringAide.containsAny("zzabyycdxx", "$.#yF") = true
     * StringAide.containsAny("aba", "z")            = false
     * </pre>
     *
     * @param sequence
     *            the CharSequence to check, may be null
     * @param searchChars
     *            the chars to search for, may be null
     * @return the {@code true} if any of the chars are found, {@code false} if no match or null input
     */
    public static boolean containsAnyChar(final CharSequence sequence, final CharSequence searchChars) {
        if (searchChars == null) {
            return false;
        }
        return containsAnyChar(sequence, toCharArray(searchChars));
    }

    /**
     * Checks if the CharSequence contains any of the CharSequences in the given array.
     *
     * <p>
     * A {@code null} {@code cs} CharSequence will return {@code false}. A {@code null} or zero length search array will
     * return {@code false}.
     * </p>
     *
     * <pre>
     * StringAide.containsAny(null, *)            = false
     * StringAide.containsAny("", *)              = false
     * StringAide.containsAny(*, null)            = false
     * StringAide.containsAny(*, [])              = false
     * StringAide.containsAny("abcd", "ab", null) = true
     * StringAide.containsAny("abcd", "ab", "cd") = true
     * StringAide.containsAny("abc", "d", "abc")  = true
     * </pre>
     *
     * @param sequence The CharSequence to check, may be null
     * @param searchSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *        null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     */
    public static boolean containsAny(final CharSequence sequence, final CharSequence... searchSequences) {
        if(sequence == null || ArrayAide.isEmpty(searchSequences)) {
            return false;
        }
        for (CharSequence searchSequence : searchSequences) {
            if (contains(sequence, searchSequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the CharSequence contains any of the CharSequences in the given array, ignoring case.
     *
     * <p>
     * A {@code null} {@code cs} CharSequence will return {@code false}. A {@code null} or zero length search array will
     * return {@code false}.
     * </p>
     *
     * <pre>
     * StringAide.containsAny(null, *)            = false
     * StringAide.containsAny("", *)              = false
     * StringAide.containsAny(*, null)            = false
     * StringAide.containsAny(*, [])              = false
     * StringAide.containsAny("abcd", "ab", null) = true
     * StringAide.containsAny("abcd", "ab", "cd") = true
     * StringAide.containsAny("abc", "d", "abc")  = true
     * StringAide.containsAny("abc", "D", "ABC")  = true
     * StringAide.containsAny("ABC", "d", "abc")  = true
     * </pre>
     *
     * @param sequence The CharSequence to check, may be null
     * @param searchSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *        null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     * @since 3.12.0
     */
    public static boolean containsAnyIgnoreCase(final CharSequence sequence, final CharSequence... searchSequences) {
        if(sequence == null || ArrayAide.isEmpty(searchSequences)) {
            return false;
        }
        for (CharSequence searchSequence : searchSequences) {
            if (containsIgnoreCase(sequence, searchSequence)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks that the CharSequence does not contain certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty CharSequence (length()=0) always returns true.</p>
     *
     * <pre>
     * StringAide.containsNone(null, *)       = true
     * StringAide.containsNone(*, null)       = true
     * StringAide.containsNone("", *)         = true
     * StringAide.containsNone("ab", '')      = true
     * StringAide.containsNone("abab", 'xyz') = true
     * StringAide.containsNone("ab1", 'xyz')  = true
     * StringAide.containsNone("abz", 'xyz')  = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChars  an array of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     */
    public static boolean containsNoneChar(final CharSequence sequence, final char... searchChars) {
        if (sequence == null || searchChars == null) {
            return true;
        }
        final int sequenceLength = sequence.length();
        final int sequenceLast = sequenceLength - 1;
        final int searchLength = searchChars.length;
        final int searchLast = searchLength - 1;
        for (int i = 0; i < sequenceLength; i++) {
            final char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (!Character.isHighSurrogate(ch)) {
                        // ch 属于基本多文种平面（Basic Multilingual Plane, BMP）
                        return false;
                    }
                    if (j == searchLast) {
                        // 缺少低代理项，就像 String.indexOf(String)
                        return false;
                    }
                    if (i < sequenceLast && searchChars[j + 1] == sequence.charAt(i + 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks that the CharSequence does not contain certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty String ("") always returns true.</p>
     *
     * <pre>
     * StringAide.containsNone(null, *)       = true
     * StringAide.containsNone(*, null)       = true
     * StringAide.containsNone("", *)         = true
     * StringAide.containsNone("ab", "")      = true
     * StringAide.containsNone("abab", "xyz") = true
     * StringAide.containsNone("ab1", "xyz")  = true
     * StringAide.containsNone("abz", "xyz")  = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param invalidChars  a String of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     * @since 2.0
     * @since 3.0 Changed signature from containsNone(String, String) to containsNone(CharSequence, String)
     */
    public static boolean containsNoneChar(final CharSequence sequence, final CharSequence invalidChars) {
        if (invalidChars == null) {
            return true;
        }
        return containsNoneChar(sequence, toCharArray(invalidChars));
    }

    /**
     * xxxxxxxxxxxx
     *
     * @param sequence
     * @param invalidSequences
     * @return
     */
    public static boolean containsNone(final CharSequence sequence, final CharSequence... invalidSequences) {
        if (sequence == null || invalidSequences == null) {
            return true;
        }
        for (CharSequence invalidSequence : invalidSequences) {
            if (contains(sequence, invalidSequence)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character array will return {@code false}.
     * An empty CharSequence (length()=0) always returns {@code true}.</p>
     *
     * <pre>
     * StringAide.containsOnly(null, *)       = false
     * StringAide.containsOnly(*, null)       = false
     * StringAide.containsOnly("", *)         = true
     * StringAide.containsOnly("ab", '')      = false
     * StringAide.containsOnly("abab", 'abc') = true
     * StringAide.containsOnly("ab1", 'abc')  = false
     * StringAide.containsOnly("abz", 'abc')  = false
     * </pre>
     *
     * @param sequence  the String to check, may be null
     * @param validChars  an array of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     * @since 3.0 Changed signature from containsOnly(String, char[]) to containsOnly(CharSequence, char...)
     */
    public static boolean containsOnlyChars(final CharSequence sequence, final char... validChars) {
        if (sequence == null || validChars == null) {
            return false;
        }
        if (sequence.isEmpty()) {
            return true;
        }
        if (validChars.length == 0) {
            return false;
        }
        return indexOfNotAnyChar(sequence, validChars) == INDEX_NOT_FOUND;
    }

    /**
     * Checks if the CharSequence contains only certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character String will return {@code false}.
     * An empty String (length()=0) always returns {@code true}.</p>
     *
     * <pre>
     * StringAide.containsOnly(null, *)       = false
     * StringAide.containsOnly(*, null)       = false
     * StringAide.containsOnly("", *)         = true
     * StringAide.containsOnly("ab", "")      = false
     * StringAide.containsOnly("abab", "abc") = true
     * StringAide.containsOnly("ab1", "abc")  = false
     * StringAide.containsOnly("abz", "abc")  = false
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param validChars  a String of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     * @since 2.0
     * @since 3.0 Changed signature from containsOnly(String, String) to containsOnly(CharSequence, String)
     */
    public static boolean containsOnlyChars(final CharSequence sequence, final CharSequence validChars) {
        if (sequence == null || validChars == null) {
            return false;
        }
        return containsOnlyChars(sequence, toCharArray(validChars));
    }

    /**
     * Finds the first index within a CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String, int)} if possible.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.</p>
     *
     * <pre>
     * StringAide.indexOf(null, *)          = -1
     * StringAide.indexOf(*, null)          = -1
     * StringAide.indexOf("", "")           = 0
     * StringAide.indexOf("", *)            = -1 (except when * = "")
     * StringAide.indexOf("aabaabaa", "a")  = 0
     * StringAide.indexOf("aabaabaa", "b")  = 2
     * StringAide.indexOf("aabaabaa", "ab") = 1
     * StringAide.indexOf("aabaabaa", "")   = 0
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param search  the CharSequence to find, may be null
     * @return the first index of the search CharSequence,
     *  -1 if no match or {@code null} string input
     */
    public static int indexOf(final CharSequence sequence, final CharSequence search) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, 0);
    }

    /**
     * Finds the first index within a CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String, int)} if possible.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A negative start position is treated as zero.
     * An empty ("") search CharSequence always matches.
     * A start position greater than the string length only matches
     * an empty search CharSequence.</p>
     *
     * <pre>
     * StringAide.indexOf(null, *, *)          = -1
     * StringAide.indexOf(*, null, *)          = -1
     * StringAide.indexOf("", "", 0)           = 0
     * StringAide.indexOf("", *, 0)            = -1 (except when * = "")
     * StringAide.indexOf("aabaabaa", "a", 0)  = 0
     * StringAide.indexOf("aabaabaa", "b", 0)  = 2
     * StringAide.indexOf("aabaabaa", "ab", 0) = 1
     * StringAide.indexOf("aabaabaa", "b", 3)  = 5
     * StringAide.indexOf("aabaabaa", "b", 9)  = -1
     * StringAide.indexOf("aabaabaa", "b", -1) = 2
     * StringAide.indexOf("aabaabaa", "", 2)   = 2
     * StringAide.indexOf("abc", "", 9)        = 3
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param search  the CharSequence to find, may be null
     * @param start  the start position, negative treated as zero
     * @return the first index of the search CharSequence (always &ge; startPos),
     *  -1 if no match or {@code null} string input
     */
    public static int indexOf(final CharSequence sequence, final CharSequence search, final int start) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, start);
    }

    /**
     * Find the first index of any of a set of potential substrings.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored, but a search
     * array containing "" will return {@code 0} if {@code str} is not
     * null. This method uses {@link String#indexOf(String)} if possible.</p>
     *
     * <pre>
     * StringAide.indexOfAny(null, *)                      = -1
     * StringAide.indexOfAny(*, null)                      = -1
     * StringAide.indexOfAny(*, [])                        = -1
     * StringAide.indexOfAny("zzabyycdxx", ["ab", "cd"])   = 2
     * StringAide.indexOfAny("zzabyycdxx", ["cd", "ab"])   = 2
     * StringAide.indexOfAny("zzabyycdxx", ["mn", "op"])   = -1
     * StringAide.indexOfAny("zzabyycdxx", ["zab", "aby"]) = 1
     * StringAide.indexOfAny("zzabyycdxx", [""])           = 0
     * StringAide.indexOfAny("", [""])                     = 0
     * StringAide.indexOfAny("", ["a"])                    = -1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchSequences  the CharSequences to search for, may be null
     * @return the first index of any of the searchStrs in str, -1 if no match
     */
    public static int indexOfAny(final CharSequence sequence, final CharSequence... searchSequences) {
        if (sequence == null || searchSequences == null) {
            return INDEX_NOT_FOUND;
        }
        int ret = Integer.MAX_VALUE;
        int tmp;
        for (CharSequence searchSequence : searchSequences) {
            if (searchSequence == null) {
                continue;
            }
            tmp = _CharSequenceAide.indexOf(sequence, searchSequence, 0);
            if (tmp == INDEX_NOT_FOUND) {
                continue;
            }
            if (tmp < ret) {
                ret = tmp;
            }
        }
        return ret != Integer.MAX_VALUE ? ret : INDEX_NOT_FOUND;
    }

    /**
     * Case in-sensitive find of the first index within a CharSequence.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A negative start position is treated as zero.
     * An empty ("") search CharSequence always matches.
     * A start position greater than the string length only matches
     * an empty search CharSequence.</p>
     *
     * <pre>
     * StringAide.indexOfIgnoreCase(null, *)          = -1
     * StringAide.indexOfIgnoreCase(*, null)          = -1
     * StringAide.indexOfIgnoreCase("", "")           = 0
     * StringAide.indexOfIgnoreCase(" ", " ")         = 0
     * StringAide.indexOfIgnoreCase("aabaabaa", "a")  = 0
     * StringAide.indexOfIgnoreCase("aabaabaa", "b")  = 2
     * StringAide.indexOfIgnoreCase("aabaabaa", "ab") = 1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param search  the CharSequence to find, may be null
     * @return the first index of the search CharSequence,
     *  -1 if no match or {@code null} string input
     * @since 2.5
     * @since 3.0 Changed signature from indexOfIgnoreCase(String, String) to indexOfIgnoreCase(CharSequence, CharSequence)
     */
    public static int indexOfIgnoreCase(final CharSequence sequence, final CharSequence search) {
        return indexOfIgnoreCase(sequence, search, 0);
    }

    /**
     * Case in-sensitive find of the first index within a CharSequence
     * from the specified position.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A negative start position is treated as zero.
     * An empty ("") search CharSequence always matches.
     * A start position greater than the string length only matches
     * an empty search CharSequence.</p>
     *
     * <pre>
     * StringAide.indexOfIgnoreCase(null, *, *)          = -1
     * StringAide.indexOfIgnoreCase(*, null, *)          = -1
     * StringAide.indexOfIgnoreCase("", "", 0)           = 0
     * StringAide.indexOfIgnoreCase("aabaabaa", "A", 0)  = 0
     * StringAide.indexOfIgnoreCase("aabaabaa", "B", 0)  = 2
     * StringAide.indexOfIgnoreCase("aabaabaa", "AB", 0) = 1
     * StringAide.indexOfIgnoreCase("aabaabaa", "B", 3)  = 5
     * StringAide.indexOfIgnoreCase("aabaabaa", "B", 9)  = -1
     * StringAide.indexOfIgnoreCase("aabaabaa", "B", -1) = 2
     * StringAide.indexOfIgnoreCase("aabaabaa", "", 2)   = 2
     * StringAide.indexOfIgnoreCase("abc", "", 9)        = -1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param search  the CharSequence to find, may be null
     * @param fromIndex  the start position, negative treated as zero
     * @return the first index of the search CharSequence (always &ge; startPos),
     *  -1 if no match or {@code null} string input
     */
    public static int indexOfIgnoreCase(final CharSequence sequence, final CharSequence search, int fromIndex) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        final int endLimit = sequence.length() - search.length() + 1;
        if (fromIndex > endLimit) {
            return INDEX_NOT_FOUND;
        }
        if (search.isEmpty()) {
            return fromIndex;
        }
        for (int i = fromIndex; i < endLimit; i++) {
            if (_CharSequenceAide.regionMatches(sequence, true, i, search, 0, search.length())) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Returns the index within {@code seq} of the first occurrence of
     * the specified character. If a character with value
     * {@code searchChar} occurs in the character sequence represented by
     * {@code seq} {@link CharSequence} object, then the index (in Unicode
     * code units) of the first such occurrence is returned. For
     * values of {@code searchChar} in the range from 0 to 0xFFFF
     * (inclusive), this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * this.charAt(<i>k</i>) == searchChar
     * </pre></blockquote>
     * is true. For other values of {@code searchChar}, it is the
     * smallest value <i>k</i> such that:
     * <blockquote><pre>
     * this.codePointAt(<i>k</i>) == searchChar
     * </pre></blockquote>
     * is true. In either case, if no such character occurs in {@code seq},
     * then {@code INDEX_NOT_FOUND (-1)} is returned.
     *
     * <p>Furthermore, a {@code null} or empty ("") CharSequence will
     * return {@code INDEX_NOT_FOUND (-1)}.</p>
     *
     * <pre>
     * StringAide.indexOf(null, *)         = -1
     * StringAide.indexOf("", *)           = -1
     * StringAide.indexOf("aabaabaa", 'a') = 0
     * StringAide.indexOf("aabaabaa", 'b') = 2
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChar  the character to find
     * @return the first index of the search character,
     *  -1 if no match or {@code null} string input
     */
    public static int indexOfChar(final CharSequence sequence, final int searchChar) {
        if (isEmpty(sequence)) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, searchChar, 0);
    }

    /**
     * Returns the index within {@code seq} of the first occurrence of the
     * specified character, starting the search at the specified index.
     * <p>
     * If a character with value {@code searchChar} occurs in the
     * character sequence represented by the {@code seq} {@link CharSequence}
     * object at an index no smaller than {@code startPos}, then
     * the index of the first such occurrence is returned. For values
     * of {@code searchChar} in the range from 0 to 0xFFFF (inclusive),
     * this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= startPos)
     * </pre></blockquote>
     * is true. For other values of {@code searchChar}, it is the
     * smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == searchChar) &amp;&amp; (<i>k</i> &gt;= startPos)
     * </pre></blockquote>
     * is true. In either case, if no such character occurs in {@code seq}
     * at or after position {@code startPos}, then
     * {@code -1} is returned.
     *
     * <p>
     * There is no restriction on the value of {@code startPos}. If it
     * is negative, it has the same effect as if it were zero: this entire
     * string may be searched. If it is greater than the length of this
     * string, it has the same effect as if it were equal to the length of
     * this string: {@code (INDEX_NOT_FOUND) -1} is returned. Furthermore, a
     * {@code null} or empty ("") CharSequence will
     * return {@code (INDEX_NOT_FOUND) -1}.
     *
     * <p>All indices are specified in {@code char} values
     * (Unicode code units).
     *
     * <pre>
     * StringAide.indexOf(null, *, *)          = -1
     * StringAide.indexOf("", *, *)            = -1
     * StringAide.indexOf("aabaabaa", 'b', 0)  = 2
     * StringAide.indexOf("aabaabaa", 'b', 3)  = 5
     * StringAide.indexOf("aabaabaa", 'b', 9)  = -1
     * StringAide.indexOf("aabaabaa", 'b', -1) = 2
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChar  the character to find
     * @param start  the start position, negative treated as zero
     * @return the first index of the search character (always &ge; startPos),
     *  -1 if no match or {@code null} string input
     */
    public static int indexOfChar(final CharSequence sequence, final int searchChar, int start) {
        if (isEmpty(sequence)) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, searchChar, start);
    }

    /**
     * xxxxxxxxxxxxxxxxxxx
     *
     * @param sequence
     * @param searchChar
     * @return
     */
    public static int indexOfChar(final CharSequence sequence, final char searchChar) {
        return indexOfChar(sequence, Character.digit(searchChar, 10));
    }

    /**
     * xxxxxxxxxxxxxxx
     *
     * @param sequence
     * @param searchChar
     * @param start
     * @return
     */
    public static int indexOfChar(final CharSequence sequence, final char searchChar, int start) {
        return indexOfChar(sequence, Character.digit(searchChar, 10), start);
    }

    /**
     * Search a CharSequence to find the first index of any
     * character in the given set of characters.
     *
     * <p>A {@code null} String will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.</p>
     *
     * <pre>
     * StringAide.indexOfAny(null, *)                  = -1
     * StringAide.indexOfAny("", *)                    = -1
     * StringAide.indexOfAny(*, null)                  = -1
     * StringAide.indexOfAny(*, [])                    = -1
     * StringAide.indexOfAny("zzabyycdxx", ['z', 'a']) = 0
     * StringAide.indexOfAny("zzabyycdxx", ['b', 'y']) = 3
     * StringAide.indexOfAny("aba", ['z'])             = -1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChars  the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     */
    public static int indexOfAnyChar(final CharSequence sequence, final char... searchChars) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        final int searchLength = searchChars.length;
        final int searchLast = searchLength - 1;
        final int sequenceLength = sequence.length();
        final int sequenceLast = sequenceLength - 1;
        for (int i = 0; i < sequenceLength; i++) {
            final char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (i >= sequenceLast || j >= searchLast || !Character.isHighSurrogate(ch)) {
                        return i;
                    }
                    if (searchChars[j + 1] == sequence.charAt(i + 1)) {
                        return i;
                    }
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any
     * character in the given set of characters.
     *
     * <p>A {@code null} String will return {@code -1}.
     * A {@code null} search string will return {@code -1}.</p>
     *
     * <pre>
     * StringAide.indexOfAny(null, *)            = -1
     * StringAide.indexOfAny("", *)              = -1
     * StringAide.indexOfAny(*, null)            = -1
     * StringAide.indexOfAny(*, "")              = -1
     * StringAide.indexOfAny("zzabyycdxx", "za") = 0
     * StringAide.indexOfAny("zzabyycdxx", "by") = 3
     * StringAide.indexOfAny("aba", "z")         = -1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChars  the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     */
    public static int indexOfAnyChar(final CharSequence sequence, final CharSequence searchChars) {
        if (isEmpty(sequence) || isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        return indexOfAnyChar(sequence, toCharArray(searchChars));
    }

    /**
     * Searches a CharSequence to find the first index of any
     * character not in the given set of characters.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.</p>
     *
     * <pre>
     * StringAide.indexOfAnyBut(null, *)                              = -1
     * StringAide.indexOfAnyBut("", *)                                = -1
     * StringAide.indexOfAnyBut(*, null)                              = -1
     * StringAide.indexOfAnyBut(*, [])                                = -1
     * StringAide.indexOfAnyBut("zzabyycdxx", new char[] {'z', 'a'} ) = 3
     * StringAide.indexOfAnyBut("aba", new char[] {'z'} )             = 0
     * StringAide.indexOfAnyBut("aba", new char[] {'a', 'b'} )        = -1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChars  the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     */
    public static int indexOfNotAnyChar(final CharSequence sequence, final char... searchChars) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        final int sequenceLength = sequence.length();
        final int sequenceLast = sequenceLength - 1;
        final int searchLength = searchChars.length;
        final int searchLast = searchLength - 1;
        outer:
        for (int i = 0; i < sequenceLength; i++) {
            final char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (i >= sequenceLast || j >= searchLast || !Character.isHighSurrogate(ch)) {
                        continue outer;
                    }
                    if (searchChars[j + 1] == sequence.charAt(i + 1)) {
                        continue outer;
                    }
                }
            }
            return i;
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any
     * character not in the given set of characters.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or empty search string will return {@code -1}.</p>
     *
     * <pre>
     * StringAide.indexOfAnyBut(null, *)            = -1
     * StringAide.indexOfAnyBut("", *)              = -1
     * StringAide.indexOfAnyBut(*, null)            = -1
     * StringAide.indexOfAnyBut(*, "")              = -1
     * StringAide.indexOfAnyBut("zzabyycdxx", "za") = 3
     * StringAide.indexOfAnyBut("zzabyycdxx", "")   = -1
     * StringAide.indexOfAnyBut("aba", "ab")        = -1
     * </pre>
     *
     * @param sequence  the CharSequence to check, may be null
     * @param searchChars  the chars to search for, may be null
     * @return the index of any of the chars, -1 if no match or null input
     */
    public static int indexOfNotAnyChar(final CharSequence sequence, final CharSequence searchChars) {
        if (isEmpty(sequence) || isEmpty(searchChars)) {
            return INDEX_NOT_FOUND;
        }
        final int sequenceLength = sequence.length();
        for (int i = 0; i < sequenceLength; i++) {
            final char ch = sequence.charAt(i);
            final boolean chFound = _CharSequenceAide.indexOf(searchChars, ch, 0) >= 0;
            if (i + 1 < sequenceLength && Character.isHighSurrogate(ch)) {
                final char ch2 = sequence.charAt(i + 1);
                if (chFound && _CharSequenceAide.indexOf(searchChars, ch2, 0) < 0) {
                    return i;
                }
            } else if (!chFound) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Converts the given CharSequence to a char[].
     *
     * @param sequence the {@link CharSequence} to be processed.
     * @return the resulting char array, never null.
     * @since 3.11
     */
    public static char[] toCharArray(final CharSequence sequence) {
        final int length = StringAide.length(sequence);
        if (length == 0) {
            return ArrayConst.EMPTY_CHAR_ARRAY;
        }
        if (sequence instanceof String string) {
            return string.toCharArray();
        }
        final char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = sequence.charAt(i);
        }
        return array;
    }
}
