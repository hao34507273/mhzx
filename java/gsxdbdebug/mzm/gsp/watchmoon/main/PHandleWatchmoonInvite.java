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
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.watchmoon.SInviteSuccessRes;
/*     */ import mzm.gsp.watchmoon.SRefuseWatchmoonRes;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*     */ import mzm.gsp.watchmoon.confbean.SWatchmoonMapCfg;
/*     */ import org.apache.log4j.Logger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PHandleWatchmoonInvite
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long invitorRoleid;
/*     */   private final long inviteeRoleid;
/*     */   private final int refuseOrAgree;
/*     */   private final long inviteTime;
/*     */   
/*     */   public PHandleWatchmoonInvite(long invitorRoleid, long inviteeRoleid, int refuseOrAgree, long inviteTime)
/*     */   {
/*  56 */     this.invitorRoleid = invitorRoleid;
/*  57 */     this.inviteeRoleid = inviteeRoleid;
/*  58 */     this.refuseOrAgree = refuseOrAgree;
/*  59 */     this.inviteTime = inviteTime;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  65 */     if (this.invitorRoleid == this.inviteeRoleid)
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     String invitorUserId = RoleInterface.getUserId(this.invitorRoleid);
/*  71 */     String inviteeUserId = RoleInterface.getUserId(this.inviteeRoleid);
/*  72 */     if ((inviteeUserId == null) || (invitorUserId == null))
/*     */     {
/*  74 */       return false;
/*     */     }
/*  76 */     Map<Long, String> roleid2userid = new HashMap();
/*  77 */     roleid2userid.put(Long.valueOf(this.invitorRoleid), invitorUserId);
/*  78 */     roleid2userid.put(Long.valueOf(this.inviteeRoleid), inviteeUserId);
/*  79 */     Lockeys.lock(User.getTable(), roleid2userid.values());
/*     */     
/*  81 */     List<Long> roleids = new ArrayList();
/*  82 */     roleids.add(Long.valueOf(this.invitorRoleid));
/*  83 */     roleids.add(Long.valueOf(this.inviteeRoleid));
/*  84 */     Lockeys.lock(Role2properties.getTable(), roleids);
/*     */     
/*  86 */     if (!WatchmoonManager.isWatchmoonSwitchOpenForRole(this.inviteeRoleid, this.invitorRoleid))
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(roleid2userid, Arrays.asList(new Long[] { Long.valueOf(this.inviteeRoleid), Long.valueOf(this.invitorRoleid) }), SWatchmoonConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  92 */     if (result.isActivityJoinCountMax())
/*     */     {
/*  94 */       if (ActivityInterface.isToMaxCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID))
/*     */       {
/*  96 */         WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 1, this.invitorRoleid);
/*     */       }
/*     */       
/*  99 */       if (ActivityInterface.isToMaxCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID))
/*     */       {
/* 101 */         WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 1, this.inviteeRoleid);
/*     */       }
/*     */       
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     if (!result.isCanJoin())
/*     */     {
/* 109 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@can join watchmooon failed|invitorRoleid=%d|count1=%d|inviteeRoleid=%d|count2=%d", new Object[] { Long.valueOf(this.invitorRoleid), Integer.valueOf(ActivityInterface.getActivityCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true)), Long.valueOf(this.inviteeRoleid), Integer.valueOf(ActivityInterface.getActivityCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true)) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */       WatchmoonManager.logger.error(logstr);
/* 116 */       return false;
/*     */     }
/* 118 */     if (MapInterface.isXunLuo(this.invitorRoleid))
/*     */     {
/* 120 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 6, this.invitorRoleid);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if (MapInterface.isXunLuo(this.inviteeRoleid))
/*     */     {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     if (!WatchmoonManager.isGangIdSame(this.invitorRoleid, this.inviteeRoleid))
/*     */     {
/* 131 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 3, this.invitorRoleid);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     Watchmoon xInvitor = Role2watchmoon.get(Long.valueOf(this.invitorRoleid));
/* 136 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 137 */     if ((xInvitor == null) || (xInvitor.getInvitetime() + TimeUnit.SECONDS.toMillis(SWatchmoonConsts.getInstance().DEFAULT_REFUSE_TIME) < now) || (xInvitor.getPartenerroleid() != this.inviteeRoleid))
/*     */     {
/*     */ 
/*     */ 
/* 141 */       return false;
/*     */     }
/* 143 */     if (xInvitor.getInvitetime() != this.inviteTime)
/*     */     {
/* 145 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@inviteTime not same as server|invitorRoleid=%d|inviteeRoleid=%d|invite_time=%d|server_invite_time=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid), Long.valueOf(this.inviteTime), Long.valueOf(xInvitor.getInvitetime()) });
/*     */       
/*     */ 
/* 148 */       WatchmoonManager.logger.error(logstr);
/* 149 */       return false;
/*     */     }
/* 151 */     if (RoleStatusInterface.containsStatus(this.invitorRoleid, 28))
/*     */     {
/* 153 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 5, this.invitorRoleid);
/* 154 */       return false;
/*     */     }
/* 156 */     if (RoleStatusInterface.containsStatus(this.inviteeRoleid, 28))
/*     */     {
/* 158 */       return false;
/*     */     }
/* 160 */     if (this.refuseOrAgree == 0)
/*     */     {
/* 162 */       xInvitor.setInvitetime(-1L);
/* 163 */       xInvitor.setPartenerroleid(0L);
/* 164 */       SRefuseWatchmoonRes refuse = new SRefuseWatchmoonRes();
/* 165 */       refuse.roleid2 = this.inviteeRoleid;
/* 166 */       refuse.name2 = RoleInterface.getName(this.inviteeRoleid);
/* 167 */       OnlineManager.getInstance().sendAtOnce(this.invitorRoleid, refuse);
/*     */       
/* 169 */       WatchmoonManager.tlogWatchMoon(this.inviteeRoleid, ActivityInterface.getActivityCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, false), this.invitorRoleid, RoleInterface.getLevel(this.invitorRoleid), ActivityInterface.getActivityCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, false), WatchmoonOperateEnum.REFUSE.value);
/*     */       
/*     */ 
/*     */ 
/* 173 */       return true;
/*     */     }
/*     */     
/* 176 */     List<Long> toReceiveTipList = new ArrayList();
/* 177 */     toReceiveTipList.add(Long.valueOf(this.inviteeRoleid));
/*     */     
/* 179 */     boolean ret = RoleStatusInterface.checkCansetStatus(roleids, 28, true, toReceiveTipList);
/* 180 */     if (!ret)
/*     */     {
/* 182 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@send watch moon invite failed,cannot set watchmoon state|invitorRoleid=%d|count1=%d|inviteeRoleid=%d|count2=%d", new Object[] { Long.valueOf(this.invitorRoleid), Integer.valueOf(ActivityInterface.getActivityCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true)), Long.valueOf(this.inviteeRoleid), Integer.valueOf(ActivityInterface.getActivityCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true)) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 188 */       WatchmoonManager.logger.info(logstr);
/* 189 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 7, this.invitorRoleid);
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     ret = RoleStatusInterface.setStatus(roleids, 28, false);
/* 194 */     if (!ret)
/*     */     {
/* 196 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@watch moon map error,can not set watch moon state|invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/* 199 */       WatchmoonManager.logger.error(logstr);
/* 200 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 7, this.invitorRoleid);
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     if (RoleStatusInterface.containsStatus(this.inviteeRoleid, 34))
/*     */     {
/* 206 */       RoleStatusInterface.unsetStatus(this.inviteeRoleid, 34);
/*     */     }
/* 208 */     ret = RoleStatusInterface.setStatus(this.inviteeRoleid, 2, false);
/* 209 */     if (!ret)
/*     */     {
/* 211 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@inviteeRoleid warch moon set fly status error |invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/* 214 */       WatchmoonManager.logger.info(logstr);
/* 215 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 7, this.inviteeRoleid);
/* 216 */       return false;
/*     */     }
/* 218 */     if (RoleStatusInterface.containsStatus(this.invitorRoleid, 34))
/*     */     {
/* 220 */       RoleStatusInterface.unsetStatus(this.invitorRoleid, 34);
/*     */     }
/* 222 */     ret = RoleStatusInterface.setStatus(this.invitorRoleid, 2, false);
/* 223 */     if (!ret)
/*     */     {
/* 225 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@invitorRoleid warch moon set fly status error |invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/* 228 */       WatchmoonManager.logger.info(logstr);
/* 229 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 7, this.invitorRoleid);
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     if (!OnlineManager.getInstance().isOnline(this.invitorRoleid))
/*     */     {
/* 235 */       WatchmoonManager.sendSAgreeWatchmoonFailedRes(this.inviteeRoleid, 4, this.invitorRoleid);
/* 236 */       return false;
/*     */     }
/* 238 */     int targetmapid = WatchmoonManager.randomMapid();
/* 239 */     if (targetmapid == -1)
/*     */     {
/*     */ 
/* 242 */       String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@watch moon map error empty|invitorRoleid=%d|inviteeRoleid=%d", new Object[] { Long.valueOf(this.invitorRoleid), Long.valueOf(this.inviteeRoleid) });
/*     */       
/*     */ 
/* 245 */       WatchmoonManager.logger.error(logstr);
/* 246 */       return false;
/*     */     }
/* 248 */     int stposx1 = SWatchmoonMapCfg.get(targetmapid).startposX;
/* 249 */     int stposy1 = SWatchmoonMapCfg.get(targetmapid).startposY;
/*     */     
/* 251 */     boolean isCoupleFly = WatchmoonManager.isCoupleFly(this.inviteeRoleid, this.invitorRoleid);
/* 252 */     boolean r = WatchmoonManager.addWatchMoon(this.inviteeRoleid, targetmapid, isCoupleFly, this.invitorRoleid, xInvitor.getInvitetime());
/*     */     
/* 254 */     if (!r)
/*     */     {
/* 256 */       return false;
/*     */     }
/* 258 */     WatchmoonManager.setWatchMoon(xInvitor, targetmapid, isCoupleFly, this.inviteeRoleid);
/*     */     
/* 260 */     SInviteSuccessRes succ = new SInviteSuccessRes();
/* 261 */     succ.roleid1 = this.invitorRoleid;
/* 262 */     succ.roleid2 = this.inviteeRoleid;
/* 263 */     OnlineManager.getInstance().sendMulti(succ, roleids);
/* 264 */     MapInterface.transferToScene(this.invitorRoleid, targetmapid, stposx1, stposy1);
/* 265 */     MapInterface.transferToScene(this.inviteeRoleid, targetmapid, stposx1, stposy1);
/*     */     
/* 267 */     ActivityInterface.tlogActivity(this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/* 268 */     ActivityInterface.tlogActivity(this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*     */     
/* 270 */     Watchmoon xInvitee = Role2watchmoon.get(Long.valueOf(this.inviteeRoleid));
/* 271 */     if (xInvitee == null)
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     FlySession session = new FlySession(SWatchmoonConsts.getInstance().MAX_FLY_TIME + SWatchmoonConsts.getInstance().PREPARE_FLY_TIME, targetmapid, roleids);
/*     */     
/*     */ 
/* 278 */     xInvitor.setSessionid(session.getSessionId());
/* 279 */     xInvitor.setGroupid(session.getSessionId());
/*     */     
/* 281 */     xInvitee.setSessionid(session.getSessionId());
/* 282 */     xInvitee.setGroupid(session.getSessionId());
/*     */     
/* 284 */     int count1 = ActivityInterface.getActivityCount(invitorUserId, this.invitorRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true);
/*     */     
/* 286 */     int count2 = ActivityInterface.getActivityCount(inviteeUserId, this.inviteeRoleid, SWatchmoonConsts.getInstance().ACTIVITY_ID, true);
/*     */     
/* 288 */     String logstr = String.format("[watchmoon]PHandleWatchmoonInvite.processImp@agree watch moon success|invitorRoleid=%d|count1=%d|inviteeRoleid=%d|count2=%d", new Object[] { Long.valueOf(this.invitorRoleid), Integer.valueOf(count1), Long.valueOf(this.inviteeRoleid), Integer.valueOf(count2) });
/*     */     
/*     */ 
/* 291 */     WatchmoonManager.logger.info(logstr);
/*     */     
/* 293 */     WatchmoonManager.tlogWatchMoon(this.inviteeRoleid, count2, this.invitorRoleid, RoleInterface.getLevel(this.invitorRoleid), count1, WatchmoonOperateEnum.AGREE.value);
/*     */     
/* 295 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\PHandleWatchmoonInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */