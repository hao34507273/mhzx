package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChildFashionInfo
  extends Bean
{
  public abstract ChildFashionInfo copy();
  
  public abstract ChildFashionInfo toData();
  
  public abstract ChildFashionInfo toBean();
  
  public abstract ChildFashionInfo toDataIf();
  
  public abstract ChildFashionInfo toBeanIf();
  
  public abstract Map<Integer, FashionInfo> getFashions();
  
  public abstract Map<Integer, FashionInfo> getFashionsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildFashionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */