package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FabaoArtifactRecords
  extends Bean
{
  public abstract FabaoArtifactRecords copy();
  
  public abstract FabaoArtifactRecords toData();
  
  public abstract FabaoArtifactRecords toBean();
  
  public abstract FabaoArtifactRecords toDataIf();
  
  public abstract FabaoArtifactRecords toBeanIf();
  
  public abstract Map<Integer, FabaoArtifactRecord> getRecords();
  
  public abstract Map<Integer, FabaoArtifactRecord> getRecordsAsData();
  
  public abstract int getEquipped_artifact_class();
  
  public abstract void setEquipped_artifact_class(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FabaoArtifactRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */