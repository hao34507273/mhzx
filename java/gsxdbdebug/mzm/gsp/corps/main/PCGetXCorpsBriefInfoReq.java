/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.SGetXCorpsBriefInfoRep;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetXCorpsBriefInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long corpsId;
/*    */   
/*    */   public PCGetXCorpsBriefInfoReq(long roleId, long corpsId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.corpsId = corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(this.corpsId));
/* 31 */     if (xCorps == null)
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[corps]PCGetXCorpsInfoReq.processImp@ not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.corpsId) }));
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     SGetXCorpsBriefInfoRep p = new SGetXCorpsBriefInfoRep();
/* 40 */     CorpsManager.fillCorpsBriefInfo(xCorps, p.corpsbriefinfo);
/* 41 */     OnlineManager.getInstance().send(this.roleId, p);
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCGetXCorpsBriefInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */