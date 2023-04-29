package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarriageParades
  extends Bean
{
  public abstract MarriageParades copy();
  
  public abstract MarriageParades toData();
  
  public abstract MarriageParades toBean();
  
  public abstract MarriageParades toDataIf();
  
  public abstract MarriageParades toBeanIf();
  
  public abstract List<MarriageParade> getMarriageparades();
  
  public abstract List<MarriageParade> getMarriageparadesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarriageParades.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */