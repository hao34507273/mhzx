package xbean;

import xdb.Bean;

public abstract interface ZhenfaBean
  extends Bean
{
  public abstract ZhenfaBean copy();
  
  public abstract ZhenfaBean toData();
  
  public abstract ZhenfaBean toBean();
  
  public abstract ZhenfaBean toDataIf();
  
  public abstract ZhenfaBean toBeanIf();
  
  public abstract int getZhenfaid();
  
  public abstract int getZhenfalevel();
  
  public abstract int getZhenfaexp();
  
  public abstract void setZhenfaid(int paramInt);
  
  public abstract void setZhenfalevel(int paramInt);
  
  public abstract void setZhenfaexp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ZhenfaBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */