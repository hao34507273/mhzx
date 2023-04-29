package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleReceivceFlowerRank
  extends Bean
{
  public abstract RoleReceivceFlowerRank copy();
  
  public abstract RoleReceivceFlowerRank toData();
  
  public abstract RoleReceivceFlowerRank toBean();
  
  public abstract RoleReceivceFlowerRank toDataIf();
  
  public abstract RoleReceivceFlowerRank toBeanIf();
  
  public abstract List<RoleReceiveFlowerBean> getRankdatas();
  
  public abstract List<RoleReceiveFlowerBean> getRankdatasAsData();
  
  public abstract int getVersion();
  
  public abstract void setVersion(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleReceivceFlowerRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */