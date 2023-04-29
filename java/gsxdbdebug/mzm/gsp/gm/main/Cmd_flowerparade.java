/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_flowerparade extends CmdBase {
/*  6 */   private int mapId = -1;
/*  7 */   private int ocp = -1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 17 */     if (this.m_arguments == null) {
/* 18 */       return true;
/*    */     }
/* 20 */     int index = 0;
/*    */     
/* 22 */     if (index >= this.m_arguments.size()) {
/* 23 */       return true;
/*    */     }
/* 25 */     Integer I_mapId = parseInt((String)this.m_arguments.get(index++));
/* 26 */     if (I_mapId == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     this.mapId = I_mapId.intValue();
/*    */     
/* 31 */     if (index >= this.m_arguments.size()) {
/* 32 */       return true;
/*    */     }
/* 34 */     Integer I_ocp = parseInt((String)this.m_arguments.get(index++));
/* 35 */     if (I_ocp == null) {
/* 36 */       return false;
/*    */     }
/* 38 */     this.ocp = I_ocp.intValue();
/*    */     
/* 40 */     if (index != this.m_arguments.size()) {
/* 41 */       return false;
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   protected void run()
/*    */   {
/* 56 */     new mzm.gsp.flowerparade.main.PGM_FlowerPradeStart(this.mapId, this.ocp).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_flowerparade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */