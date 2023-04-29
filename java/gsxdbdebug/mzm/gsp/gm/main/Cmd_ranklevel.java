/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.role.main.PGM_RankLevel;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_ranklevel
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
/* 41 */     Procedure.execute(new PGM_RankLevel());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_ranklevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */