package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FabaoArtifactRecord
  extends Bean
{
  public abstract FabaoArtifactRecord copy();
  
  public abstract FabaoArtifactRecord toData();
  
  public abstract FabaoArtifactRecord toBean();
  
  public abstract FabaoArtifactRecord toDataIf();
  
  public abstract FabaoArtifactRecord toBeanIf();
  
  public abstract int getExpire_time();
  
  public abstract int getLevel();
  
  public abstract int getUpgrade_exp();
  
  public abstract Map<Integer, Integer> getProperties();
  
  public abstract Map<Integer, Integer> getPropertiesAsData();
  
  public abstract void setExpire_time(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setUpgrade_exp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FabaoArtifactRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */