/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     mzm.gsp.activity.confbean.FestivalAwardOwnCfg festivalAwardCfg = FestivalManager.getCurrentFestivalAwardCfg();
/* 10 */     if (festivalAwardCfg == null) {
/* 11 */       return false;
/*    */     }
/* 13 */     xbean.FestivalAward xFestivalAward = xtable.Role2festivalaward.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 14 */     FestivalManager.sendFestivalMail(((RoleLevelUpArg)this.arg).roleId, xFestivalAward, festivalAwardCfg);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */