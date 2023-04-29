package xbean;

import xdb.Bean;

public abstract interface MatchActivityCfg
  extends Bean
{
  public static final int TYPE_ROLE = 0;
  public static final int TYPE_TEAM = 1;
  
  public abstract MatchActivityCfg copy();
  
  public abstract MatchActivityCfg toData();
  
  public abstract MatchActivityCfg toBean();
  
  public abstract MatchActivityCfg toDataIf();
  
  public abstract MatchActivityCfg toBeanIf();
  
  public abstract MatchKey getActivity();
  
  public abstract int getMatchtype();
  
  public abstract long getStarttime();
  
  public abstract int getRolelevel();
  
  public abstract int getLevellow();
  
  public abstract int getLevelhigh();
  
  public abstract int getNeedlevellow();
  
  public abstract int getNeedlevelhigh();
  
  public abstract long getInsistwaitsessionid();
  
  public abstract long getBeremovedsessionid();
  
  public abstract long getExpandlvsessionid();
  
  public abstract long getRolebeleaderhintsessionid();
  
  public abstract void setActivity(MatchKey paramMatchKey);
  
  public abstract void setMatchtype(int paramInt);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setRolelevel(int paramInt);
  
  public abstract void setLevellow(int paramInt);
  
  public abstract void setLevelhigh(int paramInt);
  
  public abstract void setNeedlevellow(int paramInt);
  
  public abstract void setNeedlevelhigh(int paramInt);
  
  public abstract void setInsistwaitsessionid(long paramLong);
  
  public abstract void setBeremovedsessionid(long paramLong);
  
  public abstract void setExpandlvsessionid(long paramLong);
  
  public abstract void setRolebeleaderhintsessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MatchActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */