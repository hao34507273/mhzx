/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.feisheng.main.PGM_FeiShengOK;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_feishengok
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int level;
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
/* 41 */     Integer I_level = parseInt((String)this.m_arguments.get(index++));
/* 42 */     if (I_level == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     this.level = I_level.intValue();
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
/*    */   protected boolean fillData()
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 64 */     new PGM_FeiShengOK(this.m_gmRole.getRoleid(), this.roleId, this.level).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_feishengok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */