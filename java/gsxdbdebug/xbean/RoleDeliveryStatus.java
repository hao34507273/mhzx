package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoleDeliveryStatus
  extends Bean
{
  public abstract RoleDeliveryStatus copy();
  
  public abstract RoleDeliveryStatus toData();
  
  public abstract RoleDeliveryStatus toBean();
  
  public abstract RoleDeliveryStatus toDataIf();
  
  public abstract RoleDeliveryStatus toBeanIf();
  
  public abstract Set<Integer> getFetched_rewards();
  
  public abstract Set<Integer> getFetched_rewardsAsData();
  
  public abstract long getSource_id();
  
  public abstract long getTarget_id();
  
  public abstract Set<Integer> getNotified_rewards();
  
  public abstract Set<Integer> getNotified_rewardsAsData();
  
  public abstract void setSource_id(long paramLong);
  
  public abstract void setTarget_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleDeliveryStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */