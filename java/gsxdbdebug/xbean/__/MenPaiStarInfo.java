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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class MenPaiStarInfo extends XBean implements xbean.MenPaiStarInfo
/*     */ {
/*     */   private boolean finished;
/*     */   private long start_time;
/*     */   private long end_time;
/*     */   private long champion;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.finished = false;
/*  25 */     this.start_time = 0L;
/*  26 */     this.end_time = 0L;
/*  27 */     this.champion = 0L;
/*     */   }
/*     */   
/*     */   MenPaiStarInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.finished = false;
/*     */   }
/*     */   
/*     */   public MenPaiStarInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MenPaiStarInfo(MenPaiStarInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MenPaiStarInfo(xbean.MenPaiStarInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof MenPaiStarInfo)) { assign((MenPaiStarInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MenPaiStarInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.finished = _o_.finished;
/*  59 */     this.start_time = _o_.start_time;
/*  60 */     this.end_time = _o_.end_time;
/*  61 */     this.champion = _o_.champion;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.finished = _o_.finished;
/*  67 */     this.start_time = _o_.start_time;
/*  68 */     this.end_time = _o_.end_time;
/*  69 */     this.champion = _o_.champion;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.finished);
/*  77 */     _os_.marshal(this.start_time);
/*  78 */     _os_.marshal(this.end_time);
/*  79 */     _os_.marshal(this.champion);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.finished = _os_.unmarshal_boolean();
/*  88 */     this.start_time = _os_.unmarshal_long();
/*  89 */     this.end_time = _os_.unmarshal_long();
/*  90 */     this.champion = _os_.unmarshal_long();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeBoolSize(1, this.finished);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(2, this.start_time);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(3, this.end_time);
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(4, this.champion);
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       _output_.writeBool(1, this.finished);
/* 113 */       _output_.writeInt64(2, this.start_time);
/* 114 */       _output_.writeInt64(3, this.end_time);
/* 115 */       _output_.writeInt64(4, this.champion);
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
/* 143 */           this.finished = _input_.readBool();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 148 */           this.start_time = _input_.readInt64();
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 153 */           this.end_time = _input_.readInt64();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 158 */           this.champion = _input_.readInt64();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 163 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 165 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 174 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 178 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 180 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenPaiStarInfo copy()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new MenPaiStarInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenPaiStarInfo toData()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MenPaiStarInfo toBean()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new MenPaiStarInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenPaiStarInfo toDataIf()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MenPaiStarInfo toBeanIf()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getFinished()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return this.finished;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStart_time()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     return this.start_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getEnd_time()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     return this.end_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getChampion()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this.champion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFinished(boolean _v_)
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     xdb.Logs.logIf(new LogKey(this, "finished")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 264 */         new xdb.logs.LogObject(this, Boolean.valueOf(MenPaiStarInfo.this.finished))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 268 */             MenPaiStarInfo.this.finished = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 272 */     });
/* 273 */     this.finished = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStart_time(long _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "start_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 285 */         new LogLong(this, MenPaiStarInfo.this.start_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             MenPaiStarInfo.this.start_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.start_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEnd_time(long _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "end_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 306 */         new LogLong(this, MenPaiStarInfo.this.end_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             MenPaiStarInfo.this.end_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.end_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChampion(long _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "champion")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 327 */         new LogLong(this, MenPaiStarInfo.this.champion)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             MenPaiStarInfo.this.champion = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.champion = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 342 */     _xdb_verify_unsafe_();
/* 343 */     MenPaiStarInfo _o_ = null;
/* 344 */     if ((_o1_ instanceof MenPaiStarInfo)) { _o_ = (MenPaiStarInfo)_o1_;
/* 345 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 346 */       return false;
/* 347 */     if (this.finished != _o_.finished) return false;
/* 348 */     if (this.start_time != _o_.start_time) return false;
/* 349 */     if (this.end_time != _o_.end_time) return false;
/* 350 */     if (this.champion != _o_.champion) return false;
/* 351 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     int _h_ = 0;
/* 359 */     _h_ += (this.finished ? 1231 : 1237);
/* 360 */     _h_ = (int)(_h_ + this.start_time);
/* 361 */     _h_ = (int)(_h_ + this.end_time);
/* 362 */     _h_ = (int)(_h_ + this.champion);
/* 363 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     StringBuilder _sb_ = new StringBuilder();
/* 371 */     _sb_.append("(");
/* 372 */     _sb_.append(this.finished);
/* 373 */     _sb_.append(",");
/* 374 */     _sb_.append(this.start_time);
/* 375 */     _sb_.append(",");
/* 376 */     _sb_.append(this.end_time);
/* 377 */     _sb_.append(",");
/* 378 */     _sb_.append(this.champion);
/* 379 */     _sb_.append(")");
/* 380 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 386 */     ListenableBean lb = new ListenableBean();
/* 387 */     lb.add(new ListenableChanged().setVarName("finished"));
/* 388 */     lb.add(new ListenableChanged().setVarName("start_time"));
/* 389 */     lb.add(new ListenableChanged().setVarName("end_time"));
/* 390 */     lb.add(new ListenableChanged().setVarName("champion"));
/* 391 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MenPaiStarInfo {
/*     */     private Const() {}
/*     */     
/*     */     MenPaiStarInfo nThis() {
/* 398 */       return MenPaiStarInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 404 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarInfo copy()
/*     */     {
/* 410 */       return MenPaiStarInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarInfo toData()
/*     */     {
/* 416 */       return MenPaiStarInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarInfo toBean()
/*     */     {
/* 421 */       return MenPaiStarInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarInfo toDataIf()
/*     */     {
/* 427 */       return MenPaiStarInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarInfo toBeanIf()
/*     */     {
/* 432 */       return MenPaiStarInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getFinished()
/*     */     {
/* 439 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 440 */       return MenPaiStarInfo.this.finished;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 447 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 448 */       return MenPaiStarInfo.this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEnd_time()
/*     */     {
/* 455 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 456 */       return MenPaiStarInfo.this.end_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getChampion()
/*     */     {
/* 463 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 464 */       return MenPaiStarInfo.this.champion;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinished(boolean _v_)
/*     */     {
/* 471 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 472 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 479 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 480 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEnd_time(long _v_)
/*     */     {
/* 487 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChampion(long _v_)
/*     */     {
/* 495 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 502 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 503 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 509 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 510 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 516 */       return MenPaiStarInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 522 */       return MenPaiStarInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 528 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 535 */       return MenPaiStarInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 541 */       return MenPaiStarInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 547 */       MenPaiStarInfo.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 554 */       return MenPaiStarInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 560 */       return MenPaiStarInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 566 */       return MenPaiStarInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 572 */       return MenPaiStarInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 578 */       return MenPaiStarInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 584 */       return MenPaiStarInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 590 */       return MenPaiStarInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MenPaiStarInfo
/*     */   {
/*     */     private boolean finished;
/*     */     
/*     */     private long start_time;
/*     */     
/*     */     private long end_time;
/*     */     
/*     */     private long champion;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 608 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 613 */       this.finished = false;
/*     */     }
/*     */     
/*     */     Data(xbean.MenPaiStarInfo _o1_)
/*     */     {
/* 618 */       if ((_o1_ instanceof MenPaiStarInfo)) { assign((MenPaiStarInfo)_o1_);
/* 619 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 620 */       } else if ((_o1_ instanceof MenPaiStarInfo.Const)) assign(((MenPaiStarInfo.Const)_o1_).nThis()); else {
/* 621 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MenPaiStarInfo _o_) {
/* 626 */       this.finished = _o_.finished;
/* 627 */       this.start_time = _o_.start_time;
/* 628 */       this.end_time = _o_.end_time;
/* 629 */       this.champion = _o_.champion;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 634 */       this.finished = _o_.finished;
/* 635 */       this.start_time = _o_.start_time;
/* 636 */       this.end_time = _o_.end_time;
/* 637 */       this.champion = _o_.champion;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 643 */       _os_.marshal(this.finished);
/* 644 */       _os_.marshal(this.start_time);
/* 645 */       _os_.marshal(this.end_time);
/* 646 */       _os_.marshal(this.champion);
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 653 */       this.finished = _os_.unmarshal_boolean();
/* 654 */       this.start_time = _os_.unmarshal_long();
/* 655 */       this.end_time = _os_.unmarshal_long();
/* 656 */       this.champion = _os_.unmarshal_long();
/* 657 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 663 */       int _size_ = 0;
/* 664 */       _size_ += CodedOutputStream.computeBoolSize(1, this.finished);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(2, this.start_time);
/* 666 */       _size_ += CodedOutputStream.computeInt64Size(3, this.end_time);
/* 667 */       _size_ += CodedOutputStream.computeInt64Size(4, this.champion);
/* 668 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 676 */         _output_.writeBool(1, this.finished);
/* 677 */         _output_.writeInt64(2, this.start_time);
/* 678 */         _output_.writeInt64(3, this.end_time);
/* 679 */         _output_.writeInt64(4, this.champion);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 683 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 685 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 693 */         boolean done = false;
/* 694 */         while (!done)
/*     */         {
/* 696 */           int tag = _input_.readTag();
/* 697 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 701 */             done = true;
/* 702 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 706 */             this.finished = _input_.readBool();
/* 707 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 711 */             this.start_time = _input_.readInt64();
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 716 */             this.end_time = _input_.readInt64();
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 721 */             this.champion = _input_.readInt64();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarInfo toBean()
/*     */     {
/* 760 */       return new MenPaiStarInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenPaiStarInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MenPaiStarInfo toBeanIf()
/*     */     {
/* 771 */       return new MenPaiStarInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getFinished()
/*     */     {
/* 808 */       return this.finished;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_time()
/*     */     {
/* 815 */       return this.start_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEnd_time()
/*     */     {
/* 822 */       return this.end_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getChampion()
/*     */     {
/* 829 */       return this.champion;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinished(boolean _v_)
/*     */     {
/* 836 */       this.finished = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_time(long _v_)
/*     */     {
/* 843 */       this.start_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEnd_time(long _v_)
/*     */     {
/* 850 */       this.end_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChampion(long _v_)
/*     */     {
/* 857 */       this.champion = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 863 */       if (!(_o1_ instanceof Data)) return false;
/* 864 */       Data _o_ = (Data)_o1_;
/* 865 */       if (this.finished != _o_.finished) return false;
/* 866 */       if (this.start_time != _o_.start_time) return false;
/* 867 */       if (this.end_time != _o_.end_time) return false;
/* 868 */       if (this.champion != _o_.champion) return false;
/* 869 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 875 */       int _h_ = 0;
/* 876 */       _h_ += (this.finished ? 1231 : 1237);
/* 877 */       _h_ = (int)(_h_ + this.start_time);
/* 878 */       _h_ = (int)(_h_ + this.end_time);
/* 879 */       _h_ = (int)(_h_ + this.champion);
/* 880 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 886 */       StringBuilder _sb_ = new StringBuilder();
/* 887 */       _sb_.append("(");
/* 888 */       _sb_.append(this.finished);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.start_time);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.end_time);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.champion);
/* 895 */       _sb_.append(")");
/* 896 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MenPaiStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */