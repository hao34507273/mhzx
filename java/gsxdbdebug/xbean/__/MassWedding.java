/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class MassWedding extends XBean implements xbean.MassWedding
/*     */ {
/*     */   private long worldid;
/*     */   private int endearlier;
/*     */   private int stage;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.worldid = 0L;
/*  23 */     this.endearlier = 0;
/*  24 */     this.stage = -1;
/*     */   }
/*     */   
/*     */   MassWedding(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.stage = -1;
/*     */   }
/*     */   
/*     */   public MassWedding()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MassWedding(MassWedding _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MassWedding(xbean.MassWedding _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof MassWedding)) { assign((MassWedding)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MassWedding _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.worldid = _o_.worldid;
/*  56 */     this.endearlier = _o_.endearlier;
/*  57 */     this.stage = _o_.stage;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.worldid = _o_.worldid;
/*  63 */     this.endearlier = _o_.endearlier;
/*  64 */     this.stage = _o_.stage;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.worldid);
/*  72 */     _os_.marshal(this.endearlier);
/*  73 */     _os_.marshal(this.stage);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.worldid = _os_.unmarshal_long();
/*  82 */     this.endearlier = _os_.unmarshal_int();
/*  83 */     this.stage = _os_.unmarshal_int();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.endearlier);
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(3, this.stage);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt64(1, this.worldid);
/* 105 */       _output_.writeInt32(2, this.endearlier);
/* 106 */       _output_.writeInt32(3, this.stage);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.worldid = _input_.readInt64();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.endearlier = _input_.readInt32();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.stage = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWedding copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new MassWedding(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWedding toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWedding toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new MassWedding(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWedding toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWedding toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getWorldid()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.worldid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEndearlier()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.endearlier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStage()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorldid(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "worldid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogLong(this, MassWedding.this.worldid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             MassWedding.this.worldid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.worldid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEndearlier(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "endearlier")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, MassWedding.this.endearlier)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             MassWedding.this.endearlier = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.endearlier = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStage(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "stage")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new xdb.logs.LogInt(this, MassWedding.this.stage)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             MassWedding.this.stage = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.stage = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     MassWedding _o_ = null;
/* 301 */     if ((_o1_ instanceof MassWedding)) { _o_ = (MassWedding)_o1_;
/* 302 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 303 */       return false;
/* 304 */     if (this.worldid != _o_.worldid) return false;
/* 305 */     if (this.endearlier != _o_.endearlier) return false;
/* 306 */     if (this.stage != _o_.stage) return false;
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     int _h_ = 0;
/* 315 */     _h_ = (int)(_h_ + this.worldid);
/* 316 */     _h_ += this.endearlier;
/* 317 */     _h_ += this.stage;
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.worldid);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.endearlier);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.stage);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("worldid"));
/* 341 */     lb.add(new ListenableChanged().setVarName("endearlier"));
/* 342 */     lb.add(new ListenableChanged().setVarName("stage"));
/* 343 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MassWedding {
/*     */     private Const() {}
/*     */     
/*     */     MassWedding nThis() {
/* 350 */       return MassWedding.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWedding copy()
/*     */     {
/* 362 */       return MassWedding.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWedding toData()
/*     */     {
/* 368 */       return MassWedding.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MassWedding toBean()
/*     */     {
/* 373 */       return MassWedding.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWedding toDataIf()
/*     */     {
/* 379 */       return MassWedding.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MassWedding toBeanIf()
/*     */     {
/* 384 */       return MassWedding.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorldid()
/*     */     {
/* 391 */       MassWedding.this._xdb_verify_unsafe_();
/* 392 */       return MassWedding.this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEndearlier()
/*     */     {
/* 399 */       MassWedding.this._xdb_verify_unsafe_();
/* 400 */       return MassWedding.this.endearlier;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 407 */       MassWedding.this._xdb_verify_unsafe_();
/* 408 */       return MassWedding.this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 415 */       MassWedding.this._xdb_verify_unsafe_();
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndearlier(int _v_)
/*     */     {
/* 423 */       MassWedding.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 431 */       MassWedding.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 438 */       MassWedding.this._xdb_verify_unsafe_();
/* 439 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 445 */       MassWedding.this._xdb_verify_unsafe_();
/* 446 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 452 */       return MassWedding.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 458 */       return MassWedding.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       MassWedding.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 471 */       return MassWedding.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 477 */       return MassWedding.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 483 */       MassWedding.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 490 */       return MassWedding.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 496 */       return MassWedding.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 502 */       return MassWedding.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 508 */       return MassWedding.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 514 */       return MassWedding.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 520 */       return MassWedding.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 526 */       return MassWedding.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MassWedding
/*     */   {
/*     */     private long worldid;
/*     */     
/*     */     private int endearlier;
/*     */     
/*     */     private int stage;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 547 */       this.stage = -1;
/*     */     }
/*     */     
/*     */     Data(xbean.MassWedding _o1_)
/*     */     {
/* 552 */       if ((_o1_ instanceof MassWedding)) { assign((MassWedding)_o1_);
/* 553 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 554 */       } else if ((_o1_ instanceof MassWedding.Const)) assign(((MassWedding.Const)_o1_).nThis()); else {
/* 555 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MassWedding _o_) {
/* 560 */       this.worldid = _o_.worldid;
/* 561 */       this.endearlier = _o_.endearlier;
/* 562 */       this.stage = _o_.stage;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 567 */       this.worldid = _o_.worldid;
/* 568 */       this.endearlier = _o_.endearlier;
/* 569 */       this.stage = _o_.stage;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 575 */       _os_.marshal(this.worldid);
/* 576 */       _os_.marshal(this.endearlier);
/* 577 */       _os_.marshal(this.stage);
/* 578 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 584 */       this.worldid = _os_.unmarshal_long();
/* 585 */       this.endearlier = _os_.unmarshal_int();
/* 586 */       this.stage = _os_.unmarshal_int();
/* 587 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 593 */       int _size_ = 0;
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/* 595 */       _size_ += CodedOutputStream.computeInt32Size(2, this.endearlier);
/* 596 */       _size_ += CodedOutputStream.computeInt32Size(3, this.stage);
/* 597 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 605 */         _output_.writeInt64(1, this.worldid);
/* 606 */         _output_.writeInt32(2, this.endearlier);
/* 607 */         _output_.writeInt32(3, this.stage);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 634 */             this.worldid = _input_.readInt64();
/* 635 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 639 */             this.endearlier = _input_.readInt32();
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.stage = _input_.readInt32();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWedding copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWedding toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MassWedding toBean()
/*     */     {
/* 683 */       return new MassWedding(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWedding toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MassWedding toBeanIf()
/*     */     {
/* 694 */       return new MassWedding(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorldid()
/*     */     {
/* 731 */       return this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEndearlier()
/*     */     {
/* 738 */       return this.endearlier;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 745 */       return this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 752 */       this.worldid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndearlier(int _v_)
/*     */     {
/* 759 */       this.endearlier = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 766 */       this.stage = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 772 */       if (!(_o1_ instanceof Data)) return false;
/* 773 */       Data _o_ = (Data)_o1_;
/* 774 */       if (this.worldid != _o_.worldid) return false;
/* 775 */       if (this.endearlier != _o_.endearlier) return false;
/* 776 */       if (this.stage != _o_.stage) return false;
/* 777 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 783 */       int _h_ = 0;
/* 784 */       _h_ = (int)(_h_ + this.worldid);
/* 785 */       _h_ += this.endearlier;
/* 786 */       _h_ += this.stage;
/* 787 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 793 */       StringBuilder _sb_ = new StringBuilder();
/* 794 */       _sb_.append("(");
/* 795 */       _sb_.append(this.worldid);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.endearlier);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.stage);
/* 800 */       _sb_.append(")");
/* 801 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassWedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */