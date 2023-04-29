/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import xbean.FightCache;
/*    */ 
/*    */ public class FightMultiOccupHandler implements mzm.gsp.multioccupation.main.MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/*  9 */     return handleChangeOccupation(roleid);
/*    */   }
/*    */   
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 14 */     return handleChangeOccupation(roleid);
/*    */   }
/*    */   
/*    */   private boolean handleChangeOccupation(long roleid) {
/* 18 */     FightCache xCache = xtable.Rolefightcache.get(Long.valueOf(roleid));
/* 19 */     if (xCache != null) {
/* 20 */       xCache.setRole_default_skill(0);
/* 21 */       xCache.setIsauto(false);
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightMultiOccupHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */