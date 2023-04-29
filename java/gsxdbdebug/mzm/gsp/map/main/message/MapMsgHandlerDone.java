package mzm.gsp.map.main.message;

abstract interface MapMsgHandlerDone<T extends AbstractMapMsgHandler>
{
  public abstract boolean isCallInProcedure();
  
  public abstract boolean onMapMsgHandlerDone(T paramT)
    throws Exception;
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MapMsgHandlerDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */