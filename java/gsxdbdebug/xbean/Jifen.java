package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Jifen
  extends Bean
{
  public abstract Jifen copy();
  
  public abstract Jifen toData();
  
  public abstract Jifen toBean();
  
  public abstract Jifen toDataIf();
  
  public abstract Jifen toBeanIf();
  
  public abstract Map<Integer, Long> getType2point();
  
  public abstract Map<Integer, Long> getType2pointAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Jifen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */