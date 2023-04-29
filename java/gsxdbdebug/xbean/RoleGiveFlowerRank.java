package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleGiveFlowerRank
  extends Bean
{
  public abstract RoleGiveFlowerRank copy();
  
  public abstract RoleGiveFlowerRank toData();
  
  public abstract RoleGiveFlowerRank toBean();
  
  public abstract RoleGiveFlowerRank toDataIf();
  
  public abstract RoleGiveFlowerRank toBeanIf();
  
  public abstract List<RoleGiveFlowerBean> getRankdatas();
  
  public abstract List<RoleGiveFlowerBean> getRankdatasAsData();
  
  public abstract int getVersion();
  
  public abstract void setVersion(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGiveFlowerRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */