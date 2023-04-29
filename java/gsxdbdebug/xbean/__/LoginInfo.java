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
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class LoginInfo extends XBean implements xbean.LoginInfo
/*     */ {
/*     */   private long last_time;
/*     */   private SetX<Integer> sortids;
/*     */   private SetX<Integer> unreceivedsortids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.last_time = 0L;
/*  23 */     this.sortids.clear();
/*  24 */     this.unreceivedsortids.clear();
/*     */   }
/*     */   
/*     */   LoginInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.last_time = 0L;
/*  31 */     this.sortids = new SetX();
/*  32 */     this.unreceivedsortids = new SetX();
/*     */   }
/*     */   
/*     */   public LoginInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LoginInfo(LoginInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LoginInfo(xbean.LoginInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof LoginInfo)) { assign((LoginInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LoginInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.last_time = _o_.last_time;
/*  58 */     this.sortids = new SetX();
/*  59 */     this.sortids.addAll(_o_.sortids);
/*  60 */     this.unreceivedsortids = new SetX();
/*  61 */     this.unreceivedsortids.addAll(_o_.unreceivedsortids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.last_time = _o_.last_time;
/*  67 */     this.sortids = new SetX();
/*  68 */     this.sortids.addAll(_o_.sortids);
/*  69 */     this.unreceivedsortids = new SetX();
/*  70 */     this.unreceivedsortids.addAll(_o_.unreceivedsortids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.last_time);
/*  78 */     _os_.compact_uint32(this.sortids.size());
/*  79 */     for (Integer _v_ : this.sortids)
/*     */     {
/*  81 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  83 */     _os_.compact_uint32(this.unreceivedsortids.size());
/*  84 */     for (Integer _v_ : this.unreceivedsortids)
/*     */     {
/*  86 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     this.last_time = _os_.unmarshal_long();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       int _v_ = 0;
/*  99 */       _v_ = _os_.unmarshal_int();
/* 100 */       this.sortids.add(Integer.valueOf(_v_));
/*     */     }
/* 102 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 104 */       int _v_ = 0;
/* 105 */       _v_ = _os_.unmarshal_int();
/* 106 */       this.unreceivedsortids.add(Integer.valueOf(_v_));
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     int _size_ = 0;
/* 116 */     _size_ += CodedOutputStream.computeInt64Size(1, this.last_time);
/* 117 */     for (Integer _v_ : this.sortids)
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 121 */     for (Integer _v_ : this.unreceivedsortids)
/*     */     {
/* 123 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 125 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 131 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 134 */       _output_.writeInt64(1, this.last_time);
/* 135 */       for (Integer _v_ : this.sortids)
/*     */       {
/* 137 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 139 */       for (Integer _v_ : this.unreceivedsortids)
/*     */       {
/* 141 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 146 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 148 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 154 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 157 */       boolean done = false;
/* 158 */       while (!done)
/*     */       {
/* 160 */         int tag = _input_.readTag();
/* 161 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 165 */           done = true;
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 170 */           this.last_time = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 175 */           int _v_ = 0;
/* 176 */           _v_ = _input_.readInt32();
/* 177 */           this.sortids.add(Integer.valueOf(_v_));
/* 178 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 182 */           int _v_ = 0;
/* 183 */           _v_ = _input_.readInt32();
/* 184 */           this.unreceivedsortids.add(Integer.valueOf(_v_));
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new LoginInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new LoginInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginInfo toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLast_time()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.last_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getSortids()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return xdb.Logs.logSet(new LogKey(this, "sortids"), this.sortids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getSortidsAsData()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/*     */     
/* 270 */     LoginInfo _o_ = this;
/* 271 */     Set<Integer> sortids = new SetX();
/* 272 */     sortids.addAll(_o_.sortids);
/* 273 */     return sortids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getUnreceivedsortids()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logSet(new LogKey(this, "unreceivedsortids"), this.unreceivedsortids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getUnreceivedsortidsAsData()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/*     */     
/* 289 */     LoginInfo _o_ = this;
/* 290 */     Set<Integer> unreceivedsortids = new SetX();
/* 291 */     unreceivedsortids.addAll(_o_.unreceivedsortids);
/* 292 */     return unreceivedsortids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_time(long _v_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     xdb.Logs.logIf(new LogKey(this, "last_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 304 */         new xdb.logs.LogLong(this, LoginInfo.this.last_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 308 */             LoginInfo.this.last_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 312 */     });
/* 313 */     this.last_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 319 */     _xdb_verify_unsafe_();
/* 320 */     LoginInfo _o_ = null;
/* 321 */     if ((_o1_ instanceof LoginInfo)) { _o_ = (LoginInfo)_o1_;
/* 322 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 323 */       return false;
/* 324 */     if (this.last_time != _o_.last_time) return false;
/* 325 */     if (!this.sortids.equals(_o_.sortids)) return false;
/* 326 */     if (!this.unreceivedsortids.equals(_o_.unreceivedsortids)) return false;
/* 327 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     int _h_ = 0;
/* 335 */     _h_ = (int)(_h_ + this.last_time);
/* 336 */     _h_ += this.sortids.hashCode();
/* 337 */     _h_ += this.unreceivedsortids.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.last_time);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.sortids);
/* 350 */     _sb_.append(",");
/* 351 */     _sb_.append(this.unreceivedsortids);
/* 352 */     _sb_.append(")");
/* 353 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 359 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 360 */     lb.add(new xdb.logs.ListenableChanged().setVarName("last_time"));
/* 361 */     lb.add(new xdb.logs.ListenableSet().setVarName("sortids"));
/* 362 */     lb.add(new xdb.logs.ListenableSet().setVarName("unreceivedsortids"));
/* 363 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LoginInfo {
/*     */     private Const() {}
/*     */     
/*     */     LoginInfo nThis() {
/* 370 */       return LoginInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 376 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginInfo copy()
/*     */     {
/* 382 */       return LoginInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginInfo toData()
/*     */     {
/* 388 */       return LoginInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LoginInfo toBean()
/*     */     {
/* 393 */       return LoginInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginInfo toDataIf()
/*     */     {
/* 399 */       return LoginInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LoginInfo toBeanIf()
/*     */     {
/* 404 */       return LoginInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 411 */       LoginInfo.this._xdb_verify_unsafe_();
/* 412 */       return LoginInfo.this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSortids()
/*     */     {
/* 419 */       LoginInfo.this._xdb_verify_unsafe_();
/* 420 */       return xdb.Consts.constSet(LoginInfo.this.sortids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getSortidsAsData()
/*     */     {
/* 426 */       LoginInfo.this._xdb_verify_unsafe_();
/*     */       
/* 428 */       LoginInfo _o_ = LoginInfo.this;
/* 429 */       Set<Integer> sortids = new SetX();
/* 430 */       sortids.addAll(_o_.sortids);
/* 431 */       return sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getUnreceivedsortids()
/*     */     {
/* 438 */       LoginInfo.this._xdb_verify_unsafe_();
/* 439 */       return xdb.Consts.constSet(LoginInfo.this.unreceivedsortids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getUnreceivedsortidsAsData()
/*     */     {
/* 445 */       LoginInfo.this._xdb_verify_unsafe_();
/*     */       
/* 447 */       LoginInfo _o_ = LoginInfo.this;
/* 448 */       Set<Integer> unreceivedsortids = new SetX();
/* 449 */       unreceivedsortids.addAll(_o_.unreceivedsortids);
/* 450 */       return unreceivedsortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 457 */       LoginInfo.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 464 */       LoginInfo.this._xdb_verify_unsafe_();
/* 465 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 471 */       LoginInfo.this._xdb_verify_unsafe_();
/* 472 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 478 */       return LoginInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 484 */       return LoginInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 490 */       LoginInfo.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 497 */       return LoginInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 503 */       return LoginInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 509 */       LoginInfo.this._xdb_verify_unsafe_();
/* 510 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 516 */       return LoginInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 522 */       return LoginInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 528 */       return LoginInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 534 */       return LoginInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 540 */       return LoginInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 546 */       return LoginInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 552 */       return LoginInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LoginInfo
/*     */   {
/*     */     private long last_time;
/*     */     
/*     */     private HashSet<Integer> sortids;
/*     */     
/*     */     private HashSet<Integer> unreceivedsortids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 568 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 573 */       this.last_time = 0L;
/* 574 */       this.sortids = new HashSet();
/* 575 */       this.unreceivedsortids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.LoginInfo _o1_)
/*     */     {
/* 580 */       if ((_o1_ instanceof LoginInfo)) { assign((LoginInfo)_o1_);
/* 581 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 582 */       } else if ((_o1_ instanceof LoginInfo.Const)) assign(((LoginInfo.Const)_o1_).nThis()); else {
/* 583 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LoginInfo _o_) {
/* 588 */       this.last_time = _o_.last_time;
/* 589 */       this.sortids = new HashSet();
/* 590 */       this.sortids.addAll(_o_.sortids);
/* 591 */       this.unreceivedsortids = new HashSet();
/* 592 */       this.unreceivedsortids.addAll(_o_.unreceivedsortids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 597 */       this.last_time = _o_.last_time;
/* 598 */       this.sortids = new HashSet();
/* 599 */       this.sortids.addAll(_o_.sortids);
/* 600 */       this.unreceivedsortids = new HashSet();
/* 601 */       this.unreceivedsortids.addAll(_o_.unreceivedsortids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 607 */       _os_.marshal(this.last_time);
/* 608 */       _os_.compact_uint32(this.sortids.size());
/* 609 */       for (Integer _v_ : this.sortids)
/*     */       {
/* 611 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 613 */       _os_.compact_uint32(this.unreceivedsortids.size());
/* 614 */       for (Integer _v_ : this.unreceivedsortids)
/*     */       {
/* 616 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 618 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 624 */       this.last_time = _os_.unmarshal_long();
/* 625 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 627 */         int _v_ = 0;
/* 628 */         _v_ = _os_.unmarshal_int();
/* 629 */         this.sortids.add(Integer.valueOf(_v_));
/*     */       }
/* 631 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 633 */         int _v_ = 0;
/* 634 */         _v_ = _os_.unmarshal_int();
/* 635 */         this.unreceivedsortids.add(Integer.valueOf(_v_));
/*     */       }
/* 637 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 643 */       int _size_ = 0;
/* 644 */       _size_ += CodedOutputStream.computeInt64Size(1, this.last_time);
/* 645 */       for (Integer _v_ : this.sortids)
/*     */       {
/* 647 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 649 */       for (Integer _v_ : this.unreceivedsortids)
/*     */       {
/* 651 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 653 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 661 */         _output_.writeInt64(1, this.last_time);
/* 662 */         for (Integer _v_ : this.sortids)
/*     */         {
/* 664 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 666 */         for (Integer _v_ : this.unreceivedsortids)
/*     */         {
/* 668 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 673 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 675 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 683 */         boolean done = false;
/* 684 */         while (!done)
/*     */         {
/* 686 */           int tag = _input_.readTag();
/* 687 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 691 */             done = true;
/* 692 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 696 */             this.last_time = _input_.readInt64();
/* 697 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 701 */             int _v_ = 0;
/* 702 */             _v_ = _input_.readInt32();
/* 703 */             this.sortids.add(Integer.valueOf(_v_));
/* 704 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 708 */             int _v_ = 0;
/* 709 */             _v_ = _input_.readInt32();
/* 710 */             this.unreceivedsortids.add(Integer.valueOf(_v_));
/* 711 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 715 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 717 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 726 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 730 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 732 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginInfo copy()
/*     */     {
/* 738 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginInfo toData()
/*     */     {
/* 744 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LoginInfo toBean()
/*     */     {
/* 749 */       return new LoginInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginInfo toDataIf()
/*     */     {
/* 755 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LoginInfo toBeanIf()
/*     */     {
/* 760 */       return new LoginInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 766 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 770 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 774 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 778 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 782 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 786 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 790 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 797 */       return this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSortids()
/*     */     {
/* 804 */       return this.sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSortidsAsData()
/*     */     {
/* 811 */       return this.sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getUnreceivedsortids()
/*     */     {
/* 818 */       return this.unreceivedsortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getUnreceivedsortidsAsData()
/*     */     {
/* 825 */       return this.unreceivedsortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 832 */       this.last_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 838 */       if (!(_o1_ instanceof Data)) return false;
/* 839 */       Data _o_ = (Data)_o1_;
/* 840 */       if (this.last_time != _o_.last_time) return false;
/* 841 */       if (!this.sortids.equals(_o_.sortids)) return false;
/* 842 */       if (!this.unreceivedsortids.equals(_o_.unreceivedsortids)) return false;
/* 843 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 849 */       int _h_ = 0;
/* 850 */       _h_ = (int)(_h_ + this.last_time);
/* 851 */       _h_ += this.sortids.hashCode();
/* 852 */       _h_ += this.unreceivedsortids.hashCode();
/* 853 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 859 */       StringBuilder _sb_ = new StringBuilder();
/* 860 */       _sb_.append("(");
/* 861 */       _sb_.append(this.last_time);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append(this.sortids);
/* 864 */       _sb_.append(",");
/* 865 */       _sb_.append(this.unreceivedsortids);
/* 866 */       _sb_.append(")");
/* 867 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */