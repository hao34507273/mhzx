/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.crossbattle.knockout.PGM_SetCrossServerSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setcrossserversession
/*    */   extends CmdBase
/*    */ {
/*    */   private int session;
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
/* 28 */     Integer I_session = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_session == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.session = I_session.intValue();
/*    */     
/* 34 */     if (index != this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 53 */     new PGM_SetCrossServerSession(this.session).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setcrossserversession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */