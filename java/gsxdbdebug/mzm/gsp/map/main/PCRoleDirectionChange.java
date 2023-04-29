/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PlayerDirectionChange;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCRoleDirectionChange
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int direction;
/*    */   
/*    */   public PCRoleDirectionChange(long roleid, int direction)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.direction = direction;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!MapManager.canDoAction(this.roleid, 165))
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     new MMH_PlayerDirectionChange(this.roleid, this.direction).execute();
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PCRoleDirectionChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */