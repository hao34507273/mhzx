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
/*     */ public final class MarriageParades extends XBean implements xbean.MarriageParades
/*     */ {
/*     */   private LinkedList<xbean.MarriageParade> marriageparades;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.marriageparades.clear();
/*     */   }
/*     */   
/*     */   MarriageParades(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.marriageparades = new LinkedList();
/*     */   }
/*     */   
/*     */   public MarriageParades()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MarriageParades(MarriageParades _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MarriageParades(xbean.MarriageParades _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof MarriageParades)) { assign((MarriageParades)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MarriageParades _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.marriageparades = new LinkedList();
/*  50 */     for (xbean.MarriageParade _v_ : _o_.marriageparades) {
/*  51 */       this.marriageparades.add(new MarriageParade(_v_, this, "marriageparades"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.marriageparades = new LinkedList();
/*  57 */     for (xbean.MarriageParade _v_ : _o_.marriageparades) {
/*  58 */       this.marriageparades.add(new MarriageParade(_v_, this, "marriageparades"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.marriageparades.size());
/*  66 */     for (xbean.MarriageParade _v_ : this.marriageparades)
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
/*  79 */       xbean.MarriageParade _v_ = new MarriageParade(0, this, "marriageparades");
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.marriageparades.add(_v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     for (xbean.MarriageParade _v_ : this.marriageparades)
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
/* 104 */       for (xbean.MarriageParade _v_ : this.marriageparades)
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
/* 135 */           xbean.MarriageParade _v_ = new MarriageParade(0, this, "marriageparades");
/* 136 */           _input_.readMessage(_v_);
/* 137 */           this.marriageparades.add(_v_);
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
/*     */   public xbean.MarriageParades copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new MarriageParades(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarriageParades toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarriageParades toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new MarriageParades(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarriageParades toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarriageParades toBeanIf()
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
/*     */   public List<xbean.MarriageParade> getMarriageparades()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return xdb.Logs.logList(new xdb.LogKey(this, "marriageparades"), this.marriageparades);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.MarriageParade> getMarriageparadesAsData()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/*     */     
/* 215 */     MarriageParades _o_ = this;
/* 216 */     List<xbean.MarriageParade> marriageparades = new LinkedList();
/* 217 */     for (xbean.MarriageParade _v_ : _o_.marriageparades)
/* 218 */       marriageparades.add(new MarriageParade.Data(_v_));
/* 219 */     return marriageparades;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     MarriageParades _o_ = null;
/* 227 */     if ((_o1_ instanceof MarriageParades)) { _o_ = (MarriageParades)_o1_;
/* 228 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 229 */       return false;
/* 230 */     if (!this.marriageparades.equals(_o_.marriageparades)) return false;
/* 231 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     int _h_ = 0;
/* 239 */     _h_ += this.marriageparades.hashCode();
/* 240 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     StringBuilder _sb_ = new StringBuilder();
/* 248 */     _sb_.append("(");
/* 249 */     _sb_.append(this.marriageparades);
/* 250 */     _sb_.append(")");
/* 251 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 257 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 258 */     lb.add(new xdb.logs.ListenableChanged().setVarName("marriageparades"));
/* 259 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MarriageParades {
/*     */     private Const() {}
/*     */     
/*     */     MarriageParades nThis() {
/* 266 */       return MarriageParades.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 272 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageParades copy()
/*     */     {
/* 278 */       return MarriageParades.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageParades toData()
/*     */     {
/* 284 */       return MarriageParades.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MarriageParades toBean()
/*     */     {
/* 289 */       return MarriageParades.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageParades toDataIf()
/*     */     {
/* 295 */       return MarriageParades.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MarriageParades toBeanIf()
/*     */     {
/* 300 */       return MarriageParades.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.MarriageParade> getMarriageparades()
/*     */     {
/* 307 */       MarriageParades.this._xdb_verify_unsafe_();
/* 308 */       return xdb.Consts.constList(MarriageParades.this.marriageparades);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.MarriageParade> getMarriageparadesAsData()
/*     */     {
/* 314 */       MarriageParades.this._xdb_verify_unsafe_();
/*     */       
/* 316 */       MarriageParades _o_ = MarriageParades.this;
/* 317 */       List<xbean.MarriageParade> marriageparades = new LinkedList();
/* 318 */       for (xbean.MarriageParade _v_ : _o_.marriageparades)
/* 319 */         marriageparades.add(new MarriageParade.Data(_v_));
/* 320 */       return marriageparades;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 326 */       MarriageParades.this._xdb_verify_unsafe_();
/* 327 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 333 */       MarriageParades.this._xdb_verify_unsafe_();
/* 334 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 340 */       return MarriageParades.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 346 */       return MarriageParades.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 352 */       MarriageParades.this._xdb_verify_unsafe_();
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 359 */       return MarriageParades.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 365 */       return MarriageParades.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 371 */       MarriageParades.this._xdb_verify_unsafe_();
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 378 */       return MarriageParades.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 384 */       return MarriageParades.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 390 */       return MarriageParades.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 396 */       return MarriageParades.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 402 */       return MarriageParades.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 408 */       return MarriageParades.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 414 */       return MarriageParades.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MarriageParades
/*     */   {
/*     */     private LinkedList<xbean.MarriageParade> marriageparades;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 431 */       this.marriageparades = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.MarriageParades _o1_)
/*     */     {
/* 436 */       if ((_o1_ instanceof MarriageParades)) { assign((MarriageParades)_o1_);
/* 437 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 438 */       } else if ((_o1_ instanceof MarriageParades.Const)) assign(((MarriageParades.Const)_o1_).nThis()); else {
/* 439 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MarriageParades _o_) {
/* 444 */       this.marriageparades = new LinkedList();
/* 445 */       for (xbean.MarriageParade _v_ : _o_.marriageparades) {
/* 446 */         this.marriageparades.add(new MarriageParade.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 451 */       this.marriageparades = new LinkedList();
/* 452 */       for (xbean.MarriageParade _v_ : _o_.marriageparades) {
/* 453 */         this.marriageparades.add(new MarriageParade.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       _os_.compact_uint32(this.marriageparades.size());
/* 460 */       for (xbean.MarriageParade _v_ : this.marriageparades)
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
/* 472 */         xbean.MarriageParade _v_ = xbean.Pod.newMarriageParadeData();
/* 473 */         _v_.unmarshal(_os_);
/* 474 */         this.marriageparades.add(_v_);
/*     */       }
/* 476 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 482 */       int _size_ = 0;
/* 483 */       for (xbean.MarriageParade _v_ : this.marriageparades)
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
/* 495 */         for (xbean.MarriageParade _v_ : this.marriageparades)
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
/* 525 */             xbean.MarriageParade _v_ = xbean.Pod.newMarriageParadeData();
/* 526 */             _input_.readMessage(_v_);
/* 527 */             this.marriageparades.add(_v_);
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
/*     */     public xbean.MarriageParades copy()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageParades toData()
/*     */     {
/* 561 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MarriageParades toBean()
/*     */     {
/* 566 */       return new MarriageParades(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageParades toDataIf()
/*     */     {
/* 572 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MarriageParades toBeanIf()
/*     */     {
/* 577 */       return new MarriageParades(this, null, null);
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
/*     */     public List<xbean.MarriageParade> getMarriageparades()
/*     */     {
/* 614 */       return this.marriageparades;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.MarriageParade> getMarriageparadesAsData()
/*     */     {
/* 621 */       return this.marriageparades;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 627 */       if (!(_o1_ instanceof Data)) return false;
/* 628 */       Data _o_ = (Data)_o1_;
/* 629 */       if (!this.marriageparades.equals(_o_.marriageparades)) return false;
/* 630 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 636 */       int _h_ = 0;
/* 637 */       _h_ += this.marriageparades.hashCode();
/* 638 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 644 */       StringBuilder _sb_ = new StringBuilder();
/* 645 */       _sb_.append("(");
/* 646 */       _sb_.append(this.marriageparades);
/* 647 */       _sb_.append(")");
/* 648 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarriageParades.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */