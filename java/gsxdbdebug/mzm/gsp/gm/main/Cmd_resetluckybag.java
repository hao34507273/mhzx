/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_resetluckybag extends CmdBase
/*    */ {
/*  7 */   private int number = -1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return true;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return true;
/*    */     }
/* 26 */     Integer I_number = parseInt((String)this.m_arguments.get(index++));
/* 27 */     if (I_number == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     this.number = I_number.intValue();
/*    */     
/* 32 */     if (index != this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 51 */     new mzm.gsp.luckybag.main.PGM_ResetLuckyBag(this.m_gmRole.getRoleid(), this.number).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_resetluckybag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */