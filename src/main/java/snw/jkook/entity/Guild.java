package snw.jkook.entity;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import snw.jkook.Permission;
import snw.jkook.entity.abilities.AvatarHolder;
import snw.jkook.entity.abilities.InviteHolder;
import snw.jkook.entity.abilities.MasterHolder;
import snw.jkook.entity.abilities.Nameable;
import snw.jkook.entity.channel.Category;
import snw.jkook.entity.channel.Channel;
import snw.jkook.entity.channel.TextChannel;
import snw.jkook.entity.channel.VoiceChannel;
import snw.jkook.entity.mute.MuteResult;
import snw.jkook.util.RequirePermission;

import java.util.Collection;

/**
 * Represents a Guild.
 */
public interface Guild extends Nameable, AvatarHolder, MasterHolder, InviteHolder {

    /**
     * Set the name of this guild.
     * @param name The new name
     */
    @RequirePermission(Permission.OPERATOR)
    void setName(String name);

    /**
     * Get the ID of this guild.
     */
    String getId();

    /**
     * Get the users in this guild.
     */
    Collection<User> getUsers();

    /**
     * Get the online users in this guild.
     */
    Collection<User> getOnlineUsers();

    /**
     * Get all the channels in this guild.
     */
    Collection<Channel> getChannels();

    /**
     * Get the voice server region of this guild.
     */
    String getVoiceChannelServerRegion();

    /**
     * Get the custom emojis in this guild.
     */
    Collection<CustomEmoji> getCustomEmojis();

    /**
     * Get the online user count.
     */
    int getOnlineUserCount();

    /**
     * Get the total user count.
     */
    int getUserCount();

    /**
     * Return true if this guild is public.
     */
    boolean isPublic();

    /**
     * Get the mute status of this guild.
     */
    MuteResult getMuteStatus();

    /**
     * Leave this guild. This <b>CANNOT</b> be undone!
     */
    void leave();

    /**
     * Ban the user from this guild.
     *
     * @param user           The user to be banned
     * @param reason         The reason
     * @param delMessageDays The value passed in determines how many days the message sent by this user is deleted
     */
    @RequirePermission(Permission.BAN)
    void ban(User user, @Nullable String reason, int delMessageDays);

    /**
     * Unban the user from this guild.
     *
     * @param user The user to be unbanned
     */
    @RequirePermission(Permission.BAN)
    void unban(User user);

    /**
     * Kick the user from this guild. This <b>CANNOT</b> be undone!
     *
     * @param user The user to be kicked
     */
    @RequirePermission(Permission.KICK)
    void kick(User user);

    /**
     * Create a text channel in this guild with given information.
     *
     * @param name The name of the new channel
     * @param parent The parent category of the new channel
     * @return The new channel representation
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    TextChannel createTextChannel(String name, @Nullable Category parent);

    /**
     * Create a voice channel in this guild with given information.
     *
     * @param name The name of the new channel
     * @param parent The parent category of the new channel
     * @param size The max size of the new channel, determine the number of users this channel can hold
     * @param quality Voice quality. 1 smooth, 2 normal, 3 high quality
     * @return The new channel representation
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    VoiceChannel createVoiceChannel(
            String name,
            @Nullable Category parent,
            @Range(from = 1, to = 99) int size,
            @Range(from = 1, to = 3) int quality
    );

    /**
     * Create a category in this guild with given information.
     *
     * @param name The name of the new category
     * @return The new category representation
     */
    @RequirePermission(Permission.CHANNEL_MANAGE)
    Category createCategory(String name);

    /**
     * Create an role with given information.
     *
     * @param name The name of new role
     * @return The new role representation
     */
    @RequirePermission(Permission.ROLE_MANAGE)
    Role createRole(String name);

    /**
     * Upload an emoji to this guild.
     *
     * @param binary The binary value of the emoji. Allows PNG only. The size can not exceed 256 KB.
     * @param name The name of the new emoji. If empty, it will be a random string
     * @return The new emoji representation
     */
    @RequirePermission(Permission.EMOJI_MANAGE)
    CustomEmoji uploadEmoji(String binary, @Nullable String name);

    /**
     * Get the users banned by this guild.
     */
    Collection<User> getBannedUsers();

    /**
     * Get notify type of this guild.
     */
    NotifyType getNotifyType();

    /**
     * Represents notify type.
     */
    enum NotifyType {

        /**
         * Use the settings defined by the guild.
         */
        DEFAULT(0),

        /**
         * Always notify.
         */
        ALL(1),

        /**
         * Notify on be mentioned only.
         */
        MENTION_ONLY(2),

        /**
         * Never notify.
         */
        NO_NOTIFY(3);

        private final int value;

        NotifyType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
