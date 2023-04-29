/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_equipqilin extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int wearpos;
/*    */   private int level;
/* 10 */   private int ocp = -1;
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
/* 43 */     Integer I_wearpos = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_wearpos == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.wearpos = I_wearpos.intValue();
/*    */     
/* 49 */     if (index >= this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     Integer I_level = parseInt((String)this.m_arguments.get(index++));
/* 53 */     if (I_level == null) {
/* 54 */       return false;
/*    */     }
/* 56 */     this.level = I_level.intValue();
/*    */     
/* 58 */     if (index >= this.m_arguments.size()) {
/* 59 */       return true;
/*    */     }
/* 61 */     Integer I_ocp = parseInt((String)this.m_arguments.get(index++));
/* 62 */     if (I_ocp == null) {
/* 63 */       return false;
/*    */     }
/* 65 */     this.ocp = I_ocp.intValue();
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
/* 86 */     new mzm.gsp.item.main.Pgm_Equipqilin(this.m_gmRole.getRoleid(), this.roleId, this.wearpos, this.level, this.ocp).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_equipqilin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */