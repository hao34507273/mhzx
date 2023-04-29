package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface DisplayItemList
  extends Bean
{
  public abstract DisplayItemList copy();
  
  public abstract DisplayItemList toData();
  
  public abstract DisplayItemList toBean();
  
  public abstract DisplayItemList toDataIf();
  
  public abstract DisplayItemList toBeanIf();
  
  public abstract long getFreshtime();
  
  public abstract List<DisplayItem> getDisplayitemlist();
  
  public abstract List<DisplayItem> getDisplayitemlistAsData();
  
  public abstract void setFreshtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DisplayItemList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */