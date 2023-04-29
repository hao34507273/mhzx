/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.groupshopping.SBroadcastGroupShoppingBanChanged;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingBanInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xtable.Group_shopping_ban_info;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GroupShoppingBanInterface
/*     */ {
/*     */   public static boolean isBanned(int activityId, int groupShoppingItemCfgId)
/*     */   {
/*  24 */     GroupShoppingBanInfo xGroupShoppingBanInfo = Group_shopping_ban_info.select(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)));
/*     */     
/*  26 */     if (xGroupShoppingBanInfo == null)
/*  27 */       return false;
/*  28 */     return xGroupShoppingBanInfo.getBanned_group_shopping_items().contains(Integer.valueOf(groupShoppingItemCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean ban(int activityId, int groupShoppingItemCfgId)
/*     */   {
/*  36 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, groupShoppingItemCfgId);
/*  37 */     if (type == GroupShoppingManager.GroupShoppingType.INVALID) {
/*  38 */       return false;
/*     */     }
/*  40 */     GroupShoppingBanInfo xGroupShoppingBanInfo = Group_shopping_ban_info.get(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)));
/*     */     
/*  42 */     if (xGroupShoppingBanInfo == null)
/*     */     {
/*  44 */       xGroupShoppingBanInfo = Pod.newGroupShoppingBanInfo();
/*  45 */       Group_shopping_ban_info.add(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)), xGroupShoppingBanInfo);
/*     */     }
/*  47 */     if (xGroupShoppingBanInfo.getBanned_group_shopping_items().add(Integer.valueOf(groupShoppingItemCfgId)))
/*     */     {
/*     */ 
/*  50 */       if (activityId == GroupShoppingManager.currentActivityId)
/*     */       {
/*  52 */         scheduleCloseBannedGroupShopping(activityId, groupShoppingItemCfgId);
/*  53 */         SBroadcastGroupShoppingBanChanged broadcast = new SBroadcastGroupShoppingBanChanged();
/*  54 */         broadcast.info.id = groupShoppingItemCfgId;
/*  55 */         broadcast.info.is_ban = 1;
/*  56 */         OnlineManager.getInstance().sendAll(broadcast);
/*     */       }
/*  58 */       GroupShoppingLogger.info("GroupShoppingBanInterface.ban()@done|activity_id=%d|group_shopping_item_cfgid=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(groupShoppingItemCfgId) });
/*     */     }
/*     */     
/*  61 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unban(int activityId, int groupShoppingItemCfgId)
/*     */   {
/*  69 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, groupShoppingItemCfgId);
/*  70 */     if (type == GroupShoppingManager.GroupShoppingType.INVALID) {
/*  71 */       return false;
/*     */     }
/*  73 */     GroupShoppingBanInfo xGroupShoppingBanInfo = Group_shopping_ban_info.get(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)));
/*     */     
/*  75 */     if (xGroupShoppingBanInfo == null)
/*  76 */       return true;
/*  77 */     if (xGroupShoppingBanInfo.getBanned_group_shopping_items().remove(Integer.valueOf(groupShoppingItemCfgId)))
/*     */     {
/*     */ 
/*  80 */       if (activityId == GroupShoppingManager.currentActivityId)
/*     */       {
/*  82 */         scheduleRestartBigGroupShopping(activityId, groupShoppingItemCfgId);
/*  83 */         SBroadcastGroupShoppingBanChanged broadcast = new SBroadcastGroupShoppingBanChanged();
/*  84 */         broadcast.info.id = groupShoppingItemCfgId;
/*  85 */         broadcast.info.is_ban = 0;
/*  86 */         OnlineManager.getInstance().sendAll(broadcast);
/*     */       }
/*  88 */       GroupShoppingLogger.info("GroupShoppingBanInterface.unban()@done|activity_id=%d|group_shopping_item_cfgid=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(groupShoppingItemCfgId) });
/*     */     }
/*     */     
/*  91 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getBannedSet(int activityId)
/*     */   {
/*  99 */     Set<Integer> banned = Group_shopping_ban_info.selectBanned_group_shopping_items(Long.valueOf(GameServerInfoManager.toGlobalId(activityId)));
/*     */     
/* 101 */     if (banned == null)
/* 102 */       return Collections.emptySet();
/* 103 */     return banned;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void scheduleCloseBannedGroupShopping(int activityId, int groupShoppingItemCfgId)
/*     */   {
/* 111 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, groupShoppingItemCfgId);
/* 112 */     if (type == GroupShoppingManager.GroupShoppingType.INVALID) {
/* 113 */       return;
/*     */     }
/*     */     
/* 116 */     GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(activityId);
/* 117 */     if (xGroupShoppingInfo == null) {
/* 118 */       return;
/*     */     }
/* 120 */     if (type == GroupShoppingManager.GroupShoppingType.BIG)
/*     */     {
/*     */ 
/* 123 */       BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = (BigGroupShoppingItemInfo)xGroupShoppingInfo.getBig_group_infos().get(Integer.valueOf(groupShoppingItemCfgId));
/*     */       
/* 125 */       if ((xBigGroupShoppingItemInfo != null) && (xBigGroupShoppingItemInfo.getGroup_id() != 0L))
/*     */       {
/* 127 */         ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(Long.valueOf(xBigGroupShoppingItemInfo.getGroup_id()));
/*     */         
/* 129 */         if (xShoppingGroupInfo == null)
/*     */         {
/* 131 */           xBigGroupShoppingItemInfo.setGroup_id(0L);
/*     */         }
/* 133 */         else if (xShoppingGroupInfo.getStatus() == 0)
/*     */         {
/* 135 */           NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, xBigGroupShoppingItemInfo.getGroup_id(), true, true, true));
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 143 */       for (Long groupId : IncompletedSmallGroupChartManager.getGroupIds(groupShoppingItemCfgId))
/* 144 */         NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, groupId.longValue(), true, true, true));
/*     */     }
/* 146 */     GroupShoppingLogger.info("GroupShoppingBanInterface.scheduleCloseBannedGroupShopping()@done|activity_id=%d|group_shopping_item_cfgid=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(groupShoppingItemCfgId) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void scheduleRestartBigGroupShopping(int activityId, int groupShoppingItemCfgId)
/*     */   {
/* 155 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, groupShoppingItemCfgId);
/* 156 */     if (type != GroupShoppingManager.GroupShoppingType.BIG)
/* 157 */       return;
/* 158 */     NoneRealTimeTaskManager.getInstance().addTask(new PCreateBigShoppingGroup(activityId, groupShoppingItemCfgId, true));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingBanInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */