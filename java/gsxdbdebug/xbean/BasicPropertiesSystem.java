package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BasicPropertiesSystem
  extends Bean
{
  public abstract BasicPropertiesSystem copy();
  
  public abstract BasicPropertiesSystem toData();
  
  public abstract BasicPropertiesSystem toBean();
  
  public abstract BasicPropertiesSystem toDataIf();
  
  public abstract BasicPropertiesSystem toBeanIf();
  
  public abstract int getPotentialpoint();
  
  public abstract Map<Integer, Integer> getBasicpropertymap();
  
  public abstract Map<Integer, Integer> getBasicpropertymapAsData();
  
  public abstract boolean getIsautospecialpoint();
  
  public abstract Map<Integer, Integer> getAutoassignpointpref();
  
  public abstract Map<Integer, Integer> getAutoassignpointprefAsData();
  
  public abstract void setPotentialpoint(int paramInt);
  
  public abstract void setIsautospecialpoint(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BasicPropertiesSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */