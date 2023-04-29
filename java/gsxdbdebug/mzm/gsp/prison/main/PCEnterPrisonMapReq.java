/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import java.util.HashSet;
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
/*     */ 
/*     */ public class PCEnterPrisonMapReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   
/*     */   public PCEnterPrisonMapReq(long roleId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     boolean ret = PrisonManager.checkSwitchAndCross(this.roleId, 1663);
/*  33 */     if (!ret)
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     ret = NpcInterface.checkNpcService(SPKConsts.getInstance().PK_NPC_ID, SPKConsts.getInstance().VISIT_PRISON_SERVICE_ID, this.roleId);
/*     */     
/*  41 */     if (!ret)
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     ret = MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().PK_NPC_ID);
/*  48 */     if (!ret)
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  54 */     List<Long> teamNormalList = null;
/*  55 */     Set<Long> roleIdsToLock = new HashSet();
/*  56 */     Set<Long> teamIdToLock = new HashSet();
/*  57 */     if (teamInfo != null)
/*     */     {
/*  59 */       teamNormalList = teamInfo.getTeamNormalList();
/*  60 */       if (teamNormalList.contains(Long.valueOf(this.roleId)))
/*     */       {
/*  62 */         roleIdsToLock.addAll(teamNormalList);
/*  63 */         teamIdToLock.add(Long.valueOf(teamInfo.getTeamId()));
/*  64 */         if (!teamInfo.isLeader(this.roleId))
/*     */         {
/*  66 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  71 */         roleIdsToLock.add(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     
/*  75 */     lock(Basic.getTable(), roleIdsToLock);
/*     */     
/*  77 */     lock(Team.getTable(), teamIdToLock);
/*     */     
/*     */ 
/*  80 */     if ((teamInfo != null) && (teamNormalList.contains(Long.valueOf(this.roleId))))
/*     */     {
/*  82 */       List<Long> lockMembers = teamInfo.getTeamNormalList();
/*  83 */       if ((lockMembers.size() != teamNormalList.size()) && (!lockMembers.containsAll(teamNormalList)))
/*     */       {
/*  85 */         return false;
/*     */       }
/*  87 */       if (teamInfo.getLeaderId() != this.roleId)
/*     */       {
/*  89 */         return false;
/*     */       }
/*  91 */       if (!RoleStatusInterface.checkCansetStatus(lockMembers, 1663, false))
/*     */       {
/*  93 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  98 */     MapInterface.forceTransferToScene(this.roleId, JailWorldManager.getInstance().getWorldId(), ((Integer)JailWorldManager.getInstance().getMapCfgIds().get(0)).intValue(), SPKConsts.getInstance().NON_WANTED_ENTER_PRISON_MAP_X, SPKConsts.getInstance().NON_WANTED_ENTER_PRISON_MAP_Y);
/*     */     
/*     */ 
/*     */ 
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PCEnterPrisonMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */