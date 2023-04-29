package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GuideState
  extends Bean
{
  public static final int UN_GUIDED = 0;
  public static final int GUIDED = 1;
  
  public abstract GuideState copy();
  
  public abstract GuideState toData();
  
  public abstract GuideState toBean();
  
  public abstract GuideState toDataIf();
  
  public abstract GuideState toBeanIf();
  
  public abstract Map<Integer, Integer> getGuideid2state();
  
  public abstract Map<Integer, Integer> getGuideid2stateAsData();
  
  public abstract Map<Integer, Integer> getGuideid2param();
  
  public abstract Map<Integer, Integer> getGuideid2paramAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GuideState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */