package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PropertyList
  extends Bean
{
  public abstract PropertyList copy();
  
  public abstract PropertyList toData();
  
  public abstract PropertyList toBean();
  
  public abstract PropertyList toDataIf();
  
  public abstract PropertyList toBeanIf();
  
  public abstract List<WingProperty> getPropertylist();
  
  public abstract List<WingProperty> getPropertylistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PropertyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */