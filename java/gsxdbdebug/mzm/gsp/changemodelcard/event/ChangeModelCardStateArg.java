/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardStateArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int cardCfgId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int cardLevel;
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean visible;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ChangeModelCardStateArg(long roleId, int cardCfgId, int cardLevel, boolean visible)
/*    */   {
/* 30 */     this.roleId = roleId;
/* 31 */     this.cardCfgId = cardCfgId;
/* 32 */     this.cardLevel = cardLevel;
/* 33 */     this.visible = visible;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardStateArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */