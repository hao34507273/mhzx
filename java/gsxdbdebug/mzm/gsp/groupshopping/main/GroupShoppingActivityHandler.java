/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.RoleGroupShoppingRecords;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xtable.Role2group_shopping_records;
/*     */ 
/*     */ class GroupShoppingActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  19 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*     */   {
/*  25 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityId)
/*     */   {
/*  31 */     new ROnActivityStart(activityStartType, activityId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityId) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(final int activityId)
/*     */   {
/*  44 */     GroupShoppingManager.currentActivityId = 0;
/*     */     
/*     */ 
/*  47 */     IncompletedSmallGroupChartManager.clear();
/*     */     
/*  49 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  55 */         GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(activityId);
/*  56 */         if (xGroupShoppingInfo == null) {
/*  57 */           return false;
/*     */         }
/*     */         
/*     */ 
/*  61 */         for (BigGroupShoppingItemInfo xBigGroupShoppingItemInfo : xGroupShoppingInfo.getBig_group_infos().values())
/*     */         {
/*  63 */           long groupId = xBigGroupShoppingItemInfo.getGroup_id();
/*  64 */           if (groupId != 0L)
/*     */           {
/*  66 */             ShoppingGroupInfo xShoppingGroupInfo = xtable.Shopping_group_info.select(Long.valueOf(groupId));
/*  67 */             if (xShoppingGroupInfo == null)
/*     */             {
/*  69 */               xBigGroupShoppingItemInfo.setGroup_id(0L);
/*     */             }
/*  71 */             else if (xShoppingGroupInfo.getStatus() == 0)
/*     */             {
/*  73 */               NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, groupId, false, false, false));
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  80 */         for (Long groupId : xGroupShoppingInfo.getIncompleted_small_groups()) {
/*  81 */           NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, groupId.longValue(), false, false, false));
/*     */         }
/*     */         
/*  84 */         return true;
/*     */       }
/*  86 */     }.execute();
/*  87 */     GroupShoppingLogger.info("GroupShoppingActivityHandler.onActivityEnd()@done|activity_id=%d", new Object[] { Integer.valueOf(activityId) });
/*     */   }
/*     */   
/*     */ 
/*     */   public void initData(String userId, long roleId, int turn, int activityId)
/*     */   {
/*  93 */     RoleGroupShoppingRecords xRoleRecords = Role2group_shopping_records.get(Long.valueOf(roleId));
/*  94 */     if (xRoleRecords == null)
/*     */     {
/*  96 */       xRoleRecords = Pod.newRoleGroupShoppingRecords();
/*  97 */       Role2group_shopping_records.add(Long.valueOf(roleId), xRoleRecords);
/*     */     }
/*  99 */     RoleGroupShoppingRecord xRoleRecord = Pod.newRoleGroupShoppingRecord();
/* 100 */     xRoleRecords.getRecords().put(Integer.valueOf(activityId), xRoleRecord);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */