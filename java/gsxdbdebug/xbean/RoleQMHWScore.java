package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface RoleQMHWScore
  extends Bean
{
  public abstract RoleQMHWScore copy();
  
  public abstract RoleQMHWScore toData();
  
  public abstract RoleQMHWScore toBean();
  
  public abstract RoleQMHWScore toDataIf();
  
  public abstract RoleQMHWScore toBeanIf();
  
  public abstract int getScore();
  
  public abstract int getWincount();
  
  public abstract int getLosecount();
  
  public abstract int getContinuewincount();
  
  public abstract Set<Integer> getGetawards();
  
  public abstract Set<Integer> getGetawardsAsData();
  
  public abstract Set<Integer> getGetjoinawards();
  
  public abstract Set<Integer> getGetjoinawardsAsData();
  
  public abstract Map<Long, Integer> getMatchroles();
  
  public abstract Map<Long, Integer> getMatchrolesAsData();
  
  public abstract int getExtendmatchscore();
  
  public abstract Set<Long> getLatestmatchroles();
  
  public abstract Set<Long> getLatestmatchrolesAsData();
  
  public abstract void setScore(int paramInt);
  
  public abstract void setWincount(int paramInt);
  
  public abstract void setLosecount(int paramInt);
  
  public abstract void setContinuewincount(int paramInt);
  
  public abstract void setExtendmatchscore(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleQMHWScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */