/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PlayerLand;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PLand
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int x;
/*    */   private final int y;
/*    */   
/*    */   public PLand(long roleid, int x, int y)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.x = x;
/* 17 */     this.y = y;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!MapManager.canDoAction(this.roleid, 161))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     new MMH_PlayerLand(this.roleid, this.x, this.y).execute();
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PLand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */