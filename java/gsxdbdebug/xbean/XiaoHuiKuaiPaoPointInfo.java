package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface XiaoHuiKuaiPaoPointInfo
  extends Bean
{
  public abstract XiaoHuiKuaiPaoPointInfo copy();
  
  public abstract XiaoHuiKuaiPaoPointInfo toData();
  
  public abstract XiaoHuiKuaiPaoPointInfo toBean();
  
  public abstract XiaoHuiKuaiPaoPointInfo toDataIf();
  
  public abstract XiaoHuiKuaiPaoPointInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getCfgid2count();
  
  public abstract Map<Integer, Integer> getCfgid2countAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XiaoHuiKuaiPaoPointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */