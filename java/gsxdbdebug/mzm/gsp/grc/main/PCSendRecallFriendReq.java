/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SRecallFriendNormalFail;
/*     */ import mzm.gsp.grc.SSendRecallFriendSuccess;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BeRecalledBackGameInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xbean.RecallUserInfo;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCSendRecallFriendReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long activeRoleId;
/*     */   private int beRecalledFriendZoneId;
/*     */   private long beRecalledFriendRoleId;
/*     */   private final Octets beRecalledFriendOpenIdOctets;
/*     */   
/*     */   public PCSendRecallFriendReq(long activeRoleId, int beRecallFriendZoneId, long beRecallFriendRoleId, Octets beRecallFriendOpenIdOctets)
/*     */   {
/*  54 */     this.activeRoleId = activeRoleId;
/*  55 */     this.beRecalledFriendZoneId = beRecallFriendZoneId;
/*  56 */     this.beRecalledFriendRoleId = beRecallFriendRoleId;
/*  57 */     this.beRecalledFriendOpenIdOctets = beRecallFriendOpenIdOctets;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  63 */     if (!RecallFriendManager.checkMutexStatus(this.activeRoleId))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!RecallFriendManager.isRecallFriendSwitchOpen(this.activeRoleId, true))
/*     */     {
/*  70 */       onSendRecallFriendReqFailed(21);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!GameServerInfoManager.isValidZone(this.beRecalledFriendZoneId))
/*     */     {
/*  76 */       Map<String, Object> extraMap = new HashMap();
/*  77 */       extraMap.put("zone_ids", GameServerInfoManager.getZoneIds().toString());
/*  78 */       extraMap.put("be_recall_friend_zone_id", Long.valueOf(this.beRecalledFriendRoleId));
/*     */       
/*  80 */       onSendRecallFriendReqFailed(18, extraMap);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     String xBeRecalledFriendUserId = RoleInterface.getUserId(this.beRecalledFriendRoleId);
/*  86 */     if (xBeRecalledFriendUserId == null)
/*     */     {
/*  88 */       onSendRecallFriendReqFailed(9);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     String beRecalledFriendOpenId = CommonUtils.getOpenId(xBeRecalledFriendUserId);
/*  94 */     String clientOpenId = this.beRecalledFriendOpenIdOctets.getString("UTF-8");
/*  95 */     if (!clientOpenId.equals(beRecalledFriendOpenId))
/*     */     {
/*  97 */       onSendRecallFriendReqFailed(10);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     String activeUserId = RoleInterface.getUserId(this.activeRoleId);
/* 103 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { xBeRecalledFriendUserId, activeUserId }));
/*     */     
/* 105 */     xbean.User xActiveUser = xtable.User.get(activeUserId);
/* 106 */     xbean.User xBeRecallFriendUser = xtable.User.get(xBeRecalledFriendUserId);
/* 107 */     List<Long> xBeRecallFriendRoleIdList = xBeRecallFriendUser.getRoleids();
/*     */     
/*     */ 
/* 110 */     List<Long> lockRoleIdList = new ArrayList();
/* 111 */     lockRoleIdList.addAll(xBeRecallFriendRoleIdList);
/* 112 */     lockRoleIdList.add(Long.valueOf(this.activeRoleId));
/*     */     
/* 114 */     lock(Role2properties.getTable(), lockRoleIdList);
/*     */     
/* 116 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/* 119 */     RecallFriendBackGame xActiveRecallFriendBackGame = xActiveUser.getRecall_friend_back_game();
/*     */     
/* 121 */     if (!DateTimeUtils.isInSameDay(currentTimeMillis, xActiveRecallFriendBackGame.getLast_recall_friend_time()))
/*     */     {
/* 123 */       xActiveRecallFriendBackGame.setRecall_friend_times_today(0);
/* 124 */       xActiveRecallFriendBackGame.setCross_recall_friend_times_today(0);
/*     */     }
/*     */     
/*     */ 
/* 128 */     int xTodayRecallFriendTimes = xActiveRecallFriendBackGame.getRecall_friend_times_today() + xActiveRecallFriendBackGame.getCross_recall_friend_times_today();
/*     */     
/* 130 */     if (xTodayRecallFriendTimes >= SRecallFriendConsts.getInstance().MAX_RECALL_TIMES_EVERY_DAY)
/*     */     {
/* 132 */       Map<String, Object> extraMap = new HashMap();
/* 133 */       extraMap.put("today_recall_times", Integer.valueOf(xTodayRecallFriendTimes));
/* 134 */       extraMap.put("max_recall_times_every", Integer.valueOf(SRecallFriendConsts.getInstance().MAX_RECALL_TIMES_EVERY_DAY));
/*     */       
/* 136 */       onSendRecallFriendReqFailed(11, extraMap);
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     RecallFriendBackGame xBeRecalledFriendBackGame = xBeRecallFriendUser.getRecall_friend_back_game();
/* 142 */     BeRecalledBackGameInfo xBeRecalledBackGameInfo = xBeRecalledFriendBackGame.getBe_recalled_back_game();
/*     */     
/* 144 */     boolean checkBeRecalledResult = checkBeRecalledTimesCondition(xBeRecalledBackGameInfo, currentTimeMillis, activeUserId);
/*     */     
/* 146 */     if (!checkBeRecalledResult)
/*     */     {
/* 148 */       Map<String, Object> extraMap = new HashMap();
/* 149 */       extraMap.put("x_recall_friend_user_set", xBeRecalledBackGameInfo.getRecall_user_set().toString());
/* 150 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 151 */       extraMap.put("period_begin_time", Long.valueOf(xBeRecalledBackGameInfo.getPeriod_begin_time()));
/* 152 */       extraMap.put("period_time", Integer.valueOf(SRecallFriendConsts.getInstance().PERIOD_TIME));
/*     */       
/* 154 */       onSendRecallFriendReqFailed(12, extraMap);
/* 155 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 159 */     boolean checkRecallResult = RecallFriendManager.checkRecallCondition(xBeRecallFriendUser, true);
/* 160 */     if (!checkRecallResult)
/*     */     {
/* 162 */       Map<String, Object> extraMap = new HashMap();
/* 163 */       extraMap.put("x_recall_friend_user_set", xBeRecalledBackGameInfo.getRecall_user_set().toString());
/* 164 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 165 */       extraMap.put("period_begin_time", Long.valueOf(xBeRecalledBackGameInfo.getPeriod_begin_time()));
/* 166 */       extraMap.put("period_time", Integer.valueOf(SRecallFriendConsts.getInstance().PERIOD_TIME));
/* 167 */       extraMap.put("x_be_user", xBeRecallFriendUser);
/* 168 */       onSendRecallFriendReqFailed(20, extraMap);
/* 169 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 173 */     List<RecallUserInfo> xRecallUserInfoList = xActiveRecallFriendBackGame.getRecall_friend_list();
/* 174 */     RecallUserInfo xRecallUserInfo = null;
/* 175 */     String friendOpenid = this.beRecalledFriendOpenIdOctets.getString("UTF-8");
/* 176 */     for (RecallUserInfo xTempRecallUserInfo : xRecallUserInfoList)
/*     */     {
/* 178 */       String tmpFriendOpenid = xTempRecallUserInfo.getRecall_openid();
/* 179 */       if (tmpFriendOpenid.isEmpty())
/*     */       {
/* 181 */         String friendUserid = xTempRecallUserInfo.getUser_id();
/* 182 */         tmpFriendOpenid = CommonUtils.getOpenId(friendUserid);
/* 183 */         xTempRecallUserInfo.setRecall_openid(tmpFriendOpenid);
/*     */       }
/* 185 */       if (friendOpenid.equals(tmpFriendOpenid))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 191 */         if (currentTimeMillis - xTempRecallUserInfo.getRecall_time() <= SRecallFriendConsts.getInstance().PERIOD_TIME * 86400000L)
/*     */         {
/*     */ 
/* 194 */           Map<String, Object> extraMap = new HashMap();
/* 195 */           extraMap.put("period_time", Integer.valueOf(SRecallFriendConsts.getInstance().PERIOD_TIME));
/* 196 */           extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 197 */           extraMap.put("recall_time", Long.valueOf(xTempRecallUserInfo.getRecall_time()));
/*     */           
/* 199 */           onSendRecallFriendReqFailed(17, extraMap);
/*     */           
/* 201 */           return false;
/*     */         }
/*     */         
/* 204 */         xRecallUserInfo = xTempRecallUserInfo;
/*     */       }
/*     */     }
/*     */     
/* 208 */     if (xRecallUserInfo == null)
/*     */     {
/* 210 */       xRecallUserInfo = Pod.newRecallUserInfo();
/* 211 */       xRecallUserInfoList.add(xRecallUserInfo);
/* 212 */       xRecallUserInfo.setRecall_openid(friendOpenid);
/*     */     }
/* 214 */     xRecallUserInfo.setUser_id(xBeRecalledFriendUserId);
/* 215 */     xRecallUserInfo.setRecall_role_id(this.activeRoleId);
/* 216 */     xRecallUserInfo.setRecall_time(currentTimeMillis);
/*     */     
/* 218 */     if (xBeRecalledBackGameInfo.getBack_game_time() != 0L)
/*     */     {
/* 220 */       xBeRecalledBackGameInfo.setBack_game_time(0L);
/* 221 */       xBeRecalledBackGameInfo.setBack_game_reason(0);
/* 222 */       xBeRecalledBackGameInfo.setPeriod_begin_time(currentTimeMillis);
/* 223 */       xBeRecalledBackGameInfo.setCurrent_period_be_recalled_times(0);
/* 224 */       xBeRecalledBackGameInfo.setBig_gift_awarded_state(false);
/* 225 */       xBeRecalledBackGameInfo.getRecall_user_set().clear();
/* 226 */       xBeRecalledBackGameInfo.getSign_awarded_day_set().clear();
/*     */     }
/*     */     
/*     */ 
/* 230 */     xBeRecalledBackGameInfo.getRecall_user_set().add(activeUserId);
/* 231 */     int oldBeRecalledTimes = xBeRecalledBackGameInfo.getCurrent_period_be_recalled_times();
/* 232 */     xBeRecalledBackGameInfo.setCurrent_period_be_recalled_times(oldBeRecalledTimes + 1);
/*     */     
/*     */ 
/* 235 */     xActiveRecallFriendBackGame.setRecall_friend_times_today(xTodayRecallFriendTimes + 1);
/* 236 */     xActiveRecallFriendBackGame.setLast_recall_friend_time(currentTimeMillis);
/*     */     
/* 238 */     int nowActiveRecallFriendNum = xActiveRecallFriendBackGame.getRecall_friend_num() + 1;
/* 239 */     xActiveRecallFriendBackGame.setRecall_friend_num(nowActiveRecallFriendNum);
/*     */     
/* 241 */     if (isRecallFriendSwitchOpen())
/*     */     {
/* 243 */       AwardModel awardModel = AwardInterface.awardFixAward(SRecallFriendConsts.getInstance().RECALL_FRIEND_FIX_AWARD_ID, activeUserId, this.activeRoleId, true, true, new AwardReason(LogReason.RECALL_FRIEND_AWARD));
/*     */       
/*     */ 
/* 246 */       if (awardModel == null)
/*     */       {
/* 248 */         onSendRecallFriendReqFailed(19);
/* 249 */         return false;
/*     */       }
/*     */     }
/* 252 */     RecallFriendManager.tlogRecallFriend(activeUserId, this.activeRoleId, xBeRecalledFriendUserId, this.beRecalledFriendZoneId, beRecalledFriendOpenId, nowActiveRecallFriendNum);
/*     */     
/*     */ 
/* 255 */     SSendRecallFriendSuccess sendRecallFriendSuccess = new SSendRecallFriendSuccess();
/* 256 */     sendRecallFriendSuccess.role_id = this.beRecalledFriendRoleId;
/* 257 */     sendRecallFriendSuccess.zone_id = this.beRecalledFriendZoneId;
/* 258 */     sendRecallFriendSuccess.open_id = this.beRecalledFriendOpenIdOctets;
/*     */     
/* 260 */     OnlineManager.getInstance().send(this.activeRoleId, sendRecallFriendSuccess);
/*     */     
/* 262 */     GameServer.logger().info(String.format("[recall]PCSendRecallFriendReq.processImp@handle send recall friend req success|active_role_id=%d|be_recalled_friend_zone_id=%d|be_recalled_friend_role_id=%d", new Object[] { Long.valueOf(this.activeRoleId), Integer.valueOf(this.beRecalledFriendZoneId), Long.valueOf(this.beRecalledFriendRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 266 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkBeRecalledTimesCondition(BeRecalledBackGameInfo xBeRecalledBackGameInfo, long currentTimeMillis, String activeUserId)
/*     */   {
/* 284 */     Set<String> xRecallUserSet = xBeRecalledBackGameInfo.getRecall_user_set();
/* 285 */     if (xRecallUserSet.contains(activeUserId))
/*     */     {
/* 287 */       return true;
/*     */     }
/*     */     
/* 290 */     long deltaTime = currentTimeMillis - xBeRecalledBackGameInfo.getPeriod_begin_time();
/* 291 */     long periodTime = SRecallFriendConsts.getInstance().PERIOD_TIME * 86400000L;
/* 292 */     if (deltaTime > periodTime)
/*     */     {
/* 294 */       xBeRecalledBackGameInfo.setPeriod_begin_time(currentTimeMillis);
/* 295 */       xBeRecalledBackGameInfo.setCurrent_period_be_recalled_times(0);
/* 296 */       return true;
/*     */     }
/*     */     
/* 299 */     if (xBeRecalledBackGameInfo.getCurrent_period_be_recalled_times() < SRecallFriendConsts.getInstance().ONE_PERIOD_BE_RECALL_TIMES)
/*     */     {
/* 301 */       return true;
/*     */     }
/*     */     
/* 304 */     Map<String, Object> extraMap = new HashMap();
/* 305 */     extraMap.put("x_recall_friend_user_set", xRecallUserSet.toString());
/* 306 */     extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 307 */     extraMap.put("period_begin_time", Long.valueOf(xBeRecalledBackGameInfo.getPeriod_begin_time()));
/* 308 */     extraMap.put("period_time", Integer.valueOf(SRecallFriendConsts.getInstance().PERIOD_TIME));
/*     */     
/* 310 */     onSendRecallFriendReqFailed(12, extraMap);
/*     */     
/* 312 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSendRecallFriendReqFailed(int ret)
/*     */   {
/* 325 */     onSendRecallFriendReqFailed(ret, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSendRecallFriendReqFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 338 */     StringBuilder sbLog = new StringBuilder();
/* 339 */     sbLog.append("[recall]PCSendRecallFriendReq.processImp@send recall friend req failed");
/* 340 */     sbLog.append("|ret=").append(ret);
/* 341 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/* 342 */     sbLog.append("|be_recalled_friend_zone_id=").append(this.beRecalledFriendZoneId);
/* 343 */     sbLog.append("|be_recalled_friend_role_id=").append(this.beRecalledFriendRoleId);
/* 344 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 346 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 348 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 351 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 353 */     SRecallFriendNormalFail sRecallFriendNormalFail = new SRecallFriendNormalFail();
/* 354 */     sRecallFriendNormalFail.result = ret;
/*     */     
/* 356 */     OnlineManager.getInstance().sendAtOnce(this.activeRoleId, sRecallFriendNormalFail);
/*     */   }
/*     */   
/*     */   private boolean isRecallFriendSwitchOpen()
/*     */   {
/* 361 */     if (!OpenInterface.getOpenStatus(434))
/*     */     {
/* 363 */       return false;
/*     */     }
/* 365 */     if (OpenInterface.isBanPlay(this.activeRoleId, 434))
/*     */     {
/* 367 */       OpenInterface.sendBanPlayMsg(this.activeRoleId, 434);
/* 368 */       return false;
/*     */     }
/* 370 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCSendRecallFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */