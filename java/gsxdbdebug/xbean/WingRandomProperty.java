package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WingRandomProperty
  extends Bean
{
  public abstract WingRandomProperty copy();
  
  public abstract WingRandomProperty toData();
  
  public abstract WingRandomProperty toBean();
  
  public abstract WingRandomProperty toDataIf();
  
  public abstract WingRandomProperty toBeanIf();
  
  public abstract Map<Integer, PropertyList> getIndex2wingproperty();
  
  public abstract Map<Integer, PropertyList> getIndex2wingpropertyAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingRandomProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */