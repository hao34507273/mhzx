package xbean;

import xdb.Bean;

public abstract interface GraphBean
  extends Bean
{
  public abstract GraphBean copy();
  
  public abstract GraphBean toData();
  
  public abstract GraphBean toBean();
  
  public abstract GraphBean toDataIf();
  
  public abstract GraphBean toBeanIf();
  
  public abstract int getGraphid();
  
  public abstract NodeBean getNodebean();
  
  public abstract int getAllfinishcount();
  
  public abstract void setGraphid(int paramInt);
  
  public abstract void setAllfinishcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GraphBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */