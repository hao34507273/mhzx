package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SingleCrossFieldRank
  extends Bean
{
  public abstract SingleCrossFieldRank copy();
  
  public abstract SingleCrossFieldRank toData();
  
  public abstract SingleCrossFieldRank toBean();
  
  public abstract SingleCrossFieldRank toDataIf();
  
  public abstract SingleCrossFieldRank toBeanIf();
  
  public abstract int getSeason();
  
  public abstract List<Long> getRank_list();
  
  public abstract List<Long> getRank_listAsData();
  
  public abstract void setSeason(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleCrossFieldRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */