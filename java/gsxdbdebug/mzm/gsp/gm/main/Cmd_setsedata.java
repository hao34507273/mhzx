/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.superequipment.main.PGMSetSuperEquipmentData;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setsedata
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int bagId;
/*    */   private int grid;
/*    */   private int stage;
/*    */   private int level;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 22 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 24 */     if (this.m_arguments == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     int index = 0;
/*    */     
/* 29 */     if (index >= this.m_arguments.size()) {
/* 30 */       return false;
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
/* 42 */       return false;
/*    */     }
/* 44 */     Integer I_bagId = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_bagId == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.bagId = I_bagId.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     Integer I_grid = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_grid == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.grid = I_grid.intValue();
/*    */     
/* 59 */     if (index >= this.m_arguments.size()) {
/* 60 */       return false;
/*    */     }
/* 62 */     Integer I_stage = parseInt((String)this.m_arguments.get(index++));
/* 63 */     if (I_stage == null) {
/* 64 */       return false;
/*    */     }
/* 66 */     this.stage = I_stage.intValue();
/*    */     
/* 68 */     if (index >= this.m_arguments.size()) {
/* 69 */       return false;
/*    */     }
/* 71 */     Integer I_level = parseInt((String)this.m_arguments.get(index++));
/* 72 */     if (I_level == null) {
/* 73 */       return false;
/*    */     }
/* 75 */     this.level = I_level.intValue();
/*    */     
/* 77 */     if (index != this.m_arguments.size()) {
/* 78 */       return false;
/*    */     }
/* 80 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 89 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 96 */     Procedure.execute(new PGMSetSuperEquipmentData(this.m_gmRole.getRoleid(), this.roleId, this.bagId, this.grid, this.stage, this.level));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setsedata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */