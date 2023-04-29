/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.SNotifyFriendsCircleBeTrod;
/*     */ import mzm.gsp.friendscircle.STreadFriendsCircleSuccess;
/*     */ import mzm.gsp.friendscircle.event.FriendsCirclePopularityAddArg;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleTread;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleTreadArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.SStatusTipRes;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleTread;
/*     */ import xbean.FriendsCircleTreadResult;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCTreadFriendsCircle extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long beTrodRoleId;
/*     */   private final int beTrodRoleZoneId;
/*     */   private final boolean isAutoTread;
/*     */   
/*     */   public PCTreadFriendsCircle(long roleId, long beTrodRoleId, int beTrodRoleZoneId)
/*     */   {
/*  50 */     this.roleId = roleId;
/*  51 */     this.beTrodRoleId = beTrodRoleId;
/*  52 */     this.beTrodRoleZoneId = beTrodRoleZoneId;
/*  53 */     this.isAutoTread = false;
/*     */   }
/*     */   
/*     */ 
/*     */   public PCTreadFriendsCircle(long roleId, long beTrodRoleId, int beTrodRoleZoneId, boolean isAutoTread)
/*     */   {
/*  59 */     this.roleId = roleId;
/*  60 */     this.beTrodRoleId = beTrodRoleId;
/*  61 */     this.beTrodRoleZoneId = beTrodRoleZoneId;
/*  62 */     this.isAutoTread = isAutoTread;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  68 */     int serverCalRoleZoneId = GameServerInfoManager.getZoneidFromRoleid(this.beTrodRoleId);
/*  69 */     if (this.beTrodRoleZoneId != serverCalRoleZoneId)
/*     */     {
/*  71 */       Map<String, Object> extraMap = new HashMap();
/*  72 */       extraMap.put("client_server_id", Integer.valueOf(this.beTrodRoleZoneId));
/*  73 */       extraMap.put("server_cal_role_zone_id", Integer.valueOf(serverCalRoleZoneId));
/*     */       
/*  75 */       onTreadFriendsCircleFail(62, extraMap);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!FriendsCircleManager.timeIsCanAddPopularity())
/*     */     {
/*  81 */       onTreadFriendsCircleFail(51);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 451, true))
/*     */     {
/*  87 */       onTreadFriendsCircleFail(1);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 453, true))
/*     */     {
/*  93 */       onTreadFriendsCircleFail(3);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (GameServerInfoManager.isValidZone(this.beTrodRoleZoneId))
/*     */     {
/*  99 */       return handleTreadFriendsCircleOwnServer();
/*     */     }
/*     */     
/*     */ 
/* 103 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(this.roleId, 471, true))
/*     */     {
/*     */ 
/* 106 */       onTreadFriendsCircleFail(53);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     return handleTreadFriendsCircleCrossServer();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleTreadFriendsCircleOwnServer()
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 122 */     String activeUserId = RoleInterface.getUserId(this.roleId);
/* 123 */     if (activeUserId == null)
/*     */     {
/* 125 */       onTreadFriendsCircleFail(6);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     String beTrodUserId = RoleInterface.getUserId(this.beTrodRoleId);
/* 130 */     if (beTrodUserId == null)
/*     */     {
/* 132 */       onTreadFriendsCircleFail(19);
/* 133 */       return false;
/*     */     }
/* 135 */     lock(User.getTable(), Arrays.asList(new String[] { activeUserId, beTrodUserId }));
/* 136 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.beTrodRoleId) }));
/*     */     
/* 138 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 139 */     if (roleLevel < SFriendsCircleConsts.getInstance().tread_open_role_level)
/*     */     {
/* 141 */       onTreadFriendsCircleFail(45);
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1824, true, true))
/*     */     {
/* 148 */       onTreadFriendsCircleFail(47);
/* 149 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 153 */     if (!RoleStatusInterface.checkCanSetStatus(this.beTrodRoleId, 1824, false, true))
/*     */     {
/* 155 */       Set<Integer> containStatuSet = RoleStatusInterface.getStatusSet(this.beTrodRoleId);
/*     */       
/* 157 */       if (containStatuSet.contains(Integer.valueOf(1830)))
/*     */       {
/* 159 */         onTreadFriendsCircleFail(68);
/*     */       }
/*     */       
/* 162 */       if (containStatuSet.contains(Integer.valueOf(2001)))
/*     */       {
/* 164 */         SStatusTipRes statusTipRes = new SStatusTipRes();
/* 165 */         statusTipRes.ret = 6772;
/* 166 */         OnlineManager.getInstance().sendAtOnce(this.roleId, statusTipRes);
/*     */       }
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     Role2FriendsCircleInfo xActiveRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/* 172 */     Role2FriendsCircleInfo xBeTrodRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.beTrodRoleId);
/* 173 */     if (xActiveRole2FriendsCircleInfo.getMy_black_role_list().contains(Long.valueOf(this.beTrodRoleId)))
/*     */     {
/* 175 */       onTreadFriendsCircleFail(64);
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     if (xBeTrodRole2FriendsCircleInfo.getMy_black_role_list().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 181 */       onTreadFriendsCircleFail(65);
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     Map<Long, Integer> xActiveRoleTodayTreadMap = FriendsCircleManager.refreshAndGetActiveTreadFriendsCircleMap(xActiveRole2FriendsCircleInfo);
/* 186 */     Integer xAleardyTreadTimes = (Integer)xActiveRoleTodayTreadMap.get(Long.valueOf(this.beTrodRoleId));
/* 187 */     if ((xAleardyTreadTimes != null) && (xAleardyTreadTimes.intValue() >= SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day))
/*     */     {
/*     */ 
/* 190 */       Map<String, Object> extraMap = new HashMap();
/* 191 */       extraMap.put("aleardy_tread_times", xAleardyTreadTimes);
/* 192 */       extraMap.put("limit_times", Integer.valueOf(SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day));
/*     */       
/* 194 */       onTreadFriendsCircleFail(20, extraMap);
/* 195 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 199 */     Map<Long, Integer> xBeTrodRoleTodayBeTreadHistoryMap = FriendsCircleManager.refreshAndGetBeTreadFriendsCircleMap(xBeTrodRole2FriendsCircleInfo);
/* 200 */     Integer xAleardyBeTreadTimes = (Integer)xBeTrodRoleTodayBeTreadHistoryMap.get(Long.valueOf(this.roleId));
/* 201 */     if ((xAleardyBeTreadTimes != null) && (xAleardyBeTreadTimes.intValue() >= SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day))
/*     */     {
/*     */ 
/* 204 */       Map<String, Object> extraMap = new HashMap();
/* 205 */       extraMap.put("aleardy_tread_times", xAleardyTreadTimes);
/* 206 */       extraMap.put("aleardy_be_tread_times", xAleardyBeTreadTimes);
/* 207 */       extraMap.put("limit_times", Integer.valueOf(SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day));
/*     */       
/* 209 */       onTreadFriendsCircleFail(20, extraMap);
/*     */       
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     int xOriginalTreasureBoxNum = xBeTrodRole2FriendsCircleInfo.getTreasure_box_num();
/* 215 */     boolean isTriggerBox = false;
/* 216 */     boolean isCanGetMoreTriggerBox = FriendsCircleManager.getTodayGetTreasureBoxNum(xActiveRole2FriendsCircleInfo) < SFriendsCircleConsts.getInstance().max_treasure_box_num_get_every_day;
/*     */     
/* 218 */     if ((xOriginalTreasureBoxNum > 0) && (isCanGetMoreTriggerBox))
/*     */     {
/* 220 */       int randomResult = Xdb.random().nextInt(CommonUtils.WAN_PERCENT);
/* 221 */       if (randomResult < SFriendsCircleConsts.getInstance().tread_circle_get_treasure_box_probability)
/*     */       {
/* 223 */         xBeTrodRole2FriendsCircleInfo.setTreasure_box_num(xOriginalTreasureBoxNum - 1);
/* 224 */         isTriggerBox = true;
/*     */         
/* 226 */         AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(SFriendsCircleConsts.getInstance().treasure_box_award_fix_id, activeUserId, this.roleId, false, false, new mzm.gsp.award.main.AwardReason(LogReason.FRIENDS_CIRCLE_TRIGGER_TREASURE_BOX_AWARD));
/*     */         
/*     */ 
/* 229 */         if (awardModel == null)
/*     */         {
/* 231 */           onTreadFriendsCircleFail(21);
/* 232 */           return false;
/*     */         }
/*     */         
/* 235 */         FriendsCircleManager.addTodayGetTreasureBoxNum(xActiveRole2FriendsCircleInfo, 1);
/*     */       }
/*     */     }
/*     */     
/* 239 */     isCanGetMoreTriggerBox = FriendsCircleManager.getTodayGetTreasureBoxNum(xActiveRole2FriendsCircleInfo) < SFriendsCircleConsts.getInstance().max_treasure_box_num_get_every_day;
/*     */     
/* 241 */     TriggerEventsManger.getInstance().triggerEvent(new FriendsCircleTread(), new FriendsCircleTreadArg(this.roleId, this.beTrodRoleId, isTriggerBox, xOriginalTreasureBoxNum > 0, isCanGetMoreTriggerBox), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 248 */     int treadCicleGetPopularityValue = SFriendsCircleConsts.getInstance().tread_circle_get_popularity_value;
/* 249 */     int leftCanGetPopularity = SFriendsCircleConsts.getInstance().max_get_popularity_by_tread - xBeTrodRole2FriendsCircleInfo.getToday_get_popularity_from_tread();
/*     */     
/* 251 */     int realCanAddPopularityValue = leftCanGetPopularity > treadCicleGetPopularityValue ? treadCicleGetPopularityValue : leftCanGetPopularity;
/*     */     
/*     */ 
/* 254 */     if (realCanAddPopularityValue > 0)
/*     */     {
/* 256 */       FriendsCircleManager.addAndGetWeekPopularity(this.beTrodRoleId, xBeTrodRole2FriendsCircleInfo, realCanAddPopularityValue);
/*     */       
/*     */ 
/* 259 */       int originalTotalPopularityValue = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/* 260 */       int nowTotalPopularityValue = originalTotalPopularityValue + realCanAddPopularityValue;
/*     */       
/* 262 */       xBeTrodRole2FriendsCircleInfo.setTotal_popularity_value(nowTotalPopularityValue);
/* 263 */       xBeTrodRole2FriendsCircleInfo.setToday_get_popularity_from_tread(xBeTrodRole2FriendsCircleInfo.getToday_get_popularity_from_tread() + realCanAddPopularityValue);
/*     */       
/*     */ 
/* 266 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.friendscircle.event.FriendsCirclePopularityAdd(), new FriendsCirclePopularityAddArg(this.beTrodRoleId, realCanAddPopularityValue, xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value(), xBeTrodRole2FriendsCircleInfo.getCurrent_week_popularity_value()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.beTrodRoleId)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 274 */     FriendsCircleManager.addTodayMyTreadPopularity(xActiveRole2FriendsCircleInfo, this.beTrodRoleId);
/*     */     
/* 276 */     FriendsCircleManager.addTodayTreadMePopularity(xBeTrodRole2FriendsCircleInfo, this.roleId);
/*     */     
/* 278 */     STreadFriendsCircleSuccess sTreadFriendsCircleSuccess = new STreadFriendsCircleSuccess();
/* 279 */     sTreadFriendsCircleSuccess.is_trigger_box = (isTriggerBox ? 1 : 0);
/* 280 */     sTreadFriendsCircleSuccess.be_trod_role_id = this.beTrodRoleId;
/* 281 */     sTreadFriendsCircleSuccess.popularity_week_value = xBeTrodRole2FriendsCircleInfo.getCurrent_week_popularity_value();
/* 282 */     sTreadFriendsCircleSuccess.add_popularity_total_value = realCanAddPopularityValue;
/* 283 */     sTreadFriendsCircleSuccess.popularity_total_value = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/* 284 */     sTreadFriendsCircleSuccess.is_auto_tread = (this.isAutoTread ? 1 : 0);
/*     */     
/* 286 */     boolean isNeedSend = true;
/* 287 */     if ((this.isAutoTread) && (realCanAddPopularityValue <= 0))
/*     */     {
/* 289 */       isNeedSend = false;
/*     */     }
/*     */     
/* 292 */     if (isNeedSend)
/*     */     {
/* 294 */       OnlineManager.getInstance().send(this.roleId, sTreadFriendsCircleSuccess);
/*     */     }
/*     */     
/* 297 */     SNotifyFriendsCircleBeTrod sNotifyFriendsCircleBeTrod = new SNotifyFriendsCircleBeTrod();
/* 298 */     sNotifyFriendsCircleBeTrod.current_treasure_box_num = xBeTrodRole2FriendsCircleInfo.getTreasure_box_num();
/* 299 */     sNotifyFriendsCircleBeTrod.is_trigger_box = (isTriggerBox ? 1 : 0);
/* 300 */     sNotifyFriendsCircleBeTrod.popularity_week_value = xBeTrodRole2FriendsCircleInfo.getCurrent_week_popularity_value();
/* 301 */     sNotifyFriendsCircleBeTrod.popularity_total_value = xBeTrodRole2FriendsCircleInfo.getTotal_popularity_value();
/*     */     
/* 303 */     OnlineManager.getInstance().send(this.beTrodRoleId, sNotifyFriendsCircleBeTrod);
/*     */     
/*     */ 
/* 306 */     long serialId = FriendsCircleManager.getFriendsCircleSerialId();
/*     */     
/* 308 */     FriendsCircleTreadResult xFriendsCircleTreadResult = Pod.newFriendsCircleTreadResult();
/* 309 */     xFriendsCircleTreadResult.setIs_cross_server(false);
/* 310 */     xFriendsCircleTreadResult.setIs_ssp_replied(false);
/* 311 */     xFriendsCircleTreadResult.setIs_trigger_box(isTriggerBox);
/* 312 */     xFriendsCircleTreadResult.setTread_me_role_id(this.roleId);
/* 313 */     xFriendsCircleTreadResult.setTread_me_zone_id(GameServerInfoManager.getZoneId());
/*     */     
/* 315 */     xBeTrodRole2FriendsCircleInfo.getBe_trod_result().put(Long.valueOf(serialId), xFriendsCircleTreadResult);
/*     */     
/* 317 */     FriendsCircleManager.reportTreadFriendsCircle(this.beTrodRoleId, this.roleId, isTriggerBox ? 1 : 0, realCanAddPopularityValue > 0 ? realCanAddPopularityValue : 0, serialId);
/*     */     
/*     */ 
/* 320 */     tlogTreadFriendsCircle(activeUserId, this.roleId, serialId, this.beTrodRoleId, this.beTrodRoleZoneId);
/*     */     
/* 322 */     StringBuilder sbLog = new StringBuilder();
/* 323 */     sbLog.append("[friendscircle]PCTreadFriendsCircle.handleTreadFriendsCircleOwnServer@tread friends circle own server success");
/* 324 */     sbLog.append("|role_id=").append(this.roleId);
/* 325 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 326 */     sbLog.append("|be_trod_role_zone_id=").append(this.beTrodRoleZoneId);
/* 327 */     sbLog.append("|is_trigger_box=").append(isTriggerBox);
/* 328 */     sbLog.append("|serial_id=").append(serialId);
/*     */     
/* 330 */     GameServer.logger().info(sbLog.toString());
/*     */     
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleTreadFriendsCircleCrossServer()
/*     */   {
/* 340 */     String activeUserId = RoleInterface.getUserId(this.roleId);
/* 341 */     if (activeUserId == null)
/*     */     {
/* 343 */       onTreadFriendsCircleFail(6);
/* 344 */       return false;
/*     */     }
/*     */     
/* 347 */     lock(Lockeys.get(User.getTable(), activeUserId));
/*     */     
/*     */ 
/* 350 */     Role2FriendsCircleInfo xActiveRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*     */     
/* 352 */     if (xActiveRole2FriendsCircleInfo.getCross_server_tread().size() > 20)
/*     */     {
/* 354 */       onTreadFriendsCircleFail(55);
/* 355 */       return false;
/*     */     }
/*     */     
/* 358 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 359 */     if (roleLevel < SFriendsCircleConsts.getInstance().tread_open_role_level)
/*     */     {
/* 361 */       onTreadFriendsCircleFail(45);
/* 362 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 366 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1824, true, true))
/*     */     {
/* 368 */       onTreadFriendsCircleFail(47);
/* 369 */       return false;
/*     */     }
/*     */     
/* 372 */     if (xActiveRole2FriendsCircleInfo.getMy_black_role_list().contains(Long.valueOf(this.beTrodRoleId)))
/*     */     {
/* 374 */       onTreadFriendsCircleFail(64);
/* 375 */       return false;
/*     */     }
/*     */     
/* 378 */     if (xActiveRole2FriendsCircleInfo.getCross_server_black_in_role_set().contains(Long.valueOf(this.beTrodRoleId)))
/*     */     {
/* 380 */       onTreadFriendsCircleFail(65);
/* 381 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 385 */     Map<Long, Integer> xActiveRoleTodayTreadMap = FriendsCircleManager.refreshAndGetActiveTreadFriendsCircleMap(xActiveRole2FriendsCircleInfo);
/*     */     
/* 387 */     Integer xAleardyTreadTimes = (Integer)xActiveRoleTodayTreadMap.get(Long.valueOf(this.beTrodRoleId));
/* 388 */     if ((xAleardyTreadTimes != null) && (xAleardyTreadTimes.intValue() >= SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day))
/*     */     {
/*     */ 
/* 391 */       Map<String, Object> extraMap = new HashMap();
/* 392 */       extraMap.put("aleardy_tread_times", xAleardyTreadTimes);
/* 393 */       extraMap.put("limit_times", Integer.valueOf(SFriendsCircleConsts.getInstance().max_tread_num_every_circle_every_day));
/*     */       
/* 395 */       onTreadFriendsCircleFail(20, extraMap);
/* 396 */       return false;
/*     */     }
/*     */     
/* 399 */     if (RoleStatusInterface.containsStatus(this.roleId, 1827, true))
/*     */     {
/* 401 */       onTreadFriendsCircleFail(55);
/* 402 */       return false;
/*     */     }
/*     */     
/* 405 */     RoleStatusInterface.setStatus(this.roleId, 1827, true);
/*     */     
/* 407 */     boolean isCanGetMoreTriggerBox = FriendsCircleManager.getTodayGetTreasureBoxNum(xActiveRole2FriendsCircleInfo) < SFriendsCircleConsts.getInstance().max_treasure_box_num_get_every_day;
/*     */     
/* 409 */     long treadSerialId = FriendsCircleManager.getFriendsCircleSerialId();
/*     */     
/* 411 */     CrossServerFriendsCircleTread xFriendsCircleTread = Pod.newCrossServerFriendsCircleTread();
/* 412 */     xFriendsCircleTread.setBe_trod_role_id(this.beTrodRoleId);
/* 413 */     xFriendsCircleTread.setBe_trod_role_zone_id(this.beTrodRoleZoneId);
/* 414 */     xFriendsCircleTread.setIs_can_get_more_treasure_box(isCanGetMoreTriggerBox);
/* 415 */     xFriendsCircleTread.setIs_server_replied(false);
/* 416 */     xFriendsCircleTread.setIs_auto_tread(this.isAutoTread);
/*     */     
/* 418 */     xActiveRole2FriendsCircleInfo.getCross_server_tread().put(Long.valueOf(treadSerialId), xFriendsCircleTread);
/*     */     
/* 420 */     FriendsCircleManager.addTodayMyTreadPopularity(xActiveRole2FriendsCircleInfo, this.beTrodRoleId);
/*     */     
/* 422 */     CrossServerInterface.treadFriendsCircle(this.roleId, this.beTrodRoleId, this.beTrodRoleZoneId, isCanGetMoreTriggerBox, this.isAutoTread, treadSerialId);
/*     */     
/*     */ 
/* 425 */     tlogTreadFriendsCircle(activeUserId, this.roleId, treadSerialId, this.beTrodRoleId, this.beTrodRoleZoneId);
/*     */     
/* 427 */     StringBuilder sbLog = new StringBuilder();
/* 428 */     sbLog.append("[friendscircle]PCTreadFriendsCircle.handleTreadFriendsCircleCrossServer@tread friends circle cross server,send hub protocol");
/* 429 */     sbLog.append("|role_id=").append(this.roleId);
/* 430 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 431 */     sbLog.append("|be_trod_role_zone_id=").append(this.beTrodRoleZoneId);
/* 432 */     sbLog.append("|tread_serial_id=").append(treadSerialId);
/*     */     
/* 434 */     GameServer.logger().info(sbLog.toString());
/* 435 */     return true;
/*     */   }
/*     */   
/*     */   private void onTreadFriendsCircleFail(int ret)
/*     */   {
/* 440 */     onTreadFriendsCircleFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onTreadFriendsCircleFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 445 */     StringBuilder sbLog = new StringBuilder();
/* 446 */     sbLog.append("[friendscircle]PCTreadFriendsCircle.processImp@tread friends circle failed");
/* 447 */     sbLog.append("|ret=").append(ret);
/* 448 */     sbLog.append("|role_id=").append(this.roleId);
/* 449 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 450 */     sbLog.append("|be_trod_role_zone_id=").append(this.beTrodRoleZoneId);
/*     */     
/* 452 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 454 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 456 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 459 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 461 */     if (this.isAutoTread)
/*     */     {
/* 463 */       return;
/*     */     }
/* 465 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 466 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 468 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void tlogTreadFriendsCircle(String userId, long roleId, long serialNum, long beTrodRoleId, int beTrodRoleZoneId)
/*     */   {
/* 477 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 479 */     StringBuilder sbLog = new StringBuilder();
/* 480 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 481 */     sbLog.append(userId).append('|');
/* 482 */     sbLog.append(roleId).append('|');
/* 483 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 485 */     sbLog.append(serialNum).append('|');
/* 486 */     sbLog.append(beTrodRoleId).append('|');
/* 487 */     sbLog.append(beTrodRoleZoneId);
/*     */     
/* 489 */     TLogManager.getInstance().addLog(roleId, "FriendsCircleTread", sbLog.toString());
/*     */   }
/*     */   
/*     */   public static class PUnSetCrossServerTread extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PUnSetCrossServerTread(long roleId)
/*     */     {
/* 498 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 504 */       RoleStatusInterface.unsetStatus(this.roleId, 1827);
/* 505 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCTreadFriendsCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */