/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class Pgm_SetWinPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int value;
/*    */   
/*    */   public Pgm_SetWinPoint(long roleid, int value)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     int old = JingjiManager.getWinpoint(this.roleid, false);
/* 21 */     JingjiManager.setWinpoint(this.roleid, this.value);
/*    */     
/* 23 */     JingjiManager.synJingjiDataChanged(this.roleid, this.value - old, false);
/* 24 */     RoleJingjiChartInterface.rank(this.roleid, this.value);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\Pgm_SetWinPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */