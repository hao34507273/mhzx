/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ObserveFight extends XBean implements xbean.ObserveFight
/*     */ {
/*     */   private long fightid;
/*     */   private int observetype;
/*     */   private long observevalue;
/*     */   private int observeteamtype;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.fightid = 0L;
/*  25 */     this.observetype = 0;
/*  26 */     this.observevalue = 0L;
/*  27 */     this.observeteamtype = 0;
/*     */   }
/*     */   
/*     */   ObserveFight(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ObserveFight()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ObserveFight(ObserveFight _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ObserveFight(xbean.ObserveFight _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof ObserveFight)) { assign((ObserveFight)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ObserveFight _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.fightid = _o_.fightid;
/*  58 */     this.observetype = _o_.observetype;
/*  59 */     this.observevalue = _o_.observevalue;
/*  60 */     this.observeteamtype = _o_.observeteamtype;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.fightid = _o_.fightid;
/*  66 */     this.observetype = _o_.observetype;
/*  67 */     this.observevalue = _o_.observevalue;
/*  68 */     this.observeteamtype = _o_.observeteamtype;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.fightid);
/*  76 */     _os_.marshal(this.observetype);
/*  77 */     _os_.marshal(this.observevalue);
/*  78 */     _os_.marshal(this.observeteamtype);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.fightid = _os_.unmarshal_long();
/*  87 */     this.observetype = _os_.unmarshal_int();
/*  88 */     this.observevalue = _os_.unmarshal_long();
/*  89 */     this.observeteamtype = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.fightid);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.observetype);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(3, this.observevalue);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.observeteamtype);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.fightid);
/* 112 */       _output_.writeInt32(2, this.observetype);
/* 113 */       _output_.writeInt64(3, this.observevalue);
/* 114 */       _output_.writeInt32(4, this.observeteamtype);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.fightid = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.observetype = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.observevalue = _input_.readInt64();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.observeteamtype = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ObserveFight copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new ObserveFight(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ObserveFight toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ObserveFight toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new ObserveFight(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ObserveFight toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ObserveFight toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFightid()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.fightid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getObservetype()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.observetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getObservevalue()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.observevalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getObserveteamtype()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.observeteamtype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFightid(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "fightid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogLong(this, ObserveFight.this.fightid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             ObserveFight.this.fightid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.fightid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObservetype(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "observetype")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogInt(this, ObserveFight.this.observetype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             ObserveFight.this.observetype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.observetype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObservevalue(long _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "observevalue")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogLong(this, ObserveFight.this.observevalue)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             ObserveFight.this.observevalue = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.observevalue = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObserveteamtype(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "observeteamtype")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, ObserveFight.this.observeteamtype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             ObserveFight.this.observeteamtype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.observeteamtype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     ObserveFight _o_ = null;
/* 343 */     if ((_o1_ instanceof ObserveFight)) { _o_ = (ObserveFight)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.fightid != _o_.fightid) return false;
/* 347 */     if (this.observetype != _o_.observetype) return false;
/* 348 */     if (this.observevalue != _o_.observevalue) return false;
/* 349 */     if (this.observeteamtype != _o_.observeteamtype) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.fightid);
/* 359 */     _h_ += this.observetype;
/* 360 */     _h_ = (int)(_h_ + this.observevalue);
/* 361 */     _h_ += this.observeteamtype;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.fightid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.observetype);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.observevalue);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.observeteamtype);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("fightid"));
/* 387 */     lb.add(new ListenableChanged().setVarName("observetype"));
/* 388 */     lb.add(new ListenableChanged().setVarName("observevalue"));
/* 389 */     lb.add(new ListenableChanged().setVarName("observeteamtype"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ObserveFight {
/*     */     private Const() {}
/*     */     
/*     */     ObserveFight nThis() {
/* 397 */       return ObserveFight.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ObserveFight copy()
/*     */     {
/* 409 */       return ObserveFight.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ObserveFight toData()
/*     */     {
/* 415 */       return ObserveFight.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ObserveFight toBean()
/*     */     {
/* 420 */       return ObserveFight.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ObserveFight toDataIf()
/*     */     {
/* 426 */       return ObserveFight.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ObserveFight toBeanIf()
/*     */     {
/* 431 */       return ObserveFight.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFightid()
/*     */     {
/* 438 */       ObserveFight.this._xdb_verify_unsafe_();
/* 439 */       return ObserveFight.this.fightid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getObservetype()
/*     */     {
/* 446 */       ObserveFight.this._xdb_verify_unsafe_();
/* 447 */       return ObserveFight.this.observetype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getObservevalue()
/*     */     {
/* 454 */       ObserveFight.this._xdb_verify_unsafe_();
/* 455 */       return ObserveFight.this.observevalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getObserveteamtype()
/*     */     {
/* 462 */       ObserveFight.this._xdb_verify_unsafe_();
/* 463 */       return ObserveFight.this.observeteamtype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightid(long _v_)
/*     */     {
/* 470 */       ObserveFight.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObservetype(int _v_)
/*     */     {
/* 478 */       ObserveFight.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObservevalue(long _v_)
/*     */     {
/* 486 */       ObserveFight.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObserveteamtype(int _v_)
/*     */     {
/* 494 */       ObserveFight.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       ObserveFight.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       ObserveFight.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return ObserveFight.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return ObserveFight.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       ObserveFight.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return ObserveFight.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return ObserveFight.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       ObserveFight.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return ObserveFight.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return ObserveFight.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return ObserveFight.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return ObserveFight.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return ObserveFight.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return ObserveFight.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return ObserveFight.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ObserveFight
/*     */   {
/*     */     private long fightid;
/*     */     
/*     */     private int observetype;
/*     */     
/*     */     private long observevalue;
/*     */     
/*     */     private int observeteamtype;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.ObserveFight _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof ObserveFight)) { assign((ObserveFight)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof ObserveFight.Const)) assign(((ObserveFight.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ObserveFight _o_) {
/* 624 */       this.fightid = _o_.fightid;
/* 625 */       this.observetype = _o_.observetype;
/* 626 */       this.observevalue = _o_.observevalue;
/* 627 */       this.observeteamtype = _o_.observeteamtype;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.fightid = _o_.fightid;
/* 633 */       this.observetype = _o_.observetype;
/* 634 */       this.observevalue = _o_.observevalue;
/* 635 */       this.observeteamtype = _o_.observeteamtype;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.fightid);
/* 642 */       _os_.marshal(this.observetype);
/* 643 */       _os_.marshal(this.observevalue);
/* 644 */       _os_.marshal(this.observeteamtype);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.fightid = _os_.unmarshal_long();
/* 652 */       this.observetype = _os_.unmarshal_int();
/* 653 */       this.observevalue = _os_.unmarshal_long();
/* 654 */       this.observeteamtype = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.fightid);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.observetype);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.observevalue);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.observeteamtype);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.fightid);
/* 675 */         _output_.writeInt32(2, this.observetype);
/* 676 */         _output_.writeInt64(3, this.observevalue);
/* 677 */         _output_.writeInt32(4, this.observeteamtype);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.fightid = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.observetype = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.observevalue = _input_.readInt64();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.observeteamtype = _input_.readInt32();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ObserveFight copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ObserveFight toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ObserveFight toBean()
/*     */     {
/* 758 */       return new ObserveFight(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ObserveFight toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ObserveFight toBeanIf()
/*     */     {
/* 769 */       return new ObserveFight(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFightid()
/*     */     {
/* 806 */       return this.fightid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getObservetype()
/*     */     {
/* 813 */       return this.observetype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getObservevalue()
/*     */     {
/* 820 */       return this.observevalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getObserveteamtype()
/*     */     {
/* 827 */       return this.observeteamtype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightid(long _v_)
/*     */     {
/* 834 */       this.fightid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObservetype(int _v_)
/*     */     {
/* 841 */       this.observetype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObservevalue(long _v_)
/*     */     {
/* 848 */       this.observevalue = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObserveteamtype(int _v_)
/*     */     {
/* 855 */       this.observeteamtype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.fightid != _o_.fightid) return false;
/* 864 */       if (this.observetype != _o_.observetype) return false;
/* 865 */       if (this.observevalue != _o_.observevalue) return false;
/* 866 */       if (this.observeteamtype != _o_.observeteamtype) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.fightid);
/* 875 */       _h_ += this.observetype;
/* 876 */       _h_ = (int)(_h_ + this.observevalue);
/* 877 */       _h_ += this.observeteamtype;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.fightid);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.observetype);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.observevalue);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.observeteamtype);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ObserveFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */