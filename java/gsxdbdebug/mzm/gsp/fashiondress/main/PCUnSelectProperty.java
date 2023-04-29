/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SFashionDressNormalFailed;
/*     */ import mzm.gsp.fashiondress.SUnSelectPropertySuccess;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.fashiondress.event.PassiveSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xdb.Lockeys;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2fashiondress;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUnSelectProperty extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fashionDressCfgId;
/*     */   
/*     */   public PCUnSelectProperty(long paramLong, int paramInt)
/*     */   {
/*  32 */     this.roleId = paramLong;
/*  33 */     this.fashionDressCfgId = paramInt;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!FashionDressManager.checkMutexStatus(this.roleId)) {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCUnSelectProperty.processImp", true, true)) {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCUnSelectProperty.processImp", true)) {
/*  46 */       return false;
/*     */     }
/*  48 */     String str = RoleInterface.getUserId(this.roleId);
/*  49 */     lock(Lockeys.get(User.getTable(), str));
/*  50 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 976, true, true)) {
/*  51 */       return false;
/*     */     }
/*  53 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleId));
/*  54 */     if (localRole2FashionDressInfo == null)
/*     */     {
/*  56 */       GameServer.logger().error(String.format("[fashiondress]PCUnSelectProperty.processImp@role fashion dress info is null|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  58 */       return false;
/*     */     }
/*  60 */     SFashionDressCfg localSFashionDressCfg = (SFashionDressCfg)SFashionDressCfg.getAll().get(Integer.valueOf(this.fashionDressCfgId));
/*  61 */     if (localSFashionDressCfg == null)
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[fashiondress]PCUnSelectProperty.processImp@fashion dress not exist in cfg|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  65 */       return false;
/*     */     }
/*  67 */     if (!localRole2FashionDressInfo.getFashion_dress_map().containsKey(Integer.valueOf(this.fashionDressCfgId)))
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[fashiondress]PCUnSelectProperty.processImp@role fashion dress info not exist,may be expired|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  71 */       return false;
/*     */     }
/*  73 */     Set localSet = localRole2FashionDressInfo.getActivate_property_set();
/*  74 */     if (!localSet.contains(Integer.valueOf(this.fashionDressCfgId)))
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[fashiondress]PCUnSelectProperty.processImp@activate property set not contains this fashion dress cfg id|role_id=%d|fashion_dress_cfg_id=%d|activate_property_set=%s|activate_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), localSet.toString(), Integer.valueOf(localSet.size()) }));
/*     */       
/*  78 */       return false;
/*     */     }
/*  80 */     localSet.remove(Integer.valueOf(this.fashionDressCfgId));
/*     */     
/*  82 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(this.roleId));
/*     */     
/*  84 */     boolean bool = unSelectTransferOccupationProperty(localRole2FashionDressInfo);
/*  85 */     if (!bool) {
/*  86 */       return false;
/*     */     }
/*  88 */     SUnSelectPropertySuccess localSUnSelectPropertySuccess = new SUnSelectPropertySuccess();
/*  89 */     localSUnSelectPropertySuccess.fashiondresscfgid = this.fashionDressCfgId;
/*     */     
/*  91 */     OnlineManager.getInstance().send(this.roleId, localSUnSelectPropertySuccess);
/*     */     
/*  93 */     GameServer.logger().info(String.format("[fashiondress]PCUnSelectProperty.processImp@un select property success|role_id=%d|fashion_dress_cfg_id=%d|now_activate_property=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), localSet.toString() }));
/*     */     
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   private boolean unSelectTransferOccupationProperty(Role2FashionDressInfo paramRole2FashionDressInfo)
/*     */   {
/* 100 */     Map localMap1 = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 101 */     if (localMap1.isEmpty()) {
/* 102 */       return true;
/*     */     }
/* 104 */     int i = RoleInterface.getGender(this.roleId);
/* 105 */     for (Map.Entry localEntry : localMap1.entrySet())
/*     */     {
/* 107 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 108 */       if (j > 100)
/*     */       {
/* 110 */         i = j % 100;
/* 111 */         j /= 100;
/*     */       }
/* 113 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 114 */       int k = FashionDressManager.getNewOccupationFashionDress(this.fashionDressCfgId, j, i);
/*     */       
/* 116 */       Map localMap2 = localTransferOccupationFashionDress.getFashion_dress_map();
/* 117 */       HashMap localHashMap; if (k <= 0)
/*     */       {
/* 119 */         localHashMap = new HashMap();
/* 120 */         localHashMap.put("new_occupation", Integer.valueOf(j));
/* 121 */         localHashMap.put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/*     */         
/* 123 */         onUnSelectFashionDressFail(13, localHashMap);
/* 124 */         return false;
/*     */       }
/* 126 */       if (!localMap2.containsKey(Integer.valueOf(k)))
/*     */       {
/* 128 */         localHashMap = new HashMap();
/* 129 */         localHashMap.put("new_occupation", Integer.valueOf(j));
/* 130 */         localHashMap.put("new_occupation_fashion_dress_cfg_list", localMap2.keySet().toString());
/*     */         
/* 132 */         onUnSelectFashionDressFail(17, localHashMap);
/* 133 */         return false;
/*     */       }
/* 135 */       localTransferOccupationFashionDress.getActivate_property_set().remove(Integer.valueOf(k));
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private void onUnSelectFashionDressFail(int paramInt, Map<String, ?> paramMap)
/*     */   {
/* 142 */     StringBuilder localStringBuilder = new StringBuilder();
/* 143 */     localStringBuilder.append("[fashiondress]PCUnSelectProperty.processImp@un select fashion dress failed");
/* 144 */     localStringBuilder.append("|ret=").append(paramInt);
/* 145 */     localStringBuilder.append("|role_id=").append(this.roleId);
/* 146 */     localStringBuilder.append("|fashion_dress_cfg_id=").append(this.fashionDressCfgId);
/* 147 */     if ((paramMap != null) && (!paramMap.isEmpty())) {
/* 148 */       for (localObject = paramMap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 149 */         localStringBuilder.append('|').append((String)localEntry.getKey()).append('=').append(localEntry.getValue());
/*     */       }
/*     */     }
/* 152 */     GameServer.logger().error(localStringBuilder.toString());
/*     */     
/* 154 */     Object localObject = new SFashionDressNormalFailed();
/* 155 */     ((SFashionDressNormalFailed)localObject).result = paramInt;
/*     */     
/* 157 */     OnlineManager.getInstance().sendAtOnce(this.roleId, (Protocol)localObject);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCUnSelectProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */