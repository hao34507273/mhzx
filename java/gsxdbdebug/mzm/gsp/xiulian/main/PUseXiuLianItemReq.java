/*    */ package mzm.gsp.xiulian.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.confbean.SXiuLianExpItem;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleXiuLian;
/*    */ import xtable.Role2xiulianskill;
/*    */ 
/*    */ 
/*    */ public class PUseXiuLianItemReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int itemKey;
/*    */   private final boolean isUseAll;
/*    */   private final int skillBagId;
/*    */   
/*    */   public PUseXiuLianItemReq(long roleId, int itemKey, boolean isUseAll, int skillBagId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.itemKey = itemKey;
/* 26 */     this.isUseAll = isUseAll;
/* 27 */     this.skillBagId = skillBagId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!XiuLianSkillManager.isXiuLianSwitchOpenForRole(this.roleId))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     BasicItem item = ItemInterface.getItem(this.roleId, 340600000, this.itemKey);
/* 39 */     if (item == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     SXiuLianExpItem sXiuLianExpItem = SXiuLianExpItem.get(item.getCfgId());
/* 44 */     if (sXiuLianExpItem == null)
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(this.roleId));
/* 50 */     if (xRoleXiuLian == null)
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xRoleXiuLian.getSkillmap().get(Integer.valueOf(this.skillBagId));
/* 55 */     if (xXiuLianSkill == null)
/*    */     {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     XiuLianSkill xiuLianSkill = new XiuLianSkill(this.roleId, this.skillBagId, xXiuLianSkill);
/* 61 */     int levelUpNeedExp = xiuLianSkill.getLevelUpNeedExp() - xXiuLianSkill.getExp();
/* 62 */     if (levelUpNeedExp <= 0)
/*    */     {
/* 64 */       return false;
/*    */     }
/*    */     
/*    */     int useNum;
/* 68 */     if (this.isUseAll)
/*    */     {
/* 70 */       int eachAddEep = sXiuLianExpItem.addExpNum;
/* 71 */       int needNum = (int)Math.ceil(levelUpNeedExp * 1.0D / eachAddEep);
/* 72 */       int useNum = item.getNumber();
/* 73 */       if (useNum > needNum)
/*    */       {
/* 75 */         useNum = needNum;
/*    */       }
/* 77 */       ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), useNum, new TLogArg(LogReason.XIULIAN_SKILL_USE_ITEM_REM, item.getCfgId()));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 82 */       useNum = 1;
/* 83 */       ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), 1, new TLogArg(LogReason.XIULIAN_SKILL_USE_ITEM_REM, item.getCfgId()));
/*    */     }
/*    */     
/*    */ 
/* 87 */     XiuLianSkillInterface.addXiuLianExp(this.roleId, this.skillBagId, sXiuLianExpItem.addExpNum * useNum, new TLogArg(LogReason.XIULIAN_SKILL_USE_ITEM_REM, item.getCfgId()));
/*    */     
/*    */ 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\PUseXiuLianItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */