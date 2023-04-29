package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MiFang
  extends Bean
{
  public abstract MiFang copy();
  
  public abstract MiFang toData();
  
  public abstract MiFang toBean();
  
  public abstract MiFang toDataIf();
  
  public abstract MiFang toBeanIf();
  
  public abstract int getMifangcfgid();
  
  public abstract long getMifangcfgstarttime();
  
  public abstract long getMifangcfgendtime();
  
  public abstract List<Integer> getMifangyaocailist();
  
  public abstract List<Integer> getMifangyaocailistAsData();
  
  public abstract void setMifangcfgid(int paramInt);
  
  public abstract void setMifangcfgstarttime(long paramLong);
  
  public abstract void setMifangcfgendtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MiFang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */