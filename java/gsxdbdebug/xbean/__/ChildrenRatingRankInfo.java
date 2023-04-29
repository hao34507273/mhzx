/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ChildrenRatingRankInfo extends XBean implements xbean.ChildrenRatingRankInfo
/*     */ {
/*     */   private LinkedList<xbean.SingleChildRatingRankInfo> ranklist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.ranklist.clear();
/*     */   }
/*     */   
/*     */   ChildrenRatingRankInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.ranklist = new LinkedList();
/*     */   }
/*     */   
/*     */   public ChildrenRatingRankInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChildrenRatingRankInfo(ChildrenRatingRankInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChildrenRatingRankInfo(xbean.ChildrenRatingRankInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof ChildrenRatingRankInfo)) { assign((ChildrenRatingRankInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChildrenRatingRankInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.ranklist = new LinkedList();
/*  50 */     for (xbean.SingleChildRatingRankInfo _v_ : _o_.ranklist) {
/*  51 */       this.ranklist.add(new SingleChildRatingRankInfo(_v_, this, "ranklist"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.ranklist = new LinkedList();
/*  57 */     for (xbean.SingleChildRatingRankInfo _v_ : _o_.ranklist) {
/*  58 */       this.ranklist.add(new SingleChildRatingRankInfo(_v_, this, "ranklist"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.ranklist.size());
/*  66 */     for (xbean.SingleChildRatingRankInfo _v_ : this.ranklist)
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
/*  79 */       xbean.SingleChildRatingRankInfo _v_ = new SingleChildRatingRankInfo(0, this, "ranklist");
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.ranklist.add(_v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     for (xbean.SingleChildRatingRankInfo _v_ : this.ranklist)
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
/* 104 */       for (xbean.SingleChildRatingRankInfo _v_ : this.ranklist)
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
/* 135 */           xbean.SingleChildRatingRankInfo _v_ = new SingleChildRatingRankInfo(0, this, "ranklist");
/* 136 */           _input_.readMessage(_v_);
/* 137 */           this.ranklist.add(_v_);
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
/*     */   public xbean.ChildrenRatingRankInfo copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new ChildrenRatingRankInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChildrenRatingRankInfo toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChildrenRatingRankInfo toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new ChildrenRatingRankInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChildrenRatingRankInfo toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChildrenRatingRankInfo toBeanIf()
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
/*     */   public List<xbean.SingleChildRatingRankInfo> getRanklist()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return xdb.Logs.logList(new xdb.LogKey(this, "ranklist"), this.ranklist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.SingleChildRatingRankInfo> getRanklistAsData()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/*     */     
/* 215 */     ChildrenRatingRankInfo _o_ = this;
/* 216 */     List<xbean.SingleChildRatingRankInfo> ranklist = new LinkedList();
/* 217 */     for (xbean.SingleChildRatingRankInfo _v_ : _o_.ranklist)
/* 218 */       ranklist.add(new SingleChildRatingRankInfo.Data(_v_));
/* 219 */     return ranklist;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     ChildrenRatingRankInfo _o_ = null;
/* 227 */     if ((_o1_ instanceof ChildrenRatingRankInfo)) { _o_ = (ChildrenRatingRankInfo)_o1_;
/* 228 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 229 */       return false;
/* 230 */     if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 231 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     int _h_ = 0;
/* 239 */     _h_ += this.ranklist.hashCode();
/* 240 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     StringBuilder _sb_ = new StringBuilder();
/* 248 */     _sb_.append("(");
/* 249 */     _sb_.append(this.ranklist);
/* 250 */     _sb_.append(")");
/* 251 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 257 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 258 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ranklist"));
/* 259 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChildrenRatingRankInfo {
/*     */     private Const() {}
/*     */     
/*     */     ChildrenRatingRankInfo nThis() {
/* 266 */       return ChildrenRatingRankInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 272 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenRatingRankInfo copy()
/*     */     {
/* 278 */       return ChildrenRatingRankInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenRatingRankInfo toData()
/*     */     {
/* 284 */       return ChildrenRatingRankInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChildrenRatingRankInfo toBean()
/*     */     {
/* 289 */       return ChildrenRatingRankInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenRatingRankInfo toDataIf()
/*     */     {
/* 295 */       return ChildrenRatingRankInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChildrenRatingRankInfo toBeanIf()
/*     */     {
/* 300 */       return ChildrenRatingRankInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SingleChildRatingRankInfo> getRanklist()
/*     */     {
/* 307 */       ChildrenRatingRankInfo.this._xdb_verify_unsafe_();
/* 308 */       return xdb.Consts.constList(ChildrenRatingRankInfo.this.ranklist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.SingleChildRatingRankInfo> getRanklistAsData()
/*     */     {
/* 314 */       ChildrenRatingRankInfo.this._xdb_verify_unsafe_();
/*     */       
/* 316 */       ChildrenRatingRankInfo _o_ = ChildrenRatingRankInfo.this;
/* 317 */       List<xbean.SingleChildRatingRankInfo> ranklist = new LinkedList();
/* 318 */       for (xbean.SingleChildRatingRankInfo _v_ : _o_.ranklist)
/* 319 */         ranklist.add(new SingleChildRatingRankInfo.Data(_v_));
/* 320 */       return ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 326 */       ChildrenRatingRankInfo.this._xdb_verify_unsafe_();
/* 327 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 333 */       ChildrenRatingRankInfo.this._xdb_verify_unsafe_();
/* 334 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 340 */       return ChildrenRatingRankInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 346 */       return ChildrenRatingRankInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 352 */       ChildrenRatingRankInfo.this._xdb_verify_unsafe_();
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 359 */       return ChildrenRatingRankInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 365 */       return ChildrenRatingRankInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 371 */       ChildrenRatingRankInfo.this._xdb_verify_unsafe_();
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 378 */       return ChildrenRatingRankInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 384 */       return ChildrenRatingRankInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 390 */       return ChildrenRatingRankInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 396 */       return ChildrenRatingRankInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 402 */       return ChildrenRatingRankInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 408 */       return ChildrenRatingRankInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 414 */       return ChildrenRatingRankInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChildrenRatingRankInfo
/*     */   {
/*     */     private LinkedList<xbean.SingleChildRatingRankInfo> ranklist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 431 */       this.ranklist = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.ChildrenRatingRankInfo _o1_)
/*     */     {
/* 436 */       if ((_o1_ instanceof ChildrenRatingRankInfo)) { assign((ChildrenRatingRankInfo)_o1_);
/* 437 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 438 */       } else if ((_o1_ instanceof ChildrenRatingRankInfo.Const)) assign(((ChildrenRatingRankInfo.Const)_o1_).nThis()); else {
/* 439 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChildrenRatingRankInfo _o_) {
/* 444 */       this.ranklist = new LinkedList();
/* 445 */       for (xbean.SingleChildRatingRankInfo _v_ : _o_.ranklist) {
/* 446 */         this.ranklist.add(new SingleChildRatingRankInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 451 */       this.ranklist = new LinkedList();
/* 452 */       for (xbean.SingleChildRatingRankInfo _v_ : _o_.ranklist) {
/* 453 */         this.ranklist.add(new SingleChildRatingRankInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       _os_.compact_uint32(this.ranklist.size());
/* 460 */       for (xbean.SingleChildRatingRankInfo _v_ : this.ranklist)
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
/* 472 */         xbean.SingleChildRatingRankInfo _v_ = xbean.Pod.newSingleChildRatingRankInfoData();
/* 473 */         _v_.unmarshal(_os_);
/* 474 */         this.ranklist.add(_v_);
/*     */       }
/* 476 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 482 */       int _size_ = 0;
/* 483 */       for (xbean.SingleChildRatingRankInfo _v_ : this.ranklist)
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
/* 495 */         for (xbean.SingleChildRatingRankInfo _v_ : this.ranklist)
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
/* 525 */             xbean.SingleChildRatingRankInfo _v_ = xbean.Pod.newSingleChildRatingRankInfoData();
/* 526 */             _input_.readMessage(_v_);
/* 527 */             this.ranklist.add(_v_);
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
/*     */     public xbean.ChildrenRatingRankInfo copy()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenRatingRankInfo toData()
/*     */     {
/* 561 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChildrenRatingRankInfo toBean()
/*     */     {
/* 566 */       return new ChildrenRatingRankInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenRatingRankInfo toDataIf()
/*     */     {
/* 572 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChildrenRatingRankInfo toBeanIf()
/*     */     {
/* 577 */       return new ChildrenRatingRankInfo(this, null, null);
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
/*     */     public List<xbean.SingleChildRatingRankInfo> getRanklist()
/*     */     {
/* 614 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SingleChildRatingRankInfo> getRanklistAsData()
/*     */     {
/* 621 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 627 */       if (!(_o1_ instanceof Data)) return false;
/* 628 */       Data _o_ = (Data)_o1_;
/* 629 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 630 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 636 */       int _h_ = 0;
/* 637 */       _h_ += this.ranklist.hashCode();
/* 638 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 644 */       StringBuilder _sb_ = new StringBuilder();
/* 645 */       _sb_.append("(");
/* 646 */       _sb_.append(this.ranklist);
/* 647 */       _sb_.append(")");
/* 648 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChildrenRatingRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */