/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.SingleBattleBuff;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Single_battle_buffs
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().single_battle_buffs.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().single_battle_buffs.getAutoKey(localid);
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
/*     */   public static Long insert(SingleBattleBuff value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, SingleBattleBuff value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static SingleBattleBuff get(Long key)
/*     */   {
/*  46 */     return (SingleBattleBuff)_Tables_.getInstance().single_battle_buffs.get(key);
/*     */   }
/*     */   
/*     */   public static SingleBattleBuff get(Long key, SingleBattleBuff value)
/*     */   {
/*  51 */     return (SingleBattleBuff)_Tables_.getInstance().single_battle_buffs.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, SingleBattleBuff value)
/*     */   {
/*  56 */     _Tables_.getInstance().single_battle_buffs.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, SingleBattleBuff value)
/*     */   {
/*  61 */     _Tables_.getInstance().single_battle_buffs.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().single_battle_buffs.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, SingleBattleBuff value)
/*     */   {
/*  71 */     return _Tables_.getInstance().single_battle_buffs.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, SingleBattleBuff value)
/*     */   {
/*  76 */     return _Tables_.getInstance().single_battle_buffs.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().single_battle_buffs.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, SingleBattleBuff> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().single_battle_buffs.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, SingleBattleBuff> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().single_battle_buffs;
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.BuffInfo> selectBuff_infos(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Integer, xbean.BuffInfo> get(SingleBattleBuff v)
/*     */       {
/* 100 */         return v.getBuff_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.ZoneInfo> selectZone_infos(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Integer, xbean.ZoneInfo> get(SingleBattleBuff v)
/*     */       {
/* 111 */         return v.getZone_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Single_battle_buffs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */