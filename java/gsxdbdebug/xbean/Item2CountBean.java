package xbean;

import xdb.Bean;

public abstract interface Item2CountBean
  extends Bean
{
  public abstract Item2CountBean copy();
  
  public abstract Item2CountBean toData();
  
  public abstract Item2CountBean toBean();
  
  public abstract Item2CountBean toDataIf();
  
  public abstract Item2CountBean toBeanIf();
  
  public abstract int getItemid();
  
  public abstract int getCount();
  
  public abstract void setItemid(int paramInt);
  
  public abstract void setCount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Item2CountBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */