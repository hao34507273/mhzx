/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crosscompete.main.PGM_SimplifyCrossCompete;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_simplifycrosscompete
/*    */   extends CmdBase
/*    */ {
/*    */   private String onOrOff;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return false;
/*    */     }
/* 26 */     this.onOrOff = ((String)this.m_arguments.get(index++));
/* 27 */     if (index != this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 45 */     Procedure.execute(new PGM_SimplifyCrossCompete(this.m_gmRole.getRoleid(), this.onOrOff));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_simplifycrosscompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */