package xbean;

import xdb.Bean;

public abstract interface XiaoHuiKuaiPaoGlobalInfo
  extends Bean
{
  public abstract XiaoHuiKuaiPaoGlobalInfo copy();
  
  public abstract XiaoHuiKuaiPaoGlobalInfo toData();
  
  public abstract XiaoHuiKuaiPaoGlobalInfo toBean();
  
  public abstract XiaoHuiKuaiPaoGlobalInfo toDataIf();
  
  public abstract XiaoHuiKuaiPaoGlobalInfo toBeanIf();
  
  public abstract boolean getIsautodraw();
  
  public abstract void setIsautodraw(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XiaoHuiKuaiPaoGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */