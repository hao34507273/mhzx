/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_sync_date
/*    */   extends CmdBase
/*    */ {
/*    */   private String value;
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
/* 26 */     this.value = ((String)this.m_arguments.get(index++));
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
/* 45 */     if (!GameServerInfoManager.setDateForGM(this.value, this.m_gmRole.getRoleid()))
/*    */     {
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     CrossServerInterface.setServerDateForGM(this.value);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_sync_date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */