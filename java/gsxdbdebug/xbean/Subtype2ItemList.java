package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Subtype2ItemList
  extends Bean
{
  public abstract Subtype2ItemList copy();
  
  public abstract Subtype2ItemList toData();
  
  public abstract Subtype2ItemList toBean();
  
  public abstract Subtype2ItemList toDataIf();
  
  public abstract Subtype2ItemList toBeanIf();
  
  public abstract Map<Integer, DisplayItemList> getSub2itemlist();
  
  public abstract Map<Integer, DisplayItemList> getSub2itemlistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Subtype2ItemList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */