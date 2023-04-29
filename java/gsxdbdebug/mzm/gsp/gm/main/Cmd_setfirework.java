/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.firework.main.PGM_SetFireworkData;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setfirework
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int activityId;
/*    */   private int findLastInterval;
/*    */   private int triggerCount;
/*    */   private int triggerShowNeedCount;
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
/* 44 */     Integer I_activityId = parseInt((String)this.m_arguments.get(index++));
/* 45 */     if (I_activityId == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     this.activityId = I_activityId.intValue();
/*    */     
/* 50 */     if (index >= this.m_arguments.size()) {
/* 51 */       return false;
/*    */     }
/* 53 */     Integer I_findLastInterval = parseInt((String)this.m_arguments.get(index++));
/* 54 */     if (I_findLastInterval == null) {
/* 55 */       return false;
/*    */     }
/* 57 */     this.findLastInterval = I_findLastInterval.intValue();
/*    */     
/* 59 */     if (index >= this.m_arguments.size()) {
/* 60 */       return false;
/*    */     }
/* 62 */     Integer I_triggerCount = parseInt((String)this.m_arguments.get(index++));
/* 63 */     if (I_triggerCount == null) {
/* 64 */       return false;
/*    */     }
/* 66 */     this.triggerCount = I_triggerCount.intValue();
/*    */     
/* 68 */     if (index >= this.m_arguments.size()) {
/* 69 */       return false;
/*    */     }
/* 71 */     Integer I_triggerShowNeedCount = parseInt((String)this.m_arguments.get(index++));
/* 72 */     if (I_triggerShowNeedCount == null) {
/* 73 */       return false;
/*    */     }
/* 75 */     this.triggerShowNeedCount = I_triggerShowNeedCount.intValue();
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
/*    */   protected void run()
/*    */   {
/* 95 */     new PGM_SetFireworkData(this.roleId, this.activityId, this.findLastInterval, this.triggerCount, this.triggerShowNeedCount).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setfirework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */