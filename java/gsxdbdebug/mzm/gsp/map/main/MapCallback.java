package mzm.gsp.map.main;

public abstract interface MapCallback<T>
{
  public abstract boolean isCallInProcedure();
  
  public abstract boolean onResult(T paramT);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */