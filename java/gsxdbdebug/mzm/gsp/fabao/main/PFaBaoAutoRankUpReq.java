/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fabao.CostInfo;
/*     */ import mzm.gsp.fabao.SFaBaoAutoRankUpErrorRes;
/*     */ import mzm.gsp.fabao.SFaBaoAutoRankUpRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoNextSkillCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoRankCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoSkillCfg;
/*     */ import mzm.gsp.item.confbean.SFaBaoNextRankId;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PFaBaoAutoRankUpReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int equiped;
/*     */   private final long fabaoUuid;
/*     */   private final int uptorank;
/*     */   private final Map<Integer, Map<Integer, Integer>> costkey2num;
/*     */   private final int useyuanbaonum;
/*     */   
/*     */   public PFaBaoAutoRankUpReq(long roleid, int equiped, long fabaoUuid, int uptorank, Map<Integer, CostInfo> bagid2costinfo, int useyuanbaonum)
/*     */   {
/*  46 */     this.roleId = roleid;
/*  47 */     this.equiped = equiped;
/*  48 */     this.fabaoUuid = fabaoUuid;
/*  49 */     this.uptorank = uptorank;
/*  50 */     this.useyuanbaonum = useyuanbaonum;
/*  51 */     this.costkey2num = new HashMap();
/*  52 */     for (Map.Entry<Integer, CostInfo> entry : bagid2costinfo.entrySet()) {
/*  53 */       if (((CostInfo)entry.getValue()).itemkey2num.size() > 0) {
/*  54 */         this.costkey2num.put(entry.getKey(), ((CostInfo)entry.getValue()).itemkey2num);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  62 */     if ((!OpenInterface.getOpenStatus(284)) || (OpenInterface.isBanPlay(this.roleId, 284)))
/*     */     {
/*     */ 
/*  65 */       OpenInterface.sendBanPlayMsg(this.roleId, 284);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  72 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1351, true))
/*     */     {
/*  74 */       sendErrorRes(10);
/*  75 */       return false;
/*     */     }
/*  77 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  79 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  81 */     lock(xtable.Bag.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  83 */     FabaoItem fabaoItem = null;
/*  84 */     if (this.equiped == 1)
/*     */     {
/*  86 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleId);
/*  87 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet())
/*     */       {
/*  89 */         Item xItem = (Item)entry.getValue();
/*  90 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaoUuid)))
/*     */         {
/*  92 */           fabaoItem = new FabaoItem(xItem);
/*  93 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  99 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, 340600006, this.fabaoUuid);
/* 100 */       if (!(basicItem instanceof FabaoItem))
/*     */       {
/* 102 */         sendErrorRes(2);
/* 103 */         return false;
/*     */       }
/* 105 */       fabaoItem = (FabaoItem)basicItem;
/*     */     }
/* 107 */     if (fabaoItem == null)
/*     */     {
/* 109 */       sendErrorRes(2);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     int rankRandomskillid = fabaoItem.getRankRandomSkillid();
/* 115 */     if (rankRandomskillid > 0)
/*     */     {
/* 117 */       sendErrorRes(9);
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     SFabaoRankCfg sFabaoRankCfg = null;
/* 123 */     SFabaoItem snextRankFabaoItem = null;
/* 124 */     int nextRankSkillid = fabaoItem.getOwnSkillId();
/*     */     
/*     */ 
/* 127 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/* 128 */     int times = this.uptorank - sFabaoItem.rank;
/*     */     
/* 130 */     if (times <= 0)
/*     */     {
/* 132 */       sendErrorRes(11);
/* 133 */       return false;
/*     */     }
/* 135 */     for (int i = 0; i < times; i++)
/*     */     {
/*     */ 
/* 138 */       SFaBaoNextRankId sFaBaoNextRankId = SFaBaoNextRankId.get(sFabaoItem.id);
/* 139 */       sFabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/* 140 */       snextRankFabaoItem = SFabaoItem.get(sFaBaoNextRankId.nextRankFabaoid);
/* 141 */       if ((sFabaoRankCfg == null) || (sFaBaoNextRankId == null) || (snextRankFabaoItem == null))
/*     */       {
/* 143 */         sendErrorRes(4);
/* 144 */         return false;
/*     */       }
/*     */       
/* 147 */       SFabaoNextSkillCfg fabaoNextSkillCfg = SFabaoNextSkillCfg.get(nextRankSkillid);
/* 148 */       if ((fabaoNextSkillCfg != null) && (fabaoNextSkillCfg.nextRankSkillid > 0))
/*     */       {
/* 150 */         nextRankSkillid = fabaoNextSkillCfg.nextRankSkillid;
/*     */       }
/*     */       
/* 153 */       sFabaoItem = snextRankFabaoItem;
/*     */     }
/*     */     
/* 156 */     SFabaoRankCfg sFabaoNextRankCfg = SFabaoRankCfg.get(snextRankFabaoItem.rankId);
/* 157 */     if ((sFabaoNextRankCfg == null) || (snextRankFabaoItem.rank != this.uptorank))
/*     */     {
/* 159 */       sendErrorRes(4);
/* 160 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 164 */     Map<Integer, Integer> itemCfg2num = new HashMap();
/* 165 */     if (!FabaoManager.checkAutoRankUpCost(this.roleId, fabaoItem, snextRankFabaoItem.id, this.useyuanbaonum, this.costkey2num, itemCfg2num))
/*     */     {
/*     */ 
/* 168 */       sendErrorRes(6);
/* 169 */       return false;
/*     */     }
/*     */     
/*     */     Iterator i$;
/* 173 */     if (this.costkey2num.size() > 0)
/*     */     {
/* 175 */       for (i$ = this.costkey2num.entrySet().iterator(); i$.hasNext();) { costEntry = (Map.Entry)i$.next();
/* 176 */         for (Map.Entry<Integer, Integer> entry : ((Map)costEntry.getValue()).entrySet())
/*     */         {
/* 178 */           if (!ItemInterface.removeItemByGrid(this.roleId, ((Integer)costEntry.getKey()).intValue(), ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue(), new TLogArg(LogReason.FABAO_AUTO_UPRANK)))
/*     */           {
/*     */ 
/* 181 */             sendErrorRes(6);
/* 182 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     Map.Entry<Integer, Map<Integer, Integer>> costEntry;
/* 188 */     if (this.useyuanbaonum > 0)
/*     */     {
/* 190 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, this.useyuanbaonum, CostType.COST_BIND_FABAO_AUTO_UPRANK, new TLogArg(LogReason.FABAO_AUTO_UPRANK));
/*     */       
/* 192 */       if (costResult != CostResult.Success)
/*     */       {
/* 194 */         sendErrorRes(7);
/* 195 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 199 */     SFabaoSkillCfg sFabaoSkillCfg = SFabaoSkillCfg.get(sFabaoNextRankCfg.skillLibId);
/* 200 */     int skillid = FabaoManager.randomSkill(sFabaoSkillCfg, Arrays.asList(new Integer[] { Integer.valueOf(nextRankSkillid) }));
/* 201 */     if (skillid <= 0)
/*     */     {
/* 203 */       sendErrorRes(1);
/* 204 */       GameServer.logger().error(String.format("[FaBao]PFaBaoAutoRankUpReq@|not exist uprank skill|skillLibId=%d", new Object[] { Integer.valueOf(sFabaoRankCfg.skillLibId) }));
/*     */       
/* 206 */       return false;
/*     */     }
/* 208 */     fabaoItem.setNextRankSkillid(nextRankSkillid);
/* 209 */     fabaoItem.setRankRandomSkillid(skillid);
/* 210 */     fabaoItem.setFaBaoAutoRankUpTo(snextRankFabaoItem.id);
/*     */     
/* 212 */     if (this.equiped == 1)
/*     */     {
/* 214 */       FabaoManager.onEquipFabaoChanged(this.roleId, fabaoItem, sFabaoItem);
/*     */     }
/*     */     
/* 217 */     SFaBaoAutoRankUpRes sFaBaoAutoRankUpRes = new SFaBaoAutoRankUpRes();
/* 218 */     sFaBaoAutoRankUpRes.equiped = this.equiped;
/* 219 */     sFaBaoAutoRankUpRes.fabaouuid = this.fabaoUuid;
/* 220 */     sFaBaoAutoRankUpRes.next_rank_skillid = nextRankSkillid;
/* 221 */     sFaBaoAutoRankUpRes.random_skillid = skillid;
/* 222 */     sFaBaoAutoRankUpRes.uptofabaocfgid = snextRankFabaoItem.id;
/* 223 */     OnlineManager.getInstance().send(this.roleId, sFaBaoAutoRankUpRes);
/*     */     
/*     */ 
/* 226 */     FabaoManager.tlogFaBaoAutoRankUp(this.roleId, fabaoItem.getFirstUuid().longValue(), fabaoItem.getCfgId(), sFabaoItem.rank, this.uptorank, fabaoItem.getRankExp(), this.useyuanbaonum, itemCfg2num);
/*     */     
/*     */ 
/* 229 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendErrorRes(int errorCode)
/*     */   {
/* 235 */     sendErrorRes(errorCode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendErrorRes(int errorCode, Map<String, Object> extraParams)
/*     */   {
/* 243 */     SFaBaoAutoRankUpErrorRes sFabaoUpRankErrorRes = new SFaBaoAutoRankUpErrorRes();
/* 244 */     sFabaoUpRankErrorRes.resultcode = errorCode;
/* 245 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFabaoUpRankErrorRes);
/*     */     
/* 247 */     StringBuffer logBuilder = new StringBuffer();
/* 248 */     logBuilder.append("[FaBao]PFaBaoAutoRankUpReq.onFailed@processImp() failed");
/* 249 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 250 */     logBuilder.append('|').append("fabaoUuid=").append(this.fabaoUuid);
/* 251 */     logBuilder.append('|').append("uptorank=").append(this.uptorank);
/* 252 */     logBuilder.append('|').append("error_code=").append(errorCode);
/*     */     
/* 254 */     if (extraParams != null)
/*     */     {
/* 256 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 258 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 262 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFaBaoAutoRankUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */