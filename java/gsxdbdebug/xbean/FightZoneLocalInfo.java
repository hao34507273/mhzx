package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface FightZoneLocalInfo
  extends Bean
{
  public abstract FightZoneLocalInfo copy();
  
  public abstract FightZoneLocalInfo toData();
  
  public abstract FightZoneLocalInfo toBean();
  
  public abstract FightZoneLocalInfo toDataIf();
  
  public abstract FightZoneLocalInfo toBeanIf();
  
  public abstract Set<Long> getAward_corps_id_set();
  
  public abstract Set<Long> getAward_corps_id_setAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightZoneLocalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */