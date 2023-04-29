/*     */ package xtable;
/*     */ 
/*     */ import xbean.ChessGameInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Chessgameinfo
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().chessgameinfo.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().chessgameinfo.getAutoKey(localid);
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
/*     */   public static Long insert(ChessGameInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ChessGameInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ChessGameInfo get(Long key)
/*     */   {
/*  46 */     return (ChessGameInfo)_Tables_.getInstance().chessgameinfo.get(key);
/*     */   }
/*     */   
/*     */   public static ChessGameInfo get(Long key, ChessGameInfo value)
/*     */   {
/*  51 */     return (ChessGameInfo)_Tables_.getInstance().chessgameinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ChessGameInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().chessgameinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ChessGameInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().chessgameinfo.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().chessgameinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ChessGameInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().chessgameinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ChessGameInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().chessgameinfo.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().chessgameinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ChessGameInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().chessgameinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ChessGameInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().chessgameinfo;
/*     */   }
/*     */   
/*     */   public static ChessGameInfo select(Long key)
/*     */   {
/*  96 */     (ChessGameInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ChessGameInfo get(ChessGameInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectContext_id(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getContext_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCfg_id(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChessGameInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getCfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSession_id(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getSession_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStart_time(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 144 */         return Long.valueOf(v.getStart_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectPlayer_a(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getPlayer_a());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectPlayer_b(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 166 */         return Long.valueOf(v.getPlayer_b());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectCurrent_player_is_a(Long key)
/*     */   {
/* 173 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(ChessGameInfo v)
/*     */       {
/* 177 */         return Boolean.valueOf(v.getCurrent_player_is_a());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRound(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChessGameInfo v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getRound());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRound_start_time(Long key)
/*     */   {
/* 195 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 199 */         return Long.valueOf(v.getRound_start_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLast_kill_round(Long key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChessGameInfo v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getLast_kill_round());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPlayer_a_last_operate_round(Long key)
/*     */   {
/* 217 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChessGameInfo v)
/*     */       {
/* 221 */         return Integer.valueOf(v.getPlayer_a_last_operate_round());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPlayer_b_last_operate_round(Long key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChessGameInfo v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getPlayer_b_last_operate_round());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectNext_operate_time(Long key)
/*     */   {
/* 239 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChessGameInfo v)
/*     */       {
/* 243 */         return Long.valueOf(v.getNext_operate_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, xbean.ChessPiece> selectChess_board_index2chess_piece(Long key)
/*     */   {
/* 250 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, xbean.ChessPiece> get(ChessGameInfo v)
/*     */       {
/* 254 */         return v.getChess_board_index2chess_pieceAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Chessgameinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */