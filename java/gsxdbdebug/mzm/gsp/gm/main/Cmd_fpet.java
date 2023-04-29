/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.main.PGM_FPetFight;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ public class Cmd_fpet
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 16 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return true;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return true;
/*    */     }
/* 26 */     Long targetId = null;
/* 27 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 29 */     if (targetId != null)
/*    */     {
/* 31 */       this.roleId = targetId.longValue();
/* 32 */       index++;
/*    */     }
/*    */     
/* 35 */     if (index != this.m_arguments.size()) {
/* 36 */       return false;
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   protected void run()
/*    */   {
/* 51 */     Procedure.execute(new PGM_FPetFight(this.m_gmRole.getRoleid(), this.roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_fpet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */