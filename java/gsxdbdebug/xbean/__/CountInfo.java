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
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class CountInfo extends XBean implements xbean.CountInfo
/*     */ {
/*     */   private int count;
/*     */   private boolean isawarded;
/*     */   private int awardnum;
/*     */   private long starttime;
/*     */   private int curcircle;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.count = 0;
/*  27 */     this.isawarded = false;
/*  28 */     this.awardnum = 0;
/*  29 */     this.starttime = 0L;
/*  30 */     this.curcircle = 0;
/*     */   }
/*     */   
/*     */   CountInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public CountInfo()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CountInfo(CountInfo _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CountInfo(xbean.CountInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof CountInfo)) { assign((CountInfo)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CountInfo _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.count = _o_.count;
/*  61 */     this.isawarded = _o_.isawarded;
/*  62 */     this.awardnum = _o_.awardnum;
/*  63 */     this.starttime = _o_.starttime;
/*  64 */     this.curcircle = _o_.curcircle;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.count = _o_.count;
/*  70 */     this.isawarded = _o_.isawarded;
/*  71 */     this.awardnum = _o_.awardnum;
/*  72 */     this.starttime = _o_.starttime;
/*  73 */     this.curcircle = _o_.curcircle;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.count);
/*  81 */     _os_.marshal(this.isawarded);
/*  82 */     _os_.marshal(this.awardnum);
/*  83 */     _os_.marshal(this.starttime);
/*  84 */     _os_.marshal(this.curcircle);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.count = _os_.unmarshal_int();
/*  93 */     this.isawarded = _os_.unmarshal_boolean();
/*  94 */     this.awardnum = _os_.unmarshal_int();
/*  95 */     this.starttime = _os_.unmarshal_long();
/*  96 */     this.curcircle = _os_.unmarshal_int();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(1, this.count);
/* 106 */     _size_ += CodedOutputStream.computeBoolSize(2, this.isawarded);
/* 107 */     _size_ += CodedOutputStream.computeInt32Size(3, this.awardnum);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(4, this.starttime);
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(5, this.curcircle);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.count);
/* 120 */       _output_.writeBool(2, this.isawarded);
/* 121 */       _output_.writeInt32(3, this.awardnum);
/* 122 */       _output_.writeInt64(4, this.starttime);
/* 123 */       _output_.writeInt32(5, this.curcircle);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.count = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.isawarded = _input_.readBool();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.awardnum = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.starttime = _input_.readInt64();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.curcircle = _input_.readInt32();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CountInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new CountInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CountInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CountInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new CountInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CountInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CountInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsawarded()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.isawarded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAwardnum()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.awardnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStarttime()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurcircle()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.curcircle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCount(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "count")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new LogInt(this, CountInfo.this.count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             CountInfo.this.count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsawarded(boolean _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "isawarded")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new xdb.logs.LogObject(this, Boolean.valueOf(CountInfo.this.isawarded))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             CountInfo.this.isawarded = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.isawarded = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwardnum(int _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "awardnum")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogInt(this, CountInfo.this.awardnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             CountInfo.this.awardnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.awardnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new xdb.logs.LogLong(this, CountInfo.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             CountInfo.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurcircle(int _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "curcircle")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new LogInt(this, CountInfo.this.curcircle)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             CountInfo.this.curcircle = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.curcircle = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     CountInfo _o_ = null;
/* 386 */     if ((_o1_ instanceof CountInfo)) { _o_ = (CountInfo)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.count != _o_.count) return false;
/* 390 */     if (this.isawarded != _o_.isawarded) return false;
/* 391 */     if (this.awardnum != _o_.awardnum) return false;
/* 392 */     if (this.starttime != _o_.starttime) return false;
/* 393 */     if (this.curcircle != _o_.curcircle) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ += this.count;
/* 403 */     _h_ += (this.isawarded ? 1231 : 1237);
/* 404 */     _h_ += this.awardnum;
/* 405 */     _h_ = (int)(_h_ + this.starttime);
/* 406 */     _h_ += this.curcircle;
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.count);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.isawarded);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.awardnum);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.starttime);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.curcircle);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("count"));
/* 434 */     lb.add(new ListenableChanged().setVarName("isawarded"));
/* 435 */     lb.add(new ListenableChanged().setVarName("awardnum"));
/* 436 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 437 */     lb.add(new ListenableChanged().setVarName("curcircle"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CountInfo {
/*     */     private Const() {}
/*     */     
/*     */     CountInfo nThis() {
/* 445 */       return CountInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountInfo copy()
/*     */     {
/* 457 */       return CountInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountInfo toData()
/*     */     {
/* 463 */       return CountInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CountInfo toBean()
/*     */     {
/* 468 */       return CountInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountInfo toDataIf()
/*     */     {
/* 474 */       return CountInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CountInfo toBeanIf()
/*     */     {
/* 479 */       return CountInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 486 */       CountInfo.this._xdb_verify_unsafe_();
/* 487 */       return CountInfo.this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsawarded()
/*     */     {
/* 494 */       CountInfo.this._xdb_verify_unsafe_();
/* 495 */       return CountInfo.this.isawarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAwardnum()
/*     */     {
/* 502 */       CountInfo.this._xdb_verify_unsafe_();
/* 503 */       return CountInfo.this.awardnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 510 */       CountInfo.this._xdb_verify_unsafe_();
/* 511 */       return CountInfo.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurcircle()
/*     */     {
/* 518 */       CountInfo.this._xdb_verify_unsafe_();
/* 519 */       return CountInfo.this.curcircle;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 526 */       CountInfo.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsawarded(boolean _v_)
/*     */     {
/* 534 */       CountInfo.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardnum(int _v_)
/*     */     {
/* 542 */       CountInfo.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 550 */       CountInfo.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurcircle(int _v_)
/*     */     {
/* 558 */       CountInfo.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       CountInfo.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       CountInfo.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return CountInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return CountInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       CountInfo.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return CountInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return CountInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       CountInfo.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return CountInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return CountInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return CountInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return CountInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return CountInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return CountInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return CountInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CountInfo
/*     */   {
/*     */     private int count;
/*     */     
/*     */     private boolean isawarded;
/*     */     
/*     */     private int awardnum;
/*     */     
/*     */     private long starttime;
/*     */     
/*     */     private int curcircle;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.CountInfo _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof CountInfo)) { assign((CountInfo)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof CountInfo.Const)) assign(((CountInfo.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CountInfo _o_) {
/* 690 */       this.count = _o_.count;
/* 691 */       this.isawarded = _o_.isawarded;
/* 692 */       this.awardnum = _o_.awardnum;
/* 693 */       this.starttime = _o_.starttime;
/* 694 */       this.curcircle = _o_.curcircle;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.count = _o_.count;
/* 700 */       this.isawarded = _o_.isawarded;
/* 701 */       this.awardnum = _o_.awardnum;
/* 702 */       this.starttime = _o_.starttime;
/* 703 */       this.curcircle = _o_.curcircle;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.count);
/* 710 */       _os_.marshal(this.isawarded);
/* 711 */       _os_.marshal(this.awardnum);
/* 712 */       _os_.marshal(this.starttime);
/* 713 */       _os_.marshal(this.curcircle);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.count = _os_.unmarshal_int();
/* 721 */       this.isawarded = _os_.unmarshal_boolean();
/* 722 */       this.awardnum = _os_.unmarshal_int();
/* 723 */       this.starttime = _os_.unmarshal_long();
/* 724 */       this.curcircle = _os_.unmarshal_int();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt32Size(1, this.count);
/* 733 */       _size_ += CodedOutputStream.computeBoolSize(2, this.isawarded);
/* 734 */       _size_ += CodedOutputStream.computeInt32Size(3, this.awardnum);
/* 735 */       _size_ += CodedOutputStream.computeInt64Size(4, this.starttime);
/* 736 */       _size_ += CodedOutputStream.computeInt32Size(5, this.curcircle);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt32(1, this.count);
/* 746 */         _output_.writeBool(2, this.isawarded);
/* 747 */         _output_.writeInt32(3, this.awardnum);
/* 748 */         _output_.writeInt64(4, this.starttime);
/* 749 */         _output_.writeInt32(5, this.curcircle);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 753 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 755 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         boolean done = false;
/* 764 */         while (!done)
/*     */         {
/* 766 */           int tag = _input_.readTag();
/* 767 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 771 */             done = true;
/* 772 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 776 */             this.count = _input_.readInt32();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.isawarded = _input_.readBool();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.awardnum = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.starttime = _input_.readInt64();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.curcircle = _input_.readInt32();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 801 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 803 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 812 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 816 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 818 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountInfo copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountInfo toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CountInfo toBean()
/*     */     {
/* 835 */       return new CountInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountInfo toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CountInfo toBeanIf()
/*     */     {
/* 846 */       return new CountInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 872 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 876 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 883 */       return this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsawarded()
/*     */     {
/* 890 */       return this.isawarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAwardnum()
/*     */     {
/* 897 */       return this.awardnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 904 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurcircle()
/*     */     {
/* 911 */       return this.curcircle;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 918 */       this.count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsawarded(boolean _v_)
/*     */     {
/* 925 */       this.isawarded = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardnum(int _v_)
/*     */     {
/* 932 */       this.awardnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 939 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurcircle(int _v_)
/*     */     {
/* 946 */       this.curcircle = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.count != _o_.count) return false;
/* 955 */       if (this.isawarded != _o_.isawarded) return false;
/* 956 */       if (this.awardnum != _o_.awardnum) return false;
/* 957 */       if (this.starttime != _o_.starttime) return false;
/* 958 */       if (this.curcircle != _o_.curcircle) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ += this.count;
/* 967 */       _h_ += (this.isawarded ? 1231 : 1237);
/* 968 */       _h_ += this.awardnum;
/* 969 */       _h_ = (int)(_h_ + this.starttime);
/* 970 */       _h_ += this.curcircle;
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.count);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.isawarded);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.awardnum);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.starttime);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.curcircle);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */