/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PFinishActivity
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int dieMonsterNum;
/*    */   
/*    */   public PFinishActivity(long roleId, int activityId, int dieMonsterNum)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.activityId = activityId;
/* 22 */     this.dieMonsterNum = dieMonsterNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     return LevelGuideManager.finishActivity(this.roleId, this.activityId, this.dieMonsterNum);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PFinishActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */