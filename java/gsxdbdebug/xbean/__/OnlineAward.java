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
/*     */ public final class OnlineAward extends XBean implements xbean.OnlineAward
/*     */ {
/*     */   private long logintime;
/*     */   private long onlinetime;
/*     */   private ArrayList<Integer> onlineawardlist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.logintime = 0L;
/*  23 */     this.onlinetime = 0L;
/*  24 */     this.onlineawardlist.clear();
/*     */   }
/*     */   
/*     */   OnlineAward(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.logintime = 0L;
/*  31 */     this.onlinetime = 0L;
/*  32 */     this.onlineawardlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public OnlineAward()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public OnlineAward(OnlineAward _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   OnlineAward(xbean.OnlineAward _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof OnlineAward)) { assign((OnlineAward)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(OnlineAward _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.logintime = _o_.logintime;
/*  58 */     this.onlinetime = _o_.onlinetime;
/*  59 */     this.onlineawardlist = new ArrayList();
/*  60 */     this.onlineawardlist.addAll(_o_.onlineawardlist);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.logintime = _o_.logintime;
/*  66 */     this.onlinetime = _o_.onlinetime;
/*  67 */     this.onlineawardlist = new ArrayList();
/*  68 */     this.onlineawardlist.addAll(_o_.onlineawardlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.logintime);
/*  76 */     _os_.marshal(this.onlinetime);
/*  77 */     _os_.compact_uint32(this.onlineawardlist.size());
/*  78 */     for (Integer _v_ : this.onlineawardlist)
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
/*  90 */     this.onlinetime = _os_.unmarshal_long();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _v_ = 0;
/*  94 */       _v_ = _os_.unmarshal_int();
/*  95 */       this.onlineawardlist.add(Integer.valueOf(_v_));
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
/* 106 */     _size_ += CodedOutputStream.computeInt64Size(2, this.onlinetime);
/* 107 */     for (Integer _v_ : this.onlineawardlist)
/*     */     {
/* 109 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
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
/* 121 */       _output_.writeInt64(2, this.onlinetime);
/* 122 */       for (Integer _v_ : this.onlineawardlist)
/*     */       {
/* 124 */         _output_.writeInt32(4, _v_.intValue());
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
/* 158 */           this.onlinetime = _input_.readInt64();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 163 */           int _v_ = 0;
/* 164 */           _v_ = _input_.readInt32();
/* 165 */           this.onlineawardlist.add(Integer.valueOf(_v_));
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
/*     */   public xbean.OnlineAward copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new OnlineAward(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.OnlineAward toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.OnlineAward toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new OnlineAward(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.OnlineAward toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.OnlineAward toBeanIf()
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
/*     */   public long getOnlinetime()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.onlinetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getOnlineawardlist()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return xdb.Logs.logList(new LogKey(this, "onlineawardlist"), this.onlineawardlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getOnlineawardlistAsData()
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/*     */     
/* 259 */     OnlineAward _o_ = this;
/* 260 */     List<Integer> onlineawardlist = new ArrayList();
/* 261 */     onlineawardlist.addAll(_o_.onlineawardlist);
/* 262 */     return onlineawardlist;
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
/* 274 */         new xdb.logs.LogLong(this, OnlineAward.this.logintime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             OnlineAward.this.logintime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.logintime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOnlinetime(long _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "onlinetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogLong(this, OnlineAward.this.onlinetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             OnlineAward.this.onlinetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.onlinetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     OnlineAward _o_ = null;
/* 312 */     if ((_o1_ instanceof OnlineAward)) { _o_ = (OnlineAward)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (this.logintime != _o_.logintime) return false;
/* 316 */     if (this.onlinetime != _o_.onlinetime) return false;
/* 317 */     if (!this.onlineawardlist.equals(_o_.onlineawardlist)) return false;
/* 318 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     int _h_ = 0;
/* 326 */     _h_ = (int)(_h_ + this.logintime);
/* 327 */     _h_ = (int)(_h_ + this.onlinetime);
/* 328 */     _h_ += this.onlineawardlist.hashCode();
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
/* 340 */     _sb_.append(this.onlinetime);
/* 341 */     _sb_.append(",");
/* 342 */     _sb_.append(this.onlineawardlist);
/* 343 */     _sb_.append(")");
/* 344 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 350 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 351 */     lb.add(new ListenableChanged().setVarName("logintime"));
/* 352 */     lb.add(new ListenableChanged().setVarName("onlinetime"));
/* 353 */     lb.add(new ListenableChanged().setVarName("onlineawardlist"));
/* 354 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.OnlineAward {
/*     */     private Const() {}
/*     */     
/*     */     OnlineAward nThis() {
/* 361 */       return OnlineAward.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineAward copy()
/*     */     {
/* 373 */       return OnlineAward.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineAward toData()
/*     */     {
/* 379 */       return OnlineAward.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.OnlineAward toBean()
/*     */     {
/* 384 */       return OnlineAward.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineAward toDataIf()
/*     */     {
/* 390 */       return OnlineAward.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.OnlineAward toBeanIf()
/*     */     {
/* 395 */       return OnlineAward.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLogintime()
/*     */     {
/* 402 */       OnlineAward.this._xdb_verify_unsafe_();
/* 403 */       return OnlineAward.this.logintime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOnlinetime()
/*     */     {
/* 410 */       OnlineAward.this._xdb_verify_unsafe_();
/* 411 */       return OnlineAward.this.onlinetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getOnlineawardlist()
/*     */     {
/* 418 */       OnlineAward.this._xdb_verify_unsafe_();
/* 419 */       return xdb.Consts.constList(OnlineAward.this.onlineawardlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getOnlineawardlistAsData()
/*     */     {
/* 425 */       OnlineAward.this._xdb_verify_unsafe_();
/*     */       
/* 427 */       OnlineAward _o_ = OnlineAward.this;
/* 428 */       List<Integer> onlineawardlist = new ArrayList();
/* 429 */       onlineawardlist.addAll(_o_.onlineawardlist);
/* 430 */       return onlineawardlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLogintime(long _v_)
/*     */     {
/* 437 */       OnlineAward.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOnlinetime(long _v_)
/*     */     {
/* 445 */       OnlineAward.this._xdb_verify_unsafe_();
/* 446 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 452 */       OnlineAward.this._xdb_verify_unsafe_();
/* 453 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 459 */       OnlineAward.this._xdb_verify_unsafe_();
/* 460 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 466 */       return OnlineAward.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 472 */       return OnlineAward.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 478 */       OnlineAward.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 485 */       return OnlineAward.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 491 */       return OnlineAward.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 497 */       OnlineAward.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 504 */       return OnlineAward.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 510 */       return OnlineAward.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 516 */       return OnlineAward.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 522 */       return OnlineAward.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 528 */       return OnlineAward.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 534 */       return OnlineAward.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 540 */       return OnlineAward.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.OnlineAward
/*     */   {
/*     */     private long logintime;
/*     */     
/*     */     private long onlinetime;
/*     */     
/*     */     private ArrayList<Integer> onlineawardlist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 561 */       this.logintime = 0L;
/* 562 */       this.onlinetime = 0L;
/* 563 */       this.onlineawardlist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.OnlineAward _o1_)
/*     */     {
/* 568 */       if ((_o1_ instanceof OnlineAward)) { assign((OnlineAward)_o1_);
/* 569 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 570 */       } else if ((_o1_ instanceof OnlineAward.Const)) assign(((OnlineAward.Const)_o1_).nThis()); else {
/* 571 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(OnlineAward _o_) {
/* 576 */       this.logintime = _o_.logintime;
/* 577 */       this.onlinetime = _o_.onlinetime;
/* 578 */       this.onlineawardlist = new ArrayList();
/* 579 */       this.onlineawardlist.addAll(_o_.onlineawardlist);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 584 */       this.logintime = _o_.logintime;
/* 585 */       this.onlinetime = _o_.onlinetime;
/* 586 */       this.onlineawardlist = new ArrayList();
/* 587 */       this.onlineawardlist.addAll(_o_.onlineawardlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 593 */       _os_.marshal(this.logintime);
/* 594 */       _os_.marshal(this.onlinetime);
/* 595 */       _os_.compact_uint32(this.onlineawardlist.size());
/* 596 */       for (Integer _v_ : this.onlineawardlist)
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
/* 607 */       this.onlinetime = _os_.unmarshal_long();
/* 608 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 610 */         int _v_ = 0;
/* 611 */         _v_ = _os_.unmarshal_int();
/* 612 */         this.onlineawardlist.add(Integer.valueOf(_v_));
/*     */       }
/* 614 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 620 */       int _size_ = 0;
/* 621 */       _size_ += CodedOutputStream.computeInt64Size(1, this.logintime);
/* 622 */       _size_ += CodedOutputStream.computeInt64Size(2, this.onlinetime);
/* 623 */       for (Integer _v_ : this.onlineawardlist)
/*     */       {
/* 625 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
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
/* 636 */         _output_.writeInt64(2, this.onlinetime);
/* 637 */         for (Integer _v_ : this.onlineawardlist)
/*     */         {
/* 639 */           _output_.writeInt32(4, _v_.intValue());
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
/* 672 */             this.onlinetime = _input_.readInt64();
/* 673 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 677 */             int _v_ = 0;
/* 678 */             _v_ = _input_.readInt32();
/* 679 */             this.onlineawardlist.add(Integer.valueOf(_v_));
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
/*     */     public xbean.OnlineAward copy()
/*     */     {
/* 707 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineAward toData()
/*     */     {
/* 713 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.OnlineAward toBean()
/*     */     {
/* 718 */       return new OnlineAward(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineAward toDataIf()
/*     */     {
/* 724 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.OnlineAward toBeanIf()
/*     */     {
/* 729 */       return new OnlineAward(this, null, null);
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
/*     */     public long getOnlinetime()
/*     */     {
/* 773 */       return this.onlinetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getOnlineawardlist()
/*     */     {
/* 780 */       return this.onlineawardlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getOnlineawardlistAsData()
/*     */     {
/* 787 */       return this.onlineawardlist;
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
/*     */     public void setOnlinetime(long _v_)
/*     */     {
/* 801 */       this.onlinetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 807 */       if (!(_o1_ instanceof Data)) return false;
/* 808 */       Data _o_ = (Data)_o1_;
/* 809 */       if (this.logintime != _o_.logintime) return false;
/* 810 */       if (this.onlinetime != _o_.onlinetime) return false;
/* 811 */       if (!this.onlineawardlist.equals(_o_.onlineawardlist)) return false;
/* 812 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 818 */       int _h_ = 0;
/* 819 */       _h_ = (int)(_h_ + this.logintime);
/* 820 */       _h_ = (int)(_h_ + this.onlinetime);
/* 821 */       _h_ += this.onlineawardlist.hashCode();
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
/* 832 */       _sb_.append(this.onlinetime);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.onlineawardlist);
/* 835 */       _sb_.append(")");
/* 836 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\OnlineAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */