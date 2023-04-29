/*     */ package mzm.gsp.team.changeleader;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.SInviteBeLeader;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LeaderChangeBean;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2leaderchange;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NeedChangeLeaderSession
/*     */   extends Session
/*     */ {
/*  28 */   private static final Logger logger = Logger.getLogger(NeedChangeLeaderSession.class);
/*     */   
/*     */   private final long leaderId;
/*     */   
/*     */   public NeedChangeLeaderSession(long interval, long roleId)
/*     */   {
/*  34 */     super(interval, roleId);
/*  35 */     this.leaderId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  41 */     Procedure.execute(new PChangeLeader());
/*     */   }
/*     */   
/*     */   class PChangeLeader extends LogicProcedure
/*     */   {
/*     */     PChangeLeader() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  50 */       LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(NeedChangeLeaderSession.this.leaderId));
/*  51 */       if (xLeaderChangeBean == null)
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       Long teamid = Role2team.select(Long.valueOf(NeedChangeLeaderSession.this.leaderId));
/*  57 */       if (teamid == null)
/*     */       {
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       long leaderId_now = TeamInterface.getTeamLeaderByRoleid(NeedChangeLeaderSession.this.leaderId, false, false);
/*  63 */       if ((leaderId_now <= 0L) || (leaderId_now != NeedChangeLeaderSession.this.leaderId))
/*     */       {
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       ChangeLeaderManager.startChangeLeaderSession(NeedChangeLeaderSession.this.leaderId, xLeaderChangeBean);
/*     */       
/*     */ 
/*  71 */       if ((FightInterface.isInFight(NeedChangeLeaderSession.this.leaderId)) || (MapInterface.isInMoveState(NeedChangeLeaderSession.this.leaderId)))
/*     */       {
/*  73 */         return true;
/*     */       }
/*     */       
/*  76 */       if (!RoleStatusInterface.checkCanSetStatus(leaderId_now, 392, false))
/*     */       {
/*     */ 
/*  79 */         return true;
/*     */       }
/*     */       
/*  82 */       List<Long> normalRoles = TeamInterface.getNormalRoleList(NeedChangeLeaderSession.this.leaderId);
/*  83 */       if ((normalRoles == null) || (normalRoles.size() <= 1))
/*     */       {
/*  85 */         return false;
/*     */       }
/*     */       
/*  88 */       xbean.Team xTeam = xtable.Team.get(teamid);
/*  89 */       if (xTeam == null)
/*     */       {
/*  91 */         return false;
/*     */       }
/*     */       
/*  94 */       xTeam.setIschangeleadering(true);
/*     */       
/*  96 */       OnlineManager.getInstance().sendMulti(new SInviteBeLeader(), normalRoles);
/*  97 */       if (NeedChangeLeaderSession.logger.isDebugEnabled())
/*     */       {
/*  99 */         NeedChangeLeaderSession.logger.debug("[team]NeedChangeLeaderSession.processImp@board is show up, leader name：" + RoleInterface.getName(NeedChangeLeaderSession.this.leaderId));
/*     */       }
/*     */       
/* 102 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\NeedChangeLeaderSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */