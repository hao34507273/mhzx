/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SChangeFashionDressPropertySuccess;
/*     */ import mzm.gsp.fashiondress.SFashionDressNormalFailed;
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
/*     */ public class PCChangeFashionDressProperty extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int oldFashionDressCfgId;
/*     */   private final int newFashionDressCfgId;
/*     */   
/*     */   public PCChangeFashionDressProperty(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/*  34 */     this.roleId = paramLong;
/*  35 */     this.oldFashionDressCfgId = paramInt1;
/*  36 */     this.newFashionDressCfgId = paramInt2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if ((this.oldFashionDressCfgId <= 0) || (this.newFashionDressCfgId <= 0) || (this.newFashionDressCfgId == this.oldFashionDressCfgId)) {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCExtendFashionDressTime.processImp", true, true)) {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCExtendFashionDressTime.processImp", true)) {
/*  49 */       return false;
/*     */     }
/*  51 */     String str = RoleInterface.getUserId(this.roleId);
/*  52 */     lock(Lockeys.get(User.getTable(), str));
/*  53 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 971, true, true)) {
/*  54 */       return false;
/*     */     }
/*  56 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleId));
/*  57 */     if (localRole2FashionDressInfo == null)
/*     */     {
/*  59 */       onChangeFashionDressPropertyFail(5);
/*  60 */       return false;
/*     */     }
/*  62 */     Map localMap = localRole2FashionDressInfo.getFashion_dress_map();
/*  63 */     if (!localMap.containsKey(Integer.valueOf(this.oldFashionDressCfgId)))
/*     */     {
/*  65 */       onChangeFashionDressPropertyFail(1);
/*  66 */       return false;
/*     */     }
/*  68 */     if (!localMap.containsKey(Integer.valueOf(this.newFashionDressCfgId)))
/*     */     {
/*  70 */       onChangeFashionDressPropertyFail(2);
/*  71 */       return false;
/*     */     }
/*  73 */     SFashionDressCfg localSFashionDressCfg = SFashionDressCfg.get(this.newFashionDressCfgId);
/*  74 */     if (localSFashionDressCfg == null)
/*     */     {
/*  76 */       onChangeFashionDressPropertyFail(6);
/*  77 */       return false;
/*     */     }
/*  79 */     if (localSFashionDressCfg.propertySkillList.isEmpty())
/*     */     {
/*  81 */       onChangeFashionDressPropertyFail(3);
/*  82 */       return false;
/*     */     }
/*  84 */     Set localSet = localRole2FashionDressInfo.getActivate_property_set();
/*  85 */     if (!localSet.contains(Integer.valueOf(this.oldFashionDressCfgId)))
/*     */     {
/*  87 */       onChangeFashionDressPropertyFail(3);
/*  88 */       return false;
/*     */     }
/*  90 */     if (localSet.contains(Integer.valueOf(this.newFashionDressCfgId)))
/*     */     {
/*  92 */       onChangeFashionDressPropertyFail(8);
/*  93 */       return false;
/*     */     }
/*  95 */     localSet.remove(Integer.valueOf(this.oldFashionDressCfgId));
/*  96 */     localSet.add(Integer.valueOf(this.newFashionDressCfgId));
/*     */     
/*  98 */     boolean bool = changeTransferOccupationFashionDressProperty(localRole2FashionDressInfo);
/*  99 */     if (!bool) {
/* 100 */       return false;
/*     */     }
/* 102 */     SChangeFashionDressPropertySuccess localSChangeFashionDressPropertySuccess = new SChangeFashionDressPropertySuccess();
/* 103 */     localSChangeFashionDressPropertySuccess.old_fashion_dress_cfg_id = this.oldFashionDressCfgId;
/* 104 */     localSChangeFashionDressPropertySuccess.new_fashion_dress_cfg_id = this.newFashionDressCfgId;
/*     */     
/* 106 */     OnlineManager.getInstance().send(this.roleId, localSChangeFashionDressPropertySuccess);
/*     */     
/* 108 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(this.roleId));
/*     */     
/* 110 */     GameServer.logger().info(String.format("[fashiondress]PCChangeFashionDressProperty.processImp@handle change fashion dress property success|role_id=%d|old_fashion_drss_cfg_id=%d|new_fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.oldFashionDressCfgId), Integer.valueOf(this.newFashionDressCfgId) }));
/*     */     
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   private boolean changeTransferOccupationFashionDressProperty(Role2FashionDressInfo paramRole2FashionDressInfo)
/*     */   {
/* 117 */     Map localMap1 = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 118 */     if (localMap1.isEmpty()) {
/* 119 */       return true;
/*     */     }
/* 121 */     int i = RoleInterface.getGender(this.roleId);
/* 122 */     for (Map.Entry localEntry : localMap1.entrySet())
/*     */     {
/* 124 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 125 */       if (j > 100)
/*     */       {
/* 127 */         i = j % 100;
/* 128 */         j /= 100;
/*     */       }
/* 130 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/*     */       
/* 132 */       int k = FashionDressManager.getNewOccupationFashionDress(this.oldFashionDressCfgId, j, i);
/*     */       
/* 134 */       int m = FashionDressManager.getNewOccupationFashionDress(this.newFashionDressCfgId, j, i);
/*     */       
/* 136 */       Map localMap2 = localTransferOccupationFashionDress.getFashion_dress_map();
/* 137 */       if ((k <= 0) || (m <= 0) || (!localMap2.containsKey(Integer.valueOf(k))) || (!localMap2.containsKey(Integer.valueOf(m))))
/*     */       {
/* 139 */         localObject = new HashMap();
/* 140 */         ((Map)localObject).put("new_occupation", Integer.valueOf(j));
/* 141 */         ((Map)localObject).put("new_occupation_old_fashion_dress_cfg_id", Integer.valueOf(k));
/* 142 */         ((Map)localObject).put("new_occupation_new_fashion_dress_cfg_id", Integer.valueOf(m));
/* 143 */         ((Map)localObject).put("contain_fashion_dress_cfg_id", localMap2.keySet().toString());
/*     */         
/* 145 */         onChangeFashionDressPropertyFail(16, (Map)localObject);
/*     */         
/* 147 */         return false;
/*     */       }
/* 149 */       Object localObject = localTransferOccupationFashionDress.getActivate_property_set();
/* 150 */       ((Set)localObject).remove(Integer.valueOf(k));
/* 151 */       ((Set)localObject).add(Integer.valueOf(m));
/*     */     }
/* 153 */     return true;
/*     */   }
/*     */   
/*     */   private void onChangeFashionDressPropertyFail(int paramInt)
/*     */   {
/* 158 */     onChangeFashionDressPropertyFail(paramInt, null);
/*     */   }
/*     */   
/*     */   private void onChangeFashionDressPropertyFail(int paramInt, Map<String, Object> paramMap)
/*     */   {
/* 163 */     StringBuilder localStringBuilder = new StringBuilder();
/* 164 */     localStringBuilder.append("[fashiondress]PCChangeFashionDressProperty.processImp@change fashion dress property failed");
/* 165 */     localStringBuilder.append("|ret=").append(paramInt);
/* 166 */     localStringBuilder.append("|role_id=").append(this.roleId);
/* 167 */     localStringBuilder.append("|old_fashion_dress_cfg_id=").append(this.oldFashionDressCfgId);
/* 168 */     localStringBuilder.append("|new_fashion_dress_cfg_id=").append(this.newFashionDressCfgId);
/* 169 */     if ((paramMap != null) && (!paramMap.isEmpty())) {
/* 170 */       for (localObject = paramMap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 171 */         localStringBuilder.append('|').append((String)localEntry.getKey()).append('=').append(localEntry.getValue());
/*     */       }
/*     */     }
/* 174 */     GameServer.logger().error(localStringBuilder.toString());
/*     */     
/* 176 */     Object localObject = new SFashionDressNormalFailed();
/* 177 */     ((SFashionDressNormalFailed)localObject).result = paramInt;
/*     */     
/* 179 */     OnlineManager.getInstance().sendAtOnce(this.roleId, (Protocol)localObject);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCChangeFashionDressProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */