/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class FightCommandInfo extends XBean implements xbean.FightCommandInfo
/*     */ {
/*     */   private String content;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.content = "";
/*     */   }
/*     */   
/*     */   FightCommandInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.content = "";
/*     */   }
/*     */   
/*     */   public FightCommandInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightCommandInfo(FightCommandInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightCommandInfo(xbean.FightCommandInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof FightCommandInfo)) { assign((FightCommandInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FightCommandInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.content = _o_.content;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  54 */     this.content = _o_.content;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _xdb_verify_unsafe_();
/*  61 */     _os_.marshal(this.content, "UTF-16LE");
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     this.content = _os_.unmarshal_String("UTF-16LE");
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     int _size_ = 0;
/*     */     try
/*     */     {
/*  80 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/*  84 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeBytes(1, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  99 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 101 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       boolean done = false;
/* 111 */       while (!done)
/*     */       {
/* 113 */         int tag = _input_.readTag();
/* 114 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 118 */           done = true;
/* 119 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 123 */           this.content = _input_.readBytes().toString("UTF-16LE");
/* 124 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 128 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 130 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 139 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 143 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 145 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCommandInfo copy()
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/* 152 */     return new FightCommandInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCommandInfo toData()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCommandInfo toBean()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new FightCommandInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCommandInfo toDataIf()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCommandInfo toBeanIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getContentOctets()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return Octets.wrap(getContent(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContent(String _v_)
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     if (null == _v_)
/* 210 */       throw new NullPointerException();
/* 211 */     xdb.Logs.logIf(new xdb.LogKey(this, "content")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 215 */         new xdb.logs.LogString(this, FightCommandInfo.this.content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 219 */             FightCommandInfo.this.content = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 223 */     });
/* 224 */     this.content = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContentOctets(Octets _v_)
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     setContent(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     FightCommandInfo _o_ = null;
/* 240 */     if ((_o1_ instanceof FightCommandInfo)) { _o_ = (FightCommandInfo)_o1_;
/* 241 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 242 */       return false;
/* 243 */     if (!this.content.equals(_o_.content)) return false;
/* 244 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     int _h_ = 0;
/* 252 */     _h_ += this.content.hashCode();
/* 253 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     StringBuilder _sb_ = new StringBuilder();
/* 261 */     _sb_.append("(");
/* 262 */     _sb_.append("'").append(this.content).append("'");
/* 263 */     _sb_.append(")");
/* 264 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 270 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 271 */     lb.add(new xdb.logs.ListenableChanged().setVarName("content"));
/* 272 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightCommandInfo {
/*     */     private Const() {}
/*     */     
/*     */     FightCommandInfo nThis() {
/* 279 */       return FightCommandInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 285 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommandInfo copy()
/*     */     {
/* 291 */       return FightCommandInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommandInfo toData()
/*     */     {
/* 297 */       return FightCommandInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightCommandInfo toBean()
/*     */     {
/* 302 */       return FightCommandInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommandInfo toDataIf()
/*     */     {
/* 308 */       return FightCommandInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightCommandInfo toBeanIf()
/*     */     {
/* 313 */       return FightCommandInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 320 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 321 */       return FightCommandInfo.this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 328 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 329 */       return FightCommandInfo.this.getContentOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 336 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 337 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 344 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 345 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 351 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 352 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 358 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 359 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 365 */       return FightCommandInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 371 */       return FightCommandInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 377 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 378 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 384 */       return FightCommandInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 390 */       return FightCommandInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 396 */       FightCommandInfo.this._xdb_verify_unsafe_();
/* 397 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 403 */       return FightCommandInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 409 */       return FightCommandInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 415 */       return FightCommandInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 421 */       return FightCommandInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 427 */       return FightCommandInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 433 */       return FightCommandInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 439 */       return FightCommandInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightCommandInfo
/*     */   {
/*     */     private String content;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 456 */       this.content = "";
/*     */     }
/*     */     
/*     */     Data(xbean.FightCommandInfo _o1_)
/*     */     {
/* 461 */       if ((_o1_ instanceof FightCommandInfo)) { assign((FightCommandInfo)_o1_);
/* 462 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 463 */       } else if ((_o1_ instanceof FightCommandInfo.Const)) assign(((FightCommandInfo.Const)_o1_).nThis()); else {
/* 464 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FightCommandInfo _o_) {
/* 469 */       this.content = _o_.content;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 474 */       this.content = _o_.content;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 480 */       _os_.marshal(this.content, "UTF-16LE");
/* 481 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 487 */       this.content = _os_.unmarshal_String("UTF-16LE");
/* 488 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 494 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 497 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 501 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 503 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 511 */         _output_.writeBytes(1, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 515 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 517 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 525 */         boolean done = false;
/* 526 */         while (!done)
/*     */         {
/* 528 */           int tag = _input_.readTag();
/* 529 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 533 */             done = true;
/* 534 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 538 */             this.content = _input_.readBytes().toString("UTF-16LE");
/* 539 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 543 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 545 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 554 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 558 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 560 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommandInfo copy()
/*     */     {
/* 566 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommandInfo toData()
/*     */     {
/* 572 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightCommandInfo toBean()
/*     */     {
/* 577 */       return new FightCommandInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommandInfo toDataIf()
/*     */     {
/* 583 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightCommandInfo toBeanIf()
/*     */     {
/* 588 */       return new FightCommandInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 594 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 598 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 602 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 606 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 610 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 614 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 618 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 625 */       return this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 632 */       return Octets.wrap(getContent(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 639 */       if (null == _v_)
/* 640 */         throw new NullPointerException();
/* 641 */       this.content = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 648 */       setContent(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 654 */       if (!(_o1_ instanceof Data)) return false;
/* 655 */       Data _o_ = (Data)_o1_;
/* 656 */       if (!this.content.equals(_o_.content)) return false;
/* 657 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 663 */       int _h_ = 0;
/* 664 */       _h_ += this.content.hashCode();
/* 665 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 671 */       StringBuilder _sb_ = new StringBuilder();
/* 672 */       _sb_.append("(");
/* 673 */       _sb_.append("'").append(this.content).append("'");
/* 674 */       _sb_.append(")");
/* 675 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightCommandInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */