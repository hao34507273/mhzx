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
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class StoryInfo extends XBean implements xbean.StoryInfo
/*     */ {
/*     */   private ArrayList<Integer> storyids;
/*     */   private long readtime;
/*     */   private long awardtime;
/*     */   private long storytime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.storyids.clear();
/*  25 */     this.readtime = 0L;
/*  26 */     this.awardtime = 0L;
/*  27 */     this.storytime = 0L;
/*     */   }
/*     */   
/*     */   StoryInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.storyids = new ArrayList();
/*  34 */     this.readtime = 0L;
/*  35 */     this.awardtime = 0L;
/*  36 */     this.storytime = 0L;
/*     */   }
/*     */   
/*     */   public StoryInfo()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public StoryInfo(StoryInfo _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   StoryInfo(xbean.StoryInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof StoryInfo)) { assign((StoryInfo)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(StoryInfo _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.storyids = new ArrayList();
/*  62 */     this.storyids.addAll(_o_.storyids);
/*  63 */     this.readtime = _o_.readtime;
/*  64 */     this.awardtime = _o_.awardtime;
/*  65 */     this.storytime = _o_.storytime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  70 */     this.storyids = new ArrayList();
/*  71 */     this.storyids.addAll(_o_.storyids);
/*  72 */     this.readtime = _o_.readtime;
/*  73 */     this.awardtime = _o_.awardtime;
/*  74 */     this.storytime = _o_.storytime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.compact_uint32(this.storyids.size());
/*  82 */     for (Integer _v_ : this.storyids)
/*     */     {
/*  84 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  86 */     _os_.marshal(this.readtime);
/*  87 */     _os_.marshal(this.awardtime);
/*  88 */     _os_.marshal(this.storytime);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       int _v_ = 0;
/*  99 */       _v_ = _os_.unmarshal_int();
/* 100 */       this.storyids.add(Integer.valueOf(_v_));
/*     */     }
/* 102 */     this.readtime = _os_.unmarshal_long();
/* 103 */     this.awardtime = _os_.unmarshal_long();
/* 104 */     this.storytime = _os_.unmarshal_long();
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 111 */     _xdb_verify_unsafe_();
/* 112 */     int _size_ = 0;
/* 113 */     for (Integer _v_ : this.storyids)
/*     */     {
/* 115 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 117 */     _size_ += CodedOutputStream.computeInt64Size(2, this.readtime);
/* 118 */     _size_ += CodedOutputStream.computeInt64Size(3, this.awardtime);
/* 119 */     _size_ += CodedOutputStream.computeInt64Size(4, this.storytime);
/* 120 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       for (Integer _v_ : this.storyids)
/*     */       {
/* 131 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 133 */       _output_.writeInt64(2, this.readtime);
/* 134 */       _output_.writeInt64(3, this.awardtime);
/* 135 */       _output_.writeInt64(4, this.storytime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 139 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 141 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 147 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 150 */       boolean done = false;
/* 151 */       while (!done)
/*     */       {
/* 153 */         int tag = _input_.readTag();
/* 154 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 158 */           done = true;
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 163 */           int _v_ = 0;
/* 164 */           _v_ = _input_.readInt32();
/* 165 */           this.storyids.add(Integer.valueOf(_v_));
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.readtime = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           this.awardtime = _input_.readInt64();
/* 176 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 180 */           this.storytime = _input_.readInt64();
/* 181 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 185 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 187 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 196 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 202 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.StoryInfo copy()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return new StoryInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.StoryInfo toData()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.StoryInfo toBean()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new StoryInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.StoryInfo toDataIf()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.StoryInfo toBeanIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getStoryids()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     return xdb.Logs.logList(new LogKey(this, "storyids"), this.storyids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getStoryidsAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     StoryInfo _o_ = this;
/* 259 */     List<Integer> storyids = new ArrayList();
/* 260 */     storyids.addAll(_o_.storyids);
/* 261 */     return storyids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getReadtime()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     return this.readtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAwardtime()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/* 277 */     return this.awardtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStorytime()
/*     */   {
/* 284 */     _xdb_verify_unsafe_();
/* 285 */     return this.storytime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReadtime(long _v_)
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     xdb.Logs.logIf(new LogKey(this, "readtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 297 */         new LogLong(this, StoryInfo.this.readtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 301 */             StoryInfo.this.readtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 305 */     });
/* 306 */     this.readtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwardtime(long _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "awardtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new LogLong(this, StoryInfo.this.awardtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             StoryInfo.this.awardtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.awardtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStorytime(long _v_)
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     xdb.Logs.logIf(new LogKey(this, "storytime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 339 */         new LogLong(this, StoryInfo.this.storytime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 343 */             StoryInfo.this.storytime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 347 */     });
/* 348 */     this.storytime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     StoryInfo _o_ = null;
/* 356 */     if ((_o1_ instanceof StoryInfo)) { _o_ = (StoryInfo)_o1_;
/* 357 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 358 */       return false;
/* 359 */     if (!this.storyids.equals(_o_.storyids)) return false;
/* 360 */     if (this.readtime != _o_.readtime) return false;
/* 361 */     if (this.awardtime != _o_.awardtime) return false;
/* 362 */     if (this.storytime != _o_.storytime) return false;
/* 363 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     int _h_ = 0;
/* 371 */     _h_ += this.storyids.hashCode();
/* 372 */     _h_ = (int)(_h_ + this.readtime);
/* 373 */     _h_ = (int)(_h_ + this.awardtime);
/* 374 */     _h_ = (int)(_h_ + this.storytime);
/* 375 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 381 */     _xdb_verify_unsafe_();
/* 382 */     StringBuilder _sb_ = new StringBuilder();
/* 383 */     _sb_.append("(");
/* 384 */     _sb_.append(this.storyids);
/* 385 */     _sb_.append(",");
/* 386 */     _sb_.append(this.readtime);
/* 387 */     _sb_.append(",");
/* 388 */     _sb_.append(this.awardtime);
/* 389 */     _sb_.append(",");
/* 390 */     _sb_.append(this.storytime);
/* 391 */     _sb_.append(")");
/* 392 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 398 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 399 */     lb.add(new ListenableChanged().setVarName("storyids"));
/* 400 */     lb.add(new ListenableChanged().setVarName("readtime"));
/* 401 */     lb.add(new ListenableChanged().setVarName("awardtime"));
/* 402 */     lb.add(new ListenableChanged().setVarName("storytime"));
/* 403 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.StoryInfo {
/*     */     private Const() {}
/*     */     
/*     */     StoryInfo nThis() {
/* 410 */       return StoryInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StoryInfo copy()
/*     */     {
/* 422 */       return StoryInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StoryInfo toData()
/*     */     {
/* 428 */       return StoryInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.StoryInfo toBean()
/*     */     {
/* 433 */       return StoryInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StoryInfo toDataIf()
/*     */     {
/* 439 */       return StoryInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.StoryInfo toBeanIf()
/*     */     {
/* 444 */       return StoryInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getStoryids()
/*     */     {
/* 451 */       StoryInfo.this._xdb_verify_unsafe_();
/* 452 */       return xdb.Consts.constList(StoryInfo.this.storyids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getStoryidsAsData()
/*     */     {
/* 458 */       StoryInfo.this._xdb_verify_unsafe_();
/*     */       
/* 460 */       StoryInfo _o_ = StoryInfo.this;
/* 461 */       List<Integer> storyids = new ArrayList();
/* 462 */       storyids.addAll(_o_.storyids);
/* 463 */       return storyids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReadtime()
/*     */     {
/* 470 */       StoryInfo.this._xdb_verify_unsafe_();
/* 471 */       return StoryInfo.this.readtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAwardtime()
/*     */     {
/* 478 */       StoryInfo.this._xdb_verify_unsafe_();
/* 479 */       return StoryInfo.this.awardtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStorytime()
/*     */     {
/* 486 */       StoryInfo.this._xdb_verify_unsafe_();
/* 487 */       return StoryInfo.this.storytime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReadtime(long _v_)
/*     */     {
/* 494 */       StoryInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardtime(long _v_)
/*     */     {
/* 502 */       StoryInfo.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStorytime(long _v_)
/*     */     {
/* 510 */       StoryInfo.this._xdb_verify_unsafe_();
/* 511 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 517 */       StoryInfo.this._xdb_verify_unsafe_();
/* 518 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 524 */       StoryInfo.this._xdb_verify_unsafe_();
/* 525 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 531 */       return StoryInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 537 */       return StoryInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 543 */       StoryInfo.this._xdb_verify_unsafe_();
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 550 */       return StoryInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 556 */       return StoryInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 562 */       StoryInfo.this._xdb_verify_unsafe_();
/* 563 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 569 */       return StoryInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 575 */       return StoryInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 581 */       return StoryInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 587 */       return StoryInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 593 */       return StoryInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 599 */       return StoryInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 605 */       return StoryInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.StoryInfo
/*     */   {
/*     */     private ArrayList<Integer> storyids;
/*     */     
/*     */     private long readtime;
/*     */     
/*     */     private long awardtime;
/*     */     
/*     */     private long storytime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 628 */       this.storyids = new ArrayList();
/* 629 */       this.readtime = 0L;
/* 630 */       this.awardtime = 0L;
/* 631 */       this.storytime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.StoryInfo _o1_)
/*     */     {
/* 636 */       if ((_o1_ instanceof StoryInfo)) { assign((StoryInfo)_o1_);
/* 637 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 638 */       } else if ((_o1_ instanceof StoryInfo.Const)) assign(((StoryInfo.Const)_o1_).nThis()); else {
/* 639 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(StoryInfo _o_) {
/* 644 */       this.storyids = new ArrayList();
/* 645 */       this.storyids.addAll(_o_.storyids);
/* 646 */       this.readtime = _o_.readtime;
/* 647 */       this.awardtime = _o_.awardtime;
/* 648 */       this.storytime = _o_.storytime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 653 */       this.storyids = new ArrayList();
/* 654 */       this.storyids.addAll(_o_.storyids);
/* 655 */       this.readtime = _o_.readtime;
/* 656 */       this.awardtime = _o_.awardtime;
/* 657 */       this.storytime = _o_.storytime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 663 */       _os_.compact_uint32(this.storyids.size());
/* 664 */       for (Integer _v_ : this.storyids)
/*     */       {
/* 666 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 668 */       _os_.marshal(this.readtime);
/* 669 */       _os_.marshal(this.awardtime);
/* 670 */       _os_.marshal(this.storytime);
/* 671 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 677 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 679 */         int _v_ = 0;
/* 680 */         _v_ = _os_.unmarshal_int();
/* 681 */         this.storyids.add(Integer.valueOf(_v_));
/*     */       }
/* 683 */       this.readtime = _os_.unmarshal_long();
/* 684 */       this.awardtime = _os_.unmarshal_long();
/* 685 */       this.storytime = _os_.unmarshal_long();
/* 686 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 692 */       int _size_ = 0;
/* 693 */       for (Integer _v_ : this.storyids)
/*     */       {
/* 695 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 697 */       _size_ += CodedOutputStream.computeInt64Size(2, this.readtime);
/* 698 */       _size_ += CodedOutputStream.computeInt64Size(3, this.awardtime);
/* 699 */       _size_ += CodedOutputStream.computeInt64Size(4, this.storytime);
/* 700 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 708 */         for (Integer _v_ : this.storyids)
/*     */         {
/* 710 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 712 */         _output_.writeInt64(2, this.readtime);
/* 713 */         _output_.writeInt64(3, this.awardtime);
/* 714 */         _output_.writeInt64(4, this.storytime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 718 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 720 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 728 */         boolean done = false;
/* 729 */         while (!done)
/*     */         {
/* 731 */           int tag = _input_.readTag();
/* 732 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 736 */             done = true;
/* 737 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 741 */             int _v_ = 0;
/* 742 */             _v_ = _input_.readInt32();
/* 743 */             this.storyids.add(Integer.valueOf(_v_));
/* 744 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 748 */             this.readtime = _input_.readInt64();
/* 749 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 753 */             this.awardtime = _input_.readInt64();
/* 754 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 758 */             this.storytime = _input_.readInt64();
/* 759 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 763 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 765 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 774 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 778 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 780 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StoryInfo copy()
/*     */     {
/* 786 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StoryInfo toData()
/*     */     {
/* 792 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.StoryInfo toBean()
/*     */     {
/* 797 */       return new StoryInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StoryInfo toDataIf()
/*     */     {
/* 803 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.StoryInfo toBeanIf()
/*     */     {
/* 808 */       return new StoryInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 814 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 818 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 822 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 826 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 830 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 834 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 838 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getStoryids()
/*     */     {
/* 845 */       return this.storyids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getStoryidsAsData()
/*     */     {
/* 852 */       return this.storyids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReadtime()
/*     */     {
/* 859 */       return this.readtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAwardtime()
/*     */     {
/* 866 */       return this.awardtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStorytime()
/*     */     {
/* 873 */       return this.storytime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReadtime(long _v_)
/*     */     {
/* 880 */       this.readtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardtime(long _v_)
/*     */     {
/* 887 */       this.awardtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStorytime(long _v_)
/*     */     {
/* 894 */       this.storytime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 900 */       if (!(_o1_ instanceof Data)) return false;
/* 901 */       Data _o_ = (Data)_o1_;
/* 902 */       if (!this.storyids.equals(_o_.storyids)) return false;
/* 903 */       if (this.readtime != _o_.readtime) return false;
/* 904 */       if (this.awardtime != _o_.awardtime) return false;
/* 905 */       if (this.storytime != _o_.storytime) return false;
/* 906 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 912 */       int _h_ = 0;
/* 913 */       _h_ += this.storyids.hashCode();
/* 914 */       _h_ = (int)(_h_ + this.readtime);
/* 915 */       _h_ = (int)(_h_ + this.awardtime);
/* 916 */       _h_ = (int)(_h_ + this.storytime);
/* 917 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 923 */       StringBuilder _sb_ = new StringBuilder();
/* 924 */       _sb_.append("(");
/* 925 */       _sb_.append(this.storyids);
/* 926 */       _sb_.append(",");
/* 927 */       _sb_.append(this.readtime);
/* 928 */       _sb_.append(",");
/* 929 */       _sb_.append(this.awardtime);
/* 930 */       _sb_.append(",");
/* 931 */       _sb_.append(this.storytime);
/* 932 */       _sb_.append(")");
/* 933 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\StoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */