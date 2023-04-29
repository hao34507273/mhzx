package xbean;

import xdb.Bean;

public abstract interface MysteryGoodsInfo
  extends Bean
{
  public abstract MysteryGoodsInfo copy();
  
  public abstract MysteryGoodsInfo toData();
  
  public abstract MysteryGoodsInfo toBean();
  
  public abstract MysteryGoodsInfo toDataIf();
  
  public abstract MysteryGoodsInfo toBeanIf();
  
  public abstract int getGoods_id();
  
  public abstract int getSale();
  
  public abstract int getCount();
  
  public abstract void setGoods_id(int paramInt);
  
  public abstract void setSale(int paramInt);
  
  public abstract void setCount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MysteryGoodsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */