/*     */ package mzm.gsp.fashiondress.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.SFashionDressNormalFailed;
/*     */ import mzm.gsp.fashiondress.SSelectPropertySuccess;
/*     */ import mzm.gsp.fashiondress.confbean.FashionDressConsts;
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
/*     */ public class PCSelectProperty extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int fashionDressCfgId;
/*     */   
/*     */   public PCSelectProperty(long paramLong, int paramInt)
/*     */   {
/*  33 */     this.roleId = paramLong;
/*  34 */     this.fashionDressCfgId = paramInt;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!FashionDressManager.isFashionDressSwitchOpen(this.roleId, "PCSelectProperty.processImp", true, true)) {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!FashionDressManager.isLevelOpen(this.roleId, "PCSelectProperty.processImp", true)) {
/*  44 */       return false;
/*     */     }
/*  46 */     String str = RoleInterface.getUserId(this.roleId);
/*  47 */     lock(Lockeys.get(User.getTable(), str));
/*  48 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 975, true, true)) {
/*  49 */       return false;
/*     */     }
/*  51 */     Role2FashionDressInfo localRole2FashionDressInfo = Role2fashiondress.get(Long.valueOf(this.roleId));
/*  52 */     if (localRole2FashionDressInfo == null)
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[fashiondress]PCSelectProperty.processImp@role fashion info is null|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  56 */       return false;
/*     */     }
/*  58 */     SFashionDressCfg localSFashionDressCfg = (SFashionDressCfg)SFashionDressCfg.getAll().get(Integer.valueOf(this.fashionDressCfgId));
/*  59 */     if (localSFashionDressCfg == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[fashiondress]PCSelectProperty.processImp@fashion dress not exist in cfg|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  63 */       return false;
/*     */     }
/*  65 */     if (!localRole2FashionDressInfo.getFashion_dress_map().containsKey(Integer.valueOf(this.fashionDressCfgId)))
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[fashiondress]PCSelectProperty.processImp@role fashion dress info not exist,may be expired|role_id=%d|fashion_dress_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId) }));
/*     */       
/*  69 */       return false;
/*     */     }
/*  71 */     Set localSet = localRole2FashionDressInfo.getActivate_property_set();
/*  72 */     if (localSet.size() >= FashionDressConsts.getInstance().maxUsePropertyNum)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[fashiondress]PCSelectProperty.processImp@activate property set is over flow|role_id=%d|fashion_dress_cfg_id=%d|activate_property_set=%s|activate_size=%d|activate_limit=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), localSet.toString(), Integer.valueOf(localSet.size()), Integer.valueOf(FashionDressConsts.getInstance().maxUsePropertyNum) }));
/*     */       
/*  76 */       return false;
/*     */     }
/*  78 */     if (localSet.contains(Integer.valueOf(this.fashionDressCfgId)))
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[fashiondress]PCSelectProperty.processImp@activate property set aleardy contains this fashion dress cfg id|role_id=%d|fashion_dress_cfg_id=%d|activate_property_set=%s|activate_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), localSet.toString(), Integer.valueOf(localSet.size()) }));
/*     */       
/*  82 */       return false;
/*     */     }
/*  84 */     localSet.add(Integer.valueOf(this.fashionDressCfgId));
/*     */     
/*  86 */     selectTransferOccupationProperty(localRole2FashionDressInfo);
/*     */     
/*  88 */     FashionDressManager.triggerPassiveSkillChangeEvent(new PassiveSkillChangeArg(this.roleId));
/*     */     
/*  90 */     SSelectPropertySuccess localSSelectPropertySuccess = new SSelectPropertySuccess();
/*  91 */     localSSelectPropertySuccess.fashiondresscfgid = this.fashionDressCfgId;
/*     */     
/*  93 */     OnlineManager.getInstance().send(this.roleId, localSSelectPropertySuccess);
/*     */     
/*  95 */     GameServer.logger().info(String.format("[fashiondress]PCSelectProperty.processImp@select property success|role_id=%d|fashion_dress_cfg_id=%d|now_activate_property=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.fashionDressCfgId), localSet.toString() }));
/*     */     
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private boolean selectTransferOccupationProperty(Role2FashionDressInfo paramRole2FashionDressInfo)
/*     */   {
/* 102 */     Map localMap = paramRole2FashionDressInfo.getTransfer_occupation_fashion_dress_map();
/* 103 */     if (localMap.isEmpty()) {
/* 104 */       return true;
/*     */     }
/* 106 */     int i = RoleInterface.getGender(this.roleId);
/* 107 */     for (Map.Entry localEntry : localMap.entrySet())
/*     */     {
/* 109 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 110 */       if (j > 100)
/*     */       {
/* 112 */         i = j % 100;
/* 113 */         j /= 100;
/*     */       }
/*     */       
/* 116 */       TransferOccupationFashionDress localTransferOccupationFashionDress = (TransferOccupationFashionDress)localEntry.getValue();
/* 117 */       int k = FashionDressManager.getNewOccupationFashionDress(this.fashionDressCfgId, j, i);
/* 118 */       if (k <= 0)
/*     */       {
/* 120 */         localObject = new HashMap();
/* 121 */         ((Map)localObject).put("new_occupation", Integer.valueOf(j));
/* 122 */         ((Map)localObject).put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/*     */         
/* 124 */         onSelectFashionDressPropertyFail(13, (Map)localObject);
/* 125 */         return false;
/*     */       }
/* 127 */       Object localObject = localTransferOccupationFashionDress.getFashion_dress_map();
/* 128 */       if (!((Map)localObject).containsKey(Integer.valueOf(k)))
/*     */       {
/* 130 */         HashMap localHashMap = new HashMap();
/* 131 */         localHashMap.put("new_occupation", Integer.valueOf(j));
/* 132 */         localHashMap.put("new_fashion_dress_cfg_id", Integer.valueOf(k));
/* 133 */         localHashMap.put("new_occupation_fashion_dress_list", ((Map)localObject).keySet().toString());
/*     */         
/* 135 */         onSelectFashionDressPropertyFail(13, localHashMap);
/* 136 */         return false;
/*     */       }
/* 138 */       localTransferOccupationFashionDress.getActivate_property_set().add(Integer.valueOf(k));
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   private void onSelectFashionDressPropertyFail(int paramInt, Map<String, ?> paramMap)
/*     */   {
/* 145 */     StringBuilder localStringBuilder = new StringBuilder();
/* 146 */     localStringBuilder.append("[fashiondress]PCSelectProperty.processImp@select fashion dress property failed");
/* 147 */     localStringBuilder.append("|ret=").append(paramInt);
/* 148 */     localStringBuilder.append("|role_id=").append(this.roleId);
/* 149 */     localStringBuilder.append("|fashion_dress_cfg_id=").append(this.fashionDressCfgId);
/* 150 */     if ((paramMap != null) && (!paramMap.isEmpty())) {
/* 151 */       for (localObject = paramMap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 152 */         localStringBuilder.append('|').append((String)localEntry.getKey()).append('=').append(localEntry.getValue());
/*     */       }
/*     */     }
/* 155 */     GameServer.logger().error(localStringBuilder.toString());
/*     */     
/* 157 */     Object localObject = new SFashionDressNormalFailed();
/* 158 */     ((SFashionDressNormalFailed)localObject).result = paramInt;
/*     */     
/* 160 */     OnlineManager.getInstance().sendAtOnce(this.roleId, (Protocol)localObject);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PCSelectProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */