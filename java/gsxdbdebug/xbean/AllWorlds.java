package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AllWorlds
  extends Bean
{
  public abstract AllWorlds copy();
  
  public abstract AllWorlds toData();
  
  public abstract AllWorlds toBean();
  
  public abstract AllWorlds toDataIf();
  
  public abstract AllWorlds toBeanIf();
  
  public abstract Map<Long, Long> getTeamid2worldid();
  
  public abstract Map<Long, Long> getTeamid2worldidAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllWorlds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */