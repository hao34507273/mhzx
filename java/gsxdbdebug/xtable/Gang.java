/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Gang
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().gang.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().gang.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(xbean.Gang value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Gang value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Gang get(Long key)
/*     */   {
/*  46 */     return (xbean.Gang)_Tables_.getInstance().gang.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Gang get(Long key, xbean.Gang value)
/*     */   {
/*  51 */     return (xbean.Gang)_Tables_.getInstance().gang.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Gang value)
/*     */   {
/*  56 */     _Tables_.getInstance().gang.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Gang value)
/*     */   {
/*  61 */     _Tables_.getInstance().gang.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().gang.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Gang value)
/*     */   {
/*  71 */     return _Tables_.getInstance().gang.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Gang value)
/*     */   {
/*  76 */     return _Tables_.getInstance().gang.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().gang.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Gang> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().gang.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Gang> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().gang;
/*     */   }
/*     */   
/*     */   public static xbean.Gang select(Long key)
/*     */   {
/*  96 */     (xbean.Gang)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Gang get(xbean.Gang v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName(Long key)
/*     */   {
/* 107 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Gang v)
/*     */       {
/* 111 */         return v.getName();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLevel(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getLevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreatetime(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 133 */         return Long.valueOf(v.getCreatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectPurpose(Long key)
/*     */   {
/* 140 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Gang v)
/*     */       {
/* 144 */         return v.getPurpose();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBangzhuid(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 155 */         return Long.valueOf(v.getBangzhuid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDesigntitlecaseid(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getDesigntitlecaseid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVitality(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getVitality());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLeveluptime(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 188 */         return Long.valueOf(v.getLeveluptime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.GangAnnouncement> selectAnnouncementhistorylist(Long key)
/*     */   {
/* 195 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.GangAnnouncement> get(xbean.Gang v)
/*     */       {
/* 199 */         return v.getAnnouncementhistorylistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectApprenticemaxlv(Long key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getApprenticemaxlv());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTimestamp(Long key)
/*     */   {
/* 217 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 221 */         return Long.valueOf(v.getTimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastrename(Long key)
/*     */   {
/* 228 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 232 */         return Long.valueOf(v.getLastrename());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectForbiddentalkcount(Long key)
/*     */   {
/* 239 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 243 */         return Integer.valueOf(v.getForbiddentalkcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTanheroleid(Long key)
/*     */   {
/* 250 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 254 */         return Long.valueOf(v.getTanheroleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTanheendtime(Long key)
/*     */   {
/* 261 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 265 */         return Long.valueOf(v.getTanheendtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectJuanzhongnum(Long key)
/*     */   {
/* 272 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 276 */         return Integer.valueOf(v.getJuanzhongnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNextid(Long key)
/*     */   {
/* 283 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 287 */         return Long.valueOf(v.getNextid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPublishtime(Long key)
/*     */   {
/* 294 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 298 */         return Integer.valueOf(v.getPublishtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.GangHelper> selectGanghelperlist(Long key)
/*     */   {
/* 305 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.GangHelper> get(xbean.Gang v)
/*     */       {
/* 309 */         return v.getGanghelperlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.XiangFang selectXiangfang(Long key)
/*     */   {
/* 316 */     (xbean.XiangFang)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.XiangFang get(xbean.Gang v)
/*     */       {
/* 320 */         return v.getXiangfang().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.JinKu selectJinku(Long key)
/*     */   {
/* 327 */     (xbean.JinKu)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.JinKu get(xbean.Gang v)
/*     */       {
/* 331 */         return v.getJinku().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.YaoDian selectYaodian(Long key)
/*     */   {
/* 338 */     (xbean.YaoDian)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.YaoDian get(xbean.Gang v)
/*     */       {
/* 342 */         return v.getYaodian().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.CangKu selectCangku(Long key)
/*     */   {
/* 349 */     (xbean.CangKu)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.CangKu get(xbean.Gang v)
/*     */       {
/* 353 */         return v.getCangku().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.ShuYuan selectShuyuan(Long key)
/*     */   {
/* 360 */     (xbean.ShuYuan)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.ShuYuan get(xbean.Gang v)
/*     */       {
/* 364 */         return v.getShuyuan().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.GangDutyMembers> selectDuty2members(Long key)
/*     */   {
/* 371 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.GangDutyMembers> get(xbean.Gang v)
/*     */       {
/* 375 */         return v.getDuty2membersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPeriodmoney(Long key)
/*     */   {
/* 382 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Gang v)
/*     */       {
/* 386 */         return Integer.valueOf(v.getPeriodmoney());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGrouproleid(Long key)
/*     */   {
/* 393 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 397 */         return Long.valueOf(v.getGrouproleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectGroupopenid(Long key)
/*     */   {
/* 404 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(xbean.Gang v)
/*     */       {
/* 408 */         return v.getGroupopenid();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectDisplayid(Long key)
/*     */   {
/* 415 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 419 */         return Long.valueOf(v.getDisplayid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.GangTeam> selectTeams(Long key)
/*     */   {
/* 426 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.GangTeam> get(xbean.Gang v)
/*     */       {
/* 430 */         return v.getTeamsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Long> selectMember2teamid(Long key)
/*     */   {
/* 437 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Long> get(xbean.Gang v)
/*     */       {
/* 441 */         return v.getMember2teamidAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNext_teamid(Long key)
/*     */   {
/* 448 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Gang v)
/*     */       {
/* 452 */         return Long.valueOf(v.getNext_teamid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */