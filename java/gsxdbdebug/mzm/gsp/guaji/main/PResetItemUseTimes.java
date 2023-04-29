/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DoublePoint;
/*    */ import xtable.Role2doublepoint;
/*    */ 
/*    */ 
/*    */ class PResetItemUseTimes
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long curtime;
/*    */   
/*    */   public PResetItemUseTimes(long roleId, long curtime)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.curtime = curtime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(this.roleId));
/*    */     
/*    */ 
/* 27 */     if (xDoublePoint.getResetitemusetimestamp() >= this.curtime)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     xDoublePoint.setResetitemusetimestamp(this.curtime);
/* 33 */     int oldcount = xDoublePoint.getItemusecount();
/* 34 */     xDoublePoint.setItemusecount(0);
/*    */     
/* 36 */     String logstr = String.format("[guaji]PResetItemUseTimes.processImp@reset week use count success|roleid=%d|oldcount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(oldcount) });
/* 37 */     GuajiManager.logger.info(logstr);
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\PResetItemUseTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */