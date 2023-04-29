/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.groupshopping.SBroadcastShoppingGroupCreated;
/*     */ import mzm.gsp.groupshopping.SCreateShoppingGroupFail;
/*     */ import mzm.gsp.groupshopping.SCreateShoppingGroupSuccess;
/*     */ import mzm.gsp.groupshopping.confbean.SSmallGroupShoppingItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ public class PCreateSmallShoppingGroup extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int groupShoppingItemCfgId;
/*     */   private final long currentYuanbao;
/*     */   
/*     */   public PCreateSmallShoppingGroup(long roleId, int groupShoppingItemCfgId, long currentYuanbao)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*  34 */     this.currentYuanbao = currentYuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     int activityId = GroupShoppingManager.currentActivityId;
/*  42 */     if (activityId == 0)
/*     */     {
/*  44 */       GroupShoppingTaskManager.onTaskFinished();
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (!GroupShoppingManager.isSmallGroupShoppingOpen())
/*     */     {
/*  51 */       GroupShoppingTaskManager.onTaskFinished();
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (!GroupShoppingManager.isServerLevelEnough(activityId))
/*     */     {
/*  58 */       GroupShoppingTaskManager.onTaskFinished();
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!GroupShoppingManager.canCreateShoppingGroup(this.roleId))
/*     */     {
/*  65 */       GroupShoppingTaskManager.onTaskFinished();
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (GroupShoppingBanInterface.isBanned(activityId, this.groupShoppingItemCfgId))
/*     */     {
/*  72 */       GroupShoppingTaskManager.onTaskFinished();
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, this.groupShoppingItemCfgId);
/*  78 */     if (type != GroupShoppingManager.GroupShoppingType.SMALL)
/*     */     {
/*  80 */       GroupShoppingTaskManager.onTaskFinished();
/*  81 */       return false;
/*     */     }
/*  83 */     SSmallGroupShoppingItemCfg groupShoppingItemCfg = SSmallGroupShoppingItemCfg.get(this.groupShoppingItemCfgId);
/*  84 */     if (groupShoppingItemCfg == null)
/*     */     {
/*  86 */       GroupShoppingTaskManager.onTaskFinished();
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     String userId = RoleInterface.getUserId(this.roleId);
/*  92 */     if (userId == null)
/*     */     {
/*  94 */       GroupShoppingTaskManager.onTaskFinished();
/*  95 */       return false;
/*     */     }
/*  97 */     long balance = QingfuInterface.getBalance(userId, true);
/*  98 */     if (balance != this.currentYuanbao)
/*     */     {
/* 100 */       GroupShoppingTaskManager.onTaskFinished();
/* 101 */       return false;
/*     */     }
/* 103 */     if (balance < groupShoppingItemCfg.groupPrice)
/*     */     {
/* 105 */       onFail(1);
/* 106 */       GroupShoppingTaskManager.onTaskFinished();
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin())
/*     */     {
/* 113 */       GroupShoppingTaskManager.onTaskFinished();
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     RoleGroupShoppingRecord xRoleGroupShoppingRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/*     */     
/* 120 */     if (xRoleGroupShoppingRecord == null)
/*     */     {
/* 122 */       GroupShoppingTaskManager.onTaskFinished();
/* 123 */       return false;
/*     */     }
/* 125 */     Integer boughtNum = (Integer)xRoleGroupShoppingRecord.getBought_num_map().get(Integer.valueOf(this.groupShoppingItemCfgId));
/* 126 */     if (boughtNum == null)
/* 127 */       boughtNum = Integer.valueOf(0);
/* 128 */     if ((groupShoppingItemCfg.maxBuyNum > 0) && (boughtNum.intValue() >= groupShoppingItemCfg.maxBuyNum))
/*     */     {
/* 130 */       onFail(4);
/* 131 */       GroupShoppingTaskManager.onTaskFinished();
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 137 */     SmallGroupShoppingItemInfo xSmallGroupShoppingItemInfo = GroupShoppingManager.getSmallGroupShoppingItemInfo(activityId, this.groupShoppingItemCfgId);
/*     */     
/* 139 */     if (GroupShoppingManager.currentActivityId == 0)
/*     */     {
/* 141 */       GroupShoppingTaskManager.onTaskFinished();
/* 142 */       return false;
/*     */     }
/* 144 */     if (xSmallGroupShoppingItemInfo == null)
/*     */     {
/* 146 */       GroupShoppingTaskManager.onTaskFinished();
/* 147 */       return false;
/*     */     }
/* 149 */     if ((xSmallGroupShoppingItemInfo.getTotal_num() > 0) && (xSmallGroupShoppingItemInfo.getRemaining_num() <= 0))
/*     */     {
/* 151 */       onFail(2);
/* 152 */       GroupShoppingTaskManager.onTaskFinished();
/* 153 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 157 */     for (Long groupId : xRoleGroupShoppingRecord.getParticipating_groups())
/*     */     {
/* 159 */       ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(groupId);
/* 160 */       if (xShoppingGroupInfo != null)
/*     */       {
/* 162 */         if (xShoppingGroupInfo.getGroup_shopping_item_cfgid() == this.groupShoppingItemCfgId)
/*     */         {
/* 164 */           onFail(3);
/* 165 */           GroupShoppingTaskManager.onTaskFinished();
/* 166 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 172 */     long originalBindYuanbao = QingfuInterface.getBindYuanbao(userId, true);
/* 173 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.GROUP_SHOPPING_CREATE_SHOPPING_GROUP);
/* 174 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, groupShoppingItemCfg.groupPrice, CostType.COST_BIND_FIRST_CREATE_SHOPPING_GROUP, tLogArg);
/*     */     
/* 176 */     if (costResult != CostResult.Success)
/*     */     {
/* 178 */       onFail(1);
/* 179 */       GroupShoppingTaskManager.onTaskFinished();
/* 180 */       return false;
/*     */     }
/* 182 */     int usedBindYuanbao = (int)(originalBindYuanbao - QingfuInterface.getBindYuanbao(userId, true));
/*     */     
/*     */ 
/* 185 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 186 */     int closeTime = (int)(now + groupShoppingItemCfg.duration * 60L);
/* 187 */     ShoppingGroupInfo xShoppingGroupInfo = xbean.Pod.newShoppingGroupInfo();
/* 188 */     xShoppingGroupInfo.setGroup_shopping_item_cfgid(this.groupShoppingItemCfgId);
/* 189 */     xShoppingGroupInfo.setCreator_roleid(this.roleId);
/* 190 */     xShoppingGroupInfo.setCreate_time(now);
/* 191 */     xShoppingGroupInfo.setClose_time(closeTime);
/* 192 */     xShoppingGroupInfo.setStatus(0);
/* 193 */     xShoppingGroupInfo.setPrice(groupShoppingItemCfg.groupPrice);
/* 194 */     xShoppingGroupInfo.setGroup_size(groupShoppingItemCfg.groupSize);
/* 195 */     xShoppingGroupInfo.getMembers().add(Long.valueOf(this.roleId));
/* 196 */     Long groupId = Shopping_group_info.insert(xShoppingGroupInfo);
/* 197 */     if (groupId == null)
/*     */     {
/* 199 */       GroupShoppingTaskManager.onTaskFinished();
/* 200 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 204 */     xRoleGroupShoppingRecord.getBought_num_map().put(Integer.valueOf(this.groupShoppingItemCfgId), Integer.valueOf(boughtNum.intValue() + 1));
/* 205 */     xRoleGroupShoppingRecord.getParticipating_groups().add(groupId);
/* 206 */     xRoleGroupShoppingRecord.getUsed_bind_yuanbao_map().put(groupId, Integer.valueOf(usedBindYuanbao));
/*     */     
/*     */ 
/* 209 */     xSmallGroupShoppingItemInfo.setRemaining_num(xSmallGroupShoppingItemInfo.getRemaining_num() - groupShoppingItemCfg.groupSize);
/*     */     
/* 211 */     Set<Long> xIncompletedSmallGroups = GroupShoppingManager.getIncompletedSmallGroups(activityId);
/* 212 */     if (xIncompletedSmallGroups == null)
/*     */     {
/* 214 */       GroupShoppingTaskManager.onTaskFinished();
/* 215 */       return false;
/*     */     }
/* 217 */     xIncompletedSmallGroups.add(groupId);
/* 218 */     IncompletedSmallGroupChartManager.add(groupId.longValue(), this.groupShoppingItemCfgId, now);
/*     */     
/*     */ 
/* 221 */     SCreateShoppingGroupSuccess success = new SCreateShoppingGroupSuccess();
/* 222 */     GroupShoppingManager.fillShoppingGroupInfo(groupId.longValue(), xShoppingGroupInfo, success.group_info);
/* 223 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */     
/*     */ 
/* 226 */     SBroadcastShoppingGroupCreated created = new SBroadcastShoppingGroupCreated();
/* 227 */     created.group_id = groupId.longValue();
/* 228 */     created.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 229 */     created.creator_role_id = this.roleId;
/* 230 */     created.creator_name.setString(RoleInterface.getName(this.roleId), "UTF-8");
/* 231 */     OnlineManager.getInstance().sendAll(created);
/*     */     
/*     */ 
/* 234 */     GroupShoppingCloseSession.start(activityId, this.roleId, groupId.longValue(), closeTime);
/* 235 */     GroupShoppingLogger.tlogCreateShoppingGroup(this.roleId, groupId.longValue(), this.groupShoppingItemCfgId);
/* 236 */     GroupShoppingLogger.info("PCreateSmallShoppingGroup.processImp()@done|roleid=%d|group_id=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), groupId, Integer.valueOf(this.groupShoppingItemCfgId) });
/*     */     
/* 238 */     GroupShoppingTaskManager.onTaskFinished();
/* 239 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int reason)
/*     */   {
/* 244 */     SCreateShoppingGroupFail fail = new SCreateShoppingGroupFail();
/* 245 */     fail.reason = reason;
/* 246 */     fail.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 247 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/* 248 */     GroupShoppingLogger.error("PCreateSmallShoppingGroup.onFail()@done|roleid=%d|group_shopping_item_cfgid=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.groupShoppingItemCfgId), Integer.valueOf(reason) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PCreateSmallShoppingGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */