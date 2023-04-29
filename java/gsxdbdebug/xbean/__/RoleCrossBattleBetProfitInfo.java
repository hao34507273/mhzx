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
/*     */ public final class RoleCrossBattleBetProfitInfo extends XBean implements xbean.RoleCrossBattleBetProfitInfo
/*     */ {
/*     */   private long profit;
/*     */   private long timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.profit = 0L;
/*  21 */     this.timestamp = 0L;
/*     */   }
/*     */   
/*     */   RoleCrossBattleBetProfitInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.profit = 0L;
/*  28 */     this.timestamp = 0L;
/*     */   }
/*     */   
/*     */   public RoleCrossBattleBetProfitInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleCrossBattleBetProfitInfo(RoleCrossBattleBetProfitInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleCrossBattleBetProfitInfo(xbean.RoleCrossBattleBetProfitInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RoleCrossBattleBetProfitInfo)) { assign((RoleCrossBattleBetProfitInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleCrossBattleBetProfitInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.profit = _o_.profit;
/*  54 */     this.timestamp = _o_.timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.profit = _o_.profit;
/*  60 */     this.timestamp = _o_.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.profit);
/*  68 */     _os_.marshal(this.timestamp);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.profit = _os_.unmarshal_long();
/*  77 */     this.timestamp = _os_.unmarshal_long();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt64Size(1, this.profit);
/*  87 */     _size_ += CodedOutputStream.computeInt64Size(2, this.timestamp);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt64(1, this.profit);
/*  98 */       _output_.writeInt64(2, this.timestamp);
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
/* 126 */           this.profit = _input_.readInt64();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.timestamp = _input_.readInt64();
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
/*     */   public xbean.RoleCrossBattleBetProfitInfo copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new RoleCrossBattleBetProfitInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleCrossBattleBetProfitInfo toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleCrossBattleBetProfitInfo toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new RoleCrossBattleBetProfitInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleCrossBattleBetProfitInfo toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleCrossBattleBetProfitInfo toBeanIf()
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
/*     */   public long getProfit()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.profit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTimestamp()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProfit(long _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "profit")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new LogLong(this, RoleCrossBattleBetProfitInfo.this.profit)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             RoleCrossBattleBetProfitInfo.this.profit = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.profit = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimestamp(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new LogLong(this, RoleCrossBattleBetProfitInfo.this.timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             RoleCrossBattleBetProfitInfo.this.timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     RoleCrossBattleBetProfitInfo _o_ = null;
/* 259 */     if ((_o1_ instanceof RoleCrossBattleBetProfitInfo)) { _o_ = (RoleCrossBattleBetProfitInfo)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.profit != _o_.profit) return false;
/* 263 */     if (this.timestamp != _o_.timestamp) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ = (int)(_h_ + this.profit);
/* 273 */     _h_ = (int)(_h_ + this.timestamp);
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.profit);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.timestamp);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("profit"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("timestamp"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleCrossBattleBetProfitInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleCrossBattleBetProfitInfo nThis() {
/* 303 */       return RoleCrossBattleBetProfitInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCrossBattleBetProfitInfo copy()
/*     */     {
/* 315 */       return RoleCrossBattleBetProfitInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCrossBattleBetProfitInfo toData()
/*     */     {
/* 321 */       return RoleCrossBattleBetProfitInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleCrossBattleBetProfitInfo toBean()
/*     */     {
/* 326 */       return RoleCrossBattleBetProfitInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCrossBattleBetProfitInfo toDataIf()
/*     */     {
/* 332 */       return RoleCrossBattleBetProfitInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleCrossBattleBetProfitInfo toBeanIf()
/*     */     {
/* 337 */       return RoleCrossBattleBetProfitInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getProfit()
/*     */     {
/* 344 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 345 */       return RoleCrossBattleBetProfitInfo.this.profit;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 352 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 353 */       return RoleCrossBattleBetProfitInfo.this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProfit(long _v_)
/*     */     {
/* 360 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 368 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return RoleCrossBattleBetProfitInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return RoleCrossBattleBetProfitInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return RoleCrossBattleBetProfitInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return RoleCrossBattleBetProfitInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       RoleCrossBattleBetProfitInfo.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return RoleCrossBattleBetProfitInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return RoleCrossBattleBetProfitInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return RoleCrossBattleBetProfitInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return RoleCrossBattleBetProfitInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return RoleCrossBattleBetProfitInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return RoleCrossBattleBetProfitInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return RoleCrossBattleBetProfitInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleCrossBattleBetProfitInfo
/*     */   {
/*     */     private long profit;
/*     */     
/*     */     private long timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.profit = 0L;
/* 483 */       this.timestamp = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleCrossBattleBetProfitInfo _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof RoleCrossBattleBetProfitInfo)) { assign((RoleCrossBattleBetProfitInfo)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof RoleCrossBattleBetProfitInfo.Const)) assign(((RoleCrossBattleBetProfitInfo.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleCrossBattleBetProfitInfo _o_) {
/* 496 */       this.profit = _o_.profit;
/* 497 */       this.timestamp = _o_.timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.profit = _o_.profit;
/* 503 */       this.timestamp = _o_.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.profit);
/* 510 */       _os_.marshal(this.timestamp);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.profit = _os_.unmarshal_long();
/* 518 */       this.timestamp = _os_.unmarshal_long();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt64Size(1, this.profit);
/* 527 */       _size_ += CodedOutputStream.computeInt64Size(2, this.timestamp);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt64(1, this.profit);
/* 537 */         _output_.writeInt64(2, this.timestamp);
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
/* 564 */             this.profit = _input_.readInt64();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.timestamp = _input_.readInt64();
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
/*     */     public xbean.RoleCrossBattleBetProfitInfo copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCrossBattleBetProfitInfo toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleCrossBattleBetProfitInfo toBean()
/*     */     {
/* 608 */       return new RoleCrossBattleBetProfitInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCrossBattleBetProfitInfo toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleCrossBattleBetProfitInfo toBeanIf()
/*     */     {
/* 619 */       return new RoleCrossBattleBetProfitInfo(this, null, null);
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
/*     */     public long getProfit()
/*     */     {
/* 656 */       return this.profit;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 663 */       return this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProfit(long _v_)
/*     */     {
/* 670 */       this.profit = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 677 */       this.timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.profit != _o_.profit) return false;
/* 686 */       if (this.timestamp != _o_.timestamp) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ = (int)(_h_ + this.profit);
/* 695 */       _h_ = (int)(_h_ + this.timestamp);
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.profit);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.timestamp);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleCrossBattleBetProfitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */