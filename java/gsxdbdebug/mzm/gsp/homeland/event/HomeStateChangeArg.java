/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HomeStateChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long partnerRoleId;
/*    */   
/*    */ 
/*    */   public final int oldState;
/*    */   
/*    */ 
/*    */   public final int newState;
/*    */   
/*    */ 
/*    */ 
/*    */   public HomeStateChangeArg(long roleId, long partnerRoleid, int oldState, int newState)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.partnerRoleId = partnerRoleid;
/* 26 */     this.oldState = oldState;
/* 27 */     this.newState = newState;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\HomeStateChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */