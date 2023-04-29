/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.DrawCarnivalRoleActivityInfo;
/*    */ import xbean.DrawCarnivalRoleInfo;
/*    */ 
/*    */ public class PGM_SetRoleActivityNextBigAwardDrawCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int nextBigAwardDrawCount;
/*    */   
/*    */   public PGM_SetRoleActivityNextBigAwardDrawCount(long targetRoleId, long gmRoleId, int activityId, int nextBigAwardDrawCount)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.activityId = activityId;
/* 19 */     this.nextBigAwardDrawCount = nextBigAwardDrawCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     DrawCarnivalRoleInfo xDrawCarnivalRoleInfo = xtable.Role2drawcarnivalactivity.get(Long.valueOf(this.targetRoleId));
/* 26 */     if (xDrawCarnivalRoleInfo == null)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色信息不存在");
/* 29 */       return false;
/*    */     }
/* 31 */     DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo = (DrawCarnivalRoleActivityInfo)xDrawCarnivalRoleInfo.getActivity_id2role_info().get(Integer.valueOf(this.activityId));
/*    */     
/* 33 */     if (xDrawCarnivalRoleActivityInfo == null)
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色活动信息不存在");
/* 36 */       return false;
/*    */     }
/* 38 */     xDrawCarnivalRoleActivityInfo.setGet_next_big_award_draw_count(this.nextBigAwardDrawCount);
/* 39 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置成功");
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_SetRoleActivityNextBigAwardDrawCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */