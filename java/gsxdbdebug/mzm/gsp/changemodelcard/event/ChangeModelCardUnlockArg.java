/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardUnlockArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int cardCfgId;
/*    */   
/*    */   public final int cardLevel;
/*    */   
/*    */   public ChangeModelCardUnlockArg(long roleId, int cardCfgId, int cardLevel)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.cardCfgId = cardCfgId;
/* 16 */     this.cardLevel = cardLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardUnlockArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */