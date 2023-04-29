/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatchFaction;
/*     */ import xbean.FactionCrossCompete;
/*     */ import xbean.RoleCrossCompete;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PRoleBack
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final String userid;
/*     */   private final Octets userToken;
/*     */   private final int winTimes;
/*     */   private final int loseTimes;
/*     */   private final int escapeTimes;
/*     */   private final int winStreakAwardTimes;
/*     */   private final int treasureAward;
/*     */   private final int reason;
/*     */   private final ExchangeDataHandlerInfo exchangeDataHandlerInfo;
/*     */   
/*     */   public PRoleBack(long roleid, String userid, Octets userToken, int winTimes, int loseTimes, int escapteTimes, int winStreakAwardTimes, int treasureAward, int reason, ExchangeDataHandlerInfo exchangeDataHandlerInfo)
/*     */   {
/*  48 */     this.roleid = roleid;
/*  49 */     this.userid = userid;
/*  50 */     this.userToken = userToken;
/*  51 */     this.winTimes = winTimes;
/*  52 */     this.loseTimes = loseTimes;
/*  53 */     this.escapeTimes = escapteTimes;
/*  54 */     this.winStreakAwardTimes = winStreakAwardTimes;
/*  55 */     this.treasureAward = treasureAward;
/*  56 */     this.reason = reason;
/*  57 */     this.exchangeDataHandlerInfo = exchangeDataHandlerInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  63 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*     */     
/*     */ 
/*  66 */     RoleCrossCompete xRoleCompete = CrossCompeteManager.createXRoleCrossCompeteIfNotExist(this.roleid);
/*     */     
/*     */ 
/*     */ 
/*  70 */     Octets localToken = LoginManager.getLocalToken(this.userid);
/*  71 */     if (localToken == null) {
/*  72 */       CrossCompeteManager.logWarn("PRoleBack.processImp@local token null|roleid=%d|win_times=%d|lose_times=%d|win_streak_award_times=%d|treasure_award=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.winTimes), Integer.valueOf(this.loseTimes), Integer.valueOf(this.winStreakAwardTimes), Integer.valueOf(this.treasureAward), Integer.valueOf(this.reason) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!localToken.equals(this.userToken)) {
/*  85 */       CrossCompeteManager.logWarn("PRoleBack.processImp@token not match|roleid=%d|win_times=%d|lose_times=%d|win_streak_award_times=%d|treasure_award=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.winTimes), Integer.valueOf(this.loseTimes), Integer.valueOf(this.winStreakAwardTimes), Integer.valueOf(this.treasureAward), Integer.valueOf(this.reason) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     CrossCompeteManager.onCrossBack(this.userid, this.roleid);
/*     */     
/* 100 */     if (this.exchangeDataHandlerInfo != null) {
/* 101 */       ReturnFromRoamServerHandlerManager.unboxData(this.userid, this.roleid, this.exchangeDataHandlerInfo);
/*     */     }
/*     */     
/*     */ 
/* 105 */     boolean participated = xRoleCompete.getParticipated();
/*     */     
/* 107 */     if (participated) {
/* 108 */       CrossCompeteManager.logWarn("PRoleBack.processImp@already participated|roleid=%d|win_times=%d|lose_times=%d|win_streak_award_times=%d|treasure_award=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.winTimes), Integer.valueOf(this.loseTimes), Integer.valueOf(this.winStreakAwardTimes), Integer.valueOf(this.treasureAward), Integer.valueOf(this.reason) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */       return true;
/*     */     }
/*     */     
/* 120 */     if (!CrossCompeteManager.isPrepareStage()) {
/* 121 */       xRoleCompete.setParticipated(true);
/*     */     }
/*     */     
/*     */ 
/* 125 */     if (this.winStreakAwardTimes > 0) {
/* 126 */       List<String> contentArgs = new ArrayList();
/* 127 */       contentArgs.add(String.valueOf(this.winStreakAwardTimes));
/* 128 */       contentArgs.add(String.valueOf(this.winStreakAwardTimes));
/*     */       
/* 130 */       TLogArg winStreakTlogArg = new TLogArg(LogReason.CROSS_COMPETE_WIN_STREAK_AWARD, this.winStreakAwardTimes);
/*     */       
/*     */ 
/* 133 */       AwardReason winStreakAwardReason = new AwardReason(LogReason.CROSS_COMPETE_WIN_STREAK_AWARD, this.winStreakAwardTimes);
/*     */       
/*     */ 
/* 136 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(SCrossCompeteConsts.getInstance().WinStreakAward, this.roleid, winStreakAwardReason);
/*     */       
/*     */ 
/* 139 */       MailAttachment attachment = new MailAttachment();
/* 140 */       if (awardModel != null) {
/* 141 */         List<AwardModel> awardModels = new ArrayList();
/* 142 */         for (int i = 0; i < this.winStreakAwardTimes; i++) {
/* 143 */           awardModels.add(awardModel);
/*     */         }
/*     */         
/* 146 */         AwardInterface.fillMailAttachMentBy(awardModels, attachment);
/*     */       }
/*     */       
/* 149 */       MailInterface.synBuildAndSendMail(this.roleid, SCrossCompeteConsts.getInstance().WinStreakMail, null, contentArgs, attachment, winStreakTlogArg);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 155 */     if (this.reason != 0) {
/* 156 */       TLogArg leaveTlogArg = new TLogArg(LogReason.CROSS_COMPETE_LEAVE_AWARD);
/* 157 */       MailInterface.synBuildAndSendMail(this.roleid, SCrossCompeteConsts.getInstance().LeaveAwardMail, null, null, leaveTlogArg);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 162 */     if ((this.winTimes > 0) || (this.loseTimes > 0) || (this.escapeTimes > 0)) {
/* 163 */       List<String> contentArgs = new ArrayList();
/* 164 */       contentArgs.add(String.valueOf(this.winTimes));
/* 165 */       contentArgs.add(String.valueOf(this.loseTimes));
/* 166 */       contentArgs.add(String.valueOf(this.escapeTimes));
/*     */       
/* 168 */       TLogArg fightAwardTlog = new TLogArg(LogReason.CROSS_COMPETE_FIGHT_AWARD);
/* 169 */       AwardReason awardReason = new AwardReason(LogReason.CROSS_BATTLE_AWARD);
/* 170 */       List<AwardModel> awardModels = new ArrayList();
/*     */       
/* 172 */       if (this.winTimes > 0) {
/* 173 */         for (int i = 0; i < this.winTimes; i++) {
/* 174 */           AwardModel winModel = AwardInterface.getRoleAwardModel(SCrossCompeteConsts.getInstance().WinFightAward, this.roleid, -1, awardReason);
/*     */           
/* 176 */           awardModels.add(winModel);
/*     */         }
/*     */       }
/* 179 */       if (this.loseTimes > 0) {
/* 180 */         for (int i = 0; i < this.loseTimes; i++) {
/* 181 */           AwardModel loseModel = AwardInterface.getRoleAwardModel(SCrossCompeteConsts.getInstance().LoseFightAward, this.roleid, -1, awardReason);
/*     */           
/* 183 */           awardModels.add(loseModel);
/*     */         }
/*     */       }
/*     */       
/* 187 */       MailAttachment attachment = new MailAttachment();
/* 188 */       AwardInterface.fillMailAttachMentBy(awardModels, attachment);
/*     */       
/* 190 */       MailInterface.synBuildAndSendMail(this.roleid, SCrossCompeteConsts.getInstance().FightAwardMail, null, contentArgs, attachment, fightAwardTlog);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 196 */     if (this.treasureAward > 0) {
/* 197 */       TLogArg treasureTLogArg = new TLogArg(LogReason.CROSS_COMPETE_TREASURE_AWARD, this.treasureAward);
/*     */       
/* 199 */       AwardReason awardReason = new AwardReason(LogReason.CROSS_COMPETE_TREASURE_AWARD);
/*     */       
/* 201 */       AwardModel awardModel = AwardInterface.getRoleFixAwardModel(this.treasureAward, this.roleid, awardReason);
/*     */       
/*     */ 
/* 204 */       List<String> contextArgs = new ArrayList();
/*     */       
/* 206 */       MailAttachment attachment = AwardInterface.getMailAttachmentBy(awardModel);
/* 207 */       MailInterface.synBuildAndSendMail(this.roleid, SCrossCompeteConsts.getInstance().WinnerAwardMail, null, contextArgs, attachment, treasureTLogArg);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 212 */     long factionid = GangInterface.getGangId(this.roleid);
/*     */     
/*     */ 
/* 215 */     FactionCrossCompete xFaction = CrossCompeteManager.getXFactionCrossCompete(factionid, false);
/* 216 */     if (xFaction == null) {
/* 217 */       CrossCompeteManager.logInfo("PRoleBack.processImp@no faction|roleid=%d|factionid=%d|win_times=%d|lose_times=%d|win_streak_award_times=%d|treasure_award=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Integer.valueOf(this.winTimes), Integer.valueOf(this.loseTimes), Integer.valueOf(this.winStreakAwardTimes), Integer.valueOf(this.treasureAward), Integer.valueOf(this.reason) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 226 */       return false;
/*     */     }
/*     */     
/* 229 */     long opponentFactionid = xFaction.getOpponent();
/*     */     
/* 231 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(factionid), Long.valueOf(opponentFactionid) }));
/*     */     
/* 233 */     xFaction = CrossCompeteManager.getXFactionCrossCompete(factionid, true);
/*     */     
/*     */ 
/* 236 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/* 237 */     if (xCompete == null) {
/* 238 */       CrossCompeteManager.logInfo("PRoleBack.processImp@no cross compete|roleid=%d|win_times=%d|lose_times=%d|win_streak_award_times=%d|treasure_award=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.winTimes), Integer.valueOf(this.loseTimes), Integer.valueOf(this.winStreakAwardTimes), Integer.valueOf(this.treasureAward), Integer.valueOf(this.reason) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 246 */       return false;
/*     */     }
/*     */     
/* 249 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, factionid, opponentFactionid);
/*     */     
/* 251 */     if (xAgainst == null) {
/* 252 */       CrossCompeteManager.logInfo("PRoleBack.processImp@no against|roleid=%d|factionid=%d|opponent_factionid=%d|win_times=%d|lose_times=%d|win_streak_award_times=%d|treasure_award=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(factionid), Long.valueOf(xFaction.getOpponent()), Integer.valueOf(this.winTimes), Integer.valueOf(this.loseTimes), Integer.valueOf(this.winStreakAwardTimes), Integer.valueOf(this.treasureAward), Integer.valueOf(this.reason) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 262 */       return false;
/*     */     }
/*     */     
/* 265 */     if (xAgainst.getWinner() <= 0L) {
/* 266 */       String selfName = null;
/* 267 */       String opponentName = null;
/* 268 */       if (factionid < opponentFactionid) {
/* 269 */         selfName = xAgainst.getFront_faction().getName();
/* 270 */         opponentName = xAgainst.getBehind_faction().getName();
/*     */       }
/*     */       else {
/* 273 */         selfName = xAgainst.getBehind_faction().getName();
/* 274 */         opponentName = xAgainst.getFront_faction().getName();
/*     */       }
/*     */       
/* 277 */       if ((this.reason == 4) || (this.reason == 5) || (this.reason == 6))
/*     */       {
/*     */ 
/* 280 */         xAgainst.setWinner(factionid);
/*     */         
/* 282 */         xFaction.setWin_times(xFaction.getWin_times() + 1);
/*     */         
/* 284 */         mzm.gsp.gang.main.Gang opponentFaction = GangInterface.getGang(xFaction.getOpponent(), false);
/* 285 */         if (opponentFaction != null) {
/* 286 */           CrossCompeteManager.broadcastCompeteResult(factionid, selfName, true, opponentFactionid, opponentName, true);
/*     */         }
/*     */         else
/*     */         {
/* 290 */           CrossCompeteManager.broadcastCompeteResult(factionid, selfName, true, opponentFactionid, opponentName, false);
/*     */         }
/*     */         
/*     */       }
/* 294 */       else if (this.reason == 3) {
/* 295 */         xAgainst.setWinner(xFaction.getOpponent());
/*     */         
/* 297 */         xFaction.setLose_times(xFaction.getLose_times() + 1);
/*     */         
/* 299 */         mzm.gsp.gang.main.Gang opponentFaction = GangInterface.getGang(xFaction.getOpponent(), false);
/* 300 */         if (opponentFaction != null) {
/* 301 */           CrossCompeteManager.broadcastCompeteResult(opponentFactionid, opponentName, true, factionid, selfName, true);
/*     */         }
/*     */         else
/*     */         {
/* 305 */           CrossCompeteManager.broadcastCompeteResult(opponentFactionid, opponentName, false, factionid, selfName, true);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 312 */     int pvpFightCount = this.winTimes + this.loseTimes + this.escapeTimes;
/* 313 */     if (pvpFightCount > 0) {
/* 314 */       ChangeModelCardInterface.consumePVPFightCount(this.roleid, pvpFightCount);
/*     */     }
/*     */     
/*     */ 
/* 318 */     boolean isWinner = xAgainst.getWinner() == factionid;
/* 319 */     CrossCompeteManager.triggerParticipateEvent(this.roleid, factionid, this.winTimes, this.loseTimes, this.escapeTimes, isWinner);
/*     */     
/*     */ 
/* 322 */     CrossCompeteManager.forceRemoveTeamBackContextByRoleid(this.roleid);
/*     */     
/*     */ 
/* 325 */     TeamInterface.leaveTeamNoneRealTime(this.roleid);
/*     */     
/* 327 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PRoleBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */