/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ 
/*     */ 
/*     */ public class PCLeavePrisonMapReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   
/*     */   public PCLeavePrisonMapReq(long roleId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     boolean ret = PrisonManager.checkSwitchAndCross(this.roleId, 1668);
/*  35 */     if (!ret)
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     ret = NpcInterface.checkNpcService(SPKConsts.getInstance().RESCUE_NPC_ID, SPKConsts.getInstance().RETURN_SERVICE_ID, this.roleId);
/*     */     
/*  43 */     if (!ret)
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     ret = MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().RESCUE_NPC_ID);
/*  50 */     if (!ret)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     List<Long> roleIdsToLock = new ArrayList();
/*  56 */     Set<Long> teamIdsToLock = new HashSet();
/*  57 */     if (getRoleIdsAndTeamIdsToLock(roleIdsToLock, teamIdsToLock)) {
/*  58 */       return false;
/*     */     }
/*  60 */     lock(Basic.getTable(), roleIdsToLock);
/*     */     
/*  62 */     lock(Team.getTable(), teamIdsToLock);
/*     */     
/*     */ 
/*  65 */     if (!RoleStatusInterface.checkCansetStatus(roleIdsToLock, 1668, false))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/*  73 */       if (PrisonInterface.isRoleInJail(rid))
/*     */       {
/*  75 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  80 */     MapInterface.forceTransferToScene(this.roleId, MapInterface.getBigWorldid(), SPKConsts.getInstance().LEAVE_PRISON_MAP_ID);
/*     */     
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private boolean getRoleIdsAndTeamIdsToLock(Collection<Long> roleIdsToLock, Collection<Long> teamIdsToLock)
/*     */   {
/*  87 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  88 */     List<Long> teamNormalList = null;
/*  89 */     if (teamInfo != null)
/*     */     {
/*  91 */       teamNormalList = teamInfo.getTeamNormalList();
/*  92 */       if (teamNormalList.contains(Long.valueOf(this.roleId)))
/*     */       {
/*  94 */         if (!teamInfo.isLeader(this.roleId))
/*     */         {
/*  96 */           return true;
/*     */         }
/*  98 */         roleIdsToLock.addAll(teamNormalList);
/*  99 */         teamIdsToLock.add(Long.valueOf(teamInfo.getTeamId()));
/*     */       }
/*     */       else
/*     */       {
/* 103 */         roleIdsToLock.add(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 108 */       roleIdsToLock.add(Long.valueOf(this.roleId));
/*     */     }
/* 110 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PCLeavePrisonMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */