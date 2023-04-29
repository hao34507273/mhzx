/*     */ package mzm.gsp.breakegg.invite;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.breakegg.SConfirmInviteFail;
/*     */ import mzm.gsp.nationalholiday.confbean.SInviteConfirmCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InviteConfirmBean;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Inviteconfirm_info;
/*     */ import xtable.Role2inviteconfirm_info;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCConfirmRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int inviteType;
/*     */   private final long sessionId;
/*     */   private final int reply;
/*     */   
/*     */   public PCConfirmRep(long roleId, int inviteType, long sessionId, int reply)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.inviteType = inviteType;
/*  32 */     this.sessionId = sessionId;
/*  33 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     SInviteConfirmCfg cfg = SInviteConfirmCfg.get(this.inviteType);
/*  40 */     if (cfg == null)
/*     */     {
/*  42 */       onFailed(4);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  48 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  49 */     if ((roleLevel < cfg.levelMin) || (roleLevel > cfg.levelMax))
/*     */     {
/*  51 */       onFailed(10);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  57 */     Session session = Session.getSession(this.sessionId);
/*  58 */     InviteConfirmSession inviteConfirmSession = null;
/*  59 */     if ((session instanceof InviteConfirmSession))
/*     */     {
/*  61 */       inviteConfirmSession = (InviteConfirmSession)session;
/*     */     }
/*  63 */     if (inviteConfirmSession == null)
/*     */     {
/*  65 */       onFailed(8);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (inviteConfirmSession.getOwerId() == this.roleId)
/*     */     {
/*  71 */       onFailed(6);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     Long inviteConfirmId = Role2inviteconfirm_info.select(Long.valueOf(inviteConfirmSession.getOwerId()));
/*  76 */     if (inviteConfirmId == null)
/*     */     {
/*  78 */       onFailed(8);
/*  79 */       return false;
/*     */     }
/*  81 */     String userId = RoleInterface.getUserId(this.roleId);
/*  82 */     if (userId == null)
/*     */     {
/*  84 */       onFailed(2);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  90 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*     */ 
/*  94 */     if (Role2inviteconfirm_info.get(Long.valueOf(this.roleId)) != null)
/*     */     {
/*  96 */       onFailed(9);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1863, true, true))
/*     */     {
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     InviteConfirmBean xInviteConfirmBean = Inviteconfirm_info.get(inviteConfirmId);
/* 106 */     if (xInviteConfirmBean == null)
/*     */     {
/* 108 */       onFailed(8);
/* 109 */       return false;
/*     */     }
/* 111 */     InviteConfirmHandler handler = InviteManager.getInviteConfirmHandler(xInviteConfirmBean.getInvitetype());
/* 112 */     if (handler == null)
/*     */     {
/* 114 */       onFailed(3);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (xInviteConfirmBean.getAllroles().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 120 */       onFailed(9);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if (xInviteConfirmBean.getInvitetype() != this.inviteType)
/*     */     {
/* 126 */       onFailed(4);
/* 127 */       return false;
/*     */     }
/* 129 */     if (xInviteConfirmBean.getSessionid() != this.sessionId)
/*     */     {
/* 131 */       onFailed(4);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     switch (this.reply)
/*     */     {
/*     */     case 2: 
/*     */       break;
/*     */     
/*     */     case 1: 
/* 141 */       xInviteConfirmBean.getAllroles().add(Long.valueOf(this.roleId));
/*     */       
/* 143 */       Role2inviteconfirm_info.insert(Long.valueOf(this.roleId), inviteConfirmId);
/*     */       
/* 145 */       RoleStatusInterface.setStatus(this.roleId, 1861, false);
/*     */       
/* 147 */       if (!checkInviteSuccess(xInviteConfirmBean, cfg.inviteRoleNum))
/*     */       {
/*     */ 
/* 150 */         InviteManager.sSynInviteJoinInfo(xInviteConfirmBean.getAllroles(), xInviteConfirmBean);
/*     */       }
/*     */       break;
/*     */     default: 
/* 154 */       onFailed(4);
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     GameServer.logger().info(String.format("[invite]PCConfirmRep.processImp@ success|userId=%s|roleId=%d|invite_type=%d|sessionid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.inviteType), Long.valueOf(this.sessionId) }));
/*     */     
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkInviteSuccess(InviteConfirmBean xInviteConfirmBean, int inviteRoleNum)
/*     */   {
/* 172 */     if (xInviteConfirmBean.getAllroles().size() < inviteRoleNum + 1)
/*     */     {
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     Session.removeSession(xInviteConfirmBean.getSessionid());
/*     */     
/* 179 */     InviteManager.destroyInviteInfo(this.roleId);
/*     */     
/* 181 */     InviteManager.synDoSuccessAction(xInviteConfirmBean);
/*     */     
/* 183 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int error_code)
/*     */   {
/* 194 */     SConfirmInviteFail rsp = new SConfirmInviteFail();
/* 195 */     rsp.invite_type = this.inviteType;
/* 196 */     rsp.sessionid = this.sessionId;
/* 197 */     rsp.error_code = error_code;
/* 198 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 200 */     StringBuffer logBuilder = new StringBuffer();
/* 201 */     logBuilder.append("[invite]PCConfirmRep.onFailed@processImp() failed");
/* 202 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 203 */     logBuilder.append('|').append("inviteType=").append(this.inviteType);
/* 204 */     logBuilder.append('|').append("sessionId=").append(this.sessionId);
/* 205 */     logBuilder.append('|').append("error_code=").append(error_code);
/*     */     
/* 207 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\invite\PCConfirmRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */