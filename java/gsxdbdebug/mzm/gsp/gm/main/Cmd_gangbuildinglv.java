/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PGMGangBuildingLevelUp;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_gangbuildinglv
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private String buildingType;
/*    */   private int lv;
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
/* 44 */     this.buildingType = ((String)this.m_arguments.get(index++));
/* 45 */     if (index >= this.m_arguments.size()) {
/* 46 */       return false;
/*    */     }
/* 48 */     Integer I_lv = parseInt((String)this.m_arguments.get(index++));
/* 49 */     if (I_lv == null) {
/* 50 */       return false;
/*    */     }
/* 52 */     this.lv = I_lv.intValue();
/*    */     
/* 54 */     if (index != this.m_arguments.size()) {
/* 55 */       return false;
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 72 */     new PGMGangBuildingLevelUp(this.roleId, this.buildingType, this.lv).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_gangbuildinglv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */