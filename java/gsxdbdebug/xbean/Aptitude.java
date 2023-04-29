package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Aptitude
  extends Bean
{
  public abstract Aptitude copy();
  
  public abstract Aptitude toData();
  
  public abstract Aptitude toBean();
  
  public abstract Aptitude toDataIf();
  
  public abstract Aptitude toBeanIf();
  
  public abstract Map<Integer, Integer> getAptmap();
  
  public abstract Map<Integer, Integer> getAptmapAsData();
  
  public abstract Map<Integer, Integer> getAptlimitmap();
  
  public abstract Map<Integer, Integer> getAptlimitmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Aptitude.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */