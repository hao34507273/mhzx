/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*     */ import mzm.gsp.crossserver.main.MatchActivityContextType;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.crossserver.main.RoamedMatchContext;
/*     */ import mzm.gsp.crossserver.main.RoamedRoleMatchMarkingInfo;
/*     */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*     */ import mzm.gsp.ladder.CrossMatchProcessInfo;
/*     */ import mzm.gsp.ladder.RoleLadderCrossMatchInfo;
/*     */ import mzm.gsp.ladder.SLadderCrossMatchRoleInfo;
/*     */ import mzm.gsp.ladder.SLoginWaitForOthers;
/*     */ import mzm.gsp.ladder.SUpdateCrossMatchProcessInfo;
/*     */ import mzm.gsp.ladder.WaitRoleInfo;
/*     */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*     */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Ladder;
/*     */ import xtable.Role2matchcontextid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ROnRoleLogin
/*     */   extends PlayerLoginRunnable
/*     */ {
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  46 */     if (GameServer.logger().isDebugEnabled()) {
/*  47 */       GameServer.logger().debug(String.format("[Ladder]ROnRoleLogin.process@ladder role login|roleid=%d", new Object[] { this.arg }));
/*     */     }
/*     */     
/*  50 */     if (GameServerInfoManager.isRoamServer()) {
/*  51 */       String userid = RoleInterface.getUserId(((Long)this.arg).longValue());
/*  52 */       RoamedMatchContext roamedMatchContext = (RoamedMatchContext)LadderMatchRomaContextManager.getInstance().getValue(this.arg);
/*  53 */       if (roamedMatchContext == null) {
/*  54 */         roamedMatchContext = getRoamedMatchContext(userid);
/*     */       }
/*  56 */       if (roamedMatchContext == null) {
/*  57 */         return;
/*     */       }
/*  59 */       if (roamedMatchContext.activityContextTypeid != MatchActivityContextType.LADDER.typeid) {
/*  60 */         return;
/*     */       }
/*  62 */       Set<Long> allRoleids = new HashSet();
/*  63 */       SLadderCrossMatchRoleInfo ladderCrossMatchRoleInfo = new SLadderCrossMatchRoleInfo();
/*  64 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedMatchContext.roleMatchMarkingInfos) {
/*  65 */         RoleLadderCrossMatchInfo roleLadderCrossMatchInfo = new RoleLadderCrossMatchInfo();
/*  66 */         LadderInterface.fillLadderCrossMatchInfo(roleLadderCrossMatchInfo, roamedRoleMatchMarkingInfo);
/*  67 */         ladderCrossMatchRoleInfo.matchteamainfos.add(roleLadderCrossMatchInfo);
/*  68 */         allRoleids.add(this.arg);
/*     */       }
/*     */       
/*  71 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedMatchContext.opponentRoleMatchMarkingInfos) {
/*  72 */         RoleLadderCrossMatchInfo roleLadderCrossMatchInfo = new RoleLadderCrossMatchInfo();
/*  73 */         LadderInterface.fillLadderCrossMatchInfo(roleLadderCrossMatchInfo, roamedRoleMatchMarkingInfo);
/*  74 */         ladderCrossMatchRoleInfo.matchteambinfos.add(roleLadderCrossMatchInfo);
/*  75 */         allRoleids.add(this.arg);
/*     */       }
/*  77 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), ladderCrossMatchRoleInfo);
/*     */       
/*  79 */       SUpdateCrossMatchProcessInfo updateCrossMatchProcessInfo = new SUpdateCrossMatchProcessInfo();
/*  80 */       CrossMatchProcessInfo crossMatchProcessInfo = new CrossMatchProcessInfo();
/*  81 */       crossMatchProcessInfo.process = 3;
/*  82 */       crossMatchProcessInfo.roleid = ((Long)this.arg).longValue();
/*  83 */       updateCrossMatchProcessInfo.crossmatchprocessinfos.add(crossMatchProcessInfo);
/*  84 */       OnlineManager.getInstance().sendMulti(updateCrossMatchProcessInfo, allRoleids);
/*  85 */       return;
/*     */     }
/*     */     
/*     */ 
/*  89 */     String loginUserid = RoleInterface.getUserId(((Long)this.arg).longValue());
/*  90 */     long roleid = ((Long)this.arg).longValue();
/*     */     
/*  92 */     new PLoginPro(roleid).call();
/*     */     
/*  94 */     new PFightTipPro(roleid).call();
/*     */     
/*     */ 
/*  97 */     LadderMatchEndContext ladderMatchEndContext = (LadderMatchEndContext)LadderMatchContextManager.getInstance().getValue(loginUserid);
/*     */     
/*  99 */     if (ladderMatchEndContext != null) {
/* 100 */       ladderMatchEndContext.addOnlineRole(roleid);
/*     */       
/* 102 */       SLoginWaitForOthers loginWaitForOthers = new SLoginWaitForOthers();
/* 103 */       loginWaitForOthers.ret = ladderMatchEndContext.winOrLose;
/* 104 */       for (LadderMatchEndContext.LadderMatchEnd ladderMatchEnd : ladderMatchEndContext.matchEndList) {
/* 105 */         Ladder xLadder = LadderManager.getAndInitXLadder(ladderMatchEnd.roleid, false);
/* 106 */         WaitRoleInfo waitRoleInfo = new WaitRoleInfo();
/* 107 */         fillWaitRoleInfo(ladderMatchEnd, xLadder, waitRoleInfo);
/* 108 */         waitRoleInfo.matchscore -= waitRoleInfo.fightscore;
/* 109 */         loginWaitForOthers.waitroleinfos.add(waitRoleInfo);
/*     */       }
/* 111 */       OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), loginWaitForOthers);
/*     */       
/*     */ 
/* 114 */       boolean ret = new PCheckTeamPro(((Long)this.arg).longValue()).call();
/* 115 */       if (!ret) {
/* 116 */         List<Long> teamList = new ArrayList();
/* 117 */         teamList.addAll(ladderMatchEndContext.getAllRoleList());
/* 118 */         teamList.remove(Long.valueOf(roleid));
/* 119 */         teamList.add(0, Long.valueOf(roleid));
/* 120 */         TeamInterface.formatCreateTeamAsTmpLeave(ladderMatchEndContext.getLeaderid(), teamList);
/* 121 */         GameServer.logger().info(String.format("[Ladder]ROnRoleLogin.processImp@format create team|roleids=%s", new Object[] { teamList }));
/*     */       }
/*     */       
/* 124 */       boolean checkTeamAgain = new PCheckTeamPro(((Long)this.arg).longValue()).call();
/* 125 */       if (checkTeamAgain)
/*     */       {
/* 127 */         new PReturnTeamPro(roleid).call();
/* 128 */         if (roleid == ladderMatchEndContext.getLeaderid()) {
/* 129 */           new PAppointLeaderPro(roleid).call();
/*     */         }
/*     */         
/* 132 */         boolean isAllOnline = ladderMatchEndContext.isAllOnline();
/* 133 */         if (isAllOnline) {
/* 134 */           new PDesignTeamPro(roleid, ladderMatchEndContext.getAllRoleList()).call();
/*     */         }
/* 136 */         new PAttendActivityPro(roleid).call();
/*     */       } else {
/* 138 */         GameServer.logger().info(String.format("[Ladder]ROnRoleLogin.processImp@check again,do not has team!|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 146 */     Long contextid = Role2matchcontextid.select((Long)this.arg);
/* 147 */     if (contextid != null) {
/* 148 */       MatchActivityContext matchActivityContext = CrossServerInterface.getMatchActivityContext(contextid.longValue());
/* 149 */       if ((matchActivityContext != null) && ((matchActivityContext instanceof LadderMatchContext))) {
/* 150 */         LadderMatchContext ladderMatchContext = (LadderMatchContext)matchActivityContext;
/* 151 */         List<RoleMatchMarkingInfo> opponentInfos = CrossServerInterface.getOpponentRoleMatchMarkingInfos(contextid.longValue());
/*     */         
/* 153 */         if ((opponentInfos != null) && (opponentInfos.size() > 0))
/*     */         {
/* 155 */           SLadderCrossMatchRoleInfo ladderCrossMatchRoleInfo = new SLadderCrossMatchRoleInfo();
/* 156 */           for (RoleMatchMarkingInfo roleMatchMarkingInfo : CrossServerInterface.getRoleMatchMarkingInfos(contextid.longValue()))
/*     */           {
/* 158 */             Integer process = ladderMatchContext.getRoleProcess(roleMatchMarkingInfo.getRoleid());
/* 159 */             if (process == null) {
/* 160 */               process = Integer.valueOf(0);
/*     */             }
/* 162 */             RoleLadderCrossMatchInfo roleLadderCrossMatchInfo = new RoleLadderCrossMatchInfo();
/* 163 */             LadderInterface.fillLadderCrossMatchInfo(roleLadderCrossMatchInfo, roleMatchMarkingInfo, process.intValue());
/*     */             
/* 165 */             ladderCrossMatchRoleInfo.matchteamainfos.add(roleLadderCrossMatchInfo);
/*     */           }
/*     */           
/* 168 */           for (RoleMatchMarkingInfo roleMatchMarkingInfo : opponentInfos) {
/* 169 */             Integer process = ladderMatchContext.getRoleProcess(roleMatchMarkingInfo.getRoleid());
/* 170 */             if (process == null) {
/* 171 */               process = Integer.valueOf(0);
/*     */             }
/* 173 */             RoleLadderCrossMatchInfo roleLadderCrossMatchInfo = new RoleLadderCrossMatchInfo();
/* 174 */             LadderInterface.fillLadderCrossMatchInfo(roleLadderCrossMatchInfo, roleMatchMarkingInfo, process.intValue());
/*     */             
/* 176 */             ladderCrossMatchRoleInfo.matchteambinfos.add(roleLadderCrossMatchInfo);
/*     */           }
/* 178 */           OnlineManager.getInstance().send(((Long)this.arg).longValue(), ladderCrossMatchRoleInfo);
/* 179 */           return;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 185 */     if (!ActivityInterface.isActivityOpen(SLadderConsts.getInstance().activityid)) {
/* 186 */       new PUnSetStatusPro(roleid).call();
/* 187 */       return;
/*     */     }
/*     */     
/* 190 */     new PLoginStageMsg(roleid).call();
/*     */   }
/*     */   
/*     */   private void fillWaitRoleInfo(LadderMatchEndContext.LadderMatchEnd ladderMatchEnd, Ladder xLadder, WaitRoleInfo waitRoleInfo) {
/* 194 */     long roleid = ladderMatchEnd.roleid;
/* 195 */     waitRoleInfo.gender = RoleInterface.getGender(roleid);
/* 196 */     waitRoleInfo.level = RoleInterface.getLevel(roleid);
/* 197 */     if (xLadder != null) {
/* 198 */       waitRoleInfo.losecount = xLadder.getLosecount();
/* 199 */       waitRoleInfo.matchscore = LadderManager.getScore(roleid, xLadder);
/* 200 */       waitRoleInfo.stage = xLadder.getStage();
/* 201 */       waitRoleInfo.wincount = xLadder.getWincount();
/*     */     }
/* 203 */     waitRoleInfo.name = RoleInterface.getName(roleid);
/* 204 */     waitRoleInfo.occupation = RoleInterface.getOccupationId(roleid);
/* 205 */     waitRoleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleid);
/* 206 */     waitRoleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/* 207 */     waitRoleInfo.roleid = roleid;
/* 208 */     waitRoleInfo.fightscore = ladderMatchEnd.changeMatchScore;
/*     */   }
/*     */   
/*     */   private RoamedMatchContext getRoamedMatchContext(String userid)
/*     */   {
/* 213 */     RoamType roamType = CrossServerInterface.getRoamType(userid);
/* 214 */     if ((roamType == null) || (roamType != RoamType.LADDER)) {
/* 215 */       GameServer.logger().info(String.format("[Ladder]POnRoleLogin.getRoamedMatchContext@do not have roam type|userid=%s", new Object[] { userid }));
/*     */       
/*     */ 
/* 218 */       return null;
/*     */     }
/* 220 */     Long roamedInstanceId = CrossServerInterface.getRoamedInstanceid(userid);
/* 221 */     if (roamedInstanceId == null) {
/* 222 */       GameServer.logger().info(String.format("[Ladder]POnRoleLogin.getRoamedMatchContext@do not have roamedInstanceId|userid=%s", new Object[] { userid }));
/*     */       
/*     */ 
/* 225 */       return null;
/*     */     }
/* 227 */     RoamedMatchContext roamedMatchContext = CrossServerInterface.getRoamedMatchContext(roamedInstanceId.longValue());
/* 228 */     if (roamedMatchContext == null) {
/* 229 */       GameServer.logger().info(String.format("[Ladder]POnRoleLogin.getRoamedMatchContext@do not has roamed match context|userid=%s", new Object[] { userid }));
/*     */       
/*     */ 
/*     */ 
/* 233 */       return null;
/*     */     }
/* 235 */     return roamedMatchContext;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */