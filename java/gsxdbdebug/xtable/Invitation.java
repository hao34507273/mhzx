/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Invitation
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().invitation.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().invitation.getAutoKey(localid);
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
/*     */   public static Long insert(xbean.Invitation value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, xbean.Invitation value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static xbean.Invitation get(Long key)
/*     */   {
/*  46 */     return (xbean.Invitation)_Tables_.getInstance().invitation.get(key);
/*     */   }
/*     */   
/*     */   public static xbean.Invitation get(Long key, xbean.Invitation value)
/*     */   {
/*  51 */     return (xbean.Invitation)_Tables_.getInstance().invitation.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, xbean.Invitation value)
/*     */   {
/*  56 */     _Tables_.getInstance().invitation.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, xbean.Invitation value)
/*     */   {
/*  61 */     _Tables_.getInstance().invitation.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().invitation.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, xbean.Invitation value)
/*     */   {
/*  71 */     return _Tables_.getInstance().invitation.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, xbean.Invitation value)
/*     */   {
/*  76 */     return _Tables_.getInstance().invitation.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().invitation.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, xbean.Invitation> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().invitation.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, xbean.Invitation> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().invitation;
/*     */   }
/*     */   
/*     */   public static xbean.Invitation select(Long key)
/*     */   {
/*  96 */     (xbean.Invitation)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Invitation get(xbean.Invitation v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Invitation v)
/*     */       {
/* 111 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGifttype(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(xbean.Invitation v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getGifttype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<String> selectMsgargs(Long key)
/*     */   {
/* 129 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<String> get(xbean.Invitation v)
/*     */       {
/* 133 */         return v.getMsgargsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.InvitedRole> selectInvitedmap(Long key)
/*     */   {
/* 140 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.InvitedRole> get(xbean.Invitation v)
/*     */       {
/* 144 */         return v.getInvitedmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInvitationtime(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(xbean.Invitation v)
/*     */       {
/* 155 */         return Long.valueOf(v.getInvitationtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectKnowninvitedroles(Long key)
/*     */   {
/* 162 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(xbean.Invitation v)
/*     */       {
/* 166 */         return v.getKnowninvitedrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Invitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */