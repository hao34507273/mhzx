/*    */ package xtable;
/*    */ 
/*    */ import xbean.DanceAwardInfo;
/*    */ import xbean.RoleFlowerParadeRecord;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2flowerparaderecord
/*    */ {
/*    */   public static RoleFlowerParadeRecord get(Long key)
/*    */   {
/* 12 */     return (RoleFlowerParadeRecord)_Tables_.getInstance().role2flowerparaderecord.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFlowerParadeRecord get(Long key, RoleFlowerParadeRecord value)
/*    */   {
/* 17 */     return (RoleFlowerParadeRecord)_Tables_.getInstance().role2flowerparaderecord.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFlowerParadeRecord value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2flowerparaderecord.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2flowerparaderecord.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFlowerParadeRecord value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2flowerparaderecord.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2flowerparaderecord.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFlowerParadeRecord> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2flowerparaderecord.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFlowerParadeRecord> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2flowerparaderecord;
/*    */   }
/*    */   
/*    */   public static RoleFlowerParadeRecord select(Long key)
/*    */   {
/* 52 */     (RoleFlowerParadeRecord)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleFlowerParadeRecord get(RoleFlowerParadeRecord v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectFollowawardcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleFlowerParadeRecord v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getFollowawardcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDanceawardcount(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleFlowerParadeRecord v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getDanceawardcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRedbagawardcount(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleFlowerParadeRecord v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getRedbagawardcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static DanceAwardInfo selectPredanceawardinfo(Long key)
/*    */   {
/* 96 */     (DanceAwardInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public DanceAwardInfo get(RoleFlowerParadeRecord v)
/*    */       {
/* :0 */         return v.getPredanceawardinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2flowerparaderecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */