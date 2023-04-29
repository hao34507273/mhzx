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
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class CrossLadderRankBackup extends XBean implements xbean.CrossLadderRankBackup
/*     */ {
/*     */   private HashMap<Long, xbean.CrossLadderSeasonRankBackup> backups;
/*     */   private long init_season_begin_timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.backups.clear();
/*  21 */     this.init_season_begin_timestamp = -1L;
/*     */   }
/*     */   
/*     */   CrossLadderRankBackup(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.backups = new HashMap();
/*  28 */     this.init_season_begin_timestamp = -1L;
/*     */   }
/*     */   
/*     */   public CrossLadderRankBackup()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossLadderRankBackup(CrossLadderRankBackup _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossLadderRankBackup(xbean.CrossLadderRankBackup _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CrossLadderRankBackup)) { assign((CrossLadderRankBackup)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossLadderRankBackup _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.backups = new HashMap();
/*  54 */     for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : _o_.backups.entrySet())
/*  55 */       this.backups.put(_e_.getKey(), new CrossLadderSeasonRankBackup((xbean.CrossLadderSeasonRankBackup)_e_.getValue(), this, "backups"));
/*  56 */     this.init_season_begin_timestamp = _o_.init_season_begin_timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.backups = new HashMap();
/*  62 */     for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : _o_.backups.entrySet())
/*  63 */       this.backups.put(_e_.getKey(), new CrossLadderSeasonRankBackup((xbean.CrossLadderSeasonRankBackup)_e_.getValue(), this, "backups"));
/*  64 */     this.init_season_begin_timestamp = _o_.init_season_begin_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.backups.size());
/*  72 */     for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : this.backups.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       ((xbean.CrossLadderSeasonRankBackup)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     _os_.marshal(this.init_season_begin_timestamp);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.backups = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       long _k_ = 0L;
/*  94 */       _k_ = _os_.unmarshal_long();
/*  95 */       xbean.CrossLadderSeasonRankBackup _v_ = new CrossLadderSeasonRankBackup(0, this, "backups");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.backups.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     this.init_season_begin_timestamp = _os_.unmarshal_long();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : this.backups.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt64Size(2, this.init_season_begin_timestamp);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : this.backups.entrySet())
/*     */       {
/* 126 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 127 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 129 */       _output_.writeInt64(2, this.init_season_begin_timestamp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           long _k_ = 0L;
/* 158 */           _k_ = _input_.readInt64();
/* 159 */           int readTag = _input_.readTag();
/* 160 */           if (10 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           xbean.CrossLadderSeasonRankBackup _v_ = new CrossLadderSeasonRankBackup(0, this, "backups");
/* 165 */           _input_.readMessage(_v_);
/* 166 */           this.backups.put(Long.valueOf(_k_), _v_);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.init_season_begin_timestamp = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRankBackup copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new CrossLadderRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRankBackup toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderRankBackup toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new CrossLadderRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderRankBackup toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderRankBackup toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.CrossLadderSeasonRankBackup> getBackups()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "backups"), this.backups);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.CrossLadderSeasonRankBackup> getBackupsAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     CrossLadderRankBackup _o_ = this;
/* 251 */     Map<Long, xbean.CrossLadderSeasonRankBackup> backups = new HashMap();
/* 252 */     for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : _o_.backups.entrySet())
/* 253 */       backups.put(_e_.getKey(), new CrossLadderSeasonRankBackup.Data((xbean.CrossLadderSeasonRankBackup)_e_.getValue()));
/* 254 */     return backups;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getInit_season_begin_timestamp()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.init_season_begin_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInit_season_begin_timestamp(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "init_season_begin_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, CrossLadderRankBackup.this.init_season_begin_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             CrossLadderRankBackup.this.init_season_begin_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.init_season_begin_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     CrossLadderRankBackup _o_ = null;
/* 291 */     if ((_o1_ instanceof CrossLadderRankBackup)) { _o_ = (CrossLadderRankBackup)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.backups.equals(_o_.backups)) return false;
/* 295 */     if (this.init_season_begin_timestamp != _o_.init_season_begin_timestamp) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.backups.hashCode();
/* 305 */     _h_ = (int)(_h_ + this.init_season_begin_timestamp);
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.backups);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.init_season_begin_timestamp);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("backups"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("init_season_begin_timestamp"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossLadderRankBackup {
/*     */     private Const() {}
/*     */     
/*     */     CrossLadderRankBackup nThis() {
/* 335 */       return CrossLadderRankBackup.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankBackup copy()
/*     */     {
/* 347 */       return CrossLadderRankBackup.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankBackup toData()
/*     */     {
/* 353 */       return CrossLadderRankBackup.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankBackup toBean()
/*     */     {
/* 358 */       return CrossLadderRankBackup.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankBackup toDataIf()
/*     */     {
/* 364 */       return CrossLadderRankBackup.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankBackup toBeanIf()
/*     */     {
/* 369 */       return CrossLadderRankBackup.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CrossLadderSeasonRankBackup> getBackups()
/*     */     {
/* 376 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(CrossLadderRankBackup.this.backups);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CrossLadderSeasonRankBackup> getBackupsAsData()
/*     */     {
/* 384 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       CrossLadderRankBackup _o_ = CrossLadderRankBackup.this;
/* 387 */       Map<Long, xbean.CrossLadderSeasonRankBackup> backups = new HashMap();
/* 388 */       for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : _o_.backups.entrySet())
/* 389 */         backups.put(_e_.getKey(), new CrossLadderSeasonRankBackup.Data((xbean.CrossLadderSeasonRankBackup)_e_.getValue()));
/* 390 */       return backups;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInit_season_begin_timestamp()
/*     */     {
/* 397 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 398 */       return CrossLadderRankBackup.this.init_season_begin_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInit_season_begin_timestamp(long _v_)
/*     */     {
/* 405 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return CrossLadderRankBackup.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return CrossLadderRankBackup.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return CrossLadderRankBackup.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return CrossLadderRankBackup.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       CrossLadderRankBackup.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return CrossLadderRankBackup.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return CrossLadderRankBackup.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return CrossLadderRankBackup.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return CrossLadderRankBackup.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return CrossLadderRankBackup.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return CrossLadderRankBackup.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return CrossLadderRankBackup.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossLadderRankBackup
/*     */   {
/*     */     private HashMap<Long, xbean.CrossLadderSeasonRankBackup> backups;
/*     */     
/*     */     private long init_season_begin_timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.backups = new HashMap();
/* 520 */       this.init_season_begin_timestamp = -1L;
/*     */     }
/*     */     
/*     */     Data(xbean.CrossLadderRankBackup _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof CrossLadderRankBackup)) { assign((CrossLadderRankBackup)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof CrossLadderRankBackup.Const)) assign(((CrossLadderRankBackup.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossLadderRankBackup _o_) {
/* 533 */       this.backups = new HashMap();
/* 534 */       for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : _o_.backups.entrySet())
/* 535 */         this.backups.put(_e_.getKey(), new CrossLadderSeasonRankBackup.Data((xbean.CrossLadderSeasonRankBackup)_e_.getValue()));
/* 536 */       this.init_season_begin_timestamp = _o_.init_season_begin_timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.backups = new HashMap();
/* 542 */       for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : _o_.backups.entrySet())
/* 543 */         this.backups.put(_e_.getKey(), new CrossLadderSeasonRankBackup.Data((xbean.CrossLadderSeasonRankBackup)_e_.getValue()));
/* 544 */       this.init_season_begin_timestamp = _o_.init_season_begin_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.backups.size());
/* 551 */       for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : this.backups.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 554 */         ((xbean.CrossLadderSeasonRankBackup)_e_.getValue()).marshal(_os_);
/*     */       }
/* 556 */       _os_.marshal(this.init_season_begin_timestamp);
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 564 */       int size = _os_.uncompact_uint32();
/* 565 */       if (size >= 12)
/*     */       {
/* 567 */         this.backups = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         long _k_ = 0L;
/* 572 */         _k_ = _os_.unmarshal_long();
/* 573 */         xbean.CrossLadderSeasonRankBackup _v_ = xbean.Pod.newCrossLadderSeasonRankBackupData();
/* 574 */         _v_.unmarshal(_os_);
/* 575 */         this.backups.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 578 */       this.init_season_begin_timestamp = _os_.unmarshal_long();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : this.backups.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 589 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeInt64Size(2, this.init_season_begin_timestamp);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Long, xbean.CrossLadderSeasonRankBackup> _e_ : this.backups.entrySet())
/*     */         {
/* 602 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 603 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 605 */         _output_.writeInt64(2, this.init_season_begin_timestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             long _k_ = 0L;
/* 633 */             _k_ = _input_.readInt64();
/* 634 */             int readTag = _input_.readTag();
/* 635 */             if (10 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             xbean.CrossLadderSeasonRankBackup _v_ = xbean.Pod.newCrossLadderSeasonRankBackupData();
/* 640 */             _input_.readMessage(_v_);
/* 641 */             this.backups.put(Long.valueOf(_k_), _v_);
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.init_season_begin_timestamp = _input_.readInt64();
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankBackup copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankBackup toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankBackup toBean()
/*     */     {
/* 685 */       return new CrossLadderRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderRankBackup toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderRankBackup toBeanIf()
/*     */     {
/* 696 */       return new CrossLadderRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CrossLadderSeasonRankBackup> getBackups()
/*     */     {
/* 733 */       return this.backups;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CrossLadderSeasonRankBackup> getBackupsAsData()
/*     */     {
/* 740 */       return this.backups;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInit_season_begin_timestamp()
/*     */     {
/* 747 */       return this.init_season_begin_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInit_season_begin_timestamp(long _v_)
/*     */     {
/* 754 */       this.init_season_begin_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.backups.equals(_o_.backups)) return false;
/* 763 */       if (this.init_season_begin_timestamp != _o_.init_season_begin_timestamp) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.backups.hashCode();
/* 772 */       _h_ = (int)(_h_ + this.init_season_begin_timestamp);
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.backups);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.init_season_begin_timestamp);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossLadderRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */