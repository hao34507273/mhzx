package xbean;

import xdb.Bean;

public abstract interface JiuXiaoRankRole
  extends Bean
{
  public abstract JiuXiaoRankRole copy();
  
  public abstract JiuXiaoRankRole toData();
  
  public abstract JiuXiaoRankRole toBean();
  
  public abstract JiuXiaoRankRole toDataIf();
  
  public abstract JiuXiaoRankRole toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getLayer();
  
  public abstract int getSec();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setLayer(int paramInt);
  
  public abstract void setSec(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoRankRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */