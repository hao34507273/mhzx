package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GraphTaskFinishBean
  extends Bean
{
  public abstract GraphTaskFinishBean copy();
  
  public abstract GraphTaskFinishBean toData();
  
  public abstract GraphTaskFinishBean toBean();
  
  public abstract GraphTaskFinishBean toDataIf();
  
  public abstract GraphTaskFinishBean toBeanIf();
  
  public abstract Map<Integer, Integer> getGraphidtotaskid();
  
  public abstract Map<Integer, Integer> getGraphidtotaskidAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GraphTaskFinishBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */