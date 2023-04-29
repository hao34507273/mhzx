/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.aircraft.main.PCUseAircraftItem;
/*    */ import mzm.gsp.fashiondress.main.PCUnLockFashionDress;
/*    */ import mzm.gsp.item.main.ItemIdManger;
/*    */ import mzm.gsp.item.main.PUseWingViewItem;
/*    */ import mzm.gsp.magicmark.main.PCUnLockMagicMarkReq;
/*    */ import mzm.gsp.mounts.main.PCUnlockMounts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POneKeySurface
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public POneKeySurface(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     String name = RoleInterface.getName(this.roleId);
/* 28 */     List<Long> wings = ItemIdManger.getWinitems(this.roleId);
/* 29 */     if (wings.size() > 0) {
/* 30 */       for (Long wingid : wings) {
/* 31 */         Procedure.execute(new PUseWingViewItem(this.roleId, wingid.longValue()));
/*    */       }
/*    */     }
/*    */     
/* 35 */     List<Long> airs = ItemIdManger.getAirItemUuId(Long.valueOf(this.roleId));
/* 36 */     if (airs.size() > 0) {
/* 37 */       for (Long airId : airs) {
/* 38 */         Procedure.execute(new PCUseAircraftItem(this.roleId, airId.longValue()));
/*    */       }
/*    */     }
/*    */     
/* 42 */     List<Integer> fashions = ItemIdManger.getFashionId(Long.valueOf(this.roleId));
/* 43 */     if (fashions.size() > 0) {
/* 44 */       for (Integer fashionID : fashions) {
/* 45 */         Procedure.execute(new PCUnLockFashionDress(this.roleId, fashionID.intValue()));
/*    */       }
/*    */     }
/*    */     
/* 49 */     List<Integer> magicmarks = ItemIdManger.getMagiceMarks(Long.valueOf(this.roleId));
/* 50 */     if (magicmarks.size() > 0) {
/* 51 */       for (Integer magicId : magicmarks) {
/* 52 */         Procedure.execute(new PCUnLockMagicMarkReq(this.roleId, Arrays.asList(new Integer[] { magicId })));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 57 */     List<Long> mounts = ItemIdManger.getMountsUuId(this.roleId);
/* 58 */     if (mounts.size() > 0) {
/* 59 */       for (Long mid : mounts) {
/* 60 */         Procedure.execute(new PCUnlockMounts(this.roleId, mid.longValue()));
/*    */       }
/*    */     }
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POneKeySurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */