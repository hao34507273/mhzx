/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
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
/*     */ import mzm.gsp.prison.SJailDeliveryError;
/*     */ import mzm.gsp.prison.SNotifyJailDeliveryBegin;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.PrisonInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2prisoninfo;
/*     */ import xtable.Team;
/*     */ 
/*     */ public class PCJailDeliveryReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long liberatorId;
/*     */   final long savedId;
/*     */   final boolean isConfirmDone;
/*     */   
/*     */   public PCJailDeliveryReq(long liberatorId, long savedId, boolean isConfirmDone)
/*     */   {
/*  37 */     this.liberatorId = liberatorId;
/*  38 */     this.savedId = savedId;
/*  39 */     this.isConfirmDone = isConfirmDone;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     boolean ret = PrisonManager.checkSwitchAndCross(this.liberatorId, 1665);
/*  47 */     if (!ret)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     ret = NpcInterface.checkNpcService(SPKConsts.getInstance().RESCUE_NPC_ID, SPKConsts.getInstance().RESCUE_SERVICE_ID, this.liberatorId);
/*     */     
/*  55 */     if (!ret)
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     ret = MapInterface.isNearByNPC(this.liberatorId, SPKConsts.getInstance().RESCUE_NPC_ID);
/*  62 */     if (!ret)
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     SJailDeliveryError jailDeliveryError = new SJailDeliveryError();
/*  68 */     Octets savedName = new Octets();
/*  69 */     savedName.setString(RoleInterface.getName(this.savedId), "utf-8");
/*  70 */     jailDeliveryError.savedname = savedName;
/*     */     
/*  72 */     ret = PrisonInterface.isRoleInJail(this.savedId);
/*  73 */     if (!ret)
/*     */     {
/*  75 */       jailDeliveryError.errorcode = 5;
/*  76 */       OnlineManager.getInstance().sendAtOnce(this.liberatorId, jailDeliveryError);
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     if (!OnlineManager.getInstance().isOnline(this.savedId))
/*     */     {
/*  83 */       jailDeliveryError.errorcode = 4;
/*  84 */       OnlineManager.getInstance().sendAtOnce(this.liberatorId, jailDeliveryError);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     Set<Long> roleIdsToLock = new HashSet();
/*  89 */     Set<Long> teamRoleIdsToLock = new HashSet();
/*  90 */     roleIdsToLock.add(Long.valueOf(this.savedId));
/*  91 */     Set<Long> teamIdsToLock = new HashSet();
/*  92 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.liberatorId);
/*  93 */     List<Long> teamNormalList = null;
/*  94 */     if (teamInfo != null)
/*     */     {
/*  96 */       teamNormalList = teamInfo.getTeamNormalList();
/*  97 */       if (teamNormalList.contains(Long.valueOf(this.liberatorId)))
/*     */       {
/*  99 */         if (!teamInfo.isLeader(this.liberatorId))
/*     */         {
/* 101 */           return false;
/*     */         }
/* 103 */         teamRoleIdsToLock.addAll(teamNormalList);
/* 104 */         teamIdsToLock.add(Long.valueOf(teamInfo.getTeamId()));
/*     */       }
/*     */       else
/*     */       {
/* 108 */         teamRoleIdsToLock.add(Long.valueOf(this.liberatorId));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 113 */       teamRoleIdsToLock.add(Long.valueOf(this.liberatorId));
/*     */     }
/* 115 */     roleIdsToLock.addAll(teamRoleIdsToLock);
/*     */     
/* 117 */     lock(Basic.getTable(), roleIdsToLock);
/*     */     
/* 119 */     lock(Team.getTable(), teamIdsToLock);
/*     */     
/* 121 */     ret = PrisonInterface.isRoleInJail(this.savedId);
/* 122 */     if (!ret)
/*     */     {
/* 124 */       jailDeliveryError.errorcode = 5;
/* 125 */       OnlineManager.getInstance().sendAtOnce(this.liberatorId, jailDeliveryError);
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     if (!OnlineManager.getInstance().isOnline(this.savedId))
/*     */     {
/* 132 */       jailDeliveryError.errorcode = 4;
/* 133 */       OnlineManager.getInstance().sendAtOnce(this.liberatorId, jailDeliveryError);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     if (teamInfo != null)
/*     */     {
/* 140 */       if (teamNormalList.contains(Long.valueOf(this.liberatorId)))
/*     */       {
/* 142 */         List<Long> lockMembers = teamInfo.getTeamNormalList();
/* 143 */         if ((lockMembers.size() != teamNormalList.size()) && (!lockMembers.containsAll(teamNormalList)))
/*     */         {
/* 145 */           return false;
/*     */         }
/* 147 */         if (!teamInfo.isLeader(this.liberatorId))
/*     */         {
/* 149 */           return false;
/*     */         }
/* 151 */         if (!RoleStatusInterface.checkCansetStatus(lockMembers, 1665, false))
/*     */         {
/* 153 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 157 */     for (Iterator i$ = teamRoleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/* 159 */       if (PrisonInterface.isRoleInJail(rid))
/*     */       {
/* 161 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 165 */     PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(this.savedId));
/* 166 */     if (xPrisonInfo == null)
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     if (xPrisonInfo.getJailaction() != 1)
/*     */     {
/* 172 */       jailDeliveryError.errorcode = xPrisonInfo.getJailaction();
/* 173 */       OnlineManager.getInstance().sendAtOnce(this.liberatorId, jailDeliveryError);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     if ((this.isConfirmDone) || (teamRoleIdsToLock.size() == 1))
/*     */     {
/*     */ 
/* 180 */       xPrisonInfo.setJailaction(3);
/*     */       
/*     */ 
/* 183 */       SNotifyJailDeliveryBegin notifyJailDeliveryBegin = new SNotifyJailDeliveryBegin();
/* 184 */       notifyJailDeliveryBegin.name = savedName;
/*     */       
/* 186 */       for (Iterator i$ = teamRoleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 188 */         Octets octets = new Octets();
/* 189 */         octets.setString(RoleInterface.getName(rid), "utf-8");
/* 190 */         notifyJailDeliveryBegin.namelist.add(octets);
/*     */       }
/* 192 */       OnlineManager.getInstance().sendAll(notifyJailDeliveryBegin);
/*     */       
/*     */ 
/* 195 */       FightInterface.startPVEFight(this.liberatorId, SPKConsts.getInstance().JAIL_DELIVERY_PVE_FIGHT_ID, new JailDeliveryPVEFightContext(this.savedId, SPKConsts.getInstance().JAIL_DELIVERY_PVE_FIGHT_ID), FightReason.JAIL_DELIVERY_FIGHT_PVE);
/*     */       
/*     */ 
/*     */ 
/* 199 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 203 */     TeamConfirmInterface.startTeamConfirm(teamInfo.getTeamId(), 5, new JailDeliveryConfirmContext(this.liberatorId, this.savedId, savedName));
/*     */     
/*     */ 
/* 206 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PCJailDeliveryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */