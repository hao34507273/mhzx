/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class MassWeddingRobRoles extends XBean implements xbean.MassWeddingRobRoles
/*     */ {
/*     */   private SetX<Long> grooms;
/*     */   private SetX<Long> brides;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.grooms.clear();
/*  21 */     this.brides.clear();
/*     */   }
/*     */   
/*     */   MassWeddingRobRoles(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.grooms = new SetX();
/*  28 */     this.brides = new SetX();
/*     */   }
/*     */   
/*     */   public MassWeddingRobRoles()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MassWeddingRobRoles(MassWeddingRobRoles _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MassWeddingRobRoles(xbean.MassWeddingRobRoles _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof MassWeddingRobRoles)) { assign((MassWeddingRobRoles)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MassWeddingRobRoles _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.grooms = new SetX();
/*  54 */     this.grooms.addAll(_o_.grooms);
/*  55 */     this.brides = new SetX();
/*  56 */     this.brides.addAll(_o_.brides);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.grooms = new SetX();
/*  62 */     this.grooms.addAll(_o_.grooms);
/*  63 */     this.brides = new SetX();
/*  64 */     this.brides.addAll(_o_.brides);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.grooms.size());
/*  72 */     for (Long _v_ : this.grooms)
/*     */     {
/*  74 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  76 */     _os_.compact_uint32(this.brides.size());
/*  77 */     for (Long _v_ : this.brides)
/*     */     {
/*  79 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       long _v_ = 0L;
/*  91 */       _v_ = _os_.unmarshal_long();
/*  92 */       this.grooms.add(Long.valueOf(_v_));
/*     */     }
/*  94 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  96 */       long _v_ = 0L;
/*  97 */       _v_ = _os_.unmarshal_long();
/*  98 */       this.brides.add(Long.valueOf(_v_));
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Long _v_ : this.grooms)
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 112 */     for (Long _v_ : this.brides)
/*     */     {
/* 114 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 116 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 125 */       for (Long _v_ : this.grooms)
/*     */       {
/* 127 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 129 */       for (Long _v_ : this.brides)
/*     */       {
/* 131 */         _output_.writeInt64(2, _v_.longValue());
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
/* 160 */           long _v_ = 0L;
/* 161 */           _v_ = _input_.readInt64();
/* 162 */           this.grooms.add(Long.valueOf(_v_));
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 167 */           long _v_ = 0L;
/* 168 */           _v_ = _input_.readInt64();
/* 169 */           this.brides.add(Long.valueOf(_v_));
/* 170 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 174 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 176 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 185 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 189 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 191 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRobRoles copy()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new MassWeddingRobRoles(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRobRoles toData()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRobRoles toBean()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new MassWeddingRobRoles(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRobRoles toDataIf()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRobRoles toBeanIf()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getGrooms()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return xdb.Logs.logSet(new xdb.LogKey(this, "grooms"), this.grooms);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getGroomsAsData()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/*     */     
/* 247 */     MassWeddingRobRoles _o_ = this;
/* 248 */     Set<Long> grooms = new SetX();
/* 249 */     grooms.addAll(_o_.grooms);
/* 250 */     return grooms;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getBrides()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     return xdb.Logs.logSet(new xdb.LogKey(this, "brides"), this.brides);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getBridesAsData()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/*     */     
/* 266 */     MassWeddingRobRoles _o_ = this;
/* 267 */     Set<Long> brides = new SetX();
/* 268 */     brides.addAll(_o_.brides);
/* 269 */     return brides;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     MassWeddingRobRoles _o_ = null;
/* 277 */     if ((_o1_ instanceof MassWeddingRobRoles)) { _o_ = (MassWeddingRobRoles)_o1_;
/* 278 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 279 */       return false;
/* 280 */     if (!this.grooms.equals(_o_.grooms)) return false;
/* 281 */     if (!this.brides.equals(_o_.brides)) return false;
/* 282 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     int _h_ = 0;
/* 290 */     _h_ += this.grooms.hashCode();
/* 291 */     _h_ += this.brides.hashCode();
/* 292 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     StringBuilder _sb_ = new StringBuilder();
/* 300 */     _sb_.append("(");
/* 301 */     _sb_.append(this.grooms);
/* 302 */     _sb_.append(",");
/* 303 */     _sb_.append(this.brides);
/* 304 */     _sb_.append(")");
/* 305 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 311 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 312 */     lb.add(new xdb.logs.ListenableSet().setVarName("grooms"));
/* 313 */     lb.add(new xdb.logs.ListenableSet().setVarName("brides"));
/* 314 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MassWeddingRobRoles {
/*     */     private Const() {}
/*     */     
/*     */     MassWeddingRobRoles nThis() {
/* 321 */       return MassWeddingRobRoles.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 327 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobRoles copy()
/*     */     {
/* 333 */       return MassWeddingRobRoles.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobRoles toData()
/*     */     {
/* 339 */       return MassWeddingRobRoles.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobRoles toBean()
/*     */     {
/* 344 */       return MassWeddingRobRoles.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobRoles toDataIf()
/*     */     {
/* 350 */       return MassWeddingRobRoles.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobRoles toBeanIf()
/*     */     {
/* 355 */       return MassWeddingRobRoles.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getGrooms()
/*     */     {
/* 362 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/* 363 */       return xdb.Consts.constSet(MassWeddingRobRoles.this.grooms);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getGroomsAsData()
/*     */     {
/* 369 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/*     */       
/* 371 */       MassWeddingRobRoles _o_ = MassWeddingRobRoles.this;
/* 372 */       Set<Long> grooms = new SetX();
/* 373 */       grooms.addAll(_o_.grooms);
/* 374 */       return grooms;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getBrides()
/*     */     {
/* 381 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/* 382 */       return xdb.Consts.constSet(MassWeddingRobRoles.this.brides);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getBridesAsData()
/*     */     {
/* 388 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/*     */       
/* 390 */       MassWeddingRobRoles _o_ = MassWeddingRobRoles.this;
/* 391 */       Set<Long> brides = new SetX();
/* 392 */       brides.addAll(_o_.brides);
/* 393 */       return brides;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 399 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/* 400 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 406 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/* 407 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 413 */       return MassWeddingRobRoles.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 419 */       return MassWeddingRobRoles.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 425 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 432 */       return MassWeddingRobRoles.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 438 */       return MassWeddingRobRoles.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 444 */       MassWeddingRobRoles.this._xdb_verify_unsafe_();
/* 445 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 451 */       return MassWeddingRobRoles.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 457 */       return MassWeddingRobRoles.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 463 */       return MassWeddingRobRoles.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 469 */       return MassWeddingRobRoles.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 475 */       return MassWeddingRobRoles.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 481 */       return MassWeddingRobRoles.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 487 */       return MassWeddingRobRoles.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MassWeddingRobRoles
/*     */   {
/*     */     private HashSet<Long> grooms;
/*     */     
/*     */     private HashSet<Long> brides;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 501 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 506 */       this.grooms = new HashSet();
/* 507 */       this.brides = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.MassWeddingRobRoles _o1_)
/*     */     {
/* 512 */       if ((_o1_ instanceof MassWeddingRobRoles)) { assign((MassWeddingRobRoles)_o1_);
/* 513 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 514 */       } else if ((_o1_ instanceof MassWeddingRobRoles.Const)) assign(((MassWeddingRobRoles.Const)_o1_).nThis()); else {
/* 515 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MassWeddingRobRoles _o_) {
/* 520 */       this.grooms = new HashSet();
/* 521 */       this.grooms.addAll(_o_.grooms);
/* 522 */       this.brides = new HashSet();
/* 523 */       this.brides.addAll(_o_.brides);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 528 */       this.grooms = new HashSet();
/* 529 */       this.grooms.addAll(_o_.grooms);
/* 530 */       this.brides = new HashSet();
/* 531 */       this.brides.addAll(_o_.brides);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 537 */       _os_.compact_uint32(this.grooms.size());
/* 538 */       for (Long _v_ : this.grooms)
/*     */       {
/* 540 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 542 */       _os_.compact_uint32(this.brides.size());
/* 543 */       for (Long _v_ : this.brides)
/*     */       {
/* 545 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 547 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 553 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 555 */         long _v_ = 0L;
/* 556 */         _v_ = _os_.unmarshal_long();
/* 557 */         this.grooms.add(Long.valueOf(_v_));
/*     */       }
/* 559 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 561 */         long _v_ = 0L;
/* 562 */         _v_ = _os_.unmarshal_long();
/* 563 */         this.brides.add(Long.valueOf(_v_));
/*     */       }
/* 565 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 571 */       int _size_ = 0;
/* 572 */       for (Long _v_ : this.grooms)
/*     */       {
/* 574 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 576 */       for (Long _v_ : this.brides)
/*     */       {
/* 578 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 580 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 588 */         for (Long _v_ : this.grooms)
/*     */         {
/* 590 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 592 */         for (Long _v_ : this.brides)
/*     */         {
/* 594 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 599 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 601 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         boolean done = false;
/* 610 */         while (!done)
/*     */         {
/* 612 */           int tag = _input_.readTag();
/* 613 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 617 */             done = true;
/* 618 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 622 */             long _v_ = 0L;
/* 623 */             _v_ = _input_.readInt64();
/* 624 */             this.grooms.add(Long.valueOf(_v_));
/* 625 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 629 */             long _v_ = 0L;
/* 630 */             _v_ = _input_.readInt64();
/* 631 */             this.brides.add(Long.valueOf(_v_));
/* 632 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 636 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 638 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 647 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 651 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 653 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobRoles copy()
/*     */     {
/* 659 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobRoles toData()
/*     */     {
/* 665 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobRoles toBean()
/*     */     {
/* 670 */       return new MassWeddingRobRoles(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRobRoles toDataIf()
/*     */     {
/* 676 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRobRoles toBeanIf()
/*     */     {
/* 681 */       return new MassWeddingRobRoles(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 687 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 691 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 695 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 699 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 703 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 707 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 711 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getGrooms()
/*     */     {
/* 718 */       return this.grooms;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getGroomsAsData()
/*     */     {
/* 725 */       return this.grooms;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getBrides()
/*     */     {
/* 732 */       return this.brides;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getBridesAsData()
/*     */     {
/* 739 */       return this.brides;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 745 */       if (!(_o1_ instanceof Data)) return false;
/* 746 */       Data _o_ = (Data)_o1_;
/* 747 */       if (!this.grooms.equals(_o_.grooms)) return false;
/* 748 */       if (!this.brides.equals(_o_.brides)) return false;
/* 749 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 755 */       int _h_ = 0;
/* 756 */       _h_ += this.grooms.hashCode();
/* 757 */       _h_ += this.brides.hashCode();
/* 758 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 764 */       StringBuilder _sb_ = new StringBuilder();
/* 765 */       _sb_.append("(");
/* 766 */       _sb_.append(this.grooms);
/* 767 */       _sb_.append(",");
/* 768 */       _sb_.append(this.brides);
/* 769 */       _sb_.append(")");
/* 770 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassWeddingRobRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */