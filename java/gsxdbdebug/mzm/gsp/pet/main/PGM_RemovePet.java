/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemovePet
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long targetRoleId;
/*    */   private final int petCfgId;
/*    */   private final long petId;
/*    */   
/*    */   public PGM_RemovePet(long gmRoleId, long targetRoleId, int petCfgId, long petId)
/*    */   {
/* 19 */     this.gmRoleId = gmRoleId;
/* 20 */     this.targetRoleId = targetRoleId;
/* 21 */     this.petCfgId = petCfgId;
/* 22 */     this.petId = petId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     int ret = PetInterface.removePet(this.targetRoleId, this.petCfgId, this.petId);
/*    */     
/* 30 */     if (ret == 64046)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除宠物的角色不存在");
/* 33 */       return false;
/*    */     }
/* 35 */     if (ret == 64045)
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除宠物实例id不存在");
/* 38 */       return false;
/*    */     }
/* 40 */     if (ret == 64044)
/*    */     {
/* 42 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除宠物配置id不存在");
/* 43 */       return false;
/*    */     }
/* 45 */     if (ret == 64043)
/*    */     {
/* 47 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "要删除宠物实例id和配置id不匹配");
/* 48 */       return false;
/*    */     }
/* 50 */     if (ret == 64042)
/*    */     {
/* 52 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色未拥有该宠物");
/* 53 */       return false;
/*    */     }
/* 55 */     if (ret == 64041)
/*    */     {
/* 57 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色未拥有宠物包裹");
/* 58 */       return false;
/*    */     }
/* 60 */     if (ret == 64040)
/*    */     {
/* 62 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "宠物正在战斗中");
/* 63 */       return false;
/*    */     }
/* 65 */     if (ret == 64039)
/*    */     {
/* 67 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "删除宠物在角色防御小队最后一只宠物,不能删除");
/* 68 */       return false;
/*    */     }
/* 70 */     if (ret != 0)
/*    */     {
/* 72 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "未知错误");
/* 73 */       return false;
/*    */     }
/*    */     
/* 76 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "删除成功");
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGM_RemovePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */