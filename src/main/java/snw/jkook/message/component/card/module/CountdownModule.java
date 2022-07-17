/*
 * Copyright 2022 JKook contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snw.jkook.message.component.card.module;

/**
 * Represents a countdown module.
 */
public class CountdownModule extends BaseModule {
    private final Type type;
    private final long startTime;
    private final long endTime;

    public CountdownModule(Type type, long startTime, long endTime) {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Return the type of this module.
     */
    public Type getType() {
        return type;
    }

    /**
     * Get the origin time of this countdown.
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Get the end time of this countdown.
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Represents the type of countdown.
     */
    public enum Type {

        DAY("day"),

        HOUR("hour"),

        SECOND("second");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
