/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_cutexp extends CmdBase
/*    */ {
/*    */   private long roleId;
/*  8 */   private int exp = 0;
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
/* 19 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 21 */     if (this.m_arguments == null) {
/* 22 */       return true;
/*    */     }
/* 24 */     int index = 0;
/*    */     
/* 26 */     if (index >= this.m_arguments.size()) {
/* 27 */       return true;
/*    */     }
/* 29 */     Long targetId = null;
/* 30 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 32 */     if (targetId != null)
/*    */     {
/* 34 */       this.roleId = targetId.longValue();
/* 35 */       index++;
/*    */     }
/*    */     
/* 38 */     if (index >= this.m_arguments.size()) {
/* 39 */       return true;
/*    */     }
/* 41 */     Integer I_exp = parseInt((String)this.m_arguments.get(index++));
/* 42 */     if (I_exp == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     this.exp = I_exp.intValue();
/*    */     
/* 47 */     if (index != this.m_arguments.size()) {
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */   
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
/* 65 */     new mzm.gsp.role.main.PGM_CutExp(this.roleId, this.exp).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_cutexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */