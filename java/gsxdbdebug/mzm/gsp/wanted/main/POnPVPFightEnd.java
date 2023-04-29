/*     */ package mzm.gsp.wanted.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.wanted.SNotifyPVPFightResult;
/*     */ import xbean.WantedAwardInfo;
/*     */ import xbean.WantedInfo;
/*     */ import xtable.Role2wantedawardinfo;
/*     */ import xtable.Role2wantedinfo;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     if ((((PVPFightEndArg)this.arg).fightReason != FightReason.WANTED_FIGHT_PVP.value) || (!(((PVPFightEndArg)this.arg).context instanceof WantedPVPFightContext)))
/*     */     {
/*  26 */       return false;
/*     */     }
/*     */     
/*  29 */     SNotifyPVPFightResult notifyFightResult = new SNotifyPVPFightResult();
/*  30 */     WantedManager.getRoleNamesOctets(((PVPFightEndArg)this.arg).activeRoleList, notifyFightResult.activenamelist, false);
/*  31 */     WantedManager.getRoleNamesOctets(((PVPFightEndArg)this.arg).passiveRoleList, notifyFightResult.passivenamelist, true);
/*     */     
/*  33 */     long wantedRoleId = ((WantedPVPFightContext)((PVPFightEndArg)this.arg).context).wantedRoleId;
/*     */     
/*     */ 
/*  36 */     Set<Long> wantedRoles = WantedManager.getWantedRoleIds(((PVPFightEndArg)this.arg).passiveRoleList);
/*  37 */     Set<Long> roleIdsToLock = new HashSet();
/*  38 */     Set<String> userIdsToLock = new HashSet();
/*     */     
/*  40 */     roleIdsToLock.addAll(((PVPFightEndArg)this.arg).activeRoleList);
/*  41 */     roleIdsToLock.addAll(((PVPFightEndArg)this.arg).passiveRoleList);
/*  42 */     for (Iterator i$ = roleIdsToLock.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/*  44 */       userIdsToLock.add(RoleInterface.getName(rid));
/*     */     }
/*     */     
/*     */ 
/*  48 */     lock(xtable.User.getTable(), userIdsToLock);
/*     */     
/*     */ 
/*  51 */     lock(xtable.Basic.getTable(), roleIdsToLock);
/*     */     Map<Long, Integer> xRoleId2count;
/*  53 */     Iterator i$; if (((PVPFightEndArg)this.arg).isActiveWin)
/*     */     {
/*  55 */       notifyFightResult.result = 1;
/*     */       
/*  57 */       WantedManager.ArrestRoles(wantedRoles);
/*     */       
/*  59 */       wantedAward();
/*     */     }
/*     */     else
/*     */     {
/*  63 */       notifyFightResult.result = 2;
/*     */       
/*     */ 
/*     */ 
/*  67 */       WantedInfo xWantedInfo = Role2wantedinfo.get(Long.valueOf(wantedRoleId));
/*  68 */       xRoleId2count = xWantedInfo.getRoleid2count();
/*  69 */       for (i$ = ((PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long activeRoleId = ((Long)i$.next()).longValue();
/*     */         int count;
/*  71 */         int count; if (xRoleId2count.containsKey(Long.valueOf(activeRoleId)))
/*     */         {
/*  73 */           count = ((Integer)xRoleId2count.get(Long.valueOf(activeRoleId))).intValue();
/*     */         }
/*     */         else
/*     */         {
/*  77 */           count = 0;
/*     */         }
/*  79 */         xRoleId2count.put(Long.valueOf(activeRoleId), Integer.valueOf(count + 1));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  84 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeDeadRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  86 */       WantedManager.reduceEquipmentUsePoint(roleId, SPKConsts.getInstance().NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY);
/*     */     }
/*     */     
/*     */ 
/*  90 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveDeadRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  92 */       if (wantedRoles.contains(Long.valueOf(roleId)))
/*     */       {
/*     */ 
/*  95 */         WantedManager.reduceEquipmentUsePoint(roleId, SPKConsts.getInstance().WANTED_ARREST_DEATH_EQUIPMENT_PENALTY);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 100 */         WantedManager.reduceEquipmentUsePoint(roleId, SPKConsts.getInstance().NON_WANTED_ARREST_DEATH_EQUIPMENT_PENALTY);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 105 */     WantedTlogManager.tlogWantedPVPResult(wantedRoleId, ((PVPFightEndArg)this.arg).passiveRoleList, wantedRoles, ((PVPFightEndArg)this.arg).activeRoleList, ((PVPFightEndArg)this.arg).isActiveWin ? 1 : 2);
/*     */     
/* 107 */     OnlineManager.getInstance().sendAll(notifyFightResult);
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   private void wantedAward()
/*     */   {
/* 113 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*     */ 
/* 117 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).getActiveNotEscapeList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 119 */       WantedAwardInfo xWantedAwardInfo = Role2wantedawardinfo.get(Long.valueOf(roleId));
/* 120 */       if (xWantedAwardInfo == null)
/*     */       {
/* 122 */         xWantedAwardInfo = xbean.Pod.newWantedAwardInfo();
/* 123 */         xWantedAwardInfo.setTimestamp(currentTimeStamp);
/* 124 */         Role2wantedawardinfo.insert(Long.valueOf(roleId), xWantedAwardInfo);
/*     */       }
/* 126 */       int wantedAwardCount = xWantedAwardInfo.getCount();
/* 127 */       long xdbLastTimeStamp = xWantedAwardInfo.getTimestamp();
/* 128 */       boolean isInSameDay = DateTimeUtils.isInSameDay(currentTimeStamp, xdbLastTimeStamp);
/* 129 */       if ((isInSameDay) && (wantedAwardCount >= SPKConsts.getInstance().WANTED_AWARD_MAX_COUNT_PER_DAY))
/*     */       {
/* 131 */         OnlineManager.getInstance().sendAtOnce(roleId, new mzm.gsp.wanted.SNotifyAwardCountMax());
/*     */       }
/*     */       else
/*     */       {
/* 135 */         mzm.gsp.award.main.AwardInterface.awardFixAward(SPKConsts.getInstance().ARREST_REWARD_ID, RoleInterface.getUserId(roleId), roleId, false, true, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.WANTED_AWARD));
/*     */         
/*     */ 
/* 138 */         xWantedAwardInfo.setTimestamp(currentTimeStamp);
/* 139 */         if (!isInSameDay)
/*     */         {
/* 141 */           wantedAwardCount = 0;
/*     */         }
/* 143 */         xWantedAwardInfo.setCount(wantedAwardCount + 1);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */