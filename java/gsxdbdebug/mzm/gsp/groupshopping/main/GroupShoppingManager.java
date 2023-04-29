/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.RoleGroupShoppingRecords;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ import xtable.Group_shopping_info;
/*     */ import xtable.Role2group_shopping_records;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GroupShoppingManager
/*     */ {
/*  30 */   static volatile int currentActivityId = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isServerLevelEnough(int activityId)
/*     */   {
/*  37 */     SActivityCfg activityCfg = SActivityCfg.get(activityId);
/*  38 */     if (activityCfg == null)
/*  39 */       return false;
/*  40 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*  41 */     return serverLevel >= activityCfg.serverLevelMin;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGroupShoppingOpen()
/*     */   {
/*  49 */     return OpenInterface.getOpenStatus(504);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBigGroupShoppingOpen()
/*     */   {
/*  57 */     return (isGroupShoppingOpen()) && (OpenInterface.getOpenStatus(507));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBigGroupDirectBuyOpen()
/*     */   {
/*  65 */     return (isGroupShoppingOpen()) && (OpenInterface.getOpenStatus(508));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSmallGroupShoppingOpen()
/*     */   {
/*  73 */     return (isGroupShoppingOpen()) && (OpenInterface.getOpenStatus(505));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSmallGroupDirectBuyOpen()
/*     */   {
/*  81 */     return (isGroupShoppingOpen()) && (OpenInterface.getOpenStatus(506));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static enum GroupShoppingType
/*     */   {
/*  89 */     INVALID,  SMALL,  BIG;
/*     */     
/*     */ 
/*     */     private GroupShoppingType() {}
/*     */   }
/*     */   
/*     */   static GroupShoppingType checkGroupShoppingItemCfgId(int activityId, int groupShoppingItemCfgId)
/*     */   {
/*  97 */     GroupShoppingActivityCfg cfg = GroupShoppingActivityCfg.get(activityId);
/*  98 */     if (cfg == null)
/*  99 */       return GroupShoppingType.INVALID;
/* 100 */     if (cfg.smallGroupItemCfgIds.contains(Integer.valueOf(groupShoppingItemCfgId)))
/* 101 */       return GroupShoppingType.SMALL;
/* 102 */     if (cfg.bigGroupItemCfgIds.contains(Integer.valueOf(groupShoppingItemCfgId))) {
/* 103 */       return GroupShoppingType.BIG;
/*     */     }
/* 105 */     return GroupShoppingType.INVALID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static GroupShoppingInfo getGroupShoppingInfo(int activityId)
/*     */   {
/* 113 */     long key = GameServerInfoManager.toGlobalId(activityId);
/* 114 */     return Group_shopping_info.get(Long.valueOf(key));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SmallGroupShoppingItemInfo getSmallGroupShoppingItemInfo(int activityId, int groupShoppingItemCfgId)
/*     */   {
/* 123 */     GroupShoppingInfo xGroupShoppingInfo = getGroupShoppingInfo(activityId);
/* 124 */     if (xGroupShoppingInfo == null)
/* 125 */       return null;
/* 126 */     return (SmallGroupShoppingItemInfo)xGroupShoppingInfo.getSmall_group_infos().get(Integer.valueOf(groupShoppingItemCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static BigGroupShoppingItemInfo getBigGroupShoppingItemInfo(int activityId, int groupShoppingItemCfgId)
/*     */   {
/* 135 */     GroupShoppingInfo xGroupShoppingInfo = getGroupShoppingInfo(activityId);
/* 136 */     if (xGroupShoppingInfo == null)
/* 137 */       return null;
/* 138 */     return (BigGroupShoppingItemInfo)xGroupShoppingInfo.getBig_group_infos().get(Integer.valueOf(groupShoppingItemCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Long> getIncompletedSmallGroups(int activityId)
/*     */   {
/* 146 */     GroupShoppingInfo xGroupShoppingInfo = getGroupShoppingInfo(activityId);
/* 147 */     if (xGroupShoppingInfo == null)
/* 148 */       return null;
/* 149 */     return xGroupShoppingInfo.getIncompleted_small_groups();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleGroupShoppingRecord getRoleGroupShoppingRecord(long roleId, int activityId)
/*     */   {
/* 157 */     RoleGroupShoppingRecords xRoleGroupShoppingRecords = Role2group_shopping_records.get(Long.valueOf(roleId));
/* 158 */     if (xRoleGroupShoppingRecords == null)
/* 159 */       return null;
/* 160 */     return (RoleGroupShoppingRecord)xRoleGroupShoppingRecords.getRecords().get(Integer.valueOf(activityId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canGetGroupShoppingInfo(long roleId)
/*     */   {
/* 168 */     return RoleStatusInterface.checkCanSetStatus(roleId, 1901, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canCreateShoppingGroup(long roleId)
/*     */   {
/* 176 */     return RoleStatusInterface.checkCanSetStatus(roleId, 1902, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canJoinShoppingGroup(long roleId)
/*     */   {
/* 184 */     return RoleStatusInterface.checkCanSetStatus(roleId, 1903, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canDirectBuy(long roleId)
/*     */   {
/* 192 */     return RoleStatusInterface.checkCanSetStatus(roleId, 1904, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillShoppingGroupInfo(long groupId, xbean.ShoppingGroupInfo xShoppingGroupInfo, mzm.gsp.groupshopping.ShoppingGroupInfo shoppingGroupInfo)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 201 */     shoppingGroupInfo.group_id = groupId;
/* 202 */     shoppingGroupInfo.group_shopping_item_cfgid = xShoppingGroupInfo.getGroup_shopping_item_cfgid();
/* 203 */     shoppingGroupInfo.member_num = xShoppingGroupInfo.getMembers().size();
/* 204 */     shoppingGroupInfo.status = xShoppingGroupInfo.getStatus();
/* 205 */     shoppingGroupInfo.creator_role_id = xShoppingGroupInfo.getCreator_roleid();
/* 206 */     if (shoppingGroupInfo.creator_role_id != 0L)
/* 207 */       shoppingGroupInfo.creator_name.setString(RoleInterface.getName(shoppingGroupInfo.creator_role_id), "UTF-8");
/* 208 */     shoppingGroupInfo.price = xShoppingGroupInfo.getPrice();
/* 209 */     shoppingGroupInfo.close_time = xShoppingGroupInfo.getClose_time();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */