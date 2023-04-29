/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.firework.main.PGM_FindFirework;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_findfirework
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int activityId;
/*    */   private int controllerId;
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
/* 43 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_activityId == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.activityId = I_activityId.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     Integer I_controllerId = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_controllerId == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.controllerId = I_controllerId.intValue();
/*    */     
/* 58 */     if (index != this.m_arguments.size()) {
/* 59 */       return false;
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 76 */     new PGM_FindFirework(this.roleId, this.activityId, this.controllerId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_findfirework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */