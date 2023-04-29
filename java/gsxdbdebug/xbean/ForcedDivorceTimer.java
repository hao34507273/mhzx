package xbean;

import mzm.gsp.marriage.main.ForceDivorceSession;
import xdb.Bean;

public abstract interface ForcedDivorceTimer
  extends Bean
{
  public abstract ForcedDivorceTimer copy();
  
  public abstract ForcedDivorceTimer toData();
  
  public abstract ForcedDivorceTimer toBean();
  
  public abstract ForcedDivorceTimer toDataIf();
  
  public abstract ForcedDivorceTimer toBeanIf();
  
  public abstract ForceDivorceSession getForcedivorcetimer();
  
  public abstract void setForcedivorcetimer(ForceDivorceSession paramForceDivorceSession);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ForcedDivorceTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */