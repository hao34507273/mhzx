/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TeamDispositionMember;
/*     */ import xbean.TeamMember;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2team;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAdjustDisposition
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long leader;
/*     */   private final int srcpos;
/*     */   private final int dstpos;
/*     */   
/*     */   public PAdjustDisposition(long leader, int srcpos, int dstpos)
/*     */   {
/*  26 */     this.leader = leader;
/*  27 */     this.srcpos = srcpos;
/*  28 */     this.dstpos = dstpos;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!RoleStatusInterface.checkCanSetStatus(this.leader, 391, true))
/*     */     {
/*  36 */       GameServer.logger().info(String.format("[team]PAdjustDisposition.processImp@ can not adjust disposition!|roleId=%d", new Object[] { Long.valueOf(this.leader) }));
/*     */       
/*  38 */       return false;
/*     */     }
/*  40 */     Long teamid = Role2team.select(Long.valueOf(this.leader));
/*  41 */     if (teamid == null)
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     xbean.Team xTeam = xtable.Team.get(teamid);
/*  47 */     if (xTeam == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!TeamManager.isLeader(this.leader, xTeam))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  60 */     int realSrcpos = this.srcpos - 1;
/*  61 */     int realDstpos = this.dstpos - 1;
/*     */     
/*  63 */     if ((realSrcpos == 0) || (realDstpos == 0))
/*     */     {
/*  65 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  67 */         GameServer.logger().debug(String.format("[team]PAdjustDisposition.processImp@队长位置不能更换！|leaderId=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.leader), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       }
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*  73 */     if (realSrcpos == realDstpos)
/*     */     {
/*  75 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  77 */         GameServer.logger().debug(String.format("[team]PAdjustDisposition.processImp@调换位置没有变化!|leaderId=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.leader), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       }
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*  83 */     TeamDispositionMember xTDMember_0 = (TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(realSrcpos));
/*  84 */     TeamDispositionMember xTDMember_1 = (TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(realDstpos));
/*  85 */     if ((xTDMember_0.getDispositionmembertype() != 0) || (xTDMember_1.getDispositionmembertype() != 0))
/*     */     {
/*     */ 
/*  88 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  90 */         GameServer.logger().debug(String.format("[team]PAdjustDisposition.processImp@只有队员与队员之间可以更换！|leaderId=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.leader), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       }
/*     */       
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     if (!TeamManager.swapDispositionMember(xTeam, realSrcpos, realDstpos))
/*     */     {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (((TeamMember)xTeam.getMembers().get(0)).getRoleid() != ((TeamDispositionMember)xTeam.getDisposition().get(Integer.valueOf(0))).getDispositionmemberid())
/*     */     {
/* 104 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 106 */         GameServer.logger().debug(String.format("[team]PAdjustDisposition.processImp@队长位置发生变动！|leaderId=%d|srcpos=%d|dstpos=%d", new Object[] { Long.valueOf(this.leader), Integer.valueOf(this.srcpos), Integer.valueOf(this.dstpos) }));
/*     */       }
/*     */       
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     Procedure.execute(new PSynTeamDisposition(teamid.longValue()));
/*     */     
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PAdjustDisposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */