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
/*     */ public final class SkillBuffResult extends XBean implements xbean.SkillBuffResult
/*     */ {
/*     */   private ArrayList<xbean.SkillBuffResultInfo> roundinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.roundinfo.clear();
/*     */   }
/*     */   
/*     */   SkillBuffResult(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.roundinfo = new ArrayList();
/*     */   }
/*     */   
/*     */   public SkillBuffResult()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SkillBuffResult(SkillBuffResult _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SkillBuffResult(xbean.SkillBuffResult _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof SkillBuffResult)) { assign((SkillBuffResult)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SkillBuffResult _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.roundinfo = new ArrayList();
/*  50 */     for (xbean.SkillBuffResultInfo _v_ : _o_.roundinfo) {
/*  51 */       this.roundinfo.add(new SkillBuffResultInfo(_v_, this, "roundinfo"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.roundinfo = new ArrayList();
/*  57 */     for (xbean.SkillBuffResultInfo _v_ : _o_.roundinfo) {
/*  58 */       this.roundinfo.add(new SkillBuffResultInfo(_v_, this, "roundinfo"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.roundinfo.size());
/*  66 */     for (xbean.SkillBuffResultInfo _v_ : this.roundinfo)
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
/*  79 */       xbean.SkillBuffResultInfo _v_ = new SkillBuffResultInfo(0, this, "roundinfo");
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.roundinfo.add(_v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     for (xbean.SkillBuffResultInfo _v_ : this.roundinfo)
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
/* 104 */       for (xbean.SkillBuffResultInfo _v_ : this.roundinfo)
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
/* 135 */           xbean.SkillBuffResultInfo _v_ = new SkillBuffResultInfo(0, this, "roundinfo");
/* 136 */           _input_.readMessage(_v_);
/* 137 */           this.roundinfo.add(_v_);
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
/*     */   public xbean.SkillBuffResult copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new SkillBuffResult(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillBuffResult toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillBuffResult toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new SkillBuffResult(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillBuffResult toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillBuffResult toBeanIf()
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
/*     */   public List<xbean.SkillBuffResultInfo> getRoundinfo()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return xdb.Logs.logList(new xdb.LogKey(this, "roundinfo"), this.roundinfo);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.SkillBuffResultInfo> getRoundinfoAsData()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/*     */     
/* 215 */     SkillBuffResult _o_ = this;
/* 216 */     List<xbean.SkillBuffResultInfo> roundinfo = new ArrayList();
/* 217 */     for (xbean.SkillBuffResultInfo _v_ : _o_.roundinfo)
/* 218 */       roundinfo.add(new SkillBuffResultInfo.Data(_v_));
/* 219 */     return roundinfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     SkillBuffResult _o_ = null;
/* 227 */     if ((_o1_ instanceof SkillBuffResult)) { _o_ = (SkillBuffResult)_o1_;
/* 228 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 229 */       return false;
/* 230 */     if (!this.roundinfo.equals(_o_.roundinfo)) return false;
/* 231 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     int _h_ = 0;
/* 239 */     _h_ += this.roundinfo.hashCode();
/* 240 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     StringBuilder _sb_ = new StringBuilder();
/* 248 */     _sb_.append("(");
/* 249 */     _sb_.append(this.roundinfo);
/* 250 */     _sb_.append(")");
/* 251 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 257 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 258 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roundinfo"));
/* 259 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SkillBuffResult {
/*     */     private Const() {}
/*     */     
/*     */     SkillBuffResult nThis() {
/* 266 */       return SkillBuffResult.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 272 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResult copy()
/*     */     {
/* 278 */       return SkillBuffResult.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResult toData()
/*     */     {
/* 284 */       return SkillBuffResult.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResult toBean()
/*     */     {
/* 289 */       return SkillBuffResult.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResult toDataIf()
/*     */     {
/* 295 */       return SkillBuffResult.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResult toBeanIf()
/*     */     {
/* 300 */       return SkillBuffResult.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SkillBuffResultInfo> getRoundinfo()
/*     */     {
/* 307 */       SkillBuffResult.this._xdb_verify_unsafe_();
/* 308 */       return xdb.Consts.constList(SkillBuffResult.this.roundinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.SkillBuffResultInfo> getRoundinfoAsData()
/*     */     {
/* 314 */       SkillBuffResult.this._xdb_verify_unsafe_();
/*     */       
/* 316 */       SkillBuffResult _o_ = SkillBuffResult.this;
/* 317 */       List<xbean.SkillBuffResultInfo> roundinfo = new ArrayList();
/* 318 */       for (xbean.SkillBuffResultInfo _v_ : _o_.roundinfo)
/* 319 */         roundinfo.add(new SkillBuffResultInfo.Data(_v_));
/* 320 */       return roundinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 326 */       SkillBuffResult.this._xdb_verify_unsafe_();
/* 327 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 333 */       SkillBuffResult.this._xdb_verify_unsafe_();
/* 334 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 340 */       return SkillBuffResult.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 346 */       return SkillBuffResult.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 352 */       SkillBuffResult.this._xdb_verify_unsafe_();
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 359 */       return SkillBuffResult.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 365 */       return SkillBuffResult.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 371 */       SkillBuffResult.this._xdb_verify_unsafe_();
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 378 */       return SkillBuffResult.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 384 */       return SkillBuffResult.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 390 */       return SkillBuffResult.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 396 */       return SkillBuffResult.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 402 */       return SkillBuffResult.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 408 */       return SkillBuffResult.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 414 */       return SkillBuffResult.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SkillBuffResult
/*     */   {
/*     */     private ArrayList<xbean.SkillBuffResultInfo> roundinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 431 */       this.roundinfo = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.SkillBuffResult _o1_)
/*     */     {
/* 436 */       if ((_o1_ instanceof SkillBuffResult)) { assign((SkillBuffResult)_o1_);
/* 437 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 438 */       } else if ((_o1_ instanceof SkillBuffResult.Const)) assign(((SkillBuffResult.Const)_o1_).nThis()); else {
/* 439 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SkillBuffResult _o_) {
/* 444 */       this.roundinfo = new ArrayList();
/* 445 */       for (xbean.SkillBuffResultInfo _v_ : _o_.roundinfo) {
/* 446 */         this.roundinfo.add(new SkillBuffResultInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 451 */       this.roundinfo = new ArrayList();
/* 452 */       for (xbean.SkillBuffResultInfo _v_ : _o_.roundinfo) {
/* 453 */         this.roundinfo.add(new SkillBuffResultInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       _os_.compact_uint32(this.roundinfo.size());
/* 460 */       for (xbean.SkillBuffResultInfo _v_ : this.roundinfo)
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
/* 472 */         xbean.SkillBuffResultInfo _v_ = xbean.Pod.newSkillBuffResultInfoData();
/* 473 */         _v_.unmarshal(_os_);
/* 474 */         this.roundinfo.add(_v_);
/*     */       }
/* 476 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 482 */       int _size_ = 0;
/* 483 */       for (xbean.SkillBuffResultInfo _v_ : this.roundinfo)
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
/* 495 */         for (xbean.SkillBuffResultInfo _v_ : this.roundinfo)
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
/* 525 */             xbean.SkillBuffResultInfo _v_ = xbean.Pod.newSkillBuffResultInfoData();
/* 526 */             _input_.readMessage(_v_);
/* 527 */             this.roundinfo.add(_v_);
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
/*     */     public xbean.SkillBuffResult copy()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResult toData()
/*     */     {
/* 561 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResult toBean()
/*     */     {
/* 566 */       return new SkillBuffResult(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillBuffResult toDataIf()
/*     */     {
/* 572 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SkillBuffResult toBeanIf()
/*     */     {
/* 577 */       return new SkillBuffResult(this, null, null);
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
/*     */     public List<xbean.SkillBuffResultInfo> getRoundinfo()
/*     */     {
/* 614 */       return this.roundinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SkillBuffResultInfo> getRoundinfoAsData()
/*     */     {
/* 621 */       return this.roundinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 627 */       if (!(_o1_ instanceof Data)) return false;
/* 628 */       Data _o_ = (Data)_o1_;
/* 629 */       if (!this.roundinfo.equals(_o_.roundinfo)) return false;
/* 630 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 636 */       int _h_ = 0;
/* 637 */       _h_ += this.roundinfo.hashCode();
/* 638 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 644 */       StringBuilder _sb_ = new StringBuilder();
/* 645 */       _sb_.append("(");
/* 646 */       _sb_.append(this.roundinfo);
/* 647 */       _sb_.append(")");
/* 648 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SkillBuffResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */