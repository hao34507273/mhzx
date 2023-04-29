/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCommitItemSumAwardCfg;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleWorldGoalInfo;
/*    */ import xbean.WorldGoalActivityInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2worldgoalinfo;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PSendCommitItemSumAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PSendCommitItemSumAward(long roleid, int activityCfgid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!WorldGoalManager.isWorldGoalSwitchOpenForRole(this.roleid, this.activityCfgid))
/*    */     {
/*    */ 
/* 32 */       WorldGoalManager.logger.info(String.format("[worldgoal]PSendCommitItemSumAward.processImp@module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 34 */       return false;
/*    */     }
/* 36 */     SWorldGoalCommitItemSumAwardCfg cfg = SWorldGoalCommitItemSumAwardCfg.get(this.activityCfgid);
/* 37 */     if (cfg == null)
/*    */     {
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*    */     
/* 44 */     lock(Lockeys.get(User.getTable(), userid));
/* 45 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 47 */     RoleWorldGoalInfo xRoleWorldGoalInfo = Role2worldgoalinfo.get(Long.valueOf(this.roleid));
/* 48 */     if (xRoleWorldGoalInfo == null)
/*    */     {
/* 50 */       xRoleWorldGoalInfo = Pod.newRoleWorldGoalInfo();
/* 51 */       Role2worldgoalinfo.insert(Long.valueOf(this.roleid), xRoleWorldGoalInfo);
/*    */     }
/* 53 */     WorldGoalActivityInfo xWorldGoalActivityInfo = (WorldGoalActivityInfo)xRoleWorldGoalInfo.getWorld_goal_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*    */     
/* 55 */     if (xWorldGoalActivityInfo == null)
/*    */     {
/* 57 */       xWorldGoalActivityInfo = Pod.newWorldGoalActivityInfo();
/* 58 */       xRoleWorldGoalInfo.getWorld_goal_activity_infos().put(Integer.valueOf(this.activityCfgid), xWorldGoalActivityInfo);
/*    */     }
/* 60 */     if (xWorldGoalActivityInfo.getHas_try_send_commit_item_sum_award() == true)
/*    */     {
/*    */ 
/* 63 */       return false;
/*    */     }
/* 65 */     Map.Entry<Integer, Integer> entry = cfg.trigger_nums.floorEntry(Integer.valueOf(xWorldGoalActivityInfo.getCommit_item_sum()));
/* 66 */     if (entry != null)
/*    */     {
/* 68 */       AwardReason awardReason = new AwardReason(mzm.gsp.tlog.LogReason.WORLD_GOAL_COMMIT_ITEM_SUM_AWARD, this.activityCfgid);
/* 69 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(((Integer)entry.getValue()).intValue(), userid, this.roleid, false, true, awardReason);
/* 70 */       if (awardModel == null)
/*    */       {
/*    */ 
/* 73 */         return false;
/*    */       }
/*    */     }
/* 76 */     xWorldGoalActivityInfo.setHas_try_send_commit_item_sum_award(true);
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PSendCommitItemSumAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */