/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_SetPointRaceTeamSize extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int num;
/*    */   
/*    */   public RGM_SetPointRaceTeamSize(long gmRoleid, int num)
/*    */   {
/* 13 */     this.gmRoleid = gmRoleid;
/* 14 */     this.num = num;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     if ((this.num < 1) || (this.num > 5))
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("数量错误", new Object[0]));
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     CrossBattlePointManager.setTeamSize(this.num);
/*    */     
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置进入积分赛地图队伍成员数量成功|数量=%d", new Object[] { Integer.valueOf(this.num) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\RGM_SetPointRaceTeamSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */