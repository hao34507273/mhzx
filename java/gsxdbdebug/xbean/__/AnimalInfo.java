/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class AnimalInfo extends XBean implements xbean.AnimalInfo
/*     */ {
/*     */   private int stage;
/*     */   private xbean.EmbryoStageInfo embryo_info;
/*     */   private xbean.AdultStageInfo adult_info;
/*     */   private String name;
/*     */   private long owner;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.stage = 0;
/*  27 */     this.embryo_info._reset_unsafe_();
/*  28 */     this.adult_info._reset_unsafe_();
/*  29 */     this.name = "";
/*  30 */     this.owner = 0L;
/*     */   }
/*     */   
/*     */   AnimalInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.embryo_info = new EmbryoStageInfo(0, this, "embryo_info");
/*  37 */     this.adult_info = new AdultStageInfo(0, this, "adult_info");
/*  38 */     this.name = "";
/*     */   }
/*     */   
/*     */   public AnimalInfo()
/*     */   {
/*  43 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AnimalInfo(AnimalInfo _o_)
/*     */   {
/*  48 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AnimalInfo(xbean.AnimalInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  53 */     super(_xp_, _vn_);
/*  54 */     if ((_o1_ instanceof AnimalInfo)) { assign((AnimalInfo)_o1_);
/*  55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  57 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AnimalInfo _o_) {
/*  62 */     _o_._xdb_verify_unsafe_();
/*  63 */     this.stage = _o_.stage;
/*  64 */     this.embryo_info = new EmbryoStageInfo(_o_.embryo_info, this, "embryo_info");
/*  65 */     this.adult_info = new AdultStageInfo(_o_.adult_info, this, "adult_info");
/*  66 */     this.name = _o_.name;
/*  67 */     this.owner = _o_.owner;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  72 */     this.stage = _o_.stage;
/*  73 */     this.embryo_info = new EmbryoStageInfo(_o_.embryo_info, this, "embryo_info");
/*  74 */     this.adult_info = new AdultStageInfo(_o_.adult_info, this, "adult_info");
/*  75 */     this.name = _o_.name;
/*  76 */     this.owner = _o_.owner;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     _os_.marshal(this.stage);
/*  84 */     this.embryo_info.marshal(_os_);
/*  85 */     this.adult_info.marshal(_os_);
/*  86 */     _os_.marshal(this.name, "UTF-16LE");
/*  87 */     _os_.marshal(this.owner);
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     this.stage = _os_.unmarshal_int();
/*  96 */     this.embryo_info.unmarshal(_os_);
/*  97 */     this.adult_info.unmarshal(_os_);
/*  98 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  99 */     this.owner = _os_.unmarshal_long();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/* 109 */     _size_ += CodedOutputStream.computeMessageSize(2, this.embryo_info);
/* 110 */     _size_ += CodedOutputStream.computeMessageSize(3, this.adult_info);
/*     */     try
/*     */     {
/* 113 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.name, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 117 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 119 */     _size_ += CodedOutputStream.computeInt64Size(5, this.owner);
/* 120 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       _output_.writeInt32(1, this.stage);
/* 130 */       _output_.writeMessage(2, this.embryo_info);
/* 131 */       _output_.writeMessage(3, this.adult_info);
/* 132 */       _output_.writeBytes(4, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 133 */       _output_.writeInt64(5, this.owner);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 137 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 139 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 148 */       boolean done = false;
/* 149 */       while (!done)
/*     */       {
/* 151 */         int tag = _input_.readTag();
/* 152 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 156 */           done = true;
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 161 */           this.stage = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 166 */           _input_.readMessage(this.embryo_info);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 171 */           _input_.readMessage(this.adult_info);
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 34: 
/* 176 */           this.name = _input_.readBytes().toString("UTF-16LE");
/* 177 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 181 */           this.owner = _input_.readInt64();
/* 182 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 186 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 188 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 197 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 201 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 203 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AnimalInfo copy()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new AnimalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AnimalInfo toData()
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AnimalInfo toBean()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return new AnimalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AnimalInfo toDataIf()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AnimalInfo toBeanIf()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStage()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.EmbryoStageInfo getEmbryo_info()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return this.embryo_info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.AdultStageInfo getAdult_info()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return this.adult_info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getNameOctets()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return Octets.wrap(getName(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getOwner()
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     return this.owner;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStage(int _v_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     xdb.Logs.logIf(new LogKey(this, "stage")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 303 */         new xdb.logs.LogInt(this, AnimalInfo.this.stage)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 307 */             AnimalInfo.this.stage = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 311 */     });
/* 312 */     this.stage = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String _v_)
/*     */   {
/* 319 */     _xdb_verify_unsafe_();
/* 320 */     if (null == _v_)
/* 321 */       throw new NullPointerException();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "name")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogString(this, AnimalInfo.this.name)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             AnimalInfo.this.name = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.name = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNameOctets(Octets _v_)
/*     */   {
/* 342 */     _xdb_verify_unsafe_();
/* 343 */     setName(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOwner(long _v_)
/*     */   {
/* 350 */     _xdb_verify_unsafe_();
/* 351 */     xdb.Logs.logIf(new LogKey(this, "owner")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 355 */         new xdb.logs.LogLong(this, AnimalInfo.this.owner)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 359 */             AnimalInfo.this.owner = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 363 */     });
/* 364 */     this.owner = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 370 */     _xdb_verify_unsafe_();
/* 371 */     AnimalInfo _o_ = null;
/* 372 */     if ((_o1_ instanceof AnimalInfo)) { _o_ = (AnimalInfo)_o1_;
/* 373 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 374 */       return false;
/* 375 */     if (this.stage != _o_.stage) return false;
/* 376 */     if (!this.embryo_info.equals(_o_.embryo_info)) return false;
/* 377 */     if (!this.adult_info.equals(_o_.adult_info)) return false;
/* 378 */     if (!this.name.equals(_o_.name)) return false;
/* 379 */     if (this.owner != _o_.owner) return false;
/* 380 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 386 */     _xdb_verify_unsafe_();
/* 387 */     int _h_ = 0;
/* 388 */     _h_ += this.stage;
/* 389 */     _h_ += this.embryo_info.hashCode();
/* 390 */     _h_ += this.adult_info.hashCode();
/* 391 */     _h_ += this.name.hashCode();
/* 392 */     _h_ = (int)(_h_ + this.owner);
/* 393 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 399 */     _xdb_verify_unsafe_();
/* 400 */     StringBuilder _sb_ = new StringBuilder();
/* 401 */     _sb_.append("(");
/* 402 */     _sb_.append(this.stage);
/* 403 */     _sb_.append(",");
/* 404 */     _sb_.append(this.embryo_info);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.adult_info);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append("'").append(this.name).append("'");
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.owner);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new ListenableChanged().setVarName("stage"));
/* 420 */     lb.add(new ListenableChanged().setVarName("embryo_info"));
/* 421 */     lb.add(new ListenableChanged().setVarName("adult_info"));
/* 422 */     lb.add(new ListenableChanged().setVarName("name"));
/* 423 */     lb.add(new ListenableChanged().setVarName("owner"));
/* 424 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AnimalInfo {
/*     */     private Const() {}
/*     */     
/*     */     AnimalInfo nThis() {
/* 431 */       return AnimalInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 437 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AnimalInfo copy()
/*     */     {
/* 443 */       return AnimalInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AnimalInfo toData()
/*     */     {
/* 449 */       return AnimalInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AnimalInfo toBean()
/*     */     {
/* 454 */       return AnimalInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AnimalInfo toDataIf()
/*     */     {
/* 460 */       return AnimalInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AnimalInfo toBeanIf()
/*     */     {
/* 465 */       return AnimalInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 472 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 473 */       return AnimalInfo.this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.EmbryoStageInfo getEmbryo_info()
/*     */     {
/* 480 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 481 */       return (xbean.EmbryoStageInfo)xdb.Consts.toConst(AnimalInfo.this.embryo_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.AdultStageInfo getAdult_info()
/*     */     {
/* 488 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 489 */       return (xbean.AdultStageInfo)xdb.Consts.toConst(AnimalInfo.this.adult_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getName()
/*     */     {
/* 496 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 497 */       return AnimalInfo.this.name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getNameOctets()
/*     */     {
/* 504 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 505 */       return AnimalInfo.this.getNameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOwner()
/*     */     {
/* 512 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 513 */       return AnimalInfo.this.owner;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 520 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setName(String _v_)
/*     */     {
/* 528 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNameOctets(Octets _v_)
/*     */     {
/* 536 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOwner(long _v_)
/*     */     {
/* 544 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 545 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 551 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 552 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 558 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 559 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 565 */       return AnimalInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 571 */       return AnimalInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 577 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 578 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 584 */       return AnimalInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 590 */       return AnimalInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 596 */       AnimalInfo.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 603 */       return AnimalInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 609 */       return AnimalInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 615 */       return AnimalInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 621 */       return AnimalInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 627 */       return AnimalInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 633 */       return AnimalInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 639 */       return AnimalInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AnimalInfo
/*     */   {
/*     */     private int stage;
/*     */     
/*     */     private xbean.EmbryoStageInfo embryo_info;
/*     */     
/*     */     private xbean.AdultStageInfo adult_info;
/*     */     
/*     */     private String name;
/*     */     
/*     */     private long owner;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 659 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 664 */       this.embryo_info = new EmbryoStageInfo.Data();
/* 665 */       this.adult_info = new AdultStageInfo.Data();
/* 666 */       this.name = "";
/*     */     }
/*     */     
/*     */     Data(xbean.AnimalInfo _o1_)
/*     */     {
/* 671 */       if ((_o1_ instanceof AnimalInfo)) { assign((AnimalInfo)_o1_);
/* 672 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 673 */       } else if ((_o1_ instanceof AnimalInfo.Const)) assign(((AnimalInfo.Const)_o1_).nThis()); else {
/* 674 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AnimalInfo _o_) {
/* 679 */       this.stage = _o_.stage;
/* 680 */       this.embryo_info = new EmbryoStageInfo.Data(_o_.embryo_info);
/* 681 */       this.adult_info = new AdultStageInfo.Data(_o_.adult_info);
/* 682 */       this.name = _o_.name;
/* 683 */       this.owner = _o_.owner;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 688 */       this.stage = _o_.stage;
/* 689 */       this.embryo_info = new EmbryoStageInfo.Data(_o_.embryo_info);
/* 690 */       this.adult_info = new AdultStageInfo.Data(_o_.adult_info);
/* 691 */       this.name = _o_.name;
/* 692 */       this.owner = _o_.owner;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 698 */       _os_.marshal(this.stage);
/* 699 */       this.embryo_info.marshal(_os_);
/* 700 */       this.adult_info.marshal(_os_);
/* 701 */       _os_.marshal(this.name, "UTF-16LE");
/* 702 */       _os_.marshal(this.owner);
/* 703 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 709 */       this.stage = _os_.unmarshal_int();
/* 710 */       this.embryo_info.unmarshal(_os_);
/* 711 */       this.adult_info.unmarshal(_os_);
/* 712 */       this.name = _os_.unmarshal_String("UTF-16LE");
/* 713 */       this.owner = _os_.unmarshal_long();
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 720 */       int _size_ = 0;
/* 721 */       _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/* 722 */       _size_ += CodedOutputStream.computeMessageSize(2, this.embryo_info);
/* 723 */       _size_ += CodedOutputStream.computeMessageSize(3, this.adult_info);
/*     */       try
/*     */       {
/* 726 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.name, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 730 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 732 */       _size_ += CodedOutputStream.computeInt64Size(5, this.owner);
/* 733 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 741 */         _output_.writeInt32(1, this.stage);
/* 742 */         _output_.writeMessage(2, this.embryo_info);
/* 743 */         _output_.writeMessage(3, this.adult_info);
/* 744 */         _output_.writeBytes(4, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 745 */         _output_.writeInt64(5, this.owner);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             this.stage = _input_.readInt32();
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 777 */             _input_.readMessage(this.embryo_info);
/* 778 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 782 */             _input_.readMessage(this.adult_info);
/* 783 */             break;
/*     */           
/*     */ 
/*     */           case 34: 
/* 787 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 788 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 792 */             this.owner = _input_.readInt64();
/* 793 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 797 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 799 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 808 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 812 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 814 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AnimalInfo copy()
/*     */     {
/* 820 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AnimalInfo toData()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AnimalInfo toBean()
/*     */     {
/* 831 */       return new AnimalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AnimalInfo toDataIf()
/*     */     {
/* 837 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AnimalInfo toBeanIf()
/*     */     {
/* 842 */       return new AnimalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 848 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 868 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 872 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 879 */       return this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.EmbryoStageInfo getEmbryo_info()
/*     */     {
/* 886 */       return this.embryo_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.AdultStageInfo getAdult_info()
/*     */     {
/* 893 */       return this.adult_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getName()
/*     */     {
/* 900 */       return this.name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getNameOctets()
/*     */     {
/* 907 */       return Octets.wrap(getName(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOwner()
/*     */     {
/* 914 */       return this.owner;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 921 */       this.stage = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setName(String _v_)
/*     */     {
/* 928 */       if (null == _v_)
/* 929 */         throw new NullPointerException();
/* 930 */       this.name = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNameOctets(Octets _v_)
/*     */     {
/* 937 */       setName(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOwner(long _v_)
/*     */     {
/* 944 */       this.owner = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 950 */       if (!(_o1_ instanceof Data)) return false;
/* 951 */       Data _o_ = (Data)_o1_;
/* 952 */       if (this.stage != _o_.stage) return false;
/* 953 */       if (!this.embryo_info.equals(_o_.embryo_info)) return false;
/* 954 */       if (!this.adult_info.equals(_o_.adult_info)) return false;
/* 955 */       if (!this.name.equals(_o_.name)) return false;
/* 956 */       if (this.owner != _o_.owner) return false;
/* 957 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 963 */       int _h_ = 0;
/* 964 */       _h_ += this.stage;
/* 965 */       _h_ += this.embryo_info.hashCode();
/* 966 */       _h_ += this.adult_info.hashCode();
/* 967 */       _h_ += this.name.hashCode();
/* 968 */       _h_ = (int)(_h_ + this.owner);
/* 969 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 975 */       StringBuilder _sb_ = new StringBuilder();
/* 976 */       _sb_.append("(");
/* 977 */       _sb_.append(this.stage);
/* 978 */       _sb_.append(",");
/* 979 */       _sb_.append(this.embryo_info);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.adult_info);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append("'").append(this.name).append("'");
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.owner);
/* 986 */       _sb_.append(")");
/* 987 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AnimalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */