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
/*     */ public final class FormatArgs extends XBean implements xbean.FormatArgs
/*     */ {
/*     */   private ArrayList<String> args;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.args.clear();
/*     */   }
/*     */   
/*     */   FormatArgs(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public FormatArgs()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FormatArgs(FormatArgs _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FormatArgs(xbean.FormatArgs _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof FormatArgs)) { assign((FormatArgs)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FormatArgs _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.args = new ArrayList();
/*  50 */     this.args.addAll(_o_.args);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.args = new ArrayList();
/*  56 */     this.args.addAll(_o_.args);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.args.size());
/*  64 */     for (String _v_ : this.args)
/*     */     {
/*  66 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       String _v_ = "";
/*  78 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  79 */       this.args.add(_v_);
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (String _v_ : this.args)
/*     */     {
/*     */       try
/*     */       {
/*  93 */         _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/*  97 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */     }
/* 100 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 109 */       for (String _v_ : this.args)
/*     */       {
/* 111 */         _output_.writeBytes(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 116 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 118 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 127 */       boolean done = false;
/* 128 */       while (!done)
/*     */       {
/* 130 */         int tag = _input_.readTag();
/* 131 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 135 */           done = true;
/* 136 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 140 */           String _v_ = "";
/* 141 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/* 142 */           this.args.add(_v_);
/* 143 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 147 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 149 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 158 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 162 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 164 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FormatArgs copy()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new FormatArgs(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FormatArgs toData()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FormatArgs toBean()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new FormatArgs(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FormatArgs toDataIf()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FormatArgs toBeanIf()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getArgs()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return xdb.Logs.logList(new xdb.LogKey(this, "args"), this.args);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getArgsAsData()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/*     */     
/* 220 */     FormatArgs _o_ = this;
/* 221 */     List<String> args = new ArrayList();
/* 222 */     args.addAll(_o_.args);
/* 223 */     return args;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     FormatArgs _o_ = null;
/* 231 */     if ((_o1_ instanceof FormatArgs)) { _o_ = (FormatArgs)_o1_;
/* 232 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 233 */       return false;
/* 234 */     if (!this.args.equals(_o_.args)) return false;
/* 235 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     int _h_ = 0;
/* 243 */     _h_ += this.args.hashCode();
/* 244 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     StringBuilder _sb_ = new StringBuilder();
/* 252 */     _sb_.append("(");
/* 253 */     _sb_.append(this.args);
/* 254 */     _sb_.append(")");
/* 255 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 261 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 262 */     lb.add(new xdb.logs.ListenableChanged().setVarName("args"));
/* 263 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FormatArgs {
/*     */     private Const() {}
/*     */     
/*     */     FormatArgs nThis() {
/* 270 */       return FormatArgs.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 276 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FormatArgs copy()
/*     */     {
/* 282 */       return FormatArgs.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FormatArgs toData()
/*     */     {
/* 288 */       return FormatArgs.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FormatArgs toBean()
/*     */     {
/* 293 */       return FormatArgs.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FormatArgs toDataIf()
/*     */     {
/* 299 */       return FormatArgs.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FormatArgs toBeanIf()
/*     */     {
/* 304 */       return FormatArgs.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getArgs()
/*     */     {
/* 311 */       FormatArgs.this._xdb_verify_unsafe_();
/* 312 */       return xdb.Consts.constList(FormatArgs.this.args);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<String> getArgsAsData()
/*     */     {
/* 318 */       FormatArgs.this._xdb_verify_unsafe_();
/*     */       
/* 320 */       FormatArgs _o_ = FormatArgs.this;
/* 321 */       List<String> args = new ArrayList();
/* 322 */       args.addAll(_o_.args);
/* 323 */       return args;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 329 */       FormatArgs.this._xdb_verify_unsafe_();
/* 330 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 336 */       FormatArgs.this._xdb_verify_unsafe_();
/* 337 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 343 */       return FormatArgs.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 349 */       return FormatArgs.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 355 */       FormatArgs.this._xdb_verify_unsafe_();
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 362 */       return FormatArgs.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 368 */       return FormatArgs.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 374 */       FormatArgs.this._xdb_verify_unsafe_();
/* 375 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 381 */       return FormatArgs.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 387 */       return FormatArgs.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 393 */       return FormatArgs.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 399 */       return FormatArgs.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 405 */       return FormatArgs.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 411 */       return FormatArgs.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 417 */       return FormatArgs.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FormatArgs
/*     */   {
/*     */     private ArrayList<String> args;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 429 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 434 */       this.args = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.FormatArgs _o1_)
/*     */     {
/* 439 */       if ((_o1_ instanceof FormatArgs)) { assign((FormatArgs)_o1_);
/* 440 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 441 */       } else if ((_o1_ instanceof FormatArgs.Const)) assign(((FormatArgs.Const)_o1_).nThis()); else {
/* 442 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FormatArgs _o_) {
/* 447 */       this.args = new ArrayList();
/* 448 */       this.args.addAll(_o_.args);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 453 */       this.args = new ArrayList();
/* 454 */       this.args.addAll(_o_.args);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       _os_.compact_uint32(this.args.size());
/* 461 */       for (String _v_ : this.args)
/*     */       {
/* 463 */         _os_.marshal(_v_, "UTF-16LE");
/*     */       }
/* 465 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 471 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 473 */         String _v_ = "";
/* 474 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 475 */         this.args.add(_v_);
/*     */       }
/* 477 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 483 */       int _size_ = 0;
/* 484 */       for (String _v_ : this.args)
/*     */       {
/*     */         try
/*     */         {
/* 488 */           _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 492 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/*     */       }
/* 495 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 503 */         for (String _v_ : this.args)
/*     */         {
/* 505 */           _output_.writeBytes(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 510 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 512 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 520 */         boolean done = false;
/* 521 */         while (!done)
/*     */         {
/* 523 */           int tag = _input_.readTag();
/* 524 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 528 */             done = true;
/* 529 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 533 */             String _v_ = "";
/* 534 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 535 */             this.args.add(_v_);
/* 536 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 540 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 542 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 551 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 555 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 557 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FormatArgs copy()
/*     */     {
/* 563 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FormatArgs toData()
/*     */     {
/* 569 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FormatArgs toBean()
/*     */     {
/* 574 */       return new FormatArgs(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FormatArgs toDataIf()
/*     */     {
/* 580 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FormatArgs toBeanIf()
/*     */     {
/* 585 */       return new FormatArgs(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 591 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 595 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 599 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 603 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 611 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 615 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getArgs()
/*     */     {
/* 622 */       return this.args;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getArgsAsData()
/*     */     {
/* 629 */       return this.args;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 635 */       if (!(_o1_ instanceof Data)) return false;
/* 636 */       Data _o_ = (Data)_o1_;
/* 637 */       if (!this.args.equals(_o_.args)) return false;
/* 638 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 644 */       int _h_ = 0;
/* 645 */       _h_ += this.args.hashCode();
/* 646 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 652 */       StringBuilder _sb_ = new StringBuilder();
/* 653 */       _sb_.append("(");
/* 654 */       _sb_.append(this.args);
/* 655 */       _sb_.append(")");
/* 656 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FormatArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */