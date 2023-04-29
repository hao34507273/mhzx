/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ 
/*     */ public class PlantTreeActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*     */   {
/*  21 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  27 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  34 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(roleId));
/*  35 */     if (xRolePlantTreeInfo == null)
/*     */     {
/*  37 */       xRolePlantTreeInfo = Pod.newRolePlantTreeInfo();
/*  38 */       Role_plant_tree_infos.insert(Long.valueOf(roleId), xRolePlantTreeInfo);
/*     */     }
/*  40 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(activityid));
/*  41 */     if (xPlantTreeInfo == null)
/*     */     {
/*  43 */       xPlantTreeInfo = Pod.newPlantTreeInfo();
/*  44 */       xPlantTreeInfo.getSections().put(Integer.valueOf(1), Integer.valueOf(0));
/*  45 */       xPlantTreeInfo.setOnline_reward_point_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*  46 */       xRolePlantTreeInfo.getPlant_tree_infos().put(Integer.valueOf(activityid), xPlantTreeInfo);
/*     */     }
/*     */     
/*  49 */     xPlantTreeInfo.setHas_get_activity_complete_award(false);
/*  50 */     xPlantTreeInfo.setAdd_point_times(0);
/*  51 */     xPlantTreeInfo.setRemove_special_state_award_times(0);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/*  57 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  59 */       return;
/*     */     }
/*  61 */     if (!PlantTreeManager.isPlantTreeSwitchOpen(activityid))
/*     */     {
/*  63 */       return;
/*     */     }
/*  65 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  67 */       PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityid), new PStopActivity(roleid, activityid));
/*     */     }
/*     */     
/*  70 */     StringBuilder sb = new StringBuilder();
/*  71 */     sb.append(String.format("[planttree]PlantTreeActivityHandler.onActivityEnd@plant tree activity end|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityid) }));
/*     */     
/*  73 */     PlantTreeManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  85 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  87 */       return;
/*     */     }
/*  89 */     if (!PlantTreeManager.isPlantTreeSwitchOpen(activityid))
/*     */     {
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     xtable.Activity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*     */     
/*  96 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  98 */       PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityid), new PInitActivity(roleid, activityid));
/*     */     }
/*     */     
/* 101 */     StringBuilder sb = new StringBuilder();
/* 102 */     sb.append(String.format("[planttree]PlantTreeActivityHandler.onActivityStart@plant tree activity start|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityid) }));
/*     */     
/* 104 */     PlantTreeManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PlantTreeActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */