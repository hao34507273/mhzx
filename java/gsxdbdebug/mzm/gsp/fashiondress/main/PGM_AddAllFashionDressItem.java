/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*    */ import mzm.gsp.item.main.PGM_AddItem;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddAllFashionDressItem extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_AddAllFashionDressItem(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Set<Integer> awardedFashionDressItemSet = new HashSet();
/*    */     
/* 24 */     for (SFashionDressCfg sFashionDressCfg : SFashionDressCfg.getAll().values())
/*    */     {
/* 26 */       int itemCfgId = sFashionDressCfg.costItemId;
/*    */       
/* 28 */       if (mzm.gsp.item.main.ItemInterface.getItemNumberById(this.roleId, itemCfgId) <= 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 33 */         int itemNum = sFashionDressCfg.costItemNum;
/* 34 */         if (awardedFashionDressItemSet.add(Integer.valueOf(itemCfgId)))
/*    */         {
/* 36 */           new PGM_AddItem(this.roleId, this.roleId, itemCfgId, itemNum, true).execute(); }
/*    */       }
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PGM_AddAllFashionDressItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */