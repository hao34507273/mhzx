package idip.core;

public abstract interface IDIPCmdCreator<REQ extends IDIPPacket<?>, RSP extends IDIPPacket<?>>
{
  public abstract IDIPCmd<?, ?> create();
  
  public abstract IDIPCmd<?, ?> create(REQ paramREQ, RSP paramRSP);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\core\IDIPCmdCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */