/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_seimprovelevel extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int bagId;
/*    */   private int grid;
/* 10 */   private int useYuanbao = 0;
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
/* 24 */       return false;
/*    */     }
/* 26 */     int index = 0;
/*    */     
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return false;
/*    */     }
/* 31 */     Long targetId = null;
/* 32 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
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
/* 43 */     Integer I_bagId = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_bagId == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.bagId = I_bagId.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     Integer I_grid = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_grid == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.grid = I_grid.intValue();
/*    */     
/* 58 */     if (index >= this.m_arguments.size()) {
/* 59 */       return true;
/*    */     }
/* 61 */     Integer I_useYuanbao = parseInt((String)this.m_arguments.get(index++));
/* 62 */     if (I_useYuanbao == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     this.useYuanbao = I_useYuanbao.intValue();
/*    */     
/* 67 */     if (index != this.m_arguments.size()) {
/* 68 */       return false;
/*    */     }
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 79 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 86 */     new mzm.gsp.superequipment.main.RGMSuperEquipmentImproveLevel(this.m_gmRole.getRoleid(), this.roleId, this.bagId, this.grid, this.useYuanbao != 0).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_seimprovelevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */