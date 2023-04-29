/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ public abstract class AbsActivity
/*    */ {
/*    */   int activityId;
/*    */   int graphId;
/*    */   
/*    */   public AbsActivity(int activityId, int graphId) {
/*  9 */     this.activityId = activityId;
/* 10 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */   public abstract void accept(AbsTaskState paramAbsTaskState);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\AbsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */