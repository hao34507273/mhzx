/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.VoipRoom;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Team_voip_rooms
/*     */ {
/*     */   public static VoipRoom get(Long key)
/*     */   {
/*  12 */     return (VoipRoom)_Tables_.getInstance().team_voip_rooms.get(key);
/*     */   }
/*     */   
/*     */   public static VoipRoom get(Long key, VoipRoom value)
/*     */   {
/*  17 */     return (VoipRoom)_Tables_.getInstance().team_voip_rooms.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, VoipRoom value)
/*     */   {
/*  22 */     _Tables_.getInstance().team_voip_rooms.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().team_voip_rooms.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, VoipRoom value)
/*     */   {
/*  32 */     return _Tables_.getInstance().team_voip_rooms.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().team_voip_rooms.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, VoipRoom> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().team_voip_rooms.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, VoipRoom> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().team_voip_rooms;
/*     */   }
/*     */   
/*     */   public static Integer selectRoom_state(Long key)
/*     */   {
/*  52 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(VoipRoom v)
/*     */       {
/*  56 */         return Integer.valueOf(v.getRoom_state());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoom_id(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(VoipRoom v)
/*     */       {
/*  67 */         return Long.valueOf(v.getRoom_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectPending_list(Long key)
/*     */   {
/*  74 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(VoipRoom v)
/*     */       {
/*  78 */         return v.getPending_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreater_id(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(VoipRoom v)
/*     */       {
/*  89 */         return Long.valueOf(v.getCreater_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectClose_sessionid(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(VoipRoom v)
/*     */       {
/* 100 */         return Long.valueOf(v.getClose_sessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTry_close_times(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(VoipRoom v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getTry_close_times());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Team_voip_rooms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */