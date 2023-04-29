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
/*     */ public final class ArenaTmp extends XBean implements xbean.ArenaTmp
/*     */ {
/*     */   private long world;
/*     */   private SetX<Long> fights;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.world = -1L;
/*  21 */     this.fights.clear();
/*     */   }
/*     */   
/*     */   ArenaTmp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.world = -1L;
/*  28 */     this.fights = new SetX();
/*     */   }
/*     */   
/*     */   public ArenaTmp()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ArenaTmp(ArenaTmp _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ArenaTmp(xbean.ArenaTmp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof ArenaTmp)) { assign((ArenaTmp)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ArenaTmp _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.world = _o_.world;
/*  54 */     this.fights = new SetX();
/*  55 */     this.fights.addAll(_o_.fights);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.world = _o_.world;
/*  61 */     this.fights = new SetX();
/*  62 */     this.fights.addAll(_o_.fights);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     _os_.marshal(this.world);
/*  70 */     _os_.compact_uint32(this.fights.size());
/*  71 */     for (Long _v_ : this.fights)
/*     */     {
/*  73 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.world = _os_.unmarshal_long();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       long _v_ = 0L;
/*  86 */       _v_ = _os_.unmarshal_long();
/*  87 */       this.fights.add(Long.valueOf(_v_));
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     int _size_ = 0;
/*  97 */     _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/*  98 */     for (Long _v_ : this.fights)
/*     */     {
/* 100 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.world);
/* 112 */       for (Long _v_ : this.fights)
/*     */       {
/* 114 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.world = _input_.readInt64();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 148 */           long _v_ = 0L;
/* 149 */           _v_ = _input_.readInt64();
/* 150 */           this.fights.add(Long.valueOf(_v_));
/* 151 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 155 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 157 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 166 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 170 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 172 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ArenaTmp copy()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new ArenaTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ArenaTmp toData()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ArenaTmp toBean()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new ArenaTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ArenaTmp toDataIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ArenaTmp toBeanIf()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getWorld()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this.world;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getFights()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return xdb.Logs.logSet(new xdb.LogKey(this, "fights"), this.fights);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getFightsAsData()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/*     */     
/* 236 */     ArenaTmp _o_ = this;
/* 237 */     Set<Long> fights = new SetX();
/* 238 */     fights.addAll(_o_.fights);
/* 239 */     return fights;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorld(long _v_)
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     xdb.Logs.logIf(new xdb.LogKey(this, "world")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 251 */         new xdb.logs.LogLong(this, ArenaTmp.this.world)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 255 */             ArenaTmp.this.world = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 259 */     });
/* 260 */     this.world = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     ArenaTmp _o_ = null;
/* 268 */     if ((_o1_ instanceof ArenaTmp)) { _o_ = (ArenaTmp)_o1_;
/* 269 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 270 */       return false;
/* 271 */     if (this.world != _o_.world) return false;
/* 272 */     if (!this.fights.equals(_o_.fights)) return false;
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     int _h_ = 0;
/* 281 */     _h_ = (int)(_h_ + this.world);
/* 282 */     _h_ += this.fights.hashCode();
/* 283 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     StringBuilder _sb_ = new StringBuilder();
/* 291 */     _sb_.append("(");
/* 292 */     _sb_.append(this.world);
/* 293 */     _sb_.append(",");
/* 294 */     _sb_.append(this.fights);
/* 295 */     _sb_.append(")");
/* 296 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 302 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("world"));
/* 304 */     lb.add(new xdb.logs.ListenableSet().setVarName("fights"));
/* 305 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ArenaTmp {
/*     */     private Const() {}
/*     */     
/*     */     ArenaTmp nThis() {
/* 312 */       return ArenaTmp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 318 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ArenaTmp copy()
/*     */     {
/* 324 */       return ArenaTmp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ArenaTmp toData()
/*     */     {
/* 330 */       return ArenaTmp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ArenaTmp toBean()
/*     */     {
/* 335 */       return ArenaTmp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ArenaTmp toDataIf()
/*     */     {
/* 341 */       return ArenaTmp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ArenaTmp toBeanIf()
/*     */     {
/* 346 */       return ArenaTmp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorld()
/*     */     {
/* 353 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 354 */       return ArenaTmp.this.world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFights()
/*     */     {
/* 361 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 362 */       return xdb.Consts.constSet(ArenaTmp.this.fights);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getFightsAsData()
/*     */     {
/* 368 */       ArenaTmp.this._xdb_verify_unsafe_();
/*     */       
/* 370 */       ArenaTmp _o_ = ArenaTmp.this;
/* 371 */       Set<Long> fights = new SetX();
/* 372 */       fights.addAll(_o_.fights);
/* 373 */       return fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorld(long _v_)
/*     */     {
/* 380 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 387 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 388 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 394 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 395 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 401 */       return ArenaTmp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 407 */       return ArenaTmp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 413 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 420 */       return ArenaTmp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 426 */       return ArenaTmp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 432 */       ArenaTmp.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 439 */       return ArenaTmp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 445 */       return ArenaTmp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 451 */       return ArenaTmp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 457 */       return ArenaTmp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 463 */       return ArenaTmp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 469 */       return ArenaTmp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 475 */       return ArenaTmp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ArenaTmp
/*     */   {
/*     */     private long world;
/*     */     
/*     */     private HashSet<Long> fights;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 494 */       this.world = -1L;
/* 495 */       this.fights = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.ArenaTmp _o1_)
/*     */     {
/* 500 */       if ((_o1_ instanceof ArenaTmp)) { assign((ArenaTmp)_o1_);
/* 501 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 502 */       } else if ((_o1_ instanceof ArenaTmp.Const)) assign(((ArenaTmp.Const)_o1_).nThis()); else {
/* 503 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ArenaTmp _o_) {
/* 508 */       this.world = _o_.world;
/* 509 */       this.fights = new HashSet();
/* 510 */       this.fights.addAll(_o_.fights);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 515 */       this.world = _o_.world;
/* 516 */       this.fights = new HashSet();
/* 517 */       this.fights.addAll(_o_.fights);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       _os_.marshal(this.world);
/* 524 */       _os_.compact_uint32(this.fights.size());
/* 525 */       for (Long _v_ : this.fights)
/*     */       {
/* 527 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 529 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 535 */       this.world = _os_.unmarshal_long();
/* 536 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 538 */         long _v_ = 0L;
/* 539 */         _v_ = _os_.unmarshal_long();
/* 540 */         this.fights.add(Long.valueOf(_v_));
/*     */       }
/* 542 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 548 */       int _size_ = 0;
/* 549 */       _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/* 550 */       for (Long _v_ : this.fights)
/*     */       {
/* 552 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 554 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 562 */         _output_.writeInt64(1, this.world);
/* 563 */         for (Long _v_ : this.fights)
/*     */         {
/* 565 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 570 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 572 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 580 */         boolean done = false;
/* 581 */         while (!done)
/*     */         {
/* 583 */           int tag = _input_.readTag();
/* 584 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 588 */             done = true;
/* 589 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 593 */             this.world = _input_.readInt64();
/* 594 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 598 */             long _v_ = 0L;
/* 599 */             _v_ = _input_.readInt64();
/* 600 */             this.fights.add(Long.valueOf(_v_));
/* 601 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 605 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 607 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 616 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 620 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 622 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ArenaTmp copy()
/*     */     {
/* 628 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ArenaTmp toData()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ArenaTmp toBean()
/*     */     {
/* 639 */       return new ArenaTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ArenaTmp toDataIf()
/*     */     {
/* 645 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ArenaTmp toBeanIf()
/*     */     {
/* 650 */       return new ArenaTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 656 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 676 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 680 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorld()
/*     */     {
/* 687 */       return this.world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFights()
/*     */     {
/* 694 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFightsAsData()
/*     */     {
/* 701 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorld(long _v_)
/*     */     {
/* 708 */       this.world = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 714 */       if (!(_o1_ instanceof Data)) return false;
/* 715 */       Data _o_ = (Data)_o1_;
/* 716 */       if (this.world != _o_.world) return false;
/* 717 */       if (!this.fights.equals(_o_.fights)) return false;
/* 718 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 724 */       int _h_ = 0;
/* 725 */       _h_ = (int)(_h_ + this.world);
/* 726 */       _h_ += this.fights.hashCode();
/* 727 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 733 */       StringBuilder _sb_ = new StringBuilder();
/* 734 */       _sb_.append("(");
/* 735 */       _sb_.append(this.world);
/* 736 */       _sb_.append(",");
/* 737 */       _sb_.append(this.fights);
/* 738 */       _sb_.append(")");
/* 739 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ArenaTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */