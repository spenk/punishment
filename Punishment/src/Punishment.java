import java.util.logging.Logger;

public class Punishment extends Plugin
{
	  String name = "Punishment";
	  String version = "1.0";
	  String author = " spenk";
	  static Logger log = Logger.getLogger("Minecraft");
	  
	  
public void initialize(){
	PunishmentListener listener = new PunishmentListener();
log.info(this.name +" version "+ this.version + " by " +this.author+(" is initialized!"));
etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
}
public void enable(){
	etc.getInstance().addCommand("/punish", "<player> <punishment> see /listpunish");
	etc.getInstance().addCommand("/listpunish", "to see all punishments");
	log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
}

public void disable(){
	etc.getInstance().removeCommand("/punish");
	etc.getInstance().removeCommand("/listpunish");
	log.info(this.name + " version " + this.version + " is disabled!");
}
}