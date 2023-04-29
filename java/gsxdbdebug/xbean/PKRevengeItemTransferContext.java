package xbean;

import xdb.Bean;

public abstract interface PKRevengeItemTransferContext
  extends Bean
{
  public abstract PKRevengeItemTransferContext copy();
  
  public abstract PKRevengeItemTransferContext toData();
  
  public abstract PKRevengeItemTransferContext toBean();
  
  public abstract PKRevengeItemTransferContext toDataIf();
  
  public abstract PKRevengeItemTransferContext toBeanIf();
  
  public abstract int getMap_id();
  
  public abstract int getPos_x();
  
  public abstract int getPos_y();
  
  public abstract long getSession_id();
  
  public abstract void setMap_id(int paramInt);
  
  public abstract void setPos_x(int paramInt);
  
  public abstract void setPos_y(int paramInt);
  
  public abstract void setSession_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PKRevengeItemTransferContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */