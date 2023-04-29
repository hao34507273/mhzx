/*     */ package mzm.gsp.mall.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.tlog.TLogArg;
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
/*     */ public class MallInterface
/*     */ {
/*     */   public static long getJifen(long roleid, int jifenType)
/*     */   {
/*  23 */     int fatherType = MallManager.getJifenFatherType(jifenType);
/*     */     
/*  25 */     if (fatherType == 1)
/*     */     {
/*  27 */       return MallManager.selectJifen(roleid, jifenType);
/*     */     }
/*  29 */     if (fatherType == 2)
/*     */     {
/*  31 */       return MallManager.getLadderJifen(roleid, jifenType);
/*     */     }
/*     */     
/*     */ 
/*  35 */     return 0L;
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
/*     */   public static JifenOperateResult addJifen(long roleid, long addnum, int jifenType, boolean isaddWhenTomax, TLogArg logArg)
/*     */   {
/*  53 */     int fatherType = MallManager.getJifenFatherType(jifenType);
/*     */     
/*  55 */     if (fatherType == 1)
/*     */     {
/*  57 */       return MallManager.addJifen(roleid, addnum, jifenType, isaddWhenTomax, logArg);
/*     */     }
/*  59 */     if (fatherType == 2)
/*     */     {
/*  61 */       return MallManager.addLadderJifen(roleid, jifenType, addnum, isaddWhenTomax, logArg);
/*     */     }
/*     */     
/*     */ 
/*  65 */     return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
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
/*     */   public static JifenOperateEnum addJifenForIdip(long roleid, long addnum, int jifenType, TLogArg logArg)
/*     */   {
/*  81 */     int fatherType = MallManager.getJifenFatherType(jifenType);
/*     */     
/*  83 */     if (fatherType == 1)
/*     */     {
/*  85 */       return MallManager.addJifenForIdip(roleid, addnum, jifenType, logArg);
/*     */     }
/*  87 */     if (fatherType == 2)
/*     */     {
/*  89 */       JifenOperateResult jifenOperateResult = MallManager.addLadderJifen(roleid, jifenType, addnum, false, logArg);
/*  90 */       if (jifenOperateResult.isSuccess())
/*     */       {
/*  92 */         return JifenOperateEnum.SUCCESS;
/*     */       }
/*     */       
/*     */ 
/*  96 */       return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 101 */     return JifenOperateEnum.JIFEN_TYPE_ERROR;
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
/*     */   public static JifenOperateEnum addJifenForAqIdip(long roleid, long addnum, int jifenType, TLogArg logArg)
/*     */   {
/* 116 */     return addJifenForIdip(roleid, addnum, jifenType, logArg);
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
/*     */   public static JifenOperateResult cutJifen(long roleid, long cutnum, int jifenType, TLogArg logArg)
/*     */   {
/* 134 */     int fatherType = MallManager.getJifenFatherType(jifenType);
/*     */     
/* 136 */     if (fatherType == 1)
/*     */     {
/* 138 */       return MallManager.cutJifen(roleid, cutnum, jifenType, logArg);
/*     */     }
/* 140 */     if (fatherType == 2)
/*     */     {
/* 142 */       return MallManager.cutLadderJifen(roleid, jifenType, cutnum, logArg);
/*     */     }
/*     */     
/*     */ 
/* 146 */     return new JifenOperateResult(JifenOperateResult.JifenOperateResultEnum.ParamError, 0L);
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
/*     */   public static JifenOperateEnum cutJifenForIdip(long roleid, long jifennum, int jifenType, TLogArg logArg)
/*     */   {
/* 162 */     int fatherType = MallManager.getJifenFatherType(jifenType);
/*     */     
/* 164 */     if (fatherType == 1)
/*     */     {
/* 166 */       return MallManager.cutJifenForIdip(roleid, jifennum, jifenType, logArg);
/*     */     }
/* 168 */     if (fatherType == 2)
/*     */     {
/* 170 */       JifenOperateResult jifenOperateResult = MallManager.cutLadderJifen(roleid, jifenType, jifennum, logArg);
/* 171 */       if (jifenOperateResult.isSuccess())
/*     */       {
/* 173 */         return JifenOperateEnum.SUCCESS;
/*     */       }
/*     */       
/*     */ 
/* 177 */       return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 182 */     return JifenOperateEnum.JIFEN_TYPE_ERROR;
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
/*     */   public static JifenOperateEnum cutJifenForAqIdip(long roleid, long jifennum, int jifenType, TLogArg logArg)
/*     */   {
/* 198 */     int fatherType = MallManager.getJifenFatherType(jifenType);
/*     */     
/* 200 */     if (fatherType == 1)
/*     */     {
/* 202 */       return MallManager.cutJifenForAqIdip(roleid, jifennum, jifenType, logArg);
/*     */     }
/* 204 */     if (fatherType == 2)
/*     */     {
/* 206 */       JifenOperateResult jifenOperateResult = MallManager.cutLadderJifen(roleid, jifenType, jifennum, logArg);
/* 207 */       if (jifenOperateResult.isSuccess())
/*     */       {
/* 209 */         return JifenOperateEnum.SUCCESS;
/*     */       }
/*     */       
/*     */ 
/* 213 */       return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 218 */     return JifenOperateEnum.JIFEN_TYPE_ERROR;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getItemPrice(int itemid)
/*     */   {
/* 230 */     return MallManager.getItemPrice(itemid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getLimitItemPrice(int malltype, int itemid)
/*     */   {
/* 242 */     return MallManager.getLimitItemPrice(malltype, itemid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getMallTypeForItem(long roleid, int itemid)
/*     */   {
/* 253 */     return MallManager.getMallTypeForItem(roleid, itemid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getJifenTypeForItem(int itemid)
/*     */   {
/* 264 */     return MallManager.getJifenTypeForItem(itemid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\MallInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */