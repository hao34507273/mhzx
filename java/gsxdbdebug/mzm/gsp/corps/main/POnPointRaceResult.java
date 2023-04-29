/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.event.PointRaceResultArg;
/*    */ import mzm.gsp.crossbattle.event.PointRaceResultProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnPointRaceResult
/*    */   extends PointRaceResultProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     long corpsId = ((PointRaceResultArg)this.arg).coprsid;
/* 23 */     String session = CrossBattleConsts.getInstance().cross_battle_session;
/* 24 */     if (((PointRaceResultArg)this.arg).promotion)
/*    */     {
/* 26 */       GameServer.logger().info(String.format("[corps]POnPointRaceResult.processImp@ promotion! no need add history!|session=%s|corpsId=%d|rank=%d", new Object[] { session, Long.valueOf(corpsId), Integer.valueOf(((PointRaceResultArg)this.arg).rank) }));
/*    */       
/*    */ 
/*    */ 
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     List<String> params = new ArrayList();
/* 34 */     params.add(session);
/*    */     
/* 36 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/* 37 */     if (xCorps == null)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[corps]POnPointRaceResult.processImp@ no corps!|session=%s|corpsId=%d|rank=%d", new Object[] { session, Long.valueOf(corpsId), Integer.valueOf(((PointRaceResultArg)this.arg).rank) }));
/*    */       
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     CorpsManager.addCorpsHistory(xCorps, 7, params);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnPointRaceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */