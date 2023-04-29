/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class FeedInfo extends XBean implements xbean.FeedInfo
/*     */ {
/*     */   private HashMap<Long, Integer> feed_cat_records;
/*     */   private long feed_timestamp;
/*     */   private HashMap<Long, xbean.FeedCatInfo> feed_records;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.feed_cat_records.clear();
/*  23 */     this.feed_timestamp = 0L;
/*  24 */     this.feed_records.clear();
/*     */   }
/*     */   
/*     */   FeedInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.feed_cat_records = new HashMap();
/*  31 */     this.feed_records = new HashMap();
/*     */   }
/*     */   
/*     */   public FeedInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FeedInfo(FeedInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FeedInfo(xbean.FeedInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof FeedInfo)) { assign((FeedInfo)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FeedInfo _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.feed_cat_records = new HashMap();
/*  57 */     for (Map.Entry<Long, Integer> _e_ : _o_.feed_cat_records.entrySet())
/*  58 */       this.feed_cat_records.put(_e_.getKey(), _e_.getValue());
/*  59 */     this.feed_timestamp = _o_.feed_timestamp;
/*  60 */     this.feed_records = new HashMap();
/*  61 */     for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : _o_.feed_records.entrySet()) {
/*  62 */       this.feed_records.put(_e_.getKey(), new FeedCatInfo((xbean.FeedCatInfo)_e_.getValue(), this, "feed_records"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.feed_cat_records = new HashMap();
/*  68 */     for (Map.Entry<Long, Integer> _e_ : _o_.feed_cat_records.entrySet())
/*  69 */       this.feed_cat_records.put(_e_.getKey(), _e_.getValue());
/*  70 */     this.feed_timestamp = _o_.feed_timestamp;
/*  71 */     this.feed_records = new HashMap();
/*  72 */     for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : _o_.feed_records.entrySet()) {
/*  73 */       this.feed_records.put(_e_.getKey(), new FeedCatInfo((xbean.FeedCatInfo)_e_.getValue(), this, "feed_records"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.feed_cat_records.size());
/*  81 */     for (Map.Entry<Long, Integer> _e_ : this.feed_cat_records.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  84 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  86 */     _os_.marshal(this.feed_timestamp);
/*  87 */     _os_.compact_uint32(this.feed_records.size());
/*  88 */     for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : this.feed_records.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  91 */       ((xbean.FeedCatInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     
/* 101 */     int size = _os_.uncompact_uint32();
/* 102 */     if (size >= 12)
/*     */     {
/* 104 */       this.feed_cat_records = new HashMap(size * 2);
/*     */     }
/* 106 */     for (; size > 0; size--)
/*     */     {
/* 108 */       long _k_ = 0L;
/* 109 */       _k_ = _os_.unmarshal_long();
/* 110 */       int _v_ = 0;
/* 111 */       _v_ = _os_.unmarshal_int();
/* 112 */       this.feed_cat_records.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 115 */     this.feed_timestamp = _os_.unmarshal_long();
/*     */     
/* 117 */     int size = _os_.uncompact_uint32();
/* 118 */     if (size >= 12)
/*     */     {
/* 120 */       this.feed_records = new HashMap(size * 2);
/*     */     }
/* 122 */     for (; size > 0; size--)
/*     */     {
/* 124 */       long _k_ = 0L;
/* 125 */       _k_ = _os_.unmarshal_long();
/* 126 */       xbean.FeedCatInfo _v_ = new FeedCatInfo(0, this, "feed_records");
/* 127 */       _v_.unmarshal(_os_);
/* 128 */       this.feed_records.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     for (Map.Entry<Long, Integer> _e_ : this.feed_cat_records.entrySet())
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 142 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 144 */     _size_ += CodedOutputStream.computeInt64Size(2, this.feed_timestamp);
/* 145 */     for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : this.feed_records.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 148 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       for (Map.Entry<Long, Integer> _e_ : this.feed_cat_records.entrySet())
/*     */       {
/* 161 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 162 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 164 */       _output_.writeInt64(2, this.feed_timestamp);
/* 165 */       for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : this.feed_records.entrySet())
/*     */       {
/* 167 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 168 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 184 */       boolean done = false;
/* 185 */       while (!done)
/*     */       {
/* 187 */         int tag = _input_.readTag();
/* 188 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 192 */           done = true;
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 197 */           long _k_ = 0L;
/* 198 */           _k_ = _input_.readInt64();
/* 199 */           int readTag = _input_.readTag();
/* 200 */           if (8 != readTag)
/*     */           {
/* 202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 204 */           int _v_ = 0;
/* 205 */           _v_ = _input_.readInt32();
/* 206 */           this.feed_cat_records.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 207 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 211 */           this.feed_timestamp = _input_.readInt64();
/* 212 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 216 */           long _k_ = 0L;
/* 217 */           _k_ = _input_.readInt64();
/* 218 */           int readTag = _input_.readTag();
/* 219 */           if (26 != readTag)
/*     */           {
/* 221 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 223 */           xbean.FeedCatInfo _v_ = new FeedCatInfo(0, this, "feed_records");
/* 224 */           _input_.readMessage(_v_);
/* 225 */           this.feed_records.put(Long.valueOf(_k_), _v_);
/* 226 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 232 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 241 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 247 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeedInfo copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new FeedInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeedInfo toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FeedInfo toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new FeedInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FeedInfo toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FeedInfo toBeanIf()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getFeed_cat_records()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logMap(new LogKey(this, "feed_cat_records"), this.feed_cat_records);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Integer> getFeed_cat_recordsAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     FeedInfo _o_ = this;
/* 305 */     Map<Long, Integer> feed_cat_records = new HashMap();
/* 306 */     for (Map.Entry<Long, Integer> _e_ : _o_.feed_cat_records.entrySet())
/* 307 */       feed_cat_records.put(_e_.getKey(), _e_.getValue());
/* 308 */     return feed_cat_records;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFeed_timestamp()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     return this.feed_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.FeedCatInfo> getFeed_records()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     return xdb.Logs.logMap(new LogKey(this, "feed_records"), this.feed_records);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.FeedCatInfo> getFeed_recordsAsData()
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/*     */     
/* 333 */     FeedInfo _o_ = this;
/* 334 */     Map<Long, xbean.FeedCatInfo> feed_records = new HashMap();
/* 335 */     for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : _o_.feed_records.entrySet())
/* 336 */       feed_records.put(_e_.getKey(), new FeedCatInfo.Data((xbean.FeedCatInfo)_e_.getValue()));
/* 337 */     return feed_records;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFeed_timestamp(long _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "feed_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogLong(this, FeedInfo.this.feed_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             FeedInfo.this.feed_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.feed_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     FeedInfo _o_ = null;
/* 366 */     if ((_o1_ instanceof FeedInfo)) { _o_ = (FeedInfo)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (!this.feed_cat_records.equals(_o_.feed_cat_records)) return false;
/* 370 */     if (this.feed_timestamp != _o_.feed_timestamp) return false;
/* 371 */     if (!this.feed_records.equals(_o_.feed_records)) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.feed_cat_records.hashCode();
/* 381 */     _h_ = (int)(_h_ + this.feed_timestamp);
/* 382 */     _h_ += this.feed_records.hashCode();
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.feed_cat_records);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.feed_timestamp);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.feed_records);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableMap().setVarName("feed_cat_records"));
/* 406 */     lb.add(new xdb.logs.ListenableChanged().setVarName("feed_timestamp"));
/* 407 */     lb.add(new xdb.logs.ListenableMap().setVarName("feed_records"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FeedInfo {
/*     */     private Const() {}
/*     */     
/*     */     FeedInfo nThis() {
/* 415 */       return FeedInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeedInfo copy()
/*     */     {
/* 427 */       return FeedInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeedInfo toData()
/*     */     {
/* 433 */       return FeedInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FeedInfo toBean()
/*     */     {
/* 438 */       return FeedInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeedInfo toDataIf()
/*     */     {
/* 444 */       return FeedInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FeedInfo toBeanIf()
/*     */     {
/* 449 */       return FeedInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getFeed_cat_records()
/*     */     {
/* 456 */       FeedInfo.this._xdb_verify_unsafe_();
/* 457 */       return xdb.Consts.constMap(FeedInfo.this.feed_cat_records);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getFeed_cat_recordsAsData()
/*     */     {
/* 464 */       FeedInfo.this._xdb_verify_unsafe_();
/*     */       
/* 466 */       FeedInfo _o_ = FeedInfo.this;
/* 467 */       Map<Long, Integer> feed_cat_records = new HashMap();
/* 468 */       for (Map.Entry<Long, Integer> _e_ : _o_.feed_cat_records.entrySet())
/* 469 */         feed_cat_records.put(_e_.getKey(), _e_.getValue());
/* 470 */       return feed_cat_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFeed_timestamp()
/*     */     {
/* 477 */       FeedInfo.this._xdb_verify_unsafe_();
/* 478 */       return FeedInfo.this.feed_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FeedCatInfo> getFeed_records()
/*     */     {
/* 485 */       FeedInfo.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constMap(FeedInfo.this.feed_records);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FeedCatInfo> getFeed_recordsAsData()
/*     */     {
/* 493 */       FeedInfo.this._xdb_verify_unsafe_();
/*     */       
/* 495 */       FeedInfo _o_ = FeedInfo.this;
/* 496 */       Map<Long, xbean.FeedCatInfo> feed_records = new HashMap();
/* 497 */       for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : _o_.feed_records.entrySet())
/* 498 */         feed_records.put(_e_.getKey(), new FeedCatInfo.Data((xbean.FeedCatInfo)_e_.getValue()));
/* 499 */       return feed_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFeed_timestamp(long _v_)
/*     */     {
/* 506 */       FeedInfo.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       FeedInfo.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       FeedInfo.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return FeedInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return FeedInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       FeedInfo.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return FeedInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return FeedInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       FeedInfo.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return FeedInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return FeedInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return FeedInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return FeedInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return FeedInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return FeedInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return FeedInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FeedInfo
/*     */   {
/*     */     private HashMap<Long, Integer> feed_cat_records;
/*     */     
/*     */     private long feed_timestamp;
/*     */     
/*     */     private HashMap<Long, xbean.FeedCatInfo> feed_records;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.feed_cat_records = new HashMap();
/* 623 */       this.feed_records = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.FeedInfo _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof FeedInfo)) { assign((FeedInfo)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof FeedInfo.Const)) assign(((FeedInfo.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FeedInfo _o_) {
/* 636 */       this.feed_cat_records = new HashMap();
/* 637 */       for (Map.Entry<Long, Integer> _e_ : _o_.feed_cat_records.entrySet())
/* 638 */         this.feed_cat_records.put(_e_.getKey(), _e_.getValue());
/* 639 */       this.feed_timestamp = _o_.feed_timestamp;
/* 640 */       this.feed_records = new HashMap();
/* 641 */       for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : _o_.feed_records.entrySet()) {
/* 642 */         this.feed_records.put(_e_.getKey(), new FeedCatInfo.Data((xbean.FeedCatInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 647 */       this.feed_cat_records = new HashMap();
/* 648 */       for (Map.Entry<Long, Integer> _e_ : _o_.feed_cat_records.entrySet())
/* 649 */         this.feed_cat_records.put(_e_.getKey(), _e_.getValue());
/* 650 */       this.feed_timestamp = _o_.feed_timestamp;
/* 651 */       this.feed_records = new HashMap();
/* 652 */       for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : _o_.feed_records.entrySet()) {
/* 653 */         this.feed_records.put(_e_.getKey(), new FeedCatInfo.Data((xbean.FeedCatInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.compact_uint32(this.feed_cat_records.size());
/* 660 */       for (Map.Entry<Long, Integer> _e_ : this.feed_cat_records.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 663 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       _os_.marshal(this.feed_timestamp);
/* 666 */       _os_.compact_uint32(this.feed_records.size());
/* 667 */       for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : this.feed_records.entrySet())
/*     */       {
/* 669 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 670 */         ((xbean.FeedCatInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 679 */       int size = _os_.uncompact_uint32();
/* 680 */       if (size >= 12)
/*     */       {
/* 682 */         this.feed_cat_records = new HashMap(size * 2);
/*     */       }
/* 684 */       for (; size > 0; size--)
/*     */       {
/* 686 */         long _k_ = 0L;
/* 687 */         _k_ = _os_.unmarshal_long();
/* 688 */         int _v_ = 0;
/* 689 */         _v_ = _os_.unmarshal_int();
/* 690 */         this.feed_cat_records.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 693 */       this.feed_timestamp = _os_.unmarshal_long();
/*     */       
/* 695 */       int size = _os_.uncompact_uint32();
/* 696 */       if (size >= 12)
/*     */       {
/* 698 */         this.feed_records = new HashMap(size * 2);
/*     */       }
/* 700 */       for (; size > 0; size--)
/*     */       {
/* 702 */         long _k_ = 0L;
/* 703 */         _k_ = _os_.unmarshal_long();
/* 704 */         xbean.FeedCatInfo _v_ = xbean.Pod.newFeedCatInfoData();
/* 705 */         _v_.unmarshal(_os_);
/* 706 */         this.feed_records.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       for (Map.Entry<Long, Integer> _e_ : this.feed_cat_records.entrySet())
/*     */       {
/* 718 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 719 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 721 */       _size_ += CodedOutputStream.computeInt64Size(2, this.feed_timestamp);
/* 722 */       for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : this.feed_records.entrySet())
/*     */       {
/* 724 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 725 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         for (Map.Entry<Long, Integer> _e_ : this.feed_cat_records.entrySet())
/*     */         {
/* 737 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 738 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 740 */         _output_.writeInt64(2, this.feed_timestamp);
/* 741 */         for (Map.Entry<Long, xbean.FeedCatInfo> _e_ : this.feed_records.entrySet())
/*     */         {
/* 743 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 744 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             long _k_ = 0L;
/* 773 */             _k_ = _input_.readInt64();
/* 774 */             int readTag = _input_.readTag();
/* 775 */             if (8 != readTag)
/*     */             {
/* 777 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 779 */             int _v_ = 0;
/* 780 */             _v_ = _input_.readInt32();
/* 781 */             this.feed_cat_records.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 786 */             this.feed_timestamp = _input_.readInt64();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             long _k_ = 0L;
/* 792 */             _k_ = _input_.readInt64();
/* 793 */             int readTag = _input_.readTag();
/* 794 */             if (26 != readTag)
/*     */             {
/* 796 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 798 */             xbean.FeedCatInfo _v_ = xbean.Pod.newFeedCatInfoData();
/* 799 */             _input_.readMessage(_v_);
/* 800 */             this.feed_records.put(Long.valueOf(_k_), _v_);
/* 801 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 805 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 807 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 816 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 820 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 822 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeedInfo copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeedInfo toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FeedInfo toBean()
/*     */     {
/* 839 */       return new FeedInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FeedInfo toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FeedInfo toBeanIf()
/*     */     {
/* 850 */       return new FeedInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 872 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 876 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 880 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getFeed_cat_records()
/*     */     {
/* 887 */       return this.feed_cat_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Integer> getFeed_cat_recordsAsData()
/*     */     {
/* 894 */       return this.feed_cat_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFeed_timestamp()
/*     */     {
/* 901 */       return this.feed_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FeedCatInfo> getFeed_records()
/*     */     {
/* 908 */       return this.feed_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.FeedCatInfo> getFeed_recordsAsData()
/*     */     {
/* 915 */       return this.feed_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFeed_timestamp(long _v_)
/*     */     {
/* 922 */       this.feed_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (!this.feed_cat_records.equals(_o_.feed_cat_records)) return false;
/* 931 */       if (this.feed_timestamp != _o_.feed_timestamp) return false;
/* 932 */       if (!this.feed_records.equals(_o_.feed_records)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.feed_cat_records.hashCode();
/* 941 */       _h_ = (int)(_h_ + this.feed_timestamp);
/* 942 */       _h_ += this.feed_records.hashCode();
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.feed_cat_records);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.feed_timestamp);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.feed_records);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FeedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */