package xbean;

import xdb.Bean;

public abstract interface TitleInfo
  extends Bean
{
  public abstract TitleInfo copy();
  
  public abstract TitleInfo toData();
  
  public abstract TitleInfo toBean();
  
  public abstract TitleInfo toDataIf();
  
  public abstract TitleInfo toBeanIf();
  
  public abstract int getTitleid();
  
  public abstract long getTimeout();
  
  public abstract void setTitleid(int paramInt);
  
  public abstract void setTimeout(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TitleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */