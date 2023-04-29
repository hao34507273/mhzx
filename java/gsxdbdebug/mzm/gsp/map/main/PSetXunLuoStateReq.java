/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_SetXunLuoState;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PSetXunLuoStateReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private boolean setting;
/*    */   
/*    */   public PSetXunLuoStateReq(long roleid, boolean setting)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.setting = setting;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!MapManager.canDoAction(this.roleid, 166))
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     new MMH_SetXunLuoState(this.roleid, this.setting).execute();
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PSetXunLuoStateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */