/*     */ package mzm.gsp.skylantern.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.greetingcard.GreetingCardData;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.midautumnholiday.confbean.SSkyLanternCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skylantern.SSendSkyLanternFail;
/*     */ import mzm.gsp.skylantern.SSynSendSkyLantern;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSendSkyLanternReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgid;
/*     */   private final int channel;
/*     */   private final GreetingCardData data;
/*     */   
/*     */   public PCSendSkyLanternReq(long roleId, int activityCfgid, int channel, GreetingCardData data)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.activityCfgid = activityCfgid;
/*  33 */     this.channel = channel;
/*  34 */     this.data = data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (this.activityCfgid <= 0)
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  50 */     SSkyLanternCfg sSkyLanternCfg = SSkyLanternCfg.get(this.activityCfgid);
/*  51 */     if (sSkyLanternCfg == null)
/*     */     {
/*  53 */       onFailed(3);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  60 */     if (!SkyLanternManager.isFunOpen(this.roleId, sSkyLanternCfg.openId))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userid = RoleInterface.getUserId(this.roleId);
/*  66 */     if (userid == null)
/*     */     {
/*  68 */       onFailed(2);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  79 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1881, true, true))
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, this.activityCfgid);
/*     */     
/*  91 */     if (!result.isCanJoin())
/*     */     {
/*  93 */       Map<String, Object> extras = new HashMap();
/*  94 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/*  95 */       onFailed(6, extras);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 102 */     if (!SkyLanternManager.isNearByPos(this.roleId, sSkyLanternCfg.mapCfgId, sSkyLanternCfg.mapTransferX, sSkyLanternCfg.mapTransferY))
/*     */     {
/*     */ 
/* 105 */       onFailed(5);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 112 */     int resultCode = SkyLanternManager.sendGreetingCardWithoutBagItem(this.roleId, sSkyLanternCfg.cardItemCfgId, this.channel, this.data);
/*     */     
/* 114 */     if (resultCode > 0)
/*     */     {
/* 116 */       onFailed(resultCode);
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     ActivityInterface.addActivityCount(userid, this.roleId, this.activityCfgid);
/*     */     
/*     */ 
/* 128 */     ActivityInterface.logActivity(this.roleId, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 130 */     ActivityInterface.tlogActivity(this.roleId, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 133 */     SSynSendSkyLantern syn = new SSynSendSkyLantern();
/* 134 */     syn.role_id = this.roleId;
/* 135 */     syn.activity_id = this.activityCfgid;
/*     */     
/* 137 */     MapInterface.brocadCastInSomebodyView(this.roleId, syn, false);
/*     */     
/* 139 */     OnlineManager.getInstance().send(this.roleId, syn);
/*     */     
/* 141 */     GameServer.logger().info(String.format("[skylantern]PCSendSkyLanternReq.processImp@ success|roleId=%d|activityCfgid=%d|channel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.channel) }));
/*     */     
/*     */ 
/*     */ 
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 150 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 161 */     SSendSkyLanternFail rsp = new SSendSkyLanternFail();
/* 162 */     rsp.activity_id = this.activityCfgid;
/* 163 */     rsp.error_code = retcode;
/* 164 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 166 */     StringBuffer logBuilder = new StringBuffer();
/* 167 */     logBuilder.append("[skylantern]PCSendSkyLanternReq.onFailed@ failed");
/* 168 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 169 */     logBuilder.append('|').append("activityCfgid=").append(this.activityCfgid);
/* 170 */     logBuilder.append('|').append("channel=").append(this.channel);
/* 171 */     logBuilder.append('|').append("error_code=").append(retcode);
/*     */     
/* 173 */     if (extraParams != null)
/*     */     {
/* 175 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 177 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 181 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skylantern\main\PCSendSkyLanternReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */