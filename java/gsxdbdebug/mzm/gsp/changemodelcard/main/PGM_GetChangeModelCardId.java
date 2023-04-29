/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.ChangeModelCardInfo;
/*    */ import xbean.Role2ChangeModelCardInfo;
/*    */ import xtable.Role2changemodelcard;
/*    */ 
/*    */ public class PGM_GetChangeModelCardId extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int changeModelCardCfgId;
/*    */   private final int changeModelCardLevel;
/*    */   
/*    */   public PGM_GetChangeModelCardId(long roleId, int changeModelCardCfgId, int changeModelCardLevel)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.changeModelCardCfgId = changeModelCardCfgId;
/* 20 */     this.changeModelCardLevel = changeModelCardLevel;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Role2ChangeModelCardInfo xRole2CardInfo = Role2changemodelcard.get(Long.valueOf(this.roleId));
/* 27 */     if (null == xRole2CardInfo)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "roleId有误或玩家没有变身卡信息");
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     List<Long> cardIds = new java.util.LinkedList();
/* 34 */     for (Map.Entry<Long, ChangeModelCardInfo> entry : xRole2CardInfo.getCardid2info().entrySet())
/*    */     {
/*    */ 
/* 37 */       if (((this.changeModelCardCfgId == 0) || (this.changeModelCardCfgId == ((ChangeModelCardInfo)entry.getValue()).getCard_cfg_id())) && ((this.changeModelCardLevel == 0) || (this.changeModelCardLevel == ((ChangeModelCardInfo)entry.getValue()).getLevel())))
/*    */       {
/*    */ 
/* 40 */         cardIds.add(entry.getKey());
/*    */       }
/*    */     }
/*    */     
/* 44 */     if (cardIds.isEmpty())
/*    */     {
/* 46 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有符合要求的变身卡");
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("符合要求的变身卡Id有：%s", new Object[] { cardIds }));
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PGM_GetChangeModelCardId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */