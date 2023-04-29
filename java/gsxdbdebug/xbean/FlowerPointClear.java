package xbean;

import xdb.Bean;

public abstract interface FlowerPointClear
  extends Bean
{
  public abstract FlowerPointClear copy();
  
  public abstract FlowerPointClear toData();
  
  public abstract FlowerPointClear toBean();
  
  public abstract FlowerPointClear toDataIf();
  
  public abstract FlowerPointClear toBeanIf();
  
  public abstract long getFlowerrefreshtime();
  
  public abstract void setFlowerrefreshtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FlowerPointClear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */