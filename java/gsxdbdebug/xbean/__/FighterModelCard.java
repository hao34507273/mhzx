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
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class FighterModelCard extends XBean implements xbean.FighterModelCard
/*     */ {
/*     */   private int initclassindex;
/*     */   private int initlevel;
/*     */   private int tmpclassindex;
/*     */   private int tmplevel;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.initclassindex = 0;
/*  25 */     this.initlevel = 0;
/*  26 */     this.tmpclassindex = -1;
/*  27 */     this.tmplevel = 0;
/*     */   }
/*     */   
/*     */   FighterModelCard(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.initclassindex = 0;
/*  34 */     this.tmpclassindex = -1;
/*     */   }
/*     */   
/*     */   public FighterModelCard()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FighterModelCard(FighterModelCard _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FighterModelCard(xbean.FighterModelCard _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof FighterModelCard)) { assign((FighterModelCard)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FighterModelCard _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.initclassindex = _o_.initclassindex;
/*  60 */     this.initlevel = _o_.initlevel;
/*  61 */     this.tmpclassindex = _o_.tmpclassindex;
/*  62 */     this.tmplevel = _o_.tmplevel;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.initclassindex = _o_.initclassindex;
/*  68 */     this.initlevel = _o_.initlevel;
/*  69 */     this.tmpclassindex = _o_.tmpclassindex;
/*  70 */     this.tmplevel = _o_.tmplevel;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.initclassindex);
/*  78 */     _os_.marshal(this.initlevel);
/*  79 */     _os_.marshal(this.tmpclassindex);
/*  80 */     _os_.marshal(this.tmplevel);
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     this.initclassindex = _os_.unmarshal_int();
/*  89 */     this.initlevel = _os_.unmarshal_int();
/*  90 */     this.tmpclassindex = _os_.unmarshal_int();
/*  91 */     this.tmplevel = _os_.unmarshal_int();
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     int _size_ = 0;
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(1, this.initclassindex);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(2, this.initlevel);
/* 102 */     _size_ += CodedOutputStream.computeInt32Size(3, this.tmpclassindex);
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(4, this.tmplevel);
/* 104 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       _output_.writeInt32(1, this.initclassindex);
/* 114 */       _output_.writeInt32(2, this.initlevel);
/* 115 */       _output_.writeInt32(3, this.tmpclassindex);
/* 116 */       _output_.writeInt32(4, this.tmplevel);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 144 */           this.initclassindex = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 149 */           this.initlevel = _input_.readInt32();
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 154 */           this.tmpclassindex = _input_.readInt32();
/* 155 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 159 */           this.tmplevel = _input_.readInt32();
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
/*     */   public xbean.FighterModelCard copy()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new FighterModelCard(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterModelCard toData()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterModelCard toBean()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new FighterModelCard(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FighterModelCard toDataIf()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FighterModelCard toBeanIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getInitclassindex()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.initclassindex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getInitlevel()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.initlevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTmpclassindex()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.tmpclassindex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTmplevel()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this.tmplevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInitclassindex(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "initclassindex")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogInt(this, FighterModelCard.this.initclassindex)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             FighterModelCard.this.initclassindex = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.initclassindex = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInitlevel(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "initlevel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogInt(this, FighterModelCard.this.initlevel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             FighterModelCard.this.initlevel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.initlevel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTmpclassindex(int _v_)
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     xdb.Logs.logIf(new LogKey(this, "tmpclassindex")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 307 */         new LogInt(this, FighterModelCard.this.tmpclassindex)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 311 */             FighterModelCard.this.tmpclassindex = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 315 */     });
/* 316 */     this.tmpclassindex = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTmplevel(int _v_)
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     xdb.Logs.logIf(new LogKey(this, "tmplevel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 328 */         new LogInt(this, FighterModelCard.this.tmplevel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 332 */             FighterModelCard.this.tmplevel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 336 */     });
/* 337 */     this.tmplevel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     FighterModelCard _o_ = null;
/* 345 */     if ((_o1_ instanceof FighterModelCard)) { _o_ = (FighterModelCard)_o1_;
/* 346 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 347 */       return false;
/* 348 */     if (this.initclassindex != _o_.initclassindex) return false;
/* 349 */     if (this.initlevel != _o_.initlevel) return false;
/* 350 */     if (this.tmpclassindex != _o_.tmpclassindex) return false;
/* 351 */     if (this.tmplevel != _o_.tmplevel) return false;
/* 352 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     int _h_ = 0;
/* 360 */     _h_ += this.initclassindex;
/* 361 */     _h_ += this.initlevel;
/* 362 */     _h_ += this.tmpclassindex;
/* 363 */     _h_ += this.tmplevel;
/* 364 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 370 */     _xdb_verify_unsafe_();
/* 371 */     StringBuilder _sb_ = new StringBuilder();
/* 372 */     _sb_.append("(");
/* 373 */     _sb_.append(this.initclassindex);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.initlevel);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.tmpclassindex);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.tmplevel);
/* 380 */     _sb_.append(")");
/* 381 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 387 */     ListenableBean lb = new ListenableBean();
/* 388 */     lb.add(new ListenableChanged().setVarName("initclassindex"));
/* 389 */     lb.add(new ListenableChanged().setVarName("initlevel"));
/* 390 */     lb.add(new ListenableChanged().setVarName("tmpclassindex"));
/* 391 */     lb.add(new ListenableChanged().setVarName("tmplevel"));
/* 392 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FighterModelCard {
/*     */     private Const() {}
/*     */     
/*     */     FighterModelCard nThis() {
/* 399 */       return FighterModelCard.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterModelCard copy()
/*     */     {
/* 411 */       return FighterModelCard.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterModelCard toData()
/*     */     {
/* 417 */       return FighterModelCard.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FighterModelCard toBean()
/*     */     {
/* 422 */       return FighterModelCard.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterModelCard toDataIf()
/*     */     {
/* 428 */       return FighterModelCard.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FighterModelCard toBeanIf()
/*     */     {
/* 433 */       return FighterModelCard.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getInitclassindex()
/*     */     {
/* 440 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 441 */       return FighterModelCard.this.initclassindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getInitlevel()
/*     */     {
/* 448 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 449 */       return FighterModelCard.this.initlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTmpclassindex()
/*     */     {
/* 456 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 457 */       return FighterModelCard.this.tmpclassindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTmplevel()
/*     */     {
/* 464 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 465 */       return FighterModelCard.this.tmplevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInitclassindex(int _v_)
/*     */     {
/* 472 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInitlevel(int _v_)
/*     */     {
/* 480 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 481 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTmpclassindex(int _v_)
/*     */     {
/* 488 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTmplevel(int _v_)
/*     */     {
/* 496 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 497 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 503 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 504 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 510 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 511 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 517 */       return FighterModelCard.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       return FighterModelCard.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 529 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 530 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 536 */       return FighterModelCard.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 542 */       return FighterModelCard.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 548 */       FighterModelCard.this._xdb_verify_unsafe_();
/* 549 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 555 */       return FighterModelCard.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 561 */       return FighterModelCard.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 567 */       return FighterModelCard.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 573 */       return FighterModelCard.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 579 */       return FighterModelCard.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 585 */       return FighterModelCard.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 591 */       return FighterModelCard.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FighterModelCard
/*     */   {
/*     */     private int initclassindex;
/*     */     
/*     */     private int initlevel;
/*     */     
/*     */     private int tmpclassindex;
/*     */     
/*     */     private int tmplevel;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 609 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 614 */       this.initclassindex = 0;
/* 615 */       this.tmpclassindex = -1;
/*     */     }
/*     */     
/*     */     Data(xbean.FighterModelCard _o1_)
/*     */     {
/* 620 */       if ((_o1_ instanceof FighterModelCard)) { assign((FighterModelCard)_o1_);
/* 621 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 622 */       } else if ((_o1_ instanceof FighterModelCard.Const)) assign(((FighterModelCard.Const)_o1_).nThis()); else {
/* 623 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FighterModelCard _o_) {
/* 628 */       this.initclassindex = _o_.initclassindex;
/* 629 */       this.initlevel = _o_.initlevel;
/* 630 */       this.tmpclassindex = _o_.tmpclassindex;
/* 631 */       this.tmplevel = _o_.tmplevel;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 636 */       this.initclassindex = _o_.initclassindex;
/* 637 */       this.initlevel = _o_.initlevel;
/* 638 */       this.tmpclassindex = _o_.tmpclassindex;
/* 639 */       this.tmplevel = _o_.tmplevel;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 645 */       _os_.marshal(this.initclassindex);
/* 646 */       _os_.marshal(this.initlevel);
/* 647 */       _os_.marshal(this.tmpclassindex);
/* 648 */       _os_.marshal(this.tmplevel);
/* 649 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 655 */       this.initclassindex = _os_.unmarshal_int();
/* 656 */       this.initlevel = _os_.unmarshal_int();
/* 657 */       this.tmpclassindex = _os_.unmarshal_int();
/* 658 */       this.tmplevel = _os_.unmarshal_int();
/* 659 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 665 */       int _size_ = 0;
/* 666 */       _size_ += CodedOutputStream.computeInt32Size(1, this.initclassindex);
/* 667 */       _size_ += CodedOutputStream.computeInt32Size(2, this.initlevel);
/* 668 */       _size_ += CodedOutputStream.computeInt32Size(3, this.tmpclassindex);
/* 669 */       _size_ += CodedOutputStream.computeInt32Size(4, this.tmplevel);
/* 670 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 678 */         _output_.writeInt32(1, this.initclassindex);
/* 679 */         _output_.writeInt32(2, this.initlevel);
/* 680 */         _output_.writeInt32(3, this.tmpclassindex);
/* 681 */         _output_.writeInt32(4, this.tmplevel);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 685 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 687 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 695 */         boolean done = false;
/* 696 */         while (!done)
/*     */         {
/* 698 */           int tag = _input_.readTag();
/* 699 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 703 */             done = true;
/* 704 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 708 */             this.initclassindex = _input_.readInt32();
/* 709 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 713 */             this.initlevel = _input_.readInt32();
/* 714 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 718 */             this.tmpclassindex = _input_.readInt32();
/* 719 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 723 */             this.tmplevel = _input_.readInt32();
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterModelCard copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterModelCard toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FighterModelCard toBean()
/*     */     {
/* 762 */       return new FighterModelCard(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FighterModelCard toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FighterModelCard toBeanIf()
/*     */     {
/* 773 */       return new FighterModelCard(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getInitclassindex()
/*     */     {
/* 810 */       return this.initclassindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getInitlevel()
/*     */     {
/* 817 */       return this.initlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTmpclassindex()
/*     */     {
/* 824 */       return this.tmpclassindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTmplevel()
/*     */     {
/* 831 */       return this.tmplevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInitclassindex(int _v_)
/*     */     {
/* 838 */       this.initclassindex = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInitlevel(int _v_)
/*     */     {
/* 845 */       this.initlevel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTmpclassindex(int _v_)
/*     */     {
/* 852 */       this.tmpclassindex = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTmplevel(int _v_)
/*     */     {
/* 859 */       this.tmplevel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 865 */       if (!(_o1_ instanceof Data)) return false;
/* 866 */       Data _o_ = (Data)_o1_;
/* 867 */       if (this.initclassindex != _o_.initclassindex) return false;
/* 868 */       if (this.initlevel != _o_.initlevel) return false;
/* 869 */       if (this.tmpclassindex != _o_.tmpclassindex) return false;
/* 870 */       if (this.tmplevel != _o_.tmplevel) return false;
/* 871 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 877 */       int _h_ = 0;
/* 878 */       _h_ += this.initclassindex;
/* 879 */       _h_ += this.initlevel;
/* 880 */       _h_ += this.tmpclassindex;
/* 881 */       _h_ += this.tmplevel;
/* 882 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 888 */       StringBuilder _sb_ = new StringBuilder();
/* 889 */       _sb_.append("(");
/* 890 */       _sb_.append(this.initclassindex);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.initlevel);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.tmpclassindex);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.tmplevel);
/* 897 */       _sb_.append(")");
/* 898 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FighterModelCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */