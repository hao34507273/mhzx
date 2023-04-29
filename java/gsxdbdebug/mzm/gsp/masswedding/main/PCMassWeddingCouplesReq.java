/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.masswedding.SMassWeddingCouplesRes;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MassWedding;
/*    */ import xbean.MassWeddingRankInfo;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ 
/*    */ public class PCMassWeddingCouplesReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCMassWeddingCouplesReq(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     if ((!OpenInterface.getOpenStatus(164)) || (OpenInterface.isBanPlay(this.roleid, 164)))
/*    */     {
/* 26 */       OpenInterface.sendBanPlayMsg(this.roleid, this.roleid, mzm.gsp.role.main.RoleInterface.getName(this.roleid), 164);
/*    */       
/* 28 */       return false;
/*    */     }
/* 30 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(false);
/* 31 */     if (xMassWedding == null) {
/* 32 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingCouplesReq.processImp@xMassWedding is null", new Object[0]));
/*    */       
/* 34 */       return false;
/*    */     }
/* 36 */     if (xMassWedding.getStage() < 1) {
/* 37 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingCouplesReq.processImp@not equiq or bigger than marry stage", new Object[0]));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     if (mzm.gsp.map.main.MapInterface.getRoleWorldInstanceId(this.roleid) != xMassWedding.getWorldid()) {
/* 46 */       GameServer.logger().info(String.format("[MassWedding]PCMassWeddingCouplesReq.processImp@not in massWedding world|world=%d", new Object[] { Long.valueOf(xMassWedding.getWorldid()) }));
/*    */       
/*    */ 
/* 49 */       return false;
/*    */     }
/* 51 */     MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(false);
/* 52 */     SMassWeddingCouplesRes massWeddingCouplesRes = new SMassWeddingCouplesRes();
/* 53 */     if (xMassWeddingRankInfos != null) {
/* 54 */       int coupleSize = xMassWeddingRankInfos.getMassweddingrankinfos().size();
/* 55 */       for (int i = 0; i < SMassWeddingConsts.getInstance().maxCouple; i++) {
/* 56 */         if (i >= coupleSize) {
/*    */           break;
/*    */         }
/* 59 */         mzm.gsp.masswedding.CoupleInfo coupleinfo = new mzm.gsp.masswedding.CoupleInfo();
/* 60 */         MassWeddingRankInfo xMassWeddingRankInfo = (MassWeddingRankInfo)xMassWeddingRankInfos.getMassweddingrankinfos().get(i);
/* 61 */         MassWeddingManager.fillCoupleInfo(coupleinfo, xMassWeddingRankInfo.getRoleida(), xMassWeddingRankInfo.getRoleidb());
/*    */         
/* 63 */         massWeddingCouplesRes.blesscouples.add(coupleinfo);
/*    */       }
/*    */     }
/* 66 */     OnlineManager.getInstance().send(this.roleid, massWeddingCouplesRes);
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCMassWeddingCouplesReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */