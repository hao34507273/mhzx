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
/*     */ public final class SystemAwards extends XBean implements xbean.SystemAwards
/*     */ {
/*     */   private long sequence;
/*     */   private HashMap<Long, xbean.SystemAwardBean> awards;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.sequence = 0L;
/*  21 */     this.awards.clear();
/*     */   }
/*     */   
/*     */   SystemAwards(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.sequence = 0L;
/*  28 */     this.awards = new HashMap();
/*     */   }
/*     */   
/*     */   public SystemAwards()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SystemAwards(SystemAwards _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SystemAwards(xbean.SystemAwards _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof SystemAwards)) { assign((SystemAwards)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SystemAwards _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.sequence = _o_.sequence;
/*  54 */     this.awards = new HashMap();
/*  55 */     for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : _o_.awards.entrySet()) {
/*  56 */       this.awards.put(_e_.getKey(), new SystemAwardBean((xbean.SystemAwardBean)_e_.getValue(), this, "awards"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.sequence = _o_.sequence;
/*  62 */     this.awards = new HashMap();
/*  63 */     for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : _o_.awards.entrySet()) {
/*  64 */       this.awards.put(_e_.getKey(), new SystemAwardBean((xbean.SystemAwardBean)_e_.getValue(), this, "awards"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.sequence);
/*  72 */     _os_.compact_uint32(this.awards.size());
/*  73 */     for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : this.awards.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  76 */       ((xbean.SystemAwardBean)_e_.getValue()).marshal(_os_);
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.sequence = _os_.unmarshal_long();
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.awards = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       long _k_ = 0L;
/*  95 */       _k_ = _os_.unmarshal_long();
/*  96 */       xbean.SystemAwardBean _v_ = new SystemAwardBean(0, this, "awards");
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.awards.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(1, this.sequence);
/* 110 */     for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : this.awards.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 113 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt64(1, this.sequence);
/* 125 */       for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : this.awards.entrySet())
/*     */       {
/* 127 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 128 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
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
/* 157 */           this.sequence = _input_.readInt64();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           long _k_ = 0L;
/* 163 */           _k_ = _input_.readInt64();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (18 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           xbean.SystemAwardBean _v_ = new SystemAwardBean(0, this, "awards");
/* 170 */           _input_.readMessage(_v_);
/* 171 */           this.awards.put(Long.valueOf(_k_), _v_);
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
/*     */   public xbean.SystemAwards copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new SystemAwards(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SystemAwards toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SystemAwards toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new SystemAwards(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SystemAwards toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SystemAwards toBeanIf()
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
/*     */   public long getSequence()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.sequence;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.SystemAwardBean> getAwards()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "awards"), this.awards);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.SystemAwardBean> getAwardsAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     SystemAwards _o_ = this;
/* 259 */     Map<Long, xbean.SystemAwardBean> awards = new HashMap();
/* 260 */     for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : _o_.awards.entrySet())
/* 261 */       awards.put(_e_.getKey(), new SystemAwardBean.Data((xbean.SystemAwardBean)_e_.getValue()));
/* 262 */     return awards;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSequence(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "sequence")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, SystemAwards.this.sequence)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             SystemAwards.this.sequence = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.sequence = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     SystemAwards _o_ = null;
/* 291 */     if ((_o1_ instanceof SystemAwards)) { _o_ = (SystemAwards)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (this.sequence != _o_.sequence) return false;
/* 295 */     if (!this.awards.equals(_o_.awards)) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ = (int)(_h_ + this.sequence);
/* 305 */     _h_ += this.awards.hashCode();
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.sequence);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.awards);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sequence"));
/* 327 */     lb.add(new xdb.logs.ListenableMap().setVarName("awards"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SystemAwards {
/*     */     private Const() {}
/*     */     
/*     */     SystemAwards nThis() {
/* 335 */       return SystemAwards.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemAwards copy()
/*     */     {
/* 347 */       return SystemAwards.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemAwards toData()
/*     */     {
/* 353 */       return SystemAwards.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SystemAwards toBean()
/*     */     {
/* 358 */       return SystemAwards.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemAwards toDataIf()
/*     */     {
/* 364 */       return SystemAwards.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SystemAwards toBeanIf()
/*     */     {
/* 369 */       return SystemAwards.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSequence()
/*     */     {
/* 376 */       SystemAwards.this._xdb_verify_unsafe_();
/* 377 */       return SystemAwards.this.sequence;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.SystemAwardBean> getAwards()
/*     */     {
/* 384 */       SystemAwards.this._xdb_verify_unsafe_();
/* 385 */       return xdb.Consts.constMap(SystemAwards.this.awards);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.SystemAwardBean> getAwardsAsData()
/*     */     {
/* 392 */       SystemAwards.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       SystemAwards _o_ = SystemAwards.this;
/* 395 */       Map<Long, xbean.SystemAwardBean> awards = new HashMap();
/* 396 */       for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : _o_.awards.entrySet())
/* 397 */         awards.put(_e_.getKey(), new SystemAwardBean.Data((xbean.SystemAwardBean)_e_.getValue()));
/* 398 */       return awards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSequence(long _v_)
/*     */     {
/* 405 */       SystemAwards.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       SystemAwards.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       SystemAwards.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return SystemAwards.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return SystemAwards.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       SystemAwards.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return SystemAwards.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return SystemAwards.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       SystemAwards.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return SystemAwards.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return SystemAwards.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return SystemAwards.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return SystemAwards.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return SystemAwards.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return SystemAwards.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return SystemAwards.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SystemAwards
/*     */   {
/*     */     private long sequence;
/*     */     
/*     */     private HashMap<Long, xbean.SystemAwardBean> awards;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.sequence = 0L;
/* 520 */       this.awards = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.SystemAwards _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof SystemAwards)) { assign((SystemAwards)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof SystemAwards.Const)) assign(((SystemAwards.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SystemAwards _o_) {
/* 533 */       this.sequence = _o_.sequence;
/* 534 */       this.awards = new HashMap();
/* 535 */       for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : _o_.awards.entrySet()) {
/* 536 */         this.awards.put(_e_.getKey(), new SystemAwardBean.Data((xbean.SystemAwardBean)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 541 */       this.sequence = _o_.sequence;
/* 542 */       this.awards = new HashMap();
/* 543 */       for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : _o_.awards.entrySet()) {
/* 544 */         this.awards.put(_e_.getKey(), new SystemAwardBean.Data((xbean.SystemAwardBean)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.marshal(this.sequence);
/* 551 */       _os_.compact_uint32(this.awards.size());
/* 552 */       for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : this.awards.entrySet())
/*     */       {
/* 554 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 555 */         ((xbean.SystemAwardBean)_e_.getValue()).marshal(_os_);
/*     */       }
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       this.sequence = _os_.unmarshal_long();
/*     */       
/* 565 */       int size = _os_.uncompact_uint32();
/* 566 */       if (size >= 12)
/*     */       {
/* 568 */         this.awards = new HashMap(size * 2);
/*     */       }
/* 570 */       for (; size > 0; size--)
/*     */       {
/* 572 */         long _k_ = 0L;
/* 573 */         _k_ = _os_.unmarshal_long();
/* 574 */         xbean.SystemAwardBean _v_ = xbean.Pod.newSystemAwardBeanData();
/* 575 */         _v_.unmarshal(_os_);
/* 576 */         this.awards.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       _size_ += CodedOutputStream.computeInt64Size(1, this.sequence);
/* 587 */       for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : this.awards.entrySet())
/*     */       {
/* 589 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 590 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         _output_.writeInt64(1, this.sequence);
/* 601 */         for (Map.Entry<Long, xbean.SystemAwardBean> _e_ : this.awards.entrySet())
/*     */         {
/* 603 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 604 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
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
/* 632 */             this.sequence = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             long _k_ = 0L;
/* 638 */             _k_ = _input_.readInt64();
/* 639 */             int readTag = _input_.readTag();
/* 640 */             if (18 != readTag)
/*     */             {
/* 642 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 644 */             xbean.SystemAwardBean _v_ = xbean.Pod.newSystemAwardBeanData();
/* 645 */             _input_.readMessage(_v_);
/* 646 */             this.awards.put(Long.valueOf(_k_), _v_);
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
/*     */     public xbean.SystemAwards copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemAwards toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SystemAwards toBean()
/*     */     {
/* 685 */       return new SystemAwards(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemAwards toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SystemAwards toBeanIf()
/*     */     {
/* 696 */       return new SystemAwards(this, null, null);
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
/*     */     public long getSequence()
/*     */     {
/* 733 */       return this.sequence;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.SystemAwardBean> getAwards()
/*     */     {
/* 740 */       return this.awards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.SystemAwardBean> getAwardsAsData()
/*     */     {
/* 747 */       return this.awards;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSequence(long _v_)
/*     */     {
/* 754 */       this.sequence = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (this.sequence != _o_.sequence) return false;
/* 763 */       if (!this.awards.equals(_o_.awards)) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ = (int)(_h_ + this.sequence);
/* 772 */       _h_ += this.awards.hashCode();
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.sequence);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.awards);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SystemAwards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */