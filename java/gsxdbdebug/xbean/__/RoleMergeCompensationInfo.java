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
/*     */ public final class RoleMergeCompensationInfo extends xdb.XBean implements xbean.RoleMergeCompensationInfo
/*     */ {
/*     */   private SetX<Long> have_got_compensation_merge_system_timestamps;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.have_got_compensation_merge_system_timestamps.clear();
/*     */   }
/*     */   
/*     */   RoleMergeCompensationInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.have_got_compensation_merge_system_timestamps = new SetX();
/*     */   }
/*     */   
/*     */   public RoleMergeCompensationInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleMergeCompensationInfo(RoleMergeCompensationInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleMergeCompensationInfo(xbean.RoleMergeCompensationInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof RoleMergeCompensationInfo)) { assign((RoleMergeCompensationInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleMergeCompensationInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.have_got_compensation_merge_system_timestamps = new SetX();
/*  50 */     this.have_got_compensation_merge_system_timestamps.addAll(_o_.have_got_compensation_merge_system_timestamps);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.have_got_compensation_merge_system_timestamps = new SetX();
/*  56 */     this.have_got_compensation_merge_system_timestamps.addAll(_o_.have_got_compensation_merge_system_timestamps);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.have_got_compensation_merge_system_timestamps.size());
/*  64 */     for (Long _v_ : this.have_got_compensation_merge_system_timestamps)
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
/*  79 */       this.have_got_compensation_merge_system_timestamps.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (Long _v_ : this.have_got_compensation_merge_system_timestamps)
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
/* 102 */       for (Long _v_ : this.have_got_compensation_merge_system_timestamps)
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
/* 135 */           this.have_got_compensation_merge_system_timestamps.add(Long.valueOf(_v_));
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
/*     */   public xbean.RoleMergeCompensationInfo copy()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new RoleMergeCompensationInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleMergeCompensationInfo toData()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleMergeCompensationInfo toBean()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new RoleMergeCompensationInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleMergeCompensationInfo toDataIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleMergeCompensationInfo toBeanIf()
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
/*     */   public Set<Long> getHave_got_compensation_merge_system_timestamps()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return xdb.Logs.logSet(new xdb.LogKey(this, "have_got_compensation_merge_system_timestamps"), this.have_got_compensation_merge_system_timestamps);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getHave_got_compensation_merge_system_timestampsAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     RoleMergeCompensationInfo _o_ = this;
/* 214 */     Set<Long> have_got_compensation_merge_system_timestamps = new SetX();
/* 215 */     have_got_compensation_merge_system_timestamps.addAll(_o_.have_got_compensation_merge_system_timestamps);
/* 216 */     return have_got_compensation_merge_system_timestamps;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     RoleMergeCompensationInfo _o_ = null;
/* 224 */     if ((_o1_ instanceof RoleMergeCompensationInfo)) { _o_ = (RoleMergeCompensationInfo)_o1_;
/* 225 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 226 */       return false;
/* 227 */     if (!this.have_got_compensation_merge_system_timestamps.equals(_o_.have_got_compensation_merge_system_timestamps)) return false;
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     int _h_ = 0;
/* 236 */     _h_ += this.have_got_compensation_merge_system_timestamps.hashCode();
/* 237 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.have_got_compensation_merge_system_timestamps);
/* 247 */     _sb_.append(")");
/* 248 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 254 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 255 */     lb.add(new xdb.logs.ListenableSet().setVarName("have_got_compensation_merge_system_timestamps"));
/* 256 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleMergeCompensationInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleMergeCompensationInfo nThis() {
/* 263 */       return RoleMergeCompensationInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMergeCompensationInfo copy()
/*     */     {
/* 275 */       return RoleMergeCompensationInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMergeCompensationInfo toData()
/*     */     {
/* 281 */       return RoleMergeCompensationInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleMergeCompensationInfo toBean()
/*     */     {
/* 286 */       return RoleMergeCompensationInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMergeCompensationInfo toDataIf()
/*     */     {
/* 292 */       return RoleMergeCompensationInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleMergeCompensationInfo toBeanIf()
/*     */     {
/* 297 */       return RoleMergeCompensationInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getHave_got_compensation_merge_system_timestamps()
/*     */     {
/* 304 */       RoleMergeCompensationInfo.this._xdb_verify_unsafe_();
/* 305 */       return xdb.Consts.constSet(RoleMergeCompensationInfo.this.have_got_compensation_merge_system_timestamps);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getHave_got_compensation_merge_system_timestampsAsData()
/*     */     {
/* 311 */       RoleMergeCompensationInfo.this._xdb_verify_unsafe_();
/*     */       
/* 313 */       RoleMergeCompensationInfo _o_ = RoleMergeCompensationInfo.this;
/* 314 */       Set<Long> have_got_compensation_merge_system_timestamps = new SetX();
/* 315 */       have_got_compensation_merge_system_timestamps.addAll(_o_.have_got_compensation_merge_system_timestamps);
/* 316 */       return have_got_compensation_merge_system_timestamps;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 322 */       RoleMergeCompensationInfo.this._xdb_verify_unsafe_();
/* 323 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 329 */       RoleMergeCompensationInfo.this._xdb_verify_unsafe_();
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 336 */       return RoleMergeCompensationInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 342 */       return RoleMergeCompensationInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 348 */       RoleMergeCompensationInfo.this._xdb_verify_unsafe_();
/* 349 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 355 */       return RoleMergeCompensationInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 361 */       return RoleMergeCompensationInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 367 */       RoleMergeCompensationInfo.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 374 */       return RoleMergeCompensationInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 380 */       return RoleMergeCompensationInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 386 */       return RoleMergeCompensationInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 392 */       return RoleMergeCompensationInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 398 */       return RoleMergeCompensationInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 404 */       return RoleMergeCompensationInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 410 */       return RoleMergeCompensationInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleMergeCompensationInfo
/*     */   {
/*     */     private HashSet<Long> have_got_compensation_merge_system_timestamps;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 427 */       this.have_got_compensation_merge_system_timestamps = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleMergeCompensationInfo _o1_)
/*     */     {
/* 432 */       if ((_o1_ instanceof RoleMergeCompensationInfo)) { assign((RoleMergeCompensationInfo)_o1_);
/* 433 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 434 */       } else if ((_o1_ instanceof RoleMergeCompensationInfo.Const)) assign(((RoleMergeCompensationInfo.Const)_o1_).nThis()); else {
/* 435 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleMergeCompensationInfo _o_) {
/* 440 */       this.have_got_compensation_merge_system_timestamps = new HashSet();
/* 441 */       this.have_got_compensation_merge_system_timestamps.addAll(_o_.have_got_compensation_merge_system_timestamps);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 446 */       this.have_got_compensation_merge_system_timestamps = new HashSet();
/* 447 */       this.have_got_compensation_merge_system_timestamps.addAll(_o_.have_got_compensation_merge_system_timestamps);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 453 */       _os_.compact_uint32(this.have_got_compensation_merge_system_timestamps.size());
/* 454 */       for (Long _v_ : this.have_got_compensation_merge_system_timestamps)
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
/* 468 */         this.have_got_compensation_merge_system_timestamps.add(Long.valueOf(_v_));
/*     */       }
/* 470 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 476 */       int _size_ = 0;
/* 477 */       for (Long _v_ : this.have_got_compensation_merge_system_timestamps)
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
/* 489 */         for (Long _v_ : this.have_got_compensation_merge_system_timestamps)
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
/* 521 */             this.have_got_compensation_merge_system_timestamps.add(Long.valueOf(_v_));
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
/*     */     public xbean.RoleMergeCompensationInfo copy()
/*     */     {
/* 549 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMergeCompensationInfo toData()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleMergeCompensationInfo toBean()
/*     */     {
/* 560 */       return new RoleMergeCompensationInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleMergeCompensationInfo toDataIf()
/*     */     {
/* 566 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleMergeCompensationInfo toBeanIf()
/*     */     {
/* 571 */       return new RoleMergeCompensationInfo(this, null, null);
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
/*     */     public Set<Long> getHave_got_compensation_merge_system_timestamps()
/*     */     {
/* 608 */       return this.have_got_compensation_merge_system_timestamps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getHave_got_compensation_merge_system_timestampsAsData()
/*     */     {
/* 615 */       return this.have_got_compensation_merge_system_timestamps;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 621 */       if (!(_o1_ instanceof Data)) return false;
/* 622 */       Data _o_ = (Data)_o1_;
/* 623 */       if (!this.have_got_compensation_merge_system_timestamps.equals(_o_.have_got_compensation_merge_system_timestamps)) return false;
/* 624 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 630 */       int _h_ = 0;
/* 631 */       _h_ += this.have_got_compensation_merge_system_timestamps.hashCode();
/* 632 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       StringBuilder _sb_ = new StringBuilder();
/* 639 */       _sb_.append("(");
/* 640 */       _sb_.append(this.have_got_compensation_merge_system_timestamps);
/* 641 */       _sb_.append(")");
/* 642 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleMergeCompensationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */