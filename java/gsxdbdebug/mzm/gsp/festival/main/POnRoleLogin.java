/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import xbean.FestivalAward;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     mzm.gsp.activity.confbean.FestivalAwardOwnCfg festivalAwardCfg = FestivalManager.getCurrentFestivalAwardCfg();
/* 10 */     if (festivalAwardCfg == null) {
/* 11 */       return false;
/*    */     }
/* 13 */     FestivalAward xFestivalAward = xtable.Role2festivalaward.get((Long)this.arg);
/* 14 */     FestivalManager.sendFestivalMail(((Long)this.arg).longValue(), xFestivalAward, festivalAwardCfg);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */