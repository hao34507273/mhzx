/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class StorageExp extends XBean implements xbean.StorageExp
/*     */ {
/*     */   private long storageexp;
/*     */   private long needupdatestorageexp;
/*     */   private long lastupdate;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.storageexp = 0L;
/*  23 */     this.needupdatestorageexp = 0L;
/*  24 */     this.lastupdate = 0L;
/*     */   }
/*     */   
/*     */   StorageExp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.storageexp = 0L;
/*  31 */     this.needupdatestorageexp = 0L;
/*  32 */     this.lastupdate = 0L;
/*     */   }
/*     */   
/*     */   public StorageExp()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public StorageExp(StorageExp _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   StorageExp(xbean.StorageExp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof StorageExp)) { assign((StorageExp)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(StorageExp _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.storageexp = _o_.storageexp;
/*  58 */     this.needupdatestorageexp = _o_.needupdatestorageexp;
/*  59 */     this.lastupdate = _o_.lastupdate;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.storageexp = _o_.storageexp;
/*  65 */     this.needupdatestorageexp = _o_.needupdatestorageexp;
/*  66 */     this.lastupdate = _o_.lastupdate;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.storageexp);
/*  74 */     _os_.marshal(this.needupdatestorageexp);
/*  75 */     _os_.marshal(this.lastupdate);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.storageexp = _os_.unmarshal_long();
/*  84 */     this.needupdatestorageexp = _os_.unmarshal_long();
/*  85 */     this.lastupdate = _os_.unmarshal_long();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt64Size(1, this.storageexp);
/*  95 */     _size_ += CodedOutputStream.computeInt64Size(2, this.needupdatestorageexp);
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(3, this.lastupdate);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt64(1, this.storageexp);
/* 107 */       _output_.writeInt64(2, this.needupdatestorageexp);
/* 108 */       _output_.writeInt64(3, this.lastupdate);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 112 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 114 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       boolean done = false;
/* 124 */       while (!done)
/*     */       {
/* 126 */         int tag = _input_.readTag();
/* 127 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 131 */           done = true;
/* 132 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 136 */           this.storageexp = _input_.readInt64();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.needupdatestorageexp = _input_.readInt64();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.lastupdate = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 151 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 153 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 162 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 166 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 168 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.StorageExp copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new StorageExp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.StorageExp toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.StorageExp toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new StorageExp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.StorageExp toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.StorageExp toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStorageexp()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.storageexp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getNeedupdatestorageexp()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.needupdatestorageexp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLastupdate()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.lastupdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStorageexp(long _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "storageexp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogLong(this, StorageExp.this.storageexp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             StorageExp.this.storageexp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.storageexp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNeedupdatestorageexp(long _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "needupdatestorageexp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogLong(this, StorageExp.this.needupdatestorageexp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             StorageExp.this.needupdatestorageexp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.needupdatestorageexp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastupdate(long _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "lastupdate")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogLong(this, StorageExp.this.lastupdate)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             StorageExp.this.lastupdate = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.lastupdate = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     StorageExp _o_ = null;
/* 303 */     if ((_o1_ instanceof StorageExp)) { _o_ = (StorageExp)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.storageexp != _o_.storageexp) return false;
/* 307 */     if (this.needupdatestorageexp != _o_.needupdatestorageexp) return false;
/* 308 */     if (this.lastupdate != _o_.lastupdate) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ = (int)(_h_ + this.storageexp);
/* 318 */     _h_ = (int)(_h_ + this.needupdatestorageexp);
/* 319 */     _h_ = (int)(_h_ + this.lastupdate);
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.storageexp);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.needupdatestorageexp);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.lastupdate);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("storageexp"));
/* 343 */     lb.add(new ListenableChanged().setVarName("needupdatestorageexp"));
/* 344 */     lb.add(new ListenableChanged().setVarName("lastupdate"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.StorageExp {
/*     */     private Const() {}
/*     */     
/*     */     StorageExp nThis() {
/* 352 */       return StorageExp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StorageExp copy()
/*     */     {
/* 364 */       return StorageExp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StorageExp toData()
/*     */     {
/* 370 */       return StorageExp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.StorageExp toBean()
/*     */     {
/* 375 */       return StorageExp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StorageExp toDataIf()
/*     */     {
/* 381 */       return StorageExp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.StorageExp toBeanIf()
/*     */     {
/* 386 */       return StorageExp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStorageexp()
/*     */     {
/* 393 */       StorageExp.this._xdb_verify_unsafe_();
/* 394 */       return StorageExp.this.storageexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getNeedupdatestorageexp()
/*     */     {
/* 401 */       StorageExp.this._xdb_verify_unsafe_();
/* 402 */       return StorageExp.this.needupdatestorageexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastupdate()
/*     */     {
/* 409 */       StorageExp.this._xdb_verify_unsafe_();
/* 410 */       return StorageExp.this.lastupdate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStorageexp(long _v_)
/*     */     {
/* 417 */       StorageExp.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNeedupdatestorageexp(long _v_)
/*     */     {
/* 425 */       StorageExp.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastupdate(long _v_)
/*     */     {
/* 433 */       StorageExp.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       StorageExp.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       StorageExp.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return StorageExp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return StorageExp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       StorageExp.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return StorageExp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return StorageExp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       StorageExp.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return StorageExp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return StorageExp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return StorageExp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return StorageExp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return StorageExp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return StorageExp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return StorageExp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.StorageExp
/*     */   {
/*     */     private long storageexp;
/*     */     
/*     */     private long needupdatestorageexp;
/*     */     
/*     */     private long lastupdate;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.storageexp = 0L;
/* 550 */       this.needupdatestorageexp = 0L;
/* 551 */       this.lastupdate = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.StorageExp _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof StorageExp)) { assign((StorageExp)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof StorageExp.Const)) assign(((StorageExp.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(StorageExp _o_) {
/* 564 */       this.storageexp = _o_.storageexp;
/* 565 */       this.needupdatestorageexp = _o_.needupdatestorageexp;
/* 566 */       this.lastupdate = _o_.lastupdate;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.storageexp = _o_.storageexp;
/* 572 */       this.needupdatestorageexp = _o_.needupdatestorageexp;
/* 573 */       this.lastupdate = _o_.lastupdate;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.storageexp);
/* 580 */       _os_.marshal(this.needupdatestorageexp);
/* 581 */       _os_.marshal(this.lastupdate);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.storageexp = _os_.unmarshal_long();
/* 589 */       this.needupdatestorageexp = _os_.unmarshal_long();
/* 590 */       this.lastupdate = _os_.unmarshal_long();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt64Size(1, this.storageexp);
/* 599 */       _size_ += CodedOutputStream.computeInt64Size(2, this.needupdatestorageexp);
/* 600 */       _size_ += CodedOutputStream.computeInt64Size(3, this.lastupdate);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt64(1, this.storageexp);
/* 610 */         _output_.writeInt64(2, this.needupdatestorageexp);
/* 611 */         _output_.writeInt64(3, this.lastupdate);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 615 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 617 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 625 */         boolean done = false;
/* 626 */         while (!done)
/*     */         {
/* 628 */           int tag = _input_.readTag();
/* 629 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 633 */             done = true;
/* 634 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 638 */             this.storageexp = _input_.readInt64();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.needupdatestorageexp = _input_.readInt64();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.lastupdate = _input_.readInt64();
/* 649 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 653 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 655 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 664 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StorageExp copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StorageExp toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.StorageExp toBean()
/*     */     {
/* 687 */       return new StorageExp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.StorageExp toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.StorageExp toBeanIf()
/*     */     {
/* 698 */       return new StorageExp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 720 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStorageexp()
/*     */     {
/* 735 */       return this.storageexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getNeedupdatestorageexp()
/*     */     {
/* 742 */       return this.needupdatestorageexp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastupdate()
/*     */     {
/* 749 */       return this.lastupdate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStorageexp(long _v_)
/*     */     {
/* 756 */       this.storageexp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNeedupdatestorageexp(long _v_)
/*     */     {
/* 763 */       this.needupdatestorageexp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastupdate(long _v_)
/*     */     {
/* 770 */       this.lastupdate = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.storageexp != _o_.storageexp) return false;
/* 779 */       if (this.needupdatestorageexp != _o_.needupdatestorageexp) return false;
/* 780 */       if (this.lastupdate != _o_.lastupdate) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ = (int)(_h_ + this.storageexp);
/* 789 */       _h_ = (int)(_h_ + this.needupdatestorageexp);
/* 790 */       _h_ = (int)(_h_ + this.lastupdate);
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.storageexp);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.needupdatestorageexp);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.lastupdate);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\StorageExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */