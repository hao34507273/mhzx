/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetInstanceCloseLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int instanceid;
/*    */   private int level;
/*    */   
/*    */   public PGM_SetInstanceCloseLevel(int instanceid, int level)
/*    */   {
/* 14 */     this.instanceid = instanceid;
/* 15 */     this.level = level;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     SInstanceCfg instanceCfg = SInstanceCfg.get(this.instanceid);
/* 22 */     if (instanceCfg == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     instanceCfg.closeLevel = this.level;
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PGM_SetInstanceCloseLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */