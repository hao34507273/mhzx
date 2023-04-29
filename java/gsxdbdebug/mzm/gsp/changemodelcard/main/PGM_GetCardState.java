/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Role2ChangeModelCardInfo;
/*    */ import xtable.Role2changemodelcard;
/*    */ 
/*    */ public class PGM_GetCardState extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetCardState(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     Role2ChangeModelCardInfo xRole2CardInfo = Role2changemodelcard.get(Long.valueOf(this.roleId));
/* 21 */     if (null == xRole2CardInfo)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "roleId有误或玩家没有变身卡信息");
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "未使用变身卡");
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     SCardLevelBean sCardLevelBean = ChangeModelCardCfgManager.getCardLevelCfg(xRole2CardInfo.getCurrent_card_cfg_id(), xRole2CardInfo.getCurrent_card_level());
/*    */     
/* 35 */     int overlayCount = xRole2CardInfo.getOverlay_count();
/* 36 */     long remainTimeMilliSec = xRole2CardInfo.getStart_time() + sCardLevelBean.effectPersistMinute * 60000L * overlayCount - mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 38 */     int remainPVPCount = sCardLevelBean.effectPersistPVPFight * overlayCount - xRole2CardInfo.getFight_count();
/*    */     
/* 40 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("当前叠加层数为%d，变身卡结束时间还有%d秒，当前还有%d场pvp场次可用", new Object[] { Integer.valueOf(overlayCount), Long.valueOf(remainTimeMilliSec / 1000L), Integer.valueOf(remainPVPCount) }));
/*    */     
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PGM_GetCardState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */