package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SystemSetting
  extends Bean
{
  public abstract SystemSetting copy();
  
  public abstract SystemSetting toData();
  
  public abstract SystemSetting toBean();
  
  public abstract SystemSetting toDataIf();
  
  public abstract SystemSetting toBeanIf();
  
  public abstract Map<Integer, Integer> getSettingmap();
  
  public abstract Map<Integer, Integer> getSettingmapAsData();
  
  public abstract Map<Integer, Integer> getConformsettings();
  
  public abstract Map<Integer, Integer> getConformsettingsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SystemSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */