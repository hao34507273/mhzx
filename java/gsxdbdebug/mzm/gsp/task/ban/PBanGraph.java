/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BanGraphBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBanGraph
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int graphId;
/*    */   private final int banType;
/*    */   private final BanTaskRes res;
/*    */   
/*    */   public PBanGraph(int graphId, int banType)
/*    */   {
/* 21 */     this.graphId = graphId;
/* 22 */     this.banType = banType;
/* 23 */     this.res = new BanTaskRes();
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     GraphBanManager.banGraphInCache(this.graphId, this.banType, this.res);
/* 31 */     if (!this.res.isSuc())
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     BanGraphBean xBanGraphBean = GraphBanManager.getBanGraphBeanIfAbsent(this.banType);
/* 37 */     xBanGraphBean.getGraphids().add(Integer.valueOf(this.graphId));
/* 38 */     GraphBanManager.synAllBanGraphsToAll();
/* 39 */     GameServer.logger().info(String.format("add ban graphId|graphId=%d|banType=%d", new Object[] { Integer.valueOf(this.graphId), Integer.valueOf(this.banType) }));
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   BanTaskRes getRes()
/*    */   {
/* 50 */     return this.res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\PBanGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */