/*     */ package mzm.gsp.addiction.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.addiction.confbean.SAddictionCfg;
/*     */ import mzm.gsp.addiction.confbean.SAddictionConsts;
/*     */ import mzm.gsp.addiction.pro.GameConfInfoRsp;
/*     */ import mzm.gsp.addiction.pro.ProManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OnlineInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2onlineinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCReportOnlineTime extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final byte status;
/*     */   private String userid;
/*     */   
/*     */   public PCReportOnlineTime(long roleid, byte status)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.status = status;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!AddictionManager.canDoAction(this.roleid, 502))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!AddictionManager.isFunOpen(this.roleid, false))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  49 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  50 */     OnlineInfo xOnlineInfo = Role2onlineinfo.get(Long.valueOf(this.roleid));
/*  51 */     if (xOnlineInfo == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[addiction]PCReportOnlineTime.processImp@xbean is null|userid=%s|roleid=%d", new Object[] { this.userid, Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  61 */     long updateTime = xOnlineInfo.getLastcalcuatetime();
/*  62 */     if (AddictionManager.needDailyReset(updateTime, now))
/*     */     {
/*  64 */       xOnlineInfo.setReport_count(0);
/*  65 */       xOnlineInfo.setPeriod_time(0);
/*  66 */       xOnlineInfo.setSingle_online(0);
/*  67 */       xOnlineInfo.setKickout_type(0);
/*  68 */       xOnlineInfo.setRest_time(0);
/*     */     }
/*  70 */     xOnlineInfo.setLastcalcuatetime(now);
/*     */     
/*  72 */     int reportCount = xOnlineInfo.getReport_count();
/*  73 */     int newReportCount = reportCount + 1;
/*     */     
/*  75 */     int second = SAddictionConsts.getInstance().HEART_BEAT_SECOND;
/*  76 */     if (this.status != 0)
/*     */     {
/*  78 */       xOnlineInfo.setPeriod_time(xOnlineInfo.getPeriod_time() + second);
/*     */     }
/*     */     
/*  81 */     if (newReportCount >= 5)
/*     */     {
/*  83 */       xOnlineInfo.setReport_count(0);
/*  84 */       int periodTime = xOnlineInfo.getPeriod_time();
/*  85 */       xOnlineInfo.setPeriod_time(0);
/*  86 */       if (periodTime > 0)
/*     */       {
/*     */ 
/*  89 */         ProManager.updateUserInfo(this.userid, this.roleid, periodTime, 3);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  94 */       xOnlineInfo.setReport_count(newReportCount);
/*     */     }
/*     */     
/*  97 */     if (this.status == 0)
/*     */     {
/*  99 */       GameServer.logger().info(String.format("[addiction]PCReportOnlineTime.processImp@report success|userid=%s|roleid=%d|single_online=%d|total_online=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(xOnlineInfo.getSingle_online()), Integer.valueOf(xOnlineInfo.getAccumu_time()) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return true;
/*     */     }
/*     */     
/* 106 */     AddictionHelpInfo helpInfo = null;
/* 107 */     int identityType = xOnlineInfo.getIs_adult();
/* 108 */     AddictionCfgInfo configInfo = AddictionManager.getConfig();
/* 109 */     if ((configInfo != null) && (configInfo.rsp != null))
/*     */     {
/* 111 */       helpInfo = remoteConfig(xOnlineInfo, configInfo);
/*     */     }
/*     */     else
/*     */     {
/* 115 */       SAddictionCfg addictionCfg = SAddictionCfg.get(identityType);
/* 116 */       if (addictionCfg == null)
/*     */       {
/* 118 */         GameServer.logger().error(String.format("[addiction]PCReportOnlineTime.processImp@addiction cfg is null|userid=%s|roleid=%d|type=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(identityType) }));
/*     */         
/*     */ 
/*     */ 
/* 122 */         return false;
/*     */       }
/* 124 */       helpInfo = localConfig(xOnlineInfo, addictionCfg);
/*     */     }
/*     */     
/* 127 */     if (helpInfo.kick)
/*     */     {
/* 129 */       AddictionManager.forbidUserAndSendMsg(this.userid, this.roleid, xOnlineInfo);
/* 130 */       ProManager.reportRemind(this.userid, this.roleid, 3, TimeUnit.MILLISECONDS.toSeconds(now));
/*     */     }
/* 132 */     if (helpInfo.remind)
/*     */     {
/* 134 */       ProManager.reportRemind(this.userid, this.roleid, 1, TimeUnit.MILLISECONDS.toSeconds(now));
/*     */     }
/*     */     
/*     */ 
/* 138 */     AddictionManager.sendReportOnlineTimeSuccess(this.roleid, helpInfo.remind, 1, xOnlineInfo.getSingle_online(), helpInfo.leftTime);
/*     */     
/*     */ 
/* 141 */     GameServer.logger().info(String.format("[addiction]PCReportOnlineTime.processImp@report success|userid=%s|roleid=%d|remind=%b|kick=%b|single_online=%d|total_online=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Boolean.valueOf(helpInfo.remind), Boolean.valueOf(helpInfo.kick), Integer.valueOf(xOnlineInfo.getSingle_online()), Integer.valueOf(xOnlineInfo.getAccumu_time()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private AddictionHelpInfo remoteConfig(OnlineInfo xOnlineInfo, AddictionCfgInfo configInfo)
/*     */   {
/* 151 */     boolean isInFight = RoleStatusInterface.containsStatus(this.roleid, 0, true);
/*     */     
/* 153 */     int oldSignleOnline = xOnlineInfo.getSingle_online();
/* 154 */     int newSignleOnline = oldSignleOnline + SAddictionConsts.getInstance().HEART_BEAT_SECOND;
/* 155 */     xOnlineInfo.setSingle_online(newSignleOnline);
/*     */     
/* 157 */     int identityType = xOnlineInfo.getIs_adult();
/* 158 */     int forceExitTime = 0;
/* 159 */     List<Integer> remindTimePoints = new ArrayList();
/* 160 */     int restTime = 0;
/* 161 */     if (identityType == 0)
/*     */     {
/* 163 */       forceExitTime = configInfo.rsp.child_once_game_force_exit_time;
/* 164 */       remindTimePoints.addAll(configInfo.rsp.child_once_game_rest_time_list);
/* 165 */       restTime = configInfo.rsp.child_once_game_force_rest_time;
/*     */     }
/*     */     else
/*     */     {
/* 169 */       forceExitTime = configInfo.rsp.adult_once_game_force_exit_time;
/* 170 */       remindTimePoints.addAll(configInfo.rsp.adult_once_game_rest_time_list);
/* 171 */       restTime = configInfo.rsp.adult_once_game_force_rest_time;
/*     */     }
/*     */     
/* 174 */     boolean remind = false;
/* 175 */     boolean kick = false;
/* 176 */     int leftTime = 0;
/*     */     Iterator i$;
/* 178 */     if (newSignleOnline >= forceExitTime)
/*     */     {
/* 180 */       xOnlineInfo.setKickout_type(1);
/* 181 */       xOnlineInfo.setRest_time(restTime);
/* 182 */       if (!isInFight)
/*     */       {
/* 184 */         kick = true;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 189 */       for (i$ = remindTimePoints.iterator(); i$.hasNext();) { int timePoint = ((Integer)i$.next()).intValue();
/*     */         
/* 191 */         if ((oldSignleOnline < timePoint) && (newSignleOnline >= timePoint))
/*     */         {
/*     */ 
/* 194 */           remind = true;
/* 195 */           leftTime = forceExitTime - newSignleOnline;
/* 196 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 201 */     SAddictionCfg addictionCfg = SAddictionCfg.get(identityType);
/* 202 */     if (addictionCfg != null)
/*     */     {
/* 204 */       if (xOnlineInfo.getAccumu_time() > TimeUnit.MINUTES.toSeconds(addictionCfg.totalOnlineTime))
/*     */       {
/* 206 */         int spillForceExitTime = (int)TimeUnit.MINUTES.toSeconds(addictionCfg.spillOnlineTime);
/* 207 */         int timePoint = spillForceExitTime - SAddictionConsts.getInstance().REMIND_MINUTE * 60;
/* 208 */         if ((oldSignleOnline < timePoint) && (newSignleOnline >= timePoint))
/*     */         {
/*     */ 
/* 211 */           remind = true;
/* 212 */           leftTime = spillForceExitTime - newSignleOnline;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 217 */     return new AddictionHelpInfo(remind, leftTime, kick, restTime);
/*     */   }
/*     */   
/*     */   private AddictionHelpInfo localConfig(OnlineInfo xOnlineInfo, SAddictionCfg addictionCfg)
/*     */   {
/* 222 */     boolean isInFight = RoleStatusInterface.containsStatus(this.roleid, 0, true);
/*     */     
/* 224 */     int oldSignleOnline = xOnlineInfo.getSingle_online();
/* 225 */     int newSignleOnline = oldSignleOnline + SAddictionConsts.getInstance().HEART_BEAT_SECOND;
/* 226 */     xOnlineInfo.setSingle_online(newSignleOnline);
/*     */     
/* 228 */     int forceExitTime = (int)TimeUnit.MINUTES.toSeconds(addictionCfg.singleOnlineTime);
/* 229 */     int restTime = (int)TimeUnit.MINUTES.toSeconds(addictionCfg.singleKickOutTime);
/* 230 */     boolean remind = false;
/* 231 */     boolean kick = false;
/* 232 */     int leftTime = 0;
/* 233 */     if (newSignleOnline >= forceExitTime)
/*     */     {
/* 235 */       xOnlineInfo.setKickout_type(1);
/* 236 */       xOnlineInfo.setRest_time(restTime);
/* 237 */       if (!isInFight)
/*     */       {
/* 239 */         kick = true;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 244 */       int timePoint = forceExitTime - SAddictionConsts.getInstance().REMIND_MINUTE * 60;
/* 245 */       if ((oldSignleOnline < timePoint) && (newSignleOnline >= timePoint))
/*     */       {
/*     */ 
/* 248 */         remind = true;
/* 249 */         leftTime = forceExitTime - newSignleOnline;
/*     */       }
/*     */     }
/*     */     
/* 253 */     if (xOnlineInfo.getAccumu_time() > TimeUnit.MINUTES.toSeconds(addictionCfg.totalOnlineTime))
/*     */     {
/* 255 */       int spillForceExitTime = (int)TimeUnit.MINUTES.toSeconds(addictionCfg.spillOnlineTime);
/* 256 */       int timePoint = spillForceExitTime - SAddictionConsts.getInstance().REMIND_MINUTE * 60;
/* 257 */       if ((oldSignleOnline < timePoint) && (newSignleOnline >= timePoint))
/*     */       {
/*     */ 
/* 260 */         remind = true;
/* 261 */         leftTime = spillForceExitTime - newSignleOnline;
/*     */       }
/*     */     }
/* 264 */     return new AddictionHelpInfo(remind, leftTime, kick, restTime);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\PCReportOnlineTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */