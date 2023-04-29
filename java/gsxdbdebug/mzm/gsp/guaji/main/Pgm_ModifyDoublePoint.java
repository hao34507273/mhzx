/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import mzm.gsp.guaji.SSyncDoublePoint;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.DoublePoint;
/*    */ 
/*    */ public class Pgm_ModifyDoublePoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int forzennum;
/*    */   private final int poolnum;
/*    */   
/*    */   public Pgm_ModifyDoublePoint(long roleid, int frozenum, int poolnum)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.forzennum = frozenum;
/* 17 */     this.poolnum = poolnum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     DoublePoint xDoublePoint = xtable.Role2doublepoint.get(Long.valueOf(this.roleid));
/* 23 */     if (xDoublePoint == null) {
/* 24 */       xDoublePoint = xbean.Pod.newDoublePoint();
/* 25 */       xtable.Role2doublepoint.insert(Long.valueOf(this.roleid), xDoublePoint);
/*    */     }
/* 27 */     xDoublePoint.setFrozenpoolpointnum(this.forzennum);
/* 28 */     xDoublePoint.setGettingpoolpointnum(this.poolnum);
/* 29 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/* 30 */     GuajiManager.fillDoublePointInfo(sSyncDoublePoint, xDoublePoint);
/* 31 */     OnlineManager.getInstance().send(this.roleid, sSyncDoublePoint);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\Pgm_ModifyDoublePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */