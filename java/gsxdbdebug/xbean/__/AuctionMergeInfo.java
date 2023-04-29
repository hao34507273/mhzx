/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class AuctionMergeInfo extends XBean implements xbean.AuctionMergeInfo
/*     */ {
/*     */   private ArrayList<xbean.AuctionRefundInfo> refundinfolist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.refundinfolist.clear();
/*     */   }
/*     */   
/*     */   AuctionMergeInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.refundinfolist = new ArrayList();
/*     */   }
/*     */   
/*     */   public AuctionMergeInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AuctionMergeInfo(AuctionMergeInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AuctionMergeInfo(xbean.AuctionMergeInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof AuctionMergeInfo)) { assign((AuctionMergeInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AuctionMergeInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.refundinfolist = new ArrayList();
/*  50 */     for (xbean.AuctionRefundInfo _v_ : _o_.refundinfolist) {
/*  51 */       this.refundinfolist.add(new AuctionRefundInfo(_v_, this, "refundinfolist"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.refundinfolist = new ArrayList();
/*  57 */     for (xbean.AuctionRefundInfo _v_ : _o_.refundinfolist) {
/*  58 */       this.refundinfolist.add(new AuctionRefundInfo(_v_, this, "refundinfolist"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.refundinfolist.size());
/*  66 */     for (xbean.AuctionRefundInfo _v_ : this.refundinfolist)
/*     */     {
/*  68 */       _v_.marshal(_os_);
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  79 */       xbean.AuctionRefundInfo _v_ = new AuctionRefundInfo(0, this, "refundinfolist");
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.refundinfolist.add(_v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     for (xbean.AuctionRefundInfo _v_ : this.refundinfolist)
/*     */     {
/*  93 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       for (xbean.AuctionRefundInfo _v_ : this.refundinfolist)
/*     */       {
/* 106 */         _output_.writeMessage(1, _v_);
/*     */       }
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
/*     */         case 10: 
/* 135 */           xbean.AuctionRefundInfo _v_ = new AuctionRefundInfo(0, this, "refundinfolist");
/* 136 */           _input_.readMessage(_v_);
/* 137 */           this.refundinfolist.add(_v_);
/* 138 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 142 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 144 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 153 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 157 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 159 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionMergeInfo copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new AuctionMergeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionMergeInfo toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionMergeInfo toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new AuctionMergeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionMergeInfo toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionMergeInfo toBeanIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.AuctionRefundInfo> getRefundinfolist()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return xdb.Logs.logList(new xdb.LogKey(this, "refundinfolist"), this.refundinfolist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.AuctionRefundInfo> getRefundinfolistAsData()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/*     */     
/* 215 */     AuctionMergeInfo _o_ = this;
/* 216 */     List<xbean.AuctionRefundInfo> refundinfolist = new ArrayList();
/* 217 */     for (xbean.AuctionRefundInfo _v_ : _o_.refundinfolist)
/* 218 */       refundinfolist.add(new AuctionRefundInfo.Data(_v_));
/* 219 */     return refundinfolist;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     AuctionMergeInfo _o_ = null;
/* 227 */     if ((_o1_ instanceof AuctionMergeInfo)) { _o_ = (AuctionMergeInfo)_o1_;
/* 228 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 229 */       return false;
/* 230 */     if (!this.refundinfolist.equals(_o_.refundinfolist)) return false;
/* 231 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     int _h_ = 0;
/* 239 */     _h_ += this.refundinfolist.hashCode();
/* 240 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     StringBuilder _sb_ = new StringBuilder();
/* 248 */     _sb_.append("(");
/* 249 */     _sb_.append(this.refundinfolist);
/* 250 */     _sb_.append(")");
/* 251 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 257 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 258 */     lb.add(new xdb.logs.ListenableChanged().setVarName("refundinfolist"));
/* 259 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AuctionMergeInfo {
/*     */     private Const() {}
/*     */     
/*     */     AuctionMergeInfo nThis() {
/* 266 */       return AuctionMergeInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 272 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionMergeInfo copy()
/*     */     {
/* 278 */       return AuctionMergeInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionMergeInfo toData()
/*     */     {
/* 284 */       return AuctionMergeInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AuctionMergeInfo toBean()
/*     */     {
/* 289 */       return AuctionMergeInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionMergeInfo toDataIf()
/*     */     {
/* 295 */       return AuctionMergeInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AuctionMergeInfo toBeanIf()
/*     */     {
/* 300 */       return AuctionMergeInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.AuctionRefundInfo> getRefundinfolist()
/*     */     {
/* 307 */       AuctionMergeInfo.this._xdb_verify_unsafe_();
/* 308 */       return xdb.Consts.constList(AuctionMergeInfo.this.refundinfolist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.AuctionRefundInfo> getRefundinfolistAsData()
/*     */     {
/* 314 */       AuctionMergeInfo.this._xdb_verify_unsafe_();
/*     */       
/* 316 */       AuctionMergeInfo _o_ = AuctionMergeInfo.this;
/* 317 */       List<xbean.AuctionRefundInfo> refundinfolist = new ArrayList();
/* 318 */       for (xbean.AuctionRefundInfo _v_ : _o_.refundinfolist)
/* 319 */         refundinfolist.add(new AuctionRefundInfo.Data(_v_));
/* 320 */       return refundinfolist;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 326 */       AuctionMergeInfo.this._xdb_verify_unsafe_();
/* 327 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 333 */       AuctionMergeInfo.this._xdb_verify_unsafe_();
/* 334 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 340 */       return AuctionMergeInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 346 */       return AuctionMergeInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 352 */       AuctionMergeInfo.this._xdb_verify_unsafe_();
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 359 */       return AuctionMergeInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 365 */       return AuctionMergeInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 371 */       AuctionMergeInfo.this._xdb_verify_unsafe_();
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 378 */       return AuctionMergeInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 384 */       return AuctionMergeInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 390 */       return AuctionMergeInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 396 */       return AuctionMergeInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 402 */       return AuctionMergeInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 408 */       return AuctionMergeInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 414 */       return AuctionMergeInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AuctionMergeInfo
/*     */   {
/*     */     private ArrayList<xbean.AuctionRefundInfo> refundinfolist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 431 */       this.refundinfolist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.AuctionMergeInfo _o1_)
/*     */     {
/* 436 */       if ((_o1_ instanceof AuctionMergeInfo)) { assign((AuctionMergeInfo)_o1_);
/* 437 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 438 */       } else if ((_o1_ instanceof AuctionMergeInfo.Const)) assign(((AuctionMergeInfo.Const)_o1_).nThis()); else {
/* 439 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AuctionMergeInfo _o_) {
/* 444 */       this.refundinfolist = new ArrayList();
/* 445 */       for (xbean.AuctionRefundInfo _v_ : _o_.refundinfolist) {
/* 446 */         this.refundinfolist.add(new AuctionRefundInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 451 */       this.refundinfolist = new ArrayList();
/* 452 */       for (xbean.AuctionRefundInfo _v_ : _o_.refundinfolist) {
/* 453 */         this.refundinfolist.add(new AuctionRefundInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       _os_.compact_uint32(this.refundinfolist.size());
/* 460 */       for (xbean.AuctionRefundInfo _v_ : this.refundinfolist)
/*     */       {
/* 462 */         _v_.marshal(_os_);
/*     */       }
/* 464 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 470 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 472 */         xbean.AuctionRefundInfo _v_ = xbean.Pod.newAuctionRefundInfoData();
/* 473 */         _v_.unmarshal(_os_);
/* 474 */         this.refundinfolist.add(_v_);
/*     */       }
/* 476 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 482 */       int _size_ = 0;
/* 483 */       for (xbean.AuctionRefundInfo _v_ : this.refundinfolist)
/*     */       {
/* 485 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 487 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 495 */         for (xbean.AuctionRefundInfo _v_ : this.refundinfolist)
/*     */         {
/* 497 */           _output_.writeMessage(1, _v_);
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 502 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 504 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 512 */         boolean done = false;
/* 513 */         while (!done)
/*     */         {
/* 515 */           int tag = _input_.readTag();
/* 516 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 520 */             done = true;
/* 521 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 525 */             xbean.AuctionRefundInfo _v_ = xbean.Pod.newAuctionRefundInfoData();
/* 526 */             _input_.readMessage(_v_);
/* 527 */             this.refundinfolist.add(_v_);
/* 528 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 532 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 534 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 543 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 547 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 549 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionMergeInfo copy()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionMergeInfo toData()
/*     */     {
/* 561 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AuctionMergeInfo toBean()
/*     */     {
/* 566 */       return new AuctionMergeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionMergeInfo toDataIf()
/*     */     {
/* 572 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AuctionMergeInfo toBeanIf()
/*     */     {
/* 577 */       return new AuctionMergeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 587 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 591 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 595 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 599 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 603 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 607 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.AuctionRefundInfo> getRefundinfolist()
/*     */     {
/* 614 */       return this.refundinfolist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.AuctionRefundInfo> getRefundinfolistAsData()
/*     */     {
/* 621 */       return this.refundinfolist;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 627 */       if (!(_o1_ instanceof Data)) return false;
/* 628 */       Data _o_ = (Data)_o1_;
/* 629 */       if (!this.refundinfolist.equals(_o_.refundinfolist)) return false;
/* 630 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 636 */       int _h_ = 0;
/* 637 */       _h_ += this.refundinfolist.hashCode();
/* 638 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 644 */       StringBuilder _sb_ = new StringBuilder();
/* 645 */       _sb_.append("(");
/* 646 */       _sb_.append(this.refundinfolist);
/* 647 */       _sb_.append(")");
/* 648 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionMergeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */