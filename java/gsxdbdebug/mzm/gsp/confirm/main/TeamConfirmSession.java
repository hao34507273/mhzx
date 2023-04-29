/*     */ package mzm.gsp.confirm.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.function.confbean.SCommonTeamConfirmCfg;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TeamConfirmBean;
/*     */ import xtable.Role2teamconf;
/*     */ 
/*     */ public class TeamConfirmSession extends Session
/*     */ {
/*     */   public TeamConfirmSession(long interval, long roleId)
/*     */   {
/*  17 */     super(interval, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  23 */     new TeamConfirmTimeOut(super.getOwerId()).execute();
/*     */   }
/*     */   
/*     */   class TeamConfirmTimeOut extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public TeamConfirmTimeOut(long roleId)
/*     */     {
/*  32 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  39 */       TeamConfirmBean xConfBean = Role2teamconf.get(Long.valueOf(this.roleId));
/*  40 */       if (xConfBean == null)
/*     */       {
/*  42 */         return false;
/*     */       }
/*     */       
/*  45 */       Role2teamconf.remove(Long.valueOf(this.roleId));
/*     */       
/*  47 */       afterTimeOut(new TeamConfirmSession.CacheConfBean(TeamConfirmSession.this, xConfBean.getAllroles(), xConfBean.getAcceptroles(), xConfBean.getConfirmtype(), xConfBean.getContext()));
/*     */       
/*  49 */       return true;
/*     */     }
/*     */     
/*     */     private void afterTimeOut(final TeamConfirmSession.CacheConfBean confBean)
/*     */     {
/*  54 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  60 */           TeamConfirmSession.TeamConfirmTimeOut.this.onTimeout(confBean);
/*  61 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */     
/*     */     private void onTimeout(TeamConfirmSession.CacheConfBean confBean)
/*     */     {
/*  68 */       int confirmType = confBean.getConfirmType();
/*     */       
/*  70 */       SCommonTeamConfirmCfg cfg = SCommonTeamConfirmCfg.get(confirmType);
/*  71 */       if (cfg == null)
/*     */       {
/*     */ 
/*  74 */         GameServer.logger().error(String.format("[confirm]TeamConfirmTimeOut.processImp@ SCommonTeamConformCfg is null!|leaderId=%d|confirmType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(confirmType) }));
/*     */         
/*     */ 
/*     */ 
/*  78 */         return;
/*     */       }
/*  80 */       boolean timeOutAgree = true;
/*  81 */       Set<Long> noActionRoleIds = new java.util.HashSet(confBean.getAllRoleIds());
/*  82 */       noActionRoleIds.removeAll(confBean.getAcceptRoleIds());
/*     */       
/*  84 */       if (ConfirmManager.getConfirmDefaultAgreeRoleIds(noActionRoleIds, confirmType).size() != noActionRoleIds.size())
/*     */       {
/*  86 */         timeOutAgree = false;
/*     */       }
/*     */       
/*  89 */       if (!timeOutAgree)
/*     */       {
/*  91 */         return;
/*     */       }
/*  93 */       Long teamId = mzm.gsp.team.main.TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  94 */       if (teamId != null)
/*     */       {
/*  96 */         ConfirmManager.asynDoAcceptedAction(teamId.longValue(), confirmType, confBean.getContext());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class CacheConfBean
/*     */   {
/*     */     final List<Long> allRoleIds;
/*     */     final List<Long> acceptRoleIds;
/*     */     final int confirmType;
/*     */     final TeamConfirmContext context;
/*     */     
/*     */     public CacheConfBean(List<Long> allRoleIds, int acceptRoleIds, TeamConfirmContext confirmType)
/*     */     {
/* 111 */       this.allRoleIds = allRoleIds;
/* 112 */       this.acceptRoleIds = acceptRoleIds;
/* 113 */       this.confirmType = confirmType;
/* 114 */       this.context = context;
/*     */     }
/*     */     
/*     */     public List<Long> getAllRoleIds()
/*     */     {
/* 119 */       return this.allRoleIds;
/*     */     }
/*     */     
/*     */     public List<Long> getAcceptRoleIds()
/*     */     {
/* 124 */       return this.acceptRoleIds;
/*     */     }
/*     */     
/*     */     public int getConfirmType()
/*     */     {
/* 129 */       return this.confirmType;
/*     */     }
/*     */     
/*     */     public TeamConfirmContext getContext()
/*     */     {
/* 134 */       return this.context;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\TeamConfirmSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */