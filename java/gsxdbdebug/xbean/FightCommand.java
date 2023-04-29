package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FightCommand
  extends Bean
{
  public abstract FightCommand copy();
  
  public abstract FightCommand toData();
  
  public abstract FightCommand toBean();
  
  public abstract FightCommand toDataIf();
  
  public abstract FightCommand toBeanIf();
  
  public abstract List<FightCommandInfo> getCommandfriendlist();
  
  public abstract List<FightCommandInfo> getCommandfriendlistAsData();
  
  public abstract List<FightCommandInfo> getCommandenermylist();
  
  public abstract List<FightCommandInfo> getCommandenermylistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */