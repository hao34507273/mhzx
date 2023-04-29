package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FormatArgs
  extends Bean
{
  public abstract FormatArgs copy();
  
  public abstract FormatArgs toData();
  
  public abstract FormatArgs toBean();
  
  public abstract FormatArgs toDataIf();
  
  public abstract FormatArgs toBeanIf();
  
  public abstract List<String> getArgs();
  
  public abstract List<String> getArgsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FormatArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */