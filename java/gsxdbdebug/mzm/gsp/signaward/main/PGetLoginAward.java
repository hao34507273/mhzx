/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.signaward.confbean.ItemId2Count;
/*     */ import mzm.gsp.signaward.confbean.SLoginAward;
/*     */ import mzm.gsp.signaward.confbean.SignAwardCfgConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetLoginAward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int daycount;
/*     */   
/*     */   public PGetLoginAward(long roleid, int daycount)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.daycount = daycount;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!SignAwardManager.isLoginAwardSwitchOpenForRole(this.roleid))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (!SignAwardManager.isRoleStateCanGetAward(this.roleid))
/*     */     {
/*  46 */       String logstr = String.format("[sign]PGetLoginAward.processImp@role state can not get award|roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.roleid) });
/*     */       
/*  48 */       SignAwardManager.logger.info(logstr);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     String userid = RoleInterface.getUserId(this.roleid);
/*  53 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  55 */     int level = RoleInterface.getLevel(this.roleid);
/*  56 */     if (level < SignAwardCfgConsts.getInstance().GET_LOGIN_AWARD_LEVEL)
/*     */     {
/*  58 */       String logstr = String.format("[loginaward]PGetLoginAward.processImp@role level error|userid=%s|roleid=%d|level=%d|cangetlevel=%d|daycount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(level), Integer.valueOf(SignAwardCfgConsts.getInstance().GET_LOGIN_AWARD_LEVEL), Integer.valueOf(this.daycount) });
/*     */       
/*     */ 
/*  61 */       SignAwardManager.logger.info(logstr);
/*  62 */       SignAwardManager.sendErrorProtocal(this.roleid, 4);
/*  63 */       return false;
/*     */     }
/*  65 */     int loginday = SignAwardManager.getLoginDay(this.roleid);
/*  66 */     if (this.daycount > loginday)
/*     */     {
/*  68 */       String logstr = String.format("[loginaward]PGetLoginAward.processImp@loginday error|userid=%s|roleid=%d|daycount=%d|roleloginday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.daycount), Integer.valueOf(loginday) });
/*     */       
/*     */ 
/*  71 */       SignAwardManager.logger.info(logstr);
/*  72 */       SignAwardManager.sendErrorProtocal(this.roleid, 3);
/*  73 */       return false;
/*     */     }
/*  75 */     List<Integer> awards = SignAwardManager.getLoginAward(this.roleid);
/*  76 */     if (awards.contains(Integer.valueOf(this.daycount)))
/*     */     {
/*  78 */       String logstr = String.format("[loginaward]PGetLoginAward.processImp@already get loginday award|userid=%s|roleid=%d|daycount=%d|awarddays=%s", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.daycount), awards.toString() });
/*     */       
/*     */ 
/*  81 */       SignAwardManager.logger.info(logstr);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     boolean ret = SignAwardManager.addLoginAward(this.roleid, this.daycount);
/*  86 */     if (ret)
/*     */     {
/*  88 */       Map<Integer, Integer> itemid2countMap = new HashMap();
/*  89 */       Map<Integer, Integer> itemid2countbindMap = new HashMap();
/*  90 */       Map<Integer, Integer> giftbagrewardid2count = new HashMap();
/*  91 */       SLoginAward sLoginAward = SignAwardManager.getSLoginAward(this.daycount);
/*  92 */       if (sLoginAward == null)
/*     */       {
/*  94 */         String logstr = String.format("[loginaward]PGetLoginAward.processImp@loginday award error,null|userid=%s|roleid=%d|daycount=%d|roleloginday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.daycount), Integer.valueOf(loginday) });
/*     */         
/*     */ 
/*  97 */         SignAwardManager.logger.info(logstr);
/*  98 */         return false;
/*     */       }
/* 100 */       for (ItemId2Count id2Count : sLoginAward.itemIdCountList)
/*     */       {
/* 102 */         if (id2Count.itemcount > 0)
/*     */         {
/*     */ 
/*     */ 
/* 106 */           int rewardid = ItemInterface.getGiftbagItemRewardId(id2Count.itemid);
/* 107 */           boolean isDirectlyUse = ItemInterface.isDirectlyUseGiftbagItem(id2Count.itemid);
/* 108 */           if ((!isDirectlyUse) || (rewardid == -1))
/*     */           {
/* 110 */             if (ItemInterface.isItemFromShanghuiOrBaitan(id2Count.itemid))
/*     */             {
/* 112 */               itemid2countbindMap.put(Integer.valueOf(id2Count.itemid), Integer.valueOf(id2Count.itemcount));
/*     */             }
/*     */             else
/*     */             {
/* 116 */               itemid2countMap.put(Integer.valueOf(id2Count.itemid), Integer.valueOf(id2Count.itemcount));
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*     */           else {
/* 122 */             giftbagrewardid2count.put(Integer.valueOf(rewardid), Integer.valueOf(id2Count.itemcount));
/*     */           }
/*     */         }
/*     */       }
/* 126 */       Map<Integer, Integer> itemMap = new HashMap();
/*     */       
/* 128 */       TLogArg logArg = new TLogArg(LogReason.LOGING_ADD, sLoginAward.id);
/* 129 */       ItemOperateResult result = null;
/* 130 */       if (itemid2countMap.size() > 0)
/*     */       {
/* 132 */         result = ItemInterface.addItemWithNoMail(this.roleid, itemid2countMap, false, logArg);
/* 133 */         if (!result.success())
/*     */         {
/* 135 */           ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 136 */           return false;
/*     */         }
/* 138 */         itemMap.putAll(result.getItemChangeMap());
/*     */       }
/* 140 */       if (itemid2countbindMap.size() > 0)
/*     */       {
/* 142 */         result = ItemInterface.addItemWithNoMail(this.roleid, itemid2countbindMap, true, logArg);
/* 143 */         if (!result.success())
/*     */         {
/* 145 */           ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 146 */           return false;
/*     */         }
/* 148 */         itemMap.putAll(result.getItemChangeMap());
/*     */       }
/* 150 */       for (Iterator i$ = giftbagrewardid2count.keySet().iterator(); i$.hasNext();) { int rewardid = ((Integer)i$.next()).intValue();
/*     */         
/* 152 */         for (int i = 0; i < ((Integer)giftbagrewardid2count.get(Integer.valueOf(rewardid))).intValue(); i++)
/*     */         {
/* 154 */           boolean r = SignAwardManager.useGiftbag(userid, this.roleid, rewardid, logArg);
/* 155 */           if (!r)
/*     */           {
/* 157 */             String logstr = String.format("[loginaward]PGetLoginAward.processImp@reward error|userid=%s|roleid=%d|level=%d|loginday=%d|rewardid=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(level), Integer.valueOf(loginday), Integer.valueOf(rewardid) });
/*     */             
/*     */ 
/* 160 */             SignAwardManager.logger.error(logstr);
/* 161 */             return false;
/*     */           }
/*     */         }
/*     */       }
/* 165 */       SignAwardManager.triggerLoginAwardEvent(this.roleid, this.daycount);
/*     */       
/* 167 */       SignAwardManager.sendSLoginAwardRes(this.roleid, itemMap);
/* 168 */       SignAwardManager.tlogLoginAward(this.roleid, sLoginAward.id, this.daycount);
/* 169 */       return true;
/*     */     }
/* 171 */     String logstr = String.format("[loginaward]PGetLoginAward.processImp@should not to here,xbean.LoginAward null|userid=%s|roleid=%d|daycount=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.daycount) });
/*     */     
/*     */ 
/* 174 */     SignAwardManager.logger.error(logstr);
/* 175 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PGetLoginAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */