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

import batman.aide.consts.ObjectConst;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 操作 {@link Object} 的工具方法。
 *
 * @author Kenown
 * @since 1.0.0
 */
public class ObjectAide implements ObjectConst {

    /**
     * 判断给定对象是否是一个数组（对象数组或原始数组）。
     *
     * <p>{@code null} Object 将返回 {@code false}。</p>
     *
     * @param object 要检查的对象，可以为 {@code null}
     * @return 如果对象是数组则为 {@code true}，否则为 {@code false}。
     */
    public static boolean isArray(final Object object) {
        return object != null && object.getClass().isArray();
    }

    /**
     * 判断给定对象是否为空（{@code null} 或 {@code empty}）。
     * 支持以下类型：
     * <ul>
     * <li>{@link CharSequence}：取 {@link CharSequence#isEmpty()}。</li>
     * <li>{@link Array}：如果长度为 0，则视为空。</li>
     * <li>{@link Collection}：取 {@link Collection#isEmpty()}。</li>
     * <li>{@link Map}：取 {@link Map#isEmpty()}。</li>
     * <li>{@link Optional}：取 {@link Optional#isEmpty()}。</li>
     * </ul>
     *
     * <pre>
     * ObjectAide.isEmpty(null)             = true
     * ObjectAide.isEmpty("")               = true
     * ObjectAide.isEmpty("ab")             = false
     * ObjectAide.isEmpty(new int[]{})      = true
     * ObjectAide.isEmpty(new int[]{1,2,3}) = false
     * ObjectAide.isEmpty(1234)             = false
     * ObjectAide.isEmpty(1234)             = false
     * ObjectAide.isEmpty(Optional.of(""))  = false
     * ObjectAide.isEmpty(Optional.empty()) = true
     * </pre>
     *
     * @param object 要检查的 {@link Object}，可以为 {@code null}
     * @return 如果对象具有受支持的类型并且为 {@code null} 或 {@code empty}，则为 {@code true}，否则为 {@code false}。
     */
    public static boolean isEmpty(final Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof CharSequence cs) {
            return cs.isEmpty();
        }
        if (isArray(object)) {
            return Array.getLength(object) == 0;
        }
        if (object instanceof Collection<?> coll) {
            return coll.isEmpty();
        }
        if (object instanceof Map<?,?> map) {
            return map.isEmpty();
        }
        if (object instanceof Optional<?> opt) {
            return opt.isEmpty();
        }
        return false;
    }

    /**
     * 检查给定对象是否不为空（{@code non-null} 且 {@code non-empty}）
     * 支持以下类型：
     * <ul>
     * <li>{@link CharSequence}：取 {@link CharSequence#isEmpty()}。</li>
     * <li>{@link Array}：如果长度为 0，则视为空。</li>
     * <li>{@link Collection}：取 {@link Collection#isEmpty()}。</li>
     * <li>{@link Map}：取 {@link Map#isEmpty()}。</li>
     * <li>{@link Optional}：取 {@link Optional#isEmpty()}。</li>
     * </ul>
     *
     * <pre>
     * ObjectAide.isNotEmpty(null)             = false
     * ObjectAide.isNotEmpty("")               = false
     * ObjectAide.isNotEmpty("ab")             = true
     * ObjectAide.isNotEmpty(new int[]{})      = false
     * ObjectAide.isNotEmpty(new int[]{1,2,3}) = true
     * ObjectAide.isNotEmpty(1234)             = true
     * ObjectAide.isNotEmpty(Optional.of(""))  = true
     * ObjectAide.isNotEmpty(Optional.empty()) = false
     * </pre>
     *
     * @param object 要检查的 {@link Object}，可以为 {@code null}
     * @return 如果对象类型不受支持，或者 {@code non-null} 且 {@code non-empty}，则为 {@code true}，否则为 {@code false}
     */
    public static boolean isNotEmpty(final Object object) {
        return !isEmpty(object);
    }

    public static String toString(final Object object, final Supplier<String> supplier) {
        return object != null
                ? object.toString()
                : supplier != null ? supplier.get() : null;
    }

    public static String toString(final Supplier<Object> object, final Supplier<String> supplier) {
        return object != null
                ? toString(object.get(), supplier)
                : supplier != null ? supplier.get() : null;
    }

    /**
     * 检查数组中的所有元素是否都不是 {@code null}。
     *
     * <p>如果数组为 {@code null} 或者其中的任何元素为 {@code null}，则返回 {@code false}。
     * 如果数组为 {@code empty}（不含任何元素）或其中的所有元素都不为 {@code null}，则返回 {@code true}。</p>
     *
     * <pre>
     * ObjectAide.allNonnull(*)             = true
     * ObjectAide.allNonnull(*, *)          = true
     * ObjectAide.allNonnull(null)          = false
     * ObjectAide.allNonnull(null, null)    = false
     * ObjectAide.allNonnull(null, *)       = false
     * ObjectAide.allNonnull(*, null)       = false
     * ObjectAide.allNonnull(*, *, null, *) = false
     * </pre>
     *
     * @param values 要检查的值，可以为 {@code null} 或 {@code empty}
     * @return 如果数组为 {@code null} 或其中至少有一个 {@code null} 元素，则为 {@code false}；
     * 如果数组不包含任何元素或者其中所有元素都不为 {@code null}，则为 {@code true}。
     */
    public static boolean allNonnull(final Object... values) {
        return values != null && Stream.of(values).noneMatch(Objects::isNull);
    }

    /**
     * 检查数组中的所有元素是否都是 {@code null}。
     *
     * <p>如果数组为 {@code null} 或 {@code empty} 或者其中所有元素都为 {@code null}，则返回 {@code true}，
     * 否则返回 {@code false}。</p>
     *
     * <pre>
     * ObjectAide.allNull(*)                = false
     * ObjectAide.allNull(*, null)          = false
     * ObjectAide.allNull(null, *)          = false
     * ObjectAide.allNull(null, null, *, *) = false
     * ObjectAide.allNull(null)             = true
     * ObjectAide.allNull(null, null)       = true
     * </pre>
     *
     * @param values 要检查的值，可以为 {@code null} 或 {@code empty}
     * @return 如果数组中的元素均为 {@code null}，则为 {@code true}，
     * 如果数组中至少有一个不是 {@code null} 的元素，则为 {@code false}。
     */
    public static boolean allNull(final Object... values) {
        return !anyNonnull(values);
    }

    /**
     * 检查数组中是否存在任何不是 {@code null} 的元素。
     *
     * <p>如果数组为 {@code null} 或 {@code empty} 或者其中所有元素都是 {@code null}，则返回 {@code false}，否则返回 {@code true}。</p>
     *
     * <pre>
     * ObjectAide.anyNonnull(*)                = true
     * ObjectAide.anyNonnull(*, null)          = true
     * ObjectAide.anyNonnull(null, *)          = true
     * ObjectAide.anyNonnull(null, null, *, *) = true
     * ObjectAide.anyNonnull(null)             = false
     * ObjectAide.anyNonnull(null, null)       = false
     * </pre>
     *
     * @param values 要检查的值，可以为 {@code null} 或 {@code empty}
     * @return 如果数组中至少有一个不是 {@code null} 的元素，则为 {@code true}；
     * 如果数组中的所有元素均为 {@code null}，则为 {@code false}；
     * 如果数组为 {@code null} 或 {@code empty}，则为 {@code false}。
     */
    public static boolean anyNonnull(final Object... values) {
        return firstNonnull(values) != null;
    }

    /**
     * 检查数组中是否存在任何是 {@code null} 的元素。
     *
     * <p>如果数组为 {@code null} 或其中任何元素为 {@code null}，则返回 {@code true}，否则返回 {@code false}。</p>
     *
     * <pre>
     * ObjectAide.anyNull(*)             = false
     * ObjectAide.anyNull(*, *)          = false
     * ObjectAide.anyNull(null)          = true
     * ObjectAide.anyNull(null, null)    = true
     * ObjectAide.anyNull(null, *)       = true
     * ObjectAide.anyNull(*, null)       = true
     * ObjectAide.anyNull(*, *, null, *) = true
     * </pre>
     *
     * @param values 要检查的值，可以为 {@code null} 或 {@code empty}
     * @return 如果数组中至少有一个 {@code null} 元素，则为 {@code true}；
     * 如果所有元素都不为 {@code null}，则为 {@code false}；
     * 如果数组为 {@code null} 或 {@code empty}，则为 {@code true}。
     */
    public static boolean anyNull(final Object... values) {
        return !allNonnull(values);
    }

    /**
     * 返回数组中第一个不是 {@code null} 的值。
     * 如果数组为 {@code null} 或其中所有值均为 {@code null}，则返回 {@code null}。
     *
     * <pre>
     * ObjectAide.firstNonNull(null, null)      = null
     * ObjectAide.firstNonNull(null, "")        = ""
     * ObjectAide.firstNonNull(null, null, "")  = ""
     * ObjectAide.firstNonNull(null, "zz")      = "zz"
     * ObjectAide.firstNonNull("abc", *)        = "abc"
     * ObjectAide.firstNonNull(null, "xyz", *)  = "xyz"
     * ObjectAide.firstNonNull(Boolean.TRUE, *) = Boolean.TRUE
     * ObjectAide.firstNonNull()                = null
     * </pre>
     *
     * @param values 要检查的值，可以为 {@code null} 或 {@code empty}
     * @param <T> 数组元素的类型
     * @return 数组中第一个不是 {@code null} 的值，如果没有 {@code non-null} 值，则为 null。
     */
    @SafeVarargs
    public static <T> T firstNonnull(final T... values) {
        return values != null
                ? Stream.of(values).filter(Objects::nonNull).findFirst().orElse(null)
                : null;
    }

    /**
     * 按顺序执行给定的提供器 {@link Supplier}，并返回第一个不是 {@code null} 的返回值。
     * 一旦获得 {@code non-null} 值，所有后续 Supplier 将不再执行。
     * 如果未提供任何 Supplier 或者所有返回值均为 {@code null}，则返回 {@code null}。
     *
     * <pre>
     * ObjectAide.firstNonNullLazy(null, () -&gt; null) = null
     * ObjectAide.firstNonNullLazy(() -&gt; null, () -&gt; "") = ""
     * ObjectAide.firstNonNullLazy(() -&gt; "", () -&gt; throw new IllegalStateException()) = ""
     * ObjectAide.firstNonNullLazy(() -&gt; null, () -&gt; "zz) = "zz"
     * ObjectAide.firstNonNullLazy() = null
     * </pre>
     *
     * @param suppliers 提供返回值的 {@link Supplier}。
     *                  {@code null} 值将被忽略。
     *                  Supplier 可以返回 {@code null} 或 {@code T} 类型的值
     * @param <T> 返回值的类型
     * @return 第一个不是 {@code null} 的 Supplier 返回值，如果没有 {@code non-null} 返回值则返回 {@code null}。
     */
    @SafeVarargs
    public static <T> T firstNonnull(final Supplier<T>... suppliers) {
        return suppliers != null
                ? Stream.of(suppliers).map(s -> s != null ? s.get() : null).filter(Objects::nonNull).findFirst().orElse(null)
                : null;
    }

    /**
     * 如果给定的对象不是 {@code null} 则将其返回，否则返回提供的默认值。
     *
     * <pre>
     * ObjectAide.defaultIfNull(null, null)      = null
     * ObjectAide.defaultIfNull(null, "")        = ""
     * ObjectAide.defaultIfNull(null, "zz")      = "zz"
     * ObjectAide.defaultIfNull("abc", *)        = "abc"
     * ObjectAide.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
     * </pre>
     *
     * @param value 给定的对象，可以为 {@code null}
     * @param defaultValue 当给定对象为 {@code null} 时要返回的默认值，可以为 {@code null}
     * @param <T> 对象的类型
     * @return 如果 value 不为 {@code null}，则为 value，否则为 defaultValue。
     */
    public static <T> T defaultIfNull(final T value, final T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * 如果给定的 value 不是 {@code null}，则返回该 value，否则返回默认值提供器 {@link Supplier#get()} 的值。
     *
     * <p>调用者负责默认值提供器的线程安全和异常处理。</p>
     *
     * <pre>
     * ObjectAide.defaultIfNull(null, () -&gt; null)     = null
     * ObjectAide.defaultIfNull(null, null)              = null
     * ObjectAide.defaultIfNull(null, () -&gt; "")       = ""
     * ObjectAide.defaultIfNull(null, () -&gt; "zz")     = "zz"
     * ObjectAide.defaultIfNull("abc", *)                = "abc"
     * ObjectAide.defaultIfNull(Boolean.TRUE, *)         = Boolean.TRUE
     * </pre>
     *
     * @param value 给定的对象，可以为 {@code null}
     * @param defaultSupplier 当给定对象为 {@code null} 时要返回的默认值提供器，可以Wie {@code null}
     * @param <T> 对象的类型
     * @return 如果 value 不为 {@code null}，则为 value，否则为 {@code defaultSupplier.get()}。
     */
    public static <T> T defaultIfNull(final T value, final Supplier<T> defaultSupplier) {
        return value != null
                ? value
                : defaultSupplier != null ? defaultSupplier.get() : null;
    }

    /**
     * 公共构造函数，以便一些需要 JavaBean 实例才能运行的工具使用。
     *
     * <p>在标准编程中不应构造 {@link ObjectAide} 实例，而应该直接使用类的静态方法，
     * 例如 {@code ObjectAide#isAllNonnull(Object...)}</p>
     */
    public ObjectAide() {
    }

}
