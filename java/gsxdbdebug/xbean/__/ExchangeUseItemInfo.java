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
/*     */ public final class ExchangeUseItemInfo extends XBean implements xbean.ExchangeUseItemInfo
/*     */ {
/*     */   private int exchange_times;
/*     */   private int daily_exchange_times;
/*     */   private long timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.exchange_times = 0;
/*  23 */     this.daily_exchange_times = 0;
/*  24 */     this.timestamp = 0L;
/*     */   }
/*     */   
/*     */   ExchangeUseItemInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.exchange_times = 0;
/*  31 */     this.daily_exchange_times = 0;
/*  32 */     this.timestamp = 0L;
/*     */   }
/*     */   
/*     */   public ExchangeUseItemInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ExchangeUseItemInfo(ExchangeUseItemInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ExchangeUseItemInfo(xbean.ExchangeUseItemInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ExchangeUseItemInfo)) { assign((ExchangeUseItemInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ExchangeUseItemInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.exchange_times = _o_.exchange_times;
/*  58 */     this.daily_exchange_times = _o_.daily_exchange_times;
/*  59 */     this.timestamp = _o_.timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.exchange_times = _o_.exchange_times;
/*  65 */     this.daily_exchange_times = _o_.daily_exchange_times;
/*  66 */     this.timestamp = _o_.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.exchange_times);
/*  74 */     _os_.marshal(this.daily_exchange_times);
/*  75 */     _os_.marshal(this.timestamp);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.exchange_times = _os_.unmarshal_int();
/*  84 */     this.daily_exchange_times = _os_.unmarshal_int();
/*  85 */     this.timestamp = _os_.unmarshal_long();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.exchange_times);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.daily_exchange_times);
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(3, this.timestamp);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.exchange_times);
/* 107 */       _output_.writeInt32(2, this.daily_exchange_times);
/* 108 */       _output_.writeInt64(3, this.timestamp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 112 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 114 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       boolean done = false;
/* 124 */       while (!done)
/*     */       {
/* 126 */         int tag = _input_.readTag();
/* 127 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 131 */           done = true;
/* 132 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 136 */           this.exchange_times = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.daily_exchange_times = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.timestamp = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 151 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 153 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 162 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 166 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 168 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ExchangeUseItemInfo copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new ExchangeUseItemInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ExchangeUseItemInfo toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ExchangeUseItemInfo toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new ExchangeUseItemInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ExchangeUseItemInfo toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ExchangeUseItemInfo toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getExchange_times()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.exchange_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDaily_exchange_times()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.daily_exchange_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTimestamp()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExchange_times(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "exchange_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new xdb.logs.LogInt(this, ExchangeUseItemInfo.this.exchange_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             ExchangeUseItemInfo.this.exchange_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.exchange_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDaily_exchange_times(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "daily_exchange_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogInt(this, ExchangeUseItemInfo.this.daily_exchange_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             ExchangeUseItemInfo.this.daily_exchange_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.daily_exchange_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimestamp(long _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new xdb.logs.LogLong(this, ExchangeUseItemInfo.this.timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             ExchangeUseItemInfo.this.timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     ExchangeUseItemInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof ExchangeUseItemInfo)) { _o_ = (ExchangeUseItemInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.exchange_times != _o_.exchange_times) return false;
/* 307 */     if (this.daily_exchange_times != _o_.daily_exchange_times) return false;
/* 308 */     if (this.timestamp != _o_.timestamp) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.exchange_times;
/* 318 */     _h_ += this.daily_exchange_times;
/* 319 */     _h_ = (int)(_h_ + this.timestamp);
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.exchange_times);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.daily_exchange_times);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.timestamp);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("exchange_times"));
/* 343 */     lb.add(new ListenableChanged().setVarName("daily_exchange_times"));
/* 344 */     lb.add(new ListenableChanged().setVarName("timestamp"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ExchangeUseItemInfo {
/*     */     private Const() {}
/*     */     
/*     */     ExchangeUseItemInfo nThis() {
/* 352 */       return ExchangeUseItemInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ExchangeUseItemInfo copy()
/*     */     {
/* 364 */       return ExchangeUseItemInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ExchangeUseItemInfo toData()
/*     */     {
/* 370 */       return ExchangeUseItemInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ExchangeUseItemInfo toBean()
/*     */     {
/* 375 */       return ExchangeUseItemInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ExchangeUseItemInfo toDataIf()
/*     */     {
/* 381 */       return ExchangeUseItemInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ExchangeUseItemInfo toBeanIf()
/*     */     {
/* 386 */       return ExchangeUseItemInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExchange_times()
/*     */     {
/* 393 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 394 */       return ExchangeUseItemInfo.this.exchange_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDaily_exchange_times()
/*     */     {
/* 401 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 402 */       return ExchangeUseItemInfo.this.daily_exchange_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 409 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 410 */       return ExchangeUseItemInfo.this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExchange_times(int _v_)
/*     */     {
/* 417 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDaily_exchange_times(int _v_)
/*     */     {
/* 425 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 433 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 440 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return ExchangeUseItemInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return ExchangeUseItemInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return ExchangeUseItemInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return ExchangeUseItemInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       ExchangeUseItemInfo.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 492 */       return ExchangeUseItemInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return ExchangeUseItemInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return ExchangeUseItemInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return ExchangeUseItemInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return ExchangeUseItemInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return ExchangeUseItemInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return ExchangeUseItemInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ExchangeUseItemInfo
/*     */   {
/*     */     private int exchange_times;
/*     */     
/*     */     private int daily_exchange_times;
/*     */     
/*     */     private long timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.exchange_times = 0;
/* 550 */       this.daily_exchange_times = 0;
/* 551 */       this.timestamp = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.ExchangeUseItemInfo _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof ExchangeUseItemInfo)) { assign((ExchangeUseItemInfo)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof ExchangeUseItemInfo.Const)) assign(((ExchangeUseItemInfo.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ExchangeUseItemInfo _o_) {
/* 564 */       this.exchange_times = _o_.exchange_times;
/* 565 */       this.daily_exchange_times = _o_.daily_exchange_times;
/* 566 */       this.timestamp = _o_.timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.exchange_times = _o_.exchange_times;
/* 572 */       this.daily_exchange_times = _o_.daily_exchange_times;
/* 573 */       this.timestamp = _o_.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.exchange_times);
/* 580 */       _os_.marshal(this.daily_exchange_times);
/* 581 */       _os_.marshal(this.timestamp);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.exchange_times = _os_.unmarshal_int();
/* 589 */       this.daily_exchange_times = _os_.unmarshal_int();
/* 590 */       this.timestamp = _os_.unmarshal_long();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.exchange_times);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.daily_exchange_times);
/* 600 */       _size_ += CodedOutputStream.computeInt64Size(3, this.timestamp);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.exchange_times);
/* 610 */         _output_.writeInt32(2, this.daily_exchange_times);
/* 611 */         _output_.writeInt64(3, this.timestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 615 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 617 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 625 */         boolean done = false;
/* 626 */         while (!done)
/*     */         {
/* 628 */           int tag = _input_.readTag();
/* 629 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 633 */             done = true;
/* 634 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 638 */             this.exchange_times = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.daily_exchange_times = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.timestamp = _input_.readInt64();
/* 649 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 653 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 655 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 664 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ExchangeUseItemInfo copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ExchangeUseItemInfo toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ExchangeUseItemInfo toBean()
/*     */     {
/* 687 */       return new ExchangeUseItemInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ExchangeUseItemInfo toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ExchangeUseItemInfo toBeanIf()
/*     */     {
/* 698 */       return new ExchangeUseItemInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 720 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getExchange_times()
/*     */     {
/* 735 */       return this.exchange_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDaily_exchange_times()
/*     */     {
/* 742 */       return this.daily_exchange_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 749 */       return this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExchange_times(int _v_)
/*     */     {
/* 756 */       this.exchange_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDaily_exchange_times(int _v_)
/*     */     {
/* 763 */       this.daily_exchange_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 770 */       this.timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.exchange_times != _o_.exchange_times) return false;
/* 779 */       if (this.daily_exchange_times != _o_.daily_exchange_times) return false;
/* 780 */       if (this.timestamp != _o_.timestamp) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.exchange_times;
/* 789 */       _h_ += this.daily_exchange_times;
/* 790 */       _h_ = (int)(_h_ + this.timestamp);
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.exchange_times);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.daily_exchange_times);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.timestamp);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ExchangeUseItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */