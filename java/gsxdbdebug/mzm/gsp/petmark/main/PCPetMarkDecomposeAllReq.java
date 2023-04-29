/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RolePetMarkBag;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SPetMarkDecomposeAllFail;
/*     */ import mzm.gsp.petmark.SPetMarkDecomposeAllSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkItemCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelBean;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCPetMarkDecomposeAllReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final List<Integer> decomposeQualities;
/*     */   private final int decomposeMaxLevel;
/*     */   
/*     */   public PCPetMarkDecomposeAllReq(long roleId, List<Integer> decomposeQualities, int decomposeMaxLevel)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.decomposeQualities = decomposeQualities;
/*  42 */     this.decomposeMaxLevel = decomposeMaxLevel;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  51 */       String logstr = String.format("[petmark]PCPetMarkDecomposeAllReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  53 */       GameServer.logger().info(logstr);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2139, true))
/*     */     {
/*  60 */       String logstr = String.format("[petmark]PCPetMarkDecomposeAllReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  62 */       GameServer.logger().info(logstr);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  69 */       onFail(-1);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     List<Integer> validQualities = new ArrayList(6);
/*  75 */     validQualities.add(Integer.valueOf(0));
/*  76 */     validQualities.add(Integer.valueOf(1));
/*  77 */     validQualities.add(Integer.valueOf(2));
/*  78 */     validQualities.add(Integer.valueOf(3));
/*  79 */     validQualities.add(Integer.valueOf(4));
/*  80 */     if (!validQualities.containsAll(this.decomposeQualities))
/*     */     {
/*  82 */       onFail(-5);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*     */     
/*     */ 
/*  90 */     List<Long> costPetMarkIds = new LinkedList();
/*  91 */     Map<Integer, Integer> costItemCfgId2Num = new HashMap();
/*  92 */     Map<Integer, Integer> addTokenType2Num = new HashMap(4);
/*     */     
/*  94 */     for (Map.Entry<Long, PetMarkInfo> entry : xRole2PetMarkInfo.getPetmarkid2info().entrySet())
/*     */     {
/*  96 */       PetMarkInfo xPetMarkInfo = (PetMarkInfo)entry.getValue();
/*  97 */       int petMarkCfgId = xPetMarkInfo.getPet_mark_cfg_id();
/*  98 */       SPetMarkCfg sPetMarkCfg = SPetMarkCfg.get(petMarkCfgId);
/*     */       
/* 100 */       if ((xPetMarkInfo.getPet_id() <= 0L) && (xPetMarkInfo.getLevel() <= this.decomposeMaxLevel) && (this.decomposeQualities.contains(Integer.valueOf(sPetMarkCfg.quality))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */         costPetMarkIds.add(entry.getKey());
/* 107 */         int petMarkLevel = xPetMarkInfo.getLevel();
/* 108 */         SPetMarkLevelBean levelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(petMarkCfgId).level2Bean.get(Integer.valueOf(petMarkLevel));
/* 109 */         Integer oldNum = (Integer)addTokenType2Num.get(Integer.valueOf(levelBean.smeltScoreType));
/* 110 */         if (null != oldNum)
/*     */         {
/* 112 */           addTokenType2Num.put(Integer.valueOf(levelBean.smeltScoreType), Integer.valueOf(oldNum.intValue() + levelBean.smeltScore));
/*     */         }
/*     */         else
/*     */         {
/* 116 */           addTokenType2Num.put(Integer.valueOf(levelBean.smeltScoreType), Integer.valueOf(levelBean.smeltScore));
/*     */         }
/*     */       }
/*     */     }
/* 120 */     RolePetMarkBag rolePetMarkItemBag = ItemInterface.getRolePetMarkBag(this.roleId);
/* 121 */     if (null != rolePetMarkItemBag)
/*     */     {
/* 123 */       for (BasicItem item : rolePetMarkItemBag.getAllItems(false).values())
/*     */       {
/* 125 */         int petMarkItemCfgId = item.getCfgId();
/* 126 */         SPetMarkItemCfg sPetMarkItemCfg = SPetMarkItemCfg.get(petMarkItemCfgId);
/* 127 */         if (null != sPetMarkItemCfg)
/*     */         {
/*     */ 
/*     */ 
/* 131 */           SPetMarkCfg sPetMarkCfg = SPetMarkCfg.get(sPetMarkItemCfg.petMarkCfgId);
/* 132 */           if ((sPetMarkItemCfg.level <= this.decomposeMaxLevel) && (this.decomposeQualities.contains(Integer.valueOf(sPetMarkCfg.quality))))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 137 */             int itemNum = item.getNumber();
/* 138 */             Integer oldItemNum = (Integer)costItemCfgId2Num.get(Integer.valueOf(item.getCfgId()));
/* 139 */             if (null != oldItemNum)
/*     */             {
/* 141 */               costItemCfgId2Num.put(Integer.valueOf(item.getCfgId()), Integer.valueOf(oldItemNum.intValue() + itemNum));
/*     */             }
/*     */             else
/*     */             {
/* 145 */               costItemCfgId2Num.put(Integer.valueOf(item.getCfgId()), Integer.valueOf(itemNum));
/*     */             }
/*     */             
/* 148 */             Integer oldTokenNum = (Integer)addTokenType2Num.get(Integer.valueOf(sPetMarkItemCfg.smeltScoreType));
/* 149 */             if (null != oldTokenNum)
/*     */             {
/* 151 */               addTokenType2Num.put(Integer.valueOf(sPetMarkItemCfg.smeltScoreType), Integer.valueOf(oldTokenNum.intValue() + sPetMarkItemCfg.smeltScore * itemNum));
/*     */             }
/*     */             else
/*     */             {
/* 155 */               addTokenType2Num.put(Integer.valueOf(sPetMarkItemCfg.smeltScoreType), Integer.valueOf(sPetMarkItemCfg.smeltScore * itemNum));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 161 */     if (addTokenType2Num.isEmpty())
/*     */     {
/* 163 */       onFail(-2);
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 168 */     for (Iterator i$ = costPetMarkIds.iterator(); i$.hasNext();) { long costPetMarkId = ((Long)i$.next()).longValue();
/*     */       
/* 170 */       PetMarkManager.removePetMark(this.roleId, costPetMarkId, xRole2PetMarkInfo, PetMarkManager.RemovePetMarkReason.DECOMPOSE);
/*     */     }
/* 172 */     if (!costItemCfgId2Num.isEmpty())
/*     */     {
/* 174 */       TLogArg tlogArg = new TLogArg(LogReason.PET_MARK_DECOMPOSE_COST);
/* 175 */       ItemOperateResult res = ItemInterface.removeItemById(this.roleId, costItemCfgId2Num, tlogArg);
/* 176 */       if (!res.success())
/*     */       {
/* 178 */         onFail(-4);
/* 179 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 184 */     TLogArg tlogArg = new TLogArg(LogReason.PET_MARK_DECOMPOSE_ADD);
/* 185 */     for (Map.Entry<Integer, Integer> entry : addTokenType2Num.entrySet())
/*     */     {
/* 187 */       JifenOperateResult res = MallInterface.addJifen(this.roleId, ((Integer)entry.getValue()).intValue(), ((Integer)entry.getKey()).intValue(), true, tlogArg);
/* 188 */       if (!res.isSuccess())
/*     */       {
/* 190 */         onFail(-3);
/* 191 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 196 */     onSuccess(addTokenType2Num, costPetMarkIds, costItemCfgId2Num);
/*     */     
/* 198 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSuccess(Map<Integer, Integer> addTokenType2Num, List<Long> costPetMarkIds, Map<Integer, Integer> costItemCfgId2Num)
/*     */   {
/* 205 */     SPetMarkDecomposeAllSuccess proto = new SPetMarkDecomposeAllSuccess();
/* 206 */     proto.get_score_map.putAll(addTokenType2Num);
/* 207 */     proto.cost_item_map.putAll(costItemCfgId2Num);
/* 208 */     proto.cost_pet_mark_ids.addAll(costPetMarkIds);
/* 209 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 212 */     String logstr = String.format("[petmark]PCPetMarkDecomposeAllReq.onSuccess@PCPetMarkDecomposeAllReq success|roleId=%d,get_score_map=%s,cost_item_map=%s,cost_pet_mark_ids=%s", new Object[] { Long.valueOf(this.roleId), addTokenType2Num, costPetMarkIds, costItemCfgId2Num });
/*     */     
/*     */ 
/* 215 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 218 */     PetMarkTLogManager.addPetMarkDecomposeTLog(this.roleId, addTokenType2Num);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 224 */     SPetMarkDecomposeAllFail proto = new SPetMarkDecomposeAllFail();
/* 225 */     proto.error_code = errorCode;
/* 226 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 229 */     String logstr = String.format("[petmark]PCPetMarkDecomposeAllReq.onFail@PCPetMarkDecomposeAllReq failed|roleId=%d,decomposeQualities=%s,decomposeMaxLevel=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), this.decomposeQualities, Integer.valueOf(this.decomposeMaxLevel), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 232 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkDecomposeAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */