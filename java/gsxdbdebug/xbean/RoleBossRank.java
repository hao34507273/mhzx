package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleBossRank
  extends Bean
{
  public abstract RoleBossRank copy();
  
  public abstract RoleBossRank toData();
  
  public abstract RoleBossRank toBean();
  
  public abstract RoleBossRank toDataIf();
  
  public abstract RoleBossRank toBeanIf();
  
  public abstract List<RoleBossBean> getRankdatas();
  
  public abstract List<RoleBossBean> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBossRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */