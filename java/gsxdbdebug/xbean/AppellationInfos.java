package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface AppellationInfos
  extends Bean
{
  public abstract AppellationInfos copy();
  
  public abstract AppellationInfos toData();
  
  public abstract AppellationInfos toBean();
  
  public abstract AppellationInfos toDataIf();
  
  public abstract AppellationInfos toBeanIf();
  
  public abstract List<AppellationInfo> getAppellations();
  
  public abstract List<AppellationInfo> getAppellationsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AppellationInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */