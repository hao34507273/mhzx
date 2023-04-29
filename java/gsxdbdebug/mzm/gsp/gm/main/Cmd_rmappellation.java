/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.title.main.PGM_RmAppellation;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_rmappellation
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private long targetRoleId;
/*    */   private int appellationId;
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
/* 42 */     Long L_targetRoleId = parseLong((String)this.m_arguments.get(index++));
/* 43 */     if (L_targetRoleId == null)
/* 44 */       return false;
/* 45 */     this.targetRoleId = L_targetRoleId.longValue();
/*    */     
/* 47 */     if (index >= this.m_arguments.size()) {
/* 48 */       return false;
/*    */     }
/* 50 */     Integer I_appellationId = parseInt((String)this.m_arguments.get(index++));
/* 51 */     if (I_appellationId == null) {
/* 52 */       return false;
/*    */     }
/* 54 */     this.appellationId = I_appellationId.intValue();
/*    */     
/* 56 */     if (index != this.m_arguments.size()) {
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 74 */     new PGM_RmAppellation(this.roleId, this.targetRoleId, this.appellationId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_rmappellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */