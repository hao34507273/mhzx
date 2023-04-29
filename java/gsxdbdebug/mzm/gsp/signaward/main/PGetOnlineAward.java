/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.signaward.confbean.ItemId2Count;
/*     */ import mzm.gsp.signaward.confbean.SOnlineAward;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OnlineAward;
/*     */ import xtable.Role2onlineaward;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGetOnlineAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int time;
/*     */   
/*     */   public PGetOnlineAward(long roleid, int time)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.time = time;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!SignAwardManager.isOnlineAwardSwitchOpenForRole(this.roleid))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!SignAwardManager.isRoleStateCanGetAward(this.roleid))
/*     */     {
/*  40 */       String logstr = String.format("[sign]PGetOnlineAward.processImp@role state can not get award|roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.roleid) });
/*     */       
/*  42 */       SignAwardManager.logger.info(logstr);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  47 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*     */     
/*  49 */     OnlineAward xOnlineAward = Role2onlineaward.get(Long.valueOf(this.roleid));
/*  50 */     if (xOnlineAward == null)
/*     */     {
/*  52 */       String logstr = String.format("[onlineaward]PGetOnlineAward.processImp@xOnlineAward null|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(this.roleid) });
/*     */       
/*  54 */       SignAwardManager.logger.error(logstr);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     List<Integer> awards = xOnlineAward.getOnlineawardlist();
/*  59 */     if (awards.contains(Integer.valueOf(this.time)))
/*     */     {
/*  61 */       String logstr = String.format("[onlineaward]PGetOnlineAward.processImp@role already get online time award|userid=%s|roleid=%d|time=%d|awardtimes=%s", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.time), awards.toString() });
/*     */       
/*     */ 
/*  64 */       SignAwardManager.logger.info(logstr);
/*  65 */       SignAwardManager.sendErrorProtocal(this.roleid, 7);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (xOnlineAward.getOnlinetime() < this.time)
/*     */     {
/*  71 */       String logstr = String.format("[onlineaward]PGetOnlineAward.processImp@role online time not enough|userid=%s|roleid=%d|time=%d|roleonlinetime=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.time), Long.valueOf(xOnlineAward.getOnlinetime()) });
/*     */       
/*     */ 
/*  74 */       SignAwardManager.logger.error(logstr);
/*  75 */       SignAwardManager.sendErrorProtocal(this.roleid, 8);
/*  76 */       return false;
/*     */     }
/*  78 */     xOnlineAward.getOnlineawardlist().add(Integer.valueOf(this.time));
/*     */     
/*  80 */     SOnlineAward onlineAward = SOnlineAward.get((int)TimeUnit.SECONDS.toMinutes(this.time));
/*  81 */     if ((onlineAward == null) || (onlineAward.itemIdCountList.isEmpty()))
/*     */     {
/*  83 */       String logstr = String.format("[onlineaward]PGetOnlineAward.processImp@online award error,empty|userid=%s|roleid=%d|time=%d|roleonlinetime=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.time), Long.valueOf(xOnlineAward.getOnlinetime()) });
/*     */       
/*     */ 
/*  86 */       SignAwardManager.logger.error(logstr);
/*  87 */       return false;
/*     */     }
/*  89 */     Map<Integer, Integer> itemid2countMap = new HashMap();
/*  90 */     Map<Integer, Integer> itemid2countbindMap = new HashMap();
/*     */     
/*  92 */     Map<Integer, Integer> giftbagrewardid2count = new HashMap();
/*     */     
/*  94 */     for (ItemId2Count id2Count : onlineAward.itemIdCountList)
/*     */     {
/*  96 */       if (id2Count.itemcount > 0)
/*     */       {
/*     */ 
/*     */ 
/* 100 */         int rewardid = ItemInterface.getGiftbagItemRewardId(id2Count.itemid);
/* 101 */         boolean isDirectlyUse = ItemInterface.isDirectlyUseGiftbagItem(id2Count.itemid);
/* 102 */         if ((!isDirectlyUse) || (rewardid == -1))
/*     */         {
/* 104 */           if (ItemInterface.isItemFromShanghuiOrBaitan(id2Count.itemid))
/*     */           {
/* 106 */             itemid2countbindMap.put(Integer.valueOf(id2Count.itemid), Integer.valueOf(id2Count.itemcount));
/*     */           }
/*     */           else
/*     */           {
/* 110 */             itemid2countMap.put(Integer.valueOf(id2Count.itemid), Integer.valueOf(id2Count.itemcount));
/*     */           }
/*     */           
/*     */         }
/*     */         else {
/* 115 */           giftbagrewardid2count.put(Integer.valueOf(rewardid), Integer.valueOf(id2Count.itemcount));
/*     */         }
/*     */       }
/*     */     }
/* 119 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.ONLINE_AWARD_ADD, onlineAward.id);
/* 120 */     Map<Integer, Integer> itemMap = new HashMap();
/* 121 */     ItemOperateResult result = null;
/* 122 */     if (itemid2countMap.size() > 0)
/*     */     {
/* 124 */       result = ItemInterface.addItemWithNoMail(this.roleid, itemid2countMap, false, logArg);
/* 125 */       if (!result.success())
/*     */       {
/* 127 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 128 */         return false;
/*     */       }
/* 130 */       itemMap.putAll(result.getItemChangeMap());
/*     */     }
/* 132 */     if (itemid2countbindMap.size() > 0)
/*     */     {
/* 134 */       result = ItemInterface.addItemWithNoMail(this.roleid, itemid2countbindMap, true, logArg);
/* 135 */       if (!result.success())
/*     */       {
/* 137 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 138 */         return false;
/*     */       }
/* 140 */       itemMap.putAll(result.getItemChangeMap());
/*     */     }
/* 142 */     for (Iterator i$ = giftbagrewardid2count.keySet().iterator(); i$.hasNext();) { int rewardid = ((Integer)i$.next()).intValue();
/*     */       
/* 144 */       for (int i = 0; i < ((Integer)giftbagrewardid2count.get(Integer.valueOf(rewardid))).intValue(); i++)
/*     */       {
/* 146 */         boolean r = SignAwardManager.useGiftbag(userid, this.roleid, rewardid, logArg);
/* 147 */         if (!r)
/*     */         {
/* 149 */           String logstr = String.format("[onlineaward]PGetOnlineAward.processImp@reward error|userid=%s|roleid=%d|time=%d|roleonlinetime=%d|reward=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.time), Long.valueOf(xOnlineAward.getOnlinetime()), Integer.valueOf(rewardid) });
/*     */           
/*     */ 
/* 152 */           SignAwardManager.logger.error(logstr);
/* 153 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 157 */     SignAwardManager.sendSSynAwardedRes(this.roleid, xOnlineAward, itemMap);
/* 158 */     SignAwardManager.tlogOnlineAward(this.roleid, onlineAward.id, onlineAward.time);
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PGetOnlineAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */