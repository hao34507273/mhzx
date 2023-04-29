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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class DaySaveAmtInfo extends XBean implements xbean.DaySaveAmtInfo
/*     */ {
/*     */   private long day_begin_time;
/*     */   private long save_amt;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.day_begin_time = 0L;
/*  21 */     this.save_amt = 0L;
/*     */   }
/*     */   
/*     */   DaySaveAmtInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.day_begin_time = 0L;
/*  28 */     this.save_amt = 0L;
/*     */   }
/*     */   
/*     */   public DaySaveAmtInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DaySaveAmtInfo(DaySaveAmtInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DaySaveAmtInfo(xbean.DaySaveAmtInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof DaySaveAmtInfo)) { assign((DaySaveAmtInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DaySaveAmtInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.day_begin_time = _o_.day_begin_time;
/*  54 */     this.save_amt = _o_.save_amt;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.day_begin_time = _o_.day_begin_time;
/*  60 */     this.save_amt = _o_.save_amt;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.day_begin_time);
/*  68 */     _os_.marshal(this.save_amt);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.day_begin_time = _os_.unmarshal_long();
/*  77 */     this.save_amt = _os_.unmarshal_long();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt64Size(1, this.day_begin_time);
/*  87 */     _size_ += CodedOutputStream.computeInt64Size(2, this.save_amt);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt64(1, this.day_begin_time);
/*  98 */       _output_.writeInt64(2, this.save_amt);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 102 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 104 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       boolean done = false;
/* 114 */       while (!done)
/*     */       {
/* 116 */         int tag = _input_.readTag();
/* 117 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 121 */           done = true;
/* 122 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 126 */           this.day_begin_time = _input_.readInt64();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.save_amt = _input_.readInt64();
/* 132 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 136 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 138 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 147 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DaySaveAmtInfo copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new DaySaveAmtInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DaySaveAmtInfo toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DaySaveAmtInfo toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new DaySaveAmtInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DaySaveAmtInfo toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DaySaveAmtInfo toBeanIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getDay_begin_time()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.day_begin_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSave_amt()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.save_amt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDay_begin_time(long _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "day_begin_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new LogLong(this, DaySaveAmtInfo.this.day_begin_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             DaySaveAmtInfo.this.day_begin_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.day_begin_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSave_amt(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "save_amt")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new LogLong(this, DaySaveAmtInfo.this.save_amt)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             DaySaveAmtInfo.this.save_amt = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.save_amt = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     DaySaveAmtInfo _o_ = null;
/* 259 */     if ((_o1_ instanceof DaySaveAmtInfo)) { _o_ = (DaySaveAmtInfo)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.day_begin_time != _o_.day_begin_time) return false;
/* 263 */     if (this.save_amt != _o_.save_amt) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ = (int)(_h_ + this.day_begin_time);
/* 273 */     _h_ = (int)(_h_ + this.save_amt);
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.day_begin_time);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.save_amt);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("day_begin_time"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("save_amt"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DaySaveAmtInfo {
/*     */     private Const() {}
/*     */     
/*     */     DaySaveAmtInfo nThis() {
/* 303 */       return DaySaveAmtInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DaySaveAmtInfo copy()
/*     */     {
/* 315 */       return DaySaveAmtInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DaySaveAmtInfo toData()
/*     */     {
/* 321 */       return DaySaveAmtInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DaySaveAmtInfo toBean()
/*     */     {
/* 326 */       return DaySaveAmtInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DaySaveAmtInfo toDataIf()
/*     */     {
/* 332 */       return DaySaveAmtInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DaySaveAmtInfo toBeanIf()
/*     */     {
/* 337 */       return DaySaveAmtInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDay_begin_time()
/*     */     {
/* 344 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 345 */       return DaySaveAmtInfo.this.day_begin_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSave_amt()
/*     */     {
/* 352 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 353 */       return DaySaveAmtInfo.this.save_amt;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDay_begin_time(long _v_)
/*     */     {
/* 360 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSave_amt(long _v_)
/*     */     {
/* 368 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return DaySaveAmtInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return DaySaveAmtInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return DaySaveAmtInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return DaySaveAmtInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       DaySaveAmtInfo.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return DaySaveAmtInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return DaySaveAmtInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return DaySaveAmtInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return DaySaveAmtInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return DaySaveAmtInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return DaySaveAmtInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return DaySaveAmtInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DaySaveAmtInfo
/*     */   {
/*     */     private long day_begin_time;
/*     */     
/*     */     private long save_amt;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.day_begin_time = 0L;
/* 483 */       this.save_amt = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.DaySaveAmtInfo _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof DaySaveAmtInfo)) { assign((DaySaveAmtInfo)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof DaySaveAmtInfo.Const)) assign(((DaySaveAmtInfo.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DaySaveAmtInfo _o_) {
/* 496 */       this.day_begin_time = _o_.day_begin_time;
/* 497 */       this.save_amt = _o_.save_amt;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.day_begin_time = _o_.day_begin_time;
/* 503 */       this.save_amt = _o_.save_amt;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.day_begin_time);
/* 510 */       _os_.marshal(this.save_amt);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.day_begin_time = _os_.unmarshal_long();
/* 518 */       this.save_amt = _os_.unmarshal_long();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt64Size(1, this.day_begin_time);
/* 527 */       _size_ += CodedOutputStream.computeInt64Size(2, this.save_amt);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt64(1, this.day_begin_time);
/* 537 */         _output_.writeInt64(2, this.save_amt);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 551 */         boolean done = false;
/* 552 */         while (!done)
/*     */         {
/* 554 */           int tag = _input_.readTag();
/* 555 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 559 */             done = true;
/* 560 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 564 */             this.day_begin_time = _input_.readInt64();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.save_amt = _input_.readInt64();
/* 570 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 574 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 576 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 585 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 589 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 591 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DaySaveAmtInfo copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DaySaveAmtInfo toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DaySaveAmtInfo toBean()
/*     */     {
/* 608 */       return new DaySaveAmtInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DaySaveAmtInfo toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DaySaveAmtInfo toBeanIf()
/*     */     {
/* 619 */       return new DaySaveAmtInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 641 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 645 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 649 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDay_begin_time()
/*     */     {
/* 656 */       return this.day_begin_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSave_amt()
/*     */     {
/* 663 */       return this.save_amt;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDay_begin_time(long _v_)
/*     */     {
/* 670 */       this.day_begin_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSave_amt(long _v_)
/*     */     {
/* 677 */       this.save_amt = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.day_begin_time != _o_.day_begin_time) return false;
/* 686 */       if (this.save_amt != _o_.save_amt) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ = (int)(_h_ + this.day_begin_time);
/* 695 */       _h_ = (int)(_h_ + this.save_amt);
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.day_begin_time);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.save_amt);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DaySaveAmtInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */