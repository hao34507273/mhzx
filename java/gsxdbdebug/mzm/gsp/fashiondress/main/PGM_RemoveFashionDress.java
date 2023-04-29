/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveFashionDress
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long targetRoleId;
/*    */   private final int fashionDressItemCfgId;
/*    */   
/*    */   public PGM_RemoveFashionDress(long gmRoleId, long targetRoleId, int fashionDressItemCfgId)
/*    */   {
/* 17 */     this.gmRoleId = gmRoleId;
/*    */     
/* 19 */     this.targetRoleId = targetRoleId;
/*    */     
/* 21 */     this.fashionDressItemCfgId = fashionDressItemCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     xbean.Basic xBasic = xtable.Basic.get(Long.valueOf(this.targetRoleId));
/*    */     
/* 29 */     if (xBasic == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "目标角色不存在");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     int ret = FashionDressInterface.removeFashionDress(this.targetRoleId, this.fashionDressItemCfgId);
/* 36 */     if (ret != 0)
/*    */     {
/* 38 */       if (ret == 64116)
/*    */       {
/* 40 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "目标角色时装数据不存在");
/*    */       }
/* 42 */       else if (ret == 64115)
/*    */       {
/* 44 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "物品不存在");
/*    */       }
/* 46 */       else if (ret == 64114)
/*    */       {
/* 48 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "时装物品对应的时装不存在");
/*    */       }
/* 50 */       else if (ret == 64112)
/*    */       {
/* 52 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色未拥有该时装");
/*    */       }
/*    */       
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "删除时装成功");
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PGM_RemoveFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */