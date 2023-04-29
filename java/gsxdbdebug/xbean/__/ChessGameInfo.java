/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class ChessGameInfo extends XBean implements xbean.ChessGameInfo
/*      */ {
/*      */   private long context_id;
/*      */   private int cfg_id;
/*      */   private long session_id;
/*      */   private long start_time;
/*      */   private long player_a;
/*      */   private long player_b;
/*      */   private boolean current_player_is_a;
/*      */   private int round;
/*      */   private long round_start_time;
/*      */   private int last_kill_round;
/*      */   private int player_a_last_operate_round;
/*      */   private int player_b_last_operate_round;
/*      */   private long next_operate_time;
/*      */   private HashMap<Integer, xbean.ChessPiece> chess_board_index2chess_piece;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   44 */     this.context_id = 0L;
/*   45 */     this.cfg_id = 0;
/*   46 */     this.session_id = 0L;
/*   47 */     this.start_time = 0L;
/*   48 */     this.player_a = 0L;
/*   49 */     this.player_b = 0L;
/*   50 */     this.current_player_is_a = false;
/*   51 */     this.round = 1;
/*   52 */     this.round_start_time = 0L;
/*   53 */     this.last_kill_round = 0;
/*   54 */     this.player_a_last_operate_round = 0;
/*   55 */     this.player_b_last_operate_round = 0;
/*   56 */     this.next_operate_time = 0L;
/*   57 */     this.chess_board_index2chess_piece.clear();
/*      */   }
/*      */   
/*      */   ChessGameInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     this.round = 1;
/*   64 */     this.chess_board_index2chess_piece = new HashMap();
/*      */   }
/*      */   
/*      */   public ChessGameInfo()
/*      */   {
/*   69 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChessGameInfo(ChessGameInfo _o_)
/*      */   {
/*   74 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChessGameInfo(xbean.ChessGameInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   79 */     super(_xp_, _vn_);
/*   80 */     if ((_o1_ instanceof ChessGameInfo)) { assign((ChessGameInfo)_o1_);
/*   81 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   82 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   83 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChessGameInfo _o_) {
/*   88 */     _o_._xdb_verify_unsafe_();
/*   89 */     this.context_id = _o_.context_id;
/*   90 */     this.cfg_id = _o_.cfg_id;
/*   91 */     this.session_id = _o_.session_id;
/*   92 */     this.start_time = _o_.start_time;
/*   93 */     this.player_a = _o_.player_a;
/*   94 */     this.player_b = _o_.player_b;
/*   95 */     this.current_player_is_a = _o_.current_player_is_a;
/*   96 */     this.round = _o_.round;
/*   97 */     this.round_start_time = _o_.round_start_time;
/*   98 */     this.last_kill_round = _o_.last_kill_round;
/*   99 */     this.player_a_last_operate_round = _o_.player_a_last_operate_round;
/*  100 */     this.player_b_last_operate_round = _o_.player_b_last_operate_round;
/*  101 */     this.next_operate_time = _o_.next_operate_time;
/*  102 */     this.chess_board_index2chess_piece = new HashMap();
/*  103 */     for (Map.Entry<Integer, xbean.ChessPiece> _e_ : _o_.chess_board_index2chess_piece.entrySet()) {
/*  104 */       this.chess_board_index2chess_piece.put(_e_.getKey(), new ChessPiece((xbean.ChessPiece)_e_.getValue(), this, "chess_board_index2chess_piece"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  109 */     this.context_id = _o_.context_id;
/*  110 */     this.cfg_id = _o_.cfg_id;
/*  111 */     this.session_id = _o_.session_id;
/*  112 */     this.start_time = _o_.start_time;
/*  113 */     this.player_a = _o_.player_a;
/*  114 */     this.player_b = _o_.player_b;
/*  115 */     this.current_player_is_a = _o_.current_player_is_a;
/*  116 */     this.round = _o_.round;
/*  117 */     this.round_start_time = _o_.round_start_time;
/*  118 */     this.last_kill_round = _o_.last_kill_round;
/*  119 */     this.player_a_last_operate_round = _o_.player_a_last_operate_round;
/*  120 */     this.player_b_last_operate_round = _o_.player_b_last_operate_round;
/*  121 */     this.next_operate_time = _o_.next_operate_time;
/*  122 */     this.chess_board_index2chess_piece = new HashMap();
/*  123 */     for (Map.Entry<Integer, xbean.ChessPiece> _e_ : _o_.chess_board_index2chess_piece.entrySet()) {
/*  124 */       this.chess_board_index2chess_piece.put(_e_.getKey(), new ChessPiece((xbean.ChessPiece)_e_.getValue(), this, "chess_board_index2chess_piece"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*  131 */     _os_.marshal(this.context_id);
/*  132 */     _os_.marshal(this.cfg_id);
/*  133 */     _os_.marshal(this.session_id);
/*  134 */     _os_.marshal(this.start_time);
/*  135 */     _os_.marshal(this.player_a);
/*  136 */     _os_.marshal(this.player_b);
/*  137 */     _os_.marshal(this.current_player_is_a);
/*  138 */     _os_.marshal(this.round);
/*  139 */     _os_.marshal(this.round_start_time);
/*  140 */     _os_.marshal(this.last_kill_round);
/*  141 */     _os_.marshal(this.player_a_last_operate_round);
/*  142 */     _os_.marshal(this.player_b_last_operate_round);
/*  143 */     _os_.marshal(this.next_operate_time);
/*  144 */     _os_.compact_uint32(this.chess_board_index2chess_piece.size());
/*  145 */     for (Map.Entry<Integer, xbean.ChessPiece> _e_ : this.chess_board_index2chess_piece.entrySet())
/*      */     {
/*  147 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  148 */       ((xbean.ChessPiece)_e_.getValue()).marshal(_os_);
/*      */     }
/*  150 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*  157 */     this.context_id = _os_.unmarshal_long();
/*  158 */     this.cfg_id = _os_.unmarshal_int();
/*  159 */     this.session_id = _os_.unmarshal_long();
/*  160 */     this.start_time = _os_.unmarshal_long();
/*  161 */     this.player_a = _os_.unmarshal_long();
/*  162 */     this.player_b = _os_.unmarshal_long();
/*  163 */     this.current_player_is_a = _os_.unmarshal_boolean();
/*  164 */     this.round = _os_.unmarshal_int();
/*  165 */     this.round_start_time = _os_.unmarshal_long();
/*  166 */     this.last_kill_round = _os_.unmarshal_int();
/*  167 */     this.player_a_last_operate_round = _os_.unmarshal_int();
/*  168 */     this.player_b_last_operate_round = _os_.unmarshal_int();
/*  169 */     this.next_operate_time = _os_.unmarshal_long();
/*      */     
/*  171 */     int size = _os_.uncompact_uint32();
/*  172 */     if (size >= 12)
/*      */     {
/*  174 */       this.chess_board_index2chess_piece = new HashMap(size * 2);
/*      */     }
/*  176 */     for (; size > 0; size--)
/*      */     {
/*  178 */       int _k_ = 0;
/*  179 */       _k_ = _os_.unmarshal_int();
/*  180 */       xbean.ChessPiece _v_ = new ChessPiece(0, this, "chess_board_index2chess_piece");
/*  181 */       _v_.unmarshal(_os_);
/*  182 */       this.chess_board_index2chess_piece.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  185 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  191 */     _xdb_verify_unsafe_();
/*  192 */     int _size_ = 0;
/*  193 */     _size_ += CodedOutputStream.computeInt64Size(1, this.context_id);
/*  194 */     _size_ += CodedOutputStream.computeInt32Size(2, this.cfg_id);
/*  195 */     _size_ += CodedOutputStream.computeInt64Size(3, this.session_id);
/*  196 */     _size_ += CodedOutputStream.computeInt64Size(4, this.start_time);
/*  197 */     _size_ += CodedOutputStream.computeInt64Size(5, this.player_a);
/*  198 */     _size_ += CodedOutputStream.computeInt64Size(6, this.player_b);
/*  199 */     _size_ += CodedOutputStream.computeBoolSize(7, this.current_player_is_a);
/*  200 */     _size_ += CodedOutputStream.computeInt32Size(8, this.round);
/*  201 */     _size_ += CodedOutputStream.computeInt64Size(9, this.round_start_time);
/*  202 */     _size_ += CodedOutputStream.computeInt32Size(10, this.last_kill_round);
/*  203 */     _size_ += CodedOutputStream.computeInt32Size(11, this.player_a_last_operate_round);
/*  204 */     _size_ += CodedOutputStream.computeInt32Size(12, this.player_b_last_operate_round);
/*  205 */     _size_ += CodedOutputStream.computeInt64Size(13, this.next_operate_time);
/*  206 */     for (Map.Entry<Integer, xbean.ChessPiece> _e_ : this.chess_board_index2chess_piece.entrySet())
/*      */     {
/*  208 */       _size_ += CodedOutputStream.computeInt32Size(14, ((Integer)_e_.getKey()).intValue());
/*  209 */       _size_ += CodedOutputStream.computeMessageSize(14, (Message)_e_.getValue());
/*      */     }
/*  211 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  217 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  220 */       _output_.writeInt64(1, this.context_id);
/*  221 */       _output_.writeInt32(2, this.cfg_id);
/*  222 */       _output_.writeInt64(3, this.session_id);
/*  223 */       _output_.writeInt64(4, this.start_time);
/*  224 */       _output_.writeInt64(5, this.player_a);
/*  225 */       _output_.writeInt64(6, this.player_b);
/*  226 */       _output_.writeBool(7, this.current_player_is_a);
/*  227 */       _output_.writeInt32(8, this.round);
/*  228 */       _output_.writeInt64(9, this.round_start_time);
/*  229 */       _output_.writeInt32(10, this.last_kill_round);
/*  230 */       _output_.writeInt32(11, this.player_a_last_operate_round);
/*  231 */       _output_.writeInt32(12, this.player_b_last_operate_round);
/*  232 */       _output_.writeInt64(13, this.next_operate_time);
/*  233 */       for (Map.Entry<Integer, xbean.ChessPiece> _e_ : this.chess_board_index2chess_piece.entrySet())
/*      */       {
/*  235 */         _output_.writeInt32(14, ((Integer)_e_.getKey()).intValue());
/*  236 */         _output_.writeMessage(14, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  241 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  243 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  252 */       boolean done = false;
/*  253 */       while (!done)
/*      */       {
/*  255 */         int tag = _input_.readTag();
/*  256 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  260 */           done = true;
/*  261 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  265 */           this.context_id = _input_.readInt64();
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  270 */           this.cfg_id = _input_.readInt32();
/*  271 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  275 */           this.session_id = _input_.readInt64();
/*  276 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  280 */           this.start_time = _input_.readInt64();
/*  281 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  285 */           this.player_a = _input_.readInt64();
/*  286 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  290 */           this.player_b = _input_.readInt64();
/*  291 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  295 */           this.current_player_is_a = _input_.readBool();
/*  296 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  300 */           this.round = _input_.readInt32();
/*  301 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  305 */           this.round_start_time = _input_.readInt64();
/*  306 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  310 */           this.last_kill_round = _input_.readInt32();
/*  311 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  315 */           this.player_a_last_operate_round = _input_.readInt32();
/*  316 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  320 */           this.player_b_last_operate_round = _input_.readInt32();
/*  321 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  325 */           this.next_operate_time = _input_.readInt64();
/*  326 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  330 */           int _k_ = 0;
/*  331 */           _k_ = _input_.readInt32();
/*  332 */           int readTag = _input_.readTag();
/*  333 */           if (114 != readTag)
/*      */           {
/*  335 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  337 */           xbean.ChessPiece _v_ = new ChessPiece(0, this, "chess_board_index2chess_piece");
/*  338 */           _input_.readMessage(_v_);
/*  339 */           this.chess_board_index2chess_piece.put(Integer.valueOf(_k_), _v_);
/*  340 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  344 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  346 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  355 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  359 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  361 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChessGameInfo copy()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return new ChessGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChessGameInfo toData()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChessGameInfo toBean()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return new ChessGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChessGameInfo toDataIf()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChessGameInfo toBeanIf()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getContext_id()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     return this.context_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCfg_id()
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     return this.cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSession_id()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return this.session_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPlayer_a()
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     return this.player_a;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPlayer_b()
/*      */   {
/*  448 */     _xdb_verify_unsafe_();
/*  449 */     return this.player_b;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getCurrent_player_is_a()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     return this.current_player_is_a;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRound()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     return this.round;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRound_start_time()
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     return this.round_start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLast_kill_round()
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     return this.last_kill_round;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPlayer_a_last_operate_round()
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     return this.player_a_last_operate_round;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPlayer_b_last_operate_round()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     return this.player_b_last_operate_round;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNext_operate_time()
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*  505 */     return this.next_operate_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ChessPiece> getChess_board_index2chess_piece()
/*      */   {
/*  512 */     _xdb_verify_unsafe_();
/*  513 */     return Logs.logMap(new LogKey(this, "chess_board_index2chess_piece"), this.chess_board_index2chess_piece);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ChessPiece> getChess_board_index2chess_pieceAsData()
/*      */   {
/*  520 */     _xdb_verify_unsafe_();
/*      */     
/*  522 */     ChessGameInfo _o_ = this;
/*  523 */     Map<Integer, xbean.ChessPiece> chess_board_index2chess_piece = new HashMap();
/*  524 */     for (Map.Entry<Integer, xbean.ChessPiece> _e_ : _o_.chess_board_index2chess_piece.entrySet())
/*  525 */       chess_board_index2chess_piece.put(_e_.getKey(), new ChessPiece.Data((xbean.ChessPiece)_e_.getValue()));
/*  526 */     return chess_board_index2chess_piece;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setContext_id(long _v_)
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     Logs.logIf(new LogKey(this, "context_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  538 */         new LogLong(this, ChessGameInfo.this.context_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  542 */             ChessGameInfo.this.context_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  546 */     });
/*  547 */     this.context_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCfg_id(int _v_)
/*      */   {
/*  554 */     _xdb_verify_unsafe_();
/*  555 */     Logs.logIf(new LogKey(this, "cfg_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  559 */         new LogInt(this, ChessGameInfo.this.cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  563 */             ChessGameInfo.this.cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  567 */     });
/*  568 */     this.cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSession_id(long _v_)
/*      */   {
/*  575 */     _xdb_verify_unsafe_();
/*  576 */     Logs.logIf(new LogKey(this, "session_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  580 */         new LogLong(this, ChessGameInfo.this.session_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  584 */             ChessGameInfo.this.session_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  588 */     });
/*  589 */     this.session_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  596 */     _xdb_verify_unsafe_();
/*  597 */     Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  601 */         new LogLong(this, ChessGameInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  605 */             ChessGameInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  609 */     });
/*  610 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlayer_a(long _v_)
/*      */   {
/*  617 */     _xdb_verify_unsafe_();
/*  618 */     Logs.logIf(new LogKey(this, "player_a")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  622 */         new LogLong(this, ChessGameInfo.this.player_a)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  626 */             ChessGameInfo.this.player_a = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  630 */     });
/*  631 */     this.player_a = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlayer_b(long _v_)
/*      */   {
/*  638 */     _xdb_verify_unsafe_();
/*  639 */     Logs.logIf(new LogKey(this, "player_b")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  643 */         new LogLong(this, ChessGameInfo.this.player_b)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  647 */             ChessGameInfo.this.player_b = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  651 */     });
/*  652 */     this.player_b = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_player_is_a(boolean _v_)
/*      */   {
/*  659 */     _xdb_verify_unsafe_();
/*  660 */     Logs.logIf(new LogKey(this, "current_player_is_a")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  664 */         new LogObject(this, Boolean.valueOf(ChessGameInfo.this.current_player_is_a))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  668 */             ChessGameInfo.this.current_player_is_a = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  672 */     });
/*  673 */     this.current_player_is_a = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound(int _v_)
/*      */   {
/*  680 */     _xdb_verify_unsafe_();
/*  681 */     Logs.logIf(new LogKey(this, "round")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  685 */         new LogInt(this, ChessGameInfo.this.round)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  689 */             ChessGameInfo.this.round = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  693 */     });
/*  694 */     this.round = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRound_start_time(long _v_)
/*      */   {
/*  701 */     _xdb_verify_unsafe_();
/*  702 */     Logs.logIf(new LogKey(this, "round_start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  706 */         new LogLong(this, ChessGameInfo.this.round_start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  710 */             ChessGameInfo.this.round_start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  714 */     });
/*  715 */     this.round_start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_kill_round(int _v_)
/*      */   {
/*  722 */     _xdb_verify_unsafe_();
/*  723 */     Logs.logIf(new LogKey(this, "last_kill_round")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  727 */         new LogInt(this, ChessGameInfo.this.last_kill_round)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  731 */             ChessGameInfo.this.last_kill_round = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  735 */     });
/*  736 */     this.last_kill_round = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlayer_a_last_operate_round(int _v_)
/*      */   {
/*  743 */     _xdb_verify_unsafe_();
/*  744 */     Logs.logIf(new LogKey(this, "player_a_last_operate_round")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  748 */         new LogInt(this, ChessGameInfo.this.player_a_last_operate_round)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  752 */             ChessGameInfo.this.player_a_last_operate_round = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  756 */     });
/*  757 */     this.player_a_last_operate_round = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlayer_b_last_operate_round(int _v_)
/*      */   {
/*  764 */     _xdb_verify_unsafe_();
/*  765 */     Logs.logIf(new LogKey(this, "player_b_last_operate_round")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  769 */         new LogInt(this, ChessGameInfo.this.player_b_last_operate_round)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  773 */             ChessGameInfo.this.player_b_last_operate_round = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  777 */     });
/*  778 */     this.player_b_last_operate_round = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNext_operate_time(long _v_)
/*      */   {
/*  785 */     _xdb_verify_unsafe_();
/*  786 */     Logs.logIf(new LogKey(this, "next_operate_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  790 */         new LogLong(this, ChessGameInfo.this.next_operate_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  794 */             ChessGameInfo.this.next_operate_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  798 */     });
/*  799 */     this.next_operate_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  805 */     _xdb_verify_unsafe_();
/*  806 */     ChessGameInfo _o_ = null;
/*  807 */     if ((_o1_ instanceof ChessGameInfo)) { _o_ = (ChessGameInfo)_o1_;
/*  808 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  809 */       return false;
/*  810 */     if (this.context_id != _o_.context_id) return false;
/*  811 */     if (this.cfg_id != _o_.cfg_id) return false;
/*  812 */     if (this.session_id != _o_.session_id) return false;
/*  813 */     if (this.start_time != _o_.start_time) return false;
/*  814 */     if (this.player_a != _o_.player_a) return false;
/*  815 */     if (this.player_b != _o_.player_b) return false;
/*  816 */     if (this.current_player_is_a != _o_.current_player_is_a) return false;
/*  817 */     if (this.round != _o_.round) return false;
/*  818 */     if (this.round_start_time != _o_.round_start_time) return false;
/*  819 */     if (this.last_kill_round != _o_.last_kill_round) return false;
/*  820 */     if (this.player_a_last_operate_round != _o_.player_a_last_operate_round) return false;
/*  821 */     if (this.player_b_last_operate_round != _o_.player_b_last_operate_round) return false;
/*  822 */     if (this.next_operate_time != _o_.next_operate_time) return false;
/*  823 */     if (!this.chess_board_index2chess_piece.equals(_o_.chess_board_index2chess_piece)) return false;
/*  824 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  830 */     _xdb_verify_unsafe_();
/*  831 */     int _h_ = 0;
/*  832 */     _h_ = (int)(_h_ + this.context_id);
/*  833 */     _h_ += this.cfg_id;
/*  834 */     _h_ = (int)(_h_ + this.session_id);
/*  835 */     _h_ = (int)(_h_ + this.start_time);
/*  836 */     _h_ = (int)(_h_ + this.player_a);
/*  837 */     _h_ = (int)(_h_ + this.player_b);
/*  838 */     _h_ += (this.current_player_is_a ? 1231 : 1237);
/*  839 */     _h_ += this.round;
/*  840 */     _h_ = (int)(_h_ + this.round_start_time);
/*  841 */     _h_ += this.last_kill_round;
/*  842 */     _h_ += this.player_a_last_operate_round;
/*  843 */     _h_ += this.player_b_last_operate_round;
/*  844 */     _h_ = (int)(_h_ + this.next_operate_time);
/*  845 */     _h_ += this.chess_board_index2chess_piece.hashCode();
/*  846 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  852 */     _xdb_verify_unsafe_();
/*  853 */     StringBuilder _sb_ = new StringBuilder();
/*  854 */     _sb_.append("(");
/*  855 */     _sb_.append(this.context_id);
/*  856 */     _sb_.append(",");
/*  857 */     _sb_.append(this.cfg_id);
/*  858 */     _sb_.append(",");
/*  859 */     _sb_.append(this.session_id);
/*  860 */     _sb_.append(",");
/*  861 */     _sb_.append(this.start_time);
/*  862 */     _sb_.append(",");
/*  863 */     _sb_.append(this.player_a);
/*  864 */     _sb_.append(",");
/*  865 */     _sb_.append(this.player_b);
/*  866 */     _sb_.append(",");
/*  867 */     _sb_.append(this.current_player_is_a);
/*  868 */     _sb_.append(",");
/*  869 */     _sb_.append(this.round);
/*  870 */     _sb_.append(",");
/*  871 */     _sb_.append(this.round_start_time);
/*  872 */     _sb_.append(",");
/*  873 */     _sb_.append(this.last_kill_round);
/*  874 */     _sb_.append(",");
/*  875 */     _sb_.append(this.player_a_last_operate_round);
/*  876 */     _sb_.append(",");
/*  877 */     _sb_.append(this.player_b_last_operate_round);
/*  878 */     _sb_.append(",");
/*  879 */     _sb_.append(this.next_operate_time);
/*  880 */     _sb_.append(",");
/*  881 */     _sb_.append(this.chess_board_index2chess_piece);
/*  882 */     _sb_.append(")");
/*  883 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  889 */     ListenableBean lb = new ListenableBean();
/*  890 */     lb.add(new ListenableChanged().setVarName("context_id"));
/*  891 */     lb.add(new ListenableChanged().setVarName("cfg_id"));
/*  892 */     lb.add(new ListenableChanged().setVarName("session_id"));
/*  893 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  894 */     lb.add(new ListenableChanged().setVarName("player_a"));
/*  895 */     lb.add(new ListenableChanged().setVarName("player_b"));
/*  896 */     lb.add(new ListenableChanged().setVarName("current_player_is_a"));
/*  897 */     lb.add(new ListenableChanged().setVarName("round"));
/*  898 */     lb.add(new ListenableChanged().setVarName("round_start_time"));
/*  899 */     lb.add(new ListenableChanged().setVarName("last_kill_round"));
/*  900 */     lb.add(new ListenableChanged().setVarName("player_a_last_operate_round"));
/*  901 */     lb.add(new ListenableChanged().setVarName("player_b_last_operate_round"));
/*  902 */     lb.add(new ListenableChanged().setVarName("next_operate_time"));
/*  903 */     lb.add(new ListenableMap().setVarName("chess_board_index2chess_piece"));
/*  904 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChessGameInfo {
/*      */     private Const() {}
/*      */     
/*      */     ChessGameInfo nThis() {
/*  911 */       return ChessGameInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  917 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChessGameInfo copy()
/*      */     {
/*  923 */       return ChessGameInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChessGameInfo toData()
/*      */     {
/*  929 */       return ChessGameInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChessGameInfo toBean()
/*      */     {
/*  934 */       return ChessGameInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChessGameInfo toDataIf()
/*      */     {
/*  940 */       return ChessGameInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChessGameInfo toBeanIf()
/*      */     {
/*  945 */       return ChessGameInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getContext_id()
/*      */     {
/*  952 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*  953 */       return ChessGameInfo.this.context_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfg_id()
/*      */     {
/*  960 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*  961 */       return ChessGameInfo.this.cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/*  968 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*  969 */       return ChessGameInfo.this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  976 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*  977 */       return ChessGameInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPlayer_a()
/*      */     {
/*  984 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*  985 */       return ChessGameInfo.this.player_a;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPlayer_b()
/*      */     {
/*  992 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*  993 */       return ChessGameInfo.this.player_b;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getCurrent_player_is_a()
/*      */     {
/* 1000 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1001 */       return ChessGameInfo.this.current_player_is_a;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound()
/*      */     {
/* 1008 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1009 */       return ChessGameInfo.this.round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRound_start_time()
/*      */     {
/* 1016 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1017 */       return ChessGameInfo.this.round_start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLast_kill_round()
/*      */     {
/* 1024 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1025 */       return ChessGameInfo.this.last_kill_round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_a_last_operate_round()
/*      */     {
/* 1032 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1033 */       return ChessGameInfo.this.player_a_last_operate_round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_b_last_operate_round()
/*      */     {
/* 1040 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1041 */       return ChessGameInfo.this.player_b_last_operate_round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNext_operate_time()
/*      */     {
/* 1048 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1049 */       return ChessGameInfo.this.next_operate_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChessPiece> getChess_board_index2chess_piece()
/*      */     {
/* 1056 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1057 */       return xdb.Consts.constMap(ChessGameInfo.this.chess_board_index2chess_piece);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChessPiece> getChess_board_index2chess_pieceAsData()
/*      */     {
/* 1064 */       ChessGameInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1066 */       ChessGameInfo _o_ = ChessGameInfo.this;
/* 1067 */       Map<Integer, xbean.ChessPiece> chess_board_index2chess_piece = new HashMap();
/* 1068 */       for (Map.Entry<Integer, xbean.ChessPiece> _e_ : _o_.chess_board_index2chess_piece.entrySet())
/* 1069 */         chess_board_index2chess_piece.put(_e_.getKey(), new ChessPiece.Data((xbean.ChessPiece)_e_.getValue()));
/* 1070 */       return chess_board_index2chess_piece;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContext_id(long _v_)
/*      */     {
/* 1077 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1078 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfg_id(int _v_)
/*      */     {
/* 1085 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1086 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/* 1093 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1094 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1101 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1102 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_a(long _v_)
/*      */     {
/* 1109 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1110 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_b(long _v_)
/*      */     {
/* 1117 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1118 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_player_is_a(boolean _v_)
/*      */     {
/* 1125 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1126 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound(int _v_)
/*      */     {
/* 1133 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1134 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_start_time(long _v_)
/*      */     {
/* 1141 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1142 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_kill_round(int _v_)
/*      */     {
/* 1149 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1150 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_a_last_operate_round(int _v_)
/*      */     {
/* 1157 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1158 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_b_last_operate_round(int _v_)
/*      */     {
/* 1165 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1166 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNext_operate_time(long _v_)
/*      */     {
/* 1173 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1174 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1180 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1181 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1187 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1188 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1194 */       return ChessGameInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1200 */       return ChessGameInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1206 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1213 */       return ChessGameInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1219 */       return ChessGameInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1225 */       ChessGameInfo.this._xdb_verify_unsafe_();
/* 1226 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1232 */       return ChessGameInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1238 */       return ChessGameInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1244 */       return ChessGameInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1250 */       return ChessGameInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1256 */       return ChessGameInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1262 */       return ChessGameInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1268 */       return ChessGameInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChessGameInfo
/*      */   {
/*      */     private long context_id;
/*      */     
/*      */     private int cfg_id;
/*      */     
/*      */     private long session_id;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private long player_a;
/*      */     
/*      */     private long player_b;
/*      */     
/*      */     private boolean current_player_is_a;
/*      */     
/*      */     private int round;
/*      */     
/*      */     private long round_start_time;
/*      */     
/*      */     private int last_kill_round;
/*      */     
/*      */     private int player_a_last_operate_round;
/*      */     
/*      */     private int player_b_last_operate_round;
/*      */     
/*      */     private long next_operate_time;
/*      */     
/*      */     private HashMap<Integer, xbean.ChessPiece> chess_board_index2chess_piece;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1306 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1311 */       this.round = 1;
/* 1312 */       this.chess_board_index2chess_piece = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ChessGameInfo _o1_)
/*      */     {
/* 1317 */       if ((_o1_ instanceof ChessGameInfo)) { assign((ChessGameInfo)_o1_);
/* 1318 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1319 */       } else if ((_o1_ instanceof ChessGameInfo.Const)) assign(((ChessGameInfo.Const)_o1_).nThis()); else {
/* 1320 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChessGameInfo _o_) {
/* 1325 */       this.context_id = _o_.context_id;
/* 1326 */       this.cfg_id = _o_.cfg_id;
/* 1327 */       this.session_id = _o_.session_id;
/* 1328 */       this.start_time = _o_.start_time;
/* 1329 */       this.player_a = _o_.player_a;
/* 1330 */       this.player_b = _o_.player_b;
/* 1331 */       this.current_player_is_a = _o_.current_player_is_a;
/* 1332 */       this.round = _o_.round;
/* 1333 */       this.round_start_time = _o_.round_start_time;
/* 1334 */       this.last_kill_round = _o_.last_kill_round;
/* 1335 */       this.player_a_last_operate_round = _o_.player_a_last_operate_round;
/* 1336 */       this.player_b_last_operate_round = _o_.player_b_last_operate_round;
/* 1337 */       this.next_operate_time = _o_.next_operate_time;
/* 1338 */       this.chess_board_index2chess_piece = new HashMap();
/* 1339 */       for (Map.Entry<Integer, xbean.ChessPiece> _e_ : _o_.chess_board_index2chess_piece.entrySet()) {
/* 1340 */         this.chess_board_index2chess_piece.put(_e_.getKey(), new ChessPiece.Data((xbean.ChessPiece)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1345 */       this.context_id = _o_.context_id;
/* 1346 */       this.cfg_id = _o_.cfg_id;
/* 1347 */       this.session_id = _o_.session_id;
/* 1348 */       this.start_time = _o_.start_time;
/* 1349 */       this.player_a = _o_.player_a;
/* 1350 */       this.player_b = _o_.player_b;
/* 1351 */       this.current_player_is_a = _o_.current_player_is_a;
/* 1352 */       this.round = _o_.round;
/* 1353 */       this.round_start_time = _o_.round_start_time;
/* 1354 */       this.last_kill_round = _o_.last_kill_round;
/* 1355 */       this.player_a_last_operate_round = _o_.player_a_last_operate_round;
/* 1356 */       this.player_b_last_operate_round = _o_.player_b_last_operate_round;
/* 1357 */       this.next_operate_time = _o_.next_operate_time;
/* 1358 */       this.chess_board_index2chess_piece = new HashMap();
/* 1359 */       for (Map.Entry<Integer, xbean.ChessPiece> _e_ : _o_.chess_board_index2chess_piece.entrySet()) {
/* 1360 */         this.chess_board_index2chess_piece.put(_e_.getKey(), new ChessPiece.Data((xbean.ChessPiece)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1366 */       _os_.marshal(this.context_id);
/* 1367 */       _os_.marshal(this.cfg_id);
/* 1368 */       _os_.marshal(this.session_id);
/* 1369 */       _os_.marshal(this.start_time);
/* 1370 */       _os_.marshal(this.player_a);
/* 1371 */       _os_.marshal(this.player_b);
/* 1372 */       _os_.marshal(this.current_player_is_a);
/* 1373 */       _os_.marshal(this.round);
/* 1374 */       _os_.marshal(this.round_start_time);
/* 1375 */       _os_.marshal(this.last_kill_round);
/* 1376 */       _os_.marshal(this.player_a_last_operate_round);
/* 1377 */       _os_.marshal(this.player_b_last_operate_round);
/* 1378 */       _os_.marshal(this.next_operate_time);
/* 1379 */       _os_.compact_uint32(this.chess_board_index2chess_piece.size());
/* 1380 */       for (Map.Entry<Integer, xbean.ChessPiece> _e_ : this.chess_board_index2chess_piece.entrySet())
/*      */       {
/* 1382 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1383 */         ((xbean.ChessPiece)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1385 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1391 */       this.context_id = _os_.unmarshal_long();
/* 1392 */       this.cfg_id = _os_.unmarshal_int();
/* 1393 */       this.session_id = _os_.unmarshal_long();
/* 1394 */       this.start_time = _os_.unmarshal_long();
/* 1395 */       this.player_a = _os_.unmarshal_long();
/* 1396 */       this.player_b = _os_.unmarshal_long();
/* 1397 */       this.current_player_is_a = _os_.unmarshal_boolean();
/* 1398 */       this.round = _os_.unmarshal_int();
/* 1399 */       this.round_start_time = _os_.unmarshal_long();
/* 1400 */       this.last_kill_round = _os_.unmarshal_int();
/* 1401 */       this.player_a_last_operate_round = _os_.unmarshal_int();
/* 1402 */       this.player_b_last_operate_round = _os_.unmarshal_int();
/* 1403 */       this.next_operate_time = _os_.unmarshal_long();
/*      */       
/* 1405 */       int size = _os_.uncompact_uint32();
/* 1406 */       if (size >= 12)
/*      */       {
/* 1408 */         this.chess_board_index2chess_piece = new HashMap(size * 2);
/*      */       }
/* 1410 */       for (; size > 0; size--)
/*      */       {
/* 1412 */         int _k_ = 0;
/* 1413 */         _k_ = _os_.unmarshal_int();
/* 1414 */         xbean.ChessPiece _v_ = xbean.Pod.newChessPieceData();
/* 1415 */         _v_.unmarshal(_os_);
/* 1416 */         this.chess_board_index2chess_piece.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1419 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1425 */       int _size_ = 0;
/* 1426 */       _size_ += CodedOutputStream.computeInt64Size(1, this.context_id);
/* 1427 */       _size_ += CodedOutputStream.computeInt32Size(2, this.cfg_id);
/* 1428 */       _size_ += CodedOutputStream.computeInt64Size(3, this.session_id);
/* 1429 */       _size_ += CodedOutputStream.computeInt64Size(4, this.start_time);
/* 1430 */       _size_ += CodedOutputStream.computeInt64Size(5, this.player_a);
/* 1431 */       _size_ += CodedOutputStream.computeInt64Size(6, this.player_b);
/* 1432 */       _size_ += CodedOutputStream.computeBoolSize(7, this.current_player_is_a);
/* 1433 */       _size_ += CodedOutputStream.computeInt32Size(8, this.round);
/* 1434 */       _size_ += CodedOutputStream.computeInt64Size(9, this.round_start_time);
/* 1435 */       _size_ += CodedOutputStream.computeInt32Size(10, this.last_kill_round);
/* 1436 */       _size_ += CodedOutputStream.computeInt32Size(11, this.player_a_last_operate_round);
/* 1437 */       _size_ += CodedOutputStream.computeInt32Size(12, this.player_b_last_operate_round);
/* 1438 */       _size_ += CodedOutputStream.computeInt64Size(13, this.next_operate_time);
/* 1439 */       for (Map.Entry<Integer, xbean.ChessPiece> _e_ : this.chess_board_index2chess_piece.entrySet())
/*      */       {
/* 1441 */         _size_ += CodedOutputStream.computeInt32Size(14, ((Integer)_e_.getKey()).intValue());
/* 1442 */         _size_ += CodedOutputStream.computeMessageSize(14, (Message)_e_.getValue());
/*      */       }
/* 1444 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1452 */         _output_.writeInt64(1, this.context_id);
/* 1453 */         _output_.writeInt32(2, this.cfg_id);
/* 1454 */         _output_.writeInt64(3, this.session_id);
/* 1455 */         _output_.writeInt64(4, this.start_time);
/* 1456 */         _output_.writeInt64(5, this.player_a);
/* 1457 */         _output_.writeInt64(6, this.player_b);
/* 1458 */         _output_.writeBool(7, this.current_player_is_a);
/* 1459 */         _output_.writeInt32(8, this.round);
/* 1460 */         _output_.writeInt64(9, this.round_start_time);
/* 1461 */         _output_.writeInt32(10, this.last_kill_round);
/* 1462 */         _output_.writeInt32(11, this.player_a_last_operate_round);
/* 1463 */         _output_.writeInt32(12, this.player_b_last_operate_round);
/* 1464 */         _output_.writeInt64(13, this.next_operate_time);
/* 1465 */         for (Map.Entry<Integer, xbean.ChessPiece> _e_ : this.chess_board_index2chess_piece.entrySet())
/*      */         {
/* 1467 */           _output_.writeInt32(14, ((Integer)_e_.getKey()).intValue());
/* 1468 */           _output_.writeMessage(14, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1473 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1475 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1483 */         boolean done = false;
/* 1484 */         while (!done)
/*      */         {
/* 1486 */           int tag = _input_.readTag();
/* 1487 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1491 */             done = true;
/* 1492 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1496 */             this.context_id = _input_.readInt64();
/* 1497 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1501 */             this.cfg_id = _input_.readInt32();
/* 1502 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1506 */             this.session_id = _input_.readInt64();
/* 1507 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1511 */             this.start_time = _input_.readInt64();
/* 1512 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1516 */             this.player_a = _input_.readInt64();
/* 1517 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1521 */             this.player_b = _input_.readInt64();
/* 1522 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1526 */             this.current_player_is_a = _input_.readBool();
/* 1527 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1531 */             this.round = _input_.readInt32();
/* 1532 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1536 */             this.round_start_time = _input_.readInt64();
/* 1537 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1541 */             this.last_kill_round = _input_.readInt32();
/* 1542 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1546 */             this.player_a_last_operate_round = _input_.readInt32();
/* 1547 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1551 */             this.player_b_last_operate_round = _input_.readInt32();
/* 1552 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1556 */             this.next_operate_time = _input_.readInt64();
/* 1557 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1561 */             int _k_ = 0;
/* 1562 */             _k_ = _input_.readInt32();
/* 1563 */             int readTag = _input_.readTag();
/* 1564 */             if (114 != readTag)
/*      */             {
/* 1566 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1568 */             xbean.ChessPiece _v_ = xbean.Pod.newChessPieceData();
/* 1569 */             _input_.readMessage(_v_);
/* 1570 */             this.chess_board_index2chess_piece.put(Integer.valueOf(_k_), _v_);
/* 1571 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1575 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1577 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1586 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1590 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1592 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChessGameInfo copy()
/*      */     {
/* 1598 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChessGameInfo toData()
/*      */     {
/* 1604 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChessGameInfo toBean()
/*      */     {
/* 1609 */       return new ChessGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChessGameInfo toDataIf()
/*      */     {
/* 1615 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChessGameInfo toBeanIf()
/*      */     {
/* 1620 */       return new ChessGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1626 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1642 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1646 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1650 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getContext_id()
/*      */     {
/* 1657 */       return this.context_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfg_id()
/*      */     {
/* 1664 */       return this.cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/* 1671 */       return this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/* 1678 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPlayer_a()
/*      */     {
/* 1685 */       return this.player_a;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPlayer_b()
/*      */     {
/* 1692 */       return this.player_b;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getCurrent_player_is_a()
/*      */     {
/* 1699 */       return this.current_player_is_a;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRound()
/*      */     {
/* 1706 */       return this.round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRound_start_time()
/*      */     {
/* 1713 */       return this.round_start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLast_kill_round()
/*      */     {
/* 1720 */       return this.last_kill_round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_a_last_operate_round()
/*      */     {
/* 1727 */       return this.player_a_last_operate_round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_b_last_operate_round()
/*      */     {
/* 1734 */       return this.player_b_last_operate_round;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNext_operate_time()
/*      */     {
/* 1741 */       return this.next_operate_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChessPiece> getChess_board_index2chess_piece()
/*      */     {
/* 1748 */       return this.chess_board_index2chess_piece;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChessPiece> getChess_board_index2chess_pieceAsData()
/*      */     {
/* 1755 */       return this.chess_board_index2chess_piece;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContext_id(long _v_)
/*      */     {
/* 1762 */       this.context_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfg_id(int _v_)
/*      */     {
/* 1769 */       this.cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/* 1776 */       this.session_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1783 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_a(long _v_)
/*      */     {
/* 1790 */       this.player_a = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_b(long _v_)
/*      */     {
/* 1797 */       this.player_b = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_player_is_a(boolean _v_)
/*      */     {
/* 1804 */       this.current_player_is_a = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound(int _v_)
/*      */     {
/* 1811 */       this.round = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRound_start_time(long _v_)
/*      */     {
/* 1818 */       this.round_start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_kill_round(int _v_)
/*      */     {
/* 1825 */       this.last_kill_round = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_a_last_operate_round(int _v_)
/*      */     {
/* 1832 */       this.player_a_last_operate_round = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_b_last_operate_round(int _v_)
/*      */     {
/* 1839 */       this.player_b_last_operate_round = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNext_operate_time(long _v_)
/*      */     {
/* 1846 */       this.next_operate_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1852 */       if (!(_o1_ instanceof Data)) return false;
/* 1853 */       Data _o_ = (Data)_o1_;
/* 1854 */       if (this.context_id != _o_.context_id) return false;
/* 1855 */       if (this.cfg_id != _o_.cfg_id) return false;
/* 1856 */       if (this.session_id != _o_.session_id) return false;
/* 1857 */       if (this.start_time != _o_.start_time) return false;
/* 1858 */       if (this.player_a != _o_.player_a) return false;
/* 1859 */       if (this.player_b != _o_.player_b) return false;
/* 1860 */       if (this.current_player_is_a != _o_.current_player_is_a) return false;
/* 1861 */       if (this.round != _o_.round) return false;
/* 1862 */       if (this.round_start_time != _o_.round_start_time) return false;
/* 1863 */       if (this.last_kill_round != _o_.last_kill_round) return false;
/* 1864 */       if (this.player_a_last_operate_round != _o_.player_a_last_operate_round) return false;
/* 1865 */       if (this.player_b_last_operate_round != _o_.player_b_last_operate_round) return false;
/* 1866 */       if (this.next_operate_time != _o_.next_operate_time) return false;
/* 1867 */       if (!this.chess_board_index2chess_piece.equals(_o_.chess_board_index2chess_piece)) return false;
/* 1868 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1874 */       int _h_ = 0;
/* 1875 */       _h_ = (int)(_h_ + this.context_id);
/* 1876 */       _h_ += this.cfg_id;
/* 1877 */       _h_ = (int)(_h_ + this.session_id);
/* 1878 */       _h_ = (int)(_h_ + this.start_time);
/* 1879 */       _h_ = (int)(_h_ + this.player_a);
/* 1880 */       _h_ = (int)(_h_ + this.player_b);
/* 1881 */       _h_ += (this.current_player_is_a ? 1231 : 1237);
/* 1882 */       _h_ += this.round;
/* 1883 */       _h_ = (int)(_h_ + this.round_start_time);
/* 1884 */       _h_ += this.last_kill_round;
/* 1885 */       _h_ += this.player_a_last_operate_round;
/* 1886 */       _h_ += this.player_b_last_operate_round;
/* 1887 */       _h_ = (int)(_h_ + this.next_operate_time);
/* 1888 */       _h_ += this.chess_board_index2chess_piece.hashCode();
/* 1889 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1895 */       StringBuilder _sb_ = new StringBuilder();
/* 1896 */       _sb_.append("(");
/* 1897 */       _sb_.append(this.context_id);
/* 1898 */       _sb_.append(",");
/* 1899 */       _sb_.append(this.cfg_id);
/* 1900 */       _sb_.append(",");
/* 1901 */       _sb_.append(this.session_id);
/* 1902 */       _sb_.append(",");
/* 1903 */       _sb_.append(this.start_time);
/* 1904 */       _sb_.append(",");
/* 1905 */       _sb_.append(this.player_a);
/* 1906 */       _sb_.append(",");
/* 1907 */       _sb_.append(this.player_b);
/* 1908 */       _sb_.append(",");
/* 1909 */       _sb_.append(this.current_player_is_a);
/* 1910 */       _sb_.append(",");
/* 1911 */       _sb_.append(this.round);
/* 1912 */       _sb_.append(",");
/* 1913 */       _sb_.append(this.round_start_time);
/* 1914 */       _sb_.append(",");
/* 1915 */       _sb_.append(this.last_kill_round);
/* 1916 */       _sb_.append(",");
/* 1917 */       _sb_.append(this.player_a_last_operate_round);
/* 1918 */       _sb_.append(",");
/* 1919 */       _sb_.append(this.player_b_last_operate_round);
/* 1920 */       _sb_.append(",");
/* 1921 */       _sb_.append(this.next_operate_time);
/* 1922 */       _sb_.append(",");
/* 1923 */       _sb_.append(this.chess_board_index2chess_piece);
/* 1924 */       _sb_.append(")");
/* 1925 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChessGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */