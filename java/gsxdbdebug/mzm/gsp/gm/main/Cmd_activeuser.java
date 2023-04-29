/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.csprovider.main.CSProviderInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_activeuser
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 49 */     if (this.arg.equalsIgnoreCase("on")) {
/* 50 */       CSProviderInterface.setRequireActivateUser(true);
/*    */     }
/* 52 */     else if (this.arg.equalsIgnoreCase("off")) {
/* 53 */       CSProviderInterface.setRequireActivateUser(false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_activeuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */