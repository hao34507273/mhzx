/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.role.main.PGMSetRoleLevel;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ public class Cmd_levelto extends CmdBase
/*    */ {
/*    */   private long roleId;
/* 10 */   private int level = 1;
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
/* 21 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 23 */     if (this.m_arguments == null) {
/* 24 */       return true;
/*    */     }
/* 26 */     int index = 0;
/*    */     
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return true;
/*    */     }
/* 31 */     Long targetId = null;
/* 32 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 34 */     if (targetId != null)
/*    */     {
/* 36 */       this.roleId = targetId.longValue();
/* 37 */       index++;
/*    */     }
/*    */     
/* 40 */     if (index >= this.m_arguments.size()) {
/* 41 */       return true;
/*    */     }
/* 43 */     Integer I_level = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_level == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.level = I_level.intValue();
/*    */     
/* 49 */     if (index != this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 67 */     PGMSetRoleLevel procedure = new PGMSetRoleLevel(this.roleId, this.level);
/* 68 */     procedure.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_levelto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */