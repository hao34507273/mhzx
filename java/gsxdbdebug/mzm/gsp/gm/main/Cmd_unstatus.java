/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.status.main.PGM_UnSetStatus;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_unstatus
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int status;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Long targetId = null;
/* 31 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 33 */     if (targetId != null)
/*    */     {
/* 35 */       this.roleId = targetId.longValue();
/* 36 */       index++;
/*    */     }
/*    */     
/* 39 */     if (index >= this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Integer I_status = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_status == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.status = I_status.intValue();
/*    */     
/* 48 */     if (index != this.m_arguments.size()) {
/* 49 */       return false;
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 65 */     boolean unset = false;
/* 66 */     if (this.status == 2) {
/* 67 */       unset = true;
/* 68 */     } else if (this.status == 3) {
/* 69 */       unset = true;
/*    */     } else {
/* 71 */       return;
/*    */     }
/* 73 */     if (unset) {
/* 74 */       boolean ret = new PGM_UnSetStatus(this.roleId, this.status).call();
/* 75 */       if (ret) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_unstatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */