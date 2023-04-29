/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class LoginSignInfo extends XBean implements xbean.LoginSignInfo
/*     */ {
/*     */   private long last_time;
/*     */   private int sortid;
/*     */   private long start_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.last_time = 0L;
/*  23 */     this.sortid = 0;
/*  24 */     this.start_time = 0L;
/*     */   }
/*     */   
/*     */   LoginSignInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.last_time = 0L;
/*     */   }
/*     */   
/*     */   public LoginSignInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LoginSignInfo(LoginSignInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LoginSignInfo(xbean.LoginSignInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof LoginSignInfo)) { assign((LoginSignInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LoginSignInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.last_time = _o_.last_time;
/*  56 */     this.sortid = _o_.sortid;
/*  57 */     this.start_time = _o_.start_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.last_time = _o_.last_time;
/*  63 */     this.sortid = _o_.sortid;
/*  64 */     this.start_time = _o_.start_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.last_time);
/*  72 */     _os_.marshal(this.sortid);
/*  73 */     _os_.marshal(this.start_time);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.last_time = _os_.unmarshal_long();
/*  82 */     this.sortid = _os_.unmarshal_int();
/*  83 */     this.start_time = _os_.unmarshal_long();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(1, this.last_time);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.sortid);
/*  94 */     _size_ += CodedOutputStream.computeInt64Size(3, this.start_time);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt64(1, this.last_time);
/* 105 */       _output_.writeInt32(2, this.sortid);
/* 106 */       _output_.writeInt64(3, this.start_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.last_time = _input_.readInt64();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.sortid = _input_.readInt32();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.start_time = _input_.readInt64();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginSignInfo copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new LoginSignInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginSignInfo toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginSignInfo toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new LoginSignInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LoginSignInfo toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LoginSignInfo toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLast_time()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.last_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSortid()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStart_time()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.start_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_time(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "last_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogLong(this, LoginSignInfo.this.last_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             LoginSignInfo.this.last_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.last_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSortid(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "sortid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, LoginSignInfo.this.sortid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             LoginSignInfo.this.sortid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.sortid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStart_time(long _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "start_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new xdb.logs.LogLong(this, LoginSignInfo.this.start_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             LoginSignInfo.this.start_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.start_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     LoginSignInfo _o_ = null;
/* 301 */     if ((_o1_ instanceof LoginSignInfo)) { _o_ = (LoginSignInfo)_o1_;
/* 302 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 303 */       return false;
/* 304 */     if (this.last_time != _o_.last_time) return false;
/* 305 */     if (this.sortid != _o_.sortid) return false;
/* 306 */     if (this.start_time != _o_.start_time) return false;
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     int _h_ = 0;
/* 315 */     _h_ = (int)(_h_ + this.last_time);
/* 316 */     _h_ += this.sortid;
/* 317 */     _h_ = (int)(_h_ + this.start_time);
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.last_time);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.sortid);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.start_time);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("last_time"));
/* 341 */     lb.add(new ListenableChanged().setVarName("sortid"));
/* 342 */     lb.add(new ListenableChanged().setVarName("start_time"));
/* 343 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LoginSignInfo {
/*     */     private Const() {}
/*     */     
/*     */     LoginSignInfo nThis() {
/* 350 */       return LoginSignInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSignInfo copy()
/*     */     {
/* 362 */       return LoginSignInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSignInfo toData()
/*     */     {
/* 368 */       return LoginSignInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LoginSignInfo toBean()
/*     */     {
/* 373 */       return LoginSignInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSignInfo toDataIf()
/*     */     {
/* 379 */       return LoginSignInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LoginSignInfo toBeanIf()
/*     */     {
/* 384 */       return LoginSignInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 391 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 392 */       return LoginSignInfo.this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 399 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 400 */       return LoginSignInfo.this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 407 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 408 */       return LoginSignInfo.this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 415 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 423 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 431 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 438 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 439 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 445 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 446 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 452 */       return LoginSignInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 458 */       return LoginSignInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 471 */       return LoginSignInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 477 */       return LoginSignInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 483 */       LoginSignInfo.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 490 */       return LoginSignInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 496 */       return LoginSignInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 502 */       return LoginSignInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 508 */       return LoginSignInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 514 */       return LoginSignInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 520 */       return LoginSignInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 526 */       return LoginSignInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LoginSignInfo
/*     */   {
/*     */     private long last_time;
/*     */     
/*     */     private int sortid;
/*     */     
/*     */     private long start_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 547 */       this.last_time = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.LoginSignInfo _o1_)
/*     */     {
/* 552 */       if ((_o1_ instanceof LoginSignInfo)) { assign((LoginSignInfo)_o1_);
/* 553 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 554 */       } else if ((_o1_ instanceof LoginSignInfo.Const)) assign(((LoginSignInfo.Const)_o1_).nThis()); else {
/* 555 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LoginSignInfo _o_) {
/* 560 */       this.last_time = _o_.last_time;
/* 561 */       this.sortid = _o_.sortid;
/* 562 */       this.start_time = _o_.start_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 567 */       this.last_time = _o_.last_time;
/* 568 */       this.sortid = _o_.sortid;
/* 569 */       this.start_time = _o_.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 575 */       _os_.marshal(this.last_time);
/* 576 */       _os_.marshal(this.sortid);
/* 577 */       _os_.marshal(this.start_time);
/* 578 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 584 */       this.last_time = _os_.unmarshal_long();
/* 585 */       this.sortid = _os_.unmarshal_int();
/* 586 */       this.start_time = _os_.unmarshal_long();
/* 587 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 593 */       int _size_ = 0;
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(1, this.last_time);
/* 595 */       _size_ += CodedOutputStream.computeInt32Size(2, this.sortid);
/* 596 */       _size_ += CodedOutputStream.computeInt64Size(3, this.start_time);
/* 597 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 605 */         _output_.writeInt64(1, this.last_time);
/* 606 */         _output_.writeInt32(2, this.sortid);
/* 607 */         _output_.writeInt64(3, this.start_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 634 */             this.last_time = _input_.readInt64();
/* 635 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 639 */             this.sortid = _input_.readInt32();
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.start_time = _input_.readInt64();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSignInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSignInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LoginSignInfo toBean()
/*     */     {
/* 683 */       return new LoginSignInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LoginSignInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LoginSignInfo toBeanIf()
/*     */     {
/* 694 */       return new LoginSignInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 731 */       return this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 738 */       return this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 745 */       return this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 752 */       this.last_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 759 */       this.sortid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 766 */       this.start_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 772 */       if (!(_o1_ instanceof Data)) return false;
/* 773 */       Data _o_ = (Data)_o1_;
/* 774 */       if (this.last_time != _o_.last_time) return false;
/* 775 */       if (this.sortid != _o_.sortid) return false;
/* 776 */       if (this.start_time != _o_.start_time) return false;
/* 777 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 783 */       int _h_ = 0;
/* 784 */       _h_ = (int)(_h_ + this.last_time);
/* 785 */       _h_ += this.sortid;
/* 786 */       _h_ = (int)(_h_ + this.start_time);
/* 787 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 793 */       StringBuilder _sb_ = new StringBuilder();
/* 794 */       _sb_.append("(");
/* 795 */       _sb_.append(this.last_time);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.sortid);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.start_time);
/* 800 */       _sb_.append(")");
/* 801 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LoginSignInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */