package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GraphFinishBean
  extends Bean
{
  public abstract GraphFinishBean copy();
  
  public abstract GraphFinishBean toData();
  
  public abstract GraphFinishBean toBean();
  
  public abstract GraphFinishBean toDataIf();
  
  public abstract GraphFinishBean toBeanIf();
  
  public abstract Map<Integer, Integer> getGraphidtofinish();
  
  public abstract Map<Integer, Integer> getGraphidtofinishAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GraphFinishBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */