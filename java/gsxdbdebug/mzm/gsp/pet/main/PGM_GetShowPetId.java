/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.PetBag;
/*    */ 
/*    */ public class PGM_GetShowPetId extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetShowPetId(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(this.roleId));
/* 19 */     if (xPetBag == null)
/*    */     {
/* 21 */       GmManager.getInstance().sendResultToGM(this.roleId, "角色未拥有宠物包裹");
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (xPetBag.getShowpet() == -1L)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.roleId, "角色未展示宠物");
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     GmManager.getInstance().sendResultToGM(this.roleId, "展示跟随的宠物实例id是" + xPetBag.getShowpet());
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGM_GetShowPetId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */