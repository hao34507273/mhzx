/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.circletask.main.CircleTaskInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_openshilian
/*    */   extends CmdBase
/*    */ {
/*    */   private String arg;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     this.arg = ((String)this.m_arguments.get(index++));
/* 29 */     if (index != this.m_arguments.size()) {
/* 30 */       return false;
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 48 */     if (this.arg.equalsIgnoreCase("on")) {
/* 49 */       CircleTaskInterface.setShilianOpenState(true);
/*    */     }
/* 51 */     else if (this.arg.equalsIgnoreCase("off")) {
/* 52 */       CircleTaskInterface.setShilianOpenState(false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_openshilian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */