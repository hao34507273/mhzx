/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Notice extends XBean implements xbean.Notice
/*     */ {
/*     */   private String title;
/*     */   private String content;
/*     */   private long timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.title = "";
/*  23 */     this.content = "";
/*  24 */     this.timestamp = 0L;
/*     */   }
/*     */   
/*     */   Notice(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.title = "";
/*  31 */     this.content = "";
/*     */   }
/*     */   
/*     */   public Notice()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Notice(Notice _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Notice(xbean.Notice _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof Notice)) { assign((Notice)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Notice _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.title = _o_.title;
/*  57 */     this.content = _o_.content;
/*  58 */     this.timestamp = _o_.timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.title = _o_.title;
/*  64 */     this.content = _o_.content;
/*  65 */     this.timestamp = _o_.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _xdb_verify_unsafe_();
/*  72 */     _os_.marshal(this.title, "UTF-16LE");
/*  73 */     _os_.marshal(this.content, "UTF-16LE");
/*  74 */     _os_.marshal(this.timestamp);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     this.title = _os_.unmarshal_String("UTF-16LE");
/*  83 */     this.content = _os_.unmarshal_String("UTF-16LE");
/*  84 */     this.timestamp = _os_.unmarshal_long();
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     int _size_ = 0;
/*     */     try
/*     */     {
/*  95 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.title, "UTF-16LE"));
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/*  99 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/*     */     try
/*     */     {
/* 103 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/* 107 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(3, this.timestamp);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeBytes(1, ByteString.copyFrom(this.title, "UTF-16LE"));
/* 120 */       _output_.writeBytes(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/* 121 */       _output_.writeInt64(3, this.timestamp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 125 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 127 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 136 */       boolean done = false;
/* 137 */       while (!done)
/*     */       {
/* 139 */         int tag = _input_.readTag();
/* 140 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 144 */           done = true;
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 149 */           this.title = _input_.readBytes().toString("UTF-16LE");
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 154 */           this.content = _input_.readBytes().toString("UTF-16LE");
/* 155 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 159 */           this.timestamp = _input_.readInt64();
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
/*     */   public xbean.Notice copy()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new Notice(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Notice toData()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Notice toBean()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Notice(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Notice toDataIf()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Notice toBeanIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getTitleOctets()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return Octets.wrap(getTitle(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getContentOctets()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return Octets.wrap(getContent(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTimestamp()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTitle(String _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     if (null == _v_)
/* 270 */       throw new NullPointerException();
/* 271 */     xdb.Logs.logIf(new LogKey(this, "title")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 275 */         new xdb.logs.LogString(this, Notice.this.title)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 279 */             Notice.this.title = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 283 */     });
/* 284 */     this.title = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTitleOctets(Octets _v_)
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     setTitle(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContent(String _v_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     if (null == _v_)
/* 301 */       throw new NullPointerException();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "content")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 306 */         new xdb.logs.LogString(this, Notice.this.content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             Notice.this.content = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.content = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContentOctets(Octets _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     setContent(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimestamp(long _v_)
/*     */   {
/* 330 */     _xdb_verify_unsafe_();
/* 331 */     xdb.Logs.logIf(new LogKey(this, "timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 335 */         new xdb.logs.LogLong(this, Notice.this.timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 339 */             Notice.this.timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 343 */     });
/* 344 */     this.timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 350 */     _xdb_verify_unsafe_();
/* 351 */     Notice _o_ = null;
/* 352 */     if ((_o1_ instanceof Notice)) { _o_ = (Notice)_o1_;
/* 353 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 354 */       return false;
/* 355 */     if (!this.title.equals(_o_.title)) return false;
/* 356 */     if (!this.content.equals(_o_.content)) return false;
/* 357 */     if (this.timestamp != _o_.timestamp) return false;
/* 358 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     int _h_ = 0;
/* 366 */     _h_ += this.title.hashCode();
/* 367 */     _h_ += this.content.hashCode();
/* 368 */     _h_ = (int)(_h_ + this.timestamp);
/* 369 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 375 */     _xdb_verify_unsafe_();
/* 376 */     StringBuilder _sb_ = new StringBuilder();
/* 377 */     _sb_.append("(");
/* 378 */     _sb_.append("'").append(this.title).append("'");
/* 379 */     _sb_.append(",");
/* 380 */     _sb_.append("'").append(this.content).append("'");
/* 381 */     _sb_.append(",");
/* 382 */     _sb_.append(this.timestamp);
/* 383 */     _sb_.append(")");
/* 384 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 390 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 391 */     lb.add(new xdb.logs.ListenableChanged().setVarName("title"));
/* 392 */     lb.add(new xdb.logs.ListenableChanged().setVarName("content"));
/* 393 */     lb.add(new xdb.logs.ListenableChanged().setVarName("timestamp"));
/* 394 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Notice {
/*     */     private Const() {}
/*     */     
/*     */     Notice nThis() {
/* 401 */       return Notice.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Notice copy()
/*     */     {
/* 413 */       return Notice.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Notice toData()
/*     */     {
/* 419 */       return Notice.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Notice toBean()
/*     */     {
/* 424 */       return Notice.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Notice toDataIf()
/*     */     {
/* 430 */       return Notice.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Notice toBeanIf()
/*     */     {
/* 435 */       return Notice.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getTitle()
/*     */     {
/* 442 */       Notice.this._xdb_verify_unsafe_();
/* 443 */       return Notice.this.title;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getTitleOctets()
/*     */     {
/* 450 */       Notice.this._xdb_verify_unsafe_();
/* 451 */       return Notice.this.getTitleOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 458 */       Notice.this._xdb_verify_unsafe_();
/* 459 */       return Notice.this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 466 */       Notice.this._xdb_verify_unsafe_();
/* 467 */       return Notice.this.getContentOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 474 */       Notice.this._xdb_verify_unsafe_();
/* 475 */       return Notice.this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitle(String _v_)
/*     */     {
/* 482 */       Notice.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitleOctets(Octets _v_)
/*     */     {
/* 490 */       Notice.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 498 */       Notice.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 506 */       Notice.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 514 */       Notice.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 521 */       Notice.this._xdb_verify_unsafe_();
/* 522 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 528 */       Notice.this._xdb_verify_unsafe_();
/* 529 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 535 */       return Notice.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 541 */       return Notice.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 547 */       Notice.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 554 */       return Notice.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 560 */       return Notice.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 566 */       Notice.this._xdb_verify_unsafe_();
/* 567 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 573 */       return Notice.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 579 */       return Notice.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 585 */       return Notice.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 591 */       return Notice.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 597 */       return Notice.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 603 */       return Notice.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 609 */       return Notice.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Notice
/*     */   {
/*     */     private String title;
/*     */     
/*     */     private String content;
/*     */     
/*     */     private long timestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 630 */       this.title = "";
/* 631 */       this.content = "";
/*     */     }
/*     */     
/*     */     Data(xbean.Notice _o1_)
/*     */     {
/* 636 */       if ((_o1_ instanceof Notice)) { assign((Notice)_o1_);
/* 637 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 638 */       } else if ((_o1_ instanceof Notice.Const)) assign(((Notice.Const)_o1_).nThis()); else {
/* 639 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Notice _o_) {
/* 644 */       this.title = _o_.title;
/* 645 */       this.content = _o_.content;
/* 646 */       this.timestamp = _o_.timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 651 */       this.title = _o_.title;
/* 652 */       this.content = _o_.content;
/* 653 */       this.timestamp = _o_.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.marshal(this.title, "UTF-16LE");
/* 660 */       _os_.marshal(this.content, "UTF-16LE");
/* 661 */       _os_.marshal(this.timestamp);
/* 662 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 668 */       this.title = _os_.unmarshal_String("UTF-16LE");
/* 669 */       this.content = _os_.unmarshal_String("UTF-16LE");
/* 670 */       this.timestamp = _os_.unmarshal_long();
/* 671 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 677 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 680 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.title, "UTF-16LE"));
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 684 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */       try
/*     */       {
/* 688 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 692 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 694 */       _size_ += CodedOutputStream.computeInt64Size(3, this.timestamp);
/* 695 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 703 */         _output_.writeBytes(1, ByteString.copyFrom(this.title, "UTF-16LE"));
/* 704 */         _output_.writeBytes(2, ByteString.copyFrom(this.content, "UTF-16LE"));
/* 705 */         _output_.writeInt64(3, this.timestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 709 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 711 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 719 */         boolean done = false;
/* 720 */         while (!done)
/*     */         {
/* 722 */           int tag = _input_.readTag();
/* 723 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 727 */             done = true;
/* 728 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 732 */             this.title = _input_.readBytes().toString("UTF-16LE");
/* 733 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 737 */             this.content = _input_.readBytes().toString("UTF-16LE");
/* 738 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 742 */             this.timestamp = _input_.readInt64();
/* 743 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 747 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 749 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 758 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 762 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 764 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Notice copy()
/*     */     {
/* 770 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Notice toData()
/*     */     {
/* 776 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Notice toBean()
/*     */     {
/* 781 */       return new Notice(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Notice toDataIf()
/*     */     {
/* 787 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Notice toBeanIf()
/*     */     {
/* 792 */       return new Notice(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 798 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 802 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 806 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 810 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 814 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 818 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 822 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getTitle()
/*     */     {
/* 829 */       return this.title;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getTitleOctets()
/*     */     {
/* 836 */       return Octets.wrap(getTitle(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 843 */       return this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 850 */       return Octets.wrap(getContent(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimestamp()
/*     */     {
/* 857 */       return this.timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitle(String _v_)
/*     */     {
/* 864 */       if (null == _v_)
/* 865 */         throw new NullPointerException();
/* 866 */       this.title = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTitleOctets(Octets _v_)
/*     */     {
/* 873 */       setTitle(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 880 */       if (null == _v_)
/* 881 */         throw new NullPointerException();
/* 882 */       this.content = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 889 */       setContent(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimestamp(long _v_)
/*     */     {
/* 896 */       this.timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 902 */       if (!(_o1_ instanceof Data)) return false;
/* 903 */       Data _o_ = (Data)_o1_;
/* 904 */       if (!this.title.equals(_o_.title)) return false;
/* 905 */       if (!this.content.equals(_o_.content)) return false;
/* 906 */       if (this.timestamp != _o_.timestamp) return false;
/* 907 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 913 */       int _h_ = 0;
/* 914 */       _h_ += this.title.hashCode();
/* 915 */       _h_ += this.content.hashCode();
/* 916 */       _h_ = (int)(_h_ + this.timestamp);
/* 917 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 923 */       StringBuilder _sb_ = new StringBuilder();
/* 924 */       _sb_.append("(");
/* 925 */       _sb_.append("'").append(this.title).append("'");
/* 926 */       _sb_.append(",");
/* 927 */       _sb_.append("'").append(this.content).append("'");
/* 928 */       _sb_.append(",");
/* 929 */       _sb_.append(this.timestamp);
/* 930 */       _sb_.append(")");
/* 931 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Notice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */