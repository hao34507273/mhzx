/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_getweightcorrection extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int weightCorrectionType;
/*  9 */   private int itemSubid = 0;
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
/* 31 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
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
/* 42 */     Integer I_weightCorrectionType = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_weightCorrectionType == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.weightCorrectionType = I_weightCorrectionType.intValue();
/*    */     
/* 48 */     if (index >= this.m_arguments.size()) {
/* 49 */       return true;
/*    */     }
/* 51 */     Integer I_itemSubid = parseInt((String)this.m_arguments.get(index++));
/* 52 */     if (I_itemSubid == null) {
/* 53 */       return false;
/*    */     }
/* 55 */     this.itemSubid = I_itemSubid.intValue();
/*    */     
/* 57 */     if (index != this.m_arguments.size()) {
/* 58 */       return false;
/*    */     }
/* 60 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 76 */     new mzm.gsp.awardpool.main.PGM_GetWeightCorrection(this.roleId, this.weightCorrectionType, this.itemSubid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_getweightcorrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */