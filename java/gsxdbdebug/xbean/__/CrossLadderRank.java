/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.TreeMap;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class CrossLadderRank extends XBean implements xbean.CrossLadderRank
/*     */ {
/*     */   private long season_begin_timestamp;
/*     */   private TreeMap<Integer, xbean.CrossLadderRankList> level_range_ranks;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.season_begin_timestamp = 0L;
/*  21 */     this.level_range_ranks.clear();
/*     */   }
/*     */   
/*     */   CrossLadderRank(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.level_range_ranks = new TreeMap();
/*     */   }
/*     */   
/*     */   public CrossLadderRank()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossLadderRank(CrossLadderRank _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossLadderRank(xbean.CrossLadderRank _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof CrossLadderRank)) { assign((CrossLadderRank)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossLadderRank _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.season_begin_timestamp = _o_.season_begin_timestamp;
/*  53 */     this.level_range_ranks = new TreeMap();
/*  54 */     for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : _o_.level_range_ranks.entrySet()) {
/*  55 */       this.level_range_ranks.put(_e_.getKey(), new CrossLadderRankList((xbean.CrossLadderRankList)_e_.getValue(), this, "level_range_ranks"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.season_begin_timestamp = _o_.season_begin_timestamp;
/*  61 */     this.level_range_ranks = new TreeMap();
/*  62 */     for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : _o_.level_range_ranks.entrySet()) {
/*  63 */       this.level_range_ranks.put(_e_.getKey(), new CrossLadderRankList((xbean.CrossLadderRankList)_e_.getValue(), this, "level_range_ranks"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.season_begin_timestamp);
/*  71 */     _os_.compact_uint32(this.level_range_ranks.size());
/*  72 */     for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : this.level_range_ranks.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.CrossLadderRankList)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.season_begin_timestamp = _os_.unmarshal_long();
/*  85 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  87 */       int _k_ = 0;
/*  88 */       _k_ = _os_.unmarshal_int();
/*  89 */       xbean.CrossLadderRankList _v_ = new CrossLadderRankList(0, this, "level_range_ranks");
/*  90 */       _v_.unmarshal(_os_);
/*  91 */       this.level_range_ranks.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     int _size_ = 0;
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(1, this.season_begin_timestamp);
/* 102 */     for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : this.level_range_ranks.entrySet())
/*     */     {
/* 104 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 105 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 107 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 116 */       _output_.writeInt64(1, this.season_begin_timestamp);
/* 117 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : this.level_range_ranks.entrySet())
/*     */       {
/* 119 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 120 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 125 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 127 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 136 */       boolean done = false;
/* 137 */       while (!done)
/*     */       {
/* 139 */         int tag = _input_.readTag();
/* 140 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 144 */           done = true;
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 149 */           this.season_begin_timestamp = _input_.readInt64();
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 154 */           int _k_ = 0;
/* 155 */           _k_ = _input_.readInt32();
/* 156 */           int readTag = _input_.readTag();
/* 157 */           if (18 != readTag)
/*     */           {
/* 159 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 161 */           xbean.CrossLadderRankList _v_ = new CrossLadderRankList(0, this, "level_range_ranks");
/* 162 */           _input_.readMessage(_v_);
/* 163 */           this.level_range_ranks.put(Integer.valueOf(_k_), _v_);
/* 164 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 168 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 170 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 179 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 183 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 185 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRank copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new CrossLadderRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRank toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderRank toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new CrossLadderRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRank toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderRank toBeanIf()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSeason_begin_timestamp()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return this.season_begin_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public NavigableMap<Integer, xbean.CrossLadderRankList> getLevel_range_ranks()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logNavigableMap(new xdb.LogKey(this, "level_range_ranks"), this.level_range_ranks);
/*     */   }
/*     */   
/*     */ 
/*     */   public NavigableMap<Integer, xbean.CrossLadderRankList> getLevel_range_ranksAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     CrossLadderRank _o_ = this;
/* 250 */     NavigableMap<Integer, xbean.CrossLadderRankList> level_range_ranks = new TreeMap();
/* 251 */     for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : _o_.level_range_ranks.entrySet())
/* 252 */       level_range_ranks.put(_e_.getKey(), new CrossLadderRankList.Data((xbean.CrossLadderRankList)_e_.getValue()));
/* 253 */     return level_range_ranks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSeason_begin_timestamp(long _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new xdb.LogKey(this, "season_begin_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogLong(this, CrossLadderRank.this.season_begin_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             CrossLadderRank.this.season_begin_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.season_begin_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     CrossLadderRank _o_ = null;
/* 282 */     if ((_o1_ instanceof CrossLadderRank)) { _o_ = (CrossLadderRank)_o1_;
/* 283 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 284 */       return false;
/* 285 */     if (this.season_begin_timestamp != _o_.season_begin_timestamp) return false;
/* 286 */     if (!this.level_range_ranks.equals(_o_.level_range_ranks)) return false;
/* 287 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     int _h_ = 0;
/* 295 */     _h_ = (int)(_h_ + this.season_begin_timestamp);
/* 296 */     _h_ += this.level_range_ranks.hashCode();
/* 297 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     StringBuilder _sb_ = new StringBuilder();
/* 305 */     _sb_.append("(");
/* 306 */     _sb_.append(this.season_begin_timestamp);
/* 307 */     _sb_.append(",");
/* 308 */     _sb_.append(this.level_range_ranks);
/* 309 */     _sb_.append(")");
/* 310 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 316 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 317 */     lb.add(new xdb.logs.ListenableChanged().setVarName("season_begin_timestamp"));
/* 318 */     lb.add(new xdb.logs.ListenableMap().setVarName("level_range_ranks"));
/* 319 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossLadderRank {
/*     */     private Const() {}
/*     */     
/*     */     CrossLadderRank nThis() {
/* 326 */       return CrossLadderRank.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 332 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRank copy()
/*     */     {
/* 338 */       return CrossLadderRank.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRank toData()
/*     */     {
/* 344 */       return CrossLadderRank.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRank toBean()
/*     */     {
/* 349 */       return CrossLadderRank.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRank toDataIf()
/*     */     {
/* 355 */       return CrossLadderRank.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRank toBeanIf()
/*     */     {
/* 360 */       return CrossLadderRank.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSeason_begin_timestamp()
/*     */     {
/* 367 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 368 */       return CrossLadderRank.this.season_begin_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderRankList> getLevel_range_ranks()
/*     */     {
/* 375 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constNavigableMap(CrossLadderRank.this.level_range_ranks);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderRankList> getLevel_range_ranksAsData()
/*     */     {
/* 383 */       CrossLadderRank.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       CrossLadderRank _o_ = CrossLadderRank.this;
/* 386 */       NavigableMap<Integer, xbean.CrossLadderRankList> level_range_ranks = new TreeMap();
/* 387 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : _o_.level_range_ranks.entrySet())
/* 388 */         level_range_ranks.put(_e_.getKey(), new CrossLadderRankList.Data((xbean.CrossLadderRankList)_e_.getValue()));
/* 389 */       return level_range_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeason_begin_timestamp(long _v_)
/*     */     {
/* 396 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 397 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 403 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 404 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 410 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 411 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 417 */       return CrossLadderRank.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 423 */       return CrossLadderRank.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 429 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 430 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 436 */       return CrossLadderRank.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 442 */       return CrossLadderRank.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 448 */       CrossLadderRank.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 455 */       return CrossLadderRank.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 461 */       return CrossLadderRank.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 467 */       return CrossLadderRank.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 473 */       return CrossLadderRank.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 479 */       return CrossLadderRank.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 485 */       return CrossLadderRank.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 491 */       return CrossLadderRank.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossLadderRank
/*     */   {
/*     */     private long season_begin_timestamp;
/*     */     
/*     */     private TreeMap<Integer, xbean.CrossLadderRankList> level_range_ranks;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 510 */       this.level_range_ranks = new TreeMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossLadderRank _o1_)
/*     */     {
/* 515 */       if ((_o1_ instanceof CrossLadderRank)) { assign((CrossLadderRank)_o1_);
/* 516 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 517 */       } else if ((_o1_ instanceof CrossLadderRank.Const)) assign(((CrossLadderRank.Const)_o1_).nThis()); else {
/* 518 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossLadderRank _o_) {
/* 523 */       this.season_begin_timestamp = _o_.season_begin_timestamp;
/* 524 */       this.level_range_ranks = new TreeMap();
/* 525 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : _o_.level_range_ranks.entrySet()) {
/* 526 */         this.level_range_ranks.put(_e_.getKey(), new CrossLadderRankList.Data((xbean.CrossLadderRankList)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 531 */       this.season_begin_timestamp = _o_.season_begin_timestamp;
/* 532 */       this.level_range_ranks = new TreeMap();
/* 533 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : _o_.level_range_ranks.entrySet()) {
/* 534 */         this.level_range_ranks.put(_e_.getKey(), new CrossLadderRankList.Data((xbean.CrossLadderRankList)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 540 */       _os_.marshal(this.season_begin_timestamp);
/* 541 */       _os_.compact_uint32(this.level_range_ranks.size());
/* 542 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : this.level_range_ranks.entrySet())
/*     */       {
/* 544 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 545 */         ((xbean.CrossLadderRankList)_e_.getValue()).marshal(_os_);
/*     */       }
/* 547 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 553 */       this.season_begin_timestamp = _os_.unmarshal_long();
/* 554 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 556 */         int _k_ = 0;
/* 557 */         _k_ = _os_.unmarshal_int();
/* 558 */         xbean.CrossLadderRankList _v_ = xbean.Pod.newCrossLadderRankListData();
/* 559 */         _v_.unmarshal(_os_);
/* 560 */         this.level_range_ranks.put(Integer.valueOf(_k_), _v_);
/*     */       }
/* 562 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 568 */       int _size_ = 0;
/* 569 */       _size_ += CodedOutputStream.computeInt64Size(1, this.season_begin_timestamp);
/* 570 */       for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : this.level_range_ranks.entrySet())
/*     */       {
/* 572 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 573 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 575 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 583 */         _output_.writeInt64(1, this.season_begin_timestamp);
/* 584 */         for (Map.Entry<Integer, xbean.CrossLadderRankList> _e_ : this.level_range_ranks.entrySet())
/*     */         {
/* 586 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 587 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 592 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 594 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 602 */         boolean done = false;
/* 603 */         while (!done)
/*     */         {
/* 605 */           int tag = _input_.readTag();
/* 606 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 610 */             done = true;
/* 611 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 615 */             this.season_begin_timestamp = _input_.readInt64();
/* 616 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 620 */             int _k_ = 0;
/* 621 */             _k_ = _input_.readInt32();
/* 622 */             int readTag = _input_.readTag();
/* 623 */             if (18 != readTag)
/*     */             {
/* 625 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 627 */             xbean.CrossLadderRankList _v_ = xbean.Pod.newCrossLadderRankListData();
/* 628 */             _input_.readMessage(_v_);
/* 629 */             this.level_range_ranks.put(Integer.valueOf(_k_), _v_);
/* 630 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 634 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 636 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 645 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 649 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 651 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRank copy()
/*     */     {
/* 657 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRank toData()
/*     */     {
/* 663 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRank toBean()
/*     */     {
/* 668 */       return new CrossLadderRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRank toDataIf()
/*     */     {
/* 674 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRank toBeanIf()
/*     */     {
/* 679 */       return new CrossLadderRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 685 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 689 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 693 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 697 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 701 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 705 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 709 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSeason_begin_timestamp()
/*     */     {
/* 716 */       return this.season_begin_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderRankList> getLevel_range_ranks()
/*     */     {
/* 723 */       return this.level_range_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderRankList> getLevel_range_ranksAsData()
/*     */     {
/* 730 */       return this.level_range_ranks;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeason_begin_timestamp(long _v_)
/*     */     {
/* 737 */       this.season_begin_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 743 */       if (!(_o1_ instanceof Data)) return false;
/* 744 */       Data _o_ = (Data)_o1_;
/* 745 */       if (this.season_begin_timestamp != _o_.season_begin_timestamp) return false;
/* 746 */       if (!this.level_range_ranks.equals(_o_.level_range_ranks)) return false;
/* 747 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 753 */       int _h_ = 0;
/* 754 */       _h_ = (int)(_h_ + this.season_begin_timestamp);
/* 755 */       _h_ += this.level_range_ranks.hashCode();
/* 756 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 762 */       StringBuilder _sb_ = new StringBuilder();
/* 763 */       _sb_.append("(");
/* 764 */       _sb_.append(this.season_begin_timestamp);
/* 765 */       _sb_.append(",");
/* 766 */       _sb_.append(this.level_range_ranks);
/* 767 */       _sb_.append(")");
/* 768 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossLadderRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */