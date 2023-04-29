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
/*     */ public final class MassWeddingRobSubscribeRoles extends xdb.XBean implements xbean.MassWeddingRobSubscribeRoles
/*     */ {
/*     */   private SetX<Long> roleids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.roleids.clear();
/*     */   }
/*     */   
/*     */   MassWeddingRobSubscribeRoles(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.roleids = new SetX();
/*     */   }
/*     */   
/*     */   public MassWeddingRobSubscribeRoles()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MassWeddingRobSubscribeRoles(MassWeddingRobSubscribeRoles _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MassWeddingRobSubscribeRoles(xbean.MassWeddingRobSubscribeRoles _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof MassWeddingRobSubscribeRoles)) { assign((MassWeddingRobSubscribeRoles)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MassWeddingRobSubscribeRoles _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.roleids = new SetX();
/*  50 */     this.roleids.addAll(_o_.roleids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.roleids = new SetX();
/*  56 */     this.roleids.addAll(_o_.roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.roleids.size());
/*  64 */     for (Long _v_ : this.roleids)
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
/*  79 */       this.roleids.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (Long _v_ : this.roleids)
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
/* 102 */       for (Long _v_ : this.roleids)
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
/* 135 */           this.roleids.add(Long.valueOf(_v_));
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
/*     */   public xbean.MassWeddingRobSubscribeRoles copy()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new MassWeddingRobSubscribeRoles(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRobSubscribeRoles toData()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRobSubscribeRoles toBean()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new MassWeddingRobSubscribeRoles(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRobSubscribeRoles toDataIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRobSubscribeRoles toBeanIf()
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
/*     */   public Set<Long> getRoleids()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return xdb.Logs.logSet(new xdb.LogKey(this, "roleids"), this.roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getRoleidsAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     MassWeddingRobSubscribeRoles _o_ = this;
/* 214 */     Set<Long> roleids = new SetX();
/* 215 */     roleids.addAll(_o_.roleids);
/* 216 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     MassWeddingRobSubscribeRoles _o_ = null;
/* 224 */     if ((_o1_ instanceof MassWeddingRobSubscribeRoles)) { _o_ = (MassWeddingRobSubscribeRoles)_o1_;
/* 225 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 226 */       return false;
/* 227 */     if (!this.roleids.equals(_o_.roleids)) return false;
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     int _h_ = 0;
/* 236 */     _h_ += this.roleids.hashCode();
/* 237 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.roleids);
/* 247 */     _sb_.append(")");
/* 248 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 254 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 255 */     lb.add(new xdb.logs.ListenableSet().setVarName("roleids"));
/* 256 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MassWeddingRobSubscribeRoles {
/*     */     private Const() {}
/*     */     
/*     */     MassWeddingRobSubscribeRoles nThis() {
/* 263 */       return MassWeddingRobSubscribeRoles.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobSubscribeRoles copy()
/*     */     {
/* 275 */       return MassWeddingRobSubscribeRoles.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobSubscribeRoles toData()
/*     */     {
/* 281 */       return MassWeddingRobSubscribeRoles.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobSubscribeRoles toBean()
/*     */     {
/* 286 */       return MassWeddingRobSubscribeRoles.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobSubscribeRoles toDataIf()
/*     */     {
/* 292 */       return MassWeddingRobSubscribeRoles.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobSubscribeRoles toBeanIf()
/*     */     {
/* 297 */       return MassWeddingRobSubscribeRoles.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoleids()
/*     */     {
/* 304 */       MassWeddingRobSubscribeRoles.this._xdb_verify_unsafe_();
/* 305 */       return xdb.Consts.constSet(MassWeddingRobSubscribeRoles.this.roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getRoleidsAsData()
/*     */     {
/* 311 */       MassWeddingRobSubscribeRoles.this._xdb_verify_unsafe_();
/*     */       
/* 313 */       MassWeddingRobSubscribeRoles _o_ = MassWeddingRobSubscribeRoles.this;
/* 314 */       Set<Long> roleids = new SetX();
/* 315 */       roleids.addAll(_o_.roleids);
/* 316 */       return roleids;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 322 */       MassWeddingRobSubscribeRoles.this._xdb_verify_unsafe_();
/* 323 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 329 */       MassWeddingRobSubscribeRoles.this._xdb_verify_unsafe_();
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 336 */       return MassWeddingRobSubscribeRoles.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 342 */       return MassWeddingRobSubscribeRoles.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 348 */       MassWeddingRobSubscribeRoles.this._xdb_verify_unsafe_();
/* 349 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 355 */       return MassWeddingRobSubscribeRoles.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 361 */       return MassWeddingRobSubscribeRoles.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 367 */       MassWeddingRobSubscribeRoles.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 374 */       return MassWeddingRobSubscribeRoles.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 380 */       return MassWeddingRobSubscribeRoles.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 386 */       return MassWeddingRobSubscribeRoles.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 392 */       return MassWeddingRobSubscribeRoles.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 398 */       return MassWeddingRobSubscribeRoles.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 404 */       return MassWeddingRobSubscribeRoles.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 410 */       return MassWeddingRobSubscribeRoles.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MassWeddingRobSubscribeRoles
/*     */   {
/*     */     private HashSet<Long> roleids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 427 */       this.roleids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.MassWeddingRobSubscribeRoles _o1_)
/*     */     {
/* 432 */       if ((_o1_ instanceof MassWeddingRobSubscribeRoles)) { assign((MassWeddingRobSubscribeRoles)_o1_);
/* 433 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 434 */       } else if ((_o1_ instanceof MassWeddingRobSubscribeRoles.Const)) assign(((MassWeddingRobSubscribeRoles.Const)_o1_).nThis()); else {
/* 435 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MassWeddingRobSubscribeRoles _o_) {
/* 440 */       this.roleids = new HashSet();
/* 441 */       this.roleids.addAll(_o_.roleids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 446 */       this.roleids = new HashSet();
/* 447 */       this.roleids.addAll(_o_.roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 453 */       _os_.compact_uint32(this.roleids.size());
/* 454 */       for (Long _v_ : this.roleids)
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
/* 468 */         this.roleids.add(Long.valueOf(_v_));
/*     */       }
/* 470 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 476 */       int _size_ = 0;
/* 477 */       for (Long _v_ : this.roleids)
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
/* 489 */         for (Long _v_ : this.roleids)
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
/* 521 */             this.roleids.add(Long.valueOf(_v_));
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
/*     */     public xbean.MassWeddingRobSubscribeRoles copy()
/*     */     {
/* 549 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobSubscribeRoles toData()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobSubscribeRoles toBean()
/*     */     {
/* 560 */       return new MassWeddingRobSubscribeRoles(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobSubscribeRoles toDataIf()
/*     */     {
/* 566 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobSubscribeRoles toBeanIf()
/*     */     {
/* 571 */       return new MassWeddingRobSubscribeRoles(this, null, null);
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
/*     */     public Set<Long> getRoleids()
/*     */     {
/* 608 */       return this.roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRoleidsAsData()
/*     */     {
/* 615 */       return this.roleids;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 621 */       if (!(_o1_ instanceof Data)) return false;
/* 622 */       Data _o_ = (Data)_o1_;
/* 623 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 624 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 630 */       int _h_ = 0;
/* 631 */       _h_ += this.roleids.hashCode();
/* 632 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       StringBuilder _sb_ = new StringBuilder();
/* 639 */       _sb_.append("(");
/* 640 */       _sb_.append(this.roleids);
/* 641 */       _sb_.append(")");
/* 642 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassWeddingRobSubscribeRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */