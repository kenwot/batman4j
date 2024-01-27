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
 * Operations on {@link String} that are {@code null} safe.
 *
 * @author Kenown
 * @since 1.0.0
 */
public class StringAide implements StringConst {

    /**
     * Represents a failed index search.
     */
    public static final int INDEX_NOT_FOUND = _CharSequenceAide.NOT_FOUND;

    /**
     * Gets a CharSequence length or {@code 0} if the CharSequence is {@code null}.
     *
     * @param sequence a CharSequence or {@code null}.
     * @return CharSequence length or {@code 0} if the CharSequence is {@code null}.
     */
    public static int length(CharSequence sequence) {
        return sequence == null ? 0 : sequence.length();
    }

    /**
     * Gets the Code Point length of a CharSequence or {@code 0} if the CharSequence is {@code null}.
     *
     * @param sequence a CharSequence or {@code null}.
     * @return CharSequence's Code Point length or {@code 0} if the CharSequence is {@code null}.
     */
    public static int codepointLength(CharSequence sequence) {
        return sequence == null ? 0 : (int) sequence.codePoints().count();
    }

    /**
     * Checks if a CharSequence is empty ("") or null.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence is empty or null.
     */
    public static boolean isEmpty(CharSequence sequence) {
        return sequence == null || sequence.isEmpty();
    }

    /**
     * Checks if a CharSequence is not empty ("") and not null.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code null} if the CharSequence is not empty and not null.
     */
    public static boolean isNotEmpty(CharSequence sequence) {
        return !isEmpty(sequence);
    }

    /**
     * Checks if all the CharSequences are empty ("") or null.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if all the CharSequences are empty or null.
     */
    public static boolean isAllEmpty(CharSequence... sequences) {
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
     * Checks if any of the CharSequences are empty ("") or null.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if any of the CharSequences are empty or null.
     */
    public static boolean isAnyEmpty(CharSequence... sequences) {
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
     * Checks if none of the CharSequences are empty ("") or null.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if none of the CharSequences are empty or null.
     */
    public static boolean isNoneEmpty(CharSequence... sequences) {
        return !isAnyEmpty(sequences);
    }

    /**
     * Checks if a CharSequence is empty (""), null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isBlankCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence is null, empty or whitespace only.
     * @see #isBlankCoverSupplementary(CharSequence)
     */
    public static boolean isBlank(CharSequence sequence) {
        int length = length(sequence);
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
     * Checks if a CharSequence is empty (""), null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(int)}, including supplementary characters.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence is null, empty or whitespace only.
     * @see #isBlank(CharSequence)
     */
    public static boolean isBlankCoverSupplementary(CharSequence sequence) {
        if (length(sequence) == 0) {
            return true;
        }
        return sequence.codePoints().allMatch(Character::isWhitespace);
    }

    /**
     * Checks if a CharSequence is not empty (""), not null and not whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isNotBlankCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence is not empty and not null and not whitespace only.
     * @see #isNotBlankCoverSupplementary(CharSequence)
     */
    public static boolean isNotBlank(CharSequence sequence) {
        return !isBlank(sequence);
    }

    /**
     * Checks if a CharSequence is not empty (""), not null and not whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(int)}, including supplementary characters.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence is not empty and not null and not whitespace only.
     * @see #isNotBlank(CharSequence)
     */
    public static boolean isNotBlankCoverSupplementary(CharSequence sequence) {
        return !isBlankCoverSupplementary(sequence);
    }

    /**
     * Checks if all the CharSequences are empty (""), null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAllBlankCoverSupplementary(CharSequence...)} method.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if all the CharSequences are empty or null or whitespace only.
     * @see #isAllBlankCoverSupplementary(CharSequence...)
     */
    public static boolean isAllBlank(CharSequence... sequences) {
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
     * Checks if all the CharSequences are empty (""), null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(int)}, including supplementary characters.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if all the CharSequences are empty or null or whitespace only.
     * @see #isAllBlank(CharSequence...)
     */
    public static boolean isAllBlankCoverSupplementary(CharSequence... sequences) {
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
     * Checks if any of the CharSequences are empty ("") or null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAnyBlankCoverSupplementary(CharSequence...)} method.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if any of the CharSequences are empty or null or whitespace only.
     * @see #isAnyBlankCoverSupplementary(CharSequence...)
     */
    public static boolean isAnyBlank(CharSequence... sequences) {
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
     * Checks if any of the CharSequences are empty ("") or null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(int)}, including supplementary character.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if any of the CharSequences are empty or null or whitespace only.
     * @see #isAnyBlank(CharSequence...)
     */
    public static boolean isAnyBlankCoverSupplementary(CharSequence... sequences) {
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
     * Checks if none of the CharSequences are empty (""), null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isNoneBlankCoverSupplementary(CharSequence...)} method.
     *
     * @param sequences the CharSequences to check, may be null or empty.
     * @return {@code true} if none of the CharSequences are empty or null or whitespace only.
     * @see #isNoneBlankCoverSupplementary(CharSequence...)
     */
    public static boolean isNoneBlank(CharSequence... sequences) {
        return !isAnyBlank(sequences);
    }

    /**
     * Checks if none of the CharSequences are empty (""), null or whitespace only.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(int)}, including supplementary characters.
     *
     * @param sequences 要检查的字符序列，可能为 {@code null} 或 {@code empty}.
     * @return 若所有字符序列都非空且包含除了 BMP 或 SMP 空白符以外的字符则为 {@code true}.
     * @see #isNoneBlank(CharSequence...)
     */
    public static boolean isNoneBlankCoverSupplementary(CharSequence... sequences) {
        return !isAnyBlankCoverSupplementary(sequences);
    }

    /**
     * Checks if the CharSequence contains only lowercase characters.
     *
     * <p>Lowercase is defined by {@link Character#isLowerCase(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAllLowerCaseCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains lowercase characters, and is non-null.
     * @see #isAllLowerCaseCoverSupplementary(CharSequence)
     */
    public static boolean isAllLowerCase(CharSequence sequence) {
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
     * Checks if the CharSequence contains only lowercase characters.
     *
     * <p>Lowercase is defined by {@link Character#isLowerCase(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains lowercase characters, and is non-null.
     * @see #isAllLowerCase(CharSequence)
     */
    public static boolean isAllLowerCaseCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().allMatch(Character::isLowerCase);
    }

    /**
     * Checks if the CharSequence contains any lowercase characters.
     *
     * <p>Lowercase is defined by {@link Character#isLowerCase(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAnyLowerCaseCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if contains any lowercase characters, and is non-null.
     * @see #isAnyLowerCaseCoverSupplementary(CharSequence)
     */
    public static boolean isAnyLowerCase(CharSequence sequence) {
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
     * Checks if the CharSequence contains any lowercase characters.
     *
     * <p>Lowercase is defined by {@link Character#isLowerCase(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if contains any lowercase characters, and is non-null.
     * @see #isAnyLowerCase(CharSequence)
     */
    public static boolean isAnyLowerCaseCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().anyMatch(Character::isLowerCase);
    }

    /**
     * Checks if the CharSequence contains only uppercase characters.
     *
     * <p>Uppercase is defined by {@link Character#isUpperCase(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAllUpperCaseCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains uppercase characters, and is non-null.
     * @see #isAllUpperCaseCoverSupplementary(CharSequence)
     */
    public static boolean isAllUpperCase(CharSequence sequence) {
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
     * Checks if the CharSequence contains only uppercase characters.
     *
     * <p>Uppercase is defined by {@link Character#isUpperCase(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains uppercase characters, and is non-null.
     * @see #isAllUpperCase(CharSequence)
     */
    public static boolean isAllUpperCaseCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().allMatch(Character::isUpperCase);
    }

    /**
     * Checks if the CharSequence contains any uppercase characters.
     *
     * <p>Lowercase is defined by {@link Character#isUpperCase(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAnyUpperCaseCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if contains any uppercase characters, and is non-null.
     * @see #isAnyUpperCaseCoverSupplementary(CharSequence)
     */
    public static boolean isAnyUpperCase(CharSequence sequence) {
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
     * Checks if the CharSequence contains any uppercase characters.
     *
     * <p>Lowercase is defined by {@link Character#isUpperCase(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if contains any uppercase characters, and is non-null.
     * @see #isAnyUpperCase(CharSequence)
     */
    public static boolean isAnyUpperCaseCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().anyMatch(Character::isUpperCase);
    }

    /**
     * Checks if the CharSequence contains mixed casing of both uppercase and lowercase characters.
     *
     * <p>Uppercase is defined by {@link Character#isUpperCase(char)}.
     * Lowercase is defined by {@link Character#isLowerCase(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isMixedCaseCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence contains both uppercase and lowercase characters.
     * @see #isMixedCaseCoverSupplementary(CharSequence)
     */
    public static boolean isMixedCase(CharSequence sequence) {
        if (isEmpty(sequence) || sequence.length() == 1) {
            return false;
        }
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        int length = sequence.length();
        for (int i = 0; i < length; i++) {
            char ch = sequence.charAt(i);
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
     * Checks if the CharSequence contains mixed casing of both uppercase and lowercase characters.
     *
     * <p>Uppercase is defined by {@link Character#isUpperCase(int)}.
     * Lowercase is defined by {@link Character#isLowerCase(int)}.
     * Including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if the CharSequence contains both uppercase and lowercase characters.
     * @see #isMixedCase(CharSequence)
     */
    public static boolean isMixedCaseCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence) || sequence.length() == 1) {
            return false;
        }
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        for (int codepoint : sequence.codePoints().toArray()) {
            if (Character.isUpperCase(codepoint)) {
                containsUppercase = true;
            }
            if (Character.isLowerCase(codepoint)) {
                containsLowercase = true;
            }
            if (containsUppercase && containsLowercase) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the CharSequence contains only space.
     *
     * <p>Space is defined by {@link Character#isSpaceChar(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isMixedCaseCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be {@code null}.
     * @return {@code true} if only contains space, and is non-null.
     * @see #isSpaceCoverSupplementary(CharSequence)
     */
    public static boolean isSpace(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isSpaceChar(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only space.
     *
     * <p>Space is defined by {@link Character#isSpaceChar(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * @param sequence the CharSequence to check, may be {@code null}.
     * @return {@code true} if only contains space, and is non-null.
     * @see #isSpace(CharSequence)
     */
    public static boolean isSpaceCoverSupplementary(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return sequence.codePoints().allMatch(Character::isSpaceChar);
    }

    /**
     * Checks if the CharSequence contains only whitespace.
     *
     * <p>This method is similar to {@link #isBlank(CharSequence)},
     * but will return {@code false} instead of {@code true} if the CharSequence is {@code null}.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isWhitespaceCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains whitespace, and is non-null.
     * @see #isWhitespaceCoverSupplementary(CharSequence)
     */
    public static boolean isWhitespace(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return isBlank(sequence);
    }

    /**
     * Checks if the CharSequence contains only whitespace.
     *
     * <p>This method is similar to {@link #isBlankCoverSupplementary(CharSequence)},
     * but will return {@code false} instead of {@code true} if the CharSequence is {@code null}.
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains whitespace, and is non-null.
     * @see #isWhitespace(CharSequence)
     */
    public static boolean isWhitespaceCoverSupplementary(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return isBlankCoverSupplementary(sequence);
    }

    /**
     * Checks if the CharSequence contains only Unicode letters.
     *
     * <p>Letter is defined by {@link Character#isLetter(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAlphaCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters, and is non-null.
     * @see #isAlphaCoverSupplementary(CharSequence)
     */
    public static boolean isAlpha(CharSequence sequence) {
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
     * Checks if the CharSequence contains only Unicode letters.
     *
     * <p>Letter is defined by {@link Character#isLetter(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters, and is non-null.
     * @see #isAlpha(CharSequence)
     */
    public static boolean isAlphaCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().allMatch(Character::isLetter);
    }

    /**
     * Checks if the CharSequence contains only Unicode letters or digits.
     *
     * <p>Letter and digit are defined by {@link Character#isLetterOrDigit(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAlphanumericCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters or digits, and is non-null.
     * @see #isAlphanumericCoverSupplementary(CharSequence)
     */
    public static boolean isAlphanumeric(CharSequence sequence) {
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
     * Checks if the CharSequence contains only Unicode letters or digits.
     *
     * <p>Letter and digit are defined by {@link Character#isLetterOrDigit(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters or digits, and is non-null.
     * @see #isAlphanumeric(CharSequence)
     */
    public static boolean isAlphanumericCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().allMatch(Character::isLetterOrDigit);
    }

    /**
     * Checks if the CharSequence contains only Unicode letters, digits or space ({@code ' '}).
     *
     * <p>Letter and digit are defined by {@link Character#isLetterOrDigit(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAlphanumericSpaceCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters, digits or space, and is non-null.
     * @see #isAlphanumericSpaceCoverSupplementary(CharSequence)
     */
    public static boolean isAlphanumericSpace(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c != CharConst.SPACE_CHAR && !Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode letters, digits or space ({@code ' '}).
     *
     * <p>Letter and digit are defined by {@link Character#isLetterOrDigit(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters, digits or space, and is non-null.
     * @see #isAlphanumericSpace(CharSequence)
     */
    public static boolean isAlphanumericSpaceCoverSupplementary(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return sequence.codePoints().allMatch(cp -> cp == CharConst.SPACE_CHAR || Character.isLetterOrDigit(cp));
    }

    /**
     * Checks if the CharSequence contains only Unicode letters and space ({@code ' '}).
     *
     * <p>Letter is defined by {@link Character#isLetter(char)}.
     *
     * <p>{@code null} will return {@code false} An empty CharSequence (length()=0) will return {@code true}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isAlphaSpaceCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters and space, and is non-null.
     * @see #isAlphaSpaceCoverSupplementary(CharSequence)
     */
    public static boolean isAlphaSpace(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c != CharConst.SPACE_CHAR && !Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode letters and space ({@code ' '}).
     *
     * <p>Letter is defined by {@link Character#isLetter(char)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false} An empty CharSequence (length()=0) will return {@code true}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains letters and space, and is non-null.
     * @see #isAlphaSpace(CharSequence)
     */
    public static boolean isAlphaSpaceCoverSupplementary(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return sequence.codePoints().allMatch(cp -> cp == CharConst.SPACE_CHAR || Character.isLetter(cp));
    }

    /**
     * Checks if the CharSequence contains only Unicode digits.
     * A decimal point is not a Unicode digit and returns false.
     *
     * <p>Digit is defined by {@link Character#isDigit(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p>Note that the method does not allow for a leading sign, either positive or negative.
     * Also, if a String passes the numeric test, it may still generate a NumberFormatException
     * when parsed by Integer.parseInt or Long.parseLong, e.g. if the value is outside the range
     * for int or long respectively.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isNumericCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains digits, and is non-null.
     * @see #isNumericCoverSupplementary(CharSequence)
     */
    public static boolean isNumeric(CharSequence sequence) {
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
     * Checks if the CharSequence contains only Unicode digits.
     * A decimal point is not a Unicode digit and returns false.
     *
     * <p>Digit is defined by {@link Character#isDigit(char)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code false}.
     *
     * <p>Note that the method does not allow for a leading sign, either positive or negative.
     * Also, if a String passes the numeric test, it may still generate a NumberFormatException
     * when parsed by Integer.parseInt or Long.parseLong, e.g. if the value is outside the range
     * for int or long respectively.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains digits, and is non-null.
     * @see #isNumeric(CharSequence)
     */
    public static boolean isNumericCoverSupplementary(CharSequence sequence) {
        if (isEmpty(sequence)) {
            return false;
        }
        return sequence.codePoints().allMatch(Character::isDigit);
    }

    /**
     * Checks if the CharSequence contains only Unicode digits or space ({@code ' '}).
     * A decimal point is not a Unicode digit and returns false.
     *
     * <p>Letter is defined by {@link Character#isDigit(char)}.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #isNumericSpaceCoverSupplementary(CharSequence)} method.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains digits or space, and is non-null.
     * @see #isNumericSpaceCoverSupplementary(CharSequence)
     */
    public static boolean isNumericSpace(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c != CharConst.SPACE_CHAR && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the CharSequence contains only Unicode digits or space ({@code ' '}).
     * A decimal point is not a Unicode digit and returns false.
     *
     * <p>Letter is defined by {@link Character#isDigit(int)}, including supplementary characters.
     *
     * <p>{@code null} will return {@code false}. An empty CharSequence (length()=0) will return {@code true}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if only contains digits or space, and is non-null.
     * @see #isNumericSpace(CharSequence)
     */
    public static boolean isNumericSpaceCoverSupplementary(CharSequence sequence) {
        if (sequence == null) {
            return false;
        }
        return sequence.codePoints().allMatch(cp -> cp == CharConst.SPACE_CHAR || Character.isDigit(cp));
    }

    /**
     * Checks if the CharSequence contains only ASCII printable characters.
     *
     * <p>{@code null} will return {@code false}.
     * An empty CharSequence (length()=0) will return {@code true}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @return {@code true} if every character is in the range 32 through 126.
     * @see CharAide#isAsciiPrintable(char)
     */
    public static boolean isAsciiPrintable(CharSequence sequence) {
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
     * Returns the index within a CharSequence of the first occurrence of the specified subsequence.
     *
     * <p>This method uses {@link String#indexOf(String, int)} if possible.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param search   the subsequence to search for, may be null.
     * @return the index of the first occurrence of the specified subsequence, or -1 if there is no such occurrence.
     */
    public static int indexOf(CharSequence sequence, CharSequence search) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, 0);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified subsequence,
     * starting at the specified index.
     *
     * <p>This method uses {@link String#indexOf(String, int)} if possible.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the subsequence to search for, may be null.
     * @param beginIndex the index from which to start the search.
     * @return the index of the first occurrence of the specified subsequence,
     *         starting at hte specified index,
     *         or -1 if there is no such occurrence.
     */
    public static int indexOf(CharSequence sequence, CharSequence search, int beginIndex) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, beginIndex);
    }

    /**
     * Returns the index of the first occurrence of the specified subsequence
     * within the specified index range of a CharSequence.
     *
     * <p>This method uses {@link String#indexOf(String, int, int)} if possible.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the subsequence to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex   the index to stop the search at (excluded).
     * @return the index of the first occurrence of the specified subsequence within the specified index range,
     *         or -1 if there is no such occurrence.
     */
    public static int indexOf(CharSequence sequence, CharSequence search, int beginIndex, int endIndex) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, beginIndex, endIndex);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified subsequence,
     * ignoring case considerations.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param search   the subsequence to search for, may be null.
     * @return the index of the first occurrence of the specified subsequence ignoring case,
     *         or -1 if there is no such occurrence.
     */
    public static int indexOfIgnoreCase(CharSequence sequence, CharSequence search) {
        return indexOfIgnoreCase(sequence, search, 0);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified subsequence,
     * starting at the specified index, ignoring case considerations.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the subsequence to search for, may be null.
     * @param beginIndex the index from which to start the search.
     * @return the index of the first occurrence of the specified subsequence ignoring case,
     *         starting at hte specified index,
     *         or -1 if there is no such occurrence.
     */
    public static int indexOfIgnoreCase(CharSequence sequence, CharSequence search, int beginIndex) {
        if (sequence == null || search == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        int endLimit = sequence.length() - search.length() + 1;
        if (beginIndex > endLimit) {
            return INDEX_NOT_FOUND;
        }
        if (search.isEmpty()) {
            return beginIndex;
        }
        for (int i = beginIndex; i < endLimit; i++) {
            if (_CharSequenceAide.regionMatches(true, sequence, i, search, 0, search.length())) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Returns the index of first occurrence of the specified subsequence
     * with in the specified index range of a CharSequence, ignoring case considerations.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the subsequence to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex   the index to stop the search at (excluded).
     * @return the index of the first occurrence of the specified subsequence
     *         within the specified index range ignoring case,
     *         or -1 there is no such occurrence.
     */
    public static int indexOfIgnoreCase(CharSequence sequence, CharSequence search, int beginIndex, int endIndex) {
        endIndex = Math.min(endIndex, length(sequence));
        return indexOfIgnoreCase(sequence.subSequence(0, endIndex), search, beginIndex);
    }

    /**
     * Returns the first index of any in a set of potential subsequences.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored,
     * but a search array containing "" will return {@code 0} if {@code sequence} is not null.
     *
     * <p>This method use {@link String#indexOf(String)} if possible.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the subsequence to search for, may be null.
     * @return the first index of any the {@code searches} within {@code sequence}, or -1 if no match.
     */
    public static int indexOfAny(CharSequence sequence, CharSequence... searches) {
        return indexOfAny(sequence, searches, 0);
    }

    /**
     * Returns the first index of any in a set of potential subsequences, starting at the specified index.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored,
     * but a search array containing "" will return {@code 0} if {@code sequence} is not null.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param searches   the subsequence to search for, may be null.
     * @param beginIndex the index from which to start the search.
     * @return the first index of any in a set of potential,
     *         starting at hte specified index,
     *         or -1 if no match.
     */
    public static int indexOfAny(CharSequence sequence, CharSequence[] searches, int beginIndex) {
        if (sequence == null || searches == null) {
            return INDEX_NOT_FOUND;
        }
        int ret = Integer.MAX_VALUE;
        int tmp;
        for (CharSequence search : searches) {
            if (search == null) {
                continue;
            }
            tmp = _CharSequenceAide.indexOf(sequence, search, beginIndex);
            if (tmp == INDEX_NOT_FOUND) {
                continue;
            }
            if (tmp < ret) {
                ret = tmp;
            }
        }
        return ret == Integer.MAX_VALUE ? INDEX_NOT_FOUND : ret;
    }

    /**
     * Returns the first index of any in a set of potential subsequences
     * within the specified index range of a CharSequence.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored,
     * but a search array containing "" will return {@code 0} if {@code sequence} is not null.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param searches   the subsequence to search for, may be null.
     * @param beginIndex the index to start the search from, inclusive.
     * @param endIndex   the index to stop the search at, exclusive.
     * @return the first index of any in a set of potential subsequences within the specified index range,
     *         or -1 of there is no such occurrence.
     */
    public static int indexOfAny(CharSequence sequence, CharSequence[] searches, int beginIndex, int endIndex) {
        endIndex = Math.min(endIndex, length(sequence));
        return indexOfAny(sequence.subSequence(0, endIndex), searches, beginIndex);
    }

    /**
     * Case in-sensitive return the first index of any in a set of potential subsequences.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored,
     * but a search array containing "" will return {@code 0} if {@code sequence} is not null.
     *
     * <p>This method use {@link String#indexOf(String)} if possible.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the subsequence to search for, may be null.
     * @return the first index of any the {@code searches} within {@code sequence} ignoring case,
     *         or -1 if no match.
     */
    public static int indexOfAnyIgnoreCase(CharSequence sequence, CharSequence... searches) {
        return indexOfAnyIgnoreCase(sequence, searches, 0);
    }

    /**
     * Returns the first index of any in a set of potential subsequences,
     * starting at the specified index, ignoring case considerations.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored,
     * but a search array containing "" will return {@code 0} if {@code sequence} is not null.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param searches   the subsequence to search for, may be null.
     * @param beginIndex the index from which to start the search.
     * @return the first index of any in a set of potential ignoring case,
     *         starting at hte specified index,
     *         or -1 if no match.
     */
    public static int indexOfAnyIgnoreCase(CharSequence sequence, CharSequence[] searches, int beginIndex) {
        if (sequence == null || searches == null) {
            return INDEX_NOT_FOUND;
        }
        int ret = Integer.MAX_VALUE;
        int tmp;
        for (CharSequence search : searches) {
            if (search == null) {
                continue;
            }
            tmp = indexOfIgnoreCase(sequence, search, beginIndex);
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
     * Returns the first index of any in a set of potential subsequences
     * within the specified index range of a CharSequence, ignoring case considerations.
     *
     * <p>A {@code null} CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     * A {@code null} search array entry will be ignored,
     * but a search array containing "" will return {@code 0} if {@code sequence} is not null.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param searches   the subsequence to search for, may be null.
     * @param beginIndex the index to start the search from, inclusive.
     * @param endIndex   the index to stop the search at, exclusive.
     * @return the first index of any in a set of potential subsequences within the specified index range ignoring case,
     *         or -1 of there is no such occurrence.
     */
    public static int indexOfAnyIgnoreCase(CharSequence sequence, CharSequence[] searches, int beginIndex, int endIndex) {
        endIndex = Math.min(endIndex, length(sequence));
        return indexOfAnyIgnoreCase(sequence.subSequence(0, endIndex), searches, beginIndex);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character.
     *
     * <p>If a character with value {@code search} occurs in the character sequence
     * represented by {@code sequence} CharSequence object,
     * then the index (in Unicode code units) of the first such occurrence is returned.
     *
     * <p>For values of {@code search} in the range from 0 to 0xFFFF (inclusive),
     * the result is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * this.charAt(<i>k</i>) == search
     * </pre></blockquote>
     *
     * <p>For other values of {@code search}, it is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * this.codePointAt(<i>k</i>) == search
     * </pre></blockquote>
     *
     * <p>In either case, if no such character occurs in the CharSequence, then -1 is returned.
     *
     * <p>Furthermore, a {@code null} or empty ("") CharSequence will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param search   a character (Unicode code point) to be searched for.
     * @return the first index of the {@code search} character,
     *         {@code -1} if no match or {@code null} CharSequence input.
     */
    public static int indexOfChar(CharSequence sequence, int search) {
        if (isEmpty(sequence)) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, 0);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character,
     * starting the search at the specified index.
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
     * <p>Furthermore, a {@code null} or empty ("") CharSequence will return {@code -1}.
     *
     * <p>All indices are specified in {@code char} values (Unicode code units).
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the char to be searched for (Unicode code point).
     * @param beginIndex the index to start the search from.
     * @return the first index of the search character (always &ge; fromIndex),
     *         {@code -1} if no match or {@code null} CharSequence input.
     */
    public static int indexOfChar(CharSequence sequence, int search, int beginIndex) {
        if (isEmpty(sequence)) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, beginIndex);
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
     * <p>Furthermore, a {@code null} or empty ("") CharSequence will return {@code -1}.
     *
     * <p>All indices are specified in {@code char} values (Unicode code units).
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the char to be searched for (Unicode code point).
     * @param beginIndex the index to start the search from, inclusive.
     * @param endIndex   the index to start the search from, exclusive.
     * @return the index of the first occurrence of the character in the CharSequence
     *         that is greater than or equal to {@code beginIndex} and less than {@code endIndex},
     *         or {@code -1} if the character does not occur or {@code null} CharSequence input.
     */
    public static int indexOfChar(CharSequence sequence, int search, int beginIndex, int endIndex) {
        if (isEmpty(sequence)) {
            return INDEX_NOT_FOUND;
        }
        return _CharSequenceAide.indexOf(sequence, search, beginIndex, endIndex);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character.
     *
     * <p>See {@link #indexOfChar(CharSequence, int)} for details.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param search   the character to search for.
     * @return the first index or {@code -1}.
     * @see #indexOfChar(CharSequence, int)
     */
    public static int indexOfChar(CharSequence sequence, char search) {
        return indexOfChar(sequence, (int) search);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character,
     * starting the search at the specified index.
     *
     * <p>See {@link #indexOfChar(CharSequence, int, int)} for details.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the character to search for.
     * @param beginIndex the index to start the search from.
     * @return the first index or {@code -1}.
     * @see #indexOfChar(CharSequence, int, int)
     */
    public static int indexOfChar(CharSequence sequence, char search, int beginIndex) {
        return indexOfChar(sequence, (int) search, beginIndex);
    }

    /**
     * Returns the index within a CharSequence of the first occurrence of the specified character,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>See {@link #indexOfChar(CharSequence, int, int, int)} for details.
     *
     * @param sequence   the CharSequence to be processed, may be null.
     * @param search     the char to be searched for (Unicode code point).
     * @param beginIndex the index to start the search from, inclusive.
     * @param endIndex   the index to start the search from, exclusive.
     * @return the first index or {@code -1}.
     * @see #indexOfChar(CharSequence, int, int, int)
     */
    public static int indexOfChar(CharSequence sequence, char search, int beginIndex, int endIndex) {
        return indexOfChar(sequence, (int) search, beginIndex, endIndex);
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, int... searches) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (int search : searches) {
            int index = indexOfChar(sequence, search);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters,
     * starting at the specified index.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index of the CharSequence to start the search from.
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, int[] searches, int beginIndex) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (int search : searches) {
            int index = indexOfChar(sequence, search, beginIndex);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex the index to stop the search at (excluded).
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, int[] searches, int beginIndex, int endIndex) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (int search : searches) {
            int index = indexOfChar(sequence, search, beginIndex, endIndex);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, char... searches) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (char search : searches) {
            int index = indexOfChar(sequence, search);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters,
     * starting at the specified index.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index of the CharSequence to start the search from.
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, char[] searches, int beginIndex) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (char search : searches) {
            int index = indexOfChar(sequence, search, beginIndex);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex the index to stop the search at (excluded).
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, char[] searches, int beginIndex, int endIndex) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (char search : searches) {
            int index = indexOfChar(sequence, search, beginIndex, endIndex);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, CharSequence searches) {
        if (isEmpty(sequence) || isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (int cp : searches.codePoints().toArray()) {
            int index = indexOfChar(sequence, cp);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters,
     * starting at the specified index.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index of the CharSequence to start the search from.
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, CharSequence searches, int beginIndex) {
        if (isEmpty(sequence) || isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (int cp : searches.codePoints().toArray()) {
            int index = indexOfChar(sequence, cp, beginIndex);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Search a CharSequence to find the first index of any character in the given set of characters,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to be processed, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex the index to stop the search at (excluded).
     * @return the index of any the chars, {@code -1} if no match or null input.
     */
    public static int indexOfAnyChar(CharSequence sequence, CharSequence searches, int beginIndex, int endIndex) {
        if (isEmpty(sequence) || isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        for (int cp : searches.codePoints().toArray()) {
            int index = indexOfChar(sequence, cp, beginIndex, endIndex);
            if (index != INDEX_NOT_FOUND) {
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for (Unicode code point), may be null.
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, int... searches) {
        return indexOfNotAnyChar(sequence, searches, 0, length(sequence));
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters,
     * starting at the specified index.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for (Unicode code point), may be null.
     * @param beginIndex the index of the CharSequence to start the search from.
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, int[] searches, int beginIndex) {
        return indexOfNotAnyChar(sequence, searches, beginIndex, length(sequence));
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for (Unicode code point), may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex the index to stop the search at (excluded).
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, int[] searches, int beginIndex, int endIndex) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }

        char[] tempChars = new char[searches.length * 2];
        int tempIndex = 0;
        for (int search : searches) {
            char[] chars = Character.toChars(search);
            tempChars[tempIndex++] = chars[0];
            if (chars.length > 1) {
                tempChars[tempIndex++] = chars[1];
            }
        }
        char[] chars = new char[tempIndex];
        System.arraycopy(tempChars, 0, chars, 0, tempIndex);

        return indexOfNotAnyChar(sequence, chars, beginIndex, endIndex);
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for, may be null.
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, char... searches) {
        return indexOfNotAnyChar(sequence, searches, 0, length(sequence));
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters,
     * starting at the specified index.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index of the CharSequence to start the search from.
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, char[] searches, int beginIndex) {
        return indexOfNotAnyChar(sequence, searches, beginIndex, length(sequence));
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex the index to stop the search at (excluded).
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, char[] searches, int beginIndex, int endIndex) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        int sequenceLength = sequence.length();
        if (beginIndex < 0) {
            beginIndex = 0;
        } else if (beginIndex > sequenceLength) {
            return INDEX_NOT_FOUND;
        }
        if (endIndex > sequenceLength) {
            endIndex = sequenceLength;
        }
        if (endIndex <= beginIndex) {
            return INDEX_NOT_FOUND;
        }

        int sequenceLast = endIndex - 1;
        int searchLength = searches.length;
        int searchLast = searchLength - 1;
        outer:
        for (int i = beginIndex; i < endIndex; i++) {
            char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searches[j] == ch) {
                    if (i >= sequenceLast || j >= searchLast || !Character.isHighSurrogate(ch)) {
                        continue outer;
                    }
                    if (searches[j + 1] == sequence.charAt(i + 1)) {
                        continue outer;
                    }
                }
            }
            return i;
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for, may be null.
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, CharSequence searches) {
        return indexOfNotAnyChar(sequence, searches, 0, length(sequence));
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters,
     * starting at the specified index.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index of the CharSequence to start the search from.
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, CharSequence searches, int beginIndex) {
        return indexOfNotAnyChar(sequence, searches, beginIndex, length(sequence));
    }

    /**
     * Searches a CharSequence to find the first index of any character not in the give set of characters,
     * starting the search at {@code beginIndex} and stopping before {@code endIndex}.
     *
     * <p>A {@code null} or zero length CharSequence will return {@code -1}.
     * A {@code null} or zero length search array will return {@code -1}.
     *
     * @param sequence the CharSequence to check, may be null.
     * @param searches the chars to search for, may be null.
     * @param beginIndex the index to start the search from (included).
     * @param endIndex the index to stop the search at (excluded).
     * @return the index of any the chars, -1 if no match or null input.
     */
    public static int indexOfNotAnyChar(CharSequence sequence, CharSequence searches, int beginIndex, int endIndex) {
        if (isEmpty(sequence) || isEmpty(searches)) {
            return INDEX_NOT_FOUND;
        }
        int sequenceLength = sequence.length();
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (beginIndex > sequenceLength) {
            return INDEX_NOT_FOUND;
        }
        if (endIndex > sequenceLength) {
            endIndex = sequenceLength;
        }
        if (endIndex <= beginIndex) {
            return INDEX_NOT_FOUND;
        }
        for (int i = beginIndex; i < endIndex; i++) {
            char ch = sequence.charAt(i);
            boolean chFound = _CharSequenceAide.indexOf(searches, ch, 0) >= 0;
            if (i + 1 < endIndex && Character.isHighSurrogate(ch)) {
                char ch2 = sequence.charAt(i + 1);
                if (chFound && _CharSequenceAide.indexOf(searches, ch2, 0) < 0) {
                    return i;
                }
            } else if (!chFound) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * Checks if CharSequence contains a search CharSequence, handling {@code null}.
     * This method uses {@link String#indexOf(String)} if possible.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
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
     * @param sequence the CharSequence to check, may be null
     * @param search   the CharSequence to find, may be null
     * @return true if the CharSequence contains the search CharSequence, false if not or {@code null} string input
     */
    public static boolean contains(CharSequence sequence, CharSequence search) {
        if (sequence == null || search == null) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, search, 0) >= 0;
    }

    /**
     * Checks if CharSequence contains a search CharSequence irrespective of case, handling {@code null}.
     * Case-insensitivity is defined as by {@link String#equalsIgnoreCase(String)}.
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
     * @param sequence the CharSequence to check, may be null
     * @param search   the CharSequence to find, may be null
     * @return true if the CharSequence contains the search CharSequence irrespective of case or false if not or {@code null} string input
     */
    public static boolean containsIgnoreCase(CharSequence sequence, CharSequence search) {
        if (sequence == null || search == null) {
            return false;
        }
        int searchLength = search.length();
        for (int i = 0; i <= (sequence.length() - searchLength); i++) {
            if (_CharSequenceAide.regionMatches(true, sequence, i, search, 0, searchLength)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the CharSequence contains any of the CharSequences in the given array.
     *
     * <p>A {@code null} {@code cs} CharSequence will return {@code false}. A {@code null} or zero length search array will
     * return {@code false}.
     *
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
     * @param sequence        The CharSequence to check, may be null
     * @param searchSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *                        null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     */
    public static boolean containsAny(CharSequence sequence, CharSequence... searchSequences) {
        if (sequence == null || ArrayAide.isEmpty(searchSequences)) {
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
     * <p>A {@code null} {@code cs} CharSequence will return {@code false}.
     * A {@code null} or zero length search array will return {@code false}.
     *
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
     * @param sequence        The CharSequence to check, may be null
     * @param searchSequences The array of CharSequences to search for, may be null. Individual CharSequences may be
     *                        null as well.
     * @return {@code true} if any of the search CharSequences are found, {@code false} otherwise
     */
    public static boolean containsAnyIgnoreCase(CharSequence sequence, CharSequence... searchSequences) {
        if (sequence == null || ArrayAide.isEmpty(searchSequences)) {
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
     * Checks that the CharSequence does not contain certain CharSequence in the given array, handling {@code null}.
     *
     * <p>A {@code null} {@code sequence} CharSequence will return {@code true}.
     * A {@code null} or zero length search array will return {@code true}.
     *
     *
     * @param sequence         the CharSequence to check, may be null
     * @param invalidSequences an array of invalid sequences, may be null
     * @return {@code true} if it contains none of the invalid sequences, or is null
     */
    public static boolean containsNone(CharSequence sequence, CharSequence... invalidSequences) {
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
     * Checks that the CharSequence does not contain certain CharSequence in the given array, handling {@code null}.
     * Case-insensitivity is defined as by {@link String#equalsIgnoreCase(String)}.
     *
     * <p>A {@code null} {@code sequence} CharSequence will return {@code true}.
     * A {@code null} or zero length search array will return {@code true}.
     *
     *
     * @param sequence         the CharSequence to check, may be null
     * @param invalidSequences an array of invalid sequences, may be null
     * @return {@code true} if it contains none of the invalid sequences irrespective of case, or is null
     */
    public static boolean containsNoneIgnoreCase(CharSequence sequence, CharSequence... invalidSequences) {
        if (sequence == null || invalidSequences == null) {
            return true;
        }
        for (CharSequence invalidSequence : invalidSequences) {
            if (containsIgnoreCase(sequence, invalidSequence)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if CharSequence contains a search character, handling {@code null}.
     * This method uses {@link String#indexOf(int)} if possible.
     *
     * <p>A {@code null} or empty ("") CharSequence will return {@code false}.
     *
     * <p><b>Note:</b> This method cannot handle supplementary characters.
     * To support all Unicode characters, including supplementary characters,
     * use the {@link #containsChar(CharSequence, int)} method.
     *
     * <pre>
     * StringAide.contains(null, *)    = false
     * StringAide.contains("", *)      = false
     * StringAide.contains("abc", 'a') = true
     * StringAide.contains("abc", 'z') = false
     * </pre>
     *
     * @param sequence   the CharSequence to check, may be null
     * @param searchChar the character to find
     * @return true if the CharSequence contains the search character, false if not or {@code null} string input
     * @see #containsChar(CharSequence, int)
     */
    public static boolean containsChar(CharSequence sequence, char searchChar) {
        return containsChar(sequence, (int) searchChar);
    }

    /**
     * Checks if CharSequence contains a search character, handling {@code null}.
     * This method uses {@link String#indexOf(int)} if possible.
     *
     * <p>A {@code null} or empty ("") CharSequence will return {@code false}.
     *
     * <pre>
     * StringAide.contains(null, *)    = false
     * StringAide.contains("", *)      = false
     * StringAide.contains("abc", 'a') = true
     * StringAide.contains("abc", 'z') = false
     * </pre>
     *
     * @param sequence   the CharSequence to check, may be null
     * @param searchChar the character to find
     * @return true if the CharSequence contains the search character, false if not or {@code null} string input
     * @see #containsChar(CharSequence, char)
     */
    public static boolean containsChar(CharSequence sequence, int searchChar) {
        if (isEmpty(sequence)) {
            return false;
        }
        return _CharSequenceAide.indexOf(sequence, searchChar, 0) >= 0;
    }

    /**
     * Checks if the CharSequence contains any character in the given set of characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} or zero length search array will return {@code false}.
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
     * @param sequence    the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the {@code true} if any of the chars are found, {@code false} if no match or null input
     */
    public static boolean containsAnyChar(CharSequence sequence, char... searchChars) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(searchChars)) {
            return false;
        }
        int sequenceLength = sequence.length();
        int searchLength = searchChars.length;
        int sequenceLast = sequenceLength - 1;
        int searchLast = searchLength - 1;
        for (int i = 0; i < sequenceLength; i++) {
            char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (!Character.isHighSurrogate(ch)) {
                        // ch is in the Basic Multilingual Plane
                        return true;
                    }
                    if (j == searchLast) {
                        // missing low surrogate, fine, like String.indexOf(String)
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
     * Checks if the CharSequence contains any character in the given set of characters (code points).
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} or zero length search array will return {@code false}.
     *
     * @param sequence   the CharSequence to check, may be null
     * @param codepoints the chars to search for, may be null
     * @return the {@code true} if any of the chars are found, {@code false} if no match or null input
     */
    public static boolean containsAnyChar(CharSequence sequence, int... codepoints) {
        if (isEmpty(sequence) || ArrayAide.isEmpty(codepoints)) {
            return false;
        }
        return sequence.codePoints().anyMatch(cp -> {
            for (int searchChar : codepoints) {
                if (cp == searchChar) {
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * Checks if the CharSequence contains any character in the given set of characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} search CharSequence will return {@code false}.
     *
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
     * @param sequence    the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the {@code true} if any of the chars are found, {@code false} if no match or null input
     */
    public static boolean containsAnyChar(CharSequence sequence, CharSequence searchChars) {
        if (searchChars == null) {
            return false;
        }
        return containsAnyChar(sequence, toCharArray(searchChars));
    }

    /**
     * Checks that the CharSequence does not contain certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty CharSequence (length()=0) always returns true.
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
     * @param sequence    the CharSequence to check, may be null
     * @param searchChars an array of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     */
    public static boolean containsNoneChar(CharSequence sequence, char... searchChars) {
        if (sequence == null || searchChars == null) {
            return true;
        }
        int sequenceLength = sequence.length();
        int sequenceLast = sequenceLength - 1;
        int searchLength = searchChars.length;
        int searchLast = searchLength - 1;
        for (int i = 0; i < sequenceLength; i++) {
            char ch = sequence.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (!Character.isHighSurrogate(ch)) {
                        // ch is in the Basic Multilingual Plane
                        return false;
                    }
                    if (j == searchLast) {
                        // missing low surrogate, fine, like String.indexOf(String)
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
     * Checks that the CharSequence does not contain certain characters (code points).
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty CharSequence (length()=0) always returns true.
     *
     * @param sequence   the CharSequence to check, may be null
     * @param codepoints an array of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     */
    public static boolean containsNoneChar(CharSequence sequence, int... codepoints) {
        if (sequence == null || codepoints == null) {
            return true;
        }
        return sequence.codePoints().noneMatch(cp -> {
            for (int searchChar : codepoints) {
                if (cp == searchChar) {
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * Checks that the CharSequence does not contain certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty String ("") always returns true.
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
     * @param sequence     the CharSequence to check, may be null
     * @param invalidChars a String of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     * @since 2.0
     * @since 3.0 Changed signature from containsNone(String, String) to containsNone(CharSequence, String)
     */
    public static boolean containsNoneChar(CharSequence sequence, CharSequence invalidChars) {
        if (invalidChars == null) {
            return true;
        }
        return containsNoneChar(sequence, toCharArray(invalidChars));
    }

    /**
     * Checks if the CharSequence contains only certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character array will return {@code false}.
     * An empty CharSequence (length()=0) always returns {@code true}.
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
     * @param sequence   the String to check, may be null
     * @param validChars an array of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     */
    public static boolean containsOnlyChars(CharSequence sequence, char... validChars) {
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
     * Checks if the CharSequence contains only certain characters (code points).
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character array will return {@code false}.
     * An empty CharSequence (length()=0) always returns {@code true}.
     *
     * @param sequence   the String to check, may be null
     * @param codepoints an array of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     */
    public static boolean containsOnlyChars(CharSequence sequence, int... codepoints) {
        if (sequence == null || codepoints == null || codepoints.length == 0) {
            return false;
        }
        if (sequence.isEmpty()) {
            return true;
        }
        return indexOfNotAnyChar(sequence, codepoints) == INDEX_NOT_FOUND;
    }

    /**
     * Checks if the CharSequence contains only certain characters.
     *
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} valid character String will return {@code false}.
     * An empty String (length()=0) always returns {@code true}.
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
     * @param sequence   the CharSequence to check, may be null
     * @param validChars a String of valid chars, may be null
     * @return true if it only contains valid chars and is non-null
     * @since 2.0
     * @since 3.0 Changed signature from containsOnly(String, String) to containsOnly(CharSequence, String)
     */
    public static boolean containsOnlyChars(CharSequence sequence, CharSequence validChars) {
        if (sequence == null || validChars == null) {
            return false;
        }
        return containsOnlyChars(sequence, toCharArray(validChars));
    }

    /**
     * Converts the given CharSequence to a char[].
     *
     * @param sequence the {@link CharSequence} to be processed.
     * @return the resulting char array, never null.
     */
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

    /**
     * {@link StringAide} instances should NOT be constructed in
     * standard programming. Instead, the class should be used as
     * {@code StringAide.trim(" foo ");}.
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public StringAide() {

    }
}
