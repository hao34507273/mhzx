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
/*     */ public final class ApprenticeInfo extends XBean implements xbean.ApprenticeInfo
/*     */ {
/*     */   private long masterroleid;
/*     */   private xbean.ShiTuTimeInfo timeinfo;
/*     */   private int now_pay_respect_times;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.masterroleid = 0L;
/*  23 */     this.timeinfo._reset_unsafe_();
/*  24 */     this.now_pay_respect_times = 0;
/*     */   }
/*     */   
/*     */   ApprenticeInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.timeinfo = new ShiTuTimeInfo(0, this, "timeinfo");
/*     */   }
/*     */   
/*     */   public ApprenticeInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ApprenticeInfo(ApprenticeInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ApprenticeInfo(xbean.ApprenticeInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof ApprenticeInfo)) { assign((ApprenticeInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ApprenticeInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.masterroleid = _o_.masterroleid;
/*  56 */     this.timeinfo = new ShiTuTimeInfo(_o_.timeinfo, this, "timeinfo");
/*  57 */     this.now_pay_respect_times = _o_.now_pay_respect_times;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.masterroleid = _o_.masterroleid;
/*  63 */     this.timeinfo = new ShiTuTimeInfo(_o_.timeinfo, this, "timeinfo");
/*  64 */     this.now_pay_respect_times = _o_.now_pay_respect_times;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.masterroleid);
/*  72 */     this.timeinfo.marshal(_os_);
/*  73 */     _os_.marshal(this.now_pay_respect_times);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.masterroleid = _os_.unmarshal_long();
/*  82 */     this.timeinfo.unmarshal(_os_);
/*  83 */     this.now_pay_respect_times = _os_.unmarshal_int();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(1, this.masterroleid);
/*  93 */     _size_ += CodedOutputStream.computeMessageSize(2, this.timeinfo);
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(3, this.now_pay_respect_times);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt64(1, this.masterroleid);
/* 105 */       _output_.writeMessage(2, this.timeinfo);
/* 106 */       _output_.writeInt32(3, this.now_pay_respect_times);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.masterroleid = _input_.readInt64();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 139 */           _input_.readMessage(this.timeinfo);
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.now_pay_respect_times = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ApprenticeInfo copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new ApprenticeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ApprenticeInfo toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ApprenticeInfo toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new ApprenticeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ApprenticeInfo toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ApprenticeInfo toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMasterroleid()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.masterroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.ShiTuTimeInfo getTimeinfo()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.timeinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNow_pay_respect_times()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.now_pay_respect_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMasterroleid(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "masterroleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogLong(this, ApprenticeInfo.this.masterroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             ApprenticeInfo.this.masterroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.masterroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNow_pay_respect_times(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "now_pay_respect_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, ApprenticeInfo.this.now_pay_respect_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             ApprenticeInfo.this.now_pay_respect_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.now_pay_respect_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     ApprenticeInfo _o_ = null;
/* 280 */     if ((_o1_ instanceof ApprenticeInfo)) { _o_ = (ApprenticeInfo)_o1_;
/* 281 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 282 */       return false;
/* 283 */     if (this.masterroleid != _o_.masterroleid) return false;
/* 284 */     if (!this.timeinfo.equals(_o_.timeinfo)) return false;
/* 285 */     if (this.now_pay_respect_times != _o_.now_pay_respect_times) return false;
/* 286 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     int _h_ = 0;
/* 294 */     _h_ = (int)(_h_ + this.masterroleid);
/* 295 */     _h_ += this.timeinfo.hashCode();
/* 296 */     _h_ += this.now_pay_respect_times;
/* 297 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     StringBuilder _sb_ = new StringBuilder();
/* 305 */     _sb_.append("(");
/* 306 */     _sb_.append(this.masterroleid);
/* 307 */     _sb_.append(",");
/* 308 */     _sb_.append(this.timeinfo);
/* 309 */     _sb_.append(",");
/* 310 */     _sb_.append(this.now_pay_respect_times);
/* 311 */     _sb_.append(")");
/* 312 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 318 */     ListenableBean lb = new ListenableBean();
/* 319 */     lb.add(new ListenableChanged().setVarName("masterroleid"));
/* 320 */     lb.add(new ListenableChanged().setVarName("timeinfo"));
/* 321 */     lb.add(new ListenableChanged().setVarName("now_pay_respect_times"));
/* 322 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ApprenticeInfo {
/*     */     private Const() {}
/*     */     
/*     */     ApprenticeInfo nThis() {
/* 329 */       return ApprenticeInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 335 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApprenticeInfo copy()
/*     */     {
/* 341 */       return ApprenticeInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApprenticeInfo toData()
/*     */     {
/* 347 */       return ApprenticeInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ApprenticeInfo toBean()
/*     */     {
/* 352 */       return ApprenticeInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApprenticeInfo toDataIf()
/*     */     {
/* 358 */       return ApprenticeInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ApprenticeInfo toBeanIf()
/*     */     {
/* 363 */       return ApprenticeInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMasterroleid()
/*     */     {
/* 370 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 371 */       return ApprenticeInfo.this.masterroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.ShiTuTimeInfo getTimeinfo()
/*     */     {
/* 378 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 379 */       return (xbean.ShiTuTimeInfo)xdb.Consts.toConst(ApprenticeInfo.this.timeinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNow_pay_respect_times()
/*     */     {
/* 386 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 387 */       return ApprenticeInfo.this.now_pay_respect_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMasterroleid(long _v_)
/*     */     {
/* 394 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 395 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNow_pay_respect_times(int _v_)
/*     */     {
/* 402 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 409 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 410 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 416 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 417 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 423 */       return ApprenticeInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 429 */       return ApprenticeInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 435 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 442 */       return ApprenticeInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 448 */       return ApprenticeInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 454 */       ApprenticeInfo.this._xdb_verify_unsafe_();
/* 455 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 461 */       return ApprenticeInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 467 */       return ApprenticeInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 473 */       return ApprenticeInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 479 */       return ApprenticeInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 485 */       return ApprenticeInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 491 */       return ApprenticeInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 497 */       return ApprenticeInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ApprenticeInfo
/*     */   {
/*     */     private long masterroleid;
/*     */     
/*     */     private xbean.ShiTuTimeInfo timeinfo;
/*     */     
/*     */     private int now_pay_respect_times;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.timeinfo = new ShiTuTimeInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.ApprenticeInfo _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof ApprenticeInfo)) { assign((ApprenticeInfo)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof ApprenticeInfo.Const)) assign(((ApprenticeInfo.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ApprenticeInfo _o_) {
/* 531 */       this.masterroleid = _o_.masterroleid;
/* 532 */       this.timeinfo = new ShiTuTimeInfo.Data(_o_.timeinfo);
/* 533 */       this.now_pay_respect_times = _o_.now_pay_respect_times;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 538 */       this.masterroleid = _o_.masterroleid;
/* 539 */       this.timeinfo = new ShiTuTimeInfo.Data(_o_.timeinfo);
/* 540 */       this.now_pay_respect_times = _o_.now_pay_respect_times;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 546 */       _os_.marshal(this.masterroleid);
/* 547 */       this.timeinfo.marshal(_os_);
/* 548 */       _os_.marshal(this.now_pay_respect_times);
/* 549 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 555 */       this.masterroleid = _os_.unmarshal_long();
/* 556 */       this.timeinfo.unmarshal(_os_);
/* 557 */       this.now_pay_respect_times = _os_.unmarshal_int();
/* 558 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 564 */       int _size_ = 0;
/* 565 */       _size_ += CodedOutputStream.computeInt64Size(1, this.masterroleid);
/* 566 */       _size_ += CodedOutputStream.computeMessageSize(2, this.timeinfo);
/* 567 */       _size_ += CodedOutputStream.computeInt32Size(3, this.now_pay_respect_times);
/* 568 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 576 */         _output_.writeInt64(1, this.masterroleid);
/* 577 */         _output_.writeMessage(2, this.timeinfo);
/* 578 */         _output_.writeInt32(3, this.now_pay_respect_times);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 582 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 584 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 592 */         boolean done = false;
/* 593 */         while (!done)
/*     */         {
/* 595 */           int tag = _input_.readTag();
/* 596 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 600 */             done = true;
/* 601 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 605 */             this.masterroleid = _input_.readInt64();
/* 606 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 610 */             _input_.readMessage(this.timeinfo);
/* 611 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 615 */             this.now_pay_respect_times = _input_.readInt32();
/* 616 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 620 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 622 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 631 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 635 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 637 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApprenticeInfo copy()
/*     */     {
/* 643 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApprenticeInfo toData()
/*     */     {
/* 649 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ApprenticeInfo toBean()
/*     */     {
/* 654 */       return new ApprenticeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApprenticeInfo toDataIf()
/*     */     {
/* 660 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ApprenticeInfo toBeanIf()
/*     */     {
/* 665 */       return new ApprenticeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 671 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 675 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 679 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 683 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 687 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 691 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 695 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMasterroleid()
/*     */     {
/* 702 */       return this.masterroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.ShiTuTimeInfo getTimeinfo()
/*     */     {
/* 709 */       return this.timeinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNow_pay_respect_times()
/*     */     {
/* 716 */       return this.now_pay_respect_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMasterroleid(long _v_)
/*     */     {
/* 723 */       this.masterroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNow_pay_respect_times(int _v_)
/*     */     {
/* 730 */       this.now_pay_respect_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 736 */       if (!(_o1_ instanceof Data)) return false;
/* 737 */       Data _o_ = (Data)_o1_;
/* 738 */       if (this.masterroleid != _o_.masterroleid) return false;
/* 739 */       if (!this.timeinfo.equals(_o_.timeinfo)) return false;
/* 740 */       if (this.now_pay_respect_times != _o_.now_pay_respect_times) return false;
/* 741 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 747 */       int _h_ = 0;
/* 748 */       _h_ = (int)(_h_ + this.masterroleid);
/* 749 */       _h_ += this.timeinfo.hashCode();
/* 750 */       _h_ += this.now_pay_respect_times;
/* 751 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 757 */       StringBuilder _sb_ = new StringBuilder();
/* 758 */       _sb_.append("(");
/* 759 */       _sb_.append(this.masterroleid);
/* 760 */       _sb_.append(",");
/* 761 */       _sb_.append(this.timeinfo);
/* 762 */       _sb_.append(",");
/* 763 */       _sb_.append(this.now_pay_respect_times);
/* 764 */       _sb_.append(")");
/* 765 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ApprenticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */