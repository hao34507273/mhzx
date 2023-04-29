/*     */ package mzm.gsp.active.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.active.SActiveNormalResult;
/*     */ import mzm.gsp.active.STakeActiveAwardRes;
/*     */ import mzm.gsp.activity.confbean.SActiveAwardBean;
/*     */ import mzm.gsp.activity.confbean.SActiviteAwardCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Active;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2active;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCTakeActiveAward extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int awardIndexId;
/*     */   private int rolelevel;
/*     */   
/*     */   public PCTakeActiveAward(long roleid, int awardIndexId)
/*     */   {
/*  34 */     this.roleId = roleid;
/*  35 */     this.awardIndexId = awardIndexId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 571, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     String userId = RoleInterface.getUserId(this.roleId);
/*  47 */     lock(Lockeys.get(User.getTable(), userId));
/*  48 */     this.rolelevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  50 */     TreeMap<Integer, SActiviteAwardCfg> sActiviteAwardCfgMap = (TreeMap)SActiviteAwardCfg.getAll();
/*  51 */     Map.Entry<Integer, SActiviteAwardCfg> entry = sActiviteAwardCfgMap.floorEntry(Integer.valueOf(this.rolelevel));
/*  52 */     if (entry == null)
/*     */     {
/*  54 */       onTakeActiveAwardFailed(7);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     SActiviteAwardCfg sActiviteAwardCfg = (SActiviteAwardCfg)entry.getValue();
/*     */     
/*  60 */     SActiveAwardBean sActiveAwardBean = (SActiveAwardBean)sActiviteAwardCfg.active_award_map.get(Integer.valueOf(this.awardIndexId));
/*  61 */     if (sActiveAwardBean == null)
/*     */     {
/*  63 */       onTakeActiveAwardFailed(8);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     int activeValue = ActiveInterface.getTotalActiveValue(this.roleId);
/*  68 */     if (activeValue < sActiveAwardBean.active_value)
/*     */     {
/*  70 */       Map<String, Object> extraMap = new HashMap();
/*  71 */       extraMap.put("need_active_value", Integer.valueOf(sActiveAwardBean.active_value));
/*  72 */       extraMap.put("active_value", Integer.valueOf(activeValue));
/*     */       
/*  74 */       onTakeActiveAwardFailed(5, extraMap);
/*  75 */       return true;
/*     */     }
/*     */     
/*  78 */     Active xActive = Role2active.get(Long.valueOf(this.roleId));
/*  79 */     Set<Integer> xAleardyAwardIndexIdSet = xActive.getAward_index_id_set();
/*  80 */     if (xAleardyAwardIndexIdSet.contains(Integer.valueOf(this.awardIndexId)))
/*     */     {
/*  82 */       Map<String, Object> extraMap = new HashMap();
/*  83 */       extraMap.put("aleardy_award_index_id_set", xAleardyAwardIndexIdSet.toString());
/*     */       
/*  85 */       onTakeActiveAwardFailed(5, extraMap);
/*     */       
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     AwardReason awardReason = new AwardReason(LogReason.ACTIVE_AWARD_ITEM);
/*  91 */     if (sActiveAwardBean.is_bind == 1)
/*     */     {
/*  93 */       awardReason.setAwardItemBind(true);
/*     */     }
/*     */     
/*  96 */     AwardModel awardModule = AwardInterface.awardFixAward(sActiveAwardBean.award_id, userId, this.roleId, true, true, awardReason);
/*     */     
/*  98 */     if (awardModule == null)
/*     */     {
/* 100 */       Map<String, Object> extraMap = new HashMap();
/* 101 */       extraMap.put("award_id", Integer.valueOf(sActiveAwardBean.award_id));
/*     */       
/* 103 */       onTakeActiveAwardFailed(6, extraMap);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     xAleardyAwardIndexIdSet.add(Integer.valueOf(this.awardIndexId));
/*     */     
/* 109 */     STakeActiveAwardRes sTakeActiveAwardRes = new STakeActiveAwardRes();
/* 110 */     sTakeActiveAwardRes.index_id = this.awardIndexId;
/* 111 */     OnlineManager.getInstance().send(this.roleId, sTakeActiveAwardRes);
/*     */     
/* 113 */     GameServer.logger().info(String.format("[active]PCTakeActiveAward.processImp@take active award success|role_id=%d|award_index_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardIndexId) }));
/*     */     
/*     */ 
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   private void onTakeActiveAwardFailed(int ret)
/*     */   {
/* 121 */     onTakeActiveAwardFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onTakeActiveAwardFailed(int ret, Map<String, ?> extraMap)
/*     */   {
/* 126 */     StringBuilder sbLog = new StringBuilder();
/* 127 */     sbLog.append("[active]PCTakeActiveAward.processImp@get active award failed");
/* 128 */     sbLog.append("|ret=").append(ret);
/* 129 */     sbLog.append("|role_id=").append(this.roleId);
/* 130 */     sbLog.append("|award_index=").append(this.awardIndexId);
/* 131 */     sbLog.append("!role_level=").append(this.rolelevel);
/*     */     
/* 133 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 135 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 137 */         sbLog.append('|').append((String)entry.getKey()).append('|').append(entry.getValue());
/*     */       }
/*     */     }
/* 140 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 142 */     SActiveNormalResult activeNormalResult = new SActiveNormalResult();
/* 143 */     activeNormalResult.result = ret;
/*     */     
/* 145 */     OnlineManager.getInstance().sendAtOnce(this.roleId, activeNormalResult);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\PCTakeActiveAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */