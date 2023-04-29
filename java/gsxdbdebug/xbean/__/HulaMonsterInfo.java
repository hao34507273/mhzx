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
/*     */ public final class HulaMonsterInfo extends XBean implements xbean.HulaMonsterInfo
/*     */ {
/*     */   private int monsterid;
/*     */   private int state;
/*     */   private int seq;
/*     */   private String mark_content;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.monsterid = 0;
/*  25 */     this.state = 0;
/*  26 */     this.seq = 0;
/*  27 */     this.mark_content = "";
/*     */   }
/*     */   
/*     */   HulaMonsterInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.mark_content = "";
/*     */   }
/*     */   
/*     */   public HulaMonsterInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HulaMonsterInfo(HulaMonsterInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HulaMonsterInfo(xbean.HulaMonsterInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof HulaMonsterInfo)) { assign((HulaMonsterInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(HulaMonsterInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.monsterid = _o_.monsterid;
/*  59 */     this.state = _o_.state;
/*  60 */     this.seq = _o_.seq;
/*  61 */     this.mark_content = _o_.mark_content;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.monsterid = _o_.monsterid;
/*  67 */     this.state = _o_.state;
/*  68 */     this.seq = _o_.seq;
/*  69 */     this.mark_content = _o_.mark_content;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.monsterid);
/*  77 */     _os_.marshal(this.state);
/*  78 */     _os_.marshal(this.seq);
/*  79 */     _os_.marshal(this.mark_content, "UTF-16LE");
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.monsterid = _os_.unmarshal_int();
/*  88 */     this.state = _os_.unmarshal_int();
/*  89 */     this.seq = _os_.unmarshal_int();
/*  90 */     this.mark_content = _os_.unmarshal_String("UTF-16LE");
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(1, this.monsterid);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(2, this.state);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(3, this.seq);
/*     */     try
/*     */     {
/* 104 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.mark_content, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 108 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.monsterid);
/* 120 */       _output_.writeInt32(2, this.state);
/* 121 */       _output_.writeInt32(3, this.seq);
/* 122 */       _output_.writeBytes(4, ByteString.copyFrom(this.mark_content, "UTF-16LE"));
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
/* 150 */           this.monsterid = _input_.readInt32();
/* 151 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 155 */           this.state = _input_.readInt32();
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 160 */           this.seq = _input_.readInt32();
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 34: 
/* 165 */           this.mark_content = _input_.readBytes().toString("UTF-16LE");
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
/*     */   public xbean.HulaMonsterInfo copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new HulaMonsterInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HulaMonsterInfo toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HulaMonsterInfo toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new HulaMonsterInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HulaMonsterInfo toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HulaMonsterInfo toBeanIf()
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
/*     */   public int getMonsterid()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.monsterid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getState()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSeq()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.seq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getMark_content()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return this.mark_content;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getMark_contentOctets()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return Octets.wrap(getMark_content(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMonsterid(int _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     xdb.Logs.logIf(new LogKey(this, "monsterid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 279 */         new xdb.logs.LogInt(this, HulaMonsterInfo.this.monsterid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 283 */             HulaMonsterInfo.this.monsterid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 287 */     });
/* 288 */     this.monsterid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setState(int _v_)
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     xdb.Logs.logIf(new LogKey(this, "state")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 300 */         new xdb.logs.LogInt(this, HulaMonsterInfo.this.state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 304 */             HulaMonsterInfo.this.state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 308 */     });
/* 309 */     this.state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSeq(int _v_)
/*     */   {
/* 316 */     _xdb_verify_unsafe_();
/* 317 */     xdb.Logs.logIf(new LogKey(this, "seq")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 321 */         new xdb.logs.LogInt(this, HulaMonsterInfo.this.seq)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 325 */             HulaMonsterInfo.this.seq = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 329 */     });
/* 330 */     this.seq = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMark_content(String _v_)
/*     */   {
/* 337 */     _xdb_verify_unsafe_();
/* 338 */     if (null == _v_)
/* 339 */       throw new NullPointerException();
/* 340 */     xdb.Logs.logIf(new LogKey(this, "mark_content")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 344 */         new xdb.logs.LogString(this, HulaMonsterInfo.this.mark_content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 348 */             HulaMonsterInfo.this.mark_content = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 352 */     });
/* 353 */     this.mark_content = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMark_contentOctets(Octets _v_)
/*     */   {
/* 360 */     _xdb_verify_unsafe_();
/* 361 */     setMark_content(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 367 */     _xdb_verify_unsafe_();
/* 368 */     HulaMonsterInfo _o_ = null;
/* 369 */     if ((_o1_ instanceof HulaMonsterInfo)) { _o_ = (HulaMonsterInfo)_o1_;
/* 370 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 371 */       return false;
/* 372 */     if (this.monsterid != _o_.monsterid) return false;
/* 373 */     if (this.state != _o_.state) return false;
/* 374 */     if (this.seq != _o_.seq) return false;
/* 375 */     if (!this.mark_content.equals(_o_.mark_content)) return false;
/* 376 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 382 */     _xdb_verify_unsafe_();
/* 383 */     int _h_ = 0;
/* 384 */     _h_ += this.monsterid;
/* 385 */     _h_ += this.state;
/* 386 */     _h_ += this.seq;
/* 387 */     _h_ += this.mark_content.hashCode();
/* 388 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 394 */     _xdb_verify_unsafe_();
/* 395 */     StringBuilder _sb_ = new StringBuilder();
/* 396 */     _sb_.append("(");
/* 397 */     _sb_.append(this.monsterid);
/* 398 */     _sb_.append(",");
/* 399 */     _sb_.append(this.state);
/* 400 */     _sb_.append(",");
/* 401 */     _sb_.append(this.seq);
/* 402 */     _sb_.append(",");
/* 403 */     _sb_.append("'").append(this.mark_content).append("'");
/* 404 */     _sb_.append(")");
/* 405 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 411 */     ListenableBean lb = new ListenableBean();
/* 412 */     lb.add(new ListenableChanged().setVarName("monsterid"));
/* 413 */     lb.add(new ListenableChanged().setVarName("state"));
/* 414 */     lb.add(new ListenableChanged().setVarName("seq"));
/* 415 */     lb.add(new ListenableChanged().setVarName("mark_content"));
/* 416 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HulaMonsterInfo {
/*     */     private Const() {}
/*     */     
/*     */     HulaMonsterInfo nThis() {
/* 423 */       return HulaMonsterInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 429 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaMonsterInfo copy()
/*     */     {
/* 435 */       return HulaMonsterInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaMonsterInfo toData()
/*     */     {
/* 441 */       return HulaMonsterInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HulaMonsterInfo toBean()
/*     */     {
/* 446 */       return HulaMonsterInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaMonsterInfo toDataIf()
/*     */     {
/* 452 */       return HulaMonsterInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HulaMonsterInfo toBeanIf()
/*     */     {
/* 457 */       return HulaMonsterInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMonsterid()
/*     */     {
/* 464 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 465 */       return HulaMonsterInfo.this.monsterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getState()
/*     */     {
/* 472 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 473 */       return HulaMonsterInfo.this.state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSeq()
/*     */     {
/* 480 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 481 */       return HulaMonsterInfo.this.seq;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getMark_content()
/*     */     {
/* 488 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 489 */       return HulaMonsterInfo.this.mark_content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getMark_contentOctets()
/*     */     {
/* 496 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 497 */       return HulaMonsterInfo.this.getMark_contentOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMonsterid(int _v_)
/*     */     {
/* 504 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setState(int _v_)
/*     */     {
/* 512 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeq(int _v_)
/*     */     {
/* 520 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMark_content(String _v_)
/*     */     {
/* 528 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMark_contentOctets(Octets _v_)
/*     */     {
/* 536 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 543 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 544 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 550 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 551 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 557 */       return HulaMonsterInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 563 */       return HulaMonsterInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 569 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 570 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 576 */       return HulaMonsterInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 582 */       return HulaMonsterInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 588 */       HulaMonsterInfo.this._xdb_verify_unsafe_();
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 595 */       return HulaMonsterInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 601 */       return HulaMonsterInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 607 */       return HulaMonsterInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 613 */       return HulaMonsterInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 619 */       return HulaMonsterInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 625 */       return HulaMonsterInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 631 */       return HulaMonsterInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HulaMonsterInfo
/*     */   {
/*     */     private int monsterid;
/*     */     
/*     */     private int state;
/*     */     
/*     */     private int seq;
/*     */     
/*     */     private String mark_content;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 654 */       this.mark_content = "";
/*     */     }
/*     */     
/*     */     Data(xbean.HulaMonsterInfo _o1_)
/*     */     {
/* 659 */       if ((_o1_ instanceof HulaMonsterInfo)) { assign((HulaMonsterInfo)_o1_);
/* 660 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 661 */       } else if ((_o1_ instanceof HulaMonsterInfo.Const)) assign(((HulaMonsterInfo.Const)_o1_).nThis()); else {
/* 662 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(HulaMonsterInfo _o_) {
/* 667 */       this.monsterid = _o_.monsterid;
/* 668 */       this.state = _o_.state;
/* 669 */       this.seq = _o_.seq;
/* 670 */       this.mark_content = _o_.mark_content;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 675 */       this.monsterid = _o_.monsterid;
/* 676 */       this.state = _o_.state;
/* 677 */       this.seq = _o_.seq;
/* 678 */       this.mark_content = _o_.mark_content;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.monsterid);
/* 685 */       _os_.marshal(this.state);
/* 686 */       _os_.marshal(this.seq);
/* 687 */       _os_.marshal(this.mark_content, "UTF-16LE");
/* 688 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 694 */       this.monsterid = _os_.unmarshal_int();
/* 695 */       this.state = _os_.unmarshal_int();
/* 696 */       this.seq = _os_.unmarshal_int();
/* 697 */       this.mark_content = _os_.unmarshal_String("UTF-16LE");
/* 698 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 704 */       int _size_ = 0;
/* 705 */       _size_ += CodedOutputStream.computeInt32Size(1, this.monsterid);
/* 706 */       _size_ += CodedOutputStream.computeInt32Size(2, this.state);
/* 707 */       _size_ += CodedOutputStream.computeInt32Size(3, this.seq);
/*     */       try
/*     */       {
/* 710 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.mark_content, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 714 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 716 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 724 */         _output_.writeInt32(1, this.monsterid);
/* 725 */         _output_.writeInt32(2, this.state);
/* 726 */         _output_.writeInt32(3, this.seq);
/* 727 */         _output_.writeBytes(4, ByteString.copyFrom(this.mark_content, "UTF-16LE"));
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
/* 754 */             this.monsterid = _input_.readInt32();
/* 755 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 759 */             this.state = _input_.readInt32();
/* 760 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 764 */             this.seq = _input_.readInt32();
/* 765 */             break;
/*     */           
/*     */ 
/*     */           case 34: 
/* 769 */             this.mark_content = _input_.readBytes().toString("UTF-16LE");
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
/*     */     public xbean.HulaMonsterInfo copy()
/*     */     {
/* 797 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaMonsterInfo toData()
/*     */     {
/* 803 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HulaMonsterInfo toBean()
/*     */     {
/* 808 */       return new HulaMonsterInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HulaMonsterInfo toDataIf()
/*     */     {
/* 814 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HulaMonsterInfo toBeanIf()
/*     */     {
/* 819 */       return new HulaMonsterInfo(this, null, null);
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
/*     */     public int getMonsterid()
/*     */     {
/* 856 */       return this.monsterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getState()
/*     */     {
/* 863 */       return this.state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSeq()
/*     */     {
/* 870 */       return this.seq;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getMark_content()
/*     */     {
/* 877 */       return this.mark_content;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getMark_contentOctets()
/*     */     {
/* 884 */       return Octets.wrap(getMark_content(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMonsterid(int _v_)
/*     */     {
/* 891 */       this.monsterid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setState(int _v_)
/*     */     {
/* 898 */       this.state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSeq(int _v_)
/*     */     {
/* 905 */       this.seq = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMark_content(String _v_)
/*     */     {
/* 912 */       if (null == _v_)
/* 913 */         throw new NullPointerException();
/* 914 */       this.mark_content = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMark_contentOctets(Octets _v_)
/*     */     {
/* 921 */       setMark_content(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 927 */       if (!(_o1_ instanceof Data)) return false;
/* 928 */       Data _o_ = (Data)_o1_;
/* 929 */       if (this.monsterid != _o_.monsterid) return false;
/* 930 */       if (this.state != _o_.state) return false;
/* 931 */       if (this.seq != _o_.seq) return false;
/* 932 */       if (!this.mark_content.equals(_o_.mark_content)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.monsterid;
/* 941 */       _h_ += this.state;
/* 942 */       _h_ += this.seq;
/* 943 */       _h_ += this.mark_content.hashCode();
/* 944 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 950 */       StringBuilder _sb_ = new StringBuilder();
/* 951 */       _sb_.append("(");
/* 952 */       _sb_.append(this.monsterid);
/* 953 */       _sb_.append(",");
/* 954 */       _sb_.append(this.state);
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append(this.seq);
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append("'").append(this.mark_content).append("'");
/* 959 */       _sb_.append(")");
/* 960 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HulaMonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */