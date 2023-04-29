package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface FeiShengFightInfo
  extends Bean
{
  public abstract FeiShengFightInfo copy();
  
  public abstract FeiShengFightInfo toData();
  
  public abstract FeiShengFightInfo toBean();
  
  public abstract FeiShengFightInfo toDataIf();
  
  public abstract FeiShengFightInfo toBeanIf();
  
  public abstract Set<Integer> getComplete_sortids();
  
  public abstract Set<Integer> getComplete_sortidsAsData();
  
  public abstract int getDaily_get_team_member_award_times();
  
  public abstract long getDaily_get_team_member_award_times_timestamp();
  
  public abstract void setDaily_get_team_member_award_times(int paramInt);
  
  public abstract void setDaily_get_team_member_award_times_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FeiShengFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */