/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.Pod;
/*      */ import xdb.Consts;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class IdipConfigInfo extends xdb.XBean implements xbean.IdipConfigInfo
/*      */ {
/*      */   private HashMap<Long, xbean.RoleRankForbid> rank_forbids;
/*      */   private HashMap<Long, xbean.IdipForbidInfo> zero_profits;
/*      */   private HashMap<Long, xbean.RolePlayForbid> play_forbids;
/*      */   private HashMap<Long, xbean.RoleInfoForbid> info_forbids;
/*      */   private HashMap<Integer, xbean.IdipNTimesAwardInfo> n_times_award;
/*      */   private SetX<Long> notices;
/*      */   private SetX<Long> marquees;
/*      */   private HashMap<Integer, xbean.HideItemInfo> hide_items;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.rank_forbids.clear();
/*   33 */     this.zero_profits.clear();
/*   34 */     this.play_forbids.clear();
/*   35 */     this.info_forbids.clear();
/*   36 */     this.n_times_award.clear();
/*   37 */     this.notices.clear();
/*   38 */     this.marquees.clear();
/*   39 */     this.hide_items.clear();
/*      */   }
/*      */   
/*      */   IdipConfigInfo(int __, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.rank_forbids = new HashMap();
/*   46 */     this.zero_profits = new HashMap();
/*   47 */     this.play_forbids = new HashMap();
/*   48 */     this.info_forbids = new HashMap();
/*   49 */     this.n_times_award = new HashMap();
/*   50 */     this.notices = new SetX();
/*   51 */     this.marquees = new SetX();
/*   52 */     this.hide_items = new HashMap();
/*      */   }
/*      */   
/*      */   public IdipConfigInfo()
/*      */   {
/*   57 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public IdipConfigInfo(IdipConfigInfo _o_)
/*      */   {
/*   62 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   IdipConfigInfo(xbean.IdipConfigInfo _o1_, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   67 */     super(_xp_, _vn_);
/*   68 */     if ((_o1_ instanceof IdipConfigInfo)) { assign((IdipConfigInfo)_o1_);
/*   69 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   70 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   71 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(IdipConfigInfo _o_) {
/*   76 */     _o_._xdb_verify_unsafe_();
/*   77 */     this.rank_forbids = new HashMap();
/*   78 */     for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : _o_.rank_forbids.entrySet())
/*   79 */       this.rank_forbids.put(_e_.getKey(), new RoleRankForbid((xbean.RoleRankForbid)_e_.getValue(), this, "rank_forbids"));
/*   80 */     this.zero_profits = new HashMap();
/*   81 */     for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : _o_.zero_profits.entrySet())
/*   82 */       this.zero_profits.put(_e_.getKey(), new IdipForbidInfo((xbean.IdipForbidInfo)_e_.getValue(), this, "zero_profits"));
/*   83 */     this.play_forbids = new HashMap();
/*   84 */     for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : _o_.play_forbids.entrySet())
/*   85 */       this.play_forbids.put(_e_.getKey(), new RolePlayForbid((xbean.RolePlayForbid)_e_.getValue(), this, "play_forbids"));
/*   86 */     this.info_forbids = new HashMap();
/*   87 */     for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : _o_.info_forbids.entrySet())
/*   88 */       this.info_forbids.put(_e_.getKey(), new RoleInfoForbid((xbean.RoleInfoForbid)_e_.getValue(), this, "info_forbids"));
/*   89 */     this.n_times_award = new HashMap();
/*   90 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award.entrySet())
/*   91 */       this.n_times_award.put(_e_.getKey(), new IdipNTimesAwardInfo((xbean.IdipNTimesAwardInfo)_e_.getValue(), this, "n_times_award"));
/*   92 */     this.notices = new SetX();
/*   93 */     this.notices.addAll(_o_.notices);
/*   94 */     this.marquees = new SetX();
/*   95 */     this.marquees.addAll(_o_.marquees);
/*   96 */     this.hide_items = new HashMap();
/*   97 */     for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : _o_.hide_items.entrySet()) {
/*   98 */       this.hide_items.put(_e_.getKey(), new HideItemInfo((xbean.HideItemInfo)_e_.getValue(), this, "hide_items"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  103 */     this.rank_forbids = new HashMap();
/*  104 */     for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : _o_.rank_forbids.entrySet())
/*  105 */       this.rank_forbids.put(_e_.getKey(), new RoleRankForbid((xbean.RoleRankForbid)_e_.getValue(), this, "rank_forbids"));
/*  106 */     this.zero_profits = new HashMap();
/*  107 */     for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : _o_.zero_profits.entrySet())
/*  108 */       this.zero_profits.put(_e_.getKey(), new IdipForbidInfo((xbean.IdipForbidInfo)_e_.getValue(), this, "zero_profits"));
/*  109 */     this.play_forbids = new HashMap();
/*  110 */     for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : _o_.play_forbids.entrySet())
/*  111 */       this.play_forbids.put(_e_.getKey(), new RolePlayForbid((xbean.RolePlayForbid)_e_.getValue(), this, "play_forbids"));
/*  112 */     this.info_forbids = new HashMap();
/*  113 */     for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : _o_.info_forbids.entrySet())
/*  114 */       this.info_forbids.put(_e_.getKey(), new RoleInfoForbid((xbean.RoleInfoForbid)_e_.getValue(), this, "info_forbids"));
/*  115 */     this.n_times_award = new HashMap();
/*  116 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award.entrySet())
/*  117 */       this.n_times_award.put(_e_.getKey(), new IdipNTimesAwardInfo((xbean.IdipNTimesAwardInfo)_e_.getValue(), this, "n_times_award"));
/*  118 */     this.notices = new SetX();
/*  119 */     this.notices.addAll(_o_.notices);
/*  120 */     this.marquees = new SetX();
/*  121 */     this.marquees.addAll(_o_.marquees);
/*  122 */     this.hide_items = new HashMap();
/*  123 */     for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : _o_.hide_items.entrySet()) {
/*  124 */       this.hide_items.put(_e_.getKey(), new HideItemInfo((xbean.HideItemInfo)_e_.getValue(), this, "hide_items"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*  131 */     _os_.compact_uint32(this.rank_forbids.size());
/*  132 */     for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : this.rank_forbids.entrySet())
/*      */     {
/*  134 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  135 */       ((xbean.RoleRankForbid)_e_.getValue()).marshal(_os_);
/*      */     }
/*  137 */     _os_.compact_uint32(this.zero_profits.size());
/*  138 */     for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : this.zero_profits.entrySet())
/*      */     {
/*  140 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  141 */       ((xbean.IdipForbidInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  143 */     _os_.compact_uint32(this.play_forbids.size());
/*  144 */     for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : this.play_forbids.entrySet())
/*      */     {
/*  146 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  147 */       ((xbean.RolePlayForbid)_e_.getValue()).marshal(_os_);
/*      */     }
/*  149 */     _os_.compact_uint32(this.info_forbids.size());
/*  150 */     for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : this.info_forbids.entrySet())
/*      */     {
/*  152 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  153 */       ((xbean.RoleInfoForbid)_e_.getValue()).marshal(_os_);
/*      */     }
/*  155 */     _os_.compact_uint32(this.n_times_award.size());
/*  156 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award.entrySet())
/*      */     {
/*  158 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  159 */       ((xbean.IdipNTimesAwardInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  161 */     _os_.compact_uint32(this.notices.size());
/*  162 */     for (Long _v_ : this.notices)
/*      */     {
/*  164 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  166 */     _os_.compact_uint32(this.marquees.size());
/*  167 */     for (Long _v_ : this.marquees)
/*      */     {
/*  169 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  171 */     _os_.compact_uint32(this.hide_items.size());
/*  172 */     for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : this.hide_items.entrySet())
/*      */     {
/*  174 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  175 */       ((xbean.HideItemInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  177 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  183 */     _xdb_verify_unsafe_();
/*      */     
/*  185 */     int size = _os_.uncompact_uint32();
/*  186 */     if (size >= 12)
/*      */     {
/*  188 */       this.rank_forbids = new HashMap(size * 2);
/*      */     }
/*  190 */     for (; size > 0; size--)
/*      */     {
/*  192 */       long _k_ = 0L;
/*  193 */       _k_ = _os_.unmarshal_long();
/*  194 */       xbean.RoleRankForbid _v_ = new RoleRankForbid(0, this, "rank_forbids");
/*  195 */       _v_.unmarshal(_os_);
/*  196 */       this.rank_forbids.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  200 */     int size = _os_.uncompact_uint32();
/*  201 */     if (size >= 12)
/*      */     {
/*  203 */       this.zero_profits = new HashMap(size * 2);
/*      */     }
/*  205 */     for (; size > 0; size--)
/*      */     {
/*  207 */       long _k_ = 0L;
/*  208 */       _k_ = _os_.unmarshal_long();
/*  209 */       xbean.IdipForbidInfo _v_ = new IdipForbidInfo(0, this, "zero_profits");
/*  210 */       _v_.unmarshal(_os_);
/*  211 */       this.zero_profits.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  215 */     int size = _os_.uncompact_uint32();
/*  216 */     if (size >= 12)
/*      */     {
/*  218 */       this.play_forbids = new HashMap(size * 2);
/*      */     }
/*  220 */     for (; size > 0; size--)
/*      */     {
/*  222 */       long _k_ = 0L;
/*  223 */       _k_ = _os_.unmarshal_long();
/*  224 */       xbean.RolePlayForbid _v_ = new RolePlayForbid(0, this, "play_forbids");
/*  225 */       _v_.unmarshal(_os_);
/*  226 */       this.play_forbids.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  230 */     int size = _os_.uncompact_uint32();
/*  231 */     if (size >= 12)
/*      */     {
/*  233 */       this.info_forbids = new HashMap(size * 2);
/*      */     }
/*  235 */     for (; size > 0; size--)
/*      */     {
/*  237 */       long _k_ = 0L;
/*  238 */       _k_ = _os_.unmarshal_long();
/*  239 */       xbean.RoleInfoForbid _v_ = new RoleInfoForbid(0, this, "info_forbids");
/*  240 */       _v_.unmarshal(_os_);
/*  241 */       this.info_forbids.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  245 */     int size = _os_.uncompact_uint32();
/*  246 */     if (size >= 12)
/*      */     {
/*  248 */       this.n_times_award = new HashMap(size * 2);
/*      */     }
/*  250 */     for (; size > 0; size--)
/*      */     {
/*  252 */       int _k_ = 0;
/*  253 */       _k_ = _os_.unmarshal_int();
/*  254 */       xbean.IdipNTimesAwardInfo _v_ = new IdipNTimesAwardInfo(0, this, "n_times_award");
/*  255 */       _v_.unmarshal(_os_);
/*  256 */       this.n_times_award.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  259 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  261 */       long _v_ = 0L;
/*  262 */       _v_ = _os_.unmarshal_long();
/*  263 */       this.notices.add(Long.valueOf(_v_));
/*      */     }
/*  265 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  267 */       long _v_ = 0L;
/*  268 */       _v_ = _os_.unmarshal_long();
/*  269 */       this.marquees.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  272 */     int size = _os_.uncompact_uint32();
/*  273 */     if (size >= 12)
/*      */     {
/*  275 */       this.hide_items = new HashMap(size * 2);
/*      */     }
/*  277 */     for (; size > 0; size--)
/*      */     {
/*  279 */       int _k_ = 0;
/*  280 */       _k_ = _os_.unmarshal_int();
/*  281 */       xbean.HideItemInfo _v_ = new HideItemInfo(0, this, "hide_items");
/*  282 */       _v_.unmarshal(_os_);
/*  283 */       this.hide_items.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  286 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     int _size_ = 0;
/*  294 */     for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : this.rank_forbids.entrySet())
/*      */     {
/*  296 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  297 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  299 */     for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : this.zero_profits.entrySet())
/*      */     {
/*  301 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  302 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  304 */     for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : this.play_forbids.entrySet())
/*      */     {
/*  306 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  307 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  309 */     for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : this.info_forbids.entrySet())
/*      */     {
/*  311 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  312 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  314 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award.entrySet())
/*      */     {
/*  316 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  317 */       _size_ += CodedOutputStream.computeMessageSize(6, (Message)_e_.getValue());
/*      */     }
/*  319 */     for (Long _v_ : this.notices)
/*      */     {
/*  321 */       _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */     }
/*  323 */     for (Long _v_ : this.marquees)
/*      */     {
/*  325 */       _size_ += CodedOutputStream.computeInt64Size(8, _v_.longValue());
/*      */     }
/*  327 */     for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : this.hide_items.entrySet())
/*      */     {
/*  329 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/*  330 */       _size_ += CodedOutputStream.computeMessageSize(9, (Message)_e_.getValue());
/*      */     }
/*  332 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  341 */       for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : this.rank_forbids.entrySet())
/*      */       {
/*  343 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  344 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  346 */       for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : this.zero_profits.entrySet())
/*      */       {
/*  348 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  349 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  351 */       for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : this.play_forbids.entrySet())
/*      */       {
/*  353 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  354 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  356 */       for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : this.info_forbids.entrySet())
/*      */       {
/*  358 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  359 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*  361 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award.entrySet())
/*      */       {
/*  363 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  364 */         _output_.writeMessage(6, (Message)_e_.getValue());
/*      */       }
/*  366 */       for (Long _v_ : this.notices)
/*      */       {
/*  368 */         _output_.writeInt64(7, _v_.longValue());
/*      */       }
/*  370 */       for (Long _v_ : this.marquees)
/*      */       {
/*  372 */         _output_.writeInt64(8, _v_.longValue());
/*      */       }
/*  374 */       for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : this.hide_items.entrySet())
/*      */       {
/*  376 */         _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/*  377 */         _output_.writeMessage(9, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  382 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  384 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  393 */       boolean done = false;
/*  394 */       while (!done)
/*      */       {
/*  396 */         int tag = _input_.readTag();
/*  397 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  401 */           done = true;
/*  402 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  406 */           long _k_ = 0L;
/*  407 */           _k_ = _input_.readInt64();
/*  408 */           int readTag = _input_.readTag();
/*  409 */           if (10 != readTag)
/*      */           {
/*  411 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  413 */           xbean.RoleRankForbid _v_ = new RoleRankForbid(0, this, "rank_forbids");
/*  414 */           _input_.readMessage(_v_);
/*  415 */           this.rank_forbids.put(Long.valueOf(_k_), _v_);
/*  416 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  420 */           long _k_ = 0L;
/*  421 */           _k_ = _input_.readInt64();
/*  422 */           int readTag = _input_.readTag();
/*  423 */           if (18 != readTag)
/*      */           {
/*  425 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  427 */           xbean.IdipForbidInfo _v_ = new IdipForbidInfo(0, this, "zero_profits");
/*  428 */           _input_.readMessage(_v_);
/*  429 */           this.zero_profits.put(Long.valueOf(_k_), _v_);
/*  430 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  434 */           long _k_ = 0L;
/*  435 */           _k_ = _input_.readInt64();
/*  436 */           int readTag = _input_.readTag();
/*  437 */           if (26 != readTag)
/*      */           {
/*  439 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  441 */           xbean.RolePlayForbid _v_ = new RolePlayForbid(0, this, "play_forbids");
/*  442 */           _input_.readMessage(_v_);
/*  443 */           this.play_forbids.put(Long.valueOf(_k_), _v_);
/*  444 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  448 */           long _k_ = 0L;
/*  449 */           _k_ = _input_.readInt64();
/*  450 */           int readTag = _input_.readTag();
/*  451 */           if (34 != readTag)
/*      */           {
/*  453 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  455 */           xbean.RoleInfoForbid _v_ = new RoleInfoForbid(0, this, "info_forbids");
/*  456 */           _input_.readMessage(_v_);
/*  457 */           this.info_forbids.put(Long.valueOf(_k_), _v_);
/*  458 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  462 */           int _k_ = 0;
/*  463 */           _k_ = _input_.readInt32();
/*  464 */           int readTag = _input_.readTag();
/*  465 */           if (50 != readTag)
/*      */           {
/*  467 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  469 */           xbean.IdipNTimesAwardInfo _v_ = new IdipNTimesAwardInfo(0, this, "n_times_award");
/*  470 */           _input_.readMessage(_v_);
/*  471 */           this.n_times_award.put(Integer.valueOf(_k_), _v_);
/*  472 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  476 */           long _v_ = 0L;
/*  477 */           _v_ = _input_.readInt64();
/*  478 */           this.notices.add(Long.valueOf(_v_));
/*  479 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  483 */           long _v_ = 0L;
/*  484 */           _v_ = _input_.readInt64();
/*  485 */           this.marquees.add(Long.valueOf(_v_));
/*  486 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  490 */           int _k_ = 0;
/*  491 */           _k_ = _input_.readInt32();
/*  492 */           int readTag = _input_.readTag();
/*  493 */           if (74 != readTag)
/*      */           {
/*  495 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  497 */           xbean.HideItemInfo _v_ = new HideItemInfo(0, this, "hide_items");
/*  498 */           _input_.readMessage(_v_);
/*  499 */           this.hide_items.put(Integer.valueOf(_k_), _v_);
/*  500 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  504 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  506 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  515 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  519 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  521 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipConfigInfo copy()
/*      */   {
/*  527 */     _xdb_verify_unsafe_();
/*  528 */     return new IdipConfigInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipConfigInfo toData()
/*      */   {
/*  534 */     _xdb_verify_unsafe_();
/*  535 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IdipConfigInfo toBean()
/*      */   {
/*  540 */     _xdb_verify_unsafe_();
/*  541 */     return new IdipConfigInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipConfigInfo toDataIf()
/*      */   {
/*  547 */     _xdb_verify_unsafe_();
/*  548 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IdipConfigInfo toBeanIf()
/*      */   {
/*  553 */     _xdb_verify_unsafe_();
/*  554 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  560 */     _xdb_verify_unsafe_();
/*  561 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleRankForbid> getRank_forbids()
/*      */   {
/*  568 */     _xdb_verify_unsafe_();
/*  569 */     return xdb.Logs.logMap(new xdb.LogKey(this, "rank_forbids"), this.rank_forbids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleRankForbid> getRank_forbidsAsData()
/*      */   {
/*  576 */     _xdb_verify_unsafe_();
/*      */     
/*  578 */     IdipConfigInfo _o_ = this;
/*  579 */     Map<Long, xbean.RoleRankForbid> rank_forbids = new HashMap();
/*  580 */     for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : _o_.rank_forbids.entrySet())
/*  581 */       rank_forbids.put(_e_.getKey(), new RoleRankForbid.Data((xbean.RoleRankForbid)_e_.getValue()));
/*  582 */     return rank_forbids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.IdipForbidInfo> getZero_profits()
/*      */   {
/*  589 */     _xdb_verify_unsafe_();
/*  590 */     return xdb.Logs.logMap(new xdb.LogKey(this, "zero_profits"), this.zero_profits);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.IdipForbidInfo> getZero_profitsAsData()
/*      */   {
/*  597 */     _xdb_verify_unsafe_();
/*      */     
/*  599 */     IdipConfigInfo _o_ = this;
/*  600 */     Map<Long, xbean.IdipForbidInfo> zero_profits = new HashMap();
/*  601 */     for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : _o_.zero_profits.entrySet())
/*  602 */       zero_profits.put(_e_.getKey(), new IdipForbidInfo.Data((xbean.IdipForbidInfo)_e_.getValue()));
/*  603 */     return zero_profits;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RolePlayForbid> getPlay_forbids()
/*      */   {
/*  610 */     _xdb_verify_unsafe_();
/*  611 */     return xdb.Logs.logMap(new xdb.LogKey(this, "play_forbids"), this.play_forbids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RolePlayForbid> getPlay_forbidsAsData()
/*      */   {
/*  618 */     _xdb_verify_unsafe_();
/*      */     
/*  620 */     IdipConfigInfo _o_ = this;
/*  621 */     Map<Long, xbean.RolePlayForbid> play_forbids = new HashMap();
/*  622 */     for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : _o_.play_forbids.entrySet())
/*  623 */       play_forbids.put(_e_.getKey(), new RolePlayForbid.Data((xbean.RolePlayForbid)_e_.getValue()));
/*  624 */     return play_forbids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleInfoForbid> getInfo_forbids()
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     return xdb.Logs.logMap(new xdb.LogKey(this, "info_forbids"), this.info_forbids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleInfoForbid> getInfo_forbidsAsData()
/*      */   {
/*  639 */     _xdb_verify_unsafe_();
/*      */     
/*  641 */     IdipConfigInfo _o_ = this;
/*  642 */     Map<Long, xbean.RoleInfoForbid> info_forbids = new HashMap();
/*  643 */     for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : _o_.info_forbids.entrySet())
/*  644 */       info_forbids.put(_e_.getKey(), new RoleInfoForbid.Data((xbean.RoleInfoForbid)_e_.getValue()));
/*  645 */     return info_forbids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award()
/*      */   {
/*  652 */     _xdb_verify_unsafe_();
/*  653 */     return xdb.Logs.logMap(new xdb.LogKey(this, "n_times_award"), this.n_times_award);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_awardAsData()
/*      */   {
/*  660 */     _xdb_verify_unsafe_();
/*      */     
/*  662 */     IdipConfigInfo _o_ = this;
/*  663 */     Map<Integer, xbean.IdipNTimesAwardInfo> n_times_award = new HashMap();
/*  664 */     for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award.entrySet())
/*  665 */       n_times_award.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/*  666 */     return n_times_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getNotices()
/*      */   {
/*  673 */     _xdb_verify_unsafe_();
/*  674 */     return xdb.Logs.logSet(new xdb.LogKey(this, "notices"), this.notices);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getNoticesAsData()
/*      */   {
/*  680 */     _xdb_verify_unsafe_();
/*      */     
/*  682 */     IdipConfigInfo _o_ = this;
/*  683 */     Set<Long> notices = new SetX();
/*  684 */     notices.addAll(_o_.notices);
/*  685 */     return notices;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getMarquees()
/*      */   {
/*  692 */     _xdb_verify_unsafe_();
/*  693 */     return xdb.Logs.logSet(new xdb.LogKey(this, "marquees"), this.marquees);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getMarqueesAsData()
/*      */   {
/*  699 */     _xdb_verify_unsafe_();
/*      */     
/*  701 */     IdipConfigInfo _o_ = this;
/*  702 */     Set<Long> marquees = new SetX();
/*  703 */     marquees.addAll(_o_.marquees);
/*  704 */     return marquees;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.HideItemInfo> getHide_items()
/*      */   {
/*  711 */     _xdb_verify_unsafe_();
/*  712 */     return xdb.Logs.logMap(new xdb.LogKey(this, "hide_items"), this.hide_items);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.HideItemInfo> getHide_itemsAsData()
/*      */   {
/*  719 */     _xdb_verify_unsafe_();
/*      */     
/*  721 */     IdipConfigInfo _o_ = this;
/*  722 */     Map<Integer, xbean.HideItemInfo> hide_items = new HashMap();
/*  723 */     for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : _o_.hide_items.entrySet())
/*  724 */       hide_items.put(_e_.getKey(), new HideItemInfo.Data((xbean.HideItemInfo)_e_.getValue()));
/*  725 */     return hide_items;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  731 */     _xdb_verify_unsafe_();
/*  732 */     IdipConfigInfo _o_ = null;
/*  733 */     if ((_o1_ instanceof IdipConfigInfo)) { _o_ = (IdipConfigInfo)_o1_;
/*  734 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  735 */       return false;
/*  736 */     if (!this.rank_forbids.equals(_o_.rank_forbids)) return false;
/*  737 */     if (!this.zero_profits.equals(_o_.zero_profits)) return false;
/*  738 */     if (!this.play_forbids.equals(_o_.play_forbids)) return false;
/*  739 */     if (!this.info_forbids.equals(_o_.info_forbids)) return false;
/*  740 */     if (!this.n_times_award.equals(_o_.n_times_award)) return false;
/*  741 */     if (!this.notices.equals(_o_.notices)) return false;
/*  742 */     if (!this.marquees.equals(_o_.marquees)) return false;
/*  743 */     if (!this.hide_items.equals(_o_.hide_items)) return false;
/*  744 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  750 */     _xdb_verify_unsafe_();
/*  751 */     int _h_ = 0;
/*  752 */     _h_ += this.rank_forbids.hashCode();
/*  753 */     _h_ += this.zero_profits.hashCode();
/*  754 */     _h_ += this.play_forbids.hashCode();
/*  755 */     _h_ += this.info_forbids.hashCode();
/*  756 */     _h_ += this.n_times_award.hashCode();
/*  757 */     _h_ += this.notices.hashCode();
/*  758 */     _h_ += this.marquees.hashCode();
/*  759 */     _h_ += this.hide_items.hashCode();
/*  760 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  766 */     _xdb_verify_unsafe_();
/*  767 */     StringBuilder _sb_ = new StringBuilder();
/*  768 */     _sb_.append("(");
/*  769 */     _sb_.append(this.rank_forbids);
/*  770 */     _sb_.append(",");
/*  771 */     _sb_.append(this.zero_profits);
/*  772 */     _sb_.append(",");
/*  773 */     _sb_.append(this.play_forbids);
/*  774 */     _sb_.append(",");
/*  775 */     _sb_.append(this.info_forbids);
/*  776 */     _sb_.append(",");
/*  777 */     _sb_.append(this.n_times_award);
/*  778 */     _sb_.append(",");
/*  779 */     _sb_.append(this.notices);
/*  780 */     _sb_.append(",");
/*  781 */     _sb_.append(this.marquees);
/*  782 */     _sb_.append(",");
/*  783 */     _sb_.append(this.hide_items);
/*  784 */     _sb_.append(")");
/*  785 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  791 */     ListenableBean lb = new ListenableBean();
/*  792 */     lb.add(new ListenableMap().setVarName("rank_forbids"));
/*  793 */     lb.add(new ListenableMap().setVarName("zero_profits"));
/*  794 */     lb.add(new ListenableMap().setVarName("play_forbids"));
/*  795 */     lb.add(new ListenableMap().setVarName("info_forbids"));
/*  796 */     lb.add(new ListenableMap().setVarName("n_times_award"));
/*  797 */     lb.add(new xdb.logs.ListenableSet().setVarName("notices"));
/*  798 */     lb.add(new xdb.logs.ListenableSet().setVarName("marquees"));
/*  799 */     lb.add(new ListenableMap().setVarName("hide_items"));
/*  800 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.IdipConfigInfo {
/*      */     private Const() {}
/*      */     
/*      */     IdipConfigInfo nThis() {
/*  807 */       return IdipConfigInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  813 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipConfigInfo copy()
/*      */     {
/*  819 */       return IdipConfigInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipConfigInfo toData()
/*      */     {
/*  825 */       return IdipConfigInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.IdipConfigInfo toBean()
/*      */     {
/*  830 */       return IdipConfigInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipConfigInfo toDataIf()
/*      */     {
/*  836 */       return IdipConfigInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.IdipConfigInfo toBeanIf()
/*      */     {
/*  841 */       return IdipConfigInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRankForbid> getRank_forbids()
/*      */     {
/*  848 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  849 */       return Consts.constMap(IdipConfigInfo.this.rank_forbids);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRankForbid> getRank_forbidsAsData()
/*      */     {
/*  856 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  858 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  859 */       Map<Long, xbean.RoleRankForbid> rank_forbids = new HashMap();
/*  860 */       for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : _o_.rank_forbids.entrySet())
/*  861 */         rank_forbids.put(_e_.getKey(), new RoleRankForbid.Data((xbean.RoleRankForbid)_e_.getValue()));
/*  862 */       return rank_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.IdipForbidInfo> getZero_profits()
/*      */     {
/*  869 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  870 */       return Consts.constMap(IdipConfigInfo.this.zero_profits);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.IdipForbidInfo> getZero_profitsAsData()
/*      */     {
/*  877 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  879 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  880 */       Map<Long, xbean.IdipForbidInfo> zero_profits = new HashMap();
/*  881 */       for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : _o_.zero_profits.entrySet())
/*  882 */         zero_profits.put(_e_.getKey(), new IdipForbidInfo.Data((xbean.IdipForbidInfo)_e_.getValue()));
/*  883 */       return zero_profits;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RolePlayForbid> getPlay_forbids()
/*      */     {
/*  890 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  891 */       return Consts.constMap(IdipConfigInfo.this.play_forbids);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RolePlayForbid> getPlay_forbidsAsData()
/*      */     {
/*  898 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  900 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  901 */       Map<Long, xbean.RolePlayForbid> play_forbids = new HashMap();
/*  902 */       for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : _o_.play_forbids.entrySet())
/*  903 */         play_forbids.put(_e_.getKey(), new RolePlayForbid.Data((xbean.RolePlayForbid)_e_.getValue()));
/*  904 */       return play_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleInfoForbid> getInfo_forbids()
/*      */     {
/*  911 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  912 */       return Consts.constMap(IdipConfigInfo.this.info_forbids);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleInfoForbid> getInfo_forbidsAsData()
/*      */     {
/*  919 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  921 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  922 */       Map<Long, xbean.RoleInfoForbid> info_forbids = new HashMap();
/*  923 */       for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : _o_.info_forbids.entrySet())
/*  924 */         info_forbids.put(_e_.getKey(), new RoleInfoForbid.Data((xbean.RoleInfoForbid)_e_.getValue()));
/*  925 */       return info_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award()
/*      */     {
/*  932 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  933 */       return Consts.constMap(IdipConfigInfo.this.n_times_award);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_awardAsData()
/*      */     {
/*  940 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  942 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  943 */       Map<Integer, xbean.IdipNTimesAwardInfo> n_times_award = new HashMap();
/*  944 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award.entrySet())
/*  945 */         n_times_award.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/*  946 */       return n_times_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getNotices()
/*      */     {
/*  953 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  954 */       return Consts.constSet(IdipConfigInfo.this.notices);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getNoticesAsData()
/*      */     {
/*  960 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  962 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  963 */       Set<Long> notices = new SetX();
/*  964 */       notices.addAll(_o_.notices);
/*  965 */       return notices;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMarquees()
/*      */     {
/*  972 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  973 */       return Consts.constSet(IdipConfigInfo.this.marquees);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getMarqueesAsData()
/*      */     {
/*  979 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/*  981 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/*  982 */       Set<Long> marquees = new SetX();
/*  983 */       marquees.addAll(_o_.marquees);
/*  984 */       return marquees;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.HideItemInfo> getHide_items()
/*      */     {
/*  991 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*  992 */       return Consts.constMap(IdipConfigInfo.this.hide_items);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.HideItemInfo> getHide_itemsAsData()
/*      */     {
/*  999 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1001 */       IdipConfigInfo _o_ = IdipConfigInfo.this;
/* 1002 */       Map<Integer, xbean.HideItemInfo> hide_items = new HashMap();
/* 1003 */       for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : _o_.hide_items.entrySet())
/* 1004 */         hide_items.put(_e_.getKey(), new HideItemInfo.Data((xbean.HideItemInfo)_e_.getValue()));
/* 1005 */       return hide_items;
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1011 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/* 1012 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1018 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/* 1019 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1025 */       return IdipConfigInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1031 */       return IdipConfigInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1037 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/* 1038 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1044 */       return IdipConfigInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1050 */       return IdipConfigInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1056 */       IdipConfigInfo.this._xdb_verify_unsafe_();
/* 1057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1063 */       return IdipConfigInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1069 */       return IdipConfigInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1075 */       return IdipConfigInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1081 */       return IdipConfigInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1087 */       return IdipConfigInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1093 */       return IdipConfigInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1099 */       return IdipConfigInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.IdipConfigInfo
/*      */   {
/*      */     private HashMap<Long, xbean.RoleRankForbid> rank_forbids;
/*      */     
/*      */     private HashMap<Long, xbean.IdipForbidInfo> zero_profits;
/*      */     
/*      */     private HashMap<Long, xbean.RolePlayForbid> play_forbids;
/*      */     
/*      */     private HashMap<Long, xbean.RoleInfoForbid> info_forbids;
/*      */     
/*      */     private HashMap<Integer, xbean.IdipNTimesAwardInfo> n_times_award;
/*      */     
/*      */     private HashSet<Long> notices;
/*      */     
/*      */     private HashSet<Long> marquees;
/*      */     
/*      */     private HashMap<Integer, xbean.HideItemInfo> hide_items;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1125 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1130 */       this.rank_forbids = new HashMap();
/* 1131 */       this.zero_profits = new HashMap();
/* 1132 */       this.play_forbids = new HashMap();
/* 1133 */       this.info_forbids = new HashMap();
/* 1134 */       this.n_times_award = new HashMap();
/* 1135 */       this.notices = new HashSet();
/* 1136 */       this.marquees = new HashSet();
/* 1137 */       this.hide_items = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.IdipConfigInfo _o1_)
/*      */     {
/* 1142 */       if ((_o1_ instanceof IdipConfigInfo)) { assign((IdipConfigInfo)_o1_);
/* 1143 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1144 */       } else if ((_o1_ instanceof IdipConfigInfo.Const)) assign(((IdipConfigInfo.Const)_o1_).nThis()); else {
/* 1145 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(IdipConfigInfo _o_) {
/* 1150 */       this.rank_forbids = new HashMap();
/* 1151 */       for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : _o_.rank_forbids.entrySet())
/* 1152 */         this.rank_forbids.put(_e_.getKey(), new RoleRankForbid.Data((xbean.RoleRankForbid)_e_.getValue()));
/* 1153 */       this.zero_profits = new HashMap();
/* 1154 */       for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : _o_.zero_profits.entrySet())
/* 1155 */         this.zero_profits.put(_e_.getKey(), new IdipForbidInfo.Data((xbean.IdipForbidInfo)_e_.getValue()));
/* 1156 */       this.play_forbids = new HashMap();
/* 1157 */       for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : _o_.play_forbids.entrySet())
/* 1158 */         this.play_forbids.put(_e_.getKey(), new RolePlayForbid.Data((xbean.RolePlayForbid)_e_.getValue()));
/* 1159 */       this.info_forbids = new HashMap();
/* 1160 */       for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : _o_.info_forbids.entrySet())
/* 1161 */         this.info_forbids.put(_e_.getKey(), new RoleInfoForbid.Data((xbean.RoleInfoForbid)_e_.getValue()));
/* 1162 */       this.n_times_award = new HashMap();
/* 1163 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award.entrySet())
/* 1164 */         this.n_times_award.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/* 1165 */       this.notices = new HashSet();
/* 1166 */       this.notices.addAll(_o_.notices);
/* 1167 */       this.marquees = new HashSet();
/* 1168 */       this.marquees.addAll(_o_.marquees);
/* 1169 */       this.hide_items = new HashMap();
/* 1170 */       for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : _o_.hide_items.entrySet()) {
/* 1171 */         this.hide_items.put(_e_.getKey(), new HideItemInfo.Data((xbean.HideItemInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1176 */       this.rank_forbids = new HashMap();
/* 1177 */       for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : _o_.rank_forbids.entrySet())
/* 1178 */         this.rank_forbids.put(_e_.getKey(), new RoleRankForbid.Data((xbean.RoleRankForbid)_e_.getValue()));
/* 1179 */       this.zero_profits = new HashMap();
/* 1180 */       for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : _o_.zero_profits.entrySet())
/* 1181 */         this.zero_profits.put(_e_.getKey(), new IdipForbidInfo.Data((xbean.IdipForbidInfo)_e_.getValue()));
/* 1182 */       this.play_forbids = new HashMap();
/* 1183 */       for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : _o_.play_forbids.entrySet())
/* 1184 */         this.play_forbids.put(_e_.getKey(), new RolePlayForbid.Data((xbean.RolePlayForbid)_e_.getValue()));
/* 1185 */       this.info_forbids = new HashMap();
/* 1186 */       for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : _o_.info_forbids.entrySet())
/* 1187 */         this.info_forbids.put(_e_.getKey(), new RoleInfoForbid.Data((xbean.RoleInfoForbid)_e_.getValue()));
/* 1188 */       this.n_times_award = new HashMap();
/* 1189 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : _o_.n_times_award.entrySet())
/* 1190 */         this.n_times_award.put(_e_.getKey(), new IdipNTimesAwardInfo.Data((xbean.IdipNTimesAwardInfo)_e_.getValue()));
/* 1191 */       this.notices = new HashSet();
/* 1192 */       this.notices.addAll(_o_.notices);
/* 1193 */       this.marquees = new HashSet();
/* 1194 */       this.marquees.addAll(_o_.marquees);
/* 1195 */       this.hide_items = new HashMap();
/* 1196 */       for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : _o_.hide_items.entrySet()) {
/* 1197 */         this.hide_items.put(_e_.getKey(), new HideItemInfo.Data((xbean.HideItemInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1203 */       _os_.compact_uint32(this.rank_forbids.size());
/* 1204 */       for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : this.rank_forbids.entrySet())
/*      */       {
/* 1206 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1207 */         ((xbean.RoleRankForbid)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1209 */       _os_.compact_uint32(this.zero_profits.size());
/* 1210 */       for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : this.zero_profits.entrySet())
/*      */       {
/* 1212 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1213 */         ((xbean.IdipForbidInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1215 */       _os_.compact_uint32(this.play_forbids.size());
/* 1216 */       for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : this.play_forbids.entrySet())
/*      */       {
/* 1218 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1219 */         ((xbean.RolePlayForbid)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1221 */       _os_.compact_uint32(this.info_forbids.size());
/* 1222 */       for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : this.info_forbids.entrySet())
/*      */       {
/* 1224 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1225 */         ((xbean.RoleInfoForbid)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1227 */       _os_.compact_uint32(this.n_times_award.size());
/* 1228 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award.entrySet())
/*      */       {
/* 1230 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1231 */         ((xbean.IdipNTimesAwardInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1233 */       _os_.compact_uint32(this.notices.size());
/* 1234 */       for (Long _v_ : this.notices)
/*      */       {
/* 1236 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1238 */       _os_.compact_uint32(this.marquees.size());
/* 1239 */       for (Long _v_ : this.marquees)
/*      */       {
/* 1241 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1243 */       _os_.compact_uint32(this.hide_items.size());
/* 1244 */       for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : this.hide_items.entrySet())
/*      */       {
/* 1246 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1247 */         ((xbean.HideItemInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1249 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1256 */       int size = _os_.uncompact_uint32();
/* 1257 */       if (size >= 12)
/*      */       {
/* 1259 */         this.rank_forbids = new HashMap(size * 2);
/*      */       }
/* 1261 */       for (; size > 0; size--)
/*      */       {
/* 1263 */         long _k_ = 0L;
/* 1264 */         _k_ = _os_.unmarshal_long();
/* 1265 */         xbean.RoleRankForbid _v_ = Pod.newRoleRankForbidData();
/* 1266 */         _v_.unmarshal(_os_);
/* 1267 */         this.rank_forbids.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1271 */       int size = _os_.uncompact_uint32();
/* 1272 */       if (size >= 12)
/*      */       {
/* 1274 */         this.zero_profits = new HashMap(size * 2);
/*      */       }
/* 1276 */       for (; size > 0; size--)
/*      */       {
/* 1278 */         long _k_ = 0L;
/* 1279 */         _k_ = _os_.unmarshal_long();
/* 1280 */         xbean.IdipForbidInfo _v_ = Pod.newIdipForbidInfoData();
/* 1281 */         _v_.unmarshal(_os_);
/* 1282 */         this.zero_profits.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1286 */       int size = _os_.uncompact_uint32();
/* 1287 */       if (size >= 12)
/*      */       {
/* 1289 */         this.play_forbids = new HashMap(size * 2);
/*      */       }
/* 1291 */       for (; size > 0; size--)
/*      */       {
/* 1293 */         long _k_ = 0L;
/* 1294 */         _k_ = _os_.unmarshal_long();
/* 1295 */         xbean.RolePlayForbid _v_ = Pod.newRolePlayForbidData();
/* 1296 */         _v_.unmarshal(_os_);
/* 1297 */         this.play_forbids.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1301 */       int size = _os_.uncompact_uint32();
/* 1302 */       if (size >= 12)
/*      */       {
/* 1304 */         this.info_forbids = new HashMap(size * 2);
/*      */       }
/* 1306 */       for (; size > 0; size--)
/*      */       {
/* 1308 */         long _k_ = 0L;
/* 1309 */         _k_ = _os_.unmarshal_long();
/* 1310 */         xbean.RoleInfoForbid _v_ = Pod.newRoleInfoForbidData();
/* 1311 */         _v_.unmarshal(_os_);
/* 1312 */         this.info_forbids.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1316 */       int size = _os_.uncompact_uint32();
/* 1317 */       if (size >= 12)
/*      */       {
/* 1319 */         this.n_times_award = new HashMap(size * 2);
/*      */       }
/* 1321 */       for (; size > 0; size--)
/*      */       {
/* 1323 */         int _k_ = 0;
/* 1324 */         _k_ = _os_.unmarshal_int();
/* 1325 */         xbean.IdipNTimesAwardInfo _v_ = Pod.newIdipNTimesAwardInfoData();
/* 1326 */         _v_.unmarshal(_os_);
/* 1327 */         this.n_times_award.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1330 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1332 */         long _v_ = 0L;
/* 1333 */         _v_ = _os_.unmarshal_long();
/* 1334 */         this.notices.add(Long.valueOf(_v_));
/*      */       }
/* 1336 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1338 */         long _v_ = 0L;
/* 1339 */         _v_ = _os_.unmarshal_long();
/* 1340 */         this.marquees.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/* 1343 */       int size = _os_.uncompact_uint32();
/* 1344 */       if (size >= 12)
/*      */       {
/* 1346 */         this.hide_items = new HashMap(size * 2);
/*      */       }
/* 1348 */       for (; size > 0; size--)
/*      */       {
/* 1350 */         int _k_ = 0;
/* 1351 */         _k_ = _os_.unmarshal_int();
/* 1352 */         xbean.HideItemInfo _v_ = Pod.newHideItemInfoData();
/* 1353 */         _v_.unmarshal(_os_);
/* 1354 */         this.hide_items.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1357 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1363 */       int _size_ = 0;
/* 1364 */       for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : this.rank_forbids.entrySet())
/*      */       {
/* 1366 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 1367 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/* 1369 */       for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : this.zero_profits.entrySet())
/*      */       {
/* 1371 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 1372 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/* 1374 */       for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : this.play_forbids.entrySet())
/*      */       {
/* 1376 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 1377 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/* 1379 */       for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : this.info_forbids.entrySet())
/*      */       {
/* 1381 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 1382 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/* 1384 */       for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award.entrySet())
/*      */       {
/* 1386 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1387 */         _size_ += CodedOutputStream.computeMessageSize(6, (Message)_e_.getValue());
/*      */       }
/* 1389 */       for (Long _v_ : this.notices)
/*      */       {
/* 1391 */         _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */       }
/* 1393 */       for (Long _v_ : this.marquees)
/*      */       {
/* 1395 */         _size_ += CodedOutputStream.computeInt64Size(8, _v_.longValue());
/*      */       }
/* 1397 */       for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : this.hide_items.entrySet())
/*      */       {
/* 1399 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/* 1400 */         _size_ += CodedOutputStream.computeMessageSize(9, (Message)_e_.getValue());
/*      */       }
/* 1402 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1410 */         for (Map.Entry<Long, xbean.RoleRankForbid> _e_ : this.rank_forbids.entrySet())
/*      */         {
/* 1412 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 1413 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/* 1415 */         for (Map.Entry<Long, xbean.IdipForbidInfo> _e_ : this.zero_profits.entrySet())
/*      */         {
/* 1417 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 1418 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/* 1420 */         for (Map.Entry<Long, xbean.RolePlayForbid> _e_ : this.play_forbids.entrySet())
/*      */         {
/* 1422 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 1423 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/* 1425 */         for (Map.Entry<Long, xbean.RoleInfoForbid> _e_ : this.info_forbids.entrySet())
/*      */         {
/* 1427 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 1428 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/* 1430 */         for (Map.Entry<Integer, xbean.IdipNTimesAwardInfo> _e_ : this.n_times_award.entrySet())
/*      */         {
/* 1432 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1433 */           _output_.writeMessage(6, (Message)_e_.getValue());
/*      */         }
/* 1435 */         for (Long _v_ : this.notices)
/*      */         {
/* 1437 */           _output_.writeInt64(7, _v_.longValue());
/*      */         }
/* 1439 */         for (Long _v_ : this.marquees)
/*      */         {
/* 1441 */           _output_.writeInt64(8, _v_.longValue());
/*      */         }
/* 1443 */         for (Map.Entry<Integer, xbean.HideItemInfo> _e_ : this.hide_items.entrySet())
/*      */         {
/* 1445 */           _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/* 1446 */           _output_.writeMessage(9, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1451 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1453 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1461 */         boolean done = false;
/* 1462 */         while (!done)
/*      */         {
/* 1464 */           int tag = _input_.readTag();
/* 1465 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1469 */             done = true;
/* 1470 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1474 */             long _k_ = 0L;
/* 1475 */             _k_ = _input_.readInt64();
/* 1476 */             int readTag = _input_.readTag();
/* 1477 */             if (10 != readTag)
/*      */             {
/* 1479 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1481 */             xbean.RoleRankForbid _v_ = Pod.newRoleRankForbidData();
/* 1482 */             _input_.readMessage(_v_);
/* 1483 */             this.rank_forbids.put(Long.valueOf(_k_), _v_);
/* 1484 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1488 */             long _k_ = 0L;
/* 1489 */             _k_ = _input_.readInt64();
/* 1490 */             int readTag = _input_.readTag();
/* 1491 */             if (18 != readTag)
/*      */             {
/* 1493 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1495 */             xbean.IdipForbidInfo _v_ = Pod.newIdipForbidInfoData();
/* 1496 */             _input_.readMessage(_v_);
/* 1497 */             this.zero_profits.put(Long.valueOf(_k_), _v_);
/* 1498 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1502 */             long _k_ = 0L;
/* 1503 */             _k_ = _input_.readInt64();
/* 1504 */             int readTag = _input_.readTag();
/* 1505 */             if (26 != readTag)
/*      */             {
/* 1507 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1509 */             xbean.RolePlayForbid _v_ = Pod.newRolePlayForbidData();
/* 1510 */             _input_.readMessage(_v_);
/* 1511 */             this.play_forbids.put(Long.valueOf(_k_), _v_);
/* 1512 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1516 */             long _k_ = 0L;
/* 1517 */             _k_ = _input_.readInt64();
/* 1518 */             int readTag = _input_.readTag();
/* 1519 */             if (34 != readTag)
/*      */             {
/* 1521 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1523 */             xbean.RoleInfoForbid _v_ = Pod.newRoleInfoForbidData();
/* 1524 */             _input_.readMessage(_v_);
/* 1525 */             this.info_forbids.put(Long.valueOf(_k_), _v_);
/* 1526 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1530 */             int _k_ = 0;
/* 1531 */             _k_ = _input_.readInt32();
/* 1532 */             int readTag = _input_.readTag();
/* 1533 */             if (50 != readTag)
/*      */             {
/* 1535 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1537 */             xbean.IdipNTimesAwardInfo _v_ = Pod.newIdipNTimesAwardInfoData();
/* 1538 */             _input_.readMessage(_v_);
/* 1539 */             this.n_times_award.put(Integer.valueOf(_k_), _v_);
/* 1540 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1544 */             long _v_ = 0L;
/* 1545 */             _v_ = _input_.readInt64();
/* 1546 */             this.notices.add(Long.valueOf(_v_));
/* 1547 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1551 */             long _v_ = 0L;
/* 1552 */             _v_ = _input_.readInt64();
/* 1553 */             this.marquees.add(Long.valueOf(_v_));
/* 1554 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1558 */             int _k_ = 0;
/* 1559 */             _k_ = _input_.readInt32();
/* 1560 */             int readTag = _input_.readTag();
/* 1561 */             if (74 != readTag)
/*      */             {
/* 1563 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1565 */             xbean.HideItemInfo _v_ = Pod.newHideItemInfoData();
/* 1566 */             _input_.readMessage(_v_);
/* 1567 */             this.hide_items.put(Integer.valueOf(_k_), _v_);
/* 1568 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1574 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1583 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1589 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipConfigInfo copy()
/*      */     {
/* 1595 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipConfigInfo toData()
/*      */     {
/* 1601 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.IdipConfigInfo toBean()
/*      */     {
/* 1606 */       return new IdipConfigInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipConfigInfo toDataIf()
/*      */     {
/* 1612 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.IdipConfigInfo toBeanIf()
/*      */     {
/* 1617 */       return new IdipConfigInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1627 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1631 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1635 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1643 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1647 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRankForbid> getRank_forbids()
/*      */     {
/* 1654 */       return this.rank_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRankForbid> getRank_forbidsAsData()
/*      */     {
/* 1661 */       return this.rank_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.IdipForbidInfo> getZero_profits()
/*      */     {
/* 1668 */       return this.zero_profits;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.IdipForbidInfo> getZero_profitsAsData()
/*      */     {
/* 1675 */       return this.zero_profits;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RolePlayForbid> getPlay_forbids()
/*      */     {
/* 1682 */       return this.play_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RolePlayForbid> getPlay_forbidsAsData()
/*      */     {
/* 1689 */       return this.play_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleInfoForbid> getInfo_forbids()
/*      */     {
/* 1696 */       return this.info_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleInfoForbid> getInfo_forbidsAsData()
/*      */     {
/* 1703 */       return this.info_forbids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_award()
/*      */     {
/* 1710 */       return this.n_times_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IdipNTimesAwardInfo> getN_times_awardAsData()
/*      */     {
/* 1717 */       return this.n_times_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getNotices()
/*      */     {
/* 1724 */       return this.notices;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getNoticesAsData()
/*      */     {
/* 1731 */       return this.notices;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMarquees()
/*      */     {
/* 1738 */       return this.marquees;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMarqueesAsData()
/*      */     {
/* 1745 */       return this.marquees;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.HideItemInfo> getHide_items()
/*      */     {
/* 1752 */       return this.hide_items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.HideItemInfo> getHide_itemsAsData()
/*      */     {
/* 1759 */       return this.hide_items;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1765 */       if (!(_o1_ instanceof Data)) return false;
/* 1766 */       Data _o_ = (Data)_o1_;
/* 1767 */       if (!this.rank_forbids.equals(_o_.rank_forbids)) return false;
/* 1768 */       if (!this.zero_profits.equals(_o_.zero_profits)) return false;
/* 1769 */       if (!this.play_forbids.equals(_o_.play_forbids)) return false;
/* 1770 */       if (!this.info_forbids.equals(_o_.info_forbids)) return false;
/* 1771 */       if (!this.n_times_award.equals(_o_.n_times_award)) return false;
/* 1772 */       if (!this.notices.equals(_o_.notices)) return false;
/* 1773 */       if (!this.marquees.equals(_o_.marquees)) return false;
/* 1774 */       if (!this.hide_items.equals(_o_.hide_items)) return false;
/* 1775 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1781 */       int _h_ = 0;
/* 1782 */       _h_ += this.rank_forbids.hashCode();
/* 1783 */       _h_ += this.zero_profits.hashCode();
/* 1784 */       _h_ += this.play_forbids.hashCode();
/* 1785 */       _h_ += this.info_forbids.hashCode();
/* 1786 */       _h_ += this.n_times_award.hashCode();
/* 1787 */       _h_ += this.notices.hashCode();
/* 1788 */       _h_ += this.marquees.hashCode();
/* 1789 */       _h_ += this.hide_items.hashCode();
/* 1790 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1796 */       StringBuilder _sb_ = new StringBuilder();
/* 1797 */       _sb_.append("(");
/* 1798 */       _sb_.append(this.rank_forbids);
/* 1799 */       _sb_.append(",");
/* 1800 */       _sb_.append(this.zero_profits);
/* 1801 */       _sb_.append(",");
/* 1802 */       _sb_.append(this.play_forbids);
/* 1803 */       _sb_.append(",");
/* 1804 */       _sb_.append(this.info_forbids);
/* 1805 */       _sb_.append(",");
/* 1806 */       _sb_.append(this.n_times_award);
/* 1807 */       _sb_.append(",");
/* 1808 */       _sb_.append(this.notices);
/* 1809 */       _sb_.append(",");
/* 1810 */       _sb_.append(this.marquees);
/* 1811 */       _sb_.append(",");
/* 1812 */       _sb_.append(this.hide_items);
/* 1813 */       _sb_.append(")");
/* 1814 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IdipConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */