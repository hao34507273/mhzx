/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qingfu.main.PGM_GetLastOneMonthCash;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_getlastonemonthcash
/*    */   extends CmdBase
/*    */ {
/*    */   protected boolean parse()
/*    */   {
/* 16 */     if (this.m_arguments == null) {
/* 17 */       return true;
/*    */     }
/* 19 */     int index = 0;
/*    */     
/* 21 */     if (index != this.m_arguments.size()) {
/* 22 */       return false;
/*    */     }
/* 24 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 40 */     new PGM_GetLastOneMonthCash(this.m_gmRole.getRoleid()).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getlastonemonthcash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */