/*     */ package mzm.gsp.confirm.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.confirm.SConfirmBro;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TeamConfirmBean;
/*     */ import xtable.Role2teamconf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCConfirmRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int type;
/*     */   private final long sessionId;
/*     */   private final int reply;
/*     */   
/*     */   public PCConfirmRep(long roleId, int type, long sessionId, int reply)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.type = type;
/*  31 */     this.sessionId = sessionId;
/*  32 */     this.reply = reply;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  39 */     if (teamInfo == null)
/*     */     {
/*  41 */       GameServer.logger().error(String.format("[confirm]PCConfirmRep.processImp@ team is null!|roleId=%d|type=%d|reply=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply) }));
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*  46 */     long leaderId = teamInfo.getLeaderId();
/*     */     
/*  48 */     TeamConfirmBean xConfBean = Role2teamconf.get(Long.valueOf(leaderId));
/*     */     
/*  50 */     teamInfo = TeamInterface.getTeamInfo(teamInfo.getTeamId(), true);
/*     */     
/*  52 */     if (!checkAfterGetLocks(teamInfo, leaderId, xConfBean))
/*     */     {
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     List<Long> members = xConfBean.getAllroles();
/*  59 */     switch (this.reply)
/*     */     {
/*     */     case 2: 
/*  62 */       OnlineManager.getInstance().sendMulti(new SConfirmBro(this.type, this.roleId, this.reply), members);
/*     */       
/*  64 */       Session.removeSession(xConfBean.getSessionid());
/*     */       
/*  66 */       Role2teamconf.remove(Long.valueOf(leaderId));
/*  67 */       return true;
/*     */     
/*     */     case 1: 
/*  70 */       if (xConfBean.getAcceptroles().contains(Long.valueOf(this.roleId)))
/*     */       {
/*  72 */         GameServer.logger().error(String.format("[corps]PCCreateCorpsConfirmRep.processImp@ already accept!|roleId=%d|leaderId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(leaderId) }));
/*     */         
/*     */ 
/*  75 */         return false;
/*     */       }
/*  77 */       xConfBean.getAcceptroles().add(Long.valueOf(this.roleId));
/*  78 */       OnlineManager.getInstance().sendMulti(new SConfirmBro(this.type, this.roleId, this.reply), members);
/*     */       
/*     */ 
/*  81 */       afterAllAccepted(teamInfo.getTeamId(), leaderId, xConfBean);
/*     */       
/*  83 */       return true;
/*     */     }
/*     */     
/*     */     
/*  87 */     GameServer.logger().error(String.format("[confirm]PCConfirmRep.processImp@ not support type!||roleId=%d|type=%d|reply=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply) }));
/*     */     
/*     */ 
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   private boolean checkAfterGetLocks(TeamInfo teamInfo, long leaderId, TeamConfirmBean xConfBean)
/*     */   {
/*  95 */     if (!checkAFGetTeamLock(teamInfo, leaderId))
/*     */     {
/*  97 */       GameServer.logger().error(String.format("[confirm]PCConfirmRep.checkAfterGetLocks@ team changed!|roleId=%d|type=%d|reply=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply) }));
/*     */       
/*     */ 
/* 100 */       return false;
/*     */     }
/* 102 */     if (!checkClientParameters(leaderId, xConfBean))
/*     */     {
/*     */ 
/* 105 */       return false;
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkAFGetTeamLock(TeamInfo teamInfo, long leaderId)
/*     */   {
/* 112 */     if (teamInfo == null)
/*     */     {
/* 114 */       return false;
/*     */     }
/* 116 */     if (!teamInfo.isLeader(leaderId))
/*     */     {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void afterAllAccepted(long teamId, long leaderId, TeamConfirmBean xConfBean)
/*     */   {
/* 131 */     if (!xConfBean.getAcceptroles().containsAll(xConfBean.getAllroles()))
/*     */     {
/* 133 */       return;
/*     */     }
/*     */     
/* 136 */     Session.removeSession(xConfBean.getSessionid());
/*     */     
/* 138 */     Role2teamconf.remove(Long.valueOf(leaderId));
/*     */     
/* 140 */     ConfirmManager.asynDoAcceptedAction(teamId, this.type, xConfBean.getContext());
/*     */   }
/*     */   
/*     */   private boolean checkClientParameters(long leaderId, TeamConfirmBean xConfBean)
/*     */   {
/* 145 */     if (xConfBean == null)
/*     */     {
/* 147 */       GameServer.logger().error(String.format("[confirm]PCConfirmRep.checkClientParameters@ leader's xConfBean is null!|roleId=%d|type=%d|reply=%d|leaderId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/*     */ 
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     if (!xConfBean.getAllroles().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 156 */       GameServer.logger().error(String.format("[confirm]PCConfirmRep.checkClientParameters@ not contains role!|roleId=%d|type=%d|reply=%d|leaderId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/*     */ 
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     if (xConfBean.getConfirmtype() != this.type)
/*     */     {
/* 165 */       GameServer.logger().error(String.format("[confirm]PCConfirmRep.checkClientParameters@ confirm type err!|roleId=%d|type=%d|reply=%d|leaderId=%d|xType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply), Long.valueOf(leaderId), Integer.valueOf(xConfBean.getConfirmtype()) }));
/*     */       
/*     */ 
/*     */ 
/* 169 */       return false;
/*     */     }
/*     */     
/* 172 */     if (xConfBean.getSessionid() != this.sessionId)
/*     */     {
/* 174 */       GameServer.logger().error(String.format("[confirm]PCConfirmRep.checkClientParameters@ sessionId err!|roleId=%d|type=%d|reply=%d|leaderId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.type), Integer.valueOf(this.reply), Long.valueOf(leaderId) }));
/*     */       
/*     */ 
/*     */ 
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\PCConfirmRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */