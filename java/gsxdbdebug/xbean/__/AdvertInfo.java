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
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class AdvertInfo extends XBean implements xbean.AdvertInfo
/*     */ {
/*     */   private int adverttype;
/*     */   private long release_timestamp;
/*     */   private String content;
/*     */   private int istop;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.adverttype = 0;
/*  25 */     this.release_timestamp = 0L;
/*  26 */     this.content = "";
/*  27 */     this.istop = 0;
/*     */   }
/*     */   
/*     */   AdvertInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.content = "";
/*     */   }
/*     */   
/*     */   public AdvertInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AdvertInfo(AdvertInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AdvertInfo(xbean.AdvertInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof AdvertInfo)) { assign((AdvertInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AdvertInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.adverttype = _o_.adverttype;
/*  59 */     this.release_timestamp = _o_.release_timestamp;
/*  60 */     this.content = _o_.content;
/*  61 */     this.istop = _o_.istop;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.adverttype = _o_.adverttype;
/*  67 */     this.release_timestamp = _o_.release_timestamp;
/*  68 */     this.content = _o_.content;
/*  69 */     this.istop = _o_.istop;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.adverttype);
/*  77 */     _os_.marshal(this.release_timestamp);
/*  78 */     _os_.marshal(this.content, "UTF-16LE");
/*  79 */     _os_.marshal(this.istop);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.adverttype = _os_.unmarshal_int();
/*  88 */     this.release_timestamp = _os_.unmarshal_long();
/*  89 */     this.content = _os_.unmarshal_String("UTF-16LE");
/*  90 */     this.istop = _os_.unmarshal_int();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(1, this.adverttype);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(2, this.release_timestamp);
/*     */     try
/*     */     {
/* 103 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 107 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(4, this.istop);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.adverttype);
/* 120 */       _output_.writeInt64(2, this.release_timestamp);
/* 121 */       _output_.writeBytes(3, ByteString.copyFrom(this.content, "UTF-16LE"));
/* 122 */       _output_.writeInt32(4, this.istop);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 126 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 128 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 134 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 137 */       boolean done = false;
/* 138 */       while (!done)
/*     */       {
/* 140 */         int tag = _input_.readTag();
/* 141 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 145 */           done = true;
/* 146 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 150 */           this.adverttype = _input_.readInt32();
/* 151 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 155 */           this.release_timestamp = _input_.readInt64();
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 160 */           this.content = _input_.readBytes().toString("UTF-16LE");
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 165 */           this.istop = _input_.readInt32();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 170 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 172 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 181 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 185 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 187 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AdvertInfo copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new AdvertInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AdvertInfo toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AdvertInfo toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new AdvertInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AdvertInfo toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AdvertInfo toBeanIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAdverttype()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.adverttype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRelease_timestamp()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.release_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getContentOctets()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return Octets.wrap(getContent(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIstop()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return this.istop;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAdverttype(int _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     xdb.Logs.logIf(new LogKey(this, "adverttype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 279 */         new xdb.logs.LogInt(this, AdvertInfo.this.adverttype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 283 */             AdvertInfo.this.adverttype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 287 */     });
/* 288 */     this.adverttype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRelease_timestamp(long _v_)
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     xdb.Logs.logIf(new LogKey(this, "release_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 300 */         new xdb.logs.LogLong(this, AdvertInfo.this.release_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 304 */             AdvertInfo.this.release_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 308 */     });
/* 309 */     this.release_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContent(String _v_)
/*     */   {
/* 316 */     _xdb_verify_unsafe_();
/* 317 */     if (null == _v_)
/* 318 */       throw new NullPointerException();
/* 319 */     xdb.Logs.logIf(new LogKey(this, "content")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 323 */         new xdb.logs.LogString(this, AdvertInfo.this.content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 327 */             AdvertInfo.this.content = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 331 */     });
/* 332 */     this.content = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContentOctets(Octets _v_)
/*     */   {
/* 339 */     _xdb_verify_unsafe_();
/* 340 */     setContent(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIstop(int _v_)
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     xdb.Logs.logIf(new LogKey(this, "istop")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 352 */         new xdb.logs.LogInt(this, AdvertInfo.this.istop)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 356 */             AdvertInfo.this.istop = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 360 */     });
/* 361 */     this.istop = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 367 */     _xdb_verify_unsafe_();
/* 368 */     AdvertInfo _o_ = null;
/* 369 */     if ((_o1_ instanceof AdvertInfo)) { _o_ = (AdvertInfo)_o1_;
/* 370 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 371 */       return false;
/* 372 */     if (this.adverttype != _o_.adverttype) return false;
/* 373 */     if (this.release_timestamp != _o_.release_timestamp) return false;
/* 374 */     if (!this.content.equals(_o_.content)) return false;
/* 375 */     if (this.istop != _o_.istop) return false;
/* 376 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 382 */     _xdb_verify_unsafe_();
/* 383 */     int _h_ = 0;
/* 384 */     _h_ += this.adverttype;
/* 385 */     _h_ = (int)(_h_ + this.release_timestamp);
/* 386 */     _h_ += this.content.hashCode();
/* 387 */     _h_ += this.istop;
/* 388 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 394 */     _xdb_verify_unsafe_();
/* 395 */     StringBuilder _sb_ = new StringBuilder();
/* 396 */     _sb_.append("(");
/* 397 */     _sb_.append(this.adverttype);
/* 398 */     _sb_.append(",");
/* 399 */     _sb_.append(this.release_timestamp);
/* 400 */     _sb_.append(",");
/* 401 */     _sb_.append("'").append(this.content).append("'");
/* 402 */     _sb_.append(",");
/* 403 */     _sb_.append(this.istop);
/* 404 */     _sb_.append(")");
/* 405 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 411 */     ListenableBean lb = new ListenableBean();
/* 412 */     lb.add(new ListenableChanged().setVarName("adverttype"));
/* 413 */     lb.add(new ListenableChanged().setVarName("release_timestamp"));
/* 414 */     lb.add(new ListenableChanged().setVarName("content"));
/* 415 */     lb.add(new ListenableChanged().setVarName("istop"));
/* 416 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AdvertInfo {
/*     */     private Const() {}
/*     */     
/*     */     AdvertInfo nThis() {
/* 423 */       return AdvertInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 429 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AdvertInfo copy()
/*     */     {
/* 435 */       return AdvertInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AdvertInfo toData()
/*     */     {
/* 441 */       return AdvertInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AdvertInfo toBean()
/*     */     {
/* 446 */       return AdvertInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AdvertInfo toDataIf()
/*     */     {
/* 452 */       return AdvertInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AdvertInfo toBeanIf()
/*     */     {
/* 457 */       return AdvertInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAdverttype()
/*     */     {
/* 464 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 465 */       return AdvertInfo.this.adverttype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRelease_timestamp()
/*     */     {
/* 472 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 473 */       return AdvertInfo.this.release_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 480 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 481 */       return AdvertInfo.this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 488 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 489 */       return AdvertInfo.this.getContentOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIstop()
/*     */     {
/* 496 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 497 */       return AdvertInfo.this.istop;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAdverttype(int _v_)
/*     */     {
/* 504 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRelease_timestamp(long _v_)
/*     */     {
/* 512 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 520 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 528 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIstop(int _v_)
/*     */     {
/* 536 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 543 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 544 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 550 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 551 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 557 */       return AdvertInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 563 */       return AdvertInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 569 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 570 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 576 */       return AdvertInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 582 */       return AdvertInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 588 */       AdvertInfo.this._xdb_verify_unsafe_();
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 595 */       return AdvertInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 601 */       return AdvertInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 607 */       return AdvertInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 613 */       return AdvertInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 619 */       return AdvertInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 625 */       return AdvertInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 631 */       return AdvertInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AdvertInfo
/*     */   {
/*     */     private int adverttype;
/*     */     
/*     */     private long release_timestamp;
/*     */     
/*     */     private String content;
/*     */     
/*     */     private int istop;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 654 */       this.content = "";
/*     */     }
/*     */     
/*     */     Data(xbean.AdvertInfo _o1_)
/*     */     {
/* 659 */       if ((_o1_ instanceof AdvertInfo)) { assign((AdvertInfo)_o1_);
/* 660 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 661 */       } else if ((_o1_ instanceof AdvertInfo.Const)) assign(((AdvertInfo.Const)_o1_).nThis()); else {
/* 662 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AdvertInfo _o_) {
/* 667 */       this.adverttype = _o_.adverttype;
/* 668 */       this.release_timestamp = _o_.release_timestamp;
/* 669 */       this.content = _o_.content;
/* 670 */       this.istop = _o_.istop;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 675 */       this.adverttype = _o_.adverttype;
/* 676 */       this.release_timestamp = _o_.release_timestamp;
/* 677 */       this.content = _o_.content;
/* 678 */       this.istop = _o_.istop;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.adverttype);
/* 685 */       _os_.marshal(this.release_timestamp);
/* 686 */       _os_.marshal(this.content, "UTF-16LE");
/* 687 */       _os_.marshal(this.istop);
/* 688 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 694 */       this.adverttype = _os_.unmarshal_int();
/* 695 */       this.release_timestamp = _os_.unmarshal_long();
/* 696 */       this.content = _os_.unmarshal_String("UTF-16LE");
/* 697 */       this.istop = _os_.unmarshal_int();
/* 698 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 704 */       int _size_ = 0;
/* 705 */       _size_ += CodedOutputStream.computeInt32Size(1, this.adverttype);
/* 706 */       _size_ += CodedOutputStream.computeInt64Size(2, this.release_timestamp);
/*     */       try
/*     */       {
/* 709 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.content, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 713 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 715 */       _size_ += CodedOutputStream.computeInt32Size(4, this.istop);
/* 716 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 724 */         _output_.writeInt32(1, this.adverttype);
/* 725 */         _output_.writeInt64(2, this.release_timestamp);
/* 726 */         _output_.writeBytes(3, ByteString.copyFrom(this.content, "UTF-16LE"));
/* 727 */         _output_.writeInt32(4, this.istop);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 731 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 733 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 741 */         boolean done = false;
/* 742 */         while (!done)
/*     */         {
/* 744 */           int tag = _input_.readTag();
/* 745 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 749 */             done = true;
/* 750 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 754 */             this.adverttype = _input_.readInt32();
/* 755 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 759 */             this.release_timestamp = _input_.readInt64();
/* 760 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 764 */             this.content = _input_.readBytes().toString("UTF-16LE");
/* 765 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 769 */             this.istop = _input_.readInt32();
/* 770 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 774 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 776 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 785 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 789 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 791 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AdvertInfo copy()
/*     */     {
/* 797 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AdvertInfo toData()
/*     */     {
/* 803 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AdvertInfo toBean()
/*     */     {
/* 808 */       return new AdvertInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AdvertInfo toDataIf()
/*     */     {
/* 814 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AdvertInfo toBeanIf()
/*     */     {
/* 819 */       return new AdvertInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 825 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 829 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 833 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 837 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 841 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 845 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 849 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAdverttype()
/*     */     {
/* 856 */       return this.adverttype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRelease_timestamp()
/*     */     {
/* 863 */       return this.release_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getContent()
/*     */     {
/* 870 */       return this.content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getContentOctets()
/*     */     {
/* 877 */       return Octets.wrap(getContent(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIstop()
/*     */     {
/* 884 */       return this.istop;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAdverttype(int _v_)
/*     */     {
/* 891 */       this.adverttype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRelease_timestamp(long _v_)
/*     */     {
/* 898 */       this.release_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(String _v_)
/*     */     {
/* 905 */       if (null == _v_)
/* 906 */         throw new NullPointerException();
/* 907 */       this.content = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentOctets(Octets _v_)
/*     */     {
/* 914 */       setContent(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIstop(int _v_)
/*     */     {
/* 921 */       this.istop = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 927 */       if (!(_o1_ instanceof Data)) return false;
/* 928 */       Data _o_ = (Data)_o1_;
/* 929 */       if (this.adverttype != _o_.adverttype) return false;
/* 930 */       if (this.release_timestamp != _o_.release_timestamp) return false;
/* 931 */       if (!this.content.equals(_o_.content)) return false;
/* 932 */       if (this.istop != _o_.istop) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.adverttype;
/* 941 */       _h_ = (int)(_h_ + this.release_timestamp);
/* 942 */       _h_ += this.content.hashCode();
/* 943 */       _h_ += this.istop;
/* 944 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 950 */       StringBuilder _sb_ = new StringBuilder();
/* 951 */       _sb_.append("(");
/* 952 */       _sb_.append(this.adverttype);
/* 953 */       _sb_.append(",");
/* 954 */       _sb_.append(this.release_timestamp);
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append("'").append(this.content).append("'");
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.istop);
/* 959 */       _sb_.append(")");
/* 960 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AdvertInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */