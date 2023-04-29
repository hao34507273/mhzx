/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.csprovider.ssp.SSPContext;
/*     */ import mzm.gsp.csprovider.ssp.SSPInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleOrnamentTypeShowCfg;
/*     */ import mzm.gsp.friendscircle.SSyncFriendsCircleInfo;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.personal.main.PersonalInterface;
/*     */ import mzm.gsp.role.RoleInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.AtomicRangeInteger;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import mzm.gsp.util.UuidUtils.UuidType;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ import xbean.CrossServerFriendsCircleBlackRole;
/*     */ import xbean.CrossServerFriendsCircleGift;
/*     */ import xbean.CrossServerFriendsCircleTread;
/*     */ import xbean.FriendsCircleGiftResult;
/*     */ import xbean.FriendsCircleOrnamentItem;
/*     */ import xbean.FriendsCirclePlaceTreasureResult;
/*     */ import xbean.FriendsCircleTreadResult;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xtable.Role2friendscircle;
/*     */ 
/*     */ public class FriendsCircleManager
/*     */ {
/*  56 */   private static final AtomicRangeInteger autoIncrement = new AtomicRangeInteger(0, 524288);
/*     */   
/*     */   static long getFriendsCircleSerialId()
/*     */   {
/*  60 */     return DateTimeUtils.getCurrTimeInMillis() / 1000L << 32 & 0xFFFFFFFF00000000 | GameServerInfoManager.getLocalId() << 20 | autoIncrement.getAndIncrement();
/*     */   }
/*     */   
/*     */   static int getWeekPopularityValue(long paramLong, boolean paramBoolean)
/*     */   {
/*  65 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = null;
/*  66 */     if (paramBoolean) {
/*  67 */       localRole2FriendsCircleInfo = Role2friendscircle.get(Long.valueOf(paramLong));
/*     */     } else {
/*  69 */       localRole2FriendsCircleInfo = Role2friendscircle.select(Long.valueOf(paramLong));
/*     */     }
/*  71 */     return localRole2FriendsCircleInfo == null ? 0 : getWeekPopularity(paramLong, localRole2FriendsCircleInfo).intValue();
/*     */   }
/*     */   
/*     */   static Role2FriendsCircleInfo getAndInitFriendsCircleInfo(long paramLong)
/*     */   {
/*  76 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = Role2friendscircle.get(Long.valueOf(paramLong));
/*  77 */     if (localRole2FriendsCircleInfo == null)
/*     */     {
/*  79 */       localRole2FriendsCircleInfo = Pod.newRole2FriendsCircleInfo();
/*     */       
/*  81 */       initOrnament(localRole2FriendsCircleInfo);
/*     */       
/*  83 */       long l = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  85 */       localRole2FriendsCircleInfo.setLast_get_treasure_box_time(l);
/*  86 */       localRole2FriendsCircleInfo.setLast_tread_circle_time(l);
/*  87 */       localRole2FriendsCircleInfo.setLast_tread_my_circle_time(l);
/*  88 */       localRole2FriendsCircleInfo.setLast_week_popularity_value_refresh_time(l);
/*  89 */       localRole2FriendsCircleInfo.setUpdate_ornament_result(true);
/*  90 */       localRole2FriendsCircleInfo.setRepair_tread(15);
/*     */       
/*  92 */       Role2friendscircle.add(Long.valueOf(paramLong), localRole2FriendsCircleInfo);
/*     */     }
/*  94 */     return localRole2FriendsCircleInfo;
/*     */   }
/*     */   
/*     */   static Map<Long, Integer> refreshAndGetActiveTreadFriendsCircleMap(Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */   {
/*  99 */     long l = DateTimeUtils.getCurrTimeInMillis();
/* 100 */     if (!DateTimeUtils.isInSameDay(l, paramRole2FriendsCircleInfo.getLast_tread_circle_time())) {
/* 101 */       paramRole2FriendsCircleInfo.getToday_tread_circle_role_id_map().clear();
/*     */     }
/* 103 */     paramRole2FriendsCircleInfo.setLast_tread_circle_time(l);
/*     */     
/* 105 */     return paramRole2FriendsCircleInfo.getToday_tread_circle_role_id_map();
/*     */   }
/*     */   
/*     */   static Map<Long, Integer> refreshAndGetBeTreadFriendsCircleMap(Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */   {
/* 110 */     long l = DateTimeUtils.getCurrTimeInMillis();
/* 111 */     if (!DateTimeUtils.isInSameDay(l, paramRole2FriendsCircleInfo.getLast_tread_my_circle_time()))
/*     */     {
/* 113 */       paramRole2FriendsCircleInfo.getToday_tread_my_circle_role_id_map().clear();
/* 114 */       paramRole2FriendsCircleInfo.setToday_get_popularity_from_tread(0);
/*     */     }
/* 116 */     paramRole2FriendsCircleInfo.setLast_tread_my_circle_time(l);
/*     */     
/* 118 */     return paramRole2FriendsCircleInfo.getToday_tread_my_circle_role_id_map();
/*     */   }
/*     */   
/*     */   static Integer addAndGetWeekPopularity(long paramLong, Role2FriendsCircleInfo paramRole2FriendsCircleInfo, int paramInt)
/*     */   {
/* 123 */     long l1 = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 125 */     long l2 = TimeCommonUtil.getBeforeStartTime(l1, SFriendsCircleConsts.getInstance().popularity_chart_clear_time);
/* 126 */     if (paramRole2FriendsCircleInfo.getLast_week_popularity_value_refresh_time() < l2)
/*     */     {
/* 128 */       paramRole2FriendsCircleInfo.setCurrent_week_popularity_value(0);
/* 129 */       paramRole2FriendsCircleInfo.setLast_week_popularity_value_refresh_time(l1);
/*     */     }
/* 131 */     int i = paramRole2FriendsCircleInfo.getCurrent_week_popularity_value() + paramInt;
/* 132 */     paramRole2FriendsCircleInfo.setCurrent_week_popularity_value(i);
/* 133 */     if ((paramInt > 0) && (OpenInterface.getOpenStatus(469)))
/*     */     {
/* 135 */       FriendsCicrlePopularityChart localFriendsCicrlePopularityChart = new FriendsCicrlePopularityChart(paramLong, i);
/*     */       
/* 137 */       FriendsCicrlePopularityRankManager.getInstance().rank(localFriendsCicrlePopularityChart);
/*     */     }
/* 139 */     return Integer.valueOf(paramRole2FriendsCircleInfo.getCurrent_week_popularity_value());
/*     */   }
/*     */   
/*     */   static Integer getWeekPopularity(long paramLong, Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */   {
/* 144 */     return addAndGetWeekPopularity(paramLong, paramRole2FriendsCircleInfo, 0);
/*     */   }
/*     */   
/*     */   static void addTodayTreadMePopularity(Role2FriendsCircleInfo paramRole2FriendsCircleInfo, long paramLong)
/*     */   {
/* 149 */     long l = DateTimeUtils.getCurrTimeInMillis();
/* 150 */     Map localMap = paramRole2FriendsCircleInfo.getToday_tread_my_circle_role_id_map();
/* 151 */     if (!DateTimeUtils.isInSameDay(l, paramRole2FriendsCircleInfo.getLast_tread_my_circle_time()))
/*     */     {
/* 153 */       localMap.clear();
/* 154 */       paramRole2FriendsCircleInfo.setToday_get_popularity_from_tread(0);
/*     */     }
/* 156 */     paramRole2FriendsCircleInfo.setLast_tread_my_circle_time(l);
/*     */     
/* 158 */     Integer localInteger = (Integer)localMap.get(Long.valueOf(paramLong));
/* 159 */     if (localInteger == null)
/*     */     {
/* 161 */       localInteger = new Integer(0);
/* 162 */       localMap.put(Long.valueOf(paramLong), localInteger);
/*     */     }
/* 164 */     localMap.put(Long.valueOf(paramLong), Integer.valueOf(localInteger.intValue() + 1));
/*     */   }
/*     */   
/*     */   static void addTodayMyTreadPopularity(Role2FriendsCircleInfo paramRole2FriendsCircleInfo, long paramLong)
/*     */   {
/* 169 */     long l = DateTimeUtils.getCurrTimeInMillis();
/* 170 */     Map localMap = paramRole2FriendsCircleInfo.getToday_tread_circle_role_id_map();
/* 171 */     if (!DateTimeUtils.isInSameDay(l, paramRole2FriendsCircleInfo.getLast_tread_circle_time())) {
/* 172 */       localMap.clear();
/*     */     }
/* 174 */     paramRole2FriendsCircleInfo.setLast_tread_circle_time(l);
/*     */     
/* 176 */     Integer localInteger = (Integer)localMap.get(Long.valueOf(paramLong));
/* 177 */     if (localInteger == null)
/*     */     {
/* 179 */       localInteger = new Integer(0);
/* 180 */       localMap.put(Long.valueOf(paramLong), localInteger);
/*     */     }
/* 182 */     localMap.put(Long.valueOf(paramLong), Integer.valueOf(localInteger.intValue() + 1));
/*     */   }
/*     */   
/*     */   static Role2FriendsCircleInfo getFriendsCircleInfo(long paramLong, boolean paramBoolean)
/*     */   {
/* 187 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = null;
/* 188 */     if (paramBoolean) {
/* 189 */       localRole2FriendsCircleInfo = Role2friendscircle.get(Long.valueOf(paramLong));
/*     */     } else {
/* 191 */       localRole2FriendsCircleInfo = Role2friendscircle.select(Long.valueOf(paramLong));
/*     */     }
/* 193 */     if (localRole2FriendsCircleInfo != null) {
/* 194 */       initOrnament(localRole2FriendsCircleInfo);
/*     */     }
/* 196 */     return localRole2FriendsCircleInfo;
/*     */   }
/*     */   
/*     */   static void sSyncRoleFriendsCircleInfo(long paramLong, Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */   {
/* 201 */     SSyncFriendsCircleInfo localSSyncFriendsCircleInfo = new SSyncFriendsCircleInfo();
/* 202 */     if (paramRole2FriendsCircleInfo != null)
/*     */     {
/* 204 */       initOrnament(paramRole2FriendsCircleInfo);
/* 205 */       localSSyncFriendsCircleInfo.current_pendant_item_cfg_id = paramRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id();
/* 206 */       localSSyncFriendsCircleInfo.current_rahmen_item_cfg_id = paramRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id();
/* 207 */       localSSyncFriendsCircleInfo.current_treasure_box_num = paramRole2FriendsCircleInfo.getTreasure_box_num();
/* 208 */       int i = getWeekPopularity(paramLong, paramRole2FriendsCircleInfo).intValue();
/* 209 */       localSSyncFriendsCircleInfo.current_week_popularity_value = i;
/* 210 */       localSSyncFriendsCircleInfo.own_pendant_item_cfg_id_set.addAll(paramRole2FriendsCircleInfo.getOwn_pendant_ornament_map().keySet());
/* 211 */       localSSyncFriendsCircleInfo.own_rahmen_item_cfg_id_set.addAll(paramRole2FriendsCircleInfo.getOwn_rahmen_ornament_map().keySet());
/* 212 */       localSSyncFriendsCircleInfo.receive_gift_num = paramRole2FriendsCircleInfo.getReceive_gift_num();
/* 213 */       localSSyncFriendsCircleInfo.total_popularity_value = paramRole2FriendsCircleInfo.getTotal_popularity_value();
/* 214 */       if ((i > 0) && (OpenInterface.getOpenStatus(469))) {
/* 215 */         FriendsCicrlePopularityRankManager.getInstance().rank(new FriendsCicrlePopularityChart(paramLong, i));
/*     */       }
/* 217 */       localSSyncFriendsCircleInfo.my_black_role_set.addAll(paramRole2FriendsCircleInfo.getMy_black_role_list());
/*     */     }
/*     */     else
/*     */     {
/* 221 */       SFriendsCircleOrnamentTypeShowCfg localSFriendsCircleOrnamentTypeShowCfg = SFriendsCircleOrnamentTypeShowCfg.get(0);
/* 222 */       localSSyncFriendsCircleInfo.current_pendant_item_cfg_id = localSFriendsCircleOrnamentTypeShowCfg.default_item_cfg_id;
/*     */       
/* 224 */       localSFriendsCircleOrnamentTypeShowCfg = SFriendsCircleOrnamentTypeShowCfg.get(1);
/* 225 */       localSSyncFriendsCircleInfo.current_rahmen_item_cfg_id = localSFriendsCircleOrnamentTypeShowCfg.default_item_cfg_id;
/*     */     }
/* 227 */     OnlineManager.getInstance().send(paramLong, localSSyncFriendsCircleInfo);
/*     */   }
/*     */   
/*     */   static void initOrnament(Role2FriendsCircleInfo paramRole2FriendsCircleInfo) { SFriendsCircleOrnamentTypeShowCfg localSFriendsCircleOrnamentTypeShowCfg;
/*     */     long l;
/* 232 */     if (paramRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id() == 0)
/*     */     {
/* 234 */       localSFriendsCircleOrnamentTypeShowCfg = SFriendsCircleOrnamentTypeShowCfg.get(0);
/* 235 */       if (localSFriendsCircleOrnamentTypeShowCfg != null)
/*     */       {
/* 237 */         l = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/* 238 */         paramRole2FriendsCircleInfo.getCurrent_pendant_ornament().setItem_uuid(l);
/* 239 */         paramRole2FriendsCircleInfo.getCurrent_pendant_ornament().setItem_cfg_id(localSFriendsCircleOrnamentTypeShowCfg.default_item_cfg_id);
/*     */       }
/*     */     }
/* 242 */     if (paramRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id() == 0)
/*     */     {
/* 244 */       localSFriendsCircleOrnamentTypeShowCfg = SFriendsCircleOrnamentTypeShowCfg.get(1);
/* 245 */       if (localSFriendsCircleOrnamentTypeShowCfg != null)
/*     */       {
/* 247 */         l = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/* 248 */         paramRole2FriendsCircleInfo.getCurrent_rahmen_ornament().setItem_uuid(l);
/* 249 */         paramRole2FriendsCircleInfo.getCurrent_rahmen_ornament().setItem_cfg_id(localSFriendsCircleOrnamentTypeShowCfg.default_item_cfg_id);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void reportRoleInfo(long paramLong, SSPContext paramSSPContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 257 */     if (GameServerInfoManager.isRoamServer()) {
/* 258 */       return;
/*     */     }
/* 260 */     int i = RoleInterface.getLevel(paramLong);
/*     */     
/* 262 */     String str1 = RoleInterface.getUserId(paramLong);
/* 263 */     String str2 = RoleInterface.getName(paramLong);
/*     */     
/* 265 */     int j = AvatarInterface.getCurrentAvatar(paramLong, true);
/* 266 */     int k = AvatarFrameInterface.getCurrentAvatarFrameId(paramLong, true);
/*     */     
/* 268 */     int m = RoleInterface.getOccupationId(paramLong);
/*     */     
/* 270 */     RoleInfo localRoleInfo = new RoleInfo();
/* 271 */     GangInterface.fillRoleGangInfo(paramLong, localRoleInfo);
/*     */     
/* 273 */     int n = GameServerInfoManager.getGameid();
/* 274 */     int i1 = GameServerInfoManager.getZoneId();
/*     */     
/* 276 */     JSONObject localJSONObject1 = new JSONObject();
/* 277 */     localJSONObject1.put("gameId", n);
/* 278 */     localJSONObject1.put("serverId", i1);
/* 279 */     localJSONObject1.put("roleId", paramLong);
/* 280 */     localJSONObject1.put("userId", str1);
/* 281 */     localJSONObject1.put("level", i);
/* 282 */     localJSONObject1.put("roleName", str2);
/*     */     
/* 284 */     JSONObject localJSONObject2 = new JSONObject();
/* 285 */     localJSONObject2.put("avatar", j);
/* 286 */     localJSONObject2.put("avatarFrameId", k);
/* 287 */     localJSONObject1.put("photoId", localJSONObject2.toString());
/*     */     
/* 289 */     localJSONObject1.put("corpsId", localRoleInfo.gangid);
/* 290 */     localJSONObject1.put("corpsName", localRoleInfo.gangname);
/* 291 */     localJSONObject1.put("prof", String.valueOf(m));
/* 292 */     localJSONObject1.put("race", "0");
/* 293 */     localJSONObject1.put("gender", RoleInterface.getGender(paramLong));
/*     */     
/* 295 */     JSONObject localJSONObject3 = new JSONObject();
/* 296 */     localJSONObject3.put("province", PersonalInterface.getProvince(paramLong, true));
/* 297 */     localJSONObject3.put("city", PersonalInterface.getCity(paramLong, true));
/* 298 */     localJSONObject1.put("location", localJSONObject3.toString());
/*     */     
/* 300 */     long l1 = ForbidInfoManager.getFirbidTalkTime(paramLong);
/* 301 */     String str3 = ForbidInfoManager.getFirbidFriendReason(paramLong);
/*     */     
/* 303 */     localJSONObject1.put("status", l1 > 0L ? 1 : 0);
/* 304 */     localJSONObject1.put("forbidTime", l1);
/* 305 */     localJSONObject1.put("forbidReason", str3 == null ? "" : str3);
/*     */     
/* 307 */     List localList = FriendInterface.getAllFriends(paramLong, true);
/* 308 */     JSONArray localJSONArray = new JSONArray();
/* 309 */     for (Object localObject = localList.iterator(); ((Iterator)localObject).hasNext();)
/*     */     {
/* 311 */       long l2 = ((Long)((Iterator)localObject).next()).longValue();
/*     */       
/* 313 */       JSONObject localJSONObject4 = new JSONObject();
/* 314 */       localJSONObject4.put("gameId", n);
/* 315 */       localJSONObject4.put("roleId", l2);
/*     */       
/* 317 */       localJSONArray.put(localJSONObject4);
/*     */     }
/* 319 */     localJSONObject1.put("friends", localJSONArray);
/*     */     
/* 321 */     localObject = new JSONArray();
/* 322 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = Role2friendscircle.get(Long.valueOf(paramLong));
/*     */     Iterator localIterator;
/* 324 */     if (localRole2FriendsCircleInfo != null) {
/* 325 */       for (localIterator = localRole2FriendsCircleInfo.getMy_black_role_list().iterator(); localIterator.hasNext();)
/*     */       {
/* 327 */         long l3 = ((Long)localIterator.next()).longValue();
/*     */         
/* 329 */         JSONObject localJSONObject5 = new JSONObject();
/* 330 */         localJSONObject5.put("gameId", n);
/* 331 */         localJSONObject5.put("roleId", l3);
/*     */         
/* 333 */         ((JSONArray)localObject).put(localJSONObject5);
/*     */       }
/*     */     }
/* 336 */     localJSONObject1.put("blacklist", localObject);
/*     */     
/* 338 */     sendSSPRpc(localJSONObject1.toString(), 1, paramSSPContext);
/*     */   }
/*     */   
/*     */   static void reportRoleStatusInfo(long paramLong)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 344 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong);
/*     */     
/* 346 */     long l = ForbidInfoManager.getFirbidTalkTime(paramLong);
/* 347 */     String str = ForbidInfoManager.getFirbidFriendReason(paramLong);
/*     */     
/* 349 */     localJSONObject.put("status", l > 0L ? 1 : 0);
/* 350 */     localJSONObject.put("forbidTime", l);
/* 351 */     localJSONObject.put("forbidReason", str == null ? "" : str);
/*     */     
/* 353 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleLocationInfo(long paramLong, int paramInt1, int paramInt2)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 359 */     JSONObject localJSONObject1 = getReportRoleBaseInfo(paramLong);
/*     */     
/* 361 */     JSONObject localJSONObject2 = new JSONObject();
/* 362 */     localJSONObject2.put("province", paramInt1);
/* 363 */     localJSONObject2.put("city", paramInt2);
/* 364 */     localJSONObject1.put("location", localJSONObject2.toString());
/*     */     
/* 366 */     sendSSPRpc(localJSONObject1.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleLevelInfo(long paramLong)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 372 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong);
/*     */     
/* 374 */     int i = RoleInterface.getLevel(paramLong);
/* 375 */     localJSONObject.put("level", i);
/*     */     
/* 377 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleNameInfo(long paramLong)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 383 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong);
/*     */     
/* 385 */     String str = RoleInterface.getName(paramLong);
/* 386 */     localJSONObject.put("roleName", str);
/*     */     
/* 388 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleGenderInfo(long paramLong1, long paramLong2)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 394 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong1);
/*     */     
/* 396 */     localJSONObject.put("gender", String.valueOf(paramLong2));
/*     */     
/* 398 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleAvatarInfo(long paramLong)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 404 */     JSONObject localJSONObject1 = getReportRoleBaseInfo(paramLong);
/*     */     
/* 406 */     int i = AvatarInterface.getCurrentAvatar(paramLong, true);
/* 407 */     int j = AvatarFrameInterface.getCurrentAvatarFrameId(paramLong, true);
/*     */     
/* 409 */     JSONObject localJSONObject2 = new JSONObject();
/* 410 */     localJSONObject2.put("avatar", i);
/* 411 */     localJSONObject2.put("avatarFrameId", j);
/*     */     
/* 413 */     localJSONObject1.put("photoId", localJSONObject2.toString());
/*     */     
/* 415 */     sendSSPRpc(localJSONObject1.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleGangInfo(long paramLong1, long paramLong2, String paramString)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 421 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong1);
/*     */     
/* 423 */     localJSONObject.put("corpsId", paramLong2);
/* 424 */     localJSONObject.put("corpsName", paramString);
/*     */     
/* 426 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportRoleGangInfo(long paramLong)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 432 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong);
/*     */     
/* 434 */     RoleInfo localRoleInfo = new RoleInfo();
/* 435 */     GangInterface.fillRoleGangInfo(paramLong, localRoleInfo);
/*     */     
/* 437 */     localJSONObject.put("corpsId", localRoleInfo.gangid);
/* 438 */     localJSONObject.put("corpsName", localRoleInfo.gangname);
/*     */     
/* 440 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static void reportSetRoleGiftValue(long paramLong, int paramInt, SSPContext paramSSPContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 446 */     int i = GameServerInfoManager.getGameid();
/* 447 */     int j = GameServerInfoManager.getZoneId();
/*     */     
/* 449 */     JSONObject localJSONObject = new JSONObject();
/* 450 */     localJSONObject.put("gameId", i);
/* 451 */     localJSONObject.put("serverId", j);
/* 452 */     localJSONObject.put("roleId", paramLong);
/* 453 */     localJSONObject.put("gainGiftCount", paramInt);
/*     */     
/* 455 */     sendSSPRpc(localJSONObject.toString(), 12, new SSPUpdateImportantValueContext(1));
/*     */   }
/*     */   
/*     */   static void reportSetRoleThisWeekPopularity(long paramLong, int paramInt, SSPContext paramSSPContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 461 */     int i = GameServerInfoManager.getGameid();
/* 462 */     int j = GameServerInfoManager.getZoneId();
/*     */     
/* 464 */     JSONObject localJSONObject = new JSONObject();
/* 465 */     localJSONObject.put("gameId", i);
/* 466 */     localJSONObject.put("serverId", j);
/* 467 */     localJSONObject.put("roleId", paramLong);
/* 468 */     localJSONObject.put("thisWeekPopularity", paramInt);
/*     */     
/* 470 */     sendSSPRpc(localJSONObject.toString(), 12, new SSPUpdateImportantValueContext(1));
/*     */   }
/*     */   
/*     */   static void reportSetRoleCurrentTreasureBoxNum(long paramLong, int paramInt, SSPContext paramSSPContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 476 */     int i = GameServerInfoManager.getGameid();
/* 477 */     int j = GameServerInfoManager.getZoneId();
/*     */     
/* 479 */     JSONObject localJSONObject = new JSONObject();
/* 480 */     localJSONObject.put("gameId", i);
/* 481 */     localJSONObject.put("serverId", j);
/* 482 */     localJSONObject.put("roleId", paramLong);
/* 483 */     localJSONObject.put("giftCount", paramInt);
/*     */     
/* 485 */     sendSSPRpc(localJSONObject.toString(), 12, paramSSPContext);
/*     */   }
/*     */   
/*     */   static void reportSetRoleTotalWeekPopularity(long paramLong, int paramInt, SSPContext paramSSPContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 491 */     int i = GameServerInfoManager.getGameid();
/* 492 */     int j = GameServerInfoManager.getZoneId();
/*     */     
/* 494 */     JSONObject localJSONObject = new JSONObject();
/* 495 */     localJSONObject.put("gameId", i);
/* 496 */     localJSONObject.put("serverId", j);
/* 497 */     localJSONObject.put("roleId", paramLong);
/* 498 */     localJSONObject.put("allPopularity", paramInt);
/*     */     
/* 500 */     sendSSPRpc(localJSONObject.toString(), 12, new SSPUpdateImportantValueContext(1));
/*     */   }
/*     */   
/*     */   static void reportRoleOccupationInfo(long paramLong, int paramInt)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 506 */     JSONObject localJSONObject = getReportRoleBaseInfo(paramLong);
/*     */     
/* 508 */     RoleInfo localRoleInfo = new RoleInfo();
/* 509 */     GangInterface.fillRoleGangInfo(paramLong, localRoleInfo);
/*     */     
/* 511 */     localJSONObject.put("prof", String.valueOf(paramInt));
/*     */     
/* 513 */     sendSSPRpc(localJSONObject.toString(), 1, null);
/*     */   }
/*     */   
/*     */   static JSONObject getReportRoleBaseInfo(long paramLong)
/*     */   {
/* 518 */     String str = RoleInterface.getUserId(paramLong);
/* 519 */     int i = GameServerInfoManager.getGameid();
/* 520 */     int j = GameServerInfoManager.getZoneId();
/*     */     
/* 522 */     JSONObject localJSONObject = new JSONObject();
/* 523 */     localJSONObject.put("gameId", i);
/* 524 */     localJSONObject.put("serverId", j);
/* 525 */     localJSONObject.put("roleId", paramLong);
/* 526 */     localJSONObject.put("userId", str);
/*     */     
/* 528 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   static void reportRoleFriendsChange(long paramLong1, String paramString, long paramLong2, int paramInt)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 534 */     int i = GameServerInfoManager.getGameid();
/*     */     
/* 536 */     JSONObject localJSONObject1 = getReportRoleBaseInfo(paramLong1);
/* 537 */     localJSONObject1.put("changeType", paramInt);
/*     */     
/* 539 */     JSONArray localJSONArray1 = new JSONArray();
/*     */     
/* 541 */     JSONObject localJSONObject2 = new JSONObject();
/* 542 */     localJSONObject2.put("gameId", i);
/* 543 */     localJSONObject2.put("roleId", paramLong2);
/* 544 */     localJSONArray1.put(localJSONObject2);
/* 545 */     localJSONObject1.put("changeList", localJSONArray1);
/*     */     
/* 547 */     JSONArray localJSONArray2 = new JSONArray();
/* 548 */     List localList = FriendInterface.getAllFriends(paramLong1, true);
/* 549 */     for (Iterator localIterator = localList.iterator(); localIterator.hasNext();)
/*     */     {
/* 551 */       long l = ((Long)localIterator.next()).longValue();
/*     */       
/* 553 */       JSONObject localJSONObject3 = new JSONObject();
/* 554 */       localJSONObject3.put("gameId", i);
/* 555 */       localJSONObject3.put("roleId", l);
/*     */       
/* 557 */       localJSONArray2.put(localJSONObject3);
/*     */     }
/* 559 */     localJSONObject1.put("friends", localJSONArray2);
/*     */     
/* 561 */     sendSSPRpc(localJSONObject1.toString(), 7, null);
/*     */   }
/*     */   
/*     */   static void reportRoleBlackListChange(long paramLong1, String paramString, long paramLong2, int paramInt, Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 567 */     JSONObject localJSONObject1 = getReportRoleBaseInfo(paramLong1);
/* 568 */     localJSONObject1.put("changeType", paramInt);
/*     */     
/* 570 */     int i = GameServerInfoManager.getGameid();
/*     */     
/* 572 */     JSONArray localJSONArray1 = new JSONArray();
/*     */     
/* 574 */     JSONObject localJSONObject2 = new JSONObject();
/* 575 */     localJSONObject2.put("gameId", i);
/* 576 */     localJSONObject2.put("roleId", paramLong2);
/* 577 */     localJSONArray1.put(localJSONObject2);
/* 578 */     localJSONObject1.put("changeList", localJSONArray1);
/*     */     
/* 580 */     JSONArray localJSONArray2 = new JSONArray();
/* 581 */     for (Iterator localIterator = paramRole2FriendsCircleInfo.getMy_black_role_list().iterator(); localIterator.hasNext();)
/*     */     {
/* 583 */       long l = ((Long)localIterator.next()).longValue();
/*     */       
/* 585 */       JSONObject localJSONObject3 = new JSONObject();
/* 586 */       localJSONObject3.put("gameId", i);
/* 587 */       localJSONObject3.put("roleId", l);
/*     */       
/* 589 */       localJSONArray2.put(localJSONObject3);
/*     */     }
/* 591 */     localJSONObject1.put("blacklist", localJSONArray2);
/*     */     
/* 593 */     sendSSPRpc(localJSONObject1.toString(), 9, null);
/*     */   }
/*     */   
/*     */   static void reportUpdateSpaceStyle(String paramString, long paramLong, int paramInt1, int paramInt2)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 599 */     JSONObject localJSONObject1 = new JSONObject();
/* 600 */     int i = GameServerInfoManager.getGameid();
/*     */     
/* 602 */     localJSONObject1.put("gameId", i);
/* 603 */     localJSONObject1.put("serverId", GameServerInfoManager.getZoneId());
/* 604 */     localJSONObject1.put("userId", paramString);
/* 605 */     localJSONObject1.put("roleId", paramLong);
/*     */     
/* 607 */     JSONObject localJSONObject2 = new JSONObject();
/* 608 */     localJSONObject2.put("pendant", paramInt1);
/* 609 */     localJSONObject2.put("rahmen", paramInt2);
/*     */     
/* 611 */     localJSONObject1.put("spaceStyle", localJSONObject2.toString());
/*     */     
/* 613 */     sendSSPRpc(localJSONObject1.toString(), 2, null);
/*     */   }
/*     */   
/*     */   static void reportPlaceTreasure(long paramLong1, int paramInt, long paramLong2)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 619 */     JSONObject localJSONObject = new JSONObject();
/* 620 */     localJSONObject.put("ownerGameId", GameServerInfoManager.getGameid());
/* 621 */     localJSONObject.put("ownerId", paramLong1);
/* 622 */     localJSONObject.put("count", paramInt);
/* 623 */     localJSONObject.put("serialId", paramLong2);
/*     */     
/* 625 */     sendSSPRpc(localJSONObject.toString(), 4, new SSPRepeatTimesContext());
/*     */   }
/*     */   
/*     */   static void reportTreadFriendsCircle(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 631 */     JSONObject localJSONObject = new JSONObject();
/* 632 */     int i = GameServerInfoManager.getGameid();
/*     */     
/* 634 */     localJSONObject.put("ownerGameId", i);
/* 635 */     localJSONObject.put("ownerId", paramLong1);
/* 636 */     localJSONObject.put("stepperGameId", i);
/* 637 */     localJSONObject.put("stepperId", paramLong2);
/* 638 */     localJSONObject.put("getGiftCount", paramInt1);
/* 639 */     localJSONObject.put("popularity", paramInt2);
/* 640 */     localJSONObject.put("serialId", paramLong3);
/*     */     
/* 642 */     sendSSPRpc(localJSONObject.toString(), 3, new SSPRepeatTimesContext());
/*     */   }
/*     */   
/*     */   static void reportGiveFriendsCircleGift(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, long paramLong3)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 648 */     JSONObject localJSONObject = new JSONObject();
/* 649 */     int i = GameServerInfoManager.getGameid();
/*     */     
/* 651 */     localJSONObject.put("targetGameId", i);
/* 652 */     localJSONObject.put("targetId", paramLong1);
/* 653 */     localJSONObject.put("giverGameId", i);
/* 654 */     localJSONObject.put("giverId", paramLong2);
/* 655 */     localJSONObject.put("giftId", paramInt1);
/* 656 */     localJSONObject.put("giftCount", paramInt2);
/* 657 */     localJSONObject.put("popularity", paramInt3);
/* 658 */     localJSONObject.put("status", paramInt4);
/* 659 */     localJSONObject.put("message", paramString);
/* 660 */     localJSONObject.put("serialId", paramLong3);
/*     */     
/* 662 */     sendSSPRpc(localJSONObject.toString(), 5, new SSPRepeatTimesContext());
/*     */   }
/*     */   
/*     */   static boolean isFriendsCircleSwitchOpen(long paramLong, int paramInt, boolean paramBoolean)
/*     */   {
/* 667 */     if (!OpenInterface.getOpenStatus(paramInt)) {
/* 668 */       return false;
/*     */     }
/* 670 */     if (OpenInterface.isBanPlay(paramLong, paramInt))
/*     */     {
/* 672 */       if (paramBoolean) {
/* 673 */         OpenInterface.sendBanPlayMsg(paramLong, paramInt);
/*     */       }
/* 675 */       return false;
/*     */     }
/* 677 */     return true;
/*     */   }
/*     */   
/*     */   static void sendSSPRpc(String paramString, int paramInt, SSPContext paramSSPContext)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 683 */     if (GameServerInfoManager.isRoamServer()) {
/* 684 */       return;
/*     */     }
/* 686 */     DataBetweenGameAndSocialSpaceArg localDataBetweenGameAndSocialSpaceArg = new DataBetweenGameAndSocialSpaceArg();
/* 687 */     localDataBetweenGameAndSocialSpaceArg.data.setString(paramString, "UTF-8");
/* 688 */     localDataBetweenGameAndSocialSpaceArg.qtype = paramInt;
/* 689 */     if (!SSPInterface.sendDataBetweenGameAndSocialSpaceRpc(localDataBetweenGameAndSocialSpaceArg, paramSSPContext))
/*     */     {
/* 691 */       StringBuilder localStringBuilder = new StringBuilder();
/* 692 */       localStringBuilder.append("[friendscircle]FriendsCircleManager.sendSSPRpc@send ssp info fail");
/* 693 */       localStringBuilder.append("|arg=").append(localDataBetweenGameAndSocialSpaceArg);
/*     */       
/* 695 */       GameServer.logger().error(localStringBuilder.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendGiveGiftBulletin(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
/*     */   {
/* 701 */     SBulletinInfo localSBulletinInfo = new SBulletinInfo();
/* 702 */     localSBulletinInfo.bulletintype = 46;
/* 703 */     localSBulletinInfo.params.put(Integer.valueOf(1), paramString1);
/* 704 */     localSBulletinInfo.params.put(Integer.valueOf(2), paramString2);
/* 705 */     localSBulletinInfo.params.put(Integer.valueOf(4), String.valueOf(paramInt1));
/* 706 */     localSBulletinInfo.params.put(Integer.valueOf(15), String.valueOf(paramInt2));
/* 707 */     if (paramInt3 > 0) {
/* 708 */       localSBulletinInfo.params.put(Integer.valueOf(34), String.valueOf(paramInt3));
/*     */     }
/* 710 */     localSBulletinInfo.params.put(Integer.valueOf(35), paramString3);
/* 711 */     BulletinInterface.sendBulletin(localSBulletinInfo);
/*     */   }
/*     */   
/*     */   static boolean isRoleLevelFriendsCircleOpen(long paramLong)
/*     */   {
/* 716 */     long l = RoleInterface.getLevel(paramLong);
/* 717 */     if (l < SFriendsCircleConsts.getInstance().friends_circle_open_role_level) {
/* 718 */       return false;
/*     */     }
/* 720 */     return true;
/*     */   }
/*     */   
/*     */   static void repairTreadRoleData(long paramLong, int paramInt)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 726 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = getFriendsCircleInfo(paramLong, true);
/* 727 */     if (localRole2FriendsCircleInfo == null) {
/* 728 */       return;
/*     */     }
/* 730 */     int i = RoleInterface.getLevel(paramLong);
/* 731 */     if (i < SFriendsCircleConsts.getInstance().friends_circle_open_role_level) {
/* 732 */       return;
/*     */     }
/* 734 */     int j = localRole2FriendsCircleInfo.getRepair_tread();
/* 735 */     if ((j & 0xF) == 15)
/*     */     {
/* 737 */       Set localSet = RoleStatusInterface.getStatusSet(paramLong);
/* 738 */       if (localSet.contains(Integer.valueOf(1830))) {
/* 739 */         RoleStatusInterface.unsetStatus(paramLong, 1830);
/*     */       }
/* 741 */       return;
/*     */     }
/* 743 */     localRole2FriendsCircleInfo.getBe_trod_result().clear();
/* 744 */     localRole2FriendsCircleInfo.getBe_sent_gift().clear();
/* 745 */     localRole2FriendsCircleInfo.getPlace_treasure_result().clear();
/*     */     
/* 747 */     RoleStatusInterface.setStatus(paramLong, 1830, false);
/* 748 */     int k; if ((j & 0x1) == 0)
/*     */     {
/* 750 */       k = localRole2FriendsCircleInfo.getTreasure_box_num();
/* 751 */       reportSetRoleCurrentTreasureBoxNum(paramLong, k, new SSPUpdateImportantValueContext(1));
/*     */     }
/* 753 */     if ((j & 0x2) == 0)
/*     */     {
/* 755 */       k = localRole2FriendsCircleInfo.getTotal_popularity_value();
/* 756 */       reportSetRoleTotalWeekPopularity(paramLong, k, new SSPUpdateImportantValueContext(1));
/*     */     }
/* 758 */     if ((j & 0x4) == 0)
/*     */     {
/* 760 */       k = getWeekPopularity(paramLong, localRole2FriendsCircleInfo).intValue();
/* 761 */       reportSetRoleThisWeekPopularity(paramLong, k, new SSPUpdateImportantValueContext(1));
/*     */     }
/* 763 */     if ((j & 0x8) == 0)
/*     */     {
/* 765 */       k = localRole2FriendsCircleInfo.getReceive_gift_num();
/* 766 */       reportSetRoleGiftValue(paramLong, k, new SSPUpdateImportantValueContext(1));
/*     */     }
/*     */   }
/*     */   
/*     */   static void repeatNoResponseReqWhenLogin(long paramLong, Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 773 */     if (paramRole2FriendsCircleInfo == null) {
/* 774 */       return;
/*     */     }
/* 776 */     if (GameServerInfoManager.isRoamServer()) {
/* 777 */       return;
/*     */     }
/* 779 */     for (Object localObject1 = paramRole2FriendsCircleInfo.getCross_server_send_gift().entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*     */       
/* 781 */       l1 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
/* 782 */       localObject3 = (CrossServerFriendsCircleGift)((Map.Entry)localObject2).getValue();
/* 783 */       if (!((CrossServerFriendsCircleGift)localObject3).getIs_server_replied())
/* 784 */         CrossServerInterface.giveFriendsCircleGift(paramLong, RoleInterface.getName(paramLong), ((CrossServerFriendsCircleGift)localObject3).getReceive_gift_role_id(), ((CrossServerFriendsCircleGift)localObject3).getReceive_gift_role_zone_id(), ((CrossServerFriendsCircleGift)localObject3).getItem_cfg_id(), ((CrossServerFriendsCircleGift)localObject3).getItem_grade(), ((CrossServerFriendsCircleGift)localObject3).getItem_num(), ((CrossServerFriendsCircleGift)localObject3).getAdd_popularity_value(), ((CrossServerFriendsCircleGift)localObject3).getMessage(), l1); }
/*     */     long l1;
/*     */     Object localObject3;
/* 787 */     for (localObject1 = paramRole2FriendsCircleInfo.getCross_server_tread().entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*     */       
/* 789 */       l1 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
/* 790 */       localObject3 = (CrossServerFriendsCircleTread)((Map.Entry)localObject2).getValue();
/* 791 */       if (!((CrossServerFriendsCircleTread)localObject3).getIs_server_replied()) {
/* 792 */         CrossServerInterface.treadFriendsCircle(paramLong, ((CrossServerFriendsCircleTread)localObject3).getBe_trod_role_id(), ((CrossServerFriendsCircleTread)localObject3).getBe_trod_role_zone_id(), ((CrossServerFriendsCircleTread)localObject3).getIs_can_get_more_treasure_box(), ((CrossServerFriendsCircleTread)localObject3).getIs_auto_tread(), l1);
/*     */       }
/*     */     }
/* 795 */     for (localObject1 = paramRole2FriendsCircleInfo.getBe_sent_gift().entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*     */       
/* 797 */       l1 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
/* 798 */       localObject3 = (FriendsCircleGiftResult)((Map.Entry)localObject2).getValue();
/* 799 */       if (((FriendsCircleGiftResult)localObject3).getIs_ssp_replied()) {
/* 800 */         CrossServerInterface.deleteFriendsCircleGfitHistory(((FriendsCircleGiftResult)localObject3).getGive_gift_role_id(), paramLong, l1, ((FriendsCircleGiftResult)localObject3).getGive_gift_zone_id());
/*     */       } else {
/* 802 */         reportGiveFriendsCircleGift(paramLong, ((FriendsCircleGiftResult)localObject3).getGive_gift_role_id(), ((FriendsCircleGiftResult)localObject3).getItem_cfg_id(), ((FriendsCircleGiftResult)localObject3).getItem_num(), ((FriendsCircleGiftResult)localObject3).getAdd_popularity_value(), 0, ((FriendsCircleGiftResult)localObject3).getMessage(), l1);
/*     */       }
/*     */     }
/* 805 */     for (localObject1 = paramRole2FriendsCircleInfo.getBe_trod_result().entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*     */       
/* 807 */       l1 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
/* 808 */       localObject3 = (FriendsCircleTreadResult)((Map.Entry)localObject2).getValue();
/* 809 */       if (((FriendsCircleTreadResult)localObject3).getIs_ssp_replied()) {
/* 810 */         CrossServerInterface.deleteFriendsCircleTreadHistory(((FriendsCircleTreadResult)localObject3).getTread_me_role_id(), paramLong, l1, ((FriendsCircleTreadResult)localObject3).getTread_me_zone_id());
/*     */       } else {
/* 812 */         reportTreadFriendsCircle(paramLong, ((FriendsCircleTreadResult)localObject3).getTread_me_role_id(), ((FriendsCircleTreadResult)localObject3).getIs_trigger_box() ? 1 : 0, SFriendsCircleConsts.getInstance().tread_circle_get_popularity_value, l1);
/*     */       }
/*     */     }
/* 815 */     if (paramRole2FriendsCircleInfo.getPlace_treasure_result().isEmpty())
/*     */     {
/* 817 */       localObject1 = RoleStatusInterface.getStatusSet(paramLong);
/* 818 */       if (((Set)localObject1).contains(Integer.valueOf(2001))) {
/* 819 */         RoleStatusInterface.unsetStatus(paramLong, 2001);
/*     */       }
/*     */     }
/* 822 */     localObject1 = paramRole2FriendsCircleInfo.getPlace_treasure_result().entrySet().iterator();
/* 823 */     while (((Iterator)localObject1).hasNext())
/*     */     {
/* 825 */       localObject2 = (Map.Entry)((Iterator)localObject1).next();
/*     */       
/* 827 */       l1 = ((Long)((Map.Entry)localObject2).getKey()).longValue();
/* 828 */       localObject3 = (FriendsCirclePlaceTreasureResult)((Map.Entry)localObject2).getValue();
/* 829 */       if (((FriendsCirclePlaceTreasureResult)localObject3).getIs_ssp_replied()) {
/* 830 */         ((Iterator)localObject1).remove();
/*     */       } else {
/* 832 */         reportPlaceTreasure(paramLong, ((FriendsCirclePlaceTreasureResult)localObject3).getPlace_treasure_count(), l1);
/*     */       }
/*     */     }
/* 835 */     if (!paramRole2FriendsCircleInfo.getUpdate_ornament_result())
/*     */     {
/* 837 */       localObject2 = RoleInterface.getUserId(paramLong);
/*     */       
/* 839 */       reportUpdateSpaceStyle((String)localObject2, paramLong, paramRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id(), paramRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id());
/*     */     }
/* 841 */     Object localObject2 = paramRole2FriendsCircleInfo.getCross_server_black_operator().entrySet().iterator();
/* 842 */     while (((Iterator)localObject2).hasNext())
/*     */     {
/* 844 */       Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
/* 845 */       CrossServerFriendsCircleBlackRole localCrossServerFriendsCircleBlackRole = (CrossServerFriendsCircleBlackRole)localEntry.getValue();
/* 846 */       long l2 = ((Long)localEntry.getKey()).longValue();
/* 847 */       int i = GameServerInfoManager.getZoneidFromRoleid(l2);
/*     */       
/* 849 */       CrossServerInterface.operatorFriendsCircleBlacklist(paramLong, l2, i, localCrossServerFriendsCircleBlackRole.getOperator());
/*     */     }
/*     */   }
/*     */   
/*     */   static int getTodayGetTreasureBoxNum(Role2FriendsCircleInfo paramRole2FriendsCircleInfo)
/*     */   {
/* 855 */     return addTodayGetTreasureBoxNum(paramRole2FriendsCircleInfo, 0);
/*     */   }
/*     */   
/*     */   static int addTodayGetTreasureBoxNum(Role2FriendsCircleInfo paramRole2FriendsCircleInfo, int paramInt)
/*     */   {
/* 860 */     long l = DateTimeUtils.getCurrTimeInMillis();
/* 861 */     if (!DateTimeUtils.isInSameDay(l, paramRole2FriendsCircleInfo.getLast_get_treasure_box_time())) {
/* 862 */       paramRole2FriendsCircleInfo.setToday_get_treasure_box_num(0);
/*     */     }
/* 864 */     paramRole2FriendsCircleInfo.setLast_get_treasure_box_time(l);
/* 865 */     paramRole2FriendsCircleInfo.setToday_get_treasure_box_num(paramRole2FriendsCircleInfo.getToday_get_treasure_box_num() + paramInt);
/*     */     
/* 867 */     return paramRole2FriendsCircleInfo.getToday_get_treasure_box_num();
/*     */   }
/*     */   
/*     */   static boolean timeIsCanAddPopularity()
/*     */   {
/* 872 */     long l1 = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 874 */     long l2 = TimeCommonUtil.getBeforeStartTime(l1, SFriendsCircleConsts.getInstance().popularity_chart_clear_time);
/*     */     
/* 876 */     long l3 = TimeCommonUtil.getNextStartTime(l1, SFriendsCircleConsts.getInstance().popularity_chart_clear_time);
/*     */     
/* 878 */     long l4 = 360000L;
/* 879 */     if ((l3 - l1 < 360000L) || (l1 - l2 < 360000L)) {
/* 880 */       return false;
/*     */     }
/* 882 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogFriendsCircleAddBlacklist(String paramString, long paramLong1, long paramLong2, int paramInt)
/*     */   {
/* 887 */     int i = RoleInterface.getLevel(paramLong1);
/*     */     
/* 889 */     StringBuilder localStringBuilder = new StringBuilder();
/* 890 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 891 */     localStringBuilder.append(paramString).append('|');
/* 892 */     localStringBuilder.append(paramLong1).append('|');
/* 893 */     localStringBuilder.append(i).append('|');
/*     */     
/* 895 */     localStringBuilder.append(paramLong2).append('|');
/* 896 */     localStringBuilder.append(paramInt);
/*     */     
/* 898 */     TLogManager.getInstance().addLog(paramLong1, "FriendsCircleBlackOperator", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static void tlogRepairFriendsCircleRoleData(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/* 903 */     int i = RoleInterface.getLevel(paramLong);
/*     */     
/* 905 */     StringBuilder localStringBuilder = new StringBuilder();
/* 906 */     localStringBuilder.append(GameServerInfoManager.getHostIP()).append('|');
/* 907 */     localStringBuilder.append(paramString).append('|');
/* 908 */     localStringBuilder.append(paramLong).append('|');
/* 909 */     localStringBuilder.append(i).append('|');
/*     */     
/* 911 */     localStringBuilder.append(paramInt1).append('|');
/* 912 */     localStringBuilder.append(paramInt2).append('|');
/* 913 */     localStringBuilder.append(paramInt3);
/*     */     
/* 915 */     TLogManager.getInstance().addLog(paramLong, "FriendsCircleRepairRoleData", localStringBuilder.toString());
/*     */   }
/*     */   
/*     */   static int getRoleTotalPopularity(long paramLong, boolean paramBoolean)
/*     */   {
/* 920 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = getFriendsCircleInfo(paramLong, paramBoolean);
/* 921 */     if (localRole2FriendsCircleInfo == null) {
/* 922 */       return 0;
/*     */     }
/* 924 */     return localRole2FriendsCircleInfo.getTotal_popularity_value();
/*     */   }
/*     */   
/*     */   static int getRoleReceiveGift(long paramLong, boolean paramBoolean)
/*     */   {
/* 929 */     Role2FriendsCircleInfo localRole2FriendsCircleInfo = getFriendsCircleInfo(paramLong, paramBoolean);
/* 930 */     if (localRole2FriendsCircleInfo == null) {
/* 931 */       return 0;
/*     */     }
/* 933 */     return localRole2FriendsCircleInfo.getReceive_gift_num();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCircleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */