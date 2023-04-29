/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Group;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Groups
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().groups.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().groups.getAutoKey(localid);
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
/*     */   public static Long insert(Group value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, Group value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static Group get(Long key)
/*     */   {
/*  46 */     return (Group)_Tables_.getInstance().groups.get(key);
/*     */   }
/*     */   
/*     */   public static Group get(Long key, Group value)
/*     */   {
/*  51 */     return (Group)_Tables_.getInstance().groups.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Group value)
/*     */   {
/*  56 */     _Tables_.getInstance().groups.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, Group value)
/*     */   {
/*  61 */     _Tables_.getInstance().groups.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().groups.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Group value)
/*     */   {
/*  71 */     return _Tables_.getInstance().groups.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, Group value)
/*     */   {
/*  76 */     return _Tables_.getInstance().groups.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().groups.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Group> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().groups.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Group> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().groups;
/*     */   }
/*     */   
/*     */   public static Group select(Long key)
/*     */   {
/*  96 */     (Group)getTable().select(key, new TField()
/*     */     {
/*     */       public Group get(Group v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGroup_type(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Group v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getGroup_type());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMasterid(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Group v)
/*     */       {
/* 122 */         return Long.valueOf(v.getMasterid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreate_time(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Group v)
/*     */       {
/* 133 */         return Long.valueOf(v.getCreate_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectGroup_name(Long key)
/*     */   {
/* 140 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(Group v)
/*     */       {
/* 144 */         return v.getGroup_name();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectAnnouncement(Long key)
/*     */   {
/* 151 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(Group v)
/*     */       {
/* 155 */         return v.getAnnouncement();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.GroupMember> selectGroupmembers(Long key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.GroupMember> get(Group v)
/*     */       {
/* 166 */         return v.getGroupmembersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectMemberlist(Long key)
/*     */   {
/* 173 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(Group v)
/*     */       {
/* 177 */         return v.getMemberlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInfo_version(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Group v)
/*     */       {
/* 188 */         return Long.valueOf(v.getInfo_version());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Groups.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */