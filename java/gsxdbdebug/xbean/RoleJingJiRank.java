package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleJingJiRank
  extends Bean
{
  public abstract RoleJingJiRank copy();
  
  public abstract RoleJingJiRank toData();
  
  public abstract RoleJingJiRank toBean();
  
  public abstract RoleJingJiRank toDataIf();
  
  public abstract RoleJingJiRank toBeanIf();
  
  public abstract List<RoleJingJiBean> getRankdatas();
  
  public abstract List<RoleJingJiBean> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleJingJiRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */