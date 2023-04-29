/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HomeLevelUpArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean isOwner;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int oldHomeLevel;
/*    */   
/*    */ 
/*    */   public final int newHomeLevel;
/*    */   
/*    */ 
/*    */ 
/*    */   public HomeLevelUpArg(long roleId, boolean isOwner, int oldHomeLevel, int newHomeLevel)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.isOwner = isOwner;
/* 27 */     this.oldHomeLevel = oldHomeLevel;
/* 28 */     this.newHomeLevel = newHomeLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\HomeLevelUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */