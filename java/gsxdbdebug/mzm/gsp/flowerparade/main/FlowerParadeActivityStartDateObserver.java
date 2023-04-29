/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class FlowerParadeActivityStartDateObserver extends DateObserver
/*    */ {
/*    */   private final int activityId;
/*    */   private final int index;
/*    */   
/*    */   public FlowerParadeActivityStartDateObserver(int timeCommonCfgId, int activityId, int index)
/*    */   {
/* 15 */     super(timeCommonCfgId);
/* 16 */     this.activityId = activityId;
/* 17 */     this.index = index;
/*    */   }
/*    */   
/*    */   public int getIndex()
/*    */   {
/* 22 */     return this.index;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 28 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 35 */         if (!ActivityInterface.isActivityOpen(FlowerParadeActivityStartDateObserver.this.activityId))
/*    */         {
/* 37 */           return false;
/*    */         }
/* 39 */         if (!FlowerParadeManager.isOpen(0L))
/*    */         {
/* 41 */           return false;
/*    */         }
/* 43 */         FlowerParadeManager.startFlowerParade(FlowerParadeActivityStartDateObserver.this.activityId, FlowerParadeActivityStartDateObserver.this.index);
/* 44 */         return true;
/*    */       }
/*    */       
/* 47 */     });
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeActivityStartDateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */