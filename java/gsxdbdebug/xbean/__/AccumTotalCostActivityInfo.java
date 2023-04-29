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
/*     */ 
/*     */ public final class AccumTotalCostActivityInfo extends XBean implements xbean.AccumTotalCostActivityInfo
/*     */ {
/*     */   private long accum_total_cost;
/*     */   private int sortid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.accum_total_cost = 0L;
/*  21 */     this.sortid = 0;
/*     */   }
/*     */   
/*     */   AccumTotalCostActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.accum_total_cost = 0L;
/*     */   }
/*     */   
/*     */   public AccumTotalCostActivityInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AccumTotalCostActivityInfo(AccumTotalCostActivityInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AccumTotalCostActivityInfo(xbean.AccumTotalCostActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof AccumTotalCostActivityInfo)) { assign((AccumTotalCostActivityInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AccumTotalCostActivityInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.accum_total_cost = _o_.accum_total_cost;
/*  53 */     this.sortid = _o_.sortid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.accum_total_cost = _o_.accum_total_cost;
/*  59 */     this.sortid = _o_.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.accum_total_cost);
/*  67 */     _os_.marshal(this.sortid);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.accum_total_cost = _os_.unmarshal_long();
/*  76 */     this.sortid = _os_.unmarshal_int();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(1, this.accum_total_cost);
/*  86 */     _size_ += CodedOutputStream.computeInt32Size(2, this.sortid);
/*  87 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  96 */       _output_.writeInt64(1, this.accum_total_cost);
/*  97 */       _output_.writeInt32(2, this.sortid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 101 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 103 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       boolean done = false;
/* 113 */       while (!done)
/*     */       {
/* 115 */         int tag = _input_.readTag();
/* 116 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 120 */           done = true;
/* 121 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 125 */           this.accum_total_cost = _input_.readInt64();
/* 126 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 130 */           this.sortid = _input_.readInt32();
/* 131 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 135 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 137 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 146 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AccumTotalCostActivityInfo copy()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new AccumTotalCostActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AccumTotalCostActivityInfo toData()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AccumTotalCostActivityInfo toBean()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new AccumTotalCostActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AccumTotalCostActivityInfo toDataIf()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AccumTotalCostActivityInfo toBeanIf()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAccum_total_cost()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this.accum_total_cost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSortid()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this.sortid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccum_total_cost(long _v_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     xdb.Logs.logIf(new LogKey(this, "accum_total_cost")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 220 */         new xdb.logs.LogLong(this, AccumTotalCostActivityInfo.this.accum_total_cost)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 224 */             AccumTotalCostActivityInfo.this.accum_total_cost = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 228 */     });
/* 229 */     this.accum_total_cost = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSortid(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "sortid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, AccumTotalCostActivityInfo.this.sortid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             AccumTotalCostActivityInfo.this.sortid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.sortid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     AccumTotalCostActivityInfo _o_ = null;
/* 258 */     if ((_o1_ instanceof AccumTotalCostActivityInfo)) { _o_ = (AccumTotalCostActivityInfo)_o1_;
/* 259 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 260 */       return false;
/* 261 */     if (this.accum_total_cost != _o_.accum_total_cost) return false;
/* 262 */     if (this.sortid != _o_.sortid) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ = (int)(_h_ + this.accum_total_cost);
/* 272 */     _h_ += this.sortid;
/* 273 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     StringBuilder _sb_ = new StringBuilder();
/* 281 */     _sb_.append("(");
/* 282 */     _sb_.append(this.accum_total_cost);
/* 283 */     _sb_.append(",");
/* 284 */     _sb_.append(this.sortid);
/* 285 */     _sb_.append(")");
/* 286 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 292 */     ListenableBean lb = new ListenableBean();
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("accum_total_cost"));
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sortid"));
/* 295 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AccumTotalCostActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     AccumTotalCostActivityInfo nThis() {
/* 302 */       return AccumTotalCostActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AccumTotalCostActivityInfo copy()
/*     */     {
/* 314 */       return AccumTotalCostActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AccumTotalCostActivityInfo toData()
/*     */     {
/* 320 */       return AccumTotalCostActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AccumTotalCostActivityInfo toBean()
/*     */     {
/* 325 */       return AccumTotalCostActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AccumTotalCostActivityInfo toDataIf()
/*     */     {
/* 331 */       return AccumTotalCostActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AccumTotalCostActivityInfo toBeanIf()
/*     */     {
/* 336 */       return AccumTotalCostActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAccum_total_cost()
/*     */     {
/* 343 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 344 */       return AccumTotalCostActivityInfo.this.accum_total_cost;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 351 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 352 */       return AccumTotalCostActivityInfo.this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAccum_total_cost(long _v_)
/*     */     {
/* 359 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 367 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 374 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 375 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 381 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 382 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 388 */       return AccumTotalCostActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 394 */       return AccumTotalCostActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 400 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 407 */       return AccumTotalCostActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       return AccumTotalCostActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 419 */       AccumTotalCostActivityInfo.this._xdb_verify_unsafe_();
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 426 */       return AccumTotalCostActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 432 */       return AccumTotalCostActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 438 */       return AccumTotalCostActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 444 */       return AccumTotalCostActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 450 */       return AccumTotalCostActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 456 */       return AccumTotalCostActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 462 */       return AccumTotalCostActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AccumTotalCostActivityInfo
/*     */   {
/*     */     private long accum_total_cost;
/*     */     
/*     */     private int sortid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 481 */       this.accum_total_cost = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.AccumTotalCostActivityInfo _o1_)
/*     */     {
/* 486 */       if ((_o1_ instanceof AccumTotalCostActivityInfo)) { assign((AccumTotalCostActivityInfo)_o1_);
/* 487 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 488 */       } else if ((_o1_ instanceof AccumTotalCostActivityInfo.Const)) assign(((AccumTotalCostActivityInfo.Const)_o1_).nThis()); else {
/* 489 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AccumTotalCostActivityInfo _o_) {
/* 494 */       this.accum_total_cost = _o_.accum_total_cost;
/* 495 */       this.sortid = _o_.sortid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 500 */       this.accum_total_cost = _o_.accum_total_cost;
/* 501 */       this.sortid = _o_.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.accum_total_cost);
/* 508 */       _os_.marshal(this.sortid);
/* 509 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       this.accum_total_cost = _os_.unmarshal_long();
/* 516 */       this.sortid = _os_.unmarshal_int();
/* 517 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 523 */       int _size_ = 0;
/* 524 */       _size_ += CodedOutputStream.computeInt64Size(1, this.accum_total_cost);
/* 525 */       _size_ += CodedOutputStream.computeInt32Size(2, this.sortid);
/* 526 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         _output_.writeInt64(1, this.accum_total_cost);
/* 535 */         _output_.writeInt32(2, this.sortid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 539 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 541 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 549 */         boolean done = false;
/* 550 */         while (!done)
/*     */         {
/* 552 */           int tag = _input_.readTag();
/* 553 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 557 */             done = true;
/* 558 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 562 */             this.accum_total_cost = _input_.readInt64();
/* 563 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 567 */             this.sortid = _input_.readInt32();
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AccumTotalCostActivityInfo copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AccumTotalCostActivityInfo toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AccumTotalCostActivityInfo toBean()
/*     */     {
/* 606 */       return new AccumTotalCostActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AccumTotalCostActivityInfo toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AccumTotalCostActivityInfo toBeanIf()
/*     */     {
/* 617 */       return new AccumTotalCostActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAccum_total_cost()
/*     */     {
/* 654 */       return this.accum_total_cost;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSortid()
/*     */     {
/* 661 */       return this.sortid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAccum_total_cost(long _v_)
/*     */     {
/* 668 */       this.accum_total_cost = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSortid(int _v_)
/*     */     {
/* 675 */       this.sortid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (this.accum_total_cost != _o_.accum_total_cost) return false;
/* 684 */       if (this.sortid != _o_.sortid) return false;
/* 685 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 691 */       int _h_ = 0;
/* 692 */       _h_ = (int)(_h_ + this.accum_total_cost);
/* 693 */       _h_ += this.sortid;
/* 694 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 700 */       StringBuilder _sb_ = new StringBuilder();
/* 701 */       _sb_.append("(");
/* 702 */       _sb_.append(this.accum_total_cost);
/* 703 */       _sb_.append(",");
/* 704 */       _sb_.append(this.sortid);
/* 705 */       _sb_.append(")");
/* 706 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AccumTotalCostActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */