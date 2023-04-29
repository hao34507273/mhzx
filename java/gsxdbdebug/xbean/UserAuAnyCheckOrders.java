package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface UserAuAnyCheckOrders
  extends Bean
{
  public static final int CHECK_STATUS_IDLE = 1;
  public static final int CHECK_STATUS_PREPARE = 2;
  public static final int CHECK_STATUS_DOING = 4;
  
  public abstract UserAuAnyCheckOrders copy();
  
  public abstract UserAuAnyCheckOrders toData();
  
  public abstract UserAuAnyCheckOrders toBean();
  
  public abstract UserAuAnyCheckOrders toDataIf();
  
  public abstract UserAuAnyCheckOrders toBeanIf();
  
  public abstract int getOffset();
  
  public abstract int getSn();
  
  public abstract int getCheck_status();
  
  public abstract List<AuAnyCheckOrderInfo> getOrders();
  
  public abstract List<AuAnyCheckOrderInfo> getOrdersAsData();
  
  public abstract long getMagic_num();
  
  public abstract void setOffset(int paramInt);
  
  public abstract void setSn(int paramInt);
  
  public abstract void setCheck_status(int paramInt);
  
  public abstract void setMagic_num(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserAuAnyCheckOrders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */