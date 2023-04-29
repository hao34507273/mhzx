/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.item.confbean.EquipSkillWeight;
/*     */ import mzm.gsp.item.confbean.SEquipSkillCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Item;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_AddEquip
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long gmRoleId;
/*     */   private final long roleid;
/*     */   private final int itemid;
/*     */   private final int skillid;
/*     */   
/*     */   public PGM_AddEquip(long gmRoleId, long roleid, int itemid, int skillid)
/*     */   {
/*  30 */     this.gmRoleId = gmRoleId;
/*  31 */     this.roleid = roleid;
/*  32 */     this.itemid = itemid;
/*  33 */     this.skillid = skillid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (this.skillid != -1)
/*     */     {
/*  41 */       SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(this.itemid);
/*     */       
/*  43 */       if (sItemEquipCfg == null)
/*     */       {
/*  45 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("物品%d不是装备，增加失败", new Object[] { Integer.valueOf(this.itemid) }));
/*  46 */         return false;
/*     */       }
/*  48 */       SEquipSkillCfg cfg = SEquipSkillCfg.get(sItemEquipCfg.skillid);
/*  49 */       if ((cfg == null) || (cfg.skills.isEmpty()))
/*     */       {
/*  51 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("技能id[%d]不是该装备合法的技能id，增加失败", new Object[] { Integer.valueOf(this.skillid) }));
/*  52 */         return false;
/*     */       }
/*  54 */       boolean isSkillAvailable = false;
/*     */       
/*  56 */       for (EquipSkillWeight weight : cfg.skills)
/*     */       {
/*  58 */         if (weight.skillid == this.skillid)
/*     */         {
/*  60 */           isSkillAvailable = true;
/*  61 */           break;
/*     */         }
/*     */       }
/*  64 */       if (!isSkillAvailable)
/*     */       {
/*  66 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("技能id[%d]不是该装备合法的技能id，增加失败", new Object[] { Integer.valueOf(this.skillid) }));
/*  67 */         return false;
/*     */       }
/*     */     }
/*  70 */     if (ItemInterface.isEquipItem(this.itemid))
/*     */     {
/*  72 */       List<Item> xItems = ItemManager.createXItem(this.itemid, 1);
/*  73 */       if ((xItems == null) || (xItems.isEmpty()))
/*     */       {
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       if (this.skillid == -1)
/*     */       {
/*  80 */         ItemManager.randomEquipSkill((Item)xItems.get(0));
/*     */       }
/*     */       else
/*     */       {
/*  84 */         ((Item)xItems.get(0)).getExtra().put(Integer.valueOf(6), Integer.valueOf(this.skillid));
/*     */       }
/*     */       
/*  87 */       TLogArg logArg = new TLogArg(LogReason.GM_ADD);
/*  88 */       ItemOperateResult result = ItemInterface.addItemActive(this.roleid, xItems, false, true, logArg);
/*  89 */       if (result.success())
/*     */       {
/*  91 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d增加特技装备%d成功", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid) }));
/*  92 */         return true;
/*     */       }
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("物品%d不是装备，增加失败", new Object[] { Integer.valueOf(this.itemid) }));
/*     */     
/*     */ 
/*     */ 
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_AddEquip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */