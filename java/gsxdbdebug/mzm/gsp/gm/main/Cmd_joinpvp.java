/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_joinpvp
/*    */   extends CmdBase
/*    */ {
/*    */   protected boolean parse()
/*    */   {
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return true;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index != this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   protected void run() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_joinpvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */