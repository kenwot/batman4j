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

package batman.aide.consts;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Defines some Object constants.
 *
 * @author Kenown
 * @since 1.0.0
 */
public interface ObjectConst {

    /**
     * Class used as a null placeholder where {@code null} has another meaning.
     *
     * <p>For example, in a {@link HashMap} the {@link java.util.HashMap#get(Object)} method
     * returns {@code null} if the {@link Map} contains {@code null} or if there is no matching key.
     * The {@code null} placeholder can be used to distinguish
     * between these two cases.
     *
     * <p>Another example is {@link Hashtable}, where {@code null} cannot be stored.
     */
    class Null implements Serializable {
        @Serial
        private static final long serialVersionUID = -92339585884550507L;

        private static final Null INSTANCE = new Null();

        /**
         * Restricted constructor - singleton.
         */
        private Null() {
        }

        /**
         * Ensure Singleton after serialization.
         *
         * @return the singleton value.
         */
        @Serial
        private Object readResolve() {
            return INSTANCE;
        }
    }

    /**
     * Singleton used as a {@code null} placeholder where {@code null} has another meaning.
     *
     * <p>For example, in a {@link HashMap} the {@link java.util.HashMap#get(Object)} method
     * returns {@code null} if the {@link Map} contains {@code null} or if there is no matching key.
     * The {@code null} placeholder can be used to distinguish between these two cases.
     *
     * <p>Another example is {@link Hashtable}, where {@code null} cannot be stored.
     *
     * <p>This instance is Serializable.
     */
    Null NULL = Null.INSTANCE;

}
