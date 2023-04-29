/*     */ package mzm.gsp.gangrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.confbean.SGangRaceConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gangrace.SRaceAwardRes;
/*     */ import mzm.gsp.gangrace.event.GangRaceEndArg;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GangRaceRoleInfo;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2gangraceinfo;
/*     */ 
/*     */ public class GangRaceActionSession extends Session
/*     */ {
/*     */   private final int winIndex;
/*     */   private final int gameId;
/*     */   private final long winRoleId;
/*     */   private final Set<Long> voteRoles;
/*     */   private final Map<Integer, Integer> raceid2Money;
/*     */   private final Map<Integer, String> raceObjNames;
/*     */   
/*     */   public GangRaceActionSession(long _gangid, int _gameid, long _time, int _winIndex, long _roleId, Set<Long> _voteRoles, Map<Integer, Integer> _raceid2Money, Map<Integer, String> _names)
/*     */   {
/*  38 */     super(_time, _gangid);
/*  39 */     this.winIndex = _winIndex;
/*  40 */     this.winRoleId = _roleId;
/*  41 */     this.voteRoles = _voteRoles;
/*  42 */     this.gameId = _gameid;
/*  43 */     this.raceid2Money = _raceid2Money;
/*  44 */     this.raceObjNames = _names;
/*     */   }
/*     */   
/*     */   protected void onTimeOut()
/*     */   {
/*  49 */     final long gangid = getOwerId();
/*     */     
/*  51 */     GangRaceManager.debugLog("--------帮派赛跑动画计时结束, 帮派id=" + gangid, new Object[0]);
/*     */     
/*     */ 
/*  54 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  58 */         int winAwardId = SGangRaceConsts.getInstance().winAwardId;
/*  59 */         int FailAwardId = SGangRaceConsts.getInstance().FailAwardId;
/*     */         
/*  61 */         TLogArg winLogArg = new TLogArg(LogReason.GANGRACE_AWARD_WIN);
/*  62 */         TLogArg failLogArg = new TLogArg(LogReason.GANGRACE_AWARD_FAIL);
/*  63 */         AwardReason reasonWin = new AwardReason(LogReason.GANGRACE_AWARD_WIN);
/*  64 */         AwardReason reasonFail = new AwardReason(LogReason.GANGRACE_AWARD_FAIL);
/*     */         
/*  66 */         SRaceAwardRes winRes = new SRaceAwardRes(1);
/*  67 */         SRaceAwardRes failRes = new SRaceAwardRes(0);
/*     */         
/*  69 */         Set<Long> votedWinnerRoleIds = new HashSet();
/*     */         
/*  71 */         lock(Role2gangraceinfo.getTable(), GangRaceActionSession.this.voteRoles);
/*  72 */         for (Iterator i$ = GangRaceActionSession.this.voteRoles.iterator(); i$.hasNext();) { roleid = ((Long)i$.next()).longValue();
/*  73 */           if (!mzm.gsp.idip.main.IdipManager.isZeroProfit(roleid))
/*     */           {
/*  75 */             GangRaceRoleInfo xGangRaceRoleInfoBean = GangRaceManager.getXGangRaceRoleInfo(roleid);
/*  76 */             if (xGangRaceRoleInfoBean.getGameid() != GangRaceActionSession.this.gameId) {
/*  77 */               GangRaceManager.errorLog("GangRaceActionSession.processImp@award gangrace gameid error|gangid=%d|gameid=%d|rolegameid=%d", new Object[] { Long.valueOf(gangid), Integer.valueOf(GangRaceActionSession.this.gameId), Integer.valueOf(xGangRaceRoleInfoBean.getGameid()) });
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*  82 */               userId = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  83 */               for (Map.Entry<Integer, Integer> entry : xGangRaceRoleInfoBean.getRaceid2money().entrySet()) {
/*  84 */                 int raceObjIdx = ((Integer)entry.getKey()).intValue();
/*  85 */                 String name = (String)GangRaceActionSession.this.raceObjNames.get(Integer.valueOf(raceObjIdx));
/*  86 */                 List<String> contextArg = new ArrayList();
/*  87 */                 contextArg.add(name != null ? name : "?");
/*  88 */                 if (raceObjIdx == GangRaceActionSession.this.winIndex)
/*     */                 {
/*  90 */                   GangRaceManager.logInfo("GangRaceActionSession.processImp@win|gangId=%d|roleId=%d|winIdx=%d|raceIdx=%d|name=%s", new Object[] { Long.valueOf(gangid), Long.valueOf(roleid), Integer.valueOf(GangRaceActionSession.this.winIndex), Integer.valueOf(raceObjIdx), name });
/*     */                   
/*  92 */                   int mailWin1 = SGangRaceConsts.getInstance().mailWin1;
/*  93 */                   int mailWin2 = SGangRaceConsts.getInstance().mailWin2;
/*  94 */                   int mailId = ((Integer)entry.getValue()).intValue() <= 1000 ? mailWin1 : mailWin2;
/*  95 */                   MailInterface.asynBuildAndSendMail(roleid, mailId, null, contextArg, winLogArg);
/*     */                   
/*  97 */                   AwardInterface.awardNoneRealTime(winAwardId, userId, roleid, false, true, reasonWin);
/*     */                   
/*  99 */                   GangRaceManager.tLog(roleid, 2, gangid, 0, mailId);
/*     */                   
/*     */ 
/* 102 */                   OnlineManager.getInstance().send(roleid, winRes);
/*     */                   
/*     */ 
/* 105 */                   votedWinnerRoleIds.add(Long.valueOf(roleid));
/*     */                 }
/*     */                 else {
/* 108 */                   GangRaceManager.logInfo("GangRaceActionSession.processImp@fail|gangId=%d|roleId=%d|winIdx=%d|raceIdx=%d|name=%s", new Object[] { Long.valueOf(gangid), Long.valueOf(roleid), Integer.valueOf(GangRaceActionSession.this.winIndex), Integer.valueOf(raceObjIdx), name });
/*     */                   
/* 110 */                   int mailFail1 = SGangRaceConsts.getInstance().mailFail1;
/* 111 */                   int mailFail2 = SGangRaceConsts.getInstance().mailFail2;
/* 112 */                   int mailId = ((Integer)entry.getValue()).intValue() <= 1000 ? mailFail1 : mailFail2;
/* 113 */                   MailInterface.asynBuildAndSendMail(roleid, mailId, null, contextArg, failLogArg);
/*     */                   
/* 115 */                   AwardInterface.awardNoneRealTime(FailAwardId, userId, roleid, true, true, reasonFail);
/*     */                   
/* 117 */                   GangRaceManager.tLog(roleid, 2, gangid, 0, mailId);
/*     */                   
/*     */ 
/* 120 */                   OnlineManager.getInstance().send(roleid, failRes);
/*     */                 }
/*     */               }
/*     */             } } }
/*     */         long roleid;
/*     */         String userId;
/* 126 */         GangRaceEndArg arg = new GangRaceEndArg(GangRaceActionSession.this.winRoleId, votedWinnerRoleIds);
/* 127 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gangrace.event.GangRaceEnd(), arg);
/*     */         
/* 129 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 133 */     });
/* 134 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 138 */         int oldMoney = ((Integer)GangRaceActionSession.this.raceid2Money.get(Integer.valueOf(GangRaceActionSession.this.winIndex))).intValue();
/* 139 */         long temp = oldMoney;
/* 140 */         temp = temp * SGangRaceConsts.getInstance().winnerGoldRate / 10000L;
/* 141 */         int winMoney = (int)temp;
/* 142 */         if (winMoney > SGangRaceConsts.getInstance().winnerMaxGold)
/* 143 */           winMoney = SGangRaceConsts.getInstance().winnerMaxGold;
/* 144 */         GangRaceManager.logInfo("GangRaceActionSession.processImp@winner|gangId=%d|roleId=%d|winIdx=%d|money=%d|winMoney=%d", new Object[] { Long.valueOf(gangid), Long.valueOf(GangRaceActionSession.this.winRoleId), Integer.valueOf(GangRaceActionSession.this.winIndex), Integer.valueOf(oldMoney), Integer.valueOf(winMoney) });
/*     */         
/*     */ 
/*     */ 
/* 148 */         if (GangRaceActionSession.this.winRoleId <= 0L)
/* 149 */           return false;
/* 150 */         int mailWinner = SGangRaceConsts.getInstance().mailWinner;
/* 151 */         List<String> contentArgs = new ArrayList();
/* 152 */         MailAttachment attachment = new MailAttachment();
/* 153 */         attachment.setGold(winMoney);
/* 154 */         contentArgs.add(String.valueOf(oldMoney));
/* 155 */         contentArgs.add(String.valueOf(winMoney));
/* 156 */         MailInterface.asynBuildAndSendMail(GangRaceActionSession.this.winRoleId, mailWinner, null, contentArgs, attachment, new TLogArg(LogReason.GANGRACE_AWARD_WINNER));
/*     */         
/* 158 */         GangRaceManager.tLog(GangRaceActionSession.this.winRoleId, 3, gangid, 0, winMoney);
/*     */         
/* 160 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\GangRaceActionSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */