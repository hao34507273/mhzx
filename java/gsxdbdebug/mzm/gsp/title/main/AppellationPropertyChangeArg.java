/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AppellationPropertyChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final TitleChangeReasonEnum titleChangeReason;
/*    */   
/*    */ 
/*    */ 
/*    */   public AppellationPropertyChangeArg(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.titleChangeReason = TitleChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public AppellationPropertyChangeArg(long roleId, TitleChangeReasonEnum titleChangeReason)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.titleChangeReason = titleChangeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\AppellationPropertyChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */