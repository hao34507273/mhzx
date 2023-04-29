/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.arena.confbean.SWinTimesAward;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ArenaScore;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Arenascore;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PWinTimesAwardReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int index;
/*    */   
/*    */   public PWinTimesAwardReq(long roleid, int index)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.index = index;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     String userid = RoleInterface.getUserId(this.roleid);
/* 31 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 33 */     ArenaScore xScore = Arenascore.get(Long.valueOf(this.roleid));
/* 34 */     if (xScore == null) {
/* 35 */       ArenaManager.logError("PWinTimesAwardReq.processImp@xscore null|roleid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.index) });
/*    */       
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     if (xScore.getGet_awards().contains(Integer.valueOf(this.index))) {
/* 42 */       ArenaManager.logError("PWinTimesAwardReq.processImp@already get award|roleid=%d|index=%d|win_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.index), Integer.valueOf(xScore.getWin_times()) });
/*    */       
/*    */ 
/* 45 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 49 */     if ((this.index < 0) || (this.index > SArenaConsts.getInstance().WinTimesAwardList.size())) {
/* 50 */       ArenaManager.logError("PWinTimesAwardReq.processImp@invalid index|roleid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.index) });
/*    */       
/* 52 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 56 */     SWinTimesAward cfg = (SWinTimesAward)SArenaConsts.getInstance().WinTimesAwardList.get(this.index);
/* 57 */     if (xScore.getWin_times() < cfg.winTimes) {
/* 58 */       ArenaManager.logError("PWinTimesAwardReq.processImp@win times not enough|roleid=%d|index=%d|win_times=%d|need_win_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.index), Integer.valueOf(xScore.getWin_times()), Integer.valueOf(cfg.winTimes) });
/*    */       
/*    */ 
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     AwardInterface.award(cfg.award, userid, this.roleid, false, true, new mzm.gsp.award.main.AwardReason(LogReason.ARENA_WIN_TIMES_AWARD, cfg.winTimes));
/*    */     
/*    */ 
/* 67 */     xScore.getGet_awards().add(Integer.valueOf(this.index));
/*    */     
/* 69 */     ArenaManager.syncGetWinTimesAward(this.roleid, xScore);
/*    */     
/* 71 */     ArenaManager.logInfo("WinTimesAwardReq.processImp@get award|roleid=%d|index=%d|win_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.index), Integer.valueOf(xScore.getWin_times()) });
/*    */     
/*    */ 
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PWinTimesAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */