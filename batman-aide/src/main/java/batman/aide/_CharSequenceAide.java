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
 * TODO-Kenown _CharSequenceAide
 *
 * @author Kenown
 * @since 1.0.0
 */
class _CharSequenceAide {

    static int indexOf(final CharSequence cs, final CharSequence search, final int start) {
        if (cs instanceof String string) {
            return string.indexOf(search.toString(), start);
        }
        if (cs instanceof StringBuilder builder) {
            return builder.indexOf(search.toString(), start);
        }
        if (cs instanceof StringBuffer buffer) {
            return buffer.indexOf(search.toString(), start);
        }
        return cs.toString().indexOf(search.toString(), start);
    }

}
