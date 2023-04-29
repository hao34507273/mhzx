package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface CatInfo
  extends Bean
{
  public static final int STATE_NORMAL = 1;
  public static final int STATE_EXPLORE = 2;
  public static final int STATE_RESET = 3;
  
  public abstract CatInfo copy();
  
  public abstract CatInfo toData();
  
  public abstract CatInfo toBean();
  
  public abstract CatInfo toDataIf();
  
  public abstract CatInfo toBeanIf();
  
  public abstract long getId();
  
  public abstract int getCat_level_cfgid();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getExplore_num();
  
  public abstract int getTotal_explore_num();
  
  public abstract int getVigor();
  
  public abstract int getState();
  
  public abstract long getExplore_starttime();
  
  public abstract long getExplore_costtime();
  
  public abstract long getExplore_endtime();
  
  public abstract int getExplored_level();
  
  public abstract int getExplored_partner_cfgid();
  
  public abstract int getPartner_cfgid();
  
  public abstract int getItem_cfgid();
  
  public abstract long getForce_recovery_time();
  
  public abstract List<RoleFeedInfo> getRecords();
  
  public abstract List<RoleFeedInfo> getRecordsAsData();
  
  public abstract void setId(long paramLong);
  
  public abstract void setCat_level_cfgid(int paramInt);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setExplore_num(int paramInt);
  
  public abstract void setTotal_explore_num(int paramInt);
  
  public abstract void setVigor(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void setExplore_starttime(long paramLong);
  
  public abstract void setExplore_costtime(long paramLong);
  
  public abstract void setExplore_endtime(long paramLong);
  
  public abstract void setExplored_level(int paramInt);
  
  public abstract void setExplored_partner_cfgid(int paramInt);
  
  public abstract void setPartner_cfgid(int paramInt);
  
  public abstract void setItem_cfgid(int paramInt);
  
  public abstract void setForce_recovery_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */