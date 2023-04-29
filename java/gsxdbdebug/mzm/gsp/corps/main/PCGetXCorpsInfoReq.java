/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.SGetXCorpsInfoRep;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetXCorpsInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long corpsId;
/*    */   
/*    */   public PCGetXCorpsInfoReq(long roleId, long corpsId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.corpsId = corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(this.corpsId));
/* 30 */     if (xCorps == null)
/*    */     {
/* 32 */       GameServer.logger().error(String.format("[corps]PCGetXCorpsInfoReq.processImp@ not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.corpsId) }));
/*    */       
/*    */ 
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     SGetXCorpsInfoRep p = new SGetXCorpsInfoRep();
/* 39 */     CorpsManager.fillCorpsInfo(xCorps, p.corpsinfo);
/* 40 */     OnlineManager.getInstance().send(this.roleId, p);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCGetXCorpsInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */