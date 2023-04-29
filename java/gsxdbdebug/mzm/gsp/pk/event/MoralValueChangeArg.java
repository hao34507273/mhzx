/*    */ package mzm.gsp.pk.event;
/*    */ 
/*    */ public class MoralValueChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int oldValue;
/*    */   public final int newValue;
/*    */   
/*    */   public MoralValueChangeArg(long roleId, int oldValue, int newValue)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.oldValue = oldValue;
/* 13 */     this.newValue = newValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\event\MoralValueChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */