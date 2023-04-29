/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.SSyncGangRobberBornEvent;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGangRobberActivityStage extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   private final int number;
/*    */   private final Map<Integer, Integer> controllerid2Count;
/*    */   
/*    */   public PGangRobberActivityStage(long gangId, int number, Map<Integer, Integer> controllerid2Count)
/*    */   {
/* 17 */     this.gangId = gangId;
/* 18 */     this.number = number;
/* 19 */     this.controllerid2Count = controllerid2Count;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     long worldId = GangInterface.getGangWorldId(this.gangId);
/* 26 */     if (worldId < 0L) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (this.controllerid2Count.size() <= 0) {
/* 31 */       return false;
/*    */     }
/* 33 */     for (Map.Entry<Integer, Integer> controller2NumEntry : this.controllerid2Count.entrySet()) {
/* 34 */       mzm.gsp.map.main.ControllerInterface.triggerWorldControllerWithMaxSpawnNum(worldId, ((Integer)controller2NumEntry.getKey()).intValue(), ((Integer)controller2NumEntry.getValue()).intValue());
/*    */     }
/*    */     
/* 37 */     SSyncGangRobberBornEvent event = new SSyncGangRobberBornEvent();
/* 38 */     event.robberno = this.number;
/* 39 */     GangInterface.brocastInGang(event, this.gangId);
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\PGangRobberActivityStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */