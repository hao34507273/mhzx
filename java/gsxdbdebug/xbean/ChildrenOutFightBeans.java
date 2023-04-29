package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChildrenOutFightBeans
  extends Bean
{
  public abstract ChildrenOutFightBeans copy();
  
  public abstract ChildrenOutFightBeans toData();
  
  public abstract ChildrenOutFightBeans toBean();
  
  public abstract ChildrenOutFightBeans toDataIf();
  
  public abstract ChildrenOutFightBeans toBeanIf();
  
  public abstract Map<Long, ChildrenOutFightBean> getOutfigthchilds();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildrenOutFightBeans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */