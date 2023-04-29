/*     */ package mzm.gsp.christmasstocking.main;
/*     */ 
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChristmasStockingInterface
/*     */ {
/*     */   public static void addTreeToCourtyard(long ownerRoleId, long partnerRoleId, long homelandWorldId, int courtyardMapCfgId, int courtyardLevel)
/*     */   {
/*  30 */     ChristmasStockingManager.addTreeForRole(ownerRoleId, homelandWorldId, courtyardMapCfgId, courtyardLevel);
/*     */     
/*  32 */     if (partnerRoleId > 0L)
/*     */     {
/*     */ 
/*  35 */       ChristmasStockingManager.addTreeForRole(partnerRoleId, homelandWorldId, courtyardMapCfgId, courtyardLevel);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeTreeFromCourtyard(long ownerRoleId, long partnerRoleId, long homelandWorldId)
/*     */   {
/*  49 */     MapInterface.removeMapEntity(MapEntityType.MET_CHRISTMAS_STOCKING, ownerRoleId, null);
/*  50 */     if (partnerRoleId > 0L)
/*     */     {
/*  52 */       MapInterface.removeMapEntity(MapEntityType.MET_CHRISTMAS_STOCKING, partnerRoleId, null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onHomelandWroldCreate(long ownerRoleId, long partnerRoleId, long homelandWorldId, int courtyardMapCfgId, int courtyardLevel)
/*     */   {
/*  73 */     if ((ChristmasStockingManager.isActivityOpenOrNeedRetain()) && (OpenInterface.getOpenStatus(582)))
/*     */     {
/*     */ 
/*     */ 
/*  77 */       addTreeToCourtyard(ownerRoleId, partnerRoleId, homelandWorldId, courtyardMapCfgId, courtyardLevel);
/*     */     }
/*     */     
/*     */ 
/*  81 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/*  82 */     if ((ActivityInterface.isActivityOpen(activityId)) && (OpenInterface.getOpenStatus(583)))
/*     */     {
/*     */ 
/*     */ 
/*  86 */       ChristmasStockingManager.addStockingToCourtyard(ownerRoleId, partnerRoleId, homelandWorldId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addStockingToCourtyard(long ownerRoleId, long partnerRoleId, long homelandWorldId)
/*     */   {
/*  99 */     String ownerUserId = RoleInterface.getUserId(ownerRoleId);
/* 100 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/*     */     
/* 102 */     ActivityInterface.canJoinAndCheckInitActivityData(ownerUserId, ownerRoleId, activityId);
/* 103 */     if (partnerRoleId > 0L)
/*     */     {
/* 105 */       String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/* 106 */       ActivityInterface.canJoinAndCheckInitActivityData(partnerUserId, partnerRoleId, activityId);
/*     */     }
/*     */     
/* 109 */     ChristmasStockingManager.addStockingToCourtyard(ownerRoleId, partnerRoleId, homelandWorldId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeStockingFromCourtyard(long homelandWorldId)
/*     */   {
/* 119 */     int controllerId = SChristmasStockingHidingConsts.getInstance().CONTROLLER_ID;
/* 120 */     ControllerInterface.collectWorldController(homelandWorldId, controllerId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\ChristmasStockingInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */