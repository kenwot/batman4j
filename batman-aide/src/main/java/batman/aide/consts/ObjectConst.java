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

/**
 * 对象常量
 *
 * @author Kenown
 * @since 1.0.0
 */
public interface ObjectConst {

    /**
     * 用作 {@code null} 占位符的类，用于当 {@code null} 有其他含义时。
     *
     * <p>例如，在 {@link java.util.HashMap} 中如果键对应的值是 {@code null}，
     * 或者没有匹配的键时，{@link java.util.HashMap#get(Object)} 都返回 {@code null}，
     * 使用该占位符可以区分这两种情况</p>
     *
     * <p>再如，{@link java.util.Hashtable} 中不能存储 {@code null}，也可以使用该占位符代替。</p>
     */
    class Null implements Serializable {
        @Serial
        private static final long serialVersionUID = -92339585884550507L;

        private static final Null INSTANCE = new Null();

        /**
         * 受限构造函数，用于单例
         */
        private Null() {
        }

        /**
         * 确保序列化后单例
         *
         * @return 单例实例
         */
        @Serial
        private Object readResolve() {
            return INSTANCE;
        }
    }

    /**
     * 一个用作 {@code null} 占位符的单例对象，用于当 {@code null} 有其他含义时。
     *
     * <p>例如，在 {@link java.util.HashMap} 中如果键对应的值是 {@code null}，
     * 或者没有匹配的键时，{@link java.util.HashMap#get(Object)} 都返回 {@code null}，
     * 使用该占位符可以区分这两种情况</p>
     *
     * <p>再如，{@link java.util.Hashtable} 中不能存储 {@code null}，也可以使用该占位符代替。</p>
     *
     * <p>该实例可序列化（Serializable）。</p>
     */
    Null NULL = Null.INSTANCE;

}
