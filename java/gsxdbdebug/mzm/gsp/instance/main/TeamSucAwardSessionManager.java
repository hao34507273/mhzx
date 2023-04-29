/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xdb.Procedure;
/*    */ import xtable.Instance;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TeamSucAwardSessionManager
/*    */ {
/* 16 */   private static TeamSucAwardSessionManager instance = new TeamSucAwardSessionManager();
/*    */   
/*    */   private static final int SECOND = 25;
/*    */   
/*    */   static TeamSucAwardSessionManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void addSession(long instanceUuid)
/*    */   {
/* 31 */     new TeamSucAwardSession(25L, instanceUuid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void stopSession(long instanceUuid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static class TeamSucAwardSession
/*    */     extends Session
/*    */   {
/*    */     public TeamSucAwardSession(long interval, long instanceUUid)
/*    */     {
/* 47 */       super(instanceUUid);
/*    */     }
/*    */     
/*    */     protected void onTimeOut()
/*    */     {
/* 52 */       final long instanceUuid = getOwerId();
/* 53 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 57 */           InstanceCacheBean xInstanceCacheBean = Instance.get(Long.valueOf(instanceUuid));
/* 58 */           if (xInstanceCacheBean == null) {
/* 59 */             return false;
/*    */           }
/* 61 */           int awardKey = InstanceExtra.TEAM_INSTANCE_AWARD_STATUS.ordinal();
/* 62 */           if (xInstanceCacheBean.getExtra().containsKey(Integer.valueOf(awardKey))) {
/* 63 */             int awardStatus = ((Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(awardKey))).intValue();
/* 64 */             if (awardStatus < 2) {
/* 65 */               xInstanceCacheBean.getExtra().put(Integer.valueOf(awardKey), Integer.valueOf(2));
/* 66 */               TeamInstance.awardAllSucReward(instanceUuid, xInstanceCacheBean.getInstancecfgid(), new ArrayList(xInstanceCacheBean.getSucroleids()));
/*    */             }
/*    */           }
/*    */           
/* 70 */           return true;
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamSucAwardSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */