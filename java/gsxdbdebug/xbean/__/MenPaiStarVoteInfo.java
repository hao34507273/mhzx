/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class MenPaiStarVoteInfo extends XBean implements xbean.MenPaiStarVoteInfo
/*      */ {
/*      */   private int vote;
/*      */   private int today_vote_num;
/*      */   private long last_vote_time;
/*      */   private int vote_num;
/*      */   private HashMap<Long, Long> world_canvass;
/*      */   private HashMap<Long, Long> gang_canvass;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.vote = 0;
/*   29 */     this.today_vote_num = 0;
/*   30 */     this.last_vote_time = 0L;
/*   31 */     this.vote_num = 0;
/*   32 */     this.world_canvass.clear();
/*   33 */     this.gang_canvass.clear();
/*      */   }
/*      */   
/*      */   MenPaiStarVoteInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.world_canvass = new HashMap();
/*   40 */     this.gang_canvass = new HashMap();
/*      */   }
/*      */   
/*      */   public MenPaiStarVoteInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MenPaiStarVoteInfo(MenPaiStarVoteInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MenPaiStarVoteInfo(xbean.MenPaiStarVoteInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof MenPaiStarVoteInfo)) { assign((MenPaiStarVoteInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MenPaiStarVoteInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.vote = _o_.vote;
/*   66 */     this.today_vote_num = _o_.today_vote_num;
/*   67 */     this.last_vote_time = _o_.last_vote_time;
/*   68 */     this.vote_num = _o_.vote_num;
/*   69 */     this.world_canvass = new HashMap();
/*   70 */     for (Map.Entry<Long, Long> _e_ : _o_.world_canvass.entrySet())
/*   71 */       this.world_canvass.put(_e_.getKey(), _e_.getValue());
/*   72 */     this.gang_canvass = new HashMap();
/*   73 */     for (Map.Entry<Long, Long> _e_ : _o_.gang_canvass.entrySet()) {
/*   74 */       this.gang_canvass.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   79 */     this.vote = _o_.vote;
/*   80 */     this.today_vote_num = _o_.today_vote_num;
/*   81 */     this.last_vote_time = _o_.last_vote_time;
/*   82 */     this.vote_num = _o_.vote_num;
/*   83 */     this.world_canvass = new HashMap();
/*   84 */     for (Map.Entry<Long, Long> _e_ : _o_.world_canvass.entrySet())
/*   85 */       this.world_canvass.put(_e_.getKey(), _e_.getValue());
/*   86 */     this.gang_canvass = new HashMap();
/*   87 */     for (Map.Entry<Long, Long> _e_ : _o_.gang_canvass.entrySet()) {
/*   88 */       this.gang_canvass.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.vote);
/*   96 */     _os_.marshal(this.today_vote_num);
/*   97 */     _os_.marshal(this.last_vote_time);
/*   98 */     _os_.marshal(this.vote_num);
/*   99 */     _os_.compact_uint32(this.world_canvass.size());
/*  100 */     for (Map.Entry<Long, Long> _e_ : this.world_canvass.entrySet())
/*      */     {
/*  102 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  103 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  105 */     _os_.compact_uint32(this.gang_canvass.size());
/*  106 */     for (Map.Entry<Long, Long> _e_ : this.gang_canvass.entrySet())
/*      */     {
/*  108 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  109 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     this.vote = _os_.unmarshal_int();
/*  119 */     this.today_vote_num = _os_.unmarshal_int();
/*  120 */     this.last_vote_time = _os_.unmarshal_long();
/*  121 */     this.vote_num = _os_.unmarshal_int();
/*      */     
/*  123 */     int size = _os_.uncompact_uint32();
/*  124 */     if (size >= 12)
/*      */     {
/*  126 */       this.world_canvass = new HashMap(size * 2);
/*      */     }
/*  128 */     for (; size > 0; size--)
/*      */     {
/*  130 */       long _k_ = 0L;
/*  131 */       _k_ = _os_.unmarshal_long();
/*  132 */       long _v_ = 0L;
/*  133 */       _v_ = _os_.unmarshal_long();
/*  134 */       this.world_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  138 */     int size = _os_.uncompact_uint32();
/*  139 */     if (size >= 12)
/*      */     {
/*  141 */       this.gang_canvass = new HashMap(size * 2);
/*      */     }
/*  143 */     for (; size > 0; size--)
/*      */     {
/*  145 */       long _k_ = 0L;
/*  146 */       _k_ = _os_.unmarshal_long();
/*  147 */       long _v_ = 0L;
/*  148 */       _v_ = _os_.unmarshal_long();
/*  149 */       this.gang_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  152 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  158 */     _xdb_verify_unsafe_();
/*  159 */     int _size_ = 0;
/*  160 */     _size_ += CodedOutputStream.computeInt32Size(1, this.vote);
/*  161 */     _size_ += CodedOutputStream.computeInt32Size(2, this.today_vote_num);
/*  162 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_vote_time);
/*  163 */     _size_ += CodedOutputStream.computeInt32Size(4, this.vote_num);
/*  164 */     for (Map.Entry<Long, Long> _e_ : this.world_canvass.entrySet())
/*      */     {
/*  166 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  167 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  169 */     for (Map.Entry<Long, Long> _e_ : this.gang_canvass.entrySet())
/*      */     {
/*  171 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/*  172 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  174 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       _output_.writeInt32(1, this.vote);
/*  184 */       _output_.writeInt32(2, this.today_vote_num);
/*  185 */       _output_.writeInt64(3, this.last_vote_time);
/*  186 */       _output_.writeInt32(4, this.vote_num);
/*  187 */       for (Map.Entry<Long, Long> _e_ : this.world_canvass.entrySet())
/*      */       {
/*  189 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  190 */         _output_.writeInt64(5, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  192 */       for (Map.Entry<Long, Long> _e_ : this.gang_canvass.entrySet())
/*      */       {
/*  194 */         _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/*  195 */         _output_.writeInt64(6, ((Long)_e_.getValue()).longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  202 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  211 */       boolean done = false;
/*  212 */       while (!done)
/*      */       {
/*  214 */         int tag = _input_.readTag();
/*  215 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  219 */           done = true;
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  224 */           this.vote = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  229 */           this.today_vote_num = _input_.readInt32();
/*  230 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  234 */           this.last_vote_time = _input_.readInt64();
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  239 */           this.vote_num = _input_.readInt32();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  244 */           long _k_ = 0L;
/*  245 */           _k_ = _input_.readInt64();
/*  246 */           int readTag = _input_.readTag();
/*  247 */           if (40 != readTag)
/*      */           {
/*  249 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  251 */           long _v_ = 0L;
/*  252 */           _v_ = _input_.readInt64();
/*  253 */           this.world_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  254 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  258 */           long _k_ = 0L;
/*  259 */           _k_ = _input_.readInt64();
/*  260 */           int readTag = _input_.readTag();
/*  261 */           if (48 != readTag)
/*      */           {
/*  263 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  265 */           long _v_ = 0L;
/*  266 */           _v_ = _input_.readInt64();
/*  267 */           this.gang_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  268 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  272 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  274 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  283 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  287 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  289 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenPaiStarVoteInfo copy()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new MenPaiStarVoteInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenPaiStarVoteInfo toData()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MenPaiStarVoteInfo toBean()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new MenPaiStarVoteInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenPaiStarVoteInfo toDataIf()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MenPaiStarVoteInfo toBeanIf()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVote()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return this.vote;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getToday_vote_num()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return this.today_vote_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_vote_time()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return this.last_vote_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVote_num()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.vote_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getWorld_canvass()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return xdb.Logs.logMap(new LogKey(this, "world_canvass"), this.world_canvass);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getWorld_canvassAsData()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*      */     
/*  378 */     MenPaiStarVoteInfo _o_ = this;
/*  379 */     Map<Long, Long> world_canvass = new HashMap();
/*  380 */     for (Map.Entry<Long, Long> _e_ : _o_.world_canvass.entrySet())
/*  381 */       world_canvass.put(_e_.getKey(), _e_.getValue());
/*  382 */     return world_canvass;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getGang_canvass()
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     return xdb.Logs.logMap(new LogKey(this, "gang_canvass"), this.gang_canvass);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getGang_canvassAsData()
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*      */     
/*  399 */     MenPaiStarVoteInfo _o_ = this;
/*  400 */     Map<Long, Long> gang_canvass = new HashMap();
/*  401 */     for (Map.Entry<Long, Long> _e_ : _o_.gang_canvass.entrySet())
/*  402 */       gang_canvass.put(_e_.getKey(), _e_.getValue());
/*  403 */     return gang_canvass;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVote(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     xdb.Logs.logIf(new LogKey(this, "vote")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  415 */         new LogInt(this, MenPaiStarVoteInfo.this.vote)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             MenPaiStarVoteInfo.this.vote = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.vote = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setToday_vote_num(int _v_)
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     xdb.Logs.logIf(new LogKey(this, "today_vote_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  436 */         new LogInt(this, MenPaiStarVoteInfo.this.today_vote_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  440 */             MenPaiStarVoteInfo.this.today_vote_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  444 */     });
/*  445 */     this.today_vote_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_vote_time(long _v_)
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     xdb.Logs.logIf(new LogKey(this, "last_vote_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  457 */         new xdb.logs.LogLong(this, MenPaiStarVoteInfo.this.last_vote_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  461 */             MenPaiStarVoteInfo.this.last_vote_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  465 */     });
/*  466 */     this.last_vote_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVote_num(int _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     xdb.Logs.logIf(new LogKey(this, "vote_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  478 */         new LogInt(this, MenPaiStarVoteInfo.this.vote_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  482 */             MenPaiStarVoteInfo.this.vote_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  486 */     });
/*  487 */     this.vote_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     MenPaiStarVoteInfo _o_ = null;
/*  495 */     if ((_o1_ instanceof MenPaiStarVoteInfo)) { _o_ = (MenPaiStarVoteInfo)_o1_;
/*  496 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  497 */       return false;
/*  498 */     if (this.vote != _o_.vote) return false;
/*  499 */     if (this.today_vote_num != _o_.today_vote_num) return false;
/*  500 */     if (this.last_vote_time != _o_.last_vote_time) return false;
/*  501 */     if (this.vote_num != _o_.vote_num) return false;
/*  502 */     if (!this.world_canvass.equals(_o_.world_canvass)) return false;
/*  503 */     if (!this.gang_canvass.equals(_o_.gang_canvass)) return false;
/*  504 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     int _h_ = 0;
/*  512 */     _h_ += this.vote;
/*  513 */     _h_ += this.today_vote_num;
/*  514 */     _h_ = (int)(_h_ + this.last_vote_time);
/*  515 */     _h_ += this.vote_num;
/*  516 */     _h_ += this.world_canvass.hashCode();
/*  517 */     _h_ += this.gang_canvass.hashCode();
/*  518 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     StringBuilder _sb_ = new StringBuilder();
/*  526 */     _sb_.append("(");
/*  527 */     _sb_.append(this.vote);
/*  528 */     _sb_.append(",");
/*  529 */     _sb_.append(this.today_vote_num);
/*  530 */     _sb_.append(",");
/*  531 */     _sb_.append(this.last_vote_time);
/*  532 */     _sb_.append(",");
/*  533 */     _sb_.append(this.vote_num);
/*  534 */     _sb_.append(",");
/*  535 */     _sb_.append(this.world_canvass);
/*  536 */     _sb_.append(",");
/*  537 */     _sb_.append(this.gang_canvass);
/*  538 */     _sb_.append(")");
/*  539 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  545 */     ListenableBean lb = new ListenableBean();
/*  546 */     lb.add(new ListenableChanged().setVarName("vote"));
/*  547 */     lb.add(new ListenableChanged().setVarName("today_vote_num"));
/*  548 */     lb.add(new ListenableChanged().setVarName("last_vote_time"));
/*  549 */     lb.add(new ListenableChanged().setVarName("vote_num"));
/*  550 */     lb.add(new xdb.logs.ListenableMap().setVarName("world_canvass"));
/*  551 */     lb.add(new xdb.logs.ListenableMap().setVarName("gang_canvass"));
/*  552 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MenPaiStarVoteInfo {
/*      */     private Const() {}
/*      */     
/*      */     MenPaiStarVoteInfo nThis() {
/*  559 */       return MenPaiStarVoteInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  565 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarVoteInfo copy()
/*      */     {
/*  571 */       return MenPaiStarVoteInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarVoteInfo toData()
/*      */     {
/*  577 */       return MenPaiStarVoteInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarVoteInfo toBean()
/*      */     {
/*  582 */       return MenPaiStarVoteInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarVoteInfo toDataIf()
/*      */     {
/*  588 */       return MenPaiStarVoteInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarVoteInfo toBeanIf()
/*      */     {
/*  593 */       return MenPaiStarVoteInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVote()
/*      */     {
/*  600 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  601 */       return MenPaiStarVoteInfo.this.vote;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_vote_num()
/*      */     {
/*  608 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  609 */       return MenPaiStarVoteInfo.this.today_vote_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_vote_time()
/*      */     {
/*  616 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  617 */       return MenPaiStarVoteInfo.this.last_vote_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVote_num()
/*      */     {
/*  624 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  625 */       return MenPaiStarVoteInfo.this.vote_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getWorld_canvass()
/*      */     {
/*  632 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  633 */       return xdb.Consts.constMap(MenPaiStarVoteInfo.this.world_canvass);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getWorld_canvassAsData()
/*      */     {
/*  640 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*      */       
/*  642 */       MenPaiStarVoteInfo _o_ = MenPaiStarVoteInfo.this;
/*  643 */       Map<Long, Long> world_canvass = new HashMap();
/*  644 */       for (Map.Entry<Long, Long> _e_ : _o_.world_canvass.entrySet())
/*  645 */         world_canvass.put(_e_.getKey(), _e_.getValue());
/*  646 */       return world_canvass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getGang_canvass()
/*      */     {
/*  653 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  654 */       return xdb.Consts.constMap(MenPaiStarVoteInfo.this.gang_canvass);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getGang_canvassAsData()
/*      */     {
/*  661 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*      */       
/*  663 */       MenPaiStarVoteInfo _o_ = MenPaiStarVoteInfo.this;
/*  664 */       Map<Long, Long> gang_canvass = new HashMap();
/*  665 */       for (Map.Entry<Long, Long> _e_ : _o_.gang_canvass.entrySet())
/*  666 */         gang_canvass.put(_e_.getKey(), _e_.getValue());
/*  667 */       return gang_canvass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote(int _v_)
/*      */     {
/*  674 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_vote_num(int _v_)
/*      */     {
/*  682 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_vote_time(long _v_)
/*      */     {
/*  690 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_num(int _v_)
/*      */     {
/*  698 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  705 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  706 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  712 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  713 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  719 */       return MenPaiStarVoteInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  725 */       return MenPaiStarVoteInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  731 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  732 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  738 */       return MenPaiStarVoteInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  744 */       return MenPaiStarVoteInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  750 */       MenPaiStarVoteInfo.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  757 */       return MenPaiStarVoteInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  763 */       return MenPaiStarVoteInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  769 */       return MenPaiStarVoteInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  775 */       return MenPaiStarVoteInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  781 */       return MenPaiStarVoteInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  787 */       return MenPaiStarVoteInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  793 */       return MenPaiStarVoteInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MenPaiStarVoteInfo
/*      */   {
/*      */     private int vote;
/*      */     
/*      */     private int today_vote_num;
/*      */     
/*      */     private long last_vote_time;
/*      */     
/*      */     private int vote_num;
/*      */     
/*      */     private HashMap<Long, Long> world_canvass;
/*      */     
/*      */     private HashMap<Long, Long> gang_canvass;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  820 */       this.world_canvass = new HashMap();
/*  821 */       this.gang_canvass = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.MenPaiStarVoteInfo _o1_)
/*      */     {
/*  826 */       if ((_o1_ instanceof MenPaiStarVoteInfo)) { assign((MenPaiStarVoteInfo)_o1_);
/*  827 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  828 */       } else if ((_o1_ instanceof MenPaiStarVoteInfo.Const)) assign(((MenPaiStarVoteInfo.Const)_o1_).nThis()); else {
/*  829 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MenPaiStarVoteInfo _o_) {
/*  834 */       this.vote = _o_.vote;
/*  835 */       this.today_vote_num = _o_.today_vote_num;
/*  836 */       this.last_vote_time = _o_.last_vote_time;
/*  837 */       this.vote_num = _o_.vote_num;
/*  838 */       this.world_canvass = new HashMap();
/*  839 */       for (Map.Entry<Long, Long> _e_ : _o_.world_canvass.entrySet())
/*  840 */         this.world_canvass.put(_e_.getKey(), _e_.getValue());
/*  841 */       this.gang_canvass = new HashMap();
/*  842 */       for (Map.Entry<Long, Long> _e_ : _o_.gang_canvass.entrySet()) {
/*  843 */         this.gang_canvass.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  848 */       this.vote = _o_.vote;
/*  849 */       this.today_vote_num = _o_.today_vote_num;
/*  850 */       this.last_vote_time = _o_.last_vote_time;
/*  851 */       this.vote_num = _o_.vote_num;
/*  852 */       this.world_canvass = new HashMap();
/*  853 */       for (Map.Entry<Long, Long> _e_ : _o_.world_canvass.entrySet())
/*  854 */         this.world_canvass.put(_e_.getKey(), _e_.getValue());
/*  855 */       this.gang_canvass = new HashMap();
/*  856 */       for (Map.Entry<Long, Long> _e_ : _o_.gang_canvass.entrySet()) {
/*  857 */         this.gang_canvass.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  863 */       _os_.marshal(this.vote);
/*  864 */       _os_.marshal(this.today_vote_num);
/*  865 */       _os_.marshal(this.last_vote_time);
/*  866 */       _os_.marshal(this.vote_num);
/*  867 */       _os_.compact_uint32(this.world_canvass.size());
/*  868 */       for (Map.Entry<Long, Long> _e_ : this.world_canvass.entrySet())
/*      */       {
/*  870 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  871 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  873 */       _os_.compact_uint32(this.gang_canvass.size());
/*  874 */       for (Map.Entry<Long, Long> _e_ : this.gang_canvass.entrySet())
/*      */       {
/*  876 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  877 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  879 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  885 */       this.vote = _os_.unmarshal_int();
/*  886 */       this.today_vote_num = _os_.unmarshal_int();
/*  887 */       this.last_vote_time = _os_.unmarshal_long();
/*  888 */       this.vote_num = _os_.unmarshal_int();
/*      */       
/*  890 */       int size = _os_.uncompact_uint32();
/*  891 */       if (size >= 12)
/*      */       {
/*  893 */         this.world_canvass = new HashMap(size * 2);
/*      */       }
/*  895 */       for (; size > 0; size--)
/*      */       {
/*  897 */         long _k_ = 0L;
/*  898 */         _k_ = _os_.unmarshal_long();
/*  899 */         long _v_ = 0L;
/*  900 */         _v_ = _os_.unmarshal_long();
/*  901 */         this.world_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  905 */       int size = _os_.uncompact_uint32();
/*  906 */       if (size >= 12)
/*      */       {
/*  908 */         this.gang_canvass = new HashMap(size * 2);
/*      */       }
/*  910 */       for (; size > 0; size--)
/*      */       {
/*  912 */         long _k_ = 0L;
/*  913 */         _k_ = _os_.unmarshal_long();
/*  914 */         long _v_ = 0L;
/*  915 */         _v_ = _os_.unmarshal_long();
/*  916 */         this.gang_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*  919 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  925 */       int _size_ = 0;
/*  926 */       _size_ += CodedOutputStream.computeInt32Size(1, this.vote);
/*  927 */       _size_ += CodedOutputStream.computeInt32Size(2, this.today_vote_num);
/*  928 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_vote_time);
/*  929 */       _size_ += CodedOutputStream.computeInt32Size(4, this.vote_num);
/*  930 */       for (Map.Entry<Long, Long> _e_ : this.world_canvass.entrySet())
/*      */       {
/*  932 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  933 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  935 */       for (Map.Entry<Long, Long> _e_ : this.gang_canvass.entrySet())
/*      */       {
/*  937 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/*  938 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  940 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  948 */         _output_.writeInt32(1, this.vote);
/*  949 */         _output_.writeInt32(2, this.today_vote_num);
/*  950 */         _output_.writeInt64(3, this.last_vote_time);
/*  951 */         _output_.writeInt32(4, this.vote_num);
/*  952 */         for (Map.Entry<Long, Long> _e_ : this.world_canvass.entrySet())
/*      */         {
/*  954 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  955 */           _output_.writeInt64(5, ((Long)_e_.getValue()).longValue());
/*      */         }
/*  957 */         for (Map.Entry<Long, Long> _e_ : this.gang_canvass.entrySet())
/*      */         {
/*  959 */           _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/*  960 */           _output_.writeInt64(6, ((Long)_e_.getValue()).longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  965 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  967 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  975 */         boolean done = false;
/*  976 */         while (!done)
/*      */         {
/*  978 */           int tag = _input_.readTag();
/*  979 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  983 */             done = true;
/*  984 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  988 */             this.vote = _input_.readInt32();
/*  989 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  993 */             this.today_vote_num = _input_.readInt32();
/*  994 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  998 */             this.last_vote_time = _input_.readInt64();
/*  999 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1003 */             this.vote_num = _input_.readInt32();
/* 1004 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1008 */             long _k_ = 0L;
/* 1009 */             _k_ = _input_.readInt64();
/* 1010 */             int readTag = _input_.readTag();
/* 1011 */             if (40 != readTag)
/*      */             {
/* 1013 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1015 */             long _v_ = 0L;
/* 1016 */             _v_ = _input_.readInt64();
/* 1017 */             this.world_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 1018 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1022 */             long _k_ = 0L;
/* 1023 */             _k_ = _input_.readInt64();
/* 1024 */             int readTag = _input_.readTag();
/* 1025 */             if (48 != readTag)
/*      */             {
/* 1027 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1029 */             long _v_ = 0L;
/* 1030 */             _v_ = _input_.readInt64();
/* 1031 */             this.gang_canvass.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 1032 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1036 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1038 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1047 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1051 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1053 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarVoteInfo copy()
/*      */     {
/* 1059 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarVoteInfo toData()
/*      */     {
/* 1065 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarVoteInfo toBean()
/*      */     {
/* 1070 */       return new MenPaiStarVoteInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenPaiStarVoteInfo toDataIf()
/*      */     {
/* 1076 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MenPaiStarVoteInfo toBeanIf()
/*      */     {
/* 1081 */       return new MenPaiStarVoteInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1087 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1091 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1095 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1099 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1103 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1107 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1111 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVote()
/*      */     {
/* 1118 */       return this.vote;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToday_vote_num()
/*      */     {
/* 1125 */       return this.today_vote_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_vote_time()
/*      */     {
/* 1132 */       return this.last_vote_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVote_num()
/*      */     {
/* 1139 */       return this.vote_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getWorld_canvass()
/*      */     {
/* 1146 */       return this.world_canvass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getWorld_canvassAsData()
/*      */     {
/* 1153 */       return this.world_canvass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getGang_canvass()
/*      */     {
/* 1160 */       return this.gang_canvass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getGang_canvassAsData()
/*      */     {
/* 1167 */       return this.gang_canvass;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote(int _v_)
/*      */     {
/* 1174 */       this.vote = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToday_vote_num(int _v_)
/*      */     {
/* 1181 */       this.today_vote_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_vote_time(long _v_)
/*      */     {
/* 1188 */       this.last_vote_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVote_num(int _v_)
/*      */     {
/* 1195 */       this.vote_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1201 */       if (!(_o1_ instanceof Data)) return false;
/* 1202 */       Data _o_ = (Data)_o1_;
/* 1203 */       if (this.vote != _o_.vote) return false;
/* 1204 */       if (this.today_vote_num != _o_.today_vote_num) return false;
/* 1205 */       if (this.last_vote_time != _o_.last_vote_time) return false;
/* 1206 */       if (this.vote_num != _o_.vote_num) return false;
/* 1207 */       if (!this.world_canvass.equals(_o_.world_canvass)) return false;
/* 1208 */       if (!this.gang_canvass.equals(_o_.gang_canvass)) return false;
/* 1209 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1215 */       int _h_ = 0;
/* 1216 */       _h_ += this.vote;
/* 1217 */       _h_ += this.today_vote_num;
/* 1218 */       _h_ = (int)(_h_ + this.last_vote_time);
/* 1219 */       _h_ += this.vote_num;
/* 1220 */       _h_ += this.world_canvass.hashCode();
/* 1221 */       _h_ += this.gang_canvass.hashCode();
/* 1222 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1228 */       StringBuilder _sb_ = new StringBuilder();
/* 1229 */       _sb_.append("(");
/* 1230 */       _sb_.append(this.vote);
/* 1231 */       _sb_.append(",");
/* 1232 */       _sb_.append(this.today_vote_num);
/* 1233 */       _sb_.append(",");
/* 1234 */       _sb_.append(this.last_vote_time);
/* 1235 */       _sb_.append(",");
/* 1236 */       _sb_.append(this.vote_num);
/* 1237 */       _sb_.append(",");
/* 1238 */       _sb_.append(this.world_canvass);
/* 1239 */       _sb_.append(",");
/* 1240 */       _sb_.append(this.gang_canvass);
/* 1241 */       _sb_.append(")");
/* 1242 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MenPaiStarVoteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */