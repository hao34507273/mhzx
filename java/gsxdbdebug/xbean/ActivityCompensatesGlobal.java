package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityCompensatesGlobal
  extends Bean
{
  public abstract ActivityCompensatesGlobal copy();
  
  public abstract ActivityCompensatesGlobal toData();
  
  public abstract ActivityCompensatesGlobal toBean();
  
  public abstract ActivityCompensatesGlobal toDataIf();
  
  public abstract ActivityCompensatesGlobal toBeanIf();
  
  public abstract Map<Integer, ActivityCompensateGlobal> getActivity2compensateglobal();
  
  public abstract Map<Integer, ActivityCompensateGlobal> getActivity2compensateglobalAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityCompensatesGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */