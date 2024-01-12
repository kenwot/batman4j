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
import batman.aide.consts.CharConst;
import batman.aide.consts.ObjectConst;
import batman.aide.consts.StringConst;

/**
 * 常量工具类
 *
 * @author Kenown
 * @since 1.0.0
 */
public class ConstantAide implements ObjectConst, StringConst, CharConst, ArrayConst {

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static boolean MAGIC_FLAG = ObjectAide.CONST(true);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code boolean} 值
     * @return {@code boolean} 值 value， 不变
     */
    public static boolean CONST(final boolean value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static char MAGIC_CHAR = ObjectAide.CONST('a');
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code char} 值
     * @return {@code char} 值 value， 不变
     */
    public static char CONST(final char value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static byte MAGIC_BYTE = ObjectAide.CONST((byte) 127);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code byte} 值
     * @return {@code byte} 值 value， 不变
     */
    public static byte CONST(final byte value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static short MAGIC_SHORT = ObjectAide.CONST((short) 123);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code short} 值
     * @return {@code short} 值 value， 不变
     */
    public static short CONST(final short value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static int MAGIC_INT = ObjectAide.CONST(123);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code int} 值
     * @return {@code int} 值 value， 不变
     */
    public static int CONST(final int value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static int MAGIC_INT = ObjectAide.CONST(123);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code long} 值
     * @return {@code long} 值 value， 不变
     */
    public static long CONST(final long value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static float MAGIC_FLOAT = ObjectAide.CONST(1.0f);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code float} 值
     * @return {@code float} 值 value， 不变
     */
    public static float CONST(final float value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static double MAGIC_DOUBLE = ObjectAide.CONST(1.0);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code double} 值
     * @return {@code double} 值 value， 不变
     */
    public static double CONST(final double value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static String MAGIC_STRING = ObjectAide.CONST("abc");
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的泛型对象值（通常是字符串）
     * @param <T> 对象类型
     * @return 泛型对象值 value，不变（通常是字符串）
     */
    public static <T> T CONST(final T value) {
        return value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static byte MAGIC_BYTE = ObjectAide.CONST_BYTE(127);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code byte} 值（以 {@code int} 提供）
     * @throws IllegalArgumentException 如果提供的 value 值超出 {@code byte} 范围，即小于 -128 或大于 127。
     * @return {@code byte} 值，不变
     */
    public static byte CONST_BYTE(final int value) {
        if (value < Byte.MAX_VALUE || value > Byte.MAX_VALUE) {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + value + "]");
        }
        return (byte) value;
    }

    /**
     * 将提供的值原封不动地返回。这可以防止 javac 内联常量字段。
     * 例如，
     *
     * <pre>
     *     public final static short MAGIC_SHORT = ObjectAide.CONST_SHORT(127);
     * </pre>
     *
     * 这样，如果该字段的值在未来某个时期发生变化，任何引用该字段的 jar 都不必重新编译自己。
     *
     * @param value 要返回的 {@code short} 值（以 {@code int} 提供）
     * @throws IllegalArgumentException 如果提供的 value 值超出 {@code short} 范围，即小于 -32768 或大于 32768。
     * @return {@code short} 值，不变
     */
    public static short CONST_SHORT(final int value) {
        if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + value + "]");
        }
        return (short) value;
    }

    /**
     * 公共构造函数，以便一些需要 JavaBean 实例才能运行的工具使用。
     *
     * <p>在标准编程中不应构造 {@link ConstantAide} 实例，而应该直接使用类的静态方法，
     * 例如 {@code ConstantAide#NULL}</p>
     */
    public ConstantAide() {
    }
}
