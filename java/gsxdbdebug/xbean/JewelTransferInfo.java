package xbean;

import xdb.Bean;

public abstract interface JewelTransferInfo
  extends Bean
{
  public abstract JewelTransferInfo copy();
  
  public abstract JewelTransferInfo toData();
  
  public abstract JewelTransferInfo toBean();
  
  public abstract JewelTransferInfo toDataIf();
  
  public abstract JewelTransferInfo toBeanIf();
  
  public abstract int getCount();
  
  public abstract void setCount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JewelTransferInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */