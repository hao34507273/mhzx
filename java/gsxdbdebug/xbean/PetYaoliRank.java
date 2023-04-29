package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PetYaoliRank
  extends Bean
{
  public abstract PetYaoliRank copy();
  
  public abstract PetYaoliRank toData();
  
  public abstract PetYaoliRank toBean();
  
  public abstract PetYaoliRank toDataIf();
  
  public abstract PetYaoliRank toBeanIf();
  
  public abstract List<PetYaoliBean> getRolerankdatas();
  
  public abstract List<PetYaoliBean> getRolerankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetYaoliRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */