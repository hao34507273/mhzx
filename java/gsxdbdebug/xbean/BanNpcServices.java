package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BanNpcServices
  extends Bean
{
  public abstract BanNpcServices copy();
  
  public abstract BanNpcServices toData();
  
  public abstract BanNpcServices toBean();
  
  public abstract BanNpcServices toDataIf();
  
  public abstract BanNpcServices toBeanIf();
  
  public abstract Set<Integer> getNpcservices();
  
  public abstract Set<Integer> getNpcservicesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanNpcServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */