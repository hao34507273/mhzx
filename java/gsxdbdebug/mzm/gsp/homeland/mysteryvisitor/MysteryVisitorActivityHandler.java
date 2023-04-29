/*    */ package mzm.gsp.homeland.mysteryvisitor;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.homeland.confbean.SMysteryVisitorTaskCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleMysteryVisitorInfo;
/*    */ import xtable.Role_mystery_visitor_infos;
/*    */ 
/*    */ public class MysteryVisitorActivityHandler implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 23 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 29 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 36 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(roleId));
/* 37 */     if (xRoleMysteryVisitorInfo == null)
/*    */     {
/* 39 */       xRoleMysteryVisitorInfo = Pod.newRoleMysteryVisitorInfo();
/* 40 */       Role_mystery_visitor_infos.insert(Long.valueOf(roleId), xRoleMysteryVisitorInfo);
/*    */     }
/* 42 */     for (SMysteryVisitorTaskCfg cfg : SMysteryVisitorTaskCfg.getAll().values())
/*    */     {
/* 44 */       if (TaskInterface.isHaveGraphId(roleId, cfg.task_graph_id))
/*    */       {
/* 46 */         TaskInterface.closeActivityGraphWithoutEvent(roleId, cfg.task_graph_id);
/*    */       }
/*    */     }
/* 49 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(-1);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 55 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 57 */       return;
/*    */     }
/* 59 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpen())
/*    */     {
/* 61 */       return;
/*    */     }
/* 63 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 65 */       MysteryVisitorTaskOneByOne.getInstance().add(new PClearMysteryVisitor(roleid));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 78 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 80 */       return;
/*    */     }
/* 82 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpen())
/*    */     {
/* 84 */       return;
/*    */     }
/* 86 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 88 */       MysteryVisitorTaskOneByOne.getInstance().add(new PTrySetMysteryVisitor(roleid));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\MysteryVisitorActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */