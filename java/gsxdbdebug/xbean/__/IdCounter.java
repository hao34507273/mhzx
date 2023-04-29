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
/*     */ public final class IdCounter extends XBean implements xbean.IdCounter
/*     */ {
/*     */   private int dropcount;
/*     */   private int unhitcount;
/*     */   private int historydropcount;
/*     */   private long modifytime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.dropcount = 0;
/*  25 */     this.unhitcount = 0;
/*  26 */     this.historydropcount = 0;
/*  27 */     this.modifytime = 0L;
/*     */   }
/*     */   
/*     */   IdCounter(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public IdCounter()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public IdCounter(IdCounter _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   IdCounter(xbean.IdCounter _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof IdCounter)) { assign((IdCounter)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(IdCounter _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.dropcount = _o_.dropcount;
/*  58 */     this.unhitcount = _o_.unhitcount;
/*  59 */     this.historydropcount = _o_.historydropcount;
/*  60 */     this.modifytime = _o_.modifytime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.dropcount = _o_.dropcount;
/*  66 */     this.unhitcount = _o_.unhitcount;
/*  67 */     this.historydropcount = _o_.historydropcount;
/*  68 */     this.modifytime = _o_.modifytime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.dropcount);
/*  76 */     _os_.marshal(this.unhitcount);
/*  77 */     _os_.marshal(this.historydropcount);
/*  78 */     _os_.marshal(this.modifytime);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.dropcount = _os_.unmarshal_int();
/*  87 */     this.unhitcount = _os_.unmarshal_int();
/*  88 */     this.historydropcount = _os_.unmarshal_int();
/*  89 */     this.modifytime = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.dropcount);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.unhitcount);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.historydropcount);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.modifytime);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.dropcount);
/* 112 */       _output_.writeInt32(2, this.unhitcount);
/* 113 */       _output_.writeInt32(3, this.historydropcount);
/* 114 */       _output_.writeInt64(4, this.modifytime);
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
/* 142 */           this.dropcount = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.unhitcount = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.historydropcount = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.modifytime = _input_.readInt64();
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
/*     */   public xbean.IdCounter copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new IdCounter(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IdCounter toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IdCounter toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new IdCounter(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IdCounter toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IdCounter toBeanIf()
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
/*     */   public int getDropcount()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.dropcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUnhitcount()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.unhitcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHistorydropcount()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.historydropcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getModifytime()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.modifytime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDropcount(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "dropcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, IdCounter.this.dropcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             IdCounter.this.dropcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.dropcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnhitcount(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "unhitcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, IdCounter.this.unhitcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             IdCounter.this.unhitcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.unhitcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHistorydropcount(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "historydropcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogInt(this, IdCounter.this.historydropcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             IdCounter.this.historydropcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.historydropcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setModifytime(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "modifytime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, IdCounter.this.modifytime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             IdCounter.this.modifytime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.modifytime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     IdCounter _o_ = null;
/* 343 */     if ((_o1_ instanceof IdCounter)) { _o_ = (IdCounter)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.dropcount != _o_.dropcount) return false;
/* 347 */     if (this.unhitcount != _o_.unhitcount) return false;
/* 348 */     if (this.historydropcount != _o_.historydropcount) return false;
/* 349 */     if (this.modifytime != _o_.modifytime) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.dropcount;
/* 359 */     _h_ += this.unhitcount;
/* 360 */     _h_ += this.historydropcount;
/* 361 */     _h_ = (int)(_h_ + this.modifytime);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.dropcount);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.unhitcount);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.historydropcount);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.modifytime);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("dropcount"));
/* 387 */     lb.add(new ListenableChanged().setVarName("unhitcount"));
/* 388 */     lb.add(new ListenableChanged().setVarName("historydropcount"));
/* 389 */     lb.add(new ListenableChanged().setVarName("modifytime"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.IdCounter {
/*     */     private Const() {}
/*     */     
/*     */     IdCounter nThis() {
/* 397 */       return IdCounter.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdCounter copy()
/*     */     {
/* 409 */       return IdCounter.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdCounter toData()
/*     */     {
/* 415 */       return IdCounter.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.IdCounter toBean()
/*     */     {
/* 420 */       return IdCounter.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdCounter toDataIf()
/*     */     {
/* 426 */       return IdCounter.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.IdCounter toBeanIf()
/*     */     {
/* 431 */       return IdCounter.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDropcount()
/*     */     {
/* 438 */       IdCounter.this._xdb_verify_unsafe_();
/* 439 */       return IdCounter.this.dropcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUnhitcount()
/*     */     {
/* 446 */       IdCounter.this._xdb_verify_unsafe_();
/* 447 */       return IdCounter.this.unhitcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHistorydropcount()
/*     */     {
/* 454 */       IdCounter.this._xdb_verify_unsafe_();
/* 455 */       return IdCounter.this.historydropcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getModifytime()
/*     */     {
/* 462 */       IdCounter.this._xdb_verify_unsafe_();
/* 463 */       return IdCounter.this.modifytime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDropcount(int _v_)
/*     */     {
/* 470 */       IdCounter.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUnhitcount(int _v_)
/*     */     {
/* 478 */       IdCounter.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHistorydropcount(int _v_)
/*     */     {
/* 486 */       IdCounter.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModifytime(long _v_)
/*     */     {
/* 494 */       IdCounter.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       IdCounter.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       IdCounter.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return IdCounter.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return IdCounter.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       IdCounter.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return IdCounter.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return IdCounter.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       IdCounter.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return IdCounter.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return IdCounter.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return IdCounter.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return IdCounter.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return IdCounter.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return IdCounter.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return IdCounter.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.IdCounter
/*     */   {
/*     */     private int dropcount;
/*     */     
/*     */     private int unhitcount;
/*     */     
/*     */     private int historydropcount;
/*     */     
/*     */     private long modifytime;
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
/*     */     Data(xbean.IdCounter _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof IdCounter)) { assign((IdCounter)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof IdCounter.Const)) assign(((IdCounter.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(IdCounter _o_) {
/* 624 */       this.dropcount = _o_.dropcount;
/* 625 */       this.unhitcount = _o_.unhitcount;
/* 626 */       this.historydropcount = _o_.historydropcount;
/* 627 */       this.modifytime = _o_.modifytime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.dropcount = _o_.dropcount;
/* 633 */       this.unhitcount = _o_.unhitcount;
/* 634 */       this.historydropcount = _o_.historydropcount;
/* 635 */       this.modifytime = _o_.modifytime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.dropcount);
/* 642 */       _os_.marshal(this.unhitcount);
/* 643 */       _os_.marshal(this.historydropcount);
/* 644 */       _os_.marshal(this.modifytime);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.dropcount = _os_.unmarshal_int();
/* 652 */       this.unhitcount = _os_.unmarshal_int();
/* 653 */       this.historydropcount = _os_.unmarshal_int();
/* 654 */       this.modifytime = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.dropcount);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.unhitcount);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.historydropcount);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.modifytime);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.dropcount);
/* 675 */         _output_.writeInt32(2, this.unhitcount);
/* 676 */         _output_.writeInt32(3, this.historydropcount);
/* 677 */         _output_.writeInt64(4, this.modifytime);
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
/* 704 */             this.dropcount = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.unhitcount = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.historydropcount = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.modifytime = _input_.readInt64();
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
/*     */     public xbean.IdCounter copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdCounter toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.IdCounter toBean()
/*     */     {
/* 758 */       return new IdCounter(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IdCounter toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.IdCounter toBeanIf()
/*     */     {
/* 769 */       return new IdCounter(this, null, null);
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
/*     */     public int getDropcount()
/*     */     {
/* 806 */       return this.dropcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUnhitcount()
/*     */     {
/* 813 */       return this.unhitcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHistorydropcount()
/*     */     {
/* 820 */       return this.historydropcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getModifytime()
/*     */     {
/* 827 */       return this.modifytime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDropcount(int _v_)
/*     */     {
/* 834 */       this.dropcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUnhitcount(int _v_)
/*     */     {
/* 841 */       this.unhitcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHistorydropcount(int _v_)
/*     */     {
/* 848 */       this.historydropcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModifytime(long _v_)
/*     */     {
/* 855 */       this.modifytime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.dropcount != _o_.dropcount) return false;
/* 864 */       if (this.unhitcount != _o_.unhitcount) return false;
/* 865 */       if (this.historydropcount != _o_.historydropcount) return false;
/* 866 */       if (this.modifytime != _o_.modifytime) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.dropcount;
/* 875 */       _h_ += this.unhitcount;
/* 876 */       _h_ += this.historydropcount;
/* 877 */       _h_ = (int)(_h_ + this.modifytime);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.dropcount);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.unhitcount);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.historydropcount);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.modifytime);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IdCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */