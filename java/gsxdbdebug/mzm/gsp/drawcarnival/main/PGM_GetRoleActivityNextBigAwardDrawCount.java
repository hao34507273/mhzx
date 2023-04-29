/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.DrawCarnivalRoleActivityInfo;
/*    */ 
/*    */ public class PGM_GetRoleActivityNextBigAwardDrawCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   
/*    */   public PGM_GetRoleActivityNextBigAwardDrawCount(long targetRoleId, long gmRoleId, int activityId)
/*    */   {
/* 14 */     this.targetRoleId = targetRoleId;
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     xbean.DrawCarnivalRoleInfo xDrawCarnivalRoleInfo = xtable.Role2drawcarnivalactivity.get(Long.valueOf(this.targetRoleId));
/* 23 */     if (xDrawCarnivalRoleInfo == null)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色信息不存在");
/* 26 */       return false;
/*    */     }
/* 28 */     DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo = (DrawCarnivalRoleActivityInfo)xDrawCarnivalRoleInfo.getActivity_id2role_info().get(Integer.valueOf(this.activityId));
/*    */     
/* 30 */     if (xDrawCarnivalRoleActivityInfo == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色活动信息不存在");
/* 33 */       return false;
/*    */     }
/* 35 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("下次中元宝大奖需要的最少抽奖次数：%d", new Object[] { Integer.valueOf(xDrawCarnivalRoleActivityInfo.getGet_next_big_award_draw_count()) }));
/*    */     
/*    */ 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_GetRoleActivityNextBigAwardDrawCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */