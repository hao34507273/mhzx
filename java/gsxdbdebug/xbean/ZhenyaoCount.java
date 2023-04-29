package xbean;

import xdb.Bean;

public abstract interface ZhenyaoCount
  extends Bean
{
  public abstract ZhenyaoCount copy();
  
  public abstract ZhenyaoCount toData();
  
  public abstract ZhenyaoCount toBean();
  
  public abstract ZhenyaoCount toDataIf();
  
  public abstract ZhenyaoCount toBeanIf();
  
  public abstract long getCleantime();
  
  public abstract int getZhenyaocount();
  
  public abstract int getReservedexp();
  
  public abstract int getSinglecount();
  
  public abstract int getDoublecount();
  
  public abstract void setCleantime(long paramLong);
  
  public abstract void setZhenyaocount(int paramInt);
  
  public abstract void setReservedexp(int paramInt);
  
  public abstract void setSinglecount(int paramInt);
  
  public abstract void setDoublecount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ZhenyaoCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */