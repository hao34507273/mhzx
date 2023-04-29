/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShengXiaoMonsterReliveObserver
/*    */   extends DateObserver
/*    */ {
/*    */   private int controllerId;
/* 17 */   private static final Logger logger = Logger.getLogger(ShengXiaoMonsterReliveObserver.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ShengXiaoMonsterReliveObserver(int timeCommonCfgid, int controllerId)
/*    */   {
/* 24 */     super(timeCommonCfgid);
/* 25 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 30 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 34 */         if (ShengXiaoMonsterReliveObserver.logger.isDebugEnabled()) {
/* 35 */           ShengXiaoMonsterReliveObserver.logger.debug("怪物复活");
/*    */         }
/* 37 */         ControllerInterface.triggerOrReSpawn(MapInterface.getCenterWorldid(), ShengXiaoMonsterReliveObserver.this.controllerId, 1);
/*    */       }
/* 39 */     });
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\ShengXiaoMonsterReliveObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */