/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGM_SetEntertRoundRobinMapTeamMemberNum
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int num;
/*    */   
/*    */   public RGM_SetEntertRoundRobinMapTeamMemberNum(long gmRoleid, int num)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.num = num;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 25 */     if ((this.num < 1) || (this.num > 5))
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("数量错误", new Object[0]));
/* 28 */       return;
/*    */     }
/* 30 */     CrossBattleConsts.getInstance().ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM = this.num;
/* 31 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置进入循环赛地图队伍成员数量成功|数量=%d", new Object[] { Integer.valueOf(this.num) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RGM_SetEntertRoundRobinMapTeamMemberNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */