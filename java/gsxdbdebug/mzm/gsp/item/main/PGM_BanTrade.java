/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_BanTrade extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int itemIdOrpetCfgId;
/*    */   private final int tradeType;
/*    */   private final int state;
/*    */   
/*    */   public PGM_BanTrade(long gmRoleId, int itemIdOrpetCfgId, int tradeType, int state)
/*    */   {
/* 18 */     this.gmRoleId = gmRoleId;
/* 19 */     this.itemIdOrpetCfgId = itemIdOrpetCfgId;
/* 20 */     this.tradeType = tradeType;
/* 21 */     this.state = state;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String nameString = "";
/* 29 */     if (ItemInterface.isItemExist(this.itemIdOrpetCfgId))
/*    */     {
/* 31 */       nameString = ItemInterface.getItemName(this.itemIdOrpetCfgId);
/*    */     }
/*    */     else {
/* 34 */       nameString = PetInterface.getPetName(this.itemIdOrpetCfgId);
/*    */     }
/*    */     
/* 37 */     if (this.state == 0)
/*    */     {
/* 39 */       ItemBanTrade.getInstance().banTrade(this.tradeType, this.itemIdOrpetCfgId);
/*    */       
/* 41 */       ItemBanTrade.getInstance().sendTipToTole(this.gmRoleId, nameString);
/*    */     }
/*    */     else
/*    */     {
/* 45 */       ItemBanTrade.getInstance().unBanTrade(this.tradeType, this.itemIdOrpetCfgId);
/* 46 */       SGMMessageTipRes msg = new SGMMessageTipRes();
/* 47 */       msg.result = Integer.MAX_VALUE;
/* 48 */       msg.args.add(String.format("%s 已经解除禁止", new Object[] { nameString }));
/* 49 */       OnlineManager.getInstance().sendAtOnce(this.gmRoleId, msg);
/*    */     }
/*    */     
/*    */ 
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_BanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */