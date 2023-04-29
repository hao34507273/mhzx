package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface XiaoHuiKuaiPaoActivityInfo
  extends Bean
{
  public abstract XiaoHuiKuaiPaoActivityInfo copy();
  
  public abstract XiaoHuiKuaiPaoActivityInfo toData();
  
  public abstract XiaoHuiKuaiPaoActivityInfo toBean();
  
  public abstract XiaoHuiKuaiPaoActivityInfo toDataIf();
  
  public abstract XiaoHuiKuaiPaoActivityInfo toBeanIf();
  
  public abstract Map<Integer, XiaoHuiKuaiPaoInfo> getActivityid2xiaohuikuaipaoinfo();
  
  public abstract Map<Integer, XiaoHuiKuaiPaoInfo> getActivityid2xiaohuikuaipaoinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XiaoHuiKuaiPaoActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */