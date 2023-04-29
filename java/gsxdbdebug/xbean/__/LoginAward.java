/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class LoginAward extends XBean implements xbean.LoginAward
/*     */ {
/*     */   private long logintime;
/*     */   private int loginday;
/*     */   private ArrayList<Integer> dayawardlist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.logintime = 0L;
/*  23 */     this.loginday = 0;
/*  24 */     this.dayawardlist.clear();
/*     */   }
/*     */   
/*     */   LoginAward(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.logintime = 0L;
/*  31 */     this.loginday = 0;
/*  32 */     this.dayawardlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public LoginAward()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LoginAward(LoginAward _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LoginAward(xbean.LoginAward _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof LoginAward)) { assign((LoginAward)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LoginAward _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.logintime = _o_.logintime;
/*  58 */     this.loginday = _o_.loginday;
/*  59 */     this.dayawardlist = new ArrayList();
/*  60 */     this.dayawardlist.addAll(_o_.dayawardlist);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.logintime = _o_.logintime;
/*  66 */     this.loginday = _o_.loginday;
/*  67 */     this.dayawardlist = new ArrayList();
/*  68 */     this.dayawardlist.addAll(_o_.dayawardlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.logintime);
/*  76 */     _os_.marshal(this.loginday);
/*  77 */     _os_.compact_uint32(this.dayawardlist.size());
/*  78 */     for (Integer _v_ : this.dayawardlist)
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
/*  89 */     this.logintime = _os_.unmarshal_long();
/*  90 */     this.loginday = _os_.unmarshal_int();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _v_ = 0;
/*  94 */       _v_ = _os_.unmarshal_int();
/*  95 */       this.dayawardlist.add(Integer.valueOf(_v_));
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt64Size(1, this.logintime);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.loginday);
/* 107 */     for (Integer _v_ : this.dayawardlist)
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
/* 120 */       _output_.writeInt64(1, this.logintime);
/* 121 */       _output_.writeInt32(2, this.loginday);
/* 122 */       for (Integer _v_ : this.dayawardlist)
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
/* 153 */           this.logintime = _input_.readInt64();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 158 */           this.loginday = _input_.readInt32();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           int _v_ = 0;
/* 164 */           _v_ = _input_.readInt32();
/* 165 */           this.dayawardlist.add(Integer.valueOf(_v_));
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
/*     */   public xbean.LoginAward copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new LoginAward(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginAward toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginAward toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new LoginAward(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginAward toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginAward toBeanIf()
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
/*     */   public long getLogintime()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.logintime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLoginday()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.loginday;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getDayawardlist()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return xdb.Logs.logList(new LogKey(this, "dayawardlist"), this.dayawardlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getDayawardlistAsData()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/*     */     
/* 259 */     LoginAward _o_ = this;
/* 260 */     List<Integer> dayawardlist = new ArrayList();
/* 261 */     dayawardlist.addAll(_o_.dayawardlist);
/* 262 */     return dayawardlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLogintime(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new LogKey(this, "logintime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, LoginAward.this.logintime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             LoginAward.this.logintime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.logintime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLoginday(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "loginday")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, LoginAward.this.loginday)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             LoginAward.this.loginday = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.loginday = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     LoginAward _o_ = null;
/* 312 */     if ((_o1_ instanceof LoginAward)) { _o_ = (LoginAward)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (this.logintime != _o_.logintime) return false;
/* 316 */     if (this.loginday != _o_.loginday) return false;
/* 317 */     if (!this.dayawardlist.equals(_o_.dayawardlist)) return false;
/* 318 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     int _h_ = 0;
/* 326 */     _h_ = (int)(_h_ + this.logintime);
/* 327 */     _h_ += this.loginday;
/* 328 */     _h_ += this.dayawardlist.hashCode();
/* 329 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     StringBuilder _sb_ = new StringBuilder();
/* 337 */     _sb_.append("(");
/* 338 */     _sb_.append(this.logintime);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.loginday);
/* 341 */     _sb_.append(",");
/* 342 */     _sb_.append(this.dayawardlist);
/* 343 */     _sb_.append(")");
/* 344 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 350 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 351 */     lb.add(new ListenableChanged().setVarName("logintime"));
/* 352 */     lb.add(new ListenableChanged().setVarName("loginday"));
/* 353 */     lb.add(new ListenableChanged().setVarName("dayawardlist"));
/* 354 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LoginAward {
/*     */     private Const() {}
/*     */     
/*     */     LoginAward nThis() {
/* 361 */       return LoginAward.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginAward copy()
/*     */     {
/* 373 */       return LoginAward.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginAward toData()
/*     */     {
/* 379 */       return LoginAward.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LoginAward toBean()
/*     */     {
/* 384 */       return LoginAward.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginAward toDataIf()
/*     */     {
/* 390 */       return LoginAward.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LoginAward toBeanIf()
/*     */     {
/* 395 */       return LoginAward.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLogintime()
/*     */     {
/* 402 */       LoginAward.this._xdb_verify_unsafe_();
/* 403 */       return LoginAward.this.logintime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLoginday()
/*     */     {
/* 410 */       LoginAward.this._xdb_verify_unsafe_();
/* 411 */       return LoginAward.this.loginday;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getDayawardlist()
/*     */     {
/* 418 */       LoginAward.this._xdb_verify_unsafe_();
/* 419 */       return xdb.Consts.constList(LoginAward.this.dayawardlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getDayawardlistAsData()
/*     */     {
/* 425 */       LoginAward.this._xdb_verify_unsafe_();
/*     */       
/* 427 */       LoginAward _o_ = LoginAward.this;
/* 428 */       List<Integer> dayawardlist = new ArrayList();
/* 429 */       dayawardlist.addAll(_o_.dayawardlist);
/* 430 */       return dayawardlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLogintime(long _v_)
/*     */     {
/* 437 */       LoginAward.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLoginday(int _v_)
/*     */     {
/* 445 */       LoginAward.this._xdb_verify_unsafe_();
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 452 */       LoginAward.this._xdb_verify_unsafe_();
/* 453 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 459 */       LoginAward.this._xdb_verify_unsafe_();
/* 460 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 466 */       return LoginAward.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 472 */       return LoginAward.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 478 */       LoginAward.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 485 */       return LoginAward.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 491 */       return LoginAward.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 497 */       LoginAward.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 504 */       return LoginAward.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 510 */       return LoginAward.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 516 */       return LoginAward.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 522 */       return LoginAward.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 528 */       return LoginAward.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 534 */       return LoginAward.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 540 */       return LoginAward.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LoginAward
/*     */   {
/*     */     private long logintime;
/*     */     
/*     */     private int loginday;
/*     */     
/*     */     private ArrayList<Integer> dayawardlist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 561 */       this.logintime = 0L;
/* 562 */       this.loginday = 0;
/* 563 */       this.dayawardlist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.LoginAward _o1_)
/*     */     {
/* 568 */       if ((_o1_ instanceof LoginAward)) { assign((LoginAward)_o1_);
/* 569 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 570 */       } else if ((_o1_ instanceof LoginAward.Const)) assign(((LoginAward.Const)_o1_).nThis()); else {
/* 571 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LoginAward _o_) {
/* 576 */       this.logintime = _o_.logintime;
/* 577 */       this.loginday = _o_.loginday;
/* 578 */       this.dayawardlist = new ArrayList();
/* 579 */       this.dayawardlist.addAll(_o_.dayawardlist);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 584 */       this.logintime = _o_.logintime;
/* 585 */       this.loginday = _o_.loginday;
/* 586 */       this.dayawardlist = new ArrayList();
/* 587 */       this.dayawardlist.addAll(_o_.dayawardlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 593 */       _os_.marshal(this.logintime);
/* 594 */       _os_.marshal(this.loginday);
/* 595 */       _os_.compact_uint32(this.dayawardlist.size());
/* 596 */       for (Integer _v_ : this.dayawardlist)
/*     */       {
/* 598 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 600 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 606 */       this.logintime = _os_.unmarshal_long();
/* 607 */       this.loginday = _os_.unmarshal_int();
/* 608 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 610 */         int _v_ = 0;
/* 611 */         _v_ = _os_.unmarshal_int();
/* 612 */         this.dayawardlist.add(Integer.valueOf(_v_));
/*     */       }
/* 614 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 620 */       int _size_ = 0;
/* 621 */       _size_ += CodedOutputStream.computeInt64Size(1, this.logintime);
/* 622 */       _size_ += CodedOutputStream.computeInt32Size(2, this.loginday);
/* 623 */       for (Integer _v_ : this.dayawardlist)
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
/* 635 */         _output_.writeInt64(1, this.logintime);
/* 636 */         _output_.writeInt32(2, this.loginday);
/* 637 */         for (Integer _v_ : this.dayawardlist)
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
/* 667 */             this.logintime = _input_.readInt64();
/* 668 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 672 */             this.loginday = _input_.readInt32();
/* 673 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 677 */             int _v_ = 0;
/* 678 */             _v_ = _input_.readInt32();
/* 679 */             this.dayawardlist.add(Integer.valueOf(_v_));
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
/*     */     public xbean.LoginAward copy()
/*     */     {
/* 707 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginAward toData()
/*     */     {
/* 713 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LoginAward toBean()
/*     */     {
/* 718 */       return new LoginAward(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginAward toDataIf()
/*     */     {
/* 724 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LoginAward toBeanIf()
/*     */     {
/* 729 */       return new LoginAward(this, null, null);
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
/*     */     public long getLogintime()
/*     */     {
/* 766 */       return this.logintime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLoginday()
/*     */     {
/* 773 */       return this.loginday;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getDayawardlist()
/*     */     {
/* 780 */       return this.dayawardlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getDayawardlistAsData()
/*     */     {
/* 787 */       return this.dayawardlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLogintime(long _v_)
/*     */     {
/* 794 */       this.logintime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLoginday(int _v_)
/*     */     {
/* 801 */       this.loginday = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 807 */       if (!(_o1_ instanceof Data)) return false;
/* 808 */       Data _o_ = (Data)_o1_;
/* 809 */       if (this.logintime != _o_.logintime) return false;
/* 810 */       if (this.loginday != _o_.loginday) return false;
/* 811 */       if (!this.dayawardlist.equals(_o_.dayawardlist)) return false;
/* 812 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 818 */       int _h_ = 0;
/* 819 */       _h_ = (int)(_h_ + this.logintime);
/* 820 */       _h_ += this.loginday;
/* 821 */       _h_ += this.dayawardlist.hashCode();
/* 822 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 828 */       StringBuilder _sb_ = new StringBuilder();
/* 829 */       _sb_.append("(");
/* 830 */       _sb_.append(this.logintime);
/* 831 */       _sb_.append(",");
/* 832 */       _sb_.append(this.loginday);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.dayawardlist);
/* 835 */       _sb_.append(")");
/* 836 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LoginAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */