/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import xbean.LuckyBagInfo;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     long roleid = ((Long)this.arg).longValue();
/*  9 */     int score = 0;
/* 10 */     LuckyBagInfo xLuckyBagInfo = xtable.Role2luckybag.get(Long.valueOf(roleid));
/* 11 */     if (xLuckyBagInfo != null)
/*    */     {
/* 13 */       score = xLuckyBagInfo.getScore();
/*    */     }
/*    */     
/* 16 */     LuckyBagManager.syncLuckyBagExchangeScore(roleid, score);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */