/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class ParadePrepareSession
/*    */   extends Session
/*    */ {
/* 15 */   private final List<Location> locations = new ArrayList();
/*    */   private static volatile long curSessionid;
/*    */   
/*    */   public ParadePrepareSession(long interval, long groupid, List<Location> locations)
/*    */   {
/* 20 */     super(interval, groupid);
/* 21 */     this.locations.addAll(locations);
/* 22 */     curSessionid = getSessionId();
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 31 */         if (ParadePrepareSession.this.needToStop()) {
/* 32 */           return true;
/*    */         }
/* 34 */         ParadePrepareSession.this.excute();
/* 35 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   void excute() {
/* 41 */     MapInterface.groupMove(MapGroupType.MGT_MARRIAGE, getOwerId(), this.locations);
/*    */   }
/*    */   
/*    */   static void stopParadePrepareSession() {
/* 45 */     Session session = Session.getSession(curSessionid);
/* 46 */     if ((session != null) && ((session instanceof ParadePrepareSession))) {
/* 47 */       session.stopTimer();
/* 48 */       ParadePrepareSession paradePrepareSession = (ParadePrepareSession)session;
/* 49 */       paradePrepareSession.excute();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\ParadePrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */