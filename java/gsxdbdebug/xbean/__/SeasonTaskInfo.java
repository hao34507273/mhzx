/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class SeasonTaskInfo extends XBean implements xbean.SeasonTaskInfo
/*     */ {
/*     */   private xbean.SeasonSingleTaskInfo singleinfo;
/*     */   private xbean.SeasonMultiTaskInfo multiinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.singleinfo._reset_unsafe_();
/*  21 */     this.multiinfo._reset_unsafe_();
/*     */   }
/*     */   
/*     */   SeasonTaskInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.singleinfo = new SeasonSingleTaskInfo(0, this, "singleinfo");
/*  28 */     this.multiinfo = new SeasonMultiTaskInfo(0, this, "multiinfo");
/*     */   }
/*     */   
/*     */   public SeasonTaskInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SeasonTaskInfo(SeasonTaskInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SeasonTaskInfo(xbean.SeasonTaskInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof SeasonTaskInfo)) { assign((SeasonTaskInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SeasonTaskInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.singleinfo = new SeasonSingleTaskInfo(_o_.singleinfo, this, "singleinfo");
/*  54 */     this.multiinfo = new SeasonMultiTaskInfo(_o_.multiinfo, this, "multiinfo");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.singleinfo = new SeasonSingleTaskInfo(_o_.singleinfo, this, "singleinfo");
/*  60 */     this.multiinfo = new SeasonMultiTaskInfo(_o_.multiinfo, this, "multiinfo");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     this.singleinfo.marshal(_os_);
/*  68 */     this.multiinfo.marshal(_os_);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.singleinfo.unmarshal(_os_);
/*  77 */     this.multiinfo.unmarshal(_os_);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeMessageSize(1, this.singleinfo);
/*  87 */     _size_ += CodedOutputStream.computeMessageSize(2, this.multiinfo);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeMessage(1, this.singleinfo);
/*  98 */       _output_.writeMessage(2, this.multiinfo);
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
/*     */         case 10: 
/* 126 */           _input_.readMessage(this.singleinfo);
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 131 */           _input_.readMessage(this.multiinfo);
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
/*     */   public xbean.SeasonTaskInfo copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new SeasonTaskInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SeasonTaskInfo toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SeasonTaskInfo toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new SeasonTaskInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SeasonTaskInfo toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SeasonTaskInfo toBeanIf()
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
/*     */   public xbean.SeasonSingleTaskInfo getSingleinfo()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.singleinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.SeasonMultiTaskInfo getMultiinfo()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.multiinfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     SeasonTaskInfo _o_ = null;
/* 217 */     if ((_o1_ instanceof SeasonTaskInfo)) { _o_ = (SeasonTaskInfo)_o1_;
/* 218 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 219 */       return false;
/* 220 */     if (!this.singleinfo.equals(_o_.singleinfo)) return false;
/* 221 */     if (!this.multiinfo.equals(_o_.multiinfo)) return false;
/* 222 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     int _h_ = 0;
/* 230 */     _h_ += this.singleinfo.hashCode();
/* 231 */     _h_ += this.multiinfo.hashCode();
/* 232 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     StringBuilder _sb_ = new StringBuilder();
/* 240 */     _sb_.append("(");
/* 241 */     _sb_.append(this.singleinfo);
/* 242 */     _sb_.append(",");
/* 243 */     _sb_.append(this.multiinfo);
/* 244 */     _sb_.append(")");
/* 245 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 251 */     ListenableBean lb = new ListenableBean();
/* 252 */     lb.add(new ListenableChanged().setVarName("singleinfo"));
/* 253 */     lb.add(new ListenableChanged().setVarName("multiinfo"));
/* 254 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SeasonTaskInfo {
/*     */     private Const() {}
/*     */     
/*     */     SeasonTaskInfo nThis() {
/* 261 */       return SeasonTaskInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 267 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonTaskInfo copy()
/*     */     {
/* 273 */       return SeasonTaskInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonTaskInfo toData()
/*     */     {
/* 279 */       return SeasonTaskInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SeasonTaskInfo toBean()
/*     */     {
/* 284 */       return SeasonTaskInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonTaskInfo toDataIf()
/*     */     {
/* 290 */       return SeasonTaskInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SeasonTaskInfo toBeanIf()
/*     */     {
/* 295 */       return SeasonTaskInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.SeasonSingleTaskInfo getSingleinfo()
/*     */     {
/* 302 */       SeasonTaskInfo.this._xdb_verify_unsafe_();
/* 303 */       return (xbean.SeasonSingleTaskInfo)xdb.Consts.toConst(SeasonTaskInfo.this.singleinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo getMultiinfo()
/*     */     {
/* 310 */       SeasonTaskInfo.this._xdb_verify_unsafe_();
/* 311 */       return (xbean.SeasonMultiTaskInfo)xdb.Consts.toConst(SeasonTaskInfo.this.multiinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 317 */       SeasonTaskInfo.this._xdb_verify_unsafe_();
/* 318 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 324 */       SeasonTaskInfo.this._xdb_verify_unsafe_();
/* 325 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 331 */       return SeasonTaskInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 337 */       return SeasonTaskInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 343 */       SeasonTaskInfo.this._xdb_verify_unsafe_();
/* 344 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 350 */       return SeasonTaskInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 356 */       return SeasonTaskInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 362 */       SeasonTaskInfo.this._xdb_verify_unsafe_();
/* 363 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 369 */       return SeasonTaskInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 375 */       return SeasonTaskInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 381 */       return SeasonTaskInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 387 */       return SeasonTaskInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 393 */       return SeasonTaskInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 399 */       return SeasonTaskInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 405 */       return SeasonTaskInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SeasonTaskInfo
/*     */   {
/*     */     private xbean.SeasonSingleTaskInfo singleinfo;
/*     */     
/*     */     private xbean.SeasonMultiTaskInfo multiinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 424 */       this.singleinfo = new SeasonSingleTaskInfo.Data();
/* 425 */       this.multiinfo = new SeasonMultiTaskInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.SeasonTaskInfo _o1_)
/*     */     {
/* 430 */       if ((_o1_ instanceof SeasonTaskInfo)) { assign((SeasonTaskInfo)_o1_);
/* 431 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 432 */       } else if ((_o1_ instanceof SeasonTaskInfo.Const)) assign(((SeasonTaskInfo.Const)_o1_).nThis()); else {
/* 433 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SeasonTaskInfo _o_) {
/* 438 */       this.singleinfo = new SeasonSingleTaskInfo.Data(_o_.singleinfo);
/* 439 */       this.multiinfo = new SeasonMultiTaskInfo.Data(_o_.multiinfo);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 444 */       this.singleinfo = new SeasonSingleTaskInfo.Data(_o_.singleinfo);
/* 445 */       this.multiinfo = new SeasonMultiTaskInfo.Data(_o_.multiinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 451 */       this.singleinfo.marshal(_os_);
/* 452 */       this.multiinfo.marshal(_os_);
/* 453 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 459 */       this.singleinfo.unmarshal(_os_);
/* 460 */       this.multiinfo.unmarshal(_os_);
/* 461 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 467 */       int _size_ = 0;
/* 468 */       _size_ += CodedOutputStream.computeMessageSize(1, this.singleinfo);
/* 469 */       _size_ += CodedOutputStream.computeMessageSize(2, this.multiinfo);
/* 470 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 478 */         _output_.writeMessage(1, this.singleinfo);
/* 479 */         _output_.writeMessage(2, this.multiinfo);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 483 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 485 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 493 */         boolean done = false;
/* 494 */         while (!done)
/*     */         {
/* 496 */           int tag = _input_.readTag();
/* 497 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 501 */             done = true;
/* 502 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 506 */             _input_.readMessage(this.singleinfo);
/* 507 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 511 */             _input_.readMessage(this.multiinfo);
/* 512 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 516 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 518 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 527 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 531 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 533 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonTaskInfo copy()
/*     */     {
/* 539 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonTaskInfo toData()
/*     */     {
/* 545 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SeasonTaskInfo toBean()
/*     */     {
/* 550 */       return new SeasonTaskInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonTaskInfo toDataIf()
/*     */     {
/* 556 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SeasonTaskInfo toBeanIf()
/*     */     {
/* 561 */       return new SeasonTaskInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 567 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 571 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 575 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 587 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 591 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.SeasonSingleTaskInfo getSingleinfo()
/*     */     {
/* 598 */       return this.singleinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo getMultiinfo()
/*     */     {
/* 605 */       return this.multiinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 611 */       if (!(_o1_ instanceof Data)) return false;
/* 612 */       Data _o_ = (Data)_o1_;
/* 613 */       if (!this.singleinfo.equals(_o_.singleinfo)) return false;
/* 614 */       if (!this.multiinfo.equals(_o_.multiinfo)) return false;
/* 615 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 621 */       int _h_ = 0;
/* 622 */       _h_ += this.singleinfo.hashCode();
/* 623 */       _h_ += this.multiinfo.hashCode();
/* 624 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 630 */       StringBuilder _sb_ = new StringBuilder();
/* 631 */       _sb_.append("(");
/* 632 */       _sb_.append(this.singleinfo);
/* 633 */       _sb_.append(",");
/* 634 */       _sb_.append(this.multiinfo);
/* 635 */       _sb_.append(")");
/* 636 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SeasonTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */