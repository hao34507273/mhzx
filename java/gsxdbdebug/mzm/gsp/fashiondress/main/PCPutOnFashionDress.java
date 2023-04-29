/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SFashionDressNormalFailed;
/*     */ import mzm.gsp.fashiondress.SPutOnFashionDressSuccess;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FashionDressInfo;
/*     */ import xbean.Role2FashionDressInfo;
/*     */ import xbean.TransferOccupationFashionDress;
/*     */ import xdb.Lockeys;
/*     */ import xio.Protocol;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCPutOnFashionDress extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fashionDressCfgId;
/*     */   
/*     */   public PCPutOnFashionDress(long paramLong, int paramInt)
/*     */   {
/*  30 */     this.roleId = paramLong;
/*  31 */     this.fashionDressCfgId = paramInt;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCPutOnFashionDress.processImp", true, true)) {
/*  38 */       return false;
/*     */     }
/*  40 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCPutOnFashionDress.processImp", true)) {
/*  41 */       return false;
/*     */     }
/*  43 */     String str = RoleInterface.getUserId(this.roleId);
/*  44 */     lock(Lockeys.get(User.getTable(), str));
/*     */     
/*  46 */     Role2FashionDressInfo localRole2FashionDressInfo = xtable.Role2fashiondress.get(Long.valueOf(this.roleId));
/*  47 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 974, true, true)) {
/*  48 */       return false;
/*     */     }
/*  50 */     if (localRole2FashionDressInfo == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[fashiondress]PCPutOnFashionDress.processImp@role fashion dress info is null|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  54 */       return false;
/*     */     }
/*  56 */     Map localMap = localRole2FashionDressInfo.getFashion_dress_map();
/*     */     
/*  58 */     FashionDressInfo localFashionDressInfo = (FashionDressInfo)localMap.get(Integer.valueOf(this.fashionDressCfgId));
/*  59 */     if (localFashionDressInfo == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[fashiondress]PCPutOnFashionDress.processImp@role fashion dress info not exist,may be expired|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  63 */       return false;
/*     */     }
/*  65 */     if (!SFashionDressCfg.getAll().containsKey(Integer.valueOf(this.fashionDressCfgId)))
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[fashiondress]PCPutOnFashionDress.processImp@fashion dress cfg not exist|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  69 */       return false;
/*     */     }
/*  71 */     int i = localRole2FashionDressInfo.getCurrent_fashion_dress_cfg_id();
/*  72 */     if (i == this.fashionDressCfgId)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[fashiondress]PCPutOnFashionDress.processImp@switch fashion dress info is same|role_id=%d|fashion_dress_cfg_id=%d|current_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(i) }));
/*     */       
/*  76 */       return false;
/*     */     }
/*  78 */     localRole2FashionDressInfo.setCurrent_fashion_dress_cfg_id(this.fashionDressCfgId);
/*     */     
/*  80 */     FashionDressInterface.changeRoleClothAndModel(this.roleId, this.fashionDressCfgId);
/*     */     
/*  82 */     boolean bool = putOnTransferOccupationFashionDress(localRole2FashionDressInfo);
/*  83 */     if (!bool) {
/*  84 */       return false;
/*     */     }
/*  86 */     SPutOnFashionDressSuccess localSPutOnFashionDressSuccess = new SPutOnFashionDressSuccess();
/*  87 */     localSPutOnFashionDressSuccess.fashiondresscfgid = this.fashionDressCfgId;
/*     */     
/*  89 */     OnlineManager.getInstance().send(this.roleId, localSPutOnFashionDressSuccess);
/*     */     
/*  91 */     FashionDressManager.tlogFashionDressOperator(str, this.roleId, this.fashionDressCfgId, FashionDressTLogEnum.PUT_ON);
/*     */     
/*  93 */     GameServer.logger().info(String.format("[fashiondress]PCPutOnFashionDress.processImp@put on fashion dress info success|role_id=%d|fashion_dress_cfg_id=%d|old_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), Integer.valueOf(i) }));
/*     */     
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   private boolean putOnTransferOccupationFashionDress(Role2FashionDressInfo paramRole2FashionDressInfo)
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
/* 117 */       if (!localMap2.containsKey(Integer.valueOf(k)))
/*     */       {
/* 119 */         HashMap localHashMap = new HashMap();
/* 120 */         localHashMap.put("new_occupation", Integer.valueOf(j));
/* 121 */         localHashMap.put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/* 122 */         localHashMap.put("new_occupation_fashion_dress_cfg_list", localMap2.keySet().toString());
/*     */         
/* 124 */         onPutOnFashionDressFail(17, localHashMap);
/*     */       }
/*     */       else
/*     */       {
/* 128 */         localTransferOccupationFashionDress.setCurrent_fashion_dress_cfg_id(k);
/*     */       }
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   private void onPutOnFashionDressFail(int paramInt, Map<String, ?> paramMap)
/*     */   {
/* 136 */     StringBuilder localStringBuilder = new StringBuilder();
/* 137 */     localStringBuilder.append("[fashiondress]PCExtendFashionDressTime.processImp@put on fashion dress failed");
/* 138 */     localStringBuilder.append("|ret=").append(paramInt);
/* 139 */     localStringBuilder.append("|role_id=").append(this.roleId);
/* 140 */     localStringBuilder.append("|fashion_dress_cfg_id=").append(this.fashionDressCfgId);
/* 141 */     if ((paramMap != null) && (!paramMap.isEmpty())) {
/* 142 */       for (localObject = paramMap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 143 */         localStringBuilder.append('|').append((String)localEntry.getKey()).append('=').append(localEntry.getValue());
/*     */       }
/*     */     }
/* 146 */     GameServer.logger().error(localStringBuilder.toString());
/*     */     
/* 148 */     Object localObject = new SFashionDressNormalFailed();
/* 149 */     ((SFashionDressNormalFailed)localObject).result = paramInt;
/*     */     
/* 151 */     OnlineManager.getInstance().sendAtOnce(this.roleId, (Protocol)localObject);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCPutOnFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */