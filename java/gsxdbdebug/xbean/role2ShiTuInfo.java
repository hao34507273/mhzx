package xbean;

import xdb.Bean;

public abstract interface role2ShiTuInfo
  extends Bean
{
  public abstract role2ShiTuInfo copy();
  
  public abstract role2ShiTuInfo toData();
  
  public abstract role2ShiTuInfo toBean();
  
  public abstract role2ShiTuInfo toDataIf();
  
  public abstract role2ShiTuInfo toBeanIf();
  
  public abstract int getGraduatetimes();
  
  public abstract MasterInfo getMasterinfo();
  
  public abstract ApprenticeInfo getApprenticeinfo();
  
  public abstract boolean getRefusemasterrecommend();
  
  public abstract void setGraduatetimes(int paramInt);
  
  public abstract void setRefusemasterrecommend(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\role2ShiTuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */