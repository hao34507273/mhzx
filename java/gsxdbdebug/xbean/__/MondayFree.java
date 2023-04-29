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
/*     */ public final class MondayFree extends XBean implements xbean.MondayFree
/*     */ {
/*     */   private long sunday_award_time;
/*     */   private long monday_award_time;
/*     */   private long finish_shimen_time;
/*     */   private long finish_baotu_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.sunday_award_time = 0L;
/*  25 */     this.monday_award_time = 0L;
/*  26 */     this.finish_shimen_time = 0L;
/*  27 */     this.finish_baotu_time = 0L;
/*     */   }
/*     */   
/*     */   MondayFree(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.sunday_award_time = 0L;
/*  34 */     this.monday_award_time = 0L;
/*  35 */     this.finish_shimen_time = 0L;
/*  36 */     this.finish_baotu_time = 0L;
/*     */   }
/*     */   
/*     */   public MondayFree()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MondayFree(MondayFree _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MondayFree(xbean.MondayFree _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof MondayFree)) { assign((MondayFree)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MondayFree _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.sunday_award_time = _o_.sunday_award_time;
/*  62 */     this.monday_award_time = _o_.monday_award_time;
/*  63 */     this.finish_shimen_time = _o_.finish_shimen_time;
/*  64 */     this.finish_baotu_time = _o_.finish_baotu_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.sunday_award_time = _o_.sunday_award_time;
/*  70 */     this.monday_award_time = _o_.monday_award_time;
/*  71 */     this.finish_shimen_time = _o_.finish_shimen_time;
/*  72 */     this.finish_baotu_time = _o_.finish_baotu_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.sunday_award_time);
/*  80 */     _os_.marshal(this.monday_award_time);
/*  81 */     _os_.marshal(this.finish_shimen_time);
/*  82 */     _os_.marshal(this.finish_baotu_time);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.sunday_award_time = _os_.unmarshal_long();
/*  91 */     this.monday_award_time = _os_.unmarshal_long();
/*  92 */     this.finish_shimen_time = _os_.unmarshal_long();
/*  93 */     this.finish_baotu_time = _os_.unmarshal_long();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     int _size_ = 0;
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(1, this.sunday_award_time);
/* 103 */     _size_ += CodedOutputStream.computeInt64Size(2, this.monday_award_time);
/* 104 */     _size_ += CodedOutputStream.computeInt64Size(3, this.finish_shimen_time);
/* 105 */     _size_ += CodedOutputStream.computeInt64Size(4, this.finish_baotu_time);
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       _output_.writeInt64(1, this.sunday_award_time);
/* 116 */       _output_.writeInt64(2, this.monday_award_time);
/* 117 */       _output_.writeInt64(3, this.finish_shimen_time);
/* 118 */       _output_.writeInt64(4, this.finish_baotu_time);
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
/* 146 */           this.sunday_award_time = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.monday_award_time = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.finish_shimen_time = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 161 */           this.finish_baotu_time = _input_.readInt64();
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
/*     */   public xbean.MondayFree copy()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return new MondayFree(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MondayFree toData()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MondayFree toBean()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new MondayFree(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MondayFree toDataIf()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MondayFree toBeanIf()
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
/*     */   public long getSunday_award_time()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.sunday_award_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMonday_award_time()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.monday_award_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFinish_shimen_time()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.finish_shimen_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFinish_baotu_time()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.finish_baotu_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSunday_award_time(long _v_)
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     xdb.Logs.logIf(new LogKey(this, "sunday_award_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 267 */         new LogLong(this, MondayFree.this.sunday_award_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 271 */             MondayFree.this.sunday_award_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 275 */     });
/* 276 */     this.sunday_award_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMonday_award_time(long _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "monday_award_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 288 */         new LogLong(this, MondayFree.this.monday_award_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             MondayFree.this.monday_award_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.monday_award_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFinish_shimen_time(long _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "finish_shimen_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 309 */         new LogLong(this, MondayFree.this.finish_shimen_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             MondayFree.this.finish_shimen_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.finish_shimen_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFinish_baotu_time(long _v_)
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     xdb.Logs.logIf(new LogKey(this, "finish_baotu_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 330 */         new LogLong(this, MondayFree.this.finish_baotu_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 334 */             MondayFree.this.finish_baotu_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 338 */     });
/* 339 */     this.finish_baotu_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     MondayFree _o_ = null;
/* 347 */     if ((_o1_ instanceof MondayFree)) { _o_ = (MondayFree)_o1_;
/* 348 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 349 */       return false;
/* 350 */     if (this.sunday_award_time != _o_.sunday_award_time) return false;
/* 351 */     if (this.monday_award_time != _o_.monday_award_time) return false;
/* 352 */     if (this.finish_shimen_time != _o_.finish_shimen_time) return false;
/* 353 */     if (this.finish_baotu_time != _o_.finish_baotu_time) return false;
/* 354 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 360 */     _xdb_verify_unsafe_();
/* 361 */     int _h_ = 0;
/* 362 */     _h_ = (int)(_h_ + this.sunday_award_time);
/* 363 */     _h_ = (int)(_h_ + this.monday_award_time);
/* 364 */     _h_ = (int)(_h_ + this.finish_shimen_time);
/* 365 */     _h_ = (int)(_h_ + this.finish_baotu_time);
/* 366 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 372 */     _xdb_verify_unsafe_();
/* 373 */     StringBuilder _sb_ = new StringBuilder();
/* 374 */     _sb_.append("(");
/* 375 */     _sb_.append(this.sunday_award_time);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.monday_award_time);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.finish_shimen_time);
/* 380 */     _sb_.append(",");
/* 381 */     _sb_.append(this.finish_baotu_time);
/* 382 */     _sb_.append(")");
/* 383 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 389 */     ListenableBean lb = new ListenableBean();
/* 390 */     lb.add(new ListenableChanged().setVarName("sunday_award_time"));
/* 391 */     lb.add(new ListenableChanged().setVarName("monday_award_time"));
/* 392 */     lb.add(new ListenableChanged().setVarName("finish_shimen_time"));
/* 393 */     lb.add(new ListenableChanged().setVarName("finish_baotu_time"));
/* 394 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MondayFree {
/*     */     private Const() {}
/*     */     
/*     */     MondayFree nThis() {
/* 401 */       return MondayFree.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MondayFree copy()
/*     */     {
/* 413 */       return MondayFree.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MondayFree toData()
/*     */     {
/* 419 */       return MondayFree.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MondayFree toBean()
/*     */     {
/* 424 */       return MondayFree.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MondayFree toDataIf()
/*     */     {
/* 430 */       return MondayFree.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MondayFree toBeanIf()
/*     */     {
/* 435 */       return MondayFree.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSunday_award_time()
/*     */     {
/* 442 */       MondayFree.this._xdb_verify_unsafe_();
/* 443 */       return MondayFree.this.sunday_award_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMonday_award_time()
/*     */     {
/* 450 */       MondayFree.this._xdb_verify_unsafe_();
/* 451 */       return MondayFree.this.monday_award_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFinish_shimen_time()
/*     */     {
/* 458 */       MondayFree.this._xdb_verify_unsafe_();
/* 459 */       return MondayFree.this.finish_shimen_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFinish_baotu_time()
/*     */     {
/* 466 */       MondayFree.this._xdb_verify_unsafe_();
/* 467 */       return MondayFree.this.finish_baotu_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSunday_award_time(long _v_)
/*     */     {
/* 474 */       MondayFree.this._xdb_verify_unsafe_();
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMonday_award_time(long _v_)
/*     */     {
/* 482 */       MondayFree.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinish_shimen_time(long _v_)
/*     */     {
/* 490 */       MondayFree.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinish_baotu_time(long _v_)
/*     */     {
/* 498 */       MondayFree.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 505 */       MondayFree.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       MondayFree.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return MondayFree.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return MondayFree.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       MondayFree.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return MondayFree.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return MondayFree.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       MondayFree.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 557 */       return MondayFree.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return MondayFree.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return MondayFree.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return MondayFree.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return MondayFree.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return MondayFree.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return MondayFree.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MondayFree
/*     */   {
/*     */     private long sunday_award_time;
/*     */     
/*     */     private long monday_award_time;
/*     */     
/*     */     private long finish_shimen_time;
/*     */     
/*     */     private long finish_baotu_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 616 */       this.sunday_award_time = 0L;
/* 617 */       this.monday_award_time = 0L;
/* 618 */       this.finish_shimen_time = 0L;
/* 619 */       this.finish_baotu_time = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.MondayFree _o1_)
/*     */     {
/* 624 */       if ((_o1_ instanceof MondayFree)) { assign((MondayFree)_o1_);
/* 625 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 626 */       } else if ((_o1_ instanceof MondayFree.Const)) assign(((MondayFree.Const)_o1_).nThis()); else {
/* 627 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MondayFree _o_) {
/* 632 */       this.sunday_award_time = _o_.sunday_award_time;
/* 633 */       this.monday_award_time = _o_.monday_award_time;
/* 634 */       this.finish_shimen_time = _o_.finish_shimen_time;
/* 635 */       this.finish_baotu_time = _o_.finish_baotu_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 640 */       this.sunday_award_time = _o_.sunday_award_time;
/* 641 */       this.monday_award_time = _o_.monday_award_time;
/* 642 */       this.finish_shimen_time = _o_.finish_shimen_time;
/* 643 */       this.finish_baotu_time = _o_.finish_baotu_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 649 */       _os_.marshal(this.sunday_award_time);
/* 650 */       _os_.marshal(this.monday_award_time);
/* 651 */       _os_.marshal(this.finish_shimen_time);
/* 652 */       _os_.marshal(this.finish_baotu_time);
/* 653 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 659 */       this.sunday_award_time = _os_.unmarshal_long();
/* 660 */       this.monday_award_time = _os_.unmarshal_long();
/* 661 */       this.finish_shimen_time = _os_.unmarshal_long();
/* 662 */       this.finish_baotu_time = _os_.unmarshal_long();
/* 663 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 669 */       int _size_ = 0;
/* 670 */       _size_ += CodedOutputStream.computeInt64Size(1, this.sunday_award_time);
/* 671 */       _size_ += CodedOutputStream.computeInt64Size(2, this.monday_award_time);
/* 672 */       _size_ += CodedOutputStream.computeInt64Size(3, this.finish_shimen_time);
/* 673 */       _size_ += CodedOutputStream.computeInt64Size(4, this.finish_baotu_time);
/* 674 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 682 */         _output_.writeInt64(1, this.sunday_award_time);
/* 683 */         _output_.writeInt64(2, this.monday_award_time);
/* 684 */         _output_.writeInt64(3, this.finish_shimen_time);
/* 685 */         _output_.writeInt64(4, this.finish_baotu_time);
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
/* 712 */             this.sunday_award_time = _input_.readInt64();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 717 */             this.monday_award_time = _input_.readInt64();
/* 718 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 722 */             this.finish_shimen_time = _input_.readInt64();
/* 723 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 727 */             this.finish_baotu_time = _input_.readInt64();
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
/*     */     public xbean.MondayFree copy()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MondayFree toData()
/*     */     {
/* 761 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MondayFree toBean()
/*     */     {
/* 766 */       return new MondayFree(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MondayFree toDataIf()
/*     */     {
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MondayFree toBeanIf()
/*     */     {
/* 777 */       return new MondayFree(this, null, null);
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
/*     */     public long getSunday_award_time()
/*     */     {
/* 814 */       return this.sunday_award_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMonday_award_time()
/*     */     {
/* 821 */       return this.monday_award_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFinish_shimen_time()
/*     */     {
/* 828 */       return this.finish_shimen_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFinish_baotu_time()
/*     */     {
/* 835 */       return this.finish_baotu_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSunday_award_time(long _v_)
/*     */     {
/* 842 */       this.sunday_award_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMonday_award_time(long _v_)
/*     */     {
/* 849 */       this.monday_award_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinish_shimen_time(long _v_)
/*     */     {
/* 856 */       this.finish_shimen_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinish_baotu_time(long _v_)
/*     */     {
/* 863 */       this.finish_baotu_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.sunday_award_time != _o_.sunday_award_time) return false;
/* 872 */       if (this.monday_award_time != _o_.monday_award_time) return false;
/* 873 */       if (this.finish_shimen_time != _o_.finish_shimen_time) return false;
/* 874 */       if (this.finish_baotu_time != _o_.finish_baotu_time) return false;
/* 875 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 881 */       int _h_ = 0;
/* 882 */       _h_ = (int)(_h_ + this.sunday_award_time);
/* 883 */       _h_ = (int)(_h_ + this.monday_award_time);
/* 884 */       _h_ = (int)(_h_ + this.finish_shimen_time);
/* 885 */       _h_ = (int)(_h_ + this.finish_baotu_time);
/* 886 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 892 */       StringBuilder _sb_ = new StringBuilder();
/* 893 */       _sb_.append("(");
/* 894 */       _sb_.append(this.sunday_award_time);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.monday_award_time);
/* 897 */       _sb_.append(",");
/* 898 */       _sb_.append(this.finish_shimen_time);
/* 899 */       _sb_.append(",");
/* 900 */       _sb_.append(this.finish_baotu_time);
/* 901 */       _sb_.append(")");
/* 902 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MondayFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */