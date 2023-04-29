/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardUpgradeArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int cardCfgId;
/*    */   
/*    */   public final int oldLevel;
/*    */   
/*    */   public final int newLevel;
/*    */   
/*    */   public ChangeModelCardUpgradeArg(long roleId, int cardCfgId, int oldLevel, int newLevel)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.cardCfgId = cardCfgId;
/* 18 */     this.oldLevel = oldLevel;
/* 19 */     this.newLevel = newLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardUpgradeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */