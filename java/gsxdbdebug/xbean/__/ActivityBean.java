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
/*     */ public final class ActivityBean extends XBean implements xbean.ActivityBean
/*     */ {
/*     */   private long endtime;
/*     */   private int count;
/*     */   private boolean recommendrewarded;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.endtime = 0L;
/*  23 */     this.count = 0;
/*  24 */     this.recommendrewarded = false;
/*     */   }
/*     */   
/*     */   ActivityBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ActivityBean()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ActivityBean(ActivityBean _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ActivityBean(xbean.ActivityBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof ActivityBean)) { assign((ActivityBean)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ActivityBean _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.endtime = _o_.endtime;
/*  55 */     this.count = _o_.count;
/*  56 */     this.recommendrewarded = _o_.recommendrewarded;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.endtime = _o_.endtime;
/*  62 */     this.count = _o_.count;
/*  63 */     this.recommendrewarded = _o_.recommendrewarded;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.endtime);
/*  71 */     _os_.marshal(this.count);
/*  72 */     _os_.marshal(this.recommendrewarded);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.endtime = _os_.unmarshal_long();
/*  81 */     this.count = _os_.unmarshal_int();
/*  82 */     this.recommendrewarded = _os_.unmarshal_boolean();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.endtime);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.count);
/*  93 */     _size_ += CodedOutputStream.computeBoolSize(3, this.recommendrewarded);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.endtime);
/* 104 */       _output_.writeInt32(2, this.count);
/* 105 */       _output_.writeBool(3, this.recommendrewarded);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.endtime = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.count = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.recommendrewarded = _input_.readBool();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityBean copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new ActivityBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityBean toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ActivityBean toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new ActivityBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ActivityBean toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ActivityBean toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getEndtime()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.endtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getRecommendrewarded()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.recommendrewarded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEndtime(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "endtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogLong(this, ActivityBean.this.endtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             ActivityBean.this.endtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.endtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCount(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, ActivityBean.this.count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             ActivityBean.this.count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRecommendrewarded(boolean _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "recommendrewarded")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogObject(this, Boolean.valueOf(ActivityBean.this.recommendrewarded))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             ActivityBean.this.recommendrewarded = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.recommendrewarded = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     ActivityBean _o_ = null;
/* 300 */     if ((_o1_ instanceof ActivityBean)) { _o_ = (ActivityBean)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.endtime != _o_.endtime) return false;
/* 304 */     if (this.count != _o_.count) return false;
/* 305 */     if (this.recommendrewarded != _o_.recommendrewarded) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.endtime);
/* 315 */     _h_ += this.count;
/* 316 */     _h_ += (this.recommendrewarded ? 1231 : 1237);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.endtime);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.count);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.recommendrewarded);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("endtime"));
/* 340 */     lb.add(new ListenableChanged().setVarName("count"));
/* 341 */     lb.add(new ListenableChanged().setVarName("recommendrewarded"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ActivityBean {
/*     */     private Const() {}
/*     */     
/*     */     ActivityBean nThis() {
/* 349 */       return ActivityBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityBean copy()
/*     */     {
/* 361 */       return ActivityBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityBean toData()
/*     */     {
/* 367 */       return ActivityBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ActivityBean toBean()
/*     */     {
/* 372 */       return ActivityBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityBean toDataIf()
/*     */     {
/* 378 */       return ActivityBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ActivityBean toBeanIf()
/*     */     {
/* 383 */       return ActivityBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 390 */       ActivityBean.this._xdb_verify_unsafe_();
/* 391 */       return ActivityBean.this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 398 */       ActivityBean.this._xdb_verify_unsafe_();
/* 399 */       return ActivityBean.this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getRecommendrewarded()
/*     */     {
/* 406 */       ActivityBean.this._xdb_verify_unsafe_();
/* 407 */       return ActivityBean.this.recommendrewarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 414 */       ActivityBean.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 422 */       ActivityBean.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecommendrewarded(boolean _v_)
/*     */     {
/* 430 */       ActivityBean.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       ActivityBean.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       ActivityBean.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return ActivityBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return ActivityBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       ActivityBean.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return ActivityBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return ActivityBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       ActivityBean.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return ActivityBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return ActivityBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return ActivityBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return ActivityBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return ActivityBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return ActivityBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return ActivityBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ActivityBean
/*     */   {
/*     */     private long endtime;
/*     */     
/*     */     private int count;
/*     */     
/*     */     private boolean recommendrewarded;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.ActivityBean _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof ActivityBean)) { assign((ActivityBean)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof ActivityBean.Const)) assign(((ActivityBean.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ActivityBean _o_) {
/* 558 */       this.endtime = _o_.endtime;
/* 559 */       this.count = _o_.count;
/* 560 */       this.recommendrewarded = _o_.recommendrewarded;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.endtime = _o_.endtime;
/* 566 */       this.count = _o_.count;
/* 567 */       this.recommendrewarded = _o_.recommendrewarded;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.endtime);
/* 574 */       _os_.marshal(this.count);
/* 575 */       _os_.marshal(this.recommendrewarded);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.endtime = _os_.unmarshal_long();
/* 583 */       this.count = _os_.unmarshal_int();
/* 584 */       this.recommendrewarded = _os_.unmarshal_boolean();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.endtime);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.count);
/* 594 */       _size_ += CodedOutputStream.computeBoolSize(3, this.recommendrewarded);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.endtime);
/* 604 */         _output_.writeInt32(2, this.count);
/* 605 */         _output_.writeBool(3, this.recommendrewarded);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.endtime = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.count = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.recommendrewarded = _input_.readBool();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityBean copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityBean toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ActivityBean toBean()
/*     */     {
/* 681 */       return new ActivityBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ActivityBean toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ActivityBean toBeanIf()
/*     */     {
/* 692 */       return new ActivityBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 729 */       return this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 736 */       return this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getRecommendrewarded()
/*     */     {
/* 743 */       return this.recommendrewarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 750 */       this.endtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 757 */       this.count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecommendrewarded(boolean _v_)
/*     */     {
/* 764 */       this.recommendrewarded = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.endtime != _o_.endtime) return false;
/* 773 */       if (this.count != _o_.count) return false;
/* 774 */       if (this.recommendrewarded != _o_.recommendrewarded) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.endtime);
/* 783 */       _h_ += this.count;
/* 784 */       _h_ += (this.recommendrewarded ? 1231 : 1237);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.endtime);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.count);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.recommendrewarded);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ActivityBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */