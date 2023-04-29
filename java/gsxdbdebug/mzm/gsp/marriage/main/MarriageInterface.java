/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import xbean.MarriageSkill;
/*     */ import xtable.Role2marriage;
/*     */ import xtable.Role2marriageskill;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MarriageInterface
/*     */ {
/*     */   public static long getMarriedTime(long roleid, boolean holdLock)
/*     */   {
/*  20 */     Long xMarriageid = null;
/*  21 */     if (holdLock)
/*     */     {
/*  23 */       xMarriageid = Role2marriage.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/*  27 */       xMarriageid = Role2marriage.select(Long.valueOf(roleid));
/*     */     }
/*  29 */     if (xMarriageid == null)
/*     */     {
/*  31 */       return -1L;
/*     */     }
/*     */     
/*  34 */     xbean.Marriage xMarriage = null;
/*  35 */     if (holdLock)
/*     */     {
/*  37 */       xMarriage = xtable.Marriage.get(xMarriageid);
/*     */     }
/*     */     else
/*     */     {
/*  41 */       xMarriage = xtable.Marriage.select(xMarriageid);
/*     */     }
/*  43 */     if (xMarriage == null)
/*     */     {
/*  45 */       return -1L;
/*     */     }
/*     */     
/*  48 */     return xMarriage.getMarrytime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMarried(long roleid)
/*     */   {
/*  59 */     return Role2marriage.select(Long.valueOf(roleid)) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInForceDivorce(long roleid)
/*     */   {
/*  70 */     return MarriageManager.isInForceDivorce(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getMarriedRoleid(long roleid)
/*     */   {
/*  81 */     return MarriageManager.getMarriedRoleid(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getMarriedRoleid(long roleid, boolean retainLock)
/*     */   {
/*  93 */     return MarriageManager.getMarriedRoleid(roleid, retainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMarriageRelation(long roleid1, long roleid2)
/*     */   {
/* 105 */     Long marriageId1 = Role2marriage.select(Long.valueOf(roleid1));
/* 106 */     if (marriageId1 == null)
/*     */     {
/* 108 */       return false;
/*     */     }
/* 110 */     Long marriageid2 = Role2marriage.select(Long.valueOf(roleid2));
/* 111 */     if (marriageid2 == null)
/*     */     {
/* 113 */       return false;
/*     */     }
/* 115 */     return marriageId1.equals(marriageid2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getMarrySkills(long roleid, boolean retainLock)
/*     */   {
/* 127 */     Map<Integer, Integer> skillMap = new HashMap();
/* 128 */     MarriageSkill xMarriageSkill = null;
/* 129 */     if (retainLock)
/*     */     {
/* 131 */       xMarriageSkill = Role2marriageskill.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 135 */       xMarriageSkill = Role2marriageskill.select(Long.valueOf(roleid));
/*     */     }
/* 137 */     if (xMarriageSkill == null)
/*     */     {
/* 139 */       return skillMap;
/*     */     }
/* 141 */     skillMap.putAll(xMarriageSkill.getSkills());
/* 142 */     return skillMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getMarriedId(long roleId, boolean isRemainRolelock)
/*     */   {
/* 154 */     Long marriageId = null;
/* 155 */     if (isRemainRolelock)
/*     */     {
/* 157 */       marriageId = Role2marriage.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 161 */       marriageId = Role2marriage.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 164 */     if (marriageId == null)
/*     */     {
/* 166 */       return -1L;
/*     */     }
/*     */     
/* 169 */     return marriageId.longValue();
/*     */   }
/*     */   
/*     */   public static int getPreparePrngnantScore(long marrigeId, boolean isRemainlock)
/*     */   {
/* 174 */     xbean.Marriage xMarriage = null;
/* 175 */     if (isRemainlock)
/*     */     {
/* 177 */       xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     }
/*     */     else
/*     */     {
/* 181 */       xMarriage = xtable.Marriage.select(Long.valueOf(marrigeId));
/*     */     }
/*     */     
/* 184 */     if (xMarriage == null)
/*     */     {
/* 186 */       return -1;
/*     */     }
/*     */     
/* 189 */     return xMarriage.getPrepare_pregnant_score();
/*     */   }
/*     */   
/*     */   public static long getGiveBirthScore(long marrigeId, boolean isRemainlock)
/*     */   {
/* 194 */     xbean.Marriage xMarriage = null;
/* 195 */     if (isRemainlock)
/*     */     {
/* 197 */       xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     }
/*     */     else
/*     */     {
/* 201 */       xMarriage = xtable.Marriage.select(Long.valueOf(marrigeId));
/*     */     }
/*     */     
/* 204 */     if (xMarriage == null)
/*     */     {
/* 206 */       return -1L;
/*     */     }
/*     */     
/* 209 */     return xMarriage.getGive_birth_score();
/*     */   }
/*     */   
/*     */   public static long getGiveBirthScoreEnoughTime(long marrigeId, boolean isRemainlock)
/*     */   {
/* 214 */     xbean.Marriage xMarriage = null;
/* 215 */     if (isRemainlock)
/*     */     {
/* 217 */       xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     }
/*     */     else
/*     */     {
/* 221 */       xMarriage = xtable.Marriage.select(Long.valueOf(marrigeId));
/*     */     }
/*     */     
/* 224 */     if (xMarriage == null)
/*     */     {
/* 226 */       return -1L;
/*     */     }
/*     */     
/* 229 */     return xMarriage.getGive_birth_score_enough_time();
/*     */   }
/*     */   
/*     */   public static void setGiveBirthScoreEnoughTime(long marrigeId, long giveBirthScoreEnoughTime)
/*     */   {
/* 234 */     xbean.Marriage xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     
/* 236 */     if (xMarriage == null)
/*     */     {
/* 238 */       return;
/*     */     }
/*     */     
/* 241 */     xMarriage.setGive_birth_score_enough_time(giveBirthScoreEnoughTime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setPregnantBelongRoleId(long marrigeId, long belongRoleId)
/*     */   {
/* 252 */     xbean.Marriage xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     
/* 254 */     if (xMarriage == null)
/*     */     {
/* 256 */       return;
/*     */     }
/*     */     
/* 259 */     xMarriage.setChild_belong_role_id(belongRoleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int addAndGetPreparePregnantScore(long marrigeId, int score)
/*     */   {
/* 270 */     xbean.Marriage xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     
/* 272 */     if (xMarriage == null)
/*     */     {
/* 274 */       return -1;
/*     */     }
/*     */     
/* 277 */     int nowScore = xMarriage.getPrepare_pregnant_score() + score;
/* 278 */     xMarriage.setPrepare_pregnant_score(nowScore);
/*     */     
/* 280 */     return xMarriage.getPrepare_pregnant_score();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int addAndGetGiveBirthScore(long marrigeId, int score)
/*     */   {
/* 291 */     xbean.Marriage xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     
/* 293 */     if (xMarriage == null)
/*     */     {
/* 295 */       return -1;
/*     */     }
/*     */     
/* 298 */     int nowScore = xMarriage.getGive_birth_score() + score;
/* 299 */     xMarriage.setGive_birth_score(nowScore);
/*     */     
/* 301 */     return xMarriage.getGive_birth_score();
/*     */   }
/*     */   
/*     */   public static void clearMarriagePregnant(long marrigeId)
/*     */   {
/* 306 */     xbean.Marriage xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/* 307 */     if (xMarriage == null)
/*     */     {
/* 309 */       return;
/*     */     }
/* 311 */     xMarriage.setPrepare_pregnant_score(0);
/* 312 */     xMarriage.setChild_belong_role_id(0L);
/* 313 */     xMarriage.setGive_birth_score(0);
/* 314 */     xMarriage.setGive_birth_score_enough_time(0L);
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
/*     */   public static PregnantState getPregnantState(long marrigeId, boolean isRemainLock)
/*     */   {
/* 328 */     xbean.Marriage xMarriage = null;
/* 329 */     if (isRemainLock)
/*     */     {
/* 331 */       xMarriage = xtable.Marriage.get(Long.valueOf(marrigeId));
/*     */     }
/*     */     else
/*     */     {
/* 335 */       xMarriage = xtable.Marriage.select(Long.valueOf(marrigeId));
/*     */     }
/*     */     
/* 338 */     if (xMarriage == null)
/*     */     {
/* 340 */       return null;
/*     */     }
/*     */     
/* 343 */     PregnantState pregnantState = null;
/* 344 */     if (xMarriage.getPrepare_pregnant_score() > 0)
/*     */     {
/* 346 */       pregnantState = new PregnantState();
/*     */     }
/*     */     
/* 349 */     if (pregnantState == null)
/*     */     {
/* 351 */       return null;
/*     */     }
/*     */     
/* 354 */     if (xMarriage.getGive_birth_score() >= SChildrenConsts.getInstance().give_birth_need_score)
/*     */     {
/* 356 */       pregnantState.step = 4;
/* 357 */       pregnantState.nowScore = 0;
/* 358 */       pregnantState.giveBirthScoreEnoughTime = xMarriage.getGive_birth_score_enough_time();
/* 359 */       pregnantState.belongRoleId = xMarriage.getChild_belong_role_id();
/*     */     }
/* 361 */     else if (xMarriage.getChild_belong_role_id() != 0L)
/*     */     {
/* 363 */       pregnantState.step = 3;
/* 364 */       pregnantState.nowScore = xMarriage.getGive_birth_score();
/* 365 */       pregnantState.belongRoleId = xMarriage.getChild_belong_role_id();
/*     */     }
/* 367 */     else if (xMarriage.getPrepare_pregnant_score() >= SChildrenConsts.getInstance().prepare_pregnant_need_score)
/*     */     {
/* 369 */       pregnantState.step = 2;
/* 370 */       pregnantState.nowScore = 0;
/*     */     }
/* 372 */     else if (xMarriage.getPrepare_pregnant_score() != 0L)
/*     */     {
/* 374 */       pregnantState.step = 1;
/* 375 */       pregnantState.nowScore = xMarriage.getPrepare_pregnant_score();
/*     */     }
/*     */     
/* 378 */     return pregnantState;
/*     */   }
/*     */   
/*     */   public static class PregnantState
/*     */   {
/* 383 */     public int step = 0;
/* 384 */     public int nowScore = 0;
/* 385 */     public long giveBirthScoreEnoughTime = 0L;
/* 386 */     public long belongRoleId = 0L;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */