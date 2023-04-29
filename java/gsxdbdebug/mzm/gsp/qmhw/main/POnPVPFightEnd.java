/*     */ package mzm.gsp.qmhw.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qmhw.SSynQMHWFightAward;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWFightAwardCfg;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWScoreModifyCfg;
/*     */ import mzm.gsp.util.ELO.RankResult;
/*     */ import xbean.QMHWActivity;
/*     */ import xbean.RoleQMHWScore;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     if (!(((PVPFightEndArg)this.arg).context instanceof QMHWFightContext)) {
/*  30 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  35 */     Set<Long> allRoles = ((PVPFightEndArg)this.arg).getAllRoles();
/*  36 */     Map<Long, String> allUsers = new HashMap();
/*  37 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  38 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  39 */       allUsers.put(Long.valueOf(roleid), userid);
/*     */     }
/*     */     
/*     */ 
/*  43 */     lock(xtable.User.getTable(), allUsers.values());
/*     */     
/*     */ 
/*  46 */     lock(xtable.Arenascore.getTable(), allRoles);
/*     */     
/*  48 */     List<Long> winRoles = ((PVPFightEndArg)this.arg).getWinnerList();
/*  49 */     List<Long> loseRoles = ((PVPFightEndArg)this.arg).getLoserList();
/*     */     
/*  51 */     List<Long> winRolesNotEscaped = ((PVPFightEndArg)this.arg).getWinnerNotEscapeList();
/*  52 */     List<Long> loseRolesNotEscaped = ((PVPFightEndArg)this.arg).getLoserNotEscapeList();
/*     */     
/*  54 */     int winNum = winRoles.size();
/*     */     
/*     */ 
/*  57 */     QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/*  58 */     xQmhwActivity.getFightids().remove(Long.valueOf(((PVPFightEndArg)this.arg).fightid));
/*     */     
/*     */ 
/*  61 */     boolean isActivityOpen = ActivityInterface.isActivityOpen(SQMHWCfgConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  63 */     Map<Long, Integer> scoresMap = new HashMap();
/*  64 */     Iterator i$; if (isActivityOpen)
/*  65 */       for (i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { r1 = ((Long)i$.next()).longValue();
/*  66 */         banRankScore = mzm.gsp.idip.main.IdipManager.isBanRank(r1, 14);
/*  67 */         xScore1 = QMHWManager.getXQMHWRoleCreateIfNotExist(r1);
/*  68 */         for (i$ = loseRoles.iterator(); i$.hasNext();) { long r2 = ((Long)i$.next()).longValue();
/*  69 */           RoleQMHWScore xScore2 = QMHWManager.getXQMHWRoleCreateIfNotExist(r2);
/*     */           
/*  71 */           Integer times2 = (Integer)xScore1.getMatchroles().get(Long.valueOf(r2));
/*  72 */           if (times2 == null) {
/*  73 */             times2 = Integer.valueOf(1);
/*     */           } else {
/*  75 */             times2 = Integer.valueOf(times2.intValue() + 1);
/*     */           }
/*  77 */           xScore1.getMatchroles().put(Long.valueOf(r2), times2);
/*     */           
/*  79 */           Integer times1 = (Integer)xScore2.getMatchroles().get(Long.valueOf(r1));
/*  80 */           if (times1 == null) {
/*  81 */             times1 = Integer.valueOf(1);
/*     */           } else {
/*  83 */             times1 = Integer.valueOf(times1.intValue() + 1);
/*     */           }
/*  85 */           xScore2.getMatchroles().put(Long.valueOf(r1), times1);
/*     */           
/*  87 */           if (!banRankScore)
/*     */           {
/*  89 */             ELO.RankResult rankResult = mzm.gsp.util.ELO.getELORankIncResult(xScore1.getScore(), xScore2.getScore(), SQMHWCfgConsts.getInstance().K, mzm.gsp.util.ELO.MatchResult.Win);
/*     */             
/*     */ 
/*  92 */             int addScore = Math.max(1, rankResult.getRankA());
/*  93 */             if (QMHWManager.isQMHWChange1Open()) {
/*  94 */               SQMHWScoreModifyCfg qmhwScoreModifyCfg = SQMHWScoreModifyCfg.get(winNum);
/*  95 */               if (qmhwScoreModifyCfg != null) {
/*  96 */                 addScore = (int)(addScore * qmhwScoreModifyCfg.modifyParam);
/*  97 */                 addScore = Math.max(1, addScore);
/*     */               }
/*     */             }
/*     */             
/* 101 */             xScore1.setScore(xScore1.getScore() + addScore);
/*     */             
/* 103 */             Integer gotScore = (Integer)scoresMap.get(Long.valueOf(r1));
/* 104 */             if (gotScore == null) {
/* 105 */               gotScore = Integer.valueOf(0);
/*     */             }
/* 107 */             gotScore = Integer.valueOf(gotScore.intValue() + addScore);
/* 108 */             scoresMap.put(Long.valueOf(r1), gotScore);
/*     */           }
/*     */         }
/*     */       }
/*     */     long r1;
/*     */     boolean banRankScore;
/*     */     RoleQMHWScore xScore1;
/*     */     Iterator i$;
/* 116 */     updateWin(winRolesNotEscaped, isActivityOpen);
/*     */     
/*     */ 
/* 119 */     updateLose(loseRolesNotEscaped, isActivityOpen);
/*     */     
/*     */ 
/* 122 */     AwardReason winReason = new AwardReason(mzm.gsp.tlog.LogReason.QMHW_MATCH_WIN_AWARD);
/* 123 */     AwardReason loseReason = new AwardReason(mzm.gsp.tlog.LogReason.QMHW_MATCH_LOSE_AWARD);
/* 124 */     if (winRolesNotEscaped.size() > 0) {
/* 125 */       List<String> winUsersNotEscaped = new ArrayList();
/* 126 */       for (Long roleId : winRolesNotEscaped) {
/* 127 */         winUsersNotEscaped.add(allUsers.get(roleId));
/*     */       }
/* 129 */       int winAwardid = getWinAwardId(winRolesNotEscaped);
/* 130 */       Map<Long, AwardModel> winAwardsMap = AwardInterface.award(winAwardid, winUsersNotEscaped, winRolesNotEscaped, winRoles, -1, false, false, winReason);
/*     */       
/*     */ 
/*     */ 
/* 134 */       for (Map.Entry<Long, AwardModel> entry : winAwardsMap.entrySet()) {
/* 135 */         long roleid = ((Long)entry.getKey()).longValue();
/* 136 */         Integer gotScore = (Integer)scoresMap.get(Long.valueOf(roleid));
/* 137 */         SSynQMHWFightAward synQMHWFightAward = new SSynQMHWFightAward();
/* 138 */         AwardInterface.fillAwardBean(synQMHWFightAward.awardbean, (AwardModel)entry.getValue());
/* 139 */         if (gotScore != null) {
/* 140 */           synQMHWFightAward.score = gotScore.intValue();
/*     */           
/* 142 */           QMHWManager.logInfo("POnPVPFightEnd.processImp@get qmhw score|roleid=%d|add_score=%d|win_roles=%s|lose_roles=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(gotScore.intValue()), winRoles, loseRoles });
/*     */         }
/*     */         
/*     */ 
/* 146 */         OnlineManager.getInstance().send(roleid, synQMHWFightAward);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 151 */     if (loseRolesNotEscaped.size() > 0) {
/* 152 */       List<String> loseUsersNotEscaped = new ArrayList();
/* 153 */       for (Long roleId : loseRolesNotEscaped) {
/* 154 */         loseUsersNotEscaped.add(allUsers.get(roleId));
/*     */       }
/* 156 */       int loseAwardid = getLoseAwardId(loseRolesNotEscaped);
/* 157 */       Map<Long, AwardModel> loseAwardsMap = AwardInterface.award(loseAwardid, loseUsersNotEscaped, loseRolesNotEscaped, loseRoles, -1, false, false, loseReason);
/*     */       
/*     */ 
/*     */ 
/* 161 */       for (Map.Entry<Long, AwardModel> entry : loseAwardsMap.entrySet()) {
/* 162 */         long roleid = ((Long)entry.getKey()).longValue();
/* 163 */         SSynQMHWFightAward synQMHWFightAward = new SSynQMHWFightAward();
/* 164 */         AwardInterface.fillAwardBean(synQMHWFightAward.awardbean, (AwardModel)entry.getValue());
/* 165 */         OnlineManager.getInstance().send(roleid, synQMHWFightAward);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 170 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 171 */       ActivityInterface.tlogActivity(r, SQMHWCfgConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     }
/* 173 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 174 */       ActivityInterface.tlogActivity(r, SQMHWCfgConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/* 177 */     return true;
/*     */   }
/*     */   
/*     */   private int getWinAwardId(List<Long> winRoles) {
/* 181 */     int roleSize = winRoles.size();
/* 182 */     SQMHWFightAwardCfg qmhwAwardCfg = SQMHWFightAwardCfg.get(roleSize);
/* 183 */     if (qmhwAwardCfg == null) {
/* 184 */       return SQMHWCfgConsts.getInstance().WIN_AWARDID;
/*     */     }
/* 186 */     return qmhwAwardCfg.winAwardId;
/*     */   }
/*     */   
/*     */   public int getLoseAwardId(List<Long> loseRoles)
/*     */   {
/* 191 */     int roleSize = loseRoles.size();
/* 192 */     SQMHWFightAwardCfg qmhwAwardCfg = SQMHWFightAwardCfg.get(roleSize);
/* 193 */     if (qmhwAwardCfg == null) {
/* 194 */       return SQMHWCfgConsts.getInstance().LOSE_AWARDID;
/*     */     }
/* 196 */     return qmhwAwardCfg.loseAwardid;
/*     */   }
/*     */   
/*     */   private void updateLose(List<Long> roleList, boolean isActivityOpen)
/*     */   {
/* 201 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 202 */       RoleQMHWScore xRoleQMHWScore = QMHWManager.getXQMHWRoleCreateIfNotExist(roleid);
/* 203 */       xRoleQMHWScore.setContinuewincount(0);
/* 204 */       xRoleQMHWScore.setLosecount(xRoleQMHWScore.getLosecount() + 1);
/* 205 */       QMHWManager.sendQMHWRoleInfo(roleid, xRoleQMHWScore);
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateWin(List<Long> roleList, boolean isActivityOpen)
/*     */   {
/* 211 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 212 */       RoleQMHWScore xRoleQMHWScore = QMHWManager.getXQMHWRoleCreateIfNotExist(roleid);
/* 213 */       int continueWin = xRoleQMHWScore.getContinuewincount();
/* 214 */       xRoleQMHWScore.setContinuewincount(++continueWin);
/* 215 */       xRoleQMHWScore.setWincount(xRoleQMHWScore.getWincount() + 1);
/*     */       
/* 217 */       if (isActivityOpen) {
/* 218 */         QMHWChartObj qmhwChartObj = new QMHWChartObj(roleid, xRoleQMHWScore.getScore());
/* 219 */         QMHWChart.getInstance().rank(qmhwChartObj);
/*     */       }
/*     */       
/* 222 */       QMHWManager.sendQMHWRoleInfo(roleid, xRoleQMHWScore);
/* 223 */       if (continueWin % SQMHWCfgConsts.getInstance().CONTINU_WIN_COUNT == 0)
/*     */       {
/* 225 */         mzm.gsp.qmhw.SBrocastContinueWin brocastContinueWin = new mzm.gsp.qmhw.SBrocastContinueWin();
/* 226 */         brocastContinueWin.roleid = roleid;
/* 227 */         brocastContinueWin.rolename = mzm.gsp.role.main.RoleInterface.getName(roleid);
/* 228 */         brocastContinueWin.count = continueWin;
/* 229 */         OnlineManager.getInstance().sendAll(brocastContinueWin);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */