/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.Ceremony;
/*    */ import xbean.Ceremonys;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Weddingceremony
/*    */ {
/*    */   public static Ceremonys get(Long key)
/*    */   {
/* 12 */     return (Ceremonys)_Tables_.getInstance().weddingceremony.get(key);
/*    */   }
/*    */   
/*    */   public static Ceremonys get(Long key, Ceremonys value)
/*    */   {
/* 17 */     return (Ceremonys)_Tables_.getInstance().weddingceremony.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Ceremonys value)
/*    */   {
/* 22 */     _Tables_.getInstance().weddingceremony.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().weddingceremony.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Ceremonys value)
/*    */   {
/* 32 */     return _Tables_.getInstance().weddingceremony.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().weddingceremony.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Ceremonys> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().weddingceremony.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Ceremonys> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().weddingceremony;
/*    */   }
/*    */   
/*    */   public static Ceremonys select(Long key)
/*    */   {
/* 52 */     (Ceremonys)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Ceremonys get(Ceremonys v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Ceremony> selectCeremonys(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<Ceremony> get(Ceremonys v)
/*    */       {
/* 67 */         return v.getCeremonysAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCeremonycounter(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(Ceremonys v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getCeremonycounter());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Weddingceremony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */