/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PJingjiChartReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int startpos;
/*    */   private int num;
/*    */   
/*    */   public PJingjiChartReq(long roleid, int startpos, int num)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.startpos = startpos;
/* 16 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     JingjiManager.synRankDatas(this.roleid, this.startpos, this.num);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PJingjiChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */