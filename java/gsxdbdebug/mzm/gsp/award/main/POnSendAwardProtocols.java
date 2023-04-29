/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import mzm.gsp.award.event.SendAwardProtocolsEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnSendAwardProtocols
/*    */   extends SendAwardProtocolsEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     ((NeedSendProtocolsArg)this.arg).sendNeedSendProtocols();
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\POnSendAwardProtocols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */