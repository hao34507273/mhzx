/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.own.RGM_SetRegisterCorpsMemberNumLimit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setregisterlimit
/*    */   extends CmdBase
/*    */ {
/*    */   private int activity_cfg_id;
/*    */   private int upper_limit;
/*    */   private int lower_limit;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_activity_cfg_id == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_upper_limit = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_upper_limit == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.upper_limit = I_upper_limit.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_lower_limit = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_lower_limit == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.lower_limit = I_lower_limit.intValue();
/*    */     
/* 52 */     if (index != this.m_arguments.size()) {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 69 */     new RGM_SetRegisterCorpsMemberNumLimit(this.m_gmRole.getRoleid(), this.activity_cfg_id, this.upper_limit, this.lower_limit).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setregisterlimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */