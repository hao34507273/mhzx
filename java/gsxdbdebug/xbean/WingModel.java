package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface WingModel
  extends Bean
{
  public abstract WingModel copy();
  
  public abstract WingModel toData();
  
  public abstract WingModel toBean();
  
  public abstract WingModel toDataIf();
  
  public abstract WingModel toBeanIf();
  
  public abstract List<ModelId2DyeId> getModels();
  
  public abstract List<ModelId2DyeId> getModelsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */