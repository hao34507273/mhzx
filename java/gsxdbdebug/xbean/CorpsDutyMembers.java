package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CorpsDutyMembers
  extends Bean
{
  public abstract CorpsDutyMembers copy();
  
  public abstract CorpsDutyMembers toData();
  
  public abstract CorpsDutyMembers toBean();
  
  public abstract CorpsDutyMembers toDataIf();
  
  public abstract CorpsDutyMembers toBeanIf();
  
  public abstract Set<Long> getMembers();
  
  public abstract Set<Long> getMembersAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CorpsDutyMembers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */