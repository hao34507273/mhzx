/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.MassWeddingBless;
/*    */ import xtable.Role2lucksession;
/*    */ 
/*    */ public class LuckOneSession extends Session
/*    */ {
/*    */   public LuckOneSession(long interval, long roleId)
/*    */   {
/* 14 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 24 */         long roleid = LuckOneSession.this.getOwerId();
/* 25 */         long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(roleid);
/* 26 */         lock(Role2lucksession.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(marryRoleid) }));
/* 27 */         Long ret = Role2lucksession.get(Long.valueOf(LuckOneSession.this.getOwerId()));
/* 28 */         if (ret == null) {
/* 29 */           return false;
/*    */         }
/* 31 */         if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(roleid, 164)))
/*    */         {
/* 33 */           OpenInterface.sendBanPlayMsg(roleid, 164);
/* 34 */           return false;
/*    */         }
/*    */         
/* 37 */         xbean.MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 38 */         if (xMassWedding == null) {
/* 39 */           return false;
/*    */         }
/* 41 */         MassWeddingBless xMassWeddingBless = MassWeddingManager.getMassWeddingBless(true);
/* 42 */         if (xMassWeddingBless == null) {
/* 43 */           return false;
/*    */         }
/* 45 */         MassWeddingManager.randomBlesser(roleid, marryRoleid, xMassWedding, xMassWeddingBless);
/* 46 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\LuckOneSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */