package Commands.Action;

import Constants.BotConstants;
import Manager.EmbedManager;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class scold extends Command {
    static StringBuilder names = new StringBuilder();

    public scold() {
        this.name = "Scold";
        this.help = "Scolds";
    }
    @Override
    protected void execute(CommandEvent event) {
        String message;
        if(event.getMessage().getMentionedUsers().isEmpty()) {
            message = "*Scolds* <@" + event.getAuthor().getId() + "> ";
        } else {
            names.setLength(0);
            for(int gzs = 0; gzs < event.getMessage().getMentionedUsers().size(); ++gzs) {
                names.append("<@").append(event.getMessage().getMentionedUsers().get(gzs).getId()).append("> ");
            }
            message = "*Scolds*  " + names + " ";
        }
        EmbedManager.action(event.getTextChannel(), event.getAuthor(), BotConstants.scold, message);
    }
}
