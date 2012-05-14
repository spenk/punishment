public class PunishmentListener extends PluginListener {
	
public boolean onCommand(Player player,String[] split){
	if ((split[0].equalsIgnoreCase("/punish"))&&(player.canUseCommand("/punish"))){
		if ((split.length < 3)||(split.length >3)){
			player.sendMessage("§cThe correct usage is '/punish <player> <kind>'");
			return true;
		}else{
			if (split[2].equalsIgnoreCase("burn")){
				Player player2 = etc.getServer().matchPlayer(split[1]);
				if (player2 == null){
					player.sendMessage("§cThis player is currently not online.");
					return true;
				}else{
					player2.setCreativeMode(0);
					player2.setFireTicks(1000);
					player.sendMessage("§4"+player2.getName()+"§b has been punished.");
					etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
					return true;
				}
				
			}else
				if (split[2].equalsIgnoreCase("strike")){
					Player player2 = etc.getServer().matchPlayer(split[1]);
					if (player2 == null){
						player.sendMessage("§cThis player is currently not online.");
						return true;
					}else{
				    player2.setCreativeMode(0);
					OWorldServer oworld = player2.getWorld().getWorld();
					oworld.a(new OEntityLightningBolt(oworld, player2.getX(), player2.getY(), player2.getZ()));
					player2.setFireTicks(1000);
					player.sendMessage("§4"+player2.getName()+"§b has been punished.");
					etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
					return true;
				}
				}else
					if (split[2].equalsIgnoreCase("fall")){
						Player player2 = etc.getServer().matchPlayer(split[1]);
						if (player2 == null){
							player.sendMessage("§cThis player is currently not online.");
							return true;
						}else{
							player2.setCreativeMode(0);
							player2.setY(200);
							player.sendMessage("§4"+player2.getName()+"§b has been punished.");
							etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
								return true;
							}
					}else
						if (split[2].equalsIgnoreCase("heaven")){
							Player player2 = etc.getServer().matchPlayer(split[1]);
							if (player2 == null){
								player.sendMessage("§cThis player is currently not online.");
								return true;
							}else{
								player2.setCreativeMode(0);
								player2.setY(player.getY()+99999);
								player.sendMessage("§4"+player2.getName()+"§b has been punished.");
								etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
									return true;
						}
						
					}else
						if (split[2].equalsIgnoreCase("void")){
							Player player2 = etc.getServer().matchPlayer(split[1]);
							if (player2 == null){
								player.sendMessage("§cThis player is currently not online.");
								return true;
							}else{
								player2.setCreativeMode(0);
								player2.setY(-2);
								player.sendMessage("§4"+player2.getName()+"§b has been punished.");
								etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
									return true;
					}
					}else
						if (split[2].equalsIgnoreCase("explode")){
							Player player2 = etc.getServer().matchPlayer(split[1]);
							if (player2 == null){
								player.sendMessage("§cThis player is currently not online.");
								return true;
							}else{
								player2.setCreativeMode(0);
								World world = player2.getWorld();
								world.explode(player2, player2.getX()+1, player2.getY()+1, player2.getZ()+1, 5);
					            for (Item item : player2.getInventory().getContents()) {
					                if (item != null) {
					                  player2.getWorld().dropItem(player2.getLocation(), item.getItemId(), item.getAmount(), item.getDamage());
					                }
					              }
								player2.setHealth(0);
								player.sendMessage("§4"+player2.getName()+"§b has been punished.");
								etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
								etc.getServer().messageAll(player2.getName()+" Died by an explosion.");
									return true;
					}
						}else
							if (split[2].equalsIgnoreCase("hount")){
									Player player2 = etc.getServer().matchPlayer(split[1]);
									if (player2 == null){
										player.sendMessage("§cThis player is currently not online.");
										return true;
									}else{
										player2.setCreativeMode(0);
									    Mob wolfhostile = new Mob("Wolf", new Location(player2.getX(), player2.getY()+1, player2.getZ()+2));
									    ((OEntityWolf)wolfhostile.getEntity()).g() (16, (byte)2);
									    wolfhostile.spawn();
									    player.sendMessage("§4"+player2.getName()+"§b has been punished.");
										etc.getServer().messageAll("§4"+player2.getName()+"§b has been punished by §6"+player.getName());
										return true;
									}
		}
			}
	}else
		if ((split[0].equals("/listpunish"))&&(player.canUseCommand("/listpunish"))){
			player.sendMessage("§9-----§4punnishments§9-----");
			player.sendMessage("§21. burn");
			player.sendMessage("§22. strike");
			player.sendMessage("§23. fall");
			player.sendMessage("§24. heaven");
			player.sendMessage("§25. void");
			player.sendMessage("§26. explode");
			player.sendMessage("§27. hount");
			player.sendMessage("§9--------------------------");
			return true;
		}
	return false;
}	
}