/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.visiblemonsterfight.main.robber.PGM_SimplifyRobber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_simplifyrobber
/*    */   extends CmdBase
/*    */ {
/*    */   protected boolean parse()
/*    */   {
/* 17 */     if (this.m_arguments == null) {
/* 18 */       return true;
/*    */     }
/* 20 */     int index = 0;
/*    */     
/* 22 */     if (index != this.m_arguments.size()) {
/* 23 */       return false;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 41 */     new PGM_SimplifyRobber(this.m_gmRole.getRoleid()).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_simplifyrobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */