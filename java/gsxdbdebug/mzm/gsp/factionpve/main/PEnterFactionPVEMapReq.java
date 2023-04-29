/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ import xbean.RoleFactionPVE;
/*     */ import xtable.Basic;
/*     */ import xtable.Factionpve_tmp;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PEnterFactionPVEMapReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PEnterFactionPVEMapReq(long roleid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!OpenInterface.getOpenStatus(334)) {
/*  42 */       FactionPVEManager.logError("PEnterFactionPVEMapReq.processImp@not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, false);
/*  48 */     if (faction == null) {
/*  49 */       FactionPVEManager.logError("PEnterFactionPVEMapReq.processImp@no faction|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     long factionid = faction.getGangId();
/*     */     
/*     */ 
/*  59 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*     */     
/*  61 */     List<Long> roleList = new ArrayList();
/*  62 */     if (team != null) {
/*  63 */       if (team.isNormalState(this.roleid)) {
/*  64 */         if (!team.isLeader(this.roleid)) {
/*  65 */           FactionPVEManager.logError("PEnterFactionPVEMapReq.processImp@not team leader|roleid=%d|teamid=%d|leaderid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(team.getTeamId()), Long.valueOf(team.getLeaderId()) });
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */           return false;
/*     */         }
/*  73 */         roleList.addAll(team.getTeamNormalList());
/*     */       }
/*     */       else {
/*  76 */         roleList.add(Long.valueOf(this.roleid));
/*     */       }
/*     */     }
/*     */     else {
/*  80 */       roleList.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/*  83 */     Map<Long, String> userIds = new HashMap();
/*  84 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*  85 */       userIds.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  88 */     lock(User.getTable(), userIds.values());
/*     */     
/*     */ 
/*  91 */     lock(Basic.getTable(), roleList);
/*     */     
/*     */ 
/*  94 */     FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(factionid);
/*     */     
/*     */ 
/*     */ 
/*  98 */     FactionPVETmp xFactionPVETmp = Factionpve_tmp.get(Long.valueOf(factionid));
/*  99 */     if (xFactionPVETmp == null) {
/* 100 */       FactionPVEManager.logError("PEnterFactionPVEMapReq.processImp@factionpve_tmp null|roles=%s|factionid=%d", new Object[] { roleList.toString(), Long.valueOf(factionid) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 105 */       return false;
/*     */     }
/* 107 */     if (!FactionPVEManager.isStageCanEnter(xFactionPVETmp.getStage())) {
/* 108 */       FactionPVEManager.sendNormalResult(this.roleid, 3, new String[0]);
/*     */       
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userIds, roleList, SFactionPVEConsts.getInstance().Activityid);
/*     */     
/* 116 */     if (!result.isCanJoin()) {
/* 117 */       FactionPVEManager.logError("PEnterFactionPVEMapReq.processImp@cannot join activity|roles=%s|reason_roleid=%d|reason=%d", new Object[] { roleList.toString(), Long.valueOf(result.getRoleId()), Integer.valueOf(result.getReasonValue()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */       return false;
/*     */     }
/*     */     
/*     */     Iterator i$;
/* 127 */     if (team != null) {
/* 128 */       for (i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 129 */         if (!faction.isInGang(r)) {
/* 130 */           FactionPVEManager.broadcastNormalResult(roleList, 4, new String[] { RoleInterface.getName(r) });
/*     */           
/*     */ 
/* 133 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 138 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 139 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 141 */       long joinTime = faction.getJoinTime(r);
/* 142 */       long joinMillis = now - joinTime;
/* 143 */       if (joinMillis < TimeUnit.HOURS.toMillis(SFactionPVEConsts.getInstance().NeedJoinHours)) {
/* 144 */         if (roleList.size() == 1) {
/* 145 */           FactionPVEManager.sendNormalResult(this.roleid, 5, new String[0]);
/*     */         }
/*     */         else
/*     */         {
/* 149 */           FactionPVEManager.broadcastNormalResult(roleList, 6, new String[] { RoleInterface.getName(r) });
/*     */         }
/*     */         
/*     */ 
/* 153 */         return false;
/*     */       }
/*     */       
/* 156 */       RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(r);
/* 157 */       if (!FactionPVEManager.canParticipate(xRolePVE, factionid, xFactionPVE.getStart_timestamp())) {
/* 158 */         if (roleList.size() == 1) {
/* 159 */           FactionPVEManager.sendNormalResult(this.roleid, 9, new String[0]);
/*     */         }
/*     */         else
/*     */         {
/* 163 */           FactionPVEManager.broadcastNormalResult(roleList, 10, new String[] { RoleInterface.getName(r) });
/*     */         }
/*     */         
/*     */ 
/* 167 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 173 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 174 */       boolean ret = RoleStatusInterface.setStatus(r, 1021, false);
/*     */       
/* 176 */       if (!ret) {
/* 177 */         FactionPVEManager.logError("PEnterFactionPVEMapReq.processImp@set factionpve status failed|roles=%s|factionid=%d|failed_roleid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(r) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 183 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 188 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 189 */       RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(r);
/* 190 */       FactionPVEManager.setParticipateAndCheckClearRolePVE(xRolePVE, factionid, xFactionPVE.getStart_timestamp(), now);
/*     */       
/*     */ 
/* 193 */       FactionPVEManager.syncParticipateTimes(r, xRolePVE);
/*     */       
/* 195 */       FactionPVEManager.logInfo("PEnterFactionPVEMapReq.processImp@participate|roleid=%d|factionid=%d|participate_times=%d|participate_faction=%d", new Object[] { Long.valueOf(r), Long.valueOf(factionid), Integer.valueOf(xRolePVE.getParticipate_times()), Long.valueOf(xRolePVE.getParticipate_faction()) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 202 */     if (xFactionPVETmp.getStage() == 1)
/*     */     {
/* 204 */       MapInterface.transferToScene(((Long)roleList.get(0)).longValue(), xFactionPVETmp.getWorld(), SFactionPVEConsts.getInstance().PrepareMap);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 209 */       MapInterface.transferToScene(((Long)roleList.get(0)).longValue(), xFactionPVETmp.getWorld(), SFactionPVEConsts.getInstance().FightMap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PEnterFactionPVEMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */