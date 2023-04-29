/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ArenaScore;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ class PMatchOneFight extends LogicProcedure
/*    */ {
/*    */   private MatchObj obj1;
/*    */   private MatchObj obj2;
/*    */   
/*    */   PMatchOneFight(MatchObj obj1, MatchObj obj2)
/*    */   {
/* 26 */     this.obj1 = obj1;
/* 27 */     this.obj2 = obj2;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 32 */     Set<Long> lockRoles = new HashSet();
/* 33 */     lockRoles.addAll(this.obj1.getRoleList());
/* 34 */     lockRoles.addAll(this.obj2.getRoleList());
/*    */     
/* 36 */     lock(Arenascore.getTable(), lockRoles);
/*    */     
/* 38 */     for (Iterator i$ = this.obj1.getRoleList().iterator(); i$.hasNext();) { r1 = ((Long)i$.next()).longValue();
/* 39 */       xScore1 = Arenascore.get(Long.valueOf(r1));
/* 40 */       if (xScore1 != null)
/*    */       {
/*    */ 
/* 43 */         for (i$ = this.obj2.getRoleList().iterator(); i$.hasNext();) { long r2 = ((Long)i$.next()).longValue();
/* 44 */           ArenaScore xScore2 = Arenascore.get(Long.valueOf(r2));
/* 45 */           if (xScore2 != null)
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/* 50 */             Integer times = (Integer)xScore1.getMatchroles().get(Long.valueOf(r2));
/* 51 */             if (times == null) {
/* 52 */               times = new Integer(1);
/*    */             }
/*    */             else {
/* 55 */               times = Integer.valueOf(times.intValue() + 1);
/*    */             }
/*    */             
/* 58 */             xScore1.getMatchroles().put(Long.valueOf(r2), times);
/* 59 */             xScore2.getMatchroles().put(Long.valueOf(r1), times); } } } }
/*    */     long r1;
/*    */     ArenaScore xScore1;
/*    */     Iterator i$;
/* 63 */     ArenaManager.logger.info("天下会武匹配战斗： " + this.obj1.getRoleList() + " vs " + this.obj2.getRoleList());
/* 64 */     FightContext context = new ArenaFightContext();
/* 65 */     FightInterface.startPVPFight(((Long)this.obj1.getRoleList().get(0)).longValue(), ((Long)this.obj2.getRoleList().get(0)).longValue(), context, 4, FightReason.ARENA_FIGHT);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 70 */     for (Iterator i$ = this.obj1.getRoleList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 71 */       ActivityInterface.logActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*    */     }
/* 73 */     for (Iterator i$ = this.obj2.getRoleList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 74 */       ActivityInterface.logActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*    */     }
/*    */     
/*    */ 
/* 78 */     for (Iterator i$ = this.obj1.getRoleList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 79 */       ActivityInterface.tlogActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*    */     }
/* 81 */     for (Iterator i$ = this.obj2.getRoleList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 82 */       ActivityInterface.tlogActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*    */     }
/*    */     
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PMatchOneFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */