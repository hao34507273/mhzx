/*    */ package xtable;
/*    */ 
/*    */ import xbean.SwornMember;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2swornmember
/*    */ {
/*    */   public static SwornMember get(Long key)
/*    */   {
/* 12 */     return (SwornMember)_Tables_.getInstance().role2swornmember.get(key);
/*    */   }
/*    */   
/*    */   public static SwornMember get(Long key, SwornMember value)
/*    */   {
/* 17 */     return (SwornMember)_Tables_.getInstance().role2swornmember.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SwornMember value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2swornmember.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2swornmember.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SwornMember value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2swornmember.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2swornmember.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, SwornMember> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2swornmember.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SwornMember> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2swornmember;
/*    */   }
/*    */   
/*    */   public static SwornMember select(Long key)
/*    */   {
/* 52 */     (SwornMember)getTable().select(key, new TField()
/*    */     {
/*    */       public SwornMember get(SwornMember v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSwornid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(SwornMember v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSwornid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static String selectTitle(Long key)
/*    */   {
/* 74 */     (String)getTable().select(key, new TField()
/*    */     {
/*    */       public String get(SwornMember v)
/*    */       {
/* 78 */         return v.getTitle();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2swornmember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */