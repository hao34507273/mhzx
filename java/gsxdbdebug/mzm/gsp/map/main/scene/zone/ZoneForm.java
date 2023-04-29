package mzm.gsp.map.main.scene.zone;

import mzm.gsp.map.main.scene.Position;

public abstract interface ZoneForm
{
  public abstract boolean test(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean test(Position paramPosition);
  
  public abstract boolean intersectsRectangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\ZoneForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */