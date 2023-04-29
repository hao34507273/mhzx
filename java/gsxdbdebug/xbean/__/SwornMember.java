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
/*     */ public final class SwornMember extends XBean implements xbean.SwornMember
/*     */ {
/*     */   private long swornid;
/*     */   private String title;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.swornid = 0L;
/*  21 */     this.title = "";
/*     */   }
/*     */   
/*     */   SwornMember(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.title = "";
/*     */   }
/*     */   
/*     */   public SwornMember()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SwornMember(SwornMember _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SwornMember(xbean.SwornMember _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof SwornMember)) { assign((SwornMember)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SwornMember _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.swornid = _o_.swornid;
/*  53 */     this.title = _o_.title;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.swornid = _o_.swornid;
/*  59 */     this.title = _o_.title;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.swornid);
/*  67 */     _os_.marshal(this.title, "UTF-16LE");
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.swornid = _os_.unmarshal_long();
/*  76 */     this.title = _os_.unmarshal_String("UTF-16LE");
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(1, this.swornid);
/*     */     try
/*     */     {
/*  88 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.title, "UTF-16LE"));
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
/* 103 */       _output_.writeInt64(1, this.swornid);
/* 104 */       _output_.writeBytes(2, ByteString.copyFrom(this.title, "UTF-16LE"));
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
/* 132 */           this.swornid = _input_.readInt64();
/* 133 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 137 */           this.title = _input_.readBytes().toString("UTF-16LE");
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
/*     */   public xbean.SwornMember copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new SwornMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SwornMember toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SwornMember toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new SwornMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SwornMember toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SwornMember toBeanIf()
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
/*     */   public long getSwornid()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.swornid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getTitleOctets()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return Octets.wrap(getTitle(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSwornid(long _v_)
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     xdb.Logs.logIf(new LogKey(this, "swornid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 235 */         new xdb.logs.LogLong(this, SwornMember.this.swornid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 239 */             SwornMember.this.swornid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 243 */     });
/* 244 */     this.swornid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTitle(String _v_)
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     if (null == _v_)
/* 253 */       throw new NullPointerException();
/* 254 */     xdb.Logs.logIf(new LogKey(this, "title")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 258 */         new xdb.logs.LogString(this, SwornMember.this.title)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 262 */             SwornMember.this.title = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 266 */     });
/* 267 */     this.title = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTitleOctets(Octets _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     setTitle(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     SwornMember _o_ = null;
/* 283 */     if ((_o1_ instanceof SwornMember)) { _o_ = (SwornMember)_o1_;
/* 284 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 285 */       return false;
/* 286 */     if (this.swornid != _o_.swornid) return false;
/* 287 */     if (!this.title.equals(_o_.title)) return false;
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     int _h_ = 0;
/* 296 */     _h_ = (int)(_h_ + this.swornid);
/* 297 */     _h_ += this.title.hashCode();
/* 298 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     StringBuilder _sb_ = new StringBuilder();
/* 306 */     _sb_.append("(");
/* 307 */     _sb_.append(this.swornid);
/* 308 */     _sb_.append(",");
/* 309 */     _sb_.append("'").append(this.title).append("'");
/* 310 */     _sb_.append(")");
/* 311 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 317 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 318 */     lb.add(new xdb.logs.ListenableChanged().setVarName("swornid"));
/* 319 */     lb.add(new xdb.logs.ListenableChanged().setVarName("title"));
/* 320 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SwornMember {
/*     */     private Const() {}
/*     */     
/*     */     SwornMember nThis() {
/* 327 */       return SwornMember.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 333 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SwornMember copy()
/*     */     {
/* 339 */       return SwornMember.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SwornMember toData()
/*     */     {
/* 345 */       return SwornMember.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SwornMember toBean()
/*     */     {
/* 350 */       return SwornMember.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SwornMember toDataIf()
/*     */     {
/* 356 */       return SwornMember.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SwornMember toBeanIf()
/*     */     {
/* 361 */       return SwornMember.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSwornid()
/*     */     {
/* 368 */       SwornMember.this._xdb_verify_unsafe_();
/* 369 */       return SwornMember.this.swornid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getTitle()
/*     */     {
/* 376 */       SwornMember.this._xdb_verify_unsafe_();
/* 377 */       return SwornMember.this.title;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getTitleOctets()
/*     */     {
/* 384 */       SwornMember.this._xdb_verify_unsafe_();
/* 385 */       return SwornMember.this.getTitleOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSwornid(long _v_)
/*     */     {
/* 392 */       SwornMember.this._xdb_verify_unsafe_();
/* 393 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitle(String _v_)
/*     */     {
/* 400 */       SwornMember.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitleOctets(Octets _v_)
/*     */     {
/* 408 */       SwornMember.this._xdb_verify_unsafe_();
/* 409 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 415 */       SwornMember.this._xdb_verify_unsafe_();
/* 416 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 422 */       SwornMember.this._xdb_verify_unsafe_();
/* 423 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 429 */       return SwornMember.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 435 */       return SwornMember.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 441 */       SwornMember.this._xdb_verify_unsafe_();
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 448 */       return SwornMember.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 454 */       return SwornMember.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 460 */       SwornMember.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 467 */       return SwornMember.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 473 */       return SwornMember.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 479 */       return SwornMember.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 485 */       return SwornMember.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 491 */       return SwornMember.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 497 */       return SwornMember.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 503 */       return SwornMember.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SwornMember
/*     */   {
/*     */     private long swornid;
/*     */     
/*     */     private String title;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 522 */       this.title = "";
/*     */     }
/*     */     
/*     */     Data(xbean.SwornMember _o1_)
/*     */     {
/* 527 */       if ((_o1_ instanceof SwornMember)) { assign((SwornMember)_o1_);
/* 528 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 529 */       } else if ((_o1_ instanceof SwornMember.Const)) assign(((SwornMember.Const)_o1_).nThis()); else {
/* 530 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SwornMember _o_) {
/* 535 */       this.swornid = _o_.swornid;
/* 536 */       this.title = _o_.title;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.swornid = _o_.swornid;
/* 542 */       this.title = _o_.title;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.swornid);
/* 549 */       _os_.marshal(this.title, "UTF-16LE");
/* 550 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 556 */       this.swornid = _os_.unmarshal_long();
/* 557 */       this.title = _os_.unmarshal_String("UTF-16LE");
/* 558 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 564 */       int _size_ = 0;
/* 565 */       _size_ += CodedOutputStream.computeInt64Size(1, this.swornid);
/*     */       try
/*     */       {
/* 568 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.title, "UTF-16LE"));
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
/* 582 */         _output_.writeInt64(1, this.swornid);
/* 583 */         _output_.writeBytes(2, ByteString.copyFrom(this.title, "UTF-16LE"));
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
/* 610 */             this.swornid = _input_.readInt64();
/* 611 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 615 */             this.title = _input_.readBytes().toString("UTF-16LE");
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
/*     */     public xbean.SwornMember copy()
/*     */     {
/* 643 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SwornMember toData()
/*     */     {
/* 649 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SwornMember toBean()
/*     */     {
/* 654 */       return new SwornMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SwornMember toDataIf()
/*     */     {
/* 660 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SwornMember toBeanIf()
/*     */     {
/* 665 */       return new SwornMember(this, null, null);
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
/*     */     public long getSwornid()
/*     */     {
/* 702 */       return this.swornid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getTitle()
/*     */     {
/* 709 */       return this.title;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getTitleOctets()
/*     */     {
/* 716 */       return Octets.wrap(getTitle(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSwornid(long _v_)
/*     */     {
/* 723 */       this.swornid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitle(String _v_)
/*     */     {
/* 730 */       if (null == _v_)
/* 731 */         throw new NullPointerException();
/* 732 */       this.title = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitleOctets(Octets _v_)
/*     */     {
/* 739 */       setTitle(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 745 */       if (!(_o1_ instanceof Data)) return false;
/* 746 */       Data _o_ = (Data)_o1_;
/* 747 */       if (this.swornid != _o_.swornid) return false;
/* 748 */       if (!this.title.equals(_o_.title)) return false;
/* 749 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 755 */       int _h_ = 0;
/* 756 */       _h_ = (int)(_h_ + this.swornid);
/* 757 */       _h_ += this.title.hashCode();
/* 758 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 764 */       StringBuilder _sb_ = new StringBuilder();
/* 765 */       _sb_.append("(");
/* 766 */       _sb_.append(this.swornid);
/* 767 */       _sb_.append(",");
/* 768 */       _sb_.append("'").append(this.title).append("'");
/* 769 */       _sb_.append(")");
/* 770 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SwornMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */