/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Arena;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ class PCheckEnd
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     Arena xArena = ArenaManager.getXArena(false);
/* 26 */     if (xArena == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (xArena.getFinished()) {
/* 31 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 35 */     int stage = ActivityInterface.getActivityStage(SArenaConsts.getInstance().Activityid);
/* 36 */     if (stage <= 1) {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmp(false);
/* 42 */     if (xArenaTmp.getWorld() < 0L) {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     List<Long> roles = MapInterface.getRoleList(xArenaTmp.getWorld());
/* 47 */     int lastCamp = -1;
/* 48 */     boolean hasDifferentCamp = false;
/* 49 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/* 51 */       ArenaScore xArenaScore = Arenascore.select(Long.valueOf(r));
/* 52 */       if (xArenaScore.getScore() > 0)
/*    */       {
/*    */ 
/* 55 */         if (lastCamp < 0) {
/* 56 */           lastCamp = xArenaScore.getCamp();
/*    */ 
/*    */         }
/* 59 */         else if (xArenaScore.getCamp() != lastCamp) {
/* 60 */           hasDifferentCamp = true;
/* 61 */           break;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 66 */     if (hasDifferentCamp) {
/* 67 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 71 */     NoneRealTimeTaskManager.getInstance().addTask(new PResult());
/*    */     List<String> contentArgs;
/*    */     Iterator i$;
/* 74 */     if ((lastCamp >= 0) && (!roles.isEmpty())) {
/* 75 */       String campName = ArenaConfigManager.getInstance().getCampName(lastCamp);
/* 76 */       if (campName != null) {
/* 77 */         contentArgs = new ArrayList();
/* 78 */         contentArgs.add(campName);
/* 79 */         contentArgs.add(campName);
/*    */         
/* 81 */         for (i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */           
/* 83 */           MailInterface.asynBuildAndSendMail(r, SArenaConsts.getInstance().EarlyEndMail, null, contentArgs, new TLogArg(LogReason.ARENA_EARLY_END));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PCheckEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */