/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.groupshopping.SBroadcastShoppingGroupSize;
/*     */ import mzm.gsp.groupshopping.SJoinShoppingGroupFail;
/*     */ import mzm.gsp.groupshopping.SJoinShoppingGroupSuccess;
/*     */ import mzm.gsp.groupshopping.SSyncShoppingGroupSize;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SSmallGroupShoppingItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ public class PJoinShoppingGroup extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long groupId;
/*     */   private final long currentYuanbao;
/*     */   
/*     */   public PJoinShoppingGroup(long roleId, long groupId, long currentYuanbao)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.groupId = groupId;
/*  35 */     this.currentYuanbao = currentYuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     int activityId = GroupShoppingManager.currentActivityId;
/*  43 */     if (activityId == 0)
/*     */     {
/*  45 */       GroupShoppingTaskManager.onTaskFinished();
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (!GroupShoppingManager.isServerLevelEnough(activityId))
/*     */     {
/*  52 */       GroupShoppingTaskManager.onTaskFinished();
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     if (!GroupShoppingManager.canJoinShoppingGroup(this.roleId))
/*     */     {
/*  59 */       GroupShoppingTaskManager.onTaskFinished();
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     Integer groupShoppingItemCfgId = Shopping_group_info.selectGroup_shopping_item_cfgid(Long.valueOf(this.groupId));
/*  64 */     if (groupShoppingItemCfgId == null)
/*     */     {
/*  66 */       GroupShoppingTaskManager.onTaskFinished();
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     if (GroupShoppingBanInterface.isBanned(activityId, groupShoppingItemCfgId.intValue()))
/*     */     {
/*  73 */       GroupShoppingTaskManager.onTaskFinished();
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     String userId = RoleInterface.getUserId(this.roleId);
/*  79 */     if (userId == null)
/*     */     {
/*  81 */       GroupShoppingTaskManager.onTaskFinished();
/*  82 */       return false;
/*     */     }
/*  84 */     long balance = QingfuInterface.getBalance(userId, true);
/*  85 */     if (balance != this.currentYuanbao)
/*     */     {
/*  87 */       GroupShoppingTaskManager.onTaskFinished();
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if (!mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin())
/*     */     {
/*  94 */       GroupShoppingTaskManager.onTaskFinished();
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, groupShoppingItemCfgId.intValue());
/* 100 */     if (type == GroupShoppingManager.GroupShoppingType.SMALL)
/* 101 */       return processJoinSmallShoppingGroup(activityId, groupShoppingItemCfgId.intValue());
/* 102 */     if (type == GroupShoppingManager.GroupShoppingType.BIG) {
/* 103 */       return processJoinBigShoppingGroup(activityId, groupShoppingItemCfgId.intValue());
/*     */     }
/* 105 */     GroupShoppingTaskManager.onTaskFinished();
/* 106 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean processJoinSmallShoppingGroup(int activityId, int groupShoppingItemCfgId)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 113 */     if (!GroupShoppingManager.isSmallGroupShoppingOpen())
/*     */     {
/* 115 */       GroupShoppingTaskManager.onTaskFinished();
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     SSmallGroupShoppingItemCfg groupShoppingItemCfg = SSmallGroupShoppingItemCfg.get(groupShoppingItemCfgId);
/* 121 */     if (groupShoppingItemCfg == null)
/*     */     {
/* 123 */       GroupShoppingTaskManager.onTaskFinished();
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 128 */     RoleGroupShoppingRecord xRoleGroupShoppingRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/*     */     
/* 130 */     if (xRoleGroupShoppingRecord == null)
/*     */     {
/* 132 */       GroupShoppingTaskManager.onTaskFinished();
/* 133 */       return false;
/*     */     }
/* 135 */     Integer boughtNum = (Integer)xRoleGroupShoppingRecord.getBought_num_map().get(Integer.valueOf(groupShoppingItemCfgId));
/* 136 */     if (boughtNum == null)
/* 137 */       boughtNum = Integer.valueOf(0);
/* 138 */     if ((groupShoppingItemCfg.maxBuyNum > 0) && (boughtNum.intValue() >= groupShoppingItemCfg.maxBuyNum))
/*     */     {
/* 140 */       onFail(4);
/* 141 */       GroupShoppingTaskManager.onTaskFinished();
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     for (Long groupId : xRoleGroupShoppingRecord.getParticipating_groups())
/*     */     {
/* 148 */       ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.select(groupId);
/* 149 */       if (xShoppingGroupInfo != null)
/*     */       {
/* 151 */         if (xShoppingGroupInfo.getGroup_shopping_item_cfgid() == groupShoppingItemCfgId)
/*     */         {
/* 153 */           onFail(3);
/* 154 */           GroupShoppingTaskManager.onTaskFinished();
/* 155 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 161 */     ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.get(Long.valueOf(this.groupId));
/* 162 */     if (xShoppingGroupInfo == null)
/* 163 */       return false;
/* 164 */     if ((xShoppingGroupInfo.getStatus() != 0) || (xShoppingGroupInfo.getMembers().size() == xShoppingGroupInfo.getGroup_size()))
/*     */     {
/*     */ 
/* 167 */       onFail(2);
/* 168 */       GroupShoppingTaskManager.onTaskFinished();
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     String userId = RoleInterface.getUserId(this.roleId);
/* 174 */     if (userId == null)
/*     */     {
/* 176 */       GroupShoppingTaskManager.onTaskFinished();
/* 177 */       return false;
/*     */     }
/* 179 */     long originalBindYuanbao = QingfuInterface.getBindYuanbao(userId, true);
/* 180 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.GROUP_SHOPPING_JOIN_SHOPPING_GROUP);
/* 181 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, groupShoppingItemCfg.groupPrice, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_JOIN_SHOPPING_GROUP, tLogArg);
/*     */     
/* 183 */     if (costResult != CostResult.Success)
/*     */     {
/* 185 */       onFail(1);
/* 186 */       GroupShoppingTaskManager.onTaskFinished();
/* 187 */       return false;
/*     */     }
/* 189 */     int usedBindYuanbao = (int)(originalBindYuanbao - QingfuInterface.getBindYuanbao(userId, true));
/*     */     
/*     */ 
/* 192 */     xRoleGroupShoppingRecord.getBought_num_map().put(Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(boughtNum.intValue() + 1));
/* 193 */     xRoleGroupShoppingRecord.getParticipating_groups().add(Long.valueOf(this.groupId));
/* 194 */     xRoleGroupShoppingRecord.getUsed_bind_yuanbao_map().put(Long.valueOf(this.groupId), Integer.valueOf(usedBindYuanbao));
/*     */     
/*     */ 
/* 197 */     xShoppingGroupInfo.getMembers().add(Long.valueOf(this.roleId));
/*     */     
/*     */ 
/* 200 */     if (xShoppingGroupInfo.getMembers().size() == xShoppingGroupInfo.getGroup_size()) {
/* 201 */       NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, this.groupId));
/*     */     }
/*     */     
/* 204 */     final ShoppingGroupInfo xShoppingGroupInfoData = xShoppingGroupInfo.toData();
/* 205 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 210 */         SJoinShoppingGroupSuccess success = new SJoinShoppingGroupSuccess();
/* 211 */         GroupShoppingManager.fillShoppingGroupInfo(PJoinShoppingGroup.this.groupId, xShoppingGroupInfoData, success.group_info);
/* 212 */         OnlineManager.getInstance().send(PJoinShoppingGroup.this.roleId, success);
/* 213 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 217 */     }.execute();
/* 218 */     SSyncShoppingGroupSize syncShoppingGroupSize = new SSyncShoppingGroupSize();
/* 219 */     syncShoppingGroupSize.group_id = this.groupId;
/* 220 */     syncShoppingGroupSize.member_num = xShoppingGroupInfo.getMembers().size();
/* 221 */     Set<Long> otherMembers = new HashSet(xShoppingGroupInfo.getMembers());
/* 222 */     otherMembers.remove(Long.valueOf(this.roleId));
/* 223 */     OnlineManager.getInstance().sendMulti(syncShoppingGroupSize, otherMembers);
/*     */     
/*     */ 
/* 226 */     if (xShoppingGroupInfo.getMembers().size() == groupShoppingItemCfg.groupSizeToNotify)
/*     */     {
/* 228 */       SBroadcastShoppingGroupSize broadcastShoppingGroupSize = new SBroadcastShoppingGroupSize();
/* 229 */       broadcastShoppingGroupSize.group_id = this.groupId;
/* 230 */       broadcastShoppingGroupSize.group_shopping_item_cfgid = groupShoppingItemCfgId;
/* 231 */       broadcastShoppingGroupSize.member_num = xShoppingGroupInfo.getMembers().size();
/* 232 */       broadcastShoppingGroupSize.member_role_id = this.roleId;
/* 233 */       broadcastShoppingGroupSize.member_name.setString(RoleInterface.getName(this.roleId), "UTF-8");
/* 234 */       OnlineManager.getInstance().sendAll(broadcastShoppingGroupSize);
/*     */     }
/*     */     
/* 237 */     GroupShoppingLogger.tlogJoinShoppingGroup(this.roleId, this.groupId, groupShoppingItemCfgId);
/* 238 */     GroupShoppingLogger.info("PJoinShoppingGroup.processJoinSmallShoppingGroup()@done|roleid=%d|group_id=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.groupId), Integer.valueOf(groupShoppingItemCfgId) });
/*     */     
/*     */ 
/* 241 */     GroupShoppingTaskManager.onTaskFinished();
/* 242 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean processJoinBigShoppingGroup(int activityId, int groupShoppingItemCfgId)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 249 */     if (!GroupShoppingManager.isBigGroupShoppingOpen())
/*     */     {
/* 251 */       GroupShoppingTaskManager.onTaskFinished();
/* 252 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 256 */     SBigGroupShoppingItemCfg groupShoppingItemCfg = SBigGroupShoppingItemCfg.get(groupShoppingItemCfgId);
/* 257 */     if (groupShoppingItemCfg == null)
/*     */     {
/* 259 */       GroupShoppingTaskManager.onTaskFinished();
/* 260 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 264 */     RoleGroupShoppingRecord xRoleGroupShoppingRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/*     */     
/* 266 */     if (xRoleGroupShoppingRecord == null)
/*     */     {
/* 268 */       GroupShoppingTaskManager.onTaskFinished();
/* 269 */       return false;
/*     */     }
/* 271 */     Integer boughtNum = (Integer)xRoleGroupShoppingRecord.getBought_num_map().get(Integer.valueOf(groupShoppingItemCfgId));
/* 272 */     if (boughtNum == null)
/* 273 */       boughtNum = Integer.valueOf(0);
/* 274 */     if ((groupShoppingItemCfg.maxBuyNum > 0) && (boughtNum.intValue() >= groupShoppingItemCfg.maxBuyNum))
/*     */     {
/* 276 */       onFail(4);
/* 277 */       GroupShoppingTaskManager.onTaskFinished();
/* 278 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 282 */     BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = GroupShoppingManager.getBigGroupShoppingItemInfo(activityId, groupShoppingItemCfgId);
/*     */     
/* 284 */     if (xBigGroupShoppingItemInfo == null)
/*     */     {
/* 286 */       GroupShoppingTaskManager.onTaskFinished();
/* 287 */       return false;
/*     */     }
/* 289 */     if ((xBigGroupShoppingItemInfo.getTotal_num() > 0) && (xBigGroupShoppingItemInfo.getRemaining_num() <= 0))
/*     */     {
/* 291 */       onFail(2);
/* 292 */       GroupShoppingTaskManager.onTaskFinished();
/* 293 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 297 */     ShoppingGroupInfo xShoppingGroupInfo = Shopping_group_info.get(Long.valueOf(this.groupId));
/* 298 */     if (xShoppingGroupInfo == null)
/* 299 */       return false;
/* 300 */     if (xShoppingGroupInfo.getStatus() != 0)
/*     */     {
/* 302 */       onFail(2);
/* 303 */       GroupShoppingTaskManager.onTaskFinished();
/* 304 */       return false;
/*     */     }
/* 306 */     if (xShoppingGroupInfo.getMembers().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 308 */       onFail(3);
/* 309 */       GroupShoppingTaskManager.onTaskFinished();
/* 310 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 314 */     String userId = RoleInterface.getUserId(this.roleId);
/* 315 */     if (userId == null)
/*     */     {
/* 317 */       GroupShoppingTaskManager.onTaskFinished();
/* 318 */       return false;
/*     */     }
/* 320 */     long originalBindYuanbao = QingfuInterface.getBindYuanbao(userId, true);
/* 321 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.GROUP_SHOPPING_JOIN_SHOPPING_GROUP);
/* 322 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, groupShoppingItemCfg.groupPrice, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_JOIN_SHOPPING_GROUP, tLogArg);
/*     */     
/* 324 */     if (costResult != CostResult.Success)
/*     */     {
/* 326 */       onFail(1);
/* 327 */       GroupShoppingTaskManager.onTaskFinished();
/* 328 */       return false;
/*     */     }
/* 330 */     int usedBindYuanbao = (int)(originalBindYuanbao - QingfuInterface.getBindYuanbao(userId, true));
/*     */     
/*     */ 
/* 333 */     xRoleGroupShoppingRecord.getBought_num_map().put(Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(boughtNum.intValue() + 1));
/* 334 */     xRoleGroupShoppingRecord.getParticipating_groups().add(Long.valueOf(this.groupId));
/* 335 */     xRoleGroupShoppingRecord.getUsed_bind_yuanbao_map().put(Long.valueOf(this.groupId), Integer.valueOf(usedBindYuanbao));
/*     */     
/*     */ 
/* 338 */     xShoppingGroupInfo.getMembers().add(Long.valueOf(this.roleId));
/* 339 */     xBigGroupShoppingItemInfo.setRemaining_num(xBigGroupShoppingItemInfo.getRemaining_num() - 1);
/*     */     
/*     */ 
/* 342 */     if ((xBigGroupShoppingItemInfo.getTotal_num() > 0) && (xBigGroupShoppingItemInfo.getRemaining_num() <= 0)) {
/* 343 */       NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(activityId, this.groupId));
/*     */     }
/*     */     
/* 346 */     SJoinShoppingGroupSuccess success = new SJoinShoppingGroupSuccess();
/* 347 */     GroupShoppingManager.fillShoppingGroupInfo(this.groupId, xShoppingGroupInfo, success.group_info);
/* 348 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */     
/*     */ 
/* 351 */     SSyncShoppingGroupSize syncShoppingGroupSize = new SSyncShoppingGroupSize();
/* 352 */     syncShoppingGroupSize.group_id = this.groupId;
/* 353 */     syncShoppingGroupSize.member_num = xShoppingGroupInfo.getMembers().size();
/* 354 */     Set<Long> otherMembers = new HashSet(xShoppingGroupInfo.getMembers());
/* 355 */     otherMembers.remove(Long.valueOf(this.roleId));
/* 356 */     OnlineManager.getInstance().sendMulti(syncShoppingGroupSize, otherMembers);
/*     */     
/*     */ 
/* 359 */     for (Integer size : groupShoppingItemCfg.groupSizesToNotify)
/*     */     {
/* 361 */       if (xShoppingGroupInfo.getMembers().size() == size.intValue())
/*     */       {
/* 363 */         SBroadcastShoppingGroupSize broadcastShoppingGroupSize = new SBroadcastShoppingGroupSize();
/* 364 */         broadcastShoppingGroupSize.group_id = this.groupId;
/* 365 */         broadcastShoppingGroupSize.group_shopping_item_cfgid = groupShoppingItemCfgId;
/* 366 */         broadcastShoppingGroupSize.member_num = xShoppingGroupInfo.getMembers().size();
/* 367 */         broadcastShoppingGroupSize.member_role_id = this.roleId;
/* 368 */         broadcastShoppingGroupSize.member_name.setString(RoleInterface.getName(this.roleId), "UTF-8");
/* 369 */         OnlineManager.getInstance().sendAll(broadcastShoppingGroupSize);
/* 370 */         break;
/*     */       }
/*     */     }
/*     */     
/* 374 */     GroupShoppingLogger.tlogJoinShoppingGroup(this.roleId, this.groupId, groupShoppingItemCfgId);
/* 375 */     GroupShoppingLogger.info("PJoinShoppingGroup.processJoinBigShoppingGroup()@done|roleid=%d|group_id=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.groupId), Integer.valueOf(groupShoppingItemCfgId) });
/*     */     
/*     */ 
/* 378 */     GroupShoppingTaskManager.onTaskFinished();
/* 379 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int reason)
/*     */   {
/* 384 */     SJoinShoppingGroupFail fail = new SJoinShoppingGroupFail();
/* 385 */     fail.reason = reason;
/* 386 */     fail.group_id = this.groupId;
/* 387 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/* 388 */     GroupShoppingLogger.error("PJoinShoppingGroup.onFail()@done|roleid=%d|group_id=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.groupId), Integer.valueOf(reason) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PJoinShoppingGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */