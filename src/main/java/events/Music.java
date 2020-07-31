package events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class Music extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if(!event.getMessage().getContentRaw().startsWith("!play")) return;

        if(event.getAuthor().isBot()) return;
        Guild guild = event.getGuild();

        VoiceChannel channel = guild.getVoiceChannelsByName("music", true).get(0);
        AudioManager manager = guild.getAudioManager();

        manager.setSendingHandler(new MySendHandler());

        manager.openAudioConnection(channel);

    }

}
