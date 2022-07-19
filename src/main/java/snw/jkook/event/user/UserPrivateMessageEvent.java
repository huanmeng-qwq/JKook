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

package snw.jkook.event.user;

import snw.jkook.entity.User;
import snw.jkook.event.HandlerList;
import snw.jkook.message.PrivateMessage;

/**
 * Represents the event that related to a user sent a private message to your Bot.
 */
public class UserPrivateMessageEvent extends UserEvent {
    private static final HandlerList handlers = new HandlerList();

    private final PrivateMessage pm;
    
    public UserPrivateMessageEvent(long timeStamp, User user, PrivateMessage pm) {
        super(timeStamp, user);
        this.pm = pm;
    }

    /**
     * Get the message object.
     */
    public PrivateMessage getMessage() {
        return pm;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
