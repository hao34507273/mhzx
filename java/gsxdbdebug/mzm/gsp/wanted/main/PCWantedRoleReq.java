/*     */ package mzm.gsp.wanted.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.SWantedRoleError;
/*     */ import xbean.WantedInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2wantedinfo;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCWantedRoleReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final long wantedRoleId;
/*     */   final boolean isConfirmDone;
/*     */   
/*     */   public PCWantedRoleReq(long roleId, long wantedRoleId, boolean isConfirmDone)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.wantedRoleId = wantedRoleId;
/*  41 */     this.isConfirmDone = isConfirmDone;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (this.wantedRoleId <= 0L)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     boolean ret = WantedManager.checkSwitchAndCross(this.roleId, 1652);
/*  54 */     if (!ret)
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!NpcInterface.checkNpcService(SPKConsts.getInstance().WANTED_NPC_ID, SPKConsts.getInstance().ARREST_SERVICE_ID, this.roleId))
/*     */     {
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().WANTED_NPC_ID))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     SWantedRoleError wantedRoleError = new SWantedRoleError();
/*  71 */     wantedRoleError.rolename.setString(RoleInterface.getName(this.wantedRoleId), "utf-8");
/*     */     
/*  73 */     Set<Long> roleIdsToLock = new HashSet();
/*  74 */     List<Long> activeRoleIdsToLock = new ArrayList();
/*  75 */     Set<Long> teamIdsToLock = new HashSet();
/*     */     
/*  77 */     TeamInfo activeTeamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  78 */     List<Long> activeTeamNormalList = checkTeamStat(activeRoleIdsToLock, teamIdsToLock, activeTeamInfo, this.roleId);
/*  79 */     roleIdsToLock.addAll(activeRoleIdsToLock);
/*     */     
/*  81 */     TeamInfo passiveTeamInfo = TeamInterface.getTeamInfoByRoleId(this.wantedRoleId);
/*  82 */     List<Long> passiveTeamNormalList = checkTeamStat(roleIdsToLock, teamIdsToLock, passiveTeamInfo, this.wantedRoleId);
/*     */     
/*     */ 
/*  85 */     Set<String> userIdsToLock = new HashSet();
/*  86 */     for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/*  88 */       userIdsToLock.add(RoleInterface.getUserId(rid));
/*     */     }
/*     */     
/*  91 */     lock(User.getTable(), userIdsToLock);
/*     */     
/*  93 */     lock(Basic.getTable(), roleIdsToLock);
/*     */     
/*  95 */     lock(Team.getTable(), teamIdsToLock);
/*     */     
/*     */ 
/*     */ 
/*  99 */     if ((activeTeamInfo != null) && (activeTeamNormalList.contains(Long.valueOf(this.roleId))))
/*     */     {
/* 101 */       List<Long> lockMembers = activeTeamInfo.getTeamNormalList();
/* 102 */       if ((lockMembers.size() != activeTeamNormalList.size()) || (!lockMembers.containsAll(activeTeamNormalList)))
/*     */       {
/* 104 */         return false;
/*     */       }
/* 106 */       if (!activeTeamInfo.isLeader(this.roleId))
/*     */       {
/* 108 */         return false;
/*     */       }
/*     */     }
/* 111 */     WantedInfo xWantedInfo = Role2wantedinfo.get(Long.valueOf(this.wantedRoleId));
/* 112 */     ret = WantedManager.checkActiveRoles(this.wantedRoleId, xWantedInfo, activeRoleIdsToLock, wantedRoleError);
/* 113 */     if (!ret)
/*     */     {
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     long passiveFightRoleId = this.wantedRoleId;
/* 120 */     if ((passiveTeamInfo != null) && (passiveTeamNormalList.contains(Long.valueOf(this.wantedRoleId))))
/*     */     {
/* 122 */       List<Long> lockMembers = passiveTeamInfo.getTeamNormalList();
/* 123 */       if ((lockMembers.size() != passiveTeamNormalList.size()) && (!lockMembers.containsAll(passiveTeamNormalList)))
/*     */       {
/* 125 */         return false;
/*     */       }
/* 127 */       passiveFightRoleId = passiveTeamInfo.getLeaderId();
/*     */     }
/* 129 */     ret = WantedManager.checkCanBeWantedByRole(this.wantedRoleId, xWantedInfo, this.roleId, wantedRoleError, true);
/* 130 */     if (!ret)
/*     */     {
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 136 */     if ((this.isConfirmDone) || (activeRoleIdsToLock.size() == 1))
/*     */     {
/*     */ 
/* 139 */       for (Iterator i$ = activeRoleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 141 */         ret = WantedManager.cutMoney(RoleInterface.getUserId(rid), rid, LogReason.WANTED_ROLE_COST, 0, SPKConsts.getInstance().ARREST_MONEY_TYPE, SPKConsts.getInstance().ARREST_PRICE, CostType.COST_BIND_FIRST_WANTED_ROLE);
/*     */         
/*     */ 
/* 144 */         if (!ret)
/*     */         {
/* 146 */           Octets octets = new Octets();
/* 147 */           octets.setString(RoleInterface.getName(rid), "utf-8");
/* 148 */           wantedRoleError.params.add(octets);
/*     */         }
/*     */       }
/* 151 */       if (!wantedRoleError.params.isEmpty())
/*     */       {
/* 153 */         wantedRoleError.errorcode = 3;
/* 154 */         OnlineManager.getInstance().sendAtOnce(this.roleId, wantedRoleError);
/* 155 */         return false;
/*     */       }
/*     */       
/* 158 */       FightInterface.startPVPFight(this.roleId, passiveFightRoleId, new WantedPVPFightContext(this.wantedRoleId), 26, FightReason.WANTED_FIGHT_PVP);
/*     */       
/* 160 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 164 */     Octets octets = new Octets();
/* 165 */     octets.setString(RoleInterface.getName(this.wantedRoleId), "utf-8");
/* 166 */     TeamConfirmInterface.startTeamConfirm(activeTeamInfo.getTeamId(), 4, new WantedConfirmContext(octets, this.wantedRoleId, this.roleId));
/*     */     
/*     */ 
/* 169 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private List<Long> checkTeamStat(Collection<Long> roleIdsToLock, Set<Long> teamIdsToLock, TeamInfo teamInfo, long targetRoleId)
/*     */   {
/* 175 */     List<Long> teamNormalList = null;
/* 176 */     if (teamInfo != null)
/*     */     {
/* 178 */       teamNormalList = teamInfo.getTeamNormalList();
/* 179 */       if (teamNormalList.contains(Long.valueOf(targetRoleId)))
/*     */       {
/* 181 */         roleIdsToLock.addAll(teamNormalList);
/* 182 */         teamIdsToLock.add(Long.valueOf(teamInfo.getTeamId()));
/*     */       }
/*     */       else
/*     */       {
/* 186 */         roleIdsToLock.add(Long.valueOf(targetRoleId));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 191 */       roleIdsToLock.add(Long.valueOf(targetRoleId));
/*     */     }
/* 193 */     return teamNormalList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\PCWantedRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */