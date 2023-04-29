package mzm.gsp.map.main.ai.path;

public abstract interface IPathTypeStrategy
{
  public abstract boolean isEnd();
  
  public abstract int getNextIdx();
  
  public abstract int getCurIdx();
  
  public abstract int nextIdx();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\IPathTypeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */