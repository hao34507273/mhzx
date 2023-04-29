/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*     */ import mzm.gsp.partner.confbean.SPartnerLoveDataCfg;
/*     */ import mzm.gsp.partner.confbean.STRank2partner;
/*     */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg.ChangeZhenFaIdType;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LineUp;
/*     */ import xbean.PartnerBag;
/*     */ import xtable.Role2partnerbag;
/*     */ import xtable.Role2partneroutfightbean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PartnerInterface
/*     */ {
/*     */   public static Set<Integer> getRoleAllPartnerIds(long roleId, boolean remainRoleLock)
/*     */   {
/*  31 */     RolePartner rolePartner = new RolePartner(roleId, remainRoleLock);
/*  32 */     if (!rolePartner.hasXPartnerData())
/*     */     {
/*  34 */       return Collections.emptySet();
/*     */     }
/*  36 */     return rolePartner.getAllPartners();
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
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getFightPartnerListWithoutRole(long roleId, boolean remainRoleLock)
/*     */   {
/*  51 */     return PartnerManager.getFightPartnerListWithoutRoleImpl(roleId, remainRoleLock);
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
/*     */   public static PartnerOutFightObj getPartnerOutFightObjById(long roleId, int partnerId)
/*     */   {
/*  64 */     RolePartner rolePartner = new RolePartner(roleId, true);
/*  65 */     return rolePartner.getPartnerOutFightObjById(partnerId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean removeRoleCachePartnerOutfightObjs(long roleid)
/*     */   {
/*  77 */     return Role2partneroutfightbean.remove(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SPartnerCfg getSPartnerCfgById(int partnerId)
/*     */   {
/*  89 */     return PartnerInitManager.getInstance().getPartnerCfg(partnerId).getsPartnerCfg();
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
/*     */ 
/*     */ 
/*     */   public static int getSPartnerZhenfaId(long roleId, boolean remainRoleLock)
/*     */   {
/* 104 */     RolePartner rolePartner = new RolePartner(roleId, remainRoleLock);
/* 105 */     if (rolePartner.getPartnerBag() == null)
/*     */     {
/* 107 */       return 0;
/*     */     }
/* 109 */     if ((rolePartner.getPartnerBag().getLineups() == null) || (rolePartner.getPartnerBag().getLineups().size() == 0))
/*     */     {
/* 111 */       return 0;
/*     */     }
/* 113 */     int defaultLineUp = rolePartner.getPartnerBag().getDefaultlineupnum();
/* 114 */     if (rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(defaultLineUp)) == null)
/*     */     {
/* 116 */       return 0;
/*     */     }
/* 118 */     return ((LineUp)rolePartner.getPartnerBag().getLineups().get(Integer.valueOf(defaultLineUp))).getZhenfaid();
/*     */   }
/*     */   
/*     */   public static void fillPartnerModelInfo(int partnerId, ModelInfo modelInfo)
/*     */   {
/* 123 */     int modeId = getSPartnerCfgById(partnerId).modelId;
/*     */     
/* 125 */     modelInfo.modelid = modeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SPartnerLoveDataCfg getPartnerLoveDataCfg(int loveId)
/*     */   {
/* 137 */     return SPartnerLoveDataCfg.get(loveId);
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
/*     */   public static int getRolePartnerDefaultZhenFaId(long roleId)
/*     */   {
/* 150 */     PartnerBag partnerBag = Role2partnerbag.select(Long.valueOf(roleId));
/* 151 */     if (partnerBag == null)
/*     */     {
/* 153 */       return 0;
/*     */     }
/* 155 */     int defaultLineUpId = partnerBag.getDefaultlineupnum();
/* 156 */     LineUp defaultLineUp = (LineUp)partnerBag.getLineups().get(Integer.valueOf(defaultLineUpId));
/* 157 */     if (defaultLineUp == null)
/*     */     {
/* 159 */       return 0;
/*     */     }
/* 161 */     return defaultLineUp.getZhenfaid();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean ownPartner(long roleId, int partnerId)
/*     */   {
/* 177 */     PartnerBag partnerBag = Role2partnerbag.select(Long.valueOf(roleId));
/* 178 */     if (partnerBag == null)
/*     */     {
/* 180 */       return false;
/*     */     }
/* 182 */     return partnerBag.getOwnpartnerids().contains(Integer.valueOf(partnerId));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getRoleXRankPartners(long roleId, int rank)
/*     */   {
/* 198 */     STRank2partner cfg = STRank2partner.get(rank);
/* 199 */     if (cfg == null)
/*     */     {
/* 201 */       return new HashSet();
/*     */     }
/* 203 */     List<Integer> rankPartners = cfg.partnerIds;
/* 204 */     if ((rankPartners == null) || (rankPartners.size() == 0))
/*     */     {
/* 206 */       return new HashSet();
/*     */     }
/* 208 */     PartnerBag partnerBag = Role2partnerbag.select(Long.valueOf(roleId));
/* 209 */     if (partnerBag == null)
/*     */     {
/* 211 */       return new HashSet();
/*     */     }
/* 213 */     Set<Integer> needPartnerIds = new HashSet();
/* 214 */     for (Iterator i$ = partnerBag.getOwnpartnerids().iterator(); i$.hasNext();) { int partnerId = ((Integer)i$.next()).intValue();
/*     */       
/* 216 */       if (rankPartners.contains(Integer.valueOf(partnerId)))
/*     */       {
/* 218 */         needPartnerIds.add(Integer.valueOf(partnerId));
/*     */       }
/*     */     }
/* 221 */     return needPartnerIds;
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
/*     */ 
/*     */ 
/*     */   public static boolean changeDefaultPartnerLineUpZhenFaId(long roleId, int zhenFaId, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type)
/*     */   {
/* 236 */     return changePartnerLineUpZhenFaId(roleId, zhenFaId, -1, type);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean changePartnerLineUpZhenFaId(long roleId, int zhenFaId, int index, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType type)
/*     */   {
/* 252 */     RolePartner rolePartner = PartnerManager.getRolePartner(roleId, true);
/* 253 */     if (rolePartner.getPartnerBag() == null)
/*     */     {
/* 255 */       PartnerBag partnerBag = PartnerManager.creatPartnerBagBean(rolePartner);
/* 256 */       Role2partnerbag.insert(Long.valueOf(roleId), partnerBag);
/*     */     }
/* 258 */     if (index == -1)
/*     */     {
/* 260 */       index = PartnerManager.getDefLineUp(rolePartner);
/* 261 */       if (index < 0)
/*     */       {
/* 263 */         return false;
/*     */       }
/*     */     }
/* 266 */     PartnerManager.changeZhenFa(roleId, index, zhenFaId, rolePartner, type);
/* 267 */     return true;
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
/*     */ 
/*     */   public static boolean isAssistPartner(int partnerId)
/*     */   {
/* 281 */     PartnerCfg cfg = PartnerInitManager.getInstance().getPartnerCfg(partnerId);
/* 282 */     if (cfg == null)
/*     */     {
/* 284 */       return false;
/*     */     }
/* 286 */     return cfg.isAssistPartner();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPartnerScore(long roleId, int partnerId, boolean remainRoleLock)
/*     */   {
/* 304 */     RolePartner rolePartner = PartnerManager.getRolePartner(roleId, remainRoleLock);
/* 305 */     Partner xPartner = rolePartner.getXPartner(partnerId);
/* 306 */     if (xPartner == null)
/*     */     {
/* 308 */       GameServer.logger().error(String.format("[partner]ParnterInterface.getPartnerScore@ not own this partner!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*     */       
/*     */ 
/* 311 */       return -1;
/*     */     }
/* 313 */     return xPartner.getFightScoreFromDb();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getAllPartnerScores(long roleId, boolean remainRoleLock)
/*     */   {
/* 325 */     RolePartner rolePartner = PartnerManager.getRolePartner(roleId, remainRoleLock);
/* 326 */     return rolePartner.getAllPartnerScore();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getPartnerSkillData(long roleId, int partnerId, boolean remainRoleLock)
/*     */   {
/* 344 */     RolePartner rolePartner = PartnerManager.getRolePartner(roleId, remainRoleLock);
/* 345 */     Partner xPartner = rolePartner.getXPartner(partnerId);
/* 346 */     if (xPartner == null)
/*     */     {
/* 348 */       GameServer.logger().error(String.format("[partner]ParnterInterface.getPartnerSkillData@ not own this partner!|roleId=%d|partnerId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(partnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 352 */       return new HashMap();
/*     */     }
/* 354 */     return xPartner.getSPartnerRealkills();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */