/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PGM_AddExp;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ public class Cmd_addexp extends CmdBase
/*    */ {
/*    */   private long roleId;
/* 11 */   private int exp = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 22 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 24 */     if (this.m_arguments == null) {
/* 25 */       return true;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return true;
/*    */     }
/* 32 */     Long targetId = null;
/* 33 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 35 */     if (targetId != null)
/*    */     {
/* 37 */       this.roleId = targetId.longValue();
/* 38 */       index++;
/*    */     }
/*    */     
/* 41 */     if (index >= this.m_arguments.size()) {
/* 42 */       return true;
/*    */     }
/* 44 */     Integer I_exp = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_exp == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.exp = I_exp.intValue();
/*    */     
/* 50 */     if (index != this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 62 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 68 */     new PGM_AddExp(this.roleId, this.exp).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */