/*     */ package mzm.gsp.gangrace.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.SGangRaceConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gangrace.SVoteSuccess;
/*     */ import mzm.gsp.gangrace.main.game.RaceGame;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.GangRaceGameInfo;
/*     */ import xbean.GangRaceRoleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PVoteReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int playeridx;
/*     */   private final int votecount;
/*     */   
/*     */   public PVoteReq(long roleid, int playeridx, int votecount)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.playeridx = playeridx;
/*  30 */     this.votecount = votecount;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if ((!OpenInterface.getOpenStatus(99)) || (OpenInterface.isBanPlay(this.roleid, 99)))
/*     */     {
/*  37 */       OpenInterface.sendBanPlayMsg(this.roleid, 99);
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (GangRaceManager.getInstance().getGameStage() != 0)
/*     */     {
/*  43 */       GangRaceManager.sendErrorInfo(this.roleid, 0);
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     if (!GangRaceManager.isRoleStateCanJoinGangRaceActivity(this.roleid))
/*     */     {
/*  50 */       GangRaceManager.logInfo("PRaceStatusReq.processImp@role state can not join gangrace activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     final String userid = RoleInterface.getUserId(this.roleid);
/*  55 */     long gangid = mzm.gsp.gang.main.GangInterface.getGangId(this.roleid);
/*     */     
/*  57 */     if (gangid <= 0L) {
/*  58 */       GangRaceManager.sendErrorInfo(this.roleid, 1);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  65 */     lock(Lockeys.get(xtable.Role2gangraceinfo.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  67 */     lock(Lockeys.get(xtable.Gangrace2gameinfo.getTable(), Long.valueOf(gangid)));
/*     */     
/*  69 */     if ((this.votecount != 1) && (this.votecount != 10)) {
/*  70 */       GangRaceManager.sendErrorInfo(this.roleid, 5);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     GangRaceRoleInfo xGangRaceRoleInfoBean = GangRaceManager.getXGangRaceRoleInfo(this.roleid);
/*     */     
/*  77 */     GangRaceGameInfo xGangRaceGameInfoBean = GangRaceManager.getXGangRaceGameInfo(gangid);
/*     */     
/*  79 */     RaceGame game = GangRaceManager.getInstance().getGame(gangid);
/*  80 */     if (game == null) {
/*  81 */       GangRaceManager.sendErrorInfo(this.roleid, 0);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     GangRaceManager.resetRoleGangRaceGameInfo(game, xGangRaceRoleInfoBean, xGangRaceGameInfoBean);
/*     */     
/*  87 */     if (xGangRaceRoleInfoBean.getRaceid2money().size() > 0) {
/*  88 */       GangRaceManager.sendErrorInfo(this.roleid, 7);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (!xGangRaceGameInfoBean.getCurgameroleids().add(Long.valueOf(this.roleid))) {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     xGangRaceGameInfoBean.getAllroleids().add(Long.valueOf(this.roleid));
/*     */     
/*  98 */     if ((this.playeridx < 1) || (this.playeridx > game.getRaceObjCount())) {
/*  99 */       GangRaceManager.sendErrorInfo(this.roleid, 3);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, SGangRaceConsts.getInstance().activity);
/*     */     
/* 105 */     if (!activityJoinResult.isCanJoin()) {
/* 106 */       GangRaceManager.sendErrorInfo(this.roleid, 8);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     int money = GangRaceManager.MONEY_FOR_VOTE * this.votecount;
/* 112 */     if (!RoleInterface.cutGold(this.roleid, money, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.GANGRACE_VOTE)))
/*     */     {
/*     */ 
/* 115 */       GangRaceManager.sendErrorInfo(this.roleid, 6);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     int allMoney = ((Integer)xGangRaceGameInfoBean.getRaceid2money().get(Integer.valueOf(this.playeridx))).intValue();
/* 120 */     xGangRaceRoleInfoBean.getRaceid2money().put(Integer.valueOf(this.playeridx), Integer.valueOf(money));
/* 121 */     xGangRaceGameInfoBean.getRaceid2money().put(Integer.valueOf(this.playeridx), Integer.valueOf(allMoney + money));
/*     */     
/* 123 */     SVoteSuccess res = new SVoteSuccess();
/* 124 */     res.idx2votemoney.putAll(xGangRaceGameInfoBean.getRaceid2money());
/* 125 */     res.myvoteinfo.put(Integer.valueOf(this.playeridx), Integer.valueOf(money));
/* 126 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 128 */     int beginTime = GangRaceManager.getInstance().getGameStageTime();
/* 129 */     int curRound = GangRaceManager.getInstance().getCurGameRound();
/* 130 */     int maxRound = GangRaceManager.getInstance().getMaxGameRound();
/* 131 */     OnlineManager.getInstance().send(this.roleid, new mzm.gsp.gangrace.SRaceStatusRes(1, beginTime, curRound, maxRound));
/*     */     
/* 133 */     GangRaceManager.logInfo("PVoteReq.processImp@voteInfo|gangid=%d|gameid=%d|roleId=%d|voteIdex=%d", new Object[] { Long.valueOf(gangid), Integer.valueOf(game.getGameId()), Long.valueOf(this.roleid), Integer.valueOf(this.playeridx) });
/*     */     
/*     */ 
/* 136 */     GangRaceManager.tLog(this.roleid, 1, gangid, this.playeridx, money);
/*     */     
/*     */ 
/* 139 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 143 */         Lockeys.lock(Lockeys.get(User.getTable(), userid));
/* 144 */         ActivityInterface.addActivityCount(userid, PVoteReq.this.roleid, SGangRaceConsts.getInstance().activity);
/* 145 */         return true;
/*     */       }
/*     */       
/* 148 */     });
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\PVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */