/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.grc.SRecallFriendFailed;
/*     */ import mzm.gsp.grc.confbean.SRecallFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RecallFriendBackGame;
/*     */ import xbean.RecallUserInfo;
/*     */ 
/*     */ public class PCRecallFriend extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long friendRoleid;
/*     */   private final String friendOpenid;
/*     */   private final int friendZoneid;
/*     */   
/*     */   public PCRecallFriend(long roleid, long friendRoleid, String friendOpenid, int friendZoneid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.friendRoleid = friendRoleid;
/*  33 */     this.friendOpenid = friendOpenid;
/*  34 */     this.friendZoneid = friendZoneid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.friendRoleid <= 0L) || (this.friendZoneid <= 0))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (this.friendOpenid.isEmpty())
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!RecallFriendManager.isFunOpen(this.roleid, true))
/*     */     {
/*  51 */       onFailed(4);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!RecallFriendManager.canDoAction(this.roleid, 1931))
/*     */     {
/*  57 */       onFailed(5);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     String userid = RoleInterface.getUserId(this.roleid);
/*  63 */     xbean.User xUser = xtable.User.get(userid);
/*     */     
/*     */ 
/*  66 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  67 */     RecallFriendBackGame xRecallFriendBackGame = xUser.getRecall_friend_back_game();
/*  68 */     if (!DateTimeUtils.isInSameDay(now, xRecallFriendBackGame.getLast_recall_friend_time()))
/*     */     {
/*  70 */       xRecallFriendBackGame.setRecall_friend_times_today(0);
/*  71 */       xRecallFriendBackGame.setCross_recall_friend_times_today(0);
/*     */     }
/*     */     
/*     */ 
/*  75 */     int todayRecallFriendTimes = xRecallFriendBackGame.getRecall_friend_times_today() + xRecallFriendBackGame.getCross_recall_friend_times_today();
/*     */     
/*  77 */     int todayRecallMax = SRecallFriendConsts.getInstance().MAX_RECALL_TIMES_EVERY_DAY;
/*  78 */     if (todayRecallFriendTimes >= todayRecallMax)
/*     */     {
/*  80 */       Map<String, Object> extras = new HashMap();
/*  81 */       extras.put("today_recall_times", Integer.valueOf(todayRecallFriendTimes));
/*  82 */       extras.put("max_recall_times_every", Integer.valueOf(SRecallFriendConsts.getInstance().MAX_RECALL_TIMES_EVERY_DAY));
/*  83 */       onFailed(-4, extras);
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     List<RecallUserInfo> xRecallUserInfoList = xRecallFriendBackGame.getRecall_friend_list();
/*  89 */     RecallUserInfo xRecallUserInfo = null;
/*  90 */     for (RecallUserInfo xTempRecallUserInfo : xRecallUserInfoList)
/*     */     {
/*  92 */       String tmpFriendOpenid = xTempRecallUserInfo.getRecall_openid();
/*  93 */       if (tmpFriendOpenid.isEmpty())
/*     */       {
/*  95 */         String friendUserid = xTempRecallUserInfo.getUser_id();
/*  96 */         tmpFriendOpenid = CommonUtils.getOpenId(friendUserid);
/*  97 */         xTempRecallUserInfo.setRecall_openid(tmpFriendOpenid);
/*     */       }
/*  99 */       if (this.friendOpenid.equals(tmpFriendOpenid))
/*     */       {
/* 101 */         xRecallUserInfo = xTempRecallUserInfo;
/* 102 */         break;
/*     */       }
/*     */     }
/*     */     
/* 106 */     if (xRecallUserInfo == null)
/*     */     {
/* 108 */       xRecallUserInfo = xbean.Pod.newRecallUserInfo();
/* 109 */       xRecallUserInfo.setRecall_openid(this.friendOpenid);
/* 110 */       xRecallUserInfoList.add(xRecallUserInfo);
/*     */     }
/*     */     
/*     */ 
/* 114 */     int period = SRecallFriendConsts.getInstance().RECALL_PERIOD_TIME;
/* 115 */     if (xRecallUserInfo.getRecall_time() + TimeUnit.DAYS.toMillis(period) > now)
/*     */     {
/* 117 */       Map<String, Object> extras = new HashMap();
/* 118 */       extras.put("period_time", Integer.valueOf(period));
/* 119 */       extras.put("current_time_millis", Long.valueOf(now));
/* 120 */       extras.put("recall_time", Long.valueOf(xRecallUserInfo.getRecall_time()));
/* 121 */       onFailed(-2, extras);
/* 122 */       return false;
/*     */     }
/* 124 */     if (xRecallUserInfo.getStart_time() + TimeUnit.DAYS.toMillis(SRecallFriendConsts.getInstance().PERIOD_TIME) <= now)
/*     */     {
/* 126 */       xRecallUserInfo.setBe_recall_num(0);
/*     */     }
/*     */     
/* 129 */     int beRecallNum = SRecallFriendConsts.getInstance().ONE_PERIOD_BE_RECALL_TIMES;
/* 130 */     if (xRecallUserInfo.getBe_recall_num() >= beRecallNum)
/*     */     {
/* 132 */       Map<String, Object> extras = new HashMap();
/* 133 */       extras.put("period_time", Integer.valueOf(period));
/* 134 */       extras.put("current_time_millis", Long.valueOf(now));
/* 135 */       extras.put("recall_time", Long.valueOf(xRecallUserInfo.getRecall_time()));
/* 136 */       onFailed(-5, extras);
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     String openid = CommonUtils.getOpenId(userid);
/* 141 */     OctetsStream osContext = new OctetsStream();
/* 142 */     RecallContext recallContext = new RecallContext();
/* 143 */     recallContext.count = 1;
/* 144 */     recallContext.friendRoleid = this.friendRoleid;
/* 145 */     recallContext.friendZoneid = this.friendZoneid;
/* 146 */     recallContext.roleid = this.roleid;
/* 147 */     recallContext.marshal(osContext);
/*     */     
/* 149 */     long serialNo = RecallFriendManager.getSerialNo();
/* 150 */     if (!GrcManager.recallFriend(openid, this.friendOpenid, serialNo, period, todayRecallMax, beRecallNum, osContext))
/*     */     {
/* 152 */       onFailed(-10);
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     GameServer.logger().info(String.format("[recall]PCRecallFriend.processImp@recall friend success|roleid=%d|friend_zoneid=%d|friend_roleid=%d|friend_openid=%s|serial=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.friendZoneid), Long.valueOf(this.friendRoleid), this.friendOpenid, Long.valueOf(serialNo) }));
/*     */     
/*     */ 
/*     */ 
/* 160 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode)
/*     */   {
/* 171 */     onFailed(retcode, null);
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
/*     */   private void onFailed(int retcode, Map<String, Object> extras)
/*     */   {
/* 184 */     StringBuilder log = new StringBuilder();
/* 185 */     log.append("[recall]PCRecallFriendReq.onFailed@recall friend failed");
/* 186 */     log.append("|retcode=").append(retcode);
/* 187 */     log.append("|roleid=").append(this.roleid);
/* 188 */     log.append("|friend_roleid=").append(this.friendRoleid);
/* 189 */     log.append("|friend_openid=").append(this.friendOpenid);
/* 190 */     log.append("|friend_zoneid=").append(this.friendZoneid);
/* 191 */     if ((extras != null) && (!extras.isEmpty()))
/*     */     {
/* 193 */       for (Map.Entry<String, ?> entry : extras.entrySet())
/*     */       {
/* 195 */         log.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 198 */     GameServer.logger().error(log.toString());
/*     */     
/* 200 */     SRecallFriendFailed msg = new SRecallFriendFailed();
/* 201 */     msg.retcode = retcode;
/* 202 */     msg.role_id = this.friendRoleid;
/* 203 */     msg.zone_id = this.friendZoneid;
/*     */     try
/*     */     {
/* 206 */       msg.open_id.setString(this.friendOpenid, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 211 */     OnlineManager.getInstance().sendAtOnce(this.roleid, msg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCRecallFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */