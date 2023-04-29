/*    */ package mzm.gsp.indiana.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.event.ConfirmIndianaNumberDoneArg;
/*    */ import mzm.gsp.grc.event.ConfirmIndianaNumberDoneProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnConfirmIndianaNumberDone
/*    */   extends ConfirmIndianaNumberDoneProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     GameServer.logger().info(String.format("[indiana]POnConfirmIndianaNumberDone.processImp@confirm indiana number done|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|retcode=%d", new Object[] { Long.valueOf(((ConfirmIndianaNumberDoneArg)this.arg).getRoleid()), Integer.valueOf(((ConfirmIndianaNumberDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((ConfirmIndianaNumberDoneArg)this.arg).getTurn()), Integer.valueOf(((ConfirmIndianaNumberDoneArg)this.arg).getSortid()), Integer.valueOf(((ConfirmIndianaNumberDoneArg)this.arg).getNumber()), Integer.valueOf(((ConfirmIndianaNumberDoneArg)this.arg).getRetCode()) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\POnConfirmIndianaNumberDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */