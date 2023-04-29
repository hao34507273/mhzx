/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import mzm.gsp.children.SAttendPreparePregnancyFail;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnInviteSessionTimeOut
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long inviterid;
/*    */   private final long inviteeid;
/*    */   
/*    */   public POnInviteSessionTimeOut(long inviterid, long inviteeid)
/*    */   {
/* 18 */     this.inviterid = inviterid;
/* 19 */     this.inviteeid = inviteeid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     SAttendPreparePregnancyFail protocol = new SAttendPreparePregnancyFail();
/* 26 */     protocol.res = 8;
/* 27 */     OnlineManager.getInstance().send(this.inviterid, protocol);
/*    */     
/* 29 */     StringBuilder sb = new StringBuilder();
/* 30 */     sb.append(String.format("[prepare_pregnancy]POnInviteSessionTimeOut.processImp@attend prepare pregnancy invite timeout|inviterid=%d|inviteeid=%d", new Object[] { Long.valueOf(this.inviterid), Long.valueOf(this.inviteeid) }));
/*    */     
/*    */ 
/* 33 */     PreparePregnancyManager.logger.info(sb.toString());
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\POnInviteSessionTimeOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */