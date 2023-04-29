/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
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
/*     */ public final class role2ShiTuInfo extends XBean implements xbean.role2ShiTuInfo
/*     */ {
/*     */   private int graduatetimes;
/*     */   private xbean.MasterInfo masterinfo;
/*     */   private xbean.ApprenticeInfo apprenticeinfo;
/*     */   private boolean refusemasterrecommend;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.graduatetimes = 0;
/*  25 */     this.masterinfo._reset_unsafe_();
/*  26 */     this.apprenticeinfo._reset_unsafe_();
/*  27 */     this.refusemasterrecommend = false;
/*     */   }
/*     */   
/*     */   role2ShiTuInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.masterinfo = new MasterInfo(0, this, "masterinfo");
/*  34 */     this.apprenticeinfo = new ApprenticeInfo(0, this, "apprenticeinfo");
/*     */   }
/*     */   
/*     */   public role2ShiTuInfo()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public role2ShiTuInfo(role2ShiTuInfo _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   role2ShiTuInfo(xbean.role2ShiTuInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof role2ShiTuInfo)) { assign((role2ShiTuInfo)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(role2ShiTuInfo _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.graduatetimes = _o_.graduatetimes;
/*  60 */     this.masterinfo = new MasterInfo(_o_.masterinfo, this, "masterinfo");
/*  61 */     this.apprenticeinfo = new ApprenticeInfo(_o_.apprenticeinfo, this, "apprenticeinfo");
/*  62 */     this.refusemasterrecommend = _o_.refusemasterrecommend;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.graduatetimes = _o_.graduatetimes;
/*  68 */     this.masterinfo = new MasterInfo(_o_.masterinfo, this, "masterinfo");
/*  69 */     this.apprenticeinfo = new ApprenticeInfo(_o_.apprenticeinfo, this, "apprenticeinfo");
/*  70 */     this.refusemasterrecommend = _o_.refusemasterrecommend;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.graduatetimes);
/*  78 */     this.masterinfo.marshal(_os_);
/*  79 */     this.apprenticeinfo.marshal(_os_);
/*  80 */     _os_.marshal(this.refusemasterrecommend);
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws MarshalException
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     this.graduatetimes = _os_.unmarshal_int();
/*  89 */     this.masterinfo.unmarshal(_os_);
/*  90 */     this.apprenticeinfo.unmarshal(_os_);
/*  91 */     this.refusemasterrecommend = _os_.unmarshal_boolean();
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     int _size_ = 0;
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(1, this.graduatetimes);
/* 101 */     _size_ += CodedOutputStream.computeMessageSize(2, this.masterinfo);
/* 102 */     _size_ += CodedOutputStream.computeMessageSize(3, this.apprenticeinfo);
/* 103 */     _size_ += CodedOutputStream.computeBoolSize(4, this.refusemasterrecommend);
/* 104 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       _output_.writeInt32(1, this.graduatetimes);
/* 114 */       _output_.writeMessage(2, this.masterinfo);
/* 115 */       _output_.writeMessage(3, this.apprenticeinfo);
/* 116 */       _output_.writeBool(4, this.refusemasterrecommend);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 144 */           this.graduatetimes = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 149 */           _input_.readMessage(this.masterinfo);
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 154 */           _input_.readMessage(this.apprenticeinfo);
/* 155 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 159 */           this.refusemasterrecommend = _input_.readBool();
/* 160 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 164 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 166 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 175 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 181 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.role2ShiTuInfo copy()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new role2ShiTuInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.role2ShiTuInfo toData()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.role2ShiTuInfo toBean()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new role2ShiTuInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.role2ShiTuInfo toDataIf()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.role2ShiTuInfo toBeanIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGraduatetimes()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.graduatetimes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.MasterInfo getMasterinfo()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.masterinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.ApprenticeInfo getApprenticeinfo()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.apprenticeinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getRefusemasterrecommend()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this.refusemasterrecommend;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGraduatetimes(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "graduatetimes")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new xdb.logs.LogInt(this, role2ShiTuInfo.this.graduatetimes)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             role2ShiTuInfo.this.graduatetimes = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.graduatetimes = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRefusemasterrecommend(boolean _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "refusemasterrecommend")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new xdb.logs.LogObject(this, Boolean.valueOf(role2ShiTuInfo.this.refusemasterrecommend))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             role2ShiTuInfo.this.refusemasterrecommend = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.refusemasterrecommend = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     role2ShiTuInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof role2ShiTuInfo)) { _o_ = (role2ShiTuInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.graduatetimes != _o_.graduatetimes) return false;
/* 307 */     if (!this.masterinfo.equals(_o_.masterinfo)) return false;
/* 308 */     if (!this.apprenticeinfo.equals(_o_.apprenticeinfo)) return false;
/* 309 */     if (this.refusemasterrecommend != _o_.refusemasterrecommend) return false;
/* 310 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 316 */     _xdb_verify_unsafe_();
/* 317 */     int _h_ = 0;
/* 318 */     _h_ += this.graduatetimes;
/* 319 */     _h_ += this.masterinfo.hashCode();
/* 320 */     _h_ += this.apprenticeinfo.hashCode();
/* 321 */     _h_ += (this.refusemasterrecommend ? 1231 : 1237);
/* 322 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 328 */     _xdb_verify_unsafe_();
/* 329 */     StringBuilder _sb_ = new StringBuilder();
/* 330 */     _sb_.append("(");
/* 331 */     _sb_.append(this.graduatetimes);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.masterinfo);
/* 334 */     _sb_.append(",");
/* 335 */     _sb_.append(this.apprenticeinfo);
/* 336 */     _sb_.append(",");
/* 337 */     _sb_.append(this.refusemasterrecommend);
/* 338 */     _sb_.append(")");
/* 339 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 345 */     ListenableBean lb = new ListenableBean();
/* 346 */     lb.add(new ListenableChanged().setVarName("graduatetimes"));
/* 347 */     lb.add(new ListenableChanged().setVarName("masterinfo"));
/* 348 */     lb.add(new ListenableChanged().setVarName("apprenticeinfo"));
/* 349 */     lb.add(new ListenableChanged().setVarName("refusemasterrecommend"));
/* 350 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.role2ShiTuInfo {
/*     */     private Const() {}
/*     */     
/*     */     role2ShiTuInfo nThis() {
/* 357 */       return role2ShiTuInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 363 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.role2ShiTuInfo copy()
/*     */     {
/* 369 */       return role2ShiTuInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.role2ShiTuInfo toData()
/*     */     {
/* 375 */       return role2ShiTuInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.role2ShiTuInfo toBean()
/*     */     {
/* 380 */       return role2ShiTuInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.role2ShiTuInfo toDataIf()
/*     */     {
/* 386 */       return role2ShiTuInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.role2ShiTuInfo toBeanIf()
/*     */     {
/* 391 */       return role2ShiTuInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGraduatetimes()
/*     */     {
/* 398 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 399 */       return role2ShiTuInfo.this.graduatetimes;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.MasterInfo getMasterinfo()
/*     */     {
/* 406 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 407 */       return (xbean.MasterInfo)xdb.Consts.toConst(role2ShiTuInfo.this.masterinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.ApprenticeInfo getApprenticeinfo()
/*     */     {
/* 414 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 415 */       return (xbean.ApprenticeInfo)xdb.Consts.toConst(role2ShiTuInfo.this.apprenticeinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getRefusemasterrecommend()
/*     */     {
/* 422 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 423 */       return role2ShiTuInfo.this.refusemasterrecommend;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGraduatetimes(int _v_)
/*     */     {
/* 430 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRefusemasterrecommend(boolean _v_)
/*     */     {
/* 438 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 445 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 446 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 452 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 453 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 459 */       return role2ShiTuInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 465 */       return role2ShiTuInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 471 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 472 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 478 */       return role2ShiTuInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 484 */       return role2ShiTuInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 490 */       role2ShiTuInfo.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 497 */       return role2ShiTuInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 503 */       return role2ShiTuInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 509 */       return role2ShiTuInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 515 */       return role2ShiTuInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 521 */       return role2ShiTuInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 527 */       return role2ShiTuInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 533 */       return role2ShiTuInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.role2ShiTuInfo
/*     */   {
/*     */     private int graduatetimes;
/*     */     
/*     */     private xbean.MasterInfo masterinfo;
/*     */     
/*     */     private xbean.ApprenticeInfo apprenticeinfo;
/*     */     
/*     */     private boolean refusemasterrecommend;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.masterinfo = new MasterInfo.Data();
/* 557 */       this.apprenticeinfo = new ApprenticeInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.role2ShiTuInfo _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof role2ShiTuInfo)) { assign((role2ShiTuInfo)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof role2ShiTuInfo.Const)) assign(((role2ShiTuInfo.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(role2ShiTuInfo _o_) {
/* 570 */       this.graduatetimes = _o_.graduatetimes;
/* 571 */       this.masterinfo = new MasterInfo.Data(_o_.masterinfo);
/* 572 */       this.apprenticeinfo = new ApprenticeInfo.Data(_o_.apprenticeinfo);
/* 573 */       this.refusemasterrecommend = _o_.refusemasterrecommend;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 578 */       this.graduatetimes = _o_.graduatetimes;
/* 579 */       this.masterinfo = new MasterInfo.Data(_o_.masterinfo);
/* 580 */       this.apprenticeinfo = new ApprenticeInfo.Data(_o_.apprenticeinfo);
/* 581 */       this.refusemasterrecommend = _o_.refusemasterrecommend;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 587 */       _os_.marshal(this.graduatetimes);
/* 588 */       this.masterinfo.marshal(_os_);
/* 589 */       this.apprenticeinfo.marshal(_os_);
/* 590 */       _os_.marshal(this.refusemasterrecommend);
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 597 */       this.graduatetimes = _os_.unmarshal_int();
/* 598 */       this.masterinfo.unmarshal(_os_);
/* 599 */       this.apprenticeinfo.unmarshal(_os_);
/* 600 */       this.refusemasterrecommend = _os_.unmarshal_boolean();
/* 601 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 607 */       int _size_ = 0;
/* 608 */       _size_ += CodedOutputStream.computeInt32Size(1, this.graduatetimes);
/* 609 */       _size_ += CodedOutputStream.computeMessageSize(2, this.masterinfo);
/* 610 */       _size_ += CodedOutputStream.computeMessageSize(3, this.apprenticeinfo);
/* 611 */       _size_ += CodedOutputStream.computeBoolSize(4, this.refusemasterrecommend);
/* 612 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 620 */         _output_.writeInt32(1, this.graduatetimes);
/* 621 */         _output_.writeMessage(2, this.masterinfo);
/* 622 */         _output_.writeMessage(3, this.apprenticeinfo);
/* 623 */         _output_.writeBool(4, this.refusemasterrecommend);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 627 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 629 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 637 */         boolean done = false;
/* 638 */         while (!done)
/*     */         {
/* 640 */           int tag = _input_.readTag();
/* 641 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 645 */             done = true;
/* 646 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 650 */             this.graduatetimes = _input_.readInt32();
/* 651 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 655 */             _input_.readMessage(this.masterinfo);
/* 656 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 660 */             _input_.readMessage(this.apprenticeinfo);
/* 661 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 665 */             this.refusemasterrecommend = _input_.readBool();
/* 666 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 670 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 672 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 681 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 685 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 687 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.role2ShiTuInfo copy()
/*     */     {
/* 693 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.role2ShiTuInfo toData()
/*     */     {
/* 699 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.role2ShiTuInfo toBean()
/*     */     {
/* 704 */       return new role2ShiTuInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.role2ShiTuInfo toDataIf()
/*     */     {
/* 710 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.role2ShiTuInfo toBeanIf()
/*     */     {
/* 715 */       return new role2ShiTuInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 721 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 725 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 729 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 741 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 745 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGraduatetimes()
/*     */     {
/* 752 */       return this.graduatetimes;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.MasterInfo getMasterinfo()
/*     */     {
/* 759 */       return this.masterinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.ApprenticeInfo getApprenticeinfo()
/*     */     {
/* 766 */       return this.apprenticeinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getRefusemasterrecommend()
/*     */     {
/* 773 */       return this.refusemasterrecommend;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGraduatetimes(int _v_)
/*     */     {
/* 780 */       this.graduatetimes = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRefusemasterrecommend(boolean _v_)
/*     */     {
/* 787 */       this.refusemasterrecommend = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 793 */       if (!(_o1_ instanceof Data)) return false;
/* 794 */       Data _o_ = (Data)_o1_;
/* 795 */       if (this.graduatetimes != _o_.graduatetimes) return false;
/* 796 */       if (!this.masterinfo.equals(_o_.masterinfo)) return false;
/* 797 */       if (!this.apprenticeinfo.equals(_o_.apprenticeinfo)) return false;
/* 798 */       if (this.refusemasterrecommend != _o_.refusemasterrecommend) return false;
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 805 */       int _h_ = 0;
/* 806 */       _h_ += this.graduatetimes;
/* 807 */       _h_ += this.masterinfo.hashCode();
/* 808 */       _h_ += this.apprenticeinfo.hashCode();
/* 809 */       _h_ += (this.refusemasterrecommend ? 1231 : 1237);
/* 810 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 816 */       StringBuilder _sb_ = new StringBuilder();
/* 817 */       _sb_.append("(");
/* 818 */       _sb_.append(this.graduatetimes);
/* 819 */       _sb_.append(",");
/* 820 */       _sb_.append(this.masterinfo);
/* 821 */       _sb_.append(",");
/* 822 */       _sb_.append(this.apprenticeinfo);
/* 823 */       _sb_.append(",");
/* 824 */       _sb_.append(this.refusemasterrecommend);
/* 825 */       _sb_.append(")");
/* 826 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\role2ShiTuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */