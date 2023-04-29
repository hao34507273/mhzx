/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MonsterReliveObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private int controllerId;
/* 15 */   private static final Logger logger = Logger.getLogger(MonsterReliveObserver.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public MonsterReliveObserver(long intervalMilliSeconds, int controllerId)
/*    */   {
/* 22 */     super(intervalMilliSeconds);
/* 23 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 28 */     if (logger.isDebugEnabled()) {
/* 29 */       logger.debug("怪物复活");
/*    */     }
/* 31 */     ControllerInterface.triggerOrReSpawn(MapInterface.getCenterWorldid(), this.controllerId, 1);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\MonsterReliveObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */