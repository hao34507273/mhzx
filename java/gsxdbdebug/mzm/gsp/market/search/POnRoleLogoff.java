/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnRoleLogoff extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     xbean.CustommizedCons xCustommizedCons = xtable.Role2customized.get((Long)this.arg);
/* 10 */     if (xCustommizedCons == null)
/*    */     {
/* 12 */       return false;
/*    */     }
/* 14 */     for (Iterator i$ = xCustommizedCons.getSubid2equipcons().keySet().iterator(); i$.hasNext();) { subid = ((Integer)i$.next()).intValue();
/*    */       
/* 16 */       xbean.MarketEquipConSet xMarketEquipConSet = (xbean.MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(subid));
/* 17 */       for (xbean.MarketEquipCon xMarketEquipCon : xMarketEquipConSet.getEquipcons())
/*    */       {
/*    */ 
/* 20 */         CustomizedConditionManager.getInstance().removeEquipConditionRoleId(subid, MarketSearcherManager.getEquipConditionFromXbean(xMarketEquipCon), ((Long)this.arg).longValue());
/*    */       }
/*    */     }
/*    */     
/*    */     int subid;
/*    */     
/* 26 */     for (Iterator i$ = xCustommizedCons.getSubid2petequipcons().keySet().iterator(); i$.hasNext();) { subid = ((Integer)i$.next()).intValue();
/*    */       
/* 28 */       xbean.MarketPetEquipConSet xMarketPetEquipConSet = (xbean.MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(subid));
/* 29 */       for (xbean.MarketPetEquipCon xMarketPetEquipCon : xMarketPetEquipConSet.getPetequipcons())
/*    */       {
/* 31 */         CustomizedConditionManager.getInstance().removePetEquipConditionRoleId(subid, MarketSearcherManager.getPetEquipConditionFromXbean(xMarketPetEquipCon), ((Long)this.arg).longValue());
/*    */       }
/*    */     }
/*    */     
/*    */     int subid;
/*    */     
/* 37 */     for (Iterator i$ = xCustommizedCons.getSubid2petcons().keySet().iterator(); i$.hasNext();) { subid = ((Integer)i$.next()).intValue();
/*    */       
/* 39 */       xbean.MarketPetConSet xMarketPetConSet = (xbean.MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(subid));
/* 40 */       for (xbean.MarketPetCon xMarketPetCon : xMarketPetConSet.getPetcons())
/*    */       {
/* 42 */         CustomizedConditionManager.getInstance().removePetConditionRoleId(subid, MarketSearcherManager.getPetConditionFromXbean(xMarketPetCon), ((Long)this.arg).longValue());
/*    */       }
/*    */     }
/*    */     
/*    */     int subid;
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */