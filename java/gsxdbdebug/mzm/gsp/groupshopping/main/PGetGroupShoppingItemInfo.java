/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.groupshopping.SGetBigGroupShoppingItemInfoRes;
/*     */ import mzm.gsp.groupshopping.SGetSmallGroupShoppingItemInfoRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ 
/*     */ public class PGetGroupShoppingItemInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int groupShoppingItemCfgId;
/*     */   
/*     */   public PGetGroupShoppingItemInfo(long roleId, int groupShoppingItemCfgId)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     int activityId = GroupShoppingManager.currentActivityId;
/*  30 */     if (activityId == 0)
/*     */     {
/*  32 */       GroupShoppingTaskManager.onTaskFinished();
/*  33 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  37 */     if (!GroupShoppingManager.isGroupShoppingOpen())
/*     */     {
/*  39 */       GroupShoppingTaskManager.onTaskFinished();
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (!GroupShoppingManager.isServerLevelEnough(activityId))
/*     */     {
/*  46 */       GroupShoppingTaskManager.onTaskFinished();
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!GroupShoppingManager.canGetGroupShoppingInfo(this.roleId))
/*     */     {
/*  53 */       GroupShoppingTaskManager.onTaskFinished();
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (GroupShoppingBanInterface.isBanned(activityId, this.groupShoppingItemCfgId))
/*     */     {
/*  60 */       GroupShoppingTaskManager.onTaskFinished();
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  66 */     if (userId == null)
/*     */     {
/*  68 */       GroupShoppingTaskManager.onTaskFinished();
/*  69 */       return false;
/*     */     }
/*  71 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin())
/*     */     {
/*  73 */       GroupShoppingTaskManager.onTaskFinished();
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, this.groupShoppingItemCfgId);
/*  78 */     if (type == GroupShoppingManager.GroupShoppingType.SMALL) {
/*  79 */       return processSmallGroupShoppingItemInfo(activityId);
/*     */     }
/*  81 */     return processBigGroupShoppingItemInfo(activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processSmallGroupShoppingItemInfo(int activityId)
/*     */   {
/*  89 */     RoleGroupShoppingRecord xRoleRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/*  90 */     if (xRoleRecord == null)
/*     */     {
/*  92 */       GroupShoppingTaskManager.onTaskFinished();
/*  93 */       return false;
/*     */     }
/*  95 */     SmallGroupShoppingItemInfo xSmallGroupShoppingItemInfo = GroupShoppingManager.getSmallGroupShoppingItemInfo(activityId, this.groupShoppingItemCfgId);
/*     */     
/*  97 */     if (xSmallGroupShoppingItemInfo == null)
/*     */     {
/*  99 */       GroupShoppingTaskManager.onTaskFinished();
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     SGetSmallGroupShoppingItemInfoRes res = new SGetSmallGroupShoppingItemInfoRes();
/* 104 */     res.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 105 */     if (xSmallGroupShoppingItemInfo.getTotal_num() == 0) {
/* 106 */       res.remaining_num = -1;
/*     */     } else {
/* 108 */       res.remaining_num = (xSmallGroupShoppingItemInfo.getRemaining_num() < 0 ? 0 : xSmallGroupShoppingItemInfo.getRemaining_num());
/*     */     }
/* 110 */     res.bought_num = (xRoleRecord.getBought_num_map().containsKey(Integer.valueOf(this.groupShoppingItemCfgId)) ? ((Integer)xRoleRecord.getBought_num_map().get(Integer.valueOf(this.groupShoppingItemCfgId))).intValue() : 0);
/*     */     
/* 112 */     res.shopping_group_num = IncompletedSmallGroupChartManager.getSize(this.groupShoppingItemCfgId);
/* 113 */     OnlineManager.getInstance().send(this.roleId, res);
/* 114 */     GroupShoppingLogger.info("PGetGroupShoppingItemInfo.processSmallGroupShoppingItemInfo()@done|roleid=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.groupShoppingItemCfgId) });
/*     */     
/* 116 */     GroupShoppingTaskManager.onTaskFinished();
/* 117 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processBigGroupShoppingItemInfo(int activityId)
/*     */   {
/* 125 */     RoleGroupShoppingRecord xRoleRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/* 126 */     if (xRoleRecord == null)
/*     */     {
/* 128 */       GroupShoppingTaskManager.onTaskFinished();
/* 129 */       return false;
/*     */     }
/* 131 */     BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = GroupShoppingManager.getBigGroupShoppingItemInfo(activityId, this.groupShoppingItemCfgId);
/*     */     
/* 133 */     if (xBigGroupShoppingItemInfo == null)
/*     */     {
/* 135 */       GroupShoppingTaskManager.onTaskFinished();
/* 136 */       return false;
/*     */     }
/* 138 */     ShoppingGroupInfo xShoppingGroupInfo = xtable.Shopping_group_info.select(Long.valueOf(xBigGroupShoppingItemInfo.getGroup_id()));
/*     */     
/*     */ 
/* 141 */     SGetBigGroupShoppingItemInfoRes res = new SGetBigGroupShoppingItemInfoRes();
/* 142 */     res.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 143 */     if (xBigGroupShoppingItemInfo.getTotal_num() == 0) {
/* 144 */       res.remaining_num = -1;
/*     */     } else {
/* 146 */       res.remaining_num = (xBigGroupShoppingItemInfo.getRemaining_num() < 0 ? 0 : xBigGroupShoppingItemInfo.getRemaining_num());
/*     */     }
/* 148 */     res.bought_num = (xRoleRecord.getBought_num_map().containsKey(Integer.valueOf(this.groupShoppingItemCfgId)) ? ((Integer)xRoleRecord.getBought_num_map().get(Integer.valueOf(this.groupShoppingItemCfgId))).intValue() : 0);
/*     */     
/* 150 */     res.group_id = xBigGroupShoppingItemInfo.getGroup_id();
/* 151 */     res.member_num = (xShoppingGroupInfo == null ? 0 : xShoppingGroupInfo.getMembers().size());
/* 152 */     OnlineManager.getInstance().send(this.roleId, res);
/* 153 */     GroupShoppingLogger.info("PGetGroupShoppingItemInfo.processBigGroupShoppingItemInfo()@done|roleid=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.groupShoppingItemCfgId) });
/*     */     
/* 155 */     GroupShoppingTaskManager.onTaskFinished();
/* 156 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PGetGroupShoppingItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */