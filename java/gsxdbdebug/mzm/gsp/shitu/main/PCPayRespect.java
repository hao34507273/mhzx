/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SApprenticePayRespect;
/*     */ import mzm.gsp.shitu.SPayRespectFail;
/*     */ import mzm.gsp.shitu.SPayRespectSuccess;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.Role2PayRespectInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2payrespect;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class PCPayRespect extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long apprenticeRoleId;
/*     */   private final Octets payRespectStr;
/*     */   
/*     */   public PCPayRespect(long apprenticeRoleId, Octets payRespectStr)
/*     */   {
/*  26 */     this.apprenticeRoleId = apprenticeRoleId;
/*  27 */     this.payRespectStr = payRespectStr;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!ShiTuManager.isShiTuPayRespectSwitchOpen(this.apprenticeRoleId, "PCPayRespect.processImp"))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     ApprenticeInfo xSelectApprenticeInfo = Role2shitu.selectApprenticeinfo(Long.valueOf(this.apprenticeRoleId));
/*  39 */     if (xSelectApprenticeInfo == null)
/*     */     {
/*  41 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@role shi tu info is null|apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*  46 */     if (xSelectApprenticeInfo.getTimeinfo().getEndtime() > 0L)
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@chu shi apprentice can not pay respect|apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     long xSelectMasterRoleId = xSelectApprenticeInfo.getMasterroleid();
/*  55 */     if (xSelectMasterRoleId <= 0L)
/*     */     {
/*  57 */       GameServer.logger().error(String.format("[shitu]PCPayPespect.processImp@role not has master|apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*  60 */       return false;
/*     */     }
/*  62 */     String apprenticeUserId = mzm.gsp.role.main.RoleInterface.getUserId(this.apprenticeRoleId);
/*  63 */     String masterUserId = mzm.gsp.role.main.RoleInterface.getUserId(xSelectMasterRoleId);
/*  64 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { apprenticeUserId, masterUserId }));
/*  65 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(xSelectMasterRoleId) }));
/*     */     
/*     */ 
/*  68 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.apprenticeRoleId, 1721, true, true))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  74 */     if (xRole2ShiTuInfo == null)
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@role shi tu info is null|apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(apprenticeUserId, this.apprenticeRoleId, ShiTuConsts.getInstance().payRespectActivityId);
/*     */     
/*  84 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@activity can not join|apprentice_role_id=%d|activity_cfg_id=%d|reason=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Integer.valueOf(ShiTuConsts.getInstance().payRespectActivityId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     ApprenticeInfo xApprenticeInfo = xRole2ShiTuInfo.getApprenticeinfo();
/*  95 */     long masterRoleId = xApprenticeInfo.getMasterroleid();
/*  96 */     if (masterRoleId <= 0L)
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@role not has master|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (masterRoleId != xSelectMasterRoleId)
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@master changes|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/* 109 */       return false;
/*     */     }
/* 111 */     boolean masterIsOnLine = OnlineManager.getInstance().isOnline(masterRoleId);
/* 112 */     if (!masterIsOnLine)
/*     */     {
/* 114 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@master is not online|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 118 */       sSyncPayRespectFailMessage(3);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     int xNowPayRespectTimes = xApprenticeInfo.getNow_pay_respect_times();
/* 123 */     if (xNowPayRespectTimes >= ShiTuConsts.getInstance().payRespectMaxTimes)
/*     */     {
/* 125 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@no left pay respect time left|apprentice_role_id=%d|master_role_id=%d|now_pay_respect_times=%d|pay_respect_max_times=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId), Integer.valueOf(xNowPayRespectTimes), Integer.valueOf(ShiTuConsts.getInstance().payRespectMaxTimes) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 130 */       sSyncPayRespectFailMessage(1);
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     ShiTuManager.checkAndInitPayRespectInfo(this.apprenticeRoleId, masterRoleId);
/*     */     
/* 136 */     Role2PayRespectInfo xApprenticeRole2PayRespectInfo = Role2payrespect.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 138 */     if (xApprenticeRole2PayRespectInfo.getApprentice_is_paying_respect())
/*     */     {
/* 140 */       sSyncPayRespectFailMessage(2);
/* 141 */       GameServer.logger().info(String.format("[shitu]PCPayRespect.processImp@wait for master deal your pay respect|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 149 */     Role2PayRespectInfo xMasterRole2PayRespectInfo = Role2payrespect.get(Long.valueOf(masterRoleId));
/* 150 */     if (xMasterRole2PayRespectInfo.getMaster_is_paying_respect())
/*     */     {
/* 152 */       sSyncPayRespectFailMessage(4);
/* 153 */       GameServer.logger().error(String.format("[shitu]PCPayRespect.processImp@master is in pay respect|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 157 */       return false;
/*     */     }
/* 159 */     xApprenticeRole2PayRespectInfo.setApprentice_is_paying_respect(true);
/* 160 */     xMasterRole2PayRespectInfo.setMaster_is_paying_respect(true);
/*     */     
/* 162 */     long sessionId = new PayRespectSession(ShiTuConsts.getInstance().masterReplyRespectTimes, masterRoleId, this.apprenticeRoleId).getSessionId();
/*     */     
/*     */ 
/*     */ 
/* 166 */     SPayRespectSuccess sPayRespectSuccess = new SPayRespectSuccess();
/* 167 */     OnlineManager.getInstance().send(this.apprenticeRoleId, sPayRespectSuccess);
/*     */     
/*     */ 
/* 170 */     SApprenticePayRespect sApprenticePayRespect = new SApprenticePayRespect();
/* 171 */     sApprenticePayRespect.apprentice_role_id = this.apprenticeRoleId;
/* 172 */     sApprenticePayRespect.pay_respect_str = this.payRespectStr;
/* 173 */     sApprenticePayRespect.session_id = sessionId;
/*     */     
/* 175 */     OnlineManager.getInstance().send(masterRoleId, sApprenticePayRespect);
/*     */     
/* 177 */     ShiTuManager.tlogShiTuPayRespect(this.apprenticeRoleId, apprenticeUserId, masterRoleId, masterUserId, ShiTuPayRespectTLogEnum.APPRENTICE_PAY_RESPECT);
/*     */     
/*     */ 
/* 180 */     GameServer.logger().info(String.format("[shitu]PCPayRespect.processImp@handle pay respect|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private void sSyncPayRespectFailMessage(int result)
/*     */   {
/* 189 */     SPayRespectFail sPayRespectFail = new SPayRespectFail();
/* 190 */     sPayRespectFail.result = result;
/*     */     
/* 192 */     OnlineManager.getInstance().sendAtOnce(this.apprenticeRoleId, sPayRespectFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCPayRespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */