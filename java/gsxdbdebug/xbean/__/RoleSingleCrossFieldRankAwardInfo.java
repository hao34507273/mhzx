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
/*     */ public final class RoleSingleCrossFieldRankAwardInfo extends XBean implements xbean.RoleSingleCrossFieldRankAwardInfo
/*     */ {
/*     */   private int rank;
/*     */   private boolean awarded;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.rank = 0;
/*  21 */     this.awarded = false;
/*     */   }
/*     */   
/*     */   RoleSingleCrossFieldRankAwardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.rank = 0;
/*  28 */     this.awarded = false;
/*     */   }
/*     */   
/*     */   public RoleSingleCrossFieldRankAwardInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleSingleCrossFieldRankAwardInfo(RoleSingleCrossFieldRankAwardInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleSingleCrossFieldRankAwardInfo(xbean.RoleSingleCrossFieldRankAwardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RoleSingleCrossFieldRankAwardInfo)) { assign((RoleSingleCrossFieldRankAwardInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleSingleCrossFieldRankAwardInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.rank = _o_.rank;
/*  54 */     this.awarded = _o_.awarded;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.rank = _o_.rank;
/*  60 */     this.awarded = _o_.awarded;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.rank);
/*  68 */     _os_.marshal(this.awarded);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.rank = _os_.unmarshal_int();
/*  77 */     this.awarded = _os_.unmarshal_boolean();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt32Size(1, this.rank);
/*  87 */     _size_ += CodedOutputStream.computeBoolSize(2, this.awarded);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt32(1, this.rank);
/*  98 */       _output_.writeBool(2, this.awarded);
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
/* 126 */           this.rank = _input_.readInt32();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.awarded = _input_.readBool();
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
/*     */   public xbean.RoleSingleCrossFieldRankAwardInfo copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new RoleSingleCrossFieldRankAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldRankAwardInfo toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleSingleCrossFieldRankAwardInfo toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new RoleSingleCrossFieldRankAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldRankAwardInfo toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleSingleCrossFieldRankAwardInfo toBeanIf()
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
/*     */   public int getRank()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAwarded()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.awarded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRank(int _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "rank")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new xdb.logs.LogInt(this, RoleSingleCrossFieldRankAwardInfo.this.rank)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             RoleSingleCrossFieldRankAwardInfo.this.rank = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.rank = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwarded(boolean _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "awarded")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogObject(this, Boolean.valueOf(RoleSingleCrossFieldRankAwardInfo.this.awarded))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             RoleSingleCrossFieldRankAwardInfo.this.awarded = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.awarded = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     RoleSingleCrossFieldRankAwardInfo _o_ = null;
/* 259 */     if ((_o1_ instanceof RoleSingleCrossFieldRankAwardInfo)) { _o_ = (RoleSingleCrossFieldRankAwardInfo)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.rank != _o_.rank) return false;
/* 263 */     if (this.awarded != _o_.awarded) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ += this.rank;
/* 273 */     _h_ += (this.awarded ? 1231 : 1237);
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.rank);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.awarded);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     ListenableBean lb = new ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rank"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awarded"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleSingleCrossFieldRankAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleSingleCrossFieldRankAwardInfo nThis() {
/* 303 */       return RoleSingleCrossFieldRankAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo copy()
/*     */     {
/* 315 */       return RoleSingleCrossFieldRankAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toData()
/*     */     {
/* 321 */       return RoleSingleCrossFieldRankAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toBean()
/*     */     {
/* 326 */       return RoleSingleCrossFieldRankAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toDataIf()
/*     */     {
/* 332 */       return RoleSingleCrossFieldRankAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toBeanIf()
/*     */     {
/* 337 */       return RoleSingleCrossFieldRankAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRank()
/*     */     {
/* 344 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 345 */       return RoleSingleCrossFieldRankAwardInfo.this.rank;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded()
/*     */     {
/* 352 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 353 */       return RoleSingleCrossFieldRankAwardInfo.this.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRank(int _v_)
/*     */     {
/* 360 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded(boolean _v_)
/*     */     {
/* 368 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return RoleSingleCrossFieldRankAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return RoleSingleCrossFieldRankAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return RoleSingleCrossFieldRankAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return RoleSingleCrossFieldRankAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       RoleSingleCrossFieldRankAwardInfo.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return RoleSingleCrossFieldRankAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return RoleSingleCrossFieldRankAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return RoleSingleCrossFieldRankAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return RoleSingleCrossFieldRankAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return RoleSingleCrossFieldRankAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return RoleSingleCrossFieldRankAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return RoleSingleCrossFieldRankAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleSingleCrossFieldRankAwardInfo
/*     */   {
/*     */     private int rank;
/*     */     
/*     */     private boolean awarded;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.rank = 0;
/* 483 */       this.awarded = false;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleSingleCrossFieldRankAwardInfo _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof RoleSingleCrossFieldRankAwardInfo)) { assign((RoleSingleCrossFieldRankAwardInfo)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof RoleSingleCrossFieldRankAwardInfo.Const)) assign(((RoleSingleCrossFieldRankAwardInfo.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleSingleCrossFieldRankAwardInfo _o_) {
/* 496 */       this.rank = _o_.rank;
/* 497 */       this.awarded = _o_.awarded;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.rank = _o_.rank;
/* 503 */       this.awarded = _o_.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.rank);
/* 510 */       _os_.marshal(this.awarded);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.rank = _os_.unmarshal_int();
/* 518 */       this.awarded = _os_.unmarshal_boolean();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt32Size(1, this.rank);
/* 527 */       _size_ += CodedOutputStream.computeBoolSize(2, this.awarded);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt32(1, this.rank);
/* 537 */         _output_.writeBool(2, this.awarded);
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
/* 564 */             this.rank = _input_.readInt32();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.awarded = _input_.readBool();
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
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toBean()
/*     */     {
/* 608 */       return new RoleSingleCrossFieldRankAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldRankAwardInfo toBeanIf()
/*     */     {
/* 619 */       return new RoleSingleCrossFieldRankAwardInfo(this, null, null);
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
/*     */     public int getRank()
/*     */     {
/* 656 */       return this.rank;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded()
/*     */     {
/* 663 */       return this.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRank(int _v_)
/*     */     {
/* 670 */       this.rank = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded(boolean _v_)
/*     */     {
/* 677 */       this.awarded = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.rank != _o_.rank) return false;
/* 686 */       if (this.awarded != _o_.awarded) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ += this.rank;
/* 695 */       _h_ += (this.awarded ? 1231 : 1237);
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.rank);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.awarded);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleSingleCrossFieldRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */