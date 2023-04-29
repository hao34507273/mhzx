/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.BoxAwardBean;
/*    */ import xtable.Boxaward;
/*    */ 
/*    */ public class BoxAwardTimer extends Session
/*    */ {
/*    */   public final int awardIndex;
/*    */   
/*    */   public BoxAwardTimer(long interval, long awardUuid, int awardIndex)
/*    */   {
/* 13 */     super(interval, awardUuid);
/* 14 */     this.awardIndex = awardIndex;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 22 */         long awardUuid = BoxAwardTimer.this.getOwerId();
/*    */         
/* 24 */         BoxAwardBean xTempAwardBean = Boxaward.select(Long.valueOf(awardUuid));
/* 25 */         if (xTempAwardBean == null) {
/* 26 */           return false;
/*    */         }
/*    */         
/* 29 */         long awardRoleid = BoxAwardManager.getInstance().getAwardRoleid(xTempAwardBean);
/*    */         
/*    */ 
/* 32 */         lock(xtable.Role2properties.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(awardRoleid) }));
/*    */         
/* 34 */         BoxAwardBean xTrueAwardBean = Boxaward.get(Long.valueOf(awardUuid));
/* 35 */         xbean.BoxAwardContext xBoxAwardContext = xtable.Boxawardcontext.get(Long.valueOf(awardUuid));
/* 36 */         return BoxAwardManager.getInstance().award(awardRoleid, awardUuid, xTrueAwardBean, xBoxAwardContext, BoxAwardTimer.this.awardIndex);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\BoxAwardTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */