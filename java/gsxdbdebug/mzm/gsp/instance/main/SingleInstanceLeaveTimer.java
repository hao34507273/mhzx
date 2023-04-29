/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ class SingleInstanceLeaveTimer extends Session
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public SingleInstanceLeaveTimer(long interval, long instanceUuid, long roleid)
/*    */   {
/* 11 */     super(interval, instanceUuid);
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 17 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 22 */         Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(SingleInstanceLeaveTimer.this.roleid));
/* 23 */         if ((instanceUuid == null) || (instanceUuid.longValue() != SingleInstanceLeaveTimer.this.getOwerId())) {
/* 24 */           return false;
/*    */         }
/*    */         
/* 27 */         xbean.InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(SingleInstanceLeaveTimer.this.roleid));
/*    */         
/* 29 */         xbean.InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 30 */         return SingleInstance.onleaveInstance(SingleInstanceLeaveTimer.this.roleid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstanceLeaveTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */