/*     */ package mzm.gsp.addiction.handler;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import jsonio.JsonStream;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.addiction.confbean.SAddictionCfg;
/*     */ import mzm.gsp.addiction.main.AddictionManager;
/*     */ import mzm.gsp.addiction.pro.ProManager;
/*     */ import mzm.gsp.addiction.pro.UpdateUserInfoResp;
/*     */ import mzm.gsp.addiction.pro.core.CommRsp;
/*     */ import mzm.gsp.open.main.OpenInterface;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UpdateUserInfoHandler
/*     */   implements Handler
/*     */ {
/*     */   public void handle(String data)
/*     */   {
/*  32 */     CommRsp commRsp = new CommRsp();
/*  33 */     JsonStream js = new JsonStream(data);
/*  34 */     js.unmarshal("comm_rsp", commRsp);
/*     */     
/*  36 */     if (commRsp.ret != 0)
/*     */     {
/*  38 */       GameServer.logger().error(String.format("[addiction]UpdateUserInfoHandler.handle@update user info handler error|ret=%d|error_msg=%s", new Object[] { Integer.valueOf(commRsp.ret), commRsp.err_msg }));
/*     */       
/*     */ 
/*  41 */       return;
/*     */     }
/*     */     
/*  44 */     UpdateUserInfoResp userInfo = new UpdateUserInfoResp();
/*  45 */     js.unmarshal("user_info", userInfo);
/*     */     
/*  47 */     new POnUpdateUserInfo(userInfo).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   public void onFailed(int retCode, String queryInfo, Octets context)
/*     */   {
/*  53 */     GameServer.logger().error(String.format("[addiction]UpdateUserInfoHandler.onFailed@handle failed|retcode=%d|query_info=%s", new Object[] { Integer.valueOf(retCode), queryInfo }));
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnUpdateUserInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final UpdateUserInfoResp rsp;
/*     */     
/*     */     public POnUpdateUserInfo(UpdateUserInfoResp rsp)
/*     */     {
/*  64 */       this.rsp = rsp;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  70 */       long roleid = Long.parseLong(this.rsp.character_id);
/*  71 */       String userid = RoleInterface.getUserId(roleid);
/*  72 */       lock(Lockeys.get(User.getTable(), userid));
/*  73 */       OnlineInfo xOnlineInfo = Role2onlineinfo.get(Long.valueOf(roleid));
/*  74 */       if (xOnlineInfo == null)
/*     */       {
/*  76 */         GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@logic error|openid=%s|roleid=%d", new Object[] { this.rsp.account_id, Long.valueOf(roleid) }));
/*     */         
/*     */ 
/*  79 */         return false;
/*     */       }
/*     */       
/*  82 */       int accumuTime = this.rsp.accumu_time;
/*  83 */       xOnlineInfo.setAccumu_time(accumuTime);
/*  84 */       int healthyGameFlag = this.rsp.healthy_game_flag;
/*  85 */       if (healthyGameFlag == 0)
/*     */       {
/*  87 */         GameServer.logger().info(String.format("[addiction]POnUpdateUserInfo.processImp@update user info|roleid=%d|healthy_game_flag=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag) }));
/*     */         
/*     */ 
/*     */ 
/*  91 */         return true;
/*     */       }
/*     */       
/*  94 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  95 */       if (healthyGameFlag == 1)
/*     */       {
/*  97 */         SAddictionCfg addictionCfg = SAddictionCfg.get(xOnlineInfo.getIs_adult());
/*  98 */         if (addictionCfg == null)
/*     */         {
/* 100 */           GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@addiction cfg is null|roleid=%d|healthy_game_flag=%d|accume_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime) }));
/*     */           
/*     */ 
/*     */ 
/* 104 */           return false;
/*     */         }
/*     */         
/* 107 */         int leftTime = 0;
/* 108 */         int totalOnlineTime = (int)TimeUnit.MINUTES.toSeconds(addictionCfg.totalOnlineTime);
/* 109 */         if (accumuTime < totalOnlineTime)
/*     */         {
/* 111 */           leftTime = totalOnlineTime - accumuTime;
/*     */         }
/*     */         else
/*     */         {
/* 115 */           leftTime = 3600 - accumuTime % 3600;
/*     */         }
/* 117 */         AddictionManager.sendReportOnlineTimeSuccess(roleid, true, 2, accumuTime, leftTime);
/*     */         
/* 119 */         ProManager.reportRemind(userid, roleid, 2, TimeUnit.MILLISECONDS.toSeconds(now));
/* 120 */         GameServer.logger().info(String.format("[addiction]POnUpdateUserInfo.processImp@update user info|roleid=%d|healthy_game_flag=%d|accume_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime) }));
/*     */         
/*     */ 
/*     */ 
/* 124 */         return true;
/*     */       }
/*     */       
/* 127 */       if (healthyGameFlag == 2)
/*     */       {
/* 129 */         SAddictionCfg addictionCfg = SAddictionCfg.get(xOnlineInfo.getIs_adult());
/* 130 */         if (addictionCfg == null)
/*     */         {
/* 132 */           GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@addiction cfg is null|roleid=%d|healthy_game_flag=%d|accume_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime) }));
/*     */           
/*     */ 
/*     */ 
/* 136 */           return false;
/*     */         }
/*     */         
/* 139 */         int limitTime = (addictionCfg.totalOnlineTime + 60) * 60;
/* 140 */         if (accumuTime >= limitTime)
/*     */         {
/* 142 */           ProManager.reportRemind(userid, roleid, 4, TimeUnit.MILLISECONDS.toSeconds(now));
/* 143 */           GameServer.logger().info(String.format("[addiction]POnUpdateUserInfo.processImp@update user info|roleid=%d|healthy_game_flag=%d|accume_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 150 */           xOnlineInfo.setKickout_type(2);
/* 151 */           xOnlineInfo.setRest_time(this.rsp.force_exit_rest_time);
/* 152 */           boolean fight = RoleStatusInterface.containsStatus(roleid, 0, true);
/* 153 */           if (!fight)
/*     */           {
/* 155 */             AddictionManager.forbidUserAndSendMsg(userid, roleid, xOnlineInfo);
/* 156 */             ProManager.reportRemind(userid, roleid, 4, TimeUnit.MILLISECONDS.toSeconds(now));
/*     */           }
/* 158 */           GameServer.logger().info(String.format("[addiction]POnUpdateUserInfo.processImp@update user info|roleid=%d|healthy_game_flag=%d|accume_time=%d|fight=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime), Boolean.valueOf(fight) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 163 */         return true;
/*     */       }
/*     */       
/* 166 */       if (healthyGameFlag == 3)
/*     */       {
/* 168 */         if (!OpenInterface.getOpenStatus(486))
/*     */         {
/* 170 */           GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@curfew fun is close|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */           
/* 172 */           return false;
/*     */         }
/*     */         
/* 175 */         xOnlineInfo.setKickout_type(2);
/* 176 */         int endTime = this.rsp.curfew_end_time;
/* 177 */         int resetTime = endTime - (int)TimeUnit.MILLISECONDS.toSeconds(now);
/* 178 */         if (resetTime <= 0)
/*     */         {
/* 180 */           GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@reset time < 0|roleid=%d|curfew_end_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(endTime) }));
/*     */           
/*     */ 
/*     */ 
/* 184 */           return false;
/*     */         }
/* 186 */         xOnlineInfo.setRest_time(resetTime);
/* 187 */         AddictionManager.forbidUserAndSendMsg(userid, roleid, xOnlineInfo);
/* 188 */         ProManager.reportRemind(userid, roleid, 5, TimeUnit.MILLISECONDS.toSeconds(now));
/* 189 */         GameServer.logger().info(String.format("[addiction]POnUpdateUserInfo.processImp@update user info|roleid=%d|healthy_game_flag=%d|accume_time=%d|curfew_end_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime), Integer.valueOf(endTime) }));
/*     */         
/*     */ 
/*     */ 
/* 193 */         return true;
/*     */       }
/*     */       
/* 196 */       if (healthyGameFlag == 4)
/*     */       {
/* 198 */         if (!OpenInterface.getOpenStatus(487))
/*     */         {
/* 200 */           GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@ban play fun is close|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */           
/* 202 */           return false;
/*     */         }
/*     */         
/* 205 */         xOnlineInfo.setKickout_type(2);
/* 206 */         int endTime = this.rsp.ban_end_time;
/* 207 */         int resetTime = endTime - (int)TimeUnit.MILLISECONDS.toSeconds(now);
/* 208 */         if (resetTime <= 0)
/*     */         {
/* 210 */           GameServer.logger().error(String.format("[addiction]POnUpdateUserInfo.processImp@reset time < 0|roleid=%d|ban_end_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(endTime) }));
/*     */           
/*     */ 
/* 213 */           return false;
/*     */         }
/* 215 */         xOnlineInfo.setRest_time(resetTime);
/* 216 */         AddictionManager.forbidUserAndSendMsg(userid, roleid, xOnlineInfo);
/* 217 */         ProManager.reportRemind(userid, roleid, 6, TimeUnit.MILLISECONDS.toSeconds(now));
/* 218 */         GameServer.logger().info(String.format("[addiction]POnUpdateUserInfo.processImp@update user info|roleid=%d|healthy_game_flag=%d|accume_time=%d|ban_end_time=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(healthyGameFlag), Integer.valueOf(accumuTime), Integer.valueOf(endTime) }));
/*     */         
/*     */ 
/*     */ 
/* 222 */         return true;
/*     */       }
/*     */       
/* 225 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\handler\UpdateUserInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */