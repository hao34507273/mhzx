/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ public class IntegrityArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int oldIntegrity;
/*    */   public final int newIntegrity;
/*    */   
/*    */   public IntegrityArg(long roleId, int oldIntegrity, int newIntegrity)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.oldIntegrity = oldIntegrity;
/* 13 */     this.newIntegrity = newIntegrity;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\IntegrityArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */