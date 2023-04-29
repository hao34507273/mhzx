/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PartnerBag;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2partnerbag
/*    */ {
/*    */   public static PartnerBag get(Long key)
/*    */   {
/* 12 */     return (PartnerBag)_Tables_.getInstance().role2partnerbag.get(key);
/*    */   }
/*    */   
/*    */   public static PartnerBag get(Long key, PartnerBag value)
/*    */   {
/* 17 */     return (PartnerBag)_Tables_.getInstance().role2partnerbag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PartnerBag value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2partnerbag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2partnerbag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PartnerBag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2partnerbag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2partnerbag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PartnerBag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2partnerbag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PartnerBag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2partnerbag;
/*    */   }
/*    */   
/*    */   public static PartnerBag select(Long key)
/*    */   {
/* 52 */     (PartnerBag)getTable().select(key, new TField()
/*    */     {
/*    */       public PartnerBag get(PartnerBag v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDefaultlineupnum(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PartnerBag v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getDefaultlineupnum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<Integer> selectOwnpartnerids(Long key)
/*    */   {
/* 74 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<Integer> get(PartnerBag v)
/*    */       {
/* 78 */         return v.getOwnpartneridsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.LineUp> selectLineups(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.LineUp> get(PartnerBag v)
/*    */       {
/* 89 */         return v.getLineupsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.Property> selectPartner2property(Long key)
/*    */   {
/* 96 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.Property> get(PartnerBag v)
/*    */       {
/* :0 */         return v.getPartner2propertyAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2partnerbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */