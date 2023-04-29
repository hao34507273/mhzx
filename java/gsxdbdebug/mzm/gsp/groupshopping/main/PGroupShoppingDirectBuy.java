/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*     */ import mzm.gsp.groupshopping.SGroupShoppingDirectBuyFail;
/*     */ import mzm.gsp.groupshopping.SGroupShoppingDirectBuySuccess;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SSmallGroupShoppingItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleGroupShoppingRecord;
/*     */ 
/*     */ public class PGroupShoppingDirectBuy
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int groupShoppingItemCfgId;
/*     */   private final long currentYuanbao;
/*     */   
/*     */   public PGroupShoppingDirectBuy(long roleId, int groupShoppingItemCfgId, long currentYuanbao)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*  36 */     this.currentYuanbao = currentYuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     int activityId = GroupShoppingManager.currentActivityId;
/*  44 */     if (activityId == 0) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!GroupShoppingManager.isServerLevelEnough(activityId)) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!GroupShoppingManager.canDirectBuy(this.roleId)) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (GroupShoppingBanInterface.isBanned(activityId, this.groupShoppingItemCfgId)) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     String userId = RoleInterface.getUserId(this.roleId);
/*  61 */     if (userId == null)
/*  62 */       return false;
/*  63 */     long balance = QingfuInterface.getBalance(userId, true);
/*  64 */     if (balance != this.currentYuanbao) {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, activityId).isCanJoin()) {
/*  69 */       return false;
/*     */     }
/*  71 */     GroupShoppingManager.GroupShoppingType type = GroupShoppingManager.checkGroupShoppingItemCfgId(activityId, this.groupShoppingItemCfgId);
/*  72 */     if (type == GroupShoppingManager.GroupShoppingType.SMALL)
/*  73 */       return processDirectBuySmallGroupShoppingItem(activityId);
/*  74 */     if (type == GroupShoppingManager.GroupShoppingType.BIG)
/*  75 */       return processDirectBuyBigGroupShoppingItem(activityId);
/*  76 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processDirectBuySmallGroupShoppingItem(int activityId)
/*     */   {
/*  85 */     if (!GroupShoppingManager.isSmallGroupDirectBuyOpen()) {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     SSmallGroupShoppingItemCfg groupShoppingItemCfg = SSmallGroupShoppingItemCfg.get(this.groupShoppingItemCfgId);
/*  90 */     if (groupShoppingItemCfg == null) {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     RoleGroupShoppingRecord xRoleGroupShoppingRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/*     */     
/*  96 */     if (xRoleGroupShoppingRecord == null)
/*  97 */       return false;
/*  98 */     Integer boughtNum = (Integer)xRoleGroupShoppingRecord.getBought_num_map().get(Integer.valueOf(this.groupShoppingItemCfgId));
/*  99 */     if (boughtNum == null)
/* 100 */       boughtNum = Integer.valueOf(0);
/* 101 */     if ((groupShoppingItemCfg.maxBuyNum > 0) && (boughtNum.intValue() >= groupShoppingItemCfg.maxBuyNum))
/*     */     {
/* 103 */       onFail(2);
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     String userId = RoleInterface.getUserId(this.roleId);
/* 109 */     if (userId == null)
/* 110 */       return false;
/* 111 */     TLogArg tLogArg = new TLogArg(LogReason.GROUP_SHOPPING_DIRECT_BUY);
/* 112 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, groupShoppingItemCfg.singlePrice, CostType.COST_BIND_FIRST_GROUP_SHOPPING_DIRECT_BUY, tLogArg);
/*     */     
/* 114 */     if (costResult != CostResult.Success)
/*     */     {
/* 116 */       onFail(1);
/* 117 */       return false;
/*     */     }
/* 119 */     boolean isBind = ItemInterface.isItemFromShanghuiOrBaitan(groupShoppingItemCfg.itemId);
/* 120 */     if (!ItemInterface.addItem(this.roleId, groupShoppingItemCfg.itemId, 1, isBind, tLogArg).success())
/*     */     {
/* 122 */       onFail(4);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     xRoleGroupShoppingRecord.getBought_num_map().put(Integer.valueOf(this.groupShoppingItemCfgId), Integer.valueOf(boughtNum.intValue() + 1));
/*     */     
/* 129 */     SGroupShoppingDirectBuySuccess success = new SGroupShoppingDirectBuySuccess();
/* 130 */     success.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 131 */     OnlineManager.getInstance().send(this.roleId, success);
/* 132 */     GroupShoppingLogger.info("PGroupShoppingDirectBuy.processDirectBuySmallGroupShoppingItem()@done|roleid=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.groupShoppingItemCfgId) });
/*     */     
/* 134 */     GroupShoppingLogger.tlogGroupShoppingDirectBuy(this.roleId, this.groupShoppingItemCfgId, groupShoppingItemCfg.singlePrice);
/* 135 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processDirectBuyBigGroupShoppingItem(int activityId)
/*     */   {
/* 144 */     if (!GroupShoppingManager.isBigGroupDirectBuyOpen()) {
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     SBigGroupShoppingItemCfg groupShoppingItemCfg = SBigGroupShoppingItemCfg.get(this.groupShoppingItemCfgId);
/* 149 */     if (groupShoppingItemCfg == null)
/* 150 */       return false;
/* 151 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 152 */     STimeLimitCommonCfg timeLimitCfg = STimeLimitCommonCfg.get(groupShoppingItemCfg.timeLimitCfgId);
/* 153 */     if (timeLimitCfg == null)
/* 154 */       return false;
/* 155 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 156 */     calendar.set(timeLimitCfg.startYear, timeLimitCfg.startMonth - 1, timeLimitCfg.startDay, timeLimitCfg.startHour, timeLimitCfg.startMinute);
/*     */     
/* 158 */     long startTime = calendar.getTimeInMillis();
/* 159 */     if (now < startTime)
/*     */     {
/* 161 */       onFail(3);
/* 162 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 166 */     RoleGroupShoppingRecord xRoleGroupShoppingRecord = GroupShoppingManager.getRoleGroupShoppingRecord(this.roleId, activityId);
/*     */     
/* 168 */     if (xRoleGroupShoppingRecord == null)
/* 169 */       return false;
/* 170 */     Integer boughtNum = (Integer)xRoleGroupShoppingRecord.getBought_num_map().get(Integer.valueOf(this.groupShoppingItemCfgId));
/* 171 */     if (boughtNum == null)
/* 172 */       boughtNum = Integer.valueOf(0);
/* 173 */     if ((groupShoppingItemCfg.maxBuyNum > 0) && (boughtNum.intValue() >= groupShoppingItemCfg.maxBuyNum))
/*     */     {
/* 175 */       onFail(2);
/* 176 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 180 */     String userId = RoleInterface.getUserId(this.roleId);
/* 181 */     if (userId == null)
/* 182 */       return false;
/* 183 */     TLogArg tLogArg = new TLogArg(LogReason.GROUP_SHOPPING_DIRECT_BUY);
/* 184 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, groupShoppingItemCfg.singlePrice, CostType.COST_BIND_FIRST_GROUP_SHOPPING_DIRECT_BUY, tLogArg);
/*     */     
/* 186 */     if (costResult != CostResult.Success)
/*     */     {
/* 188 */       onFail(1);
/* 189 */       return false;
/*     */     }
/* 191 */     boolean isBind = ItemInterface.isItemFromShanghuiOrBaitan(groupShoppingItemCfg.itemId);
/* 192 */     if (!ItemInterface.addItem(this.roleId, groupShoppingItemCfg.itemId, 1, isBind, tLogArg).success())
/*     */     {
/* 194 */       onFail(4);
/* 195 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 199 */     xRoleGroupShoppingRecord.getBought_num_map().put(Integer.valueOf(this.groupShoppingItemCfgId), Integer.valueOf(boughtNum.intValue() + 1));
/*     */     
/* 201 */     SGroupShoppingDirectBuySuccess success = new SGroupShoppingDirectBuySuccess();
/* 202 */     success.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 203 */     OnlineManager.getInstance().send(this.roleId, success);
/* 204 */     GroupShoppingLogger.info("PGroupShoppingDirectBuy.processDirectBuyBigGroupShoppingItem()@done|roleid=%d|group_shopping_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.groupShoppingItemCfgId) });
/*     */     
/* 206 */     GroupShoppingLogger.tlogGroupShoppingDirectBuy(this.roleId, this.groupShoppingItemCfgId, groupShoppingItemCfg.singlePrice);
/* 207 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int reason)
/*     */   {
/* 212 */     SGroupShoppingDirectBuyFail fail = new SGroupShoppingDirectBuyFail();
/* 213 */     fail.reason = reason;
/* 214 */     fail.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 215 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/* 216 */     GroupShoppingLogger.error("PGroupShoppingDirectBuy.onFail()@done|roleid=%d|group_shopping_item_cfgid=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.groupShoppingItemCfgId), Integer.valueOf(reason) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PGroupShoppingDirectBuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */