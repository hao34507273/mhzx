package mzm.gsp.effect.main;

public abstract interface Effect<T>
{
  public abstract boolean attach(T paramT);
  
  public abstract boolean detach(T paramT);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\Effect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */