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
/*     */ public final class GiveYuanbaoCount extends XBean implements xbean.GiveYuanbaoCount
/*     */ {
/*     */   private HashMap<Long, Long> roleid2count;
/*     */   private long cleartime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.roleid2count.clear();
/*  21 */     this.cleartime = 0L;
/*     */   }
/*     */   
/*     */   GiveYuanbaoCount(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.roleid2count = new HashMap();
/*  28 */     this.cleartime = 0L;
/*     */   }
/*     */   
/*     */   public GiveYuanbaoCount()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GiveYuanbaoCount(GiveYuanbaoCount _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GiveYuanbaoCount(xbean.GiveYuanbaoCount _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof GiveYuanbaoCount)) { assign((GiveYuanbaoCount)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GiveYuanbaoCount _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.roleid2count = new HashMap();
/*  54 */     for (Map.Entry<Long, Long> _e_ : _o_.roleid2count.entrySet())
/*  55 */       this.roleid2count.put(_e_.getKey(), _e_.getValue());
/*  56 */     this.cleartime = _o_.cleartime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.roleid2count = new HashMap();
/*  62 */     for (Map.Entry<Long, Long> _e_ : _o_.roleid2count.entrySet())
/*  63 */       this.roleid2count.put(_e_.getKey(), _e_.getValue());
/*  64 */     this.cleartime = _o_.cleartime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.roleid2count.size());
/*  72 */     for (Map.Entry<Long, Long> _e_ : this.roleid2count.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  77 */     _os_.marshal(this.cleartime);
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
/*  89 */       this.roleid2count = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       long _k_ = 0L;
/*  94 */       _k_ = _os_.unmarshal_long();
/*  95 */       long _v_ = 0L;
/*  96 */       _v_ = _os_.unmarshal_long();
/*  97 */       this.roleid2count.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*     */     
/* 100 */     this.cleartime = _os_.unmarshal_long();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Long, Long> _e_ : this.roleid2count.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 112 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt64Size(2, this.cleartime);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Long, Long> _e_ : this.roleid2count.entrySet())
/*     */       {
/* 126 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 127 */         _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 129 */       _output_.writeInt64(2, this.cleartime);
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
/* 160 */           if (8 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           long _v_ = 0L;
/* 165 */           _v_ = _input_.readInt64();
/* 166 */           this.roleid2count.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.cleartime = _input_.readInt64();
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
/*     */   public xbean.GiveYuanbaoCount copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new GiveYuanbaoCount(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GiveYuanbaoCount toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GiveYuanbaoCount toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new GiveYuanbaoCount(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GiveYuanbaoCount toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GiveYuanbaoCount toBeanIf()
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
/*     */   public Map<Long, Long> getRoleid2count()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "roleid2count"), this.roleid2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, Long> getRoleid2countAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     GiveYuanbaoCount _o_ = this;
/* 251 */     Map<Long, Long> roleid2count = new HashMap();
/* 252 */     for (Map.Entry<Long, Long> _e_ : _o_.roleid2count.entrySet())
/* 253 */       roleid2count.put(_e_.getKey(), _e_.getValue());
/* 254 */     return roleid2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCleartime()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.cleartime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCleartime(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "cleartime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, GiveYuanbaoCount.this.cleartime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             GiveYuanbaoCount.this.cleartime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.cleartime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     GiveYuanbaoCount _o_ = null;
/* 291 */     if ((_o1_ instanceof GiveYuanbaoCount)) { _o_ = (GiveYuanbaoCount)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.roleid2count.equals(_o_.roleid2count)) return false;
/* 295 */     if (this.cleartime != _o_.cleartime) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.roleid2count.hashCode();
/* 305 */     _h_ = (int)(_h_ + this.cleartime);
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.roleid2count);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.cleartime);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleid2count"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("cleartime"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GiveYuanbaoCount {
/*     */     private Const() {}
/*     */     
/*     */     GiveYuanbaoCount nThis() {
/* 335 */       return GiveYuanbaoCount.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveYuanbaoCount copy()
/*     */     {
/* 347 */       return GiveYuanbaoCount.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveYuanbaoCount toData()
/*     */     {
/* 353 */       return GiveYuanbaoCount.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GiveYuanbaoCount toBean()
/*     */     {
/* 358 */       return GiveYuanbaoCount.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveYuanbaoCount toDataIf()
/*     */     {
/* 364 */       return GiveYuanbaoCount.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GiveYuanbaoCount toBeanIf()
/*     */     {
/* 369 */       return GiveYuanbaoCount.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleid2count()
/*     */     {
/* 376 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(GiveYuanbaoCount.this.roleid2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleid2countAsData()
/*     */     {
/* 384 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       GiveYuanbaoCount _o_ = GiveYuanbaoCount.this;
/* 387 */       Map<Long, Long> roleid2count = new HashMap();
/* 388 */       for (Map.Entry<Long, Long> _e_ : _o_.roleid2count.entrySet())
/* 389 */         roleid2count.put(_e_.getKey(), _e_.getValue());
/* 390 */       return roleid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleartime()
/*     */     {
/* 397 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 398 */       return GiveYuanbaoCount.this.cleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleartime(long _v_)
/*     */     {
/* 405 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return GiveYuanbaoCount.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return GiveYuanbaoCount.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return GiveYuanbaoCount.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return GiveYuanbaoCount.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       GiveYuanbaoCount.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return GiveYuanbaoCount.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return GiveYuanbaoCount.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return GiveYuanbaoCount.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return GiveYuanbaoCount.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return GiveYuanbaoCount.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return GiveYuanbaoCount.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return GiveYuanbaoCount.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GiveYuanbaoCount
/*     */   {
/*     */     private HashMap<Long, Long> roleid2count;
/*     */     
/*     */     private long cleartime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.roleid2count = new HashMap();
/* 520 */       this.cleartime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.GiveYuanbaoCount _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof GiveYuanbaoCount)) { assign((GiveYuanbaoCount)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof GiveYuanbaoCount.Const)) assign(((GiveYuanbaoCount.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GiveYuanbaoCount _o_) {
/* 533 */       this.roleid2count = new HashMap();
/* 534 */       for (Map.Entry<Long, Long> _e_ : _o_.roleid2count.entrySet())
/* 535 */         this.roleid2count.put(_e_.getKey(), _e_.getValue());
/* 536 */       this.cleartime = _o_.cleartime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.roleid2count = new HashMap();
/* 542 */       for (Map.Entry<Long, Long> _e_ : _o_.roleid2count.entrySet())
/* 543 */         this.roleid2count.put(_e_.getKey(), _e_.getValue());
/* 544 */       this.cleartime = _o_.cleartime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.roleid2count.size());
/* 551 */       for (Map.Entry<Long, Long> _e_ : this.roleid2count.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 554 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */       }
/* 556 */       _os_.marshal(this.cleartime);
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
/* 567 */         this.roleid2count = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         long _k_ = 0L;
/* 572 */         _k_ = _os_.unmarshal_long();
/* 573 */         long _v_ = 0L;
/* 574 */         _v_ = _os_.unmarshal_long();
/* 575 */         this.roleid2count.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */       }
/*     */       
/* 578 */       this.cleartime = _os_.unmarshal_long();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Long, Long> _e_ : this.roleid2count.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 589 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeInt64Size(2, this.cleartime);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Long, Long> _e_ : this.roleid2count.entrySet())
/*     */         {
/* 602 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 603 */           _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */         }
/* 605 */         _output_.writeInt64(2, this.cleartime);
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
/* 635 */             if (8 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             long _v_ = 0L;
/* 640 */             _v_ = _input_.readInt64();
/* 641 */             this.roleid2count.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.cleartime = _input_.readInt64();
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
/*     */     public xbean.GiveYuanbaoCount copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveYuanbaoCount toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GiveYuanbaoCount toBean()
/*     */     {
/* 685 */       return new GiveYuanbaoCount(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveYuanbaoCount toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GiveYuanbaoCount toBeanIf()
/*     */     {
/* 696 */       return new GiveYuanbaoCount(this, null, null);
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
/*     */     public Map<Long, Long> getRoleid2count()
/*     */     {
/* 733 */       return this.roleid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, Long> getRoleid2countAsData()
/*     */     {
/* 740 */       return this.roleid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleartime()
/*     */     {
/* 747 */       return this.cleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleartime(long _v_)
/*     */     {
/* 754 */       this.cleartime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.roleid2count.equals(_o_.roleid2count)) return false;
/* 763 */       if (this.cleartime != _o_.cleartime) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.roleid2count.hashCode();
/* 772 */       _h_ = (int)(_h_ + this.cleartime);
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.roleid2count);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.cleartime);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GiveYuanbaoCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */