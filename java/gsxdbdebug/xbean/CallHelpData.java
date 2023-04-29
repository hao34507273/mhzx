package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CallHelpData
  extends Bean
{
  public abstract CallHelpData copy();
  
  public abstract CallHelpData toData();
  
  public abstract CallHelpData toBean();
  
  public abstract CallHelpData toDataIf();
  
  public abstract CallHelpData toBeanIf();
  
  public abstract Map<Integer, BoxData> getBoxindex2data();
  
  public abstract Map<Integer, BoxData> getBoxindex2dataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CallHelpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */