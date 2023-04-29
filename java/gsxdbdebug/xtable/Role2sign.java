/*     */ package xtable;
/*     */ 
/*     */ import xbean.Sign;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2sign
/*     */ {
/*     */   public static Sign get(Long key)
/*     */   {
/*  12 */     return (Sign)_Tables_.getInstance().role2sign.get(key);
/*     */   }
/*     */   
/*     */   public static Sign get(Long key, Sign value)
/*     */   {
/*  17 */     return (Sign)_Tables_.getInstance().role2sign.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Sign value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2sign.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2sign.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Sign value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2sign.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2sign.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, Sign> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2sign.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Sign> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2sign;
/*     */   }
/*     */   
/*     */   public static Sign select(Long key)
/*     */   {
/*  52 */     (Sign)getTable().select(key, new TField()
/*     */     {
/*     */       public Sign get(Sign v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSigncount(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getSigncount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSigntime(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Sign v)
/*     */       {
/*  78 */         return Long.valueOf(v.getSigntime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSignday(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getSignday());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFillincount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getFillincount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAwardedfillincount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getAwardedfillincount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBox_sign_award_state(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getBox_sign_award_state());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_precious_cell_num(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getCurrent_precious_cell_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_precious_box_buff_id(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getCurrent_precious_box_buff_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLucky_box_sign_box_buff_id(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getLucky_box_sign_box_buff_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLucky_box_gold_precious_cfg_id(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Sign v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getLucky_box_gold_precious_cfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2sign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */