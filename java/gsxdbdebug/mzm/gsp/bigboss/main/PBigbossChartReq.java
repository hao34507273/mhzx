/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PBigbossChartReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int startpos;
/*    */   private final int num;
/*    */   private final int ocp;
/*    */   
/*    */   public PBigbossChartReq(long roleid, int startpos, int num, int ocp)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.startpos = startpos;
/* 17 */     this.num = num;
/* 18 */     this.ocp = ocp;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!BigbossManager.isBigBossSwitchOpenForRole(this.roleid))
/*    */     {
/* 26 */       String logstr = String.format("[bigboss]PBigbossChartReq.processImp@Bigboss switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 27 */       BigbossManager.logger.info(logstr);
/* 28 */       return false;
/*    */     }
/* 30 */     BigbossManager.synRankDatas(this.ocp, this.roleid, this.startpos, this.num);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PBigbossChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */