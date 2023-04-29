/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friendscircle.SNotifyFriendsCircleBeTrod;
/*     */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAdd;
/*     */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAddArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FriendsCircleTreadResult;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnCrossServerTreadFriendsCircle extends LogicProcedure
/*     */ {
/*  28 */   private int result = 0;
/*  29 */   private boolean isTriggerBox = false;
/*  30 */   private int addPopularityValue = 0;
/*  31 */   private int currentWeekPopularity = 0;
/*  32 */   private int currentTotalPopularity = 0;
/*  33 */   private int ownTreasureBoxNum = 0;
/*     */   
/*     */   private final long activeRoleId;
/*     */   
/*     */   private final int activeZoneId;
/*     */   private final long beTrodRoleId;
/*     */   private final boolean isCanGetMoreTreasureBox;
/*     */   private final long serialId;
/*     */   
/*     */   public POnCrossServerTreadFriendsCircle(long activeRoleId, int activeZoneId, long beTrodRoleId, boolean isCanGetMoreTreasureBox, long serialId)
/*     */   {
/*  44 */     this.activeRoleId = activeRoleId;
/*  45 */     this.activeZoneId = activeZoneId;
/*  46 */     this.beTrodRoleId = beTrodRoleId;
/*  47 */     this.isCanGetMoreTreasureBox = isCanGetMoreTreasureBox;
/*  48 */     this.serialId = serialId;
/*     */   }
/*     */   
/*     */   public int getTreadResult()
/*     */   {
/*  53 */     return this.result;
/*     */   }
/*     */   
/*     */   public boolean isTriggerBox()
/*     */   {
/*  58 */     return this.isTriggerBox;
/*     */   }
/*     */   
/*     */   public int getAddPopularity()
/*     */   {
/*  63 */     return this.addPopularityValue;
/*     */   }
/*     */   
/*     */   public int getCurrentWeekPopularity()
/*     */   {
/*  68 */     return this.currentWeekPopularity;
/*     */   }
/*     */   
/*     */   public int getCurrentTotalPopularity()
/*     */   {
/*  73 */     return this.currentTotalPopularity;
/*     */   }
/*     */   
/*     */   public int getOwnTreasureBoxNum()
/*     */   {
/*  78 */     return this.ownTreasureBoxNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  84 */     String beTrodUserId = RoleInterface.getUserId(this.beTrodRoleId);
/*  85 */     if (beTrodUserId == null)
/*     */     {
/*  87 */       this.result = 1;
/*     */       
/*  89 */       onTreadFriendsCircleFail(1);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     lock(Lockeys.get(User.getTable(), beTrodUserId));
/*     */     
/*  95 */     int beTrodRoleLevel = RoleInterface.getLevel(this.beTrodRoleId);
/*  96 */     if (beTrodRoleLevel < SFriendsCircleConsts.getInstance().friends_circle_open_role_level)
/*     */     {
/*  98 */       this.result = 4;
/*     */       
/* 100 */       onTreadFriendsCircleFail(4);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     Role2FriendsCircleInfo xBeTrodRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.beTrodRoleId);
/*     */     
/* 107 */     FriendsCircleTreadResult xOldFriendsCircleTreadResult = (FriendsCircleTreadResult)xBeTrodRole2FriendsCircleInfo.getBe_trod_result().get(Long.valueOf(this.serialId));
/*     */     
/* 109 */     if (xOldFriendsCircleTreadResult != null)
/*     */     {
/* 111 */       this.isTriggerBox = xOldFriendsCircleTreadResult.getIs_trigger_box();
/* 112 */       this.addPopularityValue = xOldFriendsCircleTreadResult.getAdd_popularity_value();
/* 113 */       this.currentWeekPopularity = FriendsCircleManager.getWeekPopularityValue(this.beTrodRoleId, true);
/* 114 */       this.currentTotalPopularity = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/* 115 */       this.result = 3;
/* 116 */       this.ownTreasureBoxNum = xBeTrodRole2FriendsCircleInfo.getTreasure_box_num();
/*     */       
/* 118 */       onTreadFriendsCircleFail(3);
/* 119 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 123 */     Map<Long, Integer> xBeTrodRoleTodayBeTreadHistoryMap = FriendsCircleManager.refreshAndGetBeTreadFriendsCircleMap(xBeTrodRole2FriendsCircleInfo);
/* 124 */     Integer xAleardyBeTreadTimes = (Integer)xBeTrodRoleTodayBeTreadHistoryMap.get(Long.valueOf(this.activeRoleId));
/*     */     
/* 126 */     int limitTimes = SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day;
/* 127 */     if ((xAleardyBeTreadTimes != null) && (xAleardyBeTreadTimes.intValue() > limitTimes))
/*     */     {
/* 129 */       this.result = 2;
/*     */       
/* 131 */       Map<String, Object> extraMap = new HashMap();
/* 132 */       extraMap.put("limit_times", Integer.valueOf(limitTimes));
/* 133 */       extraMap.put("aleardy_be_tread_times", xAleardyBeTreadTimes);
/*     */       
/* 135 */       onTreadFriendsCircleFail(2, extraMap);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     int xOriginalTreasureBoxNum = xBeTrodRole2FriendsCircleInfo.getTreasure_box_num();
/* 140 */     this.ownTreasureBoxNum = xOriginalTreasureBoxNum;
/*     */     
/* 142 */     if ((xOriginalTreasureBoxNum > 0) && (this.isCanGetMoreTreasureBox))
/*     */     {
/* 144 */       int randomResult = Xdb.random().nextInt(CommonUtils.WAN_PERCENT);
/* 145 */       if (randomResult < SFriendsCircleConsts.getInstance().tread_circle_get_treasure_box_probability)
/*     */       {
/* 147 */         xBeTrodRole2FriendsCircleInfo.setTreasure_box_num(xOriginalTreasureBoxNum - 1);
/* 148 */         this.isTriggerBox = true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 153 */     int treadCicleGetPopularityValue = SFriendsCircleConsts.getInstance().tread_circle_get_popularity_value;
/*     */     
/* 155 */     int leftCanGetPopularity = SFriendsCircleConsts.getInstance().max_get_popularity_by_tread - xBeTrodRole2FriendsCircleInfo.getToday_get_popularity_from_tread();
/*     */     
/* 157 */     int realCanAddPopularityValue = leftCanGetPopularity > treadCicleGetPopularityValue ? treadCicleGetPopularityValue : leftCanGetPopularity;
/*     */     
/*     */ 
/* 160 */     if (realCanAddPopularityValue > 0)
/*     */     {
/* 162 */       FriendsCircleManager.addAndGetWeekPopularity(this.beTrodRoleId, xBeTrodRole2FriendsCircleInfo, realCanAddPopularityValue);
/*     */       
/*     */ 
/* 165 */       int originalTotalPopularityValue = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/* 166 */       int nowTotalPopularityValue = originalTotalPopularityValue + realCanAddPopularityValue;
/*     */       
/* 168 */       xBeTrodRole2FriendsCircleInfo.setTotal_popularity_value(nowTotalPopularityValue);
/*     */       
/* 170 */       xBeTrodRole2FriendsCircleInfo.setToday_get_popularity_from_tread(xBeTrodRole2FriendsCircleInfo.getToday_get_popularity_from_tread() + realCanAddPopularityValue);
/*     */       
/*     */ 
/* 173 */       TriggerEventsManger.getInstance().triggerEvent(new FriendsCirclePopularityAdd(), new FriendsCirclePopularityAddArg(this.beTrodRoleId, realCanAddPopularityValue, xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value(), xBeTrodRole2FriendsCircleInfo.getCurrent_week_popularity_value()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.beTrodRoleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 181 */     this.addPopularityValue = realCanAddPopularityValue;
/* 182 */     this.currentWeekPopularity = xBeTrodRole2FriendsCircleInfo.getCurrent_week_popularity_value();
/* 183 */     this.currentTotalPopularity = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/*     */     
/* 185 */     FriendsCircleManager.addTodayTreadMePopularity(xBeTrodRole2FriendsCircleInfo, this.activeRoleId);
/*     */     
/*     */ 
/* 188 */     FriendsCircleManager.reportTreadFriendsCircle(this.beTrodRoleId, this.activeRoleId, this.isTriggerBox ? 1 : 0, realCanAddPopularityValue > 0 ? realCanAddPopularityValue : 0, this.serialId);
/*     */     
/*     */ 
/* 191 */     FriendsCircleTreadResult xFriendsCircleTreadResult = xbean.Pod.newFriendsCircleTreadResult();
/* 192 */     xFriendsCircleTreadResult.setTread_me_zone_id(this.activeZoneId);
/* 193 */     xFriendsCircleTreadResult.setTread_me_role_id(this.activeRoleId);
/* 194 */     xFriendsCircleTreadResult.setIs_ssp_replied(false);
/* 195 */     xFriendsCircleTreadResult.setAdd_popularity_value(realCanAddPopularityValue);
/* 196 */     xFriendsCircleTreadResult.setIs_trigger_box(this.isTriggerBox);
/* 197 */     xFriendsCircleTreadResult.setIs_cross_server(true);
/* 198 */     xBeTrodRole2FriendsCircleInfo.getBe_trod_result().put(Long.valueOf(this.serialId), xFriendsCircleTreadResult);
/*     */     
/*     */ 
/* 201 */     SNotifyFriendsCircleBeTrod sNotifyFriendsCircleBeTrod = new SNotifyFriendsCircleBeTrod();
/* 202 */     sNotifyFriendsCircleBeTrod.current_treasure_box_num = xBeTrodRole2FriendsCircleInfo.getTreasure_box_num();
/* 203 */     sNotifyFriendsCircleBeTrod.is_trigger_box = (this.isTriggerBox ? 1 : 0);
/* 204 */     sNotifyFriendsCircleBeTrod.popularity_week_value = xBeTrodRole2FriendsCircleInfo.getCurrent_week_popularity_value();
/* 205 */     sNotifyFriendsCircleBeTrod.popularity_total_value = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/*     */     
/* 207 */     OnlineManager.getInstance().send(this.beTrodRoleId, sNotifyFriendsCircleBeTrod);
/*     */     
/* 209 */     StringBuilder sbLog = new StringBuilder();
/* 210 */     sbLog.append("[friendscircle]POnCrossServerTreadFriendsCircle.processImp@tread friends circle success");
/* 211 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/* 212 */     sbLog.append("|active_zone_id=").append(this.activeZoneId);
/* 213 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 214 */     sbLog.append("|be_trod_role_zone_id=").append(GameServerInfoManager.getZoneId());
/* 215 */     sbLog.append("|is_can_get_more_treasure_box=").append(this.isCanGetMoreTreasureBox);
/* 216 */     sbLog.append("|serial_id=").append(this.serialId);
/* 217 */     sbLog.append("|is_trigger_box=").append(this.isTriggerBox);
/* 218 */     GameServer.logger().info(sbLog.toString());
/*     */     
/* 220 */     return true;
/*     */   }
/*     */   
/*     */   private void onTreadFriendsCircleFail(int ret)
/*     */   {
/* 225 */     onTreadFriendsCircleFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onTreadFriendsCircleFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 230 */     StringBuilder sbLog = new StringBuilder();
/* 231 */     sbLog.append("[friendscircle]POnCrossServerTreadFriendsCircle.processImp@tread friends circle failed");
/* 232 */     sbLog.append("|ret=").append(ret);
/* 233 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/* 234 */     sbLog.append("|active_zone_id=").append(this.activeZoneId);
/* 235 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 236 */     sbLog.append("|is_can_get_more_treasure_box=").append(this.isCanGetMoreTreasureBox);
/* 237 */     sbLog.append("|serial_id=").append(this.serialId);
/* 238 */     sbLog.append("|be_trod_role_zone_id=").append(GameServerInfoManager.getZoneId());
/*     */     
/* 240 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 242 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 244 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 247 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerTreadFriendsCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */