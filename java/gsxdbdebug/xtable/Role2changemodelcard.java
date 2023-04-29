/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2changemodelcard
/*     */ {
/*     */   public static Role2ChangeModelCardInfo get(Long key)
/*     */   {
/*  12 */     return (Role2ChangeModelCardInfo)_Tables_.getInstance().role2changemodelcard.get(key);
/*     */   }
/*     */   
/*     */   public static Role2ChangeModelCardInfo get(Long key, Role2ChangeModelCardInfo value)
/*     */   {
/*  17 */     return (Role2ChangeModelCardInfo)_Tables_.getInstance().role2changemodelcard.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2ChangeModelCardInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2changemodelcard.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2changemodelcard.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2ChangeModelCardInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2changemodelcard.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2changemodelcard.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2ChangeModelCardInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2changemodelcard.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2ChangeModelCardInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2changemodelcard;
/*     */   }
/*     */   
/*     */   public static Role2ChangeModelCardInfo select(Long key)
/*     */   {
/*  52 */     (Role2ChangeModelCardInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2ChangeModelCardInfo get(Role2ChangeModelCardInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectCard_ids(Long key)
/*     */   {
/*  63 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(Role2ChangeModelCardInfo v)
/*     */       {
/*  67 */         return v.getCard_idsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_card_cfg_id(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChangeModelCardInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCurrent_card_cfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_card_level(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChangeModelCardInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getCurrent_card_level());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectVisible(Long key)
/*     */   {
/*  96 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Role2ChangeModelCardInfo v)
/*     */       {
/* 100 */         return Boolean.valueOf(v.getVisible());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFight_count(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChangeModelCardInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getFight_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStart_time(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2ChangeModelCardInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getStart_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOverlay_count(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChangeModelCardInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getOverlay_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNext_card_id(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2ChangeModelCardInfo v)
/*     */       {
/* 144 */         return Long.valueOf(v.getNext_card_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.ChangeModelCardInfo> selectCardid2info(Long key)
/*     */   {
/* 151 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.ChangeModelCardInfo> get(Role2ChangeModelCardInfo v)
/*     */       {
/* 155 */         return v.getCardid2infoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectActivated_in_fight(Long key)
/*     */   {
/* 162 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Role2ChangeModelCardInfo v)
/*     */       {
/* 166 */         return Boolean.valueOf(v.getActivated_in_fight());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2changemodelcard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */