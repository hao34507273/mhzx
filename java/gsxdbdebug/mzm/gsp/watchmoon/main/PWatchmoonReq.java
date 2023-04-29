/*     */ package mzm.gsp.watchmoon.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.watchmoon.SSendInviteSuccessRes;
/*     */ import mzm.gsp.watchmoon.SWatchmoonInviteRes;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.Watchmoon;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Role2watchmoon;
/*     */ import xtable.User;
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
/*     */ public class PWatchmoonReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long invitorRoleid;
/*     */   private final long inviteeRoleid;
/*     */   
/*     */   public PWatchmoonReq(long invitorRoleid, long inviteeRoleid)
/*     */   {
/*  45 */     this.invitorRoleid = invitorRoleid;
/*  46 */     this.inviteeRoleid = inviteeRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (this.invitorRoleid == this.inviteeRoleid)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     String invitorUserId = RoleInterface.getUserId(this.invitorRoleid);
/*     */     
/*  59 */     if (invitorUserId == null)
/*     */     {
/*  61 */       String logstr = String.format("[watchmoon]PWatchmoonReq.processImp@invitorUserId null|invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/*  64 */       WatchmoonManager.logger.error(logstr);
/*  65 */       return false;
/*     */     }
/*  67 */     String inviteeUserId = RoleInterface.getUserId(this.inviteeRoleid);
/*     */     
/*  69 */     if (inviteeUserId == null)
/*     */     {
/*  71 */       String logstr = String.format("[watchmoon]PWatchmoonReq.processImp@inviteeUserId null|invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/*  74 */       WatchmoonManager.logger.error(logstr);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     Map<Long, String> roleid2userid = new HashMap();
/*  79 */     roleid2userid.put(Long.valueOf(this.invitorRoleid), invitorUserId);
/*  80 */     roleid2userid.put(Long.valueOf(this.inviteeRoleid), inviteeUserId);
/*  81 */     Lockeys.lock(User.getTable(), roleid2userid.values());
/*     */     
/*  83 */     List<Long> roleids = new ArrayList();
/*  84 */     roleids.add(Long.valueOf(this.invitorRoleid));
/*  85 */     roleids.add(Long.valueOf(this.inviteeRoleid));
/*  86 */     Lockeys.lock(Role2properties.getTable(), roleids);
/*     */     
/*  88 */     if (!WatchmoonManager.isWatchmoonSwitchOpenForRole(this.invitorRoleid, this.inviteeRoleid))
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(roleid2userid, Arrays.asList(new Long[] { Long.valueOf(this.inviteeRoleid), Long.valueOf(this.invitorRoleid) }), SWatchmoonConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  95 */     if (result.isActivityJoinCountMax())
/*     */     {
/*  97 */       if (ActivityInterface.isToMaxCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID))
/*     */       {
/*  99 */         WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 1, this.invitorRoleid);
/*     */       }
/*     */       
/* 102 */       if (ActivityInterface.isToMaxCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID))
/*     */       {
/* 104 */         WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 1, this.inviteeRoleid);
/*     */       }
/*     */       
/* 107 */       return false;
/*     */     }
/* 109 */     if (!result.isCanJoin())
/*     */     {
/* 111 */       String logstr = String.format("[watchmoon]PWatchmoonReq.processImp@can join watchmooon failed|invitorRoleid=%d|count1=%d|inviteeRoleid=%d|count2=%d", new Object[] { Long.valueOf(this.invitorRoleid), Integer.valueOf(ActivityInterface.getActivityCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true)), Long.valueOf(this.inviteeRoleid), Integer.valueOf(ActivityInterface.getActivityCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true)) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */       WatchmoonManager.logger.error(logstr);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (!WatchmoonManager.isGangIdSame(this.invitorRoleid, this.inviteeRoleid))
/*     */     {
/* 123 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 3, this.inviteeRoleid);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(this.invitorRoleid));
/* 128 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 129 */     if ((xWatchmoon != null) && (xWatchmoon.getInvitetime() + TimeUnit.SECONDS.toMillis(SWatchmoonConsts.getInstance().DEFAULT_REFUSE_TIME) >= now))
/*     */     {
/*     */ 
/* 132 */       return false;
/*     */     }
/* 134 */     if (RoleStatusInterface.containsStatus(this.inviteeRoleid, 28))
/*     */     {
/* 136 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 5, this.inviteeRoleid);
/* 137 */       return false;
/*     */     }
/* 139 */     if (RoleStatusInterface.containsStatus(this.invitorRoleid, 28))
/*     */     {
/* 141 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 5, this.invitorRoleid);
/* 142 */       return false;
/*     */     }
/* 144 */     if (MapInterface.isXunLuo(this.invitorRoleid))
/*     */     {
/* 146 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 6, this.invitorRoleid);
/* 147 */       return false;
/*     */     }
/* 149 */     if (MapInterface.isXunLuo(this.inviteeRoleid))
/*     */     {
/* 151 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 6, this.inviteeRoleid);
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     List<Long> toReceiveTipList = new ArrayList();
/* 156 */     toReceiveTipList.add(Long.valueOf(this.invitorRoleid));
/* 157 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.inviteeRoleid, 28, false);
/* 158 */     if (!ret)
/*     */     {
/* 160 */       String logstr = String.format("[watchmoon]PWatchmoonReq.processImp@send watch moon invite failed,inviteeRoleid cannot set watchmoon state|invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/* 163 */       WatchmoonManager.logger.info(logstr);
/* 164 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 7, this.inviteeRoleid);
/* 165 */       return false;
/*     */     }
/* 167 */     ret = RoleStatusInterface.checkCanSetStatus(this.invitorRoleid, 28, false);
/* 168 */     if (!ret)
/*     */     {
/* 170 */       String logstr = String.format("[watchmoon]PWatchmoonReq.processImp@send watch moon invite failed,invitorRoleid cannot set watchmoon state|invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/* 173 */       WatchmoonManager.logger.info(logstr);
/* 174 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 7, this.invitorRoleid);
/* 175 */       return false;
/*     */     }
/* 177 */     if (!OnlineManager.getInstance().isOnline(this.inviteeRoleid))
/*     */     {
/* 179 */       WatchmoonManager.sendSInviteWatchmoonFailedRes(this.invitorRoleid, 4, this.inviteeRoleid);
/* 180 */       return false;
/*     */     }
/* 182 */     SSendInviteSuccessRes sen = new SSendInviteSuccessRes();
/* 183 */     sen.roleid2 = this.inviteeRoleid;
/* 184 */     OnlineManager.getInstance().send(this.invitorRoleid, sen);
/*     */     
/* 186 */     SWatchmoonInviteRes watchmoonInviteRes = new SWatchmoonInviteRes();
/* 187 */     watchmoonInviteRes.roleid1 = this.invitorRoleid;
/* 188 */     watchmoonInviteRes.name1 = RoleInterface.getName(this.invitorRoleid);
/* 189 */     watchmoonInviteRes.invitetime = now;
/* 190 */     OnlineManager.getInstance().send(this.inviteeRoleid, watchmoonInviteRes);
/*     */     
/* 192 */     if (xWatchmoon == null)
/*     */     {
/* 194 */       xWatchmoon = Pod.newWatchmoon();
/* 195 */       Role2watchmoon.insert(Long.valueOf(this.invitorRoleid), xWatchmoon);
/*     */     }
/* 197 */     xWatchmoon.setInvitetime(now);
/* 198 */     xWatchmoon.setPartenerroleid(this.inviteeRoleid);
/* 199 */     int count1 = ActivityInterface.getActivityCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true);
/*     */     
/* 201 */     int count2 = ActivityInterface.getActivityCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true);
/*     */     
/* 203 */     String logstr = String.format("[watchmoon]PWatchmoonReq.processImp@send watch moon invite success|invitorRoleid=%d|count1=%d|inviteeRoleid=%d|count2=%d", new Object[] { Long.valueOf(this.invitorRoleid), Integer.valueOf(count1), Long.valueOf(this.inviteeRoleid), Integer.valueOf(count2) });
/*     */     
/*     */ 
/* 206 */     WatchmoonManager.logger.info(logstr);
/* 207 */     WatchmoonManager.tlogWatchMoon(this.invitorRoleid, count1, this.inviteeRoleid, RoleInterface.getLevel(this.inviteeRoleid), count2, WatchmoonOperateEnum.INVITE.value);
/*     */     
/*     */ 
/* 210 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\PWatchmoonReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */