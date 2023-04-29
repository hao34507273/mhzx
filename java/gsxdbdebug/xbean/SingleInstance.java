package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleInstance
  extends Bean
{
  public abstract SingleInstance copy();
  
  public abstract SingleInstance toData();
  
  public abstract SingleInstance toBean();
  
  public abstract SingleInstance toDataIf();
  
  public abstract SingleInstance toBeanIf();
  
  public abstract int getCurprocess();
  
  public abstract int getHighprocess();
  
  public abstract int getFinishtimes();
  
  public abstract Map<Integer, ProcessBean> getProcessmap();
  
  public abstract Map<Integer, ProcessBean> getProcessmapAsData();
  
  public abstract int getSign();
  
  public abstract void setCurprocess(int paramInt);
  
  public abstract void setHighprocess(int paramInt);
  
  public abstract void setFinishtimes(int paramInt);
  
  public abstract void setSign(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */