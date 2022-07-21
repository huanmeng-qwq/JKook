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

package snw.jkook.event.channel;

import snw.jkook.entity.channel.Channel;
import snw.jkook.event.HandlerList;
import snw.jkook.message.TextChannelMessage;

import java.util.Objects;

/**
 * Represents an event related to a user modified a message.
 */
public class ChannelMessageUpdateEvent extends ChannelEvent {
    private static final HandlerList handlers = new HandlerList();

    private final TextChannelMessage message;

    public ChannelMessageUpdateEvent(final long timeStamp, final Channel channel, final TextChannelMessage message) {
        super(timeStamp, channel);
        this.message = Objects.requireNonNull(message);
    }

    /**
     * Get the message related to this event.
     */
    public TextChannelMessage getMessage() {
        return message;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
