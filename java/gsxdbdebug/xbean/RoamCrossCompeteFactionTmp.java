package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoamCrossCompeteFactionTmp
  extends Bean
{
  public abstract RoamCrossCompeteFactionTmp copy();
  
  public abstract RoamCrossCompeteFactionTmp toData();
  
  public abstract RoamCrossCompeteFactionTmp toBean();
  
  public abstract RoamCrossCompeteFactionTmp toDataIf();
  
  public abstract RoamCrossCompeteFactionTmp toBeanIf();
  
  public abstract long getWorld();
  
  public abstract Set<Long> getRoles();
  
  public abstract Set<Long> getRolesAsData();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
  
  public abstract int getMapid();
  
  public abstract void setWorld(long paramLong);
  
  public abstract void setMapid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoamCrossCompeteFactionTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */