/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveRunnable;
/*    */ 
/*    */ public class ROnGangDissolveForChatContentBuffer
/*    */   extends GangDissolveRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 12 */     FactionChatContentBufferManager.getInstance().onGangDissolve(((GangArg)this.arg).gangId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ROnGangDissolveForChatContentBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */