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
/*     */ public final class RoleFlowerParadeRecord extends XBean implements xbean.RoleFlowerParadeRecord
/*     */ {
/*     */   private int followawardcount;
/*     */   private int danceawardcount;
/*     */   private int redbagawardcount;
/*     */   private xbean.DanceAwardInfo predanceawardinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.followawardcount = 0;
/*  25 */     this.danceawardcount = 0;
/*  26 */     this.redbagawardcount = 0;
/*  27 */     this.predanceawardinfo._reset_unsafe_();
/*     */   }
/*     */   
/*     */   RoleFlowerParadeRecord(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.followawardcount = 0;
/*  34 */     this.danceawardcount = 0;
/*  35 */     this.redbagawardcount = 0;
/*  36 */     this.predanceawardinfo = new DanceAwardInfo(0, this, "predanceawardinfo");
/*     */   }
/*     */   
/*     */   public RoleFlowerParadeRecord()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleFlowerParadeRecord(RoleFlowerParadeRecord _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleFlowerParadeRecord(xbean.RoleFlowerParadeRecord _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof RoleFlowerParadeRecord)) { assign((RoleFlowerParadeRecord)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleFlowerParadeRecord _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.followawardcount = _o_.followawardcount;
/*  62 */     this.danceawardcount = _o_.danceawardcount;
/*  63 */     this.redbagawardcount = _o_.redbagawardcount;
/*  64 */     this.predanceawardinfo = new DanceAwardInfo(_o_.predanceawardinfo, this, "predanceawardinfo");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.followawardcount = _o_.followawardcount;
/*  70 */     this.danceawardcount = _o_.danceawardcount;
/*  71 */     this.redbagawardcount = _o_.redbagawardcount;
/*  72 */     this.predanceawardinfo = new DanceAwardInfo(_o_.predanceawardinfo, this, "predanceawardinfo");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.followawardcount);
/*  80 */     _os_.marshal(this.danceawardcount);
/*  81 */     _os_.marshal(this.redbagawardcount);
/*  82 */     this.predanceawardinfo.marshal(_os_);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.followawardcount = _os_.unmarshal_int();
/*  91 */     this.danceawardcount = _os_.unmarshal_int();
/*  92 */     this.redbagawardcount = _os_.unmarshal_int();
/*  93 */     this.predanceawardinfo.unmarshal(_os_);
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     int _size_ = 0;
/* 102 */     _size_ += CodedOutputStream.computeInt32Size(1, this.followawardcount);
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(2, this.danceawardcount);
/* 104 */     _size_ += CodedOutputStream.computeInt32Size(3, this.redbagawardcount);
/* 105 */     _size_ += CodedOutputStream.computeMessageSize(4, this.predanceawardinfo);
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       _output_.writeInt32(1, this.followawardcount);
/* 116 */       _output_.writeInt32(2, this.danceawardcount);
/* 117 */       _output_.writeInt32(3, this.redbagawardcount);
/* 118 */       _output_.writeMessage(4, this.predanceawardinfo);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 122 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 124 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       boolean done = false;
/* 134 */       while (!done)
/*     */       {
/* 136 */         int tag = _input_.readTag();
/* 137 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 141 */           done = true;
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 146 */           this.followawardcount = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.danceawardcount = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.redbagawardcount = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 34: 
/* 161 */           _input_.readMessage(this.predanceawardinfo);
/* 162 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 166 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 168 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 177 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 183 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFlowerParadeRecord copy()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return new RoleFlowerParadeRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFlowerParadeRecord toData()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFlowerParadeRecord toBean()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new RoleFlowerParadeRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFlowerParadeRecord toDataIf()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFlowerParadeRecord toBeanIf()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFollowawardcount()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.followawardcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDanceawardcount()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.danceawardcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRedbagawardcount()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.redbagawardcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.DanceAwardInfo getPredanceawardinfo()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.predanceawardinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFollowawardcount(int _v_)
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     xdb.Logs.logIf(new LogKey(this, "followawardcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 267 */         new LogInt(this, RoleFlowerParadeRecord.this.followawardcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 271 */             RoleFlowerParadeRecord.this.followawardcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 275 */     });
/* 276 */     this.followawardcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDanceawardcount(int _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "danceawardcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 288 */         new LogInt(this, RoleFlowerParadeRecord.this.danceawardcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             RoleFlowerParadeRecord.this.danceawardcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.danceawardcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRedbagawardcount(int _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "redbagawardcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 309 */         new LogInt(this, RoleFlowerParadeRecord.this.redbagawardcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             RoleFlowerParadeRecord.this.redbagawardcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.redbagawardcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     RoleFlowerParadeRecord _o_ = null;
/* 326 */     if ((_o1_ instanceof RoleFlowerParadeRecord)) { _o_ = (RoleFlowerParadeRecord)_o1_;
/* 327 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 328 */       return false;
/* 329 */     if (this.followawardcount != _o_.followawardcount) return false;
/* 330 */     if (this.danceawardcount != _o_.danceawardcount) return false;
/* 331 */     if (this.redbagawardcount != _o_.redbagawardcount) return false;
/* 332 */     if (!this.predanceawardinfo.equals(_o_.predanceawardinfo)) return false;
/* 333 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 339 */     _xdb_verify_unsafe_();
/* 340 */     int _h_ = 0;
/* 341 */     _h_ += this.followawardcount;
/* 342 */     _h_ += this.danceawardcount;
/* 343 */     _h_ += this.redbagawardcount;
/* 344 */     _h_ += this.predanceawardinfo.hashCode();
/* 345 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     StringBuilder _sb_ = new StringBuilder();
/* 353 */     _sb_.append("(");
/* 354 */     _sb_.append(this.followawardcount);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append(this.danceawardcount);
/* 357 */     _sb_.append(",");
/* 358 */     _sb_.append(this.redbagawardcount);
/* 359 */     _sb_.append(",");
/* 360 */     _sb_.append(this.predanceawardinfo);
/* 361 */     _sb_.append(")");
/* 362 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 368 */     ListenableBean lb = new ListenableBean();
/* 369 */     lb.add(new ListenableChanged().setVarName("followawardcount"));
/* 370 */     lb.add(new ListenableChanged().setVarName("danceawardcount"));
/* 371 */     lb.add(new ListenableChanged().setVarName("redbagawardcount"));
/* 372 */     lb.add(new ListenableChanged().setVarName("predanceawardinfo"));
/* 373 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleFlowerParadeRecord {
/*     */     private Const() {}
/*     */     
/*     */     RoleFlowerParadeRecord nThis() {
/* 380 */       return RoleFlowerParadeRecord.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 386 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFlowerParadeRecord copy()
/*     */     {
/* 392 */       return RoleFlowerParadeRecord.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFlowerParadeRecord toData()
/*     */     {
/* 398 */       return RoleFlowerParadeRecord.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleFlowerParadeRecord toBean()
/*     */     {
/* 403 */       return RoleFlowerParadeRecord.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFlowerParadeRecord toDataIf()
/*     */     {
/* 409 */       return RoleFlowerParadeRecord.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleFlowerParadeRecord toBeanIf()
/*     */     {
/* 414 */       return RoleFlowerParadeRecord.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFollowawardcount()
/*     */     {
/* 421 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 422 */       return RoleFlowerParadeRecord.this.followawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDanceawardcount()
/*     */     {
/* 429 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 430 */       return RoleFlowerParadeRecord.this.danceawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRedbagawardcount()
/*     */     {
/* 437 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 438 */       return RoleFlowerParadeRecord.this.redbagawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.DanceAwardInfo getPredanceawardinfo()
/*     */     {
/* 445 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 446 */       return (xbean.DanceAwardInfo)xdb.Consts.toConst(RoleFlowerParadeRecord.this.predanceawardinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFollowawardcount(int _v_)
/*     */     {
/* 453 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 454 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDanceawardcount(int _v_)
/*     */     {
/* 461 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 462 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRedbagawardcount(int _v_)
/*     */     {
/* 469 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 476 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 477 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 483 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 484 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 490 */       return RoleFlowerParadeRecord.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 496 */       return RoleFlowerParadeRecord.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 502 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 509 */       return RoleFlowerParadeRecord.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 515 */       return RoleFlowerParadeRecord.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 521 */       RoleFlowerParadeRecord.this._xdb_verify_unsafe_();
/* 522 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 528 */       return RoleFlowerParadeRecord.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 534 */       return RoleFlowerParadeRecord.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 540 */       return RoleFlowerParadeRecord.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 546 */       return RoleFlowerParadeRecord.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 552 */       return RoleFlowerParadeRecord.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 558 */       return RoleFlowerParadeRecord.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 564 */       return RoleFlowerParadeRecord.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleFlowerParadeRecord
/*     */   {
/*     */     private int followawardcount;
/*     */     
/*     */     private int danceawardcount;
/*     */     
/*     */     private int redbagawardcount;
/*     */     
/*     */     private xbean.DanceAwardInfo predanceawardinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 582 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 587 */       this.followawardcount = 0;
/* 588 */       this.danceawardcount = 0;
/* 589 */       this.redbagawardcount = 0;
/* 590 */       this.predanceawardinfo = new DanceAwardInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleFlowerParadeRecord _o1_)
/*     */     {
/* 595 */       if ((_o1_ instanceof RoleFlowerParadeRecord)) { assign((RoleFlowerParadeRecord)_o1_);
/* 596 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 597 */       } else if ((_o1_ instanceof RoleFlowerParadeRecord.Const)) assign(((RoleFlowerParadeRecord.Const)_o1_).nThis()); else {
/* 598 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleFlowerParadeRecord _o_) {
/* 603 */       this.followawardcount = _o_.followawardcount;
/* 604 */       this.danceawardcount = _o_.danceawardcount;
/* 605 */       this.redbagawardcount = _o_.redbagawardcount;
/* 606 */       this.predanceawardinfo = new DanceAwardInfo.Data(_o_.predanceawardinfo);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 611 */       this.followawardcount = _o_.followawardcount;
/* 612 */       this.danceawardcount = _o_.danceawardcount;
/* 613 */       this.redbagawardcount = _o_.redbagawardcount;
/* 614 */       this.predanceawardinfo = new DanceAwardInfo.Data(_o_.predanceawardinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 620 */       _os_.marshal(this.followawardcount);
/* 621 */       _os_.marshal(this.danceawardcount);
/* 622 */       _os_.marshal(this.redbagawardcount);
/* 623 */       this.predanceawardinfo.marshal(_os_);
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this.followawardcount = _os_.unmarshal_int();
/* 631 */       this.danceawardcount = _os_.unmarshal_int();
/* 632 */       this.redbagawardcount = _os_.unmarshal_int();
/* 633 */       this.predanceawardinfo.unmarshal(_os_);
/* 634 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 640 */       int _size_ = 0;
/* 641 */       _size_ += CodedOutputStream.computeInt32Size(1, this.followawardcount);
/* 642 */       _size_ += CodedOutputStream.computeInt32Size(2, this.danceawardcount);
/* 643 */       _size_ += CodedOutputStream.computeInt32Size(3, this.redbagawardcount);
/* 644 */       _size_ += CodedOutputStream.computeMessageSize(4, this.predanceawardinfo);
/* 645 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 653 */         _output_.writeInt32(1, this.followawardcount);
/* 654 */         _output_.writeInt32(2, this.danceawardcount);
/* 655 */         _output_.writeInt32(3, this.redbagawardcount);
/* 656 */         _output_.writeMessage(4, this.predanceawardinfo);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 660 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 662 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 670 */         boolean done = false;
/* 671 */         while (!done)
/*     */         {
/* 673 */           int tag = _input_.readTag();
/* 674 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 678 */             done = true;
/* 679 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 683 */             this.followawardcount = _input_.readInt32();
/* 684 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 688 */             this.danceawardcount = _input_.readInt32();
/* 689 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 693 */             this.redbagawardcount = _input_.readInt32();
/* 694 */             break;
/*     */           
/*     */ 
/*     */           case 34: 
/* 698 */             _input_.readMessage(this.predanceawardinfo);
/* 699 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 703 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 705 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 714 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 718 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 720 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFlowerParadeRecord copy()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFlowerParadeRecord toData()
/*     */     {
/* 732 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleFlowerParadeRecord toBean()
/*     */     {
/* 737 */       return new RoleFlowerParadeRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFlowerParadeRecord toDataIf()
/*     */     {
/* 743 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleFlowerParadeRecord toBeanIf()
/*     */     {
/* 748 */       return new RoleFlowerParadeRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 754 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 758 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 762 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 766 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 770 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 774 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 778 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFollowawardcount()
/*     */     {
/* 785 */       return this.followawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDanceawardcount()
/*     */     {
/* 792 */       return this.danceawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRedbagawardcount()
/*     */     {
/* 799 */       return this.redbagawardcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.DanceAwardInfo getPredanceawardinfo()
/*     */     {
/* 806 */       return this.predanceawardinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFollowawardcount(int _v_)
/*     */     {
/* 813 */       this.followawardcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDanceawardcount(int _v_)
/*     */     {
/* 820 */       this.danceawardcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRedbagawardcount(int _v_)
/*     */     {
/* 827 */       this.redbagawardcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 833 */       if (!(_o1_ instanceof Data)) return false;
/* 834 */       Data _o_ = (Data)_o1_;
/* 835 */       if (this.followawardcount != _o_.followawardcount) return false;
/* 836 */       if (this.danceawardcount != _o_.danceawardcount) return false;
/* 837 */       if (this.redbagawardcount != _o_.redbagawardcount) return false;
/* 838 */       if (!this.predanceawardinfo.equals(_o_.predanceawardinfo)) return false;
/* 839 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 845 */       int _h_ = 0;
/* 846 */       _h_ += this.followawardcount;
/* 847 */       _h_ += this.danceawardcount;
/* 848 */       _h_ += this.redbagawardcount;
/* 849 */       _h_ += this.predanceawardinfo.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.followawardcount);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.danceawardcount);
/* 861 */       _sb_.append(",");
/* 862 */       _sb_.append(this.redbagawardcount);
/* 863 */       _sb_.append(",");
/* 864 */       _sb_.append(this.predanceawardinfo);
/* 865 */       _sb_.append(")");
/* 866 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleFlowerParadeRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */