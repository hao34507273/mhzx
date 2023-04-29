/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.online.main.PGMForbidRole;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_forbidrole
/*    */   extends CmdBase
/*    */ {
/*    */   private String name;
/*    */   private int periodSec;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     this.name = ((String)this.m_arguments.get(index++));
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return false;
/*    */     }
/* 31 */     Integer I_periodSec = parseInt((String)this.m_arguments.get(index++));
/* 32 */     if (I_periodSec == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     this.periodSec = I_periodSec.intValue();
/*    */     
/* 37 */     if (index != this.m_arguments.size()) {
/* 38 */       return false;
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 55 */     new PGMForbidRole(this.name, this.periodSec).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_forbidrole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */