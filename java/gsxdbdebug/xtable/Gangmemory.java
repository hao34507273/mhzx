/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GangMemoryBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangmemory
/*    */ {
/*    */   public static GangMemoryBean get(Long key)
/*    */   {
/* 12 */     return (GangMemoryBean)_Tables_.getInstance().gangmemory.get(key);
/*    */   }
/*    */   
/*    */   public static GangMemoryBean get(Long key, GangMemoryBean value)
/*    */   {
/* 17 */     return (GangMemoryBean)_Tables_.getInstance().gangmemory.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangMemoryBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangmemory.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangmemory.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangMemoryBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangmemory.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangmemory.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangMemoryBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangmemory.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangMemoryBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangmemory;
/*    */   }
/*    */   
/*    */   public static GangMemoryBean select(Long key)
/*    */   {
/* 52 */     (GangMemoryBean)getTable().select(key, new TField()
/*    */     {
/*    */       public GangMemoryBean get(GangMemoryBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.GangApply> selectApplylist(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.GangApply> get(GangMemoryBean v)
/*    */       {
/* 67 */         return v.getApplylistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectGangworldid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(GangMemoryBean v)
/*    */       {
/* 78 */         return Long.valueOf(v.getGangworldid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.GangTeamApplicants> selectTeamapplicants(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.GangTeamApplicants> get(GangMemoryBean v)
/*    */       {
/* 89 */         return v.getTeamapplicantsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangmemory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */