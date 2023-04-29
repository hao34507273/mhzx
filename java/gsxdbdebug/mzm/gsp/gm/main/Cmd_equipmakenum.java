/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_equipmakenum extends CmdBase
/*    */ {
/*    */   private long roleId;
/*  8 */   private int level = -1;
/*  9 */   private int eqpid = -1;
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
/* 41 */     Integer I_level = parseInt((String)this.m_arguments.get(index++));
/* 42 */     if (I_level == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     this.level = I_level.intValue();
/*    */     
/* 47 */     if (index >= this.m_arguments.size()) {
/* 48 */       return true;
/*    */     }
/* 50 */     Integer I_eqpid = parseInt((String)this.m_arguments.get(index++));
/* 51 */     if (I_eqpid == null) {
/* 52 */       return false;
/*    */     }
/* 54 */     this.eqpid = I_eqpid.intValue();
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
/* 74 */     new mzm.gsp.item.main.PGM_EquipMakeCount(this.m_gmRole.getRoleid(), this.roleId, this.level, this.eqpid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_equipmakenum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */