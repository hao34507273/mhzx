/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pk.main.PStartPK;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_startpk
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private long targetRoleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 21 */     if (this.m_arguments == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     int index = 0;
/*    */     
/* 26 */     if (index >= this.m_arguments.size()) {
/* 27 */       return false;
/*    */     }
/* 29 */     Long targetId = null;
/* 30 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 32 */     if (targetId != null)
/*    */     {
/* 34 */       this.roleId = targetId.longValue();
/* 35 */       index++;
/*    */     }
/*    */     
/* 38 */     if (index >= this.m_arguments.size()) {
/* 39 */       return false;
/*    */     }
/* 41 */     Long L_targetRoleId = parseLong((String)this.m_arguments.get(index++));
/* 42 */     if (L_targetRoleId == null)
/* 43 */       return false;
/* 44 */     this.targetRoleId = L_targetRoleId.longValue();
/*    */     
/* 46 */     if (index != this.m_arguments.size()) {
/* 47 */       return false;
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 65 */     Procedure.execute(new PStartPK(this.roleId, this.targetRoleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_startpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */