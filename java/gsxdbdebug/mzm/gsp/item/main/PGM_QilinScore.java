/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.confbean.SEquipQiLinCfg;
/*    */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*    */ import mzm.gsp.skill.main.SkillInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_QilinScore
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int wearpos;
/*    */   private final int score;
/*    */   
/*    */   public PGM_QilinScore(long gmRoleid, long roleid, int wearpos, int score)
/*    */   {
/* 22 */     this.gmRoleid = gmRoleid;
/* 23 */     this.roleid = roleid;
/* 24 */     this.wearpos = wearpos;
/* 25 */     this.score = score;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(this.roleid);
/* 33 */     EquipmentItem equipmentItem = (EquipmentItem)equipBag.get(this.wearpos);
/* 34 */     if (equipmentItem == null)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家 [%d]的没有穿戴该准备", new Object[] { Long.valueOf(this.roleid) }));
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     if (this.score != -1)
/*    */     {
/* 43 */       equipmentItem.setExtra(ItemStoreEnum.QILING_SCORE, this.score);
/*    */     }
/* 45 */     SItemEquipCfg equipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/*    */     
/* 47 */     SEquipQiLinCfg equipQiLingCfg = ItemConfigManager.getSEquipQiLin(equipCfg.qilinTypeid, equipmentItem.getStrengthLevel() + 1);
/*    */     
/* 49 */     if (equipQiLingCfg == null)
/*    */     {
/* 51 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("没有找到对应得启灵配置", new Object[0]));
/* 52 */       return false;
/*    */     }
/* 54 */     int initSuccessProb = equipQiLingCfg.sucRate;
/* 55 */     int successProb = initSuccessProb;
/*    */     
/*    */ 
/* 58 */     int addProp = SkillInterface.getQiLingAddRateWithSkills(FashionDressInterface.getFashionDressPassiveSkillMap(this.roleid, false));
/*    */     
/* 60 */     successProb += addProp;
/*    */     
/*    */ 
/* 63 */     int qilingScoreRate = 0;
/* 64 */     Integer qilingScore = equipmentItem.getExtra(ItemStoreEnum.QILING_SCORE);
/* 65 */     if (qilingScore != null)
/*    */     {
/* 67 */       qilingScoreRate = qilingScore.intValue() * equipQiLingCfg.score2rate;
/*    */     }
/* 69 */     successProb += qilingScoreRate;
/* 70 */     if (successProb > 10000)
/*    */     {
/* 72 */       successProb = 10000;
/*    */     }
/*    */     
/* 75 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家 [%d]该准备当前启灵成功率为 %d,基础值%d,失败积分值%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(successProb), Integer.valueOf(initSuccessProb), Integer.valueOf(qilingScoreRate) }));
/*    */     
/*    */ 
/*    */ 
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_QilinScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */