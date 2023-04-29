/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class InitSeasonStartTimePro extends LogicProcedure
/*    */ {
/*    */   private long starttime;
/*    */   
/*    */   public InitSeasonStartTimePro(long starttime) {
/* 10 */     this.starttime = starttime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     JingjiManager.setSeasonStarttime(this.starttime);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\InitSeasonStartTimePro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */