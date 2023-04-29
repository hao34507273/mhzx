/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
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
/*     */ import mzm.gsp.prison.SJailBreakError;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.main.WantedManager;
/*     */ import xbean.PrisonInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2prisoninfo;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCJailBreakReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final boolean isConfirmDone;
/*     */   
/*     */   public PCJailBreakReq(long roleId, boolean isConfirmDone)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.isConfirmDone = isConfirmDone;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     boolean ret = PrisonManager.checkSwitchAndCross(this.roleId, 1664);
/*  48 */     if (!ret)
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     ret = NpcInterface.checkNpcService(SPKConsts.getInstance().PRISON_BREAK_NPC_ID, SPKConsts.getInstance().PRISON_BREAK_SERVICE_ID, this.roleId);
/*     */     
/*  56 */     if (!ret)
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     ret = MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().PRISON_BREAK_NPC_ID);
/*  63 */     if (!ret)
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     SJailBreakError jailBreakError = new SJailBreakError();
/*     */     
/*  70 */     Set<Long> roleIdsToLock = new HashSet();
/*  71 */     Set<Long> teamIdsToLock = new HashSet();
/*  72 */     HashMap<Long, String> roleId2userId = new HashMap();
/*  73 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  74 */     List<Long> teamNormalList = null;
/*     */     
/*     */ 
/*  77 */     if (teamInfo != null)
/*     */     {
/*  79 */       teamNormalList = teamInfo.getTeamNormalList();
/*  80 */       if (teamNormalList.contains(Long.valueOf(this.roleId)))
/*     */       {
/*  82 */         if (!teamInfo.isLeader(this.roleId))
/*     */         {
/*  84 */           return false;
/*     */         }
/*  86 */         roleIdsToLock.addAll(teamNormalList);
/*  87 */         teamIdsToLock.add(Long.valueOf(teamInfo.getTeamId()));
/*     */       }
/*     */       else
/*     */       {
/*  91 */         roleIdsToLock.add(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  96 */       roleIdsToLock.add(Long.valueOf(this.roleId));
/*     */     }
/*     */     
/*  99 */     for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/* 101 */       roleId2userId.put(Long.valueOf(rid), RoleInterface.getUserId(rid));
/*     */     }
/*     */     
/*     */ 
/* 105 */     lock(User.getTable(), roleId2userId.values());
/*     */     
/* 107 */     lock(Basic.getTable(), roleIdsToLock);
/*     */     
/* 109 */     lock(Team.getTable(), teamIdsToLock);
/*     */     
/*     */ 
/* 112 */     if (teamInfo != null)
/*     */     {
/* 114 */       if (teamNormalList.contains(Long.valueOf(this.roleId)))
/*     */       {
/* 116 */         List<Long> lockMembers = teamInfo.getTeamNormalList();
/* 117 */         if ((lockMembers.size() != teamNormalList.size()) && (!lockMembers.containsAll(teamNormalList)))
/*     */         {
/* 119 */           return false;
/*     */         }
/* 121 */         if (!teamInfo.isLeader(this.roleId))
/*     */         {
/* 123 */           return false;
/*     */         }
/* 125 */         if (!RoleStatusInterface.checkCansetStatus(lockMembers, 1664, false))
/*     */         {
/* 127 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 135 */     for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/* 137 */       PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(rid));
/* 138 */       if (xPrisonInfo == null)
/*     */       {
/* 140 */         return false;
/*     */       }
/* 142 */       int actionCode = xPrisonInfo.getJailaction();
/* 143 */       if (actionCode != 1)
/*     */       {
/* 145 */         Octets octets = new Octets();
/* 146 */         octets.setString(RoleInterface.getName(rid), "utf-8");
/* 147 */         jailBreakError.params.add(octets);
/*     */       }
/*     */     }
/* 150 */     if (!jailBreakError.params.isEmpty())
/*     */     {
/* 152 */       jailBreakError.errorcode = 3;
/* 153 */       for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 155 */         OnlineManager.getInstance().sendAtOnce(rid, jailBreakError);
/*     */       }
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     if ((this.isConfirmDone) || (roleIdsToLock.size() == 1))
/*     */     {
/*     */ 
/* 163 */       for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 165 */         ret = WantedManager.cutMoney((String)roleId2userId.get(Long.valueOf(rid)), rid, LogReason.JAIL_BREAK_COST, 0, SPKConsts.getInstance().PRISON_BREAK_MONEY_TYPE, SPKConsts.getInstance().PRISON_BREAK_PRICE, CostType.COST_BIND_FIRST_JAIL_BREAK);
/*     */         
/*     */ 
/* 168 */         if (!ret)
/*     */         {
/* 170 */           Octets octets = new Octets();
/* 171 */           octets.setString(RoleInterface.getName(rid), "utf-8");
/* 172 */           jailBreakError.params.add(octets);
/*     */         }
/*     */       }
/*     */       
/* 176 */       if (!jailBreakError.params.isEmpty())
/*     */       {
/* 178 */         jailBreakError.errorcode = 6;
/* 179 */         for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */           
/* 181 */           OnlineManager.getInstance().sendAtOnce(rid, jailBreakError);
/*     */         }
/* 183 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 187 */       for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 189 */         PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(rid));
/* 190 */         if (xPrisonInfo == null)
/*     */         {
/* 192 */           return false;
/*     */         }
/* 194 */         xPrisonInfo.setJailaction(2);
/*     */       }
/*     */       
/*     */ 
/* 198 */       FightInterface.startPVEFight(this.roleId, SPKConsts.getInstance().JAIL_BREAK_PVE_FIGHT_ID, new JailBreakPVEFightContext(SPKConsts.getInstance().JAIL_BREAK_PVE_FIGHT_ID), FightReason.JAIL_BREAK_FIGHT_PVE);
/*     */       
/*     */ 
/* 201 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 205 */     TeamConfirmInterface.startTeamConfirm(teamInfo.getTeamId(), 6, new JailBreakConfirmContext(this.roleId));
/*     */     
/* 207 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PCJailBreakReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */