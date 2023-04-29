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
/*     */ public final class ZoneInfo extends XBean implements xbean.ZoneInfo
/*     */ {
/*     */   private SetX<Long> role_set;
/*     */   private int eventid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.role_set.clear();
/*  21 */     this.eventid = -1;
/*     */   }
/*     */   
/*     */   ZoneInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.role_set = new SetX();
/*  28 */     this.eventid = -1;
/*     */   }
/*     */   
/*     */   public ZoneInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ZoneInfo(ZoneInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ZoneInfo(xbean.ZoneInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof ZoneInfo)) { assign((ZoneInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ZoneInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.role_set = new SetX();
/*  54 */     this.role_set.addAll(_o_.role_set);
/*  55 */     this.eventid = _o_.eventid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.role_set = new SetX();
/*  61 */     this.role_set.addAll(_o_.role_set);
/*  62 */     this.eventid = _o_.eventid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     _os_.compact_uint32(this.role_set.size());
/*  70 */     for (Long _v_ : this.role_set)
/*     */     {
/*  72 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  74 */     _os_.marshal(this.eventid);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _v_ = 0L;
/*  85 */       _v_ = _os_.unmarshal_long();
/*  86 */       this.role_set.add(Long.valueOf(_v_));
/*     */     }
/*  88 */     this.eventid = _os_.unmarshal_int();
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     int _size_ = 0;
/*  97 */     for (Long _v_ : this.role_set)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(2, this.eventid);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       for (Long _v_ : this.role_set)
/*     */       {
/* 113 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 115 */       _output_.writeInt32(2, this.eventid);
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
/* 143 */           long _v_ = 0L;
/* 144 */           _v_ = _input_.readInt64();
/* 145 */           this.role_set.add(Long.valueOf(_v_));
/* 146 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 150 */           this.eventid = _input_.readInt32();
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
/*     */   public xbean.ZoneInfo copy()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new ZoneInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZoneInfo toData()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZoneInfo toBean()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new ZoneInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ZoneInfo toDataIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ZoneInfo toBeanIf()
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
/*     */   public Set<Long> getRole_set()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return xdb.Logs.logSet(new xdb.LogKey(this, "role_set"), this.role_set);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getRole_setAsData()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/*     */     
/* 228 */     ZoneInfo _o_ = this;
/* 229 */     Set<Long> role_set = new SetX();
/* 230 */     role_set.addAll(_o_.role_set);
/* 231 */     return role_set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEventid()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.eventid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEventid(int _v_)
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     xdb.Logs.logIf(new xdb.LogKey(this, "eventid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 251 */         new xdb.logs.LogInt(this, ZoneInfo.this.eventid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 255 */             ZoneInfo.this.eventid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 259 */     });
/* 260 */     this.eventid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     ZoneInfo _o_ = null;
/* 268 */     if ((_o1_ instanceof ZoneInfo)) { _o_ = (ZoneInfo)_o1_;
/* 269 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 270 */       return false;
/* 271 */     if (!this.role_set.equals(_o_.role_set)) return false;
/* 272 */     if (this.eventid != _o_.eventid) return false;
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     int _h_ = 0;
/* 281 */     _h_ += this.role_set.hashCode();
/* 282 */     _h_ += this.eventid;
/* 283 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     StringBuilder _sb_ = new StringBuilder();
/* 291 */     _sb_.append("(");
/* 292 */     _sb_.append(this.role_set);
/* 293 */     _sb_.append(",");
/* 294 */     _sb_.append(this.eventid);
/* 295 */     _sb_.append(")");
/* 296 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 302 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 303 */     lb.add(new xdb.logs.ListenableSet().setVarName("role_set"));
/* 304 */     lb.add(new xdb.logs.ListenableChanged().setVarName("eventid"));
/* 305 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ZoneInfo {
/*     */     private Const() {}
/*     */     
/*     */     ZoneInfo nThis() {
/* 312 */       return ZoneInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 318 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZoneInfo copy()
/*     */     {
/* 324 */       return ZoneInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZoneInfo toData()
/*     */     {
/* 330 */       return ZoneInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ZoneInfo toBean()
/*     */     {
/* 335 */       return ZoneInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZoneInfo toDataIf()
/*     */     {
/* 341 */       return ZoneInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ZoneInfo toBeanIf()
/*     */     {
/* 346 */       return ZoneInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRole_set()
/*     */     {
/* 353 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 354 */       return xdb.Consts.constSet(ZoneInfo.this.role_set);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getRole_setAsData()
/*     */     {
/* 360 */       ZoneInfo.this._xdb_verify_unsafe_();
/*     */       
/* 362 */       ZoneInfo _o_ = ZoneInfo.this;
/* 363 */       Set<Long> role_set = new SetX();
/* 364 */       role_set.addAll(_o_.role_set);
/* 365 */       return role_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEventid()
/*     */     {
/* 372 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 373 */       return ZoneInfo.this.eventid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEventid(int _v_)
/*     */     {
/* 380 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 387 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 388 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 394 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 395 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 401 */       return ZoneInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 407 */       return ZoneInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 413 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 420 */       return ZoneInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 426 */       return ZoneInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 432 */       ZoneInfo.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 439 */       return ZoneInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 445 */       return ZoneInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 451 */       return ZoneInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 457 */       return ZoneInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 463 */       return ZoneInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 469 */       return ZoneInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 475 */       return ZoneInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ZoneInfo
/*     */   {
/*     */     private HashSet<Long> role_set;
/*     */     
/*     */     private int eventid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 494 */       this.role_set = new HashSet();
/* 495 */       this.eventid = -1;
/*     */     }
/*     */     
/*     */     Data(xbean.ZoneInfo _o1_)
/*     */     {
/* 500 */       if ((_o1_ instanceof ZoneInfo)) { assign((ZoneInfo)_o1_);
/* 501 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 502 */       } else if ((_o1_ instanceof ZoneInfo.Const)) assign(((ZoneInfo.Const)_o1_).nThis()); else {
/* 503 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ZoneInfo _o_) {
/* 508 */       this.role_set = new HashSet();
/* 509 */       this.role_set.addAll(_o_.role_set);
/* 510 */       this.eventid = _o_.eventid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 515 */       this.role_set = new HashSet();
/* 516 */       this.role_set.addAll(_o_.role_set);
/* 517 */       this.eventid = _o_.eventid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       _os_.compact_uint32(this.role_set.size());
/* 524 */       for (Long _v_ : this.role_set)
/*     */       {
/* 526 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 528 */       _os_.marshal(this.eventid);
/* 529 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 535 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 537 */         long _v_ = 0L;
/* 538 */         _v_ = _os_.unmarshal_long();
/* 539 */         this.role_set.add(Long.valueOf(_v_));
/*     */       }
/* 541 */       this.eventid = _os_.unmarshal_int();
/* 542 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 548 */       int _size_ = 0;
/* 549 */       for (Long _v_ : this.role_set)
/*     */       {
/* 551 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 553 */       _size_ += CodedOutputStream.computeInt32Size(2, this.eventid);
/* 554 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 562 */         for (Long _v_ : this.role_set)
/*     */         {
/* 564 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 566 */         _output_.writeInt32(2, this.eventid);
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
/* 593 */             long _v_ = 0L;
/* 594 */             _v_ = _input_.readInt64();
/* 595 */             this.role_set.add(Long.valueOf(_v_));
/* 596 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 600 */             this.eventid = _input_.readInt32();
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
/*     */     public xbean.ZoneInfo copy()
/*     */     {
/* 628 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZoneInfo toData()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ZoneInfo toBean()
/*     */     {
/* 639 */       return new ZoneInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ZoneInfo toDataIf()
/*     */     {
/* 645 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ZoneInfo toBeanIf()
/*     */     {
/* 650 */       return new ZoneInfo(this, null, null);
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
/*     */     public Set<Long> getRole_set()
/*     */     {
/* 687 */       return this.role_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRole_setAsData()
/*     */     {
/* 694 */       return this.role_set;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEventid()
/*     */     {
/* 701 */       return this.eventid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEventid(int _v_)
/*     */     {
/* 708 */       this.eventid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 714 */       if (!(_o1_ instanceof Data)) return false;
/* 715 */       Data _o_ = (Data)_o1_;
/* 716 */       if (!this.role_set.equals(_o_.role_set)) return false;
/* 717 */       if (this.eventid != _o_.eventid) return false;
/* 718 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 724 */       int _h_ = 0;
/* 725 */       _h_ += this.role_set.hashCode();
/* 726 */       _h_ += this.eventid;
/* 727 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 733 */       StringBuilder _sb_ = new StringBuilder();
/* 734 */       _sb_.append("(");
/* 735 */       _sb_.append(this.role_set);
/* 736 */       _sb_.append(",");
/* 737 */       _sb_.append(this.eventid);
/* 738 */       _sb_.append(")");
/* 739 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */