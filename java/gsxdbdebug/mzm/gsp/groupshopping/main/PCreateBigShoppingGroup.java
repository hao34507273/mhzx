/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*     */ import mzm.gsp.groupshopping.SBroadcastShoppingGroupCreated;
/*     */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xtable.Shopping_group_info;
/*     */ 
/*     */ public class PCreateBigShoppingGroup extends LogicProcedure
/*     */ {
/*     */   private final int activityId;
/*     */   private final int groupShoppingItemCfgId;
/*     */   private final boolean replaceCancelled;
/*     */   
/*     */   PCreateBigShoppingGroup(int activityId, int groupShoppingItemCfgId)
/*     */   {
/*  25 */     this.activityId = activityId;
/*  26 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*  27 */     this.replaceCancelled = false;
/*     */   }
/*     */   
/*     */   PCreateBigShoppingGroup(int activityId, int groupShoppingItemCfgId, boolean replaceCancelled)
/*     */   {
/*  32 */     this.activityId = activityId;
/*  33 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*  34 */     this.replaceCancelled = replaceCancelled;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (GameServerInfoManager.isRoamServer()) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     SBigGroupShoppingItemCfg groupShoppingItemCfg = SBigGroupShoppingItemCfg.get(this.groupShoppingItemCfgId);
/*  46 */     if (groupShoppingItemCfg == null)
/*  47 */       return false;
/*  48 */     STimeLimitCommonCfg timeLimitCfg = STimeLimitCommonCfg.get(groupShoppingItemCfg.timeLimitCfgId);
/*  49 */     if (timeLimitCfg == null) {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     Calendar calendar = DateTimeUtils.getCalendar();
/*  54 */     calendar.set(timeLimitCfg.endYear, timeLimitCfg.endMonth - 1, timeLimitCfg.endDay, timeLimitCfg.endHour, timeLimitCfg.endMinute);
/*     */     
/*  56 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  57 */     int closeTime = (int)(calendar.getTimeInMillis() / 1000L);
/*  58 */     if (now >= closeTime) {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(this.activityId);
/*  63 */     if (xGroupShoppingInfo == null)
/*  64 */       return false;
/*  65 */     BigGroupShoppingItemInfo xBigGroupShoppingItemInfo = (BigGroupShoppingItemInfo)xGroupShoppingInfo.getBig_group_infos().get(Integer.valueOf(this.groupShoppingItemCfgId));
/*     */     
/*  67 */     if (xBigGroupShoppingItemInfo == null)
/*  68 */       return false;
/*  69 */     if (xBigGroupShoppingItemInfo.getGroup_id() != 0L)
/*     */     {
/*  71 */       if (!this.replaceCancelled) {
/*  72 */         return false;
/*     */       }
/*  74 */       Integer status = Shopping_group_info.selectStatus(Long.valueOf(xBigGroupShoppingItemInfo.getGroup_id()));
/*     */       
/*  76 */       if ((status != null) && (status.intValue() != 3)) {
/*  77 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  81 */     ShoppingGroupInfo xShoppingGroupInfo = xbean.Pod.newShoppingGroupInfo();
/*  82 */     xShoppingGroupInfo.setGroup_shopping_item_cfgid(this.groupShoppingItemCfgId);
/*  83 */     xShoppingGroupInfo.setCreator_roleid(0L);
/*  84 */     xShoppingGroupInfo.setCreate_time(now);
/*  85 */     xShoppingGroupInfo.setClose_time(closeTime);
/*  86 */     xShoppingGroupInfo.setStatus(0);
/*  87 */     xShoppingGroupInfo.setPrice(groupShoppingItemCfg.groupPrice);
/*  88 */     xShoppingGroupInfo.setGroup_size(groupShoppingItemCfg.groupSize);
/*  89 */     Long groupId = Shopping_group_info.insert(xShoppingGroupInfo);
/*  90 */     if (groupId == null)
/*  91 */       return false;
/*  92 */     xBigGroupShoppingItemInfo.setGroup_id(groupId.longValue());
/*     */     
/*     */ 
/*  95 */     boolean sendBroadcastMessage = (GroupShoppingManager.isServerLevelEnough(this.activityId)) && (GroupShoppingManager.isBigGroupShoppingOpen()) && (!GroupShoppingBanInterface.isBanned(this.activityId, this.groupShoppingItemCfgId));
/*     */     
/*     */ 
/*  98 */     if (sendBroadcastMessage)
/*     */     {
/* 100 */       SBroadcastShoppingGroupCreated created = new SBroadcastShoppingGroupCreated();
/* 101 */       created.group_id = groupId.longValue();
/* 102 */       created.group_shopping_item_cfgid = this.groupShoppingItemCfgId;
/* 103 */       created.creator_role_id = 0L;
/* 104 */       OnlineManager.getInstance().sendAll(created);
/*     */     }
/*     */     
/*     */ 
/* 108 */     GroupShoppingCloseSession.start(this.activityId, 0L, groupId.longValue(), closeTime);
/* 109 */     GroupShoppingLogger.info("PCreateBigShoppingGroup.processImp()@done|group_id=%d|group_shopping_item_cfgid=%d", new Object[] { groupId, Integer.valueOf(this.groupShoppingItemCfgId) });
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\PCreateBigShoppingGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */