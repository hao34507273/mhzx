/*    */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.concurrent.locks.ReentrantLock;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhuXianJianZhenVisibleMonsterFightHandlerManager
/*    */ {
/* 18 */   private static ZhuXianJianZhenVisibleMonsterFightHandlerManager instance = new ZhuXianJianZhenVisibleMonsterFightHandlerManager();
/*    */   
/*    */   static ZhuXianJianZhenVisibleMonsterFightHandlerManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/* 25 */   private ReentrantLock lock = new ReentrantLock();
/* 26 */   private HashMap<Long, ZhuXianJianZhenVisibleMonsterFightHandler> handlers = new HashMap();
/*    */   
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
/* 39 */       ZhuXianJianZhenVisibleMonsterFightHandler oldHandler = (ZhuXianJianZhenVisibleMonsterFightHandler)this.handlers.remove(Long.valueOf(worldid));
/* 40 */       if (oldHandler != null)
/*    */       {
/* 42 */         MapInterface.unregisterMonsterFightHandler(worldid, oldHandler);
/*    */       }
/* 44 */       SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 45 */       ZhuXianJianZhenVisibleMonsterFightHandler newHandler = new ZhuXianJianZhenVisibleMonsterFightHandler(FightReason.ZHU_XIAN_JIAN_ZHEN_PVE, cfg.moduleid, activityCfgid);
/*    */       
/*    */ 
/*    */ 
/* 49 */       newHandler.addGroupId(cfg.monster_group_id);
/* 50 */       MapInterface.registerMonsterFightHandler(worldid, newHandler);
/* 51 */       this.handlers.put(Long.valueOf(worldid), newHandler);
/*    */     }
/*    */     finally
/*    */     {
/* 55 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void unregisterHandler(long worldid)
/*    */   {
/* 66 */     this.lock.lock();
/*    */     try
/*    */     {
/* 69 */       ZhuXianJianZhenVisibleMonsterFightHandler oldHandler = (ZhuXianJianZhenVisibleMonsterFightHandler)this.handlers.remove(Long.valueOf(worldid));
/* 70 */       if (oldHandler != null)
/*    */       {
/* 72 */         MapInterface.unregisterMonsterFightHandler(worldid, oldHandler);
/*    */       }
/*    */     }
/*    */     finally
/*    */     {
/* 77 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\ZhuXianJianZhenVisibleMonsterFightHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */