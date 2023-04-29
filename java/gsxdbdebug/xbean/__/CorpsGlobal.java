/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class CorpsGlobal extends xdb.XBean implements xbean.CorpsGlobal
/*     */ {
/*     */   private SetX<Long> allcorpsids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.allcorpsids.clear();
/*     */   }
/*     */   
/*     */   CorpsGlobal(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.allcorpsids = new SetX();
/*     */   }
/*     */   
/*     */   public CorpsGlobal()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CorpsGlobal(CorpsGlobal _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CorpsGlobal(xbean.CorpsGlobal _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof CorpsGlobal)) { assign((CorpsGlobal)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CorpsGlobal _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.allcorpsids = new SetX();
/*  50 */     this.allcorpsids.addAll(_o_.allcorpsids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.allcorpsids = new SetX();
/*  56 */     this.allcorpsids.addAll(_o_.allcorpsids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.allcorpsids.size());
/*  64 */     for (Long _v_ : this.allcorpsids)
/*     */     {
/*  66 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       long _v_ = 0L;
/*  78 */       _v_ = _os_.unmarshal_long();
/*  79 */       this.allcorpsids.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (Long _v_ : this.allcorpsids)
/*     */     {
/*  91 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/*  93 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 102 */       for (Long _v_ : this.allcorpsids)
/*     */       {
/* 104 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           long _v_ = 0L;
/* 134 */           _v_ = _input_.readInt64();
/* 135 */           this.allcorpsids.add(Long.valueOf(_v_));
/* 136 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 140 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 142 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 151 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 157 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsGlobal copy()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new CorpsGlobal(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsGlobal toData()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CorpsGlobal toBean()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new CorpsGlobal(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsGlobal toDataIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CorpsGlobal toBeanIf()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getAllcorpsids()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return xdb.Logs.logSet(new xdb.LogKey(this, "allcorpsids"), this.allcorpsids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getAllcorpsidsAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     CorpsGlobal _o_ = this;
/* 214 */     Set<Long> allcorpsids = new SetX();
/* 215 */     allcorpsids.addAll(_o_.allcorpsids);
/* 216 */     return allcorpsids;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     CorpsGlobal _o_ = null;
/* 224 */     if ((_o1_ instanceof CorpsGlobal)) { _o_ = (CorpsGlobal)_o1_;
/* 225 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 226 */       return false;
/* 227 */     if (!this.allcorpsids.equals(_o_.allcorpsids)) return false;
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     int _h_ = 0;
/* 236 */     _h_ += this.allcorpsids.hashCode();
/* 237 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.allcorpsids);
/* 247 */     _sb_.append(")");
/* 248 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 254 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 255 */     lb.add(new xdb.logs.ListenableSet().setVarName("allcorpsids"));
/* 256 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CorpsGlobal {
/*     */     private Const() {}
/*     */     
/*     */     CorpsGlobal nThis() {
/* 263 */       return CorpsGlobal.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsGlobal copy()
/*     */     {
/* 275 */       return CorpsGlobal.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsGlobal toData()
/*     */     {
/* 281 */       return CorpsGlobal.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CorpsGlobal toBean()
/*     */     {
/* 286 */       return CorpsGlobal.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsGlobal toDataIf()
/*     */     {
/* 292 */       return CorpsGlobal.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CorpsGlobal toBeanIf()
/*     */     {
/* 297 */       return CorpsGlobal.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getAllcorpsids()
/*     */     {
/* 304 */       CorpsGlobal.this._xdb_verify_unsafe_();
/* 305 */       return xdb.Consts.constSet(CorpsGlobal.this.allcorpsids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getAllcorpsidsAsData()
/*     */     {
/* 311 */       CorpsGlobal.this._xdb_verify_unsafe_();
/*     */       
/* 313 */       CorpsGlobal _o_ = CorpsGlobal.this;
/* 314 */       Set<Long> allcorpsids = new SetX();
/* 315 */       allcorpsids.addAll(_o_.allcorpsids);
/* 316 */       return allcorpsids;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 322 */       CorpsGlobal.this._xdb_verify_unsafe_();
/* 323 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 329 */       CorpsGlobal.this._xdb_verify_unsafe_();
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 336 */       return CorpsGlobal.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 342 */       return CorpsGlobal.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 348 */       CorpsGlobal.this._xdb_verify_unsafe_();
/* 349 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 355 */       return CorpsGlobal.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 361 */       return CorpsGlobal.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 367 */       CorpsGlobal.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 374 */       return CorpsGlobal.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 380 */       return CorpsGlobal.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 386 */       return CorpsGlobal.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 392 */       return CorpsGlobal.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 398 */       return CorpsGlobal.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 404 */       return CorpsGlobal.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 410 */       return CorpsGlobal.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CorpsGlobal
/*     */   {
/*     */     private HashSet<Long> allcorpsids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 427 */       this.allcorpsids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.CorpsGlobal _o1_)
/*     */     {
/* 432 */       if ((_o1_ instanceof CorpsGlobal)) { assign((CorpsGlobal)_o1_);
/* 433 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 434 */       } else if ((_o1_ instanceof CorpsGlobal.Const)) assign(((CorpsGlobal.Const)_o1_).nThis()); else {
/* 435 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CorpsGlobal _o_) {
/* 440 */       this.allcorpsids = new HashSet();
/* 441 */       this.allcorpsids.addAll(_o_.allcorpsids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 446 */       this.allcorpsids = new HashSet();
/* 447 */       this.allcorpsids.addAll(_o_.allcorpsids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 453 */       _os_.compact_uint32(this.allcorpsids.size());
/* 454 */       for (Long _v_ : this.allcorpsids)
/*     */       {
/* 456 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 458 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 466 */         long _v_ = 0L;
/* 467 */         _v_ = _os_.unmarshal_long();
/* 468 */         this.allcorpsids.add(Long.valueOf(_v_));
/*     */       }
/* 470 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 476 */       int _size_ = 0;
/* 477 */       for (Long _v_ : this.allcorpsids)
/*     */       {
/* 479 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 481 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 489 */         for (Long _v_ : this.allcorpsids)
/*     */         {
/* 491 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 496 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 498 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 506 */         boolean done = false;
/* 507 */         while (!done)
/*     */         {
/* 509 */           int tag = _input_.readTag();
/* 510 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 514 */             done = true;
/* 515 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 519 */             long _v_ = 0L;
/* 520 */             _v_ = _input_.readInt64();
/* 521 */             this.allcorpsids.add(Long.valueOf(_v_));
/* 522 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 526 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 528 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 537 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsGlobal copy()
/*     */     {
/* 549 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsGlobal toData()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CorpsGlobal toBean()
/*     */     {
/* 560 */       return new CorpsGlobal(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsGlobal toDataIf()
/*     */     {
/* 566 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CorpsGlobal toBeanIf()
/*     */     {
/* 571 */       return new CorpsGlobal(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 577 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 593 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 597 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 601 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getAllcorpsids()
/*     */     {
/* 608 */       return this.allcorpsids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getAllcorpsidsAsData()
/*     */     {
/* 615 */       return this.allcorpsids;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 621 */       if (!(_o1_ instanceof Data)) return false;
/* 622 */       Data _o_ = (Data)_o1_;
/* 623 */       if (!this.allcorpsids.equals(_o_.allcorpsids)) return false;
/* 624 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 630 */       int _h_ = 0;
/* 631 */       _h_ += this.allcorpsids.hashCode();
/* 632 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       StringBuilder _sb_ = new StringBuilder();
/* 639 */       _sb_.append("(");
/* 640 */       _sb_.append(this.allcorpsids);
/* 641 */       _sb_.append(")");
/* 642 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CorpsGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */