/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PartnerYuanshenInfo;
/*    */ import xbean.PartnerYuanshenPositionInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2partner_yuanshen
/*    */ {
/*    */   public static PartnerYuanshenInfo get(Long key)
/*    */   {
/* 12 */     return (PartnerYuanshenInfo)_Tables_.getInstance().role2partner_yuanshen.get(key);
/*    */   }
/*    */   
/*    */   public static PartnerYuanshenInfo get(Long key, PartnerYuanshenInfo value)
/*    */   {
/* 17 */     return (PartnerYuanshenInfo)_Tables_.getInstance().role2partner_yuanshen.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PartnerYuanshenInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2partner_yuanshen.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2partner_yuanshen.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PartnerYuanshenInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2partner_yuanshen.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2partner_yuanshen.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, PartnerYuanshenInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2partner_yuanshen.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PartnerYuanshenInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2partner_yuanshen;
/*    */   }
/*    */   
/*    */   public static PartnerYuanshenInfo select(Long key)
/*    */   {
/* 52 */     (PartnerYuanshenInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public PartnerYuanshenInfo get(PartnerYuanshenInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PartnerYuanshenPositionInfo> selectPosition_info_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PartnerYuanshenPositionInfo> get(PartnerYuanshenInfo v)
/*    */       {
/* 67 */         return v.getPosition_info_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2partner_yuanshen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */