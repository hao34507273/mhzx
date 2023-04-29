/*     */ package mzm.gsp.arena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.arena.confbean.SArenaConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Arena;
/*     */ import xbean.ArenaScore;
/*     */ import xbean.ArenaTmp;
/*     */ import xtable.Arenascore;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PEnterArenaMapReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int npc;
/*     */   
/*     */   public PEnterArenaMapReq(long roleid, int npc)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.npc = npc;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(this.npc, 150205058, this.roleid)) {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*     */     
/*  44 */     List<Long> roleList = new ArrayList();
/*  45 */     if (team != null) {
/*  46 */       roleList.addAll(team.getTeamNormalList());
/*     */     }
/*     */     else {
/*  49 */       roleList.add(Long.valueOf(this.roleid));
/*     */     }
/*  51 */     Map<Long, String> userIds = new HashMap();
/*  52 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*  53 */       userIds.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  56 */     lock(User.getTable(), userIds.values());
/*     */     
/*  58 */     lock(Basic.getTable(), roleList);
/*     */     
/*     */ 
/*  61 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userIds, roleList, SArenaConsts.getInstance().Activityid);
/*  62 */     if (result.isActivityNotOpen()) {
/*  63 */       ArenaManager.broadcastNormalResult(roleList, 7, new String[0]);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (!result.isCanJoin()) {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if ((team != null) && 
/*  72 */       (!team.isLeader(this.roleid)))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  79 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  80 */       ArenaScore xScore = Arenascore.select(Long.valueOf(r));
/*  81 */       if (xScore != null) {
/*  82 */         if (xScore.getAction_point() <= 0) {
/*  83 */           if (roleList.size() == 1) {
/*  84 */             ArenaManager.sendNormalResult(this.roleid, 1, new String[0]);
/*     */           }
/*     */           else {
/*  87 */             ArenaManager.broadcastNormalResult(roleList, 2, new String[] { RoleInterface.getName(r) });
/*     */           }
/*  89 */           return false;
/*     */         }
/*  91 */         if (xScore.getParticipated()) {
/*  92 */           if (roleList.size() == 1) {
/*  93 */             ArenaManager.sendNormalResult(this.roleid, 3, new String[0]);
/*     */           }
/*     */           else {
/*  96 */             ArenaManager.broadcastNormalResult(roleList, 4, new String[] { RoleInterface.getName(r) });
/*     */           }
/*  98 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 104 */     if ((team != null) && (!team.isAllTeamMemberNormal())) {
/* 105 */       ArenaManager.broadcastNormalResult(roleList, 6, new String[0]);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 111 */     int camp = -1;
/* 112 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 113 */       ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(r);
/* 114 */       if (camp < 0) {
/* 115 */         if (xScore.getCamp() >= 0) {
/* 116 */           camp = xScore.getCamp();
/*     */         }
/*     */         
/*     */       }
/* 120 */       else if ((xScore.getCamp() >= 0) && (xScore.getCamp() != camp)) {
/* 121 */         ArenaManager.sendNormalResult(this.roleid, 5, new String[0]);
/* 122 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 128 */     Arena xArena = ArenaManager.getXArenaIfNotExist();
/* 129 */     if (xArena.getFinished()) {
/* 130 */       ArenaManager.broadcastNormalResult(roleList, 8, new String[0]);
/* 131 */       return false; }
/*     */     Iterator i$;
/*     */     Iterator i$;
/* 134 */     if (camp < 0) {
/* 135 */       camp = ArenaManager.nextCamp(xArena);
/* 136 */       for (i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 137 */         ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(r);
/* 138 */         ArenaManager.joinCamp(xScore, xArena, camp);
/*     */       }
/*     */     }
/*     */     else {
/* 142 */       for (i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 143 */         ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(r);
/* 144 */         if (xScore.getCamp() != camp) {
/* 145 */           ArenaManager.joinCamp(xScore, xArena, camp);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 151 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmpIfNotExist();
/* 152 */     MapInterface.transferToScene(((Long)roleList.get(0)).longValue(), xArenaTmp.getWorld(), SArenaConsts.getInstance().ActivityMap);
/*     */     
/*     */ 
/* 155 */     ArenaManager.logger.info(String.format("PEnterArenaMapReq.processImp@success|roles=%s|camp=%d", new Object[] { roleList.toString(), Integer.valueOf(camp) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PEnterArenaMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */