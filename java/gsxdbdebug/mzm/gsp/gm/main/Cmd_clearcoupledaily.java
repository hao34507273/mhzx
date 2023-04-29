/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.coupledaily.main.PGM_ResetCoupleDailyInfo;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_clearcoupledaily
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
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
/* 30 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 32 */     if (targetId != null)
/*    */     {
/* 34 */       this.roleId = targetId.longValue();
/* 35 */       index++;
/*    */     }
/*    */     
/* 38 */     if (index != this.m_arguments.size()) {
/* 39 */       return false;
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 57 */     new PGM_ResetCoupleDailyInfo(this.roleId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_clearcoupledaily.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */