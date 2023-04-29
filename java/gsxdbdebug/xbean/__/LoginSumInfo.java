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
/*     */ public final class LoginSumInfo extends XBean implements xbean.LoginSumInfo
/*     */ {
/*     */   private long last_time;
/*     */   private int login_days;
/*     */   private SetX<Integer> sortids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.last_time = 0L;
/*  23 */     this.login_days = 0;
/*  24 */     this.sortids.clear();
/*     */   }
/*     */   
/*     */   LoginSumInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.last_time = 0L;
/*  31 */     this.login_days = 0;
/*  32 */     this.sortids = new SetX();
/*     */   }
/*     */   
/*     */   public LoginSumInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LoginSumInfo(LoginSumInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LoginSumInfo(xbean.LoginSumInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof LoginSumInfo)) { assign((LoginSumInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LoginSumInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.last_time = _o_.last_time;
/*  58 */     this.login_days = _o_.login_days;
/*  59 */     this.sortids = new SetX();
/*  60 */     this.sortids.addAll(_o_.sortids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.last_time = _o_.last_time;
/*  66 */     this.login_days = _o_.login_days;
/*  67 */     this.sortids = new SetX();
/*  68 */     this.sortids.addAll(_o_.sortids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.last_time);
/*  76 */     _os_.marshal(this.login_days);
/*  77 */     _os_.compact_uint32(this.sortids.size());
/*  78 */     for (Integer _v_ : this.sortids)
/*     */     {
/*  80 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  88 */     _xdb_verify_unsafe_();
/*  89 */     this.last_time = _os_.unmarshal_long();
/*  90 */     this.login_days = _os_.unmarshal_int();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _v_ = 0;
/*  94 */       _v_ = _os_.unmarshal_int();
/*  95 */       this.sortids.add(Integer.valueOf(_v_));
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt64Size(1, this.last_time);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.login_days);
/* 107 */     for (Integer _v_ : this.sortids)
/*     */     {
/* 109 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 111 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       _output_.writeInt64(1, this.last_time);
/* 121 */       _output_.writeInt32(2, this.login_days);
/* 122 */       for (Integer _v_ : this.sortids)
/*     */       {
/* 124 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 129 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 131 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       boolean done = false;
/* 141 */       while (!done)
/*     */       {
/* 143 */         int tag = _input_.readTag();
/* 144 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 148 */           done = true;
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 153 */           this.last_time = _input_.readInt64();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 158 */           this.login_days = _input_.readInt32();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           int _v_ = 0;
/* 164 */           _v_ = _input_.readInt32();
/* 165 */           this.sortids.add(Integer.valueOf(_v_));
/* 166 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 170 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 172 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 181 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 185 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 187 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginSumInfo copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new LoginSumInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginSumInfo toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginSumInfo toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new LoginSumInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginSumInfo toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginSumInfo toBeanIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLast_time()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.last_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLogin_days()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.login_days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getSortids()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return xdb.Logs.logSet(new LogKey(this, "sortids"), this.sortids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getSortidsAsData()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/*     */     
/* 259 */     LoginSumInfo _o_ = this;
/* 260 */     Set<Integer> sortids = new SetX();
/* 261 */     sortids.addAll(_o_.sortids);
/* 262 */     return sortids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_time(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new LogKey(this, "last_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, LoginSumInfo.this.last_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             LoginSumInfo.this.last_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.last_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLogin_days(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "login_days")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, LoginSumInfo.this.login_days)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             LoginSumInfo.this.login_days = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.login_days = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     LoginSumInfo _o_ = null;
/* 312 */     if ((_o1_ instanceof LoginSumInfo)) { _o_ = (LoginSumInfo)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (this.last_time != _o_.last_time) return false;
/* 316 */     if (this.login_days != _o_.login_days) return false;
/* 317 */     if (!this.sortids.equals(_o_.sortids)) return false;
/* 318 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     int _h_ = 0;
/* 326 */     _h_ = (int)(_h_ + this.last_time);
/* 327 */     _h_ += this.login_days;
/* 328 */     _h_ += this.sortids.hashCode();
/* 329 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     StringBuilder _sb_ = new StringBuilder();
/* 337 */     _sb_.append("(");
/* 338 */     _sb_.append(this.last_time);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.login_days);
/* 341 */     _sb_.append(",");
/* 342 */     _sb_.append(this.sortids);
/* 343 */     _sb_.append(")");
/* 344 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 350 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 351 */     lb.add(new xdb.logs.ListenableChanged().setVarName("last_time"));
/* 352 */     lb.add(new xdb.logs.ListenableChanged().setVarName("login_days"));
/* 353 */     lb.add(new xdb.logs.ListenableSet().setVarName("sortids"));
/* 354 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LoginSumInfo {
/*     */     private Const() {}
/*     */     
/*     */     LoginSumInfo nThis() {
/* 361 */       return LoginSumInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSumInfo copy()
/*     */     {
/* 373 */       return LoginSumInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSumInfo toData()
/*     */     {
/* 379 */       return LoginSumInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LoginSumInfo toBean()
/*     */     {
/* 384 */       return LoginSumInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSumInfo toDataIf()
/*     */     {
/* 390 */       return LoginSumInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LoginSumInfo toBeanIf()
/*     */     {
/* 395 */       return LoginSumInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 402 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 403 */       return LoginSumInfo.this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLogin_days()
/*     */     {
/* 410 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 411 */       return LoginSumInfo.this.login_days;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSortids()
/*     */     {
/* 418 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 419 */       return xdb.Consts.constSet(LoginSumInfo.this.sortids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getSortidsAsData()
/*     */     {
/* 425 */       LoginSumInfo.this._xdb_verify_unsafe_();
/*     */       
/* 427 */       LoginSumInfo _o_ = LoginSumInfo.this;
/* 428 */       Set<Integer> sortids = new SetX();
/* 429 */       sortids.addAll(_o_.sortids);
/* 430 */       return sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 437 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLogin_days(int _v_)
/*     */     {
/* 445 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 452 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 453 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 459 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 460 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 466 */       return LoginSumInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 472 */       return LoginSumInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 478 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 485 */       return LoginSumInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 491 */       return LoginSumInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 497 */       LoginSumInfo.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 504 */       return LoginSumInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 510 */       return LoginSumInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 516 */       return LoginSumInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 522 */       return LoginSumInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 528 */       return LoginSumInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 534 */       return LoginSumInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 540 */       return LoginSumInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LoginSumInfo
/*     */   {
/*     */     private long last_time;
/*     */     
/*     */     private int login_days;
/*     */     
/*     */     private HashSet<Integer> sortids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 561 */       this.last_time = 0L;
/* 562 */       this.login_days = 0;
/* 563 */       this.sortids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.LoginSumInfo _o1_)
/*     */     {
/* 568 */       if ((_o1_ instanceof LoginSumInfo)) { assign((LoginSumInfo)_o1_);
/* 569 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 570 */       } else if ((_o1_ instanceof LoginSumInfo.Const)) assign(((LoginSumInfo.Const)_o1_).nThis()); else {
/* 571 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LoginSumInfo _o_) {
/* 576 */       this.last_time = _o_.last_time;
/* 577 */       this.login_days = _o_.login_days;
/* 578 */       this.sortids = new HashSet();
/* 579 */       this.sortids.addAll(_o_.sortids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 584 */       this.last_time = _o_.last_time;
/* 585 */       this.login_days = _o_.login_days;
/* 586 */       this.sortids = new HashSet();
/* 587 */       this.sortids.addAll(_o_.sortids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 593 */       _os_.marshal(this.last_time);
/* 594 */       _os_.marshal(this.login_days);
/* 595 */       _os_.compact_uint32(this.sortids.size());
/* 596 */       for (Integer _v_ : this.sortids)
/*     */       {
/* 598 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 600 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 606 */       this.last_time = _os_.unmarshal_long();
/* 607 */       this.login_days = _os_.unmarshal_int();
/* 608 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 610 */         int _v_ = 0;
/* 611 */         _v_ = _os_.unmarshal_int();
/* 612 */         this.sortids.add(Integer.valueOf(_v_));
/*     */       }
/* 614 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 620 */       int _size_ = 0;
/* 621 */       _size_ += CodedOutputStream.computeInt64Size(1, this.last_time);
/* 622 */       _size_ += CodedOutputStream.computeInt32Size(2, this.login_days);
/* 623 */       for (Integer _v_ : this.sortids)
/*     */       {
/* 625 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 627 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 635 */         _output_.writeInt64(1, this.last_time);
/* 636 */         _output_.writeInt32(2, this.login_days);
/* 637 */         for (Integer _v_ : this.sortids)
/*     */         {
/* 639 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 644 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 646 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 654 */         boolean done = false;
/* 655 */         while (!done)
/*     */         {
/* 657 */           int tag = _input_.readTag();
/* 658 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 662 */             done = true;
/* 663 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 667 */             this.last_time = _input_.readInt64();
/* 668 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 672 */             this.login_days = _input_.readInt32();
/* 673 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 677 */             int _v_ = 0;
/* 678 */             _v_ = _input_.readInt32();
/* 679 */             this.sortids.add(Integer.valueOf(_v_));
/* 680 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 684 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 686 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 695 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 699 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 701 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSumInfo copy()
/*     */     {
/* 707 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSumInfo toData()
/*     */     {
/* 713 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LoginSumInfo toBean()
/*     */     {
/* 718 */       return new LoginSumInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSumInfo toDataIf()
/*     */     {
/* 724 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LoginSumInfo toBeanIf()
/*     */     {
/* 729 */       return new LoginSumInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 751 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 755 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 759 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 766 */       return this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLogin_days()
/*     */     {
/* 773 */       return this.login_days;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSortids()
/*     */     {
/* 780 */       return this.sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSortidsAsData()
/*     */     {
/* 787 */       return this.sortids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 794 */       this.last_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLogin_days(int _v_)
/*     */     {
/* 801 */       this.login_days = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 807 */       if (!(_o1_ instanceof Data)) return false;
/* 808 */       Data _o_ = (Data)_o1_;
/* 809 */       if (this.last_time != _o_.last_time) return false;
/* 810 */       if (this.login_days != _o_.login_days) return false;
/* 811 */       if (!this.sortids.equals(_o_.sortids)) return false;
/* 812 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 818 */       int _h_ = 0;
/* 819 */       _h_ = (int)(_h_ + this.last_time);
/* 820 */       _h_ += this.login_days;
/* 821 */       _h_ += this.sortids.hashCode();
/* 822 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 828 */       StringBuilder _sb_ = new StringBuilder();
/* 829 */       _sb_.append("(");
/* 830 */       _sb_.append(this.last_time);
/* 831 */       _sb_.append(",");
/* 832 */       _sb_.append(this.login_days);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.sortids);
/* 835 */       _sb_.append(")");
/* 836 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LoginSumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */