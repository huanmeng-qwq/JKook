/*
 * Copyright 2022 - 2023 JKook contributors
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

package snw.jkook.event.role;

import snw.jkook.entity.Role;
import snw.jkook.event.HandlerList;

/**
 * Represents an event that means a role was created.
 */
public class RoleCreateEvent extends RoleEvent {
    private static final HandlerList handlers = new HandlerList();

    public RoleCreateEvent(final long timeStamp, final Role role) {
        super(timeStamp, role);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
