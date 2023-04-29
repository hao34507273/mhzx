/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.crossserver.main.RoamedRoleMatchMarkingInfo;
/*     */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.ladder.RoleLadderCrossMatchInfo;
/*     */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LadderInterface
/*     */ {
/*     */   public static void startLadderFight(List<Long> activeRoleids, List<Long> passiveRoleids, LadderFightContext ladderFightContext)
/*     */   {
/*  30 */     FightInterface.startPVPFightWithTeamDisposition(activeRoleids, passiveRoleids, ladderFightContext, 15, FightReason.LADDER_FIGHT_IN_CORSS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean removeCrossLadderForIDIP(String userid)
/*     */   {
/*  43 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  47 */         Long roleid = LoginManager.getInstance().getCrossRoleid(this.val$userid, true);
/*  48 */         if (roleid == null) {
/*  49 */           return false;
/*     */         }
/*  51 */         LoginManager.getInstance().onRoleCrossEnd(this.val$userid, roleid.longValue());
/*  52 */         RoleStatusInterface.unsetStatus(roleid.longValue(), 40);
/*  53 */         RoleStatusInterface.unsetStatus(roleid.longValue(), 42);
/*  54 */         RoleStatusInterface.unsetStatus(roleid.longValue(), 43);
/*  55 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeLadderStatusForIDIP(long roleid)
/*     */   {
/*  66 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  70 */         RoleStatusInterface.unsetStatus(this.val$roleid, 40);
/*  71 */         RoleStatusInterface.unsetStatus(this.val$roleid, 42);
/*  72 */         RoleStatusInterface.unsetStatus(this.val$roleid, 43);
/*  73 */         RoleStatusInterface.unsetStatus(this.val$roleid, 41);
/*  74 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean onMatchFightEnd(LadderMatchEndContext matchEndContext)
/*     */   {
/*  87 */     Map<Long, String> role2UserMap = matchEndContext.getRole2UserMap();
/*  88 */     LadderMatchContextManager.getInstance().putKeys(role2UserMap.values(), matchEndContext);
/*  89 */     RoleStatusInterface.setStatus(matchEndContext.getAllRoleList(), 65, false);
/*     */     
/*     */ 
/*  92 */     new LadderFightEndSession(SLadderConsts.getInstance().leaveSec, 0L, matchEndContext.getRole2UserMap());
/*  93 */     return LadderManager.onMatchFightEnd(matchEndContext);
/*     */   }
/*     */   
/*     */   public static void fillLadderCrossMatchInfo(RoleLadderCrossMatchInfo ladderCrossMatchInfo, RoleMatchMarkingInfo roleMatchMarkingInfo, int process)
/*     */   {
/*  98 */     ladderCrossMatchInfo.process = process;
/*  99 */     ladderCrossMatchInfo.gender = roleMatchMarkingInfo.getGender();
/* 100 */     ladderCrossMatchInfo.level = roleMatchMarkingInfo.getLevel();
/* 101 */     ladderCrossMatchInfo.matchscore = roleMatchMarkingInfo.getRanking();
/* 102 */     ladderCrossMatchInfo.occupation = roleMatchMarkingInfo.getOccupation();
/* 103 */     ladderCrossMatchInfo.avatarid = roleMatchMarkingInfo.getAvatarid();
/* 104 */     ladderCrossMatchInfo.avatarframeid = roleMatchMarkingInfo.getAvatarFrameid();
/* 105 */     ladderCrossMatchInfo.losecount = roleMatchMarkingInfo.getLoseNum();
/* 106 */     ladderCrossMatchInfo.roleid = roleMatchMarkingInfo.getRoleid();
/* 107 */     ladderCrossMatchInfo.stage = roleMatchMarkingInfo.getDisplayRank();
/* 108 */     ladderCrossMatchInfo.wincount = roleMatchMarkingInfo.getWinNum();
/* 109 */     ladderCrossMatchInfo.name = roleMatchMarkingInfo.getRoleName();
/*     */   }
/*     */   
/*     */   public static void fillLadderCrossMatchInfo(RoleLadderCrossMatchInfo ladderCrossMatchInfo, RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo)
/*     */   {
/* 114 */     if (roamedRoleMatchMarkingInfo.isLogined()) {
/* 115 */       ladderCrossMatchInfo.process = 3;
/* 116 */     } else if (roamedRoleMatchMarkingInfo.isDataPrepared()) {
/* 117 */       ladderCrossMatchInfo.process = 2;
/*     */     } else {
/* 119 */       ladderCrossMatchInfo.process = 1;
/*     */     }
/* 121 */     ladderCrossMatchInfo.gender = roamedRoleMatchMarkingInfo.getGender();
/* 122 */     ladderCrossMatchInfo.level = roamedRoleMatchMarkingInfo.getLevel();
/* 123 */     ladderCrossMatchInfo.matchscore = roamedRoleMatchMarkingInfo.getRanking();
/* 124 */     ladderCrossMatchInfo.occupation = roamedRoleMatchMarkingInfo.getOccupation();
/* 125 */     ladderCrossMatchInfo.avatarid = roamedRoleMatchMarkingInfo.getAvatarid();
/* 126 */     ladderCrossMatchInfo.avatarframeid = roamedRoleMatchMarkingInfo.getAvatarFrameid();
/* 127 */     ladderCrossMatchInfo.losecount = roamedRoleMatchMarkingInfo.getLoseNum();
/* 128 */     ladderCrossMatchInfo.roleid = roamedRoleMatchMarkingInfo.getRoleid();
/* 129 */     ladderCrossMatchInfo.stage = roamedRoleMatchMarkingInfo.getDisplayRank();
/* 130 */     ladderCrossMatchInfo.wincount = roamedRoleMatchMarkingInfo.getWinNum();
/* 131 */     ladderCrossMatchInfo.name = roamedRoleMatchMarkingInfo.getRoleName();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */