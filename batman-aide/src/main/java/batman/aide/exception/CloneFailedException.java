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

package batman.aide.exception;

import java.io.Serial;

/**
 * 对象克隆失败时抛出的异常。相比 {@link CloneNotSupportedException} 这是一个 {@link RuntimeException}。
 *
 * @author Kenown
 * @since 1.0.0
 */
public class CloneFailedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8890776807148591266L;

    /**
     * 构造一个 {@link CloneFailedException}。
     *
     * @param message 异常描述
     */
    public CloneFailedException(String message) {
        super(message);
    }

    /**
     * 构造一个 {@link CloneFailedException}。
     *
     * @param message 异常描述
     * @param cause 异常原因
     */
    public CloneFailedException(String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造一个 {@link CloneFailedException}。
     *
     * @param cause 异常原因
     */
    public CloneFailedException(Throwable cause) {
        super(cause);
    }

}
