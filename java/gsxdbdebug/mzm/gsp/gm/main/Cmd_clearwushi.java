/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.superequipment.wushi.main.PGM_ClearWuShi;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_clearwushi
/*    */   extends CmdBase
/*    */ {
/*    */   protected boolean parse()
/*    */   {
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return true;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index != this.m_arguments.size()) {
/* 24 */       return false;
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 41 */     Procedure.execute(new PGM_ClearWuShi(this.m_gmRole.getRoleid()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_clearwushi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */