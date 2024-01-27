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
 * @author Kenown
 * @since 1.0.0
 */
public class TmpStringIndexAide {

    public static boolean isEmpty(CharSequence sequence) {
        return StringAide.isEmpty(sequence);
    }

    public static int length(CharSequence sequence) {
        return StringAide.length(sequence);
    }

    public static final int INDEX_NOT_FOUND = -1;



}
