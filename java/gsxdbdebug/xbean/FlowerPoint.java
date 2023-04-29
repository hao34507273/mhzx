package xbean;

import xdb.Bean;

public abstract interface FlowerPoint
  extends Bean
{
  public abstract FlowerPoint copy();
  
  public abstract FlowerPoint toData();
  
  public abstract FlowerPoint toBean();
  
  public abstract FlowerPoint toDataIf();
  
  public abstract FlowerPoint toBeanIf();
  
  public abstract int getReceivepoint();
  
  public abstract int getGivepoint();
  
  public abstract long getCleartime();
  
  public abstract int getVersion();
  
  public abstract int getTotal_receive_point();
  
  public abstract int getTotal_give_point();
  
  public abstract void setReceivepoint(int paramInt);
  
  public abstract void setGivepoint(int paramInt);
  
  public abstract void setCleartime(long paramLong);
  
  public abstract void setVersion(int paramInt);
  
  public abstract void setTotal_receive_point(int paramInt);
  
  public abstract void setTotal_give_point(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FlowerPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */