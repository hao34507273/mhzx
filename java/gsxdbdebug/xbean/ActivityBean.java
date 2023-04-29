package xbean;

import xdb.Bean;

public abstract interface ActivityBean
  extends Bean
{
  public abstract ActivityBean copy();
  
  public abstract ActivityBean toData();
  
  public abstract ActivityBean toBean();
  
  public abstract ActivityBean toDataIf();
  
  public abstract ActivityBean toBeanIf();
  
  public abstract long getEndtime();
  
  public abstract int getCount();
  
  public abstract boolean getRecommendrewarded();
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setCount(int paramInt);
  
  public abstract void setRecommendrewarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */