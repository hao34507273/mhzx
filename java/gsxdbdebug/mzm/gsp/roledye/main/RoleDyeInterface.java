/*     */ package mzm.gsp.roledye.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleInterface.DefaultColorInfo;
/*     */ import mzm.gsp.roledye.ColorIds;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ClothColor;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleClothes;
/*     */ import xbean.TransferOccupationRoleClothes;
/*     */ import xtable.Roleclothes;
/*     */ 
/*     */ public class RoleDyeInterface
/*     */ {
/*     */   public static boolean initRoleDefaultClothes(long paramLong, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  22 */     return RoleDyeManager.initRoleClothes(paramLong, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   public static ColorIds getRoleCurClothes(long paramLong)
/*     */   {
/*  27 */     return RoleDyeManager.getRoleCurClothes(paramLong);
/*     */   }
/*     */   
/*     */   public static ColorIds getRoleCurClothesNoLock(long paramLong)
/*     */   {
/*  32 */     return RoleDyeManager.getRoleCurClothesNoLock(paramLong);
/*     */   }
/*     */   
/*     */   public static void setRoleClothColor(long paramLong, int paramInt)
/*     */   {
/*  37 */     RoleDyeManager.setRoleClothColor(paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public static boolean activeNewOccupation(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/*  42 */     if (paramInt1 == paramInt2)
/*     */     {
/*  44 */       GameServer.logger().error(String.format("[roledye]RoleDyeInterface.activeNewOccupation@new occupation same with old occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/*  46 */       return false;
/*     */     }
/*  48 */     RoleClothes localRoleClothes = RoleDyeManager.getXRoleClothesIfNotExist(paramLong);
/*     */     
/*  50 */     int i = RoleInterface.getGender(paramLong);
/*  51 */     int j = paramInt1 * 100 + i;
/*  52 */     int k = paramInt2 * 100 + i;
/*     */     
/*  54 */     Map localMap1 = localRoleClothes.getTransfer_occupation_role_clothes();
/*  55 */     if ((localMap1.containsKey(Integer.valueOf(paramInt1))) || (localMap1.containsKey(Integer.valueOf(j))))
/*     */     {
/*  57 */       GameServer.logger().error(String.format("[roledye]RoleDyeInterface.activeNewOccupation@aleardy has new occupation role clothes|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/*  59 */       return false;
/*     */     }
/*  61 */     Map localMap2 = localRoleClothes.getFashion_dress_cloth_map();
/*     */     
/*  63 */     TransferOccupationRoleClothes localTransferOccupationRoleClothes = Pod.newTransferOccupationRoleClothes();
/*  64 */     localTransferOccupationRoleClothes.setCurid(localRoleClothes.getCurid());
/*  65 */     localTransferOccupationRoleClothes.setDefid(localRoleClothes.getDefid());
/*  66 */     localTransferOccupationRoleClothes.setMaxcount(localRoleClothes.getMaxcount());
/*  67 */     localTransferOccupationRoleClothes.setNextid(localRoleClothes.getNextid());
/*  68 */     for (Object localObject = localRoleClothes.getClothes().iterator(); ((Iterator)localObject).hasNext();) { ClothColor localClothColor = (ClothColor)((Iterator)localObject).next();
/*  69 */       localTransferOccupationRoleClothes.getClothes().add(localClothColor.copy());
/*     */     }
/*  71 */     localTransferOccupationRoleClothes.getFashion_dress_cloth_map().putAll(localRoleClothes.getFashion_dress_cloth_map());
/*     */     
/*  73 */     localMap1.put(Integer.valueOf(k), localTransferOccupationRoleClothes);
/*     */     
/*  75 */     localRoleClothes.setDefid(-1);
/*  76 */     localRoleClothes.setCurid(-1);
/*  77 */     localRoleClothes.setNextid(0);
/*  78 */     localRoleClothes.setMaxcount(10);
/*  79 */     localRoleClothes.getClothes().clear();
/*  80 */     localMap2.clear();
/*     */     
/*  82 */     localObject = RoleInterface.getRoleColorInfo(paramInt1, i);
/*  83 */     RoleDyeManager.addRoleClothesColor(localRoleClothes, ((RoleInterface.DefaultColorInfo)localObject).getHairColorId(), ((RoleInterface.DefaultColorInfo)localObject).getClothColorId(), -1);
/*     */     
/*  85 */     localRoleClothes.setDefid(0);
/*  86 */     localRoleClothes.setCurid(0);
/*     */     
/*  88 */     int m = FashionDressInterface.getWearFashionDress(paramLong, true);
/*  89 */     RoleDyeManager.setRoleClothColorChangeOccupation(paramLong, m, paramInt1, i);
/*     */     
/*  91 */     GameServer.logger().info(String.format("[roledye]RoleDyeInterface.activeNewOccupation@|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */     
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean switchOccupation(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/*  98 */     if (paramInt1 == paramInt2)
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[roledye]RoleDyeInterface.switchOccupation@new occupation same with old occupation|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 102 */       return false;
/*     */     }
/* 104 */     RoleClothes localRoleClothes = RoleDyeManager.getXRoleClothesIfNotExist(paramLong);
/*     */     
/* 106 */     int i = RoleInterface.getGender(paramLong);
/* 107 */     int j = paramInt1 * 100 + i;
/* 108 */     int k = paramInt2 * 100 + i;
/*     */     
/* 110 */     Map localMap = localRoleClothes.getTransfer_occupation_role_clothes();
/* 111 */     if (localMap.containsKey(Integer.valueOf(paramInt1)))
/*     */     {
/* 113 */       localTransferOccupationRoleClothes1 = (TransferOccupationRoleClothes)localMap.remove(Integer.valueOf(paramInt1));
/* 114 */       localMap.put(Integer.valueOf(j), localTransferOccupationRoleClothes1);
/*     */     }
/*     */     
/* 117 */     TransferOccupationRoleClothes localTransferOccupationRoleClothes1 = (TransferOccupationRoleClothes)localMap.remove(Integer.valueOf(j));
/* 118 */     if (localTransferOccupationRoleClothes1 == null)
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[roledye]RoleDyeInterface.switchOccupation@not has new occupation role dye|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */       
/* 122 */       return activeNewOccupation(paramLong, paramInt1, paramInt2);
/*     */     }
/* 124 */     TransferOccupationRoleClothes localTransferOccupationRoleClothes2 = Pod.newTransferOccupationRoleClothes();
/* 125 */     localTransferOccupationRoleClothes2.setCurid(localRoleClothes.getCurid());
/* 126 */     localTransferOccupationRoleClothes2.setDefid(localRoleClothes.getDefid());
/* 127 */     localTransferOccupationRoleClothes2.setMaxcount(localRoleClothes.getDefid());
/* 128 */     localTransferOccupationRoleClothes2.setNextid(localRoleClothes.getNextid());
/* 129 */     for (Iterator localIterator = localRoleClothes.getClothes().iterator(); localIterator.hasNext();) { localClothColor = (ClothColor)localIterator.next();
/* 130 */       localTransferOccupationRoleClothes2.getClothes().add(localClothColor.copy()); }
/*     */     ClothColor localClothColor;
/* 132 */     localTransferOccupationRoleClothes2.getFashion_dress_cloth_map().putAll(localRoleClothes.getFashion_dress_cloth_map());
/*     */     
/* 134 */     localMap.put(Integer.valueOf(k), localTransferOccupationRoleClothes2);
/*     */     
/* 136 */     localRoleClothes.setCurid(localTransferOccupationRoleClothes1.getCurid());
/* 137 */     localRoleClothes.setDefid(localTransferOccupationRoleClothes1.getDefid());
/* 138 */     localRoleClothes.setMaxcount(localTransferOccupationRoleClothes1.getMaxcount());
/* 139 */     localRoleClothes.setNextid(localTransferOccupationRoleClothes1.getNextid());
/*     */     
/* 141 */     localRoleClothes.getClothes().clear();
/* 142 */     localRoleClothes.getFashion_dress_cloth_map().clear();
/* 143 */     for (localIterator = localTransferOccupationRoleClothes1.getClothes().iterator(); localIterator.hasNext();) { localClothColor = (ClothColor)localIterator.next();
/* 144 */       localRoleClothes.getClothes().add(localClothColor.copy());
/*     */     }
/* 146 */     localRoleClothes.getFashion_dress_cloth_map().putAll(localTransferOccupationRoleClothes1.getFashion_dress_cloth_map());
/*     */     
/* 148 */     int m = FashionDressInterface.getWearFashionDress(paramLong, true);
/* 149 */     RoleDyeManager.setRoleClothColorChangeOccupation(paramLong, m, paramInt1, i);
/*     */     
/* 151 */     GameServer.logger().info(String.format("[roledye]RoleDyeInterface.switchOccupation@|role_id=%d|new_occupation=%d|old_occupation=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*     */     
/* 153 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean genderConvert(long paramLong, int paramInt1, int paramInt2)
/*     */   {
/* 158 */     int i = RoleInterface.getOccupationId(paramLong);
/* 159 */     int j = i * 100 + paramInt1;
/* 160 */     int k = i * 100 + paramInt2;
/*     */     
/* 162 */     RoleClothes localRoleClothes = RoleDyeManager.getXRoleClothesIfNotExist(paramLong);
/*     */     
/* 164 */     Map localMap = localRoleClothes.getTransfer_occupation_role_clothes();
/*     */     
/* 166 */     for (Object localObject1 = mzm.gsp.multioccupation.main.MultiOccupInterface.getOccupList(paramLong, false).iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Integer)((Iterator)localObject1).next();
/*     */       
/* 168 */       if (localMap.containsKey(Integer.valueOf(((Integer)localObject2).intValue())))
/*     */       {
/* 170 */         localObject3 = (TransferOccupationRoleClothes)localMap.remove(Integer.valueOf(((Integer)localObject2).intValue()));
/* 171 */         int n = ((Integer)localObject2).intValue() * 100 + paramInt2;
/* 172 */         localMap.put(Integer.valueOf(n), localObject3);
/*     */       } }
/*     */     Object localObject2;
/*     */     Object localObject3;
/* 176 */     if (!localMap.containsKey(Integer.valueOf(j)))
/*     */     {
/* 178 */       GameServer.logger().info(String.format("[roledye]RoleDyeInterface.genderConvert@|reset RoleClothes role_id=%d|occupation=%d|gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1) }));
/*     */       
/* 180 */       localObject1 = localRoleClothes.getFashion_dress_cloth_map();
/*     */       
/* 182 */       localObject2 = Pod.newTransferOccupationRoleClothes();
/* 183 */       ((TransferOccupationRoleClothes)localObject2).setCurid(localRoleClothes.getCurid());
/* 184 */       ((TransferOccupationRoleClothes)localObject2).setDefid(localRoleClothes.getDefid());
/* 185 */       ((TransferOccupationRoleClothes)localObject2).setMaxcount(localRoleClothes.getMaxcount());
/* 186 */       ((TransferOccupationRoleClothes)localObject2).setNextid(localRoleClothes.getNextid());
/* 187 */       for (localObject3 = localRoleClothes.getClothes().iterator(); ((Iterator)localObject3).hasNext();) { ClothColor localClothColor1 = (ClothColor)((Iterator)localObject3).next();
/* 188 */         ((TransferOccupationRoleClothes)localObject2).getClothes().add(localClothColor1.copy());
/*     */       }
/* 190 */       ((TransferOccupationRoleClothes)localObject2).getFashion_dress_cloth_map().putAll(localRoleClothes.getFashion_dress_cloth_map());
/*     */       
/* 192 */       localMap.put(Integer.valueOf(k), localObject2);
/*     */       
/* 194 */       localRoleClothes.setDefid(-1);
/* 195 */       localRoleClothes.setCurid(-1);
/* 196 */       localRoleClothes.setNextid(0);
/* 197 */       localRoleClothes.setMaxcount(10);
/* 198 */       localRoleClothes.getClothes().clear();
/* 199 */       ((Map)localObject1).clear();
/*     */       
/* 201 */       localObject3 = RoleInterface.getRoleColorInfo(i, paramInt1);
/* 202 */       RoleDyeManager.addRoleClothesColor(localRoleClothes, ((RoleInterface.DefaultColorInfo)localObject3).getHairColorId(), ((RoleInterface.DefaultColorInfo)localObject3).getClothColorId(), -1);
/*     */       
/* 204 */       localRoleClothes.setDefid(0);
/* 205 */       localRoleClothes.setCurid(0);
/*     */       
/* 207 */       int i1 = FashionDressInterface.getWearFashionDress(paramLong, true);
/* 208 */       RoleDyeManager.setRoleClothColorChangeOccupation(paramLong, i1, i, paramInt1);
/*     */     }
/*     */     else
/*     */     {
/* 212 */       GameServer.logger().info(String.format("[roledye]RoleDyeInterface.genderConvert@|exist RoleClothes role_id=%d|occupation=%d|gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1) }));
/*     */       
/* 214 */       localObject1 = (TransferOccupationRoleClothes)localMap.remove(Integer.valueOf(j));
/* 215 */       localObject2 = Pod.newTransferOccupationRoleClothes();
/* 216 */       ((TransferOccupationRoleClothes)localObject2).setCurid(localRoleClothes.getCurid());
/* 217 */       ((TransferOccupationRoleClothes)localObject2).setDefid(localRoleClothes.getDefid());
/* 218 */       ((TransferOccupationRoleClothes)localObject2).setMaxcount(localRoleClothes.getDefid());
/* 219 */       ((TransferOccupationRoleClothes)localObject2).setNextid(localRoleClothes.getNextid());
/* 220 */       for (localObject3 = localRoleClothes.getClothes().iterator(); ((Iterator)localObject3).hasNext();) { localClothColor2 = (ClothColor)((Iterator)localObject3).next();
/* 221 */         ((TransferOccupationRoleClothes)localObject2).getClothes().add(localClothColor2.copy()); }
/*     */       ClothColor localClothColor2;
/* 223 */       ((TransferOccupationRoleClothes)localObject2).getFashion_dress_cloth_map().putAll(localRoleClothes.getFashion_dress_cloth_map());
/*     */       
/* 225 */       localMap.put(Integer.valueOf(k), localObject2);
/*     */       
/* 227 */       localRoleClothes.setCurid(((TransferOccupationRoleClothes)localObject1).getCurid());
/* 228 */       localRoleClothes.setDefid(((TransferOccupationRoleClothes)localObject1).getDefid());
/* 229 */       localRoleClothes.setMaxcount(((TransferOccupationRoleClothes)localObject1).getMaxcount());
/* 230 */       localRoleClothes.setNextid(((TransferOccupationRoleClothes)localObject1).getNextid());
/*     */       
/* 232 */       localRoleClothes.getClothes().clear();
/* 233 */       localRoleClothes.getFashion_dress_cloth_map().clear();
/* 234 */       for (localObject3 = ((TransferOccupationRoleClothes)localObject1).getClothes().iterator(); ((Iterator)localObject3).hasNext();) { localClothColor2 = (ClothColor)((Iterator)localObject3).next();
/* 235 */         localRoleClothes.getClothes().add(localClothColor2.copy());
/*     */       }
/* 237 */       localRoleClothes.getFashion_dress_cloth_map().putAll(((TransferOccupationRoleClothes)localObject1).getFashion_dress_cloth_map());
/*     */       
/* 239 */       int m = FashionDressInterface.getWearFashionDress(paramLong, true);
/* 240 */       RoleDyeManager.setRoleClothColorChangeOccupation(paramLong, m, i, paramInt1);
/*     */     }
/*     */     
/* 243 */     GameServer.logger().info(String.format("[roledye]RoleDyeInterface.genderConvert@|role_id=%d|occupation=%d|gender=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(paramInt1) }));
/*     */     
/* 245 */     return true;
/*     */   }
/*     */   
/*     */   public static RoleColorInfo getRoleOccupationColorInfo(long paramLong, int paramInt, boolean paramBoolean)
/*     */   {
/* 250 */     int i = RoleInterface.getOccupationId(paramLong);
/* 251 */     RoleClothes localRoleClothes = null;
/* 252 */     if (paramBoolean) {
/* 253 */       localRoleClothes = Roleclothes.get(Long.valueOf(paramLong));
/*     */     } else {
/* 255 */       localRoleClothes = Roleclothes.select(Long.valueOf(paramLong));
/*     */     }
/* 257 */     if (localRoleClothes == null)
/*     */     {
/* 259 */       GameServer.logger().error(String.format("[roledye]RoleDyeInterface.getRoleOccupationColorInfo@role clothes info is null|role_id=%d|occupation_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/*     */       
/* 261 */       return null; }
/*     */     int j;
/*     */     Object localObject1;
/* 264 */     Object localObject2; if (i == paramInt)
/*     */     {
/* 266 */       j = localRoleClothes.getCurid();
/* 267 */       for (localObject1 = localRoleClothes.getClothes().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (ClothColor)((Iterator)localObject1).next();
/* 268 */         if (((ClothColor)localObject2).getId() == j) {
/* 269 */           return new RoleColorInfo(((ClothColor)localObject2).getHair(), ((ClothColor)localObject2).getCloth());
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 275 */       localObject1 = localRoleClothes.getTransfer_occupation_role_clothes();
/* 276 */       localObject2 = (TransferOccupationRoleClothes)((Map)localObject1).get(Integer.valueOf(paramInt));
/* 277 */       if (localObject2 == null)
/*     */       {
/* 279 */         int k = RoleInterface.getGender(paramLong);
/* 280 */         localObject2 = (TransferOccupationRoleClothes)((Map)localObject1).get(Integer.valueOf(paramInt * 10 + k));
/*     */       }
/* 282 */       if (localObject2 == null)
/*     */       {
/* 284 */         GameServer.logger().error(String.format("[roledye]RoleDyeInterface.getRoleOccupationColorInfo@not contains the occupation|role_id=%d|occupation_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/*     */         
/* 286 */         return null;
/*     */       }
/* 288 */       j = ((TransferOccupationRoleClothes)localObject2).getCurid();
/* 289 */       for (ClothColor localClothColor : ((TransferOccupationRoleClothes)localObject2).getClothes()) {
/* 290 */         if (localClothColor.getId() == j) {
/* 291 */           return new RoleColorInfo(localClothColor.getHair(), localClothColor.getCloth());
/*     */         }
/*     */       }
/*     */     }
/* 295 */     GameServer.logger().error(String.format("[roledye]RoleDyeInterface.getRoleOccupationColorInfo@other occupation|role_id=%d|occupation_id=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/*     */     
/* 297 */     return null;
/*     */   }
/*     */   
/*     */   public static class RoleColorInfo
/*     */   {
/*     */     private final int hairColorId;
/*     */     private final int clothColorId;
/*     */     
/*     */     public RoleColorInfo(int paramInt1, int paramInt2)
/*     */     {
/* 307 */       this.hairColorId = paramInt1;
/* 308 */       this.clothColorId = paramInt2;
/*     */     }
/*     */     
/*     */     public int getHairColorId()
/*     */     {
/* 313 */       return this.hairColorId;
/*     */     }
/*     */     
/*     */     public int getClothColorId()
/*     */     {
/* 318 */       return this.clothColorId;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\RoleDyeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */