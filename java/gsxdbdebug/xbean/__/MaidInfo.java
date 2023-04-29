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
/*     */ public final class MaidInfo extends XBean implements xbean.MaidInfo
/*     */ {
/*     */   private int maidcfgid;
/*     */   private String name;
/*     */   private int x;
/*     */   private int y;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.maidcfgid = 0;
/*  25 */     this.name = "";
/*  26 */     this.x = 0;
/*  27 */     this.y = 0;
/*     */   }
/*     */   
/*     */   MaidInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.name = "";
/*     */   }
/*     */   
/*     */   public MaidInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MaidInfo(MaidInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MaidInfo(xbean.MaidInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof MaidInfo)) { assign((MaidInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MaidInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.maidcfgid = _o_.maidcfgid;
/*  59 */     this.name = _o_.name;
/*  60 */     this.x = _o_.x;
/*  61 */     this.y = _o_.y;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.maidcfgid = _o_.maidcfgid;
/*  67 */     this.name = _o_.name;
/*  68 */     this.x = _o_.x;
/*  69 */     this.y = _o_.y;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.maidcfgid);
/*  77 */     _os_.marshal(this.name, "UTF-16LE");
/*  78 */     _os_.marshal(this.x);
/*  79 */     _os_.marshal(this.y);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.maidcfgid = _os_.unmarshal_int();
/*  88 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  89 */     this.x = _os_.unmarshal_int();
/*  90 */     this.y = _os_.unmarshal_int();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(1, this.maidcfgid);
/*     */     try
/*     */     {
/* 102 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.name, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 106 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(3, this.x);
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(4, this.y);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.maidcfgid);
/* 120 */       _output_.writeBytes(2, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 121 */       _output_.writeInt32(3, this.x);
/* 122 */       _output_.writeInt32(4, this.y);
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
/* 150 */           this.maidcfgid = _input_.readInt32();
/* 151 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 155 */           this.name = _input_.readBytes().toString("UTF-16LE");
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 160 */           this.x = _input_.readInt32();
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 165 */           this.y = _input_.readInt32();
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
/*     */   public xbean.MaidInfo copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new MaidInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MaidInfo toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MaidInfo toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new MaidInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MaidInfo toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MaidInfo toBeanIf()
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
/*     */   public int getMaidcfgid()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.maidcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getNameOctets()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return Octets.wrap(getName(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getX()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return this.x;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getY()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return this.y;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMaidcfgid(int _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     xdb.Logs.logIf(new LogKey(this, "maidcfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 279 */         new xdb.logs.LogInt(this, MaidInfo.this.maidcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 283 */             MaidInfo.this.maidcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 287 */     });
/* 288 */     this.maidcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String _v_)
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     if (null == _v_)
/* 297 */       throw new NullPointerException();
/* 298 */     xdb.Logs.logIf(new LogKey(this, "name")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 302 */         new xdb.logs.LogString(this, MaidInfo.this.name)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 306 */             MaidInfo.this.name = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 310 */     });
/* 311 */     this.name = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNameOctets(Octets _v_)
/*     */   {
/* 318 */     _xdb_verify_unsafe_();
/* 319 */     setName(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setX(int _v_)
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     xdb.Logs.logIf(new LogKey(this, "x")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 331 */         new xdb.logs.LogInt(this, MaidInfo.this.x)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 335 */             MaidInfo.this.x = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 339 */     });
/* 340 */     this.x = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setY(int _v_)
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     xdb.Logs.logIf(new LogKey(this, "y")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 352 */         new xdb.logs.LogInt(this, MaidInfo.this.y)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 356 */             MaidInfo.this.y = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 360 */     });
/* 361 */     this.y = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 367 */     _xdb_verify_unsafe_();
/* 368 */     MaidInfo _o_ = null;
/* 369 */     if ((_o1_ instanceof MaidInfo)) { _o_ = (MaidInfo)_o1_;
/* 370 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 371 */       return false;
/* 372 */     if (this.maidcfgid != _o_.maidcfgid) return false;
/* 373 */     if (!this.name.equals(_o_.name)) return false;
/* 374 */     if (this.x != _o_.x) return false;
/* 375 */     if (this.y != _o_.y) return false;
/* 376 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 382 */     _xdb_verify_unsafe_();
/* 383 */     int _h_ = 0;
/* 384 */     _h_ += this.maidcfgid;
/* 385 */     _h_ += this.name.hashCode();
/* 386 */     _h_ += this.x;
/* 387 */     _h_ += this.y;
/* 388 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 394 */     _xdb_verify_unsafe_();
/* 395 */     StringBuilder _sb_ = new StringBuilder();
/* 396 */     _sb_.append("(");
/* 397 */     _sb_.append(this.maidcfgid);
/* 398 */     _sb_.append(",");
/* 399 */     _sb_.append("'").append(this.name).append("'");
/* 400 */     _sb_.append(",");
/* 401 */     _sb_.append(this.x);
/* 402 */     _sb_.append(",");
/* 403 */     _sb_.append(this.y);
/* 404 */     _sb_.append(")");
/* 405 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 411 */     ListenableBean lb = new ListenableBean();
/* 412 */     lb.add(new ListenableChanged().setVarName("maidcfgid"));
/* 413 */     lb.add(new ListenableChanged().setVarName("name"));
/* 414 */     lb.add(new ListenableChanged().setVarName("x"));
/* 415 */     lb.add(new ListenableChanged().setVarName("y"));
/* 416 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MaidInfo {
/*     */     private Const() {}
/*     */     
/*     */     MaidInfo nThis() {
/* 423 */       return MaidInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 429 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MaidInfo copy()
/*     */     {
/* 435 */       return MaidInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MaidInfo toData()
/*     */     {
/* 441 */       return MaidInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MaidInfo toBean()
/*     */     {
/* 446 */       return MaidInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MaidInfo toDataIf()
/*     */     {
/* 452 */       return MaidInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MaidInfo toBeanIf()
/*     */     {
/* 457 */       return MaidInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMaidcfgid()
/*     */     {
/* 464 */       MaidInfo.this._xdb_verify_unsafe_();
/* 465 */       return MaidInfo.this.maidcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getName()
/*     */     {
/* 472 */       MaidInfo.this._xdb_verify_unsafe_();
/* 473 */       return MaidInfo.this.name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getNameOctets()
/*     */     {
/* 480 */       MaidInfo.this._xdb_verify_unsafe_();
/* 481 */       return MaidInfo.this.getNameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getX()
/*     */     {
/* 488 */       MaidInfo.this._xdb_verify_unsafe_();
/* 489 */       return MaidInfo.this.x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getY()
/*     */     {
/* 496 */       MaidInfo.this._xdb_verify_unsafe_();
/* 497 */       return MaidInfo.this.y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMaidcfgid(int _v_)
/*     */     {
/* 504 */       MaidInfo.this._xdb_verify_unsafe_();
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setName(String _v_)
/*     */     {
/* 512 */       MaidInfo.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNameOctets(Octets _v_)
/*     */     {
/* 520 */       MaidInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setX(int _v_)
/*     */     {
/* 528 */       MaidInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setY(int _v_)
/*     */     {
/* 536 */       MaidInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 543 */       MaidInfo.this._xdb_verify_unsafe_();
/* 544 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 550 */       MaidInfo.this._xdb_verify_unsafe_();
/* 551 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 557 */       return MaidInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 563 */       return MaidInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 569 */       MaidInfo.this._xdb_verify_unsafe_();
/* 570 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 576 */       return MaidInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 582 */       return MaidInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 588 */       MaidInfo.this._xdb_verify_unsafe_();
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 595 */       return MaidInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 601 */       return MaidInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 607 */       return MaidInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 613 */       return MaidInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 619 */       return MaidInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 625 */       return MaidInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 631 */       return MaidInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MaidInfo
/*     */   {
/*     */     private int maidcfgid;
/*     */     
/*     */     private String name;
/*     */     
/*     */     private int x;
/*     */     
/*     */     private int y;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 654 */       this.name = "";
/*     */     }
/*     */     
/*     */     Data(xbean.MaidInfo _o1_)
/*     */     {
/* 659 */       if ((_o1_ instanceof MaidInfo)) { assign((MaidInfo)_o1_);
/* 660 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 661 */       } else if ((_o1_ instanceof MaidInfo.Const)) assign(((MaidInfo.Const)_o1_).nThis()); else {
/* 662 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MaidInfo _o_) {
/* 667 */       this.maidcfgid = _o_.maidcfgid;
/* 668 */       this.name = _o_.name;
/* 669 */       this.x = _o_.x;
/* 670 */       this.y = _o_.y;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 675 */       this.maidcfgid = _o_.maidcfgid;
/* 676 */       this.name = _o_.name;
/* 677 */       this.x = _o_.x;
/* 678 */       this.y = _o_.y;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.maidcfgid);
/* 685 */       _os_.marshal(this.name, "UTF-16LE");
/* 686 */       _os_.marshal(this.x);
/* 687 */       _os_.marshal(this.y);
/* 688 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 694 */       this.maidcfgid = _os_.unmarshal_int();
/* 695 */       this.name = _os_.unmarshal_String("UTF-16LE");
/* 696 */       this.x = _os_.unmarshal_int();
/* 697 */       this.y = _os_.unmarshal_int();
/* 698 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 704 */       int _size_ = 0;
/* 705 */       _size_ += CodedOutputStream.computeInt32Size(1, this.maidcfgid);
/*     */       try
/*     */       {
/* 708 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.name, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 712 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 714 */       _size_ += CodedOutputStream.computeInt32Size(3, this.x);
/* 715 */       _size_ += CodedOutputStream.computeInt32Size(4, this.y);
/* 716 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 724 */         _output_.writeInt32(1, this.maidcfgid);
/* 725 */         _output_.writeBytes(2, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 726 */         _output_.writeInt32(3, this.x);
/* 727 */         _output_.writeInt32(4, this.y);
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
/* 754 */             this.maidcfgid = _input_.readInt32();
/* 755 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 759 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 760 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 764 */             this.x = _input_.readInt32();
/* 765 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 769 */             this.y = _input_.readInt32();
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
/*     */     public xbean.MaidInfo copy()
/*     */     {
/* 797 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MaidInfo toData()
/*     */     {
/* 803 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MaidInfo toBean()
/*     */     {
/* 808 */       return new MaidInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MaidInfo toDataIf()
/*     */     {
/* 814 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MaidInfo toBeanIf()
/*     */     {
/* 819 */       return new MaidInfo(this, null, null);
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
/*     */     public int getMaidcfgid()
/*     */     {
/* 856 */       return this.maidcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getName()
/*     */     {
/* 863 */       return this.name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getNameOctets()
/*     */     {
/* 870 */       return Octets.wrap(getName(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getX()
/*     */     {
/* 877 */       return this.x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getY()
/*     */     {
/* 884 */       return this.y;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMaidcfgid(int _v_)
/*     */     {
/* 891 */       this.maidcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setName(String _v_)
/*     */     {
/* 898 */       if (null == _v_)
/* 899 */         throw new NullPointerException();
/* 900 */       this.name = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNameOctets(Octets _v_)
/*     */     {
/* 907 */       setName(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setX(int _v_)
/*     */     {
/* 914 */       this.x = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setY(int _v_)
/*     */     {
/* 921 */       this.y = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 927 */       if (!(_o1_ instanceof Data)) return false;
/* 928 */       Data _o_ = (Data)_o1_;
/* 929 */       if (this.maidcfgid != _o_.maidcfgid) return false;
/* 930 */       if (!this.name.equals(_o_.name)) return false;
/* 931 */       if (this.x != _o_.x) return false;
/* 932 */       if (this.y != _o_.y) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.maidcfgid;
/* 941 */       _h_ += this.name.hashCode();
/* 942 */       _h_ += this.x;
/* 943 */       _h_ += this.y;
/* 944 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 950 */       StringBuilder _sb_ = new StringBuilder();
/* 951 */       _sb_.append("(");
/* 952 */       _sb_.append(this.maidcfgid);
/* 953 */       _sb_.append(",");
/* 954 */       _sb_.append("'").append(this.name).append("'");
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append(this.x);
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.y);
/* 959 */       _sb_.append(")");
/* 960 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MaidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */