package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TimeFlowInfos
  extends Bean
{
  public abstract TimeFlowInfos copy();
  
  public abstract TimeFlowInfos toData();
  
  public abstract TimeFlowInfos toBean();
  
  public abstract TimeFlowInfos toDataIf();
  
  public abstract TimeFlowInfos toBeanIf();
  
  public abstract Map<Integer, TimeFlowInfo> getFlows();
  
  public abstract Map<Integer, TimeFlowInfo> getFlowsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TimeFlowInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */