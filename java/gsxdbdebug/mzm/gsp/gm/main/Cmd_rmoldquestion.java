/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.chat.question.PGM_ClearOwnQuestions;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_rmoldquestion
/*    */   extends CmdBase
/*    */ {
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return true;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index != this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 42 */     Procedure.execute(new PGM_ClearOwnQuestions());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_rmoldquestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */