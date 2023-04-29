package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleLevelRank
  extends Bean
{
  public abstract RoleLevelRank copy();
  
  public abstract RoleLevelRank toData();
  
  public abstract RoleLevelRank toBean();
  
  public abstract RoleLevelRank toDataIf();
  
  public abstract RoleLevelRank toBeanIf();
  
  public abstract List<RoleLevelBean> getRankdatas();
  
  public abstract List<RoleLevelBean> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleLevelRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */