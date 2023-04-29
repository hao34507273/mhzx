/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ApplyInfo extends XBean implements xbean.ApplyInfo
/*     */ {
/*     */   private int applysec;
/*     */   private String content;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.applysec = 0;
/*  21 */     this.content = "";
/*     */   }
/*     */   
/*     */   ApplyInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.content = "";
/*     */   }
/*     */   
/*     */   public ApplyInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ApplyInfo(ApplyInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ApplyInfo(xbean.ApplyInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof ApplyInfo)) { assign((ApplyInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ApplyInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.applysec = _o_.applysec;
/*  53 */     this.content = _o_.content;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.applysec = _o_.applysec;
/*  59 */     this.content = _o_.content;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.applysec);
/*  67 */     _os_.marshal(this.content, "UTF-16LE");
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.applysec = _os_.unmarshal_int();
/*  76 */     this.content = _os_.unmarshal_String("UTF-16LE");
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(1, this.applysec);
/*     */     try
/*     */     {
/*  88 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/*  92 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.applysec);
/* 104 */       _output_.writeBytes(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 108 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 110 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       boolean done = false;
/* 120 */       while (!done)
/*     */       {
/* 122 */         int tag = _input_.readTag();
/* 123 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 127 */           done = true;
/* 128 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 132 */           this.applysec = _input_.readInt32();
/* 133 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 137 */           this.content = _input_.readBytes().toString("UTF-16LE");
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
/*     */   public xbean.ApplyInfo copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new ApplyInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ApplyInfo toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ApplyInfo toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new ApplyInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ApplyInfo toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ApplyInfo toBeanIf()
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
/*     */   public int getApplysec()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.applysec;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getContentOctets()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return Octets.wrap(getContent(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setApplysec(int _v_)
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     xdb.Logs.logIf(new LogKey(this, "applysec")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 235 */         new xdb.logs.LogInt(this, ApplyInfo.this.applysec)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 239 */             ApplyInfo.this.applysec = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 243 */     });
/* 244 */     this.applysec = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContent(String _v_)
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     if (null == _v_)
/* 253 */       throw new NullPointerException();
/* 254 */     xdb.Logs.logIf(new LogKey(this, "content")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 258 */         new xdb.logs.LogString(this, ApplyInfo.this.content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 262 */             ApplyInfo.this.content = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 266 */     });
/* 267 */     this.content = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContentOctets(Octets _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     setContent(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     ApplyInfo _o_ = null;
/* 283 */     if ((_o1_ instanceof ApplyInfo)) { _o_ = (ApplyInfo)_o1_;
/* 284 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 285 */       return false;
/* 286 */     if (this.applysec != _o_.applysec) return false;
/* 287 */     if (!this.content.equals(_o_.content)) return false;
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     int _h_ = 0;
/* 296 */     _h_ += this.applysec;
/* 297 */     _h_ += this.content.hashCode();
/* 298 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     StringBuilder _sb_ = new StringBuilder();
/* 306 */     _sb_.append("(");
/* 307 */     _sb_.append(this.applysec);
/* 308 */     _sb_.append(",");
/* 309 */     _sb_.append("'").append(this.content).append("'");
/* 310 */     _sb_.append(")");
/* 311 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 317 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 318 */     lb.add(new xdb.logs.ListenableChanged().setVarName("applysec"));
/* 319 */     lb.add(new xdb.logs.ListenableChanged().setVarName("content"));
/* 320 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ApplyInfo {
/*     */     private Const() {}
/*     */     
/*     */     ApplyInfo nThis() {
/* 327 */       return ApplyInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 333 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApplyInfo copy()
/*     */     {
/* 339 */       return ApplyInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApplyInfo toData()
/*     */     {
/* 345 */       return ApplyInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ApplyInfo toBean()
/*     */     {
/* 350 */       return ApplyInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApplyInfo toDataIf()
/*     */     {
/* 356 */       return ApplyInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ApplyInfo toBeanIf()
/*     */     {
/* 361 */       return ApplyInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getApplysec()
/*     */     {
/* 368 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 369 */       return ApplyInfo.this.applysec;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 376 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 377 */       return ApplyInfo.this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 384 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 385 */       return ApplyInfo.this.getContentOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setApplysec(int _v_)
/*     */     {
/* 392 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 393 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 400 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 408 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 409 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 415 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 416 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 422 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 423 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 429 */       return ApplyInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 435 */       return ApplyInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 441 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 448 */       return ApplyInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 454 */       return ApplyInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 460 */       ApplyInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 467 */       return ApplyInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 473 */       return ApplyInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 479 */       return ApplyInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 485 */       return ApplyInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 491 */       return ApplyInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 497 */       return ApplyInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 503 */       return ApplyInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ApplyInfo
/*     */   {
/*     */     private int applysec;
/*     */     
/*     */     private String content;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 522 */       this.content = "";
/*     */     }
/*     */     
/*     */     Data(xbean.ApplyInfo _o1_)
/*     */     {
/* 527 */       if ((_o1_ instanceof ApplyInfo)) { assign((ApplyInfo)_o1_);
/* 528 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 529 */       } else if ((_o1_ instanceof ApplyInfo.Const)) assign(((ApplyInfo.Const)_o1_).nThis()); else {
/* 530 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ApplyInfo _o_) {
/* 535 */       this.applysec = _o_.applysec;
/* 536 */       this.content = _o_.content;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.applysec = _o_.applysec;
/* 542 */       this.content = _o_.content;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.applysec);
/* 549 */       _os_.marshal(this.content, "UTF-16LE");
/* 550 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 556 */       this.applysec = _os_.unmarshal_int();
/* 557 */       this.content = _os_.unmarshal_String("UTF-16LE");
/* 558 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 564 */       int _size_ = 0;
/* 565 */       _size_ += CodedOutputStream.computeInt32Size(1, this.applysec);
/*     */       try
/*     */       {
/* 568 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 572 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 574 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 582 */         _output_.writeInt32(1, this.applysec);
/* 583 */         _output_.writeBytes(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 597 */         boolean done = false;
/* 598 */         while (!done)
/*     */         {
/* 600 */           int tag = _input_.readTag();
/* 601 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 605 */             done = true;
/* 606 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 610 */             this.applysec = _input_.readInt32();
/* 611 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 615 */             this.content = _input_.readBytes().toString("UTF-16LE");
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
/*     */     public xbean.ApplyInfo copy()
/*     */     {
/* 643 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApplyInfo toData()
/*     */     {
/* 649 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ApplyInfo toBean()
/*     */     {
/* 654 */       return new ApplyInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ApplyInfo toDataIf()
/*     */     {
/* 660 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ApplyInfo toBeanIf()
/*     */     {
/* 665 */       return new ApplyInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 671 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
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
/*     */     public xdb.Bean toConst() {
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
/*     */     public int getApplysec()
/*     */     {
/* 702 */       return this.applysec;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 709 */       return this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 716 */       return Octets.wrap(getContent(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setApplysec(int _v_)
/*     */     {
/* 723 */       this.applysec = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 730 */       if (null == _v_)
/* 731 */         throw new NullPointerException();
/* 732 */       this.content = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 739 */       setContent(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 745 */       if (!(_o1_ instanceof Data)) return false;
/* 746 */       Data _o_ = (Data)_o1_;
/* 747 */       if (this.applysec != _o_.applysec) return false;
/* 748 */       if (!this.content.equals(_o_.content)) return false;
/* 749 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 755 */       int _h_ = 0;
/* 756 */       _h_ += this.applysec;
/* 757 */       _h_ += this.content.hashCode();
/* 758 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 764 */       StringBuilder _sb_ = new StringBuilder();
/* 765 */       _sb_.append("(");
/* 766 */       _sb_.append(this.applysec);
/* 767 */       _sb_.append(",");
/* 768 */       _sb_.append("'").append(this.content).append("'");
/* 769 */       _sb_.append(")");
/* 770 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ApplyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */