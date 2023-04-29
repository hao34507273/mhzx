/*    */ package mzm.gsp.moneytree.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.moneytree.confbean.MoneyTreeConsts;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnOpenChange extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (!MoneyTreeManager.postInitFlag)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 20 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 21 */     if (type != 232)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     if (isOpen)
/*    */     {
/* 27 */       if (!ActivityInterface.isActivityOpen(MoneyTreeConsts.getInstance().ACTIVITY_CFG_ID))
/*    */       {
/* 29 */         return false;
/*    */       }
/* 31 */       ControllerInterface.triggerOrReSpawn(MapInterface.getBigWorldid(), MoneyTreeConsts.getInstance().NPC_CONTROLLER_ID);
/*    */       
/* 33 */       StringBuilder sb = new StringBuilder();
/* 34 */       sb.append(String.format("[moneytree]POnOpenChange.processImp@money tree activity start", new Object[0]));
/* 35 */       MoneyTreeManager.logger.info(sb.toString());
/*    */     }
/*    */     else
/*    */     {
/* 39 */       if (!ActivityInterface.isActivityOpen(MoneyTreeConsts.getInstance().ACTIVITY_CFG_ID))
/*    */       {
/* 41 */         return false;
/*    */       }
/* 43 */       ControllerInterface.collectController(MoneyTreeConsts.getInstance().NPC_CONTROLLER_ID);
/*    */       
/* 45 */       StringBuilder sb = new StringBuilder();
/* 46 */       sb.append(String.format("[moneytree]POnOpenChange.processImp@money tree activity end", new Object[0]));
/* 47 */       MoneyTreeManager.logger.info(sb.toString());
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\moneytree\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */