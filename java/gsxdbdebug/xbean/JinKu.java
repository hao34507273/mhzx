package xbean;

import xdb.Bean;

public abstract interface JinKu
  extends Bean
{
  public abstract JinKu copy();
  
  public abstract JinKu toData();
  
  public abstract JinKu toBean();
  
  public abstract JinKu toDataIf();
  
  public abstract JinKu toBeanIf();
  
  public abstract int getLevel();
  
  public abstract long getLevelupendtime();
  
  public abstract int getGangmoney();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setLevelupendtime(long paramLong);
  
  public abstract void setGangmoney(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JinKu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */