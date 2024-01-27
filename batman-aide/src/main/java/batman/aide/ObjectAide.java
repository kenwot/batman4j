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
import batman.aide.consts.StringConst;
import batman.aide.exception.CloneFailedException;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Operations on {@link Object}.
 *
 * @author Kenown
 * @since 1.0.0
 */
public class ObjectAide implements ObjectConst {

    /**
     * Tests whether the given object is an Object array or a primitive array in a null-safe manner.
     *
     * <p>A {@code null} {@code object} Object will return {@code false}.
     *
     * @param object the object to check, may be {@code null}.
     * @return {@code true} if the object is an {@code array}, {@code false} otherwise.
     */
    public static boolean isArray(Object object) {
        return object != null && object.getClass().isArray();
    }

    /**
     * Tests if an Object is empty or null.
     * The following types are supported:
     * <ul>
     * <li>{@link CharSequence}: Considered empty if its length is zero.</li>
     * <li>{@link Array}: Considered empty if its length is zero.</li>
     * <li>{@link Collection}: Considered empty if it has zero elements.</li>
     * <li>{@link Map}: Considered empty if it has zero key-value mappings.</li>
     * <li>{@link Optional}: Considered empty if {@link Optional#isPresent} returns false, regardless of the "emptiness" of the contents.</li>
     * </ul>
     *
     * @param object the {@link Object} to test, may be {@code null}.
     * @return {@code true} if the object has a supported type and is empty or null, {@code false} otherwise.
     */
    public static boolean isEmpty(Object object) {
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
        if (object instanceof Map<?, ?> map) {
            return map.isEmpty();
        }
        if (object instanceof Optional<?> opt) {
            return opt.isEmpty();
        }
        return false;
    }

    /**
     * Tests if an Object is not empty and not null.
     * The following types are supported:
     * <ul>
     * <li>{@link CharSequence}: Considered empty if its length is zero.</li>
     * <li>{@link Array}: Considered empty if its length is zero.</li>
     * <li>{@link Collection}: Considered empty if it has zero elements.</li>
     * <li>{@link Map}: Considered empty if it has zero key-value mappings.</li>
     * <li>{@link Optional}: Considered empty if {@link Optional#isPresent} returns false, regardless of the "emptiness" of the contents.</li>
     * </ul>
     *
     * @param object the {@link Object} to test, may be {@code null}.
     * @return {@code true} if the object has an unsupported type or is not empty and not null, {@code false} otherwise.
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    /**
     * Checks if all values in the given array are {@code null}.
     *
     * <p>If all the values are {@code null} or the array is {@code null}
     * or empty, then {@code true} is returned, otherwise {@code false} is returned.
     *
     *
     * @param values the values to test, may be {@code null} or {@code empty}.
     * @return {@code true} if all values in the array are {@code null}s,
     *         {@code false} if there is at least one non-null value in the array.
     */
    public static boolean isAllNull(Object... values) {
        return !isAnyNonnull(values);
    }

    /**
     * Checks if all values in the array are not {@code nulls}.
     *
     * <p>If any value is {@code null} or the array is {@code null} then
     * {@code false} is returned. If all elements in array are not
     * {@code null} or the array is empty (contains no elements) {@code true}
     * is returned.
     *
     *
     * @param values the values to test, may be {@code null} or empty.
     * @return {@code false} if there is at least one {@code null} value in the array or the array is {@code null},
     *         {@code true} if all values in the array are not {@code null}s or array contains no elements.
     */
    public static boolean isAllNonnull(Object... values) {
        return values != null && Stream.of(values).noneMatch(Objects::isNull);
    }

    /**
     * Checks if any value in the given array is {@code null}.
     *
     * <p>If any of the values are {@code null} or the array is {@code null},
     * then {@code true} is returned, otherwise {@code false} is returned.
     *
     *
     * @param values the values to test, may be {@code null} or empty.
     * @return {@code true} if there is at least one {@code null} value in the array,
     *         {@code false} if all the values are non-null.
     *         If the array is {@code null} or empty, {@code true} is also returned.
     */
    public static boolean isAnyNull(Object... values) {
        return !isAllNonnull(values);
    }

    /**
     * Checks if any value in the given array is not {@code null}.
     *
     * <p>If all the values are {@code null} or the array is {@code null}
     * or empty then {@code false} is returned. Otherwise {@code true} is returned.
     *
     *
     * @param values the values to test, may be {@code null} or empty.
     * @return {@code true} if there is at least one non-null value in the array,
     *         {@code false} if all values in the array are {@code null}s.
     *         If the array is {@code null} or empty {@code false} is also returned.
     */
    public static boolean isAnyNonnull(Object... values) {
        return firstNonnull(values) != null;
    }

    /**
     * Returns the first value in the array which is not {@code null}.
     * If all the values are {@code null} or the array is {@code null}
     * or empty then {@code null} is returned.
     *
     * @param values the values to test, may be {@code null} or empty.
     * @param <T>    the component type of the array.
     * @return the first value from {@code values} which is not {@code null},
     *         or {@code null} if there are no non-null values.
     */
    @SafeVarargs
    public static <T> T firstNonnull(T... values) {
        return values != null
                ? Stream.of(values).filter(Objects::nonNull).findFirst().orElse(null)
                : null;
    }

    /**
     * Executes the given suppliers in order and returns the first return
     * value where a value other than {@code null} is returned.
     * Once a non-{@code null} value is obtained, all following suppliers are
     * not executed anymore.
     * If all the return values are {@code null} or no suppliers are provided
     * then {@code null} is returned.
     *
     * @param suppliers the suppliers returning the values to test.
     *                  {@code null} values are ignored.
     *                  Suppliers may return {@code null} or a value of type {@code T}.
     * @param <T>       the type of the return values.
     * @return the first return value from {@code suppliers} which is not {@code null},
     *         or {@code null} if there are no non-null values.
     */
    @SafeVarargs
    public static <T> T firstNonnull(Supplier<T>... suppliers) {
        return suppliers != null
                ? Stream.of(suppliers).map(s -> s != null ? s.get() : null).filter(Objects::nonNull).findFirst().orElse(null)
                : null;
    }

    /**
     * Returns a default value if the object passed is {@code null}.
     *
     * @param value        the {@link Object} to test, may be {@code null}.
     * @param defaultValue the default value to return, may be {@code null}.
     * @param <T>          the type of the object.
     * @return {@code object} if it is not {@code null}, defaultValue otherwise.
     */
    public static <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * Returns the given {@code object} is it is non-null, otherwise returns the Supplier's {@link Supplier#get()}
     * value.
     *
     * <p>The caller responsible for thread-safety and exception handling of default value supplier.
     *
     *
     * @param value           the {@link Object} to test, may be {@code null}.
     * @param defaultSupplier the default value to return, may be {@code null}.
     * @param <T>             the type of the object.
     * @return {@code object} if it is not {@code null}, {@code defaultValueSupplier.get()} otherwise.
     */
    public static <T> T defaultIfNull(T value, Supplier<T> defaultSupplier) {
        return value != null
                ? value
                : defaultSupplier != null ? defaultSupplier.get() : null;
    }

    /**
     * Returns the value Supplier's {@link Supplier#get()} value is it is non-null and its Supplier.get() is non-null,
     * otherwise returns the default Supplier's Supplier.get() value.
     *
     * <p>The caller responsible for thread-safety and exception handling of default value supplier.
     *
     * @param valueSupplier   the value Supplier to test, may be {@code null}.
     * @param defaultSupplier the default value to return, may be {@code null}.
     * @param <T>             the type of the object.
     * @return {@code valueSupplier.get()} value or {@code defaultSupplier.get()} value.
     */
    public static <T> T defaultIfNull(Supplier<T> valueSupplier, Supplier<T> defaultSupplier) {
        T value = valueSupplier != null ? valueSupplier.get() : null;
        return defaultIfNull(value, defaultSupplier);
    }

    /**
     * Gets the {@code toString} of an {@link Object} returning a specified text if {@code null} input.
     *
     * <pre>
     * ObjectAide.toString(obj, () -&gt; expensive())
     * </pre>
     *
     * @param object   the Object to {@code toString}, may be null.
     * @param supplier the Supplier of String used on {@code null} input, may be null.
     * @param <T>      the obj type.
     * @return the passed in Object's toString, or {@code nullStr} if {@code null} input.
     */
    public static <T> String toString(T object, Supplier<String> supplier) {
        return object != null
                ? object.toString()
                : supplier != null ? supplier.get() : null;
    }

    /**
     * Gets the {@code toString} of an {@link Supplier}'s {@link Supplier#get()} returning
     * a specified text if {@code null} input.
     *
     * <pre>
     * ObjectAide.toString(() -&gt; obj, () -&gt; expensive())
     * </pre>
     *
     * @param object   the Object to {@code toString}, may be null.
     * @param supplier the Supplier of String used on {@code null} input, may be null.
     * @return the passed in Object's toString, or {@code nullStr} if {@code null} input.
     */
    public static String toString(Supplier<Object> object, Supplier<String> supplier) {
        return object != null
                ? toString(object.get(), supplier)
                : supplier != null ? supplier.get() : null;
    }

    /**
     * Gets the toString that would be produced by {@link Object}
     * if a class did not override toString itself. {@code null}
     * will return {@code null}.
     *
     * <p>The method returns a string equivalent to:
     * <blockquote><pre>
     * object.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(object))
     * </pre></blockquote>
     *
     *
     * @param object the object to create a toString for, may be {@code null}.
     * @return the default toString text, or {@code null} if {@code null} passed in.
     */
    public static String toIdentityString(Object object) {
        if (object == null) {
            return null;
        }
        return object.getClass().getName() + StringConst.AT + Integer.toHexString(System.identityHashCode(object));
    }

    /**
     * Find the most frequently occurring item.
     *
     * @param items to check.
     * @param <T>   type of values processed by this method.
     * @return most populous T, {@code null} if non-unique or no items supplied.
     */
    @SafeVarargs
    public static <T> T mode(T... items) {
        if (ArrayAide.isNotEmpty(items)) {
            HashMap<T, Integer> occurrences = new HashMap<>(items.length);
            for (T item : items) {
                Integer count = occurrences.get(item);
                if (count == null) {
                    occurrences.put(item, 1);
                } else {
                    occurrences.put(item, ++count);
                }
            }
            T result = null;
            int max = 0;
            for (Map.Entry<T, Integer> entry : occurrences.entrySet()) {
                int count = entry.getValue();
                if (count == max) {
                    result = null;
                } else if (count > max) {
                    max = count;
                    result = entry.getKey();
                }
            }
            return result;
        }
        return null;
    }

    /**
     * Clone an object.
     *
     * <p>If the provided instance is {@code null} or is not cloneable, {@code null} is returned.
     *
     * @param object the object to clone, null returns null.
     * @param <T>    the type of the object.
     * @return the clone if the object implements {@link Cloneable} otherwise {@code null}.
     * @throws CloneFailedException if the object is cloneable and the clone operation fails.
     */
    public static <T> T clone(T object) {
        if (object instanceof Cloneable) {
            Object result;
            if (isArray(object)) {
                Class<?> componentType = object.getClass().getComponentType();
                if (componentType.isPrimitive()) {
                    int length = Array.getLength(object);
                    result = Array.newInstance(componentType, length);
                    while (length-- > 0) {
                        Array.set(result, length, Array.get(object, length));
                    }
                } else {
                    result = ((Object[]) object).clone();
                }
            } else {
                try {
                    Method clone = object.getClass().getMethod("clone");
                    result = clone.invoke(object);
                } catch (NoSuchMethodException ex) {
                    throw new CloneFailedException("Cloneable type " + object.getClass().getName() + " has no clone method", ex);
                } catch (IllegalAccessException ex) {
                    throw new CloneFailedException("Cannot clone Cloneable type " + object.getClass().getName(), ex);
                } catch (InvocationTargetException ex) {
                    throw new CloneFailedException("Exception cloning Cloneable type " + object.getClass().getName(), ex.getCause());
                }
            }
            @SuppressWarnings("unchecked")  // OK because input is of type T
            T checked = (T) result;
            return checked;
        }
        return null;
    }

    /**
     * Clone an object if possible.
     *
     * <p>This method is similar to {@link #clone(Object)}, but will return the provided
     * instance as the return value instead of {@code null} if the instance
     * is not cloneable. This is more convenient if the caller uses different
     * implementations (e.g. of a service) and some of the implementations do not allow concurrent
     * processing or have state. In such cases the implementation can simply provide a proper
     * clone implementation and the caller's code does not have to change.
     *
     * @param object the object to clone, null returns null.
     * @param <T>    the type of the object.
     * @return the clone if the object implements {@link Cloneable} otherwise the object itself.
     * @throws CloneFailedException if the object is cloneable and the clone operation fails.
     */
    public static <T> T cloneIfPossible(T object) {
        T clone = clone(object);
        return clone != null ? clone : object;
    }

    /**
     * Calls {@link Object#wait(long, int)} for the given Duration.
     *
     * @param object   The receiver of the wait call.
     * @param duration How long to wait.
     * @throws IllegalArgumentException     if the timeout duration is negative.
     * @throws IllegalMonitorStateException if the current thread is not the owner of the {@code obj}'s monitor.
     * @throws InterruptedException         if any thread interrupted the current thread before or while the current thread was
     *                                      waiting for a notification. The <em>interrupted status</em> of the current thread is cleared when this
     *                                      exception is thrown.
     * @see Object#wait(long, int)
     */
    public static void wait(Object object, Duration duration) throws InterruptedException {
        Duration timeout = defaultIfNull(duration, Duration.ZERO);
        long millis = timeout.toMillis();
        int nanos = timeout.getNano() % 1_000_000;
        object.wait(millis, nanos);
    }

    /**
     * {@link ObjectAide} instances should NOT be constructed in
     * standard programming. Instead, the static methods on the class should
     * be used, such as {@code ObjectAide.isAllNonnull("a", "b");}.
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.
     */
    public ObjectAide() {
    }

}
