/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class Pgm_SetJingjicount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int value;
/*    */   
/*    */   public Pgm_SetJingjicount(long roleid, int value)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.value = value;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     JingjiManager.setChallengeCount(this.roleid, this.value);
/* 22 */     JingjiManager.synJingjiDataChanged(this.roleid, 0, false);
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\Pgm_SetJingjicount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */