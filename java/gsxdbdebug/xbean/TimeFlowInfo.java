package xbean;

import xdb.Bean;

public abstract interface TimeFlowInfo
  extends Bean
{
  public abstract TimeFlowInfo copy();
  
  public abstract TimeFlowInfo toData();
  
  public abstract TimeFlowInfo toBean();
  
  public abstract TimeFlowInfo toDataIf();
  
  public abstract TimeFlowInfo toBeanIf();
  
  public abstract int getStep();
  
  public abstract void setStep(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TimeFlowInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */