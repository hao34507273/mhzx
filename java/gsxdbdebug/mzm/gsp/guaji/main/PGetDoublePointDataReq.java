/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import mzm.gsp.guaji.SSyncDoublePoint;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DoublePoint;
/*    */ import xtable.Role2doublepoint;
/*    */ 
/*    */ public class PGetDoublePointDataReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PGetDoublePointDataReq(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(this.roleId));
/* 21 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/* 22 */     GuajiManager.fillDoublePointInfo(sSyncDoublePoint, xDoublePoint);
/* 23 */     OnlineManager.getInstance().send(this.roleId, sSyncDoublePoint);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\PGetDoublePointDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */