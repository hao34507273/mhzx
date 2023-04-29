/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleWorldGoalInfo;
/*    */ import xbean.Section;
/*    */ import xbean.WorldGoal;
/*    */ import xbean.WorldGoalActivityInfo;
/*    */ import xtable.Role2worldgoalinfo;
/*    */ 
/*    */ public class PSendAwardMailOnRoleLogin extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PSendAwardMailOnRoleLogin(long roleid, int activityCfgid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     RoleWorldGoalInfo xRoleWorldGoalInfo = Role2worldgoalinfo.get(Long.valueOf(this.roleid));
/* 31 */     if (xRoleWorldGoalInfo == null)
/*    */     {
/* 33 */       xRoleWorldGoalInfo = Pod.newRoleWorldGoalInfo();
/* 34 */       Role2worldgoalinfo.insert(Long.valueOf(this.roleid), xRoleWorldGoalInfo);
/*    */     }
/* 36 */     WorldGoalActivityInfo xWorldGoalActivityInfo = (WorldGoalActivityInfo)xRoleWorldGoalInfo.getWorld_goal_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*    */     
/* 38 */     if (xWorldGoalActivityInfo == null)
/*    */     {
/* 40 */       xWorldGoalActivityInfo = Pod.newWorldGoalActivityInfo();
/* 41 */       xRoleWorldGoalInfo.getWorld_goal_activity_infos().put(Integer.valueOf(this.activityCfgid), xWorldGoalActivityInfo);
/*    */     }
/*    */     
/*    */ 
/* 45 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 46 */     WorldGoal xWorldGoal = xtable.Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 47 */     if (xWorldGoal == null)
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     Set<Integer> needSendAwardSections = new java.util.HashSet();
/* 52 */     needSendAwardSections.addAll(WorldGoalCfgManager.getAlreadyCompleteSectionid(this.activityCfgid, xWorldGoal.getCurrent_section_id(), ((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getPoint()));
/*    */     
/* 54 */     needSendAwardSections.removeAll(xWorldGoalActivityInfo.getAward_section_ids());
/* 55 */     for (Iterator i$ = needSendAwardSections.iterator(); i$.hasNext();) { int sectionids = ((Integer)i$.next()).intValue();
/*    */       
/* 57 */       RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(this.roleid), new PSendAwardMail(this.roleid, this.activityCfgid, sectionids));
/*    */     }
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PSendAwardMailOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */