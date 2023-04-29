package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface GangDutyMembers
  extends Bean
{
  public abstract GangDutyMembers copy();
  
  public abstract GangDutyMembers toData();
  
  public abstract GangDutyMembers toBean();
  
  public abstract GangDutyMembers toDataIf();
  
  public abstract GangDutyMembers toBeanIf();
  
  public abstract Set<Long> getMembers();
  
  public abstract Set<Long> getMembersAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangDutyMembers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */