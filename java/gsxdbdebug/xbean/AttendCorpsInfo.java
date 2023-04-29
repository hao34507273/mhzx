package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface AttendCorpsInfo
  extends Bean
{
  public abstract AttendCorpsInfo copy();
  
  public abstract AttendCorpsInfo toData();
  
  public abstract AttendCorpsInfo toBean();
  
  public abstract AttendCorpsInfo toDataIf();
  
  public abstract AttendCorpsInfo toBeanIf();
  
  public abstract int getZoneid();
  
  public abstract List<Long> getMembers();
  
  public abstract List<Long> getMembersAsData();
  
  public abstract float getVote_stage_start_average_fight_value();
  
  public abstract int getVote_num();
  
  public abstract long getVote_num_timestamp();
  
  public abstract int getRound_robin_point();
  
  public abstract int getRound_robin_win_num();
  
  public abstract int getRound_robin_lose_num();
  
  public abstract float getRound_robin_end_average_fight_value();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getBadge();
  
  public abstract void setZoneid(int paramInt);
  
  public abstract void setVote_stage_start_average_fight_value(float paramFloat);
  
  public abstract void setVote_num(int paramInt);
  
  public abstract void setVote_num_timestamp(long paramLong);
  
  public abstract void setRound_robin_point(int paramInt);
  
  public abstract void setRound_robin_win_num(int paramInt);
  
  public abstract void setRound_robin_lose_num(int paramInt);
  
  public abstract void setRound_robin_end_average_fight_value(float paramFloat);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setBadge(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AttendCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */