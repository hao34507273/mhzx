package xbean;

import xdb.Bean;

public abstract interface ProcessBean
  extends Bean
{
  public abstract ProcessBean copy();
  
  public abstract ProcessBean toData();
  
  public abstract ProcessBean toBean();
  
  public abstract ProcessBean toDataIf();
  
  public abstract ProcessBean toBeanIf();
  
  public abstract int getSecond();
  
  public abstract int getSuctimes();
  
  public abstract void setSecond(int paramInt);
  
  public abstract void setSuctimes(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ProcessBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */