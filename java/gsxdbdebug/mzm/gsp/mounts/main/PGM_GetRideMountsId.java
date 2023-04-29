/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Role2MountsInfo;
/*    */ import xtable.Role2mounts;
/*    */ 
/*    */ public class PGM_GetRideMountsId extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetRideMountsId(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/* 20 */     if (xRole2MountsInfo == null)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.roleId, "角色未拥有坐骑包裹");
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (xRole2MountsInfo.getCurrent_ride_mounts_id() == 0L)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.roleId, "角色当前未骑乘坐骑");
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前骑乘坐骑实例id是 " + xRole2MountsInfo.getCurrent_ride_mounts_id());
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PGM_GetRideMountsId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */