/*     */ package mzm.gsp.zhenfa.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.common.PropertyRandomUtil.KeyValuePair;
/*     */ import mzm.gsp.item.confbean.SZhenfaBookItem;
/*     */ import xbean.ZhenfaInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZhenfaInterface
/*     */ {
/*     */   public static boolean studyZhenfa(long roleId, int zhenfaId)
/*     */   {
/*  21 */     return ZhenfaManager.studyZhenfa(roleId, zhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RoleZhenfaInfo getRoleZhenfaInfo(long roleId)
/*     */   {
/*  32 */     return new RoleZhenfaInfo(roleId, ZhenfaManager.getZhenfaInfo(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addZhenfaExp(long roleId, int zhenfaId, int expNum)
/*     */   {
/*  45 */     return ZhenfaManager.addZhenfaExp(roleId, zhenfaId, expNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenfaBookExp(int zhenfaBookId)
/*     */   {
/*  56 */     return ZhenfaManager.getZhenfaBookExp(zhenfaBookId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenfaBookExtraExp(int zhenfaBookId)
/*     */   {
/*  67 */     return ZhenfaManager.getZhenfaBookExtraExp(zhenfaBookId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isZhenfaBookSuitZhenfa(int zhenfaId, int zhenfaBookId)
/*     */   {
/*  79 */     if (SZhenfaBookItem.get(zhenfaBookId) == null)
/*     */     {
/*  81 */       return false;
/*     */     }
/*  83 */     return SZhenfaBookItem.get(zhenfaBookId).zhenfaId == zhenfaId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenfaFragmentExp(int zhenfaFragId)
/*     */   {
/*  94 */     return ZhenfaManager.getZhenfaFragmentExp(zhenfaFragId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenfaExp(long roleId, int zhenfaId)
/*     */   {
/* 106 */     return ZhenfaManager.getZhenfaExp(roleId, zhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenfaLevel(long roleId, int zhenfaId)
/*     */   {
/* 118 */     return ZhenfaManager.getZhenfaLevel(roleId, zhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenfaBookId(int zhenfaId)
/*     */   {
/* 129 */     return ZhenfaManager.getZhenfaBookId(zhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, List<PropertyRandomUtil.KeyValuePair>> getZhenfaPosAttributes(int zhenfaId, int zhenfaLevel)
/*     */   {
/* 142 */     return ZhenfaManager.getZhenfaPosAttributes(zhenfaId, zhenfaLevel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int zhenfaRestrictRelation(int zhenfaId1, int zhenfaId2)
/*     */   {
/* 154 */     return ZhenfaManager.zhenfaRestrictRelation(zhenfaId1, zhenfaId2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PropertyRandomUtil.KeyValuePair getRestZhenfaAttribute(int zhenfaId, int beRestZhenfaId)
/*     */   {
/* 166 */     return ZhenfaManager.getRestZhenfaAttribute(zhenfaId, beRestZhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasZhenfa(long roleId, int zhenfaId)
/*     */   {
/* 178 */     return ZhenfaManager.hasZhenfa(roleId, zhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isZhenfaAvailable(Map<Integer, List<Long>> attendFightObjectMap, int zhenfaId)
/*     */   {
/* 191 */     List<Long> roleList = (List)attendFightObjectMap.get(Integer.valueOf(1));
/* 192 */     if ((roleList == null) || (roleList.size() == 0))
/*     */     {
/* 194 */       return false;
/*     */     }
/*     */     
/* 197 */     int count = roleList.size();
/* 198 */     List<Long> fellowList = (List)attendFightObjectMap.get(Integer.valueOf(2));
/* 199 */     if (fellowList != null)
/*     */     {
/* 201 */       count += fellowList.size();
/*     */     }
/* 203 */     List<Long> monsterList = (List)attendFightObjectMap.get(Integer.valueOf(8));
/* 204 */     if (monsterList != null)
/*     */     {
/* 206 */       count += monsterList.size();
/*     */     }
/*     */     
/* 209 */     return count >= 5;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isZhenfaExists(int zhenfaId)
/*     */   {
/* 220 */     return ZhenfaManager.isZhenfaExists(zhenfaId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhenFaCount(long roleId)
/*     */   {
/* 232 */     return ZhenfaManager.getZhenfaInfo(roleId).getZhenfas().size();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\ZhenfaInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */