/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.knockout.PGM_SetFinalCorpsInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setfinalcorps
/*    */   extends CmdBase
/*    */ {
/*    */   private int fightZone;
/*    */   private int rank;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_fightZone = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_fightZone == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.fightZone = I_fightZone.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_rank = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_rank == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.rank = I_rank.intValue();
/*    */     
/* 42 */     if (index != this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 61 */     new PGM_SetFinalCorpsInfo(this.m_gmRole.getRoleid(), this.fightZone, this.rank).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setfinalcorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */