/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.CustommizedCons;
/*    */ import xbean.MarketEquipConSet;
/*    */ import xbean.MarketPetConSet;
/*    */ import xbean.MarketPetEquipConSet;
/*    */ 
/*    */ public class PDeleteConditionReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int index;
/*    */   private final int subid;
/*    */   
/*    */   public PDeleteConditionReq(long roleId, int index, int subid)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.index = (index - 1);
/* 19 */     this.subid = subid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (this.index < 0)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!mzm.gsp.market.main.MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 32 */       String logStr = String.format("[marketcustomized]PDeleteConditionReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 34 */       mzm.gsp.market.main.MarketInterface.getLogger().info(logStr);
/* 35 */       return false;
/*    */     }
/* 37 */     CustommizedCons xCustommizedCons = xtable.Role2customized.get(Long.valueOf(this.roleId));
/* 38 */     if (xCustommizedCons == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     mzm.gsp.market.SDeleteConditionRes res = new mzm.gsp.market.SDeleteConditionRes();
/* 43 */     res.index = (this.index + 1);
/* 44 */     res.subid = this.subid;
/* 45 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 47 */     MarketEquipConSet xMarketEquipConSet = (MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(this.subid));
/* 48 */     if ((xMarketEquipConSet != null) && (this.index < xMarketEquipConSet.getEquipcons().size()))
/*    */     {
/* 50 */       xbean.MarketEquipCon xMarketEquipCon = (xbean.MarketEquipCon)xMarketEquipConSet.getEquipcons().remove(this.index);
/* 51 */       if (xMarketEquipCon != null)
/*    */       {
/* 53 */         CustomizedConditionManager.getInstance().removeEquipConditionRoleId(this.subid, MarketSearcherManager.getEquipConditionFromXbean(xMarketEquipCon), this.roleId);
/*    */       }
/*    */       
/* 56 */       return true;
/*    */     }
/* 58 */     MarketPetEquipConSet xMarketPetEquipConSet = (MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(this.subid));
/* 59 */     if ((xMarketPetEquipConSet != null) && (this.index < xMarketPetEquipConSet.getPetequipcons().size()))
/*    */     {
/* 61 */       xbean.MarketPetEquipCon xMarketPetEquipCon = (xbean.MarketPetEquipCon)xMarketPetEquipConSet.getPetequipcons().remove(this.index);
/* 62 */       if (xMarketPetEquipCon != null)
/*    */       {
/* 64 */         CustomizedConditionManager.getInstance().removePetEquipConditionRoleId(this.subid, MarketSearcherManager.getPetEquipConditionFromXbean(xMarketPetEquipCon), this.roleId);
/*    */       }
/*    */       
/*    */ 
/* 68 */       return true;
/*    */     }
/* 70 */     MarketPetConSet xMarketPetConSet = (MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(this.subid));
/* 71 */     if ((xMarketPetConSet != null) && (this.index < xMarketPetConSet.getPetcons().size()))
/*    */     {
/* 73 */       xbean.MarketPetCon xMarketPetCon = (xbean.MarketPetCon)xMarketPetConSet.getPetcons().remove(this.index);
/* 74 */       if (xMarketPetCon != null)
/*    */       {
/* 76 */         CustomizedConditionManager.getInstance().removePetConditionRoleId(this.subid, MarketSearcherManager.getPetConditionFromXbean(xMarketPetCon), this.roleId);
/*    */       }
/*    */       
/* 79 */       return true;
/*    */     }
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PDeleteConditionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */