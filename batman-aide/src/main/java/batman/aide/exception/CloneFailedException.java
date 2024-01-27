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
 * Exception thrown when a clone cannot be created. In contrast to
 * {@link CloneNotSupportedException} this is a {@link RuntimeException}.
 *
 * @author Kenown
 * @since 1.0.0
 */
public class CloneFailedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8890776807148591266L;

    /**
     * Constructs a CloneFailedException.
     *
     * @param message description of the exception.
     */
    public CloneFailedException(String message) {
        super(message);
    }

    /**
     * Constructs a CloneFailedException.
     *
     * @param message description of the exception.
     * @param cause cause of the exception.
     */
    public CloneFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a CloneFailedException.
     *
     * @param cause cause of the exception.
     */
    public CloneFailedException(Throwable cause) {
        super(cause);
    }

}
