/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class IdipNTimesAwardInfo extends XBean implements xbean.IdipNTimesAwardInfo
/*     */ {
/*     */   private long start_time;
/*     */   private long expire_time;
/*     */   private int n_times;
/*     */   private SetX<Integer> valid_zone_id_set;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.start_time = 0L;
/*  25 */     this.expire_time = 0L;
/*  26 */     this.n_times = 0;
/*  27 */     this.valid_zone_id_set.clear();
/*     */   }
/*     */   
/*     */   IdipNTimesAwardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.valid_zone_id_set = new SetX();
/*     */   }
/*     */   
/*     */   public IdipNTimesAwardInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public IdipNTimesAwardInfo(IdipNTimesAwardInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   IdipNTimesAwardInfo(xbean.IdipNTimesAwardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof IdipNTimesAwardInfo)) { assign((IdipNTimesAwardInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(IdipNTimesAwardInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.start_time = _o_.start_time;
/*  59 */     this.expire_time = _o_.expire_time;
/*  60 */     this.n_times = _o_.n_times;
/*  61 */     this.valid_zone_id_set = new SetX();
/*  62 */     this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.start_time = _o_.start_time;
/*  68 */     this.expire_time = _o_.expire_time;
/*  69 */     this.n_times = _o_.n_times;
/*  70 */     this.valid_zone_id_set = new SetX();
/*  71 */     this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.marshal(this.start_time);
/*  79 */     _os_.marshal(this.expire_time);
/*  80 */     _os_.marshal(this.n_times);
/*  81 */     _os_.compact_uint32(this.valid_zone_id_set.size());
/*  82 */     for (Integer _v_ : this.valid_zone_id_set)
/*     */     {
/*  84 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     this.start_time = _os_.unmarshal_long();
/*  94 */     this.expire_time = _os_.unmarshal_long();
/*  95 */     this.n_times = _os_.unmarshal_int();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       int _v_ = 0;
/*  99 */       _v_ = _os_.unmarshal_int();
/* 100 */       this.valid_zone_id_set.add(Integer.valueOf(_v_));
/*     */     }
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt64Size(1, this.start_time);
/* 111 */     _size_ += CodedOutputStream.computeInt64Size(2, this.expire_time);
/* 112 */     _size_ += CodedOutputStream.computeInt32Size(3, this.n_times);
/* 113 */     for (Integer _v_ : this.valid_zone_id_set)
/*     */     {
/* 115 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*     */     }
/* 117 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 126 */       _output_.writeInt64(1, this.start_time);
/* 127 */       _output_.writeInt64(2, this.expire_time);
/* 128 */       _output_.writeInt32(3, this.n_times);
/* 129 */       for (Integer _v_ : this.valid_zone_id_set)
/*     */       {
/* 131 */         _output_.writeInt32(4, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       boolean done = false;
/* 148 */       while (!done)
/*     */       {
/* 150 */         int tag = _input_.readTag();
/* 151 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 155 */           done = true;
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 160 */           this.start_time = _input_.readInt64();
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 165 */           this.expire_time = _input_.readInt64();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 170 */           this.n_times = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 175 */           int _v_ = 0;
/* 176 */           _v_ = _input_.readInt32();
/* 177 */           this.valid_zone_id_set.add(Integer.valueOf(_v_));
/* 178 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 182 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 184 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 193 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 197 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 199 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IdipNTimesAwardInfo copy()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new IdipNTimesAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IdipNTimesAwardInfo toData()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IdipNTimesAwardInfo toBean()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new IdipNTimesAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IdipNTimesAwardInfo toDataIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IdipNTimesAwardInfo toBeanIf()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStart_time()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.start_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getExpire_time()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.expire_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getN_times()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return this.n_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getValid_zone_id_set()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     return xdb.Logs.logSet(new LogKey(this, "valid_zone_id_set"), this.valid_zone_id_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getValid_zone_id_setAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     IdipNTimesAwardInfo _o_ = this;
/* 280 */     Set<Integer> valid_zone_id_set = new SetX();
/* 281 */     valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/* 282 */     return valid_zone_id_set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStart_time(long _v_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     xdb.Logs.logIf(new LogKey(this, "start_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 294 */         new xdb.logs.LogLong(this, IdipNTimesAwardInfo.this.start_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 298 */             IdipNTimesAwardInfo.this.start_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 302 */     });
/* 303 */     this.start_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpire_time(long _v_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     xdb.Logs.logIf(new LogKey(this, "expire_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 315 */         new xdb.logs.LogLong(this, IdipNTimesAwardInfo.this.expire_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 319 */             IdipNTimesAwardInfo.this.expire_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 323 */     });
/* 324 */     this.expire_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setN_times(int _v_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     xdb.Logs.logIf(new LogKey(this, "n_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 336 */         new xdb.logs.LogInt(this, IdipNTimesAwardInfo.this.n_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 340 */             IdipNTimesAwardInfo.this.n_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 344 */     });
/* 345 */     this.n_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     IdipNTimesAwardInfo _o_ = null;
/* 353 */     if ((_o1_ instanceof IdipNTimesAwardInfo)) { _o_ = (IdipNTimesAwardInfo)_o1_;
/* 354 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 355 */       return false;
/* 356 */     if (this.start_time != _o_.start_time) return false;
/* 357 */     if (this.expire_time != _o_.expire_time) return false;
/* 358 */     if (this.n_times != _o_.n_times) return false;
/* 359 */     if (!this.valid_zone_id_set.equals(_o_.valid_zone_id_set)) return false;
/* 360 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     int _h_ = 0;
/* 368 */     _h_ = (int)(_h_ + this.start_time);
/* 369 */     _h_ = (int)(_h_ + this.expire_time);
/* 370 */     _h_ += this.n_times;
/* 371 */     _h_ += this.valid_zone_id_set.hashCode();
/* 372 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     StringBuilder _sb_ = new StringBuilder();
/* 380 */     _sb_.append("(");
/* 381 */     _sb_.append(this.start_time);
/* 382 */     _sb_.append(",");
/* 383 */     _sb_.append(this.expire_time);
/* 384 */     _sb_.append(",");
/* 385 */     _sb_.append(this.n_times);
/* 386 */     _sb_.append(",");
/* 387 */     _sb_.append(this.valid_zone_id_set);
/* 388 */     _sb_.append(")");
/* 389 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 395 */     ListenableBean lb = new ListenableBean();
/* 396 */     lb.add(new xdb.logs.ListenableChanged().setVarName("start_time"));
/* 397 */     lb.add(new xdb.logs.ListenableChanged().setVarName("expire_time"));
/* 398 */     lb.add(new xdb.logs.ListenableChanged().setVarName("n_times"));
/* 399 */     lb.add(new xdb.logs.ListenableSet().setVarName("valid_zone_id_set"));
/* 400 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.IdipNTimesAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     IdipNTimesAwardInfo nThis() {
/* 407 */       return IdipNTimesAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdipNTimesAwardInfo copy()
/*     */     {
/* 419 */       return IdipNTimesAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdipNTimesAwardInfo toData()
/*     */     {
/* 425 */       return IdipNTimesAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.IdipNTimesAwardInfo toBean()
/*     */     {
/* 430 */       return IdipNTimesAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdipNTimesAwardInfo toDataIf()
/*     */     {
/* 436 */       return IdipNTimesAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.IdipNTimesAwardInfo toBeanIf()
/*     */     {
/* 441 */       return IdipNTimesAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 448 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 449 */       return IdipNTimesAwardInfo.this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpire_time()
/*     */     {
/* 456 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 457 */       return IdipNTimesAwardInfo.this.expire_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getN_times()
/*     */     {
/* 464 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 465 */       return IdipNTimesAwardInfo.this.n_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_set()
/*     */     {
/* 472 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 473 */       return xdb.Consts.constSet(IdipNTimesAwardInfo.this.valid_zone_id_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_setAsData()
/*     */     {
/* 479 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/*     */       
/* 481 */       IdipNTimesAwardInfo _o_ = IdipNTimesAwardInfo.this;
/* 482 */       Set<Integer> valid_zone_id_set = new SetX();
/* 483 */       valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/* 484 */       return valid_zone_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 491 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire_time(long _v_)
/*     */     {
/* 499 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setN_times(int _v_)
/*     */     {
/* 507 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 514 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 515 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 521 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 522 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 528 */       return IdipNTimesAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 534 */       return IdipNTimesAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 540 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 547 */       return IdipNTimesAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 553 */       return IdipNTimesAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 559 */       IdipNTimesAwardInfo.this._xdb_verify_unsafe_();
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 566 */       return IdipNTimesAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 572 */       return IdipNTimesAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 578 */       return IdipNTimesAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 584 */       return IdipNTimesAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 590 */       return IdipNTimesAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 596 */       return IdipNTimesAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 602 */       return IdipNTimesAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.IdipNTimesAwardInfo
/*     */   {
/*     */     private long start_time;
/*     */     
/*     */     private long expire_time;
/*     */     
/*     */     private int n_times;
/*     */     
/*     */     private HashSet<Integer> valid_zone_id_set;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 620 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 625 */       this.valid_zone_id_set = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.IdipNTimesAwardInfo _o1_)
/*     */     {
/* 630 */       if ((_o1_ instanceof IdipNTimesAwardInfo)) { assign((IdipNTimesAwardInfo)_o1_);
/* 631 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 632 */       } else if ((_o1_ instanceof IdipNTimesAwardInfo.Const)) assign(((IdipNTimesAwardInfo.Const)_o1_).nThis()); else {
/* 633 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(IdipNTimesAwardInfo _o_) {
/* 638 */       this.start_time = _o_.start_time;
/* 639 */       this.expire_time = _o_.expire_time;
/* 640 */       this.n_times = _o_.n_times;
/* 641 */       this.valid_zone_id_set = new HashSet();
/* 642 */       this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 647 */       this.start_time = _o_.start_time;
/* 648 */       this.expire_time = _o_.expire_time;
/* 649 */       this.n_times = _o_.n_times;
/* 650 */       this.valid_zone_id_set = new HashSet();
/* 651 */       this.valid_zone_id_set.addAll(_o_.valid_zone_id_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 657 */       _os_.marshal(this.start_time);
/* 658 */       _os_.marshal(this.expire_time);
/* 659 */       _os_.marshal(this.n_times);
/* 660 */       _os_.compact_uint32(this.valid_zone_id_set.size());
/* 661 */       for (Integer _v_ : this.valid_zone_id_set)
/*     */       {
/* 663 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 665 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 671 */       this.start_time = _os_.unmarshal_long();
/* 672 */       this.expire_time = _os_.unmarshal_long();
/* 673 */       this.n_times = _os_.unmarshal_int();
/* 674 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 676 */         int _v_ = 0;
/* 677 */         _v_ = _os_.unmarshal_int();
/* 678 */         this.valid_zone_id_set.add(Integer.valueOf(_v_));
/*     */       }
/* 680 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 686 */       int _size_ = 0;
/* 687 */       _size_ += CodedOutputStream.computeInt64Size(1, this.start_time);
/* 688 */       _size_ += CodedOutputStream.computeInt64Size(2, this.expire_time);
/* 689 */       _size_ += CodedOutputStream.computeInt32Size(3, this.n_times);
/* 690 */       for (Integer _v_ : this.valid_zone_id_set)
/*     */       {
/* 692 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*     */       }
/* 694 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 702 */         _output_.writeInt64(1, this.start_time);
/* 703 */         _output_.writeInt64(2, this.expire_time);
/* 704 */         _output_.writeInt32(3, this.n_times);
/* 705 */         for (Integer _v_ : this.valid_zone_id_set)
/*     */         {
/* 707 */           _output_.writeInt32(4, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 722 */         boolean done = false;
/* 723 */         while (!done)
/*     */         {
/* 725 */           int tag = _input_.readTag();
/* 726 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 730 */             done = true;
/* 731 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 735 */             this.start_time = _input_.readInt64();
/* 736 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 740 */             this.expire_time = _input_.readInt64();
/* 741 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 745 */             this.n_times = _input_.readInt32();
/* 746 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 750 */             int _v_ = 0;
/* 751 */             _v_ = _input_.readInt32();
/* 752 */             this.valid_zone_id_set.add(Integer.valueOf(_v_));
/* 753 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 757 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 759 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 768 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 772 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 774 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdipNTimesAwardInfo copy()
/*     */     {
/* 780 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdipNTimesAwardInfo toData()
/*     */     {
/* 786 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.IdipNTimesAwardInfo toBean()
/*     */     {
/* 791 */       return new IdipNTimesAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdipNTimesAwardInfo toDataIf()
/*     */     {
/* 797 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.IdipNTimesAwardInfo toBeanIf()
/*     */     {
/* 802 */       return new IdipNTimesAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 808 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 812 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 816 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 820 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 828 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 832 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 839 */       return this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpire_time()
/*     */     {
/* 846 */       return this.expire_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getN_times()
/*     */     {
/* 853 */       return this.n_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_set()
/*     */     {
/* 860 */       return this.valid_zone_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getValid_zone_id_setAsData()
/*     */     {
/* 867 */       return this.valid_zone_id_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 874 */       this.start_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire_time(long _v_)
/*     */     {
/* 881 */       this.expire_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setN_times(int _v_)
/*     */     {
/* 888 */       this.n_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 894 */       if (!(_o1_ instanceof Data)) return false;
/* 895 */       Data _o_ = (Data)_o1_;
/* 896 */       if (this.start_time != _o_.start_time) return false;
/* 897 */       if (this.expire_time != _o_.expire_time) return false;
/* 898 */       if (this.n_times != _o_.n_times) return false;
/* 899 */       if (!this.valid_zone_id_set.equals(_o_.valid_zone_id_set)) return false;
/* 900 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 906 */       int _h_ = 0;
/* 907 */       _h_ = (int)(_h_ + this.start_time);
/* 908 */       _h_ = (int)(_h_ + this.expire_time);
/* 909 */       _h_ += this.n_times;
/* 910 */       _h_ += this.valid_zone_id_set.hashCode();
/* 911 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 917 */       StringBuilder _sb_ = new StringBuilder();
/* 918 */       _sb_.append("(");
/* 919 */       _sb_.append(this.start_time);
/* 920 */       _sb_.append(",");
/* 921 */       _sb_.append(this.expire_time);
/* 922 */       _sb_.append(",");
/* 923 */       _sb_.append(this.n_times);
/* 924 */       _sb_.append(",");
/* 925 */       _sb_.append(this.valid_zone_id_set);
/* 926 */       _sb_.append(")");
/* 927 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IdipNTimesAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */