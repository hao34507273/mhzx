/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.masswedding.SRandomLuckyBlesserErrorRes;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MassWeddingBless;
/*    */ import xtable.Role2lucksession;
/*    */ 
/*    */ public class PCRandomLuckyBlesserReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCRandomLuckyBlesserReq(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(this.roleid, 164)))
/*    */     {
/* 28 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, mzm.gsp.role.main.RoleInterface.getName(this.roleid), 164);
/*    */       
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (!ActivityInterface.isActivityOpen(SMassWeddingConsts.getInstance().activityid)) {
/* 34 */       GameServer.logger().info("[MassWedding]PCRandomLuckyBlesserReq.processImp@activity is close");
/* 35 */       return false;
/*    */     }
/* 37 */     long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid);
/* 38 */     lock(Role2lucksession.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(marryRoleid) }));
/* 39 */     Long ret = Role2lucksession.get(Long.valueOf(this.roleid));
/* 40 */     if (ret == null) {
/* 41 */       SRandomLuckyBlesserErrorRes rankBlesserErrorRes = new SRandomLuckyBlesserErrorRes();
/* 42 */       rankBlesserErrorRes.result = 2;
/* 43 */       OnlineManager.getInstance().sendAtOnce(this.roleid, rankBlesserErrorRes);
/* 44 */       return false;
/*    */     }
/* 46 */     Session session = Session.getSession(ret.longValue());
/* 47 */     if (session != null) {
/* 48 */       session.stopTimer();
/*    */     }
/*    */     
/* 51 */     xbean.MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 52 */     if (xMassWedding == null) {
/* 53 */       return false;
/*    */     }
/* 55 */     MassWeddingBless xMassWeddingBless = MassWeddingManager.getMassWeddingBless(true);
/* 56 */     if (xMassWeddingBless == null) {
/* 57 */       return false;
/*    */     }
/* 59 */     MassWeddingManager.randomBlesser(this.roleid, marryRoleid, xMassWedding, xMassWeddingBless);
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCRandomLuckyBlesserReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */