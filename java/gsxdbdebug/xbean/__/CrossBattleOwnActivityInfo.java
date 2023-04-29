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
/*     */ public final class CrossBattleOwnActivityInfo extends XBean implements xbean.CrossBattleOwnActivityInfo
/*     */ {
/*     */   private int vote_times;
/*     */   private long vote_timestamp;
/*     */   private long canvass_timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.vote_times = 0;
/*  23 */     this.vote_timestamp = 0L;
/*  24 */     this.canvass_timestamp = 0L;
/*     */   }
/*     */   
/*     */   CrossBattleOwnActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.vote_times = 0;
/*  31 */     this.canvass_timestamp = 0L;
/*     */   }
/*     */   
/*     */   public CrossBattleOwnActivityInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossBattleOwnActivityInfo(CrossBattleOwnActivityInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossBattleOwnActivityInfo(xbean.CrossBattleOwnActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof CrossBattleOwnActivityInfo)) { assign((CrossBattleOwnActivityInfo)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossBattleOwnActivityInfo _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.vote_times = _o_.vote_times;
/*  57 */     this.vote_timestamp = _o_.vote_timestamp;
/*  58 */     this.canvass_timestamp = _o_.canvass_timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.vote_times = _o_.vote_times;
/*  64 */     this.vote_timestamp = _o_.vote_timestamp;
/*  65 */     this.canvass_timestamp = _o_.canvass_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _xdb_verify_unsafe_();
/*  72 */     _os_.marshal(this.vote_times);
/*  73 */     _os_.marshal(this.vote_timestamp);
/*  74 */     _os_.marshal(this.canvass_timestamp);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.vote_times = _os_.unmarshal_int();
/*  83 */     this.vote_timestamp = _os_.unmarshal_long();
/*  84 */     this.canvass_timestamp = _os_.unmarshal_long();
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     int _size_ = 0;
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(1, this.vote_times);
/*  94 */     _size_ += CodedOutputStream.computeInt64Size(2, this.vote_timestamp);
/*  95 */     _size_ += CodedOutputStream.computeInt64Size(3, this.canvass_timestamp);
/*  96 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 102 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 105 */       _output_.writeInt32(1, this.vote_times);
/* 106 */       _output_.writeInt64(2, this.vote_timestamp);
/* 107 */       _output_.writeInt64(3, this.canvass_timestamp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 111 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 113 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       boolean done = false;
/* 123 */       while (!done)
/*     */       {
/* 125 */         int tag = _input_.readTag();
/* 126 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 130 */           done = true;
/* 131 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 135 */           this.vote_times = _input_.readInt32();
/* 136 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 140 */           this.vote_timestamp = _input_.readInt64();
/* 141 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 145 */           this.canvass_timestamp = _input_.readInt64();
/* 146 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 150 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 152 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 161 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 165 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 167 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleOwnActivityInfo copy()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return new CrossBattleOwnActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleOwnActivityInfo toData()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossBattleOwnActivityInfo toBean()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new CrossBattleOwnActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossBattleOwnActivityInfo toDataIf()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossBattleOwnActivityInfo toBeanIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getVote_times()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return this.vote_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getVote_timestamp()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return this.vote_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCanvass_timestamp()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.canvass_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVote_times(int _v_)
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     xdb.Logs.logIf(new LogKey(this, "vote_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 243 */         new xdb.logs.LogInt(this, CrossBattleOwnActivityInfo.this.vote_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 247 */             CrossBattleOwnActivityInfo.this.vote_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 251 */     });
/* 252 */     this.vote_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVote_timestamp(long _v_)
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     xdb.Logs.logIf(new LogKey(this, "vote_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 264 */         new xdb.logs.LogLong(this, CrossBattleOwnActivityInfo.this.vote_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 268 */             CrossBattleOwnActivityInfo.this.vote_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 272 */     });
/* 273 */     this.vote_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCanvass_timestamp(long _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "canvass_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 285 */         new xdb.logs.LogLong(this, CrossBattleOwnActivityInfo.this.canvass_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             CrossBattleOwnActivityInfo.this.canvass_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.canvass_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     CrossBattleOwnActivityInfo _o_ = null;
/* 302 */     if ((_o1_ instanceof CrossBattleOwnActivityInfo)) { _o_ = (CrossBattleOwnActivityInfo)_o1_;
/* 303 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 304 */       return false;
/* 305 */     if (this.vote_times != _o_.vote_times) return false;
/* 306 */     if (this.vote_timestamp != _o_.vote_timestamp) return false;
/* 307 */     if (this.canvass_timestamp != _o_.canvass_timestamp) return false;
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     int _h_ = 0;
/* 316 */     _h_ += this.vote_times;
/* 317 */     _h_ = (int)(_h_ + this.vote_timestamp);
/* 318 */     _h_ = (int)(_h_ + this.canvass_timestamp);
/* 319 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     StringBuilder _sb_ = new StringBuilder();
/* 327 */     _sb_.append("(");
/* 328 */     _sb_.append(this.vote_times);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.vote_timestamp);
/* 331 */     _sb_.append(",");
/* 332 */     _sb_.append(this.canvass_timestamp);
/* 333 */     _sb_.append(")");
/* 334 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 340 */     ListenableBean lb = new ListenableBean();
/* 341 */     lb.add(new ListenableChanged().setVarName("vote_times"));
/* 342 */     lb.add(new ListenableChanged().setVarName("vote_timestamp"));
/* 343 */     lb.add(new ListenableChanged().setVarName("canvass_timestamp"));
/* 344 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossBattleOwnActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     CrossBattleOwnActivityInfo nThis() {
/* 351 */       return CrossBattleOwnActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 357 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnActivityInfo copy()
/*     */     {
/* 363 */       return CrossBattleOwnActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnActivityInfo toData()
/*     */     {
/* 369 */       return CrossBattleOwnActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnActivityInfo toBean()
/*     */     {
/* 374 */       return CrossBattleOwnActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnActivityInfo toDataIf()
/*     */     {
/* 380 */       return CrossBattleOwnActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnActivityInfo toBeanIf()
/*     */     {
/* 385 */       return CrossBattleOwnActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getVote_times()
/*     */     {
/* 392 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 393 */       return CrossBattleOwnActivityInfo.this.vote_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getVote_timestamp()
/*     */     {
/* 400 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 401 */       return CrossBattleOwnActivityInfo.this.vote_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCanvass_timestamp()
/*     */     {
/* 408 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 409 */       return CrossBattleOwnActivityInfo.this.canvass_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVote_times(int _v_)
/*     */     {
/* 416 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 417 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVote_timestamp(long _v_)
/*     */     {
/* 424 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 425 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCanvass_timestamp(long _v_)
/*     */     {
/* 432 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 433 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 439 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 440 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 446 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 447 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 453 */       return CrossBattleOwnActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       return CrossBattleOwnActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 465 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 466 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 472 */       return CrossBattleOwnActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 478 */       return CrossBattleOwnActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 484 */       CrossBattleOwnActivityInfo.this._xdb_verify_unsafe_();
/* 485 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 491 */       return CrossBattleOwnActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 497 */       return CrossBattleOwnActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 503 */       return CrossBattleOwnActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 509 */       return CrossBattleOwnActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 515 */       return CrossBattleOwnActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 521 */       return CrossBattleOwnActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 527 */       return CrossBattleOwnActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossBattleOwnActivityInfo
/*     */   {
/*     */     private int vote_times;
/*     */     
/*     */     private long vote_timestamp;
/*     */     
/*     */     private long canvass_timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 548 */       this.vote_times = 0;
/* 549 */       this.canvass_timestamp = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.CrossBattleOwnActivityInfo _o1_)
/*     */     {
/* 554 */       if ((_o1_ instanceof CrossBattleOwnActivityInfo)) { assign((CrossBattleOwnActivityInfo)_o1_);
/* 555 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 556 */       } else if ((_o1_ instanceof CrossBattleOwnActivityInfo.Const)) assign(((CrossBattleOwnActivityInfo.Const)_o1_).nThis()); else {
/* 557 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossBattleOwnActivityInfo _o_) {
/* 562 */       this.vote_times = _o_.vote_times;
/* 563 */       this.vote_timestamp = _o_.vote_timestamp;
/* 564 */       this.canvass_timestamp = _o_.canvass_timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 569 */       this.vote_times = _o_.vote_times;
/* 570 */       this.vote_timestamp = _o_.vote_timestamp;
/* 571 */       this.canvass_timestamp = _o_.canvass_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 577 */       _os_.marshal(this.vote_times);
/* 578 */       _os_.marshal(this.vote_timestamp);
/* 579 */       _os_.marshal(this.canvass_timestamp);
/* 580 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 586 */       this.vote_times = _os_.unmarshal_int();
/* 587 */       this.vote_timestamp = _os_.unmarshal_long();
/* 588 */       this.canvass_timestamp = _os_.unmarshal_long();
/* 589 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 595 */       int _size_ = 0;
/* 596 */       _size_ += CodedOutputStream.computeInt32Size(1, this.vote_times);
/* 597 */       _size_ += CodedOutputStream.computeInt64Size(2, this.vote_timestamp);
/* 598 */       _size_ += CodedOutputStream.computeInt64Size(3, this.canvass_timestamp);
/* 599 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 607 */         _output_.writeInt32(1, this.vote_times);
/* 608 */         _output_.writeInt64(2, this.vote_timestamp);
/* 609 */         _output_.writeInt64(3, this.canvass_timestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 613 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 615 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 623 */         boolean done = false;
/* 624 */         while (!done)
/*     */         {
/* 626 */           int tag = _input_.readTag();
/* 627 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 631 */             done = true;
/* 632 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 636 */             this.vote_times = _input_.readInt32();
/* 637 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 641 */             this.vote_timestamp = _input_.readInt64();
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 646 */             this.canvass_timestamp = _input_.readInt64();
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnActivityInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnActivityInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnActivityInfo toBean()
/*     */     {
/* 685 */       return new CrossBattleOwnActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossBattleOwnActivityInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossBattleOwnActivityInfo toBeanIf()
/*     */     {
/* 696 */       return new CrossBattleOwnActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getVote_times()
/*     */     {
/* 733 */       return this.vote_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getVote_timestamp()
/*     */     {
/* 740 */       return this.vote_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCanvass_timestamp()
/*     */     {
/* 747 */       return this.canvass_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVote_times(int _v_)
/*     */     {
/* 754 */       this.vote_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setVote_timestamp(long _v_)
/*     */     {
/* 761 */       this.vote_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCanvass_timestamp(long _v_)
/*     */     {
/* 768 */       this.canvass_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 774 */       if (!(_o1_ instanceof Data)) return false;
/* 775 */       Data _o_ = (Data)_o1_;
/* 776 */       if (this.vote_times != _o_.vote_times) return false;
/* 777 */       if (this.vote_timestamp != _o_.vote_timestamp) return false;
/* 778 */       if (this.canvass_timestamp != _o_.canvass_timestamp) return false;
/* 779 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 785 */       int _h_ = 0;
/* 786 */       _h_ += this.vote_times;
/* 787 */       _h_ = (int)(_h_ + this.vote_timestamp);
/* 788 */       _h_ = (int)(_h_ + this.canvass_timestamp);
/* 789 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 795 */       StringBuilder _sb_ = new StringBuilder();
/* 796 */       _sb_.append("(");
/* 797 */       _sb_.append(this.vote_times);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.vote_timestamp);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.canvass_timestamp);
/* 802 */       _sb_.append(")");
/* 803 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossBattleOwnActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */