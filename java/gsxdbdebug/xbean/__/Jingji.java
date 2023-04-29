/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class Jingji extends XBean implements xbean.Jingji
/*     */ {
/*     */   private long seasonstarttime;
/*     */   private long rankrefreshtime;
/*     */   private int totalcount;
/*     */   private int merge_clear;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.seasonstarttime = 0L;
/*  25 */     this.rankrefreshtime = 0L;
/*  26 */     this.totalcount = 0;
/*  27 */     this.merge_clear = 0;
/*     */   }
/*     */   
/*     */   Jingji(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.seasonstarttime = 0L;
/*  34 */     this.rankrefreshtime = 0L;
/*  35 */     this.totalcount = 0;
/*  36 */     this.merge_clear = 0;
/*     */   }
/*     */   
/*     */   public Jingji()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Jingji(Jingji _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Jingji(xbean.Jingji _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof Jingji)) { assign((Jingji)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Jingji _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.seasonstarttime = _o_.seasonstarttime;
/*  62 */     this.rankrefreshtime = _o_.rankrefreshtime;
/*  63 */     this.totalcount = _o_.totalcount;
/*  64 */     this.merge_clear = _o_.merge_clear;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.seasonstarttime = _o_.seasonstarttime;
/*  70 */     this.rankrefreshtime = _o_.rankrefreshtime;
/*  71 */     this.totalcount = _o_.totalcount;
/*  72 */     this.merge_clear = _o_.merge_clear;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.seasonstarttime);
/*  80 */     _os_.marshal(this.rankrefreshtime);
/*  81 */     _os_.marshal(this.totalcount);
/*  82 */     _os_.marshal(this.merge_clear);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.seasonstarttime = _os_.unmarshal_long();
/*  91 */     this.rankrefreshtime = _os_.unmarshal_long();
/*  92 */     this.totalcount = _os_.unmarshal_int();
/*  93 */     this.merge_clear = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     int _size_ = 0;
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(1, this.seasonstarttime);
/* 103 */     _size_ += CodedOutputStream.computeInt64Size(2, this.rankrefreshtime);
/* 104 */     _size_ += CodedOutputStream.computeInt32Size(3, this.totalcount);
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(4, this.merge_clear);
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       _output_.writeInt64(1, this.seasonstarttime);
/* 116 */       _output_.writeInt64(2, this.rankrefreshtime);
/* 117 */       _output_.writeInt32(3, this.totalcount);
/* 118 */       _output_.writeInt32(4, this.merge_clear);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 122 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 124 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       boolean done = false;
/* 134 */       while (!done)
/*     */       {
/* 136 */         int tag = _input_.readTag();
/* 137 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 141 */           done = true;
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 146 */           this.seasonstarttime = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.rankrefreshtime = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.totalcount = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 161 */           this.merge_clear = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 166 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 168 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 177 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 183 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Jingji copy()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return new Jingji(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Jingji toData()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Jingji toBean()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new Jingji(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Jingji toDataIf()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Jingji toBeanIf()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSeasonstarttime()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.seasonstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRankrefreshtime()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.rankrefreshtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalcount()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.totalcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMerge_clear()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.merge_clear;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSeasonstarttime(long _v_)
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     xdb.Logs.logIf(new LogKey(this, "seasonstarttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 267 */         new xdb.logs.LogLong(this, Jingji.this.seasonstarttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 271 */             Jingji.this.seasonstarttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 275 */     });
/* 276 */     this.seasonstarttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRankrefreshtime(long _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "rankrefreshtime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 288 */         new xdb.logs.LogLong(this, Jingji.this.rankrefreshtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             Jingji.this.rankrefreshtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.rankrefreshtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalcount(int _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "totalcount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 309 */         new xdb.logs.LogInt(this, Jingji.this.totalcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             Jingji.this.totalcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.totalcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMerge_clear(int _v_)
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     xdb.Logs.logIf(new LogKey(this, "merge_clear")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 330 */         new xdb.logs.LogInt(this, Jingji.this.merge_clear)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 334 */             Jingji.this.merge_clear = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 338 */     });
/* 339 */     this.merge_clear = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     Jingji _o_ = null;
/* 347 */     if ((_o1_ instanceof Jingji)) { _o_ = (Jingji)_o1_;
/* 348 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 349 */       return false;
/* 350 */     if (this.seasonstarttime != _o_.seasonstarttime) return false;
/* 351 */     if (this.rankrefreshtime != _o_.rankrefreshtime) return false;
/* 352 */     if (this.totalcount != _o_.totalcount) return false;
/* 353 */     if (this.merge_clear != _o_.merge_clear) return false;
/* 354 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 360 */     _xdb_verify_unsafe_();
/* 361 */     int _h_ = 0;
/* 362 */     _h_ = (int)(_h_ + this.seasonstarttime);
/* 363 */     _h_ = (int)(_h_ + this.rankrefreshtime);
/* 364 */     _h_ += this.totalcount;
/* 365 */     _h_ += this.merge_clear;
/* 366 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 372 */     _xdb_verify_unsafe_();
/* 373 */     StringBuilder _sb_ = new StringBuilder();
/* 374 */     _sb_.append("(");
/* 375 */     _sb_.append(this.seasonstarttime);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.rankrefreshtime);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.totalcount);
/* 380 */     _sb_.append(",");
/* 381 */     _sb_.append(this.merge_clear);
/* 382 */     _sb_.append(")");
/* 383 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 389 */     ListenableBean lb = new ListenableBean();
/* 390 */     lb.add(new ListenableChanged().setVarName("seasonstarttime"));
/* 391 */     lb.add(new ListenableChanged().setVarName("rankrefreshtime"));
/* 392 */     lb.add(new ListenableChanged().setVarName("totalcount"));
/* 393 */     lb.add(new ListenableChanged().setVarName("merge_clear"));
/* 394 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Jingji {
/*     */     private Const() {}
/*     */     
/*     */     Jingji nThis() {
/* 401 */       return Jingji.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Jingji copy()
/*     */     {
/* 413 */       return Jingji.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Jingji toData()
/*     */     {
/* 419 */       return Jingji.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Jingji toBean()
/*     */     {
/* 424 */       return Jingji.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Jingji toDataIf()
/*     */     {
/* 430 */       return Jingji.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Jingji toBeanIf()
/*     */     {
/* 435 */       return Jingji.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSeasonstarttime()
/*     */     {
/* 442 */       Jingji.this._xdb_verify_unsafe_();
/* 443 */       return Jingji.this.seasonstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRankrefreshtime()
/*     */     {
/* 450 */       Jingji.this._xdb_verify_unsafe_();
/* 451 */       return Jingji.this.rankrefreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalcount()
/*     */     {
/* 458 */       Jingji.this._xdb_verify_unsafe_();
/* 459 */       return Jingji.this.totalcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMerge_clear()
/*     */     {
/* 466 */       Jingji.this._xdb_verify_unsafe_();
/* 467 */       return Jingji.this.merge_clear;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeasonstarttime(long _v_)
/*     */     {
/* 474 */       Jingji.this._xdb_verify_unsafe_();
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRankrefreshtime(long _v_)
/*     */     {
/* 482 */       Jingji.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalcount(int _v_)
/*     */     {
/* 490 */       Jingji.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMerge_clear(int _v_)
/*     */     {
/* 498 */       Jingji.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 505 */       Jingji.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       Jingji.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return Jingji.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return Jingji.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       Jingji.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return Jingji.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return Jingji.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       Jingji.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 557 */       return Jingji.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return Jingji.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return Jingji.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return Jingji.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return Jingji.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return Jingji.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return Jingji.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Jingji
/*     */   {
/*     */     private long seasonstarttime;
/*     */     
/*     */     private long rankrefreshtime;
/*     */     
/*     */     private int totalcount;
/*     */     
/*     */     private int merge_clear;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 616 */       this.seasonstarttime = 0L;
/* 617 */       this.rankrefreshtime = 0L;
/* 618 */       this.totalcount = 0;
/* 619 */       this.merge_clear = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.Jingji _o1_)
/*     */     {
/* 624 */       if ((_o1_ instanceof Jingji)) { assign((Jingji)_o1_);
/* 625 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 626 */       } else if ((_o1_ instanceof Jingji.Const)) assign(((Jingji.Const)_o1_).nThis()); else {
/* 627 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Jingji _o_) {
/* 632 */       this.seasonstarttime = _o_.seasonstarttime;
/* 633 */       this.rankrefreshtime = _o_.rankrefreshtime;
/* 634 */       this.totalcount = _o_.totalcount;
/* 635 */       this.merge_clear = _o_.merge_clear;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 640 */       this.seasonstarttime = _o_.seasonstarttime;
/* 641 */       this.rankrefreshtime = _o_.rankrefreshtime;
/* 642 */       this.totalcount = _o_.totalcount;
/* 643 */       this.merge_clear = _o_.merge_clear;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 649 */       _os_.marshal(this.seasonstarttime);
/* 650 */       _os_.marshal(this.rankrefreshtime);
/* 651 */       _os_.marshal(this.totalcount);
/* 652 */       _os_.marshal(this.merge_clear);
/* 653 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 659 */       this.seasonstarttime = _os_.unmarshal_long();
/* 660 */       this.rankrefreshtime = _os_.unmarshal_long();
/* 661 */       this.totalcount = _os_.unmarshal_int();
/* 662 */       this.merge_clear = _os_.unmarshal_int();
/* 663 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 669 */       int _size_ = 0;
/* 670 */       _size_ += CodedOutputStream.computeInt64Size(1, this.seasonstarttime);
/* 671 */       _size_ += CodedOutputStream.computeInt64Size(2, this.rankrefreshtime);
/* 672 */       _size_ += CodedOutputStream.computeInt32Size(3, this.totalcount);
/* 673 */       _size_ += CodedOutputStream.computeInt32Size(4, this.merge_clear);
/* 674 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 682 */         _output_.writeInt64(1, this.seasonstarttime);
/* 683 */         _output_.writeInt64(2, this.rankrefreshtime);
/* 684 */         _output_.writeInt32(3, this.totalcount);
/* 685 */         _output_.writeInt32(4, this.merge_clear);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 689 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 691 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 699 */         boolean done = false;
/* 700 */         while (!done)
/*     */         {
/* 702 */           int tag = _input_.readTag();
/* 703 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 707 */             done = true;
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 712 */             this.seasonstarttime = _input_.readInt64();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 717 */             this.rankrefreshtime = _input_.readInt64();
/* 718 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 722 */             this.totalcount = _input_.readInt32();
/* 723 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 727 */             this.merge_clear = _input_.readInt32();
/* 728 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 732 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 734 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 743 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Jingji copy()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Jingji toData()
/*     */     {
/* 761 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Jingji toBean()
/*     */     {
/* 766 */       return new Jingji(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Jingji toDataIf()
/*     */     {
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Jingji toBeanIf()
/*     */     {
/* 777 */       return new Jingji(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 799 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 803 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 807 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSeasonstarttime()
/*     */     {
/* 814 */       return this.seasonstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRankrefreshtime()
/*     */     {
/* 821 */       return this.rankrefreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalcount()
/*     */     {
/* 828 */       return this.totalcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMerge_clear()
/*     */     {
/* 835 */       return this.merge_clear;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeasonstarttime(long _v_)
/*     */     {
/* 842 */       this.seasonstarttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRankrefreshtime(long _v_)
/*     */     {
/* 849 */       this.rankrefreshtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalcount(int _v_)
/*     */     {
/* 856 */       this.totalcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMerge_clear(int _v_)
/*     */     {
/* 863 */       this.merge_clear = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.seasonstarttime != _o_.seasonstarttime) return false;
/* 872 */       if (this.rankrefreshtime != _o_.rankrefreshtime) return false;
/* 873 */       if (this.totalcount != _o_.totalcount) return false;
/* 874 */       if (this.merge_clear != _o_.merge_clear) return false;
/* 875 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 881 */       int _h_ = 0;
/* 882 */       _h_ = (int)(_h_ + this.seasonstarttime);
/* 883 */       _h_ = (int)(_h_ + this.rankrefreshtime);
/* 884 */       _h_ += this.totalcount;
/* 885 */       _h_ += this.merge_clear;
/* 886 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 892 */       StringBuilder _sb_ = new StringBuilder();
/* 893 */       _sb_.append("(");
/* 894 */       _sb_.append(this.seasonstarttime);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.rankrefreshtime);
/* 897 */       _sb_.append(",");
/* 898 */       _sb_.append(this.totalcount);
/* 899 */       _sb_.append(",");
/* 900 */       _sb_.append(this.merge_clear);
/* 901 */       _sb_.append(")");
/* 902 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Jingji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */