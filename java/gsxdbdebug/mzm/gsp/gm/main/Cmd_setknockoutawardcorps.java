/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.knockout.PGM_SetKnockOutAwardCorps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setknockoutawardcorps
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityCfgId;
/*    */   private int knockOutType;
/*    */   private int fightZoneId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Integer I_activityCfgId = parseInt((String)this.m_arguments.get(index++));
/* 31 */     if (I_activityCfgId == null) {
/* 32 */       return false;
/*    */     }
/* 34 */     this.activityCfgId = I_activityCfgId.intValue();
/*    */     
/* 36 */     if (index >= this.m_arguments.size()) {
/* 37 */       return false;
/*    */     }
/* 39 */     Integer I_knockOutType = parseInt((String)this.m_arguments.get(index++));
/* 40 */     if (I_knockOutType == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     this.knockOutType = I_knockOutType.intValue();
/*    */     
/* 45 */     if (index >= this.m_arguments.size()) {
/* 46 */       return false;
/*    */     }
/* 48 */     Integer I_fightZoneId = parseInt((String)this.m_arguments.get(index++));
/* 49 */     if (I_fightZoneId == null) {
/* 50 */       return false;
/*    */     }
/* 52 */     this.fightZoneId = I_fightZoneId.intValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 73 */     new PGM_SetKnockOutAwardCorps(this.m_gmRole.getRoleid(), this.activityCfgId, this.knockOutType, this.fightZoneId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setknockoutawardcorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */