/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.ActivityData;
/*    */ import mzm.gsp.activity.SynActivityChangeRes;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.main.RoleTask;
/*    */ import mzm.gsp.task.main.RoleTaskManager;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Activity;
/*    */ import xbean.ActivityBean;
/*    */ import xbean.TaskBean;
/*    */ import xtable.Role2activity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ClearZhenyao
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearZhenyao(long roleid)
/*    */   {
/* 30 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     List<Long> roleList = TeamInterface.getTeamMemberList(TeamInterface.getTeamidByRoleid(this.roleid, true).longValue(), true);
/* 38 */     for (Long roleID : roleList)
/*    */     {
/* 40 */       Activity activity = Role2activity.get(roleID);
/* 41 */       if (activity == null)
/*    */       {
/* 43 */         return true;
/*    */       }
/* 45 */       ActivityBean activityBean = (ActivityBean)activity.getActivitymap().get(Integer.valueOf(ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID));
/* 46 */       if (activityBean == null)
/*    */       {
/* 48 */         return true;
/*    */       }
/* 50 */       activityBean.setCount(0);
/* 51 */       activityBean.setRecommendrewarded(false);
/* 52 */       TaskInterface.closeActivityGraphWithoutEvent(roleID.longValue(), ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID);
/*    */       
/* 54 */       SynActivityChangeRes activityChangeRes = new SynActivityChangeRes();
/* 55 */       fillActivityData(ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, activityChangeRes.activityinfo);
/* 56 */       OnlineManager.getInstance().send(this.roleid, activityChangeRes);
/* 57 */       RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleid, true);
/* 58 */       for (TaskBean taskBean : roleTask.getAllTaskBean())
/*    */       {
/* 60 */         RoleTaskManager.sendUpdateTaskState(this.roleid, ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID, taskBean.getTaskid(), 4);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 65 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private static void fillActivityData(int activityId, ActivityData activityData)
/*    */   {
/* 71 */     activityData.actvityid = activityId;
/* 72 */     activityData.count = 0;
/* 73 */     activityData.awarded = 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\PGM_ClearZhenyao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */