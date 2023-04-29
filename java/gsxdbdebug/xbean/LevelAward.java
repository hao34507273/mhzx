package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface LevelAward
  extends Bean
{
  public abstract LevelAward copy();
  
  public abstract LevelAward toData();
  
  public abstract LevelAward toBean();
  
  public abstract LevelAward toDataIf();
  
  public abstract LevelAward toBeanIf();
  
  public abstract List<Integer> getLevelawardlist();
  
  public abstract List<Integer> getLevelawardlistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LevelAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */