/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PGM_CutGoldByIdip;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_cutgoldbyaqidip
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int number;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 21 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 23 */     if (this.m_arguments == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     int index = 0;
/*    */     
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return false;
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
/* 41 */       return false;
/*    */     }
/* 43 */     Integer I_number = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_number == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.number = I_number.intValue();
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
/* 67 */     Procedure.execute(new PGM_CutGoldByIdip(this.roleId, this.number, 2));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_cutgoldbyaqidip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */