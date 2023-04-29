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
/*     */ public final class RoleBigBossRemoteChartAwardInfo extends XBean implements xbean.RoleBigBossRemoteChartAwardInfo
/*     */ {
/*     */   private int occupation;
/*     */   private int rank;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.occupation = 0;
/*  21 */     this.rank = -1;
/*     */   }
/*     */   
/*     */   RoleBigBossRemoteChartAwardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.rank = -1;
/*     */   }
/*     */   
/*     */   public RoleBigBossRemoteChartAwardInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleBigBossRemoteChartAwardInfo(RoleBigBossRemoteChartAwardInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleBigBossRemoteChartAwardInfo(xbean.RoleBigBossRemoteChartAwardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof RoleBigBossRemoteChartAwardInfo)) { assign((RoleBigBossRemoteChartAwardInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleBigBossRemoteChartAwardInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.occupation = _o_.occupation;
/*  53 */     this.rank = _o_.rank;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.occupation = _o_.occupation;
/*  59 */     this.rank = _o_.rank;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.occupation);
/*  67 */     _os_.marshal(this.rank);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.occupation = _os_.unmarshal_int();
/*  76 */     this.rank = _os_.unmarshal_int();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(1, this.occupation);
/*  86 */     _size_ += CodedOutputStream.computeInt32Size(2, this.rank);
/*  87 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  96 */       _output_.writeInt32(1, this.occupation);
/*  97 */       _output_.writeInt32(2, this.rank);
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
/* 125 */           this.occupation = _input_.readInt32();
/* 126 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 130 */           this.rank = _input_.readInt32();
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
/*     */   public xbean.RoleBigBossRemoteChartAwardInfo copy()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new RoleBigBossRemoteChartAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleBigBossRemoteChartAwardInfo toData()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleBigBossRemoteChartAwardInfo toBean()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new RoleBigBossRemoteChartAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleBigBossRemoteChartAwardInfo toDataIf()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleBigBossRemoteChartAwardInfo toBeanIf()
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
/*     */   public int getOccupation()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this.occupation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRank()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this.rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOccupation(int _v_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     xdb.Logs.logIf(new LogKey(this, "occupation")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 220 */         new xdb.logs.LogInt(this, RoleBigBossRemoteChartAwardInfo.this.occupation)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 224 */             RoleBigBossRemoteChartAwardInfo.this.occupation = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 228 */     });
/* 229 */     this.occupation = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRank(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "rank")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, RoleBigBossRemoteChartAwardInfo.this.rank)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             RoleBigBossRemoteChartAwardInfo.this.rank = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.rank = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     RoleBigBossRemoteChartAwardInfo _o_ = null;
/* 258 */     if ((_o1_ instanceof RoleBigBossRemoteChartAwardInfo)) { _o_ = (RoleBigBossRemoteChartAwardInfo)_o1_;
/* 259 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 260 */       return false;
/* 261 */     if (this.occupation != _o_.occupation) return false;
/* 262 */     if (this.rank != _o_.rank) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ += this.occupation;
/* 272 */     _h_ += this.rank;
/* 273 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     StringBuilder _sb_ = new StringBuilder();
/* 281 */     _sb_.append("(");
/* 282 */     _sb_.append(this.occupation);
/* 283 */     _sb_.append(",");
/* 284 */     _sb_.append(this.rank);
/* 285 */     _sb_.append(")");
/* 286 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 292 */     ListenableBean lb = new ListenableBean();
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("occupation"));
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rank"));
/* 295 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleBigBossRemoteChartAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleBigBossRemoteChartAwardInfo nThis() {
/* 302 */       return RoleBigBossRemoteChartAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo copy()
/*     */     {
/* 314 */       return RoleBigBossRemoteChartAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toData()
/*     */     {
/* 320 */       return RoleBigBossRemoteChartAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toBean()
/*     */     {
/* 325 */       return RoleBigBossRemoteChartAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toDataIf()
/*     */     {
/* 331 */       return RoleBigBossRemoteChartAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toBeanIf()
/*     */     {
/* 336 */       return RoleBigBossRemoteChartAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOccupation()
/*     */     {
/* 343 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 344 */       return RoleBigBossRemoteChartAwardInfo.this.occupation;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRank()
/*     */     {
/* 351 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 352 */       return RoleBigBossRemoteChartAwardInfo.this.rank;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOccupation(int _v_)
/*     */     {
/* 359 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRank(int _v_)
/*     */     {
/* 367 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 374 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 375 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 381 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 382 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 388 */       return RoleBigBossRemoteChartAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 394 */       return RoleBigBossRemoteChartAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 400 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 407 */       return RoleBigBossRemoteChartAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       return RoleBigBossRemoteChartAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 419 */       RoleBigBossRemoteChartAwardInfo.this._xdb_verify_unsafe_();
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 426 */       return RoleBigBossRemoteChartAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 432 */       return RoleBigBossRemoteChartAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 438 */       return RoleBigBossRemoteChartAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 444 */       return RoleBigBossRemoteChartAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 450 */       return RoleBigBossRemoteChartAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 456 */       return RoleBigBossRemoteChartAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 462 */       return RoleBigBossRemoteChartAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleBigBossRemoteChartAwardInfo
/*     */   {
/*     */     private int occupation;
/*     */     
/*     */     private int rank;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 481 */       this.rank = -1;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleBigBossRemoteChartAwardInfo _o1_)
/*     */     {
/* 486 */       if ((_o1_ instanceof RoleBigBossRemoteChartAwardInfo)) { assign((RoleBigBossRemoteChartAwardInfo)_o1_);
/* 487 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 488 */       } else if ((_o1_ instanceof RoleBigBossRemoteChartAwardInfo.Const)) assign(((RoleBigBossRemoteChartAwardInfo.Const)_o1_).nThis()); else {
/* 489 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleBigBossRemoteChartAwardInfo _o_) {
/* 494 */       this.occupation = _o_.occupation;
/* 495 */       this.rank = _o_.rank;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 500 */       this.occupation = _o_.occupation;
/* 501 */       this.rank = _o_.rank;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.occupation);
/* 508 */       _os_.marshal(this.rank);
/* 509 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       this.occupation = _os_.unmarshal_int();
/* 516 */       this.rank = _os_.unmarshal_int();
/* 517 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 523 */       int _size_ = 0;
/* 524 */       _size_ += CodedOutputStream.computeInt32Size(1, this.occupation);
/* 525 */       _size_ += CodedOutputStream.computeInt32Size(2, this.rank);
/* 526 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         _output_.writeInt32(1, this.occupation);
/* 535 */         _output_.writeInt32(2, this.rank);
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
/* 562 */             this.occupation = _input_.readInt32();
/* 563 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 567 */             this.rank = _input_.readInt32();
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
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toBean()
/*     */     {
/* 606 */       return new RoleBigBossRemoteChartAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleBigBossRemoteChartAwardInfo toBeanIf()
/*     */     {
/* 617 */       return new RoleBigBossRemoteChartAwardInfo(this, null, null);
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
/*     */     public int getOccupation()
/*     */     {
/* 654 */       return this.occupation;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRank()
/*     */     {
/* 661 */       return this.rank;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOccupation(int _v_)
/*     */     {
/* 668 */       this.occupation = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRank(int _v_)
/*     */     {
/* 675 */       this.rank = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (this.occupation != _o_.occupation) return false;
/* 684 */       if (this.rank != _o_.rank) return false;
/* 685 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 691 */       int _h_ = 0;
/* 692 */       _h_ += this.occupation;
/* 693 */       _h_ += this.rank;
/* 694 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 700 */       StringBuilder _sb_ = new StringBuilder();
/* 701 */       _sb_.append("(");
/* 702 */       _sb_.append(this.occupation);
/* 703 */       _sb_.append(",");
/* 704 */       _sb_.append(this.rank);
/* 705 */       _sb_.append(")");
/* 706 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleBigBossRemoteChartAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */