/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.award.drop.PGM_CheckRoleDropInfo;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_dropinfo
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return true;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return true;
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
/* 39 */     if (index != this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 57 */     Procedure.execute(new PGM_CheckRoleDropInfo(this.roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_dropinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */