/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import xbean.MassWedding;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ 
/*    */ public class PCLeaveMassWedding extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCLeaveMassWedding(long roldid)
/*    */   {
/* 15 */     this.roleid = roldid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     MassWedding xMassWedding = MassWeddingManager.getMassWedding(false);
/* 22 */     if (xMassWedding == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     long woridid = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 26 */     if (woridid != xMassWedding.getWorldid()) {
/* 27 */       GameServer.logger().info(String.format("[MassWedding]PCLeaveMassWedding.processImp@not in same world|nowWorld=%d|weddingWorld=%d|roleid=%d", new Object[] { Long.valueOf(woridid), Long.valueOf(xMassWedding.getWorldid()), Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     long marryRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid);
/*    */     
/* 39 */     if ((xMassWedding.getStage() == 1) && 
/* 40 */       (marryRoleid != -1L))
/*    */     {
/* 42 */       MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(true);
/* 43 */       if (xMassWeddingRankInfos != null) {
/* 44 */         Integer rank = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(marryRoleid));
/* 45 */         if (rank == null) {
/* 46 */           rank = (Integer)xMassWeddingRankInfos.getRoleid2index().get(Long.valueOf(this.roleid));
/*    */         }
/* 48 */         if ((rank != null) && 
/* 49 */           (!xMassWeddingRankInfos.getNotbackcoinsroleids().contains(Long.valueOf(this.roleid)))) {
/* 50 */           GameServer.logger().info(String.format("[MassWedding]PCLeaveMassWedding.processImp@not finish massMarry|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 57 */           return false;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 65 */     MapInterface.transferToScene(this.roleid, MapInterface.getBigWorldid(), mzm.gsp.masswedding.confbean.SMassWeddingConsts.getInstance().outMapid);
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCLeaveMassWedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */