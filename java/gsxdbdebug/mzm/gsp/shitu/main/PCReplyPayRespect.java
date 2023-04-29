/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.shitu.SPayRespectFail;
/*     */ import mzm.gsp.shitu.SReplyPayRespect;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.Role2PayRespectInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2payrespect;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCReplyPayRespect extends LogicProcedure
/*     */ {
/*     */   private final int operator;
/*     */   private final long masterRoleId;
/*     */   private final long apprenticeRoleId;
/*     */   private final long sessionId;
/*     */   
/*     */   public PCReplyPayRespect(int operator, long masterRoleId, long apprenticeRoleId, long sessionId)
/*     */   {
/*  36 */     this.operator = operator;
/*  37 */     this.masterRoleId = masterRoleId;
/*  38 */     this.apprenticeRoleId = apprenticeRoleId;
/*  39 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((this.operator != 1) && (this.operator != 0))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ShiTuManager.isShiTuPayRespectSwitchOpen(this.masterRoleId, "PCPayRespect.processImp"))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     ApprenticeInfo xSelectApprenticeInfo = Role2shitu.selectApprenticeinfo(Long.valueOf(this.apprenticeRoleId));
/*  56 */     if (xSelectApprenticeInfo == null)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[shitu]PCReplyPayRespect.processImp@role select shi tu info is null|operator=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(this.operator), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*  64 */     long xSelectMasterRoleId = xSelectApprenticeInfo.getMasterroleid();
/*  65 */     if ((xSelectMasterRoleId <= 0L) || (xSelectMasterRoleId != this.masterRoleId))
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[shitu]PCReplyPayRespect.processImp@role not has master|operator=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(this.operator), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  74 */     String masterUserId = RoleInterface.getUserId(xSelectMasterRoleId);
/*     */     
/*  76 */     if ((apprenticeUserId == null) || (masterUserId == null))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     lock(User.getTable(), Arrays.asList(new String[] { apprenticeUserId, masterUserId }));
/*  82 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(xSelectMasterRoleId) }));
/*     */     
/*     */ 
/*  85 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1722, true, true))
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  91 */     if (xRole2ShiTuInfo == null)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[shitu]PCReplyPayRespect.processImp@role get shi tu info is null|operator=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(this.operator), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     ApprenticeInfo xApprenticeInfo = xRole2ShiTuInfo.getApprenticeinfo();
/* 100 */     long xMasterRoleId = xApprenticeInfo.getMasterroleid();
/* 101 */     if (xSelectMasterRoleId != xMasterRoleId)
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[shitu]PCReplyPayRespect.processImp@master info changes|operator=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(this.operator), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     Session session = Session.getSession(this.sessionId);
/* 110 */     PayRespectSession payRespectSession = null;
/* 111 */     if ((session instanceof PayRespectSession))
/*     */     {
/* 113 */       payRespectSession = (PayRespectSession)session;
/*     */     }
/*     */     
/* 116 */     if (payRespectSession == null)
/*     */     {
/* 118 */       GameServer.logger().error(String.format("[shitu]PCReplyRespect.processImp@session is not exist,may be expired|master_role_id=%d|apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/* 124 */     if ((payRespectSession.getOwerId() != xMasterRoleId) || (this.apprenticeRoleId != payRespectSession.getApprenticeRoleId()))
/*     */     {
/* 126 */       GameServer.logger().error(String.format("[shitu]PCReplyRespect.processImp@session context not match|session_id=%d|master_role_id=%d|apprentice_role_id=%d|session_master_role_id=%d|session_apprentice_role_id=%d", new Object[] { Long.valueOf(this.sessionId), Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(payRespectSession.getOwerId()), Long.valueOf(payRespectSession.getApprenticeRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     Session.removeSession(this.sessionId);
/*     */     
/* 136 */     ShiTuManager.checkAndInitPayRespectInfo(this.apprenticeRoleId, this.masterRoleId);
/* 137 */     Role2PayRespectInfo xApprenticePayRespectInfo = Role2payrespect.get(Long.valueOf(this.apprenticeRoleId));
/* 138 */     Role2PayRespectInfo xMasterPayRespectInfo = Role2payrespect.get(Long.valueOf(this.masterRoleId));
/* 139 */     if ((!xApprenticePayRespectInfo.getApprentice_is_paying_respect()) || (!xMasterPayRespectInfo.getMaster_is_paying_respect()))
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[shitu]PCReplyRespect.processImp@paying state not match,may be expired|master_role_id=%d|apprentice_role_id=%d|session_id=%d|master_state=%b|apprentice_state=%b", new Object[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.sessionId), Boolean.valueOf(xMasterPayRespectInfo.getMaster_is_paying_respect()), Boolean.valueOf(xApprenticePayRespectInfo.getApprentice_is_paying_respect()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     xApprenticePayRespectInfo.setApprentice_is_paying_respect(false);
/* 151 */     xMasterPayRespectInfo.setMaster_is_paying_respect(false);
/*     */     
/* 153 */     SReplyPayRespect sReplyPayRespect = new SReplyPayRespect();
/* 154 */     sReplyPayRespect.apprentice_role_id = this.apprenticeRoleId;
/* 155 */     sReplyPayRespect.master_role_id = xMasterRoleId;
/* 156 */     if (this.operator == 0)
/*     */     {
/*     */ 
/* 159 */       sReplyPayRespect.operator = 0;
/*     */       
/* 161 */       OnlineManager.getInstance().send(this.apprenticeRoleId, sReplyPayRespect);
/* 162 */       GameServer.logger().info(String.format("[shitu]PCReplyRespect.processImp@master refuse apprentice's pay respect|master_role_id=%d|apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(xMasterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 167 */       ShiTuManager.tlogShiTuPayRespect(this.apprenticeRoleId, apprenticeUserId, this.masterRoleId, masterUserId, ShiTuPayRespectTLogEnum.MASTER_REFUSE);
/*     */       
/* 169 */       return true;
/*     */     }
/*     */     
/* 172 */     boolean apprenticeIsOnLine = OnlineManager.getInstance().isOnline(this.apprenticeRoleId);
/* 173 */     if (!apprenticeIsOnLine)
/*     */     {
/* 175 */       SPayRespectFail sPayRespectFail = new SPayRespectFail();
/* 176 */       sPayRespectFail.result = 5;
/* 177 */       OnlineManager.getInstance().send(this.masterRoleId, sPayRespectFail);
/*     */       
/* 179 */       GameServer.logger().info(String.format("[shitu]PCReplyRespect.processImp@apprentice is not online|master_role_id=%d|apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(xMasterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 183 */       return true;
/*     */     }
/* 185 */     xApprenticeInfo.setNow_pay_respect_times(xApprenticeInfo.getNow_pay_respect_times() + 1);
/*     */     
/* 187 */     int masterRoleLevel = RoleInterface.getLevel(xMasterRoleId);
/* 188 */     int apprenticeRoleLevel = RoleInterface.getLevel(this.apprenticeRoleId);
/* 189 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/* 190 */     int limitRoleLevel = Math.min(masterRoleLevel + ShiTuConsts.getInstance().apprenticeRoleLevelLimit, serverLevel + ShiTuConsts.getInstance().apprenticeRoleLevelLimit);
/*     */     
/*     */ 
/* 193 */     if (apprenticeRoleLevel < limitRoleLevel)
/*     */     {
/* 195 */       AwardReason awardReason = new AwardReason(LogReason.SHI_TU_PAY_RESPECT_AWARD);
/*     */       
/* 197 */       mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(ShiTuConsts.getInstance().apprenticePayRespectAwardExp, apprenticeUserId, this.apprenticeRoleId, true, true, awardReason);
/*     */       
/* 199 */       if (awardModel == null)
/*     */       {
/* 201 */         GameServer.logger().error(String.format("[shitu]PCReplyRespect.processImp@award model is null|master_role_id=%d|apprentice_role_id=%d|session_id=%d", new Object[] { Long.valueOf(xMasterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.sessionId) }));
/*     */         
/*     */ 
/*     */ 
/* 205 */         return false;
/*     */       }
/*     */     }
/* 208 */     int addNum = FriendInterface.addFriendValue(this.apprenticeRoleId, xMasterRoleId, ShiTuConsts.getInstance().payRespectAwardRelationValue, 3);
/*     */     
/*     */ 
/* 211 */     sReplyPayRespect.operator = 1;
/* 212 */     OnlineManager.getInstance().sendMulti(sReplyPayRespect, Arrays.asList(new Long[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.masterRoleId) }));
/*     */     
/* 214 */     ShiTuManager.tlogShiTuPayRespect(this.apprenticeRoleId, apprenticeUserId, this.masterRoleId, masterUserId, ShiTuPayRespectTLogEnum.MASTER_AGREE);
/*     */     
/*     */ 
/* 217 */     ActivityInterface.logActivity(this.apprenticeRoleId, ShiTuConsts.getInstance().payRespectActivityId, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/*     */ 
/* 221 */     ActivityInterface.tlogActivity(this.apprenticeRoleId, ShiTuConsts.getInstance().payRespectActivityId, ActivityLogStatus.FINISH);
/*     */     
/* 223 */     GameServer.logger().info(String.format("[shitu]PCReplyRespect.processImp@master agree apprentice's pay respect|master_role_id=%d|apprentice_role_id=%d|session_id=%d|add_friend_value=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.sessionId), Integer.valueOf(addNum) }));
/*     */     
/*     */ 
/*     */ 
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCReplyPayRespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */