/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.PersonalInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2personal
/*     */ {
/*     */   public static PersonalInfo get(Long key)
/*     */   {
/*  12 */     return (PersonalInfo)_Tables_.getInstance().role2personal.get(key);
/*     */   }
/*     */   
/*     */   public static PersonalInfo get(Long key, PersonalInfo value)
/*     */   {
/*  17 */     return (PersonalInfo)_Tables_.getInstance().role2personal.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, PersonalInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2personal.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2personal.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, PersonalInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2personal.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2personal.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, PersonalInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2personal.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, PersonalInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2personal;
/*     */   }
/*     */   
/*     */   public static PersonalInfo select(Long key)
/*     */   {
/*  52 */     (PersonalInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public PersonalInfo get(PersonalInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectSign(Long key)
/*     */   {
/*  63 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(PersonalInfo v)
/*     */       {
/*  67 */         return v.getSign();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGender(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PersonalInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getGender());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAge(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PersonalInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getAge());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBirthday(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(PersonalInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getBirthday());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAnimalsign(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PersonalInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getAnimalsign());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectConstellation(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PersonalInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getConstellation());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBloodtype(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PersonalInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getBloodtype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOccupation(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(PersonalInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getOccupation());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectSchool(Long key)
/*     */   {
/* 151 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(PersonalInfo v)
/*     */       {
/* 155 */         return v.getSchool();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLocation(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(PersonalInfo v)
/*     */       {
/* 166 */         return Long.valueOf(v.getLocation());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Integer> selectHobbies(Long key)
/*     */   {
/* 173 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Integer> get(PersonalInfo v)
/*     */       {
/* 177 */         return v.getHobbiesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectHeadimage(Long key)
/*     */   {
/* 184 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(PersonalInfo v)
/*     */       {
/* 188 */         return v.getHeadimage();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<String> selectPhotos(Long key)
/*     */   {
/* 195 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<String> get(PersonalInfo v)
/*     */       {
/* 199 */         return v.getPhotosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.PraiseInfo selectPraise(Long key)
/*     */   {
/* 206 */     (xbean.PraiseInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.PraiseInfo get(PersonalInfo v)
/*     */       {
/* 210 */         return v.getPraise().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectRefreshadvert(Long key)
/*     */   {
/* 217 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(PersonalInfo v)
/*     */       {
/* 221 */         return v.getRefreshadvertAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectAdverts(Long key)
/*     */   {
/* 228 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(PersonalInfo v)
/*     */       {
/* 232 */         return v.getAdvertsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectDeletetimestamps(Long key)
/*     */   {
/* 239 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(PersonalInfo v)
/*     */       {
/* 243 */         return v.getDeletetimestampsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2personal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */