/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.signaward.confbean.ItemId2Count;
/*     */ import mzm.gsp.signaward.confbean.SLevelmenpaisex2Award;
/*     */ import mzm.gsp.signaward.confbean.SignAwardCfgConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetLevelAward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int level;
/*     */   
/*     */   public PGetLevelAward(long roleid, int level)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.level = level;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!SignAwardManager.isLevelAwardSwitchOpenForRole(this.roleid))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!SignAwardManager.isRoleStateCanGetAward(this.roleid))
/*     */     {
/*  50 */       String logstr = String.format("[sign]PGetLevelAward.processImp@role state can not get award|roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.roleid) });
/*     */       
/*  52 */       SignAwardManager.logger.info(logstr);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userid = RoleInterface.getUserId(this.roleid);
/*  57 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  59 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*  60 */     if (this.level > roleLevel)
/*     */     {
/*  62 */       String logstr = String.format("[levelaward]PGetLevelAward.processImp@role level error|userid=%s|roleid=%d|level=%d|rolelevle=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.level), Integer.valueOf(roleLevel) });
/*     */       
/*     */ 
/*  65 */       SignAwardManager.logger.error(logstr);
/*  66 */       SignAwardManager.sendErrorProtocal(this.roleid, 4);
/*  67 */       return false;
/*     */     }
/*  69 */     List<Integer> awards = SignAwardManager.getLevelAwards(this.roleid);
/*  70 */     if (awards.contains(Integer.valueOf(this.level)))
/*     */     {
/*  72 */       String logstr = String.format("[levelaward]PGetLevelAward.processImp@already get level award|userid=%s|roleid=%d|level=%d|rolelevle=%d|awardlevels=%s", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.level), Integer.valueOf(roleLevel), awards.toString() });
/*     */       
/*     */ 
/*  75 */       SignAwardManager.logger.info(logstr);
/*  76 */       SignAwardManager.sendErrorProtocal(this.roleid, 6);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     boolean ret = SignAwardManager.addLevelAward(this.roleid, this.level);
/*     */     
/*  82 */     List<Item> xItems = new ArrayList();
/*     */     
/*  84 */     if (ret)
/*     */     {
/*  86 */       int ocp = RoleInterface.getOccupationId(this.roleid);
/*  87 */       int sex = RoleInterface.getGender(this.roleid);
/*  88 */       SLevelmenpaisex2Award levelUpAward = SignAwardManager.getSlevelUpAward(this.level, ocp, sex);
/*  89 */       if (levelUpAward == null)
/*     */       {
/*  91 */         String logstr = String.format("[levelaward]PGetLevelAward.processImp@level award error,null|userid=%s|roleid=%d|level=%d|rolelevle=%d|ocp=%d|sex=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.level), Integer.valueOf(roleLevel), Integer.valueOf(ocp), Integer.valueOf(sex) });
/*     */         
/*     */ 
/*  94 */         SignAwardManager.logger.error(logstr);
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       Map<Integer, Integer> giftbagrewardid2count = new HashMap();
/*     */       
/* 100 */       for (ItemId2Count id2Count : levelUpAward.itemIdCountList)
/*     */       {
/* 102 */         if (id2Count.itemcount > 0)
/*     */         {
/*     */ 
/*     */ 
/* 106 */           int rewardid = ItemInterface.getGiftbagItemRewardId(id2Count.itemid);
/* 107 */           boolean isDirectlyUse = ItemInterface.isDirectlyUseGiftbagItem(id2Count.itemid);
/* 108 */           if ((!isDirectlyUse) || (rewardid == -1))
/*     */           {
/*     */ 
/* 111 */             SItemEquipCfg equipCfg = SItemEquipCfg.get(id2Count.itemid);
/*     */             
/*     */ 
/* 114 */             if ((equipCfg != null) && (this.level <= SignAwardCfgConsts.getInstance().MAX_EQUIP_LEVEL))
/*     */             {
/* 116 */               Map<Integer, Integer> extraMap = new HashMap();
/* 117 */               extraMap.put(Integer.valueOf(ItemStoreEnum.EQUIP_FLAG.getStoreType()), Integer.valueOf(this.level));
/* 118 */               xItems.addAll(ItemInterface.createXItem(id2Count.itemid, id2Count.itemcount, extraMap, true));
/*     */             }
/*     */             else
/*     */             {
/* 122 */               boolean isbind = ItemInterface.isItemFromShanghuiOrBaitan(id2Count.itemid);
/* 123 */               xItems.addAll(ItemInterface.createXItem(id2Count.itemid, id2Count.itemcount, null, isbind));
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 130 */             giftbagrewardid2count.put(Integer.valueOf(rewardid), Integer.valueOf(id2Count.itemcount));
/*     */           }
/*     */         }
/*     */       }
/* 134 */       TLogArg logArg = new TLogArg(LogReason.LEVEL_UP_ADD, levelUpAward.id);
/* 135 */       Map<Integer, Integer> itemMap = null;
/* 136 */       if (xItems.size() > 0)
/*     */       {
/* 138 */         ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, new TLogArg(LogReason.LEVEL_UP_ADD, levelUpAward.id));
/*     */         
/* 140 */         if (result.isBagFull())
/*     */         {
/* 142 */           ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 143 */           return false;
/*     */         }
/* 145 */         itemMap = result.getItemChangeMap();
/*     */       }
/* 147 */       for (Iterator i$ = giftbagrewardid2count.keySet().iterator(); i$.hasNext();) { int rewardid = ((Integer)i$.next()).intValue();
/*     */         
/* 149 */         for (int i = 0; i < ((Integer)giftbagrewardid2count.get(Integer.valueOf(rewardid))).intValue(); i++)
/*     */         {
/* 151 */           boolean result = SignAwardManager.useGiftbag(userid, this.roleid, rewardid, logArg);
/* 152 */           if (!result)
/*     */           {
/* 154 */             String logstr = String.format("[levelaward]PGetLevelAward.processImp@reward error|userid=%s|roleid=%d|level=%d|rolelevel=%d|rewardid=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.level), Integer.valueOf(roleLevel), Integer.valueOf(rewardid) });
/*     */             
/*     */ 
/* 157 */             SignAwardManager.logger.error(logstr);
/* 158 */             return false;
/*     */           }
/*     */         }
/*     */       }
/* 162 */       SignAwardManager.sendSLevelAwardRes(this.roleid, itemMap);
/* 163 */       SignAwardManager.triggerLevelUpAwardEvent(this.roleid, this.level);
/* 164 */       SignAwardManager.tlogLevelAward(this.roleid, levelUpAward.id, this.level);
/* 165 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 169 */     String logstr = String.format("[levelaward]PGetLevelAward.processImp@should not to here,already get level award|userid=%s|roleid=%d|level=%d|rolelevel=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.level), Integer.valueOf(roleLevel) });
/*     */     
/*     */ 
/* 172 */     SignAwardManager.logger.error(logstr);
/* 173 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PGetLevelAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */