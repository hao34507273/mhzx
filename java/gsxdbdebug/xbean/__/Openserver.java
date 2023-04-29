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
/*     */ 
/*     */ public final class Openserver extends XBean implements xbean.Openserver
/*     */ {
/*     */   private ArrayList<Integer> awardeddays;
/*     */   private long signtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.awardeddays.clear();
/*  21 */     this.signtime = 0L;
/*     */   }
/*     */   
/*     */   Openserver(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.awardeddays = new ArrayList();
/*  28 */     this.signtime = 0L;
/*     */   }
/*     */   
/*     */   public Openserver()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Openserver(Openserver _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Openserver(xbean.Openserver _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof Openserver)) { assign((Openserver)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Openserver _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.awardeddays = new ArrayList();
/*  54 */     this.awardeddays.addAll(_o_.awardeddays);
/*  55 */     this.signtime = _o_.signtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.awardeddays = new ArrayList();
/*  61 */     this.awardeddays.addAll(_o_.awardeddays);
/*  62 */     this.signtime = _o_.signtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     _os_.compact_uint32(this.awardeddays.size());
/*  70 */     for (Integer _v_ : this.awardeddays)
/*     */     {
/*  72 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  74 */     _os_.marshal(this.signtime);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       int _v_ = 0;
/*  85 */       _v_ = _os_.unmarshal_int();
/*  86 */       this.awardeddays.add(Integer.valueOf(_v_));
/*     */     }
/*  88 */     this.signtime = _os_.unmarshal_long();
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     int _size_ = 0;
/*  97 */     for (Integer _v_ : this.awardeddays)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(2, this.signtime);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       for (Integer _v_ : this.awardeddays)
/*     */       {
/* 113 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 115 */       _output_.writeInt64(2, this.signtime);
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
/* 143 */           int _v_ = 0;
/* 144 */           _v_ = _input_.readInt32();
/* 145 */           this.awardeddays.add(Integer.valueOf(_v_));
/* 146 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 150 */           this.signtime = _input_.readInt64();
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
/*     */   public xbean.Openserver copy()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Openserver(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Openserver toData()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Openserver toBean()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Openserver(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Openserver toDataIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Openserver toBeanIf()
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
/*     */   public List<Integer> getAwardeddays()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return xdb.Logs.logList(new LogKey(this, "awardeddays"), this.awardeddays);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getAwardeddaysAsData()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/*     */     
/* 228 */     Openserver _o_ = this;
/* 229 */     List<Integer> awardeddays = new ArrayList();
/* 230 */     awardeddays.addAll(_o_.awardeddays);
/* 231 */     return awardeddays;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSigntime()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.signtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSigntime(long _v_)
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     xdb.Logs.logIf(new LogKey(this, "signtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 251 */         new xdb.logs.LogLong(this, Openserver.this.signtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 255 */             Openserver.this.signtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 259 */     });
/* 260 */     this.signtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     Openserver _o_ = null;
/* 268 */     if ((_o1_ instanceof Openserver)) { _o_ = (Openserver)_o1_;
/* 269 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 270 */       return false;
/* 271 */     if (!this.awardeddays.equals(_o_.awardeddays)) return false;
/* 272 */     if (this.signtime != _o_.signtime) return false;
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     int _h_ = 0;
/* 281 */     _h_ += this.awardeddays.hashCode();
/* 282 */     _h_ = (int)(_h_ + this.signtime);
/* 283 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     StringBuilder _sb_ = new StringBuilder();
/* 291 */     _sb_.append("(");
/* 292 */     _sb_.append(this.awardeddays);
/* 293 */     _sb_.append(",");
/* 294 */     _sb_.append(this.signtime);
/* 295 */     _sb_.append(")");
/* 296 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 302 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awardeddays"));
/* 304 */     lb.add(new xdb.logs.ListenableChanged().setVarName("signtime"));
/* 305 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Openserver {
/*     */     private Const() {}
/*     */     
/*     */     Openserver nThis() {
/* 312 */       return Openserver.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 318 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Openserver copy()
/*     */     {
/* 324 */       return Openserver.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Openserver toData()
/*     */     {
/* 330 */       return Openserver.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Openserver toBean()
/*     */     {
/* 335 */       return Openserver.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Openserver toDataIf()
/*     */     {
/* 341 */       return Openserver.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Openserver toBeanIf()
/*     */     {
/* 346 */       return Openserver.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getAwardeddays()
/*     */     {
/* 353 */       Openserver.this._xdb_verify_unsafe_();
/* 354 */       return xdb.Consts.constList(Openserver.this.awardeddays);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getAwardeddaysAsData()
/*     */     {
/* 360 */       Openserver.this._xdb_verify_unsafe_();
/*     */       
/* 362 */       Openserver _o_ = Openserver.this;
/* 363 */       List<Integer> awardeddays = new ArrayList();
/* 364 */       awardeddays.addAll(_o_.awardeddays);
/* 365 */       return awardeddays;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSigntime()
/*     */     {
/* 372 */       Openserver.this._xdb_verify_unsafe_();
/* 373 */       return Openserver.this.signtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSigntime(long _v_)
/*     */     {
/* 380 */       Openserver.this._xdb_verify_unsafe_();
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 387 */       Openserver.this._xdb_verify_unsafe_();
/* 388 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 394 */       Openserver.this._xdb_verify_unsafe_();
/* 395 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 401 */       return Openserver.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 407 */       return Openserver.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 413 */       Openserver.this._xdb_verify_unsafe_();
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 420 */       return Openserver.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 426 */       return Openserver.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 432 */       Openserver.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 439 */       return Openserver.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 445 */       return Openserver.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 451 */       return Openserver.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 457 */       return Openserver.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 463 */       return Openserver.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 469 */       return Openserver.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 475 */       return Openserver.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Openserver
/*     */   {
/*     */     private ArrayList<Integer> awardeddays;
/*     */     
/*     */     private long signtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 494 */       this.awardeddays = new ArrayList();
/* 495 */       this.signtime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.Openserver _o1_)
/*     */     {
/* 500 */       if ((_o1_ instanceof Openserver)) { assign((Openserver)_o1_);
/* 501 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 502 */       } else if ((_o1_ instanceof Openserver.Const)) assign(((Openserver.Const)_o1_).nThis()); else {
/* 503 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Openserver _o_) {
/* 508 */       this.awardeddays = new ArrayList();
/* 509 */       this.awardeddays.addAll(_o_.awardeddays);
/* 510 */       this.signtime = _o_.signtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 515 */       this.awardeddays = new ArrayList();
/* 516 */       this.awardeddays.addAll(_o_.awardeddays);
/* 517 */       this.signtime = _o_.signtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       _os_.compact_uint32(this.awardeddays.size());
/* 524 */       for (Integer _v_ : this.awardeddays)
/*     */       {
/* 526 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 528 */       _os_.marshal(this.signtime);
/* 529 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 535 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 537 */         int _v_ = 0;
/* 538 */         _v_ = _os_.unmarshal_int();
/* 539 */         this.awardeddays.add(Integer.valueOf(_v_));
/*     */       }
/* 541 */       this.signtime = _os_.unmarshal_long();
/* 542 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 548 */       int _size_ = 0;
/* 549 */       for (Integer _v_ : this.awardeddays)
/*     */       {
/* 551 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 553 */       _size_ += CodedOutputStream.computeInt64Size(2, this.signtime);
/* 554 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 562 */         for (Integer _v_ : this.awardeddays)
/*     */         {
/* 564 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 566 */         _output_.writeInt64(2, this.signtime);
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
/* 593 */             int _v_ = 0;
/* 594 */             _v_ = _input_.readInt32();
/* 595 */             this.awardeddays.add(Integer.valueOf(_v_));
/* 596 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 600 */             this.signtime = _input_.readInt64();
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
/*     */     public xbean.Openserver copy()
/*     */     {
/* 628 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Openserver toData()
/*     */     {
/* 634 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Openserver toBean()
/*     */     {
/* 639 */       return new Openserver(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Openserver toDataIf()
/*     */     {
/* 645 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Openserver toBeanIf()
/*     */     {
/* 650 */       return new Openserver(this, null, null);
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
/*     */     public List<Integer> getAwardeddays()
/*     */     {
/* 687 */       return this.awardeddays;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getAwardeddaysAsData()
/*     */     {
/* 694 */       return this.awardeddays;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSigntime()
/*     */     {
/* 701 */       return this.signtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSigntime(long _v_)
/*     */     {
/* 708 */       this.signtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 714 */       if (!(_o1_ instanceof Data)) return false;
/* 715 */       Data _o_ = (Data)_o1_;
/* 716 */       if (!this.awardeddays.equals(_o_.awardeddays)) return false;
/* 717 */       if (this.signtime != _o_.signtime) return false;
/* 718 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 724 */       int _h_ = 0;
/* 725 */       _h_ += this.awardeddays.hashCode();
/* 726 */       _h_ = (int)(_h_ + this.signtime);
/* 727 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 733 */       StringBuilder _sb_ = new StringBuilder();
/* 734 */       _sb_.append("(");
/* 735 */       _sb_.append(this.awardeddays);
/* 736 */       _sb_.append(",");
/* 737 */       _sb_.append(this.signtime);
/* 738 */       _sb_.append(")");
/* 739 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Openserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */