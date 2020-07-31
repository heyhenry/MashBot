package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String messageSent = event.getMessage().getContentRaw();
        String name = event.getMember().getUser().getName();

        if (messageSent.equalsIgnoreCase("!Hello")) {

            if (!event.getMember().getUser().isBot()) {

                event.getChannel().sendMessage("Hello " + name).queue();

            }

        }

    }

}
