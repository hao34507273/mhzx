/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PLeaveCrossCompeteMapReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PLeaveCrossCompeteMapReq(long roleid)
/*     */   {
/*  30 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(this.roleid, false);
/*     */     
/*  38 */     if (xRoamRole == null) {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     long factionid = xRoamRole.getFactionid();
/*     */     
/*     */ 
/*  45 */     RoamCrossCompeteFaction xFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(factionid, false);
/*     */     
/*  47 */     RoamCrossCompeteFactionTmp xFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(factionid, false);
/*     */     
/*  49 */     if ((xFaction == null) || (xFactionTmp == null)) {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     long world = MapInterface.getRoleWorldInstanceId(this.roleid);
/*  55 */     if (world != xFactionTmp.getWorld()) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     List<Long> roles = new ArrayList();
/*     */     
/*     */ 
/*  62 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  63 */     if (team != null) {
/*  64 */       if (team.isNormalState(this.roleid)) {
/*  65 */         if (CrossCompeteManager.isPrepareStage()) {
/*  66 */           if (!team.isLeader(this.roleid)) {
/*  67 */             CrossCompeteManager.sendNormalResult(this.roleid, 43, new Object[0]);
/*     */             
/*  69 */             return false;
/*     */           }
/*  71 */           if (!team.isAllTeamMemberNormal()) {
/*  72 */             CrossCompeteManager.sendNormalResult(this.roleid, 44, new Object[0]);
/*     */             
/*  74 */             return false;
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*  79 */         else if (team.getTeamAllMembersNum() > 1) {
/*  80 */           CrossCompeteManager.sendNormalResult(this.roleid, 42, new Object[0]);
/*     */           
/*  82 */           return false;
/*     */         }
/*     */         
/*  85 */         roles.addAll(team.getTeamMemberList());
/*     */       }
/*     */       else {
/*  88 */         CrossCompeteManager.sendNormalResult(this.roleid, 42, new Object[0]);
/*     */         
/*  90 */         return false;
/*     */       }
/*     */     }
/*     */     else {
/*  94 */       roles.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/*  97 */     Map<Long, String> roleid2Userid = new HashMap();
/*  98 */     List<String> userids = new ArrayList();
/*  99 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 101 */       String userid = RoleInterface.getUserId(r);
/* 102 */       userids.add(userid);
/* 103 */       roleid2Userid.put(Long.valueOf(r), userid);
/*     */     }
/*     */     
/*     */ 
/* 107 */     lock(User.getTable(), userids);
/*     */     
/* 109 */     lock(Basic.getTable(), roles);
/*     */     
/*     */ 
/* 112 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 113 */     if (xCompete == null) {
/* 114 */       CrossCompeteManager.logError("PLeaveCrossCompeteMapReq.processImp@no compete|roleid=%d|factionid=%d|world=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Long.valueOf(world) });
/*     */       
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, xRoamRole.getFactionid(), xFaction.getOpponent());
/*     */     
/*     */ 
/* 123 */     if (xAgainst == null) {
/* 124 */       CrossCompeteManager.logError("PLeaveCrossCompeteMapReq.processImp@no against|roleid=%d|factionid=%d|world=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Long.valueOf(world) });
/*     */       
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*     */ 
/* 133 */     if (CrossCompeteManager.isPrepareStage(stage))
/*     */     {
/* 135 */       if (team != null)
/*     */       {
/* 137 */         boolean ret = CrossCompeteRoamManager.leave(roles, roleid2Userid, 0);
/*     */         
/* 139 */         if (!ret) {
/* 140 */           CrossCompeteManager.logError("PLeaveCrossCompeteMapReq.processImp@team back failed|role2user=%s", new Object[] { roleid2Userid });
/*     */           
/*     */ 
/* 143 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 148 */         CrossCompeteRoamManager.leave((String)roleid2Userid.get(Long.valueOf(this.roleid)), this.roleid, xRoamRole, 0);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 153 */     else if (xAgainst.getWinner() == factionid)
/*     */     {
/* 155 */       CrossCompeteRoamManager.leave((String)roleid2Userid.get(Long.valueOf(this.roleid)), this.roleid, xRoamRole, 6);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 160 */       CrossCompeteRoamManager.leave((String)roleid2Userid.get(Long.valueOf(this.roleid)), this.roleid, xRoamRole, 0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PLeaveCrossCompeteMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */