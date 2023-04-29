/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.husong.event.HuSongArg;
/*    */ import mzm.gsp.husong.event.HuSongEventProcedure;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnHuSongEvent
/*    */   extends HuSongEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!((HuSongArg)this.arg).success)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     RoleVigorManager.getInstance().awardAward(((HuSongArg)this.arg).roleid, 5, new TLogArg(LogReason.VIGOR_ADD__HUSONG, 0));
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnHuSongEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */