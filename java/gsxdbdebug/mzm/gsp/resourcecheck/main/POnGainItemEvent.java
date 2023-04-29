/*    */ package mzm.gsp.resourcecheck.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.event.GainItemeArg;
/*    */ 
/*    */ public class POnGainItemEvent extends mzm.gsp.item.event.GainItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     Map<Integer, Integer> itemId2Num = ((GainItemeArg)this.arg).itemOperateResult.getItemChangeMap();
/*    */     
/* 13 */     for (Iterator i$ = itemId2Num.keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*    */       
/* 15 */       ResourceChecker.addItemNumAndTriggerWarn(((GainItemeArg)this.arg).roleId, ((GainItemeArg)this.arg).logArg.logReason, itemId, ((Integer)itemId2Num.get(Integer.valueOf(itemId))).intValue());
/*    */     }
/*    */     
/*    */ 
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\resourcecheck\main\POnGainItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */