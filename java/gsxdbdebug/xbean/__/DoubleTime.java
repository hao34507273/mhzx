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
/*     */ public final class DoubleTime extends XBean implements xbean.DoubleTime
/*     */ {
/*     */   private long pointoffertime;
/*     */   private long itemcountcleartime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.pointoffertime = 0L;
/*  21 */     this.itemcountcleartime = 0L;
/*     */   }
/*     */   
/*     */   DoubleTime(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.pointoffertime = 0L;
/*  28 */     this.itemcountcleartime = 0L;
/*     */   }
/*     */   
/*     */   public DoubleTime()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public DoubleTime(DoubleTime _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   DoubleTime(xbean.DoubleTime _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof DoubleTime)) { assign((DoubleTime)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(DoubleTime _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.pointoffertime = _o_.pointoffertime;
/*  54 */     this.itemcountcleartime = _o_.itemcountcleartime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.pointoffertime = _o_.pointoffertime;
/*  60 */     this.itemcountcleartime = _o_.itemcountcleartime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.pointoffertime);
/*  68 */     _os_.marshal(this.itemcountcleartime);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.pointoffertime = _os_.unmarshal_long();
/*  77 */     this.itemcountcleartime = _os_.unmarshal_long();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt64Size(1, this.pointoffertime);
/*  87 */     _size_ += CodedOutputStream.computeInt64Size(2, this.itemcountcleartime);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt64(1, this.pointoffertime);
/*  98 */       _output_.writeInt64(2, this.itemcountcleartime);
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
/* 126 */           this.pointoffertime = _input_.readInt64();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.itemcountcleartime = _input_.readInt64();
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
/*     */   public xbean.DoubleTime copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new DoubleTime(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DoubleTime toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DoubleTime toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new DoubleTime(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.DoubleTime toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.DoubleTime toBeanIf()
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
/*     */   public long getPointoffertime()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.pointoffertime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getItemcountcleartime()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.itemcountcleartime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPointoffertime(long _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "pointoffertime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new LogLong(this, DoubleTime.this.pointoffertime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             DoubleTime.this.pointoffertime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.pointoffertime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setItemcountcleartime(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "itemcountcleartime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new LogLong(this, DoubleTime.this.itemcountcleartime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             DoubleTime.this.itemcountcleartime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.itemcountcleartime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     DoubleTime _o_ = null;
/* 259 */     if ((_o1_ instanceof DoubleTime)) { _o_ = (DoubleTime)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.pointoffertime != _o_.pointoffertime) return false;
/* 263 */     if (this.itemcountcleartime != _o_.itemcountcleartime) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ = (int)(_h_ + this.pointoffertime);
/* 273 */     _h_ = (int)(_h_ + this.itemcountcleartime);
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.pointoffertime);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.itemcountcleartime);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("pointoffertime"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("itemcountcleartime"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.DoubleTime {
/*     */     private Const() {}
/*     */     
/*     */     DoubleTime nThis() {
/* 303 */       return DoubleTime.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DoubleTime copy()
/*     */     {
/* 315 */       return DoubleTime.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DoubleTime toData()
/*     */     {
/* 321 */       return DoubleTime.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.DoubleTime toBean()
/*     */     {
/* 326 */       return DoubleTime.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DoubleTime toDataIf()
/*     */     {
/* 332 */       return DoubleTime.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.DoubleTime toBeanIf()
/*     */     {
/* 337 */       return DoubleTime.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPointoffertime()
/*     */     {
/* 344 */       DoubleTime.this._xdb_verify_unsafe_();
/* 345 */       return DoubleTime.this.pointoffertime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getItemcountcleartime()
/*     */     {
/* 352 */       DoubleTime.this._xdb_verify_unsafe_();
/* 353 */       return DoubleTime.this.itemcountcleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPointoffertime(long _v_)
/*     */     {
/* 360 */       DoubleTime.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setItemcountcleartime(long _v_)
/*     */     {
/* 368 */       DoubleTime.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       DoubleTime.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       DoubleTime.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return DoubleTime.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return DoubleTime.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       DoubleTime.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return DoubleTime.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return DoubleTime.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       DoubleTime.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return DoubleTime.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return DoubleTime.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return DoubleTime.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return DoubleTime.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return DoubleTime.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return DoubleTime.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return DoubleTime.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.DoubleTime
/*     */   {
/*     */     private long pointoffertime;
/*     */     
/*     */     private long itemcountcleartime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.pointoffertime = 0L;
/* 483 */       this.itemcountcleartime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.DoubleTime _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof DoubleTime)) { assign((DoubleTime)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof DoubleTime.Const)) assign(((DoubleTime.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(DoubleTime _o_) {
/* 496 */       this.pointoffertime = _o_.pointoffertime;
/* 497 */       this.itemcountcleartime = _o_.itemcountcleartime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.pointoffertime = _o_.pointoffertime;
/* 503 */       this.itemcountcleartime = _o_.itemcountcleartime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.pointoffertime);
/* 510 */       _os_.marshal(this.itemcountcleartime);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.pointoffertime = _os_.unmarshal_long();
/* 518 */       this.itemcountcleartime = _os_.unmarshal_long();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt64Size(1, this.pointoffertime);
/* 527 */       _size_ += CodedOutputStream.computeInt64Size(2, this.itemcountcleartime);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt64(1, this.pointoffertime);
/* 537 */         _output_.writeInt64(2, this.itemcountcleartime);
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
/* 564 */             this.pointoffertime = _input_.readInt64();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.itemcountcleartime = _input_.readInt64();
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
/*     */     public xbean.DoubleTime copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DoubleTime toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.DoubleTime toBean()
/*     */     {
/* 608 */       return new DoubleTime(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.DoubleTime toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.DoubleTime toBeanIf()
/*     */     {
/* 619 */       return new DoubleTime(this, null, null);
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
/*     */     public long getPointoffertime()
/*     */     {
/* 656 */       return this.pointoffertime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getItemcountcleartime()
/*     */     {
/* 663 */       return this.itemcountcleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPointoffertime(long _v_)
/*     */     {
/* 670 */       this.pointoffertime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setItemcountcleartime(long _v_)
/*     */     {
/* 677 */       this.itemcountcleartime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.pointoffertime != _o_.pointoffertime) return false;
/* 686 */       if (this.itemcountcleartime != _o_.itemcountcleartime) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ = (int)(_h_ + this.pointoffertime);
/* 695 */       _h_ = (int)(_h_ + this.itemcountcleartime);
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.pointoffertime);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.itemcountcleartime);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DoubleTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */