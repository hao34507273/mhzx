/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AppOrTitleChangeArg
/*    */ {
/*    */   public long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int id;
/*    */   
/*    */ 
/*    */ 
/*    */   public int changeType;
/*    */   
/*    */ 
/*    */ 
/*    */   public int oldId;
/*    */   
/*    */ 
/*    */ 
/*    */   public String appString;
/*    */   
/*    */ 
/*    */ 
/*    */   public TitleChangeReasonEnum changeReason;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public AppOrTitleChangeArg(long roleId, int id, int changeType, int oldId)
/*    */   {
/* 37 */     this.roleId = roleId;
/* 38 */     this.id = id;
/* 39 */     this.changeType = changeType;
/* 40 */     this.oldId = oldId;
/* 41 */     this.appString = "";
/* 42 */     this.changeReason = TitleChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */ 
/*    */   public AppOrTitleChangeArg(long roleId, int id, int changeType, int oldId, TitleChangeReasonEnum titleChangeReasonEnum)
/*    */   {
/* 48 */     this.roleId = roleId;
/* 49 */     this.id = id;
/* 50 */     this.changeType = changeType;
/* 51 */     this.oldId = oldId;
/* 52 */     this.appString = "";
/* 53 */     this.changeReason = titleChangeReasonEnum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean isRemove()
/*    */   {
/* 63 */     return this.id <= 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\AppOrTitleChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */