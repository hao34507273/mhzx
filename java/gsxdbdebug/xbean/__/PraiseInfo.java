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
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class PraiseInfo extends XBean implements xbean.PraiseInfo
/*     */ {
/*     */   private int be_praised_num;
/*     */   private HashMap<Long, xbean.PraiseRecord> praise_records;
/*     */   private long praise_timestamp;
/*     */   private int praised_num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.be_praised_num = 0;
/*  25 */     this.praise_records.clear();
/*  26 */     this.praise_timestamp = 0L;
/*  27 */     this.praised_num = 0;
/*     */   }
/*     */   
/*     */   PraiseInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.praise_records = new HashMap();
/*     */   }
/*     */   
/*     */   public PraiseInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PraiseInfo(PraiseInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PraiseInfo(xbean.PraiseInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof PraiseInfo)) { assign((PraiseInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PraiseInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.be_praised_num = _o_.be_praised_num;
/*  59 */     this.praise_records = new HashMap();
/*  60 */     for (Map.Entry<Long, xbean.PraiseRecord> _e_ : _o_.praise_records.entrySet())
/*  61 */       this.praise_records.put(_e_.getKey(), new PraiseRecord((xbean.PraiseRecord)_e_.getValue(), this, "praise_records"));
/*  62 */     this.praise_timestamp = _o_.praise_timestamp;
/*  63 */     this.praised_num = _o_.praised_num;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  68 */     this.be_praised_num = _o_.be_praised_num;
/*  69 */     this.praise_records = new HashMap();
/*  70 */     for (Map.Entry<Long, xbean.PraiseRecord> _e_ : _o_.praise_records.entrySet())
/*  71 */       this.praise_records.put(_e_.getKey(), new PraiseRecord((xbean.PraiseRecord)_e_.getValue(), this, "praise_records"));
/*  72 */     this.praise_timestamp = _o_.praise_timestamp;
/*  73 */     this.praised_num = _o_.praised_num;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.be_praised_num);
/*  81 */     _os_.compact_uint32(this.praise_records.size());
/*  82 */     for (Map.Entry<Long, xbean.PraiseRecord> _e_ : this.praise_records.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  85 */       ((xbean.PraiseRecord)_e_.getValue()).marshal(_os_);
/*     */     }
/*  87 */     _os_.marshal(this.praise_timestamp);
/*  88 */     _os_.marshal(this.praised_num);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     this.be_praised_num = _os_.unmarshal_int();
/*     */     
/*  98 */     int size = _os_.uncompact_uint32();
/*  99 */     if (size >= 12)
/*     */     {
/* 101 */       this.praise_records = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       long _k_ = 0L;
/* 106 */       _k_ = _os_.unmarshal_long();
/* 107 */       xbean.PraiseRecord _v_ = new PraiseRecord(0, this, "praise_records");
/* 108 */       _v_.unmarshal(_os_);
/* 109 */       this.praise_records.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 112 */     this.praise_timestamp = _os_.unmarshal_long();
/* 113 */     this.praised_num = _os_.unmarshal_int();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     _size_ += CodedOutputStream.computeInt32Size(1, this.be_praised_num);
/* 123 */     for (Map.Entry<Long, xbean.PraiseRecord> _e_ : this.praise_records.entrySet())
/*     */     {
/* 125 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 126 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 128 */     _size_ += CodedOutputStream.computeInt64Size(3, this.praise_timestamp);
/* 129 */     _size_ += CodedOutputStream.computeInt32Size(4, this.praised_num);
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       _output_.writeInt32(1, this.be_praised_num);
/* 140 */       for (Map.Entry<Long, xbean.PraiseRecord> _e_ : this.praise_records.entrySet())
/*     */       {
/* 142 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 143 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 145 */       _output_.writeInt64(3, this.praise_timestamp);
/* 146 */       _output_.writeInt32(4, this.praised_num);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           this.be_praised_num = _input_.readInt32();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           long _k_ = 0L;
/* 180 */           _k_ = _input_.readInt64();
/* 181 */           int readTag = _input_.readTag();
/* 182 */           if (18 != readTag)
/*     */           {
/* 184 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 186 */           xbean.PraiseRecord _v_ = new PraiseRecord(0, this, "praise_records");
/* 187 */           _input_.readMessage(_v_);
/* 188 */           this.praise_records.put(Long.valueOf(_k_), _v_);
/* 189 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 193 */           this.praise_timestamp = _input_.readInt64();
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 198 */           this.praised_num = _input_.readInt32();
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PraiseInfo copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new PraiseInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PraiseInfo toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PraiseInfo toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new PraiseInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PraiseInfo toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PraiseInfo toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBe_praised_num()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return this.be_praised_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.PraiseRecord> getPraise_records()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return xdb.Logs.logMap(new LogKey(this, "praise_records"), this.praise_records);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.PraiseRecord> getPraise_recordsAsData()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/*     */     
/* 285 */     PraiseInfo _o_ = this;
/* 286 */     Map<Long, xbean.PraiseRecord> praise_records = new HashMap();
/* 287 */     for (Map.Entry<Long, xbean.PraiseRecord> _e_ : _o_.praise_records.entrySet())
/* 288 */       praise_records.put(_e_.getKey(), new PraiseRecord.Data((xbean.PraiseRecord)_e_.getValue()));
/* 289 */     return praise_records;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPraise_timestamp()
/*     */   {
/* 296 */     _xdb_verify_unsafe_();
/* 297 */     return this.praise_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPraised_num()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     return this.praised_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBe_praised_num(int _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "be_praised_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogInt(this, PraiseInfo.this.be_praised_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             PraiseInfo.this.be_praised_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.be_praised_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPraise_timestamp(long _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "praise_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogLong(this, PraiseInfo.this.praise_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             PraiseInfo.this.praise_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.praise_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPraised_num(int _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "praised_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogInt(this, PraiseInfo.this.praised_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             PraiseInfo.this.praised_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.praised_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     PraiseInfo _o_ = null;
/* 376 */     if ((_o1_ instanceof PraiseInfo)) { _o_ = (PraiseInfo)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (this.be_praised_num != _o_.be_praised_num) return false;
/* 380 */     if (!this.praise_records.equals(_o_.praise_records)) return false;
/* 381 */     if (this.praise_timestamp != _o_.praise_timestamp) return false;
/* 382 */     if (this.praised_num != _o_.praised_num) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ += this.be_praised_num;
/* 392 */     _h_ += this.praise_records.hashCode();
/* 393 */     _h_ = (int)(_h_ + this.praise_timestamp);
/* 394 */     _h_ += this.praised_num;
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.be_praised_num);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.praise_records);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.praise_timestamp);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.praised_num);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableChanged().setVarName("be_praised_num"));
/* 420 */     lb.add(new xdb.logs.ListenableMap().setVarName("praise_records"));
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("praise_timestamp"));
/* 422 */     lb.add(new xdb.logs.ListenableChanged().setVarName("praised_num"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PraiseInfo {
/*     */     private Const() {}
/*     */     
/*     */     PraiseInfo nThis() {
/* 430 */       return PraiseInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PraiseInfo copy()
/*     */     {
/* 442 */       return PraiseInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PraiseInfo toData()
/*     */     {
/* 448 */       return PraiseInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PraiseInfo toBean()
/*     */     {
/* 453 */       return PraiseInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PraiseInfo toDataIf()
/*     */     {
/* 459 */       return PraiseInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PraiseInfo toBeanIf()
/*     */     {
/* 464 */       return PraiseInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBe_praised_num()
/*     */     {
/* 471 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 472 */       return PraiseInfo.this.be_praised_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PraiseRecord> getPraise_records()
/*     */     {
/* 479 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 480 */       return xdb.Consts.constMap(PraiseInfo.this.praise_records);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PraiseRecord> getPraise_recordsAsData()
/*     */     {
/* 487 */       PraiseInfo.this._xdb_verify_unsafe_();
/*     */       
/* 489 */       PraiseInfo _o_ = PraiseInfo.this;
/* 490 */       Map<Long, xbean.PraiseRecord> praise_records = new HashMap();
/* 491 */       for (Map.Entry<Long, xbean.PraiseRecord> _e_ : _o_.praise_records.entrySet())
/* 492 */         praise_records.put(_e_.getKey(), new PraiseRecord.Data((xbean.PraiseRecord)_e_.getValue()));
/* 493 */       return praise_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPraise_timestamp()
/*     */     {
/* 500 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 501 */       return PraiseInfo.this.praise_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPraised_num()
/*     */     {
/* 508 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 509 */       return PraiseInfo.this.praised_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBe_praised_num(int _v_)
/*     */     {
/* 516 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPraise_timestamp(long _v_)
/*     */     {
/* 524 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPraised_num(int _v_)
/*     */     {
/* 532 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return PraiseInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return PraiseInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return PraiseInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return PraiseInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       PraiseInfo.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return PraiseInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return PraiseInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return PraiseInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return PraiseInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return PraiseInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return PraiseInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return PraiseInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PraiseInfo
/*     */   {
/*     */     private int be_praised_num;
/*     */     
/*     */     private HashMap<Long, xbean.PraiseRecord> praise_records;
/*     */     
/*     */     private long praise_timestamp;
/*     */     
/*     */     private int praised_num;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.praise_records = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PraiseInfo _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof PraiseInfo)) { assign((PraiseInfo)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof PraiseInfo.Const)) assign(((PraiseInfo.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PraiseInfo _o_) {
/* 663 */       this.be_praised_num = _o_.be_praised_num;
/* 664 */       this.praise_records = new HashMap();
/* 665 */       for (Map.Entry<Long, xbean.PraiseRecord> _e_ : _o_.praise_records.entrySet())
/* 666 */         this.praise_records.put(_e_.getKey(), new PraiseRecord.Data((xbean.PraiseRecord)_e_.getValue()));
/* 667 */       this.praise_timestamp = _o_.praise_timestamp;
/* 668 */       this.praised_num = _o_.praised_num;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 673 */       this.be_praised_num = _o_.be_praised_num;
/* 674 */       this.praise_records = new HashMap();
/* 675 */       for (Map.Entry<Long, xbean.PraiseRecord> _e_ : _o_.praise_records.entrySet())
/* 676 */         this.praise_records.put(_e_.getKey(), new PraiseRecord.Data((xbean.PraiseRecord)_e_.getValue()));
/* 677 */       this.praise_timestamp = _o_.praise_timestamp;
/* 678 */       this.praised_num = _o_.praised_num;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.be_praised_num);
/* 685 */       _os_.compact_uint32(this.praise_records.size());
/* 686 */       for (Map.Entry<Long, xbean.PraiseRecord> _e_ : this.praise_records.entrySet())
/*     */       {
/* 688 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 689 */         ((xbean.PraiseRecord)_e_.getValue()).marshal(_os_);
/*     */       }
/* 691 */       _os_.marshal(this.praise_timestamp);
/* 692 */       _os_.marshal(this.praised_num);
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 699 */       this.be_praised_num = _os_.unmarshal_int();
/*     */       
/* 701 */       int size = _os_.uncompact_uint32();
/* 702 */       if (size >= 12)
/*     */       {
/* 704 */         this.praise_records = new HashMap(size * 2);
/*     */       }
/* 706 */       for (; size > 0; size--)
/*     */       {
/* 708 */         long _k_ = 0L;
/* 709 */         _k_ = _os_.unmarshal_long();
/* 710 */         xbean.PraiseRecord _v_ = xbean.Pod.newPraiseRecordData();
/* 711 */         _v_.unmarshal(_os_);
/* 712 */         this.praise_records.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 715 */       this.praise_timestamp = _os_.unmarshal_long();
/* 716 */       this.praised_num = _os_.unmarshal_int();
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       _size_ += CodedOutputStream.computeInt32Size(1, this.be_praised_num);
/* 725 */       for (Map.Entry<Long, xbean.PraiseRecord> _e_ : this.praise_records.entrySet())
/*     */       {
/* 727 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 728 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 730 */       _size_ += CodedOutputStream.computeInt64Size(3, this.praise_timestamp);
/* 731 */       _size_ += CodedOutputStream.computeInt32Size(4, this.praised_num);
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         _output_.writeInt32(1, this.be_praised_num);
/* 741 */         for (Map.Entry<Long, xbean.PraiseRecord> _e_ : this.praise_records.entrySet())
/*     */         {
/* 743 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 744 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 746 */         _output_.writeInt64(3, this.praise_timestamp);
/* 747 */         _output_.writeInt32(4, this.praised_num);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 761 */         boolean done = false;
/* 762 */         while (!done)
/*     */         {
/* 764 */           int tag = _input_.readTag();
/* 765 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 769 */             done = true;
/* 770 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 774 */             this.be_praised_num = _input_.readInt32();
/* 775 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 779 */             long _k_ = 0L;
/* 780 */             _k_ = _input_.readInt64();
/* 781 */             int readTag = _input_.readTag();
/* 782 */             if (18 != readTag)
/*     */             {
/* 784 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 786 */             xbean.PraiseRecord _v_ = xbean.Pod.newPraiseRecordData();
/* 787 */             _input_.readMessage(_v_);
/* 788 */             this.praise_records.put(Long.valueOf(_k_), _v_);
/* 789 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 793 */             this.praise_timestamp = _input_.readInt64();
/* 794 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 798 */             this.praised_num = _input_.readInt32();
/* 799 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 803 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 805 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 814 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 818 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 820 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PraiseInfo copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PraiseInfo toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PraiseInfo toBean()
/*     */     {
/* 837 */       return new PraiseInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PraiseInfo toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PraiseInfo toBeanIf()
/*     */     {
/* 848 */       return new PraiseInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 874 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 878 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBe_praised_num()
/*     */     {
/* 885 */       return this.be_praised_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PraiseRecord> getPraise_records()
/*     */     {
/* 892 */       return this.praise_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.PraiseRecord> getPraise_recordsAsData()
/*     */     {
/* 899 */       return this.praise_records;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPraise_timestamp()
/*     */     {
/* 906 */       return this.praise_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPraised_num()
/*     */     {
/* 913 */       return this.praised_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBe_praised_num(int _v_)
/*     */     {
/* 920 */       this.be_praised_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPraise_timestamp(long _v_)
/*     */     {
/* 927 */       this.praise_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPraised_num(int _v_)
/*     */     {
/* 934 */       this.praised_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (this.be_praised_num != _o_.be_praised_num) return false;
/* 943 */       if (!this.praise_records.equals(_o_.praise_records)) return false;
/* 944 */       if (this.praise_timestamp != _o_.praise_timestamp) return false;
/* 945 */       if (this.praised_num != _o_.praised_num) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ += this.be_praised_num;
/* 954 */       _h_ += this.praise_records.hashCode();
/* 955 */       _h_ = (int)(_h_ + this.praise_timestamp);
/* 956 */       _h_ += this.praised_num;
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.be_praised_num);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.praise_records);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.praise_timestamp);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.praised_num);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PraiseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */