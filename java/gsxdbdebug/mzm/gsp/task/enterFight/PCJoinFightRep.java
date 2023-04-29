/*     */ package mzm.gsp.task.enterFight;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.SSynMemberJoinFightState;
/*     */ import mzm.gsp.task.main.TaskImplManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.TaskConfBean;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2taskconf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCJoinFightRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long sessionId;
/*     */   private final int result;
/*     */   
/*     */   public PCJoinFightRep(long roleId, long sessionId, int result)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.sessionId = sessionId;
/*  33 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     Session session = Session.getSession(this.sessionId);
/*  41 */     if ((session == null) || (!(session instanceof InviteJoinFightSession)))
/*     */     {
/*     */ 
/*  44 */       return false;
/*     */     }
/*  46 */     InviteJoinFightSession inviteJoinFightSession = (InviteJoinFightSession)session;
/*  47 */     final long leaderId = inviteJoinFightSession.getLeaderId();
/*     */     
/*  49 */     long leaderNow = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/*  50 */     if (leaderId != leaderNow)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if ((this.result != 0) && (this.result != 1))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     int memberState = TeamInterface.getTeamMemberStatus(this.roleId);
/*  62 */     if (memberState != 0)
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     String roleName = RoleInterface.getName(this.roleId);
/*     */     
/*  69 */     TaskConfBean xTaskConfBean = Role2taskconf.get(Long.valueOf(leaderId));
/*  70 */     if (xTaskConfBean == null)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     List<Long> allTeamMember = new ArrayList(xTaskConfBean.getAllroles());
/*  76 */     allTeamMember.add(Long.valueOf(leaderId));
/*  77 */     SSynMemberJoinFightState pro = new SSynMemberJoinFightState();
/*  78 */     pro.represult = this.result;
/*  79 */     pro.rolename = roleName;
/*  80 */     pro.roleid = this.roleId;
/*  81 */     OnlineManager.getInstance().sendMulti(pro, allTeamMember);
/*     */     
/*  83 */     switch (this.result)
/*     */     {
/*     */     case 0: 
/*  86 */       Role2taskconf.remove(Long.valueOf(leaderId));
/*  87 */       return true;
/*     */     
/*     */     case 1: 
/*  90 */       xTaskConfBean.getAcceptroles().add(Long.valueOf(this.roleId));
/*  91 */       if (xTaskConfBean.getAllroles().size() == xTaskConfBean.getAcceptroles().size())
/*     */       {
/*  93 */         final int taskId = xTaskConfBean.getTaskid();
/*  94 */         int battleId = xTaskConfBean.getBattleid();
/*  95 */         final int graphId = xTaskConfBean.getGraphid();
/*  96 */         Procedure.execute(new LogicProcedure()
/*     */         {
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 102 */             int mapCfgid = MapInterface.getRoleMapId(PCJoinFightRep.this.roleId);
/* 103 */             if (mapCfgid == -1)
/*     */             {
/* 105 */               return false;
/*     */             }
/* 107 */             TaskImplManager.startTaskFight(taskId, leaderId, graphId, mapCfgid, this.val$graphId);
/* 108 */             return true;
/*     */           }
/* 110 */         });
/* 111 */         Session.removeSession(this.sessionId);
/* 112 */         Role2taskconf.remove(Long.valueOf(leaderId));
/* 113 */         return true;
/*     */       }
/* 115 */       return true;
/*     */     }
/*     */     
/* 118 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\enterFight\PCJoinFightRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */