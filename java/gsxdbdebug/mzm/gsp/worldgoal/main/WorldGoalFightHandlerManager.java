/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.visiblemonsterfight.main.VisibleMonsterFightHandler;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalFightHandlerManager
/*    */ {
/* 19 */   private static WorldGoalFightHandlerManager instance = new WorldGoalFightHandlerManager();
/*    */   
/*    */   static WorldGoalFightHandlerManager getInstance()
/*    */   {
/* 23 */     return instance;
/*    */   }
/*    */   
/* 26 */   private ReentrantLock lock = new ReentrantLock();
/* 27 */   private HashMap<Integer, VisibleMonsterFightHandler> handlers = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void registerHandler(long worldid, int activityCfgid)
/*    */   {
/* 36 */     this.lock.lock();
/*    */     try
/*    */     {
/* 39 */       VisibleMonsterFightHandler oldHandler = (VisibleMonsterFightHandler)this.handlers.remove(Integer.valueOf(activityCfgid));
/* 40 */       if (oldHandler != null)
/*    */       {
/* 42 */         MapInterface.unregisterMonsterFightHandler(worldid, oldHandler);
/*    */       }
/* 44 */       SWorldGoalCfg cfg = SWorldGoalCfg.get(activityCfgid);
/* 45 */       if (cfg.monster_group_id > 0)
/*    */       {
/* 47 */         VisibleMonsterFightHandler newHandler = new VisibleMonsterFightHandler(FightReason.WORLD_GOAL_PVE, 168, activityCfgid);
/*    */         
/*    */ 
/*    */ 
/* 51 */         newHandler.addGroupId(cfg.monster_group_id);
/* 52 */         MapInterface.registerMonsterFightHandler(worldid, newHandler);
/* 53 */         this.handlers.put(Integer.valueOf(activityCfgid), newHandler);
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 58 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void unregisterHandler(long worldid, int activityCfgid)
/*    */   {
/* 69 */     this.lock.lock();
/*    */     try
/*    */     {
/* 72 */       VisibleMonsterFightHandler oldHandler = (VisibleMonsterFightHandler)this.handlers.remove(Integer.valueOf(activityCfgid));
/* 73 */       if (oldHandler != null)
/*    */       {
/* 75 */         MapInterface.unregisterMonsterFightHandler(worldid, oldHandler);
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 80 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalFightHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */