/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.auction.confbean.SAuctionActivityCfg;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnOpenChange extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (((OpenChangeComplexArg)this.arg).getType() != 534)
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     Set<Integer> activityIdSet = SAuctionActivityCfg.getAll().keySet();
/* 19 */     if ((activityIdSet == null) || (activityIdSet.isEmpty()))
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     for (Iterator i$ = activityIdSet.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */       
/* 25 */       if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */       {
/* 27 */         AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityId), new POnSwitchOpen(activityId));
/*    */       }
/*    */       else
/*    */       {
/* 31 */         AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityId), new POnSwitchClose(activityId));
/*    */       }
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */