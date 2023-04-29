/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangCombineArg;
/*    */ import mzm.gsp.gang.event.GangCombineRunnable;
/*    */ 
/*    */ 
/*    */ public class ROnGangCombineForChatContentBuffer
/*    */   extends GangCombineRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 13 */     FactionChatContentBufferManager.getInstance().onGangDissolve(((GangCombineArg)this.arg).viceGangid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ROnGangCombineForChatContentBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */